package bmo5.bmo5tests.tests.adm;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.subnational.EntityMaintenanceSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Subnational.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_074_2_Adm_Subnational_CreateEntity.csv", separator=',')

public class Bmo5_074_2_Adm_Subnational_CreateEntity {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps admLoginSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	
	@Steps
	public EntityMaintenanceSteps entitySteps;
	
	String username, password,country,entityCode,entityName,entityLevel,entityType,parent,cmsShowState,
	webShowState,wrongEntityLevel,negativeNumber,realNumber,zero,wrongEntityCode,entityMaintenanceBreadcrumb,addEntityBreadcrumb;
	String specialCharacters="äöüßúůýžáčďéěíňóřšť";
	
	public void setEntityCode(String entityCode){
		this.entityCode=entityCode+Integer.toString(StringUtils.randomNumber(50000));
	}
	
	public void setWrongEntityCode(String entityCode){
		this.wrongEntityCode=entityCode+Integer.toString(StringUtils.randomNumber(10000000))+Integer.toString(StringUtils.randomNumber(50000));
	}
	
	public void setEntityName(String entityName){
		this.entityName=entityName+Integer.toString(StringUtils.randomNumber(50000));
	}
	
	@Test
	public void bmo5_074_2_Adm_Subnational_CreateEntity(){
		setEntityCode(entityCode);
		setWrongEntityCode(entityCode);
		setEntityName(entityName);
		admLoginSteps.performLogin(username, password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.National);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.EntityMaintenance);
		menuNavigationSteps.verifyBreadCrumb(entityMaintenanceBreadcrumb);
		entitySteps.clickOnNewButton();
		menuNavigationSteps.verifyBreadCrumb(addEntityBreadcrumb);
		entitySteps.verifySaveButtonDisabledAndElementsDisplayed();
		entitySteps.clickOnContinueButtonAndVerifyErrorMessage();
		String countryISO=entitySteps.selectCountry(country);
		entitySteps.clickOnResetAndVerifySelectedOption();
		entitySteps.selectCountry(country);
		entitySteps.clickOnContinueButton();
		menuNavigationSteps.verifyBreadCrumb(addEntityBreadcrumb);
		entitySteps.verifySaveButtonEnabledAndElementsDisplayed();
		entitySteps.clickOnSaveWithoutCompletingAndVerifyErrorMessages();
		entitySteps.typeInvalidData(wrongEntityLevel, negativeNumber, realNumber,wrongEntityCode);
		String parentCode=entitySteps.typeValidData(entityCode, entityName, entityLevel, entityType, cmsShowState, webShowState, parent);
	    entitySteps.verifySaveButtonIsEnabled();
	    entitySteps.clickOnSaveButton();
	    entitySteps.verifySuccessfullySavedMessage();
	    entitySteps.clickListViewButton();
	    entitySteps.clickOnNewButton();
	    entitySteps.verifySaveButtonDisabledAndElementsDisplayed();
		entitySteps.selectCountry(country);
		entitySteps.clickOnContinueButton();
		entitySteps.verifySaveButtonEnabledAndElementsDisplayed();
	    entitySteps.typeValidData(entityCode, entityName, entityLevel, entityType, cmsShowState, webShowState, parent);
		entitySteps.verifySaveButtonIsEnabled();
	    entitySteps.clickOnSaveButton();	
	    entitySteps.verifyAlreadyExistsError();
	    entitySteps.clickListViewButton();
	    entitySteps.typeSearchItemAndClickSearch("", entityName);
	    entitySteps.verifyDataOnEntityTablePage(entityCode, entityLevel, entityName, countryISO, cmsShowState, webShowState, parentCode);
	}
}
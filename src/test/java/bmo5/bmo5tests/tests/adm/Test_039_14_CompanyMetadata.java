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

import bmo5.bmo5tests.adm.steps.CompanyMetadataSteps;
import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.widgets.HotTopicsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.CompanyMetadata.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Test_039_14_CompanyMetadata.csv", separator=',')

public class Test_039_14_CompanyMetadata {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps admLoginSteps;
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	@Steps
	public HotTopicsSteps hotTopicsSteps;
	@Steps 
	public MenuNavigationSteps menuNavigationSteps;
	@Steps
	public CompanyMetadataSteps companyMetadataSteps;
	
	public String username, password, companyName, state, nationality, service, newCompanyName, pageTitle, updatedCompanyName, updatedstate, updatednationality, updatedservice, 
	newUpdatedCompanyName;

	@Test
	public void adm_039_11_Articles_Management(){
		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.CompanyMetadata);
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
		companyMetadataSteps.clickOnNewButtonAndVerify();
		companyMetadataSteps.clickOnSaveWithoutCompletingTheFormAndVerify();
		companyMetadataSteps.clickOnResetButton();
		companyMetadataSteps.completeTheFormWithoutNationalitySaveAndVerify(companyName, state, service);
		companyMetadataSteps.clickOnResetButton();
		newCompanyName = companyMetadataSteps.completeTheFormWithDataAndSave(companyName, state, nationality, service);
		companyMetadataSteps.verifyPageTitle("Search for Companies");
		companyMetadataSteps.selectOneCompany(newCompanyName);
		companyMetadataSteps.verifyCompanyData(newCompanyName, state, nationality, service);
		companyMetadataSteps.clickOnNewButtonAndVerify();
		companyMetadataSteps.completeCompanyNameWithAnExistingOneSaveAndVerify(newCompanyName, state, nationality, service);
		
		menuNavigationSteps.selectMenuItem(AdmMenuItems.CompanyMetadata);
		companyMetadataSteps.selectOneCompany(newCompanyName);
		newUpdatedCompanyName = companyMetadataSteps.editCompanyWithNewData(updatedCompanyName, updatedstate, updatednationality, updatedservice);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.CompanyMetadata);
		companyMetadataSteps.selectOneCompany(newUpdatedCompanyName);
		companyMetadataSteps.verifyCompanyData(newUpdatedCompanyName, updatedstate, updatednationality, updatedservice);
		companyMetadataSteps.selectOneServiceToExportData(updatedservice);
		companyMetadataSteps.clickOnExportCompaniesForSelectedSector();
		
		menuNavigationSteps.selectMenuItem(AdmMenuItems.CompanyMetadata);
		companyMetadataSteps.selectOneCompany(newUpdatedCompanyName);
		companyMetadataSteps.deleteCompanyAndVerify(newUpdatedCompanyName);
	}
}

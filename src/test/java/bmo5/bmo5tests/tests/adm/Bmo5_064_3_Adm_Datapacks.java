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
import bmo5.bmo5tests.adm.steps.dvpacks.DatapackSteps;
import bmo5.bmo5tests.adm.steps.subnational.EntityMaintenanceSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.DvPacks.Datapacks.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_064_3_Datapacks.csv", separator=',')

public class Bmo5_064_3_Adm_Datapacks {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps	
	public LoginSteps admLoginSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public DatapackSteps datapackSteps;
	
	@Steps
	public EntityMaintenanceSteps entitySteps;
	
	public String admUsername, admPassword,datapackType,excelName,dvpackId,geographyTaggingOption,
	serviceTaggingOption,companyTaggingOption,dataPackTitle,wrongDvpackId;
	byte exists,doesnExist;
	
	@Test
	public void bmo5_064_3_Adm_Datapacks(){
		admLoginSteps.performLogin(admUsername, admPassword);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DataPacks);
		datapackSteps.clickAddNewDatapackButton();
		datapackSteps.verifyElementsDisplayed();
		String savedDatapackTitle=datapackSteps.typeDatapackTitle(dataPackTitle);
		datapackSteps.selectDataPackType(datapackType);
		if (datapackType.equals("upload_excel")) {
			datapackSteps.uploadExcel(excelName);
		}

		if (datapackType.equals("dvpack")) {
			datapackSteps.typeDvpackID(dvpackId);
		}
		datapackSteps.selectPrimaryTaggingOptions(geographyTaggingOption,serviceTaggingOption, companyTaggingOption);
		datapackSteps.clickContinueButton();
		datapackSteps.verifySuccessMessage();
		datapackSteps.verifySuccessfullySavedMessage();
		datapackSteps.verifySelectedTagging(serviceTaggingOption, geographyTaggingOption, companyTaggingOption);
		datapackSteps.verifySelectedDatapackType(datapackType);
		datapackSteps.verifyTitleAndDvpackId(savedDatapackTitle, dvpackId);
		datapackSteps.clickAddNewDatapackButton();
		datapackSteps.typeDatapackTitle(dataPackTitle);
		datapackSteps.selectDataPackType(datapackType);
		datapackSteps.selectPrimaryTaggingOptions(geographyTaggingOption,serviceTaggingOption, companyTaggingOption);
		datapackSteps.typeDvpackIdAndVerifyErrorMessage(wrongDvpackId);
		entitySteps.clickOnResetButtonEditPage();
		datapackSteps.verifyElementsDisplayed();
		datapackSteps.clickContinueWithoutCompletingAndVerifyErrorMessage();
		datapackSteps.verifyElementsDisplayed();//this will fail BMONG-2418
		entitySteps.clickOnResetButtonEditPage();
		datapackSteps.verifyErrorMessagesExistOrDoesntExists(doesnExist);
		datapackSteps.verifyElementsDisplayed();
	}
}

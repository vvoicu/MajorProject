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
import bmo5.bmo5tests.adm.steps.dvpacks.ADM_DvPacks_GenerateDVPack_GeneralSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.ADM_DvPacks_Listing_GeneralSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Adm_DvPacks_CreateDvPack_GeneralSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Adm_Dvpacks_PreviewAndAprove_GeneralSteps;
import bmo5.bmo5tests.adm.steps.widgets.KeyGlobalForecastsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Widgets.BusinessRulesWidgets.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_045_Adm_Widgets_Key_Global_Forecasts.csv", separator=',')
public class Bmo5_045_Adm_Widgets_Key_Global_Forecasts {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public KeyGlobalForecastsSteps kgfSteps;
	
	@Steps
	public Adm_DvPacks_CreateDvPack_GeneralSteps adm_DvPacks_CreateDvPack_GeneralSteps;
	
	@Steps 
	public ADM_DvPacks_Listing_GeneralSteps adm_DvPacks_Listing_GeneralSteps;
	
	@Steps
	public ADM_DvPacks_GenerateDVPack_GeneralSteps adm_DvPacks_GenerateDVPack_GeneralSteps;
	
	@Steps
	public Adm_Dvpacks_PreviewAndAprove_GeneralSteps adm_Dvpacks_PreviewAndAprove_GeneralSteps;
	
	public String admUsername,admPassword,keyGlobalForecastsBreadcrumb,errorMessageForEmptyInput,errorMessageForInvalidData,lettersAndNumbers,negativeNumbers,realNumbers,specialCharacters	
	,largeDvpackID,errorMessageInvalidDvpackId,chartDvpackId,staticDvpackId,dynamicDvpackId,expectedDvPackname,newButtonText,generateDvPacksPageBreadcrumbs,expectedDvPackTitle,
	dvPackType,type,dvPackname,dvPackTitle,dvPackDescription,database,expectedDvPackDescription,country, indicator, dateRangeFrom, dateRangeTo,
	dvPackId,confirmationpageBreadcrumbs,renderType, databaseTable,createDynamicDvPackPageBreadcrumbs,editDvPackPageBreadcrumbs,defaultView,previewDvPackPageBreadcrumbs, inputType, inputTypeForm;
	private static int line = 0;
	
	@Test
	public void bmo5_045_Adm_Widgets_Key_Global_Forecasts(){
		loginSteps.performLogin(admUsername,admPassword);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageDVPacks);
		adm_DvPacks_Listing_GeneralSteps.verifyBreadcrumbsDVPacks();
		adm_DvPacks_Listing_GeneralSteps.verifyColumnName();
		adm_DvPacks_Listing_GeneralSteps.clickOnAddNewDvPackButton(newButtonText);
		menuNavigationSteps.verifyBreadCrumb(generateDvPacksPageBreadcrumbs);
		adm_DvPacks_GenerateDVPack_GeneralSteps.selectDvpackType(dvPackType, type);
		expectedDvPackname = adm_DvPacks_GenerateDVPack_GeneralSteps.inputNameForDvPack(dvPackname);
		expectedDvPackTitle = adm_DvPacks_GenerateDVPack_GeneralSteps.inputTitleForDvPack(dvPackTitle);
		expectedDvPackDescription = adm_DvPacks_GenerateDVPack_GeneralSteps.inputDescriptionForDvPack(dvPackDescription);
		adm_DvPacks_GenerateDVPack_GeneralSteps.selectADataBaseFromDropdownList(database);
		adm_DvPacks_GenerateDVPack_GeneralSteps.selectDvpackType(dvPackType, type);
		adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
		menuNavigationSteps.verifyBreadCrumb(createDynamicDvPackPageBreadcrumbs);
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnBackButton();
		menuNavigationSteps.verifyBreadCrumb(editDvPackPageBreadcrumbs);
		adm_DvPacks_GenerateDVPack_GeneralSteps.verifyEditDvPackPage(expectedDvPackname, expectedDvPackTitle, expectedDvPackDescription, dvPackType, databaseTable, type, defaultView);
		adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
		menuNavigationSteps.verifyBreadCrumb(createDynamicDvPackPageBreadcrumbs);
		if(database.equals("NDB") ){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersNdb(country, indicator, dateRangeFrom, dateRangeTo,dvPackType);
		}else{
			System.out.println("There is no such a database in list");
		}
		
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
		menuNavigationSteps.verifyBreadCrumb(previewDvPackPageBreadcrumbs);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyNameFromPreview(expectedDvPackname);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyTitleFromPreview(expectedDvPackTitle);
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
		menuNavigationSteps.verifyBreadCrumb(confirmationpageBreadcrumbs);
		dvPackId = adm_Dvpacks_PreviewAndAprove_GeneralSteps.getDvpackIDConfirmationPage(Constants.ADM_RESOURCES_PREFIX + "Bmo5_045_Adm_Widgets_Key_Global_Forecasts.csv", line);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.clickOnDvPackListButton();
		adm_DvPacks_Listing_GeneralSteps.checkTableIntoListView(dvPackId, expectedDvPackname, expectedDvPackTitle, type, renderType, databaseTable, dvPackType);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.KeyGlobalForecasts);
		menuNavigationSteps.verifyBreadCrumb(keyGlobalForecastsBreadcrumb);
		kgfSteps.verifyCellIsDisplayed(inputType);
        kgfSteps.addDataClickSaveAndVerifyMessage(inputType, inputTypeForm,"",errorMessageForEmptyInput );
        kgfSteps.addDataClickSaveAndVerifyMessage(inputType, inputTypeForm, lettersAndNumbers,errorMessageForInvalidData );
        kgfSteps.addDataClickSaveAndVerifyMessage(inputType, inputTypeForm, negativeNumbers,errorMessageForInvalidData);
        kgfSteps.addDataClickSaveAndVerifyMessage(inputType, inputTypeForm, realNumbers,errorMessageForInvalidData);
        kgfSteps.addDataClickSaveAndVerifyMessage(inputType, inputTypeForm, specialCharacters,errorMessageForInvalidData);
        kgfSteps.addDataClickSaveAndVerifyMessage(inputType, inputTypeForm, largeDvpackID,errorMessageInvalidDvpackId);
        kgfSteps.addDataClickSaveAndVerifyMessage(inputType, inputTypeForm, chartDvpackId, errorMessageInvalidDvpackId);
        kgfSteps.addDataClickSaveAndVerifyMessage(inputType, inputTypeForm, staticDvpackId, errorMessageInvalidDvpackId);
        kgfSteps.addDataClickSaveAndVerifyMessage(inputType, inputTypeForm, dvPackId, dvPackId);
        kgfSteps.addDataClickSaveAndVerifyMessage(inputType, inputTypeForm, dynamicDvpackId, dynamicDvpackId);
	}
}

package bmo5.bmo5tests.tests.adm;


import java.util.List;

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
import bmo5.bmo5tests.adm.steps.widgets.KeyMarketForecastsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Widgets.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_070_Adm_KeyMarketForecasts.csv", separator=',')
public class Bmo5_070_Adm_KeyMarketForecasts {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	
	@Steps
	public KeyMarketForecastsSteps keyMarketForecastsSteps;
	
	@Steps
	public KeyGlobalForecastsSteps keyGlobalForecastsSteps;
	
	@Steps 
	public ADM_DvPacks_Listing_GeneralSteps adm_DvPacks_Listing_GeneralSteps;
	
	@Steps
	public ADM_DvPacks_GenerateDVPack_GeneralSteps adm_DvPacks_GenerateDVPack_GeneralSteps;
	
	@Steps
	public Adm_DvPacks_CreateDvPack_GeneralSteps adm_DvPacks_CreateDvPack_GeneralSteps;
	
	@Steps
	public Adm_Dvpacks_PreviewAndAprove_GeneralSteps adm_Dvpacks_PreviewAndAprove_GeneralSteps;
	
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Steps
	public DailyAnalysisAndNewsSteps dailyAnalysisAndNewsSteps;
	
	@Steps
	public  bmo5.bmo5tests.bmo.steps.LoginSteps bmo5LoginSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	
	String admUsername,admPassword,keyMarketForeastsBreadcrumb,searchItem,deleteAction,dvpackIdInputSelector,errorMessageForEmptyInput,errorMessageLabel,
	lettersAndNumbers,negativeNumbers,realNumbers,errorMessageForInvalidData,dvpackCellTable,dvpackIDInputTable,	
	newButtonText,generateDvPacksPageBreadcrumbs,dvPackType, type, defaultView,expectedDvPackname,expectedDvPackTitle,expectedDvPackDescription,
	dvPackname,dvPackTitle,dvPackDescription,database,createTemplateDvPackPageBreadcrumbs,indicator, dateRangeFrom, dateRangeTo,country,previewDvPackPageBreadcrumbs,
	renderType, databaseTable,formatPng, extentionPng,continent,breadcrumbDAN,confirmationpageBreadcrumbs,formatJpg,extentionJpg,extentionXls,dvPackId,bmo5Username,bmo5Password,service,serviceTop
	;
	int expectedNumberOfRowsFromTable,line,firstElementFromTable,secondElementFromTable,thirdElementFromTable;
	
	@Test
	public void bmo5_070_Adm_KeyMarketForecasts(){
		loginSteps.performLogin(admUsername,admPassword);
		line++;
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.KeyMarketForecasts);
		menuNavigationSteps.verifyBreadCrumb(keyMarketForeastsBreadcrumb);
		keyMarketForecastsSteps.typeSearchItemAndVerifyResults(searchItem);
		keyMarketForecastsSteps.clickOnDeleteButtonVerifyAndDoAction(deleteAction);
		keyGlobalForecastsSteps.addDataClickSaveAndVerifyMessage(dvpackCellTable, "", dvpackIDInputTable, errorMessageForEmptyInput);
		keyGlobalForecastsSteps.addDataClickSaveAndVerifyMessage(dvpackCellTable, lettersAndNumbers, dvpackIDInputTable, errorMessageForInvalidData);
		keyGlobalForecastsSteps.addDataClickSaveAndVerifyMessage(dvpackCellTable, negativeNumbers, dvpackIDInputTable, errorMessageForInvalidData);
		keyGlobalForecastsSteps.addDataClickSaveAndVerifyMessage(dvpackCellTable, realNumbers, dvpackIDInputTable, errorMessageForInvalidData);
		keyMarketForecastsSteps.typeSearchItem("");
		keyMarketForecastsSteps.clickOnAddRowButton();
	    keyMarketForecastsSteps.typeInvalidDataSaveAndVerify(dvpackIdInputSelector, "", errorMessageForEmptyInput, errorMessageLabel);
	    keyMarketForecastsSteps.typeInvalidDataSaveAndVerify(dvpackIdInputSelector, lettersAndNumbers, errorMessageForInvalidData, errorMessageLabel);
	    keyMarketForecastsSteps.typeInvalidDataSaveAndVerify(dvpackIdInputSelector, negativeNumbers, errorMessageForInvalidData, errorMessageLabel);
	    keyMarketForecastsSteps.typeInvalidDataSaveAndVerify(dvpackIdInputSelector, realNumbers, errorMessageForInvalidData, errorMessageLabel);
	    menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageDVPacks);
		adm_DvPacks_Listing_GeneralSteps.verifyBreadcrumbsDVPacks();
		adm_DvPacks_Listing_GeneralSteps.clickOnAddNewDvPackButton(newButtonText);
		menuNavigationSteps.verifyBreadCrumb(generateDvPacksPageBreadcrumbs);
		adm_DvPacks_GenerateDVPack_GeneralSteps.selectDvPackTypeTypeAndDefaultView(dvPackType, type, defaultView);
		expectedDvPackname = adm_DvPacks_GenerateDVPack_GeneralSteps.inputNameForDvPack(dvPackname);
		expectedDvPackTitle = adm_DvPacks_GenerateDVPack_GeneralSteps.inputTitleForDvPack(dvPackTitle);
		expectedDvPackDescription = adm_DvPacks_GenerateDVPack_GeneralSteps.inputDescriptionForDvPack(dvPackDescription);
		adm_DvPacks_GenerateDVPack_GeneralSteps.selectADataBaseFromDropdownList(database);
		adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
		menuNavigationSteps.verifyBreadCrumb(createTemplateDvPackPageBreadcrumbs);
		if(database.equals("NDB")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersNdbTemplateDvPack(indicator, dateRangeFrom, dateRangeTo, dvPackType);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(country);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else{
			System.out.println("There is no such a database in list");
		}
		
		expectedNumberOfRowsFromTable = adm_DvPacks_CreateDvPack_GeneralSteps.returnNumbeOfRowsFromTable();
		List<String> indicatorsFromADM=adm_DvPacks_CreateDvPack_GeneralSteps.getIndicators();
		for(String indicator:indicatorsFromADM){
			System.out.println("Indicators from adm: "+indicator);
		}
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
		menuNavigationSteps.verifyBreadCrumb(previewDvPackPageBreadcrumbs);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyNameFromPreview(expectedDvPackname);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyTitleFromPreview(expectedDvPackTitle);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyNumberOfRowsFromTableInPreview(expectedNumberOfRowsFromTable);
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
		menuNavigationSteps.verifyBreadCrumb(confirmationpageBreadcrumbs);
		dvPackId = adm_Dvpacks_PreviewAndAprove_GeneralSteps.getDvpackIDConfirmationPage(Constants.ADM_RESOURCES_PREFIX + "Bmo5_070_Adm_KeyMarketForecasts.csv", line);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.clickOnDvPackListButton();
		adm_DvPacks_Listing_GeneralSteps.checkTableIntoListView(dvPackId, expectedDvPackname, expectedDvPackTitle, type, renderType, databaseTable, dvPackType);
		
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.KeyMarketForecasts);
		menuNavigationSteps.verifyBreadCrumb(keyMarketForeastsBreadcrumb);
		keyMarketForecastsSteps.typeSearchItemAndVerifyResults(searchItem);
		keyGlobalForecastsSteps.clickDvpackIdInput(dvpackCellTable);
		keyGlobalForecastsSteps.typeDvpackId(dvpackIDInputTable, dvPackId);
		keyGlobalForecastsSteps.clickSaveButton();
		
		menuNavigationSteps.admLogout();
		menuNavigationSteps.navigateTo(Constants.BMO_HOST);
		bmo5LoginSteps.performLogin(bmo5Username, bmo5Password);	
		homePageTopMenuSteps.clickAndVerifyService( serviceTop,service);
		dailyAnalysisAndNewsSteps.verifyKeyMarketForecastsIsDisplayed();
		dailyAnalysisAndNewsSteps.selectGeographyFromFilter(breadcrumbDAN, country, continent);
		dailyAnalysisAndNewsSteps.verifyKeyMarketForecastsIsDisplayed();
		List<String>indicatorsListFromBMO=dailyAnalysisAndNewsSteps.getIndicatorsFromKeyMarketForecasts();
		dailyAnalysisAndNewsSteps.compareIndicators(indicatorsFromADM, indicatorsListFromBMO);
		String firstIndicator=dailyAnalysisAndNewsSteps.getCellValueFromKeyMarketForecasts(secondElementFromTable,firstElementFromTable);
		String secondIndicator=dailyAnalysisAndNewsSteps.getCellValueFromKeyMarketForecasts(thirdElementFromTable,firstElementFromTable);
		String firstIndicatorValue=dailyAnalysisAndNewsSteps.getCellValueFromKeyMarketForecasts(secondElementFromTable,secondElementFromTable);
		String secondIndicatorValue=dailyAnalysisAndNewsSteps.getCellValueFromKeyMarketForecasts(thirdElementFromTable,secondElementFromTable);
		dailyAnalysisAndNewsSteps.clickOnClickHereToExploreFromKMF(dvPackId);
		dailyAnalysisAndNewsSteps.getDriver().getCurrentUrl().contains(dvPackId);
		homePageHeaderSteps.verifyBreadCrumbs(dvPackTitle);
		dataToolSteps.verifyIfActionIconsAreEnabled();
		dataToolSteps.getCellValueFromTableAndVerify(firstIndicator,firstElementFromTable,secondElementFromTable);
		dataToolSteps.getCellValueFromTableAndVerify(secondIndicator,secondElementFromTable,secondElementFromTable);
		dataToolSteps.getCellValueReplaceCommaAndVerify(firstIndicatorValue,firstElementFromTable,thirdElementFromTable);
		dataToolSteps.getCellValueReplaceCommaAndVerify(secondIndicatorValue,secondElementFromTable,thirdElementFromTable);
		dataAndForecastingSteps.clickOnDownloadDataTool(extentionXls);
		dataToolSteps.clickOnExportButton();
		dataToolSteps.verifyExportWindowDefaultState();
		dataToolSteps.verifyExportChart(formatJpg, extentionJpg);
		dataToolSteps.verifyExportChart(formatPng, extentionPng);
		dataToolSteps.clickOnTableRadioButton();
		dataToolSteps.verifyExportTable(extentionXls);
		dataToolSteps.clickOnTableAndChartRadioButton();
		dataToolSteps.verifyExportChartAndTable(extentionXls);
		dataToolSteps.clickOnSaveChart();
		bmiDatabasesGeneralSteps.saveNameChart(dvPackname);	
	}
}

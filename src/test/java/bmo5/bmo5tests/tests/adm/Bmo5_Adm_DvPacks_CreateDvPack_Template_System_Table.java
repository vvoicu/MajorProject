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
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;
import junit.framework.TestCase;

@Story(Application.Adm.DvPacks.ManageDvPacks.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_Adm_DvPacks_CreateDvPack_Template_System_Table.csv", separator=',')

public class Bmo5_Adm_DvPacks_CreateDvPack_Template_System_Table extends TestCase{
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public Adm_DvPacks_CreateDvPack_GeneralSteps adm_DvPacks_CreateDvPack_GeneralSteps;
	
	@Steps 
	public ADM_DvPacks_Listing_GeneralSteps adm_DvPacks_Listing_GeneralSteps;
	
	@Steps
	public ADM_DvPacks_GenerateDVPack_GeneralSteps adm_DvPacks_GenerateDVPack_GeneralSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public Adm_Dvpacks_PreviewAndAprove_GeneralSteps adm_Dvpacks_PreviewAndAprove_GeneralSteps;
	
	public String username, password, country, indicator, dateRangeFrom, dateRangeTo, newButtonText, dvPackname, dvPackTitle, dvPackDescription, database, generateDvPacksPageBreadcrumbs, 
	createTemplateDvPackPageBreadcrumbs, region, startDateOperator, startYear, endDateOperator, endYear, status, sector, fromValue, toValue, fromEstPeakOil, toEstPeakOil, fromEstPeakGas, 
	toEstPeakGas, fromProjectCost, toProjectCost, onshoreOrOffshore, hydrocarbonType, industryType, fromCapacityBD, toCapacityBD, fromCapacityTPA, toCapacityTPA, metal, fromCapex, 
	toCapex, fromOreGrade, toOreGrade, operator, age, gender, letter, previewDvPackPageBreadcrumbs, expectedDvPackname, expectedDvPackTitle, expectedDvPackDescription, 
	confirmationpageBreadcrumbs, dvPackId, dvPackType, type, defaultView, editDvPackPageBreadcrumbs, renderType, databaseTable, rowNumber, expectedDvPacknameClone, 
	expectedDvPackTitleClone, countryEdit, indicatorEdit, dateRangeFromEdit, dateRangeToEdit, regionEdit, startDateOperatorEdit, startYearEdit, endDateOperatorEdit, endYearEdit, 
	statusEdit, sectorEdit, fromValueEdit, toValueEdit, fromEstPeakOilEdit, toEstPeakOilEdit, fromEstPeakGasEdit, toEstPeakGasEdit, fromProjectCostEdit, toProjectCostEdit, 
	onshoreOrOffshoreEdit, hydrocarbonTypeEdit, fromCapacityBDEdit, toCapacityBDEdit, fromCapacityTPAEdit, toCapacityTPAEdit, metalEdit, fromCapexEdit, toCapexEdit, fromOreGradeEdit, 
	toOreGradeEdit, letterEdit, ageEdit, genderEdit;
	public int expectedNumberOfRowsFromTable;
	private static int line = 0;
	
	@Test
	public void bmo5_Adm_DvPacks_CreateDvPack_Template_System_Table(){
		loginSteps.performLogin(username,password);
		line++;
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageDVPacks);
		adm_DvPacks_Listing_GeneralSteps.verifyBreadcrumbsDVPacks();
		adm_DvPacks_Listing_GeneralSteps.verifyColumnName();
		adm_DvPacks_Listing_GeneralSteps.clickOnAddNewDvPackButton(newButtonText);
		menuNavigationSteps.verifyBreadCrumb(generateDvPacksPageBreadcrumbs);
		adm_DvPacks_GenerateDVPack_GeneralSteps.selectDvPackTypeTypeAndDefaultView(dvPackType, type, defaultView);
		expectedDvPackname = adm_DvPacks_GenerateDVPack_GeneralSteps.inputNameForDvPack(dvPackname);
		expectedDvPackTitle = adm_DvPacks_GenerateDVPack_GeneralSteps.inputTitleForDvPack(dvPackTitle);
		expectedDvPackDescription = adm_DvPacks_GenerateDVPack_GeneralSteps.inputDescriptionForDvPack(dvPackDescription);
		adm_DvPacks_GenerateDVPack_GeneralSteps.selectADataBaseFromDropdownList(database);
		if(database.equals("Industry Risk Reward")){
			adm_DvPacks_GenerateDVPack_GeneralSteps.selectAnIndustryRisk(industryType);
		}
		adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
		menuNavigationSteps.verifyBreadCrumb(createTemplateDvPackPageBreadcrumbs);
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnBackButton();
		menuNavigationSteps.verifyBreadCrumb(editDvPackPageBreadcrumbs);
		adm_DvPacks_GenerateDVPack_GeneralSteps.verifyEditDvPackPage(expectedDvPackname, expectedDvPackTitle, expectedDvPackDescription, dvPackType, databaseTable, type, defaultView);
		adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
		menuNavigationSteps.verifyBreadCrumb(createTemplateDvPackPageBreadcrumbs);
		if(database.equals("NDB")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersNdbTemplateDvPack(indicator, dateRangeFrom, dateRangeTo, dvPackType);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(country);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else if(database.equals("Country Risk") || database.equals("Industry Risk Reward")  || database.equals("Project Finance")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersRatingsTemplateDvPack(indicator, dateRangeFrom, dateRangeTo, dvPackType);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(country);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else if(database.equals("Key Projects Infrastructure") || database.equals("Key Projects Power") || database.equals("Key Projects Renewables")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersKeyProjectsTemplateDvPack(startDateOperator, startYear, endDateOperator, endYear, status, sector, fromValue, toValue);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(region);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else if(database.equals("Upstream Projects")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersUpstreamProjectsTemplateDvPack(status, fromEstPeakOil, toEstPeakOil, fromEstPeakGas, toEstPeakGas, fromProjectCost, toProjectCost, onshoreOrOffshore, hydrocarbonType);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(region);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else if(database.equals("Global Refineries")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersGlobalRefineriesTemplateDvPack(status, fromCapacityBD, toCapacityBD, fromCapacityTPA, toCapacityTPA, startDateOperator, startYear, endDateOperator, endYear);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(region);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else if(database.equals("Global Mines")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersGlobalMinesTemplateDvPack(metal, fromCapex, toCapex, fromOreGrade, toOreGrade, dateRangeFrom, dateRangeTo, endDateOperator, endYear, letter, status, dvPackType);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(region);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else if(database.equals("Burden of Disease")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersBODDTemplateDvPack(indicator, age, gender, dateRangeFrom, dateRangeTo, dvPackType);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(region);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else{
			System.out.println("There is no such a database in list");
		}
//		adm_DvPacks_CreateDvPack_GeneralSteps.verifyButtonsPresenceForDynamicDvPack();
		expectedNumberOfRowsFromTable = adm_DvPacks_CreateDvPack_GeneralSteps.returnNumbeOfRowsFromTable();
		if(database.equals("NDB") || database.equals("Mobile Operators") || database.equals("Burden of Disease")){
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyChartTitle(expectedDvPackTitle);
		}
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnFormatTableAndVerify(expectedDvPackTitle, expectedDvPackDescription);
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
		menuNavigationSteps.verifyBreadCrumb(previewDvPackPageBreadcrumbs);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyNameFromPreview(expectedDvPackname);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyTitleFromPreview(expectedDvPackTitle);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyNumberOfRowsFromTableInPreview(expectedNumberOfRowsFromTable);
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
		menuNavigationSteps.verifyBreadCrumb(confirmationpageBreadcrumbs);
		dvPackId = adm_Dvpacks_PreviewAndAprove_GeneralSteps.getDvpackIDConfirmationPage(Constants.ADM_RESOURCES_PREFIX + "Bmo5_Adm_DvPacks_CreateDvPack_Template_System_Table.csv", line);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.clickOnDvPackListButton();
		adm_DvPacks_Listing_GeneralSteps.checkTableIntoListView(dvPackId, expectedDvPackname, expectedDvPackTitle, type, renderType, databaseTable, dvPackType);
		
		adm_DvPacks_Listing_GeneralSteps.clickOnEditLink(rowNumber);
		adm_DvPacks_GenerateDVPack_GeneralSteps.verifyEditDvPackPage(expectedDvPackname, expectedDvPackTitle, expectedDvPackDescription, dvPackType, databaseTable, type, defaultView);
		adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnClearFiltersButton();
		if(database.equals("NDB")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersNdbTemplateDvPack(indicatorEdit, dateRangeFromEdit, dateRangeToEdit, dvPackType);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(countryEdit);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else if(database.equals("Country Risk") || database.equals("Industry Risk Reward")  || database.equals("Project Finance")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersRatingsTemplateDvPack(indicatorEdit, dateRangeFromEdit, dateRangeToEdit, dvPackType);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(countryEdit);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else if(database.equals("Key Projects Infrastructure") || database.equals("Key Projects Power") || database.equals("Key Projects Renewables")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersKeyProjectsTemplateDvPack(startDateOperatorEdit, startYearEdit, endDateOperatorEdit, endYearEdit, statusEdit, sectorEdit, fromValueEdit, toValueEdit);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(regionEdit);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else if(database.equals("Upstream Projects")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersUpstreamProjectsTemplateDvPack(statusEdit, fromEstPeakOilEdit, toEstPeakOilEdit, fromEstPeakGasEdit, toEstPeakGasEdit, fromProjectCostEdit, toProjectCostEdit, onshoreOrOffshoreEdit, hydrocarbonTypeEdit);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(regionEdit);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else if(database.equals("Global Refineries")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersGlobalRefineriesTemplateDvPack(statusEdit, fromCapacityBDEdit, toCapacityBDEdit, fromCapacityTPAEdit, toCapacityTPAEdit, startDateOperatorEdit, startYearEdit, endDateOperatorEdit, endYearEdit);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(regionEdit);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else if(database.equals("Global Mines")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersGlobalMinesTemplateDvPack(metalEdit, fromCapexEdit, toCapexEdit, fromOreGradeEdit, toOreGradeEdit, dateRangeFromEdit, dateRangeToEdit, endDateOperatorEdit, endYearEdit, letterEdit, statusEdit, dvPackType);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(regionEdit);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else if(database.equals("Burden of Disease")){
			adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersBODDTemplateDvPack(indicatorEdit, ageEdit, genderEdit, dateRangeFromEdit, dateRangeToEdit, dvPackType);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(regionEdit);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else{
			System.out.println("There is no such a database in list");
		}
//		adm_DvPacks_CreateDvPack_GeneralSteps.verifyButtonsPresenceForDynamicDvPack();
		expectedNumberOfRowsFromTable = adm_DvPacks_CreateDvPack_GeneralSteps.returnNumbeOfRowsFromTable();
		if(database.equals("NDB") || database.equals("Mobile Operators") || database.equals("Burden of Disease")){
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyChartTitle(expectedDvPackTitle);
		}
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnFormatTableAndVerify(expectedDvPackTitle, expectedDvPackDescription);
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
		menuNavigationSteps.verifyBreadCrumb(previewDvPackPageBreadcrumbs);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyNameFromPreview(expectedDvPackname);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyTitleFromPreview(expectedDvPackTitle);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyNumberOfRowsFromTableInPreview(expectedNumberOfRowsFromTable);
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
		menuNavigationSteps.verifyBreadCrumb(confirmationpageBreadcrumbs);
		dvPackId = adm_Dvpacks_PreviewAndAprove_GeneralSteps.getDvpackIDConfirmationPage(Constants.ADM_RESOURCES_PREFIX + "Bmo5_Adm_DvPacks_CreateDvPack_Template_System_Table.csv", line);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.clickOnDvPackListButton();
		adm_DvPacks_Listing_GeneralSteps.checkTableIntoListView(dvPackId, expectedDvPackname, expectedDvPackTitle, type, renderType, databaseTable, dvPackType);
		
		adm_DvPacks_Listing_GeneralSteps.clickOnCloneLink(rowNumber);
		adm_DvPacks_GenerateDVPack_GeneralSteps.verifyEditDvPackPageForClone(expectedDvPackname, expectedDvPackTitle, expectedDvPackDescription, dvPackType, databaseTable, type, defaultView);
		expectedDvPacknameClone = adm_DvPacks_GenerateDVPack_GeneralSteps.inputNameForDvPackClone(dvPackname);
		expectedDvPackTitleClone = adm_DvPacks_GenerateDVPack_GeneralSteps.inputTitleForDvPack(dvPackTitle);
		adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
		if(database.equals("NDB") || database.equals("Country Risk") || database.equals("Industry Risk Reward")  || database.equals("Project Finance")){
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(countryEdit);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else if(database.equals("Key Projects Infrastructure") || database.equals("Key Projects Power") || database.equals("Key Projects Renewables") ||
				database.equals("Upstream Projects") || database.equals("Global Refineries") || database.equals("Global Mines") || database.equals("Burden of Disease")){
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyPreviewForPopUpWindow();
			adm_DvPacks_CreateDvPack_GeneralSteps.checkOneGeographyFromPreviewTemplateDvPack(regionEdit);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
		}
		else{
			System.out.println("There is no such a database in list");
		}
		expectedNumberOfRowsFromTable = adm_DvPacks_CreateDvPack_GeneralSteps.returnNumbeOfRowsFromTable();
		if(database.equals("NDB") || database.equals("Mobile Operators") || database.equals("Burden of Disease")){
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyChartTitle(expectedDvPackTitleClone);
		}
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnFormatTableAndVerify(expectedDvPackTitleClone, expectedDvPackDescription);
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
		menuNavigationSteps.verifyBreadCrumb(previewDvPackPageBreadcrumbs);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyNameFromPreview(expectedDvPacknameClone);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyTitleFromPreview(expectedDvPackTitleClone);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyNumberOfRowsFromTableInPreview(expectedNumberOfRowsFromTable);
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
		menuNavigationSteps.verifyBreadCrumb(confirmationpageBreadcrumbs);
		dvPackId = adm_Dvpacks_PreviewAndAprove_GeneralSteps.getDvpackIDConfirmationPage(Constants.ADM_RESOURCES_PREFIX + "Bmo5_Adm_DvPacks_CreateDvPack_Template_System_Table.csv", line);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.clickOnDvPackListButton();
		adm_DvPacks_Listing_GeneralSteps.checkTableIntoListView(dvPackId, expectedDvPacknameClone, expectedDvPackTitleClone, type, renderType, databaseTable, dvPackType);
	}
}

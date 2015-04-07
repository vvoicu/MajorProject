package bmo5.bmo5tests.tests.adm;

import junit.framework.TestCase;
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

@Story(Application.Adm.DvPacks.ManageDvPacks.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_System_Chart.csv", separator=',')

public class Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_System_Chart extends TestCase{
	
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
	createDynamicDvPackPageBreadcrumbs, region, startDateOperator, startYear, endDateOperator, endYear, status, sector, fromValue, toValue, fromEstPeakOil, toEstPeakOil, fromEstPeakGas, 
	toEstPeakGas, fromProjectCost, toProjectCost, onshoreOrOffshore, hydrocarbonType, industryType, fromCapacityBD, toCapacityBD, fromCapacityTPA, toCapacityTPA, metal, fromCapex, 
	toCapex, fromOreGrade, toOreGrade, operator, age, gender, letter, previewDvPackPageBreadcrumbs, expectedDvPackname, expectedDvPackTitle, expectedDvPackDescription, 
	confirmationpageBreadcrumbs, dvPackId, dvPackType, type, defaultView, editDvPackPageBreadcrumbs, renderType, dvPackSubTitle, expectedDvPackSubtitle, databaseTable, rowNumber,
	expectedDvPacknameClone, expectedDvPackTitleClone, countryEdit, indicatorEdit, dateRangeFromEdit, dateRangeToEdit, regionEdit, operatorEdit, ageEdit, genderEdit;
	private static int line = 0;
	
	@Test
	public void bmo5_Adm_DvPacks_CreateDvPack_Dynamic_System_Chart(){
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
		expectedDvPackSubtitle = adm_DvPacks_GenerateDVPack_GeneralSteps.inputSubTitleForDvPack(dvPackSubTitle);
		expectedDvPackDescription = adm_DvPacks_GenerateDVPack_GeneralSteps.inputDescriptionForDvPack(dvPackDescription);
		adm_DvPacks_GenerateDVPack_GeneralSteps.selectADataBaseFromDropdownList(database);
		if(database.equals("NDB") || database.equals("Mobile Operators") || database.equals("Burden of Disease")){
			adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
			menuNavigationSteps.verifyBreadCrumb(createDynamicDvPackPageBreadcrumbs);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnBackButton();
			menuNavigationSteps.verifyBreadCrumb(editDvPackPageBreadcrumbs);
			adm_DvPacks_GenerateDVPack_GeneralSteps.verifyEditDvPackPage(expectedDvPackname, expectedDvPackTitle, expectedDvPackDescription, dvPackType, databaseTable, type, defaultView);
			adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
			menuNavigationSteps.verifyBreadCrumb(createDynamicDvPackPageBreadcrumbs);
			if(database.equals("NDB")){
				adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersNdb(country, indicator, dateRangeFrom, dateRangeTo, dvPackType);
			}
			else if(database.equals("Mobile Operators")){
				adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersMOD(region, operator, indicator, dateRangeFrom, dateRangeTo, dvPackType);
			}
			else if(database.equals("Burden of Disease")){
				adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersBODD(region, indicator, age, gender, dateRangeFrom, dateRangeTo, dvPackType);
			}
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
//			adm_DvPacks_CreateDvPack_GeneralSteps.verifyButtonsPresenceForDynamicDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyChartTitle(expectedDvPackTitle);
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyChartSubtitle(expectedDvPackSubtitle);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnFormatChartAndVerify(expectedDvPackTitle, expectedDvPackSubtitle, expectedDvPackDescription,dvPackType);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
			menuNavigationSteps.verifyBreadCrumb(previewDvPackPageBreadcrumbs);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyNameFromPreview(expectedDvPackname);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyTitleFromPreview(expectedDvPackTitle);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyChartIsDisplayedInPreview();
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
			menuNavigationSteps.verifyBreadCrumb(confirmationpageBreadcrumbs);
			dvPackId = adm_Dvpacks_PreviewAndAprove_GeneralSteps.getDvpackIDConfirmationPage(Constants.ADM_RESOURCES_PREFIX + "Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_System_Chart.csv", line);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.clickOnDvPackListButton();
			adm_DvPacks_Listing_GeneralSteps.checkTableIntoListView(dvPackId, expectedDvPackname, expectedDvPackTitle, type, renderType, databaseTable, dvPackType);
			
			adm_DvPacks_Listing_GeneralSteps.clickOnEditLink(rowNumber);
			adm_DvPacks_GenerateDVPack_GeneralSteps.verifyEditDvPackPage(expectedDvPackname, expectedDvPackTitle, expectedDvPackDescription, dvPackType, databaseTable, type, defaultView);
			adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnClearFiltersButtonAndVerify();
			if(database.equals("NDB")){
				adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersNdb(countryEdit, indicatorEdit, dateRangeFromEdit, dateRangeToEdit, dvPackType);
			}
			else if(database.equals("Mobile Operators")){
				adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersMOD(regionEdit, operatorEdit, indicatorEdit, dateRangeFromEdit, dateRangeToEdit, dvPackType);
			}
			else if(database.equals("Burden of Disease")){
				adm_DvPacks_CreateDvPack_GeneralSteps.selectDataFromFiltersBODD(regionEdit, indicatorEdit, ageEdit, genderEdit, dateRangeFromEdit, dateRangeToEdit, dvPackType);
			}
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnDisplayDataButtonAndVerify();
//			adm_DvPacks_CreateDvPack_GeneralSteps.verifyButtonsPresenceForDynamicDvPack();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyChartTitle(expectedDvPackTitle);
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyChartSubtitle(expectedDvPackSubtitle);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnFormatChartAndVerify(expectedDvPackTitle, expectedDvPackSubtitle, expectedDvPackDescription,dvPackType);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
			menuNavigationSteps.verifyBreadCrumb(previewDvPackPageBreadcrumbs);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyNameFromPreview(expectedDvPackname);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyTitleFromPreview(expectedDvPackTitle);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyChartIsDisplayedInPreview();
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
			menuNavigationSteps.verifyBreadCrumb(confirmationpageBreadcrumbs);
			dvPackId = adm_Dvpacks_PreviewAndAprove_GeneralSteps.getDvpackIDConfirmationPage(Constants.ADM_RESOURCES_PREFIX + "Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_System_Chart.csv", line);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.clickOnDvPackListButton();
			adm_DvPacks_Listing_GeneralSteps.checkTableIntoListView(dvPackId, expectedDvPackname, expectedDvPackTitle, type, renderType, databaseTable, dvPackType);
			
			adm_DvPacks_Listing_GeneralSteps.clickOnCloneLink(rowNumber);
			adm_DvPacks_GenerateDVPack_GeneralSteps.verifyEditDvPackPageForClone(expectedDvPackname, expectedDvPackTitle, expectedDvPackDescription, dvPackType, databaseTable, type, defaultView);
			expectedDvPacknameClone = adm_DvPacks_GenerateDVPack_GeneralSteps.inputNameForDvPackClone(dvPackname);
			expectedDvPackTitleClone = adm_DvPacks_GenerateDVPack_GeneralSteps.inputTitleForDvPack(dvPackTitle);
			adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyChartTitle(expectedDvPackTitleClone);
			adm_DvPacks_CreateDvPack_GeneralSteps.verifyChartSubtitle(expectedDvPackSubtitle);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnFormatChartAndVerify(expectedDvPackTitleClone, expectedDvPackSubtitle, expectedDvPackDescription,dvPackType);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
			menuNavigationSteps.verifyBreadCrumb(previewDvPackPageBreadcrumbs);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyNameFromPreview(expectedDvPacknameClone);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyTitleFromPreview(expectedDvPackTitleClone);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyChartIsDisplayedInPreview();
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
			menuNavigationSteps.verifyBreadCrumb(confirmationpageBreadcrumbs);
			dvPackId = adm_Dvpacks_PreviewAndAprove_GeneralSteps.getDvpackIDConfirmationPage(Constants.ADM_RESOURCES_PREFIX + "Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_System_Chart.csv", line);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.clickOnDvPackListButton();
			adm_DvPacks_Listing_GeneralSteps.checkTableIntoListView(dvPackId, expectedDvPacknameClone, expectedDvPackTitleClone, type, renderType, databaseTable, dvPackType);
		}
		else{
			System.out.println( database + " database does not has chart as default view");
			adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
			menuNavigationSteps.verifyBreadCrumb(createDynamicDvPackPageBreadcrumbs);
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnBackButton();
			menuNavigationSteps.verifyBreadCrumb(editDvPackPageBreadcrumbs);
			adm_DvPacks_GenerateDVPack_GeneralSteps.verifyChartOptionFronDefaultViewIsDisabled();
		}
	}
}

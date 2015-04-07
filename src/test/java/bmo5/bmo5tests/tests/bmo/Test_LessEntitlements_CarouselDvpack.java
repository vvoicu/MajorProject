package bmo5.bmo5tests.tests.bmo;

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
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.ADM_DvPacks_GenerateDVPack_GeneralSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.ADM_DvPacks_Listing_GeneralSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Adm_DvPacks_CreateDvPack_GeneralSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Adm_Dvpacks_PreviewAndAprove_GeneralSteps;
import bmo5.bmo5tests.adm.steps.widgets.BusinessRulesWidgetsSteps;
import bmo5.bmo5tests.adm.steps.widgets.CarouselSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Navigation.LessEntitlements.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_LessEntitlements_CarouselDvpack.csv", separator = ',')

public class Test_LessEntitlements_CarouselDvpack {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl =Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public bmo5.bmo5tests.adm.steps.LoginSteps admLoginSteps;
	
	@Steps
    public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Steps
	public DailyAnalysisAndNewsSteps dailyAnalysisAndNewsSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public Adm_DvPacks_CreateDvPack_GeneralSteps adm_DvPacks_CreateDvPack_GeneralSteps;
	
	@Steps 
	public ADM_DvPacks_Listing_GeneralSteps adm_DvPacks_Listing_GeneralSteps;
	
	@Steps
	public ADM_DvPacks_GenerateDVPack_GeneralSteps adm_DvPacks_GenerateDVPack_GeneralSteps;
	
	@Steps
	public Adm_Dvpacks_PreviewAndAprove_GeneralSteps adm_Dvpacks_PreviewAndAprove_GeneralSteps;
	
	@Steps
	public CarouselSteps carouselSteps;
	
	@Steps
	public HomePageLevelOneSteps homePageLevelOneSteps;
	
	@Steps
	public BusinessRulesWidgetsSteps brwSteps;
	
	public String admUsername, admPassword,bmo5Username, bmo5Password, country, indicator, dateRangeFrom, dateRangeTo, newButtonText, dvPackname, dvPackTitle, dvPackDescription, database, generateDvPacksPageBreadcrumbs, createStatiDvPackPageBreadcrumbs, region, startDateOperator, startYear, endDateOperator, endYear, status, sector, fromValue, toValue, fromEstPeakOil, toEstPeakOil, fromEstPeakGas, toEstPeakGas, fromProjectCost, toProjectCost, onshoreOrOffshore, hydrocarbonType, industryType, fromCapacityBD, toCapacityBD, fromCapacityTPA, toCapacityTPA, metal, fromCapex, toCapex, fromOreGrade, toOreGrade, operator, age, gender, letter, previewDvPackPageBreadcrumbs, expectedDvPackname, expectedDvPackTitle, expectedDvPackDescription, confirmationpageBreadcrumbs, dvPackId, dvPackType, type, defaultView, editDvPackPageBreadcrumbs, renderType, dvPackSubTitle, expectedDvPackSubtitle, databaseTable,firstArticleID,secondArticleID;
	 private static int line = 0;
	
	@Test
	public void test_LessEntitlements_CarouselDvpack(){
		admLoginSteps.performLogin(admUsername,admPassword);
		line++;
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageDVPacks);
		adm_DvPacks_Listing_GeneralSteps.verifyBreadcrumbsDVPacks();
		adm_DvPacks_Listing_GeneralSteps.clickOnAddNewDvPackButton(newButtonText);
		menuNavigationSteps.verifyBreadCrumb(generateDvPacksPageBreadcrumbs);
		adm_DvPacks_GenerateDVPack_GeneralSteps.selectDvPackTypeTypeAndDefaultView(dvPackType, type, defaultView);
		expectedDvPackname = adm_DvPacks_GenerateDVPack_GeneralSteps.inputNameForDvPack(dvPackname);
		expectedDvPackTitle = adm_DvPacks_GenerateDVPack_GeneralSteps.inputTitleForDvPack(dvPackTitle);
		expectedDvPackSubtitle = adm_DvPacks_GenerateDVPack_GeneralSteps.inputSubTitleForDvPack(dvPackSubTitle);
		expectedDvPackDescription = adm_DvPacks_GenerateDVPack_GeneralSteps.inputDescriptionForDvPack(dvPackDescription);
		adm_DvPacks_GenerateDVPack_GeneralSteps.selectADataBaseFromDropdownList(database);
			adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
			menuNavigationSteps.verifyBreadCrumb(createStatiDvPackPageBreadcrumbs);
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
//			adm_DvPacks_CreateDvPack_GeneralSteps.verifyButtonsPresenceForStaticDvPAck();
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
			Sleeper.sleepTight(5000);
			menuNavigationSteps.verifyBreadCrumb(previewDvPackPageBreadcrumbs);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyNameFromPreview(expectedDvPackname);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyTitleFromPreview(expectedDvPackTitle);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyChartIsDisplayedInPreview();
			adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
			Sleeper.sleepTight(5000);
			menuNavigationSteps.verifyBreadCrumb(confirmationpageBreadcrumbs);
			dvPackId = adm_Dvpacks_PreviewAndAprove_GeneralSteps.getDvpackIDConfirmationPage(Constants.BMO_RESOURCES_PREFIX + "Test_LessEntitlements_CarouselDvpack.csv", line);
			adm_Dvpacks_PreviewAndAprove_GeneralSteps.clickOnDvPackListButton();
			adm_DvPacks_Listing_GeneralSteps.checkTableIntoListView(dvPackId, expectedDvPackname, expectedDvPackTitle, type, renderType, databaseTable, dvPackType);
			
			menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
			menuNavigationSteps.selectMenuItem(AdmMenuItems.Carousel);
			int activeCarousels=carouselSteps.deselectAnActiveItem();
			carouselSteps.clickOnAddNewButtonCompleteFieldsWithValidDataSaveAndVerify(firstArticleID,secondArticleID,dvPackId);
			String carouselID=carouselSteps.getCarouselID();
			carouselSteps.setCreatedCarouselActive(carouselID);
			carouselSteps.clickSaveButton();
			menuNavigationSteps.admLogout();
			carouselSteps.navigateTo(Constants.BMO_HOST);
			loginSteps.performLogin(bmo5Username, bmo5Password);
			for(int i=1;i<=activeCarousels;i++){
			homePageLevelOneSteps.clickOnDvPackFromCarouselAndVerifyPermissionModal();
			homePageLevelOneSteps.clickOnNextArrowFromCarousel();
		}
	}
}
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
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.ADM_DvPacks_Listing_GeneralSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Create_StaticDvPack_WidgetType_SelectOptionSteps;
import bmo5.bmo5tests.adm.steps.widgets.CarouselEditSteps;
import bmo5.bmo5tests.adm.steps.widgets.CarouselSteps;
import bmo5.bmo5tests.adm.steps.widgets.HotTopicsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Widgets.Carousel.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_045_ADM_Widgets_Carousel.csv", separator=',')

public class Bmo5_045_Adm_WidgetsCarousel extends TestCase {
	
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
	public CarouselSteps carouselSteps;
	@Steps
	public CarouselEditSteps carouselEditSteps;
	@Steps 
	public ADM_DvPacks_Listing_GeneralSteps adm_DvPacks_listingSteps;
	@Steps
	public Create_StaticDvPack_WidgetType_SelectOptionSteps create_StaticDvPack_WidgetType_SelectOptionSteps;
	@Steps
	public HotTopicsSteps hotTopicsSteps;
	
	public String username, password, articleID, reportID, intalidArticleID, invalidReportID, invaliDvPackID, name, title, subtitle, description, type, databaseType, searchGeography, metalIndicator, tableMessage, primaryGeography, primaryChannel, primaryCompany, carouselBreadcrumbs, editCarouselBreadcrumbs;
	int carouselNumber;
	
	public void setName(String name) {
		this.name = name+"_"+StringUtils.randomNumber(84000)+"_"+StringUtils.randomNumber(84000);
	}
	
	@Test
	public void bmo5_045_Adm_WidgetsCarousel(){
		admLoginSteps.performLogin(username,password);
		
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageDVPacks);
		Sleeper.sleepTight(4000);
		adm_DvPacks_listingSteps.verifyBreadcrumbsDVPacks();
		adm_DvPacks_listingSteps.verifyColumnName();
		create_StaticDvPack_WidgetType_SelectOptionSteps.createDvPackTableLead(name, title, subtitle, description, type, databaseType);
		create_StaticDvPack_WidgetType_SelectOptionSteps.verifyStaticDvPack();
		create_StaticDvPack_WidgetType_SelectOptionSteps.selectGeography(searchGeography);
		create_StaticDvPack_WidgetType_SelectOptionSteps.selectMetalIndicator(metalIndicator);
		create_StaticDvPack_WidgetType_SelectOptionSteps.displayTable(primaryGeography,searchGeography, metalIndicator);
		create_StaticDvPack_WidgetType_SelectOptionSteps.saveDvPackTableLead(title, name, tableMessage, primaryGeography, primaryChannel, primaryCompany, searchGeography, metalIndicator);
		String dvPackID = create_StaticDvPack_WidgetType_SelectOptionSteps.checkTableIntoListView(name, title, databaseType, type);
		   
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Carousel);
		menuNavigationSteps.verifyBreadCrumb(carouselBreadcrumbs);
		carouselSteps.clickOnAddNewButtonCancelAndVerify();
		carouselSteps.clickOnAddNewButtonAndSaveWithoutCompletingAnyFieldAndVerify();
		carouselSteps.clickOnAddButtonCompleteFieldsWithInvalidDataAndVerify(intalidArticleID, invalidReportID, invaliDvPackID);
		Sleeper.sleepTight(3000);
		carouselSteps.clickOnAddNewButtonCompleteFieldsWithValidDataSaveAndVerify(articleID, reportID, dvPackID);
		
		carouselSteps.clickOnEditLinkOfOneItemFromCarousel(carouselNumber);
		menuNavigationSteps.verifyBreadCrumb(editCarouselBreadcrumbs);
		carouselEditSteps.deleteAllDataAndClickOnUpdateButtonThenClickOnResetLink(); 
		carouselEditSteps.completeFieldsWithInvalidDataAndClickOnUpdateButton(intalidArticleID, invalidReportID, invaliDvPackID);
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
		carouselEditSteps.clickOnListViewButton();
		
		carouselSteps.removeOneItemFromCarousel(dvPackID);
		
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageDVPacks);
		Sleeper.sleepTight(4000);
		adm_DvPacks_listingSteps.verifyBreadcrumbsDVPacks();
		manageWidgetsSteps.searchInputAndVerify(dvPackID);
		create_StaticDvPack_WidgetType_SelectOptionSteps.deleteOneItemFromList(dvPackID);
	}

}

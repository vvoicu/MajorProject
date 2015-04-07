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
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.ADM_DvPacks_Listing_GeneralSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Create_DynamicDvPackTable_WidgetTypeSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Create_StaticDvPack_WidgetTypeSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Delete_DvPacksSteps;
import bmo5.bmo5tests.adm.steps.widgets.BusinessRulesWidgetsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Widgets.BusinessRulesWidgets.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_Adm_BusinessRulesWidgets_DvPacks.csv", separator=',')

public class Bmo5_Adm_BusinessRulesWidgets_DvPacks {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public  bmo5.bmo5tests.bmo.steps.LoginSteps bmo5LoginSteps;
	
	@Steps
	public LoginSteps admLoginSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public BusinessRulesWidgetsSteps businessRulesWidgetsSteps;
	
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	
	@Steps
	public SingleArticleSteps singleArticleSteps;
	
	@Steps 
	public ADM_DvPacks_Listing_GeneralSteps adm_DvPacks_listingSteps;
	
	@Steps 
	public Create_DynamicDvPackTable_WidgetTypeSteps create_DynamicDvPackTable_WidgetTypeSteps;
	
	@Steps 
	public Create_StaticDvPack_WidgetTypeSteps create_StaticDvPack_WidgetTypeSteps;
	
	@Steps 
	public Delete_DvPacksSteps delete_DvPacksSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	
	public String bmo5Username,bmo5Password,admUsername, admPassword, name, title, status, refine, contentType, contextType, subContextType,slotsFrom,slotsTo, navCondGeo, navCondService, navCondCat, navCondComp,retOutGeo, retOutService, retOutCat, retOutComp, taggingTypeGeo, taggingTypeService, taggingTypeCategory, taggingTypeCompany, page, widgetType, area,slot,pivotPoint, pivotName, npcSens,cleanupWidget,savedName,widgetId,savedTitle, continent,otherRating, records,deleteWidget,serviceLeftHandFilter,geographyLeftHandFilter,serviceException, articleTypeNumber,serviceOptionToRefine,geographyOptionToRefine, hotTopicsPageNumber, displayOption;
	public String dvPackName, dvPackTitle, dvPackSubtitle, dvPackDescription, dvPackType, dvPackDatabaseType, searchGeography, indicator, tableMessage,  primaryGeography,  primaryChannel,  primaryCompany, dvPackId, ruleTitle, addException;
	public String widgetContainer,extentionXls,formatJpg,formatPng, extentionPng, extentionJpg,	widgetContainerSAR,	widgetContainerPreview,	divsReports,	divsSAR;
	public int itemNumber;
	
   @Test
    public void bmo5_Adm_BusinessRulesWidgets_DvPacks(){
	   loginSteps.performLogin(admUsername,admPassword);
	   menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
	   menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageDVPacks);
	   Sleeper.sleepTight(4000);
	   adm_DvPacks_listingSteps.verifyBreadcrumbsDVPacks();
	   create_DynamicDvPackTable_WidgetTypeSteps.createTemplateDvPackTable(dvPackName, dvPackTitle, dvPackSubtitle, dvPackDescription, dvPackType, dvPackDatabaseType);
	   create_DynamicDvPackTable_WidgetTypeSteps.selectGeography(searchGeography);
	   create_DynamicDvPackTable_WidgetTypeSteps.selectIndicator(indicator);
	   create_DynamicDvPackTable_WidgetTypeSteps.displayTable();
	   Sleeper.sleepTight(2000);
	   create_DynamicDvPackTable_WidgetTypeSteps.saveDvPackTable(dvPackName, dvPackTitle,  tableMessage,  primaryGeography,  primaryChannel,  primaryCompany, searchGeography,  indicator);
	   Sleeper.sleepTight(5000);
       dvPackId = create_DynamicDvPackTable_WidgetTypeSteps.getDVpackID();
		
	   menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
	   menuNavigationSteps.selectMenuItem(AdmMenuItems.BusinessRulesWidgets);
	   businessRulesWidgetsSteps.clickOnBuildNewWidgetButton();
	
	   businessRulesWidgetsSteps.typeWidgetName(name);
	   businessRulesWidgetsSteps.typeWidgetTitle(title);
	   businessRulesWidgetsSteps.selectContentType(contentType);
	   businessRulesWidgetsSteps.selectDisplayOptionForDvPack(displayOption);
	   businessRulesWidgetsSteps.selectStatusRadiobutton(status);
	   businessRulesWidgetsSteps.selectRefineRadiobutton(refine);
	   businessRulesWidgetsSteps.clickOnBuildWidgetButton();
	   businessRulesWidgetsSteps.verifyEditWidgetDvPackPage(name, title, contentType, displayOption);
	   
	   businessRulesWidgetsSteps.clickAddNewRuleLink();
	   businessRulesWidgetsSteps.insertRuleDvPack(ruleTitle, dvPackId);
	   
	   savedName=businessRulesWidgetsSteps.getSavedName();
       savedTitle=businessRulesWidgetsSteps.getSavedTitle();
	   
	   menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageWidgets);
	   manageWidgetsSteps.addWidgetOption();
	   String subPageName =  manageWidgetsSteps.addPageOptionToWidget(page,hotTopicsPageNumber);
	   manageWidgetsSteps.selectTypeFroWidget(widgetType);
	   widgetId=manageWidgetsSteps.selectWidgetName(savedName); 
	   manageWidgetsSteps.selectAreaWidget(area);
	   manageWidgetsSteps.selectNPCWidget(npcSens);
		manageWidgetsSteps.clickOnWidgetCleanup(cleanupWidget);
		if(businessRulesWidgetsSteps.checkSlotsAvailable()){	
		manageWidgetsSteps.addNewWidgetButtonFromForm ();
		manageWidgetsSteps.confirmationMessageWidget();
		menuNavigationSteps.admLogout();
		
		businessRulesWidgetsSteps.navigateTo(Constants.BMO_HOST);
		bmo5LoginSteps.performLogin(bmo5Username, bmo5Password);
		businessRulesWidgetsSteps.clickOnSelectedPageForDvPacksAndMedia(page, subPageName);
	    businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle, widgetContainer);
		businessRulesWidgetsSteps.clickFirstArticleFromWidget(widgetContainer, savedTitle,widgetId, contentType);
		homePageHeaderSteps.verifyBreadCrumbs(dvPackTitle);
		dataToolSteps.verifyIfActionIconsAreEnabled();
		//dataAndForecastingSteps.clickOnDownloadDataTool(extentionXls);
		dataToolSteps.clickOnExportButton();
		dataToolSteps.verifyExportWindowDefaultState();
		dataToolSteps.verifyExportChart(formatJpg, extentionJpg);
		dataToolSteps.verifyExportChart(formatPng, extentionPng);
		dataToolSteps.clickOnTableRadioButton();
		dataToolSteps.verifyExportTable(extentionXls);
		dataToolSteps.clickOnTableAndChartRadioButton();
		dataToolSteps.verifyExportChartAndTable(extentionXls);
		dataToolSteps.clickOnSaveChart();
		bmiDatabasesGeneralSteps.saveNameChart(savedTitle);	
		
		businessRulesWidgetsSteps.navigateTo(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);
		businessRulesWidgetsSteps.selectOptionAndDeleteWidgetByName(savedName, AdmMenuItems.BusinessRulesWidgets);
		
		}
		else{
			System.out.println("No Slots available, skip this test!");
			menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
			businessRulesWidgetsSteps.selectOptionAndDeleteWidgetByName(savedName, AdmMenuItems.BusinessRulesWidgets);
		}
		
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageDVPacks);
		Sleeper.sleepTight(4000);
		adm_DvPacks_listingSteps.verifyBreadcrumbsDVPacks();
		adm_DvPacks_listingSteps.verifyColumnName();
		delete_DvPacksSteps.deleteDvPackById(dvPackId);
   }   
}

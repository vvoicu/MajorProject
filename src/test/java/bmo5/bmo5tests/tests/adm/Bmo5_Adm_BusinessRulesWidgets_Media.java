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
import bmo5.bmo5tests.adm.steps.dvpacks.ADM_DvPacks_Listing_GeneralSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Create_DynamicDvPackTable_WidgetTypeSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Delete_DvPacksSteps;
import bmo5.bmo5tests.adm.steps.widgets.BusinessRulesWidgetsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Widgets.BusinessRulesWidgets.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_Adm_BusinessRulesWidgets_Media.csv", separator=',')

public class Bmo5_Adm_BusinessRulesWidgets_Media{
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
	public Delete_DvPacksSteps delete_DvPacksSteps;
	
	public String bmo5Username,bmo5Password,admUsername, admPassword, name, title, status, refine, contentType, contextType, subContextType,slotsFrom,slotsTo, navCondGeo, navCondService, navCondCat, navCondComp,retOutGeo, retOutService, retOutCat, retOutComp, taggingTypeGeo, taggingTypeService, taggingTypeCategory, taggingTypeCompany, page, widgetType, area,slot,pivotPoint, pivotName, npcSens,cleanupWidget,savedName,widgetId,savedTitle, continent,otherRating, records,deleteWidget,serviceLeftHandFilter,geographyLeftHandFilter,serviceException, articleTypeNumber,serviceOptionToRefine,geographyOptionToRefine, hotTopicsPageNumber, displayOption;
	public String dvPackName, dvPackTitle, dvPackSubtitle, dvPackDescription, dvPackType, dvPackDatabaseType, searchGeography, indicator, tableMessage,  primaryGeography,  primaryChannel,  primaryCompany, dvPackId, ruleTitle, addException, timing, upload;
	public int itemNumber;
	public String widgetContainer,	widgetContainerSAR,	widgetContainerPreview,	divsReports,	divsSAR;
	
   @Test
    public void bmo5_Adm_BusinessRulesWidgets_Media(){
		loginSteps.performLogin(admUsername, admPassword);

		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.BusinessRulesWidgets);
		businessRulesWidgetsSteps.clickOnBuildNewWidgetButton();

		businessRulesWidgetsSteps.typeWidgetName(name);
		businessRulesWidgetsSteps.typeWidgetTitle(title);
		businessRulesWidgetsSteps.selectContentType(contentType);
		businessRulesWidgetsSteps.selectContextType(contextType);
		businessRulesWidgetsSteps.selectStatusRadiobutton(status);
		businessRulesWidgetsSteps.selectRefineRadiobutton(refine);
		businessRulesWidgetsSteps.clickOnBuildWidgetButton();
		businessRulesWidgetsSteps.verifyEditWidgetDvPackPage(name, title,
				contentType, displayOption);

		businessRulesWidgetsSteps.clickAddNewRuleLink();
		businessRulesWidgetsSteps.insertRuleMedia(timing, upload);

		savedName = businessRulesWidgetsSteps.getSavedName();
		savedTitle = businessRulesWidgetsSteps.getSavedTitle();
	   
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageWidgets);
		manageWidgetsSteps.addWidgetOption();
		String subPageName = manageWidgetsSteps.addPageOptionToWidget(page,
				hotTopicsPageNumber);
		manageWidgetsSteps.selectTypeFroWidget(widgetType);
		manageWidgetsSteps.selectWidgetName(savedName);
		manageWidgetsSteps.selectAreaWidget(area);
		manageWidgetsSteps.selectNPCWidget(npcSens);
		manageWidgetsSteps.clickOnWidgetCleanup(cleanupWidget);
		if (businessRulesWidgetsSteps.checkSlotsAvailable()) {
			manageWidgetsSteps.addNewWidgetButtonFromForm();
			manageWidgetsSteps.confirmationMessageWidget();
		menuNavigationSteps.admLogout();
		businessRulesWidgetsSteps.navigateTo(Constants.BMO_HOST);
		bmo5LoginSteps.performLogin(bmo5Username, bmo5Password);
		
		businessRulesWidgetsSteps.clickOnSelectedPageForDvPacksAndMedia(page, subPageName);
		businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInReportsAndSARPages(savedTitle, widgetContainerSAR,divsSAR);
		
		businessRulesWidgetsSteps.navigateTo(Constants.ADM_HOST);
		loginSteps.performLogin(admUsername,admPassword);
		businessRulesWidgetsSteps.selectOptionAndDeleteWidgetByName(savedName, AdmMenuItems.BusinessRulesWidgets);
		}
		else{
			System.out.println("No Slots available, skip this test!");
			menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
			businessRulesWidgetsSteps.selectOptionAndDeleteWidgetByName(savedName, AdmMenuItems.BusinessRulesWidgets);
		}
   }   
}

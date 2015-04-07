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
import bmo5.bmo5tests.adm.steps.widgets.BusinessRulesWidgetsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Navigation.LessEntitlements.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_LessEntitlements_BusinessRulesWidgets.csv", separator = ',')
public class Test_LessEntitlements_BusinessRulesWidgets {
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
	public BusinessRulesWidgetsSteps businessRulesWidgetsSteps;
	
	@Steps ManageWidgetsSteps manageWidgetsSteps;
	
	String bmoUsername, bmoPassword, admUsername,admPassword, name, title, status,analysis,news, refine, contentType, contextType, subContextType,slotsFrom,slotsTo, navCondGeo, navCondService, navCondCat, navCondComp,retOutGeo, retOutService, retOutCat, retOutComp, taggingTypeGeo, taggingTypeService, taggingTypeCategory, taggingTypeCompany, page, widgetType, area,slot,pivotPoint, pivotName, npcSens,cleanupWidget,savedName,widgetId,savedTitle, continent,otherRating, records,deleteWidget,serviceLeftHandFilter,geographyLeftHandFilter,serviceException, articleTypeNumber,serviceOptionToRefine,geographyOptionToRefine, hotTopicsPageNumber,countryId,addException,articleId;
	public int itemNumber;
	boolean foundViewMoreButton;
	public String viewMore,optionId, widgetContainer,reportIssueNumber,widgetContainerSAR,widgetContainerPreview, divsReports,divsSAR;
	
    @Test
    public void test_LessEntitlements_BusinessRulesWidgets(){
	if(deleteWidget.equals("0")){
		//	log.info("Started test"+testNumber);
			admLoginSteps.performLogin(admUsername,admPassword);
			menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
			Sleeper.sleepTight(2000);
			menuNavigationSteps.selectMenuItem(AdmMenuItems.BusinessRulesWidgets);
			Sleeper.sleepTight(2000);
			businessRulesWidgetsSteps.clickOnBuildNewWidgetButton();
			businessRulesWidgetsSteps.selectOptionsForBuildWidget(name,title,contentType, contextType, subContextType, status, refine, viewMore);
			Sleeper.sleepTight(3000);
			businessRulesWidgetsSteps.verifyEditWidgetPage(name,title,contentType,contextType);
			
			businessRulesWidgetsSteps.clickAddNewRuleLink();
			businessRulesWidgetsSteps.typeSlotsFromValue(slotsFrom);
		    businessRulesWidgetsSteps.typeSlotsToValue(slotsTo);	
		    if(contextType.equals("Details")&& !page.contains("Report")){
		    	businessRulesWidgetsSteps.clickArticleType(articleTypeNumber);
		    }
		    
		    businessRulesWidgetsSteps.selectConditions(navCondGeo, navCondService, navCondCat, navCondComp);
	        businessRulesWidgetsSteps.selectReturnedOutputOptions(retOutGeo, retOutService, retOutCat, retOutComp);
	        businessRulesWidgetsSteps.selectTaggingType(taggingTypeGeo, taggingTypeService,taggingTypeCategory, taggingTypeCompany);
	        businessRulesWidgetsSteps.clickAddRuleButton();
	        
	        savedName=businessRulesWidgetsSteps.getSavedName();
	        savedTitle=businessRulesWidgetsSteps.getSavedTitle();
	        
		    if(contextType.equals("General")){
				businessRulesWidgetsSteps.clickOnExceptionsMiniTab();
				businessRulesWidgetsSteps.clickAddNewExceptionButton();
				if(pivotPoint.contains("Industry")&&addException.equals("yes")){
					businessRulesWidgetsSteps.selectServiceExcption(serviceException);
					businessRulesWidgetsSteps.clickOnBuildWidgetButton();
					
				} 
			}
	     
	        menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageWidgets);
	        manageWidgetsSteps.addWidgetOption();
	        String subPageName=	manageWidgetsSteps.addPageOptionToWidget(page,hotTopicsPageNumber);
			manageWidgetsSteps.selectTypeFroWidget(widgetType);
			widgetId=manageWidgetsSteps.selectWidgetName(savedName); 
			manageWidgetsSteps.selectAreaWidget(area);
			manageWidgetsSteps.selectNPCWidget(npcSens);
			manageWidgetsSteps.pivotForWidget(pivotPoint);
			manageWidgetsSteps.selectPivotName(pivotPoint,pivotName);
		//	manageWidgetsSteps.selectSlot(slot);
			manageWidgetsSteps.clickOnWidgetCleanup(cleanupWidget);
		//	boolean slotsAvailable=businessRulesWidgetsSteps.checkSlotsAvailable();
			
			if(businessRulesWidgetsSteps.checkSlotsAvailable()){
			
			manageWidgetsSteps.addNewWidgetButtonFromForm ();
			if(!manageWidgetsSteps.checkAlertIsErrorMessage()){

			manageWidgetsSteps.confirmationMessageWidget();
			menuNavigationSteps.admLogout();
			businessRulesWidgetsSteps.navigateTo(Constants.BMO_HOST);
	        loginSteps.performLogin(bmoUsername, bmoPassword);	
	      //TODO fix this
//			businessRulesWidgetsSteps.clickOnSelectedPage(page,pivotPoint, pivotName, continent, otherRating, analysis,news,itemNumber, contentType,subContextType, serviceLeftHandFilter, geographyLeftHandFilter,subPageName,countryId, articleTypeNumber, articleId,reportIssueNumber);
		
		   if(page.contains("Preview")){
				businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle,widgetContainerPreview);
				if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
					foundViewMoreButton=businessRulesWidgetsSteps.clickViewMoreButton(widgetContainerPreview, savedTitle, contentType, widgetId); 
					if(foundViewMoreButton){
					businessRulesWidgetsSteps.clickOnUnentitledItemFromViewMoreListingAndVerifyIconsDontExistAndModal(contentType);
					businessRulesWidgetsSteps.clickEntitledItemFromViewMorelisting(contentType);
					}
				}
			} 
			
			else if(page.contains("Hot Topics")){
				boolean foundHotTopic =businessRulesWidgetsSteps.checkHotTopicsAvailableOnBmoAndClick(subPageName);
				if(foundHotTopic){
					businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle,widgetContainer);
					if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
						foundViewMoreButton=businessRulesWidgetsSteps.clickViewMoreButton(widgetContainer, savedTitle,contentType,widgetId); 
						if(foundViewMoreButton){
						businessRulesWidgetsSteps.clickOnUnentitledItemFromViewMoreListingAndVerifyIconsDontExistAndModal(contentType);
						businessRulesWidgetsSteps.clickEntitledItemFromViewMorelisting(contentType);
						}
					}
				}
			}
			
			else if(page.equals("Strategic Analysis & Reports")){
				businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInReportsAndSARPages(savedTitle, widgetContainerSAR,divsSAR);
				if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
					foundViewMoreButton=businessRulesWidgetsSteps.clickViewMoreButton(widgetContainerSAR, savedTitle,contentType,widgetId); 
					if(foundViewMoreButton){
					businessRulesWidgetsSteps.clickOnUnentitledItemFromViewMoreListingAndVerifyIconsDontExistAndModal(contentType);
					businessRulesWidgetsSteps.clickEntitledItemFromViewMorelisting(contentType);
					}
				}
			}
			
			else if(page.equals("Reports")^page.equals("Strategic Analysis")){
				businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInReportsAndSARPages(savedTitle, widgetContainerSAR, divsReports);
				if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
					foundViewMoreButton=businessRulesWidgetsSteps.clickViewMoreButton(widgetContainerSAR, savedTitle,contentType,widgetId); 
					if(foundViewMoreButton){
					businessRulesWidgetsSteps.clickOnUnentitledItemFromViewMoreListingAndVerifyIconsDontExistAndModal(contentType);
					businessRulesWidgetsSteps.clickEntitledItemFromViewMorelisting(contentType);
					}
				}
			}
		
			else{
			businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle,widgetContainer);
			if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
				foundViewMoreButton=businessRulesWidgetsSteps.clickViewMoreButton(widgetContainer, savedTitle,contentType,widgetId); 
				if(foundViewMoreButton){
				businessRulesWidgetsSteps.clickOnUnentitledItemFromViewMoreListingAndVerifyIconsDontExistAndModal(contentType);
				businessRulesWidgetsSteps.clickEntitledItemFromViewMorelisting(contentType);
							}
						}
					}

			if(refine.equals("1")){
				if(pivotPoint.equals("Geography")){	
			businessRulesWidgetsSteps.clickServiceFromLeftHandFilter(serviceOptionToRefine);
			if(page.equals("Reports")^page.equals("Strategic Analysis")){
			businessRulesWidgetsSteps.selectRefineOptionForWidget(serviceOptionToRefine, savedTitle, widgetContainerSAR,optionId);
			}
			else if(page.equals("Strategic Analysis & Reports")){
				businessRulesWidgetsSteps.selectRefineOptionForWidget(serviceOptionToRefine, savedTitle, widgetContainerSAR,optionId);
			}
			else
				businessRulesWidgetsSteps.selectRefineOptionForWidget(serviceOptionToRefine, savedTitle, widgetContainer,optionId);
			
	   }
		else if(pivotPoint.equals("Industry")) {
			businessRulesWidgetsSteps.clickContinentFromLeftHandFilter(geographyOptionToRefine);
			if(page.equals("Reports")^page.equals("Strategic Analysis")){
			businessRulesWidgetsSteps.selectRefineOptionForWidget(geographyOptionToRefine, savedTitle, widgetContainerSAR,optionId);
			}
			else if(page.equals("Strategic Analysis & Reports")^page.equals("Strategic Analysis")){
				businessRulesWidgetsSteps.selectRefineOptionForWidget(geographyOptionToRefine, savedTitle, widgetContainerSAR,optionId);
			}
			else
				businessRulesWidgetsSteps.selectRefineOptionForWidget(geographyOptionToRefine, savedTitle, widgetContainer,optionId);
		}
		}
			
//			if(!serviceException.equals("")){
//				businessRulesWidgetsSteps.selectFinancialMartketsTopNav();
//				businessRulesWidgetsSteps.checkIfWidgetIsNotDisplayed(savedTitle);
//			}
			}	
			else{
				System.out.println("Error Mesage displayed");
				Sleeper.sleepTight(2000);
				businessRulesWidgetsSteps.selectOptionAndDeleteWidgetByName(savedName, AdmMenuItems.BusinessRulesWidgets);
				}
				businessRulesWidgetsSteps.navigateTo(Constants.ADM_HOST);
				admLoginSteps.performLogin(admUsername,admPassword);
				businessRulesWidgetsSteps.selectOptionAndDeleteWidgetByName(savedName, AdmMenuItems.BusinessRulesWidgets);
			}
			else{
				System.out.println("No Slots available, skip this test!");
				menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
			    businessRulesWidgetsSteps.selectOptionAndDeleteWidgetByName(savedName, AdmMenuItems.BusinessRulesWidgets);
			}
		//		log.info("No Slots available, skip this test!");
			}	
		
			if(deleteWidget.equals("1"))
		   {
		//		log.info("Started deleting widgets");
			businessRulesWidgetsSteps.navigateTo(Constants.ADM_HOST);
			loginSteps.performLogin(admUsername,admPassword);
			menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		    menuNavigationSteps.selectMenuItem(AdmMenuItems.BusinessRulesWidgets);
			businessRulesWidgetsSteps.recordsPerPageSelect(records);
			businessRulesWidgetsSteps.deleteAllWidgets(name, records); 
		   }	
	}
}

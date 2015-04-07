package bmo5.bmo5tests.tests.adm;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

//import org.apache.log4j.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.widgets.BusinessRulesWidgetsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Widgets.BusinessRulesWidgets.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_ADM_BusinessRulesWidgets.csv", separator=',')
//@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_DeleteBRW.csv", separator=',')

public class Bmo5_Adm_Business_RulesWidgets {
	
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public  bmo5.bmo5tests.bmo.steps.LoginSteps bmo5LoginSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public BusinessRulesWidgetsSteps businessRulesWidgetsSteps;
	
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	
	@Steps
	public SingleArticleSteps singleArticleSteps;
	
	public String testNumber,bmo5Username,bmo5Password,admUsername, admPassword, name, title, status,analysis,news, refine, contentType, contextType, subContextType,slotsFrom,slotsTo, navCondGeo, navCondService, navCondCat, navCondComp,retOutGeo, retOutService, retOutCat, retOutComp, taggingTypeGeo, taggingTypeService, taggingTypeCategory, taggingTypeCompany, page, widgetType, area,slot,pivotPoint, pivotName, npcSens,cleanupWidget,savedName,widgetId,savedTitle, continent,otherRating, records,deleteWidget,serviceLeftHandFilter,geographyLeftHandFilter,serviceException, articleTypeNumber,serviceOptionToRefine,geographyOptionToRefine, hotTopicsPageNumber,countryId,addException,articleId;
	public int itemNumber;
	public String optionId,viewMore, widgetContainer,reportIssueNumber,widgetContainerSAR,widgetContainerPreview, divsReports,divsSAR;

	//   static final Logger log = Logger.getLogger(Bmo5_Adm_Business_RulesWidgets.class);
     @Test
      public void bmo5_ADM_BusinessRulesWidgets(){
	 
	//	PropertyConfigurator.configure("log4j.properties");
	
		if(deleteWidget.equals("0")){
	//	log.info("Started test"+testNumber);
		loginSteps.performLogin(admUsername,admPassword);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		Sleeper.sleepTight(2000);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.BusinessRulesWidgets);
		Sleeper.sleepTight(2000);
		businessRulesWidgetsSteps.clickOnBuildNewWidgetButton();
		businessRulesWidgetsSteps.selectOptionsForBuildWidget(name,title,contentType, contextType, subContextType, status, refine, viewMore);
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
		bmo5LoginSteps.performLogin(bmo5Username, bmo5Password);	
		//TODO fix this
		//		businessRulesWidgetsSteps.clickOnSelectedPage(page,pivotPoint, pivotName, continent, otherRating, analysis,news,itemNumber, contentType,subContextType, serviceLeftHandFilter, geographyLeftHandFilter,subPageName,countryId, articleTypeNumber, articleId,reportIssueNumber);
		
	   if(page.contains("Preview")){
			businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle,widgetContainerPreview);
			//TODO fix this
			//			businessRulesWidgetsSteps.clickDownloadButtonAndVerifyDownloadedReport(widgetContainerPreview, savedTitle, contentType, widgetId);
			if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
				//TODO fix this
				//				businessRulesWidgetsSteps.clickViewMoreButtonAndVerifyIcons(widgetContainerPreview, savedTitle, contentType, widgetId); 
			}
		} 
		
		else if(page.contains("Hot Topics")){
			boolean foundHotTopic =businessRulesWidgetsSteps.checkHotTopicsAvailableOnBmoAndClick(subPageName);
			if(foundHotTopic){
				businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle,widgetContainer);
				//TODO fix this
				//				businessRulesWidgetsSteps.clickDownloadButtonAndVerifyDownloadedReport(widgetContainer, savedTitle, contentType, widgetId);
				if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
					//TODO fix this
//					businessRulesWidgetsSteps.clickViewMoreButtonAndVerifyIcons(widgetContainer, savedTitle,contentType,widgetId); 
				}
			}
		}
		
		else if(page.equals("Strategic Analysis & Reports")){
			businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInReportsAndSARPages(savedTitle, widgetContainerSAR,divsSAR);
			//TODO fix this			businessRulesWidgetsSteps.clickDownloadButtonAndVerifyDownloadedReport(widgetContainerSAR, savedTitle, contentType, widgetId);
			if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
				//TODO fix this				businessRulesWidgetsSteps.clickViewMoreButtonAndVerifyIcons(widgetContainerSAR, savedTitle,contentType,widgetId); 
			}
		}
		
		else if(page.equals("Reports")^page.equals("Strategic Analysis")){
			businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInReportsAndSARPages(savedTitle, widgetContainerSAR, divsReports);
			//TODO fix this			businessRulesWidgetsSteps.clickDownloadButtonAndVerifyDownloadedReport(widgetContainerSAR, savedTitle, contentType, widgetId);
			if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
				//TODO fix this				businessRulesWidgetsSteps.clickViewMoreButtonAndVerifyIcons(widgetContainerSAR, savedTitle,contentType,widgetId); 
			}
		}
	
		else{
		businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle,widgetContainer);
		//TODO fix this	businessRulesWidgetsSteps.clickDownloadButtonAndVerifyDownloadedReport(widgetContainer, savedTitle, contentType, widgetId);
		if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
			//TODO fix this		businessRulesWidgetsSteps.clickViewMoreButtonAndVerifyIcons(widgetContainer, savedTitle,contentType,widgetId); 
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
		
//		if(!serviceException.equals("")){
//			businessRulesWidgetsSteps.selectFinancialMartketsTopNav();
//			businessRulesWidgetsSteps.checkIfWidgetIsNotDisplayed(savedTitle);
//		}
		}	
		else{
			System.out.println("Error Mesage displayed");
			Sleeper.sleepTight(2000);
			businessRulesWidgetsSteps.selectOptionAndDeleteWidgetByName(savedName, AdmMenuItems.BusinessRulesWidgets);
			}
			businessRulesWidgetsSteps.navigateTo(Constants.ADM_HOST);
			loginSteps.performLogin(admUsername,admPassword);
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
		
	//	log.info("Finished test"+testNumber);
   }
	
}

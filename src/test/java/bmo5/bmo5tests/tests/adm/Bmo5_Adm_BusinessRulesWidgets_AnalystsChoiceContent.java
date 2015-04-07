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

import bmo5.bmo5tests.adm.steps.ArticlesManagementSteps;
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
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_Adm_BusinessRulesWidgets_AnalystsChoice.csv", separator=',')

public class Bmo5_Adm_BusinessRulesWidgets_AnalystsChoiceContent {
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
	public ArticlesManagementSteps articlesManagementSteps;
	
	public String admUsername, admPassword,region, channel,records, name, title, contentType, contextType, status,analysis,news, refine, slotsTo, slotsFrom,articleTypeNumber, navCondGeo, navCondService, navCondCat, navCondComp, retOutGeo, retOutService, retOutCat, retOutComp, taggingTypeGeo, taggingTypeService,taggingTypeCategory, taggingTypeCompany, savedName, savedTitle, pivotPoint, addException, serviceException,page,hotTopicsPageNumber;
	public String widgetType,widgetId,deleteWidget, area, npcSens, pivotName, cleanupWidget, bmo5Username, bmo5Password, continent, otherRating,subContextType, serviceLeftHandFilter, geographyLeftHandFilter,subPageName,countryId, articleId, serviceOptionToRefine, geographyOptionToRefine,reportIssueNumber;
	public int number, itemNumber;
	public String viewMore,widgetContainer,optionId,	widgetContainerSAR,	widgetContainerPreview,	divsReports,	divsSAR;
   
	@Test
    public void bmo5_ADM_BusinessRulesWidgets_AnalystChoiceContent(){
		if (deleteWidget.equals("0")) {
			loginSteps.performLogin(admUsername, admPassword);
			// menuNavigationSteps.selectMenuItem(AdmMenuItems.Articles);
			// menuNavigationSteps.selectMenuItem(AdmMenuItems.Management);
			articlesManagementSteps.clickOnArticleManagementFromLeftSidebar();
			Sleeper.sleepTight(5000);
			articlesManagementSteps.selectRegion(region);
			articlesManagementSteps.selectChannel(channel);
			articlesManagementSteps.clickOnSearchButton();
			manageWidgetsSteps.selectRecordsPerPageAndVerify(records);
			articlesManagementSteps.checkArticles(number);

			menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
			menuNavigationSteps
					.selectMenuItem(AdmMenuItems.BusinessRulesWidgets);
			businessRulesWidgetsSteps.clickOnBuildNewWidgetButton();

			businessRulesWidgetsSteps.typeWidgetName(name);
			businessRulesWidgetsSteps.typeWidgetTitle(title);
			businessRulesWidgetsSteps.selectContentType(contentType);
			businessRulesWidgetsSteps.selectContextType(contextType);
			businessRulesWidgetsSteps.selectStatusRadiobutton(status);
			businessRulesWidgetsSteps.selectRefineRadiobutton(refine);
			businessRulesWidgetsSteps.clickOnBuildWidgetButton();
			businessRulesWidgetsSteps.verifyEditWidgetPage(name, title,
					contentType, contextType);

			businessRulesWidgetsSteps.clickAddNewRuleLink();
			businessRulesWidgetsSteps.typeSlotsFromValue(slotsFrom);
		    businessRulesWidgetsSteps.typeSlotsToValue(slotsTo);	
		    
		    if(contextType.equals("Details")){
		    	businessRulesWidgetsSteps.clickArticleType(articleTypeNumber);
		    }
		    
		    businessRulesWidgetsSteps.selectConditions(navCondGeo, navCondService, navCondCat, navCondComp);
	        businessRulesWidgetsSteps.selectReturnedOutputOptions(retOutGeo, retOutService, retOutCat, retOutComp);
	        businessRulesWidgetsSteps.selectTaggingType(taggingTypeGeo, taggingTypeService,taggingTypeCategory, taggingTypeCompany);
	        businessRulesWidgetsSteps.clickAddRuleButton();
	        
	        savedName=businessRulesWidgetsSteps.getSavedName();
	        savedTitle=businessRulesWidgetsSteps.getSavedTitle();
	        
		    if(businessRulesWidgetsSteps.getSavedContextType().equals("General")){
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
			if(businessRulesWidgetsSteps.checkSlotsAvailable()){
			manageWidgetsSteps.addNewWidgetButtonFromForm ();
			manageWidgetsSteps.confirmationMessageWidget();
			menuNavigationSteps.admLogout();
			businessRulesWidgetsSteps.navigateTo(Constants.BMO_HOST);
			bmo5LoginSteps.performLogin(bmo5Username, bmo5Password);
			//TODO fix this
//			businessRulesWidgetsSteps.clickOnSelectedPage(page,pivotPoint, pivotName, continent, otherRating,analysis,news, itemNumber, contentType,subContextType, serviceLeftHandFilter, geographyLeftHandFilter,subPageName,countryId, articleTypeNumber, articleId,reportIssueNumber);
		
	        if(page.contains("Preview")){
				//businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInPreview(savedTitle);
				businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle,widgetContainerPreview);
				if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
					//TODO fix this
					//					businessRulesWidgetsSteps.clickViewMoreButtonAndVerifyIcons(widgetContainerPreview, savedTitle, contentType,widgetId); 
				}
			}else if(page.contains("Hot Topics")){
				boolean foundHotTopic =businessRulesWidgetsSteps.checkHotTopicsAvailableOnBmoAndClick(subPageName);
				if(foundHotTopic){
					//businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInRatingsExplorationPageAndDetails(savedTitle);
					businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle,widgetContainer);
					if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
						//TODO fix this
						//						businessRulesWidgetsSteps.clickViewMoreButtonAndVerifyIcons(widgetContainer, savedTitle,contentType,widgetId); 
					}
				}
			}else if(page.equals("Strategic Analysis & Reports")){
				businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInReportsAndSARPages(savedTitle, widgetContainerSAR,divsSAR);
				if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
					//TODO fix this					businessRulesWidgetsSteps.clickViewMoreButtonAndVerifyIcons(widgetContainerSAR, savedTitle,contentType,widgetId); 
				}
			}
			
			else if(page.equals("Reports")^page.equals("Strategic Analysis")){
				businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInReportsAndSARPages(savedTitle, widgetContainerSAR, divsReports);
				if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
					//TODO fix this
					//					businessRulesWidgetsSteps.clickViewMoreButtonAndVerifyIcons(widgetContainerSAR, savedTitle,contentType,widgetId); 
				}
			}
		
			else{
			businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle, widgetContainer);
			if(viewMore.equals("1")&&(Integer.parseInt(slotsTo)-Integer.parseInt(slotsFrom)>=5)){
				//TODO fix this
				//			businessRulesWidgetsSteps.clickViewMoreButtonAndVerifyIcons(widgetContainer, savedTitle,contentType,widgetId); 
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
			else if(page.equals("Strategic Analysis & Reports")){
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
			
			businessRulesWidgetsSteps.navigateTo(Constants.ADM_HOST);
			admLoginSteps.performLogin(admUsername,admPassword);
			businessRulesWidgetsSteps.selectOptionAndDeleteWidgetByName(savedName, AdmMenuItems.BusinessRulesWidgets);
			}
			else{
				System.out.println("No Slots available, skip this test!");
				menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
			    businessRulesWidgetsSteps.selectOptionAndDeleteWidgetByName(savedName, AdmMenuItems.BusinessRulesWidgets);
			}
			
			}
			if(deleteWidget.equals("1"))
		   {
			businessRulesWidgetsSteps.navigateTo(Constants.ADM_HOST);
			loginSteps.performLogin(admUsername,admPassword);
			menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		    menuNavigationSteps.selectMenuItem(AdmMenuItems.BusinessRulesWidgets);
			businessRulesWidgetsSteps.recordsPerPageSelect(records);
			businessRulesWidgetsSteps.deleteAllWidgets(name, records); 
		   }
	   }
}

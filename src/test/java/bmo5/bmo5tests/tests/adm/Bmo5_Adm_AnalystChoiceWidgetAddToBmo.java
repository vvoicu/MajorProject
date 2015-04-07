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
import bmo5.bmo5tests.adm.steps.widgets.AnalystsChoiceSteps;
import bmo5.bmo5tests.adm.steps.widgets.BusinessRulesWidgetsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;
import bmo5.bmo5tests.tools.adm.SelectEnums.WidgetSelect;

@Story(Application.Adm.Widgets.BusinessRulesWidgets.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_Adm_AnalystChoiceAddToBmo.csv", separator=',')

public class Bmo5_Adm_AnalystChoiceWidgetAddToBmo {
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
	public AnalystsChoiceSteps analystsChoiseSteps;
	@Steps
	public BusinessRulesWidgetsSteps businessRulesWidgetsSteps;
	@Steps
	public  bmo5.bmo5tests.bmo.steps.LoginSteps bmo5LoginSteps;
	
	public String admUsername,caption, name,title,admPassword, bmo5Username, bmo5Password,widgetType,articleId,reportId,saId,analysis,news,	page,	area,	pivotPoint,	npcSens,subContextType,	cleanupWidget,	records,	deleteWidget,	hotTopicsPageNumber,articleTypeNumber,		pivotName,	serviceLeftHandFilter,	countryId,	geographyLeftHandFilter,	continent,	slot,	contentID,	embeddedCode, contentType, otherRating,reportIssueNumber;
	public int  articleNumber, itemNumber;
	public String widgetContainer,	widgetContainerSAR,	widgetContainerPreview,	divsReports,	divsSAR, widgetId;
	
	@Test
	public void bmo5_Adm_AnalystChoiceWidgetAddToBmo(){
		admLoginSteps.performLogin(admUsername,admPassword);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		//menuNavigationSteps.selectMenuItem(AdmMenuItems.Analyst);
		menuNavigationSteps.selectAnalystsChoise(WidgetSelect.Analyst);
		Sleeper.sleepTight(5000);
		analystsChoiseSteps.clickOnAddNewWindgetButtonListingPage();
		analystsChoiseSteps.createAnalystChoice(name, title, caption, contentType);
		
		if (contentType.equals("Video")) {
		analystsChoiseSteps.clickOnAddNewRowVideoButton();
	    analystsChoiseSteps.completeEmbeddedCodeForVideoWithValidDataClickOnSaveAndVerify(embeddedCode);
		}
		else{
		analystsChoiseSteps.clickOnAddNewRowButton();
		
		if(contentType.equals("Articles")){
		analystsChoiseSteps.completeArticleIDWithValidDataSaveAndVerify(articleId);
		}
		
		if(contentType.equals("Reports")){
		analystsChoiseSteps.completeArticleIDWithValidDataSaveAndVerify(reportId);
		}
		
		if(contentType.equals("Strategic Analysis")){
			analystsChoiseSteps.completeArticleIDWithValidDataSaveAndVerify(saId);
		}
		
		}
		String savedName=analystsChoiseSteps.getSavedName();
		String savedTitle=analystsChoiseSteps.getSavedTitle();
		
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageWidgets);
		Sleeper.sleepTight(5000);
		manageWidgetsSteps.addWidgetOption();
		String subPageName = manageWidgetsSteps.addPageOptionToWidget(page,
				hotTopicsPageNumber);
		manageWidgetsSteps.selectTypeFroWidget(widgetType+"s");
		widgetId=manageWidgetsSteps.selectWidgetName(savedName);
		manageWidgetsSteps.selectAreaWidget(area);
		manageWidgetsSteps.selectNPCWidget(npcSens);
		manageWidgetsSteps.pivotForWidget(pivotPoint);
		manageWidgetsSteps.selectPivotName(pivotPoint, pivotName);
		// manageWidgetsSteps.selectSlot(slot);
		manageWidgetsSteps.clickOnWidgetCleanup(cleanupWidget);
		boolean slotsAvailable=businessRulesWidgetsSteps.checkSlotsAvailable();
		if (slotsAvailable) {
			manageWidgetsSteps.addNewWidgetButtonFromForm();
			if(!manageWidgetsSteps.checkAlertIsErrorMessage()){
			manageWidgetsSteps.confirmationMessageWidget();	
			menuNavigationSteps.admLogout();
			businessRulesWidgetsSteps.navigateTo(Constants.BMO_HOST);
			bmo5LoginSteps.performLogin(bmo5Username, bmo5Password);	
			//TODO fix this
			//	businessRulesWidgetsSteps.clickOnSelectedPage(page,pivotPoint, pivotName, continent, otherRating,analysis,news,itemNumber, contentType,subContextType, serviceLeftHandFilter, geographyLeftHandFilter,subPageName,countryId, articleTypeNumber, articleId,reportIssueNumber);
		
		 if(page.contains("Hot Topics")){
				boolean foundHotTopic =businessRulesWidgetsSteps.checkHotTopicsAvailableOnBmoAndClick(subPageName);
				if(foundHotTopic){
					//businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInRatingsExplorationPageAndDetails(savedTitle);
					businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle,widgetContainer);
				}
			}
			
			else if(page.equals("Strategic Analysis & Reports")){
				businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInReportsAndSARPages(savedTitle, widgetContainerSAR,divsSAR);
			}
			
			else if(page.equals("Reports")^page.equals("Strategic Analysis")){
				businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInReportsAndSARPages(savedTitle, widgetContainerSAR, divsReports);
			}
		
			else{
			businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle,widgetContainer);
				}
			}
			else{
			System.out.println("Error Mesage displayed");
			Sleeper.sleepTight(2000);
			businessRulesWidgetsSteps.selectOptionAndDeleteWidgetByName(savedName, AdmMenuItems.Analyst);
			}
			businessRulesWidgetsSteps.navigateTo(Constants.ADM_HOST);
			admLoginSteps.performLogin(admUsername,admPassword);
			businessRulesWidgetsSteps.selectOptionAndDeleteWidgetByName(savedName, AdmMenuItems.Analyst);
		}
		else{
			System.out.println("No slots available");
			Sleeper.sleepTight(2000);
			menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		    businessRulesWidgetsSteps.selectOptionAndDeleteWidgetByName(savedName, AdmMenuItems.Analyst);
		}
	}
}
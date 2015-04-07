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
import bmo5.bmo5tests.adm.steps.widgets.AnalystsChoiceSteps;
import bmo5.bmo5tests.adm.steps.widgets.HotTopicsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;
import bmo5.bmo5tests.tools.adm.SelectEnums.WidgetSelect;

@Story(Application.Adm.Widgets.AnalystsChoice.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_043_2_ADM_Widgets_AnalystsChoice_New.csv", separator=',')

public class Bmo5_043_2_Adm_Widgets_Analysts_Choice_New extends TestCase {
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
	public HotTopicsSteps hotTopicsSteps;
	
	public String username, password, widgetName, title, caption, invalidArticleID, inexistingArticleID, articleIDOne, articleIDTwo, embeddedCode, invalidEmbeddedCode, nameTwo, titleTwo, content, videoContent, itemsPerPageOne, newTitle, widgetVideoName, contentTypeOne, contentTypeTwo, addNewAnalystsChoiceBreadcrumbs, editAnalystsChoiceBreadcrumbs;
	public int  articleNumber;
	
	@Test
	public void bmo5_043_2_Adm_Widgets_Analysts_Choice_New(){
		admLoginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		//menuNavigationSteps.selectMenuItem(AdmMenuItems.Analyst);
		menuNavigationSteps.selectAnalystsChoise(WidgetSelect.Analyst);
		analystsChoiseSteps.clickOnAddNewWindgetButtonListingPage();
		menuNavigationSteps.verifyBreadCrumb(addNewAnalystsChoiceBreadcrumbs);
		analystsChoiseSteps.submitWithoutCompletingAnyField();
		analystsChoiseSteps.completeAllFieldsWithSpacesSubmitAndVerify();
		analystsChoiseSteps.completeFieldsWithValidDataClickOnResetLinkAndVerify(widgetName, title, caption, contentTypeOne);
		analystsChoiseSteps.completeFieldsWithValidDataSubmitAndVerify(widgetName, title, caption, contentTypeOne);
		analystsChoiseSteps.clickOnAddNewRowButton();
		analystsChoiseSteps.clickOnSaveButtonWithoutCompleteTheArticleIDBox();
		analystsChoiseSteps.completeArticleIdWithInvalidDataClickOnSaveButtonAndVerify(invalidArticleID);
		analystsChoiseSteps.completeArticleIDWitInexistingValueClickOnSaveButtonAndVerify(inexistingArticleID);
		analystsChoiseSteps.completeArticleIDWithValidDataSaveAndVerify(articleIDOne);
		analystsChoiseSteps.clickOnAddNewRowButton();
		analystsChoiseSteps.completeArticleIDWithValidDataSaveAndVerify(articleIDTwo);
		analystsChoiseSteps.removeArticle(articleNumber);
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
		analystsChoiseSteps.clickOnListViewButton();
		analystsChoiseSteps.clickOnAddNewWindgetButtonListingPage();
		analystsChoiseSteps.completeFieldsWithValidDataSubmitAndVerify(nameTwo, titleTwo, caption, contentTypeTwo);
		analystsChoiseSteps.clickOnAddNewRowVideoButton();
		analystsChoiseSteps.clickOnSaveButtonWithoutCompleteTheEmbeddedCodeForVideo();
		analystsChoiseSteps.clickOnAddNewRowVideoButton();
//		analystsChoiseSteps.completeEmbeddedCodeForVideoIdWithInvalidDataClickOnSaveButtonAndVerify(invalidEmbeddedCode);
		analystsChoiseSteps.completeEmbeddedCodeForVideoWithValidDataClickOnSaveAndVerify(embeddedCode);
		
		menuNavigationSteps.selectAnalystsChoise(WidgetSelect.Analyst);
		
		Sleeper.sleepTight(2000);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPageOne);
		analystsChoiseSteps.clickOnOneItemFromListing(widgetName);
		Sleeper.sleepTight(3000);
		menuNavigationSteps.verifyBreadCrumb(editAnalystsChoiceBreadcrumbs);
		analystsChoiseSteps.editTitle(newTitle);
		analystsChoiseSteps.clickOnAddNewRowButton();
		analystsChoiseSteps.clickOnSaveButtonWithoutCompleteTheArticleIDBox();
		analystsChoiseSteps.completeArticleIdWithInvalidDataClickOnSaveButtonAndVerify(invalidArticleID);
		analystsChoiseSteps.completeArticleIDWitInexistingValueClickOnSaveButtonAndVerify(inexistingArticleID);
		analystsChoiseSteps.completeArticleIDWithValidDataSaveAndVerify(articleIDOne);
		analystsChoiseSteps.clickOnAddNewRowButton();
		analystsChoiseSteps.completeArticleIDWithValidDataSaveAndVerify(articleIDTwo);
		analystsChoiseSteps.removeArticle(articleNumber);
		analystsChoiseSteps.editWidgetEmptyFieldsSaveAndVerify();
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
		analystsChoiseSteps.clickOnListViewButton();
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPageOne);
		analystsChoiseSteps.deleteOneItemFromListing(widgetName);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPageOne);
		analystsChoiseSteps.deleteOneItemFromListing(widgetVideoName);
	}
}

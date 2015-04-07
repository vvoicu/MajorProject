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
import bmo5.bmo5tests.adm.steps.widgets.HotTopicsSteps;
import bmo5.bmo5tests.adm.steps.widgets.KeyGlobalViewsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Widgets.HotTopics.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_042_2_ADM_Widgets_HotTopics_New.csv", separator=',')

public class Bmo5_042_2_Adm_Widgets_Hot_Topics_New extends TestCase {
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
	public HotTopicsSteps hotTopicsSteps;
	@Steps
	public KeyGlobalViewsSteps keyGlobalViewsSteps;
	
	public String username, password, widgetName, title, caption, invalidStartDate, invalidEndDate, startDate, endDate, invalidArticleID, inexistingArticleID, articleID, bmoHeadline, newbmoHeadline, newName, newTitle, newStartDate, newEndDate, hotTopic, itemsPerPageOne, hotTopicsBreadcrumbs, editHotTopicsBreadcrumbs;

	@Test
	public void bmo5_042_2_ADM_Widgets_HotTopics_New(){
		admLoginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.HotTopics);
		menuNavigationSteps.verifyBreadCrumb(hotTopicsBreadcrumbs);
		hotTopicsSteps.clickOnNewHotTopicButton();
		hotTopicsSteps.clickOnAddButtonWithoutCompletingAnyField();
		hotTopicsSteps.clickOnAddButtonAfterTheFieldsAreCompletedWithSpaces();
		hotTopicsSteps.completeStartAndDateWithInvalidDataClickOnAddAndVerify(widgetName, title, caption, invalidStartDate, invalidEndDate);
		hotTopicsSteps.clickOnResetButtonAndVerify();
		hotTopicsSteps.addANewHotTopicWidgetAndVerify(widgetName, title, caption, startDate, endDate);
		hotTopicsSteps.clickOnAddNewRowButtonWithoutCompletingAnyField();
		hotTopicsSteps.completeWithInvalidArticleIDAndClickOnSaveButton(invalidArticleID, bmoHeadline);
		hotTopicsSteps.completeWithInexistingArticleIDAndClickOnSaveButton(inexistingArticleID, bmoHeadline);
		hotTopicsSteps.submitWithBlankBMOHeadline(articleID);
		hotTopicsSteps. addANewArticleToTheHotTopicWidget(articleID, bmoHeadline);
		keyGlobalViewsSteps.editOneItemFromListing(bmoHeadline, newbmoHeadline);
		hotTopicsSteps.removeFirstArticleFromList();
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
//		hotTopicsSteps.verifyHelpModalWindowAbsence();
		hotTopicsSteps.clickOnListViewButtonAndVerify();
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPageOne);
		hotTopicsSteps.clickOnOneHotTopicFromListing(hotTopic);
		menuNavigationSteps.verifyBreadCrumb(editHotTopicsBreadcrumbs);
		hotTopicsSteps.clearAllFieldsClickOnSaveButtonAndVerify();
		hotTopicsSteps.editWidgetPageResetFields(newName, newTitle, newStartDate, newEndDate);
		hotTopicsSteps.editWidgetCompleteFieldsAndSave(newName, newTitle, newStartDate, newEndDate);
		hotTopicsSteps.addANewArticleToTheHotTopicWidget(articleID, bmoHeadline);
		hotTopicsSteps.removeFirstArticleFromList(); // Not sure//Cannot access any hot topic
		hotTopicsSteps.clickOnSaveWidgetButtonAndVerify();
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
//		hotTopicsSteps.verifyHelpModalWindowAbsence();
		hotTopicsSteps.clickOnListViewButtonAndVerify();
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPageOne);
		hotTopicsSteps.removeHotTopic(hotTopic); 
	}
}

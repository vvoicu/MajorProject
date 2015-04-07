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

@Story(Application.Adm.Widgets.KeyGlobalViews.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_044_ADM_Widgets_KeyGlobalViews.csv", separator=',')

public class Bmo5_044_Adm_Widgets_Key_Global_Views extends TestCase {
	
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
	public KeyGlobalViewsSteps keyGlobalViewsSteps;
	@Steps
	public HotTopicsSteps hotTopicsSteps;
	
	public String username, password, articleID, invalidArticleID, inexistingArticleID, headlineText, itemName, keyGlobalViewsBreadcrumbs;
	int itemNumber;
	
	@Test
	public void bmo5_044_Adm_Widgets_Key_Global_Views(){
		admLoginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.KeyGlobalViews);
		menuNavigationSteps.verifyBreadCrumb(keyGlobalViewsBreadcrumbs);
		keyGlobalViewsSteps.clickOnUpdateButtonWithoutCompletingAnyFieldAndVerify();
		keyGlobalViewsSteps.addANewRowWithInvalidArticleIDAndVerify(invalidArticleID, headlineText);
		keyGlobalViewsSteps.addANewRowWithInexistingArticleIDAndVerify(inexistingArticleID, headlineText);
		keyGlobalViewsSteps.addNewRowWithoutCompletingHeadlineAndVerify(articleID);
		keyGlobalViewsSteps.cancelAddingANewRowAndVerify();
		keyGlobalViewsSteps.addANewRowAndVerify(articleID, headlineText);
		keyGlobalViewsSteps.editOneItemFromListing(headlineText, itemName);
		keyGlobalViewsSteps.removeOneItemFromListing(itemName);
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
	}
}

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
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Widgets.HotTopics.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_042_1_ADM_Widgets_HotTopics.csv", separator=',')

public class Bmo5_042_1_Adm_Widgets_Hot_Topics extends TestCase {
	
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
	
	public String username, password, itemsPerPageOne, itemsPerPageTwo, searchInput, itemsPerPageThree, hotTopicsBreadcrumbs;
	
	@Test
	public void bmo5_042_1_Adm_Widgets_Hot_Topics(){
		admLoginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.HotTopics);
		menuNavigationSteps.verifyBreadCrumb(hotTopicsBreadcrumbs);
		manageWidgetsSteps.navigatePagesAndVerify();
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPageOne);
		hotTopicsSteps.verifyTableColumns();
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPageTwo);
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
//		hotTopicsSteps.verifyHelpModalWindowAbsence();
		manageWidgetsSteps.searchInputAndVerify(searchInput);
	}
}

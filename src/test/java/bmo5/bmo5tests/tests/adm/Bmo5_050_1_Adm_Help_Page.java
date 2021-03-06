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
import bmo5.bmo5tests.adm.steps.systemalerts.HelpSteps;
import bmo5.bmo5tests.adm.steps.widgets.HotTopicsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.SystemAlerts.Help.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_050_1_ADM_HelpPage.csv", separator = ',')

public class Bmo5_050_1_Adm_Help_Page extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;

	//ADM steps
	@Steps
	public LoginSteps admLoginSteps;
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	@Steps
	public HelpSteps helpSteps;
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	
	//BMO steps
	@Steps
	public bmo5.bmo5tests.bmo.steps.LoginSteps bmoLoginSteps;
	@Steps
	public HomePageHeaderSteps homeSteps;
	@Steps
	public HotTopicsSteps hotTopicsSteps;

	public String username, password, recordsOne, recordsTwo, recordsThree, recordsFour ,recordsFive, recordsSix, helpBreadcrumbs;
	
	@Test
	public void bmo5_050_1_Adm_Help_Page(){
		admLoginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.SystemAlerts);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Help);
		menuNavigationSteps.verifyBreadCrumb(helpBreadcrumbs);
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordsTwo);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordsThree);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordsFour);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordsFive);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordsSix);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordsOne);
		manageWidgetsSteps.navigatePagesAndVerify();
		helpSteps.verifyTableColumns();
	}
}

package bmo5.bmo5tests.tests.bmo;


import junit.framework.TestCase;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.adm.steps.ClientAccountsSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.MncMdgSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FooterSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Mnc.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_051_1_Mnc_HomePage.csv", separator=',')

public class Test_051_1_Mnc_Home_Page  extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	@Steps
	public bmo5.bmo5tests.adm.steps.LoginSteps admLoginSteps;

	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;

	@Steps
	public MncMdgSteps mnc_MDG_Steps;

	@Steps
	public FooterSteps footerSteps;

	@Steps
	public ClientAccountsSteps clientAccountSteps;

	@Steps
	public MenuNavigationSteps menuNavigationSteps;

	@Qualifier
	public String getQualifier() {
		return breadcrumbName;
	}

	String username, password,breadcrumb,breadcrumbName,terms,helpName,updates,total,contact,record,career,logout,account,webinar;
	String admUsername, admPassword,email;

	@Test
	public void test_051_1_Mnc_HomePage() {
		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);

		menuNavigationSteps.selectMenuItem(AdmMenuItems.AccountManagement);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ClientAccounts);
		clientAccountSteps.performSearch(email);
		clientAccountSteps.selectAdvancedSettings();
		clientAccountSteps.deselectUserType();
		clientAccountSteps.selectMNC();
		clientAccountSteps.saveAdvancedSettings();

		loginSteps.getDriver().get(Constants.BMO_HOST);
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.verifyHeaderpresence();
		homePageHeaderSteps.verifyHeaderIcons(helpName,updates,total);
		mnc_MDG_Steps.selecBimoAccount(logout,account);
		homePageHeaderSteps.clickOnLogo();
		Sleeper.sleepTight(3000);
		mnc_MDG_Steps.verifyBreadCrumb(breadcrumbName);
		mnc_MDG_Steps.selectWebinarsAndPodcasts(webinar);
		Sleeper.sleepTight(3000);
		mnc_MDG_Steps.verifyWebinarsBreadcrumb(breadcrumb);
		footerSteps.selectFooterElements(terms,contact,record,career);

		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);

		clientAccountSteps.deselectUserType();
		clientAccountSteps.selectMyPreferences();
		clientAccountSteps.saveAdvancedSettings();
	}

}

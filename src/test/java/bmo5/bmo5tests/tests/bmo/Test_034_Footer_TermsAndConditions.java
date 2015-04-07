package bmo5.bmo5tests.tests.bmo;


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

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FooterSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.Footer.TermsAndConditions.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_034_Footer_TermsAndConditions.csv", separator = ',')

public class Test_034_Footer_TermsAndConditions extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public FooterSteps footerSteps;
	
	@Steps
	public HomePageHeaderSteps  homePageHeaderSteps;
	
	public String username, password,terms,breadcrumb,privacy;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Test
	public void test_034_Footer_TermsAndConditions() {
		loginSteps.performLogin(username, password);
		footerSteps.verifyTermsAndCOnditionsPresenceOnFooter();
		footerSteps.clickOnTermsAndConditions(terms);
		footerSteps.verifyBreadCrumbs(breadcrumb);
		footerSteps.verifyTitleName();
		Sleeper.sleepTight(2000);
		footerSteps.verifyLeftPanelTerms(terms, privacy);
		footerSteps.verifyPrivacyPolicyInLeftFilter(privacy);
	}
	
}
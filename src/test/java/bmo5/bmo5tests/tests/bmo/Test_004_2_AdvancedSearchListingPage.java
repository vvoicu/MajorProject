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

import bmo5.bmo5tests.bmo.steps.AdvancedSearchSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.SearchSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.SpecialReportsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Header.AdvancedSearch.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_004_2_AdvancedSearchListingPage.csv", separator=',')


public class Test_004_2_AdvancedSearchListingPage extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageHeaderSteps homeSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public AdvancedSearchSteps advancedSearchSteps;
	@Steps
	public SearchSteps searchSteps;
	@Steps
	public SpecialReportsSteps specialReportsSteps;

	public String username, breadcrumbString, password;
	int articleNumber;
	
	@Test
	public void test_004_2_AdvancedSearchListingPage() {
		loginSteps.performLogin(username, password);
		homeSteps.advancedSearch();
		advancedSearchSteps.checkNonSubscribedContentBox();
		searchSteps.verifyBreadcrumbs(breadcrumbString);
		searchSteps.verifyNonSubscribedContentIsChecked();
		searchSteps.clickOnNonPermissionArticleAndClickOnCancel(articleNumber);
		searchSteps.clickOnNonPermissionArticleAndClickOnContactAccountManagerButton(articleNumber);
	}
}

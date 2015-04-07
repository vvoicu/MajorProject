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

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

/**
 * Three pillars navigation tabs
 * 
 * @Test:
 * 
 *        1. Mouse over the main tabs
 * 
 *        2. Click on each tab and sub-tab and verify breadcrumbs
 * 
 */

@Story(Application.HomePage.Pillars.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_011_ThreePillarNavigationTabs.csv", separator = ',')

public class Test_011_ThreePillarNavigationTabs extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;

	public String username, password, dailyViews, breadcrumb, dailyViewsBreadcrumbs, analysisBreadcrumbs, nwesBreadcrumbs, reportsAndStrategicContentBreadcrumbs, reportsBreadcrumbs, reportsArchiveBreadcrumbs, dataAndForecastingBreadcrumbs, dataToolBreadcrumbs, ratingsBreadcrumbs, bmiDatabasesBreadcrumbs;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Test
	public void test_011_ThreePillarNavigationTabs() {
		loginSteps.performLogin(username, password);		
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dailyViewsBreadcrumbs);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(analysisBreadcrumbs);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(nwesBreadcrumbs);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsAndStrategicContentBreadcrumbs);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(breadcrumb);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsBreadcrumbs);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsArchiveBreadcrumbs);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dataAndForecastingBreadcrumbs);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dataToolBreadcrumbs);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(ratingsBreadcrumbs);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
	}	
	
}

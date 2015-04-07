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
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.ReportsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.ReportsAndStrategicContent.Reports.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_023_5_Reports_GeographyPivotPoint.csv", separator=',')

public class Test_023_5_Reports_GeographyPivotPoint extends TestCase {
	
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public ReportsSteps reportsSteps;
	@Steps
	public DailyAnalysisAndNewsSteps dailyAnalysisAndNewsSteps;
	
	
	public String username, password, continent, country, service,breadcrumb,geographyTop,news,clear,all;
	
	@Test
	public void test_023_5_StrategicAnalysisAndReports_Reports_GeographyPivotPoint() {
		loginSteps.performLogin(username, password);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(breadcrumb);
		homePageTopMenuSteps.clickOnGeography(geographyTop,continent,country);
		homePageTopMenuSteps.verifyGeoPivotBr(country);
		reportsSteps.clickServiceGeographyToColapseExpandFromPanel();
		Sleeper.sleepTight(10000);
		reportsSteps.chooseAServiceFromLeftPanel(service);
		Sleeper.sleepTight(10000);
		reportsSteps. clearFilter(clear,all);
		reportsSteps.verifyBreadCrumb(breadcrumb);
		
		dailyAnalysisAndNewsSteps.clickNewsTab(news);
		reportsSteps.verifyBreadCrumb(news);
	}
}
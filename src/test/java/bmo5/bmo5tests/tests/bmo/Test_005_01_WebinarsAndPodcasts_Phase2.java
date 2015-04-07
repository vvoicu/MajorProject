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

import bmo5.bmo5tests.bmo.steps.HotTopicArticleSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.WebinarsAndPodcastsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.HomePageTopMenu.WebinarsAndPodcasts.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_005_01_WebinarsAndPodcasts_Phase2.csv", separator=',')

public class Test_005_01_WebinarsAndPodcasts_Phase2 extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public DailyAnalysisAndNewsSteps dailyAnalysisAndNewsSteps;
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	@Steps
	public SingleArticleSteps singleArticleSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Steps
	public HomePageLevelOneSteps homePageLevelOneSteps;
	
	@Steps
	public WebinarsAndPodcastsSteps webinarsAndPodcastsSteps;
	
	@Steps
	public HotTopicArticleSteps hotTopicsArticleSteps;
	
	public String username, password, widgetName, breadcrumbsWP;
	
	private int widgetNumber, serviceNumber, geographyNumber;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setWidgetNumber(int widgetNumber) {
		this.widgetNumber = widgetNumber;
	}
	
	public void setServiceNumber(int serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	
	public void setGeographyNumber(int geographyNumber) {
		this.geographyNumber = geographyNumber;
	}
	
	@Test
	public void test_005_01_WebinarsAndPodcasts_Phase2() {
		loginSteps.performLogin(username, password);
		homePageLevelOneSteps.clickOnPreviewWebinarOrPodcastFromDropDownList();
		homePageLevelOneSteps.clickOnViewAllWidgetsAndPodcastsLink();
		webinarsAndPodcastsSteps.clickOnAGeography(geographyNumber);
		webinarsAndPodcastsSteps.clickOnTheServiceToggler();
		webinarsAndPodcastsSteps.clickOnAService(serviceNumber);
		widgetName = webinarsAndPodcastsSteps.clickOnAWebinarOrPodcast(widgetNumber);
		//TODO fix this
//		webinarsAndPodcastsSteps.verifyWebinarBreadcrumb(widgetName);
//		webinarsAndPodcastsSteps.verifyTitle(widgetName);
		webinarsAndPodcastsSteps.clickOnBackToPreviousPage(); //verify the data from the left hand filters(not implemented yet)
		//TODO fix this
//		webinarsAndPodcastsSteps.verifyBreadcrumbs(breadcrumbsWP);
		homePageTopMenuSteps.clickOnTheHomeBreadcrumb();
		homePageLevelOneSteps.verifyHomePage();
	}
}

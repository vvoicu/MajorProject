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
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelSpecialRepSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomeSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_029_Homepage.csv", separator=',')

public class Test_029_Homepage extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public HomeSteps homeSteps;
	@Steps
	public FilterPanelSpecialRepSteps filterPanelSpecialRepSteps;

	
	public String username, password, threeCharacters, saveTitle, word, itemsPerPage, startDate, endDate, startDateGrater, endDateSmaller, invalidStartDate, invalidEndDate,keyViews,keyForecasts,hotTopic,specialReport,webinars;
	int geographyNumber, channelNumber, categoryNumber, companyNumber,dotValue;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Test
	public void test_029_Homepage() {
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnLogo();
		homeSteps.carouselMouseOver(dotValue) ;
		homeSteps.keyGlobalSelectArticle();
		homeSteps.exploreKeyForecasts();
		homeSteps.viewAllHotTopics();
		homePageHeaderSteps.clickOnLogo();
		homeSteps.viewAllSpecialReports();
		homePageHeaderSteps.clickOnLogo();
		homeSteps.viewAllWebinarsAndPodcasts();
		filterPanelSpecialRepSteps.clickHome();
		homeSteps.verifyHomePageTitlePresenceOfButtons(keyViews,keyForecasts,hotTopic,specialReport,webinars);
		
		
	}
}
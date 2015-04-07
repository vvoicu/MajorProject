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

import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.widgets.EventsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.WebinarsAndPodcastsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomeSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.HomePage.HomePageTopMenu.WebinarsAndPodcasts.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_048_3_Bmo_Events.csv", separator=',')

public class Test_048_3_BmoEvents extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public HomeSteps homeSteps;
	@Steps
	public WebinarsAndPodcastsSteps webinarsAndPodcastsSteps;
	@Steps
	public bmo5.bmo5tests.adm.steps.LoginSteps admLoginSteps;
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	@Steps
	public EventsSteps eventsSteps;
	
	public String username, password, threeCharacters, saveTitle, word, itemsPerPage, startDate, endDate, startDateGrater, endDateSmaller, invalidStartDate, invalidEndDate;
	int geographyNumber, channelNumber, categoryNumber, companyNumber;
	String title, caption,admUsername, admPassword,location,startTime,endTime;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Test
	public void test_048_3_Bmo_Events() {
		
		
		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Events);
		eventsSteps.clickOnAddANewEventButton();
		eventsSteps.completeAllFieldsWithValidDataAndVerify(title, caption, startDate, startTime, endDate, endTime, location);
		
		loginSteps.getDriver().get(Constants.BMO_HOST);
		loginSteps.performLogin(username, password);	
		homePageTopMenuSteps.clickOnWebinarsAndPodcastsViewAll();
	//	webinarsAndPodcastsSteps.webinarsAddToCalendar(); // the event was added in ADM and after that accessed in bmouat5
	}
}
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

import bmo5.bmo5tests.bmo.steps.HotTopicArticleSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.PreviewArticleWindowSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelTwoSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomeSteps;
import bmo5.bmo5tests.bmo.steps.homepage.KeyGlobalViewsBmoSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.KeyGlobalViews.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_RegularUser_KeyGlobalViews.csv", separator = ',')

public class Test_RegularUser_KeyGlobalViews extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps 
	public SingleArticleSteps singleArticleSteps;
	
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	
	@Steps
	public HomePageLevelTwoSteps homePageLevelTwoSteps;
	
	@Steps 
	public KeyGlobalViewsBmoSteps keyGlobalViewsBmoSteps;
	
	@Steps
	public PreviewArticleWindowSteps previewArticleWindowSteps;
	
	@Steps
	public HotTopicArticleSteps hotTopicsArticleSteps;
	
	@Steps
	public HomeSteps homeSteps;
	
	String username, password, keyGlobalViewsBreadcrums, articleName;
	int articleNumber;
	
	@Test
	public void test_RegularUser_KeyGlobalViews() {
		loginSteps.performLogin(username, password);		
		homePageHeaderSteps.clickOnLogo();
		homePageLevelTwoSteps.viewAllKeyGlobalViews();
		homePageHeaderSteps.verifyBreadCrumbs(keyGlobalViewsBreadcrums);

		articleName = hotTopicsArticleSteps.clickArticle(articleNumber);
		Sleeper.sleepTight(10000);
		singleArticleSteps.verifyIfActionIconsAreEnabled();
		singleArticleSteps.clickOnBackToPreviousPage();
		homePageHeaderSteps.verifyBreadCrumbs(keyGlobalViewsBreadcrums);
		
		homePageHeaderSteps.clickOnLogo();
		articleName = homePageLevelTwoSteps.clickOnArticleFromKeyGlobalViews(articleNumber);
		singleArticleSteps.verifyIfActionIconsAreEnabled();
		singleArticleSteps.clickOnBackToPreviousPage();
		homeSteps.verifyHomePageKeyGlobalViews(keyGlobalViewsBreadcrums);
	}
}

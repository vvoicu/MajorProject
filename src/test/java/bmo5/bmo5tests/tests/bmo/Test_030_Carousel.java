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
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Carousel.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_030_Carousel.csv", separator=',')

public class Test_030_Carousel extends TestCase {
	
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	
	@Steps
	public HomePageLevelOneSteps homePageLevelOneSteps;
	
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Steps
	public SingleArticleSteps singleArticleSteps;

	public String username, password, articleName;
	public int circle;
	
	@Test
	public void test_030_Carousel(){
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnLogo();
		articleName = homePageLevelOneSteps.clickOnFirstArticleFromCarousel();
		homePageHeaderSteps.verifyBreadCrumbs(articleName);
		singleArticleSteps.clickOnBackToPreviousPage();
		homePageLevelOneSteps.clickOnDvPackFromCarousel();
		homePageHeaderSteps.clickOnLogo();
		homePageLevelOneSteps.clickOnCircle(circle);
		homePageLevelOneSteps.clickOnNextArrowFromCarousel();
		homePageLevelOneSteps.clickOnPreviousArrowFromCarousel();
	}
	
}

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

import bmo5.bmo5tests.bmo.steps.EmailPopUpWindowSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.DailyViews.Analysis.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_019_2_Analysis_SingleArticle.csv", separator = ',')

public class Test_019_4_Analysis_ListingPage extends TestCase{
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	@Steps
	public SingleArticleSteps singleArticleSteps;
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	
	public String username, password, analysis, articleName;
	int articleNumber;
	
	@Test
	public void test_019_2_Analysis_SingleArticle() {
		loginSteps.performLogin(username, password);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(analysis);
		//TODO fix this
//		singleArticleSteps.clickOnDownloadArticleFromListing(articleNumber);
		singleArticleSteps.clickOnPrintArticleFromListing(articleNumber);
		singleArticleSteps.clickOnSaveArticleFromListing(articleNumber);
		singleArticleSteps.clickOnEmailArticleFromListing(articleNumber);
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.submitWithSpacesInFieldsAndVerify();
		emailPopUpWindowSteps.completeFieldsClearAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
      }
}

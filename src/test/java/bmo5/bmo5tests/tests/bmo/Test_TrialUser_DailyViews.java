package bmo5.bmo5tests.tests.bmo;

import junit.framework.TestCase;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.bmo.steps.EmailPopUpWindowSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.PreviewArticleWindowSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelDailyAnalysisSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Trial.Pillars.DailyViews.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_TrialUser_DailyViews.csv", separator = ',')

public class Test_TrialUser_DailyViews extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps 
	public SingleArticleSteps singleArticleSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	
	@Steps
	public PreviewArticleWindowSteps previewArticleWindowSteps;
	
	@Steps
	public FilterPanelDailyAnalysisSteps filterPanelDailyAnalysisSteps;
	
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Qualifier
	 public String getQualifier() {
       return dailyViews;
   }

	String username, password,dailyViews,dailyViewsBreadcrumbs,analysisBreadcumbs,nwesBreadcrumbs,geographyTop,continent,country,saveView;
	int articleNumber;
	
	@Test
	public void test_TrialUser_DailyViews() {
		loginSteps.performLogin(username, password);		
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dailyViewsBreadcrumbs);
		filterPanelDailyAnalysisSteps.selectTags(articleNumber);
		singleArticleSteps.verifyMediaActionsForTrialOnHover(articleNumber);
		singleArticleSteps.clickOnPrintIconArticleFromListTrialUser(articleNumber);
		singleArticleSteps.clickOnDownloadIconArticleFromListTrialUser(articleNumber);
		singleArticleSteps.clickOnSaveArticleFromListing(articleNumber);
		singleArticleSteps.clickOnEmailArticleFromListing(articleNumber);
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		singleArticleSteps.clickOnPreviewArticle(articleNumber);
		Sleeper.sleepTight(3000);
		singleArticleSteps.verifyMediaActionsForTrialInPreview();
		//TODO fix this
//		previewArticleWindowSteps.clickOnPrintIconPreviewArticleTrialUser();
		singleArticleSteps.clickOnPreviewArticle(articleNumber);
		//TODO fix this
//		previewArticleWindowSteps.clickOnDownloadIconPreviewArticleTrialUser();
		Sleeper.sleepTight(2000);
		singleArticleSteps.clickOnPreviewArticle(articleNumber);
		previewArticleWindowSteps.clickOnSaveIconPreviewArticle();
		Sleeper.sleepTight(2000);
		//TODO fix this
//		previewArticleWindowSteps.clickOnEmailIconPreviewArticle();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		singleArticleSteps.clickSingleArticle(articleNumber);
		singleArticleSteps.verifyMediaActionsForTrialInDetailArticle();
		singleArticleSteps.clickOnPrintButtonArticleTrialUser();
		singleArticleSteps.clickOnDownloadButtonArticleTrialUser();
		singleArticleSteps.clickOnSaveButton();
		singleArticleSteps.clickOnEmailIconArticlePage();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dailyViewsBreadcrumbs);
		homePageTopMenuSteps.clickOnGeography(geographyTop,continent,country);
		Sleeper.sleepTight(5000);
		filterPanelDailyAnalysisSteps.clickOnSaveView(saveView);
		
	}	
}

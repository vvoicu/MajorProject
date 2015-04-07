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

@Story(Application.Trial.Pillars.DailyViews.Analysis.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_TrialUser_Analysis.csv", separator = ',')

public class Test_TrialUser_Analysis extends TestCase {
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
       return analysisBreadcumbs;
   }
	
	String username, password,dailyViews,dailyViewsBreadcrumbs,analysisBreadcumbs,nwesBreadcrumbs,serviceTop,saveView,geographyTop,continent,country;
	int articleNumber,column,serviceNumber;
	
	public void setGeo(String geographyTop) {
		this.geographyTop = geographyTop;
	}
	
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setuser(String username) {
		this.username = username;
	}
	public void setPass(String password) {
		this.password = password;
	}
	public void setAnalysisBreadcumbs(String analysisBreadcumbs) {
		this.analysisBreadcumbs = analysisBreadcumbs;
	}
	public void setArtNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}
	
	@Test
	public void test_TrialUser_Analysis() {
		loginSteps.performLogin(username, password);	
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(analysisBreadcumbs);
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
		Sleeper.sleepTight(3000);
		singleArticleSteps.clickOnPreviewArticle(articleNumber);
		previewArticleWindowSteps.clickOnSaveIconPreviewArticle();
		//singleArticleSteps.clickOnPreviewArticle(articleNumber);
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
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(analysisBreadcumbs);
		homePageTopMenuSteps.clickOnGeography(geographyTop,continent,country);
		Sleeper.sleepTight(3000);
		filterPanelDailyAnalysisSteps.clickOnSaveView(saveView);
	}
	}
		
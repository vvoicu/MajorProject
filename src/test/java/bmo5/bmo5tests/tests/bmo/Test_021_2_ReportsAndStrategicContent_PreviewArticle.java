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
import bmo5.bmo5tests.bmo.steps.PreviewArticleWindowSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.ReportsAndStrategicContent.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_021_2_ReportsAndStrategicContent_PreviewArticle.csv", separator=',')

public class Test_021_2_ReportsAndStrategicContent_PreviewArticle extends TestCase {
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
	public PreviewArticleWindowSteps previewArticleWindowSteps;
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	@Steps
	public StrategicAnalysisSteps strategicAnalysisPageSteps;
	
	public String username, password, articleName, parentBreadcrumb;
	private int articleNumber;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}
	
	@Test
	public void test_021_2_ReportsAndStrategicContent_PreviewArticle() {
		loginSteps.performLogin(username, password);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(parentBreadcrumb);
		singleArticleSteps.clickOnPreviewArticle(articleNumber);
		//TODO fix this
//		articleName = previewArticleWindowSteps.getArticleNameFromPreviewWindow();
//		previewArticleWindowSteps.clickOnEmailIconPreviewArticle();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.submitWithSpacesInFieldsAndVerify();
		emailPopUpWindowSteps.completeFieldsClearAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(parentBreadcrumb);
	
		singleArticleSteps.clickOnPreviewArticle(articleNumber);
		//TODO fix this
//		articleName = previewArticleWindowSteps.getArticleNameFromPreviewWindow();
		previewArticleWindowSteps.clickOnSaveIconPreviewArticle();
		strategicAnalysisPageSteps.clickOnDownloadIconPreviewArticleStrategicAnalysisPage(articleName);
		//TODO fix this
//		previewArticleWindowSteps.clickOnPrintIconPreviewArticle(articleName);
		previewArticleWindowSteps.clickOnReadMoreButtonFromPreviewArticle();
		singleArticleSteps.verifyArticleBreadcrumb(articleName);
		strategicAnalysisPageSteps.verifyArticleTitleStrategicAnalysisPage(articleName); //SA
		homePageTopMenuSteps.clickOnTheNameOfTheParentBreadcrumb(); 
		homePageTopMenuSteps.verifyBreadCrumb(parentBreadcrumb); 
		homePageTopMenuSteps.clickOnTheHomeBreadcrumb();
		homePageLevelOneSteps.verifyHomePage();
	}
}

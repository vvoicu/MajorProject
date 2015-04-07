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
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.DailyViews.News.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_020_02_News_SingleArticle.csv", separator = ',')

public class Test_020_06_News_WindowPage extends TestCase{
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	@Steps
	public SingleArticleSteps singleArticleSteps;
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	@Steps
	public StrategicAnalysisSteps strategicAnalysisPageSteps;
	@Steps
	public PreviewArticleWindowSteps previewArticleWindowSteps;
	
	public String username, password, newsBreadcrumbs, articleName;
	int articleNumber;
	
	@Test
	public void test_020_06_News_WindowPage() {
		loginSteps.performLogin(username, password);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(newsBreadcrumbs);
		articleName = singleArticleSteps.clickOnPreviewArticle(articleNumber);
		strategicAnalysisPageSteps.clickOnDownloadIconPreviewArticleStrategicAnalysisPage(articleName);
		//TODO fix this
//		previewArticleWindowSteps.clickOnViewFullReportIconPreviewArticle(articleName);
//		previewArticleWindowSteps.clickOnPrintIconPreviewArticle(articleName);
		previewArticleWindowSteps.clickOnSaveIconPreviewArticle();
		//TODO fix this
//		previewArticleWindowSteps.clickOnEmailIconPreviewArticle();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.submitWithSpacesInFieldsAndVerify();
		emailPopUpWindowSteps.completeFieldsClearAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		articleName = singleArticleSteps.clickOnPreviewArticle(articleNumber);
		previewArticleWindowSteps.clickOnReadMoreButtonFromPreviewArticle();
		singleArticleSteps.verifyArticleBreadcrumb(articleName);
		singleArticleSteps.clickOnBackToPreviousPage();
		homePageTopMenuSteps.verifyBreadCrumb(newsBreadcrumbs);
      }
}

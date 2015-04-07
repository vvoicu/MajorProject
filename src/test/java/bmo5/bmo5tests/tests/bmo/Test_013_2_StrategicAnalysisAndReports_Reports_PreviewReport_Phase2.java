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
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.HomePage.Pillars.ReportsAndStrategicContent.Reports.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_013_2_StrategicAnalysisAndReports_Reports_PreviewReport_Phase2.csv", separator=',')


public class Test_013_2_StrategicAnalysisAndReports_Reports_PreviewReport_Phase2 extends TestCase {
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
	public SingleReportSteps singleReportSteps;
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
	
	public String username, password, articleName, parentBreadcrumb, reportsBreadcrumbs;
	private int reportNumber;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setArticleNumber(int reportNumber) {
		this.reportNumber = reportNumber;
	}
	
	@Test
	public void test_013_2_StrategicAnalysisAndReports_Reports_PreviewReport_Phase2() {
		loginSteps.performLogin(username, password);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsBreadcrumbs);                                         
		singleReportSteps.clickOnPreviewOfOneReportFromListing(reportNumber);
		//TODO fix this
//		previewArticleWindowSteps.clickOnEmailIconPreviewArticle();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.submitWithSpacesInFieldsAndVerify();
		emailPopUpWindowSteps.completeFieldsClearAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsBreadcrumbs);                                           
		articleName = singleReportSteps.clickOnPreviewOfOneReportFromListing(reportNumber);   
		//TODO fix this
//		previewArticleWindowSteps.getArticleNameFromPreviewWindow();
//		previewArticleWindowSteps.clickOnSaveIconReportFromPreviewWindow();
//		previewArticleWindowSteps.clickOnDownloadIconPreviewArticle(articleName);
//		previewArticleWindowSteps.clickOnPrintIconPreviewReport(articleName);
//		previewArticleWindowSteps.getArticleNameFromPreviewWindow();
		previewArticleWindowSteps.clickOnReadMoreButtonFromPreviewArticle();
		singleArticleSteps.verifyArticleBreadcrumb(articleName);
		homePageTopMenuSteps.clickOnTheNameOfTheChildBreadcrumb();
		homePageTopMenuSteps.verifyBreadCrumb(reportsBreadcrumbs);
		homePageTopMenuSteps.clickOnTheNameOfTheParentBreadcrumb();
		homePageTopMenuSteps.verifyBreadCrumb(parentBreadcrumb); 
		homePageTopMenuSteps.clickOnTheHomeBreadcrumb();
		homePageLevelOneSteps.verifyHomePage();
	}
}

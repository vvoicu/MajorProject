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
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelDailyAnalysisSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.KeyGlobalViewsBmoSteps;
import bmo5.bmo5tests.bmo.steps.pillars.ReportsArchiveSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Trial.Pillars.ReportsAndStrategicContent.Reports.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_TrialUser_Reports.csv", separator = ',')

public class Test_TrialUser_Reports extends TestCase {
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
	public SingleReportSteps singleReportSteps;

	@Steps
	public ReportsArchiveSteps reportsArchiveSteps;

	@Steps
	public KeyGlobalViewsBmoSteps keyGlobalViewsBmoSteps;

	@Steps
	public FilterPanelDailyAnalysisSteps filterPanelDailyAnalysisSteps;
	
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;

	@Qualifier
	 public String getQualifier() {
       return reportsBreadcrumbs;
   }
	
	String username, password,breadcrumb,reportsAndStrategicContentBreadcrumbs,reportsBreadcrumbs,reportsArchiveBreadcrumbs;
	int reportNumber, articleNumber, pastVersionNumber;

	@Test
	public void test_TrialUser_Reports() {
		loginSteps.performLogin(username, password);	
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsBreadcrumbs);
		singleReportSteps.verifyReportHoveredMediaActions(reportNumber);
		singleArticleSteps.verifySaveForTrial(reportNumber,articleNumber);
		singleReportSteps.verifyReportHoveredMediaActions(reportNumber);
		singleArticleSteps.clickOnEmailIcon(articleNumber);
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		singleReportSteps.clickOnPrintIconReportFromListTrialUser(reportNumber);
		singleReportSteps.clickOnDownloadIconReportFromListTrialUser(reportNumber);
		singleReportSteps.clickOnPreviewOfOneReportFromListing(reportNumber);
		Sleeper.sleepTight(3000);
		singleReportSteps.verifyReportPreviewMediaActions();
		previewArticleWindowSteps.clickOnSaveIconPreviewArticle();
		//TODO fix this
//		previewArticleWindowSteps.clickOnDownloadIconPreviewArticleTrialUser();
		singleReportSteps.clickOnOneReportFromListing(reportNumber);
		singleReportSteps.verifyReportDetailMediaActions();
		singleArticleSteps.clickOnSaveButton();
		singleArticleSteps.clickOnEmailIconArticlePage();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		singleReportSteps.clickOnPrintIconReportTrialUser();
		singleReportSteps.clickOnDownloadIconReportTrialUser();
		singleReportSteps.clickOnPastVersionsToggler();
		singleReportSteps.verifyActionIconsOfPastVersionsTrialUsers(pastVersionNumber);
	}
}
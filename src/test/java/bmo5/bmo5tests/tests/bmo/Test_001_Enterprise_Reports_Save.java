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
import bmo5.bmo5tests.bmo.steps.EntrepriseLoginSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.PreviewArticleWindowSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelDailyAnalysisSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.ReportsArchiveSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Enterprise.Pillars.ReportsAndStrategicContent.Reports.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enterprise_Reports_Save.csv", separator=',')

public class Test_001_Enterprise_Reports_Save extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST_IP)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public DailyAnalysisAndNewsSteps dailyAnalysisAndNewsSteps;
	@Steps
	public EntrepriseLoginSteps entrepriseLoginSteps;
	@Steps
	public FilterPanelDailyAnalysisSteps filterPanelDailyAnalysisSteps;
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	@Steps
	public SingleArticleSteps singleArticleSteps;
	@Steps
	public PreviewArticleWindowSteps previewArticleWindowSteps;
	@Steps
	public SingleReportSteps singleReportSteps;
	@Steps
	public ReportsArchiveSteps reportsArchiveSteps;
	@Steps
	public StrategicAnalysisSteps strategicAnalysisPageSteps;
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	
	@Qualifier
	 public String getQualifier() {
       return reportsBreadcrumbs;
   }
	public String service,continent,name,article,articleTitle,reportsAndStrategicContentBreadcrumbs,reportsBreadcrumbs,reportsArchiveBreadcrumbs,serviceTop,articleName;
	int articleNumber,reportNumber,reportNumberList,column,serviceNumber;

	@Test
	public void test_001_Enterprise_Reports_Save() {

		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsBreadcrumbs);
		homePageTopMenuSteps.selectServicefromTop(serviceTop);
		singleReportSteps.verifyMediaActionOnHoveredReport(reportNumber);
		singleReportSteps.clickOnSaveIconOfOneReportFromListing(reportNumber);
		Sleeper.sleepTight(5000);
		filterPanelDailyAnalysisSteps.cancelEnteprisePopUpWindow();
		filterPanelDailyAnalysisSteps.clickOnTags(articleNumber);
		singleArticleSteps.clickOnEmailIcon(articleNumber);
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		singleReportSteps.clickOnPreviewOfOneReportFromListing(reportNumber); 
		singleReportSteps.verifyMediaActionInReportPreview();
		//TODO fix this
//		previewArticleWindowSteps.clickOnSaveIconReportFromPreviewWindow();
		filterPanelDailyAnalysisSteps.cancelEnteprisePopUpWindow();
		Sleeper.sleepTight(3000);
		String articleName = singleReportSteps.clickOnPreviewReportsFromList(reportNumber);
		Sleeper.sleepTight(5000);
		//TODO fix this
//		previewArticleWindowSteps.getArticleNameFromPreviewWindow();
//		previewArticleWindowSteps.clickOnDownloadIconPreviewArticle(articleName);
		Sleeper.sleepTight(3000);
//		previewArticleWindowSteps.clickOnPrintIconPreviewReport(articleName);
		
		singleReportSteps.clickOnOneReportFromListing(reportNumber);
		singleReportSteps.verifyMediaActionsOnReportView();
		singleReportSteps.saveEnterpriseIconInsideReport();
		filterPanelDailyAnalysisSteps.cancelEnteprisePopUpWindow();
		singleArticleSteps.clickOnEmailIconArticlePage();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		Sleeper.sleepTight(3000);
		articleName = singleArticleSteps.getReportNameFromBreadcrumbs();
		Sleeper.sleepTight(3000);
		singleArticleSteps.clickOnPrintIconReport(articleName);
		Sleeper.sleepTight(3000);
		singleReportSteps.clickOnDownloadIconReport(articleName);
	}
}

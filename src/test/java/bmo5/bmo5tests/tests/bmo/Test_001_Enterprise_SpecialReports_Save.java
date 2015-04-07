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
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Enterprise.HomePageTopMenu.SpecialReports.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enterprise_SpecialReports_Save.csv", separator=',')

public class Test_001_Enterprise_SpecialReports_Save extends TestCase {
	
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
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	
	public String service,continent,name,article,articleTitle;
	int articleNumber,reportNumberList,reportNumber;
	
	@Test
	public void test_001_Enterprise_SpecialReports_Save() {
		homePageTopMenuSteps.clickAndVerifySpecialReports();
		singleReportSteps.clickOnPreviewReportArchiveFromList(reportNumber);
		Sleeper.sleepTight(5000);
		singleReportSteps.verifyMediaActionInReportPreview();
		//TODO fix this
//		previewArticleWindowSteps.clickOnSaveIconReportFromPreviewWindow();
		filterPanelDailyAnalysisSteps.cancelEnteprisePopUpWindow(); 
		//previewArticleWindowSteps.closePreviewWindow();
	
		singleReportSteps.clickOnPreviewReportArchiveFromList(reportNumber);
		Sleeper.sleepTight(5000);
		//TODO fix this
//		previewArticleWindowSteps.clickOnEmailIconPreviewArticle();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		Sleeper.sleepTight(3000);
		String articleName = singleReportSteps.clickOnPreviewReportArchiveFromList(reportNumber);
		Sleeper.sleepTight(5000);
		//TODO fix this
//		previewArticleWindowSteps.getArticleNameFromPreviewWindow();
//		previewArticleWindowSteps.clickOnDownloadIconPreviewArticle(articleName);
		Sleeper.sleepTight(3000);
		//TODO fix this
//		previewArticleWindowSteps.clickOnPrintIconPreviewReport(articleName);
		Sleeper.sleepTight(3000);
		singleReportSteps.clickASpecialReportsFromListing(reportNumberList);
		singleReportSteps.verifyMediaActionsOnReportView();
		singleReportSteps.saveEnterpriseIconInsideReport();
		filterPanelDailyAnalysisSteps.cancelEnteprisePopUpWindow();
		singleArticleSteps.clickOnEmailIconArticlePage();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.submitWithSpacesInFieldsAndVerify();
		emailPopUpWindowSteps.completeFieldsClearAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		Sleeper.sleepTight(3000);
		articleName = singleArticleSteps.getReportNameFromBreadcrumbs();
		Sleeper.sleepTight(2000);
		singleArticleSteps.clickOnPrintIconReport(articleName);
		Sleeper.sleepTight(3000);
		singleReportSteps.clickOnDownloadIconReport(articleName);
		
	}
}
	
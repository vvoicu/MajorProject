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
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelNewsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisAndReportsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.NavigationItems;

@Story(Application.HomePage.Pillars.ReportsAndStrategicContent.Reports.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_013_1_StrategicAnalysisAndReports_Reports_Phase2.csv", separator=',')


public class Test_013_1_StrategicAnalysisAndReports_Reports_Phase2 extends TestCase {
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
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public HomePageLevelOneSteps homePageLevelOneSteps;
	@Steps
	public StrategicAnalysisAndReportsSteps strategicAnalysisAndReportsSteps;
	@Steps
	public PreviewArticleWindowSteps previewArticleWindowSteps;
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	@Steps
	public SingleReportSteps singleReportSteps;
	@Steps
	public FilterPanelNewsSteps filterPanelNewsSteps;
	
	public String username, password, reportName, reportsBreadcrumbs;
	private int reportNumber,archiveNumber;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setArticleNumber(int reportNumber) {
		this.reportNumber = reportNumber;
	}
	
	public void setArchiveNumber(int archiveNumber) {
		this.archiveNumber = archiveNumber;
	}
	
	@Test
	public void test_013_1_StrategicAnalysisAndReports_Reports_Phase2() {
		loginSteps.performLogin(username, password);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsBreadcrumbs);
		
		filterPanelNewsSteps.navigateToItemReports(NavigationItems.Two);
		filterPanelNewsSteps.navigateToItemReports(NavigationItems.Previous);
		filterPanelNewsSteps.navigateToItemReports(NavigationItems.One);
		filterPanelNewsSteps.navigateToItemReports(NavigationItems.Three);
		filterPanelNewsSteps.navigateToItemReports(NavigationItems.Five);
		filterPanelNewsSteps.navigateToItemReports(NavigationItems.Last);
		filterPanelNewsSteps.navigateToItemReports(NavigationItems.Two);
		filterPanelNewsSteps.navigateToItemReports(NavigationItems.Previous);
		
		strategicAnalysisAndReportsSteps.clickAndVerifyArchivesOfReportFromListing(reportNumber, archiveNumber); 
	
		singleReportSteps.clickOnEmailIconOfOneReportFromListing(reportNumber);
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.submitWithSpacesInFieldsAndVerify();
		emailPopUpWindowSteps.completeFieldsClearAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		singleReportSteps.clickOnSaveIconOfOneReportFromListing(reportNumber);
		//TODO fix this
//		singleReportSteps.clickOnDownloadIconOfOneReportFromListing(reportNumber);
		singleReportSteps.clickOnPrintIconOfOneReportFromListing(reportNumber);
		reportName = singleReportSteps.clickOnPreviewOfOneReportFromListing(reportNumber);
		previewArticleWindowSteps.closePreviewWindow();
	}
}

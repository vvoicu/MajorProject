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
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisAndReportsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.ReportsAndStrategicContent.Reports.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_013_3_StrategicAnalysisAndReports_Reports_ReportPage_Phase2.csv", separator=',')

public class Test_013_3_StrategicAnalysisAndReports_Reports_ReportPage_Phase2 extends TestCase {
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
	public SingleReportSteps singleReportSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public HomePageLevelOneSteps homePageLevelOneSteps;
	@Steps
	public StrategicAnalysisAndReportsSteps strategicAnalysisAndReportsSteps;
	@Steps
	public EmailPopUpWindowSteps emailPopUpWondowSteps;
	
	public String username, password, reportName, parentBreadcrumb, reportsBreadcrumbs;
	private int reportNumber, itemNumber, pastVersionNumber;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setArticleNumber(int reportNumber) {
		this.reportNumber = reportNumber;
	}
	
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	public void setPastVersionNumber(int pastVersionNumber) {
		this.pastVersionNumber = pastVersionNumber;
	}
	
	@Test
	public void test_013_3_StrategicAnalysisAndReports_Reports_ReportPage_Phase2() {
		loginSteps.performLogin(username, password);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsBreadcrumbs);
		reportName = singleReportSteps.clickOnOneReportFromListing(reportNumber);
		singleArticleSteps.verifyArticleBreadcrumb(reportName);
		singleReportSteps.clickOnEmailIcon();
		emailPopUpWondowSteps.closeEmailWondow();
		singleReportSteps.clickOnSaveIconReport();
		singleReportSteps.clickOnDownloadIconReport(reportName);
		singleReportSteps.clickOnPrintIconReport(reportName);
		singleReportSteps.verifyPastVersionSection(pastVersionNumber);
		singleReportSteps.clickOnOneItemFromLeftHandPanel(itemNumber);
		singleReportSteps.clickOnBackToPreviousPage();
		homePageTopMenuSteps.verifyBreadCrumb(reportsBreadcrumbs);
		homePageTopMenuSteps.clickOnTheNameOfTheParentBreadcrumb();
		homePageTopMenuSteps.verifyBreadCrumb(parentBreadcrumb);
		homePageTopMenuSteps.clickOnTheHomeBreadcrumb();
		homePageLevelOneSteps.verifyHomePage();
	}
}

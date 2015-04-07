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

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.MyAccountSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Trial.Header.MyBMO.Account.ContactAccountManager.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_TrialUser_ContactAccountManager.csv", separator = ',')

public class Test_TrialUser_ContactAccountManager extends TestCase {

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
	public SingleReportSteps singleReportSteps;
	
	@Steps
	public MyAccountSteps myAccountSteps;
	
	String username, password,dailyViews,dailyViewsBreadcrumbs,reportsBreadcrumbs;
	int articleNumber, reportNumber, pastVersionNumber;
	
	@Test
	public void test_TrialUser_ContactAccountManager() {
		loginSteps.performLogin(username, password);		
		
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dailyViewsBreadcrumbs);
		myAccountSteps.verifyTheSubjectTrialUserFromArticles(singleArticleSteps.clickOnPrintIconArticleFromListTrialUserAndVerifyContactAccountManager(articleNumber));
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dailyViewsBreadcrumbs);
		myAccountSteps.verifyTheSubjectTrialUserFromArticles(singleArticleSteps.clickOnDownloadIconArticleFromListTrialUserAndVerifyContactAccountManager(articleNumber));
		
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsBreadcrumbs);
		myAccountSteps.verifyTheSubjectTrialUserFromReports(singleReportSteps.clickOnPrintIconReportFromListTrialUserAndVerifyContactAccountManager(reportNumber));
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsBreadcrumbs);
		myAccountSteps.verifyTheSubjectTrialUserFromReports(singleReportSteps.clickOnDownloadIconReportFromListTrialUserAndVerifyContactAccountManager(reportNumber));
		
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsBreadcrumbs);
		singleReportSteps.clickOnOneReportFromListing(reportNumber);
		singleReportSteps.clickOnPastVersionsToggler();
		myAccountSteps.verifyTheSubjectTrialUserFromReports(singleReportSteps.verifyDownloadAndContactAccountManagerFromPastVersionsForTrialUser(pastVersionNumber));
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsBreadcrumbs);
		singleReportSteps.clickOnOneReportFromListing(reportNumber);
		singleReportSteps.clickOnPastVersionsToggler();
		myAccountSteps.verifyTheSubjectTrialUserFromReports(singleReportSteps.verifyPrintAndContactAccountManagerFromPastVersionsForTrialUser(pastVersionNumber));
	}	
}

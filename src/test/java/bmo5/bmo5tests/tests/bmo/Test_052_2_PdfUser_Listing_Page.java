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

import bmo5.bmo5tests.adm.steps.ClientAccountsSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.PDFUserLandingSteps;
import bmo5.bmo5tests.bmo.steps.PDFUserListingSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.SpecialReportsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.ReportsArchiveSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Pdf.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_052_2_PDFUser_ListingPage.csv", separator=',')

public class Test_052_2_PdfUser_Listing_Page extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public PDFUserLandingSteps pdfUserLandingSteps;
	@Steps
	public PDFUserListingSteps pdfUserListingSteps;
	@Steps
	public SpecialReportsSteps specialReportsSteps;
	@Steps
	public bmo5.bmo5tests.adm.steps.LoginSteps admLoginSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public ClientAccountsSteps clientAccountSteps;
	@Steps
	public ReportsArchiveSteps reportsArchiveSteps;
	
	public String username, password, pdfBreadcrumb, dateRangeNameOne,dateRangeNameTwo, dateRangeNameThree, dateRangeNameFour, dateRangeNameFive,  startDate, endDate, sortByNameItemOne, sortByNameItemTwo, sortByNameItemThree, sortByNameOrderOne, sortByNameOrderTwo, admUsername, admPassword, email, geographyLeftHand, serviceLeftHand, reportTypeLeftHand, countryCode,serviceCode,continentCode,reportCode;
	public int reportNumber, itemNumber;	
	
	@Test
	public void test_052_2_PdfUser_Listing_Page() {
		
//		admLoginSteps.getDriver().get(Constants.ADM_HOST);
//		admLoginSteps.performLogin(admUsername,admPassword);
//		
//		clientAccountSteps.gotoClientAccountspage();
//		clientAccountSteps.performSearch(email);
//		clientAccountSteps.selectAdvancedSettings();
//		clientAccountSteps.deselectUserType();
//		clientAccountSteps.selectPDF();
//		clientAccountSteps.saveAdvancedSettings();
//		
//		loginSteps.getDriver().get(Constants.BMO_HOST);
		loginSteps.performLogin(username, password);
		pdfUserLandingSteps.clickOnSearchButton();
		pdfUserLandingSteps.verifyPDFBreadcrumbs(pdfBreadcrumb);
		pdfUserListingSteps.clickOnOneReportFromListing(reportNumber);
		pdfUserListingSteps.clickOnBackToPreviousPageButton();
		Sleeper.sleepTight(3000);
		
		reportsArchiveSteps.navigatePages();
		
		pdfUserListingSteps.selectDateRange(dateRangeNameTwo);
		pdfUserListingSteps.selectDateRange(dateRangeNameThree);
		pdfUserListingSteps.selectDateRange(dateRangeNameFour);
		pdfUserListingSteps.selectDateRange(dateRangeNameFive);
		pdfUserListingSteps.selectDateRange(dateRangeNameOne);
		pdfUserListingSteps.selectSortByResultsOrder(sortByNameOrderOne);
		pdfUserListingSteps.selectSortByResultsItem(sortByNameItemTwo);
		pdfUserListingSteps.selectSortByResultsOrder(sortByNameOrderTwo);
		pdfUserListingSteps.selectSortByResultsItem(sortByNameItemThree);
		
		reportsArchiveSteps.selectGeographyFromLeftHand(geographyLeftHand);
	    reportsArchiveSteps.verifyIfCountryIsSelected(continentCode);
	    reportsArchiveSteps.selectServiceFromLeftHand(serviceLeftHand);
	    reportsArchiveSteps.verifyIfServiceIsSelected(serviceCode);
	    reportsArchiveSteps.selectReportTypeFromLeftHand(reportTypeLeftHand);
	    reportsArchiveSteps.verifyIfReportTypeIsSelected(reportCode);
	    
	    reportsArchiveSteps.clickOnBackToBMIReportsButtonAndVerifyBreadcrumb();
		
//		admLoginSteps.getDriver().get(Constants.ADM_HOST);
//		admLoginSteps.performLogin(admUsername,admPassword);
//		
//		clientAccountSteps.deselectUserType();
//		clientAccountSteps.selectMyPreferences();
//		clientAccountSteps.saveAdvancedSettings();
	}
}

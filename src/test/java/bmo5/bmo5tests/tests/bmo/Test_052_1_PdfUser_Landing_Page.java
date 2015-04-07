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

import bmo5.bmo5tests.adm.steps.ClientAccountsSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.PDFUserLandingSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Pdf.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_052_1_PDFUser_LandingPage.csv", separator=',')

public class Test_052_1_PdfUser_Landing_Page extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public PDFUserLandingSteps pdfUserLandingSteps;
	@Steps
	public bmo5.bmo5tests.adm.steps.LoginSteps admLoginSteps;
	
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	
	@Steps
	public ClientAccountsSteps clientAccountSteps;
	
	public String username, password, pdfBreadcrumb, threeLettersReportTitle, threeLettersGeographyName, dateRangeName, sortByNameOne,startDate, endDate, sortByNameTwo, admUsername, admPassword, email, geographyName, serviceName;
	public int reportNumber, geographyNumber, serviceNumber;
	
	@Test
	public void test_052_1_PdfUser_Landing_Page() {
		
//		admLoginSteps.getDriver().get(Constants.ADM_HOST);
//		admLoginSteps.performLogin(admUsername,admPassword);
//		
//		menuNavigationSteps.selectMenuItem(AdmMenuItems.AccountManagement);
//		menuNavigationSteps.selectMenuItem(AdmMenuItems.ClientAccounts);
//		clientAccountSteps.performSearch(email);
//		clientAccountSteps.selectAdvancedSettings();
//		clientAccountSteps.deselectUserType();
//		clientAccountSteps.selectPDF();
//		clientAccountSteps.saveAdvancedSettings();
//		
//		loginSteps.getDriver().get(Constants.BMO_HOST);
		loginSteps.performLogin(username, password);
		pdfUserLandingSteps.clickOnClearLinkAndVerifyTheForm();
//		pdfUserLandingSteps.verifyPDFBreadcrumbs(pdfBreadcrumb);
//		pdfUserLandingSteps.typeThreeLettersOfAReportTitle(threeLettersReportTitle, reportNumber);
//		pdfUserLandingSteps.clickOnSearchButton();
//		pdfUserLandingSteps.clickOnHomeBreadcrumb(pdfBreadcrumb);
		geographyName = pdfUserLandingSteps.typeThreeLettersInGeographyBoxAndMoveOneItem(threeLettersGeographyName, geographyNumber);
		pdfUserLandingSteps.selectAllServices();
		pdfUserLandingSteps.clickOnSearchButton();
		pdfUserLandingSteps.verifyIfGeographyIsCheckedInLHF(geographyName);
		//TODO fix this
//		pdfUserLandingSteps.verifyIfAllServicesAreCheckedInLHF();
		pdfUserLandingSteps.clickOnHomeBreadcrumb(pdfBreadcrumb);
		pdfUserLandingSteps.clickOnClearLinkAndVerifyTheForm();
		serviceName = pdfUserLandingSteps.selectAService(serviceNumber);
		pdfUserLandingSteps.checkDateRangeAndVerify(dateRangeName); // values: any, lastweek, lastmonth, lastthree or nothing(which means "Within last 6 months")
		pdfUserLandingSteps.checkSortByResultsAndVerify(sortByNameOne); //values: date, service or title
		pdfUserLandingSteps.clickOnSearchButton();
		pdfUserLandingSteps.verifyIfDateRangeIsCheckedInLHF(dateRangeName);
		//TODO fix this
//		pdfUserLandingSteps.verifyIfAllGeographiesAreCheckedInLHF();
		pdfUserLandingSteps.verifyIfServiceIsCheckedInLHF(serviceName);
		pdfUserLandingSteps.verifySortBy(sortByNameOne);
		pdfUserLandingSteps.clickOnHomeBreadcrumb(pdfBreadcrumb);
		pdfUserLandingSteps.clickOnClearLinkAndVerifyTheForm();
		geographyName = pdfUserLandingSteps.typeThreeLettersInGeographyBoxAndMoveOneItem(threeLettersGeographyName, geographyNumber);
		serviceName = pdfUserLandingSteps.selectAService(serviceNumber);
		pdfUserLandingSteps.enterValidStartAndEndDate(startDate, endDate);
		pdfUserLandingSteps.checkSortByResultsAndVerify(sortByNameTwo); //values: date, service or title
		pdfUserLandingSteps.clickOnSearchButton();
		pdfUserLandingSteps.verifyStartDateAndEndDateFromLHF(startDate, endDate);
		pdfUserLandingSteps.verifyIfGeographyIsCheckedInLHF(geographyName);
		pdfUserLandingSteps.verifyIfServiceIsCheckedInLHF(serviceName);
		pdfUserLandingSteps.verifySortBy(sortByNameTwo);
		pdfUserLandingSteps.clickOnHomeBreadcrumb(pdfBreadcrumb);
		pdfUserLandingSteps.clickOnClearLinkAndVerifyTheForm();
		pdfUserLandingSteps.selectAllCountries();
		pdfUserLandingSteps.selectAllServices();
		pdfUserLandingSteps.enterValidStartAndEndDate(startDate, endDate);
		pdfUserLandingSteps.checkSortByResultsAndVerify(sortByNameTwo);
		pdfUserLandingSteps.clickOnClearLinkAndVerifyTheForm();
//		
//		admLoginSteps.getDriver().get(Constants.ADM_HOST);
//		admLoginSteps.performLogin(admUsername,admPassword);
//		
//		clientAccountSteps.deselectUserType();
//		clientAccountSteps.selectMyPreferences();
//		clientAccountSteps.saveAdvancedSettings();
	}
}

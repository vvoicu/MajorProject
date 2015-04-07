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
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.homepage.SpecialReportsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.ReportsArchiveSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.ReportsAndStrategicContent.ReportsArchive.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_024_2_ReportsArchiveLandingPage.csv", separator=',')

public class Test_024_1_ReportsArchiveListingPage extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public ReportsArchiveSteps reportsArchiveSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Steps
	public SpecialReportsSteps specialReportsSteps;
	
	@Steps
	public SingleArticleSteps singleArticleSteps;
	
	@Steps
	public SingleReportSteps singleReportSteps;
	
	String reportCode, serviceCode, countryCode, continentCode, username, password, searchLetters, continentName, country, service, startDate, endDate, sortOption, geographyLeftHand, serviceLeftHand, 
	reportTypeLeftHand, reportsArchiveBreadcrumbs, reportName,sortByCode;
	int reportNumber;
	
	public void setService(String service) {
		this.service = service;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setSearchLetters(String searchLetters) {
		this.searchLetters = searchLetters;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}
	
	@Test
	public void test_024_1_ReportsArchiveListingPage(){
		loginSteps.performLogin(username, password);
		
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsArchiveBreadcrumbs);
		reportsArchiveSteps.searchByOneCountryOneServiceDateRangeSortByPublicationDate( country, service,startDate,endDate);
		reportsArchiveSteps.verifySortByDateSelectedOption();	
	    reportsArchiveSteps.verifyBackToReportsArchiveSelections(countryCode,country,serviceCode,service,startDate,endDate,sortByCode);
	    reportsArchiveSteps.verifyIfServiceIsSelected(serviceCode);
	    reportsArchiveSteps.verifyIfCountryIsSelected(countryCode);
	    homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsArchiveBreadcrumbs);
	    reportsArchiveSteps.clickSearchAndVerifyResultsContainerIsDisplayed();
	    
		reportsArchiveSteps.selectSortByServiceFromDropDown();
		reportsArchiveSteps.navigatePages();
		reportsArchiveSteps.getNumberOfReportsAndVerifyResults();
		reportsArchiveSteps.clickLeftDoubleArrow();
		
		reportsArchiveSteps.selectOptionsFromLeftHandAndVerifySelected(continentName, continentCode, service, serviceCode, reportTypeLeftHand, reportCode);
	    reportsArchiveSteps.getNumberOfReportsAndVerifyResults();
		reportsArchiveSteps.selectGeographyFromLeftHand(continentName);
        reportsArchiveSteps.selectServiceFromLeftHand(service);
	    reportsArchiveSteps.selectReportTypeFromLeftHand(reportTypeLeftHand);
	    reportsArchiveSteps.verifyOptionsFromLeftHandFilterAreDeselected(continentCode, serviceCode, reportCode);
	    
	    homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsArchiveBreadcrumbs);
	    reportsArchiveSteps.clickSearchAndVerifyResultsContainerIsDisplayed();
	    reportName = singleReportSteps.clickASpecialReportsFromListing(reportNumber);
	    System.out.println(reportName);
	 //   singleArticleSteps.verifyArticleBreadcrumb(reportName);
	    singleArticleSteps.clickOnBackToPreviousPage();

	    reportsArchiveSteps.clickOnBackToBMIReportsButtonAndVerifyBreadcrumb();
		}
}

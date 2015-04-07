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
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.ReportsArchiveSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.ReportsAndStrategicContent.ReportsArchive.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_024_2_ReportsArchiveLandingPage.csv", separator=',')

public class Test_024_2_ReportsArchiveLandingPage extends TestCase {
	
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
	

	String username, password,sortByOption,dateRangeOption, searchLetters,continentName,country,service,startDate,endDate,countryCode,serviceCode,continentCode,reportCode,reportsArchiveBreadcrumbs;
	
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
	public void test_024_2_ReportsArchiveLandingPage(){
		loginSteps.performLogin(username, password);
	
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsArchiveBreadcrumbs);
    	reportsArchiveSteps.typeSearchLettersAndVerifyReport(searchLetters);

		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsArchiveBreadcrumbs);
   		reportsArchiveSteps.searchByContinentAllServicesSortByService(continentName);
   	    reportsArchiveSteps.verifyIfCountryIsSelected(continentCode);
		reportsArchiveSteps.verifySortByServiceSelectedOption();
		reportsArchiveSteps.getNumberOfReportsAndVerifyResults();
	
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsArchiveBreadcrumbs);
	    reportsArchiveSteps.searchByAllGeographiesAllServicesSortByTitle();
		reportsArchiveSteps.verifySortByTitleSelectedOption();	
		reportsArchiveSteps.getNumberOfReportsAndVerifyResults();
		
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsArchiveBreadcrumbs);
	    reportsArchiveSteps.searchByOneCountryOneServiceDateRangeSortByPublicationDate( country, service,startDate,endDate);
	    reportsArchiveSteps.verifySortByDateSelectedOption();
	    reportsArchiveSteps.verifyIfCountryIsSelected(countryCode);
	    reportsArchiveSteps.verifyIfServiceIsSelected(serviceCode);
    	reportsArchiveSteps.getNumberOfReportsAndVerifyResults();
    	
    	homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsArchiveBreadcrumbs);

    	reportsArchiveSteps.typeReportTitle(searchLetters);
    	reportsArchiveSteps.filterGeographyLeftList(continentName);
    	reportsArchiveSteps.selectGeographyByValue(continentName);
    	reportsArchiveSteps.clickGeographyRightSimpleArrow();
    	reportsArchiveSteps.selectAllServicesCheckboxAndVerifySelected();
    	reportsArchiveSteps.selectSortByServiceRadiobutton();
        reportsArchiveSteps.clickClearLink();
        reportsArchiveSteps.verifyAllElementsAreCleared(sortByOption,dateRangeOption);
    	
	}
}
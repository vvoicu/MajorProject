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

import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.MncMdgSteps;
import bmo5.bmo5tests.bmo.steps.SavedContentSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.HomePage.Pillars.DataAndForecasting.BmiDatabases.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_060_27_Bmi_Databases_ExecutiveContacts.csv", separator = ',')


public class Test_060_27_Bmi_Databases_ExecutiveContacts extends TestCase{
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	
	
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	@Steps
	public MncMdgSteps mnc_MDG_Steps;
	
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	
	@Steps
	public SavedContentSteps savedContentSteps;
	
	
	public String username, password, geography, indicator, databaseName,search,companyTitle,jobTitle,text,saveMncName,address,savedMnc,companyName,companyNat,industryOption,jobOption,companyLoc,adressName,jobName,location,nationality,nationalityFromList,job,locationFromList,jobFromList,industry,industryFromList,breadcrumb, bmiDatabasesBreadcrumbs;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void databaseName(String databaseName){
		this.databaseName = databaseName;
	}

	public void setIndicator(String indicator){
		this.indicator = indicator;
	}
	public void job(String job) {
		this.job = job;
	}
	public void locationFromList(String locationFromList) {
		this.locationFromList = locationFromList;
	}
	public void breadcrumb(String breadcrumb) {
		this.breadcrumb = breadcrumb;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public void nationality(String nationality) {
		this.nationality = nationality;
	}

	public void setIndustryFromList(String industryFromList) {
		this.industryFromList = industryFromList;
	}
	public void setJobFromList(String jobFromList) {
		this.jobFromList = jobFromList;
	}
	public void setNationalityFromList(String nationalityFromList) {
		this.nationalityFromList = nationalityFromList;
	}
	public void companyName(String companyName) {
		this.companyName = companyName;
	}
	public void adressName(String adressName) {
		this.adressName = adressName;
	}
	public void jobName(String jobName) {
		this.jobName = jobName;
	}
	public void location(String location) {
		this.location = location;
	}

	
	@Test
	public void test_060_27_Bmi_Databases_ExecutiveContacts() {
		loginSteps.performLogin(username, password);
		dataToolSteps.goFullScreen();
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.clickOnSavedMNCFromLeftPanel();
		savedContentSteps.deleteAllSavedContent();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);
		mnc_MDG_Steps.searchMNC(search,companyTitle,companyName);
		mnc_MDG_Steps.addressSearch(address,adressName);
		mnc_MDG_Steps.jobSearch(jobTitle,jobName);
		mnc_MDG_Steps.clickCompanyLocation(companyLoc); 
		mnc_MDG_Steps.typeCompanyLocation(location);
		mnc_MDG_Steps.selectRegionFromList(locationFromList);
		mnc_MDG_Steps.clearCompanyButton();
		mnc_MDG_Steps.clickCompanyNationality(companyNat); 
		mnc_MDG_Steps.nationalitySearchFilter(nationality);
		mnc_MDG_Steps.selectNationalityFromList(nationalityFromList);
		mnc_MDG_Steps.clearCompanyNationalityButton();
		mnc_MDG_Steps.clickOnJobOption(job);
		mnc_MDG_Steps.typeJobName(jobOption);
		mnc_MDG_Steps.selectJobFromList(jobFromList);
		mnc_MDG_Steps.clearJobList();
		mnc_MDG_Steps.clickOnIndustryOption(industry);
		mnc_MDG_Steps.typeIndustryName(industryOption);
		mnc_MDG_Steps.selectIndustryFromList(industryFromList);
		mnc_MDG_Steps.clearIndustryList();
		bmiDatabasesGeneralSteps.verifyCompanyContactsBreadcrumb(breadcrumb);
		//mnc_MDG_Steps.clickOnSaveThisSearch(text);
		saveMncName = mnc_MDG_Steps.clickOnSaveThisSearch(text);
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.clickOnSavedMNCFromLeftPanel();
		//savedContentSteps.clickOnSavedMNCFromLeftPanel();
		mnc_MDG_Steps.verifySavedMNCInSavedCOntent(savedMnc,saveMncName);
		mnc_MDG_Steps.verifyBreadCrumbs(breadcrumb);
		mnc_MDG_Steps.verifySavedMncMatchesCompanySearchSelections(companyName);
		
	}
	}
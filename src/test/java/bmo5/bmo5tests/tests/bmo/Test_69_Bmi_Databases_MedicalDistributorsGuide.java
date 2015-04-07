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

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.MncMdgSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FooterSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Mdg.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_69_Bmi_Databases_MedicalDistributorsGuide.csv", separator=',')

public class Test_69_Bmi_Databases_MedicalDistributorsGuide  extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public MncMdgSteps mnc_MDG_Steps;

	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;

	@Steps
	public FooterSteps footerSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;

	String username, password,breadcrumb,companyName,adressName,jobName,companies,product,search,location,companyLoc,jobOption,locationFromList,job,jobFromList,companyTitle,jobTitle,address,bmiDatabasesBreadcrumbs,databaseName;
	
	@Test
	public void test_69_Bmi_Databases_MedicalDistributorsGuide() {
		
		loginSteps.performLogin(username, password);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);
		mnc_MDG_Steps.verifyBreadCrumbs(breadcrumb);
	//	mnc_MDG_Steps.doASearchForMdg(search,companyTitle,companyName); not needed
		mnc_MDG_Steps.addressSearch(address,adressName);
		mnc_MDG_Steps.jobSearch(jobTitle,jobName);
		mnc_MDG_Steps.companiesSearch(companies);
		mnc_MDG_Steps.productSearch(product);
		mnc_MDG_Steps.verifyMdgExpandableSectionsName(companyLoc,job);
		mnc_MDG_Steps.typeCompanyLocation(location);
		mnc_MDG_Steps.selectRegionFromList(locationFromList);
		mnc_MDG_Steps.clickJobOption();
		mnc_MDG_Steps.typeJobName(jobOption);
		mnc_MDG_Steps.selectJobFromList(jobFromList); 
		mnc_MDG_Steps.clearJobList();
		mnc_MDG_Steps.clickOnSearchButton(search);
		Sleeper.sleepTight(5000);
		mnc_MDG_Steps.verifyCompanyProfileAsMdgOnPage() ;
		homePageHeaderSteps.clickOnHomePageBreadcrumb();

		}
	}

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
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.RatingsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Trial.HomePageTopMenu.Service.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_TrialUser_CompanyIntelligence_Export.csv", separator=',')

public class Test_TrialUser_CompanyIntelligence_Export extends TestCase {
	
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Steps
	public MncMdgSteps mnc_MDG_Steps;
	
	@Steps
	public RatingsSteps ratingsSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	public String username,password,service,locationFromList,breadcrumbName,search,companyLoc,serviceTop,text,extension;
	public int column,serviceNumber;
	
	@Test
	public void test_TrialUser_CompanyIntelligence_Export() {
		loginSteps.performLogin(username, password);	
		homePageTopMenuSteps.selectServicefromTop(serviceTop);
		homePageTopMenuSteps.selectService(service,column,serviceNumber);
		homePageTopMenuSteps.exportContacts();
		mnc_MDG_Steps.verifyBreadCrumb(breadcrumbName);
		mnc_MDG_Steps.clickCompanyLocation(companyLoc); 
		mnc_MDG_Steps.selectRegionFromList(locationFromList);
		mnc_MDG_Steps.clickOnSearchMnc(search);
		mnc_MDG_Steps.clickOnSaveThisSearch(text);
//		mnc_MDG_Steps.exportAction();
		mnc_MDG_Steps.exportMNCTrialUserMessage(extension);
	}
}
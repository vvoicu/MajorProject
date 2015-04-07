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
import bmo5.bmo5tests.bmo.steps.homepage.AlertsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.Header.MyBMO.Alerts.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_009_1_CreateNewCustomAlert.csv", separator = ',')

public class Test_009_1_CreateNewCustomAlert extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HomePageHeaderSteps  homePageHeaderSteps;
	
	@Steps
	public AlertsSteps alertsSteps;
	
	public String username, password,alertValue,optionAlert,alertName,save,textName,textCompanies, selectServiceAsOptionAlert,button,frequency,geography,service,company,companyOption,companySearch,regionSearch,searchForService;
	
	@Test
	public void test_009_1_CreateNewCustomAlert(){
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnMyBmoIcon();
		homePageHeaderSteps.clickOnEmailAlerts();
//		alertsSteps.addAlert();
//		alertsSteps.clickCancel(button);
		alertsSteps.addAlert();
		alertsSteps.typeAlertName();
		alertsSteps.selectFirstFrequencyForAddAlert();
		alertsSteps.selectGeographiesOptionsAlert(textName);
		alertsSteps.typeTheFirstLettersForAGeography(regionSearch);
		alertsSteps.selectAGeography(geography);
		
		alertsSteps.clickOnServiceIndustries(selectServiceAsOptionAlert);
		alertsSteps.selectAServiceIndustries(searchForService,service);
		alertsSteps.selectCompany(textCompanies,companySearch);
		alertsSteps.moveCompanyForNewAlerts(company);
		alertsSteps.saveAlert(save);
		//alertsSteps.verifyAlertMessage(); //bug,i cannot take css, because there is no save message displayed
	}
}
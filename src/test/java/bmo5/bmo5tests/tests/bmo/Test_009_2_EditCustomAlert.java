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
import bmo5.bmo5tests.bmo.steps.homepage.AlertsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.Header.MyBMO.Alerts.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_009_2_EditCustomAlert.csv", separator = ',')

public class Test_009_2_EditCustomAlert extends TestCase {

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

	public String username, password,alertValue,optionAlert,button,geography,save,textService,service,textCompanies,company,companyOption,selectServiceAsOptionAlert,searchForService,testName;
	public int radioButtonIntra,radButtonDaily,radButtonWeekly;
	
	@Test
	public void test_009_2_EditCustomAlert(){

		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnMyBmoIcon();
		homePageHeaderSteps.clickOnEmailAlerts();
		alertsSteps.clickOnAlert(testName,radioButtonIntra,radButtonDaily,radButtonWeekly);
		Sleeper.sleepTight(3000);
		alertsSteps.selectGeographiesForEditCustomAlert(optionAlert);
		Sleeper.sleepTight(2000);
		alertsSteps.selectAGeographyFromCreatedCustomAlertsList(geography);
		alertsSteps.clickOnServiceEditCustomAlertOption(selectServiceAsOptionAlert);
		alertsSteps.selectAServiceIndustries(searchForService,service);
		alertsSteps.selectCompanyForEditCustomAlert(textCompanies,company);
		alertsSteps.selectAndMoveACompany(company);
		alertsSteps.saveAlert(save);
		Sleeper.sleepTight(8000);
//		alertsSteps.verifyEditAlertSaveMessage();
	}
}
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
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_009_10_SectorAlerts.csv", separator = ',')

public class Test_009_10_SectorAlerts  extends TestCase {

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
	
	public String username, password, sectorAlertOption,value,cancel,save,sectorAlerts,politic;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void sectorAlertOption(String sectorAlertOption) {
		this.sectorAlertOption = sectorAlertOption;
	}
	
	
	@Test
	public void test_009_10_SectorAlerts() {
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnMyBmoIcon(); ;
		homePageHeaderSteps.clickOnEmailAlerts();

		alertsSteps.clickOnSectorALerts(sectorAlerts);
		alertsSteps.selectSectorAlertOption(sectorAlertOption);
	//	alertsSteps.clickCancelAlertButton(cancel);
		alertsSteps.selectSectorAlertOption(value);
		alertsSteps.clickSaveAlerts(save);
		alertsSteps.verifySectorAlertsConfirmationMessage(value);
		Sleeper.sleepTight(3000);
		
	}
}
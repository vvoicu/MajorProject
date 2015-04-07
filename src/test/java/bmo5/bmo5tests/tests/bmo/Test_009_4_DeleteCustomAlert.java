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
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_009_4_DeleteCustomAlert.csv", separator = ',')

public class Test_009_4_DeleteCustomAlert extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HomePageHeaderSteps  homePageHeaderSteps;
	@Steps
	public AlertsSteps  alertsSteps;
	
	public String getQualifier() {
		return customAlerts;
	}
	
	public String username, password,alertValue,alpha,deleteMessage,customAlerts;
	
	@Test
	public void test_009_4_DeleteCustomAlert() {
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnMyBmoIcon();
		homePageHeaderSteps.clickOnEmailAlerts();
		homePageHeaderSteps.verifyBreadCrumbsAlerts(customAlerts);
		alertsSteps.selectAlertBy(alertValue,alpha);
		alertsSteps.tickUntickAllCustomCheckboxes();
		alertsSteps.tickCustomAlertCheckbox();
		alertsSteps.clickDelete();
		alertsSteps.clickPopUpDelete();
		alertsSteps.removeAlertMessage(deleteMessage);
		
		}
	}
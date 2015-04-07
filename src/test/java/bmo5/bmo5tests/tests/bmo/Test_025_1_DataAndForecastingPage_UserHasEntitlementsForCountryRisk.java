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
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.HomePage.Pillars.DataAndForecasting.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_025_1_DataAndForecastingPage_UserHasEntitlementsForCountryRisk.csv", separator = ',')

public class Test_025_1_DataAndForecastingPage_UserHasEntitlementsForCountryRisk extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	public String username, password, text, element, elementSubtab, breadcrumbText,serviceName,dataTab,infra;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void tabElement(String element) {
		this.element = element;
	}
	
	public void breadcrumbsText(String text) {
		this.text = text;
	}
	public void elementSubtab(String elementSubtab) {
		this.elementSubtab = elementSubtab;
	}
	public void breadcrumbText(String breadcrumbText) {
		this.breadcrumbText = breadcrumbText;
	}
	
	@Test
	public void test_025_1_DataAndForecastingPage_UserHasEntitlementsForCountryRisk() {
		loginSteps.performLogin(username, password);
		dataAndForecastingSteps.clickDataAndForecastingTab(dataTab);
		dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
		dataAndForecastingSteps.clickCountryRiskTab();
		dataAndForecastingSteps.verifyBreadcrumbsForCountryRisk(text);
		dataAndForecastingSteps.selectSubTabDataAndForecasting(elementSubtab);
		dataAndForecastingSteps.clickOnBMIDatabasesLink(infra);
		dataAndForecastingSteps.verifyBreadcrumbsForKeyProjects(breadcrumbText);
	}
}
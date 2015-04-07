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

import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.HomePage.Pillars.DataAndForecasting.DataTool.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX
		+ "Test_057_2_DataTool_DisplayData.csv", separator = ',')

public class Test_057_2_DataTool_DisplayData extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	public String username, password, text, geography, service,indicator,dataTool;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void text(String text) {
		this.text = text;
	}
	public void geography(String geography) {
		this.geography = geography;
	}
	public void service(String service) {
		this.service = service;
	}
	
	@Test
	public void test_057_2_DataTool_DisplayData() {
		loginSteps.performLogin(username, password);
		dataToolSteps.goFullScreen();
		dataAndForecastingSteps.selectDataTool(dataTool); 
		dataToolSteps.filterExpandSearchSelectGeography(geography);
		dataToolSteps.filterExpandSearchSelectIndicator(indicator);
//		dataToolSteps.filterExpandSelectDateRanges(dateRanges);
		dataToolSteps.clickFilterDisplayDataButton();
		dataAndForecastingSteps.selectDisplayData();
		dataToolSteps.verifyChart();
		dataToolSteps.clearFiltersInDataTool(text);
		Sleeper.sleepTight(5000);
		
		
		
	}
}
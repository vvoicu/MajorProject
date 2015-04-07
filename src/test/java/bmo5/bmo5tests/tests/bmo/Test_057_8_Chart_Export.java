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
import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.HomePage.Pillars.DataAndForecasting.DataTool.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX
		+ "Test_057_8_Chart_Export.csv", separator = ',')


public class Test_057_8_Chart_Export extends TestCase{
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	public String username, password, geography, indicator, dateRanges, filePath, formatJpg, formatPng, extentionJpg, extentionPng, extentionXls,dataTool;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setGeography(String geography){
		this.geography = geography;
	}

	public void setIndicator(String indicator){
		this.indicator = indicator;
	}
	
	public void setDateRanges(String dateRanges){
		this.dateRanges = dateRanges;
	}

	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Test
	public void test_057_8_Chart_Export() {
		loginSteps.performLogin(username, password);
//		dataToolSteps.goFullScreen();
		dataAndForecastingSteps.selectDataTool(dataTool);
		dataToolSteps.filterExpandSearchSelectGeography(geography);
		dataToolSteps.filterExpandSearchSelectIndicator(indicator);
		dataToolSteps.clickFilterDisplayDataButton();
		dataToolSteps.clickOnExportButton();
		dataToolSteps.verifyExportWindowDefaultState();
		
		dataToolSteps.verifyExportChart(formatJpg, extentionJpg);
		dataToolSteps.verifyExportChart(formatPng, extentionPng);
		dataToolSteps.clickOnTableRadioButton();
		dataToolSteps.verifyExportTable(extentionXls);
		dataToolSteps.clickOnTableAndChartRadioButton();
		dataToolSteps.verifyExportChartAndTable(extentionXls);
	}
}
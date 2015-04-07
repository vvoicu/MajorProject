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
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelTwoSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomeSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.KeyGlobalViews.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_RegularUser_KeyGlobalForecasts.csv", separator = ',')

public class Test_RegularUser_KeyGlobalForecasts extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	
	@Steps
	public HomePageLevelTwoSteps homePageLevelTwoSteps;
	
	@Steps
	public HomeSteps homeSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	public String username, password, keyGlobalForecastsBreadcrumbs, firstIndicator, secondIndicator, firstValueOfFirstYear, secondValueOfFirstYear, savedDataName, extentionXls, formatJpg, extentionJpg, 
	formatPng, extentionPng;
	public int firstElementFromTable,secondElementFromTable,thirdElementFromTable;
	@Test
	public void test_RegularUser_KeyGlobalForecasts() {
		loginSteps.performLogin(username, password);		
		homePageHeaderSteps.clickOnLogo();
		firstIndicator = homePageLevelTwoSteps.getCellValueFromKeyGlobalForecasts(firstElementFromTable,firstElementFromTable);
		secondIndicator = homePageLevelTwoSteps.getCellValueFromKeyGlobalForecasts(secondElementFromTable,firstElementFromTable);
		firstValueOfFirstYear = homePageLevelTwoSteps.getCellValueFromKeyGlobalForecasts(firstElementFromTable,secondElementFromTable);
		secondValueOfFirstYear = homePageLevelTwoSteps.getCellValueFromKeyGlobalForecasts(secondElementFromTable,secondElementFromTable);
		homePageLevelTwoSteps.clickOnKeyGlobalForecasts();
		homePageHeaderSteps.verifyBreadCrumbs(keyGlobalForecastsBreadcrumbs);
		dataToolSteps.verifyIfActionIconsAreEnabled();
		dataToolSteps.getCellValueFromTableAndVerify(firstIndicator,firstElementFromTable,secondElementFromTable);
		dataToolSteps.getCellValueFromTableAndVerify(secondIndicator,secondElementFromTable,secondElementFromTable);
		dataToolSteps.getCellValueFromTableAndVerify(firstValueOfFirstYear,firstElementFromTable,thirdElementFromTable);
		dataToolSteps.getCellValueFromTableAndVerify(secondValueOfFirstYear,secondElementFromTable,thirdElementFromTable);
		dataAndForecastingSteps.clickOnDownloadDataTool(extentionXls);
		dataToolSteps.clickOnExportButton();
		dataToolSteps.verifyExportWindowDefaultState();
		dataToolSteps.verifyExportChart(formatJpg, extentionJpg);
		dataToolSteps.verifyExportChart(formatPng, extentionPng);
		dataToolSteps.clickOnTableRadioButton();
		dataToolSteps.verifyExportTable(extentionXls);
		dataToolSteps.clickOnTableAndChartRadioButton();
		dataToolSteps.verifyExportChartAndTable(extentionXls);
		dataToolSteps.clickOnSaveChart();
		bmiDatabasesGeneralSteps.saveNameChart(savedDataName);
	}
}

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
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelTwoSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Trial.HomePage.KeyGlobalForecast.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_TrialUser_KeyGlobalForecasts.csv", separator = ',')

public class Test_TrialUser_KeyGlobalForecasts extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HomePageLevelOneSteps homePageLevelOneSteps;
	
	@Steps 
	public SingleArticleSteps singleArticleSteps;
	
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public HomePageLevelTwoSteps homePageLevelTwoSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	public String username, password, extention, savedDataName, firstIndicator, secondIndicator, firstValueOfFirstYear, secondValueOfFirstYear, keyGlobalForecastsBreadcrumbs;
	public int firstElementFromTable,secondElementFromTable,thirdElementFromTable;
	
	@Test
	public void test_TrialUser_KeyGlobalForecasts() {
		loginSteps.performLogin(username, password);		
		homePageHeaderSteps.clickOnLogo();
		firstIndicator = homePageLevelTwoSteps.getCellValueFromKeyGlobalForecasts(firstElementFromTable,firstElementFromTable);
		secondIndicator = homePageLevelTwoSteps.getCellValueFromKeyGlobalForecasts(secondElementFromTable,firstElementFromTable);
		firstValueOfFirstYear = homePageLevelTwoSteps.getCellValueFromKeyGlobalForecasts(firstElementFromTable,secondElementFromTable);
		secondValueOfFirstYear = homePageLevelTwoSteps.getCellValueFromKeyGlobalForecasts(secondElementFromTable,secondElementFromTable);
		homePageLevelTwoSteps.clickOnKeyGlobalForecasts();
		homePageHeaderSteps.verifyBreadCrumbs(keyGlobalForecastsBreadcrumbs);
		dataToolSteps.getCellValueFromTableAndVerify(firstIndicator,firstElementFromTable,secondElementFromTable);
		dataToolSteps.getCellValueFromTableAndVerify(secondIndicator,secondElementFromTable,secondElementFromTable);
		dataToolSteps.getCellValueFromTableAndVerify(firstValueOfFirstYear,firstElementFromTable,thirdElementFromTable);
		dataToolSteps.getCellValueFromTableAndVerify(secondValueOfFirstYear,secondElementFromTable,thirdElementFromTable);
		dataToolSteps.clickFilterDisplayDataButton();
		dataToolSteps.clickFilterDownloadButtonTrialUser(extention);
		dataToolSteps.clickOnPrintChartTrialUser();
		dataToolSteps.verifyExportTrialUser();
		dataToolSteps.clickOnSaveChart();
		bmiDatabasesGeneralSteps.saveNameChart(savedDataName);
	}
}

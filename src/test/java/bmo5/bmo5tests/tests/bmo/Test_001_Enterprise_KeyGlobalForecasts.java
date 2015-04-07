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
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Enterprise.HomePage.KeyGlobalForecast.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enterprise_KeyGlobalForecasts.csv", separator = ',')


public class Test_001_Enterprise_KeyGlobalForecasts extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST_IP)
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
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	@Steps
	public HomePageLevelTwoSteps homePageLevelTwoSteps;
	
	public String username, password, extensionFile, firstIndicator, secondIndicator, firstValueOfFirstYear, secondValueOfFirstYear, keyGlobalForecastsBreadcrumbs;
	public int firstElementFromTable,secondElementFromTable,thirdElementFromTable;
	
	@Test
	public void test_001_Enterprise_KeyGlobalForecasts() {
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
		dataToolSteps.clickSaveButtonEnterpriseUser();
		dataAndForecastingSteps.clickOnDownloadDataTool(extensionFile);
	}
}

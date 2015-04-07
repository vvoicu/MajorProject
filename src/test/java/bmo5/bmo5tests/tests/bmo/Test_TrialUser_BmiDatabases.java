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
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BmiDatabasesFeedInTariffsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Trial.Pillars.DataAndForecasting.BmiDatabases.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_TrialUser_BmiDatabases.csv", separator = ',')

public class Test_TrialUser_BmiDatabases extends TestCase{

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarSteps;
	
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	@Steps
	public BmiDatabasesFeedInTariffsSteps bmiDatabasesFeedInTariffsSteps;
	
	String username, password, geography, indicatorOne, operator, sindicator, tindicator, age, gender, indicatorTwo, region, threeLetters, option, year, extension, dataToolBreadcrumbs,dataTool, bmiDatabasesBreadcrumbs, databaseName, indicator, savedDataName;
	
	@Test
	public void test_TrialUser_BmiDatabases() {
		loginSteps.performLogin(username, password);	
		homePagePillarSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);
		
		if(databaseName.equals("Infrastructure Key Projects") || databaseName.equals("Power Key Projects") || databaseName.equals("Renewable Key Projects") 
				|| databaseName.equals("Upstream Projects") || databaseName.equals("Global Refineries") || databaseName.equals("Global Mines")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
			Sleeper.sleepTight(5000);
			dataToolSteps.clickFilterDownloadButtonTrialUser(extension);
			dataToolSteps.verifyExportTrialUser();
			dataToolSteps.clickOnSaveChart();
			bmiDatabasesGeneralSteps.saveNameChart(savedDataName);
		}
		else if(databaseName.equals("Mobile Operators")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			bmiDatabasesGeneralSteps.selectOperator(operator);
			bmiDatabasesGeneralSteps.selectIndicator(indicator);
			
			bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
			dataToolSteps.clickOnExportButton();
			dataToolSteps.clickFilterDownloadButtonTrialUser(extension);
			dataToolSteps.clickOnPrintChartTrialUser();
			dataToolSteps.verifyExportTrialUser();
			dataToolSteps.clickOnSaveChart();
			bmiDatabasesGeneralSteps.saveNameChart(savedDataName);
		}
		else if(databaseName.equals("Burden of Disease")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			bmiDatabasesGeneralSteps.selectIndicator(indicator);
			bmiDatabasesGeneralSteps.selectAge(age);
			bmiDatabasesGeneralSteps.selectGender(gender);
			
			bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
			dataToolSteps.clickOnExportButton();
			dataToolSteps.clickFilterDownloadButtonTrialUser(extension);
			dataToolSteps.clickOnPrintChartTrialUser();
			dataToolSteps.verifyExportTrialUser();
			dataToolSteps.clickOnSaveChart();
			bmiDatabasesGeneralSteps.saveNameChart(savedDataName);
		}
		else if(databaseName.equals("Feed In Tariffs")){
			bmiDatabasesGeneralSteps.checkOneRegion(region);
			bmiDatabasesFeedInTariffsSteps.clickOnSectorToggler();
			bmiDatabasesFeedInTariffsSteps.insertLettersInSectorInputBox(threeLetters);
			bmiDatabasesFeedInTariffsSteps.checkSector(option);
			bmiDatabasesFeedInTariffsSteps.clickOnDateRangesToggler();
			bmiDatabasesFeedInTariffsSteps.checkOneYearFromDateRangesSection(year);
			dataToolSteps.clickFilterDownloadButtonTrialUser(extension);
		}
	}
}

package bmo5.bmo5tests.tests.bmo;

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
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesKeyProjectsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesMobileOperatorsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import junit.framework.TestCase;

@Story(Application.Enterprise.Pillars.DataAndForecasting.BmiDatabases.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enterprise_BmiDatabases.csv", separator = ',')

public class Test_001_Enterprise_BmiDatabases extends TestCase{

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST_IP)
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
	public BMIDatabasesMobileOperatorsSteps bmiDatabasesMobileOperatorsSteps;
	
	@Steps
	public BMIDatabasesKeyProjectsSteps bmiDatabasesKeyProjectsSteps;
	
	String username, password, geography, indicatorOne, operator, sindicator, tindicator, age, gender, indicatorTwo, dataToolBreadcrumbs, bmiDatabasesBreadcrumbs,dataTool,  formatJpg, 
	formatPng, extentionJpg, extentionPng, extentionXls, extensionFile, databaseName, indicator, sector, renewable, fuelType;

	@Test
	public void test_001_Enterprise_BmiDatabases() {
		homePagePillarSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);
		
		if(databaseName.equals("Infrastructure Key Projects") || databaseName.equals("Power Key Projects") || databaseName.equals("Renewable Key Projects") 
				|| databaseName.equals("Upstream Projects") || databaseName.equals("Global Refineries") || databaseName.equals("Global Mines")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			if(databaseName.equals("Infrastructure Key Projects") || databaseName.equals("Power Key Projects") || databaseName.equals("Renewable Key Projects")){
				bmiDatabasesKeyProjectsSteps.clickOnSectorToggler();
				if(databaseName.equals("Power Key Projects")){
					bmiDatabasesKeyProjectsSteps.checkUncheckASectorAndVerify(fuelType);
				}
				else if(databaseName.equals("Renewable Key Projects")){
					bmiDatabasesKeyProjectsSteps.checkUncheckASectorAndVerify(renewable);
				}
				else{
					bmiDatabasesKeyProjectsSteps.checkUncheckASectorAndVerify(sector);
				}
			}
			bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
			Sleeper.sleepTight(5000);
			dataToolSteps.clickSaveButtonEnterpriseUser();
			dataToolSteps.clickOnExportButton();
			dataToolSteps.verifyExportTable(extentionXls);
			dataAndForecastingSteps.clickOnDownloadDataTool(extentionXls);
		}
		else if(databaseName.equals("Mobile Operators")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			bmiDatabasesGeneralSteps.selectOperator(operator);
			bmiDatabasesGeneralSteps.selectIndicator(indicator);
			
			bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
			dataToolSteps.clickSaveButtonEnterpriseUser();
			dataToolSteps.clickOnExportButton();
			dataToolSteps.verifyExportChart(formatJpg, extentionJpg);
			dataToolSteps.verifyExportChart(formatPng, extentionPng);
			dataToolSteps.clickOnTableRadioButton();
			dataToolSteps.verifyExportTable(extentionXls);
			dataToolSteps.clickOnTableAndChartRadioButton();
			dataToolSteps.verifyExportChartAndTable(extentionXls);
			dataAndForecastingSteps.clickOnDownloadDataTool(extentionXls);
		}
		else if(databaseName.equals("Burden of Disease")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			bmiDatabasesGeneralSteps.selectIndicator(indicator);
			bmiDatabasesGeneralSteps.selectAge(age);
			bmiDatabasesGeneralSteps.selectGender(gender);
			
			bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
			dataToolSteps.clickSaveButtonEnterpriseUser();
			dataToolSteps.clickOnExportButton();
			dataToolSteps.verifyExportChart(formatJpg, extentionJpg);
			dataToolSteps.verifyExportChart(formatPng, extentionPng);
			dataToolSteps.clickOnTableRadioButton();
			dataToolSteps.verifyExportTable(extentionXls);
			dataToolSteps.clickOnTableAndChartRadioButton();
			dataToolSteps.verifyExportChartAndTable(extentionXls);
			dataAndForecastingSteps.clickOnDownloadDataTool(extentionXls);
		}
	}
}

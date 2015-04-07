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
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesBurdenOfDiseaseSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesKeyProjectsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesMobileOperatorsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.DataAndForecasting.BmiDatabases.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_060_12_BMIDatabases_DvPacks_Chart_Export.csv", separator = ',')

public class Test_060_12_BmiDatabases_DvPacks_Chart_Export extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	@Steps
	public BMIDatabasesMobileOperatorsSteps bmiDatabasesMobileOperatorsSteps;
	
	@Steps
	public BMIDatabasesBurdenOfDiseaseSteps bmiDatabasesBurdenOfDiseaseSteps;

	@Steps
	public BMIDatabasesKeyProjectsSteps bmiDatabasesKeyProjectsSteps;
	
	public String username, password, databaseName,geography,operator,indicator,year,gender,age, formatJpg, formatPng,  extentionJpg, extentionPng, extentionXls, bmiDatabasesBreadcrumbs,
	sector, fuelType, renewable;
	int statusNumber;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void setDatabaseName(String databaseName) {
		this.databaseName= databaseName;
	}
	public void setGeography(String geography) {
		this.geography = geography;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	@Test
	public void test_060_12_BMIDatabases_DvPacks_Chart_Export() {
		loginSteps.performLogin(username, password);
//		dataToolSteps.goFullScreen();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);

		if(databaseName.equals("Infrastructure Key Projects") || databaseName.equals("Power Key Projects") || databaseName.equals("Renewable Key Projects") 
				|| databaseName.equals("Upstream Projects") || databaseName.equals("Global Refineries") || databaseName.equals("Global Mines")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			if(databaseName.equals("Infrastructure Key Projects")){
				bmiDatabasesKeyProjectsSteps.clickOnSectorToggler();
				bmiDatabasesKeyProjectsSteps.checkUncheckASectorAndVerify(sector);
			}
			else if(databaseName.equals("Power Key Projects")){
				bmiDatabasesKeyProjectsSteps.clickOnSectorToggler();
				bmiDatabasesKeyProjectsSteps.checkUncheckASectorAndVerify(fuelType);
			}
			else if(databaseName.equals("Renewable Key Projects")){
				bmiDatabasesKeyProjectsSteps.clickOnSectorToggler();
				bmiDatabasesKeyProjectsSteps.checkUncheckASectorAndVerify(renewable);
			}
			bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
			Sleeper.sleepTight(5000);
			dataToolSteps.clickOnExportButton();
			dataToolSteps.clickOnTableRadioButton();
			dataToolSteps.verifyExportTable(extentionXls);
		}
		else if(databaseName.equals("Mobile Operators")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			bmiDatabasesGeneralSteps.selectOperator(operator);
			bmiDatabasesGeneralSteps.selectIndicator(indicator);
			
			bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
			dataToolSteps.clickOnExportButton();
			dataToolSteps.verifyExportChart(formatJpg, extentionJpg);
			dataToolSteps.verifyExportChart(formatPng, extentionPng);
			dataToolSteps.clickOnTableRadioButton();
			dataToolSteps.verifyExportTable(extentionXls);
			dataToolSteps.clickOnTableAndChartRadioButton();
			dataToolSteps.verifyExportChartAndTable(extentionXls);
		}
		else if(databaseName.equals("Burden of Disease")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			bmiDatabasesGeneralSteps.selectIndicator(indicator);
			bmiDatabasesGeneralSteps.selectAge(age);
			bmiDatabasesGeneralSteps.selectGender(gender);
			
			bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
			Sleeper.sleepTight(6000);
			dataToolSteps.clickOnExportButton();
			dataToolSteps.verifyExportChart(formatJpg, extentionJpg);
			dataToolSteps.verifyExportChart(formatPng, extentionPng);
			dataToolSteps.clickOnTableRadioButton();
			dataToolSteps.verifyExportTable(extentionXls);
			dataToolSteps.clickOnTableAndChartRadioButton();
			dataToolSteps.verifyExportChartAndTable(extentionXls);
		}
	}
}
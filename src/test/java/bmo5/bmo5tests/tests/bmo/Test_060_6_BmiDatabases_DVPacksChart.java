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
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesBurdenOfDiseaseSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesMobileOperatorsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.DataAndForecasting.BmiDatabases.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_060_6_BmiDatabases_DVPacks_Chart.csv", separator = ',')

public class Test_060_6_BmiDatabases_DVPacksChart extends TestCase {
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
	
	public String username, password, databaseName,region,operator,indicator,operatorSearchArea,bmiDatabasesBreadcrumbs, continent, letter, year, age, gender, country;
	int statusNumber;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void operatorSearchArea(String operatorSearchArea) {
		this.operatorSearchArea = operatorSearchArea;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	
	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	public void setLetter(String letter) {
		this.letter = letter;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Test
	public void test_060_6_BmiDatabases_DVPacks_Chart() {
		loginSteps.performLogin(username, password);
		dataToolSteps.goFullScreen();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);
		
		if(databaseName.equals("Infrastructure Key Projects")){
			bmiDatabasesGeneralSteps.testNotAvailableForDatabaseName(databaseName);
		}
		else if(databaseName.equals("Power Key Projects")){
			bmiDatabasesGeneralSteps.testNotAvailableForDatabaseName(databaseName);
		}
		else if(databaseName.equals("Renewables Key Projects")){
			bmiDatabasesGeneralSteps.testNotAvailableForDatabaseName(databaseName);
		}
		else if(databaseName.equals("Upstream Projects")){
			bmiDatabasesGeneralSteps.testNotAvailableForDatabaseName(databaseName);
		}
		else if(databaseName.equals("Global Refineries")){
			bmiDatabasesGeneralSteps.testNotAvailableForDatabaseName(databaseName);
		}
		else if(databaseName.equals("Global Mines")){
			bmiDatabasesGeneralSteps.testNotAvailableForDatabaseName(databaseName);
		}
		else if(databaseName.equals("Mobile Operators")){
			bmiDatabasesMobileOperatorsSteps.checkOneRegion(continent);
			bmiDatabasesMobileOperatorsSteps.clickOnOperatorToggler();
			bmiDatabasesMobileOperatorsSteps.checkOneLetterFromOperatorSection(letter);
			bmiDatabasesMobileOperatorsSteps.clickOnIndicatorToggler();
			bmiDatabasesMobileOperatorsSteps.checkOneIndicatorFromIndicatorSection(indicator);
			bmiDatabasesMobileOperatorsSteps.clickOnDateRangesToggler();
			bmiDatabasesMobileOperatorsSteps.verifyDateRangesFilter(year);
		}
		else if(databaseName.equals("Burden of Disease")){
			bmiDatabasesGeneralSteps.selectGeography(country);
			bmiDatabasesBurdenOfDiseaseSteps.clickOnIndicatorToggler();
			bmiDatabasesBurdenOfDiseaseSteps.verifyIndicatorFilter(indicator);
			bmiDatabasesBurdenOfDiseaseSteps.clickOnAgeToggler();
			bmiDatabasesBurdenOfDiseaseSteps.verifyAgeFilter(age);
			bmiDatabasesBurdenOfDiseaseSteps.clickOnGenderToggler();
			bmiDatabasesBurdenOfDiseaseSteps.verifyGenderFilter(gender);
			bmiDatabasesBurdenOfDiseaseSteps.clickOnDateRangesToggler();
			bmiDatabasesBurdenOfDiseaseSteps.verifyDateRangeFilter(year);
		}
		
		bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
		dataToolSteps.verifyChart();
		bmiDatabasesGeneralSteps.clearFiltersLink();
		
		if(databaseName.equals("Infrastructure Key Projects")){
			bmiDatabasesGeneralSteps.testNotAvailableForDatabaseName(databaseName);
		}
		else if(databaseName.equals("Power Key Projects")){
			bmiDatabasesGeneralSteps.testNotAvailableForDatabaseName(databaseName);
		}
		else if(databaseName.equals("Renewables Key Projects")){
			bmiDatabasesGeneralSteps.testNotAvailableForDatabaseName(databaseName);
		}
		else if(databaseName.equals("Upstream Projects")){
			bmiDatabasesGeneralSteps.testNotAvailableForDatabaseName(databaseName);
		}
		else if(databaseName.equals("Global Refineries")){
			bmiDatabasesGeneralSteps.testNotAvailableForDatabaseName(databaseName);
		}
		else if(databaseName.equals("Global Mines")){
			bmiDatabasesGeneralSteps.testNotAvailableForDatabaseName(databaseName);
		}
		else if(databaseName.equals("Mobile Operators")){
			bmiDatabasesMobileOperatorsSteps.verifyFiltersAreClered();
		}
		else if(databaseName.equals("Burden of Disease")){
			bmiDatabasesBurdenOfDiseaseSteps.verifyFiltersAreCleared();
		}
	}
}
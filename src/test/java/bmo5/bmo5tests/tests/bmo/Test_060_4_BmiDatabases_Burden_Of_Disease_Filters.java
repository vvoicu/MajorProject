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
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.DataAndForecasting.BmiDatabases.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_060_4_BMIDatabases_BurdenOfDiseaseFilters.csv", separator = ',')

public class Test_060_4_BmiDatabases_Burden_Of_Disease_Filters extends TestCase {
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
	public BMIDatabasesBurdenOfDiseaseSteps bmiDatabasesBurdenOfDiseaseSteps;
	
	public String username, password, databaseName, continent, age, indicator, year, gender, bmiDatabasesBreadcrumbs, dvPackName, name;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	
	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Test
	public void test_060_4_BmiDatabases_Burden_Of_Disease_Filters() {
		loginSteps.performLogin(username, password);
//		dataToolSteps.goFullScreen();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);
		
		bmiDatabasesGeneralSteps.verifyGeographyFilter(continent);

		bmiDatabasesBurdenOfDiseaseSteps.clickOnIndicatorToggler();
		bmiDatabasesBurdenOfDiseaseSteps.verifyIndicatorFilter(indicator);
		
		bmiDatabasesBurdenOfDiseaseSteps.clickOnAgeToggler();
		bmiDatabasesBurdenOfDiseaseSteps.verifyAgeFilter(age);
		
		bmiDatabasesBurdenOfDiseaseSteps.clickOnGenderToggler();
		bmiDatabasesBurdenOfDiseaseSteps.verifyGenderFilter(gender);
		
		bmiDatabasesBurdenOfDiseaseSteps.clickOnDateRangesToggler();
		bmiDatabasesBurdenOfDiseaseSteps.verifyDateRangeFilter(year);
		
		bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
		
		dataToolSteps.saveDataChart();
		bmiDatabasesGeneralSteps.cancelFromSaveDialogWindowOfDataChart();
		dataToolSteps.saveDataChart();
		dvPackName = bmiDatabasesGeneralSteps.saveNameChart(name);
		bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
		bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(dvPackName);
		
		bmiDatabasesBurdenOfDiseaseSteps.verifyFiltersAfterOpeningSavedData(continent, indicator, age, gender, year);
	}
}

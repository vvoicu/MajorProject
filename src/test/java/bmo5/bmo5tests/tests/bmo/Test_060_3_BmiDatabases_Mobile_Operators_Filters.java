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
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesMobileOperatorsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.DataAndForecasting.BmiDatabases.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_060_3_BMIDatabases_MobileOperatorsFilters.csv", separator = ',')

public class Test_060_3_BmiDatabases_Mobile_Operators_Filters extends TestCase {
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
	
	public String username, password, databaseName, continent, letter, indicator, year, bmiDatabasesBreadcrumbs, dvPackName, name;
	
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
	
	public void setLetter(String letter) {
		this.letter = letter;
	}
	
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Test
	public void test_060_3_BmiDatabases_Mobile_Operators_Filters() {
		loginSteps.performLogin(username, password);
		dataToolSteps.goFullScreen();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);
		
		bmiDatabasesMobileOperatorsSteps.verifyGeographyFilter(continent);
		
		bmiDatabasesMobileOperatorsSteps.clickOnOperatorToggler();
		bmiDatabasesMobileOperatorsSteps.verifyOperatorsFilter(letter);
		
		bmiDatabasesMobileOperatorsSteps.clickOnIndicatorToggler();
		bmiDatabasesMobileOperatorsSteps.verifyIndicatorFilter(indicator);
		
		bmiDatabasesMobileOperatorsSteps.clickOnDateRangesToggler();
		bmiDatabasesMobileOperatorsSteps.verifyDateRangesFilter(year);
		
		bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
		dataToolSteps.verifyChart();
		
		dataToolSteps.saveDataChart();
		bmiDatabasesGeneralSteps.cancelFromSaveDialogWindowOfDataChart();
		dataToolSteps.saveDataChart();
		dvPackName = bmiDatabasesGeneralSteps.saveNameChart(name);
		bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
		bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(dvPackName);
		
		bmiDatabasesMobileOperatorsSteps.verifyFiltersAfterOpeningSavedData(continent, letter, indicator, year);
	}
}

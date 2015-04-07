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
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGlobalMinesSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesMobileOperatorsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.DataAndForecasting.BmiDatabases.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_060_7_BMIDatabases_MobileOperatorsTable.csv", separator = ',')


public class Test_060_7_BmiDatabases_Mobile_Operators_Table extends TestCase {
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
	public BMIDatabasesGlobalMinesSteps bmiDatabasesGlobalMinesSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	@Steps
	public BMIDatabasesMobileOperatorsSteps bmiDatabasesMobileOperatorsSteps;
	
	public String username, password, databaseName, continent, letter, indicator, year, bmiDatabasesBreadcrumbs;
	
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
	
	@Test
	public void test_060_7_BmiDatabases_Mobile_Operators_Table() {
		loginSteps.performLogin(username, password);
		dataToolSteps.goFullScreen();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);
		
		bmiDatabasesMobileOperatorsSteps.checkOneRegion(continent);
		
		bmiDatabasesMobileOperatorsSteps.clickOnOperatorToggler();
		bmiDatabasesMobileOperatorsSteps.checkOneLetterFromOperatorSection(letter);
		
		bmiDatabasesMobileOperatorsSteps.clickOnIndicatorToggler();
		bmiDatabasesMobileOperatorsSteps.checkOneIndicatorFromIndicatorSection(indicator);
		
		bmiDatabasesMobileOperatorsSteps.clickOnDateRangesToggler();
		bmiDatabasesMobileOperatorsSteps.checkOneYearFromDateRangesSection(year);
		
		bmiDatabasesMobileOperatorsSteps.clickOnDisplayDataButton();
		
		bmiDatabasesMobileOperatorsSteps.verifyGeographyInTable();
		bmiDatabasesMobileOperatorsSteps.verifyOperatorInTable();
		bmiDatabasesMobileOperatorsSteps.verifyIndicatorInTable();
		bmiDatabasesMobileOperatorsSteps.verifyDateRangesInTable(year);
	}
}

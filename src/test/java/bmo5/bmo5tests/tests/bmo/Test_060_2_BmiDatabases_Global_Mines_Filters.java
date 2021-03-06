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
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGlobalMinesSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesKeyProjectsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.DataAndForecasting.BmiDatabases.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_060_2_BMIDatabases_GlobalMinesFilters.csv", separator = ',')

public class Test_060_2_BmiDatabases_Global_Mines_Filters extends TestCase {
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
	public BMIDatabasesGlobalMinesSteps bmiDatabasesGlobalMinesSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	@Steps
	public BMIDatabasesKeyProjectsSteps bmiDatabasesKeyProjectsSteps;
	
	public String username, password, databaseName, continent, metal, letter, year, status, capexValue, oreGrandeValue, bmiDatabasesBreadcrumbs, name, dvPackName,cancel;
	
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
	
	public void setMetal(String metal) {
		this.metal = metal;
	}
	
	public void setLetter(String letter) {
		this.letter = letter;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setCapexValue(String capexValue) {
		this.capexValue = capexValue;
	}
	
	public void setOreGrandeValue(String oreGrandeValue) {
		this.oreGrandeValue = oreGrandeValue;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Test
	public void test_060_2_BmiDatabases_Global_Mines_Filters() {
		loginSteps.performLogin(username, password);
		dataToolSteps.goFullScreen();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);
		
		bmiDatabasesGeneralSteps.verifyGeographyFilter(continent);
		
		bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
		
		bmiDatabasesGlobalMinesSteps.clickOnFilterToggler();
		
		bmiDatabasesGlobalMinesSteps.clickOnMetalToggler();
		bmiDatabasesGlobalMinesSteps.verifyTheMetalFilter(metal);
		
		bmiDatabasesGlobalMinesSteps.clickOnCompanyToggler();
		bmiDatabasesGlobalMinesSteps.verifyCompanyFilter(letter);
		
		bmiDatabasesGlobalMinesSteps.clickOnCapexToggler();
		bmiDatabasesGlobalMinesSteps.selectCapexValue(capexValue);
		
		bmiDatabasesGlobalMinesSteps.clickOnOreGrandeToggler();
		bmiDatabasesGlobalMinesSteps.selectOreGrandeValue(oreGrandeValue);
		
		bmiDatabasesGlobalMinesSteps.clickOnStatusToggler();
		bmiDatabasesGlobalMinesSteps.verifyStatusFilter(status);
		
		bmiDatabasesKeyProjectsSteps.clickOnFilterButton();
		
		dataToolSteps.saveDataChart();
		bmiDatabasesGeneralSteps.cancelFromSaveDialogWindowOfDataChart();
		Sleeper.sleepTight(3000);
		dataToolSteps.saveDataChart();
		dvPackName = bmiDatabasesGeneralSteps.saveNameChart(name);
		bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
		bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(dvPackName);
		
		bmiDatabasesKeyProjectsSteps.verifyIfRegionIsChecked(continent);
		bmiDatabasesGlobalMinesSteps.clickOnFilterToggler();
		bmiDatabasesGlobalMinesSteps.verifyFiltersAfterOpeningSavedData(metal, letter, status);
	}
}

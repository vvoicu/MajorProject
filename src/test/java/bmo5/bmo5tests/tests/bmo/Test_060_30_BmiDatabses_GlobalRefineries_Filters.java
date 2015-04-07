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

import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGlobalMinesSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesKeyProjectsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BmiDatabasesGlobalRefineriesSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.DataAndForecasting.BmiDatabases.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_060_30_BmiDatabses_GlobalRefineries_Filters.csv", separator = ',')

public class Test_060_30_BmiDatabses_GlobalRefineries_Filters {
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
	public BMIDatabasesGlobalMinesSteps bmiDatabasesGlobalMinesSteps;
	
	@Steps
	public BMIDatabasesKeyProjectsSteps bmiDatabasesKeyProjectsSteps;
	
	@Steps
	public BmiDatabasesGlobalRefineriesSteps bmiDatabasesGlobalRefineriesSteps;
	
	public String username, password, databaseName, continent, status, bmiDatabasesBreadcrumbs, dvPackName, name, capacityBD, capacityTPA, startDateOperator, startDateYear, endDateOperator, endDateYear, letter;
	
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
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Test
	public void test_060_30_BmiDatabses_GlobalRefineries_Filters() {
		loginSteps.performLogin(username, password);
		dataToolSteps.goFullScreen();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);
		
		bmiDatabasesGeneralSteps.verifyGeographyFilter(continent);
		
		bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
		
		bmiDatabasesGlobalRefineriesSteps.clickOnFilterToggler();
		
		bmiDatabasesGlobalRefineriesSteps.verifyStatusFilter(status);
		
		bmiDatabasesGlobalRefineriesSteps.clickOnCapacityBDTogglerAndVerify();
		bmiDatabasesGlobalRefineriesSteps.selectCapacityBDFromDropDown(capacityBD);
		
		bmiDatabasesGlobalRefineriesSteps.clickOnCapacityTPATogglerAndVerify();
		bmiDatabasesGlobalRefineriesSteps.selectCapacityTPAFromDropDown(capacityTPA);
		
		bmiDatabasesGlobalRefineriesSteps.clickOnStartDateTogglerAndVerify();
		bmiDatabasesKeyProjectsSteps.selectOneOperatorFromStartDateSection(startDateOperator);
		bmiDatabasesKeyProjectsSteps.selectOneYearFromStartDateDropDownList(startDateYear);
		
		bmiDatabasesGlobalRefineriesSteps.clickOnEndDateTogglerAndVerify();
		bmiDatabasesKeyProjectsSteps.selectOneOperatorFromEndDateSection(endDateOperator);
		bmiDatabasesKeyProjectsSteps.selectOneYearFromEndDateDropDownList(endDateYear);
		
		bmiDatabasesGlobalRefineriesSteps.clickOnOwnerTogglerAndVerify();
		bmiDatabasesGlobalRefineriesSteps.verifyOwnerFilter(letter);
		
		bmiDatabasesKeyProjectsSteps.clickOnFilterButton();
		
		dataToolSteps.saveDataChart();
		bmiDatabasesGeneralSteps.cancelFromSaveDialogWindowOfDataChart();
		dataToolSteps.saveDataChart();
		dvPackName = bmiDatabasesGeneralSteps.saveNameChart(name);
		bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
		bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(dvPackName);
		
		bmiDatabasesGeneralSteps.verifyIfOneRegionIsChecked(continent);
		bmiDatabasesGlobalRefineriesSteps.clickOnFilterToggler();
		bmiDatabasesGlobalRefineriesSteps.verifyFiltersAfterOpeningSavedData(status, letter);
	}
}

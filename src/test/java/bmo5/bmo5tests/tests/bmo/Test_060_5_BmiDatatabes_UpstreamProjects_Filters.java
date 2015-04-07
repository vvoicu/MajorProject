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
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesKeyProjectsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesUpstreamProjectsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.HomePage.Pillars.DataAndForecasting.BmiDatabases.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_060_5_BmiDatatabes_UpstreamProjects_Filters.csv", separator = ',')

public class Test_060_5_BmiDatatabes_UpstreamProjects_Filters extends TestCase {
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
	public BMIDatabasesUpstreamProjectsSteps bmiDatabasesUpstreamProjectsSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	@Steps
	public BMIDatabasesKeyProjectsSteps bmiDatabasesKeyProjectsSteps;
	
	public String username, password, databaseName, continent, peakOilValue, peakGasValue, fromProjectCost, toProjectCost, onshoreOrOffshore, status, hydrocarbonType, character, bmiDatabasesBreadcrumbs, dvPackName, name;
	
	public void setName(String name){
		this.name = name;
	}
	
	@Test
	public void test_060_5_BmiDatatabes_UpstreamProjects_Filters() {
		loginSteps.performLogin(username, password);
		dataToolSteps.goFullScreen();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);
		bmiDatabasesUpstreamProjectsSteps.verifyLeftHandFilter();
		
		bmiDatabasesGeneralSteps.verifyGeographyFilter(continent);
		
		bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
		
		bmiDatabasesUpstreamProjectsSteps.clickOnFilterToggler();
		
		bmiDatabasesUpstreamProjectsSteps.verifyCompaniesFiler(character);
		
		bmiDatabasesUpstreamProjectsSteps.clickOnStatusToggler();
		bmiDatabasesUpstreamProjectsSteps.verifyStatusFilter(status);
		
		bmiDatabasesUpstreamProjectsSteps.clickOnProjectCostToggler();
		bmiDatabasesUpstreamProjectsSteps.insertValuesIntoProjectCostSection(fromProjectCost, toProjectCost);
		
		bmiDatabasesUpstreamProjectsSteps.clickOnPeakOilToggler();
		bmiDatabasesUpstreamProjectsSteps.selectValuesIntoPeakOilSection(peakOilValue);
		
		bmiDatabasesUpstreamProjectsSteps.clickOnPeakGasToggler();
		bmiDatabasesUpstreamProjectsSteps.selectValuesIntoPeakGasSection(peakGasValue);
		
		bmiDatabasesUpstreamProjectsSteps.clickOnOnshoreOffshoreToggler();
		bmiDatabasesUpstreamProjectsSteps.verifyOnshoreOffshoreFilter(onshoreOrOffshore);
		
		bmiDatabasesUpstreamProjectsSteps.clickOnHydrocarbonToggler();
		bmiDatabasesUpstreamProjectsSteps.verifyHydrocarbonTypeFilter(hydrocarbonType);
		
		bmiDatabasesKeyProjectsSteps.clickOnFilterButton();
		
		dataToolSteps.saveDataChart();
		bmiDatabasesGeneralSteps.cancelFromSaveDialogWindowOfDataChart();
		dataToolSteps.saveDataChart();
		dvPackName = bmiDatabasesGeneralSteps.saveNameChart(name);
		bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
		bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(dvPackName);
		
		bmiDatabasesGeneralSteps.verifyIfOneRegionIsChecked(continent);
		bmiDatabasesUpstreamProjectsSteps.clickOnFilterToggler();
		bmiDatabasesUpstreamProjectsSteps.verifyRightHandFiltersAfterOpeningSavedData(character, status, fromProjectCost, toProjectCost, onshoreOrOffshore, hydrocarbonType);
		
//		bmiDatabasesUpstreamProjectsSteps.clickOnClearFilters();
//		bmiDatabasesUpstreamProjectsSteps.verifyLeftHandFilter();
//		bmiDatabasesGeneralSteps.checkOneRegion(continent);
//		bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
//		bmiDatabasesUpstreamProjectsSteps.verifyPaginator();
	}
}

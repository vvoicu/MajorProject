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
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_060_1_BMIDatabases_KeyProjects_Filters.csv", separator = ',')

public class Test_060_1_BmiDatabases_Key_Projects_Filters extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Steps
	public BMIDatabasesKeyProjectsSteps bmiDatabasesKeyProjectsSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	@Steps
	public BMIDatabasesUpstreamProjectsSteps bmiDatabasesUpstreamProjectsSteps;
	
	public String username, password, databaseName, letters, operatorOne, operatorTwo, operatorThree, operatorFour, fromInput, toInput, character, size, fromCapacity, toCapacity, fuelType, renewable, bmiDatabasesBreadcrumbs,continent, sector, status, startYear, endYear, name, dvPackName, fuelTypeId;
	int statusNumber;
	
	public void setName(String name){
		this.name = name;
	}
	
	@Test
	public void test_060_1_BmiDatabases_Key_Projects_Filters() {
		loginSteps.performLogin(username, password);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);
		
		bmiDatabasesKeyProjectsSteps.checkUncheckAContinentAndVerify(continent);
		
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
		
		bmiDatabasesKeyProjectsSteps.clickOnDisplayDataButton();
		
		bmiDatabasesKeyProjectsSteps.clickOnFilterToggler();
		
		bmiDatabasesUpstreamProjectsSteps.verifyCompaniesFiler(character);
		
		bmiDatabasesKeyProjectsSteps.clickOnStatusToggler();
		bmiDatabasesKeyProjectsSteps.verifyStatusFilter(status);
		
		bmiDatabasesKeyProjectsSteps.clickOnStartDateToggler();
		bmiDatabasesKeyProjectsSteps.selectOneOperatorFromStartDateSection(operatorThree);
		bmiDatabasesKeyProjectsSteps.selectOneYearFromStartDateDropDownList(startYear);
		
		bmiDatabasesKeyProjectsSteps.clickOnEndDateToggler();
		bmiDatabasesKeyProjectsSteps.selectOneOperatorFromEndDateSection(operatorTwo);
		bmiDatabasesKeyProjectsSteps.selectOneYearFromEndDateDropDownList(endYear);
		
		bmiDatabasesKeyProjectsSteps.clickOnValuesToggler();
		bmiDatabasesKeyProjectsSteps.completeFieldsValuesSection(fromInput, toInput);
		
		bmiDatabasesKeyProjectsSteps.clickOnCapacityToggler();
		bmiDatabasesKeyProjectsSteps.completeFieldsFromCapacitySection(size, fromCapacity, toCapacity);
		
		bmiDatabasesKeyProjectsSteps.clickOnFilterButton();
		
		dataToolSteps.saveDataChart();
		bmiDatabasesGeneralSteps.cancelFromSaveDialogWindowOfDataChart();
		dataToolSteps.saveDataChart();
		dvPackName = bmiDatabasesGeneralSteps.saveNameChart(name);
		bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
		bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(dvPackName);
		
		bmiDatabasesKeyProjectsSteps.verifyIfRegionIsChecked(continent);
		bmiDatabasesKeyProjectsSteps.clickOnSectorToggler();
		if(databaseName.equals("Power Key Projects")){
			fuelTypeId = bmiDatabasesKeyProjectsSteps.returnTheSectorId(fuelType);
			bmiDatabasesKeyProjectsSteps.verifyIfSectorIsChecked(fuelTypeId);
		}
		else if(databaseName.equals("Renewable Key Projects")){
			bmiDatabasesKeyProjectsSteps.verifyIfSectorIsChecked(renewable);
		}
		else{
			bmiDatabasesKeyProjectsSteps.verifyIfSectorIsChecked(sector);
		}
		
		bmiDatabasesKeyProjectsSteps.clickOnFilterToggler();
		bmiDatabasesKeyProjectsSteps.verifyFiltersAfterOpeningSavedData(character, status, fromInput, toInput, fromCapacity, toCapacity);
	}
}

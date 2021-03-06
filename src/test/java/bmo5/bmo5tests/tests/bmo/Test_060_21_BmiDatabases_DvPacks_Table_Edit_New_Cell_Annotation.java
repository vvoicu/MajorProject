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
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesKeyProjectsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesMobileOperatorsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.DataAndForecasting.BmiDatabases.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_060_21_BMIDatabases_DvPacks_Table_Edit_New_Cell_Annotation.csv", separator = ',')

public class Test_060_21_BmiDatabases_DvPacks_Table_Edit_New_Cell_Annotation extends TestCase {
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
	
	public String username,password,databaseName,geography,operator,indicator,year,gender,age,sindicator,tindicator,annotationType,description,newDescription,row,column, 
	bmiDatabasesBreadcrumbs, sector, fuelType, renewable;
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
	
	public void setSindicator(String sindicator){
		this.sindicator = sindicator;
	}
	
	public void setTindicator(String tindicator){
		this.tindicator = tindicator;
	}
	
	public void setAnnotationType(String annotationType){
		this.annotationType = annotationType;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setNewDescription(String newDescription){
		this.newDescription = newDescription;
	}
	
	public void setRow(String row){
		this.row = row;
	}
	
	public void setColumn(String column){
		this.column = column;
	}
	
	
	@Test
	public void test_060_21_BMIDatabases_DvPacks_Table_Edit_New_Cell_Annotation() {
		loginSteps.performLogin(username, password);
		dataToolSteps.goFullScreen();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);
		int size = bmiDatabasesGeneralSteps.filterSizeBeforeExpander();
		
		if(databaseName.equals("Infrastructure Key Projects")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			bmiDatabasesKeyProjectsSteps.clickOnSectorToggler();
			bmiDatabasesKeyProjectsSteps.checkUncheckASectorAndVerify(sector);
		}
		else if(databaseName.equals("Power Key Projects")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			bmiDatabasesKeyProjectsSteps.clickOnSectorToggler();
			bmiDatabasesKeyProjectsSteps.checkUncheckASectorAndVerify(fuelType);
		}
		else if(databaseName.equals("Renewable Key Projects")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			bmiDatabasesKeyProjectsSteps.clickOnSectorToggler();
			bmiDatabasesKeyProjectsSteps.checkUncheckASectorAndVerify(renewable);
		}
		else if(databaseName.equals("Upstream Projects")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
		}
		else if(databaseName.equals("Global Refineries")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
		}
		else if(databaseName.equals("Global Mines")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
		}
		else if(databaseName.equals("Mobile Operators")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			bmiDatabasesGeneralSteps.selectOperator(operator);
			bmiDatabasesGeneralSteps.selectIndicator(indicator);
		}
		else if(databaseName.equals("Burden of Disease")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			bmiDatabasesGeneralSteps.selectIndicator(indicator);
			bmiDatabasesGeneralSteps.selectOneIndicatorFromFilter(sindicator);
			bmiDatabasesGeneralSteps.selectOneIndicatorFromFilter(tindicator);
			bmiDatabasesGeneralSteps.selectAge(age);
			bmiDatabasesGeneralSteps.selectGender(gender);
		}
		
		bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
		bmiDatabasesGeneralSteps.waitFiltersExpander(size);
		dataToolSteps.tableAddAndVerifyNewCellAnnotationList(annotationType,description,row,column);
		dataToolSteps.tableAddAndVerifyEditedCellAnnotationList(description,newDescription,row,column);
		
	}
}
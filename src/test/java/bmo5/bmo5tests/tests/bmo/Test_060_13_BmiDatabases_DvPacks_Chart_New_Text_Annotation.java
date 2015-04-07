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
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_060_13_BMIDatabases_DvPacks_Chart_New_Text_Annotation.csv", separator = ',')

public class Test_060_13_BmiDatabases_DvPacks_Chart_New_Text_Annotation extends TestCase {
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
	
	public String username,password,databaseName,geography,operator,indicator,year,gender,age,annotationType,textSize,rotation,description,bmiDatabasesBreadcrumbs;
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
	
	public void setAnnotationType(String annotationType){
		this.annotationType = annotationType;
	}
	
	public void setTextSize(String textSize){
		this.textSize = textSize;
	}
	
	public void setRotation(String rotation){
		this.rotation = rotation;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	@Test
	public void test_060_13_BMIDatabases_DvPacks_Chart_New_Text_Annotation() {
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
			bmiDatabasesGeneralSteps.selectGeography(geography);
			bmiDatabasesGeneralSteps.selectOperator(operator);
			bmiDatabasesGeneralSteps.selectIndicator(indicator);
		}
		else if(databaseName.equals("Burden of Disease")){
			bmiDatabasesGeneralSteps.selectGeography(geography);
			bmiDatabasesGeneralSteps.selectIndicator(indicator);
			bmiDatabasesGeneralSteps.selectAge(age);
			bmiDatabasesGeneralSteps.selectGender(gender);
		}
		
		bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
		dataToolSteps.addAndVerifyNewChartTextAnnotation(annotationType,textSize,rotation,description);
		
	}
}
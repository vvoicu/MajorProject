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
import bmo5.bmo5tests.bmo.steps.pillars.BmiDatabasesFeedInTariffsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.HomePage.Pillars.DataAndForecasting.BmiDatabases.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_060_26_Bmi_Databases_FeedInTariffs.csv", separator = ',')


public class Test_060_26_Bmi_Databases_FeedInTariffs extends TestCase{
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
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	@Steps
	public BMIDatabasesMobileOperatorsSteps bmiDatabasesMobileOperatorsSteps;
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public BmiDatabasesFeedInTariffsSteps bmiDatabasesFeedInTarrifsSteps;
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	public String username, password, geography, indicator, databaseName,region,sector,threeLetters,option,year,bmiDatabasesBreadcrumbs,extensionFile;
	
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void databaseName(String databaseName){
		this.databaseName = databaseName;
	}

	public void setRegion(String region){
		this.region = region;
	}
	
	public void setSector(String sector){
		this.sector = sector;
	}
	
	public void setThreeLetters(String threeLetters){
		this.threeLetters = threeLetters;
	}
	public void setOption(String option){
		this.option = option;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	@Test
	public void test_060_26_Bmi_Databases_FeedInTariffs() {
		loginSteps.performLogin(username, password);
		dataToolSteps.goFullScreen();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabasesBreadcrumbs);
		bmiDatabasesGeneralSteps.clickOnOneDatabase(databaseName);
		bmiDatabasesGeneralSteps.checkOneRegion(region);
		bmiDatabasesFeedInTarrifsSteps.clickOnSectorToggler();
		bmiDatabasesFeedInTarrifsSteps.insertThreeLettersInInputBoxFromSectorSectionAndVerify(threeLetters);
		bmiDatabasesFeedInTarrifsSteps.checkOneOptionFromSectorFilter(option);
		bmiDatabasesFeedInTarrifsSteps.verifyIfOptionFromSectorFilterIsChecked(option);
		bmiDatabasesFeedInTarrifsSteps.clickOnDaterangesToggler();
		bmiDatabasesFeedInTarrifsSteps.checkOneYearFromDaterangesSection(year);
		bmiDatabasesMobileOperatorsSteps.downloadTheFeedInTariffsData(); //just clickable
		dataAndForecastingSteps.clickOnDownloadDataTool(extensionFile);
}
}
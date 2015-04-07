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
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.HomePage.Pillars.DataAndForecasting.DataTool.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX
		+ "Test_057_5_DataTool_SaveButton.csv", separator = ',')

public class Test_057_5_DataTool_SaveButton extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	@Steps
	public DataToolSteps dataToolSteps;
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	
	public String username, password, text, geography, indicator, Selectedindicator, name, dataTool, dateRanges, frequency, dvPackName;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void text(String text) {
		this.text = text;
	}
	public void geography(String geography) {
		this.geography = geography;
	}
	public void indicator(String indicator) {
		this.indicator =indicator;
	}
	public void Selectedindicator(String Selectedindicator) {
		this.Selectedindicator = Selectedindicator;
	}
	
	@Test
	public void test_057_5_DataTool_SaveButton() {
		loginSteps.performLogin(username, password);
		dataToolSteps.goFullScreen();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dataTool);
		dataToolSteps.filterExpandSearchSelectGeography(geography);
		dataToolSteps.filterContainerForDataTool(indicator,Selectedindicator);
		dataToolSteps.filterExpandSelectDateRanges(dateRanges);
		dataToolSteps.verifyFrequencyFilter(frequency);
		dataToolSteps.clickFilterDisplayDataButton();
		
		dataToolSteps.verifyChart();
		
		dataToolSteps.clickOnSaveChart();
		dvPackName = bmiDatabasesGeneralSteps.saveNameChart(name);
		bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
		bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(dvPackName);
		
		dataToolSteps.filterExpandSearchSelectGeographyVerify(geography);
		dataToolSteps.filterContainerForDataToolVerify(indicator, Selectedindicator);
		dataToolSteps.expandFilterDateRangesSection();
		dataToolSteps.verifyIfDateRangeIsChecked(dateRanges);
		dataToolSteps.clickOnFrequencyFilter();
		dataToolSteps.verifyIfFrequencyIsChecked(frequency);
	}
}
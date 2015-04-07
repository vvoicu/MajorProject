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
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Navigation.LessEntitlements.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_LessEntitlements_BMIDatabases.csv", separator = ',')

public class Test_LessEntitlements_BMIDatabases {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
    public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Steps
	public DailyAnalysisAndNewsSteps dailyAnalysisAndNewsSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	String username, password, entitledService, entitledGeography,serviceTop ,continentForEntitledGeo,geographyTop,bmiDatabases, databaseNumber;

	@Test
	public void test_LessEntitlements_BMIDatabases() {
		loginSteps.performLogin(username, password);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(bmiDatabases);
		bmiDatabasesGeneralSteps.verifyUnentitledDatabases(entitledService);
		bmiDatabasesGeneralSteps.verifyEntitledDatabasesAccordingToService(entitledService);
	    bmiDatabasesGeneralSteps.verifyEntitledDatabasesFromDropDownAccordingToService(entitledService);
		bmiDatabasesGeneralSteps.clickOnBMIDatabaseAccordingToService(entitledService, Integer.parseInt(databaseNumber));
		bmiDatabasesGeneralSteps.verifyEntitledDatabasesFromDropDownAccordingToService(entitledService);
		dailyAnalysisAndNewsSteps.verifyEntitledGeographyFromLeftHandFilter(entitledService,bmiDatabases,entitledGeography, continentForEntitledGeo);
	}
}

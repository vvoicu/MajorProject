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

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.bmo.steps.pillars.RatingsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.DataAndForecasting.Ratings.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_027_Ratings_SovereignRisk.csv", separator=',')

public class Test_027_Ratings_SovereignRisk  extends TestCase {
	
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public RatingsSteps ratingsSteps;
	
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	public String username,password,element,ratingName,country,indicator,value;
	
	
	@Test
	public void test_027_Ratings_SovereignRisk () {
		loginSteps.performLogin(username, password);
		dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
		dataAndForecastingSteps.selectOneRatingFromDropDownList(ratingName);
		ratingsSteps.clickOnBriefMethodology();
		ratingsSteps.closeMethodologyButton();
		Sleeper.sleepTight(7000);
		ratingsSteps.clickAndVerifySovereignMethodology();
		ratingsSteps.closeMethodologyButton();
		
		ratingsSteps.exapndGeographyFromFilter(country);
//		ratingsSteps.clickOnIndicatorsTogglerFromFilter();
		ratingsSteps.checkOneIndicatorFromList(indicator);
		ratingsSteps.clickOnSovereignRiskToggler(value);
		ratingsSteps.clickOnDisplayDataButton();
	}
}
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
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.bmo.steps.pillars.RatingsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Enterprise.Pillars.DataAndForecasting.Ratings.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enterprise_Ratings_Save.csv", separator=',')

public class Test_001_Enterprise_Ratings_Save extends TestCase {
	
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST_IP)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public RatingsSteps ratingsSteps;
	
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	public String element,rating,securityRisk,projectFinance,industryAutos,industryBanking,text,securityBr,financeBr,autosBr,bankingBr,food,foodBr,retail,retailBr,tourism,tourismBr,info,infoBr, infra, infraBr, insurance, insuranceBr, mining, miningBr, oil, oilBr, petro, petroBr, pharma, pharmaBr, power, powerBr, estate, estateBr, 
	renew, renewBr, telecom, telecomBr;
	int articleNumber,reportNumberList,reportNumber;
	
	@Test
	public void test_001_Enterprise_Ratings_Save() {
		
		dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
		dataAndForecastingSteps.clickCountryRiskTab();
		dataAndForecastingSteps.verifyBreadcrumbsForCountryRisk(text);
		ratingsSteps.saveRating();
		ratingsSteps.clickOnTheFirstCountryFromCRTable();
		ratingsSteps.saveRating();
		Sleeper.sleepTight(5000);
//		ratingsSteps.selectFromRatingDropdown(rating); // sovereign risk 
//		ratingsSteps.saveRating();
		ratingsSteps.selectFromRatingDropdown(securityRisk);
		dataAndForecastingSteps.verifyBreadcrumbRatings(securityBr);
		ratingsSteps.saveRating();
		ratingsSteps.clickOnFirstCountruForSecurityTable();
		ratingsSteps.saveRating();
		ratingsSteps.selectFromRatingDropdown(projectFinance);
		dataAndForecastingSteps.verifyBreadcrumbRatings(financeBr);
		ratingsSteps.saveRating();
		ratingsSteps.clickOnFirstCountruForSecurityTable();
		ratingsSteps.saveRating();
		ratingsSteps.selectFromRatingDropdown(industryAutos);
		dataAndForecastingSteps.verifyBreadcrumbRatings(autosBr);
		ratingsSteps.saveRating();
		ratingsSteps.clickOnFirstCountruForSecurityTable();
		ratingsSteps.saveRating();
		ratingsSteps.selectFromRatingDropdown(industryBanking);
		dataAndForecastingSteps.verifyBreadcrumbRatings(bankingBr);
		ratingsSteps.saveRating();
		ratingsSteps.clickOnFirstCountruForSecurityTable();
		ratingsSteps.saveRating();
		ratingsSteps.selectFromRatingDropdown(food);
		dataAndForecastingSteps.verifyBreadcrumbRatings(foodBr);
		ratingsSteps.saveRating();
		ratingsSteps.clickOnFirstCountruForSecurityTable();
		ratingsSteps.saveRating();
		ratingsSteps.selectFromRatingDropdown(retail);
		dataAndForecastingSteps.verifyBreadcrumbRatings(retailBr);
		ratingsSteps.saveRating();
		ratingsSteps.clickOnFirstCountruForSecurityTable();
		ratingsSteps.saveRating();
		ratingsSteps.selectFromRatingDropdown(tourism);
		dataAndForecastingSteps.verifyBreadcrumbRatings(tourismBr);
		ratingsSteps.saveRating();
		ratingsSteps.clickOnFirstCountruForSecurityTable();
		ratingsSteps.saveRating();
		ratingsSteps.verifyThePartOfRatingsRewards(info,infoBr, infra, infraBr, insurance, insuranceBr, mining, miningBr, oil, oilBr, petro, petroBr, pharma, pharmaBr, power, powerBr, estate, estateBr, renew, renewBr, telecom, telecomBr);
	
	}
}
	
		
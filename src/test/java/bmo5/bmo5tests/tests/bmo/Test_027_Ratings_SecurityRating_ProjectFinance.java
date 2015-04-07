package bmo5.bmo5tests.tests.bmo;


import junit.framework.TestCase;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.bmo.steps.pillars.RatingsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.DataAndForecasting.Ratings.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_027_Ratings_SecurityRating_ProjectFinance.csv", separator=',')

public class Test_027_Ratings_SecurityRating_ProjectFinance extends TestCase {
	
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
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Qualifier
	 public String getQualifier() {
      return ratingName;
  }
	public String username, password, element, savedRating, country, indicator, rating, ratingName, titleOfRating,one,projIndex, finance,operation,construction,securityIndex,domestic,shortTerm,geography,ratingIndustry,ratingSavedName,message,dateRange,regPeer,countryFilter,projRisk,moreMethodology, brief,parameterTitle, parameterBriefTitle, save; 

	@Test
	public void test_027_Ratings_SecurityRating_ProjectFinance() {
		loginSteps.performLogin(username, password);
		if (ratingName.equals("Security Risk")){
		dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
		dataAndForecastingSteps.selectOneRatingFromDropDownList(ratingName);
	//	ratingsSteps.verifyMethodologyOnRatingsIndustries(moreMethodology, brief, parameterTitle,save);
	//	ratingsSteps.verifyBriefOnRatingsIndustriesAndSecurity(moreMethodology, brief, parameterBriefTitle, save);
		ratingsSteps.verifyBriefAndMethodologyPresenceOnPage();
		dataToolSteps.goFullScreen();	
		ratingsSteps.verifySecurityRiskTable(titleOfRating,securityIndex,domestic,shortTerm);
		
	//	ratingsSteps.clickOnACountryFromTableSecurityRiskRating(country);
		ratingsSteps.selectACountryFromTheTable(country);
		Sleeper.sleepTight(10000);
		savedRating = ratingsSteps.saveRatingAsRegular(ratingSavedName,message);
		driver.navigate().refresh();
		Sleeper.sleepTight(7000);
		bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
		bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(savedRating);
		ratingsSteps.verifySavedRatingCR(one,geography);
		Sleeper.sleepTight(10000);
		ratingsSteps.downloadExcelRatingTable();
		Sleeper.sleepTight(10000);
		ratingsSteps.verifyCountryArticleOrPeerGroupTable(dateRange,regPeer);
		ratingsSteps.verifyDateRangeMatchesArticleDatesRiskSummary(dateRange);
		ratingsSteps. downloadRegionalPeerTable();		
		//ratingsSteps.exapndGeographyFromFilter(countryFilter);
		ratingsSteps.checkOneIndicatorFromList(indicator);
		ratingsSteps.clickOnRatingTogglerFromFilter();
		ratingsSteps.checkOneRatingFromList(rating);
		ratingsSteps.clickOnDisplayDataButton();
		}
		else {
		
		dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
		dataAndForecastingSteps.selectProjectFinance(projRisk);
		Sleeper.sleepTight(4000);
		//ratingsSteps.verifyMethodologyOnRatingsProjectRisk(moreMethodology, brief, parameterTitle, save);
		//ratingsSteps.verifyBriefOnRatingsProjectRisk(moreMethodology, brief, parameterBriefTitle, save);
		dataToolSteps.goFullScreen();	
		ratingsSteps.verifyProjectFinanceTable(titleOfRating,projIndex, finance,operation,construction);
		
		ratingsSteps.clickOnACountryFromTableSecurityRiskRating(country);
		ratingsSteps.selectACountryFromTheTable(country);
		Sleeper.sleepTight(10000);
		savedRating = ratingsSteps.saveRatingAsRegular(ratingSavedName,message);
		driver.navigate().refresh();
		Sleeper.sleepTight(7000);
		bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
		bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(savedRating);
		ratingsSteps.verifySavedRatingCR(one,geography);
		Sleeper.sleepTight(10000);
		ratingsSteps.downloadExcelRatingTable();
		Sleeper.sleepTight(10000);
		ratingsSteps.verifyCountryArticleOrPeerGroupTable(dateRange,regPeer);
		ratingsSteps.verifyDateRangeMatchesArticleDatesRiskSummary(dateRange);
		ratingsSteps. downloadRegionalPeerTable();		
		ratingsSteps.exapndGeographyFromFilter(country);
		ratingsSteps.checkOneIndicatorFromList(indicator);
		ratingsSteps.clickOnRatingTogglerFromFilter();
		ratingsSteps.checkOneRatingFromList(rating);
		ratingsSteps.clickOnDisplayDataButton();
		
		}
		
	}
}

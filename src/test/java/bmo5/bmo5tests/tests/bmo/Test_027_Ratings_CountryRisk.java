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

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.bmo.steps.pillars.RatingsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.DataAndForecasting.Ratings.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_027_Ratings_CountryRisk.csv", separator=',')

public class Test_027_Ratings_CountryRisk extends TestCase {
	
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
	
	@Qualifier
	 public String getElement() {
       return element;
   }
	
	public String username,password,element,name,geography,value,indicator,date,breadcrumb,one,shortTermP,longTermP,shortTermE, longTermE, opRisk,crIndex,message,regPeer,dateRange,moreMethodology, brief, parameterTitle,save,parameterBriefTitle,savedRating,ratingSavedName;
	
	
	@Test
	public void test_027_Ratings_CountryRisk() {
		loginSteps.performLogin(username, password);
		dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
		dataAndForecastingSteps.clickCountryRiskTab();
		//ratingsSteps.verifyMethodologyOnRatings(moreMethodology, brief, parameterTitle,save);
		//ratingsSteps.verifyBriefOnRatings(moreMethodology, brief, parameterBriefTitle, save);
		ratingsSteps.verifyBriefAndMethodologyPresenceOnPage();
	    ratingsSteps.verifyRatingsTable(shortTermP,longTermP,shortTermE, longTermE, opRisk,crIndex);
		//ratingsSteps.clickOnTheFirstCountryFromCRTable();
	    ratingsSteps.selectACountryFromTheTable(geography);
	    dataAndForecastingSteps.verifyBreadcrumbRatings(breadcrumb);
		Sleeper.sleepTight(10000);
		savedRating = ratingsSteps.saveRatingAsRegular(ratingSavedName,message);
		driver.navigate().refresh();
		Sleeper.sleepTight(7000);
		bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
		bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(savedRating);
		ratingsSteps.verifySavedRatingBrCR(breadcrumb);
		ratingsSteps.verifySavedRatingCR(one,geography);
		Sleeper.sleepTight(10000);
		ratingsSteps.downloadExcelRatingTable();
		Sleeper.sleepTight(10000);
		ratingsSteps.verifyCountryArticleOrPeerGroupTable(dateRange,regPeer);
		ratingsSteps.verifyDateRangeMatchesArticleDatesRiskSummary(dateRange);
		Sleeper.sleepTight(5000);
		ratingsSteps. downloadRegionalPeerTable();
		ratingsSteps.clickOnIndicatorsTogglerFromFilter();
		//ratingsSteps.exapndGeographyFromFilter(geography);
		ratingsSteps.checkOneIndicatorFromList(indicator);
		ratingsSteps.expandRiskRewardFromFilterForCountryRisk(value);
		//ratingsSteps.verifyCrRatingColumn(); 
		ratingsSteps.clickOnDisplayDataButton();
		
		
		
	}
}
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
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_027_Ratings_RiskRewardRatings.csv", separator=',')

public class Test_027_Ratings_RiskRewardRatings extends TestCase {

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
	
	public String username, password, element, savedRating, country, indicator, rating, ratingName, ratingSavedName,titleOfRating,breadcrumb,one,ratingIndustry,message,dateRange,regPeer,moreMethodology,brief,parameterTitle,save,parameterBriefTitle; 
	public String riskRewIndex,reward,risks,industryRisk,combinedIndex,upstreamIndex,downstreamIndex,riskRewardRet,rewardsRet,risksRet,rewards,risksMed,mdIndex;
	@Test
	public void test_027_Ratings_RiskRewardRating() {
		loginSteps.performLogin(username, password);
		if (ratingName.equals("-- Retail")) {
			dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
			dataAndForecastingSteps.selectOneRatingFromDropDownList(ratingName);
		//	ratingsSteps.verifyMethodologyOnRatingsIndustries(moreMethodology, brief, parameterTitle,save);
		//	ratingsSteps.verifyBriefOnRatingsIndustriesAndSecurity(moreMethodology, brief, parameterBriefTitle, save);
			ratingsSteps.verifyBriefAndMethodologyPresenceOnPage();
			dataToolSteps.goFullScreen();	
			ratingsSteps.verifyTourismTelecomRetailRatings(titleOfRating,riskRewardRet,rewardsRet,risksRet);

			ratingsSteps.clickOnACountryFromTableSecurityRiskRating(country);
			//	ratingsSteps.selectACountryFromTheTable(country);
			Sleeper.sleepTight(10000);
			savedRating = ratingsSteps.saveRatingAsRegular(ratingSavedName,message);
			driver.navigate().refresh();
			Sleeper.sleepTight(7000);
			bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
			bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(savedRating);
			ratingsSteps.verifySavedRatingCR(one,country);
			Sleeper.sleepTight(10000);
			ratingsSteps.downloadExcelRatingTable();
			Sleeper.sleepTight(10000);
			ratingsSteps.verifyCountryArticleOrPeerGroupTable(dateRange,regPeer);
			ratingsSteps.verifyDateRangeMatchesArticleDatesRiskSummary(dateRange);
			ratingsSteps. downloadRegionalPeerTable();		

			ratingsSteps.clickOnIndicatorsTogglerFromFilter();
			ratingsSteps.checkOneIndicatorFromList(indicator);
			//	ratingsSteps.exapndGeographyFromFilter(country);
			ratingsSteps.clickOnRatingTogglerFromFilter();
			ratingsSteps.checkOneRatingFromList(rating);
			ratingsSteps.clickOnDisplayDataButton();
		}
		else if (ratingName.equals("-- Medical Devices")) {
			dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
			dataAndForecastingSteps.selectOneRatingFromDropDownList(ratingName);
			dataToolSteps.goFullScreen();	
			ratingsSteps.verifyMedicalDevicesRating(titleOfRating,rewards,risksMed,mdIndex);
			//ratingsSteps.verifyMethodologyOnRatingsIndustries(moreMethodology, brief, parameterTitle,save);
			//ratingsSteps.verifyBriefOnRatingsIndustriesAndSecurity(moreMethodology, brief, parameterBriefTitle, save);
			ratingsSteps.verifyBriefAndMethodologyPresenceOnPage();
			ratingsSteps.clickOnACountryFromTableSecurityRiskRating(country);
			//	ratingsSteps.selectACountryFromTheTable(country);
			Sleeper.sleepTight(10000);
			savedRating = ratingsSteps.saveRatingAsRegular(ratingSavedName,message);
			driver.navigate().refresh();
			Sleeper.sleepTight(7000);
			bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
			bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(savedRating);
			ratingsSteps.verifySavedRatingCR(one,country);
			Sleeper.sleepTight(10000);
			ratingsSteps.downloadExcelRatingTable();
			Sleeper.sleepTight(10000);
			ratingsSteps.verifyCountryArticleOrPeerGroupTable(dateRange,regPeer);
			ratingsSteps.verifyDateRangeMatchesArticleDatesRiskSummary(dateRange);
			ratingsSteps. downloadRegionalPeerTable();		

			ratingsSteps.clickOnIndicatorsTogglerFromFilter();
			ratingsSteps.checkOneIndicatorFromList(indicator);
			//ratingsSteps.exapndGeographyFromFilter(country);
			ratingsSteps.clickOnRatingTogglerFromFilter();
			ratingsSteps.checkOneRatingFromList(rating);
			ratingsSteps.clickOnDisplayDataButton();
		}
		else if (ratingName.equals("-- Telecommunications")) {
			dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
			dataAndForecastingSteps.selectOneRatingFromDropDownList(ratingName);
		//	ratingsSteps.verifyMethodologyOnRatingsIndustries(moreMethodology, brief, parameterTitle,save);
		//	ratingsSteps.verifyBriefOnRatingsIndustriesAndSecurity(moreMethodology, brief, parameterBriefTitle, save);
			ratingsSteps.verifyBriefAndMethodologyPresenceOnPage();
			dataToolSteps.goFullScreen();	
			ratingsSteps.verifyTourismTelecomRetailRatings(titleOfRating,riskRewardRet,rewardsRet,risksRet);

			ratingsSteps.clickOnACountryFromTableSecurityRiskRating(country);
			//	ratingsSteps.selectACountryFromTheTable(country);
			Sleeper.sleepTight(10000);
			savedRating = ratingsSteps.saveRatingAsRegular(ratingSavedName,message);
			driver.navigate().refresh();
			Sleeper.sleepTight(7000);
			bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
			bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(savedRating);
			ratingsSteps.verifySavedRatingCR(one,country);
			Sleeper.sleepTight(10000);
			ratingsSteps.downloadExcelRatingTable();
			Sleeper.sleepTight(10000);
			ratingsSteps.verifyCountryArticleOrPeerGroupTable(dateRange,regPeer);
			ratingsSteps.verifyDateRangeMatchesArticleDatesRiskSummary(dateRange);
			ratingsSteps. downloadRegionalPeerTable();		

			ratingsSteps.clickOnIndicatorsTogglerFromFilter();
			ratingsSteps.checkOneIndicatorFromList(indicator);
			//			ratingsSteps.exapndGeographyFromFilter(country);
			ratingsSteps.clickOnRatingTogglerFromFilter();
			ratingsSteps.checkOneRatingFromList(rating);
			ratingsSteps.clickOnDisplayDataButton();
		}
		else if (ratingName.equals("-- Tourism")) {
			dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
			dataAndForecastingSteps.selectOneRatingFromDropDownList(ratingName);
//			ratingsSteps.verifyMethodologyOnRatingsIndustries(moreMethodology, brief, parameterTitle,save);
//			ratingsSteps.verifyBriefOnRatingsIndustriesAndSecurity(moreMethodology, brief, parameterBriefTitle, save);
			ratingsSteps.verifyBriefAndMethodologyPresenceOnPage();
			dataToolSteps.goFullScreen();	
			ratingsSteps.verifyTourismTelecomRetailRatings(titleOfRating,riskRewardRet,rewardsRet,risksRet);

			ratingsSteps.clickOnACountryFromTableSecurityRiskRating(country);
			//	ratingsSteps.selectACountryFromTheTable(country);
			Sleeper.sleepTight(10000);
			savedRating = ratingsSteps.saveRatingAsRegular(ratingSavedName,message);
			driver.navigate().refresh();
			Sleeper.sleepTight(7000);
			bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
			bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(savedRating);
			ratingsSteps.verifySavedRatingCR(one,country);
			Sleeper.sleepTight(10000);
			ratingsSteps.downloadExcelRatingTable();
			Sleeper.sleepTight(10000);
			ratingsSteps.verifyCountryArticleOrPeerGroupTable(dateRange,regPeer);
			ratingsSteps.verifyDateRangeMatchesArticleDatesRiskSummary(dateRange);
			ratingsSteps. downloadRegionalPeerTable();		

			ratingsSteps.clickOnIndicatorsTogglerFromFilter();
			ratingsSteps.checkOneIndicatorFromList(indicator);
			//				ratingsSteps.exapndGeographyFromFilter(country);
			ratingsSteps.clickOnRatingTogglerFromFilter();
			ratingsSteps.checkOneRatingFromList(rating);
			ratingsSteps.clickOnDisplayDataButton();
		}
		else if (ratingName.equals("-- Insurance")) {
			dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
			dataAndForecastingSteps.selectOneRatingFromDropDownList(ratingName);
		//	ratingsSteps.verifyMethodologyOnRatingsIndustries(moreMethodology, brief, parameterTitle,save);
		//	ratingsSteps.verifyBriefOnRatingsIndustriesAndSecurity(moreMethodology, brief, parameterBriefTitle, save);
			ratingsSteps.verifyBriefAndMethodologyPresenceOnPage();
			dataToolSteps.goFullScreen();	
			ratingsSteps.verifyInsuranceRating(titleOfRating,riskRewIndex,reward,risks,industryRisk);

			ratingsSteps.clickOnACountryFromTableSecurityRiskRating(country);
			//	ratingsSteps.selectACountryFromTheTable(country);
			Sleeper.sleepTight(10000);
			savedRating = ratingsSteps.saveRatingAsRegular(ratingSavedName,message);
			driver.navigate().refresh();
			Sleeper.sleepTight(7000);
			bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
			bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(savedRating);
			ratingsSteps.verifySavedRatingCR(one,country);
			Sleeper.sleepTight(10000);
			ratingsSteps.downloadExcelRatingTable();
			Sleeper.sleepTight(10000);
			ratingsSteps.verifyCountryArticleOrPeerGroupTable(dateRange,regPeer);
			ratingsSteps.verifyDateRangeMatchesArticleDatesRiskSummary(dateRange);
			ratingsSteps. downloadRegionalPeerTable();		

			ratingsSteps.clickOnIndicatorsTogglerFromFilter();
			ratingsSteps.checkOneIndicatorFromList(indicator);
			//	ratingsSteps.exapndGeographyFromFilter(country);
			ratingsSteps.clickOnRatingTogglerFromFilter();
			ratingsSteps.checkOneRatingFromList(rating);
			ratingsSteps.clickOnDisplayDataButton();
		}
		else if (ratingName.equals("-- Oil & Gas")) {
			dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
			dataAndForecastingSteps.selectOneRatingFromDropDownList(ratingName);
			dataToolSteps.goFullScreen();	
			ratingsSteps.verifyOilAndGasRating(titleOfRating,combinedIndex,upstreamIndex,downstreamIndex);
		//	ratingsSteps.verifyMethodologyOnRatingsIndustries(moreMethodology, brief, parameterTitle,save);
		//	ratingsSteps.verifyBriefOnRatingsIndustriesAndSecurity(moreMethodology, brief, parameterBriefTitle, save);
			ratingsSteps.verifyBriefAndMethodologyPresenceOnPage();
			ratingsSteps.clickOnACountryFromTableSecurityRiskRating(country);
			//	ratingsSteps.selectACountryFromTheTable(country);
			Sleeper.sleepTight(10000);
			savedRating = ratingsSteps.saveRatingAsRegular(ratingSavedName,message);
			driver.navigate().refresh();
			Sleeper.sleepTight(7000);
			bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
			bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(savedRating);
			ratingsSteps.verifySavedRatingCR(one,country);
			Sleeper.sleepTight(10000);
			ratingsSteps.downloadExcelRatingTable();
			Sleeper.sleepTight(10000);
			ratingsSteps.verifyCountryArticleOrPeerGroupTable(dateRange,regPeer);
			ratingsSteps.verifyDateRangeMatchesArticleDatesRiskSummary(dateRange);
			ratingsSteps. downloadRegionalPeerTable();		

			ratingsSteps.clickOnIndicatorsTogglerFromFilter();
			ratingsSteps.checkOneIndicatorFromList(indicator);
			//ratingsSteps.exapndGeographyFromFilter(country);
			ratingsSteps.clickOnRatingTogglerFromFilter();
			ratingsSteps.checkOneRatingFromList(rating);
			ratingsSteps.clickOnDisplayDataButton();


		} 

		else {
			dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
			dataAndForecastingSteps.selectOneRatingFromDropDownList(ratingName);
		//	ratingsSteps.verifyMethodologyOnRatingsIndustries(moreMethodology, brief, parameterTitle, save);
		//	ratingsSteps.verifyBriefOnRatingsIndustriesAndSecurity(moreMethodology, brief, parameterBriefTitle, save);
			ratingsSteps.verifyBriefAndMethodologyPresenceOnPage();
			dataToolSteps.goFullScreen();	
			ratingsSteps.verifyIndustryRiskRewardTable(titleOfRating);

			ratingsSteps.clickOnACountryFromTableSecurityRiskRating(country);
			//	ratingsSteps.selectACountryFromTheTable(country);
			Sleeper.sleepTight(10000);
			savedRating = ratingsSteps.saveRatingAsRegular(ratingSavedName,message);
			driver.navigate().refresh();
			Sleeper.sleepTight(7000);
			bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
			bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(savedRating);
			ratingsSteps.verifySavedRatingCR(one,country);
			Sleeper.sleepTight(10000);
			ratingsSteps.downloadExcelRatingTable();
			Sleeper.sleepTight(10000);
			ratingsSteps.verifyCountryArticleOrPeerGroupTable(dateRange,regPeer);
			ratingsSteps.verifyDateRangeMatchesArticleDatesRiskSummary(dateRange);
			ratingsSteps. downloadRegionalPeerTable();		

			ratingsSteps.clickOnIndicatorsTogglerFromFilter();
			ratingsSteps.checkOneIndicatorFromList(indicator);
			//	ratingsSteps.exapndGeographyFromFilter(country);
			ratingsSteps.clickOnRatingTogglerFromFilter();
			ratingsSteps.checkOneRatingFromList(rating);
			ratingsSteps.clickOnDisplayDataButton();

		}

	} 
}

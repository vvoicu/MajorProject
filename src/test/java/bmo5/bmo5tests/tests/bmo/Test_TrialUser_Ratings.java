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
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.bmo.steps.pillars.RatingsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Trial.Pillars.DataAndForecasting.Ratings.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_TrialUser_Ratings.csv", separator = ',')

public class Test_TrialUser_Ratings extends TestCase {
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
	public DataToolSteps dataToolSteps;
	
	@Qualifier
	 public String getQualifier() {
       return element;
   }
	
	String username, password,element,rating,securityRisk,projectFinance,industryAutos,industryBanking,extension;
	int reportNumber, articleNumber, pastVersionNumber;
	
	@Test
	public void test_TrialUser_Ratings() {
		loginSteps.performLogin(username, password);	
		dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
		dataAndForecastingSteps.clickCountryRiskTab();
		Sleeper.sleepTight(10000);
		dataToolSteps.clickFilterDownloadButtonTrialUserForRatings(extension);
	//	ratingsSteps.selectFromRatingDropdown(rating); // sovereign risk
	//	ratingsSteps.clickOnDownloadRatingsTrialUser();
		ratingsSteps.selectFromRatingDropdown(securityRisk);
		//ratingsSteps.verifySecurityProjectFinanceAndIndustryRisk();
		dataToolSteps.clickFilterDownloadButtonTrialUserForRatings(extension);
		ratingsSteps.selectFromRatingDropdown(projectFinance);
		//ratingsSteps.verifySecurityProjectFinanceAndIndustryRisk();
		dataToolSteps.clickFilterDownloadButtonTrialUserForRatings(extension);
		ratingsSteps.selectFromRatingDropdown(industryAutos);
		//ratingsSteps.verifySecurityProjectFinanceAndIndustryRisk();
		dataToolSteps.clickFilterDownloadButtonTrialUserForRatings(extension);
		ratingsSteps.selectFromRatingDropdown(industryBanking);
		//ratingsSteps.verifySecurityProjectFinanceAndIndustryRisk();
		dataToolSteps.clickFilterDownloadButtonTrialUserForRatings(extension);
	}
	}
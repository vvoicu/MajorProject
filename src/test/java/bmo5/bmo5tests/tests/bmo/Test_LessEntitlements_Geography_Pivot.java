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


import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Navigation.LessEntitlements.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_LessEntitlements_Geography.csv", separator = ',')

public class Test_LessEntitlements_Geography_Pivot {
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
	public DataToolSteps dataToolSteps;
	
	String username, password, entitledService, entitledGeography,serviceTop ,continentForEntitledGeo,geographyTop,dailyViews,analysis,news,reportsAndSC,strategicContent,reports,dataTool;
	
	@Test
	public void test_LessEntitlements_Geography_Pivot(){
		loginSteps.performLogin(username, password);
		homePageTopMenuSteps.verifyCountryIsDisplayed( geographyTop,  continentForEntitledGeo,  entitledGeography);
		homePageTopMenuSteps.verifyEntitledGeography(geographyTop, entitledGeography);
		homePageTopMenuSteps.clickAndVerifyGeography(geographyTop, continentForEntitledGeo, entitledGeography);
		homePageTopMenuSteps.verifyUnentitledGeography(geographyTop, entitledGeography);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dailyViews);
		dailyAnalysisAndNewsSteps.verifyEntitledServiceFromLeftHandFilter(entitledService);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(analysis);
		dailyAnalysisAndNewsSteps.verifyEntitledServiceFromLeftHandFilter(entitledService);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(news);
		dailyAnalysisAndNewsSteps.verifyEntitledServiceFromLeftHandFilter(entitledService);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reports);
		dailyAnalysisAndNewsSteps.verifyEntitledServiceFromLeftHandFilter(entitledService);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(strategicContent);
		dailyAnalysisAndNewsSteps.verifyEntitledServiceFromLeftHandFilter(entitledService);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsAndSC);
		dailyAnalysisAndNewsSteps.verifyEntitledServiceFromLeftHandFilter(entitledService);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dataTool);
		dataToolSteps.searchFilterGeographySection(entitledGeography);
		dataToolSteps.selectOneGeograpyFromFilter(entitledGeography);
		dataToolSteps.clickFilterIndicatorSection();
		dataToolSteps.verifyEntitledIndicatorFromLeftHandFilter(entitledService);
	}
}
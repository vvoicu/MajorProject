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
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelDailyAnalysisSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelNewsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelSpecialRepSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.homepage.SpecialReportsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.ReportsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.DailyViews.Analysis.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_Save_Views_On_DailyViews.csv", separator = ',')

public class Test_Save_Views_On_DailyViews extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public SpecialReportsSteps specialReportsSteps;
	@Steps
	public FilterPanelSpecialRepSteps filterPanelSpecialRepSteps;
	@Steps
	public DailyAnalysisAndNewsSteps dailyAnalysisAndNewsSteps;
	@Steps
	public FilterPanelNewsSteps filterPanelNewsSteps;
	@Steps
	public FilterPanelDailyAnalysisSteps filterPanelDailyAnalysisSteps;
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	@Steps
	public ReportsSteps reportsSteps;
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	public String username, password, service, itemsPerPage, continent, country, article, saveView, reportsBreadcrumbs,serviceTop,home,analysis,saveViewName,dailyViews,news, dailyViewsBreadcrumbs,geographyTop;
	int articleNumber,column,serviceNumber;
	
	
	@Test
	public void test_Save_Views_On_DailyViews () {
		loginSteps.performLogin(username, password);
		dailyAnalysisAndNewsSteps.clickOnDailyAnalysissubtab(analysis);
		homePageTopMenuSteps.selectServicefromTop(serviceTop);
		homePageTopMenuSteps.selectService(service,column,serviceNumber);
		Sleeper.sleepTight(5000);
		filterPanelDailyAnalysisSteps.verifyBreadcrumbServicePivot(service);
		//homePageTopMenuSteps.clickOnGeography(continent, country);
		filterPanelDailyAnalysisSteps.selectGeographyfromPanel(continent);
		Sleeper.sleepTight(10000);
		filterPanelDailyAnalysisSteps.verifyFilterSelection(continent);
		filterPanelDailyAnalysisSteps.clickOnSaveView(saveView);
		filterPanelDailyAnalysisSteps.saveMessageConfirmation();
		bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
		bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(saveViewName);
		filterPanelDailyAnalysisSteps.verifyFilterSelection(continent);
		//Sleeper.sleepTight(5000);
		
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dailyViewsBreadcrumbs);
		homePageTopMenuSteps.clickOnGeography(geographyTop,continent,country);
		reportsSteps.chooseAServiceFromLeftPanel(service);
		filterPanelDailyAnalysisSteps.clickOnSaveView(saveView);
		filterPanelDailyAnalysisSteps.saveMessageConfirmation();
		bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
		bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(saveViewName);
		filterPanelDailyAnalysisSteps.verifyFilterSelectionService(service);
		
		dailyAnalysisAndNewsSteps.clickNewsTab(news);
		homePageTopMenuSteps.selectServicefromTop(serviceTop);
		homePageTopMenuSteps.selectService(service,column,serviceNumber);
		Sleeper.sleepTight(10000);
		filterPanelDailyAnalysisSteps.verifyBreadcrumbServicePivot(service);
		filterPanelDailyAnalysisSteps.selectGeographyfromPanel(continent);
		Sleeper.sleepTight(10000);
		filterPanelDailyAnalysisSteps.verifyFilterSelection(continent);
		filterPanelDailyAnalysisSteps.clickOnSaveView(saveView);
		filterPanelDailyAnalysisSteps.saveMessageConfirmation();
		bmiDatabasesGeneralSteps.clickOnTheArrowBesideSaveButton();
		bmiDatabasesGeneralSteps.clickOnOneSavedDvPack(saveViewName);
		filterPanelDailyAnalysisSteps.verifyFilterSelection(continent);
        }
}
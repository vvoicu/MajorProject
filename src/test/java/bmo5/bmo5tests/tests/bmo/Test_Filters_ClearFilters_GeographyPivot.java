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
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Navigation.Filters.ClearFilters.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_Filters_ClearFilters_GeographyPivot.csv", separator = ',')

public class Test_Filters_ClearFilters_GeographyPivot {
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
	
	@Steps
	public StrategicAnalysisSteps strategicAnalysisSteps;
	
	String username, password, service,serviceId, geography,serviceTop ,continent,geographyTop,dailyViews,analysis,news,reportsAndSC,strategicContent,reports,dataTool,category;
	
	@Test
	public void test_Filters_ClearFilters_GeographyPivot(){
		String urlBeforeClearFilters="";
		int numberOfCategories;
		loginSteps.performLogin(username, password);
		homePageTopMenuSteps.verifyCountryIsDisplayed( geographyTop,  continent,  geography);
		homePageTopMenuSteps.clickAndVerifyGeography(geographyTop, continent, geography);
		 urlBeforeClearFilters=homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dailyViews);
		dailyAnalysisAndNewsSteps.selectServiceClickClearFiltersAndVerifyDeselectedAndURL( service,  serviceId,  urlBeforeClearFilters);
		urlBeforeClearFilters=homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(analysis);
		dailyAnalysisAndNewsSteps.selectServiceClickClearFiltersAndVerifyDeselectedAndURL( service,  serviceId,  urlBeforeClearFilters);
		urlBeforeClearFilters=homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(news);
		dailyAnalysisAndNewsSteps.selectServiceClickClearFiltersAndVerifyDeselectedAndURL( service,  serviceId,  urlBeforeClearFilters);
		urlBeforeClearFilters=homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsAndSC);
		numberOfCategories=strategicAnalysisSteps.getNumberOfCategories();
		dailyAnalysisAndNewsSteps.selectServiceClickClearFiltersAndVerifyDeselectedAndURL( service,  serviceId,  urlBeforeClearFilters);
		strategicAnalysisSteps.selectCategoryAndVerifyDeselectedAndNumberOfCategories(numberOfCategories,category,urlBeforeClearFilters);
		urlBeforeClearFilters=homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(strategicContent);
		numberOfCategories=strategicAnalysisSteps.getNumberOfCategories();
		dailyAnalysisAndNewsSteps.selectServiceClickClearFiltersAndVerifyDeselectedAndURL( service,  serviceId,  urlBeforeClearFilters);
		strategicAnalysisSteps.selectCategoryAndVerifyDeselectedAndNumberOfCategories(numberOfCategories,category,urlBeforeClearFilters);
		urlBeforeClearFilters=homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reports);
		dailyAnalysisAndNewsSteps.selectServiceClickClearFiltersAndVerifyDeselectedAndURL( service,  serviceId,  urlBeforeClearFilters);
	}
}

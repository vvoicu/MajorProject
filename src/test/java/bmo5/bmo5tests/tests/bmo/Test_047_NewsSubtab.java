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
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelDailyAnalysisSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelNewsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.homepage.SpecialReportsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.ReportsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.NavigationItems;


@Story(Application.HomePage.Pillars.DailyViews.News.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_047_NewsSubtab.csv", separator=',')

public class Test_047_NewsSubtab extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	@Steps
	public FilterPanelDailyAnalysisSteps filterPanelDailyAnalysisSteps;
	@Steps
	public DailyAnalysisAndNewsSteps dailyAnalysisAndNewsSteps;
	@Steps
	public SpecialReportsSteps specialReportsSteps; 
	@Steps
	public FilterPanelNewsSteps filterPanelNewsSteps; 
	@Steps
	public SingleArticleSteps singleArticleSteps;
	@Steps
	public ReportsSteps reportsSteps; 
	@Steps
	public StrategicAnalysisSteps strategicAnalysisPageSteps;
	
	public String username, password, continent, country, service, itemsPerPage,article,name, reportsBreadcrumbs,serviceTop,saveView,news,articleName;
	public int articleNumber,column,serviceNumber;
	
	@Test
	public void test_047_News_sub_tab()  {
		loginSteps.performLogin(username, password);
		dailyAnalysisAndNewsSteps.clickNewsTab(news);
		homePageTopMenuSteps.selectServicefromTop(serviceTop);
		homePageTopMenuSteps.selectService(service,column,serviceNumber);
		Sleeper.sleepTight(10000);
		filterPanelDailyAnalysisSteps.clickOnSaveView(saveView);
		filterPanelDailyAnalysisSteps.saveMessageConfirmation();
		Sleeper.sleepTight(10000);
		
		filterPanelNewsSteps.navigateToItem(NavigationItems.Two);
		filterPanelNewsSteps.navigateToItem(NavigationItems.Previous);
		filterPanelNewsSteps.navigateToItem(NavigationItems.One);
		filterPanelNewsSteps.navigateToItem(NavigationItems.Three);
		filterPanelNewsSteps.navigateToItem(NavigationItems.Five);
		filterPanelNewsSteps.navigateToItem(NavigationItems.Last);
		filterPanelNewsSteps.navigateToItem(NavigationItems.Two);
		filterPanelNewsSteps.navigateToItem(NavigationItems.Previous);
		filterPanelNewsSteps.selectItemsPerPage(itemsPerPage);

		reportsSteps.clickServiceGeographyToColapseExpandFromPanel();
		reportsSteps.chooseAGeographyFromPanel(continent);
		singleArticleSteps.clickSingleArticle(articleNumber);
		articleName = singleArticleSteps.getArticleNameFromBreadcrumbs();
		singleArticleSteps.verifyArticleBreadcrumb(articleName);
		strategicAnalysisPageSteps.verifyArticleTitleStrategicAnalysisPage(articleName); 
		 filterPanelNewsSteps.verifyPreviousArticlebutton();
		 homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsBreadcrumbs);
	    
	}
		
}
		


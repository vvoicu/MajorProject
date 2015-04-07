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

import bmo5.bmo5tests.bmo.steps.HotTopicArticleSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelNewsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FiltersPanelGeoPivotSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.homepage.SpecialReportsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.ReportsArchiveSteps;
import bmo5.bmo5tests.bmo.steps.pillars.ReportsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.NavigationItems;

@Story(Application.Navigation.Persistence.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_PaginationPersistence.csv", separator=',')

public class Test_PaginationPersistence extends TestCase {

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
	public FilterPanelNewsSteps filterPanelNewsSteps;
	@Steps
	public DailyAnalysisAndNewsSteps dailyAnalysisAndNewsSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public SpecialReportsSteps specialReportsSteps;
	@Steps
	public ReportsArchiveSteps reportsArchiveSteps;
	@Steps
	public HotTopicArticleSteps hotTopicArticleSteps;
	@Steps
	public HomePageLevelOneSteps homePageLevelOneSteps;
	@Steps
	public StrategicAnalysisSteps strategicAnalysisSteps;
	@Steps
	public SingleArticleSteps singleArticleSteps;
	@Steps
	public FiltersPanelGeoPivotSteps filtersPanelGeoPivotSteps;
	@Steps
	public ReportsSteps reportsSteps;
	
	public String username, password, continent, country, geographyTop, dailyViews, dailyViewsBreadcrumbs, itemsPerPage, analysis, reportsBreadcrumbs, serviceTop, 
				  serviceName, itemSelector_Articles, itemSelector_Reports, itemsPerPage_1, news, itemSelector_Special, reportsArchiveBreadcrumbs, itemSelector_Archive, 
				  itemSelector_Hot, itemSelector_Webinars, breadcrumbsSC, category1, category2, itemSelector_SC, breadcrumbsRSC, categoryId1, categoryId2, service, service1, categoryId3, categoryId4;
	public int articleNumber1, articleNumber;

	@Test
	public void test_PaginationPersistence() throws InterruptedException {
		
		loginSteps.performLogin(username, password);
		driver.manage().window().maximize();		
		//Daily views
		System.out.println("DAILY VIEWS");
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dailyViewsBreadcrumbs);
		homePageTopMenuSteps.clickOnGeography(geographyTop,continent,country);
		dailyAnalysisAndNewsSteps.verifyPaginationIsPresent();
		dailyAnalysisAndNewsSteps.selectItemsPerPage(itemsPerPage);
		reportsSteps.chooseAServiceFromLeftPanel(service); //agri
		filtersPanelGeoPivotSteps.verifySelectedCategory(categoryId3); //verify agri
		Thread.sleep(5000);
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage,itemSelector_Articles); 
		dailyAnalysisAndNewsSteps.clickLatestNewsArticle(articleNumber1); 
		driver.navigate().back();
		Thread.sleep(5000);
		filterPanelNewsSteps.navigateToItem(NavigationItems.Three);
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_Articles);
		dailyAnalysisAndNewsSteps.clickLatestNewsArticle(articleNumber1);
		driver.navigate().back();
		Thread.sleep(5000);
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_Articles);
		driver.navigate().back();
		Thread.sleep(5000);//sleep needed after back,because on the first load there are only 15 articles,then page is reloaded and there appears the correct number
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_Articles);
		//Analysis
		System.out.println("ANALYSIS");
		dailyAnalysisAndNewsSteps.clickOnDailyAnalysissubtab(analysis);
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_Articles);
		reportsSteps.chooseAServiceFromLeftPanel(service1); //autos
		filtersPanelGeoPivotSteps.verifySelectedCategory(categoryId4); //verify autos
		filterPanelNewsSteps.navigateToItem(NavigationItems.Four);
		dailyAnalysisAndNewsSteps.clickLatestNewsArticle(articleNumber1);
		driver.navigate().back();
		Thread.sleep(5000);
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_Articles);
		//News
		System.out.println("NEWS");
		dailyAnalysisAndNewsSteps.clickNewsTab(news);
		filtersPanelGeoPivotSteps.verifySelectedCategory(categoryId4); //verify autos
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_Articles);
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_Articles);
		dailyAnalysisAndNewsSteps.clickLatestNewsArticle(articleNumber1);
		driver.navigate().back();
		Thread.sleep(5000);
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_Articles);
		homePageHeaderSteps.clickOnLogo(); //need to get rid of pivot,otherwise there won't be displayed 30 reports for pivot = geo
		//Reports
		System.out.println("REPORTS");
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsBreadcrumbs);
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_Reports);	
		filterPanelNewsSteps.navigateToItem(NavigationItems.Three);	
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_Reports);	
		filterPanelNewsSteps.selectItemsPerPage(itemsPerPage_1);		
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage_1, itemSelector_Reports);
		//RSC
		System.out.println("REPORTS AND STRATEGIC CONTENT");
		homePageTopMenuSteps.clickOnGeography(geographyTop,continent,country);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(breadcrumbsRSC);
		Sleeper.sleepTight(5000);
		filtersPanelGeoPivotSteps.checkCategory(category1); //industry f
		filtersPanelGeoPivotSteps.verifySelectedCategory(categoryId1); //verify industry f
		dailyAnalysisAndNewsSteps.verifyArticlesTitle(itemSelector_SC, category1);
		//dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage_1, itemSelector_SC);
		filtersPanelGeoPivotSteps.checkCategory(category2); //commodities
		filtersPanelGeoPivotSteps.verifySelectedCategory(categoryId2); //verify comm
		Sleeper.sleepTight(5000);	
		dailyAnalysisAndNewsSteps.selectItemsPerPage(itemsPerPage);
		filtersPanelGeoPivotSteps.verifySelectedCategory(categoryId2); //verify comm
		reportsSteps.chooseAServiceFromLeftPanel(service); //agri
		filtersPanelGeoPivotSteps.verifySelectedCategory(categoryId3); //verify agri
		//dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_SC);
		singleArticleSteps.clickSingleArticle(articleNumber1);
		driver.navigate().back();
		Sleeper.sleepTight(10000);
		filtersPanelGeoPivotSteps.verifySelectedCategory(categoryId3); //verify agri
		reportsSteps.chooseAServiceFromLeftPanel(service1); //select autos
		//dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_SC);
		//SC
		System.out.println("STRATEGIC CONTENT");
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(breadcrumbsSC);
		Sleeper.sleepTight(5000);
		//dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_SC);
		dailyAnalysisAndNewsSteps.selectItemsPerPage(itemsPerPage_1);
		Sleeper.sleepTight(10000);
		filtersPanelGeoPivotSteps.verifySelectedCategory(categoryId3); //verify agri
		//dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage_1, itemSelector_SC);
		singleArticleSteps.clickSingleArticle(articleNumber1);
		driver.navigate().back();
		Sleeper.sleepTight(10000);
		filtersPanelGeoPivotSteps.verifySelectedCategory(categoryId3); //verify agri
		strategicAnalysisSteps.selectCategoryFromLeftHand(category2); //deselect comm
		Sleeper.sleepTight(10000);
		strategicAnalysisSteps.verifyCategoryIsDeselected(category2);//verify des comm
		//Special reports
		System.out.println("SPECIAL REPORTS");
		specialReportsSteps.clickSpecialReportsup();
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage_1, itemSelector_Special);
		filterPanelNewsSteps.selectItemsPerPage(itemsPerPage);
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_Special);
		//Hot topics
		System.out.println("HOT TOPICS");
		homePageTopMenuSteps.mouseOverHotTopics();
		homePageTopMenuSteps.clickHotTopicsViewAll();
		dailyAnalysisAndNewsSteps.verifyItemsPerPage(itemsPerPage);
		hotTopicArticleSteps.clickArticle(articleNumber1);
		driver.navigate().back();
		hotTopicArticleSteps.clickOnHotTopicFromHandLeftPanel(articleNumber);
		dailyAnalysisAndNewsSteps.selectItemsPerPage(itemsPerPage_1);
		//Webinars&Podcasts
		System.out.println("WEBINARS AND PODCASTS");
		homePageLevelOneSteps.clickOnViewAllWidgetsAndPodcastsLink();
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage_1, itemSelector_Webinars);
		dailyAnalysisAndNewsSteps.selectItemsPerPage(itemsPerPage);
		dailyAnalysisAndNewsSteps.verifyArticlesOrReportsPerPage(itemsPerPage, itemSelector_Webinars);		
		homePageHeaderSteps.clickOnLogout();
		}	
}

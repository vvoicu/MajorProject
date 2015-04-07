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

import bmo5.bmo5tests.bmo.steps.EmailPopUpWindowSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelDailyAnalysisSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelNewsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelSpecialRepSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.homepage.SpecialReportsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.NavigationItems;

@Story(Application.HomePage.Pillars.DailyViews.Analysis.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_019_2_Analysis_SingleArticle.csv", separator = ',')

public class Test_019_2_Analysis_SingleArticle extends TestCase {

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
	public SingleArticleSteps singleArticleSteps;
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	@Steps
	public StrategicAnalysisSteps strategicAnalysisPageSteps;
	@Steps
	public SingleReportSteps singleReportSteps;
	
	public String username, password, service, itemsPerPage, continent, country, article, saveView, reportsBreadcrumbs,serviceTop,home,analysis, articleName;
	int articleNumber,column,serviceNumber;
	
	
	@Test
	public void test_019_2_Analysis_SingleArticle() {
		loginSteps.performLogin(username, password);
		dailyAnalysisAndNewsSteps.clickOnDailyAnalysissubtab(analysis);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(analysis);
		filterPanelNewsSteps.navigateToItem(NavigationItems.Two);
		filterPanelNewsSteps.navigateToItem(NavigationItems.Previous);
		filterPanelNewsSteps.navigateToItem(NavigationItems.One);
		filterPanelNewsSteps.navigateToItem(NavigationItems.Three);
		filterPanelNewsSteps.navigateToItem(NavigationItems.Five);
		filterPanelNewsSteps.navigateToItem(NavigationItems.Last);
		filterPanelNewsSteps.navigateToItem(NavigationItems.Two);
		filterPanelNewsSteps.navigateToItem(NavigationItems.Previous);
		filterPanelNewsSteps.selectItemsPerPage(itemsPerPage);
		singleArticleSteps.clickSingleArticle(articleNumber);
		articleName = singleArticleSteps.getArticleNameFromBreadcrumbs();
		strategicAnalysisPageSteps.verifyArticleTitleStrategicAnalysisPage(articleName);
		singleArticleSteps.clickOnEmailIconArticlePage();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.submitWithSpacesInFieldsAndVerify();
		emailPopUpWindowSteps.completeFieldsClearAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		singleArticleSteps.clickOnSaveButton();
		singleArticleSteps.clickOnPrintIconArticle(articleName);
		singleReportSteps.clickOnDownloadIconReport(articleName);
		singleArticleSteps.clickOnBackToPreviousPage();
		homePageTopMenuSteps.verifyBreadCrumb(analysis);
      }
}
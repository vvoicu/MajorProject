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

import bmo5.bmo5tests.bmo.steps.EmailPopUpWindowSteps;
import bmo5.bmo5tests.bmo.steps.EntrepriseLoginSteps;
import bmo5.bmo5tests.bmo.steps.HotTopicArticleSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.PreviewArticleWindowSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelDailyAnalysisSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelNewsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.homepage.KeyGlobalViewsBmoSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Enterprise.Pillars.DailyViews.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enteprise_DailyViews_Save.csv", separator=',')

public class Test_001_Enteprise_DailyViews_Save extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST_IP)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public DailyAnalysisAndNewsSteps dailyAnalysisAndNewsSteps;
	@Steps
	public EntrepriseLoginSteps entrepriseLoginSteps;
	@Steps
	public FilterPanelDailyAnalysisSteps filterPanelDailyAnalysisSteps;
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	@Steps
	public SingleArticleSteps singleArticleSteps;
	@Steps
	public FilterPanelNewsSteps filterPanelNewsSteps; 
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	@Steps 
	public SingleReportSteps singleReportSteps;
	
	@Steps 
	public KeyGlobalViewsBmoSteps keyGlobalViewsBmoSteps;
	
	@Steps
	public HotTopicArticleSteps hotTopicsArticleSteps;
	
	@Steps
	public StrategicAnalysisSteps strategicAnalysisPageSteps;
	@Steps
	public PreviewArticleWindowSteps previewArticleWindowSteps;

	@Qualifier
	 public String getQualifier() {
     return dailyViewsBreadcrumbs;
 }
	
	public String service,continent,name,article,articleTitle,dailyViews,dailyViewsBreadcrumbs,serviceTop,analysis,home,news,articleName;
	int articleNumber,column,serviceNumber;

	@Test
	public void test_001_Enteprise_DailyViews_Save() {
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dailyViewsBreadcrumbs);
		filterPanelDailyAnalysisSteps.verifyOnHoveredeArticleMediaActios(articleNumber);
		filterPanelDailyAnalysisSteps.saveArticleAfterHover();
	//	filterPanelDailyAnalysisSteps.clickOnTags(articleNumber);
		singleArticleSteps.clickOnEmailArticleFromListing(articleNumber);
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		Sleeper.sleepTight(3000);
		filterPanelDailyAnalysisSteps.clickOnTags(articleNumber);
		//TODO fix this
		//		singleArticleSteps.clickOnDownloadArticleFromListing(articleNumber);
		keyGlobalViewsBmoSteps.clickOnSaveButtonOfAnArticleFromListEnterpriseUser(articleNumber);
		singleArticleSteps.clickOnPrintArticleFromListing(articleNumber);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dailyViewsBreadcrumbs);
		singleArticleSteps.clickSingleArticle(articleNumber);
		articleName = singleArticleSteps.getArticleNameFromBreadcrumbs();
		filterPanelDailyAnalysisSteps.verifyArticleViewMediaActions();
		singleArticleSteps.clickOnEmailIconArticlePage();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		singleArticleSteps.clickOnPrintIconArticle(articleName);
		singleReportSteps.clickOnDownloadIconReport(articleName);
		filterPanelDailyAnalysisSteps.saveArticleDetail();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dailyViewsBreadcrumbs);
		filterPanelDailyAnalysisSteps.clickOnPreviewArticle(articleNumber);
		filterPanelDailyAnalysisSteps.verifyMediaActionsFromPreview(); 
		filterPanelDailyAnalysisSteps.saveFromPreviewArticle();
		filterPanelDailyAnalysisSteps.clickOnPreviewArticle(articleNumber);
		//TODO fix this	
//		previewArticleWindowSteps.clickOnEmailIconPreviewArticle();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		filterPanelDailyAnalysisSteps.clickOnPreviewArticle(articleNumber);
		//TODO fix this		
//		articleName = previewArticleWindowSteps.getArticleNameFromPreviewWindow();
		strategicAnalysisPageSteps.clickOnDownloadIconPreviewArticleStrategicAnalysisPage(articleName);
		Sleeper.sleepTight(2000);
		//TODO fix this		
//		previewArticleWindowSteps.clickOnPrintIconPreviewArticle(articleName);
	}
}

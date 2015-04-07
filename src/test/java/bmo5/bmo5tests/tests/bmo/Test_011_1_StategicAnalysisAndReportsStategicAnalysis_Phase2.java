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
import bmo5.bmo5tests.bmo.steps.PreviewArticleWindowSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisAndReportsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.ReportsAndStrategicContent.StrategicContent.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_011_1_StategicAnalysisAndReportsStategicAnalysis_Phase2.csv", separator=',')

public class Test_011_1_StategicAnalysisAndReportsStategicAnalysis_Phase2 extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public DailyAnalysisAndNewsSteps dailyAnalysisAndNewsSteps;
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	@Steps
	public SingleArticleSteps singleArticleSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public HomePageLevelOneSteps homePageLevelOneSteps;
	@Steps
	public StrategicAnalysisAndReportsSteps strategicAnalysisAndReportsSteps;
	@Steps
	public PreviewArticleWindowSteps previewArticleWindowSteps;
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	@Steps
	public StrategicAnalysisSteps strategicAnalysisSteps;
	
	public String username, password,breadcrumb;
	
	private int articleNumber, archiveNumber, relatedContentNumber;
	//private int articleNumberCountryReports, articleNumberSpecialReports;
	private String articleName;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}
	
	public void setArchiveNumber(int archiveNumber) {
		this.archiveNumber = archiveNumber;
	}
	
	public void setRelatedContentNumber(int relatedContentNumber) {
		this.relatedContentNumber = relatedContentNumber;
	}
	
	@Test
	public void test_011_1_StategicAnalysisAndReportsStategicAnalysis_Phase2() {
		loginSteps.performLogin(username, password);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(breadcrumb);
		singleArticleSteps.clickOnEmailArticleFromListing(articleNumber);
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.submitWithSpacesInFieldsAndVerify();
		emailPopUpWindowSteps.completeFieldsClearAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		singleArticleSteps.clickOnSaveArticleFromListing(articleNumber);
		//TODO fix this
//		singleArticleSteps.clickOnDownloadArticleFromListing(articleNumber);
		strategicAnalysisAndReportsSteps.clickOnViewFullReportIcon(articleNumber); //Needs some changes
		singleArticleSteps.clickOnPrintArticleFromListing(articleNumber);
		//TODO fix this
//		strategicAnalysisSteps.clickOnRelatedContentOfOneArticleFromList(articleNumber, relatedContentNumber);
//		strategicAnalysisSteps.clickOnArchivesOfOneArticleFromList(articleNumber, archiveNumber);
		articleName = singleArticleSteps.clickOnPreviewArticle(articleNumber);
		previewArticleWindowSteps.verifyArticleTitleFromPreviewArticleWindow(articleName);
		previewArticleWindowSteps.closePreviewWindow();
	}
}

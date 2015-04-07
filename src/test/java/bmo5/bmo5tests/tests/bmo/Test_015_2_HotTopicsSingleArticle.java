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
import bmo5.bmo5tests.bmo.steps.HotTopicArticleSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.HomePageTopMenu.HotTopics.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_015_2_HotTopicsSingleArticle.csv", separator=',')

public class Test_015_2_HotTopicsSingleArticle extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public HotTopicArticleSteps hotTopicsArticleSteps;
	@Steps
	public SingleArticleSteps singleArticleSteps;
	@Steps
	public HomePageLevelOneSteps homePageLevelOneSteps;
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	@Steps
	public StrategicAnalysisSteps strategicAnalysisPageSteps;
	@Steps
	public SingleReportSteps singleReportSteps;
	
	public String username, password, articleName, hotTopicName, hotTopicsBreadcrumbs;
	private int articleNumber, articleNumberCategory;
	
	@Test
	public void test_015_2_HotTopicsSingleArticle() {
		loginSteps.performLogin(username, password);
		homePageTopMenuSteps.mouseOverHotTopics();
		hotTopicName = homePageTopMenuSteps.clickHotTopicsArticle(articleNumber);
		hotTopicsArticleSteps.verifyHotTopicSelected(articleNumber);
		articleName=hotTopicsArticleSteps.clickArticle(articleNumberCategory);
		singleArticleSteps.verifyArticleBreadcrumb(articleName);
		strategicAnalysisPageSteps.verifyArticleTitleStrategicAnalysisPage(articleName);
		singleArticleSteps.clickOnBackToPreviousPage();
		hotTopicsArticleSteps.clickArticle(articleNumberCategory);
		singleArticleSteps.clickOnEmailIconArticlePage();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.submitWithSpacesInFieldsAndVerify();
		emailPopUpWindowSteps.completeFieldsClearAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		singleArticleSteps.clickOnSaveButton();
		singleArticleSteps.clickOnPrintIconArticle(articleName);
		//TODO fix this
//		singleArticleSteps.clickOnDownloadIconArticle(articleName); 
		homePageTopMenuSteps.clickOnTheNameOfTheChildBreadcrumb(); 
		homePageTopMenuSteps.clickOnTheNameOfTheParentBreadcrumb();
		homePageTopMenuSteps.verifyBreadCrumb(hotTopicsBreadcrumbs);
		homePageTopMenuSteps.clickOnTheHomeBreadcrumb();
		homePageLevelOneSteps.verifyHomePage();
	}
}

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
import bmo5.bmo5tests.bmo.steps.PreviewArticleWindowSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.HomePage.HomePageTopMenu.HotTopics.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_015_3_HotTopicsListingPage.csv", separator=',')

public class Test_015_3_HotTopicsListingPage extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public HotTopicArticleSteps hotTopicArticleSteps;
	@Steps
	public SingleArticleSteps singleArticleSteps;
	@Steps
	public HomePageLevelOneSteps homePageLevelOneSteps;
	@Steps
	public PreviewArticleWindowSteps previewArticleWindowSteps;
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	@Steps SingleReportSteps singleReportSteps;
	
	public String username, password, articleName, hotTopicName, hotTopicsBreadbrumbs;
	private int articleNumber;
	
	@Test
	public void test_015_3_HotTopicsListingPage(){
		loginSteps.performLogin(username, password);
		homePageTopMenuSteps.mouseOverHotTopics();
		homePageTopMenuSteps.clickHotTopicsViewAll();
		hotTopicArticleSteps.verifyNamePageFirstHotTopic();
		hotTopicArticleSteps.clickOnEmailIconArticleFromList(articleNumber);
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.submitWithSpacesInFieldsAndVerify();
		emailPopUpWindowSteps.completeFieldsClearAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		hotTopicArticleSteps.clickOnSaveIconArticleFromList(articleNumber);
		hotTopicArticleSteps.clickOnPrintIconArticleFromList(articleNumber);
		//TODO fix this
//		hotTopicArticleSteps.clickOnDownloadIconArticleFromList(articleNumber);
		articleName = hotTopicArticleSteps.clickOnPreviewArticle(articleNumber);
		previewArticleWindowSteps.clickOnReadMoreButtonFromPreviewArticle();
		singleArticleSteps.verifyArticleBreadcrumb(articleName);
		homePageTopMenuSteps.mouseOverHotTopics();
		homePageTopMenuSteps.clickHotTopicsViewAll();
		hotTopicName = hotTopicArticleSteps.clickOnHotTopicFromHandLeftPanel(articleNumber);
		articleName = hotTopicArticleSteps.clickArticle(articleNumber);
		singleArticleSteps.verifyArticleBreadcrumb(articleName);
		homePageTopMenuSteps.clickOnTheNameOfTheChildBreadcrumb();
		homePageTopMenuSteps.clickOnTheNameOfTheParentBreadcrumb();
		homePageTopMenuSteps.verifyBreadCrumb(hotTopicsBreadbrumbs);
		homePageTopMenuSteps.clickOnTheHomeBreadcrumb();
		homePageLevelOneSteps.verifyHomePage();
	}
}

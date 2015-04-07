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
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelThreeSteps;
import bmo5.bmo5tests.bmo.steps.homepage.KeyGlobalViewsBmoSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Trial.HomePageTopMenu.HotTopics.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_TrialUser_HotTopics.csv", separator = ',')

public class Test_TrialUser_HotTopics extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps 
	public SingleArticleSteps singleArticleSteps;
	
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	
	@Steps
	public HomePageLevelThreeSteps homePageLevelThreeSteps;
	
	@Steps
	public PreviewArticleWindowSteps previewArticleWindowSteps;
	
	@Steps 
	public KeyGlobalViewsBmoSteps keyGlobalViewsBmoSteps;
	
	@Steps
	public HotTopicArticleSteps hotTopicsArticleSteps;
	
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowsSteps;
	
	
	String username, password;
	int articleNumber;
	
	@Test
	public void test_TrialUser_HotTopics() {
		loginSteps.performLogin(username, password);		
		homePageHeaderSteps.clickOnLogo();
		homePageLevelThreeSteps.hotTopicsViewAll();
		keyGlobalViewsBmoSteps.clickOnPrintButtonOfAnArticleFromListTrialUser(articleNumber);
		keyGlobalViewsBmoSteps.clickOnDownloadButtonOfAnArticleFromListTrialUser(articleNumber);
		keyGlobalViewsBmoSteps.clickOnViewFullReportButtonOfAnArticleFromList(articleNumber);
		hotTopicsArticleSteps.clickOnSaveIconArticleFromList(articleNumber);
		hotTopicsArticleSteps.clickOnEmailIconArticleFromList(articleNumber);
		emailPopUpWindowsSteps.verifyEmailWindowElements();
		emailPopUpWindowsSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowsSteps.closeEmailWondow();
		
		hotTopicsArticleSteps.clickOnPreviewArticle(articleNumber);
		//TODO fix this
//		previewArticleWindowSteps.clickOnDownloadIconPreviewArticleTrialUser();
		homePageHeaderSteps.clickOnLogo();
		homePageLevelThreeSteps.hotTopicsViewAll();
		hotTopicsArticleSteps.clickOnPreviewArticle(articleNumber);
		//TODO fix this
//		previewArticleWindowSteps.clickOnPrintIconPreviewArticleTrialUser();
		homePageHeaderSteps.clickOnLogo();
		homePageLevelThreeSteps.hotTopicsViewAll();
		hotTopicsArticleSteps.clickOnPreviewArticle(articleNumber);
		previewArticleWindowSteps.clickOnViewFullReportIconPreviewArticleTrialUser();
		previewArticleWindowSteps.clickOnSaveIconPreviewArticle();
//		
//		previewArticleWindowSteps.clickOnEmailIconPreviewArticle();
		emailPopUpWindowsSteps.verifyEmailWindowElements();
		emailPopUpWindowsSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowsSteps.closeEmailWondow();
		
		homePageHeaderSteps.clickOnLogo();
		homePageLevelThreeSteps.hotTopicsViewAll();
		hotTopicsArticleSteps.clickArticle(articleNumber);
		singleArticleSteps.clickOnDownloadButtonArticleTrialUser();
		singleArticleSteps.clickOnPrintButtonArticleTrialUser();
		singleArticleSteps.clickOnViewFullReportButtonArticleTrialUser();
		singleArticleSteps.clickOnSaveButton();
		singleArticleSteps.clickOnEmailIconArticlePage();
		emailPopUpWindowsSteps.verifyEmailWindowElements();
		emailPopUpWindowsSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowsSteps.closeEmailWondow();
	}
}

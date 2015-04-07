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

@Story(Application.Enterprise.HomePageTopMenu.HotTopics.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enterprise_HotTopics.csv", separator = ',')


public class Test_001_Enterprise_HotTopics extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST_IP)
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
	
	String username, password, fileName;
	int articleNumber;
	
	@Test
	public void test_001_Enterprise_HotTopics() {
		homePageHeaderSteps.clickOnLogo();
		homePageLevelThreeSteps.hotTopicsViewAll();
		//TODO fix this
//		hotTopicsArticleSteps.clickOnDownloadIconArticleFromList(articleNumber);
		keyGlobalViewsBmoSteps.clickOnSaveButtonOfAnArticleFromListEnterpriseUser(articleNumber);
		hotTopicsArticleSteps.clickOnPrintIconArticleFromList(articleNumber);
		hotTopicsArticleSteps.clickOnEmailIconArticleFromList(articleNumber);
		emailPopUpWindowsSteps.verifyEmailWindowElements();
		emailPopUpWindowsSteps.verifySubjectIsEmptyForEnterprise();
		emailPopUpWindowsSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowsSteps.closeEmailWondow();
		
		fileName = hotTopicsArticleSteps.clickOnPreviewArticle(articleNumber);
		//TODO fix this
//		previewArticleWindowSteps.clickOnDownloadIconPreviewArticleFromSearch(fileName);
		previewArticleWindowSteps.clickOnSavePreviewArticleEnterpriseUser(); // save is not working (to take off the comments from method after this pb is fixed)
		fileName = hotTopicsArticleSteps.clickOnPreviewArticle(articleNumber);
		//TODO fix this
//		previewArticleWindowSteps.clickOnPrintIconPreviewArticle(fileName);
		//TODO fix this
//		previewArticleWindowSteps.clickOnEmailIconPreviewArticle();
		emailPopUpWindowsSteps.verifyEmailWindowElements();
		emailPopUpWindowsSteps.verifySubjectIsEmptyForEnterprise();
		emailPopUpWindowsSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowsSteps.closeEmailWondow();
		
		fileName = hotTopicsArticleSteps.clickArticle(articleNumber);
		//TODO fix this
//		singleArticleSteps.clickOnDownloadIconArticle(fileName);
		singleArticleSteps.clickOnSaveButtonArticleEnterpriseUser();
		singleArticleSteps.clickOnPrintIconArticle(fileName);
		singleArticleSteps.clickOnEmailIconArticlePage();
		emailPopUpWindowsSteps.verifyEmailWindowElements();
		emailPopUpWindowsSteps.verifySubjectIsEmptyForEnterprise();
		emailPopUpWindowsSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowsSteps.closeEmailWondow();
	}
}

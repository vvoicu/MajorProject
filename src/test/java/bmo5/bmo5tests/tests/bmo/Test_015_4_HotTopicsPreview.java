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
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.HomePageTopMenu.HotTopics.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_015_4_HotTopicsPreview.csv", separator=',')

public class Test_015_4_HotTopicsPreview extends TestCase{
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
	public PreviewArticleWindowSteps previewArticleWindowSteps;
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	@Steps
	public StrategicAnalysisSteps strategicAnalysisPageSteps;
	
	public String username, password, articleName;
	private int articleNumber;

	@Test
	public void test_015_4_HotTopicsPreview(){
		loginSteps.performLogin(username, password);
		homePageTopMenuSteps.mouseOverHotTopics();
		homePageTopMenuSteps.clickHotTopicsViewAll();
		hotTopicArticleSteps.verifyNamePageFirstHotTopic();
		articleName = hotTopicArticleSteps.clickOnPreviewArticle(articleNumber);
		strategicAnalysisPageSteps.clickOnDownloadIconPreviewArticleStrategicAnalysisPage(articleName);
		//TODO fix this
//		previewArticleWindowSteps.clickOnPrintIconPreviewArticle(articleName);
//		previewArticleWindowSteps.clickOnViewFullReportIconPreviewArticle(articleName);
		previewArticleWindowSteps.clickOnSaveIconPreviewArticle();
		//TODO fix this
//		previewArticleWindowSteps.clickOnEmailIconPreviewArticle();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
	}
}

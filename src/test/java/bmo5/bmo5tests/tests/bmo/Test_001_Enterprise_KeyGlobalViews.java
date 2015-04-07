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
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelTwoSteps;
import bmo5.bmo5tests.bmo.steps.homepage.KeyGlobalViewsBmoSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Enterprise.HomePage.KeyGlobalViews.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enterprise_KeyGlobalViews.csv", separator = ',')


public class Test_001_Enterprise_KeyGlobalViews extends TestCase {
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
	public HomePageLevelTwoSteps homePageLevelTwoSteps;
	
	@Steps 
	public KeyGlobalViewsBmoSteps keyGlobalViewsBmoSteps;
	
	@Steps
	public PreviewArticleWindowSteps previewArticleWindowSteps;
	
	@Steps
	public HotTopicArticleSteps hotTopicsArticleSteps;
	
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	
	String username, password, keyGlobalViewsBreadcrums;
	int articleNumber;
	
	@Test
	public void test_001_Enterprise_KeyGlobalViews() {
		homePageHeaderSteps.clickOnLogo();
		homePageLevelTwoSteps.viewAllKeyGlobalViews();
		homePageHeaderSteps.verifyBreadCrumbs(keyGlobalViewsBreadcrums);
		keyGlobalViewsBmoSteps.clickOnSaveButtonOfAnArticleFromListEnterpriseUser(articleNumber);
		
		hotTopicsArticleSteps.clickOnPreviewArticle(articleNumber);
		previewArticleWindowSteps.clickOnSavePreviewArticleEnterpriseUser();
		
		hotTopicsArticleSteps.clickArticle(articleNumber);
		singleArticleSteps.clickOnSaveButtonArticleEnterpriseUser();
		singleArticleSteps.clickOnBackToPreviousPage();
		homePageHeaderSteps.verifyBreadCrumbs(keyGlobalViewsBreadcrums);
	}
}

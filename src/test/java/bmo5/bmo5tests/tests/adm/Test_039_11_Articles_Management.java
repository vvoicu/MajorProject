package bmo5.bmo5tests.tests.adm;

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

import bmo5.bmo5tests.adm.steps.ArticlesManagementSteps;
import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.widgets.HotTopicsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Adm.Articles.Management.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Test_039_11_Articles_Management.csv", separator=',')

public class Test_039_11_Articles_Management extends TestCase{
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps admLoginSteps;
	@Steps
	public ArticlesManagementSteps articleManagementSteps;
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	@Steps
	public HotTopicsSteps hotTopicsSteps;
	
	
	public String username, password, region, channel, category, source, keyword, articleNumber, articleName, itemsPerPage;
	public int articleNumberFromList;
	
	@Test
	public void adm_039_11_Articles_Management(){
		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(username,password);
		articleManagementSteps.clickOnArticleManagementFromLeftSidebar();
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
		articleManagementSteps.selectRegion(region);
		articleManagementSteps.selectChannel(channel);
		articleManagementSteps.clickOnSearchButton();
		articleManagementSteps.clickOnOpenerAndVerify();
		articleManagementSteps.verifyRegionSelected(region);
		articleManagementSteps.verifyChannelSelected(channel);
		articleName = articleManagementSteps.clickOnAnArticleFromList(articleNumberFromList);
		articleManagementSteps.verifyArticleTitleInsideArticlePreview(articleName);
		articleManagementSteps.verifyRegionInsideArticlePreview(region);
		articleManagementSteps.verifyChannelInsideArticlePreview(channel);
		
		articleManagementSteps.clickOnLogo();
		articleManagementSteps.clickOnArticleManagementFromLeftSidebar();
		articleManagementSteps.selectCategory(category);
		articleManagementSteps.clickOnSearchButton();
		articleManagementSteps.clickOnOpenerAndVerify();
		articleManagementSteps.verifyCategorySelected(category);
		articleName = articleManagementSteps.clickOnAnArticleFromList(articleNumberFromList);
		articleManagementSteps.verifyArticleTitleInsideArticlePreview(articleName);
		articleManagementSteps.verifyCategoryInsideArticlePreview(category);
		
		articleManagementSteps.clickOnLogo();
		articleManagementSteps.clickOnArticleManagementFromLeftSidebar();
		articleManagementSteps.insertKeyword(keyword);
		articleManagementSteps.clickOnSearchButton();
		articleManagementSteps.clickOnOpenerAndVerify();
		articleManagementSteps.verifyKeyword(keyword);
		manageWidgetsSteps.navigatePagesAndVerify();
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPage);
		articleManagementSteps.verifyThatAllHeadersContainTheKeyword(keyword);
		
		articleManagementSteps.clickOnLogo();
		articleManagementSteps.clickOnArticleManagementFromLeftSidebar();
		articleManagementSteps.insertArticleNumber(articleNumber);
		articleManagementSteps.clickOnSearchButton();
		articleManagementSteps.verifyArticleNumberInsideArticle(articleNumber);
	}
}

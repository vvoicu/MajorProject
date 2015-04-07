package bmo5.bmo5tests.tests.bmo;

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

import bmo5.bmo5tests.adm.steps.ClientAccountsSteps;
import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.bmo.steps.EmailPopUpWindowSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelDailyAnalysisSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Trial.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_TrialUser_SetTrialUser.csv", separator=',')
public class Test_TrialUser_SetTrialUser {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps admLoginSteps;
	
	@Steps
	public ClientAccountsSteps clientAccountSteps;
	
	@Steps
	public  bmo5.bmo5tests.bmo.steps.LoginSteps bmo5LoginSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	
	@Steps
	public FilterPanelDailyAnalysisSteps filterPanelDailyAnalysisSteps;
	
	@Steps 
	public SingleArticleSteps singleArticleSteps;
	
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	
	public String admUsername,admPassword,bmoUsername,bmoPassword,trialUserOption,dailyViewsBreadcrumbs;
    public int articleNumber ;
    
	@Test
	public void test_TrialUser_SetTrialUser(){
		admLoginSteps.performLogin(admUsername, admPassword);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.AccountManagement);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ClientAccounts);
		clientAccountSteps.performSearch(bmoUsername);
		if(!clientAccountSteps.isUserTrial(trialUserOption)){
		clientAccountSteps.selectUserTypeByvisibleText(trialUserOption);
		clientAccountSteps.saveUserDetails();
		}
		clientAccountSteps.assertTrialUser(trialUserOption);
		menuNavigationSteps.navigateTo(Constants.BMO_HOST);
		bmo5LoginSteps.performLogin(bmoUsername, bmoPassword);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dailyViewsBreadcrumbs);
		filterPanelDailyAnalysisSteps.selectTags(articleNumber);
		singleArticleSteps.verifyMediaActionsForTrialOnHover(articleNumber);
		singleArticleSteps.clickOnPrintIconArticleFromListTrialUser(articleNumber);
		singleArticleSteps.clickOnDownloadIconArticleFromListTrialUser(articleNumber);
		singleArticleSteps.clickOnSaveArticleFromListing(articleNumber);
		singleArticleSteps.clickOnEmailArticleFromListing(articleNumber);
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
	}
}

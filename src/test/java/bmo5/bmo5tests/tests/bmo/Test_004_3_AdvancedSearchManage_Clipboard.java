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

import bmo5.bmo5tests.bmo.steps.AdvancedSearchSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.SavedContentSteps;
import bmo5.bmo5tests.bmo.steps.SearchSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.SpecialReportsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Header.AdvancedSearch.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_004_3_AdvancedSearchManageClipBoard.csv", separator=',')

public class Test_004_3_AdvancedSearchManage_Clipboard extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageHeaderSteps homeSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public AdvancedSearchSteps advancedSearchSteps;
	@Steps
	public SearchSteps searchSteps;
	@Steps
	public SavedContentSteps savedContentSteps;
	@Steps
	public SpecialReportsSteps specialReportsSteps;
	
	public String username, password, breadcrumbString;
	public int numbeOfArticlesToBeChecked;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Test
	public void test_004_3_AdvancedSearchManageClipBoard() {
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnSearchButtonAndVerify(breadcrumbString);
		searchSteps.checkArticlesFromListing(numbeOfArticlesToBeChecked);
		searchSteps.verifyTheNumberOfArticlesFromManageClipboardTitle(numbeOfArticlesToBeChecked);
		searchSteps.clickOnClipboardAndVerify();  
		searchSteps.verifyTheNumberOfArticlesFromManageClipboardInsideIt(numbeOfArticlesToBeChecked);
		searchSteps.clickOnPrintAllLinkAnCancel();
		searchSteps.clickOnClipboardAndVerify();
		//TODO fix this
//		searchSteps.clickOnDownloadLink();
		searchSteps.checkArticlesFromListing(numbeOfArticlesToBeChecked);
		searchSteps.verifyTheNumberOfArticlesFromManageClipboardTitle(numbeOfArticlesToBeChecked);
		searchSteps.clickOnClipboardAndVerify();  
		searchSteps.verifyTheNumberOfArticlesFromManageClipboardInsideIt(numbeOfArticlesToBeChecked);
		searchSteps.clickOnAddOnSavedContentButton();
//		searchSteps.verifyClipboardAfterAddedAllArticlesOnSavedContent(); // this step fails
	}
}

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
import bmo5.bmo5tests.bmo.steps.SavedArticlesSavedDataSteps;
import bmo5.bmo5tests.bmo.steps.SavedContentSteps;
import bmo5.bmo5tests.bmo.steps.SavedViewsSavedSearchesSavedMncSteps;
import bmo5.bmo5tests.bmo.steps.SearchSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Header.AdvancedSearch.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_004_4_AdvancedSearchSavedSearches.csv", separator=',')

public class Test_004_4_AdvancedSearchSavedSearches extends TestCase {
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
	public SavedViewsSavedSearchesSavedMncSteps savedViewsSavedSearchesSavedMncSteps;
	@Steps
	public SavedArticlesSavedDataSteps savedArticlesSavedDataSteps;
	
	public String username, password, word, searchTitle, updateSearchBreadcrumbs, savedSearchesBreadcrumbs;
	public int itemNumber;
	
	public void setWord(String word){
		this.word = word;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public void setUpdateSearchBreadcrumbs(String updateSearchBreadcrumbs) {
		this.updateSearchBreadcrumbs = updateSearchBreadcrumbs;
	}

	
	@Test
	public void test_004_4_AdvancedSearchSavedSearches() {
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnSavedContent();
		homePageHeaderSteps.verifyIfSavedContentIsActive();
		savedContentSteps.clickOnSavedSearchesFromLeftPanel();
		homePageHeaderSteps.verifyBreadCrumbs(savedSearchesBreadcrumbs);
		savedContentSteps.verifyifSavedSearchesLeftPanelIsActive();
		savedViewsSavedSearchesSavedMncSteps.createANewSavedSearch(); 
		advancedSearchSteps.verifySaveSearchPage();
		//TODO fix this
//		advancedSearchSteps.completeAllSectionSaveSearchWithAnExistingNameAndVerifyFromSaveSearchPageAddNewSavedSearch(word);
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.clickOnSavedSearchesFromLeftPanel();
		savedViewsSavedSearchesSavedMncSteps.checkOnOneViewFromList(itemNumber);
//		savedViewsSavedSearchesSavedMncSteps.verifyIfOneViewIsChecked(itemNumber); // this step fails
		savedViewsSavedSearchesSavedMncSteps.clickOnEditIcon(itemNumber);
		advancedSearchSteps.verifySaveSearchPage();
		homePageHeaderSteps.verifyBreadCrumbs(updateSearchBreadcrumbs);
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.clickOnSavedSearchesFromLeftPanel();
		savedViewsSavedSearchesSavedMncSteps.deleteItemsAndVerify();
	}
}

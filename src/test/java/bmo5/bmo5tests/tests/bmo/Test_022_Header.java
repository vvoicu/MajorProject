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

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.ServiceUpdateSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Header.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_022_Header.csv", separator=',')

public class Test_022_Header extends TestCase {
	
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public HomePageLevelOneSteps homePageLevelOneSteps;
	@Steps
	public ServiceUpdateSteps serviceUpdatesSteps;
	
	
	public String username, password,search,word, searchTitle, advancedSearchTitle,close, methodologyTitle, accountTitle,helpName,updates,total, breadcrumbString;
		
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}
	public void setAdvancedSearchTitle(String advancedSearchTitle) {
		this.advancedSearchTitle = advancedSearchTitle;
	}
	public void setMethodologyTitle(String methodologyTitle) {
		this.methodologyTitle = methodologyTitle;
	}
	public void setAccountTitle(String accountTitle) {
		this.accountTitle = accountTitle;
	}
	public void setWord(String word) {
		this.word = word;
	}

	@Test
	public void test_022_Header() {
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.predictiveSearch(word);
		homePageHeaderSteps.clickOnSearchButtonAndVerify(breadcrumbString);
		homePageTopMenuSteps.verifyBreadCrumb(searchTitle);
		homePageHeaderSteps.advancedSearch();
		homePageTopMenuSteps.verifyBreadCrumbForHeader(advancedSearchTitle);
		homePageHeaderSteps.clickOnHelp(helpName);
		homePageHeaderSteps.closeHelp(close);
		homePageHeaderSteps.clickOnServiceUpdates(updates);
		homePageHeaderSteps.clickOnMethodologyAndVerify(total);
		homePageHeaderSteps.verifyMyBmoSection();
		homePageTopMenuSteps.verifyBreadCrumbAccount(accountTitle);
		homePageHeaderSteps.clickOnLogo();
		homePageLevelOneSteps.verifyHomePage();
		homePageHeaderSteps.clickOnLogout();
	}
}

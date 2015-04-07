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
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FinancialMarketsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.HomePageTopMenu.FinancialMarkets.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_013_NavigationBar_FinancialMarkets.csv", separator=',')

public class Test_013_NavigationBar_FinancialMarkets extends TestCase {
	
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public FinancialMarketsSteps financialMarketsSteps;
	
	public String username, password, serviceName,assetRegion,keyRegion,exchangeTable,interestTable, serviceTop;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Test
	public void test_013_NavigationBar_FinancialMarkets() {
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnLogo();
		homePageTopMenuSteps.clickAndVerifyFinancialMarkets( serviceTop,serviceName);
		Sleeper.sleepTight(10000);
		financialMarketsSteps.selectARegionForAssetClassStrategy(assetRegion);
		financialMarketsSteps.verifyTableOfAssetStrategyIsPresent();
		financialMarketsSteps.selectKeyForecasts(keyRegion);
		financialMarketsSteps.verifyTableOfKeyForecasts(exchangeTable,interestTable);
	}
}

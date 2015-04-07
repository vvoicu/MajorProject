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

import bmo5.bmo5tests.adm.steps.ClientAccountsSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.bmo.steps.EntrepriseLoginSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Enterprise.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_02_Enterprise_Login_Login.csv", separator=',')

public class Test_001_02_01_Enterprise_Login_Login extends TestCase {
	
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST_IP)
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
	public EntrepriseLoginSteps entrepriseLoginSteps;
	@Steps
	public bmo5.bmo5tests.adm.steps.LoginSteps admLoginSteps;
	@Steps
	public ClientAccountsSteps clientAccountSteps;
	@Steps 
	public MenuNavigationSteps menuNavigationSteps;
	
	public String username, password,search,word,validation, numberConcurrentUsers,admUsername, admPassword,email, ipUat5, ipStg, serviceEntitlements, currentEntitlements, costCodesOptionOff;
		
	@Test
	public void test_001_02_Enterprise_Login() {
		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.AccountManagement);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ClientAccounts);
		clientAccountSteps.performSearch(email);
		clientAccountSteps.selectAdvancedSettings();
		clientAccountSteps.setConcurentUsers(numberConcurrentUsers);
		Sleeper.sleepTight(5000);
		clientAccountSteps.selectIPorUrl();
		if(Constants.ADM_HOST.contains("uat5")){
			clientAccountSteps.insertIpRange(Constants.IpUat5);
		}
		else if(Constants.ADM_HOST.contains("stg")){
			clientAccountSteps.insertIpRange(Constants.IpStaging);
		}
		else{
			clientAccountSteps.insertIpRange(Constants.IpPublic);
		}
		clientAccountSteps.selectEntitlements(serviceEntitlements, currentEntitlements);
		clientAccountSteps.deselectCostCodes(costCodesOptionOff);
		clientAccountSteps.saveSubscriptionParameters();
		clientAccountSteps.verifyIfCostCodesAreOff(costCodesOptionOff);
		
		admLoginSteps.getDriver().get(Constants.BMO_HOST_IP);
		homePageHeaderSteps.clickOnMyBmoIcon();
		homePageHeaderSteps.verifyMyBmoForIpUser(email);
	}
}

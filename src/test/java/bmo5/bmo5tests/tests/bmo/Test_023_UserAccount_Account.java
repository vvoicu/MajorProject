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
import bmo5.bmo5tests.bmo.steps.MyAccountSteps;
import bmo5.bmo5tests.bmo.steps.ServiceUpdateSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Header.MyBMO.Account.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_023_UserAccount_Account.csv", separator=',')

public class Test_023_UserAccount_Account extends TestCase {
	
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
	@Steps 
	public MyAccountSteps myAccountSteps;
	
	
	public String username, password, oldpassword, newpassword, confirmpassword, validation, accountBreadcrumbs, changePasswordBreadcrumbs, subscriptionBreadcrumbs, contactAccountManagerBreadcrumbs, subject, message, websitePreferencesBreadcrumbs, websitePreference;
		
	
	public void setOldPassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public void setNewPassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public void setConfirmPassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public void setValidation(String validation) {
		this.validation = validation;
	}
	
	@Test
	public void test_023_UserAccount_Account() throws InterruptedException {
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickAccountDropDown();
		homePageTopMenuSteps.verifyBreadCrumb(accountBreadcrumbs);
		myAccountSteps.verifyMyProfileTitle();
		myAccountSteps.verifyMyAccountMangerTitle();
		myAccountSteps.verifyEmailfromProfile(username);
		myAccountSteps.openChangePasswordsection();
		homePageTopMenuSteps.verifyBreadCrumb(changePasswordBreadcrumbs);
		myAccountSteps.verifyemptyfieldsChangePassword();
		myAccountSteps.performChangePassword(oldpassword, newpassword, confirmpassword);
		myAccountSteps.openSubscriptionsSection();
		homePageTopMenuSteps.verifyBreadCrumb(subscriptionBreadcrumbs);
		myAccountSteps.verifySubscriptionsTitle();
		myAccountSteps.openRequestServices();
		myAccountSteps.verifyContactAccountManagerSection(username);
		homePageTopMenuSteps.verifyBreadCrumb(contactAccountManagerBreadcrumbs);
		myAccountSteps.openContactAccountManagerSection();
		homePageTopMenuSteps.verifyBreadCrumb(contactAccountManagerBreadcrumbs);
		myAccountSteps.verifyContactAccountManagerSection(username);
		myAccountSteps.verifyClearbutton(subject,message);
		myAccountSteps.openWebsitePreferencesSection();
		homePageTopMenuSteps.verifyBreadCrumb(websitePreferencesBreadcrumbs);
		myAccountSteps.verifyWebsitePreferencesSection();
		myAccountSteps.verifyChooseWebsitePreferencesSection(username,password,websitePreferencesBreadcrumbs,websitePreference); // values for websitePreference: lp_default, dan, sar, df
		homePageHeaderSteps.clickOnLogout();
	}
	
}

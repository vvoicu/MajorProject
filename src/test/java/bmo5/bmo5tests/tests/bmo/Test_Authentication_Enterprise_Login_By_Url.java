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

import bmo5.bmo5tests.adm.steps.ClientAccountsSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.bmo.steps.AuthenticationTypesSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

/**
 * Enterprise Authentication with only URL
 * 
 * @Test:
 * 
 *        1. Navigate to ADM > Client Account > Advanced settings
 * 
 *        2. Set IP Authentication only to IP&URL
 * 
 *        3. Insert Referring URL
 * 
 *        4. From referring URL click on BMO5 links /cgi-bin.request.pl and
 *        /enter
 * 
 *        5. From BMO5 verify if user is logged in as Enterprise user
 * 
 */

@Story(Application.Authentication.LoginByUrl.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX
		+ "Test_Authentication_Enterprise_Login_IP_URL.csv", separator = ',')
public class Test_Authentication_Enterprise_Login_By_Url extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;

	@Steps
	public bmo5.bmo5tests.adm.steps.LoginSteps admLoginSteps;

	@Steps
	public ClientAccountsSteps clientAccountSteps;

	@Steps
	public AuthenticationTypesSteps authenticationTypesSteps;

	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;

	@Steps
	public MenuNavigationSteps menuNavigationSteps;

	public String username, password, email, admUsername, admPassword, ipUat5,
			ipStg, numberConcurrentUsers, uat5Link, stgLink, liveLink;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPasssword(String password) {
		this.password = password;
	}

	public void setNumberConcurrentUsers(String numberConcurrentUsers) {
		this.numberConcurrentUsers = numberConcurrentUsers;
	}

	public void setAdmUsername(String admUsername) {
		this.admUsername = admUsername;
	}

	public void setAdmPassword(String admPassword) {
		this.admPassword = admPassword;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUAT5Link(String uat5Link) {
		this.uat5Link = uat5Link;
	}

	public void setSTGLink(String stgLink) {
		this.stgLink = stgLink;
	}

	public void setLiveLink(String liveLink) {
		this.liveLink = liveLink;
	}

	@Test
	public void test_Authentication_Enterprise_Login_By_URL() {

		if (uat5Link.contains("WWW") || stgLink.contains("WWW")) {
		} else {
			admLoginSteps.getDriver().get(Constants.ADM_HOST);
			admLoginSteps.performLogin(admUsername, admPassword);
			clientAccountSteps.gotoClientAccountspage();
			clientAccountSteps.performSearch(email);
			clientAccountSteps.selectAdvancedSettings();
			clientAccountSteps.selectIPorURLAutentication();
			clientAccountSteps.deleteReferringURL();
			clientAccountSteps
					.addReferringURL(Constants.AuthenticationTypesURL);
			clientAccountSteps.deleteIpRange();
			menuNavigationSteps.admLogout();
			authenticationTypesSteps
					.navigateTo(Constants.AuthenticationTypesURL);
			if (Constants.ADM_HOST.contains("uat5")) {
				authenticationTypesSteps.clickOnLink(uat5Link);
			} else if (Constants.ADM_HOST.contains("stg")) {
				authenticationTypesSteps.clickOnLink(stgLink);
			} else {
				authenticationTypesSteps.clickOnLink(liveLink);
			}
			// homePageHeaderSteps. clickOnAccount();
			homePageHeaderSteps.verifyMyBmoForIpUser(email);
			homePageHeaderSteps.clickOnLogout();

			// Verify direct URL access BMO5/enter
			authenticationTypesSteps.navigateTo(Constants.BMO_HOST_IP);
			authenticationTypesSteps.loginPageIsDisplayed();
		}
	}
}

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
 *        2. Set IP Authentication only to Form-based 
 * 
 *        3. Delete Referring URL
 *        
 *        4. Delete IP Range
 * 
 *        4. From Form-based page insert username and password on BMO5 links /cgi-bin.request.pl  and  /enter
 * 
 *        5. From BMO5 verify if user is logged in as Enterprise user
 * 
 */

@Story(Application.Authentication.LoginByFormBased.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_Authentication_Enterprise_Login_By_Form_Based.csv", separator=',')

public class Test_Authentication_Enterprise_Login_By_Form_Based extends TestCase {
	
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
	
	public String username,password,email,admUsername,admPassword,ipUat5,ipStg,numberConcurrentUsers,formEnvironmentUAT5,formEnvironmentSTG,formEnvironmentLive;
		
	
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
	public void setFormEnvironmentUAT5(String formEnvironmentUAT5) {
		this.formEnvironmentUAT5 = formEnvironmentUAT5;
	}
	public void setFormEnvironmentSTG(String formEnvironmentSTG) {
		this.formEnvironmentSTG = formEnvironmentSTG;
	}
	public void setFormEnvironmentLive(String formEnvironmentLive) {
		this.formEnvironmentLive = formEnvironmentLive;
	}


	
	@Test
	public void test_Authentication_Enterprise_Login_By_Form_Based() {
		
		if(formEnvironmentUAT5.contains("www") || formEnvironmentSTG.contains("www")){
		}else{
		
			admLoginSteps.getDriver().get(Constants.ADM_HOST);
			admLoginSteps.performLogin(admUsername,admPassword);
			clientAccountSteps.gotoClientAccountspage();
			clientAccountSteps.performSearch(email);
			clientAccountSteps.selectAdvancedSettings();
			clientAccountSteps.selectFormBasedAutentication();
			clientAccountSteps.deleteReferringURL();
			clientAccountSteps.deleteIpRange();
			menuNavigationSteps.admLogout();
			authenticationTypesSteps.navigateTo(Constants.AuthenticationTypesURL);
			if(Constants.ADM_HOST.equals("https://adm-uat5.bmiresearch.com/user/login")){
				authenticationTypesSteps.loginByForm(formEnvironmentUAT5,username,password);
			}
			if(Constants.ADM_HOST.equals("https://adm-stg.bmiresearch.com/user/login")){
				authenticationTypesSteps.loginByForm(formEnvironmentSTG,username,password);
			}
			if(Constants.ADM_HOST.equals("https://adm.bmiresearch.com/user/login")){
				authenticationTypesSteps.loginByForm(formEnvironmentLive,username,password);
			}
			homePageHeaderSteps.clickOnMyBmoIcon();
			homePageHeaderSteps.verifyMyBmoForIpUser(email);
			homePageHeaderSteps.clickOnLogout();
	}
	}
}

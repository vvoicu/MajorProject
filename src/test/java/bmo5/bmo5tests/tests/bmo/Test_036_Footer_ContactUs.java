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
import bmo5.bmo5tests.bmo.steps.homepage.FooterSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Footer.ContactUs.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_036_Footer_ContactUs.csv", separator = ',')

public class Test_036_Footer_ContactUs extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public FooterSteps footerSteps;
	
	@Steps
	public HomePageHeaderSteps  homePageHeaderSteps;
	
	public String username, password,region,breadcrumb,contact,email,invalidEmail,validEmail,subject,clear,sendButton, messageName, messageContent,send,message,key,error;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void region(String region) {
		this.region = region;
	}

	
	@Test
	public void test_036_ContactUs() {
		loginSteps.performLogin(username, password);
		footerSteps.verifyContactUsOnFooter();
		footerSteps.clickOnContactUs(contact);
		footerSteps.verifyBreadCrumbs(breadcrumb);
		footerSteps.doFormOperation(send, error, clear,subject, key, messageName, messageContent);
		footerSteps.sendMailContactForm(send);
		Sleeper.sleepTight(3000);
		footerSteps.verifyConfirmationContactFormMessage(message);
		homePageHeaderSteps.clickContactUsFromDropdown(contact); //contact us from MyBmo Account
		footerSteps.verifyBreadCrumbs(breadcrumb);
		
	}
}


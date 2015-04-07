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

import bmo5.bmo5tests.bmo.steps.EntrepriseLoginSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Enterprise.Header.MyBMO.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enterprise_Login_MyBmo.csv", separator=',')

public class Test_001_Enterprise_Login_MyBmo extends TestCase {
	
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
	
	
	public String profile, subscription, accountContact,url,text,textSubs, textContactAccount,enterpriseBmo,email, emailEnterprise;
		
	
	@Test
	public void test_001_Enterprise_Login_MyBmo() {
		homePageHeaderSteps.clickOnMyBmoIcon();
		homePageHeaderSteps.verifyMyBmoForIpUser(emailEnterprise);
		entrepriseLoginSteps.verifyAccountForEnterprise(profile, subscription, accountContact);
		entrepriseLoginSteps.verifyBreadcrumb(text,textSubs,textContactAccount);
		homePageHeaderSteps.clickOnMyBmoIcon();
		entrepriseLoginSteps.verifyEntrepriseAccountSection(enterpriseBmo);
		loginSteps.getDriver().get(Constants.BMO_HOST_IP);
		homePageHeaderSteps.clickOnMyBmoIcon();
		entrepriseLoginSteps.verifyForgotPassword(email);
		
	}
	}
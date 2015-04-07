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
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.Header.TotalAnalysis.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_007_Header_Methodology.csv", separator = ',')

public class Test_007_Header_Methodology extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HomePageHeaderSteps  homePageHeaderSteps;
	
	public String username, password,alertValue,name,total,methodology;
	
	@Test
	public void test_007_Header_Methodology() {
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnMethodologyAndVerify(total);
		Sleeper.sleepTight(5000);
		homePageHeaderSteps.verifyBreadCrumbHeader(methodology);
		homePageHeaderSteps.clickOnHomePageBreadcrumb();
		
		}
	}
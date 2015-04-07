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

import bmo5.bmo5tests.bmo.steps.BmoGuideSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_061_BmoUserGuide.csv", separator = ',')


public class Test_061_BmoUserGuide extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	
	@Steps
	public BmoGuideSteps bmoGuideSteps;
	
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	
	public String username, password, continent,geographyTop, country,dailyViews,dailyViewsBreadcrumbs,dataToolBreadcrumbs;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Test
	public void test_060_9_BmiDatabases_DvPacks_SaveButton() {
		loginSteps.performLogin(username, password);
		bmoGuideSteps.verifyNavigationModalWindow();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dailyViewsBreadcrumbs);
		bmoGuideSteps.verifyTabStructureWindow();
		homePageTopMenuSteps.clickOnGeography(geographyTop,continent,country);
		bmoGuideSteps.verifyLeftHandNavigation();
		bmoGuideSteps.clickOnNextButtonFromLeftHandNavigationPivotPointAndVerify();
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(dataToolBreadcrumbs);
		bmoGuideSteps.verifyLeftHandNavigation();
		bmoGuideSteps.clickOnNextButtonFromLeftHandNavigationDataToolAndVerify();
		bmoGuideSteps.clickOnBackButtonFromDownloadAndDisplayDataWindowAndVerify();
		bmoGuideSteps.removeForNowTheBMOGuideAndVerify();
//		homePagePillarsSteps.clickAndVerifyDataTool();
//		bmoGuideSteps.stopBMOGuideAndVerify();
	}
}

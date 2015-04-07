package bmo5.bmo5tests.tests.bmo;
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

import bmo5.bmo5tests.adm.steps.widgets.BusinessRulesWidgetsSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelTwoSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Navigation.LessEntitlements.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_LessEntitlements_KeyGlobalForecasts.csv", separator = ',')

public class Test_LessEntitlements_KeyGlobalForecasts {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl =Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
    public BusinessRulesWidgetsSteps businessRulesWidgetsSteps;
	
	@Steps 
	public HomePageLevelTwoSteps homePageLevelTwoSteps;
	
    String bmo5Username, bmo5Password;

	@Test
    public void test_LessEntitlements_KeyGlobalForecasts(){
		loginSteps.performLogin(bmo5Username, bmo5Password);
		homePageLevelTwoSteps.clickOnKeyGlobalForecasts();
		businessRulesWidgetsSteps.verifyPermissionModalByType("");
	}
}

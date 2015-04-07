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
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.bmo.steps.pillars.NoEntitlementsForUserSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.HomePage.Pillars.DataAndForecasting.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_025_2_DataAndForecastingPage_UserDoesNotHaveEntitlementsForCountryRisk.csv", separator = ',')

public class Test_025_2_DataAndForecastingPage_UserDoesNotHaveEntitlementsForCountryRisk extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;

	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;

	@Steps
	public NoEntitlementsForUserSteps noEntitlementsForUserSteps;

	public String username, password, text, element, breadcrumbText,serviceName;
	public String admUsername, admPassword,email,geography,service,item,no,deleteEnt,message,serviceEntitlements,currentEntitlements,geo,serv,confirm,dataTab;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void tabElement(String element) {
		this.element = element;
	}

	public void breadcrumbsText(String text) {
		this.text = text;
	}

	public void breadcrumbText(String breadcrumbText) {
		this.breadcrumbText = breadcrumbText;
	}
	@Steps
	public ClientAccountsSteps clientAccountSteps;
	@Steps
	public bmo5.bmo5tests.adm.steps.LoginSteps admLoginSteps;

	@Test
	public void test_025_2_DataAndForecastingPage_UserDoesNotHaveEntitlementsForCountryRisk() {


		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);

		clientAccountSteps.gotoClientAccountspage();
		clientAccountSteps.performSearch(email);
		clientAccountSteps.selectEntitlements(serviceEntitlements,currentEntitlements);
		clientAccountSteps.selectAndDeleteEntitlementsFromList(deleteEnt,message);


		loginSteps.getDriver().get(Constants.BMO_HOST);
		loginSteps.performLogin(username, password);
		dataAndForecastingSteps.clickDataAndForecastingTab(dataTab);
		dataAndForecastingSteps.selectSubTabDataAndForecasting(element);
		dataAndForecastingSteps.clickCountryRiskTab();
		noEntitlementsForUserSteps.popUpOptionSelected();
		dataAndForecastingSteps.verifyBreadcrumbsForContactAccountManager(breadcrumbText);

		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);

		clientAccountSteps.selectEntitlements(serviceEntitlements,currentEntitlements);
		clientAccountSteps.setUserEntitlements(geography,geo,service,serv);
		clientAccountSteps.saveServiceEntitlements(confirm);
		
	}
}
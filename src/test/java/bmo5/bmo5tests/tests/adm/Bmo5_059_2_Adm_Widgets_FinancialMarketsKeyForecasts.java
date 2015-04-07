package bmo5.bmo5tests.tests.adm;


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

import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.widgets.FinancialAdmMarketsSteps;
import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Widgets.FinancialMarkets.KeyForecasts.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_059_2_Adm_Widgets_FinancialMarkets_KeyForecasts.csv", separator=',')

public class Bmo5_059_2_Adm_Widgets_FinancialMarketsKeyForecasts extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public FinancialAdmMarketsSteps financialAdmMarketsSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	public String keyForecastsBreadcrumb,username, password, region, indicator, indicatorName, geography, description, geographyName;
	
	@Test
	public void bmo5_059_2_Adm_Widgets_FinancialMarkets_KeyForecasts(){
		loginSteps.performLogin(username,password);
		dataToolSteps.goFullScreen();
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.FinancialMarkets);
		financialAdmMarketsSteps.clickOnKeyForecasts();
		menuNavigationSteps.verifyBreadCrumb(keyForecastsBreadcrumb);
		financialAdmMarketsSteps.selectRegionForecasts(region);
		Sleeper.sleepTight(5000);
		financialAdmMarketsSteps.chooseAnIndicator(indicatorName, indicator, region);
		financialAdmMarketsSteps.chooseAGeography(region, geography, geographyName);
		financialAdmMarketsSteps.enterADescription(region, description);
		financialAdmMarketsSteps.clickOnAddRowButton(region, indicatorName, geographyName, description);
		Sleeper.sleepTight(5000);
		financialAdmMarketsSteps.deleteRow(region, indicatorName, geographyName, description);
	}
}
package bmo5.bmo5tests.tests.bmo;

import junit.framework.TestCase;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.AlertsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.Header.MyBMO.Alerts.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_009_Alerts_Create_NewCustom_NewReport_Alert_SaveWithoutTitle.csv", separator = ',')

public class Test_009_Alerts_Create_NewCustom_NewReport_Alert_SaveWithoutTitle extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HomePageHeaderSteps  homePageHeaderSteps;
	
	@Steps
	public AlertsSteps alertsSteps;
	

	@Qualifier
	public String getQualifier() {
		return save;
	}
	
	public String username, password,alertValue,error,save,textName,textCompanies, selectServiceAsOptionAlert,button,frequency,geography,service,company,companyOption,companySearch,
	regionSearch,searchForService,report,clear,clearSeries,optionAlert, sortByPDFAlert, seriesSearch,geographySearch, geographyOptionList, serieOption,textArea,serieOptionList;
	public int radioButtonIntra,radButtonDaily,radButtonWeekly;;
	
	@Test
	public void test_009_Alerts_Create_NewCustom_NewReportAlert_SaveWithoutTitle(){
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnMyBmoIcon();
		homePageHeaderSteps.clickOnEmailAlerts();
 //		alertsSteps.addAlert();
 //		alertsSteps.clickCancel(button);
		alertsSteps.addAlert();
		alertsSteps.selectFirstFrequencyForAddAlert();
		alertsSteps.selectGeographiesOptionsAlert(textName);
		alertsSteps.typeTheFirstLettersForAGeography(regionSearch);
		alertsSteps.selectAGeography(geography);
		
		alertsSteps.clickOnServiceIndustries(selectServiceAsOptionAlert);
		alertsSteps.selectAServiceIndustries(searchForService,service);
		alertsSteps.selectCompany(textCompanies,companySearch);
		alertsSteps.moveCompanyForNewAlerts(company);
		alertsSteps.saveAlert(save);
		alertsSteps.verifyErrorMessageOnSavingWithoutTitle(error);
		
		alertsSteps.selectReportAlertsFromLeftPanel(report);
		alertsSteps.addAlert();
		alertsSteps.selectGeographiesReport(optionAlert);
		alertsSteps.serchForReportGeography(geographySearch);
		alertsSteps.selectGeographiesForReportAlerts (geographyOptionList);
		alertsSteps.clickOnClearReport(clear);
		alertsSteps.selectAddAlertReportFrequency(radButtonDaily, radButtonWeekly);
		alertsSteps.selectSeriesReport(serieOption);
		alertsSteps.searchSeries(seriesSearch);
		alertsSteps.selectSerieReportList(serieOptionList);
		alertsSteps.clearSeriesReport(clearSeries);
		alertsSteps.saveAlert(save);
		alertsSteps.verifyErrorMessageOnSavingWithoutTitle(error);
		
		
	}
}
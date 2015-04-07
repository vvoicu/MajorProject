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

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.AlertsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.Header.MyBMO.Alerts.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_009_6_CreateNewPdfAlert.csv", separator = ',')

public class Test_009_6_Create_NewPdfAlert  extends TestCase {

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
	
	public String getQualifier() {
		return report;
	}
	
	public String username, password, alertValue,report,clear,clearSeries,save, optionAlert, sortByPDFAlert, seriesSearch,geographySearch, geographyOptionList, serieOption,textArea,serieOptionList,button;
	public int radioButtonIntra,radButtonDaily,radButtonWeekly;

	@Test
	public void test_009_6_CreateNewPdfAlert() {
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnMyBmoIcon();
		homePageHeaderSteps.clickOnEmailAlerts();
		alertsSteps.selectReportAlertsFromLeftPanel(report);
		alertsSteps.createNewReportAlert(textArea, optionAlert);
		alertsSteps.chooseSaveCancelAlert(button);
		alertsSteps.createNewReportAlert(textArea, optionAlert);
		alertsSteps.serchForReportGeography(geographySearch);
		alertsSteps.selectGeographiesForReportAlerts (geographyOptionList);
		alertsSteps.clickOnClearReport(clear);
		alertsSteps.selectAddAlertReportFrequency(radButtonDaily, radButtonWeekly);
		alertsSteps.selectSeriesReport(serieOption);
		alertsSteps.searchSeries(seriesSearch);
		alertsSteps.selectSerieReportList(serieOptionList);
		alertsSteps.clearSeriesReport(clearSeries);
		alertsSteps.saveAlert(save);
		//alertsSteps.verifyReportNewAlertMessage();
	}
	}
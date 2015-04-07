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

import bmo5.bmo5tests.bmo.steps.CreateChildAccountSteps;
import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.MncMdgSteps;
import bmo5.bmo5tests.bmo.steps.SavedContentSteps;
import bmo5.bmo5tests.bmo.steps.SearchSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.AlertsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelDailyAnalysisSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Enterprise.Children.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enteprise_VerifyChildren.csv", separator = ',')

public class Test_001_Enteprise_VerifyChildren extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST_IP)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	
	@Steps
	public SearchSteps searchSteps;
	
	@Steps
	public SingleReportSteps singleReportSteps;
	
	@Steps
	public SingleArticleSteps singleArticleSteps;
	
	@Steps
	public CreateChildAccountSteps createChildAccountSteps;
	
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Steps
	public FilterPanelDailyAnalysisSteps filterPanelDailyAnalysisSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public MncMdgSteps mnc_MDG_Steps;
	
	@Steps
	public AlertsSteps alertsSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	@Steps 
	public SavedContentSteps savedContentSteps;
	
	String usernameChildOne, passwordOne, usernameChildTwo,report,save,textArea,service,serviceTop,geographyTop,optionAlert, passwordTwo, continent, country, savedView, geography, indicator, savedSearch, saveTitle, savedData, serviceName, savedMNC, customAlert, reportAlert, breadcrumbString, reportsBreadcrumbs, dataToolBreadcrumbs;
	int articleNumber,radButtonDaily, radButtonWeekly,column,serviceNumber;
	
	@Test
	public void test_001_Enterprise_VerifyChildren() {

		createChildAccountSteps.loginFromEnterprise(usernameChildOne, passwordOne);
		
		homePageHeaderSteps.clickOnLogo();
		homePageTopMenuSteps.clickAndVerifyGeography(geographyTop ,continent, country);
		filterPanelDailyAnalysisSteps.clickOnSaveView(savedView);
		singleArticleSteps.clickOnSaveArticleFromListing(articleNumber);
		
		homePagePillarSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsBreadcrumbs);
		singleArticleSteps.clickOnSaveArticleFromListing(articleNumber);
		
		homePagePillarSteps.clickOnNavigationalTabByLinkTextAndVerify(dataToolBreadcrumbs);
		dataToolSteps.filterExpandSearchSelectGeography(geography);
		dataToolSteps.filterExpandSearchSelectIndicator(indicator);
		dataToolSteps.clickFilterDisplayDataButton();
		dataToolSteps.saveDataChart();
		bmiDatabasesGeneralSteps.saveNameChart(savedData);
		
		homePageHeaderSteps.clickOnSearchButtonAndVerify(breadcrumbString);
		searchSteps.clickOnSaveSearchButton(savedSearch);
		
		homePageTopMenuSteps.selectServicefromTop(serviceTop);
		homePageTopMenuSteps.selectService(service,column,serviceNumber);
		homePageTopMenuSteps.exportContacts();
		mnc_MDG_Steps.clickOnSaveThisSearch(savedMNC);
		
		homePageHeaderSteps.clickOnMyBmoIcon();
		homePageHeaderSteps.clickOnEmailAlerts();
		alertsSteps.addAlert();
		alertsSteps.typeAlertName();
		alertsSteps.selectFirstFrequencyForAddAlert();
		alertsSteps.saveAlert(save);
		
		alertsSteps.selectReportAlertsFromLeftPanel(report);
		alertsSteps.createNewReportAlert(textArea, optionAlert);
		alertsSteps.selectAddAlertReportFrequency(radButtonDaily, radButtonWeekly);

		alertsSteps.saveAlert(save);

		createChildAccountSteps.logoutChild();
		
		createChildAccountSteps.loginFromEnterprise(usernameChildTwo, passwordTwo);
		
		homePageHeaderSteps.clickOnMyBmoIcon();
		homePageHeaderSteps.clickOnEmailAlerts();

		alertsSteps.verifyCustumAlertsAreEmptyForSecondChildEnterpriseUser();
		alertsSteps.selectReportAlertsFromLeftPanel(report);
		alertsSteps.verifyReportAlertsAreEmptyForSecondChildEnterpriseUser();
		
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.verifySavedContentIsEmptySecondChildEnterpriseUser();
		savedContentSteps.clickOnSavedReportsFromLeftPanel();
		savedContentSteps.verifySavedContentIsEmptySecondChildEnterpriseUser();
		savedContentSteps.clickOnSavedDataFromLeftPanel();
		savedContentSteps.verifySavedContentIsEmptySecondChildEnterpriseUser();
		savedContentSteps.clickOnSavedViewsFromLeftPanel();
		savedContentSteps.verifySavedContentIsEmptySecondChildEnterpriseUser();
		savedContentSteps.clickOnSavedSearchesFromLeftPanel();
		savedContentSteps.verifySavedContentIsEmptySecondChildEnterpriseUser();
		savedContentSteps.clickOnSavedMNCFromLeftPanel();
		savedContentSteps.verifySavedContentIsEmptySecondChildEnterpriseUser();
		
		createChildAccountSteps.logoutChild();
		
		createChildAccountSteps.loginFromEnterprise(usernameChildOne, passwordOne);
		
		homePageHeaderSteps.clickOnMyBmoIcon();
		homePageHeaderSteps.clickOnEmailAlerts();
		alertsSteps.deleteAllCustomAlerts();
		alertsSteps.selectReportAlertsFromLeftPanel(report);
		alertsSteps.deleteAllReportAlerts();
		
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.deleteAllSavedContent();
		savedContentSteps.clickOnSavedReportsFromLeftPanel();
		savedContentSteps.deleteAllSavedContent();
		savedContentSteps.clickOnSavedDataFromLeftPanel();
		savedContentSteps.deleteAllSavedContent();
		savedContentSteps.clickOnSavedViewsFromLeftPanel();
		savedContentSteps.deleteAllSavedContent();
		savedContentSteps.clickOnSavedSearchesFromLeftPanel();
		savedContentSteps.deleteAllSavedContent();
		savedContentSteps.clickOnSavedMNCFromLeftPanel();
		savedContentSteps.deleteAllSavedContent();
	}
}

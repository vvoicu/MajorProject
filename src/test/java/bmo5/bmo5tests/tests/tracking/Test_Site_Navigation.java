package bmo5.bmo5tests.tests.tracking;

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

import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.DateUtils;
import bmo5.bmo5tests.tracking.steps.AdmUsageReportingSteps;
import bmo5.bmo5tests.adm.steps.LoginSteps;

@Story(Application.Authentication.Login.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.TRACKING_RESOURCES_PREFIX + "Test_Site_Navigation.csv", separator=',')

public class Test_Site_Navigation extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps admLoginSteps;
	@Steps
	public AdmUsageReportingSteps admUsageReportingSteps;

	public String username, password,bmoUserEmail;
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setBmoUserEmail(String bmoUserEmail) {
		this.bmoUserEmail = bmoUserEmail;
	}

	@Test
	public void test_Site_Navigation() {
		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(username,password);
		admLoginSteps.navigateTo(Constants.UserReportingURL);
		admUsageReportingSteps.clickOnSelectUsersButton();
		admUsageReportingSteps.emailInput(bmoUserEmail);
		admUsageReportingSteps.checkSiteNavigation();
		String startDate = DateUtils.GetUTCdatetimeAsString();
		String endDate = DateUtils.GetUTCdatetimeAsString();
		admUsageReportingSteps.insertStartDate(startDate);
		admUsageReportingSteps.insertEndDate(endDate);
		admUsageReportingSteps.clickExportReportToExcelButton();
		String reportID = admUsageReportingSteps.returnReportID();
		admUsageReportingSteps.clickCloseButtonFromReportWasQueuedModal();
		admUsageReportingSteps.downloadReport(reportID);
//		admUsageReportingSteps.deleteReport(reportID);
		
	}
}
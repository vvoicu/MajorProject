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
import bmo5.bmo5tests.bmo.steps.homepage.FooterSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Footer.TrackRecord.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_035_Footer_TrackRecord.csv", separator = ',')

public class Test_035_Footer_TrackRecord extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public FooterSteps footerSteps;
	
	public String username, password,breadcrumb,record,archive;
	public int region;
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	
	@Test
	public void test_035_Footer_TrackRecord() {
		loginSteps.performLogin(username, password);
		footerSteps.verifyTrackrecordOnFooter();
		footerSteps.clickOnTrackRecords(record);
		footerSteps.clickOnLeftPanel(region);
		footerSteps.clickElementPanel(region);
		footerSteps.clickArchiveFromPanel(region,archive);
		footerSteps.verifyBreadCrumbs(breadcrumb);
}
}

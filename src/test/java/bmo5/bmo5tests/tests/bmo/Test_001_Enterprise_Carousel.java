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

import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.bmo.steps.EmailPopUpWindowSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Enterprise.HomePage.Carousel.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enterprise_Carousel.csv", separator = ',')


public class Test_001_Enterprise_Carousel extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST_IP)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HomePageLevelOneSteps homePageLevelOneSteps;
	
	@Steps 
	public SingleArticleSteps singleArticleSteps;
	
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowsSteps;
	
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	@Steps
	public SingleReportSteps singleReportsSteps;
	
	String username, password, fileName, extensionXLSX, extensionXLS;
	
	@Test
	public void test_001_Enterprise_Carousel() {
		homePageHeaderSteps.clickOnLogo();
		fileName = homePageLevelOneSteps.clickOnFirstArticleFromCarousel();
		System.out.println(fileName);
		singleReportsSteps.clickOnDownloadIconReport(fileName);
		singleArticleSteps.clickOnSaveButtonArticleEnterpriseUser();
		singleArticleSteps.clickOnPrintIconArticle(fileName);
		singleArticleSteps.clickOnEmailIconArticlePage();
		emailPopUpWindowsSteps.verifyEmailWindowElements();
		emailPopUpWindowsSteps.verifySubjectIsEmptyForEnterprise();
		emailPopUpWindowsSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowsSteps.closeEmailWondow();
		singleArticleSteps.clickOnBackToPreviousPage();
		homePageLevelOneSteps.clickOnDvPackFromCarousel();
		dataToolSteps.clickSaveButtonEnterpriseUser();
		dataAndForecastingSteps.downloadAndVerifyGeneralDvPack(extensionXLSX, extensionXLS);
	}
}

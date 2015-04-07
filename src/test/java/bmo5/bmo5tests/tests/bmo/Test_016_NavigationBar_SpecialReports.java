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
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.bmo.steps.EmailPopUpWindowSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.PreviewArticleWindowSteps;
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelSpecialRepSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.homepage.SpecialReportsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisAndReportsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.NavigationEnum;

@Story(Application.HomePage.HomePageTopMenu.SpecialReports.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_016_NavigationBar_SpecialReports.csv", separator = ',')

public class Test_016_NavigationBar_SpecialReports extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public SpecialReportsSteps specialReportsSteps;
	@Steps
	public FilterPanelSpecialRepSteps filterPanelSpecialRepSteps;
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	@Steps
	public SingleReportSteps singleReportSteps;
	@Steps
	public StrategicAnalysisAndReportsSteps strategicAnalysisAndReportsSteps;
	@Steps
	public PreviewArticleWindowSteps previewArticleWindowSteps;
	@Steps
	public DataToolSteps dataToolSteps;
	
	public String username,password,searchTerm,specialReportsTitleNo,geoCheck,itemsPerPage,continent,country,service,reportName,readButton,backToPreviousButon,specialReports,calendardate, sixM, any;
 
	int reportNumber, serviceNumber,geography,anytime, lastWeek, lastM, lastThreeM, lastSixM;
	
	@Test
	/**
	 * Special Reports(top menu,right side of page) 
	 * The test verifies the following actions:
	 * 				- media actions from a preview of a report from the listing page
	 * 				- reading more from report Preview
	 * 				- back to previous Special Reports listing from report detail
	 * 				- pagination: navigate from 2 to previous page(1), then to 2, to 1 to the next one, 2, last and to previous page
	 * 				- in filter, the test verifies:Publication Date section by selecting firstly :radio buttons and then a/an start/end date; geography section by selecting one parent; services section by selecting a service; 
	 *              - it also opens a special report from top Special Reports dropdown's and goes back to the listing page and finally goes on Home page;  
	 */
	
	public void test_016_NavigationBar_SpecialReports() {
		loginSteps.performLogin(username, password);
		specialReportsSteps.clickSpecialReportsup();
		singleReportSteps.clickOnPreviewReportArchiveFromList(reportNumber);
		specialReportsSteps.verifyMediaActionsFromPreview();
		specialReportsSteps.accessReadButtonAndBackToPreviousButtonAndVerifyInsideActions(readButton);
		specialReportsSteps.backToPreviousReportListingPage(backToPreviousButon);
		Sleeper.sleepTight(5000);
		specialReportsSteps.navigateToItem(NavigationEnum.Two);
		specialReportsSteps.navigateToItem(NavigationEnum.Previous);
		specialReportsSteps.navigateToItem(NavigationEnum.Two);
		specialReportsSteps.navigateToItem(NavigationEnum.First);
		specialReportsSteps.navigateToItem(NavigationEnum.Two);
		specialReportsSteps.navigateToItem(NavigationEnum.Next);
		specialReportsSteps.navigateToItem(NavigationEnum.Two);
		specialReportsSteps.navigateToItem(NavigationEnum.Last);
		specialReportsSteps.navigateToItem(NavigationEnum.Previous);
//		specialReportsSteps.selectItemsPerPageAndVerify(itemsPerPage);
		dataToolSteps.goFullScreen();
		Sleeper.sleepTight(3000);
		filterPanelSpecialRepSteps.searchForAllWordsFilter(searchTerm,specialReportsTitleNo);
		filterPanelSpecialRepSteps.selectAndVerifyPublicationDateRadioOptions(anytime,lastWeek,lastM,lastThreeM,lastSixM,sixM,any);
		filterPanelSpecialRepSteps.clickOnLeftPanelGeography(geography,geoCheck);
		Sleeper.sleepTight(5000);
		filterPanelSpecialRepSteps.clickOnDatePicker(calendardate);
		Sleeper.sleepTight(5000);
		filterPanelSpecialRepSteps.clickOnLeftPanelService(serviceNumber);
		filterPanelSpecialRepSteps.verifyBreadcrumbs(specialReports);
		specialReportsSteps.clickSpecialReportsTopMenu(reportNumber,backToPreviousButon);
		filterPanelSpecialRepSteps.clickHome();
		
	
	}

}

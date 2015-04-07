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

import bmo5.bmo5tests.bmo.steps.EmailPopUpWindowSteps;
import bmo5.bmo5tests.bmo.steps.SavedArticlesSavedDataSteps;
import bmo5.bmo5tests.bmo.steps.SavedContentSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.PreviewArticleWindowSteps;
import bmo5.bmo5tests.bmo.steps.SavedReportsSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelNewsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageLevelOneSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.homepage.SpecialReportsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisAndReportsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Header.MyBMO.SavedContent.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_010_2_SavedContent_SavedReports.csv", separator=',')

public class Test_010_2_SavedContent_SavedReports extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public DailyAnalysisAndNewsSteps dailyAnalysisAndNewsSteps;
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public HomePageLevelOneSteps homePageLevelOneSteps;
	@Steps
	public StrategicAnalysisAndReportsSteps strategicAnalysisAndReportsSteps;
	@Steps
	public PreviewArticleWindowSteps previewArticleWindowSteps;
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	@Steps
	public SingleReportSteps singleReportSteps;
	@Steps
	public FilterPanelNewsSteps filterPanelNewsSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public SavedContentSteps savedContentSteps;
	@Steps
	public SingleArticleSteps singleArticleSteps;
	@Steps
	public SpecialReportsSteps specialReportsSteps;
	@Steps
	public SavedArticlesSavedDataSteps savedArticlesSavedDataSteps;
	@Steps
	public SavedReportsSteps savedReportsSteps;
	
	public String username, password, newFolderName, fileName, folderName, myBmoBreadcrumbs, savedReportsBreadcrumbs;
	public int savedReportNumber, folderNumber;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSavedArticleNumber(int savedReportNumber) {
		this.savedReportNumber = savedReportNumber;
	}
	public void setNewFolderName(String newFolderName) {
		this.newFolderName = newFolderName;
	}
	public void setFolderNumber(int folderNumber) {
		this.folderNumber = folderNumber;
	}
	
	@Test
	public void test_010_2_SavedContent_SavedReports(){
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnSavedContent();
//		savedContentSteps.clickOnSavedReportsFromLeftPanel();
////		savedReportsSteps.verifyAlphabeticalOrder();
//		savedContentSteps.addNewFolder(folderName);
//		savedContentSteps.clickOnSavedReportsFromLeftPanel();
//		savedReportsSteps.editFolderName(folderNumber, newFolderName);
//		savedContentSteps.clickOnSavedReportsFromLeftPanel();
//		fileName = savedReportsSteps.checkOneReportFromList(savedReportNumber);
//		savedReportsSteps.verifyActionIconsAfterSelectingItems(savedReportNumber);
//		savedReportsSteps.downloadSelectedItem(fileName, savedReportNumber);
////		savedReportsSteps.printSelectedItem(savedReportNumber);
//		savedReportsSteps.moveToFolder(folderName, savedReportNumber);
//		homePageHeaderSteps.clickOnSavedContent();
//		savedContentSteps.clickOnSavedReportsFromLeftPanel();
//		savedReportsSteps.checkOnOneFolderFromSavedReportsList(folderNumber);
//		savedReportsSteps.printSelectedArticleAndFolder(folderNumber);
//		savedReportsSteps.downloadSelectedArticleAndFolder(folderNumber);
//		savedReportsSteps.deleteSelectedItems(folderNumber, savedReportNumber);
//		savedContentSteps.clickOnSavedReportsFromLeftPanel();
//		fileName = savedReportsSteps.clickOnOneReportFromList(savedReportNumber);
//		savedReportsSteps.clickOnEmailIcon();
//		savedReportsSteps.clickOnDownloadIconReport(fileName);
//		savedReportsSteps.clickOnSaveIconReport();
//		savedReportsSteps.clickOnPrintIconReport();
//		savedReportsSteps.clickOnBackToPreviousPage();
		
		savedContentSteps.clickOnSavedReportsFromLeftPanel();
		savedContentSteps.deleteAllSavedContent();
	}
}

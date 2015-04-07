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

import bmo5.bmo5tests.bmo.steps.EmailPopUpWindowSteps;
import bmo5.bmo5tests.bmo.steps.SavedArticlesSavedDataSteps;
import bmo5.bmo5tests.bmo.steps.SavedContentSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.PreviewArticleWindowSteps;
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
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_010_1_SavedContent_SavedArticles.csv", separator=',')

public class Test_010_1_SavedContent_SavedArticles extends TestCase {
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
	
	public String username, password, newFolderName, fileName, extention, folderName, myBmoBreadcrumbs, savedArticlesBreadcrumbs, secondFolderName;
	public int savedArticleNumber, folderNumber;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSavedArticleNumber(int savedArticleNumber) {
		this.savedArticleNumber = savedArticleNumber;
	}
	public void setNewFolderName(String newFolderName) {
		this.newFolderName = newFolderName;
	}
	public void setFolderNumber(int folderNumber) {
		this.folderNumber = folderNumber;
	}
	
	@Test
	public void test_010_1_SavedContent_SavedArticles(){
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.verifySavedArticlesBreadcrumbs(myBmoBreadcrumbs, savedArticlesBreadcrumbs);
		savedContentSteps.verifySavedArticlesLeftPanel();
		savedContentSteps.verifySortByDate();
		savedArticlesSavedDataSteps.changeToAlphabeticalOrder();
		savedContentSteps.addNewFolder(folderName);
		homePageHeaderSteps.clickOnSavedContent();
		newFolderName = savedContentSteps.editFolder(folderNumber, newFolderName);
		System.out.println(newFolderName);
		Sleeper.sleepTight(5000);
		homePageHeaderSteps.clickOnSavedContent();
		fileName = savedArticlesSavedDataSteps.checkOneItemFromListing(savedArticleNumber);
		savedArticlesSavedDataSteps.verifyActionIconsAfterSelectingItems();
//		savedArticlesSavedDataSteps.printSelectedItem();
		savedArticlesSavedDataSteps.downloadSelectedSavedArticles(fileName);
		savedArticlesSavedDataSteps.moveToFolder(newFolderName);
		homePageHeaderSteps.clickOnSavedContent();
//		savedContentSteps.addNewFolder(folderName);
//		homePageHeaderSteps.clickOnSavedContent();
		savedArticlesSavedDataSteps.checkOneFolderFromListing(folderNumber);
		savedArticlesSavedDataSteps.checkOneItemFromListing(savedArticleNumber);
		savedArticlesSavedDataSteps.printSelectedArticleAndFolder(savedArticleNumber);
		savedArticlesSavedDataSteps.downloadSelectedArticleAndFolder();
		savedArticlesSavedDataSteps.deleteSelectedItems();
		fileName = savedArticlesSavedDataSteps.clickOneItemFromListing(savedArticleNumber);
		savedArticlesSavedDataSteps.clickOnEmailIcon();
		savedArticlesSavedDataSteps.clickOnDownloadIconReport(fileName);
		savedArticlesSavedDataSteps.clickOnSaveIconReport();
		savedArticlesSavedDataSteps.clickOnPrintIconReport();
		savedArticlesSavedDataSteps.clickOnBackToPreviousPage();
		
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.deleteAllSavedContent();
	}
}

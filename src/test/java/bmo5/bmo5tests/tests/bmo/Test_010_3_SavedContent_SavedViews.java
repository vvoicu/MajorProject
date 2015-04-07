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
import bmo5.bmo5tests.bmo.steps.SavedViewsSavedSearchesSavedMncSteps;
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
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_010_3_SavedContent_SavedViews.csv", separator=',')

public class Test_010_3_SavedContent_SavedViews extends TestCase {
	
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
	public SavedViewsSavedSearchesSavedMncSteps savedViewsSavedSearchesSavedMncSteps;
	
	public String username, password, newFolderName, fileName, myBmoBreadcrumbs, savedViewsBreadcrumbs, folderName;
	public int savedViewNumber, folderNumber;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSavedArticleNumber(int savedViewNumber) {
		this.savedViewNumber = savedViewNumber;
	}
	public void setNewFolderName(String newFolderName) {
		this.newFolderName = newFolderName;
	}
	public void setFolderNumber(int folderNumber) {
		this.folderNumber = folderNumber;
	}
	
	@Test
	public void test_010_3_SavedContent_SavedViews(){
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.clickOnSavedViewsFromLeftPanel();
		savedContentSteps.verifySavedViewsBreadcrumbs(myBmoBreadcrumbs, savedViewsBreadcrumbs);
		savedContentSteps.verifySavedViewsLeftPanel();
		savedViewsSavedSearchesSavedMncSteps.verifySortByDate();
		savedViewsSavedSearchesSavedMncSteps.verifyAlphabeticalOrder();
		Sleeper.sleepTight(2000);
		savedContentSteps.addNewFolder(newFolderName);
		Sleeper.sleepTight(2000);
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.clickOnSavedViewsFromLeftPanel();
		savedContentSteps.editFolder(folderNumber, newFolderName);
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.clickOnSavedViewsFromLeftPanel();
		savedViewsSavedSearchesSavedMncSteps.checkOnOneViewFromList(savedViewNumber);
		Sleeper.sleepTight(2000);
		savedViewsSavedSearchesSavedMncSteps.moveToFolder(newFolderName, savedViewNumber); 
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.clickOnSavedViewsFromLeftPanel();
		savedViewsSavedSearchesSavedMncSteps.checkOnOneViewFromList(savedViewNumber);
		savedContentSteps.clickOnSavedViewsFromLeftPanel();
		savedViewsSavedSearchesSavedMncSteps.checkOneFolderFromList(folderNumber);
		Sleeper.sleepTight(2000);
		savedViewsSavedSearchesSavedMncSteps.verifyActionIconsAfterSelectingItems_SV_SMNC(savedViewNumber);
//		savedArticlesSavedDataSteps.moveItemsAndFoldersToFolder(newFolderName, folderNumber); 
//		savedViewsSavedSearchesSavedMncSteps.checkOneFolderFromList(folderNumber);
		savedArticlesSavedDataSteps.deleteSelectedItems(); 
		savedViewsSavedSearchesSavedMncSteps.clickOneSavedViewFromListing(savedViewNumber);
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.clickOnSavedViewsFromLeftPanel();
		savedViewsSavedSearchesSavedMncSteps.checkOnOneViewFromList(savedViewNumber);
		savedViewsSavedSearchesSavedMncSteps.clickOnEditIcon(savedViewNumber);
		
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.clickOnSavedViewsFromLeftPanel();
		savedContentSteps.deleteAllSavedContent();
	}
}

package bmo5.bmo5tests.tests.adm;

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

import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.systemalerts.HelpSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.SystemAlerts.Help.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_050_2_ADM_Help_SearchAndDelete.csv", separator = ',')

public class Bmo5_050_2_Adm_Help_Search_And_Delete extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;

	//ADM steps
	@Steps
	public LoginSteps admLoginSteps;
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	@Steps
	public HelpSteps helpSteps;
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	
	//BMO steps
	@Steps
	public bmo5.bmo5tests.bmo.steps.LoginSteps bmoLoginSteps;
	@Steps
	public HomePageHeaderSteps homeSteps;
	

	public String username, password, search, newName,recordOne, recordTwo, recordThree, recordFour ,recordFive, recordSix, path, content, type, helpName
, chapter, status;
	
	@Test
	public void bmo5_050_2_Adm_Help_Search_And_Delete(){
		admLoginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.SystemAlerts);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Help);
		Sleeper.sleepTight(5000);
		helpSteps.clickOnManageContentButton();
		helpSteps.clickOnAddNewChapterButton();
		helpSteps.completeChaptersNameAndClickOnCancel(chapter);
		helpSteps.clickOnAddNewChapterButton();
		helpSteps.completeChaptersNameAndClickOnAddButton(chapter);
		helpSteps.recordsPerPageSelect(recordSix);
		Sleeper.sleepTight(5000);
		helpSteps.changeTheChaptersNameAndClickOnCancelButton(newName, chapter);
		helpSteps.recordsPerPageSelect(recordSix);
		Sleeper.sleepTight(5000);
		helpSteps.changeTheChaptersNameAndClickOnUpdateButton(newName, chapter);
		Sleeper.sleepTight(5000);
		helpSteps.clickOnHelpButton();
		helpSteps.searchInputManageHelpContentPage(newName);
		helpSteps.searchForSubChaptersInputManageHelpContentPage(newName);
		
		helpSteps.clickOnListViewButton();
		helpSteps.clickOnAddNewSubChapterButton();
		helpSteps.selectTypeMenuItem(type);
		helpSteps.insertANameForPageNewSubChapterClickOnAddButtonAndVerify(helpName);
		helpSteps.resetFormAddingANewSubChapterAndVerify();
		Sleeper.sleepTight(3000);
		helpSteps.completeFieldsWithValidDataClickOnAddButtonAndVerify(type, content, newName, helpName, status);
		Sleeper.sleepTight(2000);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordSix);
		helpSteps.clickOnDeleteIconOfOneElementCancelAndVerify(helpName);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordSix);
		helpSteps.deleteOneItemFromListingAndVerify(helpName);
		
		helpSteps.clickOnManageContentButton();
		helpSteps.recordsPerPageSelect(recordSix);
		helpSteps.clickOnDeleteButtonThenCancel(newName);
		helpSteps.recordsPerPageSelect(recordSix);
		helpSteps.deleteOneChapterFromList(newName);
		helpSteps.clickOnHelpButton();
		helpSteps.recordsPerPageSelect(recordTwo);
		helpSteps.recordsPerPageSelect(recordThree);
		helpSteps.recordsPerPageSelect(recordFour);
		helpSteps.recordsPerPageSelect(recordFive);
		helpSteps.recordsPerPageSelect(recordSix);
		helpSteps.navigateToNextIconManageHelpContentPage();
		helpSteps.navigateToPreviousIconManageHelpContentPage();
		helpSteps.searchInputManageHelpContentPage(search);
	}
}

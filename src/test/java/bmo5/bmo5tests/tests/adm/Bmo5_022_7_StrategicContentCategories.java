package bmo5.bmo5tests.tests.adm;

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

import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.StrategicContentCategoriesSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.StrategicAnalysisAndReportsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;
import junit.framework.TestCase;

@Story(Application.Adm.ControlPanel.StartegicContentCategories.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_022_7_StrategicContentCategories.csv", separator=',')

public class Bmo5_022_7_StrategicContentCategories extends TestCase{
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps admLoginSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	
	@Steps 
	public StrategicContentCategoriesSteps strategicContentCategoriesSteps;
	
	@Steps
	public bmo5.bmo5tests.bmo.steps.LoginSteps bmoLoginSteps;
	
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	
	@Steps
	public StrategicAnalysisAndReportsSteps strategicAnalysisAndReportsSteps;
	
	public String username, password, recordsOne, recordsTwo, recordsThree, recordsFour ,recordsFive, recordsSix, search,service, categoryOne, categoryTwo, bmoUsername, bmoPassword, serviceTop, serviceName, reportsAndStrategicContentBreadcrumbs, strategicContentBreadcrumbs;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRecordsOne(String recordsOne) {
		this.recordsOne = recordsOne;
	}
	
	public void setRecordsTwo(String recordsTwo) {
		this.recordsTwo = recordsTwo;
	}
	
	public void setRecordsThree(String recordsThree) {
		this.recordsThree = recordsThree;
	}
	
	public void setRecordsFour(String recordsFour) {
		this.recordsFour = recordsFour;
	}
	
	public void setrRecordsFive(String recordsFive) {
		this.recordsFive = recordsFive;
	}
	
	public void setRecordsSix(String recordsSix) {
		this.recordsSix = recordsSix;
	}
	
	public void setSearch(String search) {
		this.search = search;
	}
	
	@Test
	public void bmo5_022_7_StrategicContentCategories(){
		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ControlPanel);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.SCCategoriesOrder);
		strategicContentCategoriesSteps.clickOnService();
		strategicContentCategoriesSteps.verifyBreadcrumbs();
		manageWidgetsSteps.navigatePagesAndVerify();
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordsTwo);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordsThree);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordsFour);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordsFive);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordsSix);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordsOne);
		strategicContentCategoriesSteps.verifyTableColumns();
		manageWidgetsSteps.clickHelpButton();
		manageWidgetsSteps.searchInputAndVerify(search);
		strategicContentCategoriesSteps.clickOnServiceFromTableAndVerify(service);
		strategicContentCategoriesSteps.clickOnListViewButtonAndVerify();
		manageWidgetsSteps.selectRecordsPerPageAndVerify(recordsSix);
		strategicContentCategoriesSteps.clickOnServiceFromTableAndVerify(service);
		strategicContentCategoriesSteps.clickOnCancelButtonAndVerify();
		strategicContentCategoriesSteps.moveOneCategoryToRightPanel(categoryOne);
		strategicContentCategoriesSteps.moveOneCategoryToRightPanel(categoryTwo);
		strategicContentCategoriesSteps.clickOnSaveButtonAndVerify();
		
		bmoLoginSteps.getDriver().get(Constants.BMO_HOST);
		bmoLoginSteps.performLogin(bmoUsername, bmoPassword);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(reportsAndStrategicContentBreadcrumbs);
		homePageTopMenuSteps.clickAndVerifyService(serviceTop, serviceName);
		strategicAnalysisAndReportsSteps.verifyFirstCategoryFromFilterAndListWithArticles(categoryOne);
		strategicAnalysisAndReportsSteps.verifySecondCategoryFromFilterAndListWithArticles(categoryTwo);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(strategicContentBreadcrumbs);
		strategicAnalysisAndReportsSteps.verifyFirstCategoryFromFilterAndListWithArticles(categoryOne);
		strategicAnalysisAndReportsSteps.verifySecondCategoryFromFilterAndListWithArticles(categoryTwo);
	}
}

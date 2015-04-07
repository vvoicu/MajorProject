package bmo5.bmo5tests.tests.bmo;

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
import bmo5.bmo5tests.adm.steps.NDBKeyProjectsSteps;
import bmo5.bmo5tests.adm.steps.widgets.BusinessRulesWidgetsSteps;
import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.bmo.steps.SavedArticlesSavedDataSteps;
import bmo5.bmo5tests.bmo.steps.SavedContentSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Header.MyBMO.SavedContent.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_063_2_SavedData_RefreshKeyProjects.csv", separator=',')

public class Test_063_2_SavedData_RefreshKeyProjects {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public  bmo5.bmo5tests.bmo.steps.LoginSteps bmo5LoginSteps;
	
	@Steps
	public NDBKeyProjectsSteps NDBKeyProjectsSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public BusinessRulesWidgetsSteps businessRulesWidgetsSteps;
	
	@Steps
	public SavedContentSteps savedContentSteps;
	
	@Steps
	public SavedArticlesSavedDataSteps savedArticlesSavedDataSteps; 
	
	@Steps
	public  HomePageHeaderSteps  homePageHeaderSteps;
	
	String admUsername, admPassword, bmo5Username, bmo5Password, column, operator,dataToSearch,value,databaseName, breadcrumb,annotationType,description,rowForAnnotation,columnForAnnotation;


	@Test
	public void  test_SavedData_RefreshKeyProjects(){
		
		bmo5LoginSteps.performLogin(bmo5Username, bmo5Password);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(breadcrumb);
		bmiDatabasesGeneralSteps.selectDatabaseFromDropdownList(databaseName);
		bmiDatabasesGeneralSteps.selectProjectNameUserJourney();
		bmiDatabasesGeneralSteps.typeProjectName(dataToSearch);
		bmiDatabasesGeneralSteps.clickOnDisplayDataButton();
		dataToolSteps.tableAddNewCellAnnotation(annotationType,description,rowForAnnotation, columnForAnnotation);
		Sleeper.sleepTight(10000);
		String savedName=bmiDatabasesGeneralSteps.saveTable(dataToSearch); 
		homePageHeaderSteps.clickOnLogout();
		
		businessRulesWidgetsSteps.navigateTo(Constants.ADM_HOST);
		loginSteps.performLogin(admUsername,admPassword);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.NDB);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.KeyProjects);
		NDBKeyProjectsSteps.verifyKeyProjectTableAndFilter(column, operator, dataToSearch);
		String oldValue=NDBKeyProjectsSteps.getOldValue();
		System.out.println(oldValue);
		double newDoubleValue=Double.parseDouble(value);
		double oldDoubleValue=1.0;
		if (!oldValue.equals(" ")){
		 oldDoubleValue=Double.parseDouble(oldValue);
		}
		String newValue =NDBKeyProjectsSteps.typeValueInUSDollarsAndPressEnter(value,oldValue, newDoubleValue, oldDoubleValue);
	    menuNavigationSteps.admLogout();
	    newDoubleValue=Double.parseDouble(newValue);
	    businessRulesWidgetsSteps.navigateTo(Constants.BMO_HOST);
	    bmo5LoginSteps.performLogin(bmo5Username, bmo5Password);
	    homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.clickOnSavedDataFromLeftPanel();
		savedContentSteps.verifySavedDataLeftPanel();
		savedContentSteps.clickLastPageAndClickNewestSavedData(savedName);
		if(!bmiDatabasesGeneralSteps.verifyRefreshButtonDoesNotExist()){
			bmiDatabasesGeneralSteps.clickRefreshButton();
			String date=bmiDatabasesGeneralSteps.verifyNewValueAfterRefresh(newDoubleValue, newValue);
			bmiDatabasesGeneralSteps.verifyRefreshWarning();
	     	  bmiDatabasesGeneralSteps.clickSaveButton();
	     	  bmiDatabasesGeneralSteps.verifySavedNameAndDateInSaveWindow(dataToSearch, date);
			}
		
		businessRulesWidgetsSteps.navigateTo(Constants.ADM_HOST);
		loginSteps.performLogin(admUsername,admPassword);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.NDB);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.KeyProjects);
		NDBKeyProjectsSteps.verifyKeyProjectTableAndFilter(column, operator, dataToSearch);
		NDBKeyProjectsSteps.typeOldValue(oldValue); 
	    menuNavigationSteps.admLogout();
	
	}
}

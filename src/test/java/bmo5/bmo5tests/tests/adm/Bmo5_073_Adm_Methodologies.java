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
import bmo5.bmo5tests.adm.steps.MethodologiesSteps;
import bmo5.bmo5tests.adm.steps.widgets.HotTopicsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;
import junit.framework.TestCase;
@Story(Application.Adm.Methodologies.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_073_Adm_Methodologies.csv", separator=',')

public class Bmo5_073_Adm_Methodologies extends TestCase{

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
	public MethodologiesSteps methodologiesSteps;
	
	@Steps
	public HotTopicsSteps hotTopicsSteps;
	
	public String username, password, indicesOrBmiDatabases, itemsPerPageOne, search, editIndexOrBmiDatabasesBreadcrumbs, indexOrDatabase, indexOrDatabaseName, methodologicalDetails, 
	briefOutlines;
	
	@Test
	public void bmo5_073_Adm_Methodologies(){
		admLoginSteps.performLogin(username,password);
		
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Methodologies);
		if(indicesOrBmiDatabases.equalsIgnoreCase("Indices")){
			menuNavigationSteps.selectMenuItem(AdmMenuItems.Indices);
		}
		else if(indicesOrBmiDatabases.equalsIgnoreCase("BMI Databases")){
			menuNavigationSteps.selectMenuItem(AdmMenuItems.BMIDatabases);
		}
		menuNavigationSteps.verifyBreadCrumb(indicesOrBmiDatabases);
		manageWidgetsSteps.clickHelpButton();
		manageWidgetsSteps.navigatePagesAndVerify();
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPageOne);
		methodologiesSteps.verifyTableColumns();
		manageWidgetsSteps.searchInputAndVerify(search);
		hotTopicsSteps.clickOnOneHotTopicFromListing(search);
		menuNavigationSteps.verifyBreadCrumb(editIndexOrBmiDatabasesBreadcrumbs);
		methodologiesSteps.verifyEditPage(indexOrDatabase, indexOrDatabaseName, methodologicalDetails, briefOutlines);
		methodologiesSteps.clickOnResetButtonAndVerify(indexOrDatabase, indexOrDatabaseName, methodologicalDetails, briefOutlines);
		methodologiesSteps.clickOnListViewButtonAndVerify();
		manageWidgetsSteps.searchInputAndVerify(search);
		hotTopicsSteps.clickOnOneHotTopicFromListing(search);
	}
}

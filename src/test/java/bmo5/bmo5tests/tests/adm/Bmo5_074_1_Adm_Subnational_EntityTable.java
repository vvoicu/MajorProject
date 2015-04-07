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
import bmo5.bmo5tests.adm.steps.subnational.BulkUploadLogSteps;
import bmo5.bmo5tests.adm.steps.subnational.EntityMaintenanceSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Subnational.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_074_1_Adm_EntityTable.csv", separator=',')

public class Bmo5_074_1_Adm_Subnational_EntityTable {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps admLoginSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public EntityMaintenanceSteps entitySteps;
	
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	
	@Steps
	public BulkUploadLogSteps bulkUploadLogSteps;
	
	String username, password,countryISO,entityName,itemsPerPage10,itemsPerPage25,itemsPerPage50,itemsPerPage100,itemsPerPage200,itemsPerPageAll, listSelector,entityMaintenanceBreadcrumb;
	
	@Test
	public void bmo5_074_1_Adm_Subnational_EntityTable() {
		admLoginSteps.performLogin(username, password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.National);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.EntityMaintenance);
		menuNavigationSteps.verifyBreadCrumb(entityMaintenanceBreadcrumb);
		manageWidgetsSteps.navigatePagesAndVerify(); 
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPage25);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPage50);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPage100);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPage10);
		entitySteps.verifyAscendingDescending(listSelector);
		entitySteps.typeSearchItemAndClickSearch(countryISO, entityName);
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPage100);
		entitySteps.verifySearchResults(entityName);
	}
}

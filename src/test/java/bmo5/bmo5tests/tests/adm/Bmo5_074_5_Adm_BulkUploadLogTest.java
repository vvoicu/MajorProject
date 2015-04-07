package bmo5.bmo5tests.tests.adm;


import java.util.Date;
import java.util.List;

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
import bmo5.bmo5tests.adm.steps.subnational.EntityTypeSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.RatingsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;
import junit.framework.TestCase;

@Story(Application.Adm.Subnational.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_074_5_Adm_BulkUploadLog.csv", separator=',')


public class Bmo5_074_5_Adm_BulkUploadLogTest extends TestCase {
	
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps admLoginSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public BulkUploadLogSteps bulkUploadLogSteps;
	
	@Steps
	public EntityTypeSteps entityTypeSteps;
	
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	
	@Steps
	public RatingsSteps ratingsSteps;
	
	@Steps
	public EntityMaintenanceSteps bulkUploadSteps;

	
	String username, password, itemsPerPage1, itemsPerPage2, itemsPerPage3, startDateKeys, endDateKeys, listSelector, lastChildOfBreadcrumb, downloadedFileName;
	int max;
	
	@Test
	public void Test_BulkUploadLog() throws Exception, Throwable {
		
		admLoginSteps.performLogin(username,password);
		driver.manage().window().maximize();
		menuNavigationSteps.selectMenuItem(AdmMenuItems.National);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.EntityMaintenance);
		List<String> statusesFromFileNames = bulkUploadLogSteps.uploadBulkFiles();
		menuNavigationSteps.selectMenuItem(AdmMenuItems.BulkUploadLog);
		menuNavigationSteps.verifyBreadCrumb(lastChildOfBreadcrumb);
		List<String> statusFromDataTable = bulkUploadLogSteps.clickOnDownloadAndVerify(max);
		List<String> listOfNames = bulkUploadLogSteps.verifyFileName(downloadedFileName);
		List<String> statusFromExcel = bulkUploadLogSteps.readExcelFile(listOfNames);
		System.out.println(statusFromExcel);
		bulkUploadLogSteps.compareResults(statusesFromFileNames, statusFromDataTable, statusFromExcel);
		manageWidgetsSteps.navigatePagesAndVerify(); 
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPage2);
		Date start = bulkUploadLogSteps.enterStartDate(startDateKeys);
		Date end = bulkUploadLogSteps.enterEndDate(endDateKeys);
		bulkUploadLogSteps.clickOnSearchButton();
		bulkUploadLogSteps.verifySearchResultsOnStartDate(start);
		bulkUploadLogSteps.verifySearchResultsOnEndDate(end);		
		bulkUploadLogSteps.verifyAscendingDescending(listSelector);
		bulkUploadLogSteps.deleteDownloadedFiles(downloadedFileName);
	}
}

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

import bmo5.bmo5tests.adm.steps.BMIReportsSteps;
import bmo5.bmo5tests.adm.steps.BmiReportsAddProductSteps;
import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.widgets.HotTopicsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Articles.Management.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Test_039_13_BmiReports_ProductSearch.csv", separator=',')

public class Test_039_13_BmiReports_ProductSearch {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps admLoginSteps;
	@Steps 
	public BMIReportsSteps bmiReportsSteps;
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	@Steps
	public HotTopicsSteps hotTopicsSteps;
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	@Steps 
	public BmiReportsAddProductSteps bmiReportsAddProductSteps;
	
	
	public String username, password, region, service, publicationFrequency,  keyword, productCodeReport, itemsPerPage, productCode;
	public int reportNumber;
	
	@Test
	public void adm_039_11_Articles_Management(){
		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.BMIReports);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ProductsSearch);
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
		bmiReportsSteps.selectRegionOrCountry(region);
		bmiReportsSteps.selectService(service);
		bmiReportsSteps.selectPublicationFrequency(publicationFrequency);
		bmiReportsSteps.clickOnSearchButton();
		productCodeReport = bmiReportsSteps.clickOnReportFromTable(reportNumber);
		bmiReportsAddProductSteps.verifyProductCode(productCodeReport);
		bmiReportsAddProductSteps.verifySelectedGeography(region);
		bmiReportsAddProductSteps.verifySelectedService(service);
		
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ProductsSearch);
		bmiReportsSteps.insertProductCode(productCode);
		bmiReportsSteps.clickOnSearchButton();
		bmiReportsSteps.verifyTheReportFromListingPage(productCode);
		bmiReportsSteps.clickOnReportFromTable(1);
		bmiReportsAddProductSteps.verifyProductCode(productCode);
		
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ProductsSearch);
		bmiReportsSteps.insertKeyword(keyword);
		bmiReportsSteps.clickOnSearchButton();
		manageWidgetsSteps.navigatePagesAndVerify();
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPage);
		bmiReportsSteps.verifyThatAllProductTitlesContainTheKeyword(keyword);
	}
}

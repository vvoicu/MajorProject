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

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FiltersPanelGeoPivotSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.ReportsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.HomePage.Pillars.ReportsAndStrategicContent.StrategicContent.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_022_4_StrategicAnalysis_GeoPivot.csv", separator=',')

public class Test_022_4_StrategicAnalysis_GeoPivot extends TestCase {
	
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePagePillarsSteps homePagePillarsSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public FiltersPanelGeoPivotSteps filtersPanelGeoPivotSteps;
	@Steps
	public ReportsSteps reportsSteps;
	
	public String username, password, continent, country, service, subService, category,geographyTop,breadcrumb,clearFilter,all,categoryId;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setService(String service) {
		this.service = service;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Test
	public void test_022_4_StrategicAnalysis_GeoPivot() {
		loginSteps.performLogin(username, password);
		homePagePillarsSteps.clickOnNavigationalTabByLinkTextAndVerify(breadcrumb);
		homePageTopMenuSteps.clickOnGeography(geographyTop,continent, country);
//		filtersPanelGeoPivotSteps.checkServiceOrSubService(service);
//		filtersPanelGeoPivotSteps.verifySelectedService();
		//not needed for now
		//filtersPanelGeoPivotSteps.checkServiceOrSubService(subService);
		
		reportsSteps.clickServiceGeographyToColapseExpandFromPanel();
		Sleeper.sleepTight(10000);
		reportsSteps.chooseAServiceFromLeftPanel(service);
		Sleeper.sleepTight(5000);
		filtersPanelGeoPivotSteps.checkCategory(category);
		filtersPanelGeoPivotSteps.verifySelectedCategory(categoryId);
		Sleeper.sleepTight(3000);
//		filtersPanelGeoPivotSteps.verifyContent(category, service, country);
		filtersPanelGeoPivotSteps.verifyClearFilterLink(clearFilter,all);
	}
}

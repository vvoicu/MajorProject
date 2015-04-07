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
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.bmo.steps.pillars.NoEntitlementsForUserSteps;
import bmo5.bmo5tests.bmo.steps.pillars.ReportsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.HomePage.Pillars.DataAndForecasting.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_025_3_DataAndForecastingPage.csv", separator = ',')

public class Test_025_3_DataAndForecastingPage extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;

	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;

	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;

	@Steps
	public ReportsSteps reportsSteps;

	@Steps
	public NoEntitlementsForUserSteps noEntitlementsForUserSteps;

	public String username, password, text, element, breadcrumbText,dataTab, data,rating,database,cr,security,project,industry,autos,commercial,consumer,food, info,infra,insurance,mining,oil,petro,pharma,power,estate
	,renew,ret,telecom,tourism,ratings, crs, securitys, projects,autosBr,commercialBr,consumerBr,foodBr,itBr,infraBr,InsBr,MinBr,oilBr,petroBr,pharmaBr,powerBr,estateBr,renewBr
	,retBr,telecomBr,tourismBr,breadcrumb,burden,burdenBr,executive,executiveBr,globalMin,operational,ratingBr,operationalRisk,glogalMinBr,globalRef,globalRefBr,infraKey,infraKeyBr,mobile,mobileBr,mdg,mdgBr,powerKey,powerKeyBr,feed,feedBr,renewKey,renewKeyBr,upstream,upstreamBr,medical,medicalBr;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void tabElement(String element) {
		this.element = element;
	}

	public void breadcrumbsText(String text) {
		this.text = text;
	}
	
	public void breadcrumbText(String breadcrumbText) {
		this.breadcrumbText = breadcrumbText;
	}

	@Test
	public void test_025_3_DataAndForecastingPage() {

		loginSteps.performLogin(username, password);
		dataAndForecastingSteps.clickDataAndForecastingTab(dataTab);
		dataAndForecastingSteps.verifyBreadcrumbsForDataAndForecasting(breadcrumbText);
		dataAndForecastingSteps.verifySubTabsPresenceOnPage (data,rating,database,cr,operational,security,project,industry,autos,commercial,consumer,food, info,infra,insurance,medical,mining,oil,petro,pharma,power,estate,renew,ret,telecom,tourism);
		
		dataAndForecastingSteps.verifyDataToolRedirection(data);
		Sleeper.sleepTight(5000);
		dataAndForecastingSteps.verifyAllRatingsOnDataAndaForecastingPage(ratingBr,crs,operationalRisk,securitys,projects,autosBr,commercialBr,consumerBr,foodBr,itBr,infraBr,InsBr,medicalBr,MinBr,oilBr,petroBr,pharmaBr,powerBr,estateBr,renewBr,retBr,telecomBr,tourismBr);
		dataAndForecastingSteps.verifyBMIDatabasesRedirection(breadcrumb);
		dataAndForecastingSteps.verifyAllBmiDatabasesOnDataAndForecastingPage(burden, burdenBr,executive,executiveBr,globalMin,glogalMinBr,globalRef,globalRefBr,infraKey,infraKeyBr,mdg,mdgBr,mobile,mobileBr,powerKey,powerKeyBr,feed,feedBr,renewKey,renewKeyBr,upstream,upstreamBr);
	}
}
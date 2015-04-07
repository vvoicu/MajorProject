package bmo5.bmo5tests.tests.bmo;

import junit.framework.TestCase;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.MncMdgSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Enterprise.HomePageTopMenu.Service.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enterprise_CompanyIntelligence.csv", separator=',')

public class Test_001_Enterprise_CompanyIntelligence extends TestCase {
	
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST_IP)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Steps
	public MncMdgSteps mnc_MDG_Steps;
	
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	@Qualifier
	 public String getQualifier() {
     return serviceTop;
 }
	
	public String service,text,serviceTop;
	public int column,serviceNumber;
	
	
	@Test
	public void test_001_Enterprise_CompanyIntelligence() {
		homePageTopMenuSteps.selectServicefromTop(serviceTop);
		homePageTopMenuSteps.selectService(service,column,serviceNumber);
		homePageTopMenuSteps.verifyBreadCrumb(service);
		homePageTopMenuSteps.exportContacts();
		mnc_MDG_Steps.saveMncSearchForEnterprise();
		
	}
	}
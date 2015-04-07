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
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.adm.steps.ClientAccountsSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.MncMdgSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FooterSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Mdg.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_053_2_Mdg003_BuildingSelection.csv", separator=',')

public class Test_053_2_Mdg003BuildingSelection  extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;

	@Steps
	public bmo5.bmo5tests.adm.steps.LoginSteps admLoginSteps;

	@Steps
	public ClientAccountsSteps clientAccountSteps;

	@Steps
	public MncMdgSteps mnc_MDG_Steps;

	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;

	@Steps
	public FooterSteps footerSteps;

	@Steps
	public MenuNavigationSteps menuNavigationSteps;

	@Qualifier
	public String getQualifier() {
		return breadcrumb;
	}

	String username, password,breadcrumb,companyName,adressName,jobName,companies,product,search,location,companyLoc,jobOption,locationFromList,job,jobFromList,companyTitle,jobTitle,address;
	String admUsername, admPassword,email;

	@Test
	public void test_053_2_Mdg003_BuildingSelection() {
		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);

		menuNavigationSteps.selectMenuItem(AdmMenuItems.AccountManagement);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ClientAccounts);
		clientAccountSteps.performSearch(email);
		clientAccountSteps.selectAdvancedSettings();
		clientAccountSteps.deselectUserType();
		clientAccountSteps.saveAdvancedSettings();
		clientAccountSteps.selectMDG();
		clientAccountSteps.saveAdvancedSettings();

		loginSteps.getDriver().get(Constants.BMO_HOST);

		loginSteps.performLogin(username, password);
		Sleeper.sleepTight(3000);
		mnc_MDG_Steps.verifyBreadCrumbs(breadcrumb);
		mnc_MDG_Steps.doASearchForMdg(search,companyTitle,companyName);
		mnc_MDG_Steps.addressSearch(address,adressName);
		mnc_MDG_Steps.jobSearch(jobTitle,jobName);
		mnc_MDG_Steps.companiesSearch(companies);
		mnc_MDG_Steps.productSearch(product);
		mnc_MDG_Steps.verifyMdgExpandableSectionsName(companyLoc,job);
		mnc_MDG_Steps.typeCompanyLocation(location);
		mnc_MDG_Steps.selectRegionFromList(locationFromList);
		mnc_MDG_Steps.clickJobOption();
		mnc_MDG_Steps.typeJobName(jobOption);
		mnc_MDG_Steps.selectJobFromList(jobFromList); 
		mnc_MDG_Steps.clearJobList();

		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);

		clientAccountSteps.deselectUserType();
		clientAccountSteps.selectMyPreferences();
		clientAccountSteps.saveAdvancedSettings();

	}
}
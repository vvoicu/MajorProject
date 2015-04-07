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
import bmo5.bmo5tests.bmo.steps.homepage.FilterPanelNewsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.ReportsArchiveSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.NavigationItems;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Mdg.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_053_3_Mdg_SelectedCompanyProfile.csv", separator=',')

public class Test_053_3_MdgSelectedCompanyProfile extends TestCase {
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
	public ReportsArchiveSteps reportsArchiveSteps;

	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;

	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;

	@Steps
	public FilterPanelNewsSteps filterPanelNewsSteps;

	@Steps
	public MncMdgSteps mnc_MDG_Steps;

	@Steps
	public MncMdgSteps mncMdgSteps;

	@Steps
	public MenuNavigationSteps menuNavigationSteps;

	@Qualifier
	public String getQualifier() {
		return breadcrumbName;
	}

	String username, password, searchLetters,continentName,country,service,search,breadcrumbCompany,details,text,startDate,endDate,companyName,adressName,jobName,location,itemsPerPage,company;
	String admUsername, admPassword,email,breadcrumbName;
	int itemNumber;

	@Test
	public void test_053_3_Mdg_SelectedCompanyProfile() {
		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);

		menuNavigationSteps.selectMenuItem(AdmMenuItems.AccountManagement);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ClientAccounts);
		clientAccountSteps.performSearch(email);
		clientAccountSteps.selectAdvancedSettings();
		clientAccountSteps.deselectUserType();
		clientAccountSteps.selectMDG();
		clientAccountSteps.saveAdvancedSettings();

		loginSteps.getDriver().get(Constants.BMO_HOST);


		loginSteps.performLogin(username, password);
		mnc_MDG_Steps.verifyBreadCrumb(breadcrumbName);
		mncMdgSteps.clickOnSearchButton(search);
		mnc_MDG_Steps.verifyCompanyProfileAsMdgOnPage() ;
		filterPanelNewsSteps.navigateToItemMdg(NavigationItems.Two);
		filterPanelNewsSteps.navigateToItemMdg(NavigationItems.Previous);
		filterPanelNewsSteps.navigateToItemMdg(NavigationItems.Next);
		//filterPanelNewsSteps.selectItemsPerPage(itemsPerPage);
		mnc_MDG_Steps.clickOnSearchButtonOptions(itemNumber,breadcrumbCompany,details,text);
		Sleeper.sleepTight(6000);
		//	mnc_MDG_Steps.goBackToTheInitialPage();
		driver.navigate().back();
		Sleeper.sleepTight(5000);
		mnc_MDG_Steps.verifyCompanyProfileOnPage();
		Sleeper.sleepTight(4000);
		mnc_MDG_Steps.verifyPaginatorOnPageMdg();

		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);

		clientAccountSteps.deselectUserType();
		clientAccountSteps.selectMyPreferences();
		clientAccountSteps.saveAdvancedSettings();
	}
}
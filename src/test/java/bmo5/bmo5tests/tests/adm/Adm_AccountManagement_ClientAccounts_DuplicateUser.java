package bmo5.bmo5tests.tests.adm;

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

import bmo5.bmo5tests.adm.steps.ClientAccountsSteps;
import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.widgets.HotTopicsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.AccountManagement.ClientAccounts.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Adm_AccountManagement_ClientAccounts_DuplicateUser.csv", separator=',')

public class  Adm_AccountManagement_ClientAccounts_DuplicateUser extends TestCase {
	
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
	public HotTopicsSteps hotTopicsPageSteps;
	@Steps
	public ClientAccountsSteps clientAccountSteps;
	@Steps
	public bmo5.bmo5tests.bmo.steps.LoginSteps loginSteps;
	@Steps
	public HomePageHeaderSteps  homePageHeaderSteps;
	
	
	public String username, password,correctEmail, correctPass, firstName, lastName, companyUserDetail,
	region, type, date, geography, geo, service, serv, clientDetails,searchForEmailType, userNameForSearch, duplicateAccount;
	@Test
	public void adm_AccountManagement_ClientAccounts_DuplicateUser(){
		admLoginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.AccountManagement);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ClientAccounts);
		clientAccountSteps.createAUserDuplicate(searchForEmailType, userNameForSearch, duplicateAccount, companyUserDetail, correctEmail, correctPass, firstName, lastName);
		String userLoginBmo = clientAccountSteps.useEmailForBmoLogin();
		clientAccountSteps.verifyDuplicateUserTabsSelections(clientDetails, date, serv, geo);
		loginSteps.getDriver().get(Constants.BMO_HOST);
		loginSteps.performLogin(userLoginBmo, correctPass);
		homePageHeaderSteps.clickAccountDropDown();
		homePageHeaderSteps.verifyEmailOfTheNewUserOnBmo(userLoginBmo);
	}

}
	
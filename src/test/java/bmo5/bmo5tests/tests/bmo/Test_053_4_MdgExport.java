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

import bmo5.bmo5tests.adm.steps.ClientAccountsSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.MncMdgSteps;
import bmo5.bmo5tests.bmo.steps.homepage.FooterSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Mdg.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_053_4_Mdg_Export.csv", separator=',')

public class Test_053_4_MdgExport  extends TestCase {
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
	public MncMdgSteps mncSteps;

	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;

	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;

	@Steps
	public FooterSteps footerSteps;

	@Steps
	public MncMdgSteps mnc_MDG_Steps;

	@Steps
	public MenuNavigationSteps menuNavigationSteps;

	@Qualifier
	public String getQualifier() {
		return breadcrumb;
	}

	String username, password,breadcrumb,companyTitle,companyName,search,adressName,jobName,companies,product,location,jobOption,extension;
	String admUsername, admPassword,email;

	@Test
	public void test_053_4_Mdg_Export() {
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
		mncSteps.verifyBreadCrumbs(breadcrumb);
		mncSteps.doASearchForMdgCompany(companyTitle,companyName,search);
		mncSteps.exportAction(); 
		mnc_MDG_Steps.clickOnExportAndVerify(extension);

		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);

		clientAccountSteps.deselectUserType();
		clientAccountSteps.selectMyPreferences();
		clientAccountSteps.saveAdvancedSettings();
	}
}
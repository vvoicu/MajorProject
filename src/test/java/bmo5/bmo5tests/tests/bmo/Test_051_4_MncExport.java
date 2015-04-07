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
import bmo5.bmo5tests.bmo.steps.SavedContentSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Mnc.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_051_4_Mnc_Export.csv", separator=',')

public class  Test_051_4_MncExport extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;

	@Steps
	public MncMdgSteps mnc_MDG_Steps;

	@Steps
	public bmo5.bmo5tests.adm.steps.LoginSteps admLoginSteps;

	@Steps
	public ClientAccountsSteps clientAccountSteps;

	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;

	@Steps
	public SavedContentSteps savedContentSteps;

	@Steps
	public MenuNavigationSteps menuNavigationSteps;

	@Qualifier
	public String getQualifier() {
		return breadcrumb;
	}

	String username,password,breadcrumb,companyName,text,extension,companyTitle,search,myBmoBreadcrumbs, savedMncBreadcrumbs,savedMnc,saveMncName;
	String admUsername, admPassword,email;

	@Test
	public void test_051_4_Mnc_Export() {
		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);

		menuNavigationSteps.selectMenuItem(AdmMenuItems.AccountManagement);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ClientAccounts);
		clientAccountSteps.performSearch(email);
		clientAccountSteps.selectAdvancedSettings();
		clientAccountSteps.deselectUserType();
		clientAccountSteps.selectMNC();
		clientAccountSteps.saveAdvancedSettings();

		loginSteps.getDriver().get(Constants.BMO_HOST);
		loginSteps.performLogin(username, password);
		mnc_MDG_Steps.verifyBreadCrumbs(breadcrumb);
		homePageHeaderSteps.clickOnSavedContent();
		//		savedContentSteps.clickOnSavedMNCFromLeftPanel();
		savedContentSteps.deleteAllSavedContent(); //bug BMONG-3528
		homePageHeaderSteps.clickOnLogo();
		mnc_MDG_Steps.doASerachForMnc(companyTitle,companyName,search); 
		saveMncName = mnc_MDG_Steps.saveSearchPopUp(text);
		homePageHeaderSteps.clickOnSavedContent();
		//savedContentSteps.clickOnSavedMNCFromLeftPanel();
		mnc_MDG_Steps.verifySavedMNCInSavedCOntent(savedMnc,saveMncName);
		mnc_MDG_Steps.verifyBreadCrumbs(breadcrumb);
		mnc_MDG_Steps.verifySavedMncMatchesCompanySearchSelections(companyName);
		Sleeper.sleepTight(3000);
		mnc_MDG_Steps.exportAction(); 
		mnc_MDG_Steps.clickOnExportAndVerify(extension);


		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);

		clientAccountSteps.deselectUserType();
		clientAccountSteps.selectMyPreferences();
		clientAccountSteps.saveAdvancedSettings();

	}
}
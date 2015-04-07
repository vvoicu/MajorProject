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
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.ReportsArchiveSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Mnc.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_051_2_Mnc_Search.csv", separator=',')

public class Test_051_2_MncSearch   extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;

	@Steps
	public bmo5.bmo5tests.adm.steps.LoginSteps admLoginSteps;

	@Steps
	public ReportsArchiveSteps reportsArchiveSteps;

	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;

	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;

	@Steps
	public MncMdgSteps mnc_MDG_Steps;

	@Steps
	public ClientAccountsSteps clientAccountSteps;

	@Steps
	public SavedContentSteps savedContentSteps;

	@Steps
	public MenuNavigationSteps menuNavigationSteps;

	@Qualifier
	public String getQualifier() {
		return mncSearch;
	}

	String username, password, text ,companyName,saveCompanyMncName,savedMnc,adressName,jobName,location,search,address,mncSearch,companyTitle,jobTitle,webinar,companyNat,companyLoc,nationality,nationalityFromList,job,locationFromList,jobFromList,industry,industryFromList,breadcrumb;
	String admUsername, admPassword,email;

	@Test
	public void test_051_2_Mnc_Search() {
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
		homePageHeaderSteps.clickOnSavedContent();
		//savedContentSteps.clickOnSavedMNCFromLeftPanel();
		savedContentSteps.deleteAllSavedContentMnc();
		homePageHeaderSteps.clickOnHomePageBreadcrumb();
		mnc_MDG_Steps.searchMNC(search,companyTitle,companyName);
		mnc_MDG_Steps.addressSearch(address,adressName);
		mnc_MDG_Steps.jobSearch(jobTitle,jobName);
		mnc_MDG_Steps.saveSearchPopUp(mncSearch);
		mnc_MDG_Steps.clickCompanyLocation(companyLoc); 
		mnc_MDG_Steps.typeCompanyLocation(location);
		mnc_MDG_Steps.selectRegionFromList(locationFromList);
		mnc_MDG_Steps.clearCompanyButton();
		mnc_MDG_Steps.clickCompanyNationality(companyNat); 
		//mnc_MDG_Steps.nationalitySearchFilter(nationality);
		mnc_MDG_Steps.selectNationalityFromList(nationalityFromList);
		mnc_MDG_Steps.clearCompanyNationalityButton();
		mnc_MDG_Steps.clickOnJobOption(job);
		//	mnc_MDG_Steps.typeJobName(job);
		mnc_MDG_Steps.selectJobFromList(jobFromList);
		mnc_MDG_Steps.clearJobList();
		mnc_MDG_Steps.clickOnIndustryOption(industry);
		//	mnc_MDG_Steps.typeIndustryName(industry);
		mnc_MDG_Steps.selectIndustryFromList(industryFromList);
		mnc_MDG_Steps.clearIndustryList();
		mnc_MDG_Steps.clickOnTheCompanyFromTheList();
		saveCompanyMncName = mnc_MDG_Steps.verifySaveInCompanyDetail(companyName, text);

		homePageHeaderSteps.clickOnSavedContent();
		//	savedContentSteps.clickOnSavedMNCFromLeftPanel();
		//		mnc_MDG_Steps.verifySavedMNCInSavedCOntent(savedMnc,saveCompanyMncName);
		//	homePageHeaderSteps.clickOnSavedContent();
		Sleeper.sleepTight(3000);
		mnc_MDG_Steps.verifyPrintForCompanySavedInMnc(companyName);
		mnc_MDG_Steps.verifyPrintForCompanyOrSearch(companyName);
		mnc_MDG_Steps.selectWebinarsAndPodcasts(webinar);
		mnc_MDG_Steps.verifyWebinarsBreadcrumb(breadcrumb);

		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);

		clientAccountSteps.deselectUserType();
		clientAccountSteps.selectMyPreferences();
		clientAccountSteps.saveAdvancedSettings();

	}
}
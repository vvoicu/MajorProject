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

import bmo5.bmo5tests.adm.steps.ClientAccountsSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.bmo.steps.CostCodesSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.MncMdgSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DailyAnalysisAndNewsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Header.MyBMO.Account.CostCodes.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_066_1_Adm_Bmo_Optional_CostCodes.csv", separator = ',')

public class Test_066_1_Adm_Bmo_Optional_CostCodes extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	
	@Steps
	public CostCodesSteps costCodesSteps;
	
	@Steps
	public MncMdgSteps mnc_MDG_Steps;
	
	@Steps
	public bmo5.bmo5tests.adm.steps.LoginSteps admLoginSteps;
	
	@Steps
	public ClientAccountsSteps clientAccountsSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	
	@Steps
	public DailyAnalysisAndNewsSteps dailyAnalysisAndNewsSteps;

	String username, password,breadcrumb,nameFour,button,logout,account,accountTitle,costCodes,myCostCodes,message,mandatoryCCMessage,nameOne, nameTwo, nameThree,news,labelOneName,labelTwoName,labelThreeName, labelFourName, costCodeNameF, costCodeNameS, costCodeNameT, costCodeNameFo,labelO,labelT,labelTh,labelF;
	String admUsername, admPassword,email,type,costcodes,ccname,label1,label2,label3,label4,status,costCodesOption,off,serviceEntitlements,currentEntitlements,label, newCostCode;
	

	@Test
	public void test_066_1_Adm_Bmo_Optional_CostCodes() {
		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);
		
		menuNavigationSteps.selectMenuItem(AdmMenuItems.AccountManagement);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ClientAccounts);
		clientAccountsSteps.performSearch(email);
		clientAccountsSteps.selectStatus(status);
		clientAccountsSteps.selectUserType(type);
		Sleeper.sleepTight(2000);
		clientAccountsSteps.saveUserDetails();
		Sleeper.sleepTight(4000);
		clientAccountsSteps.selectEntitlements(serviceEntitlements,currentEntitlements);
		clientAccountsSteps.setCostCodesOptional(costcodes, ccname, labelOneName, labelTwoName, labelThreeName, labelFourName);
		clientAccountsSteps.checkShowCostCodeHeader();
		clientAccountsSteps.saveSubscriptionParameters();
		
		loginSteps.getDriver().get(Constants.BMO_HOST);
		loginSteps.performLogin(username, password);
		//costCodesSteps.inputCostCodesAtLogin(labelOneName, labelTwoName, labelThreeName, labelFourName, costCodeNameF, costCodeNameS, costCodeNameT, costCodeNameFo);
		costCodesSteps.selectAnyButtonToContinueOrToResetTheFields(button);
	//	costCodesSteps.verifyCostCodesMessage();
		homePageHeaderSteps.clickAccountDropDown();
		Sleeper.sleepTight(5000);
		costCodesSteps.selectCostCodesFromLeftPanel(costCodes);
		//homePageTopMenuSteps.verifyBreadCrumb(myCostCodes);
		costCodesSteps.verifyEmptyCostCodesFields();
		costCodesSteps.changeAndVerifyTheCostCodeName(labelO,labelT,labelTh,labelF,newCostCode);
		Sleeper.sleepTight(5000);
		costCodesSteps.verifyResetAllAction(message);
	
		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername, admPassword);

		clientAccountsSteps.selectEntitlements(serviceEntitlements,currentEntitlements);
		clientAccountsSteps.deselectCostCodes(costCodesOption);
		clientAccountsSteps.saveSubscriptionParameters();
		clientAccountsSteps.verifyIfCostCodesAreOff(costCodesOption);
		

	}
}
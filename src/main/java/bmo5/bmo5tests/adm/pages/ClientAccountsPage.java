package bmo5.bmo5tests.adm.pages;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import net.thucydides.core.annotations.findby.By;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class ClientAccountsPage extends AbstractAdmPage {

//	public ClientAccountsPage(WebDriver driver) {
//		super(driver);
//	}

	@FindBy(id = "email")
	private WebElement emailuser;

	@FindBy(css = "div.form-actions > button:nth-child(1)")
	private WebElement searchSubmit;

	@FindBy(css = "td.sorting_1 > a")
	private WebElement id;

	@FindBy(css = "div.span6 >h5")
	private WebElement usersummary;

	@FindBy(id = "frozen")
	private WebElement typeList;

	@FindBy(css = "button.btn")
	private WebElement saveSubmit;

	@FindBy(css = "div.alert.alert-success")
	private WebElement messageSave;

	@FindBy(id = "CostCodeMode")
	private WebElement costCodesList;

	@FindBy(id = "ccshowhead")
	private WebElement header;

	@FindBy(id = "cost_code_name")
	private WebElement name;

	@FindBy(css = "input#cost_code_label_1")
	private WebElement cclabel1;

	@FindBy(css = "input#cost_code_label_2")
	private WebElement cclabel2;

	@FindBy(css = "input#cost_code_label_3")
	private WebElement cclabel3;

	@FindBy(css = "input#cost_code_label_4")
	private WebElement cclabel4;

	@FindBy(css = "a[href='#entitlements']")
	private WebElement entitlements;

	@FindBy(css = "form#save_subscription_parameters > div:nth-child(7) > button")
	private WebElement saveParameters;

	@FindBy(css = "div.control-group >label.control-label")
	private WebElement typeClick;

	@FindBy(id = "dexpired_yn")
	private WebElement statusList;

	@FindBy(id = "finish_date")
	private WebElement finishDate;

	@FindBy(id = "allEntitlements")
	private WebElement deleteEntitlements;

	@FindBy(css = "div#entitlements > div:nth-child(2) > div:nth-child(2) > form:nth-child(2) > div > button ")
	private WebElement deleteSelectedEntitlements;

	@FindBy(id = "all_Geographies")
	private WebElement selectGeographies;

	@FindBy(id = "all_Services")
	private WebElement selectServices;

	@FindBy(id = "all_Geographies_rightSelected")
	private WebElement movetoRightGeographies;

	@FindBy(id = "all_Services_rightSelected")
	private WebElement movetoRightServices;

	@FindBy(css = "button#save_entitlements")
	private WebElement saveEntitlements;

	@FindBy(css = "a[href='#advanced']")
	private WebElement advancedSettings;

	@FindBy(id = "InterfaceID_4")
	private WebElement versionfour;

	@FindBy(id = "userid")
	private WebElement userNameField;

	@FindBy(id = "InterfaceID_5")
	private WebElement versionfive;

	@FindBy(id = "id-account-version")
	private WebElement saveVersion;

	@FindBy(id = "ipbased_yn")
	private WebElement ipOrURLbox;

	@FindBy(id = "iprequired_yn")
	private WebElement ipAndURLbox;

	@FindBy(id = "postbased_yn")
	private WebElement formPortBasedbox;

	@FindBy(id = "id-advanced-customisation")
	private WebElement saveIP;

	@FindBy(id = "ref_url")
	private WebElement refURLfield;

	@FindBy(id = "id-add-url-management")
	private WebElement addURL;

	@FindBy(css = "table.table.table-condensed.table-bordered.table-striped.urls > thead > tr > th:nth-child(2) > input")
	private WebElement refURLallCheckbox;

	@FindBy(id = "id-deleted-urls")
	private WebElement deleteRefURLs;

	@FindBy(id = "ip_from")
	private WebElement addIPText;

	@FindBy(id = "id-add-ip-range")
	private WebElement addIPRange;

	@FindBy(css = "table.table.table-condensed.table-bordered.table-striped.ips > thead > tr > th:nth-child(3) > input")
	private WebElement allIpRangesCheckButton;

	@FindBy(id = "id-deleted-ips")
	private WebElement deleteIpRangesButton;

	@FindBy(id = "mnc")
	private WebElement checkMNC;

	@FindBy(css = "input#mdg")
	private WebElement checkMDG;

	@FindBy(id = "PDFService_YN")
	private WebElement checkPDF;

	@FindBy(id = "PrefsEnabled_YN")
	private WebElement checkMYPref;

	@FindBy(css = "ul#sidebar > li:nth-child(2) > a > span:nth-child(2)")
	private WebElement pageSelectAccountManagement;

	@FindBy(css = "ul#sidebar > li:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a > span:nth-child(2)")
	private WebElement pageSelectClientAccounts;

	@FindBy(css = "form[class='form-horizontal']:nth-of-type(3) button.btn")
	private WebElement saveAdvancedSettingsButton;

	@FindBy(id = "CostCodeMode")
	private WebElement containerCostCodesOption;

	@FindBy(css = "div#entitlements > div:nth-child(2) > div:nth-child(2) > form:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(3) > input")
	private WebElement containerEntitlementsList;

	@FindBy(css = "input#maxsessions")
	private WebElement concurrentUsersInputBox;

	@FindBy(css="select#frozen")
	private WebElement userTypeDropDown;

	@FindBy(css = "a[href='/accountmanagement/client/new_client']")
	private WebElement addNewUser;

	@FindBy(id= "firstname")
	private WebElement inputFirstNameField;

	@FindBy(id = "lastname")
	private WebElement inputLastNameField;

	@FindBy(id = "password")
	private WebElement inputPasswordField;

	@FindBy(id = "company")
	private WebElement inputCompanyNameField;

	@FindBy(id = "country_id")
	private WebElement containerCountrydropdownForNewUser;

	@FindBy(id = "frozen")
	private WebElement containerTypeNewUser;

	@FindBy(css = "label[for='SFOpportunityID']")
	private WebElement sfOpportunityName;

	@FindBy(id = "SFOpportunityID")
	private WebElement inputSfOpportunityField;

	@FindBy(css = "label.help-block.error")
	private WebElement errorForExistingEmail;

	@FindBy(css = "div.widget-content > form > div:nth-of-type(1) > div > div > label")
	private WebElement errorMessageForEmailEmpty;

	@FindBy(css = "div.widget-content > form > div:nth-of-type(4) > div:nth-of-type(1) > div > label")
	private WebElement errorForEmptyFirstName;

	@FindBy(css = "div.widget-content > form > div:nth-of-type(4) > div:nth-of-type(2) > div > label")
	private WebElement errorForEmptyLastName;

	@FindBy(css = "div.widget-content > form > div:nth-of-type(5) > div:nth-of-type(1) > div > label")
	private WebElement errorForEmptyCompany;

	@FindBy(css = "div.widget-content > form > div:nth-of-type(2) > div:nth-of-type(2) > div > label")
	private WebElement errorMessageForInvaliEmptydPass;

	@FindBy(css = "div#breadcrumb > div:nth-of-type(1) > a:last-child")
	private WebElement lastChildBrClientsAcc;

	@FindBy(css = "div#breadcrumb > div > span[class='current']")
	private WebElement lastElementBreadcrumb;

	@FindBy(css = "input#expired_yn")
	private WebElement statusActive;

	@FindBy(css = "select#frozen > option[selected='selected']")
	private WebElement selectedTypeVerified;

	@FindBy(css = "div#content > div > div >div:nth-of-type(2) > form > table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)")
	private WebElement getEmailFromSummary;

	@FindBy(css = "div#content > div > div >div:nth-of-type(2) > form > table > tbody > tr:nth-of-type(1) > td:nth-of-type(1)")
	private WebElement userNo;

	@FindBy(css = "a[href='#alerts']")
	private WebElement selectAlertsSectionFOrUSerDetail;

	@FindBy(css = "a[href='#details']")
	private WebElement userDetails;

	@FindBy(css = "div#breadcrumb > div:nth-of-type(2) > div:nth-of-type(2) > a")
	private WebElement duplicateButton;

	@FindBy(css = "div#breadcrumb > div:nth-of-type(2) > div:nth-of-type(3) > a")
	private WebElement createChildButton;

	@FindBy(css = "div#breadcrumb > div:nth-of-type(2) > div:nth-of-type(4) > a")
	private WebElement deleteUserButton;

	@FindBy(css = "button.btn.btn-link.evil.color")
	private WebElement resetUserDetailForm;

	@FindBy( id = "UserNo")
	private WebElement userID;

	@FindBy( id = "InterfaceID_5")
	private WebElement versionFive;

	@FindBy(css = "div.text.align.right.row-fluid.control-group > div > a:nth-of-type(1)")
	private WebElement viewHistory;

	@FindBy(css = "div.text.align.right.row-fluid.control-group > div > a:nth-of-type(2)")
	private WebElement usageSummary;

	@FindBy(css = "input[aria-controls='DataTables_Table_0']")
	private WebElement searchForUsersTypeField;

	@FindBy(css = "table#DataTables_Table_0 > tbody > tr:last-child > td:nth-of-type(1) > a")
	private WebElement lastIdOfUserCreated;

	@FindBy(css = "div#content > div > div > div:nth-of-type(2) > div:nth-of-type(4) > div > h5:nth-of-type(2) > a")
	private WebElement parentEmailSummary;

	@FindBy(css = "div#entitlements > div:nth-of-type(1) > div:nth-of-type(1) > h5")
	private WebElement subscriptionParamSectionName;

	@FindBy(css = "div#entitlements > div:nth-of-type(2) > div:nth-of-type(1) > h5")
	private WebElement  servEntitlementsSection;

	@FindBy(css = "a[href='#children']")
	private WebElement childrenSectionOnParent;

	@FindBy(css = "div.tab-content> div#children > div:nth-of-type(1) > div:nth-of-type(2) > table > tbody > tr:last-child > td:nth-of-type(2) > a")
	private WebElement lastChildCreated;

	public void deleteUser() {
		deleteUserButton.click();
	}
	
	public void verifyChildrenSection() {
		waitABit(3000);
		Assert.assertTrue(childrenSectionOnParent.isDisplayed());
		childrenSectionOnParent.click();
		System.out.println("Children section opened!");
	}

	public void verifyLastChildCreatedInChildrenSection(String userLoginBmo) {
		System.out.println("1");
		waitABit(3000);
		System.out.println(lastChildCreated);
		Assert.assertTrue(lastChildCreated.getText().contains(userLoginBmo));	
	}

	public void clickOnCreateChildButton(String addNewChild) {
		createChildButton.click();
		waitABit(3000);
		verifyBreadcrumbForNewCientAccount(addNewChild);
	}

	public void verifyConfirmMessageForNewUserTypeCreated() {
		waitABit(4000);
		Assert.assertTrue(messageSave.isDisplayed());
	}

	public void verifyEntitlementsChildSection() {
		entitlements.click();
		Assert.assertTrue(subscriptionParamSectionName.isDisplayed());
		Assert.assertTrue(servEntitlementsSection.isDisplayed());
		waitABit(3000);
		userDetails.click();
	}

	public void clickOnDuplicateButtonForUser(String duplicateAccount) {
		duplicateButton.click();
		waitUntilElementExists(By.cssSelector("div.pull-left > h5"), 4);
		verifyBreadcrumbForNewCientAccount(duplicateAccount);
	}

	public void verifyBreadcrumbForClientDetails(String clientDetails) {
		Assert.assertTrue(lastElementBreadcrumb.getText().contains(clientDetails));
	}

	public void entitlementsAndSubscriptionsAndAdvancedSettingsAreaMatchesTheRegularUserForTheDUplicate(String date,String serv, String geo) {
		entitlements.click();
		Assert.assertTrue(finishDate.getAttribute("value").contains(date));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("table.table.table-bordered.table-striped.current-entitlements > tbody > tr > td:nth-of-type(1)")).getText().contains(serv));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("table.table.table-bordered.table-striped.current-entitlements > tbody > tr > td:nth-of-type(2)")).getText().contains(geo));
		advancedSettings.click();
		Assert.assertTrue(versionFive.getAttribute("value").contains("5"));
	}

	public void verifyDuplicateUserHasCompanyCountryAndTypeAsTheRegularUserCreated(String companyUserDetail) {
		Assert.assertTrue("The company is not the same!",inputCompanyNameField.getAttribute("value").contains(companyUserDetail));
		Assert.assertTrue("The country is not the same!",getDriver().findElements(By.cssSelector("select#country_id > option[selected='']")).size() ==1);
		Assert.assertTrue("The type is not the same!",getDriver().findElements(By.cssSelector("select#frozen > option[selected='']")).size() ==1);
	}

	public void clickOnAlertsTab() {
		selectAlertsSectionFOrUSerDetail.click();
	}

	public void clickOnEntitlementsAndSubscriptionsTab(String date) {
		entitlements.click();
		setFinishDate(date);
		saveParameters.click();
	}

	public void verifyPresenceOfHistoryAndUsageSummaryButtons() {
		Assert.assertTrue(viewHistory.isDisplayed());
		Assert.assertTrue(usageSummary.isDisplayed());
	}

	public void clickOnSaveAlerts(String saveAlertType) {
		getDriver().findElement(By.cssSelector("div#alerts > div:nth-of-type("+saveAlertType+") > div:nth-of-type(2) > form > div:nth-of-type(1)> button")).click();
	}

	public void verifyBmoVersionAndRegularTypeUserOnAdvancedSet() {
		advancedSettings.click();
		waitUntilElementExists(By.cssSelector("div#advanced > div > div:nth-of-type(1)"), 3);
		Assert.assertTrue("5 version is not set!", versionFive.getAttribute("value").contains("5"));
		waitABit(2000);
		Assert.assertTrue("My Preferences is not set!!!", getDriver().findElements(By.cssSelector("input#PrefsEnabled_YN[checked='1']")).size() == 1);
	}

	public void searchAfterUserNumber(String idUser) {
		userID.click();
		userID.sendKeys(idUser);
		searchSubmit.click();
		waitABit(4000);
	}

	public void verifyUserNameAndSFAreDisabled() {
		waitABit(4000);
		Assert.assertTrue(userNameField.getAttribute("readonly").contains("true"));
		Assert.assertTrue(sfOpportunityName.getAttribute("readonly").contains("readonly"));
	}

	public void searchAfterUserNameAndClickOnTheLastUserId(String searchForEmailType,String userName) {
		emailuser.click();
		emailuser.sendKeys(searchForEmailType);
		searchSubmit.click();
		searchForUsersTypeField.click();
		searchForUsersTypeField.sendKeys(userName);
		lastIdOfUserCreated.click();
	}

	public void clickOnNewUserButton() {
		addNewUser.click();
	}

	public void clickOnResetUserFormButton() {
		resetUserDetailForm.click();
		waitABit(4000);
	}

	public void clickOnSaveUserDetailsButton() {
		saveSubmit.click();
	}

	public String useEmailFromEmailFieldLoginOnBmo() {
		waitABit(2000);
		String email = emailuser.getAttribute("value");
		System.out.println(email);
		return email;	
	}

	public String getParentEmailAddressFromChildSummary() {
		String parentEmailAddr = parentEmailSummary.getText();
		return parentEmailAddr;
	}


	public void selectCountryFromDropdownForNewUser(String region) {
		selectFromDropdown(containerCountrydropdownForNewUser, region);
		//verifying the selected region is not working because the country is not selected
	}

	public void selectTypeFromDropdownForNewUser(String type) {
		selectFromDropdown(containerTypeNewUser, type);
	}

	public void verifyTypeWasSelected(String type) {
		Assert.assertTrue("Type was not selected from dropdown!",selectedTypeVerified.getText().contains(type));
	}

	public void messageErrorForExistingEmail(String errorExistingEmail) {
		Assert.assertTrue(errorForExistingEmail.getText().contains(errorExistingEmail));
	}

	public void messageErrorForEmptyWrongEmail(String erroremptyInvalidEmail) {
		Assert.assertTrue(errorMessageForEmailEmpty.getText().contains(erroremptyInvalidEmail));
	}

	public void messageErrorForWrongEmail(String erroremptyInvalidEmail) {
		Assert.assertTrue(errorMessageForEmailEmpty.getText().contains("Email address not valid."));
	}

	public void messageErrorForEmptyFirstName(String errorEmptyFirstName) {
		Assert.assertTrue(errorForEmptyFirstName.getText().contains(errorEmptyFirstName));
	}

	public void messageErrorForEmptyLastName(String errorEmptyLastName) {
		Assert.assertTrue(errorForEmptyLastName.getText().contains(errorEmptyLastName));
	}

	public void messageErrorForEmptyPassword(String errorEmptyPassword) {
		Assert.assertTrue(errorMessageForInvaliEmptydPass.getText().contains(errorEmptyPassword));
	}

	public void messageErrorForInvalidPassword(String errorInvalidPassword) {
		Assert.assertTrue(errorMessageForInvaliEmptydPass.getText().contains("Please enter a valid password. The password must contain minimum 8 characters, and at least 1 digit and 1 uppercase."));
	}

	public void messageErrorForEmptyCompany(String errorEmptyCompany) {
		Assert.assertTrue(errorForEmptyCompany.getText().contains(errorEmptyCompany));
	}

	public void inputEmailAddressField(String correctEmail) {
		emailuser.click();
		int ran;
		ran = 100 + (int) (Math.random() * ((10000 - 100) + 1));
		correctEmail = ran + correctEmail;
		emailuser.sendKeys(correctEmail);
	}

	public void inputWrongEmailPassword(String wrongEmail,String wrongPass,String erroremptyInvalidEmail,String errorInvalidPassword) {
		emailuser.click();
		emailuser.sendKeys(wrongEmail);
		inputPasswordField.click();
		inputPasswordField.sendKeys(wrongPass);
		saveSubmit.click();
		waitABit(5000);
		messageErrorForInvalidPassword(errorInvalidPassword);
		messageErrorForWrongEmail(erroremptyInvalidEmail);
	}

	public void inputFirstNewUserName(String firstName) {
		inputFirstNameField.click();
		inputFirstNameField.sendKeys(firstName);
	}

	public void inputLastNewUserName(String lastName) {
		inputLastNameField.click();
		inputLastNameField.sendKeys(lastName);
	}

	public void clickOnUsernameField() {
		userNameField.click();
		waitABit(2000);
	}

	public void inputCompanyUserDetailName(String companyUserDetail) {
		inputCompanyNameField.click();
		inputCompanyNameField.sendKeys(companyUserDetail);
	}

	public void inputCorrectPassForNewUser(String correctPass) {
		inputPasswordField.click();
		inputPasswordField.sendKeys(correctPass);
	}

	public void verifyTheUserWasCreated() {
		waitUntilElementExists(By.cssSelector("div.control-group > label[for='expired_yn']"), 4);
		Assert.assertTrue("Status not found!", statusActive.getAttribute("value").contains("Active"));
	}
	public void saveWithoutCompletingAnyFieldForTheNewUser(String errorExistingEmail,String errorEmptyFirstName,String errorEmptyLastName,String errorEmptyPassword,String erroremptyInvalidEmail) {
		saveSubmit.click();
		messageErrorForEmptyCompany(errorExistingEmail);
		messageErrorForEmptyFirstName(errorEmptyFirstName);
		messageErrorForEmptyLastName(errorEmptyLastName);
		messageErrorForEmptyPassword(errorEmptyPassword);
		messageErrorForEmptyWrongEmail(erroremptyInvalidEmail);
	}

	public void selectEntitlementsFromList(String deleteEnt, String message) {
		element(containerEntitlementsList).waitUntilVisible();
		// Assert.assertTrue(containerEntitlementsList.isSelected());
		containerEntitlementsList.click();
		deleteSelectedEntitlements.click();
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div#entitlements > div:nth-child(2) > div:nth-child(2) >form:nth-child(2) > div > button"))
						.getText().contains(deleteEnt));
		element(
				getDriver().findElement(
						By.cssSelector("div.alert.alert-success")))
						.waitUntilPresent();
		Assert.assertTrue(getDriver()
				.findElement(By.cssSelector("div.alert.alert-success"))
				.getText().contains(message));
	}

	public void selectIPorUrl() {
		if (getDriver()
				.findElements(
						By.cssSelector("div#advanced > div > div:nth-child(2) > form:nth-child(3) > div:nth-child(15) > div:nth-child(2) > div > div >div:nth-child(1) > div:nth-child(1) > label > input[checked='1']"))
						.size() == 0) {
			ipOrURLbox.click();
			saveIP.click();
			waitABit(10000);
			Assert.assertTrue(getDriver()
					.findElements(
							By.cssSelector("div#advanced > div > div:nth-child(2) > form:nth-child(3) > div:nth-child(15) > div:nth-child(2) > div > div >div:nth-child(1) > div:nth-child(1) > label > input[checked='1']"))
							.size() == 1);
		} else {
			System.out.println("Ip or Url option is already selected");
		}
	}

	public void deselectIpOrUrl() {
		if (getDriver()
				.findElements(
						By.cssSelector("div#advanced > div > div:nth-child(2) > form:nth-child(3) > div:nth-child(15) > div:nth-child(2) > div > div >div:nth-child(1) > div:nth-child(1) > label > input[checked='1']"))
						.size() == 1) {
			ipOrURLbox.click();
			saveIP.click();
			waitABit(10000);
			Assert.assertTrue(getDriver()
					.findElements(
							By.cssSelector("div#advanced > div > div:nth-child(2) > form:nth-child(3) > div:nth-child(15) > div:nth-child(2) > div > div >div:nth-child(1) > div:nth-child(1) > label > input[checked='1']"))
							.size() == 0);
		} else {
			System.out.println("Ip or Url option is not selected");
		}
	}

	public void insertIpRange(String ip) {
		addIPText.sendKeys(ip);
		addIPRange.click();
	}

	public void addCurrentMachineIP() {
		try {
			InetAddress inet = InetAddress.getLocalHost();
			InetAddress[] ips = InetAddress.getAllByName(inet.getCanonicalHostName());
			if (ips != null) {
				for (int i = 0; i < ips.length; i++) {
					System.out.println(ips[i].getHostAddress());
					addIPText.sendKeys(ips[i].getHostAddress());
					addIPRange.click();
				}
			}
		} catch (UnknownHostException e) {

		}
	}

	public void deleteIpRange() {
		allIpRangesCheckButton.click();
		deleteIpRangesButton.click();
		waitABit(3000);
		Assert.assertTrue(getDriver()
				.findElements(
						By.cssSelector("table[class='table table-condensed table-bordered table-striped ips'] > tbody > tr "))
						.size() == 0);
	}

	public void selectClientAccounts() {
		pageSelectAccountManagement.click();
		Sleeper.sleepTight(4000);
		pageSelectClientAccounts.click();

	}

	public void userSearch(String email) {
		emailuser.click();
		emailuser.sendKeys(email);
		searchSubmit.submit();
		id.click();
	}

	public void verifyUser(String email) {
		Assert.assertTrue("Another user has been open", usersummary.getText()
				.contains(email));
	}

	// another method with selectFromDropdown exists for user type + Assertion after save details
	public void selectType(String type) {
		Select userTypeSelect=new Select(userTypeDropDown);
		  userTypeSelect.selectByValue(type);
		  typeClick.click();
	}

	// another method with selectFromDropdown exists for user type + Assertion after save details
	public void selectUserTypeByvisibleText(String userType){
		 Select userTypeSelect=new Select(userTypeDropDown);
		  userTypeSelect.selectByVisibleText(userType);
		  typeClick.click();
	}

	public boolean isUserTrial(String userType){
		 Select userTypeSelect=new Select(userTypeDropDown);
		  return userTypeSelect.getFirstSelectedOption().getText().contains(userType);
	}

	public void assertTrialUser(String userType){
		 Select userTypeSelect=new Select(userTypeDropDown);
		  Assert.assertTrue("Trial user not selected",userTypeSelect.getFirstSelectedOption().getText().contains(userType));
	}

	public void selectStatus(String status) {
		waitABit(3000);
		Select itemsPerPage = new Select(getDriver().findElement(
				By.cssSelector("select#expired_yn")));
		itemsPerPage.selectByValue(status);

	}

	public void saveDetails() {
		saveSubmit.submit();
		waitABit(3000);
		Assert.assertTrue("Details did not save! ", messageSave.getText()
				.contains("Details succesfully saved."));
	}

	public void selectEntitlemets(String servEntitlements,
			String currentEntitlements) {
		entitlements.click();
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div#entitlements > div:nth-child(2) > div:nth-child(1) > h5"))
						.getText().contains(servEntitlements));
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div#entitlements > div:nth-child(2) > div:nth-child(2) > form:nth-child(2) > h5"))
						.getText().contains(currentEntitlements));

	}

	public void setCostCodes(String costcodes, String ccname, String labelOne,
			String labelTwo, String labelThree, String labelFour) {
		element(getDriver().findElement(By.cssSelector("select#CostCodeMode"))).click();
		Select itemsPerPage = new Select(getDriver().findElement(
				By.cssSelector("select#CostCodeMode")));
		itemsPerPage.selectByValue("Mandatory");
	//	selectFromDropdown(getDriver().findElement(By.cssSelector("select#CostCodeMode")), "Mandatory");
		System.out.println("2");
		cclabel1.clear();
		System.out.println("3");
		cclabel1.sendKeys("marketing");
		System.out.println("4");
		cclabel2.clear();
		cclabel2.sendKeys("hr");
		cclabel3.clear();
		cclabel3.sendKeys("it");
		cclabel4.clear();
		cclabel4.sendKeys("accounting");
	}

	public void setCostCodesOptional(String costcodes, String ccname,
			String labelOne, String labelTwo, String labelThree,
			String labelFour) {
		Select itemsPerPage = new Select(getDriver().findElement(
				By.cssSelector("select#CostCodeMode")));
		itemsPerPage.selectByValue("Optional");
		cclabel1.clear();
		cclabel1.sendKeys("marketing");
		cclabel2.clear();
		cclabel2.sendKeys("hr");
		cclabel3.clear();
		cclabel3.sendKeys("it");
		cclabel4.clear();
		cclabel4.sendKeys("accounting");
	}

	public void deselectCostCodesOption(String costCodesOption) {
		selectFromDropdown(containerCostCodesOption, costCodesOption);
		containerCostCodesOption.click();
		waitABit(5000);
		Select costCode = new Select(containerCostCodesOption);
		WebElement option = costCode.getFirstSelectedOption();
		String selection = option.getText();
		Assert.assertTrue(costCodesOption.contains(selection));
	}

	public void setFinishDate(String date) {
		finishDate.clear();
		finishDate.sendKeys(date);
	}

	public void checkShowCostCodeHeader() {
		if (getDriver()
				.findElements(
						By.cssSelector("form#save_subscription_parameters > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div > input[checked='1']"))
						.size() == 1) {
			System.out
			.println("Show Cost Code Header option is already checked.");
		} else {
			getDriver().findElement(By.cssSelector("input#ccshowhead")).click();
		}
	}

	public void verifyIfShowCostCodeHeaderOptionIsChecked() {
		Assert.assertTrue(getDriver()
				.findElements(
						By.cssSelector("form#save_subscription_parameters > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div > input[checked='1']"))
						.size() == 1);
	}

	public void saveParameters() {
		getDriver()
		.findElement(
				By.cssSelector("form#save_subscription_parameters > div:nth-child(7) > button "))
				.click();
	}

	public void verifyConfirmationMessage() {
		Assert.assertTrue("Parameters did not save! ", messageSave.getText()
				.contains("New subscription paramaters succesfully saved."));
	}

	public void verifyIfCostCodesAreOff(String off) {
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("select#CostCodeMode > option[value ='Off']"))
						.getText().contains(off));
	}

	public void deleteEntitlements() {
		deleteEntitlements.click();
		deleteSelectedEntitlements.click();
	}

	public void selectUserEntitlements(String geography, String geo,
			String service, String serv) {
		Assert.assertTrue(
				"not found!",
				getDriver().findElement(
						By.cssSelector("select#all_Geographies")).isDisplayed());
		System.out.println("in selectGeographyFromList");
		int counterGeo = getDriver().findElements(
				By.cssSelector("select#all_Geographies > option")).size();
		System.out.println(counterGeo);
		int counterEmptyList = getDriver().findElements(
				By.cssSelector("select#Geographies")).size() - 1;
		System.out.println(counterEmptyList);
		Select itemsPerPage = new Select(getDriver().findElement(
				By.cssSelector("select#all_Geographies")));
		itemsPerPage.selectByValue(geography);
		getDriver().findElement(
				By.cssSelector("button#all_Geographies_rightSelected")).click();
		System.out.println("moved!");
		waitABit(4000);
		Assert.assertTrue(
				"not found!",
				getDriver()
				.findElement(
						By.cssSelector("select#Geographies> option"))
						.getText().contains(geo));
		int counterAfterMovingGeo = getDriver().findElements(
				By.cssSelector("select#all_Geographies > option")).size();
		int counterAfterMovingGeoList = getDriver().findElements(
				By.cssSelector("select#Geographies > option")).size();
		System.out.println(counterAfterMovingGeo);
		System.out.println(counterAfterMovingGeoList);
		waitABit(3000);
		Assert.assertTrue("not found the counter list!!!",
				counterAfterMovingGeo == counterGeo - 1);
		Assert.assertTrue(counterAfterMovingGeoList == counterEmptyList + 1);
		// movetoRightGeographies.click();
		waitABit(5000);
		Assert.assertTrue("not found!",
				getDriver().findElement(By.cssSelector("select#all_Services"))
				.isDisplayed());
		System.out.println("in selectServiceFromList");
		int counterServ = getDriver().findElements(
				By.cssSelector("select#all_Services > option")).size();
		System.out.println(counterServ);
		int counterEmptyListServ = getDriver().findElements(
				By.cssSelector("select#Services")).size() - 1;
		System.out.println(counterEmptyListServ);
		Select itemsPerPage2 = new Select(getDriver().findElement(
				By.cssSelector("select#all_Services")));
		itemsPerPage2.selectByValue(service);
		movetoRightServices.click();
		waitABit(3000);
		Assert.assertTrue(
				"not found!",
				getDriver()
				.findElement(By.cssSelector("select#Services > option"))
				.getText().contains(serv));
		int counterAfterMovingServ = getDriver().findElements(
				By.cssSelector("select#all_Services > option")).size();
		int counterAfterMovingServList = getDriver().findElements(
				By.cssSelector("select#Services > option")).size();
		System.out.println(counterAfterMovingServ);
		System.out.println(counterAfterMovingServList);
		waitABit(3000);
		Assert.assertTrue("not found the counter list!!!",
				counterAfterMovingServ == counterServ - 1);
		Assert.assertTrue(counterAfterMovingServList == counterEmptyListServ + 1);
	}

	public void saveEntitlements(String confirm) {
		saveEntitlements.submit();
		element(
				getDriver().findElement(
						By.cssSelector("div.alert.alert-success")))
						.waitUntilPresent();
		Assert.assertTrue(getDriver()
				.findElement(By.cssSelector("div.alert.alert-success"))
				.getText().contains(confirm));
	}

	public void selectAdvanceSettings() {
		advancedSettings.click();
	}

	public void selectBMOVersion(String version) {
		if (version == "5") {
			versionfive.click();
		} else {
			versionfour.click();
		}
		saveVersion.click();
		Assert.assertTrue("Version did not save! ", messageSave.getText()
				.contains("Updated BMO version succesfully saved."));

	}

	public void setConcurentUsers(String number) {
		concurrentUsersInputBox.sendKeys(Keys.CONTROL, "a");
		concurrentUsersInputBox.sendKeys(Keys.DELETE);
		concurrentUsersInputBox.sendKeys(number);
		saveIP.click();
	}

	public void selectIPAutentication(String ip) {
		selectIPorURLAutentication();
		addIpRange(ip);
	}

	public void selectIPorURLAutentication() {

		if (getDriver().findElement(By.id("ipbased_yn")).isSelected()) {
			System.out.println("Ip or Url option is already selected");
		} else {
			ipOrURLbox.click();
			saveIP.click();
			Assert.assertTrue(
					"Unable to save Ip or Url with option selected! ",
					messageSave.getText().contains(
							"Advanced settings succesfully saved."));
		}

		if (getDriver().findElement(By.id("iprequired_yn")).isSelected()) {
			ipAndURLbox.click();
			saveIP.click();
			Assert.assertTrue(
					"Ip and Url option is still selected! ",
					messageSave.getText().contains(
							"Advanced settings succesfully saved."));
		} else {
			System.out.println("Ip and Url option is not selected");
		}

		if (getDriver().findElement(By.id("postbased_yn")).isSelected()) {
			formPortBasedbox.click();
			saveIP.click();
			Assert.assertTrue(
					"Form Post-based option is still selected! ",
					messageSave.getText().contains(
							"Advanced settings succesfully saved."));
		} else {
			System.out.println("Form Post-based option is not selected");
		}
	}

	public void verifyBreadcrumbForNewCientAccount(String addNewUser) {
		waitUntilElementExists(By.cssSelector("div#content > div > div > div:nth-of-type(2) > div:nth-of-type(2) > h5"), 4);
		Assert.assertTrue(lastChildBrClientsAcc.getText().contains(addNewUser));
	}

	public void selectIPandURLAutentication() {

		if (getDriver().findElement(By.id("ipbased_yn")).isSelected()) {
			ipOrURLbox.click();
			saveIP.click();
			Assert.assertTrue(
					"Unable to save Ip or Url with option selected! ",
					messageSave.getText().contains(
							"Advanced settings succesfully saved."));
		} else {
			System.out.println("Ip or Url option is not selected");
		}

		if (getDriver().findElement(By.id("iprequired_yn")).isSelected()) {
			System.out.println("Ip and Url option is already selected");
		} else {
			ipAndURLbox.click();
			saveIP.click();
			Assert.assertTrue(
					"Ip and Url option is still selected! ",
					messageSave.getText().contains(
							"Advanced settings succesfully saved."));
		}

		if (getDriver().findElement(By.id("postbased_yn")).isSelected()) {
			formPortBasedbox.click();
			saveIP.click();
			Assert.assertTrue(
					"Form Post-based option is still selected! ",
					messageSave.getText().contains(
							"Advanced settings succesfully saved."));
		} else {
			System.out.println("Form Post-based option is not selected");
		}
	}

	public void selectFormBasedAutentication() {

		if (getDriver().findElement(By.id("ipbased_yn")).isSelected()) {
			ipOrURLbox.click();
			saveIP.click();
			Assert.assertTrue(
					"Unable to save Ip or Url with option selected! ",
					messageSave.getText().contains(
							"Advanced settings succesfully saved."));
		} else {
			System.out.println("Ip or Url option is not selected");
		}

		if (getDriver().findElement(By.id("iprequired_yn")).isSelected()) {
			ipAndURLbox.click();
			saveIP.click();
			Assert.assertTrue(
					"Ip and Url option is still selected! ",
					messageSave.getText().contains(
							"Advanced settings succesfully saved."));
		} else {
			System.out.println("Ip and Url option is not selected");
		}

		if (getDriver().findElement(By.id("postbased_yn")).isSelected()) {
			System.out.println("Form Post-based option is not selected");
		} else {
			formPortBasedbox.click();
			saveIP.click();
			Assert.assertTrue(
					"Form Post-based option is still selected! ",
					messageSave.getText().contains(
							"Advanced settings succesfully saved."));
		}
	}

	public void addReferringURL(String referringURL) {
		refURLfield.clear();
		refURLfield.sendKeys(referringURL);
		addURL.click();
		Assert.assertTrue("Referring URL was not added! ",
				getDriver().findElement(By.cssSelector("div.alert")).getText()
				.contains("URL"));
	}

	public void deleteReferringURL() {
		refURLallCheckbox.click();
		deleteRefURLs.click();
		Assert.assertTrue("Referring URL was not deleted! ",
				getDriver().findElement(By.cssSelector("div.alert")).getText()
				.contains("URL"));
	}

	public void addIpRange(String ip) {
		addIPText.sendKeys(ip);
		addIPRange.click();
		Assert.assertTrue("Ip was not added! ",
				messageSave.getText().contains("IP Range added."));
	}

	public void selectMNC() {
		checkMNC.click();
		Assert.assertTrue(checkMNC.getAttribute("name").contains("mnc"));
	}

	public void selectMDG() {
		checkMDG.click();
		Assert.assertTrue(checkMDG.getAttribute("name").contains("mdg"));
	}

	public void selectPDF() {
		checkPDF.click();
		Assert.assertTrue(checkPDF.getAttribute("name").contains("pdf"));
	}

	public void selectMyPreferences() {
		checkMYPref.click();
		// Assert.assertTrue(checkMNC.getAttribute("name").contains("PrefsEnabled_YN"));
	}

	public void deselectUserType() {
		if (checkPDF.isEnabled()) {
			evaluateJavascript("$('input#PDFService_YN').click();");
		} else if (checkMNC.isEnabled()) {
			evaluateJavascript("$('input#mnc').click();");
		} else if (checkMDG.isEnabled()) {
			evaluateJavascript("$('input#mdg').click();");
		} else if (checkMYPref.isEnabled()) {
			evaluateJavascript("$('input#PrefsEnabled_YN').click();");
		}
	}

	public void saveAdvancedSettings() {
		saveAdvancedSettingsButton.click();
		Assert.assertTrue(messageSave.getText().contains(
				"Advanced settings succesfully saved"));
	}

	public void setCalendarDateAndYear(String year,String day) {
		finishDate.click();
		waitABit(4000);
		selectFromDropdown(getDriver().findElement(By.cssSelector("select.ui-datepicker-year")), year);
		WebElement dateWidget = getDriver().findElement(By.id("ui-datepicker-div"));   
		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  

		for (WebElement cell: columns){  
			if (cell.getText().equals(day)){  
				cell.findElement(By.linkText(day)).click(); 
				waitABit(5000);
				finishDate.click();
				waitABit(5000);
				Assert.assertTrue("not found!!!",getDriver().findElement(By.cssSelector("table.ui-datepicker-calendar > tbody > tr > td > a.ui-state-default.ui-state-active ")).isDisplayed());
				break; 
			}
		}
	}

	public void verifyFinishDateWasSet(String year) {
		Assert.assertTrue("The finish date was not set!", finishDate.getAttribute("value").contains(year));
	}

	public void verifySaveEntitlementsMessageConfirmation() {
		Assert.assertTrue("Entitlements weren't saved!", messageSave.getText().contains("Client entitlements succesfully saved."));
	}

	public void  verifyUserSummaryDetails(String correctEmail) {
		Assert.assertTrue("Email is not the same!", getEmailFromSummary.getText().contains(correctEmail));
	}

	public String getUserNumber() {
		String userNumber = userNo.getText();
		userNumber = userNumber.replaceAll("[^-?0-9]+", " "); 
		System.out.println(Arrays.asList(userNumber.trim().split(" ")));
		return userNumber.trim();
	}

	public void setFirstAlertForUser(String alertTypeDeselectSubscribed) {
		//click on first entitled alert
		getDriver().findElement(By.cssSelector("div#alerts > div:nth-of-type("+alertTypeDeselectSubscribed+") > div:nth-of-type(2) > form > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > input")).click();
		//de-select subscribed alert section
		getDriver().findElement(By.cssSelector("div#alerts > div:nth-of-type("+alertTypeDeselectSubscribed+") > div:nth-of-type(2) > form > table > tbody > tr:nth-of-type(1) > td:nth-of-type(3) > input")).click();
	}

	public void confirmationSavedAlertsMessage() {
		messageSave.getText().contains("Alerts succesfully saved");
	}

	public void verifyUserSectionsPresence() {
		waitUntilElementExists(By.cssSelector("ul#client-details"), 3);
		Assert.assertTrue(userDetails.isDisplayed());
		Assert.assertTrue(entitlements.isDisplayed());
		Assert.assertTrue(selectAlertsSectionFOrUSerDetail.isDisplayed());
		Assert.assertTrue(advancedSettings.isDisplayed());
	}
}

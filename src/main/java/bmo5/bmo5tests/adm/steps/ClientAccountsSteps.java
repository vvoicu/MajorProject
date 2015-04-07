package bmo5.bmo5tests.adm.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class ClientAccountsSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -3234781128713122231L;

	@StepGroup
	public void performSearch(String email) {
		clientAccountsPage().userSearch(email);
		clientAccountsPage().verifyUser(email);
	}

	@StepGroup
	public void createAndVerifyUserWithEmptyFields(String addNewUser,String errorEmptyFirstName, String errorEmptyLastName, String errorEmptyPassword, String erroremptyInvalidEmail, String errorEmptyCompany ) {
		clientAccountsPage().clickOnNewUserButton();
		clientAccountsPage().verifyBreadcrumbForNewCientAccount(addNewUser);
		clientAccountsPage().clickOnSaveUserDetailsButton();
		clientAccountsPage().messageErrorForEmptyFirstName(errorEmptyFirstName);
		clientAccountsPage().messageErrorForEmptyLastName(errorEmptyLastName);
		clientAccountsPage().messageErrorForEmptyPassword(errorEmptyPassword);
		clientAccountsPage().messageErrorForEmptyWrongEmail(erroremptyInvalidEmail);
		clientAccountsPage().messageErrorForEmptyCompany(errorEmptyCompany);
		clientAccountsPage().clickOnResetUserFormButton();
	}
	
	@StepGroup
	public void createAValidUserInAdm(String correctEmail, String correctPass, String firstName, String lastName, String companyUserDetail, String region, String type) {
		clientAccountsPage().clickOnResetUserFormButton();
		clientAccountsPage().inputEmailAddressField(correctEmail);
		clientAccountsPage().inputCorrectPassForNewUser(correctPass);
		clientAccountsPage().inputFirstNewUserName(firstName);
		clientAccountsPage().inputLastNewUserName(lastName);
		clientAccountsPage().inputCompanyUserDetailName(companyUserDetail);
		clientAccountsPage().selectCountryFromDropdownForNewUser(region);
		clientAccountsPage().selectTypeFromDropdownForNewUser(type);
		clientAccountsPage().clickOnSaveUserDetailsButton();
	}
	
	@StepGroup
	public String verifyUserDetailSummaryPage(String correctEmail) {
		clientAccountsPage().verifyUserSummaryDetails(correctEmail);
		clientAccountsPage().verifyUserSectionsPresence();
		return clientAccountsPage().getUserNumber();
	}
	
	@StepGroup
	public void setOptionsForTheNewUser(String idUser,String date,String geography,String geo,String service,String serv ,String confirm,String dsaAlert,String saveAlertDsa,String dfaAlert,String saveAlertDfa, String bfsAlert,String saveAlertBfs ) {
		clientAccountsPage().searchAfterUserNumber(idUser);
		clientAccountsPage().clickOnEntitlementsAndSubscriptionsTab(date);
		clientAccountsPage().selectUserEntitlements(geography, geo, service, serv);
		clientAccountsPage().saveEntitlements(confirm);
		clientAccountsPage().clickOnAlertsTab();
		clientAccountsPage().setFirstAlertForUser(dsaAlert);
		clientAccountsPage().clickOnSaveAlerts(saveAlertDsa);
		clientAccountsPage().setFirstAlertForUser(dfaAlert);
		clientAccountsPage().clickOnSaveAlerts(saveAlertDfa);
		clientAccountsPage().setFirstAlertForUser(bfsAlert);
		clientAccountsPage().clickOnSaveAlerts(saveAlertBfs);
		clientAccountsPage().verifyBmoVersionAndRegularTypeUserOnAdvancedSet();
		clientAccountsPage().verifyPresenceOfHistoryAndUsageSummaryButtons();
	}
	
	@StepGroup
	public void createAUserDuplicate(String searchForEmailType, String userName, String duplicateAccount, String companyUserDetail, String correctEmail, String correctPass, String firstName, String lastName) {
		clientAccountsPage().searchAfterUserNameAndClickOnTheLastUserId(searchForEmailType, userName);
		clientAccountsPage().clickOnDuplicateButtonForUser(duplicateAccount);
		clientAccountsPage().verifyDuplicateUserHasCompanyCountryAndTypeAsTheRegularUserCreated(companyUserDetail);
		clientAccountsPage().inputEmailAddressField(correctEmail);
		clientAccountsPage().clickOnUsernameField();
		clientAccountsPage().inputCorrectPassForNewUser(correctPass);
		clientAccountsPage().inputFirstNewUserName(firstName);
		clientAccountsPage().inputLastNewUserName(lastName);
		clientAccountsPage().clickOnSaveUserDetailsButton();	
	}
	
	@StepGroup
	public void verifyDuplicateUserTabsSelections(String clientDetails,String date,String serv, String geo) {
		clientAccountsPage().verifyBreadcrumbForClientDetails(clientDetails);
		clientAccountsPage().entitlementsAndSubscriptionsAndAdvancedSettingsAreaMatchesTheRegularUserForTheDUplicate(date, serv, geo);	
	}
	
	@StepGroup
	public String createAChildOfTheLastDuplicateUserFromTheList(String searchForEmailType, String userName,String addNewChild,String correctEmail,String correctPass, String firstName, String lastName, String companyUserDetail, String region, String type) {
		clientAccountsPage().searchAfterUserNameAndClickOnTheLastUserId(searchForEmailType, userName);
		clientAccountsPage().clickOnCreateChildButton(addNewChild);
		//clientAccountPage().verifyUserNameAndSFAreDisabled();
		clientAccountsPage().inputEmailAddressField(correctEmail);
		clientAccountsPage().inputCorrectPassForNewUser(correctPass);
		clientAccountsPage().inputFirstNewUserName(firstName);
		clientAccountsPage().inputLastNewUserName(lastName);
		clientAccountsPage().inputCompanyUserDetailName(companyUserDetail);
		clientAccountsPage().selectCountryFromDropdownForNewUser(region);
		clientAccountsPage().selectTypeFromDropdownForNewUser(type);
		clientAccountsPage().clickOnSaveUserDetailsButton();
		clientAccountsPage().verifyConfirmMessageForNewUserTypeCreated();
		clientAccountsPage().verifyEntitlementsChildSection();
		return clientAccountsPage().getParentEmailAddressFromChildSummary();
	}
	
	@StepGroup
	public void deleteUser() {
//	clientAccountPage().searchAfterUserNameAndClickOnTheLastUserId(searchForEmailType, userName);
	clientAccountsPage().deleteUser();
	clientAccountsPage().verifyConfirmMessageForNewUserTypeCreated();
		
	}
	
	@Step
	public void selectTypeForUser(String type) {
		clientAccountsPage().selectTypeFromDropdownForNewUser(type);
	}
	
	@Step
	public void verifyChildrenSectionInParentEmailArea() {
	clientAccountsPage().verifyChildrenSection();	
	}
	
	@Step
	public void verifyChildInChildrenSection(String userLoginBmo) {
	clientAccountsPage().verifyLastChildCreatedInChildrenSection(userLoginBmo);	
	}
	
	@Step
	public String useEmailForBmoLogin() {
		return clientAccountsPage().useEmailFromEmailFieldLoginOnBmo();
	}
	
	@Step
	public void createAndVerifyUserWithWrongEmailAndPasswordFields(String wrongEmail,String wrongPass,String erroremptyInvalidEmail,String errorInvalidPassword) {
		clientAccountsPage().inputWrongEmailPassword(wrongEmail, wrongPass, erroremptyInvalidEmail, errorInvalidPassword);
		clientAccountsPage().clickOnResetUserFormButton();
	}
	
	@Step
	public void selectUserType(String type) {
		clientAccountsPage().selectType(type);
	}
	
	@Step
	public void selectStatus(String status) {
		clientAccountsPage().selectType(status);
	}
	
	@Step
	public void selectUserTypeByvisibleText(String userType){
		clientAccountsPage().selectUserTypeByvisibleText(userType);
	}
	
	@Step
	public boolean isUserTrial(String userType){
		return clientAccountsPage().isUserTrial(userType);
	}
	
	@Step
	public void assertTrialUser(String userType){
		clientAccountsPage().assertTrialUser(userType);
	}
	
	@Step
	public void selectEntitlements(String servEntitlements, String currentEntitlements) {
		clientAccountsPage().selectEntitlemets(servEntitlements,currentEntitlements);
	}
	
	@Step
	public void selectFinishDate(String date) {
		clientAccountsPage().setFinishDate(date);
	}
	
	@Step
	public void setCostCodesSection(String costcodes,String ccname, String labelOne, String labelTwo, String labelThree, String labelFour ){
		clientAccountsPage().setCostCodes(costcodes,ccname,labelOne,labelTwo,labelThree,labelFour);
	}
	
	@Step
	public void saveSubscriptionParameters(){
		clientAccountsPage().saveParameters();
	}
	
	@Step
	public void saveUserDetails(){
		clientAccountsPage().saveDetails();
	}
	
	@Step
	public void setUserEntitlements(String geography,String geo, String service,String serv){
		clientAccountsPage().selectUserEntitlements(geography,geo,service,serv);
	}
	
	@Step
	public void saveServiceEntitlements(String confirm){
		clientAccountsPage().saveEntitlements(confirm);
	}
	
	@Step
	public void deleteAllEntitlements(){
		clientAccountsPage().deleteEntitlements();
	}
	
	@Step
	public void selectAdvancedSettings(){
		clientAccountsPage().selectAdvanceSettings();
	}
	
	@Step
	public void selectBMOAccountVersion(String version){
		clientAccountsPage().selectBMOVersion(version);
	}
	
	@Step
	public void setIPAuthentication(String ip) {
		clientAccountsPage().selectIPAutentication(ip);
	}
	
	@Step
	public void selectIPorURLAutentication() {
		clientAccountsPage().selectIPorURLAutentication();
	}
	
	@Step
	public void selectIPandURLAutentication() {
		clientAccountsPage().selectIPandURLAutentication();
	}
	
	@Step
	public void selectFormBasedAutentication() {
		clientAccountsPage().selectFormBasedAutentication();
	}
	
	@Step
	public void addReferringURL(String referringURL) {
		clientAccountsPage().addReferringURL(referringURL);
	}
	
	@Step
	public void deleteReferringURL() {
		clientAccountsPage().deleteReferringURL();
	}
	
	@Step
	public void setMNC() {
		clientAccountsPage().selectMNC();
	}
	
	@Step
	public void gotoClientAccountspage(){
		clientAccountsPage().selectClientAccounts();
	}
	
	@Step
	public void deselectUserType(){
		clientAccountsPage().deselectUserType();
	}
	
	@Step
	public void selectMNC(){
		clientAccountsPage().selectMNC();
	}
	
	@Step
	public void selectMDG(){
		clientAccountsPage().selectMDG();
	}
	
	@Step
	public void selectPDF(){
		clientAccountsPage().selectPDF();
	}
	
	@Step
	public void saveAdvancedSettings(){
		clientAccountsPage().saveAdvancedSettings();
	}
	
	@Step
	public void selectMyPreferences(){
		clientAccountsPage().selectMyPreferences();
	}

	@Step
	public void deselectCostCodes(String costCodesOption) {
		clientAccountsPage().deselectCostCodesOption(costCodesOption);		
	}

	@Step
	public void selectAndDeleteEntitlementsFromList(String deleteEnt,String message) {
		clientAccountsPage().selectEntitlementsFromList(deleteEnt,message);		
	}
	
	@Step
	public void selectIPorUrl() {
		clientAccountsPage().selectIPorUrl();
	}
	
	@Step
	public void insertIpRange(String ip){
		clientAccountsPage().insertIpRange(ip);
	}
	
	@Step
	public void addCurrentMachineIP(){
		clientAccountsPage().addCurrentMachineIP();
	}
	
	@Step
	public void deleteIpRange(){
		clientAccountsPage().deleteIpRange();
	}
	
	@Step
	public void setConcurentUsers(String number){
		clientAccountsPage().setConcurentUsers(number);
	}
	
	@Step
	public void deselectIpOrUrl(){
		clientAccountsPage().deselectIpOrUrl();
	}

	@Step
	public void verifyIfCostCodesAreOff(String off) {
		clientAccountsPage().verifyIfCostCodesAreOff(off);
	}
	
	@Step
	public void verifyConfirmationMessage(){
		clientAccountsPage().verifyConfirmationMessage();
	}
	
	@Step
	public void checkShowCostCodeHeader(){
		clientAccountsPage().checkShowCostCodeHeader();
	}
	
	@Step
	public void verifyIfShowCostCodeHeaderOptionIsChecked(){
		clientAccountsPage().verifyIfShowCostCodeHeaderOptionIsChecked();
	}
	
	@Step
	public void setCostCodesOptional(String costcodes, String ccname,
			String labelOneName, String labelTwoName, String labelThreeName,
			String labelFourName) {
		clientAccountsPage().setCostCodesOptional(costcodes, ccname, labelOneName, labelTwoName, labelThreeName, labelFourName);
	}

	@Step
	public void verifyTypeWasSelected(String type) {
		clientAccountsPage().verifyTypeWasSelected(type);		
	}

}

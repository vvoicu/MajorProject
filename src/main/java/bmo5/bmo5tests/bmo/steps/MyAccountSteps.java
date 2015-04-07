package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class MyAccountSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void verifyMyProfileTitle() {
		myAccountPage().verifyMyProfile();
	}

	@Step
	public void verifyMyAccountMangerTitle() {
		myAccountPage().verifyAccountManager();
	}

	@Step
	public void verifyEmailfromProfile(String email) {
		myAccountPage().verifyEmail(email);
	}

	@Step
	public void openChangePasswordsection() {
		myAccountPage().openChangePassword();
	}
	
	@Step
	public void verifyemptyfieldsChangePassword() {
		myAccountPage().verifyWrongChangePassword0();
	}

	@Step
	public void performChangePassword(String oldp, String newp, String confp) {
		myAccountPage().ChangePassword(oldp, newp, confp);
	}

	@Step
	public void verifyChangePassword(String user, String pass, String validation) {
		myAccountPage().verifyChangePassword(user, pass, validation);
	}

	@Step
	public void openSubscriptionsSection() {
		myAccountPage().openSubscriptions();
	}

	@Step
	public void verifySubscriptionsTitle() {
		myAccountPage().verifySubscriptions();
	}

	@Step
	public void openRequestServices() {
		myAccountPage().requestServices();
	}

	@Step
	public void verifyContactAccountManagerSection(String email) {
		myAccountPage().verifyContactAccountManager(email);
	}

	@Step
	public void openContactAccountManagerSection() {
		myAccountPage().openContactAcccountManager();
	}

	@StepGroup
	public void verifyRequiredFields() {
		myAccountPage().submitMessage();
		myAccountPage().requiredFields();
	}

	@StepGroup
	public void verifyClearbutton(String Subject, String Message) {
		myAccountPage().writeMessage(Subject, Message);
		myAccountPage().verifyClear(Subject, Message);
	}

	@StepGroup
	public void performSubmitMessage(String Subject, String Message)
			throws InterruptedException {
		myAccountPage().writeMessage(Subject, Message);
		myAccountPage().submitMessage();
		myAccountPage().verifyEmailSent();
	}

	@Step
	public void openWebsitePreferencesSection() {
		myAccountPage().openWebsitePreferences();
	}

	@Step
	public void verifyWebsitePreferencesSection() {
		myAccountPage().verifyWebsitePreferences();
	}
	
	@StepGroup
	public void verifyChooseWebsitePreferencesSection(String user, String pass, String websitePreferencesBreadcrumbs, String websitePreference) {
		myAccountPage().chooseWebsitePreferences(websitePreference);
		homePageHeaderPage().clickOnLogout();
		loginPage().inputUsername(user);
		loginPage().inputPassword(pass);
		loginPage().clickOnLogin();
		loginPage().verifyCorrectLogin();
		homePageHeaderPage().clickMyBmoAccountDropdown();
		myAccountPage().openWebsitePreferences();
		homePageTopMenuPage().verifyBreadCrumb(websitePreferencesBreadcrumbs);
		myAccountPage().verifyWebsitePreferences(websitePreference);
	}
	
	@Step
	public void verifyTheSubjectTrialUserFromArticles(String name){
		myAccountPage().verifyTheSubjectTrialUserFromArticles(name);
	}
	
	@Step
	public void verifyTheSubjectTrialUserFromReports(String name){
		myAccountPage().verifyTheSubjectTrialUserFromReports(name);
	}
}


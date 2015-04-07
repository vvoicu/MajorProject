package bmo5.bmo5tests.bmo.steps.homepage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class HomePageHeaderSteps extends AbstractSteps {

	private static final long serialVersionUID = 134534534654624L;

	@StepGroup
	public void verifyBreadCrumbHeader(String text) {
		homePageHeaderPage().verifyBreadCrumbs(text);
		homePageHeaderPage().verifyMethodologyImage();
	}

	@StepGroup
	public void clickHelpContentLinkAndIndex(String index) {
		homePageHeaderPage().helpContentLink();
		homePageHeaderPage().clickOnIndex(index);
	}

	@StepGroup
	public void verifyHeaderIcons(String helpName, String updates,String total) {
		homePageHeaderPage().clickHelp(helpName);
		homePageHeaderPage().clickCloseButton();
		homePageHeaderPage().clickServiceUpdates(updates);
		clickOnMethodologyAndVerify(total);
		homePageHeaderPage().clickOnHomeBreadcrumb();
	}

	@StepGroup
	public void clickContactUsFromDropdown(String contactUs) {
		homePageHeaderPage().clickOnMyBmoIcon();
		homePageHeaderPage().clickOnContactUsFromMyBmoDropdown(contactUs);
	}

	@StepGroup
	public void clickOnSearchButtonAndVerify(String breadcrumbString) {
		homePageHeaderPage().clickSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbString);
	}

	@Step
	public void clickOnLogo() {
		homePageHeaderPage().clickLogo();
	}

	@Step
	public void searchFor(String keyword) {
		homePageHeaderPage().searchFor(keyword);
	}

	@Step
	public void predictiveSearch(String threecharacters) {
		homePageHeaderPage().predictiveSearch(threecharacters);
	}

	@Step
	public void advancedSearch() {
		homePageHeaderPage().clickAdvancedSearch();
	}

	@Step
	public void clickOnHelp(String helpName) {
		homePageHeaderPage().clickHelp(helpName);
	}

	@Step
	public void clickOnServiceUpdates(String updates) {
		homePageHeaderPage().clickServiceUpdates(updates);
	}

	@Step
	public void clickOnMethodologyAndVerify(String total) {
		homePageHeaderPage().verifyPageMethodology(total);
	}

	@Step
	public void clickAccountDropDown() {
		homePageHeaderPage().clickMyBmoAccountDropdown();
	}

	@Step
	public void verifyEmailOfTheNewUserOnBmo(String correctEmail) {
		homePageHeaderPage().verifyEmailFromAccountMatchesTheUserCreatedEmail(correctEmail);
	}

	@Step
	public void verifyTopMessage() {
		homePageHeaderPage().verifyMyBmoIconDropdownWelcomeNameMessage();
	}

	@Step
	public void clickOnEmailAlerts() {
		homePageHeaderPage().clickOnEmailAlerts();
	}

	@Step
	public void clickOnSavedContent() {
		homePageHeaderPage().clickOnSavedContent();
	}

	@Step
	public void verifyBreadCrumbsAlerts(String customAlerts) {
		verifyBreadCrumbs(customAlerts);
	}

	@Step
	public void verifyBreadCrumbs(String text) {
		homePageHeaderPage().verifyBreadCrumbs(text);
	}

	@Step
	public void clickOnHomePageBreadcrumb() {
		homePageHeaderPage().clickOnHomeBreadcrumb();
	}

	@Step
	public  void selectAccountOptions(String value) {
		homePageHeaderPage().containerAccountOptions(value);
	}

	@Step
	public void clickHelpQuickReferenceGuide(String reference) {
		homePageHeaderPage().helpQuickReferenceGuide(reference);
	}

	@Step
	public void clickHelpTermsAndConditions() {
		homePageHeaderPage().helpTermsAndConditions();
	}

	@Step
	public void clickHelpPrint(String print)  {
		homePageHeaderPage().helpPrint(print);
	}

	@Step
	public void clickHelpContentLink()  {
		homePageHeaderPage().helpContentLink();
	}

	@Step
	public void verifyMyBmoForIpUser(String email) {
		homePageHeaderPage().verifyMyBmoForIpUser(email);
	}

	@Step
	public void clickOnMyBmoIcon(){
		homePageHeaderPage().clickOnMyBmoIcon();
	}

	@Step
	public void clickOnLogout(){
		homePageHeaderPage().clickOnLogout();
	}

	@Step
	public void verifyIfSavedContentIsActive(){
		homePageHeaderPage().verifyIfSavedContentIsActive();
	}

	@Step
	public void verifyHeaderpresence() {
		homePageHeaderPage().verifyHeaderpresence();

	}

	@Step
	public void cancelPrinting() {
		homePageHeaderPage().cancelPrinting();

	}

	@Step
	public void closeHelp(String close) {
		homePageHeaderPage().closeHelp(close);

	}

	@Step
	public void verifyMyBmoSection() {
		homePageHeaderPage().verifyMyBmoSection();

	}

	@Step
	public void accessServiceUpdates() {
		homePageHeaderPage().accessServiceUpdates();

	}
}

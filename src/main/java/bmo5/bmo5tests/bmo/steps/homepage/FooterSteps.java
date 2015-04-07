package bmo5.bmo5tests.bmo.steps.homepage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class FooterSteps extends AbstractSteps {

	private static final long serialVersionUID = 8858564152118641503L;
	
	@Step
	public void clickOnTermsAndConditions(String terms) {
		footerPage().clickTermsAndConditions(terms);
	}
	
	@Step
	public void verifyTitleName() {
		footerPage().verifyTitle();
	}
	
	@Step
	public void verifyLeftPanelTerms(String terms,String privacy) {
	footerPage().verifyLeftPanelTerms(terms, privacy);
	}
	
	@Step
	public void clickOnTrackRecords(String record) {
		footerPage().clickTrackRecord(record);
	}
	
	@Step
	public void clickOnLeftPanel(int region) {
		footerPage().clickLeftPanel(region);
	}
	
	@Step
	public void clickElementPanel(int region) {
		footerPage().clickRegionElementPanel(region);
	}
	
	@Step
	public void clickArchiveFromPanel(int region, String archive) {
		footerPage().clickArchivePanel(region,archive);

	}
	
	@Step
	public void clickOnContactUs(String contact) {
		footerPage().clickContactUs(contact);		
	}
	
	@StepGroup
	public void doFormOperation(String send,String error,String clear,String subject,String key, String messageName,String messageContent) {
		footerPage().verifyEmptyContactUsFields();
		footerPage().clickSendContactUs(send);
		footerPage().verifyErrorMessageAfterSendWithoutCompletingFIelds(error);
		footerPage().clickOnClearButton(clear);
		footerPage().clickSubjectFormArea(subject,key);
		footerPage().clickSendContactUs(send);
		footerPage().verifyErrorMessageWhenMessageIsEmpty(error);
		footerPage().clickMessageFormArea(messageName, messageContent);
	
	}
	
	
	@Step
	public void clickCareersLink(String career) {
		footerPage().clickCareersFooter(career);		
	}
	
	@StepGroup
	public void selectFooterElements(String terms, String contact, String record, String career) {
		footerPage().clickTermsAndConditions(terms);
		footerPage().clickContactUs(contact);
		footerPage().clickTrackRecord(record);
		footerPage().clickCareersFooter(career);

	}
	
	@Step
	public void sendMailContactForm(String send) {
		footerPage().clickSendContactUs(send);
	}
	
	@Step
	public void emailEnterprise(String email,String invalidEmail, String validEmail, String subject,String sendButton, String messageName, String messageContent) {
		footerPage().emailEnterprise(email,invalidEmail, validEmail, subject,sendButton, messageName, messageContent);
	}
	
	@Step
	public void clickOnContactUsForIp(String contactUs) {
		footerPage().clickOnContactUsForIp(contactUs);
	}
	
	@Step
	public void verifyTermsAndCOnditionsPresenceOnFooter() {
		footerPage().verifyTermsAndCOnditionsPresenceOnFooter();
	}
	
	@Step
	public void verifyBreadCrumbs(String breadcrumb) {
		footerPage().verifyBreadCrumbs(breadcrumb);
	}
	
	@Step
	public void verifyTrackrecordOnFooter() {
		footerPage().verifyTrackrecordOnFooter();
	}

	@Step
	public void verifyContactUsOnFooter() {
		footerPage().verifyContactUsOnFooter();;
	}
	
	@Step
	public void verifyCareersOnFooter() {
		footerPage().verifyCareersOnFooter();
	}

	@Step
	public void verifyCareersPage() {
		footerPage().verifyCareersPage();
	}
	
	@Step
	public void verifyPrivacyPolicyInLeftFilter(String privacy) {
		footerPage().verifyPrivacyPolicyInLeftFilter(privacy);
		
	}

	@Step
	public void verifyConfirmationContactFormMessage(String message) {
		footerPage().verifyConfirmationContactFormMessage(message);
		
	}
}
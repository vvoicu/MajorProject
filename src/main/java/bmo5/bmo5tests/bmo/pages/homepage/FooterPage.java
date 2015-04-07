package bmo5.bmo5tests.bmo.pages.homepage;


import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class FooterPage extends AbstractPage {

	@FindBy(css =" a[ href='/legal']")
	private WebElement clickTermsAndConditions;

	@FindBy(id = "terms-conditions")
	private WebElement getTitleName;

	@FindBy(css =" a[ href='/trackrecords']")
	private WebElement clickTrackRecord;

	@FindBy(css ="div.sidebar.well > ul:nth-child(1) > li > ul ")
	private WebElement clickOnLeftPanel;

	@FindBy(css ="div.sidebar.well > ul:nth-child(2) > li > h5 ")
	private WebElement clickOnLeftPanelSecondExapnd;

	@FindBy(css ="div.sidebar.well > ul:nth-child(3) > li > h5")
	private WebElement clickOnLeftPanelThirdExapnd;

	@FindBy(css ="body[data-target ='#scrollContent'] > footer > a:nth-child(3)") //a[ href='/contact_us']")
	private WebElement clickContactUs;

	@FindBy(css =" a[ href='/contact_us']")
	private WebElement clickContactUsForEnterprise;

	@FindBy(css =" a[ href='https://careers.businessmonitor.com/']")
	private WebElement clickCareers;

	@FindBy(css ="input#account-manager-submit")
	private WebElement sendContactUsButton;

	@FindBy(css ="input#subject")
	private WebElement subjectTextArea;

	@FindBy(css ="textarea#content")
	private WebElement messageTextArea;

	@FindBy(css = "div.container-fluid > div:nth-child(5) > section > ul > li.active")
	private WebElement breadcrumbLast;

	@FindBy(css = "ul.breadcrumb > li:nth-child(2) > a")    
	private WebElement breadcrumbFirst;

	@FindBy(linkText = "Terms & Conditions")
	private WebElement termsElement;

	@FindBy(linkText = "Track Record")
	private WebElement trackRecordElement;

	@FindBy(linkText = "Contact us")
	private WebElement contactUsElement;

	@FindBy(linkText = "Careers")
	private WebElement careersElement;


	public void clickOnContactUsForIp(String contactUs) {
		clickContactUsForEnterprise.click();
		Assert.assertTrue(clickContactUsForEnterprise.getText().contains(contactUs));
	}

	public void clickTermsAndConditions(String terms){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("a[href='/legal']")).getText().contains(terms));
		clickTermsAndConditions.click();
		
	}

	public void clickTrackRecord(String record){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("footer > a[href='/trackrecords']")).getText().contains(record));
		clickTrackRecord.click();
	}

	public void clickContactUs(String contact){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("footer > a[href='/contact_us']")).getText().contains(contact));
		clickContactUs.click();
	}

	public void clickCareersFooter(String career){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("footer > a[href='https://careers.businessmonitor.com/']")).getText().contains(career));
		clickCareers.click();
	}

	public void verifyCareersPage() {
		waitABit(3000);
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("a[href='https://careers.businessmonitor.com/']")).isDisplayed());
		getDriver().navigate().to("https://careers.businessmonitor.com/");		
		waitABit(5000);
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div.menuLogin > a")).getText().contains("Click Here To Login")); 
	}

	public void verifyEmptyContactUsFields() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input#subject")).getAttribute("value").equals(""));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("textarea#content")).getAttribute("class").equals("span12 required modal-contact-us-textarea"));

	}
	public void clickSubjectFormArea(String subject,String key){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#contact-manager-form > div:nth-child(2) > label ")).getText().contains(subject));
		subjectTextArea.sendKeys(key);
	}

	public void verifyErrorMessageAfterSendWithoutCompletingFIelds(String error) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#contact-manager-form > div:nth-child(2) > div > label.error")).getText().contains(error));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#contact-manager-form > div:nth-child(3) > div > label.error")).getText().contains(error));

	}
	
	public void clickOnClearButton(String clear) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input#clear")).getAttribute("value").contains(clear));
		getDriver().findElement(By.cssSelector("input#clear")).click();
	}
	
	public void verifyErrorMessageWhenMessageIsEmpty(String error) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#contact-manager-form > div:nth-child(3) > div > label.error")).getText().contains(error));

	}
	
	public void verifyConfirmationContactFormMessage(String message) {
		element(getDriver().findElement(By.cssSelector("div.alert.alert-success"))).waitUntilPresent();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.alert.alert-success")).getText().contains(message));
	}
	
	public void emailEnterprise(String email,String invalidEmail, String validEmail, String subject,String sendButton, String messageName, String messageContent) {
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("form#contact-manager-form > div:nth-child(1) > label")).getText().contains(email));
		getDriver().findElement(By.cssSelector("input#from_email")).sendKeys(invalidEmail);
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("input#account-manager-submit ")).getAttribute("value").equals(sendButton));
		sendContactUsButton.click();
		waitABit(5000);
		if (getDriver().findElement(By.cssSelector("div#email_error")).getText().contains("Email not valid.")){
			getDriver().findElement(By.cssSelector("input#clear")).click();
		}
		waitABit(5000);
		getDriver().findElement(By.cssSelector("input#from_email")).sendKeys(validEmail);
		getDriver().findElement(By.cssSelector("input#subject")).sendKeys(subject);
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("form#contact-manager-form > div:nth-child(3) > label")).getText().contains(messageName));
		getDriver().findElement(By.cssSelector("textarea#content")).sendKeys("This is a test");
		sendContactUsButton.click();
	}

	public void clickMessageFormArea(String messageName, String messageContent){
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("form#contact-manager-form > div:nth-child(3) > label")).getText().contains(messageName));
		messageTextArea.sendKeys(messageContent);
	}

	public void verifyTitle(){
		String expectedTitle = "Terms & Conditions";
		//String actualTitle = "";
		String actualTitle =  getDriver().findElement(By.cssSelector("div#terms-conditions > h4")).getText();
		if (actualTitle.contentEquals(expectedTitle)){

			System.out.println("Test Passed!");

		} else {

			System.out.println("Test Failed");

		}
	}

	public void verifyLeftPanelTerms(String terms,String privacy) {
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li > h5")).click();
		element(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li > h5 > span >i"))).waitUntilPresent();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li > h5 > span >i")).getAttribute("class").contains("icon-c-right-dir"));
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li > h5")).click();
		waitABit(2000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li >ul > li:nth-child(1) > a")).getText().contains(terms));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li >ul > li:nth-child(2) > a")).getText().contains(privacy));
	}

	public void verifyPrivacyPolicyInLeftFilter(String privacy) {
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li >ul > li:nth-child(2) > a")).click();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#privacy-policy > h4")).getText().contains(privacy));
	}

	public void verifyTermsAndCOnditionsPresenceOnFooter() {
		waitABit(5000);
		Assert.assertTrue(termsElement.isDisplayed());
	}

	public void verifyTrackrecordOnFooter() {
		waitABit(5000);
		Assert.assertTrue(trackRecordElement.isDisplayed());
	}

	public void verifyContactUsOnFooter() {
		waitABit(5000);
		Assert.assertTrue(contactUsElement.isDisplayed());
	}

	public void verifyCareersOnFooter() {
		waitABit(5000);
		Assert.assertTrue(careersElement.isDisplayed());
	}

	public void clickLeftPanel(int region){
		element(clickOnLeftPanel).waitUntilVisible();
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(1) >li > ul > li:nth-child("+region+") > a")).click();
		String regionLF = getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(1) >li > ul > li:nth-child("+region+") > a")).getText();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(1) >li > ul > li:nth-child("+region+") > a")).getText().contains(regionLF));
		String title = getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(6) > article:nth-child(2) > div > div:nth-child(3) > h4")).getText();
		if (regionLF.contentEquals(title)){
			System.out.println(title);
		} else
		{
			System.out.println("Not the same title!");
		}
	}	

	public void verifyBreadCrumbs(String text) {
		boolean contained = false;

		if (breadcrumbLast.getText().contains(text)) {
			contained = true;
		} else {
			if (breadcrumbFirst.getText().contains(text)) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}

	public void clickRegionElementPanel(int region){
		element( clickOnLeftPanelSecondExapnd).waitUntilVisible();
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(2) >li > h5")).click();
		element(getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(2) > li > ul > li:nth-child("+region+") > a"))).waitUntilPresent();
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(2) > li > ul > li:nth-child("+region+") > a")).click();
		String regionLF = getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(2) >li > ul > li:nth-child("+region+") > a")).getText();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(2) >li > ul > li:nth-child("+region+") > a")).getText().contains(regionLF));
		waitABit(2000);
		String title = getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(6) > article:nth-child(2) > div > div:nth-child(3) > h4")).getText();
		if (regionLF.contentEquals(title)){
			System.out.println(title);
		} else
		{
			System.out.println("Not the same title!");
		}
	}

	public void clickArchivePanel(int region, String archive){
		element(clickOnLeftPanelThirdExapnd).waitUntilVisible();
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(3) >li > h5")).click();
		element(getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(3) > li > ul > li:nth-child("+region+") > a"))).waitUntilPresent();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(3) > li > h5")).getText().contains(archive));
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(3) >li > ul > li:nth-child("+region+") > a")).click();
		String regionLF = getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(3) >li > ul > li:nth-child("+region+") > a")).getText();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(3) >li > ul > li:nth-child("+region+") > a")).getText().contains(regionLF));
		String title = getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(6) > article:nth-child(2) > div > div:nth-child(3) > h4")).getText();
		if (regionLF.contentEquals(title)){
			System.out.println(title);
		} else
		{
			System.out.println("Not the same title!");
		}
	}

	public void clickSendContactUs(String send) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input#account-manager-submit")).getAttribute("value").contains(send));
		sendContactUsButton.click();
		
	}
}


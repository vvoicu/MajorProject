package bmo5.bmo5tests.bmo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class MyAccountPage extends AbstractPage {
	

	@FindBy(css = "article.span10 > h4:nth-child(1)")
	@CacheLookup
	private WebElement myProfile;
	
	@FindBy(css = "article.span10 > h4:nth-child(3)")
	@CacheLookup
	private WebElement myAccountManager;
	
	@FindBy(css = "div.border-top > dl.dl-horizontal > dd:nth-of-type(2)")
	@CacheLookup
	private WebElement myEmailAccount;
	
	@FindBy(css = "li.nav-header > ul > li:nth-child(2) > a ")
	@CacheLookup
	private WebElement changePassword;
	
	@FindBy(css = "input#original")
	@CacheLookup
	private WebElement oldPassword;
	
	@FindBy(css = "input#new_password")
	@CacheLookup
	private WebElement newPassword;
	
	@FindBy(css = "input#repeat_new_password")
	@CacheLookup
	private WebElement confirmNewPassword;
	
	@FindBy(css = "div.controls > button.btn.btn-primary")
	@CacheLookup
	private WebElement buttonChangePassword;
	
	@FindBy(css = "li.nav-header > ul > li:nth-child(3) > a")
	@CacheLookup
	private WebElement subscriptions;
	
	@FindBy(css = "div#subscriptions > h4")
	@CacheLookup
	private WebElement titleSubscriptions;
	
	@FindBy(css = "div#subscriptions > h4 > a")
	@CacheLookup
	private WebElement buttonRequestServices;
	
	@FindBy(css = "div#contact-am > h4")
	@CacheLookup
	private WebElement titleContactAccountManager;
	
	@FindBy(css = "li.nav-header > ul > li:nth-child(4) > a")
	@CacheLookup
	private WebElement contactaccountmanager;
	
	@FindBy(css = "div#contact-am input#account-manager-submit")
	@CacheLookup
	private WebElement buttonsubmitmessage;
	
	@FindBy(css = "div#contact-am input#contact-manager-form-clear")
	@CacheLookup
	private WebElement buttonclear;
	
	@FindBy(css = "div#contact-am input#subject")
	@CacheLookup
	private WebElement subject;
	
	@FindBy(css = "div#contact-am textarea")
	@CacheLookup
	private WebElement message;
	
	@FindBy(css = "li.nav-header > ul > li:nth-child(5) > a")
	@CacheLookup
	private WebElement websitepreferences;
	
	@FindBy(css = "div.border-top > form > div:nth-child(1) > div > label:nth-child(2)")
	@CacheLookup
	private WebElement choosedefault;
	
	@FindBy(css = "div.border-top > form > div:nth-child(1) > div > label:nth-child(5)")
	@CacheLookup
	private WebElement dan;
	
	@FindBy(css = "div.border-top > form > div:nth-child(1) > div > label:nth-child(8)")
	@CacheLookup
	private WebElement sar;
	
	@FindBy(css = "div.border-top > form > div:nth-child(1) > div > label:nth-child(11)")
	@CacheLookup
	private WebElement dataforecasting;
	
	@FindBy(css = "button.btn.btn-primary")
	@CacheLookup
	private WebElement savebutton;
	
	
	public void verifyMyProfile() {
		Assert.assertTrue("Title doesn't contain My Profile", myProfile.getText().contains("My Profile"));
	}
	
	public void verifyAccountManager() {
		Assert.assertTrue("Title doesn't contain My account manager", myAccountManager.getText().contains("My Account Manager"));
	}
	
	public void verifyEmail(String email) {
		Assert.assertTrue("Email is not correct ", myEmailAccount.getText().contains(email));
	}
	
	public void openChangePassword() {
		changePassword.click();
	}

	public void ChangePassword(String oldp, String newp, String confp) {
		oldPassword.sendKeys(oldp);
		newPassword.sendKeys(newp);
		confirmNewPassword.sendKeys(confp);
		buttonChangePassword.submit();
	}
	
	public void verifyCorrectChangePassword(){
		Assert.assertTrue("Change Password failed", getDriver().findElement(By.cssSelector("div.alert.alert-success")).getText().contains("Password changed successfully."));
	}
	
	public void verifyWrongChangePassword0() {
		buttonChangePassword.submit();
		Assert.assertTrue("Change Password Failed as expected", getDriver().findElement(By.cssSelector("div.alert.alert-error")).getText().contains("The old password should not be empty."));
	}

	public void verifyWrongChangePassword1() {
		Assert.assertTrue("Change Password Failed as expected", getDriver().findElement(By.cssSelector("div.alert.alert-error")).getText().contains("Old password do not match."));
	}
	
	public void verifyWrongChangePassword2() {
		Assert.assertTrue("Change Password Failed as expected", getDriver().findElement(By.cssSelector("div.alert.alert-error")).getText().contains("Password must be at least 8 characters, and contain at least 1 upper case letter and 1 number."));
	}
	
	public void verifyWrongChangePassword3() {
		Assert.assertTrue("Change Password Failed as expected", getDriver().findElement(By.cssSelector("div.alert.alert-error")).getText().contains("The new passwords do not match."));
	}
	
	public void openSubscriptions() {
		subscriptions.click();
	}
	
	public void verifySubscriptions() {
		Assert.assertTrue("Title doesn't contain Subscriptions", titleSubscriptions.getText().contains("Subscriptions")); 
	}
	
	public void requestServices() {
		buttonRequestServices.click();
	}
	
	public void verifyContactAccountManager(String email) {
		Assert.assertTrue("Title doesn't contain Contact account manager", titleContactAccountManager.getText().contains("Contact Account Manager"));
		String formField = getDriver().findElement(By.cssSelector("div#contact-am input#from_email")).getAttribute("value");
			Assert.assertTrue("From field doesn't contain Email", formField.contains(email));
	}
	
	public void openContactAcccountManager() {
		contactaccountmanager.click();
	}
	
	public void submitMessage() {
		buttonsubmitmessage.click();
	}
	
	public void requiredFields() {
		Assert.assertTrue("Subject and Message Field are not required", getDriver().findElement(By.cssSelector("div.alert.alert-error")).getText().contains("Subject and Message are required fields."));
	
	}
	
	public void verifyClear(String Subject, String Message) {
		buttonclear.click();
		Assert.assertFalse("Clear subject does not work", subject.getText().contains(Subject));
		Assert.assertFalse("Clear message does not work", message.getText().contains(Message));
	}
	
	public void writeMessage(String Subject, String Message) {
		subject.sendKeys(Subject);
		message.sendKeys(Message);
	}
	
	public void verifyEmailSent() throws InterruptedException {
		buttonsubmitmessage.click();
		Assert.assertTrue("Error when sending the email", getDriver().findElement(By.cssSelector("div#result > div")).getText().contains("Message sent."));
	}
	
	public void openWebsitePreferences() {
		websitepreferences.click();
	}
	
	public void verifyWebsitePreferences() {
		Assert.assertTrue("Title doesn't contain Website preferences", getDriver().findElement(By.cssSelector("article.span10 > h4")).getText().contains("Website preferences"));
		choosedefault.click();
		String service=getDriver().findElement(By.cssSelector("select#service_landing_page")).getAttribute("disabled");
		System.out.println(service);
		if(service.equals("true")){System.out.println("Service is disabled");}
		else {System.out.println("Service is not disabled");}
		dataforecasting.click();
		String service2=getDriver().findElement(By.cssSelector("select#service_landing_page")).getAttribute("disabled");
		System.out.println(service2);
		if(service2.equals("true")){System.out.println("Service is disabled");}
		else {System.out.println("Service is not disabled");}
	}
	
	public void chooseWebsitePreferences(String websitePreference) {
		//getDriver().findElement(By.cssSelector("form[class='form-horizontal padding-top-20'] > div:nth-child(1) > div > label div#uniform-" + websitePreference)).click();
		sar.click();
	//	Assert.assertTrue(getDriver().findElement(By.cssSelector("form[class='form-horizontal padding-top-20'] > div:nth-child(1) > div > label div#uniform-" + websitePreference + " > span")).getAttribute("class").contains("checked"));
		savebutton.click();
	}
	
	public void verifyWebsitePreferences(String websitePreference){
		//Assert.assertTrue(getDriver().findElement(By.cssSelector("form[class='form-horizontal padding-top-20'] > div:nth-child(1) > div > label div#uniform-" + websitePreference + " > span")).getAttribute("class").contains("checked"));
		Assert.assertTrue("not found!", verifyElementState("document.getElementById('sar')"));
	}
	
	public void verifyTheSubjectTrialUserFromArticles(String name){
		String newName[]= name.split("[-]");
		System.out.println(newName[1]);
		String subjectName = subject.getAttribute("value").toString();
		System.out.println(subjectName);
		Assert.assertTrue(subjectName.contains("[Content Access Needed]" + newName[1]));
	}
	
	public void verifyTheSubjectTrialUserFromReports(String name){
		String newName[]= name.split(" ");
		System.out.println(newName[0]);
		System.out.println(newName[1]);
		String subjectName = subject.getAttribute("value").toString();
		System.out.println(subjectName);
		Assert.assertTrue(subjectName.contains("[PDF Access Needed] PDF " + newName[0] + " " + newName[1]));
	}
	
	public void verifyChangePassword(String user, String pass, String validation) {
		//TODO fix this
//		HomePageHeaderPage homePage = new HomePageHeaderPage(getDriver());
//		LoginPage loginPage = new LoginPage(getDriver());
		if (validation.contains("correct")) {
			verifyCorrectChangePassword();
//			homePage.clickOnLogout();
//			loginPage.inputUsername(user);
//			loginPage.inputPassword(pass);
//			loginPage.clickOnLogin();
//			loginPage.verifyCorrectLogin();
//			homePage.clickOnMyBmoIcon();
//			homePage.clickMyBmoAccountDropdown();
			openChangePassword();
		} else {
			if (validation.contains("wrong1")) {
				verifyWrongChangePassword1();
			} else {
				if (validation.contains("wrong2")) {
					verifyWrongChangePassword2();
				} else {
					if (validation.contains("wrong3")) {
						verifyWrongChangePassword3();
					} 
					
				}
			}
		}
	}
}


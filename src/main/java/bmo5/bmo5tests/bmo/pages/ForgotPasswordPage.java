package bmo5.bmo5tests.bmo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class ForgotPasswordPage extends AbstractPage {


	private WebElement email;
	
	@FindBy(partialLinkText = "Go back to login")
	@CacheLookup
	private WebElement goBackLink;
	
	@FindBy(css = "button[type='submit']")
	private WebElement retrievePasswordButton;
	
	
	public void retrievePassword(String emailAddress) {
		email.sendKeys(emailAddress);
		retrievePasswordButton.submit();
	}
	
	public void backToLogin() {
		goBackLink.click();
	}
	
	public void verifyLoginButtonExists() {
		waitABit(5000);
		Assert.assertTrue("Go Back To Login did not work", getDriver().findElement(By.cssSelector("button[type='submit']")).isDisplayed());
	}
	
	public void verifyRetrievePassword(String validation) {
		if(validation.contains("correct")) {verifyRetrieved(); }
		else { verifyNotRetrieved(); }
	}
	
	public void verifyRetrieved() {
		waitABit(5000);
		Assert.assertTrue("Password Retrieve has failed", getDriver().findElement(By.cssSelector("p[class='help-block']")).getText().contains("We have sent you an email containing a link to reset your password."));
	}
	
	public void verifyNotRetrieved() {
		waitABit(5000);
		Assert.assertTrue("The email wasn't wrong (as expected)", getDriver().findElement(By.cssSelector("p[class='help-block']")).getText().contains("The email address you provided is not in our records"));
	}
}
package bmo5.bmo5tests.bmo.pages;

import net.thucydides.core.annotations.findby.By;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class LoginPage extends AbstractPage {

	@FindBy(css = "input#email")
	private WebElement email;

	@FindBy(css = "input#password")
	private WebElement password;

	@FindBy(partialLinkText = "Forgot password")
	private WebElement forgotPassword;

	@FindBy(css = "button[type='submit']")
	private WebElement submitButton;

	public void inputUserName(String placeholderEmail,String user) {
//		element(email).waitUntilVisible();
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("input#email")).getAttribute("placeholder").contains(placeholderEmail));
		email.sendKeys(user);
	}

	public void  inputUsername(String user){
		email.sendKeys(user);
	}
	
	public void inputPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void inputPassWord(String placeholderPass,String pass) {
//		element(password).waitUntilVisible();
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("input#password")).getAttribute("placeholder").contains(placeholderPass));
		password.sendKeys(pass);
	}

	public void clickOnLogin() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("button.btn.btn-wider.btn-primary.pull-right")).isDisplayed());
		element(submitButton).waitUntilVisible();
		submitButton.submit();
	}

	public void clickForgotPassword() {
		forgotPassword.click();
	}

	//TODO fix this
//	public void verifyLogIn(String validation){
//		if(validation.contains("correct")){ 
//			verifyCorrectLogin(); 
//			HomePageHeaderPage homePageHeaderPage = new HomePageHeaderPage(getDriver());
//			homePageHeaderPage.clickOnLogout(); 
//			}
//		else { 
//			verifyWrongLogin(); 
//			}
//	}
	public void verifyCorrectLogin() {
		Assert.assertTrue("Login failed", getDriver().findElement(By.linkText("Advanced search")).isDisplayed());
	}

	public void verifyWrongLogin() {
		Assert.assertTrue("Login Failed as expected",getDriver().findElement(By.cssSelector("div[class='alert alert-error']")).getText()
						.contains("User name and/or password are incorrect, please re-enter and submit."));
	}
}




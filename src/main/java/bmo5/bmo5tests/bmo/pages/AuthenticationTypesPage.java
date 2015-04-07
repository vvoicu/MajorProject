package bmo5.bmo5tests.bmo.pages;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class AuthenticationTypesPage extends AbstractPage{
	
	@FindBy(css = "div.text-center > h4")
	private WebElement subscriberLogin;
	
	@FindBy(css = "a.btn.dropdown-toggle > i.icon-c-user")
	private WebElement myBMO;
	
	
	public void clickOnLink(String urlLink) {
		element(By.cssSelector("a."+urlLink+"")).waitUntilVisible().click();
	}
	
	public void loginPageIsDisplayed(){
		element(subscriberLogin).waitUntilVisible();
		Assert.assertTrue("Login page was not displayed! ", subscriberLogin.getText().contains("Subscriber login")); 
	}
	
	public void loginByForm(String formEnvironment, String username, String password){
		waitABit(5000);
		element(getDriver().findElement(By.cssSelector("form."+formEnvironment+" > div > input#uid"))).waitUntilVisible();
		waitABit(1000);
		getDriver().findElement(By.cssSelector("form."+formEnvironment+" > div > input#uid")).sendKeys(username);
		waitABit(1000);
		
		element(getDriver().findElement(By.cssSelector("form."+formEnvironment+" > div > input#pwdOne"))).waitUntilVisible();
		waitABit(1000);
		getDriver().findElement(By.cssSelector("form."+formEnvironment+" > div > input#pwdOne")).sendKeys(password);
		waitABit(1000);
		
		element(getDriver().findElement(By.cssSelector("form."+formEnvironment+" > div > input[type='submit']"))).waitUntilVisible();
		waitABit(1000);
		getDriver().findElement(By.cssSelector("form."+formEnvironment+" > div > input[type='submit']")).click();
		
//		element(myBMO).waitUntilPresent();
		Assert.assertTrue("User was not logged in", myBMO.isDisplayed()); 
	}
}

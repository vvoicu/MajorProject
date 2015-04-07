package bmo5.bmo5tests.adm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;


/**
 * Login page for ADM site
 */
public class LoginPage extends AbstractAdmPage{


	@FindBy(id = "username")
	private WebElement userInput;
	
	@FindBy(id = "password")
	private WebElement passwordInput;
	
	
	@FindBy(css = "button.btn.btn-primary")
	private WebElement loginButton;
	
	public void usernameInput(String user){
		element(userInput).waitUntilVisible();
		userInput.sendKeys(user);
	}
	
	public void passwordInput(String pass){
		element(passwordInput).waitUntilVisible();
		passwordInput.sendKeys(pass);
	}
	
	public void clickOnLogin(){
		element(loginButton).waitUntilVisible();
		loginButton.click();
	}
	
	
}

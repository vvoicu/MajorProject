package bmo5.bmo5tests.bmo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class CreateChildAccountPage extends AbstractPage {
	
	@FindBy(css = "ul#js-mybmo-menu > li:nth-child(2) > h4")
	private WebElement childAccountWindow;
	
	@FindBy(css = "i.icon-c-user")
	private WebElement myBMOIcon;
	
	@FindBy(css = "a#create_account")
	private WebElement createANewAccountLink;
	
	@FindBy(css = "button#create_child_account_button")
	private WebElement createNewAccountButton;
	
	@FindBy(css = "button#cancel_create_child_account_button")
	private WebElement cancelNewAccountButton;
	
	@FindBy(css = "input#first_name")
	private WebElement first_nameField;
	
	@FindBy(css = "input#last_name")
	private WebElement last_nameField;
	
	@FindBy(css = "input#email")
	private WebElement emailField;
	
	@FindBy(css = "input#repeat_email")
	private WebElement repeat_emailField;
	
	@FindBy(css = "input#password")
	private WebElement passwordField;
	
	@FindBy(css = "input#repeat_password")
	private WebElement repeat_passwordField;
	
	@FindBy(css = "div#create_child_account_form_error")
	private WebElement create_child_account_form_error;
	
	@FindBy(css = "div#create_child_account_form_error > div:nth-child(1)")
	private WebElement errorMessages;
	
	@FindBy(css = "div.btn-toolbar > div:nth-child(3) > a")
	private WebElement admDeleteButton;
	
	@FindBy(css = "div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > h5:nth-child(2) > a")
	private WebElement userSummary;
	
	//@FindBy(css = "div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(4) > table > tbody > tr:nth-child(1) > td:nth-child(1)")
	//private WebElement childId;
	
	@FindBy(css = "div[class='alert alert-success']")
	private WebElement messageChildSuccesfullyDeleted;
	
	@FindBy(css = "div[class='alert alert-error']")
	private WebElement messageInvalidPassword;
	
	@FindBy(css = "div[class='alert alert-error']")
	private WebElement messageEmailAlreadyUsed;
	
	@FindBy(css = "div[class='alert alert-success']")
	private WebElement messageAccountSuccessfullyCreated;
	
	@FindBy(css = "ul.dropdown-menu.pull-right > li:nth-child(6) > span > a")
	private WebElement logoutButton;
	
	@FindBy(css = "input#Email")
	private WebElement emailAccountField;
	
	@FindBy(css = "input#Password")
	private WebElement passwordAccountField;
	
	@FindBy(css = "form#child_login > div:nth-child(4) > div:nth-child(1) > button")
	private WebElement loginButton;
	
	public void createChildAccountLeaveEmptyFields() {
		myBMOIcon.click();
		element(childAccountWindow).waitUntilVisible();
		createANewAccountLink.click();
		element(createNewAccountButton).waitUntilVisible();
		cancelNewAccountButton.click();
		createANewAccountLink.click();
		element(createNewAccountButton).waitUntilVisible();
		createNewAccountButton.click();
		element(create_child_account_form_error).waitUntilVisible();
		String errors = errorMessages.getText();
		System.out.println(errors);
		Assert.assertTrue("The message for empty fields is missing", errorMessages.getText().contains("All fields are required but some are empty"));
		Assert.assertTrue("The message for not identical emails is missing", errorMessages.getText().contains("Email is not valid"));
		Assert.assertTrue("The message for not identical password is missing", errorMessages.getText().contains("Password must be at least 8 characters"));
	}
		
	
	public void createChildAccountWithInvalidEmails(String invalidEmail1, String invalidEmail2, String invalidEmail3, String invalidEmail4, String invalidEmail5, String validPassword1, String firstName, String lastName) {
		first_nameField.sendKeys(firstName);
		last_nameField.sendKeys(lastName);
		emailField.sendKeys(invalidEmail1);
		repeat_emailField.sendKeys(invalidEmail1);
		passwordField.sendKeys(validPassword1);
		repeat_passwordField.sendKeys(validPassword1);
		createNewAccountButton.click();
		String errorInvalidEmail1 = errorMessages.getText();
		System.out.println(errorInvalidEmail1);
		Assert.assertTrue("The message for invalid1 email is missing", errorMessages.getText().contains("Email " + invalidEmail1 + " is not valid"));
		
		emailField.clear();
		repeat_emailField.clear();
		emailField.sendKeys(invalidEmail2);
		repeat_emailField.sendKeys(invalidEmail2);
		createNewAccountButton.click();
		String errorInvalidEmail2 = errorMessages.getText();
		System.out.println(errorInvalidEmail2);
		Assert.assertTrue("The message for invalid email2 is missing", errorMessages.getText().contains("Email " + invalidEmail2 + " is not valid"));
		
		emailField.clear();
		repeat_emailField.clear();
		emailField.sendKeys(invalidEmail3);
		repeat_emailField.sendKeys(invalidEmail3);
		createNewAccountButton.click();
		String errorInvalidEmail3 = errorMessages.getText();
		System.out.println(errorInvalidEmail3);
		Assert.assertTrue("The message for invalid email3 is missing", errorMessages.getText().contains("Email " + invalidEmail3 + " is not valid"));
		
		emailField.clear();
		repeat_emailField.clear();
		emailField.sendKeys(invalidEmail4);
		repeat_emailField.sendKeys(invalidEmail4);
		createNewAccountButton.click();
		String errorInvalidEmail4 = errorMessages.getText();
		System.out.println(errorInvalidEmail4);
		Assert.assertTrue("The message for invalid email4 is missing", errorMessages.getText().contains("Email " + invalidEmail4 + " is not valid"));
		
		emailField.clear();
		repeat_emailField.clear();
		emailField.sendKeys(invalidEmail5);
		repeat_emailField.sendKeys(invalidEmail5);
		createNewAccountButton.click();
		String errorInvalidEmail5 = errorMessages.getText();
		System.out.println(errorInvalidEmail5);
		Assert.assertTrue("The message for invalid email5 is missing", errorMessages.getText().contains("Email " + invalidEmail5 + " is not valid"));
	}
	
	public void createChildAccountWithNotIdenticalEmails(String validEmail1, String validEmail2) {
		emailField.clear();
		repeat_emailField.clear();
		emailField.sendKeys(validEmail1);
		repeat_emailField.sendKeys(validEmail2);
		createNewAccountButton.click();
		String errorNotIdenticalEmails = errorMessages.getText();
		System.out.println(errorNotIdenticalEmails);
		Assert.assertTrue("The message for not identical emails is missing", errorMessages.getText().contains("Emails do not match"));
		}
	
	public void createChildAccountWithNotIdenticalPasswords(String validPassword1, String validPassword2, String validEmail1) {
		
		emailField.clear();
		repeat_emailField.clear();
		passwordField.clear();
		repeat_passwordField.clear();
		emailField.sendKeys(validEmail1);
		repeat_emailField.sendKeys(validEmail1);
		passwordField.sendKeys(validPassword1);
		repeat_passwordField.sendKeys(validPassword2);
		createNewAccountButton.click();
		String errorNotIdenticalPasswords = errorMessages.getText();
		System.out.println(errorNotIdenticalPasswords);
		Assert.assertTrue("The message for not identical passwords is missing", errorMessages.getText().contains("Passwords do not match."));
		}
	
	public void createChildAccountWithInvalidPasswords(String firstName, String lastName, String invalidPassword, String validEmail1) {
		
		passwordField.clear();
		repeat_passwordField.clear();
		passwordField.sendKeys(invalidPassword);
		repeat_passwordField.sendKeys(invalidPassword);
		createNewAccountButton.click();
		String errorMessageInvalidPassword = errorMessages.getText();
		System.out.println(errorMessageInvalidPassword);
		Assert.assertTrue("The message for invalid password is missing", errorMessages.getText().contains("Password must be at least 8 characters"));
		}
	
	public void createChildAccountWithEmailAlreadyUsed(String validPassword1, String emailAlreadyUsed, String firstName, String lastName) {
		first_nameField.clear();
		first_nameField.sendKeys(firstName);
		last_nameField.clear();
		last_nameField.sendKeys(lastName);
		emailField.clear();
		emailField.sendKeys(emailAlreadyUsed);
		repeat_emailField.clear();
		repeat_emailField.sendKeys(emailAlreadyUsed);
		passwordField.clear();
		passwordField.sendKeys(validPassword1);
		repeat_passwordField.clear();
		repeat_passwordField.sendKeys(validPassword1);
		createNewAccountButton.click();
		String errorEmailAlreadyUsed = errorMessages.getText();
		System.out.println(errorEmailAlreadyUsed);
		Assert.assertTrue("The message for email already used is missing", errorMessages.getText().contains("There is an account already"));
		}
	
	public String createChildAccountWithValidData(String firstName, String lastName, String validPassword1, String randomValidEmail) {
		String randomEmail = randomValidEmail+"_"+StringUtils.randomNumber(84000)+"_"+StringUtils.randomNumber(84000)+"@evozon.com";
		element(createNewAccountButton).waitUntilVisible();
		first_nameField.clear();
		first_nameField.sendKeys(firstName);
		last_nameField.clear();
		last_nameField.sendKeys(lastName);
		emailField.clear();
		emailField.sendKeys(randomEmail);
		repeat_emailField.clear();
		repeat_emailField.sendKeys(randomEmail);
		System.out.println(randomEmail);
		passwordField.clear();
		passwordField.sendKeys(validPassword1);
		repeat_passwordField.clear();
		repeat_passwordField.sendKeys(validPassword1);
		createNewAccountButton.click();
		String messageSucces = messageAccountSuccessfullyCreated.getText();
		System.out.println(messageSucces);
		Assert.assertTrue("The account was not created", messageAccountSuccessfullyCreated.getText().contains("Account successfully created. You have successfully logged into child account"));
		return randomEmail;
		}

	public void loginWithNewUserCreated(String validPassword1, String randomEmail) {
		
		myBMOIcon.click();
		element(logoutButton).waitUntilVisible();
		waitABit(5000);
		logoutButton.click();
		waitABit(5000);
		myBMOIcon.click();
		element(emailAccountField).waitUntilVisible();
		emailAccountField.sendKeys(randomEmail);
		waitABit(5000);
		passwordAccountField.sendKeys(validPassword1);
		waitABit(5000);
		loginButton.click();
		}
	
	public void verifyChildAccountIntoAdm(String validEmail, String parentEmail) {
		
		element(admDeleteButton).waitUntilVisible();
		Assert.assertTrue("The child account don't have parent account", userSummary.getText().contains(parentEmail));
		admDeleteButton.click();
		element(messageChildSuccesfullyDeleted).waitUntilVisible();
		Assert.assertTrue("The child account was not deleted", messageChildSuccesfullyDeleted.getText().contains("succesfully deleted."));
		}
	
	public void loginFromEnterprise(String username, String password){
		myBMOIcon.click();
		element(emailAccountField).waitUntilVisible();
		emailAccountField.sendKeys(username);
		waitABit(5000);
		passwordAccountField.sendKeys(password);
		waitABit(5000);
		loginButton.click();
	}
	
	public void logoutChild(){
		myBMOIcon.click();
		element(logoutButton).waitUntilVisible();
		waitABit(5000);
		logoutButton.click();
		waitABit(5000);
	}
	public void logoutTheIpUser(){
		myBMOIcon.click();
		getDriver().findElement(By.cssSelector("ul#js-mybmo-menu > li:nth-child(1) > a:nth-child(2)")).click();
		waitABit(3000);
		
	}
	public void verifyMessageForEnterpriseChildLoginOnBmo(String errorMessage) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#flash-alert-message")).getText().contains(errorMessage));
	}
}
package bmo5.bmo5tests.bmo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class EntrepriseAccountPage extends AbstractPage {

	@FindBy(css = "ul#js-mybmo-menu > li:nth-child(2) > h4")
	private WebElement myBMO;

	@FindBy(css = "form#child_login > div.controls >button")
	private WebElement submitButton;

	@FindBy(css = "div#login > form > div:nth-child(4) > div > a") //a[class='btn btn-link']
	private WebElement forgotPassword;

	@FindBy(css = "a[id ='create_account']")
	private WebElement createAccount;

	@FindBy(css = "input[id ='Password']")
	private WebElement password;

	@FindBy(css = "input[id ='Email']")
	private WebElement email;

	@FindBy(css = "div#forgot-pass> form > div:nth-child(1)  > div > input") //"input[id ='email']
	private WebElement emailreset;

	@FindBy(css = "div#login > form > div:nth-child(3) > div > button")
	private WebElement loginButton;

	@FindBy(css = "ul.breadcrumb > li.active")
	@CacheLookup
	private WebElement breadcrumbLast;

	@FindBy(css = "ul.breadcrumb > li:nth-child(3) > a")
	@CacheLookup
	private WebElement breadcrumbMiddle;

	@FindBy(css = "form#child_login > div:nth-child(4) > div > button")
	private WebElement logInButton;

	@FindBy(css = "div#forgot-pass > form > div:nth-child(2) > div > button:nth-child(1)")
	private WebElement retrievePassword;
	@FindBy(css = "div.container-fluid section > div > form > div:nth-child(2) > div > button")
	private WebElement retrieveForgotPasswordEmail;

	@FindBy(css = "div.container-fluid > section > div > form > div:nth-child(2) > div > button.btn.btn-wider.btn-primary.pull-right")
	private WebElement retrievePasswordEmail;
	
	@FindBy(css = "div.container-fluid > section > div > div > p")
	private WebElement retrieveForgotPasswordConfirmationMessage;

	public void clickOnLoginButton() {
		loginButton.click();
	}

	public void verifyEnterpriseAccount(String enterpriseBmo) {
		Assert.assertTrue("The user is not login with an Entreprise account", getDriver().findElement(By.cssSelector("ul#js-mybmo-menu > li:nth-child(2) > h4")).getText().equals(enterpriseBmo));
		Assert.assertTrue("The button is not found!", logInButton.getText().contains("Login"));//getDriver().findElement(By.cssSelector("form#child_login > div:nth-child(3) > div > button"))
		logInButton.click();
		Assert.assertTrue("No message there!", getDriver().findElement(By.cssSelector("div.alert.alert-error ")).getText().contains("User name and/or password are incorrect, please re-enter and submit."));
	}

	public void verifyForgotPasswordlink(String email){
		waitABit(5000);
		Assert.assertTrue("not found!!", getDriver().findElement(By.cssSelector("a#create_account")).getText().contains("Create a new account"));
		Assert.assertTrue("The link is missing!", forgotPassword.getText().contains("Forgot password?"));
		forgotPassword.click();
		waitABit(5000);
		Assert.assertTrue("not found", getDriver().findElement(By.cssSelector("div#forgot-pass > p")).getText().contains("Please enter your email address, so that we may send you a link to reset your password:"));
		retrievePassword.click();
		waitABit(5000);
		int ran;
		ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		getDriver().findElement(By.cssSelector("div.container-fluid > section > div > form > div:nth-child(1) > div > input")).sendKeys("123@evo.2" + ran);
		retrieveForgotPasswordEmail.click();

		getDriver().findElement(By.cssSelector("div.container-fluid > section > div > form > div:nth-child(1) > div > input")).sendKeys(email);
		//waitABit(5000);
		retrievePasswordEmail.click();
		//waitABit(5000);
		Assert.assertTrue("not found!!!",retrieveForgotPasswordConfirmationMessage.getText().contains("We have sent you an email containing a link to reset your password."));
	}

	public void verifyTextonEnterprise() {
		Assert.assertTrue("", getDriver().findElement(By.cssSelector("form#child_login > div:nth-child(3) > p > a")).getTagName().contains("Create a new account"));
	}
	public void inputUsername(String user) {
		element(email).waitUntilVisible();
		email.sendKeys(user);
	}

	public void inputPassword(String pass) {
		element(password).waitUntilVisible();
		password.sendKeys(pass);
	}

	public void clickOnLogin() {
		element(submitButton).waitUntilVisible();
		submitButton.submit();
	}

	public void verifyCorrectLogin() {
		Assert.assertTrue("Login failed",
				getDriver().findElement(By.linkText("Advanced search"))
				.isDisplayed());
	}

	public void verifyWrongLogin() {
		Assert.assertTrue(
				"Login Failed as expected",
				getDriver()
				.findElement(
						By.cssSelector("div[class='alert alert-error']"))
						.getText()
						.contains("User name and/or password are incorrect, please re-enter and submit."));
	}

	public void verifyEntreprisePage() {
		Assert.assertTrue("Login failed",
				getDriver().findElement(By.linkText("Enterprise Account"))
				.isDisplayed());
	}

	public void forgotPassword(String email) {
		forgotPassword.click();
		element(emailreset).waitUntilVisible();
		emailreset.sendKeys(email);


	}

	public void verifyAccountForEnterprise(String profile, String subscription, String accountContact) {
		Assert.assertTrue("Profile is not in the dropdown!", getDriver().findElement(By.cssSelector("ul#slide-account > li:nth-child(1) > a")).getText().contains(profile));
		Assert.assertTrue("Profile is not in the dropdown!", getDriver().findElement(By.cssSelector("ul#slide-account > li:nth-child(2) > a")).getText().contains(subscription));
		Assert.assertTrue("Profile is not in the dropdown!", getDriver().findElement(By.cssSelector("ul#slide-account > li:nth-child(3) > a")).getText().contains(accountContact));

	}
	
	public void verifyBreadCrumb(String text,String textSubs, String textContactAccount) {
		boolean contained = false;
		if (breadcrumbLast.getText().contains(text)) {
			contained = true;
		} else {
			if (breadcrumbMiddle.getText().contains(text)) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}
}


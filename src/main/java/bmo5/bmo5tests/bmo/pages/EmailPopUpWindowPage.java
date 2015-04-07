package bmo5.bmo5tests.bmo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class EmailPopUpWindowPage extends AbstractPage  {
	
	@FindBy(css="div.controls > input#subject")
	@CacheLookup
	private WebElement subjectContent;
	
	@FindBy(css="div.controls > textarea")
	@CacheLookup
	private WebElement messageContent;
	
	@FindBy(css="input#contact-manager-form-clear")
	@CacheLookup
	private WebElement clearButton;
	
	@FindBy(css="input#account-manager-submit")
	@CacheLookup
	private WebElement submitButton;
	
	@FindBy(css="div.modal-body > button.close")
	@CacheLookup
	private WebElement closeLink;
	
	@FindBy(css="div.email-acc-manager-info > h3")
	@CacheLookup
	private WebElement titlePopUpWindow;
	
	@FindBy(css="form#contact-manager-form > div:nth-child(1) >label")
	@CacheLookup
	private WebElement subjectName;
	
	@FindBy(css="form#contact-manager-form > div:nth-child(2) >label")
	@CacheLookup
	private WebElement messageName;
	
	@FindBy(css="form#contact-manager-form > div:nth-child(2) > div > label")
	@CacheLookup
	private WebElement subjectErrorMessage;
	
	@FindBy(css="form#contact-manager-form > div:nth-child(3) > div > label")
	@CacheLookup
	private WebElement messageErrorMessage;
	
	@FindBy(css="div#result > div")
	@CacheLookup
	private WebElement messageSent;
	
	
	public void verifyEmailIconPreviewArticle(){
		if(getDriver().findElements(By.cssSelector("div.email-acc-manager-info > h3 ")).size() == 1 && getDriver().findElement(By.cssSelector("div.email-acc-manager-info > h3 ")).isDisplayed()){
			Assert.assertEquals("Contact Us", titlePopUpWindow.getText());
			Assert.assertTrue(subjectName.isDisplayed());
			Assert.assertTrue(subjectContent.isDisplayed());	
			Assert.assertTrue(messageName.isDisplayed());
			Assert.assertTrue(messageContent.isDisplayed());
			Assert.assertTrue(submitButton.isDisplayed());
			Assert.assertTrue(clearButton.isDisplayed());	
			Assert.assertTrue(closeLink.isDisplayed());
		}
		else{
			System.out.println("There is no email wondow.");
		}
	}
	
	public void verifySubjectIsEmptyForEnterprise(){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input#from_email")).getAttribute("value").isEmpty());
	}
	
	public void closeEmailIconPageTitle(){
		if(getDriver().findElements(By.cssSelector("form#contact-manager-form > div:nth-child(1) >label")).size() == 1 && getDriver().findElement(By.cssSelector("div.email-acc-manager-info > h3 ")).isDisplayed()){
			closeLink.click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("input#from_email")).size() == 0);
		}
		else{
			System.out.println("There is no email wondow.");
		}
	}
	
	public void submitWithoutCompletingAnyField(){
		if(getDriver().findElements(By.cssSelector("form#contact-manager-form > div:nth-child(1) >label")).size() == 1 && getDriver().findElement(By.cssSelector("div.email-acc-manager-info > h3 ")).isDisplayed()){
			submitButton.click();
			Assert.assertTrue(subjectErrorMessage.isDisplayed());
			Assert.assertTrue(messageErrorMessage.isDisplayed());	
		}
		else{
			System.out.println("There is no email wondow.");
		}
	}
	
	public void submitWithSpacesInFields(){
		if(getDriver().findElements(By.cssSelector("form#contact-manager-form > div:nth-child(1) >label")).size() == 1 && getDriver().findElement(By.cssSelector("div.email-acc-manager-info > h3 ")).isDisplayed()){
			subjectContent.sendKeys("          ");
			messageContent.sendKeys("          ");
			submitButton.click();
			Assert.assertTrue("", subjectErrorMessage.isDisplayed());
			Assert.assertTrue(messageErrorMessage.isDisplayed());
		}
		else{
			System.out.println("There is no email wondow.");
		}
	}
	
	public void completeFieldsAndClear(){
		if(getDriver().findElements(By.cssSelector("form#contact-manager-form > div:nth-child(1) >label")).size() == 1 && getDriver().findElement(By.cssSelector("div.email-acc-manager-info > h3 ")).isDisplayed()){
			clearButton.click();
			subjectContent.sendKeys("Test Subject");
			messageContent.sendKeys("Test message content: This is a test");
			Assert.assertTrue(subjectContent.getText().isEmpty());
			Assert.assertTrue(messageContent.getText().isEmpty());
		}
		else{
			System.out.println("There is no email wondow.");
		}
	}
	
	public void completeFieldsAndSubmit(){
		if(getDriver().findElements(By.cssSelector("form#contact-manager-form > div:nth-child(1) >label")).size() == 1 && getDriver().findElement(By.cssSelector("div.email-acc-manager-info > h3 ")).isDisplayed()){
			subjectContent.sendKeys("Test Subject");
			messageContent.sendKeys("Test message content: This is a test");
			submitButton.click();
			Assert.assertTrue(messageSent.isDisplayed());
		}
		else{
			System.out.println("There is no email wondow.");
		}
	}
	
	public void firstEmailTestFromPreviewArticle(){
		if(getDriver().findElements(By.cssSelector("form#contact-manager-form > div:nth-child(1) >label")).size() == 1){
			System.out.println(titlePopUpWindow.getText());
			Assert.assertEquals("Contact Us", titlePopUpWindow.getText());
			Sleeper.sleepTight(2000);
			subjectContent.sendKeys("Test");
			Sleeper.sleepTight(2000);
			submitButton.click();
			Sleeper.sleepTight(2000);
			Assert.assertTrue(messageErrorMessage.isDisplayed());
			Sleeper.sleepTight(2000);
			clearButton.click();
			Sleeper.sleepTight(2000);
			closeLink.click();
		}
		else{
			System.out.println("There is no email wondow.");
		}
	}
	
	public void secondEmailTestFromPreviewArticle(){
		if(getDriver().findElements(By.cssSelector("form#contact-manager-form > div:nth-child(1) >label")).size() == 1){
			subjectName.click();
			Sleeper.sleepTight(2000);
			subjectContent.sendKeys("Test2");
			Sleeper.sleepTight(2000);
			messageContent.sendKeys("Just a test...");
			Sleeper.sleepTight(2000);
			clearButton.click();
			Sleeper.sleepTight(2000);
			submitButton.click();
			Sleeper.sleepTight(2000);
			Assert.assertTrue(subjectErrorMessage.isDisplayed());
			Assert.assertTrue(messageErrorMessage.isDisplayed());	
			messageContent.sendKeys("Text");
			Sleeper.sleepTight(2000);
			submitButton.click();
			Sleeper.sleepTight(2000);
			Assert.assertTrue(subjectErrorMessage.isDisplayed());
			closeLink.click();
		}
		else{
			System.out.println("There is no email wondow.");
		}
	}
	
}

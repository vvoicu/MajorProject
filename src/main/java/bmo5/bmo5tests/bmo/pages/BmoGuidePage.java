package bmo5.bmo5tests.bmo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class BmoGuidePage  extends AbstractPage{

	@FindBy(css = "a.introjs-button.introjs-skipbutton")
	private WebElement closeLinkOrRemoveButton;
	
	@FindBy(css = "div.introjs-tooltiptext h4")
	private WebElement modalWindowTitle;
	
	@FindBy(css = "a.introjs-button.introjs-prevbutton.introjs-disabled")
	private WebElement backButtonDisabled;
	
	@FindBy(css = "a.introjs-button.introjs-nextbutton")
	private WebElement nextButtonEnabled;
	
	@FindBy(css = "a.introjs-button.introjs-prevbutton")
	private WebElement backButtonEnabled;
	
	@FindBy(css = "a.introjs-button.introjs-nextbutton.introjs-disabled")
	private WebElement nextButtonDisabled;
	
	@FindBy(css = "introjs-overlay")
	private WebElement overlay;
	
	@FindBy(css = "h4.modal-title")
	private WebElement messageDialogTitle;
	
	@FindBy(css = "div#introConfirm > div > div > div:nth-child(2) > p:nth-child(1) > div#uniform-stopintro > span")
	private WebElement stopGuideCheckBox;
	
	@FindBy(css = "div#introConfirm > div > div > div:nth-child(3) > a:nth-child(1)")
	private WebElement cancelLeavingTheGuideLink;
	
	@FindBy(css = "div#introConfirm > div > div > div:nth-child(3) > a:nth-child(2)")
	private WebElement saveLeavingGuideButton;
	
	public void verifyNavigationModalWindow(){
		element(modalWindowTitle).waitUntilPresent();
		Assert.assertTrue(modalWindowTitle.getText().contains("Navigation"));
		closeLinkOrRemoveButton.click();
	}
	
	public void verifyTabStructureWindow(){
		element(modalWindowTitle).waitUntilPresent();
		Assert.assertTrue(modalWindowTitle.getText().contains("Tab structure"));
		closeLinkOrRemoveButton.click();
	}
	
	public void verifyLeftHandNavigation(){
		element(modalWindowTitle).waitUntilPresent();
		Assert.assertTrue(modalWindowTitle.getText().contains("Left Hand Navigation"));
		Assert.assertTrue(closeLinkOrRemoveButton.isDisplayed());
		Assert.assertTrue(backButtonDisabled.isDisplayed());
		Assert.assertTrue(nextButtonEnabled.isDisplayed());
	}
	
	public void clickOnNextButtonFromLeftHandNavigationPivotPointAndVerify(){
		nextButtonEnabled.click();
		element(modalWindowTitle).waitUntilPresent();
		Assert.assertTrue(modalWindowTitle.getText().contains("Tab structure"));
		Assert.assertTrue(backButtonEnabled.isDisplayed());
		Assert.assertTrue(nextButtonDisabled.isDisplayed());
		closeLinkOrRemoveButton.click();
	}
	
	public void clickOnNextButtonFromLeftHandNavigationDataToolAndVerify(){
		nextButtonEnabled.click();
		waitABit(3000);
		Assert.assertTrue(modalWindowTitle.getText().contains("Download & Display Data"));
		Assert.assertTrue(backButtonEnabled.isDisplayed());
		Assert.assertTrue(nextButtonDisabled.isDisplayed());
	}
	
	public void clickOnBackButtonFromDownloadAndDisplayDataWindowAndVerify(){
		backButtonEnabled.click();
		Assert.assertTrue(modalWindowTitle.getText().contains("Left Hand Navigation"));
		Assert.assertTrue(closeLinkOrRemoveButton.isDisplayed());
		Assert.assertTrue(backButtonDisabled.isDisplayed());
		Assert.assertTrue(nextButtonEnabled.isDisplayed());
	}
	
	public void removeForNowTheBMOGuideAndVerify(){
		closeLinkOrRemoveButton.click();
		Assert.assertTrue(messageDialogTitle.getText().contains("Would you like to leave this guide early?"));
		messageDialogTitle.click();
		cancelLeavingTheGuideLink.click();
		Assert.assertTrue(modalWindowTitle.getText().contains("Left Hand Navigation"));
		Assert.assertTrue(closeLinkOrRemoveButton.isDisplayed());
		Assert.assertTrue(backButtonDisabled.isDisplayed());
		Assert.assertTrue(nextButtonEnabled.isDisplayed());
		closeLinkOrRemoveButton.click();
		Assert.assertTrue(messageDialogTitle.getText().contains("Would you like to leave this guide early?"));
		saveLeavingGuideButton.click();
	}
	
	public void stopBMOGuideAndVerify(){
		closeLinkOrRemoveButton.click();
		Assert.assertTrue(messageDialogTitle.getText().contains("Would you like to leave this guide early?"));
		messageDialogTitle.click();
		WebElement stop =  getDriver().findElement(By.cssSelector("div#introConfirm > div > div > div:nth-child(2) > p:nth-child(1) > div#uniform-stopintro > span"));
		stop.click();
		//stopGuideCheckBox.click();
		waitABit(10000);
		Assert.assertTrue(stopGuideCheckBox.getAttribute("class").contains("checked"));
		saveLeavingGuideButton.click();
	}
}

package bmo5.bmo5tests.bmo.pages;


import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class  CostCodesPage extends AbstractPage {

	@FindBy (css = "div.control-group.row-fluid > div:nth-child(2) > div >input")
	private WebElement labelOne;

	@FindBy (css = "div.control-group.row-fluid > div:nth-child(3) > div >input")
	private WebElement labelTwo;

	@FindBy (css = "div.control-group.row-fluid > div:nth-child(4) > div >input")
	private WebElement labelThree;

	@FindBy (css = "div.control-group.row-fluid > div:nth-child(5) > div > input")
	private WebElement labelFour;

	@FindBy (css = "div.control-group.row-fluid > div:nth-child(6) > div ")
	private WebElement selectButtonsCostCodes;

	@FindBy (css = "div.control-group.row-fluid > div:nth-child(6) > div > input:nth-child(1)")
	private WebElement selectContinueButton;

	@FindBy (css = "ul#slide-account > li:nth-child(1) > a")
	private WebElement selectCostCodesFromPanel;

	@FindBy (css = "div.alert.alert-info")
	private WebElement messageCosCodesInfo;

	@FindBy (css = "div#flash-alert-message")
	private WebElement messageConfirmation;

	@FindBy (css = "form#cost_codes_form > div:nth-child(1) > div > input")
	private WebElement labelCCOne;
	
	@FindBy (css = "form#cost_codes_form > div:nth-child(2) > div > input")
	private WebElement labelCCTwo;
	
	@FindBy (css = "form#cost_codes_form > div:nth-child(3) > div > input")
	private WebElement labelCCThree;
	
	@FindBy (css = "form#cost_codes_form > div:nth-child(4) > div > input")
	private WebElement labelCCFour;
	
	@FindBy (css = "div#loginform_div > form > div> div > div:nth-child(2) > label")
	private WebElement labelValueOne;
	
	@FindBy (css = "div#loginform_div > form > div> div > div:nth-child(3) > label")
	private WebElement labelValueTwo;
	
	@FindBy (css = "div#loginform_div > form > div> div > div:nth-child(4) > label")
	private WebElement labelValueThree;
	
	@FindBy (css = "div#loginform_div > form > div> div > div:nth-child(5) > label")
	private WebElement labelValueFour;
	
	@FindBy (css = "form#cost_codes_form > div:nth-child(5) > div > input.btn.btn-primary.btn-wider")
	private WebElement saveChanges;
	
	@FindBy (css = "div.alert.alert-info")
	private WebElement saveInfoMessage;
	
	@FindBy (css = "input#reset-buton")
	private WebElement resetButton;
	
	@FindBy (css = "div.page-wrap > div > section:nth-child(6) > article:nth-child(2) > div:nth-child(2) > dl > dd:nth-child(4)")
	private WebElement emailProfile;
	
	public void showMessageCostCodes() {
		Assert.assertTrue("No message appears!", messageCosCodesInfo.isDisplayed());
	}

	public void selectCostCodesBimo() {
		selectButtonsCostCodes.click();
	}
	
	public void selectContinueOrClearAllButton(String button) {
		Assert.assertTrue("not found!", selectContinueButton.isDisplayed());
		selectContinueButton.click();
		System.out.println("Continue clicked!!!");
	}
	
	public void selectLabelOne(String nameOne) {
		labelOne.sendKeys(nameOne);
	}
	
	public void selectLabeTwo(String nameTwo) {
		labelTwo.sendKeys(nameTwo);
	}
	
	public void selectLabelThree(String nameThree) {
		labelThree.sendKeys(nameThree);
	}
	
	public void selectLabelFour(String nameFour) {
		Assert.assertTrue("Not visible...", labelFour.isDisplayed());
		labelFour.sendKeys(nameFour);
	}

	public void selectCostCodesFromLeftPanel(String costCodes) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(1) > li > ul > li:nth-child(1) > a")).getText().contains("Cost Codes"));
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(1) > li > ul > li:nth-child(1) > a")).click();
	}

	public void changeTheCostCodesNameAndVerify(String labelO,String labelT,String labelTh,String labelF,String newCostCode) {
		getDriver().findElement(By.cssSelector("form#cost_codes_form > div:nth-child("+ labelO +") > div > input ")).clear();
		element(getDriver().findElement(By.cssSelector("form#cost_codes_form > div:nth-child("+ labelO +") > div > input "))).sendKeys(newCostCode);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#cost_codes_form > div:nth-child("+ labelO +") > div > input ")).getAttribute("value").contains(newCostCode));
		getDriver().findElement(By.cssSelector("form#cost_codes_form > div:nth-child("+ labelT +") > div > input ")).clear();
		getDriver().findElement(By.cssSelector("form#cost_codes_form > div:nth-child("+ labelT +") > div > input ")).sendKeys(newCostCode);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#cost_codes_form > div:nth-child("+ labelT +") > div > input ")).getAttribute("value").contains(newCostCode));
		getDriver().findElement(By.cssSelector("form#cost_codes_form > div:nth-child("+ labelTh +") > div > input ")).clear();
		getDriver().findElement(By.cssSelector("form#cost_codes_form > div:nth-child("+labelTh+") > div > input ")).sendKeys(newCostCode);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#cost_codes_form > div:nth-child("+ labelTh +") > div > input ")).getAttribute("value").contains(newCostCode));
		getDriver().findElement(By.cssSelector("form#cost_codes_form > div:nth-child("+labelF+") > div > input ")).clear();
		getDriver().findElement(By.cssSelector("form#cost_codes_form > div:nth-child("+labelF+") > div > input ")).sendKeys(newCostCode);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#cost_codes_form > div:nth-child("+ labelF +") > div > input ")).getAttribute("value").contains(newCostCode));

	}

	public void inputCostCodesNameAtLogin(String labelOneName,String labelTwoName,String labelThreeName, String labelFourName,String costCodeNameF, String costCodeNameS, String costCodeNameT, String costCodeNameFo) {
		Assert.assertTrue(labelValueOne.getText().contains("marketing"));
		getDriver().findElement(By.cssSelector("input#cost_code0")).clear();
		getDriver().findElement(By.cssSelector("input#cost_code0")).sendKeys(costCodeNameF);
		Assert.assertTrue(labelValueTwo.getText().contains("hr"));
		getDriver().findElement(By.cssSelector("input#cost_code1")).clear();
		getDriver().findElement(By.cssSelector("input#cost_code1")).sendKeys(costCodeNameS);
		Assert.assertTrue(labelValueThree.getText().contains("it"));
		getDriver().findElement(By.cssSelector("input#cost_code2")).clear();
		getDriver().findElement(By.cssSelector("input#cost_code2")).sendKeys(costCodeNameT);
		Assert.assertTrue(labelValueFour.getText().contains("accounting"));
		getDriver().findElement(By.cssSelector("input#cost_code3")).clear();
		getDriver().findElement(By.cssSelector("input#cost_code3")).sendKeys(costCodeNameFo);
	}
	
	public void clickOnSaveButton() {
		Assert.assertTrue(saveChanges.isDisplayed());
		saveChanges.click();
		waitABit(3000);
	}

	public void verifyCosCodesNameChanges(String newCostCode) {
		saveInfoMessage.getText().endsWith(newCostCode);
	}

	public void resetAllCostCodes() {
		Assert.assertTrue(resetButton.isDisplayed());
		resetButton.click();
	}

	public void verifyResetAllAction(String message) {
		if(getDriver().findElements(By.cssSelector("div#flash-alert-message")).size() == 1){
			waitABit(4000);
			Assert.assertTrue(messageConfirmation.getText().contains("All cost codes are mandatory for this account"));
		}
		else {
			System.out.println("Optional Cost Codes are on the page!");
			verifyEmptyCostCodesFields();
		}
	}

	public void verifyCostCodesEmptyFieldsMessage(String mandatoryCCMessage,String message) {
		waitABit(3000);
		System.out.println("Message on screen!");
		Assert.assertTrue(messageConfirmation.getText().contains("All cost codes are mandatory for this account"));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#loginform > div > div:nth-child(2) > div:nth-child(1) > p")).isDisplayed());

	}

	public void verifyTheCostCodeNameExistsInTheField(String nameOne,String nameTwo,String nameThree,String nameFour) {
		Assert.assertTrue(labelCCOne.getAttribute("value").contains(nameOne));
		Assert.assertTrue(labelCCTwo.getAttribute("value").contains(nameTwo));
		Assert.assertTrue(labelCCThree.getAttribute("value").contains(nameThree));
		Assert.assertTrue(labelCCFour.getAttribute("value").contains(nameFour));
	}

	public void verifyEmptyCostCodesFields() {
		Assert.assertTrue(labelCCOne.getAttribute("value").contains(""));
		Assert.assertTrue(labelCCTwo.getAttribute("value").contains(""));
		Assert.assertTrue(labelCCThree.getAttribute("value").contains(""));
		Assert.assertTrue(labelCCFour.getAttribute("value").contains(""));
	}

	public void verifyCosCodesIsAppliedOnTrial(String username) {
		String email = emailProfile.getText();
		System.out.println(email);
		Assert.assertTrue(emailProfile.getText().contains(username));
	}
}
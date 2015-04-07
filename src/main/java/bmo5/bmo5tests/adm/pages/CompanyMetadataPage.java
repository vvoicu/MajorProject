package bmo5.bmo5tests.adm.pages;

import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.desktop.DesktopKeyboard;

import bmo5.bmo5tests.tools.FileChecker;
import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class CompanyMetadataPage extends AbstractAdmPage{


	@FindBy(css = "a[href='/companies/management/add']")
	private WebElement newButton;
	
	@FindBy(id = "search")
	private WebElement searchInputBox;
	
	@FindBy(id = "companyid")
	private WebElement companiesContainer;
	
	@FindBy(id = "companyname")
	private WebElement companyNameInputBox;
	
	@FindBy(id = "state")
	private WebElement stateContainer;
	
	@FindBy(id = "iso")
	private WebElement nationalityContainer;
	
	@FindBy(id = "all_Services")
	private WebElement allServicesContainer;
	
	@FindBy(id = "Services")
	private WebElement selectedServicesContainer;
	
	@FindBy(id = "download_service")
	private WebElement downloadServiceContainer;
	
	@FindBy(id = "export-selected-sectors")
	private WebElement exportCompaniesForSelectedSectorButton;
	
	@FindBy(css = "button[class='btn btn-block']")
	private WebElement resetFormButton;
	
	@FindBy(css = "button[type='submit']")
	private WebElement saveButton;
	
	@FindBy(css = "button[type='reset']")
	private WebElement resetButton;
	
	@FindBy(css = "label[for='companyname'][class='help-block error']")
	private WebElement errorMessageForCompanyName;
	
	@FindBy(css = "label[for='iso'][class='help-block error']")
	private WebElement errorMessageForNationality;
	
	@FindBy(id = "all_Services_rightSelected")
	private WebElement moveToRightPanelSelectedSericesArrow;
	
	@FindBy(css = "a.delete.btn")
	private WebElement deleteButton;
	
	@FindBy(css = "div[class='bootbox modal fade in'] a[class='btn btn-primary']")
	private WebElement okButtonModalWindow;
	
	@FindBy(id = "all_Services_leftAll")
	private WebElement moveAllItemsToLeftPanelButton;
	
	@FindBy(id = "download_service")
	private WebElement downloadServicesContainer;
	
	public void clickOnNewButtonAndVerify(){
		newButton.click();
		Assert.assertTrue(companyNameInputBox.isDisplayed());
		Assert.assertTrue(stateContainer.isDisplayed());
		Assert.assertTrue(nationalityContainer.isDisplayed());
		Assert.assertTrue(allServicesContainer.isDisplayed());
		Assert.assertTrue(selectedServicesContainer.isDisplayed());
		Assert.assertTrue(saveButton.isDisplayed());
		Assert.assertTrue(resetButton.isDisplayed());
	}
	
	public void clickOnSaveWithoutCompletingTheFormAndVerify(){
		saveButton.click();
		Assert.assertTrue(errorMessageForCompanyName.getText().contains("Company Name cannot be empty!"));
		Assert.assertTrue(errorMessageForNationality.getText().contains("Nationality cannot be empty!"));
	}
	
	public void clickOnResetButton(){
		resetButton.click();
	}
	
	public void completeTheFormWithoutNationalitySaveAndVerify(String companyName, String state, String service){
		int ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		String newName = companyName + ran;
		companyNameInputBox.sendKeys(newName);
		selectFromDropdown(stateContainer, state);
		selectFromDropdown(allServicesContainer, service);
		moveToRightPanelSelectedSericesArrow.click();
		saveButton.click();
		Assert.assertTrue(errorMessageForNationality.getText().contains("Nationality cannot be empty!"));
	}
	
	public String completeTheFormWithDataAndSave(String companyName, String state, String nationlity, String service){
		int ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		String newName = companyName + ran;
		companyNameInputBox.sendKeys(newName);
		selectFromDropdown(stateContainer, state);
		selectFromDropdown(nationalityContainer, nationlity);
		selectFromDropdown(allServicesContainer, service);
		moveToRightPanelSelectedSericesArrow.click();
		saveButton.click();
		return newName;
	}
	
	public void completeCompanyNameWithAnExistingOneSaveAndVerify(String companyName, String state, String nationlity, String service){
		companyNameInputBox.sendKeys(companyName);
		selectFromDropdown(stateContainer, state);
		selectFromDropdown(nationalityContainer, nationlity);
		selectFromDropdown(allServicesContainer, service);
		moveToRightPanelSelectedSericesArrow.click();
		saveButton.click();
		Assert.assertTrue(errorMessageForCompanyName.getText().contains("Please enter a new company name. This one already exists"));
	}
	
	public void insertCompanyNameInsearchInput(String companyName){
		searchInputBox.sendKeys(companyName);
		Assert.assertTrue(companiesContainer.getText().contains(companyName));
	}
	
	public void selectOneCompany(String companyName){
		selectFromDropdown(companiesContainer, companyName);
	}
	
	public void verifyCompanyData(String companyName, String state, String nationality, String service){
		Assert.assertTrue(companyNameInputBox.getAttribute("value").contains(companyName));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("select#state > option[selected]")).getAttribute("value").contains(state));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("select#iso > option[selected]")).getText().contains(nationality));
		Assert.assertTrue(selectedServicesContainer.getText().contains(service));
	}
	
	public void deleteCompany(){
		deleteButton.click();
		okButtonModalWindow.click();
	}
	
	public void verifyCompanyIsDeleted(String companyName){
		Assert.assertFalse(companiesContainer.getText().contains(companyName));
	}
	
	public void verifyPageTitle(String pageTitle){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("h5")).getText().contains(pageTitle));
	}
	
	public String editCompanyWithNewData(String companyName, String state, String nationality, String service){
		int ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		String newName = companyName + ran;
		companyNameInputBox.clear();
		companyNameInputBox.sendKeys(newName);
		selectFromDropdown(stateContainer, state);
		selectFromDropdown(nationalityContainer, nationality);
		moveAllItemsToLeftPanelButton.click();
		selectFromDropdown(allServicesContainer, service);
		moveToRightPanelSelectedSericesArrow.click();
		saveButton.click();
		return newName;
	}
	
	public void selectOneServiceToExportData(String service){
		selectFromDropdown(downloadServicesContainer, service);
	}
	
	public void clickOnExportCompaniesForSelectedSectorAndVerify(){
		exportCompaniesForSelectedSectorButton.click();
		String mainWindow = getDriver().getWindowHandle();
		getDriver().switchTo().activeElement();

		waitABit(3000);
		Keyboard keyboard = new DesktopKeyboard();
		waitABit(1000);
		keyboard.keyDown(KeyEvent.VK_ENTER);
		keyboard.keyUp(KeyEvent.VK_ENTER);

		getDriver().switchTo().window(mainWindow);
		FileChecker file = new FileChecker();
		file.verifyServiceCompanyExcelForSelectedService();
	}
}

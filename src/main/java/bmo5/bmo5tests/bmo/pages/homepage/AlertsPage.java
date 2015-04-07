package bmo5.bmo5tests.bmo.pages.homepage;


import java.util.List;

import net.thucydides.core.annotations.findby.By;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class AlertsPage extends AbstractPage{

	@FindBy(id = "uniform-select-deselect")
	private WebElement clickCheckBox;

	@FindBy(id="delete")
	private WebElement deleteButton;

	@FindBy(id = "add_alert")
	private WebElement newAlertButton;

	@FindBy(id="delete_alerts")
	private WebElement deletePopUpButton;

	@FindBy(css="div#delete-alert-modal> div:nth-child(3) a")
	private WebElement deleteReportPopUp;

	@FindBy(id="alert-title-new")
	private WebElement typeAlertName;

	@FindBy(css="button.btn.btn-primary")
	private WebElement saveButton;

	@FindBy(css =  "div.alert.alert-success")
	private WebElement errorMessage;

	@FindBy(css = "div#acc-custom-alerts > div:nth-child(1) > div:nth-child(2) > div > div  > form > div:nth-child(5) > div > div") //(id="acc-new")
	private WebElement expandGeographiesServicesCompanies;

	@FindBy(id="filter-geo")
	private WebElement searchGeographyField;

	@FindBy(css="button.btn.btn-link.btn-clear-geo")
	private WebElement clickClearButton;

	@FindBy(id="filter-companies")
	@CacheLookup
	private WebElement clickACompany;

	@FindBy(id = "new-all-companies")
	@CacheLookup
	private WebElement listOfCompanies;

	@FindBy(css = "div#acc-custom-alerts > div:nth-child(1) > div:nth-child(2) > div > div  > form > div:nth-child(5)  > div > div > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(2) > div > div:nth-child(1) > select")
	private WebElement listOfCompaniesForEditedAlert;

	@FindBy(css="button.btn.btn-link.btn-clear-comp")
	private WebElement clearCompany;

	@FindBy(css="button.btn.btn-micro.pull-right")
	@CacheLookup
	private WebElement plusServicesButton;

	@FindBy(css="div#acc-custom-alerts > div:nth-child(1) > div > div:nth-child(1) > div > span > input ")
	private WebElement selectACeckbox;

	@FindBy(css="div#acc-custom-alerts > div:nth-child(1) > div:nth-child(1) > a")
	private WebElement createdAlert;

	@FindBy(css="div#acc-custom-alerts > div:nth-child(1) > div:nth-child(2) > div > div > form > div:nth-child(2) > div > input")
	private WebElement clearAlertName;

	@FindBy (id = "new-all-countries")
	private WebElement geographyList;

	@FindBy(css="div.accordions > div:nth-child(1) > div:nth-child(2) > div > div > form >div:nth-child(5) > div > div > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > select")
	private WebElement companyList;

	@FindBy(css="div.accordion-group-container > div > div > form >  div:nth-child(4) > div > label")
	private WebElement clickStopCustomAlert;

	@FindBy(css="a[href='/alerts/pdfalerts/list']")
	private WebElement clickReportAlert;	

	@FindBy(css="div#uniform-select-deselect")
	private WebElement checkAllBoxes;

	@FindBy(css="div.accordions > div:nth-child(1) > div:nth-child(1) > div > a")
	private WebElement clickOnACreatedReportAlert;

	@FindBy(css="div#delete-alert-modal  div:nth-child(3)  a")
	private WebElement deletePopUpChooseButton;

	@FindBy(css="input#alert-title-new")
	private WebElement typeReportName;

	@FindBy(css="div#acc-new")
	@CacheLookup
	private WebElement selectGeographiseSeriesReportAlert;

	@FindBy(css="input#filter-geo")
	private WebElement containerGeographyTextArea;

	@FindBy(css="button.btn.btn-link.btn-clear-geo")
	private WebElement clearReportbutton;

	@FindBy(css="select#new-all-countries")
	private WebElement containerGeographyReportList;

	@FindBy(css="input#filter-series")
	private WebElement textAreaSeriesReport;

	@FindBy(css="select#new-all-series")
	@CacheLookup
	private WebElement containerSeriesReportList;

	@FindBy(css="button.btn.btn-link.btn-clear-series")
	private WebElement clearSeriesReport;

	@FindBy(css="div.accordion-group-container > div > div > form > div:nth-child(6) > div > a")
	private WebElement buttonCancelChangesReport;

	@FindBy(css = "a.accordion-toggle accordion-toggle-absolute")
	private WebElement clickOnCreatedReportAlert;

	@FindBy(css="div.accordion-group-container > div > div > form > div > div > label")
	private WebElement firstAlertNameTextArea;
	
	@FindBy(css="div.accordion-group-container > div > div > form > div > div > input")
	private WebElement reportAlertNameTextArea;

	@FindBy(css="div.alert.alert-success")
	private WebElement alertMessage;

	@FindBy(css="div.accordions")
	private WebElement containerReportAlerts;

	@FindBy(css="div#pdf-alerts > div:nth-child(1) > div:nth-child(1) > a")
	private WebElement reportAlert;

	@FindBy(css="a[href='/alerts/dailymacro/list']")
	private WebElement macroAlert;

	@FindBy(css = "form#daily_macro > div:nth-child(1) > div ")
	private WebElement containerMacroAlert;

	@FindBy(css="a[href='/alerts/bfs/list']")
	private WebElement bfsAlert;

	@FindBy(css = "form#daily_macro > div:nth-child(1) > div ")
	private WebElement containerBFSAlert;

	@FindBy(linkText = "Sector Alerts")
	private WebElement sectorAlert;

	@FindBy(css = "form#sector_alerts > div:nth-child(1) > div ")
	private WebElement containerSectorAlert;

	@FindBy(css = "div.accordion-group-container > div > div > form > div:nth-child(4) > div > label")
	private WebElement stopCustomAlert;

	@FindBy(css = "div.accordion-group-container > div > div > form > div:nth-child(5) > div > div > div:nth-child(1) > div:nth-child(2) > div > div:nth-child(2) > div  > div:nth-child(1) > select ")
	private WebElement geographyListExistentCustomAlerts;

	@FindBy(css = "div#acc-custom-alerts > div:nth-child(1) > div > div > a.btn.btn-small.pull-right.accordion-toggle-absolute")
	private WebElement editAlert;

	@FindBy(css = "div#pdf-alerts > div:nth-child(1) > div:nth-child(1) > div > a")
	private WebElement editReportAlert;

	@FindBy(css = "div#custom-alerts > div > form >  div:nth-child(2) > div > label:nth-child(1) > div > span > input ")
	private WebElement selectAlertFrequency;

	@FindBy(css = "div#uniform-select-deselect > span")
	private WebElement selectAllCheckBoxAlerts;

	@FindBy(css = "form#daily_macro > div:nth-child(1) > div > div:nth-child(7) > label")
	private WebElement politicsAlertOption;
	
	@FindBy(css = "div#flash-alert-message")
	private WebElement confirmationMessageChanges;
	
	@FindBy(css = "input#reset-buton")
	private WebElement cancelAlert;
	
	@FindBy(css = "div.accordion-group-container > div > div > form > div:nth-child(4) > div > label")
	private WebElement stopReportAlertOnEdit;
	
	@FindBy(css="select#ca-sort")
	private WebElement customASortByDropdown;
	
	@FindBy(css = "select#order")
	private WebElement sortByReportAlertDropdown;
	
	@FindBy(css = "form#form-new > div:nth-child(4) > div > a")
	private WebElement cancelNewCustomAlert;
	
	@FindBy(css="div.accordion-group-container > div > div > form > div:nth-child(3) > div > span:nth-child(1) > label")
	private WebElement intraDailyRadioB;
	
	@FindBy(css="div.accordion-group-container > div > div > form > div:nth-child(3) > div > span:nth-child(2) > label")
	private WebElement dailyRadioB;
	
	@FindBy(css="div.accordion-group-container > div > div > form > div:nth-child(3) > div > span:nth-child(3) > label")
	private WebElement weeklyRadioB;
	
	@FindBy(css="form#form-new > div:nth-child(2) > div > label:nth-child(2)")
	private WebElement firstFrequencyAlert;
	
	@FindBy(css="div.accordion-group-container > div > div > form >div:nth-child(3) > div > span:nth-child(1) > label)")
	private WebElement dailyReportRadio;
	
	@FindBy(css="div.accordion-group-container > div > div > form >div:nth-child(3) > div > span:nth-child(2) > label")
	private WebElement weeklyReportRadio;
	
	@FindBy(css="div#error > p")
	private WebElement errorMessageOnSavingWthoutTitle;
	
	
	public void stopCustomAlert() {
		Assert.assertTrue("Not found!", stopCustomAlert.isDisplayed());
		stopCustomAlert.click();
	}

	public void successAlertMessage() {
		Assert.assertTrue("Not found!", alertMessage.isDisplayed());
	}

	public void deleteAlertconfirmationMessage(String deleteMessage) {
		element(alertMessage).waitUntilPresent();
		Assert.assertTrue("No message is displayed!!!", alertMessage.getText().contains(deleteMessage));
	}
	
	public void deleteReportAlertconfirmationMessage(String reportDeleted) {
		element(alertMessage).waitUntilPresent();
		Assert.assertTrue("No message is displayed!!!", alertMessage.getText().contains(reportDeleted));
	}

	public void tickCustomAlertCheckbox() {
		element(getDriver().findElement(By.cssSelector("div#acc-custom-alerts > div > div > div > label[class='checkbox']"))).waitUntilPresent();
		element(getDriver().findElement(By.cssSelector("div#acc-custom-alerts > div > div > div > label[class='checkbox']"))).click();
	}

	public void clickBFSAlert(String financialAlert) {
		element(bfsAlert).waitUntilVisible();
		Assert.assertTrue("not found!", bfsAlert.getText().contains(financialAlert));
		element(bfsAlert).waitUntilVisible();
		bfsAlert.click();
	}

	public void clickMacroAlert(String macroAlerts) {
		element(macroAlert).waitUntilVisible();
		Assert.assertTrue("not found!", macroAlert.getText().contains(macroAlerts));
		macroAlert.click();
	}

	public void clickSectorAlert(String sectorAlerts) {
		element(sectorAlert).waitUntilVisible();
		Assert.assertTrue("not found!", sectorAlert.getText().contains(sectorAlerts));
		sectorAlert.click();
	}

	public void clickCancel(String value,String cancel) {
		element(cancelAlert).waitUntilVisible();
		Assert.assertTrue("not found!!!",cancelAlert.getAttribute(value).equals(cancel));
		cancelAlert.click();
	}

	public void clickReportAlert(String edit) {
		Assert.assertTrue("not found!", editReportAlert.getText().contains(edit));
		editReportAlert.click();
	}

	public void clickOnStopReport(String stopAlert) {
		waitForRenderedElementsToBePresent(By.cssSelector("div#pdf-alerts > div:nth-child(1) > div:nth-child(2) > div > div > form > div:nth-child(4) > div "));
		element(editReportAlert).waitUntilVisible();
		Assert.assertTrue("not found!",stopReportAlertOnEdit.getText().contains(stopAlert));
		stopReportAlertOnEdit.click();
	}

	public void clearReportButton(String clear) {
		element(clearReportbutton).waitUntilVisible();
		Assert.assertTrue("not found!", clearReportbutton.getText().contains(clear));
		clearReportbutton.click();
	}

	public void clearReportTextArea(String alertNameArea) {
		element(firstAlertNameTextArea).waitUntilVisible();
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("div#pdf-alerts > div:nth-child(1) > div:nth-child(2) > div > div > form > div > label")).getText().contains(alertNameArea));
		reportAlertNameTextArea.clear();
		int ran;
		ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		reportAlertNameTextArea.sendKeys("report"+ran);
	}

	public void clearReportSeriesButton(String clearSeries) {
		element(clearSeriesReport).waitUntilVisible();
		Assert.assertTrue("not found!", clearSeriesReport.getText().contains(clearSeries));
		clearSeriesReport.click();
	}

	public void clickStopAlert(String stopAlert) {
		element(clickStopCustomAlert).waitUntilVisible();
		Assert.assertTrue("not found!", clickStopCustomAlert.getText().contains(stopAlert));
		clickStopCustomAlert.click();
	}

	public void typeReportAlertGeographies(String geographySearch) {
		element(containerGeographyTextArea).waitUntilVisible();
		containerGeographyTextArea.sendKeys(geographySearch);;
	}

	public void clickOnSaveReportAlert(String save) {
		element(saveButton).waitUntilVisible();
		Assert.assertTrue("not found!!!", saveButton.getText().contains(save));
		saveButton.click();
	}

	public void clickCheckBoxesALLCheck() {
		element(getDriver().findElement(By.cssSelector("div.accordion-heading-content.table-header > div > div:nth-child(1) > div > span > label"))).waitUntilPresent();
		element(getDriver().findElement(By.cssSelector("div.accordion-heading-content.table-header > div > div:nth-child(1) > div > span > label"))).click();
		waitABit(2000);
		Assert.assertTrue("not found!", verifyElementState("document.getElementById('select-deselect')"));
	}
	public void clickCheckBoxesALLUnCheck() {
		waitABit(2000);
		element(getDriver().findElement(By.cssSelector("div.accordion-heading-content.table-header > div > div:nth-child(1) > div > span > label"))).waitUntilPresent();
		element(getDriver().findElement(By.cssSelector("div.accordion-heading-content.table-header > div > div:nth-child(1) > div > span > label"))).click();
		waitABit(2000);
		//Assert.assertTrue("not found!", verifyElementState("document.getElementByFor('select-deselect')"));
	}

	public void checkOneReportAlert() {
		element(getDriver().findElement(By.cssSelector("div#pdf-alerts >div > div > div > label[class='checkbox']"))).waitUntilPresent();
		element(getDriver().findElement(By.cssSelector("div#pdf-alerts >div > div > div > label[class='checkbox']"))).click();
	}

	public void clickOnReportAlert(String report) {
		element(clickReportAlert).waitUntilVisible();
		Assert.assertTrue("not found!", clickReportAlert.getText().contains(report));
		clickReportAlert.click();
	}

	public void clearAlertTitle() {
		element(clearAlertName).waitUntilVisible();
		clearAlertName.clear();
	}

	public void clickOnClearCompany() {
		element(clearCompany).waitUntilVisible();
		clearCompany.click();

	}

	public void addANewAlert() {
		element(newAlertButton).waitUntilVisible();
		newAlertButton.click();
	}

	public void clickOnAvailableAlert() {
		element(editAlert).waitUntilVisible();
		editAlert.click();
	}

	public void typeFirstThreeLettersCompany(String companySearch) {
		element(clickACompany).waitUntilVisible();
		clickACompany.sendKeys(companySearch);
	}

	public void typeFirstThreeLettersGeography(String regionSearch) {
		element(searchGeographyField).waitUntilVisible();
		searchGeographyField.sendKeys(regionSearch);
	}

	public void clickOnClear(String clearGeographies) {
		element(clickClearButton).waitUntilVisible();
		Assert.assertTrue("not found!", clickClearButton.getText().contains(clearGeographies));
		clickClearButton.click();
	}

	public void saveAlert(String save) {
		element(saveButton).waitUntilVisible();
		Assert.assertTrue("not found!", saveButton.getText().contains(save));
		saveButton.click();

	}

	public void verifySaveReportAlertMessage (String saveReportMessage) {
		element(confirmationMessageChanges).waitUntilVisible();
		Assert.assertTrue("The alert's message couldn't been verified!", confirmationMessageChanges.getText().contains(saveReportMessage));
	}
	
	public void verifySaveEditReportAlertMessage(String editReportMessage) {
		Assert.assertTrue("The alert's message couldn't been verified!",confirmationMessageChanges.getText().contains(editReportMessage));
	}
	
	public void clickPlusButton() {
		element(plusServicesButton).waitUntilVisible();
		plusServicesButton.click();;
	}

	public void typeSeriesReportText(String seriesSearch) {
		element(textAreaSeriesReport).waitUntilVisible();
		textAreaSeriesReport.sendKeys(seriesSearch);
	}

	public void typeAlertNameField() {
		int ran;
		ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		element(typeAlertName).waitUntilVisible();
		typeAlertName.sendKeys("alert" + ran);
		waitABit(5000);
	}

	public void typeNameReportContainer(String textPdfArea) {
		element(typeReportName).waitUntilVisible();
		typeReportName.sendKeys(textPdfArea);
	}

	public void typeValidReportName(String textArea) {
		element(typeReportName).waitUntilVisible();
		int ran;
		ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		typeReportName.sendKeys("reportAlert"+ran);
	}

	public void clickDeletePopUp() {
		element(deletePopUpButton).waitUntilVisible();
		deletePopUpButton.click();
		waitABit(3000);
	}
	
	public void clickDeleteReportPopUp() {
		element(deletePopUpButton).waitUntilVisible();
		deletePopUpButton.click();
	}

	public void clickDelete() {
		element(deleteButton).waitUntilVisible();
		deleteButton.click();
	}
	
	public void clickCheckBox() {
		element(getDriver().findElement(By.cssSelector("div#uniform-select-deselect > span > input"))).waitUntilVisible();
		element(getDriver().findElement(By.cssSelector("div#uniform-select-deselect > span > input"))).click();
	}
	
	
	public void alertSortBy(String value,String alpha){
		selectFromDropdown(customASortByDropdown, alpha);
		waitABit(3000);
		Assert.assertTrue("SortBy is not working for Custom Alerts!!!", getDriver().findElement(By.cssSelector("select#ca-sort > option[selected='selected']")).getText().contains(alpha));
	}
	
	public void reportAlertSortBy(String alpha){
		selectFromDropdown(sortByReportAlertDropdown, alpha);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("select#order > option[selected='selected']")).getText().contains(alpha));
	}

	public void cancelAlert(String element){
		Assert.assertTrue("not found", cancelNewCustomAlert.isDisplayed());
		cancelNewCustomAlert.click();
	}

	public void selectGeographiesOptionsAlert(String textName){
		waitABit(7000);
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("div#custom-alerts > div > form > div:nth-child(3) > div > div > div:nth-child(1) > div:nth-child(1) > a ")).getText().contains(textName));
		getDriver().findElement(By.cssSelector("div#custom-alerts > div > form > div:nth-child(3) > div > div > div:nth-child(1) > div:nth-child(1) > a > span:nth-child(1)")).click();
		waitABit(5000);
	}

	public void selectGeographiesForEditCustomAlert(String textName){
		waitABit(7000);
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("div#acc-custom-alerts > div:nth-child(1) > div:nth-child(2)> div > div > form > div:nth-child(5) > div > div > div:nth-child(1)  > div:nth-child(1) > a ")).getText().contains(textName));
		getDriver().findElement(By.cssSelector("div#acc-custom-alerts > div:nth-child(1) > div:nth-child(2)> div > div > form > div:nth-child(5) > div > div > div:nth-child(1)  > div:nth-child(1) > a > span:nth-child(1)")).click();
		waitABit(5000);
	}

	public void selectGeographiesForNewAlert(String textName) {
		element(getDriver().findElement(By.cssSelector("div#acc-new > div:nth-child(1) > div:nth-child(1) > a > span:nth-child(1)"))).waitUntilPresent();
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("div#acc-new > div:nth-child(1) > div:nth-child(1) > a")).getText().contains(textName));
		evaluateJavascript("$(\"div#acc-new > div:nth-child(1) > div:nth-child(1) > a > span\").click();");
		waitABit(5000);
	}

	public void selectServiceOptionsAlerts(String textService) {
		element(getDriver().findElement(By.cssSelector("div#acc-new > div:nth-child(2) > div:nth-child(1) > a > span:nth-child(1)"))).waitUntilPresent();
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("div#acc-new > div:nth-child(2) > div:nth-child(1) > a ")).getText().contains(textService));
		evaluateJavascript("$(\"div#acc-new > div:nth-child(2) > div:nth-child(1) > a > span:nth-child(1)\").click();");
		waitABit(5000);
	}

	public void selectServiceOptionsEditAlerts(String textService) {
		element (getDriver().findElement(By.cssSelector("div#acc-custom-alerts > div:nth-child(1) > div:nth-child(2) > div > div > form > div:nth-child(5) > div > div > div:nth-child(2) > div:nth-child(1) > a > span"))).waitUntilPresent();
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("div#acc-custom-alerts > div:nth-child(1) > div:nth-child(2) > div > div > form > div:nth-child(5) > div > div > div:nth-child(2) > div:nth-child(1) > a  ")).getText().contains(textService));
		evaluateJavascript("$(\"div#acc-custom-alerts > div:nth-child(1) > div:nth-child(2) > div > div > form > div:nth-child(5) > div > div > div:nth-child(2) > div:nth-child(1) > a > span\").click();");
		waitABit(5000);
	}

	public void selectCompanyOptionsEditAlerts(String textCompanies) {
		element(getDriver().findElement(By.cssSelector("div#acc-custom-alerts > div:nth-child(1) > div:nth-child(2) > div > div > form > div:nth-child(5) > div > div > div:nth-child(3) > div:nth-child(1) > a > span"))).waitUntilPresent();
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("div#acc-custom-alerts > div:nth-child(1) > div:nth-child(2) > div > div > form > div:nth-child(5) > div > div > div:nth-child(3) > div:nth-child(1) > a ")).getText().contains(textCompanies));
		evaluateJavascript("$(\"div#acc-custom-alerts > div:nth-child(1) > div:nth-child(2) > div > div > form > div:nth-child(5) > div > div > div:nth-child(3) > div:nth-child(1) > a > span\").click();");
		waitABit(5000);
	}

	public void selectCompanyOptionsAlerts(String textCompanies) {
		element(getDriver().findElement(By.cssSelector("div#acc-new > div:nth-child(3) > div:nth-child(1) > a > span:nth-child(1)"))).waitUntilPresent();
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("div#acc-new > div:nth-child(3) > div:nth-child(1) > a ")).getText().contains(textCompanies));
		evaluateJavascript("$(\"div#acc-new > div:nth-child(3) > div:nth-child(1) > a > span:nth-child(1)\").click();");
		waitABit(5000);
	}

	public void selectGeographiesdReportAlert(String element){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#acc-new > div:nth-child(1) > div:nth-child(1) > a")).getText().contains(element));
		getDriver().findElement(By.cssSelector("div#acc-new > div:nth-child(1) > div:nth-child(1) > a")).click();
	}

	public void selectSeriesReportAlert(String series){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#acc-new > div:nth-child(2) > div:nth-child(1) > a")).getText().contains(series));
		getDriver().findElement(By.cssSelector("div#acc-new > div:nth-child(2) > div:nth-child(1) > a")).click();
	}

	public void selectAGeography(String element){
		element(geographyList).waitUntilVisible();
		List<WebElement> allElements = geographyList.findElements(By.tagName("option"));
		for (WebElement geography : allElements) {
			if (geography.getText().equals(element)) {
				geography.click();
				break;
			}
		}
	}

	public void selectAGeographyFromCreatedCustomAlerts(String element){
		element(geographyListExistentCustomAlerts).waitUntilVisible();
		List<WebElement> allElements = geographyListExistentCustomAlerts.findElements(By.tagName("option"));
		for (WebElement geography : allElements) {
			if (geography.getText().equals(element)) {
				geography.click();
				break;
			}
		}
		List<WebElement> moveButtonList = getVisibleMoveButtons();
		System.out.println("selected regions");
		moveButtonList.get(1).click();
	}

	public void selectAService(String searchForService,String element){
		element(getDriver().findElement(By.cssSelector("ul#services_move_remove > li:nth-child(1) > input "))).waitUntilVisible();
		getDriver().findElement(By.cssSelector("ul#services_move_remove > li:nth-child(1) > input ")).sendKeys(searchForService);
		element(getDriver().findElement(By.cssSelector("ul#services_move_remove > li > ul"))).waitUntilVisible();
		WebElement containerServiceList = getDriver().findElement(By.cssSelector("ul#services_move_remove > li > ul"));
		element(containerServiceList).waitUntilVisible();

		List<WebElement> allElements = containerServiceList.findElements(By.tagName("label"));
		for (WebElement service : allElements) {
			if (service.getText().equals(element)) {
				service.click();
				break;
			}
		}
	}

	public void selectACompany(String element){
		element(listOfCompaniesForEditedAlert).waitUntilVisible();
		List<WebElement> allElements = listOfCompaniesForEditedAlert.findElements(By.tagName("option"));
		for (WebElement company : allElements) {
			if (company.getText().equals(element)) {
				company.click();
				waitABit(5000);
				break;
			}
		}
		List<WebElement> moveButtonList = getVisibleMoveButtons();
		moveButtonList.get(1).click();
	}

	public void selectACompanyForNewAlerts(String element){
		element(listOfCompanies).waitUntilVisible();
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("select#new-all-companies")).isDisplayed());
		int counterComp = getDriver().findElements(By.cssSelector("select#new-all-companies")).size();
		System.out.println("the list size is :" + counterComp);
		List<WebElement> allElements = listOfCompanies.findElements(By
				.tagName("option"));

		for (WebElement company : allElements) {
			if (company.getText().equals(element)) {
				company.click();
				waitABit(5000);
				break;
			}
		}
		List<WebElement> moveButtonList = getVisibleMoveButtons();
		moveButtonList.get(1).click();
		int countCompAfter = getDriver().findElements(By.cssSelector("select#new-all-companies")).size();
		Assert.assertTrue("Button not clicked!",countCompAfter == counterComp );
	}

	public void selectAreportAlert(){
		element(clickOnACreatedReportAlert).waitUntilVisible();
		WebElement alert = getDriver().findElement(By.cssSelector("div.accordions > div:nth-child(1) > div:nth-child(1) > div > a"));
		alert.click();
	}
	
	public void selectRadioButtonsAlert(int radioButtonIntra, int radButtonDaily, int radButtonWeekly){
		if(getDriver().findElement(By.cssSelector("div.accordion-group-container > div > div > form > div:nth-child(3) > div > span:nth-child(1) > input:nth-child(1)")).getAttribute("value").equals("9"))
		{
			weeklyRadioB.click(); 
			dailyRadioB.click(); 
		}
		else if (getDriver().findElement(By.cssSelector("div.accordion-group-container > div > div > form > div:nth-child(3) > div > span:nth-child(2) > input:nth-child(1)")).getAttribute("value").equals("1"))
		{
			intraDailyRadioB.click(); 
			weeklyRadioB.click();
		}
		else if (getDriver().findElement(By.cssSelector("div.accordion-group-container > div > div > form > div:nth-child(3) > div > span:nth-child(3) > input:nth-child(1)")).getAttribute("value").equals("2"))
		{
			intraDailyRadioB.click(); 
			dailyRadioB.click();
		}
	}

	public void checkFirstFrequency () {
		firstFrequencyAlert.click();
		Assert.assertTrue("not found!",verifyElementState("document.getElementById('frequency-new-intra-daily')"));
	}

	public void selectRadioButtonsReportAlert(){
		if (getDriver().findElement(By.cssSelector("div.accordion-group-container > div > div > form >div:nth-child(3) > div > span:nth-child(1) > input")).getAttribute("value").equals("-1")) {
			weeklyReportRadio.click();
		}
		else if (getDriver().findElement(By.cssSelector("div.accordion-group-container > div > div > form >div:nth-child(3) > div > span:nth-child(1) > input")).getAttribute("value").equals("-7")){
			dailyReportRadio.click();
		}
	}

	public void selectRadioButtonsNewReportAlert(int radButtonDaily, int radButtonWeekly){
		getDriver().findElement(By.cssSelector("div#custom-alerts > div > div > form > div:nth-child(2) > div > div > label:nth-child("+radButtonDaily+")")).click();
		waitABit(2000);
		Assert.assertTrue("not found!", verifyElementState("document.getElementById('frequency')"));
	}

	private List<WebElement> getVisibleMoveButtons(){
		List<WebElement> moveButtonGroupList = getDriver().findElements(By.cssSelector("div.btn-multiselect-group"));
		WebElement moveButtonGroup = moveButtonGroupList.get(0);
		for (WebElement elem : moveButtonGroupList){
			if (element(elem).isVisible()) {
				moveButtonGroup = elem;
				break;
			}
		}
		return element(moveButtonGroup).findElements(By.cssSelector("button"));
	}

	public void selectGeographyFromList(String element){
		element(geographyList).waitUntilVisible();
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("select#new-all-countries")).isDisplayed());
		int counterGeo = getDriver().findElements(By.cssSelector("select#new-all-countries > option")).size();
		System.out.println(counterGeo);
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("div#geographies_move_remove")).isDisplayed());
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("select#new-selected-countries")).isDisplayed());
		System.out.println("in selectGeographyFromList");
		List<WebElement> allElements = geographyList.findElements(By.tagName("option"));

		for (WebElement region : allElements) {
			if (region.getText().equals(element)) {
				region.click();
				waitABit(5000);
				break;
			}
		}
		List<WebElement> moveButtonList = getVisibleMoveButtons();
		moveButtonList.get(1).click();
		element(getDriver().findElement(By.cssSelector("select#new-selected-countries"))).waitUntilPresent();
		waitABit(5000);
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("select#new-selected-countries")).getText().contains(element) );
		int counterAfterMovingGeo = getDriver().findElements(By.cssSelector("select#new-all-countries > option")).size();
		System.out.println(counterAfterMovingGeo);
		Assert.assertTrue("not found the counter list!!!",counterGeo == counterAfterMovingGeo   +1);
	}

	public void typeAlertTextField(String testName){
		element(clearAlertName).waitUntilVisible();
		clearAlertName.sendKeys(testName);
	}

	public void containerPopUpButtons(){
		element(deletePopUpChooseButton).waitUntilVisible();
		deletePopUpChooseButton.click();
	}

	public void selectGeographyFromReportList(String element){
		element(containerGeographyReportList).waitUntilVisible();
		int counterGeo = getDriver().findElements(By.cssSelector("select#new-all-countries > option")).size();
		System.out.println(counterGeo);
		List<WebElement> allElements = containerGeographyReportList.findElements(By
				.tagName("option"));

		for (WebElement region : allElements) {
			if (region.getText().equals(element)) {
				region.click();
				break;
			}
		}
		List<WebElement> moveButtonList = getVisibleMoveButtons();
		moveButtonList.get(1).click();
		int counterAfterMovingGeo = getDriver().findElements(By.cssSelector("select#new-all-countries > option")).size();
		System.out.println(counterAfterMovingGeo);	
		waitABit(2000);
	}

	public void selectSeriesFromReportList(String element){
		element(containerSeriesReportList).waitUntilVisible();
		Select selectSeries = new Select(getDriver().findElement(By.id("new-all-series")));
		selectSeries.selectByVisibleText(element);
		List<WebElement> moveButtonList = getVisibleMoveButtons();
		moveButtonList.get(1).click();
	}

	public void selectAlertsFromReportList(){
		element(clickOnCreatedReportAlert).waitUntilVisible();
		clickOnCreatedReportAlert.click();
	}

	public void selectCancel(){
		element(buttonCancelChangesReport).waitUntilVisible();
		buttonCancelChangesReport.click();
	}

	public void selectReportAlertsList() {
		element(containerReportAlerts).waitUntilVisible();
		List<WebElement> allElements = containerReportAlerts.findElements(By.cssSelector("div:nth-child(1) div a"));

		for (WebElement region : allElements) {
			if (region.isSelected()) {
				region.click();
				break;
			}
		}
	}

	public void containerMacro(String value){
		if (getDriver().findElement(By.cssSelector("form#daily_macro > div:nth-child(1) > div ")).isDisplayed()) {
			getDriver().findElement(By.cssSelector("form#daily_macro > div:nth-child(1) > div > div:nth-child("+ value +") > label")).click();
		} else
		{
			System.out.println("There is no option available!");
		}
	}

	public void containerSectorAlerts(String value){
		waitABit(3000);
		if (getDriver().findElement(By.cssSelector("form#sector_alerts > div:nth-child(1) > div ")).isDisplayed()) {
			getDriver().findElement(By.cssSelector("form#sector_alerts > div:nth-child(1) > div > div:nth-child("+ value +") > label")).click();
		} else
		{
			System.out.println("There is no option available!");
		}
	}

	public void containerFinancialMarketsAlerts(String value){
		waitABit(3000);
		if (getDriver().findElement(By.cssSelector("form#sector_alerts > div:nth-child(2) > div ")).isDisplayed()) {
			getDriver().findElement(By.cssSelector("form#sector_alerts > div:nth-child(2) > div > div:nth-child("+ value +") > label")).click();
		} else
		{
			System.out.println("There is no option available!");
		}
	}

	public void verifyDailyMacroConfirmationMessage(String value) {
		element(confirmationMessageChanges).waitUntilVisible();
		Assert.assertTrue ("not found!",confirmationMessageChanges.getText().contains("Changes to Daily Macro Alerts have been successfully saved."));
		waitABit(4000);
		if (getDriver().findElement(By.cssSelector("form#daily_macro > div:nth-child(1) > div > div:nth-child("+value +") > input")).isDisplayed()) {
			Assert.assertTrue("not checked!", getDriver().findElement(By.cssSelector("form#daily_macro > div:nth-child(1) > div > div:nth-child("+value +") > input ")).getAttribute("checked").contains("checked"));
		} 
	}

	public void verifySectorAlertsConfirmationMessage(String value) {
		element(confirmationMessageChanges).waitUntilVisible();
		Assert.assertTrue ("not found!",confirmationMessageChanges.getText().contains("Changes to Sector Alerts have been successfully saved."));
		waitABit(3000);
		if (getDriver().findElements(By.cssSelector("form#sector_alerts > div:nth-child(1) > div:nth-child(1) > div:nth-child("+value +") > input[checked='checked'] ")).size() == 1) {
			waitABit(3000);
				Assert.assertTrue("not found!", verifyElementState("document.getElementById('sector-Autos')"));
		} 
		else 
			{
			getDriver().findElement(By.cssSelector("form#sector_alerts > div:nth-child(1) > div:nth-child(1) > div:nth-child("+value +") > label")).click();
			waitABit(3000);
			Assert.assertTrue("not found!", verifyElementState("document.getElementById('sector-Autos')"));
			}
	}

	public void verifyFinancialMarketsAlertsConfirmationMessage(String value,String valueFMA) {
		element(confirmationMessageChanges).waitUntilVisible();
		Assert.assertTrue ("not found!",confirmationMessageChanges.getText().contains("Changes to Financial Markets Alerts have been successfully saved."));
		if (getDriver().findElements(By.cssSelector("form#sector_alerts > div:nth-child(2) > div:nth-child(1) > div:nth-child("+value +") > input[checked ='checked'] ")).size() == 1) {
			waitABit(3000);
			Assert.assertTrue("not found!", verifyElementState("document.getElementById('"+valueFMA+"')"));
		} 
		else 
			{
				getDriver().findElement(By.cssSelector("form#sector_alerts > div:nth-child(2) > div:nth-child(1) > div:nth-child("+value +") > label")).click();
				Assert.assertTrue("not found!", verifyElementState("document.getElementById('bfs-1319')"));
			}
	}

	public void verifyCustumAlertsAreEmptyForSecondChildEnterpriseUser(){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div#acc-custom-alerts > div")).size() == 0);
	}

	public void verifyReportAlertsAreEmptyForSecondChildEnterpriseUser(){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div.accordions > div")).size() == 0);
	}

	public void deleteAllCustomAlerts(){
		if(getDriver().findElements(By.cssSelector("div#acc-custom-alerts > div")).size() == 0){
			System.out.println("There is no alert in the list");
		}
		else{
			element(getDriver().findElement(By.cssSelector("input#select-deselect"))).waitUntilVisible();
			element(getDriver().findElement(By.cssSelector("input#select-deselect"))).click();
			element(deleteButton).waitUntilVisible();
			deleteButton.click();
			element(deleteReportPopUp).waitUntilVisible();
			deleteReportPopUp.click();
		}
	}

	public void deleteAllReportAlerts(){
		if(getDriver().findElements(By.cssSelector("div.accordions > div")).size() == 0){
			System.out.println("There is no alert in the list");
		}
		else{
			element(getDriver().findElement(By.cssSelector("input#select-deselect"))).waitUntilVisible();
			element(getDriver().findElement(By.cssSelector("input#select-deselect"))).click();
			element(deleteButton).waitUntilVisible();
			deleteButton.click();
			element(deleteReportPopUp).waitUntilVisible();
			deleteReportPopUp.click();
		}
	}
	
	public void verifyPoliticsInDailyMacroAlerts(String politic) {
		Assert.assertTrue("Politics is not in the list!!!", politicsAlertOption.getText().contains(politic));
	}
	
	public void saveCustomReportAlertverifyErrorMessage(String error) {
		errorMessageOnSavingWthoutTitle.getText().contains(error);
	}
}


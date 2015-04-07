package bmo5.bmo5tests.bmo.pages.pillarPages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class BMIDatabasesKeyProjectsPage extends AbstractPage{

	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) > h5")
	private WebElement geographyToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(1) > h5")
	private WebElement companyToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) > h5")
	private WebElement statusToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(3) > h5")
	private WebElement startDateToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(4) > h5")
	private WebElement endDateToggler;

	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(5) > h5")
	private WebElement sectorToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(5) > h5")
	private WebElement valuesToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-of-type(6) > h5")
	private WebElement capacityToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-of-type(7) > h5")
	private WebElement fuelTypeToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-of-type(7) > h5")
	private WebElement renewablesSectorToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) > h5 > span > i")
	private WebElement arrowGeographyToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(1) > h5 > span > i")
	private WebElement arrowCompanyToggler;

	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(3) > h5 > span > i")
	private WebElement arrowStartDateToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(4) > h5 > span > i")
	private WebElement arrowEndDateToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) > h5 > span > i")
	private WebElement arrowStatusToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(5) > h5 > span > i")
	private WebElement arrowSectorToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(5) > h5 > span > i")
	private WebElement arrowValuesToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-of-type(6) > h5 > span > i")
	private WebElement arrowCapacityToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-of-type(7) > h5 > span > i")
	private WebElement arrowFuelTypeToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-of-type(7) > h5 > span > i")
	private WebElement arrowRenewablesSectorToggler;
	
	@FindBy(css = "button#filter-download-data")
	private WebElement downloadButton;
	
	@FindBy(css = "button#filter-display-data")
	private WebElement displayDataButton;
	
	@FindBy(css = "a#filter-clear")
	private WebElement clearFiltersLink;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4)  ul > li:nth-child(1) > input")
	private WebElement inputBoxGeographySection;
	
	@FindBy(css = "button#db-dd")
	private WebElement filterToggler;
	
	@FindBy(css = "select#start_date_operator")
	private WebElement startDateOperatorsContainer;
	
	@FindBy(css = "select#start_date")
	private WebElement startDateContainer;
	
	@FindBy(css = "select#end_date_operator")
	private WebElement endDateOperatorsContainer;
	
	@FindBy(css = "select#end_date")
	private WebElement endDateContainer;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(5)  ul > li:nth-child(1) > input")
	private WebElement inputBoxSectorSection;
	
	@FindBy(css = "input#from_value")
	private WebElement fromBoxValuesSection;
	
	@FindBy(css = "input#to_value")
	private WebElement toBoxValuesSection;
	
	@FindBy(css = "ul.breadcrumb > li:nth-of-type(5)")
	private WebElement databaseBreadcrumb;
	
	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li:nth-child(4) > h5")
	private WebElement containerGeographyFilter;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(3) > h5")
	private WebElement containerStartDate;
	
	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li:nth-child(4)  > ul")
	private WebElement containerGeographyList;
	
	@FindBy(id = "start_date_operator")
	private WebElement startDateFilterDropDown;
	
	@FindBy(css = "button#dbfilter-clear")
	private WebElement resetFiltersButton;
	
	@FindBy(css = "button#filter-db-button")
	private WebElement filterButton;
	
	@FindBy(css = "select#capacity_size")
	private WebElement sizeContainer;
	
	@FindBy(css = "input#from_value_capacity")
	private WebElement fromInputBoxCapacity;
	
	@FindBy(css = "input#to_value_capacity")
	private WebElement toInputBoxCapacity;
	
	@FindBy(css = "select#fuel_type")
	private WebElement fuelTypeContainer;

	@FindBy(css="ul.nav.nav-list.dropdown-list.user-journey > li:last-child > label")
	private WebElement projectNameRadiobutton;
	
	@FindBy(css="div.modal-footer > button:last-child")
	private WebElement okButton;
	
	@FindBy(css="input#project_name")
	private WebElement projectNameInput;
	
	public void clickOnGeography () {
		containerGeographyFilter.click();
	}
	public void clickOnStartDate () {
		containerStartDate.click();
	}
	public void clickOnStartDateDropdown() {
		Select date = new Select(startDateFilterDropDown);
		date.selectByVisibleText("After");
	}
	public void selectAGeographyFromFilter(String geography) {
		element(containerGeographyList).waitUntilVisible();
		List<WebElement> itemsList = containerGeographyList.findElements(By.cssSelector("li > label"));
		
		for(WebElement elementNow:itemsList){
			System.out.println(elementNow.getText());
			if(elementNow.getText().contains(geography)){
				elementNow.click();
				System.out.println("selected!!!");
				break;
			}
		}
	}
	
	public void clickOnOneDatabase(String databaseName){
		int numberOfRows = getDriver().findElements(By.cssSelector("article.span10 > div")).size();
		for(int i=1; i<= numberOfRows; i++){
			int numberOfElementsPerColumn = getDriver().findElements(By.cssSelector("article.span10 > div:nth-child(" + i + ") > div")).size();
			for(int j=1; j<=numberOfElementsPerColumn; j++){
				System.out.println(getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(" + i + ") > div:nth-child(" + j + ") > h4 > a")).getText());
				if(getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(" + i + ") > div:nth-child(" + j + ") > h4 > a")).getText().contains(databaseName)){
					getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(" + i + ") > div:nth-child(" + j + ") > h4 > a")).click();
					break;
				}
			}
		}
	}
	
	public void verifyIfElementsArePresentAfterAccessingDatabases(){
		Assert.assertTrue(geographyToggler.isDisplayed());
		Assert.assertTrue(arrowGeographyToggler.getAttribute("class").contains("down"));
		Assert.assertTrue(clearFiltersLink.isDisplayed());
		Assert.assertTrue(downloadButton.isDisplayed());
		Assert.assertTrue(displayDataButton.isDisplayed());
	}
	
	public void insertLettersInInputBoxFromGeographySection(String letters){
		inputBoxGeographySection.sendKeys(letters);
		Sleeper.sleepTight(2000);
		int numberOfContinents = getDriver().findElements(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li ")).size() - 1; 
		System.out.println(numberOfContinents);
		boolean contains = false;
		for(int i=1; i<=numberOfContinents; i++){
			int j = i+1;
			if(getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li:nth-child(" + j + ") > label")).getText().contains(letters)){
				contains = true;
				System.out.println(getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li:nth-child(" + j + ") > label")).getText());
			}
			else{
				contains = false;
				System.out.println("There are aditional elements.");
				Assert.assertTrue(contains);
				break;
			}
			int numberOfRegionsFromOneCountry = getDriver().findElements(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li:nth-child(" + j + ") > ul > li")).size(); 
			for(int k=1; k<=numberOfRegionsFromOneCountry; k++){
				if(getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li:nth-child(" + j + ")> ul > li:nth-child(" + k + ")")).getAttribute("style").contains("none")){
					continue;
				}
				else if(getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li:nth-child(" + j + ") > ul > li:nth-child(" + k + ") > label")).getText().contains(letters)){
					contains = true;
					System.out.println(getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li:nth-child(" + j + ") > ul > li:nth-child(" + k + ") > label")).getText());
				}
				else{
					contains = false;
					System.out.println("There are aditional elements.");
					System.out.println(getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li:nth-child(" + j + ") > ul > li:nth-child(" + k + ") > label")).getText());
					Assert.assertTrue(contains);
					break;
				}
			}
		}
	}
	
	public void verifyDatabaseBreadcrumb(String databaseName){
		Assert.assertTrue(databaseBreadcrumb.getText().contains(databaseName));
	}
	
	public void checkAllElementsFromGeographySectionAndVerify(){
		int numberOfContinents = getDriver().findElements(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li")).size() - 1; //[style='display: list-item;']
		System.out.println(numberOfContinents);
		int i,j;
		for(i=1; i<=numberOfContinents; i++){
			j =i+1;
			getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li:nth-child(" + j + ") label")).click();
		}                                     
	}
	
	
	public void clickOnStartDateToggler(){
		startDateToggler.click();
		Assert.assertTrue(arrowStartDateToggler.getAttribute("class").contains("down"));
	}
	
	public void selectOneOperatorFromStartDateSection(String operator){
		selectFromDropdown(startDateOperatorsContainer, operator);
	}
	
	public void selectOneYearFromStartDateDropDownList(String year){
		if(startDateContainer.getText().contains(year)){
			selectFromDropdown(startDateContainer, year);
		}
	}
	
	public void clickOnEndDateToggler(){
		endDateToggler.click();
		Assert.assertTrue(arrowEndDateToggler.getAttribute("class").contains("down"));
	}
	
	public void selectOneOperatorFromEndDateSection(String operator){
		selectFromDropdown(endDateOperatorsContainer, operator);
	}
	
	public void selectOneYearFromEndDateDropDownList(String year){
		if(endDateContainer.getText().contains(year)){
			selectFromDropdown(endDateContainer, year);
		}
	}
	
	public void clickOnStatusToggler(){
		statusToggler.click();
		Assert.assertTrue(arrowStatusToggler.getAttribute("class").contains("down"));
	}
	
	public void checkOneStatus(String status){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) > ul > li label[title='" + status + "']")).size() ==1){
			getDriver().findElement(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) > ul > li label[title='" + status + "']")).click();
		}
	}
	
	public String returnTheStatusId(String status){
		String idStatus = null;
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) > ul > li label[title='" + status + "']")).size() ==1){
			idStatus = getDriver().findElement(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) > ul > li label[title='" + status + "']")).getAttribute("for");
		}
		return idStatus;
	}
	
	public void verifyStatusIsChecked(String status){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) > ul > li label[title='" + status + "']")).size() ==1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + status + "'"));
		}
	}
	
	public void verifyIfStatusIsUnchecked(String status){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) > ul > li label[title='" + status + "']")).size() ==1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + status + "'"));
		}
	}
	
	public void clickOnSectorToggler(){
		sectorToggler.click();
		Assert.assertTrue(arrowSectorToggler.getAttribute("class").contains("down"));
	}
	
	public void insertLettersInInputBoxSectorSection(String letters){
		inputBoxSectorSection.sendKeys(letters);
		Sleeper.sleepTight(2000);
		int numberOfContinents = getDriver().findElements(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li ")).size() - 1; 
		System.out.println(numberOfContinents);
		boolean contains = false;
		for(int i=1; i<=numberOfContinents; i++){
			int j = i+1;                              
			if(getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li:nth-child(" + j + ") > label")).getText().contains(letters)){
				contains = true;
				System.out.println(getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li:nth-child(" + j + ") > label")).getText());
			}
			else{
				contains = false;
				System.out.println("There are aditional elements.");
				Assert.assertTrue(contains);
				break;
			}
			int numberOfRegionsFromOneCountry = getDriver().findElements(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li:nth-child(" + j + ") > ul > li")).size(); 
			System.out.println(numberOfRegionsFromOneCountry);
			for(int k=1; k<=numberOfRegionsFromOneCountry; k++){
				if(getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li:nth-child(" + j + ")> ul > li:nth-child(" + k + ")")).getAttribute("style").contains("none")){
					continue;
				}
				else if(getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li:nth-child(" + j + ") > ul > li:nth-child(" + k + ") > label")).getText().contains(letters)){
					contains = true;
					System.out.println(getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li:nth-child(" + j + ") > ul > li:nth-child(" + k + ") > label")).getText());
				}
				else{
					contains = false;
					System.out.println("There are aditional elements.");
					System.out.println(getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li:nth-child(" + j + ") > ul > li:nth-child(" + k + ") > label")).getText());
					Assert.assertTrue(contains);
					break;
				}
			}
		}
	}
	
	public void checkOneItemFromSector(String sector){
		if(getDriver().findElements(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li label[title='" + sector + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li label[title='" + sector + "']")).click();
		}
	}
	
	public String returnTheSectorId(String sector){
		String sectorId = null;
		if(getDriver().findElements(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li label[title='" + sector + "']")).size() == 1){
			sectorId = getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li label[title='" + sector + "']")).getAttribute("for");
		}
		return sectorId;
	}
	
	public void verifyIfSectorIsChecked(String sector){
		if(getDriver().findElements(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li label[title='" + sector + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + sector + "')"));
		}
	}
	
	public void verifyIfSectorIsNotChecked(String sector){
		if(getDriver().findElements(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li label[title='" + sector + "']")).size() == 1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + sector + "')"));
		}
	}
	
	public void checkAllElementsFromSectorSectionAndVerify(){
		int numberOfContinents = getDriver().findElements(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li")).size() - 1; 
		int i,j;
		boolean isChecked = false;
		for(i=1; i<=numberOfContinents; i++){
			j =i+1;
			getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li:nth-child(" + j + ") > label > div > span")).click();
		}
		for(i=1; i<=numberOfContinents; i++){
			j = i+1;
			if(getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li:nth-child(" + j + ") > label > div > span")).getAttribute("class").contains("checked")){
				isChecked = true;
			}
			else{
				isChecked = false;
				System.out.println("There are aditional elements.");
				Assert.assertTrue(isChecked);
				break;
			}
		}
	}
	
	public void uncheckAllElementsFromSectorSectionAndVerify(){
		int numberOfContinents = getDriver().findElements(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li")).size() - 1; 
		int i,j;
		boolean isChecked = false;
		for(i=1; i<=numberOfContinents; i++){
			j =i+1;
			getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li:nth-child(" + j + ") > label > div > span")).click();
		}
		for(i=1; i<=numberOfContinents; i++){
			j = i+1;
			if(getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li:nth-child(" + j + ") > label > div > span")).getAttribute("class").isEmpty()){
				isChecked = true;
			}
			else{
				isChecked = false;
				System.out.println("There are aditional elements.");
				Assert.assertTrue(isChecked);
				break;
			}
		}
	}
	
	public void clickOnValuesToggler(){
		valuesToggler.click();
		Assert.assertTrue(arrowValuesToggler.getAttribute("class").contains("down"));
	}
	
	public void completeFieldsValuesSection(String fromInput, String toInput ){
		fromBoxValuesSection.sendKeys(fromInput);
		toBoxValuesSection.sendKeys(toInput);
	}
	
	public void verifyTheFieldsFromValuesSection(String fromInput, String toInput){
		Assert.assertTrue(fromBoxValuesSection.getAttribute("value").contains(fromInput));
		Assert.assertTrue(toBoxValuesSection.getAttribute("value").contains(toInput));
	}
	
	public void clickOnCapacityToggler(){
		capacityToggler.click();
		Assert.assertTrue(arrowCapacityToggler.getAttribute("class").contains("down"));
	}
	
	public void completeFieldsFromCapacitySection(String size, String fromCapacity, String toCapacity){
		selectFromDropdown(sizeContainer, size);
		fromInputBoxCapacity.sendKeys(fromCapacity);
		toInputBoxCapacity.sendKeys(toCapacity);
	}
	
	public void verifyFieldsFromCapacitySection(String fromCapacity, String toCapacity){
		Assert.assertTrue(fromInputBoxCapacity.getAttribute("value").contains(fromCapacity));
		Assert.assertTrue(toInputBoxCapacity.getAttribute("value").contains(toCapacity));
	}
	
	public void clickOnDisplayDataButton(){
		displayDataButton.click();
	}
	
	public void clickOnFilterToggler(){
		waitUntilElementExists(By.cssSelector("div#dynamic_table > div"), 10);
		if(getDriver().findElements(By.cssSelector("div#dynamic_table > div.alert.alert-info")).size() == 1){
			System.out.println("Filter button is not available. No results were found.");
		}
		else{
			elementClick("div#main-actions div.btn-group.filter-database > button > span");
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div#main-actions > div:nth-child(2)")).getAttribute("class").contains("open"));
			Assert.assertTrue(companyToggler.isDisplayed());
			Assert.assertTrue(startDateToggler.isDisplayed());
			Assert.assertTrue(endDateToggler.isDisplayed());
			Assert.assertTrue(statusToggler.isDisplayed());
			Assert.assertTrue(sectorToggler.isDisplayed());
			Assert.assertTrue(valuesToggler.isDisplayed());
			Assert.assertTrue(capacityToggler.isDisplayed());
			Assert.assertTrue(resetFiltersButton.isDisplayed());
			Assert.assertTrue(filterButton.isDisplayed());
		}
	}
	
	public void clickOnFilterButton(){
		filterButton.click();
		Assert.assertTrue((getDriver().findElements(By.cssSelector("div#dynamic_table > div.alert.alert-info")).size() == 1 && getDriver().findElements(By.cssSelector("button#dvpack-save[disabled]")).size() == 1) || (getDriver().findElements(By.cssSelector("div#dynamic_table > div > div:nth-child(1) > div:last-child > div > table > thead > tr > th")).size() > 0 && getDriver().findElements(By.cssSelector("button#dvpack-save[disabled]")).size() == 0));
	}
	
	public void selectProjectNameRadioButton(){
		projectNameRadiobutton.click();
		okButton.click();
	}
	
	public void typeProjectName(String projectName){
		String splittedProjectName[]=projectName.split(",");
		projectNameInput.sendKeys(splittedProjectName[0]);
		projectNameInput.click();
	}
	
	public void checkOneRegion(String continent){
		if(getDriver().findElements(By.cssSelector("form.no-margin > div > ul > li:nth-child(4) > div > ul > li > label[title='" + continent + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("form.no-margin > div > ul > li:nth-child(4) > div > ul > li > label[title='" + continent + "']")).click();
		}
	}
	
	public void verifyIfRegionIsChecked(String continent){
		if(getDriver().findElements(By.cssSelector("form.no-margin > div > ul > li:nth-child(4) > div > ul > li > label[title='" + continent + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + continent + "')"));
		}
	}
	
	public void verifyIfRegionIsNotChecked(String continent){
		if(getDriver().findElements(By.cssSelector("form.no-margin > div > ul > li:nth-child(4) > div > ul > li > label[title='" + continent + "']")).size() == 1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + continent + "')"));
		}
	}
}

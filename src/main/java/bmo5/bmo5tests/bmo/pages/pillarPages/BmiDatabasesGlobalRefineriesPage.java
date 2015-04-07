package bmo5.bmo5tests.bmo.pages.pillarPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class BmiDatabasesGlobalRefineriesPage extends AbstractPage{

	@FindBy(css = "h5[data-section-name ='capacity_bd']")
	private WebElement capacityBDToggler;
	
	@FindBy(css = "h5[data-section-name ='capacity_bd'] i")
	private WebElement capacityBDTogglerArrow;
	
	@FindBy(css = "h5[data-section-name ='capacity_tpa']")
	private WebElement capacityTPAToggler;
	
	@FindBy(css = "h5[data-section-name ='capacity_tpa'] i")
	private WebElement capacityTPATogglerArrow;
	
	@FindBy(css = "h5[data-section-name ='start_dates']")
	private WebElement startDateToggler;
	
	@FindBy(css = "h5[data-section-name ='start_dates'] i")
	private WebElement startDateTogglerArrow;
	
	@FindBy(css = "h5[data-section-name ='end_dates']")
	private WebElement endDateToggler;
	
	@FindBy(css = "h5[data-section-name ='end_dates'] i")
	private WebElement endDateTogglerArrow;
	
	@FindBy(css = "li#filter-owners > h5")
	private WebElement ownerToggler;
	
	@FindBy(css = "li#filter-owners > h5 i")
	private WebElement ownerTogglerArrow;
	
	@FindBy(css = "select#capacities_bd")
	private WebElement capacityBDContainer;
	
	@FindBy(css = "select#capacities_tpa")
	private WebElement capacityTPAContainer;
	
	@FindBy(css = "button#dbfilter-clear")
	private WebElement resetFiltersButton;
	
	@FindBy(css = "button#filter-db-button")
	private WebElement filterButton;
	
	public void clickOnCapacityBDTogglerAndVerify(){
		capacityBDToggler.click();
		Assert.assertTrue(capacityBDTogglerArrow.getAttribute("class").contains("down"));
	}
	
	public void clickOnCapacityTPATogglerAndVerify(){
		capacityTPAToggler.click();
		Assert.assertTrue(capacityTPATogglerArrow.getAttribute("class").contains("down"));
	}
	
	public void clickOnStartDateTogglerAndVerify(){
		startDateToggler.click();
		Assert.assertTrue(startDateTogglerArrow.getAttribute("class").contains("down"));
	}
	
	public void clickOnEndDateTogglerAndVerify(){
		endDateToggler.click();
		Assert.assertTrue(endDateTogglerArrow.getAttribute("class").contains("down"));
	}
	
	public void clickOnOwnerTogglerAndVerify(){
		ownerToggler.click();
		Assert.assertTrue(ownerTogglerArrow.getAttribute("class").contains("down"));
	}
	
	public void checkOneItemFromStatusSection(String status){
		getDriver().findElement(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-of-type(1) > ul > li > label[title='" + status +"']")).click();
	}
	
	public void verifyIfTheStatusIsChecked(String status){
		Assert.assertTrue(verifyElementState("document.getElementById('" + status + "')"));
	}
	
	public void verifyIfThStatusIsUnchecked(String status){
		Assert.assertFalse(verifyElementState("document.getElementById('" + status + "')"));
	}
	
	public String returnStatusId(String status){
		return getDriver().findElement(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-of-type(1) > ul > li > label[title='" + status +"']")).getAttribute("for");
	}
	
	public void selectCapacityBDFromDropDown(String capacityBD){
		selectFromDropdown(capacityBDContainer, capacityBD);
	}
	
	public void selectCapacityTPAFromDropDown(String capacityTPA){
		selectFromDropdown(capacityTPAContainer, capacityTPA);
	}
	
	public void checkOneLetterInOwnerFilter(String letter){
		if(getDriver().findElements(By.cssSelector("ul#rhs-filter > li:last-child > ul > li > label[for='" + letter + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("ul#rhs-filter > li:last-child > ul > li > label[for='" + letter + "']")).click();
		}
	}
	
	public void verifyIfOneLetterFromOwnerFilterIsChecked(String letter){
		if(getDriver().findElements(By.cssSelector("ul#rhs-filter > li:last-child > ul > li > label[for='" + letter + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + letter + "')"));
		}
	}
	
	public void verifyIfOneLetterFromOwnerFilterIsNotChecked(String letter){
		if(getDriver().findElements(By.cssSelector("ul#rhs-filter > li:last-child > ul > li > label[for='" + letter + "']")).size() == 1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + letter + "')"));
		}
	}
	
	public void clickOnFilterToggler(){
		waitUntilElementExists(By.cssSelector("div#dynamic_table > div"), 10);
		if(getDriver().findElements(By.cssSelector("div#dynamic_table > div.alert.alert-info")).size() == 1){
			System.out.println("Filter button is not available. No results were found.");
		}
		else{
			elementClick("div#main-actions div.btn-group.filter-database > button > span");
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div#main-actions > div:nth-child(2)")).getAttribute("class").contains("open"));
			Assert.assertTrue(startDateToggler.isDisplayed());
			Assert.assertTrue(startDateToggler.isDisplayed());
			Assert.assertTrue(endDateToggler.isDisplayed());
			Assert.assertTrue(capacityBDToggler.isDisplayed());
			Assert.assertTrue(capacityTPAToggler.isDisplayed());
			Assert.assertTrue(ownerToggler.isDisplayed());
			Assert.assertTrue(resetFiltersButton.isDisplayed());
			Assert.assertTrue(filterButton.isDisplayed());
		}
	}
}

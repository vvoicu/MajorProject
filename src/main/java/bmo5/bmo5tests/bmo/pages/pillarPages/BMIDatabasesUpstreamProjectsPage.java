package bmo5.bmo5tests.bmo.pages.pillarPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class BMIDatabasesUpstreamProjectsPage extends AbstractPage{
	
	@FindBy(css = "aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-of-type(3) > h5")
	private WebElement geographyToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) > h5")
	private WebElement statusToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(1) > h5")
	private WebElement statusCompany;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(4) > h5")
	private WebElement peakOilToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(5) > h5")
	private WebElement peakGasToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(3) > h5")
	private WebElement projectCostToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(6) > h5")
	private WebElement onshoreOffshoreToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(7) > h5")
	private WebElement hydrocarbonTypeToggler;
	
	@FindBy(css = "aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-of-type(3) > h5 > span > i")
	private WebElement arrowGeographyToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(1) > h5 > span > i")
	private WebElement arrowCompanyToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) > h5 > span > i")
	private WebElement arrowStatusToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(4) > h5 > span > i")
	private WebElement arrowPeakOilToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(5) > h5 > span > i")
	private WebElement arrowPeakGasToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(3) > h5 > span > i")
	private WebElement arrowProjectCostToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(6) > h5 > span > i")
	private WebElement arrowOnshoreOffshoreToggler;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(7) > h5 > span > i")
	private WebElement arrowHydrocarbonTypeToggler;
	
	@FindBy(css = "button#filter-display-data")
	private WebElement displayDataButton;
	
	@FindBy(css = "select#peak_oil_range")
	private WebElement peakOilDropDownList;
	
	@FindBy(css = "select#peak_gas_range")
	private WebElement peakGasDropDownList;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(3) ul > div:nth-child(1) input")
	private WebElement projectCostFromInput;
	
	@FindBy(css = "aside.clear-both > div:nth-child(1) > ul > li:nth-child(3) ul > div:nth-child(2) input")
	private WebElement projectCostToInput;
	
	@FindBy(css = "a#filter-clear")
	private WebElement clearFiltersLink;
	
	@FindBy(css = "div.dataTables_wrapper > div:nth-child(1) > div > ul")
	private WebElement paginator;
	
	@FindBy(css = "div.dataTables_wrapper > div:nth-child(1) > div > ul > li i.icon-c-angle-double-right")
	private WebElement next;
	
	@FindBy(css = "div.dataTables_wrapper > div:nth-child(1) > div > ul > li i.icon-c-angle-double-left")
	private WebElement previous;
	
	@FindBy(css = "button#dbfilter-clear")
	private WebElement resetFiltersButton;
	
	@FindBy(css = "button#filter-db-button")
	private WebElement filterButton;
	
	@FindBy(css = "button#db-dd")
	private WebElement filterToggler;
	
	public void verifyLeftHandFilter(){
		Assert.assertTrue(geographyToggler.isDisplayed());
		Assert.assertTrue(arrowGeographyToggler.getAttribute("class").contains("down"));
		Assert.assertTrue(displayDataButton.isDisplayed());
	}
	
	public void clickOnStatusToggler(){
		statusToggler.click();
		Assert.assertTrue(arrowStatusToggler.getAttribute("class").contains("down"));
	}
	
	public void checkOneStatus(String status){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) ul > li label[title='" + status + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) ul > li label[title='" + status + "']")).click();
		}
	}
	
	public String returnTheStatusId(String status){
		return getDriver().findElement(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) ul > li label[title='" + status + "']")).getAttribute("for");
	}
	
	public void verifyIfStatusIsChecked(String status){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) ul > li label[title='" + status + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + status + "')"));
		}
	}
	
	public void verifyIfStatusIsUnChecked(String status){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) ul > li label[title='" + status + "']")).size() == 1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + status + "')"));
		}
	}
	
	public void checkOneCompany(String character){
		if(getDriver().findElements(By.cssSelector("ul#rhs-filter > li:nth-child(1) > ul > li label[for='" + character + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("ul#rhs-filter > li:nth-child(1) > ul > li label[for='" + character + "']")).click();
		}
	}
	
	public void verifyIfCompanyIsChecked(String character){
		if(getDriver().findElements(By.cssSelector("ul#rhs-filter > li:nth-child(1) > ul > li label[for='" + character + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + character + "')"));
		}
	}
	
	public void clickOnPeakOilToggler(){
		peakOilToggler.click();
		Assert.assertTrue(arrowPeakOilToggler.getAttribute("class").contains("down"));
	}
	
	public void selectValuesIntoPeakOilSection(String peakOilValue){
		waitABit(2000);
		selectFromDropdown(peakOilDropDownList, peakOilValue);
	}
	
	public void clickOnPeakGasToggler(){
		peakGasToggler.click();
		Assert.assertTrue(arrowPeakGasToggler.getAttribute("class").contains("down"));
	}
	
	public void selectValuesIntoPeakGasSection(String peakGasValue){
		waitABit(2000);
		selectFromDropdown(peakGasDropDownList, peakGasValue);
	}
	
	public void clickOnProjectCostToggler(){
		projectCostToggler.click();
		Assert.assertTrue(arrowProjectCostToggler.getAttribute("class").contains("down"));
	}
	
	public void insertValuesIntoProjectCostSection(String fromProjectCost, String toProjectCost){
		projectCostFromInput.sendKeys(fromProjectCost);
		projectCostToInput.sendKeys(toProjectCost);
	}
	
	public void verifyValuesFromProjectCostSection(String fromProjectCost, String toProjectCost){
		Assert.assertTrue(projectCostFromInput.getAttribute("value").contains(fromProjectCost));
		Assert.assertTrue(projectCostToInput.getAttribute("value").contains(toProjectCost));
	}
	
	public void clickOnOnshoreOffshoreToggler(){
		onshoreOffshoreToggler.click();
		Assert.assertTrue(arrowOnshoreOffshoreToggler.getAttribute("class").contains("down"));
	}
	
	public void checkOneOnshoreOrOffshore(String onshoreOrOffshore){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(6) ul > li label[title='" + onshoreOrOffshore + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(6) ul > li label[title='" + onshoreOrOffshore + "']")).click();
		}
	}
	
	public void verifyIfOnshoreOrOffshoreIsChecked(String onshoreOrOffshore){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(6) ul > li label[title='" + onshoreOrOffshore + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + onshoreOrOffshore + "')"));		
		}
	}
	
	public void verifyIfOnshoreOrOffshoreIsUnChecked(String onshoreOrOffshore){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(6) ul > li label[title='" + onshoreOrOffshore + "']")).size() == 1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + onshoreOrOffshore + "')"));		
		}
	}
	
	public void clickOnHydrocarbonToggler(){
		hydrocarbonTypeToggler.click();
		Assert.assertTrue(arrowHydrocarbonTypeToggler.getAttribute("class").contains("down"));
	}
	
	public void checkOneHydrocarbonType(String hydrocarbonType){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(7) ul > li label[title='" + hydrocarbonType + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(7) ul > li label[title='" + hydrocarbonType + "']")).click();
		}
	}
	
	public void verifyIfHydrocarbonTypeIsChecked(String hydrocarbonType){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(7) ul > li label[title='" + hydrocarbonType + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + hydrocarbonType + "')"));			
		}
	}
	
	public void verifyIfHydrocarbonTypeIsUnChecked(String hydrocarbonType){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(7) ul > li label[title='" + hydrocarbonType + "']")).size() == 1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + hydrocarbonType + "')"));			
		}
	}
	
	public void clickOnClearFilters(){
		clearFiltersLink.click();
	}
	
	public void verifyPaginator(){
		waitABit(4000);
		if(getDriver().findElements(By.cssSelector("div.dataTables_wrapper > div:nth-child(1) > div > ul")).size() > 0){
			Assert.assertTrue(paginator.isDisplayed());
			next.click();
			previous.click();
		}
		else{
			System.out.println("There is no paginator");
		}
	}
	
	public void clickOnFilterToggler(){
		waitUntilElementExists(By.cssSelector("div#dynamic_table > div"), 10);
		elementClick("div#main-actions div.btn-group.filter-database > button > span");
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#main-actions > div:nth-child(2)")).getAttribute("class").contains("open"));
		Assert.assertTrue(arrowCompanyToggler.getAttribute("class").contains("down"));
		Assert.assertTrue(statusToggler.isDisplayed());
		Assert.assertTrue(arrowStatusToggler.getAttribute("class").contains("right"));
		Assert.assertTrue(peakOilToggler.isDisplayed());
		Assert.assertTrue(arrowPeakOilToggler.getAttribute("class").contains("right"));
		Assert.assertTrue(peakGasToggler.isDisplayed());
		Assert.assertTrue(arrowPeakGasToggler.getAttribute("class").contains("right"));
		Assert.assertTrue(projectCostToggler.isDisplayed());
		Assert.assertTrue(arrowProjectCostToggler.getAttribute("class").contains("right"));
		Assert.assertTrue(onshoreOffshoreToggler.isDisplayed());
		Assert.assertTrue(arrowOnshoreOffshoreToggler.getAttribute("class").contains("right"));
		Assert.assertTrue(hydrocarbonTypeToggler.isDisplayed());
		Assert.assertTrue(arrowHydrocarbonTypeToggler.getAttribute("class").contains("right"));
		Assert.assertTrue(resetFiltersButton.isDisplayed());
		Assert.assertTrue(filterButton.isDisplayed());
	}
}

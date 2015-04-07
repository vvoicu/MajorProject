package bmo5.bmo5tests.bmo.pages.pillarPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class BMIDatabasesGlobalMinesPage extends AbstractPage{
	
	@FindBy(css = "h5[data-section-name='geography_list']")
	private WebElement geographyToggler;
	
	@FindBy(css = "h5[data-section-name='metals']")
	private WebElement metalToggler;
	
	@FindBy(css = "li#filter-companies > h5")
	private WebElement companyToggler;
	
	@FindBy(css = "h5[data-section-name='capex']")
	private WebElement capexToggler;
	
	@FindBy(css = "h5[data-section-name='oregrade']")
	private WebElement oreGrandeToggler;
	
	@FindBy(css = "h5[data-section-name='statuses']")
	private WebElement statusToggler;
	
	@FindBy(css = "h5[data-section-name='geography_list'] > span > i")
	private WebElement arrowGeographyToggler;
	
	@FindBy(css = "h5[data-section-name='metals'] > span > i")
	private WebElement arrowMetalToggler;
	
	@FindBy(css = "li#filter-companies > h5 > span > i")
	private WebElement arrowCompanyToggler;
	
	@FindBy(css = "h5[data-section-name='capex'] > span > i")
	private WebElement arrowCapexToggler;
	
	@FindBy(css = "h5[data-section-name='oregrade'] > span > i")
	private WebElement arrowOreGrandeToggler;
	
	@FindBy(css = "h5[data-section-name='statuses'] > span > i")
	private WebElement arrowStatusToggler;
	
	@FindBy(css = "button#filter-download-data")
	private WebElement downloadButton;
	
	@FindBy(css = "a#filter-clear")
	private WebElement clearFiltersLink;
	
	@FindBy(css = "aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-of-type(3) > div > ul > li:nth-child(1) > input")
	private WebElement inputBoxGeographySection;
	
	@FindBy(css = "aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-of-type(3) > div > ul")
	private WebElement geographyContainer;
	
	@FindBy(css = "select#capexes")
	private WebElement capexDropDownList;
	
	@FindBy(css = "select#ore_grades")
	private WebElement oreGrandeDropDownList;
	
	@FindBy(css = "button#db-dd")
	private WebElement filterToggler;
	
	@FindBy(css = "button#dbfilter-clear")
	private WebElement resetFiltersButton;
	
	@FindBy(css = "button#filter-database")
	private WebElement filterButton;
	
	public void clickOnMetalToggler(){
		metalToggler.click();
		Assert.assertTrue(arrowMetalToggler.getAttribute("class").contains("down"));
	}
	
	public void checkOneItemFromMetalSection(String metal){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-of-type(1) > ul > li > label[for='" + metal +"']")).size() == 1){
			getDriver().findElement(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-of-type(1) > ul > li > label[for='" + metal +"']")).click();
		}
	}
	
	public void verifyIfTheMetalIsChecked(String metal){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-of-type(1) > ul > li > label[for='" + metal +"']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + metal + "')"));		}
	}
	
	public void verifyIfTheMetalIsUnchecked(String metal){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-of-type(1) > ul > li > label[for='" + metal +"']")).size() == 1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + metal + "')"));		}
	}
	
	public void clickOnCompanyToggler(){
		companyToggler.click();
		Assert.assertTrue(arrowCompanyToggler.getAttribute("class").contains("down"));
	}
	
	public void checkOneLetterAndVerifyFromCompanySection(String letter){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) ul > li > label[for='" + letter + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) ul > li > label[for='" + letter + "']")).click();
		}
	}
	
	public void verifyOneLetterIsChecked(String letter){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) ul > li > label[for='" + letter + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + letter + "')"));
		}
	}
	
	public void verifyOneLetterIsNotChecked(String letter){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(2) ul > li > label[for='" + letter + "']")).size() == 1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + letter + "')"));
		}
	}
	
	
	public void clickOnCapexToggler(){
		capexToggler.click();
		Assert.assertTrue(arrowCapexToggler.getAttribute("class").contains("down"));
	}
	
	public void selectCapexValue(String capexValue){
		waitABit(2000);
		selectFromDropdown(capexDropDownList, capexValue);
	}
	
	public void clickOnOreGrandeToggler(){
		oreGrandeToggler.click();
		Assert.assertTrue(arrowOreGrandeToggler.getAttribute("class").contains("down"));
	}
	
	public void selectOreGrandeValue(String oreGrandeValue){
		waitABit(2000);
		selectFromDropdown(oreGrandeDropDownList, oreGrandeValue);
	}
	
	public void clickOnStatusToggler(){
		statusToggler.click();
		Assert.assertTrue(arrowStatusToggler.getAttribute("class").contains("down"));
	}
	
	public void checkItemFromStatusSection(String status){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(5) ul > li > label[title='" + status + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(5) ul > li > label[title='" + status + "']")).click();
		}
	}
	
	public String returnTheStatusId(String status){
		return getDriver().findElement(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(5) ul > li > label[title='" + status + "']")).getAttribute("for");
	}
	
	public void verifyIfThestatusIsChecked(String status){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(5) ul > li > label[title='" + status + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + status + "')"));
		}
	}
	
	public void verifyIfThestatusIsUnChecked(String status){
		if(getDriver().findElements(By.cssSelector("aside.clear-both > div:nth-child(1) > ul > li:nth-child(5) ul > li > label[title='" + status + "']")).size() == 1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + status + "')"));
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
		}
	}
}

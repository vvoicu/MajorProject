package bmo5.bmo5tests.bmo.pages.homepage;

import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class FilterPanelSpecialRepPage extends AbstractPage {
	
	@FindBy(id = "geographies_filter")
	private WebElement geography;

	@FindBy(id = "services_filter")
	@CacheLookup
	private WebElement service;

	@FindBy(id = "reports_refine_form")
	private WebElement dropBox;

	@FindBy(linkText = "Special Reports")
	@CacheLookup
	private WebElement specialReports;

	@FindBy(css = "ul.breadcrumb li.active ")
	private WebElement breadcrumbLast;

	@FindBy(css = "ul.breadcrumb li:first-child a[href='/home']")
	private WebElement breadcrumbFirst;

	@FindBy(css = "ul.breadcrumb > li:nth-child(2) > a")
	private WebElement clickHome;

	@FindBy(css = "div#ui-datepicker-calendar > tbody") 
	private WebElement datePicker;

	@FindBy(id = "new_form_start_date")
	private WebElement clickDatepicker;
	
	@FindBy(css = "button.btn")
	private WebElement clickUpdateButton;
	
	@FindBy(css = "input#new_form_end_date")
	private WebElement endDateFilter;
	
	@FindBy(css = "input#new_form_q")
	private WebElement searchAllWordsFilter;
	
	
	public void clickOnDate() {
		clickDatepicker.click();
		waitABit(5000);
	}

	public void clickOnHome() {
		clickHome.click();
	}

	public void clickOnLeftPanelLevelOne(int itemGeo, String geoCheck) {
		element(geography).waitUntilVisible();
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(4) > ul >li:nth-child(1) > ul > li:nth-child("+itemGeo+") > label ")).click();
		waitABit(4000);
		Assert.assertTrue("not found!", verifyElementState("document.getElementById('"+geoCheck+"')"));
	}
	
	public void verifyCheckbox(int anytime, int lastWeek, int lastM, int lastThreeM, int lastSixM, String sixM, String any) {
		element(dropBox).waitUntilVisible();
		if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+anytime+") > input[checked='checked']")).size() == 1) {
			getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+lastSixM+") > label ")).click();
			element(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+lastSixM+") > label "))).waitUntilPresent();
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+lastSixM+")  > label")).getText().contains(sixM));
		} else if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+lastWeek+") > input[checked='checked'] ")).size() ==1) {
			getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+lastSixM+")  > label")).click();
			element(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+lastSixM+") > label "))).waitUntilPresent();
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+lastSixM+")  > label")).getText().contains(sixM));
		} else if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+lastSixM+") > input[checked='checked'] ")).size() == 1) {
			getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+anytime+")  > label")).click();
			element(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+anytime+")  > label"))).waitUntilPresent();
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+lastSixM+") > label ")).getText().contains(any));
		}else if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+lastThreeM+")  > input[checked='checked']")).size() == 1) {
			getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+lastSixM+")  > label")).click();
			element(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+lastSixM+")  > label"))).waitUntilPresent();
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+lastSixM+") > label ")).getText().contains(sixM));
		}else if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+lastM+") > input[checked='checked']")).size() == 1) {
			getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+anytime+")  > label")).click();
			element(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > li:nth-child("+anytime+")  > label"))).waitUntilPresent();
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > ul > lil:nth-child("+anytime+") > labe ")).getText().contains(any));
		}
	}

	public void clickOnLeftPanelLevelFour(int serviceNumber) {
		element(service).waitUntilVisible();
		getDriver().findElement(By.cssSelector("ul#services_filter > li > ul > li:nth-child("+serviceNumber +") > label ")).click();
		waitABit(7000);
		if(getDriver().findElements(By.cssSelector("ul#services_filter > li > ul > li:nth-child("+serviceNumber +") > label > div > span.checked ")).size() == 1){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#services_filter > li > ul > li:nth-child("+serviceNumber +") > input[checked='checked'] ")).isDisplayed());}
	}

	public void verifyBreadcrumbs(String text) {
		boolean contained = false;
			if(breadcrumbLast.getText().contains(text)) {
			contained = true;
		} else {
			if(breadcrumbFirst.getText().contains(text)) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}

	public void setDate(String day) {
		 endDateFilter.click();
		 waitABit(4000);
		 WebElement dateWidget = getDriver().findElement(By.id("ui-datepicker-div"));   
		 List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
		    
		  for (WebElement cell: columns){  
			  if (cell.getText().equals(day)){  
		   cell.findElement(By.linkText(day)).click(); 
		   waitABit(5000);
		   endDateFilter.click();
			waitABit(5000);
			Assert.assertTrue("not found!!!",getDriver().findElement(By.cssSelector("table.ui-datepicker-calendar > tbody > tr > td > a.ui-state-default.ui-state-active ")).isDisplayed());
		   break; 
		  	}
		  }
		  }
	
	public void searchForAllOfTheseWords(String searchTerm,String specialReportTitleNo) {
		searchAllWordsFilter.sendKeys(searchTerm);
		searchAllWordsFilter.sendKeys(Keys.ENTER);
		waitABit(10000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.media-listing > div:nth-of-type("+specialReportTitleNo+") > div:nth-of-type(1) > div > h5 > a")).getText().contains(searchTerm));
		searchAllWordsFilter.clear();
		searchAllWordsFilter.sendKeys(Keys.ENTER);
	}
	}
	

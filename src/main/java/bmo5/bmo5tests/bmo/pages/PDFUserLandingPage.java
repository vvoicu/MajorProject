package bmo5.bmo5tests.bmo.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class PDFUserLandingPage extends AbstractPage{
	
	@FindBy(css = "div.control-group.no-padding > div > input")
	private WebElement reportTitlesBox;
	
	@FindBy(css = "input#geographies_filter")
	private WebElement selectGeographiesToSearchAgainstBox;
	
	@FindBy(css = "a.btn.btn-move > i.icon-c-angle-double-right")
	private WebElement moveAllGeographiesToRightPanelArrow;
	
	@FindBy(css = "select#geographies")
	private WebElement rightPanelGeographies;
	
	@FindBy(css = "label[for='services_all']")
	private WebElement allServicesCheckBox;
	
	@FindBy(css = "div#date-container > div:nth-of-type(1) > div >label:nth-child(1) > div >span ")
	private WebElement anytimeRadioButton;
	
	@FindBy(css = "div#date-container > div:nth-of-type(1) > div >label:nth-child(2) > div >span ")
	private WebElement withinLastWeekRadioButton;
	
	@FindBy(css = "div#date-container > div:nth-of-type(1) > div >label:nth-child(3) > div >span ")
	private WebElement withinLastMonthRadioButton;
	
	@FindBy(css = "div#date-container > div:nth-of-type(1) > div >label:nth-child(4) > div >span ")
	private WebElement withinLast3MonthsRadioButton;
	
	@FindBy(css = "div#date-container > div:nth-of-type(1) > div >label:nth-child(5) > div >span ")
	private WebElement withinLast6MonthsRadioButton;
	
	@FindBy(css = "input#sort_by_date")
	private WebElement publicationDateRadioButton;
	
	@FindBy(css = "input#sort_by_service")
	private WebElement serviceRadioButton;
	
	@FindBy(css = "input#sort_by_title")
	private WebElement titleRadioButton;
	
	@FindBy(css = "div#services_checkboxes > button")
	private WebElement clearLinkServicesSection;
	
	@FindBy(css = "div#date-container > button")
	private WebElement clearLinkDataSection;
	
	@FindBy(css = "form#bmi_reports_search_form > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)")
	private WebElement searchButtonTopPage;
	
	@FindBy(css = "form#bmi_reports_search_form > div:nth-child(1) > div:nth-child(1) > button:nth-child(2)")
	private WebElement clearLinkTopPage;
	
	@FindBy(css = "input#start_date")
	private WebElement startDateBox;
	
	@FindBy(css = "input#end_date")
	private WebElement endDateBox;
	
	@FindBy(css = "ul.breadcrumb > li.active")
	private WebElement lastBreadcrumb;
	
	@FindBy(css = "i.icon-c-angle-right")
	private WebElement moveToRightOneGeographyArrow;
	
	@FindBy(css = "ul.breadcrumb > li >a ")
	private WebElement homeBreadcrumb;
	
	@FindBy(css = "select[name='all_geographies']")
	private WebElement leftPanelGeographiesSection;
	
	@FindBy(css = "div#date-container > div:nth-of-type(3) > div")
	private WebElement sortByContainer;
	
	@FindBy(css = "div#date-container > div:nth-of-type(1) > div")
	private WebElement dateRangeContainer;
	
	public void verifyPDFBreadcrumbs(String pdfBreadcrumb){
		Assert.assertTrue(lastBreadcrumb.getText().contains(pdfBreadcrumb));
	}
	
	public void typeThreeLettersOfAReportTitleAndChooseOneItem(String threeLetters, int itemNumber){
		reportTitlesBox.sendKeys(threeLetters);
		Sleeper.sleepTight(2000);
		int numberOfItems = getDriver().findElements(By.cssSelector("ul[class='typeahead dropdown-menu'] > li")).size() -1;
		if(numberOfItems > 0){
			if(itemNumber < numberOfItems && itemNumber > 0){
				int rightItemNumber = itemNumber + 1;
				getDriver().findElement(By.cssSelector("ul[class='typeahead dropdown-menu'] > li:nth-child(" + rightItemNumber + ") > a")).click();
			}
			else{
				System.out.println("There are not so many items, so click the first one.");
				getDriver().findElement(By.cssSelector("ul[class='typeahead dropdown-menu'] > li:nth-child(2) > a")).click();
			}
		}
		else{
			System.out.println("There are no items is list.");
		}
	} 
	
	public String typeThreeLettersInGeographyBoxAndMoveOneItem(String threeLetters, int itemNumber){
		selectGeographiesToSearchAgainstBox.sendKeys(threeLetters);
		Sleeper.sleepTight(2000);
		String itemName = null;
		boolean isPresent = false;
		int numberOfItems = getDriver().findElements(By.cssSelector("select[name='all_geographies'] > option")).size();
		if(numberOfItems > 0){
			if(itemNumber < numberOfItems && itemNumber > 0){
				itemName = getDriver().findElement(By.cssSelector("select[name='all_geographies'] > option:nth-of-type(" + itemNumber + ")")).getText();
				getDriver().findElement(By.cssSelector("select[name='all_geographies'] > option:nth-of-type(" + itemNumber + ")")).click();
				moveToRightOneGeographyArrow.click();
			}
			else{
				System.out.println("There are not so many items, so click the first one.");
				itemName = getDriver().findElement(By.cssSelector("select[name='all_geographies'] > option:nth-of-type(1)")).getText();
				getDriver().findElement(By.cssSelector("select[name='all_geographies'] > option:nth-of-type(1)")).click();
				moveToRightOneGeographyArrow.click();
			}
		}
		else{
			System.out.println("There are no items is list.");
		}
		int numberOfItemsMoved = getDriver().findElements(By.cssSelector("select#geographies > option")).size();
		for(int i=1; i<=numberOfItemsMoved; i++){
			if(getDriver().findElement(By.cssSelector("select#geographies > option:nth-of-type(" + i + ")")).getText().contains(itemName)){
				isPresent = true;
				break;
			}
		}
		Assert.assertTrue(isPresent);
		return itemName;
	}
	
	public void verifyIfGeographyIsCheckedInLHF(String geographyName){
		if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul > li")).size() == 6){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child(4) > ul > li > ul > li:nth-child(1) label")).getText().contains(geographyName));
		}
		else{
			System.out.println("There were no results");
		}
	}
	
	public void selectAllServices(){
		allServicesCheckBox.click();
		Assert.assertTrue(verifyElementState("document.getElementById('services_all')"));
		int numberOfServices = getDriver().findElements(By.cssSelector("div[class='controls span9 margin-left-20 services_container'] > div > label")).size();
		String serviceId = null;
		for(int i=1; i<=numberOfServices; i++){
			serviceId = getDriver().findElement(By.cssSelector("div[class='controls span9 margin-left-20 services_container'] > div:nth-child(" + i + ") > label")).getAttribute("for");
			Assert.assertTrue(verifyElementState("document.getElementById('" + serviceId + "')"));
		}
	}
	
	//TODO fix this
//	public void verifyIfAllServicesAreCheckedInLHF(){
//		if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul > li")).size() == 6){
//			ReportsArchiveListingPage reports = new ReportsArchiveListingPage(getDriver());
//			reports.clickShowMoreUntilNotDisplayed("services_filter");
//			int numberOfGeographies = getDriver().findElements(By.cssSelector("ul.nav.nav-list > li.nav-header:nth-child(5) > ul > li > ul > li ")).size();
//			for(int i=1; i<=numberOfGeographies; i++){
//				Assert.assertTrue(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li.nav-header:nth-child(5) > ul > li > ul > li:nth-of-type(" + i + ") > input")).getAttribute("ischecked").contains("1"));
//			}
//		}
//		else{
//			System.out.println("There were no results");
//		}
//	}
	
	public void clickOnSearchButton(){
		searchButtonTopPage.click();
		waitABit(5000);
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div#disabled_warning > span")).size() == 1 || getDriver().findElements(By.cssSelector("div.sidebar.well > ul > li")).size() == 6);
	}
	
	public void selectAllCountries(){
		moveAllGeographiesToRightPanelArrow.click();
		Assert.assertTrue(leftPanelGeographiesSection.getText().isEmpty());
	}
	
	//TODO fix this
//	public void verifyIfAllGeographiesAreCheckedInLHF(){
//		if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul > li")).size() == 6){
//			ReportsArchiveListingPage reports = new ReportsArchiveListingPage(getDriver());
//			reports.clickShowMoreUntilNotDisplayed("geographies_filter");
//			int numberOfGeographies = getDriver().findElements(By.cssSelector("ul.nav.nav-list > li.nav-header:nth-child(4) > ul > li > ul > li ")).size();
//			for(int i=1; i<=numberOfGeographies; i++){
//				Assert.assertTrue(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li.nav-header:nth-child(4) > ul > li > ul > li:nth-of-type(" + i + ") > label > div > span")).getAttribute("class").contains("checked"));
//			}
//		}
//		else{
//			System.out.println("There were no results");
//		}
//	}
	
	public String selectAService(int itemNumber){
		Sleeper.sleepTight(2000);
		String serviceName = null, serviceId = null;
		int numberOfItems = getDriver().findElements(By.cssSelector("div[class='controls span9 margin-left-20 services_container'] > div")).size();
		if(numberOfItems > 0){
			if(itemNumber < numberOfItems && itemNumber > 0){
				getDriver().findElement(By.cssSelector("div[class='controls span9 margin-left-20 services_container'] > div:nth-child(" + itemNumber + ") > label")).click();
				serviceId = getDriver().findElement(By.cssSelector("div[class='controls span9 margin-left-20 services_container'] > div:nth-child(" + itemNumber + ") > label")).getAttribute("for");
				System.out.println(serviceId);
				serviceName = getDriver().findElement(By.cssSelector("div[class='controls span9 margin-left-20 services_container'] > div:nth-child(" + itemNumber + ") > label")).getText();
				System.out.println(serviceName);
				Assert.assertTrue(verifyElementState("document.getElementById('" + serviceId + "')"));
			}
			else{
				System.out.println("There are not so many items, so check the first one.");
				getDriver().findElement(By.cssSelector("div[class='controls span9 margin-left-20 services_container'] > div:nth-child(1) > label > div > span")).click();
				serviceId = getDriver().findElement(By.cssSelector("div[class='controls span9 margin-left-20 services_container'] > div:nth-child(1) > label")).getAttribute("for");
				serviceName = getDriver().findElement(By.cssSelector("div[class='controls span9 margin-left-20 services_container'] > div:nth-child(1) > label")).getText();
				Assert.assertTrue(verifyElementState("document.getElementById('" + serviceId + "')"));
			}
		}
		else{
			System.out.println("There are no items is list.");
		}
		return serviceName;
	}
	
	public void verifyIfServiceIsCheckedInLHF(String serviceName){
		if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul > li")).size() == 6){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child(5) > ul > li > ul > li:nth-child(1) label")).getText().contains(serviceName));
		}
		else{
			System.out.println("There were no results");
		}
	}

	public void checkDateRangeAndVerify(String dateRange){
		if(dateRange.isEmpty()){
			getDriver().findElement(By.cssSelector("div#date-container > div:nth-of-type(1) label[for='publication_date" + dateRange + "']")).click();
			Assert.assertTrue(verifyElementState("document.getElementById('publication_date" + dateRange + "')"));
		}
		else{
			getDriver().findElement(By.cssSelector("div#date-container > div:nth-of-type(1) label[for='uniform-publication_date_" + dateRange + "']")).click();
			Assert.assertTrue(verifyElementState("document.getElementById('uniform-publication_date_" + dateRange + "')"));
		}
	}
	
	public void verifyIfDateRangeIsCheckedInLHF(String dateRange){
		if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul > li")).size() == 6){
			if(dateRange.isEmpty()){
				Assert.assertTrue(verifyElementState("document.getElementById('6month-date')"));
			}
			else if(dateRange.contains("lastthree")){
				Assert.assertTrue(verifyElementState("document.getElementById('3month-date')"));
			}
			else{
				Assert.assertTrue(dateRange.contains(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child(3) > ul > li input[checked='checked']")).getAttribute("value")));
			}
		}
		else{
			System.out.println("There were no results");
		}
	}
	
	public void checkSortByResultsAndVerify(String sortBy){
		getDriver().findElement(By.cssSelector("div#date-container > div:nth-of-type(3) > div label[for='sort_by_" + sortBy + "']")).click();
		Assert.assertTrue(verifyElementState("document.getElementById('sort_by_" + sortBy + "')"));
	}
	
	public void verifySortBy(String sortBy){
		if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul > li")).size() == 6){
			String sortByDropDown = getDriver().findElement(By.cssSelector("span[class='input-prepend input-append pull-left'] > div:nth-of-type(1) div")).getText().toLowerCase();
			Assert.assertTrue(sortByDropDown.contains(sortBy));
		}
		else{
			System.out.println("There were no results");
		}
	}
	
	public void enterValidStartAndEndDate(String startDate, String endDate){
		startDateBox.sendKeys(startDate);
		endDateBox.sendKeys(endDate);
	}
	
	public void verifyStartDateAndEndDateFromLHF(String startDate, String endDate){
		if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul > li")).size() == 6){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child(3) > ul > li.row-fluid input#new_form_start_date")).getAttribute("value").contains(startDate));
			Assert.assertTrue(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child(3) > ul > li.row-fluid input#new_form_end_date")).getAttribute("value").contains(endDate));
		}
		else{
			System.out.println("There were no results");
		}
	}
	
	public void clickOnHomeBreadcrumb(){
		homeBreadcrumb.click();
		Assert.assertTrue(reportTitlesBox.isDisplayed());
	}
	
	public void clickOnClearLinkAndVerifyTheForm(){
		clearLinkTopPage.click();
		Assert.assertTrue(reportTitlesBox.getText().isEmpty());
		Assert.assertTrue(selectGeographiesToSearchAgainstBox.getText().isEmpty());
		Assert.assertTrue(rightPanelGeographies.getText().isEmpty());
		Assert.assertFalse(verifyElementState("document.getElementById('services_all')"));
		int numberOfServices = getDriver().findElements(By.cssSelector("div[class='controls span9 margin-left-20 services_container'] > div > label")).size();
		String serviceId = null;
		for(int i=1; i<=numberOfServices; i++){
			serviceId = getDriver().findElement(By.cssSelector("div[class='controls span9 margin-left-20 services_container'] > div:nth-child(" + i + ") > label")).getAttribute("for");
			Assert.assertFalse(verifyElementState("document.getElementById('" + serviceId + "')"));
		}
		Assert.assertTrue(verifyElementState("document.getElementById('publication_date_any')"));
//		Assert.assertTrue(verifyElementState("document.getElementById('sort_by_date')"));
	}
}

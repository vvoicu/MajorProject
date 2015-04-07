package bmo5.bmo5tests.bmo.pages.pillarPages;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class BMIDatabasesGeneralPage extends AbstractPage{

	@FindBy(css= "div.sidebar.well > ul > li:nth-child(4) > h5")
	private WebElement sectorFromFilter;


	@FindBy(css= "div.sidebar.well > ul > li:nth-child(5)> h5")
	private WebElement indicatorFromFilter;

	@FindBy(css= "ul.operators.nav.nav-list.dropdown-list")
	private WebElement operatorListFromFilter;

	@FindBy(css= "ul.operators.nav.nav-list.dropdown-list > li:nth-child(1)")
	private WebElement operatorSearchAreaFromFilter;		

	@FindBy(css= "div.expandable-wrapper > ul")
	private WebElement indicatorListFromFilter;

	@FindBy( css="article#content-wrapper > div > div > div:last-child > button")
	private WebElement saveChart;

	@FindBy( id = "modal-save-dvpack")
	private WebElement containerSavePopUp;

	@FindBy( css = "div#modal-save-dvpack  > form > div >input")
	private WebElement textAreaSavePopUp;

	@FindBy( css = "div#modal-save-dvpack > div > a:nth-child(1)")
	private WebElement cancelSavePopUp;

	@FindBy( css = "div#modal-save-dvpack > div > a:nth-child(2)")
	private WebElement saveButtonFromSavePopUp;

	@FindBy(css = "select.input-block-level > option")
	private WebElement databasesDropdown;

	@FindBy(css = "h5[data-section-name='date_ranges']")
	private WebElement dateRangesToggler;

	@FindBy(css = "h5[data-section-name='date_ranges'] > span > i")
	private WebElement arrowDateRangesToggler;

	@FindBy(css = "button#filter-display-data")
	private WebElement displayDataButton;

	@FindBy(css = "h5[data-section-name='geography_list']")
	private WebElement filterGeographySection;

	@FindBy(css = "ul.nav.nav-list")
	private WebElement filterGeographySectionExpanded;

	@FindBy(css = "input.input-block-level")
	private WebElement filterQuickSearch;

	@FindBy(css = "input[placeholder='Quick filter']")
	private WebElement filterQuickSearchOperator;

	@FindBy(css = "h5[data-section-name='op_list']")
	private WebElement filterOperatorsSection;

	@FindBy(css = "ul.operators.nav")
	private WebElement filterOperatorsSectionExpanded;

	@FindBy(css = "h5[data-section-name='indicator_list']")
	private WebElement filterIndicatorsSection;

	@FindBy(css = "ul.nav.nav-list")
	private WebElement filterIndicatorsSectionExpanded;

	@FindBy(css = "h5[data-section-name='date_ranges']")
	private WebElement filterDataRangesSection;

	@FindBy(css = "ul.nav.nav-list")
	private WebElement filterDataRangesSectionExpanded;

	@FindBy(css = "h5[data-section-name='age']")
	private WebElement filterAgeSection;

	@FindBy(css = "ul.nav.nav-list")
	private WebElement filterAgeSectionExpanded;

	@FindBy(css = "h5[data-section-name='gender']")
	private WebElement filterGenderSection;

	@FindBy(css = "ul.nav.nav-list")
	private WebElement filterGenderSectionExpanded;

	@FindBy(css = "ul.nav.nav-list.dropdown-list.user-journey")
	private WebElement journeyOperatorGeography;

	@FindBy(css = "ul.nav.nav-list.dropdown-list.user-journey > li:nth-child(2) > label > div")
	private WebElement journeyOperatorGeographyDialogWindow;

	@FindBy(css = "div#journey-modal > div:nth-child(2)")
	private WebElement journeyDialogWindowConfirmationButtons;

	@FindBy(css = "a[href='/home']")
	private WebElement firstBreadcrumb;

	@FindBy(css = "ul.breadcrumb li.active ")
	private WebElement lastBreadcrumb;

	@FindBy(id = "filter-clear")
	private WebElement clearFilters;

	@FindBy(css = "div#modal-save-dvpack > form > div > input[class*='input-block-level']")
	private WebElement saveDataInputBox;

	@FindBy(css="button#dt-data-refresh-button")
	private WebElement refreshButton;

	@FindBy(css="table#DataTables_Table_0 > tbody > tr > td:nth-child(5)")
	private WebElement valueFirstRow;

	@FindBy(css="span#dt-data-refresh-text")
	private WebElement lastUpdatedTextLabel;

	@FindBy(css="div#dt-data-refresh-warning")
	private WebElement dataRefreshWarning;

	@FindBy(css = "button[class='btn btn-small dropdown-toggle']")
	private WebElement arrowBesideSaveButton;

	@FindBy(css = "ul#saved-data-dropdown")
	private WebElement savedDataContainer;

	@FindBy(css = "aside.span2.sidebar-wrapper")
	private WebElement filtersArea;
	
	@FindBy(css = "div#dynamic_chart > div.alert.alert-info")
	private WebElement alertMessageForChart;
	
	@FindBy(css = "div#dynamic_table > div.alert.alert-info")
	private WebElement alertMessageForTable;

	public void clickOnClearFilters(){
		Assert.assertTrue("Not displayed!!!", getDriver().findElement(By.id("filter-clear")).getText().equals("Clear filters"));
		clearFilters.click();
	}

	public void clickOnDisplayDataButton(){
		displayDataButton.click();
	}
	public void expandSectorFromFilter() {
		element(sectorFromFilter).waitUntilVisible();
		Assert.assertTrue("", getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(4) > h5 > span > i")).isDisplayed());
		sectorFromFilter.click();
	}

	public void clickOnOneDatabase(String databaseName){
		int numberOfRows = getDriver().findElements(By.cssSelector("article.span10 > div")).size();
		System.out.println("Number of rows:" + numberOfRows);
		for(int i=1; i<= numberOfRows; i++){
			int numberOfElementsPerColumn = getDriver().findElements(By.cssSelector("article.span10 > div:nth-child(" + i + ") > div")).size();
			System.out.println("Number of elements per row" + numberOfElementsPerColumn);
			for(int j=1; j<=numberOfElementsPerColumn; j++){
				if(getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(" + i + ") > div:nth-child(" + j + ") > h4 > a")).getText().contains(databaseName)){
					getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(" + i + ") > div:nth-child(" + j + ") > h4 > a")).click();
					break;
				}
			}
		}
	}

	public void selectDatabaseFromDropdownList(String element) {
		element(getDriver().findElement(By.cssSelector("select.input-block-level"))).waitUntilVisible();
		selectFromDropdown(getDriver().findElement(By.cssSelector("select.input-block-level")), element);
	}
	
	public void selectJourneyFromFilter(String option) {

		element(journeyOperatorGeography).waitUntilVisible();
		List<WebElement> itemsList = journeyOperatorGeography.findElements(By.cssSelector("li label"));

		for(WebElement elementNow:itemsList){
			System.out.println(elementNow.getText());
			if(elementNow.getText().contains(option)){
				elementNow.click();
				System.out.println("selected!!!");

				break;
			}
		}
	}
	
	public void verifyBreadCrumbsForCompanyContacts(String breadcrumb) {
		boolean contained = false;
		if (breadcrumb.contains(lastBreadcrumb.getText())) {
			contained = true;
		} else {
			if (breadcrumb.contains(firstBreadcrumb.getText())) {
				contained = true;
				waitABit(10000);	
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + breadcrumb + "!", contained);
		waitABit(10000);	
	}

	public void journeyFilterDialogWindow() {
		journeyOperatorGeographyDialogWindow.click();
		waitABit(5000);
		Assert.assertTrue("Not displayed!!", getDriver().findElement(By.cssSelector("div#journey-modal > div:nth-child(1) > p")).getText().contains("You are now changing your starting point and all your filters will be reset."));

	}
	
	public void cancelOkJourneyFromFilter(String confirmation) {
		element(journeyDialogWindowConfirmationButtons).waitUntilVisible();
		List<WebElement> itemsList = journeyDialogWindowConfirmationButtons.findElements(By.tagName("button"));

		for(WebElement elementNow:itemsList){
			System.out.println(elementNow.getText());
			if(elementNow.getText().contains(confirmation)){
				elementNow.click();
				System.out.println("selected!!!");
				waitABit(10000);
				break;
			}
		}
	}

	public void checkOneRegion(String continent){
		if(getDriver().findElements(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-child(3) label[title='" + continent + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-child(3) label[title='" + continent + "']")).click();
		}
	}

	public void verifyIfOneRegionIsChecked(String continent){
		if(getDriver().findElements(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-child(3) label[title='" + continent + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + continent + "')"));
		}
	}
	
	public void verifyIfOneRegionIsNotChecked(String continent){
		if(getDriver().findElements(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-child(3) label[title='" + continent + "']")).size() == 1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + continent + "')"));
		}
	}

	public void checkAllElementsFromGeographySectionAndVerify(){
		int numberOfContinents = getDriver().findElements(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(3) > div > ul > li")).size() - 1; //[style='display: list-item;']
		System.out.println(numberOfContinents);
		int i,j;
		for(i=1; i<=numberOfContinents; i++){
			j =i+1;
			getDriver().findElement(By.cssSelector("aside[class='span2 sidebar-wrapper'] > form > div:nth-child(1) > ul > li:nth-child(3) > div > ul > li:nth-child(" + j + ") label")).click();
		}                                     
	}

	public void clickOnDateRangesToggler(){
		dateRangesToggler.click();
		Assert.assertTrue(arrowDateRangesToggler.getAttribute("class").contains("down"));
	}

	public void checkYearFromDateRangesSection(String year){
		int numberOfYears = getDriver().findElements(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(6) > ul > li")).size();
		int i;
		boolean isChecked;
		for(i=1; i<=numberOfYears; i++){
			if(getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(6) > ul > li:nth-child(" + i + ") > label")).getText().contains(year)){
				getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(6) > ul > li:nth-child(" + i + ") > label > div > span")).click();
				if(getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(6) > ul > li:nth-child(" + i + ") > label > div > span")).getAttribute("class").contains("checked")){
					isChecked = true;
				}
				else{
					isChecked = false;
				}
				Assert.assertTrue(isChecked);
			}
		}
	}

	public void uncheckYearFromDateRangesSection(String year){
		int numberOfYears = getDriver().findElements(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(6) > ul > li")).size();
		int i;
		boolean isUnchecked;
		for(i=1; i<=numberOfYears; i++){
			if(getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(6) > ul > li:nth-of-type(" + i + ") > label")).getText().contains(year)){
				getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(6) > ul > li:nth-of-type(" + i + ") > label > div > span")).click();
				if(getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(6) > ul > li:nth-of-type(" + i + ") > label > div > span")).getAttribute("class").isEmpty()){
					isUnchecked = true;
				}
				else{
					isUnchecked = false;
				}
				Assert.assertTrue(isUnchecked);
			}
		}
	}

	public void savePopUpChart() {
		Assert.assertTrue(saveChart.isDisplayed());
		saveChart.click();
		containerSavePopUp.click();
		textAreaSavePopUp.sendKeys("testareeeee");

	}
	
	public String clickSaveTheChartName(String name) {
		if(getDriver().findElements(By.cssSelector("div#dynamic_table > div.alert.alert-info")).size() == 1){
			System.out.println("There are no results");
			Assert.assertTrue(getDriver().findElements(By.cssSelector("button#dvpack-save[disabled]")).size() == 1);
		}
		else{
			Assert.assertTrue("not found!!", saveButtonFromSavePopUp.isDisplayed());
			waitABit(5000);
			int ran;
			ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
			name = name + ran;
			saveDataInputBox.sendKeys(name);
			System.out.println(name);
			//			saveButtonFromSavePopUp.click();
			elementClick("div#modal-save-dvpack > div > a:nth-child(2)");
		}
		return name;
	}

	public void clickCancelFromSaveDialogWindow() {
		if(getDriver().findElements(By.cssSelector("div#dynamic_table > div.alert.alert-info")).size() == 1){
			System.out.println("There are no results");
			Assert.assertTrue(getDriver().findElements(By.cssSelector("button#dvpack-save[disabled]")).size() == 1);
		}
		else{
			cancelSavePopUp.click();
		}
	}
	public void cancelSavePopUp(String cancel) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#modal-save-dvpack > div > a:nth-child(1)")).getText().contains(cancel));
		cancelSavePopUp.click();
	
	}
	public void displayChart() {
		displayDataButton.click();
	}

	public void expandOperatorFromFilter(String operator) {

		element(operatorListFromFilter).waitUntilVisible();
		List<WebElement> itemsList = operatorListFromFilter.findElements(By.tagName("label"));

		for(WebElement elementNow:itemsList){
			System.out.println(elementNow.getText());
			if(elementNow.getText().contains(operator)){
				elementNow.click();
				System.out.println("selected!!!");

				break;
			}

		}
	}
	
	public void expandIndicatorFromFilter(String indicator) {
		indicatorFromFilter.click();
		element(indicatorListFromFilter).waitUntilVisible();
		List<WebElement> itemsList = indicatorListFromFilter.findElements(By.cssSelector("li label"));

		for(WebElement elementNow:itemsList){
			System.out.println(elementNow.getText());
			if(elementNow.getText().contains(indicator)){
				elementNow.click();
				System.out.println("selected!!!");

				break;
			}
		}
	}

	public void testNotAvailableForDatabaseName(String databaseName){
		boolean fail = false;
		Assert.assertTrue("Test is not available for" + databaseName + "database",fail);
	}

	public void clickFilterGeographySection() {
		element(filterGeographySection).waitUntilVisible();
		filterGeographySection.click();
	}

	public void searchFilterGeographySection(String geography) {
		element(filterQuickSearch).waitUntilVisible();

		waitUntilElementDoesntExist(By.cssSelector("div.loading"),30);

		if(geography.equals("Global")){
		}
		else if(geography.equals("Africa")){
		}
		else if(geography.equals("Asia")){
		}
		else if(geography.equals("Caribbean")){
		}
		else if(geography.equals("Europe")){
		}
		else if(geography.equals("Latin America")){
		}
		else if(geography.equals("Middle East")){
		}
		else if(geography.equals("North America")){
		}
		else{
			filterQuickSearch.sendKeys(geography);
		}
	}

	public void selectOneGeograpyFromFilter(String geography) {

		element(filterGeographySectionExpanded).waitUntilVisible();

		waitUntilElementDoesntExist(By.cssSelector("div.loading"), 120);

		WebElement element = filterGeographySectionExpanded.findElement(By
				.cssSelector("label[title='" + geography + "'].checkbox"));
		element(element).click();
	}

	public void clickFilterOperatorsSection() {
		element(filterOperatorsSection).waitUntilVisible();
		filterOperatorsSection.click();
	}

	public void searchFilterOperatorsSection(String operator) {
		element(filterQuickSearchOperator).waitUntilVisible();

		waitUntilElementDoesntExist(By.cssSelector("div.loading"),120);


		if(operator.equals("123")){
		}else if(operator.equals("A")){
		}else if(operator.equals("B")){
		}else if(operator.equals("C")){
		}else if(operator.equals("D")){
		}else if(operator.equals("E")){
		}else if(operator.equals("F")){
		}else if(operator.equals("G")){
		}else if(operator.equals("H")){
		}else if(operator.equals("I")){
		}else if(operator.equals("K")){
		}else if(operator.equals("L")){
		}else if(operator.equals("M")){
		}else if(operator.equals("N")){
		}else if(operator.equals("O")){
		}else if(operator.equals("P")){
		}else if(operator.equals("Q")){
		}else if(operator.equals("R")){
		}else if(operator.equals("S")){
		}else if(operator.equals("T")){
		}else if(operator.equals("U")){
		}else if(operator.equals("V")){
		}else if(operator.equals("W")){
		}else if(operator.equals("X")){
		}else if(operator.equals("Y")){
		}else if(operator.equals("Z")){
		}
		else{
			filterQuickSearch.sendKeys(operator);
		}
	}

	public void selectOneOperatorFromFilter(String operator) {

		element(filterOperatorsSectionExpanded).waitUntilVisible();

		waitUntilElementDoesntExist(By.cssSelector("div.loading"), 120);

		WebElement element = filterOperatorsSectionExpanded.findElement(By
				.cssSelector("label[title='"+operator+"'].checkbox"));
		element(element).click();
	}

	public void clickFilterIndicatorSection() {
		element(filterIndicatorsSection).waitUntilVisible();
		filterIndicatorsSection.click();
	}

	public void searchFilterIndicatorSection(String indicator) {
		waitUntilElementDoesntExist(By.cssSelector("div.loading"),120);
		filterQuickSearch.sendKeys(indicator);
	}

	public void selectOneIndicatorFromFilter(String indicator) {
		element(filterIndicatorsSectionExpanded).waitUntilVisible();
		waitUntilElementDoesntExist(By.cssSelector("div.loading"), 120);
		WebElement element = filterIndicatorsSectionExpanded.findElement(By
				.cssSelector("label[title='"+indicator+"']"));
		element(element).click();
	}

	public void clickFilterAgeSection() {
		element(filterAgeSection).waitUntilVisible();
		filterAgeSection.click();
	}

	public void searchFilterAgeSection(String age) {
		waitUntilElementDoesntExist(By.cssSelector("div.loading"),120);
		filterQuickSearch.sendKeys(age);
	}

	public void selectOneAgeFromFilter(String age) {
		element(filterAgeSectionExpanded).waitUntilVisible();
		waitUntilElementDoesntExist(By.cssSelector("div.loading"), 120);
		WebElement element = filterAgeSectionExpanded.findElement(By
				.cssSelector("label[title='"+age+"'].checkbox"));
		element(element).click();
	}

	public void clickFilterGenderSection() {
		element(filterGenderSection).waitUntilVisible();
		filterGenderSection.click();
	}

	public void searchFilterGenderSection(String gender) {
		waitUntilElementDoesntExist(By.cssSelector("div.loading"),120);
		filterQuickSearch.sendKeys(gender);
	}

	public void selectOneGenderFromFilter(String gender) {
		element(filterGenderSectionExpanded).waitUntilVisible();
		waitUntilElementDoesntExist(By.cssSelector("div.loading"), 120);
		WebElement element = filterGenderSectionExpanded.findElement(By
				.cssSelector("label[title='"+gender+"'].checkbox"));
		element(element).click();
	}

	public boolean verifyRefreshButtonDoesNotExist(){
		WebElement dateRefreshAndExportContainer=getDriver().findElement(By.cssSelector("div.dropdown.inline-block.pull-left"));
		List<WebElement> buttons = dateRefreshAndExportContainer.findElements(By.cssSelector("button"));
		System.out.println("Number of buttons: "+buttons.size());
		boolean isNotRefresh=true;
		for(WebElement button: buttons){
			if (button.getText().contains("Refresh")){
				isNotRefresh=false;
				break;
			}
			else
				isNotRefresh=true;
		} 
		return isNotRefresh;
	}

	public void clickRefreshButton(){
		refreshButton.click();
		waitABit(8000);//the table reloads so we need to wait a bit
	}

	public String verifyNewValueAfterRefresh( double newDoubleValue, String newValue){
		String refreshDate=" ";
		if(!newValue.equals(" ")){
			double valueFromCell=Double.parseDouble(valueFirstRow.getText());
			System.out.println("valueFromCell: "+valueFromCell + " newDoubleValue: "+newDoubleValue);
			Assert.assertTrue("Table has not been refreshed ",valueFromCell==newDoubleValue);
			System.out.println("String value from cell: "+valueFirstRow.getText());
			System.out.println("Double value from cell: "+valueFromCell);
			System.out.println("String new value: "+newValue);
			System.out.println("Double new value: "+newDoubleValue);
			refreshDate=verifyLastUpdatedDateIsCurrentDateAfterRefresh(); 
		}
		return refreshDate;
	}

	public String verifyLastUpdatedDateIsCurrentDateAfterRefresh(){
		String lastUpdatedText=lastUpdatedTextLabel.getText();
		String splittedlastUpdatedText[]=lastUpdatedText.split(" ");//split to get the date
		String splittedlastUpdatedText2[]=lastUpdatedText.split(":"); //split to get the day
		String date=splittedlastUpdatedText2[1].trim();
		String day=splittedlastUpdatedText[3].trim();
		if(Integer.parseInt(day)<10){
			date="0"+date;
		}
		System.out.println("Last updated label text: " +lastUpdatedText);
		DateFormat df = new SimpleDateFormat("dd MMM yyyy");
		Date dateobj = new Date();
		System.out.println("Current date: "+df.format(dateobj));
		System.out.println("Date after splitting: "+date);
		Assert.assertTrue("Last updated date didn't modify to current date!!",df.format(dateobj).equals(date));
		return date;
	}

	public String saveTable(String name){
		saveChart.click();
		waitABit(3000);
		Assert.assertTrue("Save window not displayed!!", saveButtonFromSavePopUp.isDisplayed());
		String savedName=name+Integer.toString(StringUtils.randomNumber(10000));
		saveDataInputBox.sendKeys(savedName);
		saveButtonFromSavePopUp.click();
		waitABit(8000);
		return savedName;
	}

	public void clickSavebutton(){
		saveChart.click();
		waitABit(3000);
		Assert.assertTrue("Save window not displayed!!", saveButtonFromSavePopUp.isDisplayed());
	}

	public void verifySavedNameAndDateInSaveWindow(String savedName, String date){
		System.out.println("Name in save window: "+saveDataInputBox.getAttribute("value"));
		Assert.assertTrue("This is not the saved name",saveDataInputBox.getAttribute("value").contains(savedName));
		Assert.assertTrue("This is not the current date",saveDataInputBox.getAttribute("value").contains(date));
	}

	public void verifyRefreshWarning(){
		Assert.assertTrue(dataRefreshWarning.getText().contains("Please note: refreshing your chart and/or table may invalidate some of your chart/table annotations"));	
	}

	public void clickOnTheArrowBesideSaveButton(){
		waitABit(10000);

		if(getDriver().findElements(By.cssSelector("div#dynamic_table > div.alert.alert-info")).size() == 1){
			System.out.println("There are no results");
			Assert.assertTrue(getDriver().findElements(By.cssSelector("button#dvpack-save[disabled]")).size() == 1);
		}
		else{
			waitUntilElementExists(By.cssSelector("button[class='btn btn-small dropdown-toggle']"), 10000);
			arrowBesideSaveButton.click();
			Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#saved-data-dropdown > li:last-child > a > strong")).getText().contains("View all"));
		}
	}

	public void clickOnOneSavedDvPack(String dvPackName){
		if(getDriver().findElements(By.cssSelector("div#dynamic_table > div.alert.alert-info")).size() == 1){
			System.out.println("There are no results");
			Assert.assertTrue(getDriver().findElements(By.cssSelector("button#dvpack-save[disabled]")).size() == 1);
		}
		else{
			int numberOfSavedDataInWindow = getDriver().findElements(By.cssSelector("ul#saved-data-dropdown > li")).size() - 4;
			for(int i=3; i<=numberOfSavedDataInWindow-1; i++){
				if(getDriver().findElement(By.cssSelector("ul#saved-data-dropdown > li:nth-child(" + i + ") > a")).getText().contains(dvPackName)){
					getDriver().findElement(By.cssSelector("ul#saved-data-dropdown > li:nth-child(" + i + ") > a")).click();
					break;
				}
			}
		}
	}

	public int filterSizeBeforeExpander(){
		element(filtersArea).waitUntilPresent();
		int size = element(filtersArea).getSize().getWidth();
		System.out.println("size: " + size);
		return size;
	}

	public void waitFiltersExpander(int size){	
		element(getDriver().findElement(By.cssSelector("article#content-wrapper"))).click();
		System.out.println("old size: " + size);
		int i = 1;
		while(element(filtersArea).getSize().getWidth() != size && i < 60){
			waitABit(1000);
			i++;
			System.out.println("new size:" + element(filtersArea).getSize().getWidth());
		}
		Assert.assertTrue("Filter was not minimized or 60 seconds passed", element(filtersArea).getSize().getWidth() == size);
	}

	public String[] getDatabaseAccordingToService(String service){
		String[] databases = new String[2];
		switch(service){
		case "Power":
			databases[0]="Power Key Projects";
			databases[1]="Another database";
		break;
		
		case "Renewables":
			databases[0]="Renewable Key Projects";
			databases[1]="Feed In Tariffs";
		break;
		
		case "Infrastructure":
			databases[0]="Infrastructure Key Projects";
			databases[1]="Another database";
		break;
		
		case "Oil & Gas":
			databases[0] = "Global Refineries";
			databases[1]= "Upstream Projects";
		break;
			
		case "Mining":
			databases[0]="Global Mines";
			databases[1]="Another database";
		break;
		
		case "Telecommunications":
			databases[0]="Mobile Operators";
			databases[1]="Another database";
		break;
		
		case "Pharmaceuticals & Healthcare":
			databases[0]="Burden of Disease";
			databases[1]="Another database";
		break;
		
		case "Company Intelligence":
			databases[0]="Key Executive Contacts";
			databases[1]="Another database";
		break;
		
		case "Medical Devices":
			databases[0]="Medical Distributors Guide";
			databases[1]="Another database";
		break;
		
		}
		return databases;
	}
	
	public void verifyMessagesForDisplayingLargeAmountOfData(){
		waitUntilElementExists(By.cssSelector("div#dynamic_chart > div.alert.alert-info"), 150);
		Assert.assertTrue(alertMessageForChart.getText().contains("Please refine your selection, charts cannot contain more than 20 data series"));
		Assert.assertTrue(alertMessageForTable.getText().contains("Please refine your selection, tables cannot contain more than 1000 data series"));
	}
	/**
	 * This method clicks on a databases according to a service associated to it
	 * @param service - the service associated to the database e.g. Renewables - Renewable Key Projects
	 * @param databaseNumber - which database to select if the service has more than one associated database e.g. Oil & Gas - Global Refineries, Upstream Projects e.g. databaseNumber =0 is Global Refiniries
	 */
	public void clickOnBMIDatabaseAccordingToService(String service, int databaseNumber){
		String[] databases;
	    databases = getDatabaseAccordingToService(service);
        selectDatabaseFromDropdownList(databases[databaseNumber]);
	}
	
	public void verifyUnentitledDatabases(String entitledService){
		
		WebElement databasesContainer=getDriver().findElement(By.cssSelector("article.span10"));
		List<WebElement> lines=databasesContainer.findElements(By.cssSelector("div[class*='row-fluid']"));
		
		for(int i=1; i<=lines.size();i++){
			List<WebElement> databases=getDriver().findElements(By.cssSelector("article.span10 >div:nth-of-type("+i+") > *"));
			
			for(int j=1; j<=databases.size();j++){
				if(getDriver().findElements(By.cssSelector("article.span10 >div:nth-of-type("+i+") > div:nth-of-type("+j+") > *")).size()!=0){
				    if(getDriver().findElement(By.cssSelector("article.span10 > div:nth-of-type("+i+") > div:nth-of-type("+j+")")).getAttribute("class").contains("disabled")){
					    getDriver().findElement(By.cssSelector("article.span10 > div:nth-of-type("+i+") > div:nth-of-type("+j+") > h4 > a")).click();
					    waitABit(2000);
//					    BusinessRulesWidgetsPage brwPage=new BusinessRulesWidgetsPage(getDriver());
//					    brwPage.verifyPermissionModalByType("service");
					}
				}
			}
		}
	}
	
	public void verifyEntitledDatabasesAccordingToService(String entitledService){
		String[] databasesArray;
	    databasesArray=getDatabaseAccordingToService(entitledService);
		WebElement databasesContainer=getDriver().findElement(By.cssSelector("article.span10"));
		List<WebElement> lines=databasesContainer.findElements(By.cssSelector("div[class*='row-fluid']"));
		
		for(int i=1; i<=lines.size();i++){
			List<WebElement> databases=getDriver().findElements(By.cssSelector("article.span10 > div:nth-of-type("+i+") > *"));
			
			for(int j=1; j<=databases.size();j++){
				if(getDriver().findElements(By.cssSelector("article.span10 >div:nth-of-type("+i+") > div:nth-of-type("+j+") > *")).size()!=0){
				for(int k=0;k<databasesArray.length;k++){
					if(getDriver().findElement(By.cssSelector("article.span10 >div:nth-of-type("+i+") > div:nth-of-type("+j+") > h4 > a")).getText().contains(databasesArray[k])){
					Assert.assertTrue("Entitled database is disabled",!getDriver().findElement(By.cssSelector("article.span10 > div:nth-of-type("+i+") > div:nth-of-type("+j+")")).getAttribute("class").contains("disabled"));
						}
					}
				}
			}
		}
	}
	
	public void verifyEntitledDatabasesFromDropDownAccordingToService(String entitledService){
		String[] databasesArray;
		databasesArray=getDatabaseAccordingToService(entitledService);
		WebElement bmiDatabaseDropDown=getDriver().findElement(By.cssSelector("select.input-block-level"));
		Select bmiDatabasesDropdown=new Select(bmiDatabaseDropDown);
		List<WebElement> databaseOptions=bmiDatabasesDropdown.getOptions();
		
		for(int i=1;i<databaseOptions.size();i++){
			System.out.println("Database from drop down: "+databaseOptions.get(i).getText());
		      	Assert.assertTrue("Unentitled database is displayed",databaseOptions.get(i).getText().contains(databasesArray[0])||databaseOptions.get(i).getText().contains(databasesArray[databasesArray.length-1]));
		}
	}
	
	public void verifyGeographyIsDeselected(String country,String continent){
		boolean isContinentSelected,isCountrySelected;
		waitUntilElementDoesntExist(By.cssSelector("div.click-blocker"), 50);
		if(!country.equals("")){
		isCountrySelected=verifyElementState("document.getElementById('"+country+"')");
		Assert.assertFalse("Checkbox is checked",isCountrySelected);
		}
		else{
			System.out.println("Country is empty");
		}
		if(!continent.equals("")){
		isContinentSelected=verifyElementState("document.getElementById('"+continent+"')");
		Assert.assertFalse("Checkbox is checked",isContinentSelected);
		}
		else{
			System.out.println("Continent is empty");
		}
	}
}
package bmo5.bmo5tests.adm.pages.dvpakcs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;


public class Create_StaticDvPack_WidgetType_SelectOptionPage extends AbstractAdmPage {

	@FindBy(css="div#breadcrumb div:nth-child(2) >  div:nth-child(1) > a:nth-child(1)")
	private WebElement newbutton;
	
	@FindBy(id="name")
	private WebElement dvpackname;
	
	@FindBy(id="title")
	private WebElement dvpacktitle;
	
	@FindBy(id="subtitle")
	private WebElement dvpacksubtitle;
	
	@FindBy(css = "input#description")
	private WebElement dvpackdescription;
	
	@FindBy(id="app_type_widget")
	private WebElement typewidget;
	
	@FindBy (id = "default_view_DynamicChart")
	private WebElement defaultviewchart;
	
	@FindBy (id = "default_view_WebTable")
	private WebElement defaultviewtable;
	
	@FindBy (css="div.form-actions button")
	private WebElement continuebutton;
	
	@FindBy (css="div#breadcrumb > div:nth-child(1) > span:nth-child(3)")
	private WebElement breadcrumb;
	
	@FindBy (css="div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(4) > div:nth-child(2) > label")
	private WebElement titleinput;
	
	@FindBy (id = "back")
	private WebElement backbutton;
	
	@FindBy (css="button[class='btn pull-right']")
	private WebElement editDVPackContinuebutton;
	
	@FindBy(css="button.btn.pull-right")
	private WebElement continuebutton2;
	
	@FindBy (css="div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h3")
	private WebElement charttitle;
	
	@FindBy (css="div#breadcrumb >  div:nth-child(2) > button#continue-w")
	private WebElement continuebutton3;
	
	@FindBy (css="div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)>h3")
	private WebElement chartstitle;
	
	@FindBy (id="continue")
	private WebElement aprovecontinue;
	
	@FindBy (css=" div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > h4")
	private WebElement message;
	
	@FindBy (id="list")
	private WebElement dvpacklist;
	
	@FindBy (css="table#DataTables_Table_0 > thead > tr > th:nth-child(6)")
	private WebElement datecreated;
	
	@FindBy (css="table#DataTables_Table_0 > tbody > tr:nth-child(1) > td:nth-child(2)")
	private WebElement namefromtable;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(2) > label:nth-child(1) > input")
	private WebElement global;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(3) > label:nth-child(2) > input")
	private WebElement africa;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(4) > label:nth-child(2) > input")
	private WebElement asia;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(5) > label:nth-child(2) >  input")
	private WebElement caribbean;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(6) > label:nth-child(2) >  input")
	private WebElement europe;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(7) > label:nth-child(2) >  input")
	private WebElement latinamerica;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(8) > label:nth-child(2) >  input")
	private WebElement middleeast;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(9) > label:nth-child(2) >  input")
	private WebElement northamerica;
	
	@FindBy (css="input.input-block-level")
	private WebElement searchfilter;
	
	@FindBy (css=" li.nav-header > ul:nth-child(3) > li:nth-child(43) > label > div > span > input")
	private WebElement country;
	
	@FindBy (css="li.nav-header > h5 > span.pull-right > i.icon-right-dir")
	private WebElement indicatorSection;
	
	@FindBy (css="h5[data-section-name='metals']")
	private WebElement metalIndicatorSection;
	
	@FindBy (css="div[class='sidebar well'] > ul:nth-child(2) > li > ul:nth-child(2) > li > label")
	private WebElement metalIndicator;
	
	@FindBy (css="li.nav-header > div.expandable-wrapper > ul:nth-child(2) > li.quick-search > input.input-block-level")
	private WebElement indicatorFilter;
	
	@FindBy (css="li.nav-header > div.expandable-wrapper > ul.nav.nav-list")
	private WebElement filterIndicatorSectionExpanded;
	
	@FindBy (css="div[class='sidebar well'] > ul:nth-child(2) > li > ul:nth-child(2)")
	private WebElement filterMetalIndicatorSectionExpanded;
	
	@FindBy (css="li.nav-header > div:nth-child(2) > ul:nth-child(2)")
	private WebElement dataRangeSection;
	
	@FindBy (css="button#filter-display-data")
	private WebElement displayDataButton;
	
	@FindBy (css="text.highcharts-title > tspan")
	private WebElement chartTitle;
	
	@FindBy (css="li.nav-header > ul.nav.nav-list")
	private WebElement filterGeographySectionExpanded;
	
	@FindBy (css="ul.nav.nav-list > li.nav-header > ul.nav.nav-list.dropdown-list.show")
	private WebElement filterDateRangesSectionExpanded;
	
	@FindBy (css="div.sidebar.well > ul:nth-child(3) > li.nav-header > h5 > span.pull-right > i.icon-right-dir")
	private WebElement dateranges;
	
	@FindBy (css="div#breadcrumb div:nth-child(2) >  div:nth-child(1) > a:nth-child(2)")
	private WebElement helpButton;
	
	@FindBy (css="div#help > div:nth-child(1) > h3:nth-child(2)")
	private WebElement helpWindowTitle;
	
	@FindBy (css="div#help > div:nth-child(3) > button")
	private WebElement helpWindowCloseButton;
	
	@FindBy (css="div#dynamic_chart")
	private WebElement chartContainer;
	
	@FindBy (css="button#load-dvpack-select")
	private WebElement selectButton;
	
	@FindBy (css="ul#sortable > li:nth-child(1) > label > input")
	private WebElement geo_indicator1;
	
	@FindBy (css="button#apply-select")
	private WebElement applyButton;
	
	@FindBy (css="button#reset-select")
	private WebElement resetButton;
	
	@FindBy (css="div.right-side > div:nth-child(2) > div:nth-child(1) > h3")
	private WebElement tableTitle;
	
	@FindBy (css="div.right-side > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > h4:nth-child(2)")
	private WebElement tableTitlePreview;
	
	@FindBy (css="div.right-side > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > h3")
	private WebElement tableNamePreview;
	
	@FindBy (css="div.right-side > div:nth-child(2) > h4")
	private WebElement messageTable;
	
	//@FindBy (css="svg")
	//private WebElement svgElement;
	
	@FindBy (css="button#continue")
	private WebElement continueButtonTable;
	
	@FindBy(css = "button#all_Geography_rightAll")
	private WebElement moveAllGeographiesToRightPanelButton;
	
	@FindBy(css = "button#all_Services_rightAll")
	private WebElement moveAllServicesToRightPanelButton;
	
	@FindBy(css = "button#all_Companies_rightAll")
	private WebElement moveAllCompaniesToRightPanelButton;
	
	@FindBy(css = "div#breadcrumb > div:nth-child(2) > button#list")
	private WebElement dvPackList;
	
	@FindBy(css = "div.dataTables_filter > label > input")
	private WebElement searchDvPackField;
	
	@FindBy(css = "tr[class='data-entry odd'] > td:nth-child(2)")
	private WebElement tableNameColumn;
	
	@FindBy(css = "tr[class='data-entry odd'] > td:nth-child(3)")
	private WebElement tableTitleColumn;
	
	@FindBy(css = "tr[class='data-entry odd'] > td:nth-child(11)")
	private WebElement tableDatabaseTypeColumn;
	
	@FindBy(css = "select#primary_service")
	private WebElement primaryChannelDropDown;
	
	@FindBy(css = "select#primary_iso")
	private WebElement primaryGeographyDropDown;
	
	@FindBy(css = "select#primary_company")
	private WebElement primaryCompanyDropDown;
	
	@FindBy(css = "tr[class='data-entry odd'] > td:nth-child(12)")
	private WebElement tableTypeColumn;
	
	@FindBy(css = "table > tbody > tr:nth-child(1) > td:nth-child(1)")
	private WebElement regionColumnDisplayedTable;
	
	@FindBy(css = "table > tbody > tr:nth-child(1) > td:nth-child(2)")
	private WebElement countryColumnDisplayedTable;
	
	@FindBy(css = "table > tbody > tr:nth-child(1) > td:nth-child(3)")
	private WebElement indicatorColumnDisplayedTable;
	
	@FindBy(css = "tr[class='data-entry odd'] > td:nth-child(1)")
	private WebElement tableDvPackIdColumn;
	
	public void displayHelpWindow() {
		helpButton.click();
		waitABit(2000);
		Assert.assertTrue("The help window title is not correct", helpWindowTitle.getText().contains("Help")); 
		helpWindowCloseButton.click();
	}
	
	public void createDvPackChartNDB(String name, String title, String subtitle, String description, String type, String databasetype) {
		newbutton.click();
		defaultviewchart.click();
		dvpackname.sendKeys(name);
		dvpacktitle.sendKeys(title);
		dvpacksubtitle.sendKeys(subtitle);
		dvpackdescription.click();
		dvpackdescription.sendKeys(description);
		Select dvpacktype = new Select(getDriver().findElement(
				By.cssSelector("select#type")));
		dvpacktype.selectByValue(type);
		Select database = new Select(getDriver().findElement(
				By.cssSelector("select#database")));
		database.selectByValue(databasetype);
		typewidget.click();
		continuebutton.click();
		
	}
	
	public void createDvPackTableLead(String name, String title, String subtitle, String description, String type, String databasetype) {
		newbutton.click();
		dvpackname.sendKeys(name);
		dvpacktitle.sendKeys(title);
		dvpackdescription.sendKeys(description);
		Select dvpacktype = new Select(getDriver().findElement(
				By.cssSelector("select#type")));
		dvpacktype.selectByValue(type);
		Select database = new Select(getDriver().findElement(
				By.cssSelector("select#database")));
		database.selectByValue(databasetype);
		typewidget.click();
		defaultviewtable.click();
		continuebutton.click();
		
	}
	public void verifyStaticDvPack() {
		Assert.assertTrue("The breadcrumb is not correct", breadcrumb.getText().contains("Create Static DV Pack")); 
 
	}
	
	public void verifyBackbutton(String name, String title, String subtitle, String description, String type, String databasetype) {
		backbutton.click();
		String backdvpackname=getDriver().findElement(By.cssSelector("input#name")).getAttribute("value");
		String backtitle=getDriver().findElement(By.cssSelector("input#title")).getAttribute("value");
		String backsubtitle=getDriver().findElement(By.cssSelector("input#subtitle")).getAttribute("value");
		String backdvpacktype=getDriver().findElement(By.cssSelector("select#type")).getAttribute("value");
		String backdatabase=getDriver().findElement(By.cssSelector("select#database")).getAttribute("value");
		if(name.equals(backdvpackname) && title.equals(backtitle) && subtitle.equals(backsubtitle) && databasetype.equals(backdatabase) && type.equals(backdvpacktype)){System.out.println("Back button works");}
		else {System.out.println("Back button does not work.");}
		continuebutton2.click();
	}
	
	public void selectGeography (String searchGeography) {
		System.out.println("Geography : " + searchGeography );
		if(searchGeography.equals("Global")){ global.click();
		}
		else if(searchGeography.equals("Africa")){ africa.click();
		}
		else if(searchGeography.equals("Asia")){ asia.click();
		}
		else if(searchGeography.equals("Caribbean")){ caribbean.click();
		}
		else if(searchGeography.equals("Europe")){ europe.click();
		}
		else if(searchGeography.equals("Latin America")){ latinamerica.click();
		}
		else if(searchGeography.equals("Middle East")){ middleeast.click();
		}
		else if(searchGeography.equals("North America")){ northamerica.click();
		}
		else{
			
		searchfilter.sendKeys(searchGeography);
		waitABit(3000);
		element(filterGeographySectionExpanded).waitUntilVisible();
		WebElement element = filterGeographySectionExpanded.findElement(
				By.cssSelector("label[title='"+searchGeography+"'].checkbox"));
		element(element).click();
		}
	}
	
	public void selectIndicator(String indicator) {
		System.out.println("Indicator : " + indicator);
		indicatorSection.click();
		element(filterIndicatorSectionExpanded).waitUntilVisible();
		waitABit(30000);
		indicatorFilter.sendKeys(indicator);
		waitUntilElementDoesntExist(By.cssSelector("div.loading"),30);
		element(filterIndicatorSectionExpanded.findElement(
				By.cssSelector("label[title='"+indicator+"']"))).click();
	
	}
	
	public void selectDateRanges(String dateRanges) {
		System.out.println("DateRanges : " + dateRanges);
		dateranges.click();
		element(filterDateRangesSectionExpanded).waitUntilVisible();
		waitUntilElementDoesntExist(By.cssSelector("div.loading"),30);
		System.out.println("DateRanges : " + dateRanges);
	
		List<WebElement> allElements = filterDateRangesSectionExpanded
				.findElements(By.cssSelector(" li label "));

		for (WebElement region : allElements) {
			if (region.getText().equals(dateRanges)) {
				region.click();
				break;
			}
		}
	}
	
	public void displayChart(String title) {
		displayDataButton.click();
		Assert.assertTrue("The breadcrumb is not correct", chartTitle.getText().contains(title));
	}

	public void displaySelectWindow() {
		element(getDriver().findElement(
				By.cssSelector("div#dynamic_chart"))).waitUntilVisible();
		WebElement element = getDriver().findElement(By.cssSelector("button#load-dvpack-select"));
		element.click();
//		evaluateJavascript("$('button#load-dvpack-select').click();");
//		selectButton.click();
		String winHandleBefore = getDriver().getWindowHandle();
	    for (String winHandle : getDriver().getWindowHandles()) {
	     getDriver().switchTo().window(winHandle);
	    }
	    element(applyButton).waitUntilVisible();
		geo_indicator1.click();
		waitABit(1000);
		applyButton.click();
		waitABit(1000);
		getDriver().switchTo().window(winHandleBefore);
		waitABit(3000);
		selectButton.click();
		winHandleBefore = getDriver().getWindowHandle();
	    for (String winHandle : getDriver().getWindowHandles()) {
	     getDriver().switchTo().window(winHandle);
	    }
		element(resetButton).waitUntilVisible();
		resetButton.click();
		getDriver().switchTo().window(winHandleBefore);
		
	}
		
	public void selectMetalIndicator(String indicatorLabel) {
		metalIndicatorSection.click();
		element(filterMetalIndicatorSectionExpanded).waitUntilVisible();
		WebElement metalIndicator=getDriver().findElement(By.cssSelector("input[value="+indicatorLabel+"]"));
		metalIndicator.click();
		waitABit(5000);
	}
	
	public void displayTable(String primaryGeography, String searchGeography, String metalIndicator) {
		displayDataButton.click();
		element(getDriver().findElement(By.cssSelector("div#dynamic_table"))).waitUntilVisible();
		Assert.assertTrue("The table was not created", regionColumnDisplayedTable.getText().contains(primaryGeography));
		Assert.assertTrue("The table was not created", countryColumnDisplayedTable.getText().contains(searchGeography));
		Assert.assertTrue("The table was not created", indicatorColumnDisplayedTable.getText().contains(metalIndicator));
	}
	
	public void saveDvPackTableLead(String title,String name, String tableMessage, String primaryGeography, String primaryChannel, String primaryCompany, String searchGeography, String metalIndicator) {
		continueButtonTable.click();
		element(getDriver().findElement(By.cssSelector("select#all_Geography"))).waitUntilVisible();
		Assert.assertTrue("The title is not correct", tableTitle.getText().contains(title));
		moveAllGeographiesToRightPanelButton.click();
		waitABit(2000);
		selectFromDropdown(primaryGeographyDropDown, primaryGeography);
		moveAllServicesToRightPanelButton.click();
		waitABit(2000);
		selectFromDropdown(primaryChannelDropDown, primaryChannel);
		moveAllCompaniesToRightPanelButton.click();
		waitABit(2000);
		selectFromDropdown(primaryCompanyDropDown, primaryCompany);
		waitABit(2000);
		continueButtonTable.click();
		element(getDriver().findElement(By.cssSelector("div#dynamic_table"))).waitUntilVisible();
		Assert.assertTrue("The tabletitlePreview is not correct", tableTitlePreview.getText().contains(title));
		Assert.assertTrue("The tableNamePreview is not correct", tableNamePreview.getText().contains(name));
		Assert.assertTrue("The table was not created", regionColumnDisplayedTable.getText().contains(primaryGeography));
		Assert.assertTrue("The table was not created", countryColumnDisplayedTable.getText().contains(searchGeography));
		Assert.assertTrue("The table was not created", indicatorColumnDisplayedTable.getText().contains(metalIndicator));
		waitABit(2000);
		continueButtonTable.click();
		element(messageTable).waitUntilVisible();
		Assert.assertTrue("The table was not created", messageTable.getText().contains(tableMessage));
}
	public String checkTableIntoListView(String name, String title, String databaseType, String type) {
		waitABit(2000);
		dvPackList.click();
		waitABit(2000);
		element(getDriver().findElement(By.cssSelector("div.dvpacks-table"))).waitUntilVisible();
		System.out.println("tableName : " + name);
		searchDvPackField.click();
		searchDvPackField.sendKeys(name);
		element(getDriver().findElement(By.cssSelector("tr[class='data-entry odd']"))).waitUntilVisible();
		Assert.assertTrue("The tableNameColumn is not correct", tableNameColumn.getText().contains(name));
		Assert.assertTrue("The tableTitleColumn is not correct", tableTitleColumn.getText().contains(title));
		Assert.assertTrue("The tableDatabaseTypeColumn is not correct", tableDatabaseTypeColumn.getText().contains(databaseType));
		Assert.assertTrue("The tableTypeColumn is not correct", tableTypeColumn.getText().contains(type));
		return tableDvPackIdColumn.getText();
}
	
	public void deleteFirstDVPackWidget(){
		getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr.data-entry.odd > td:nth-child(13) > a:nth-child(3)")).click();
		waitABit(3000);
		getDriver().findElement(By.cssSelector("div[class='bootbox modal fade in'] div.modal-footer a.btn.btn-primary")).click();
	}
	
	public void deleteOneItemFromList(String idDvPack){
		//TODO fix this
//		ManageWidgetsPage manage = new ManageWidgetsPage(getDriver());
//		manage.selectRecordsPerPageAndVerify("All");
		int numberOfItems = getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody >tr")).size();
		for(int i=1; i<=numberOfItems; i++){
			if(getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody >tr:nth-child(" + i + ") > td:nth-child(1)")).getText().equals(idDvPack)){
				getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody >tr:nth-child(" + i + ") > td:nth-child(13) > a:nth-child(3)")).click();
				waitABit(3000);
				getDriver().findElement(By.cssSelector("div[class='bootbox modal fade in'] div.modal-footer a.btn.btn-primary")).click();
				break;
			}
		}
		waitABit(5000);
//		manage.searchInputAndVerify(idDvPack);
//		manage.selectRecordsPerPageAndVerify("All");
		int numberOfItemsNew = getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody >tr")).size();
		if(numberOfItemsNew ==1){
			if(getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody >tr > td.dataTables_empty")).size()==1){
				System.out.println("There is no item anymore in list");
				Assert.assertTrue(numberOfItems == numberOfItemsNew);
			}
			else{
				Assert.assertTrue(numberOfItemsNew == numberOfItems - 1);
			}
		}
	}
}

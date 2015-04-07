package bmo5.bmo5tests.adm.pages.dvpakcs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;


public class Create_And_Delete_CMSTemplateDvPackTablePage extends AbstractAdmPage {

	@FindBy(css="div#breadcrumb div:nth-child(2) >  div:nth-child(1) > a:nth-child(1)")
	private WebElement newbutton;
	
	@FindBy(id="name")
	private WebElement dvpackname;
	
	@FindBy(id="title")
	private WebElement dvpacktitle;
	
	@FindBy(css = "input#description")
	private WebElement dvpackdescription;
	
	@FindBy(css = "input#app_type_cms_template")
	private WebElement cmstemplatebutton;
	
	@FindBy (css = "input#default_view_WebTable")
	private WebElement defaultviewtable;
	
	@FindBy (css="div.form-actions button")
	private WebElement continuebutton;
	
	@FindBy (id = "back")
	private WebElement backbutton;
	
	@FindBy (css="input.custom-indicator-checkbox")
	private WebElement customIndicator;
	
	@FindBy (css="ul.nav.nav-list.dropdown-list > li:last-child > button")
	private WebElement customIndicatorExpander;
	
	@FindBy (css="textarea[name='custom_indicators']")
	private WebElement customIndicatorTextarea;
	
	@FindBy (css="h5[data-section-name='date_ranges']")
	private WebElement dateRangesTab;
	
	@FindBy(css="button.btn.pull-right")
	private WebElement continuebutton2;

	@FindBy (css="div#breadcrumb div:nth-child(2) >  div:nth-child(1) > a:nth-child(2)")
	private WebElement helpButton;
	
	@FindBy (css="div#help > div:nth-child(1) > h3:nth-child(2)")
	private WebElement helpWindowTitle;
	
	@FindBy (css="div#help > div:nth-child(3) > button")
	private WebElement helpWindowCloseButton;
	
	@FindBy (css="div#breadcrumb > div:nth-child(1) > span:nth-child(3)")
	private WebElement breadcrumbCreatePage;
	
	@FindBy (css="button#filter-preview-data")
	private WebElement displayDataButton1;
	
	@FindBy (css="div#modal-geographies")
	private WebElement geographiesWindow;
	
	@FindBy (css="div#modal-geographies > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > ul:nth-child(2) > li:nth-child(4) > button")
	private WebElement region;
	
	@FindBy (css="div#modal-geographies > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > ul:nth-child(2) > li:nth-child(4) > ul:nth-child(3) > li:nth-child(2) > label > input")
	private WebElement geography;
	
	@FindBy (css="button#filter-display-data")
	private WebElement displayDataButton2;
	
	@FindBy (css="div#dynamic_table")
	private WebElement table;
	
	@FindBy (css="button#continue")
	private WebElement continueButton;
	
	@FindBy (css="tbody > tr:nth-child(1) > td:nth-child(1)")
	private WebElement countryColumnTable;
	
	@FindBy (css="tbody > tr:nth-child(1) > td:nth-child(2)")
	private WebElement indicator1ColumnTable;
	
	@FindBy (css="tbody > tr:nth-child(2) > td:nth-child(2)")
	private WebElement indicator2ColumnTable;
	
	@FindBy (css="div.right-side > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > h4:nth-child(2)")
	private WebElement tableTitlePreviewPage;
	
	@FindBy (css="div.right-side > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > h3")
	private WebElement tableNamePreviewPage;
	
	@FindBy (css="div#breadcrumb > div:nth-child(1) > span:nth-child(3)")
	private WebElement breadcrumbPreviewPage;
	
	@FindBy (css="div.right-side > div:nth-child(2) > h4")
	private WebElement messageTable;
	
	@FindBy (css="div#breadcrumb > div:nth-child(1) > span:nth-child(3)")
	private WebElement breadcrumbConfirmationPage;
	
	@FindBy (css="button#list")
	private WebElement dvPackButtonList;
	
	@FindBy(css = "div.dataTables_filter > label > input")
	private WebElement searchDvPackField;
	
	@FindBy(css = "tr[class='data-entry odd'] > td:nth-child(2)")
	private WebElement tableNameColumn;
	
	@FindBy(css = "tr[class='data-entry odd'] > td:nth-child(3)")
	private WebElement tableTitleColumn;
	
	@FindBy(css = "tr[class='data-entry odd'] > td:nth-child(11)")
	private WebElement tableDatabaseTypeColumn;
	
	@FindBy(css = "tr[class='data-entry odd'] > td:nth-child(12)")
	private WebElement tableTypeColumn;
	
	@FindBy(css = "a[class='btn btn-link btn-link-delete delete']")
	private WebElement deleteButtonFirstDvPack;
	
	@FindBy(css = "a[class='btn btn-primary']")
	private WebElement okButtonDeleteWindow;
	
	@FindBy(css = "div[class='alert alert-success']")
	private WebElement deleteNotification;
	
	@FindBy(css = "div[id^='DataTables']")
	private WebElement showResults;
	
	@FindBy(css = "button#load-dvpack-select")
	private WebElement selectButton;
	
	@FindBy(css = "button#apply-select")
	private WebElement applyButton;
	
	@FindBy(css = "form[class='clearfix form-horizontal-select']")
	private WebElement selectWindow;
	
	@FindBy(css = "ul#sortable > li:nth-child(2) > label > input")
	private WebElement indicator2Checkbox;
	
	public void displayHelpWindow() {
		helpButton.click();
		waitABit(2000);
		Assert.assertTrue("The help window title is not correct", helpWindowTitle.getText().contains("Help")); 
		helpWindowCloseButton.click();
	}
	
	public void createTemplateDvPackTable(String name, String title, String subtitle, String description, String type, String databasetype) {
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
		cmstemplatebutton.click();
		defaultviewtable.click();
		continuebutton.click();
		
	}

	public void verifyBackbutton(String name, String title, String subtitle, String description, String type, String databasetype) {
		backbutton.click();
		String backdvpackname=getDriver().findElement(By.cssSelector(" input#name")).getAttribute("value");
		String backtitle=getDriver().findElement(By.cssSelector("input#title")).getAttribute("value");
		String backsubtitle=getDriver().findElement(By.cssSelector("input#subtitle")).getAttribute("value");
		String backdvpacktype=getDriver().findElement(By.cssSelector("select#type")).getAttribute("value");
		String backdatabase=getDriver().findElement(By.cssSelector("select#database")).getAttribute("value");
		if(name.equals(backdvpackname) && title.equals(backtitle) && subtitle.equals(backsubtitle) && databasetype.equals(backdatabase) && type.equals(backdvpacktype)){System.out.println("Back button works");}
		else {System.out.println("Back button does not work.");}
		continuebutton2.click();
	}
	
	public void selectIndicators(String indicator1, String indicator2, String dateRangeValue) {
		element(breadcrumbCreatePage).waitUntilVisible();
		Assert.assertTrue("The breadcrumb is not correct", breadcrumbCreatePage.getText().contains("Create Template DV Pack")); 
		customIndicator.click();
		customIndicatorExpander.click();
		customIndicatorTextarea.sendKeys(indicator1 + ' ');
		customIndicatorTextarea.sendKeys(indicator2);
		dateRangesTab.click();
		waitABit(1000);
		Select dateRange = new Select(getDriver().findElement(
				By.cssSelector("select#end_date")));
		dateRange.selectByValue(dateRangeValue);
		displayDataButton1.click();
		element(geographiesWindow).waitUntilVisible();
		region.click();
		element(geography).waitUntilVisible();
		geography.click();
		displayDataButton2.click();
		
	}
	public void displayTable() {
			element(table).waitUntilVisible();
			Assert.assertTrue("The table was not created", countryColumnTable.getText().contains("Australia"));
			Assert.assertTrue("The table was not created", indicator1ColumnTable.getText().contains("Capacity, Net, % y-o-y"));
			Assert.assertTrue("The table was not created", indicator2ColumnTable.getText().contains("Generation, Wind, TWh"));
			selectButton.click();
			element(selectWindow).waitUntilVisible();
			indicator2Checkbox.click();
			applyButton.click();
			waitABit(2000);
			Assert.assertTrue(getDriver().findElements(By.cssSelector("tbody > tr:nth-child(2) > td:nth-child(2)")).size() == 0);
			continueButton.click();
		}
		
	public void saveTablePreviewPage(String name, String title, String tableMessage) {
		element(table).waitUntilVisible();
		Assert.assertTrue("The breadcrumb is not correct", breadcrumbPreviewPage.getText().contains("Preview DV Pack")); 
		Assert.assertTrue("The table name is not correct", tableNamePreviewPage.getText().contains(name));
		Assert.assertTrue("The table title is not correct", tableTitlePreviewPage.getText().contains(title));
		Assert.assertTrue("The table was not created", countryColumnTable.getText().contains("Australia"));
		Assert.assertTrue("The table was not created", indicator1ColumnTable.getText().contains("Capacity, Net, % y-o-y"));
		continueButton.click();
		waitABit(2000);
		Assert.assertTrue("The table was not created", messageTable.getText().contains(tableMessage));
		Assert.assertTrue("The breadcrumb is not correct", breadcrumbConfirmationPage.getText().contains("Confirmation")); 
	}
	
	public void checkTableIntoListView(String name, String title, String databaseType, String type, String deleteMessage, String showNoResults) {
		dvPackButtonList.click();
		element(newbutton).waitUntilVisible();
		searchDvPackField.click();
		searchDvPackField.sendKeys(name);
		Assert.assertTrue("The tableNameColumn is not correct", tableNameColumn.getText().contains("CMSTemplate" + ' ' + name));
		Assert.assertTrue("The tableTitleColumn is not correct", tableTitleColumn.getText().contains(title));
		Assert.assertTrue("The tableDatabaseTypeColumn is not correct", tableDatabaseTypeColumn.getText().contains(databaseType));
		Assert.assertTrue("The tableTypeColumn is not correct", tableTypeColumn.getText().contains(type));
		deleteButtonFirstDvPack.click();
		okButtonDeleteWindow.click();
		element(deleteNotification).waitUntilVisible();
		Assert.assertTrue("The DvPack was not deleted", deleteNotification.getText().contains(deleteMessage)); 
		searchDvPackField.sendKeys(name);
		Assert.assertTrue("The DvPack was not deleted", showResults.getText().contains(showNoResults)); 
	}
	}
package bmo5.bmo5tests.adm.pages.dvpakcs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;


public class Create_TemplateDvPackTable_SystemType_GlobalMinesPage extends AbstractAdmPage {

	@FindBy(css="div#breadcrumb div:nth-child(2) >  div:nth-child(1) > a:nth-child(1)")
	private WebElement newbutton;
	
	@FindBy(id="name")
	private WebElement dvpackname;
	
	@FindBy(id="title")
	private WebElement dvpacktitle;
	
	@FindBy(css = "input#description")
	private WebElement dvpackdescription;
	
	@FindBy(id="app_type_widget")
	private WebElement typewidget;
	
	@FindBy (id = "default_view_DynamicTable")
	private WebElement defaultviewtable;
	
	@FindBy (css="div.form-actions button")
	private WebElement continuebutton;
	
	@FindBy (id = "back")
	private WebElement backbutton;
	
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
	
	@FindBy (css="li.nav-header > ul:nth-child(2) > li:nth-child(7) > label > input")
	private WebElement metalIndicator;
	
	@FindBy (css="div[class='sidebar well'] > ul:nth-child(2) > li > h5")
	private WebElement companySection;
	
	@FindBy (css="ul[class='companies nav nav-list dropdown-list'] > li:nth-child(6) > label:nth-child(2) > input")
	private WebElement companyIndicator1;
	
	@FindBy (css="ul[class='companies nav nav-list dropdown-list'] > li:nth-child(7) > label:nth-child(2) > input")
	private WebElement companyIndicator2;
	
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
	private WebElement regionColumnTable;
	
	@FindBy (css="tbody > tr:nth-child(1) > td:nth-child(2)")
	private WebElement countryColumnTable;
	
	@FindBy (css="tbody > tr:nth-child(1) > td:nth-child(3)")
	private WebElement metalColumnTable;
	
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
		typewidget.click();
		//defaultviewtable.click();
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
	
	public void selectIndicators() {
		element(breadcrumbCreatePage).waitUntilVisible();
		Assert.assertTrue("The breadcrumb is not correct", breadcrumbCreatePage.getText().contains("Create Template DV Pack")); 
		metalIndicator.click();
		System.out.println("MetalIndicator : Nickel" );
		companySection.click();
		element(companyIndicator1).waitUntilVisible();
		companyIndicator1.click();
		companyIndicator2.click();
		displayDataButton1.click();
		element(geographiesWindow).waitUntilVisible();
		region.click();
		element(geography).waitUntilVisible();
		geography.click();
		displayDataButton2.click();
		
	}
	public void displayTable() {
			element(table).waitUntilVisible();
			Assert.assertTrue("The table was not created", regionColumnTable.getText().contains("Asia"));
			Assert.assertTrue("The table was not created", countryColumnTable.getText().contains("Australia"));
			Assert.assertTrue("The table was not created", metalColumnTable.getText().contains("Nickel"));
			continueButton.click();
		}
		
	public void saveTablePreviewPage(String name, String title, String tableMessage) {
		element(table).waitUntilVisible();
		Assert.assertTrue("The breadcrumb is not correct", breadcrumbPreviewPage.getText().contains("Preview DV Pack")); 
		Assert.assertTrue("The table name is not correct", tableNamePreviewPage.getText().contains(name));
		Assert.assertTrue("The table title is not correct", tableTitlePreviewPage.getText().contains(title));
		Assert.assertTrue("The table was not created", regionColumnTable.getText().contains("Asia"));
		Assert.assertTrue("The table was not created", countryColumnTable.getText().contains("Australia"));
		Assert.assertTrue("The table was not created", metalColumnTable.getText().contains("Nickel"));
		continueButton.click();
		waitABit(2000);
		Assert.assertTrue("The table was not created", messageTable.getText().contains(tableMessage));
		Assert.assertTrue("The breadcrumb is not correct", breadcrumbConfirmationPage.getText().contains("Confirmation")); 
	}
	
	public void checkTableIntoListView(String name, String title, String databaseType, String type) {
		dvPackButtonList.click();
		element(newbutton).waitUntilVisible();
		searchDvPackField.click();
		searchDvPackField.sendKeys(name);
		Assert.assertTrue("The tableNameColumn is not correct", tableNameColumn.getText().contains(name));
		Assert.assertTrue("The tableTitleColumn is not correct", tableTitleColumn.getText().contains(title));
		Assert.assertTrue("The tableDatabaseTypeColumn is not correct", tableDatabaseTypeColumn.getText().contains(databaseType));
		Assert.assertTrue("The tableTypeColumn is not correct", tableTypeColumn.getText().contains(type));
	}
	}
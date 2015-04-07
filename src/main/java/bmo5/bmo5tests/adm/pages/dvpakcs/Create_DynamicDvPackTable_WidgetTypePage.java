package bmo5.bmo5tests.adm.pages.dvpakcs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.adm.AbstractAdmPage;


public class Create_DynamicDvPackTable_WidgetTypePage extends AbstractAdmPage {

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
	
	@FindBy (id = "default_view_WebTable")
	private WebElement defaultviewtable;
	
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
	
	@FindBy (css="div#dynamic_table")
	private WebElement table;
	
	@FindBy (css="tbody > tr:nth-child(1) > td:nth-child(1)")
	private WebElement countryColumnTable;
	
	@FindBy (css="div.right-side > div:nth-child(2) > h4")
	private WebElement messageTable;
	
	@FindBy (css="button#list")
	private WebElement dvPackButtonList;
	
	@FindBy(css = "div.dataTables_filter > label > input")
	private WebElement searchDvPackField;
	
	@FindBy(css = "tr[class='data-entry odd'] > td:nth-child(1)")
	private WebElement tableDvPackIdColumn;
	
	@FindBy(css = "tr[class='data-entry odd'] > td:nth-child(2)")
	private WebElement tableNameColumn;
	
	@FindBy(css = "tr[class='data-entry odd'] > td:nth-child(3)")
	private WebElement tableTitleColumn;
	
	@FindBy(css = "tr[class='data-entry odd'] > td:nth-child(11)")
	private WebElement tableDatabaseTypeColumn;
	
	@FindBy(css = "tr[class='data-entry odd'] > td:nth-child(12)")
	private WebElement tableTypeColumn;
	
	@FindBy (css="input.input-block-level")
	private WebElement searchfilter;
	
	@FindBy (css="li.nav-header > div.expandable-wrapper > ul")
	private WebElement filterIndicatorSectionExpanded;
	
	@FindBy (css="li.nav-header > h5 > span.pull-right > i.icon-right-dir")
	private WebElement indicatorSection;
	
	@FindBy (css="li.nav-header > ul.nav.nav-list")
	private WebElement filterGeographySectionExpanded;
	
	@FindBy (css="li.nav-header > div.expandable-wrapper > ul:nth-child(2) > li.quick-search > input.input-block-level")
	private WebElement indicatorFilter;
	
	@FindBy (css="input#ind_5020")
	private WebElement indicatorCheckbox;
	
	@FindBy (css="button#filter-display-data")
	private WebElement displayDataButton;
	
	@FindBy (css="button#continue")
	private WebElement continueButtonTable;
	
	@FindBy(css = "button#all_Geography_rightAll")
	private WebElement moveAllGeographiesToRightPanelButton;
	
	@FindBy(css = "button#all_Services_rightAll")
	private WebElement moveAllServicesToRightPanelButton;
	
	@FindBy(css = "button#all_Companies_rightAll")
	private WebElement moveAllCompaniesToRightPanelButton;
	
	@FindBy(css = "select#primary_service")
	private WebElement primaryChannelDropDown;
	
	@FindBy(css = "select#primary_iso")
	private WebElement primaryGeographyDropDown;
	
	@FindBy(css = "select#primary_company")
	private WebElement primaryCompanyDropDown;
	
	@FindBy(css = "table[class*='dvpack_table'] > tbody > tr:nth-child(1) > td:nth-child(1)")
	private WebElement countryColumnDisplayedTable;
	
	@FindBy (css="div.right-side > div:nth-child(2) > div:nth-child(1) h4")
	private WebElement tableTitlePreview;
	
	@FindBy (css="div.right-side > div:nth-child(2) > div:nth-child(1) h3")
	private WebElement tableNamePreview;
	
	@FindBy (css="div.right-side > div:nth-child(2) > div:nth-child(1) > h3")
	private WebElement tableTitle;
	
	@FindBy(css="input#app_type_data_pack")
	private WebElement datapackRadiobutton;
	
	@FindBy (css="select#database")
	private WebElement databaseDropDown;
	
	@FindBy(css="input#name")
	private WebElement nameInput;
	
	@FindBy(css="input#title")
	private WebElement titleInput;
	
	@FindBy(css="div.btn-toolbar > button:nth-child(2)")
	private WebElement continueButtonToPreviewSection;
	
	@FindBy(css="div.right-side > div:nth-child(2) > h4")
	private WebElement successMessage;
	
	public void displayHelpWindow() {
		helpButton.click();
		waitABit(2000);
		Assert.assertTrue("The help window title is not correct",
				helpWindowTitle.getText().contains("Help"));
		helpWindowCloseButton.click();
	}
	
	public void createTemplateDvPackTable(String name, String title, String subtitle, String description, String type, String databasetype) {
		newbutton.click();
		dvpackname.sendKeys(name+"_"+StringUtils.randomNumber(84000)+"_"+StringUtils.randomNumber(84000));
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
	public void clickDisplayDataButton(){
			displayDataButton.click();
			waitABit(5000);
	}
	
	public void displayTable() {
			displayDataButton.click();
			element(table).waitUntilVisible();
			Assert.assertTrue("The table was not created", countryColumnTable.getText().contains("Algeria"));
		}
		
	public String saveDvPackTable(String title,String name, String tableMessage, String primaryGeography, String primaryChannel, String primaryCompany, String searchGeography, String indicator) {
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
//		Assert.assertTrue("The tableNamePreview is not correct", tableNamePreview.getText().contains(name));
		Assert.assertTrue("The table was not created", countryColumnDisplayedTable.getText().contains(searchGeography));
		waitABit(2000);
		String s = tableNamePreview.getText();
		continueButtonTable.click();
		element(messageTable).waitUntilVisible();
		Assert.assertTrue("The table was not created", messageTable.getText().contains(tableMessage));
		return s;
}
	
	public String checkTableIntoListView(String name, String title, String databaseType, String type) {
		dvPackButtonList.click();
		element(newbutton).waitUntilVisible();
		searchDvPackField.click();
		searchDvPackField.sendKeys(name);
		Assert.assertTrue("The tableNameColumn is not correct", tableNameColumn.getText().contains(name));
		Assert.assertTrue("The tableTitleColumn is not correct", tableTitleColumn.getText().contains(title));
		Assert.assertTrue("The tableDatabaseTypeColumn is not correct", tableDatabaseTypeColumn.getText().contains(databaseType));
		Assert.assertTrue("The tableTypeColumn is not correct", tableTypeColumn.getText().contains(type));
		return tableDvPackIdColumn.getText();
	}
	
	public void waitUntilElementDoesntExist(By by, int waitSeconds) {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		boolean elementPresent = false;
		for (int i = 0; i < waitSeconds; i++) {
			try {
				waitABit(1000);
				getDriver().findElement(by);
				elementPresent = true;
			} catch (Exception e) {
				getDriver().manage().timeouts()
						.implicitlyWait(30, TimeUnit.SECONDS);
				elementPresent = false;
				break;
			}
		}
		Assert.assertFalse("The element did not disappear after "
				+ waitSeconds + " seconds!", elementPresent);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void clickDatapackTypeRadiobutton(){
		datapackRadiobutton.click();
	}
	
	public void selectDatabase(String database){
		Select databaseSelect=new Select(databaseDropDown);
		databaseSelect.selectByVisibleText(database);
	}
	
	public void typeNameAndTitle(String name, String title){
		nameInput.sendKeys(name+Integer.toString(StringUtils.randomNumber(10000)));
		titleInput.sendKeys(title+Integer.toString(StringUtils.randomNumber(10000)));
	}
	
	public void addNewDvpack() {
		newbutton.click();
	}
	
	public void clickContinueButton(){
		continuebutton.click();
	}
	
	public void clickContinueButtonToPreviewSection(){
		continueButtonToPreviewSection.click();
	}
	
	public void clickDvpackList() {
		dvPackButtonList.click();
	}
	public String getDvpackID(){
		String[] successMessageSplitted=successMessage.getText().split(" ");
		System.out.println("Created dvpack id: " +successMessageSplitted[successMessageSplitted.length-1]);
		return successMessageSplitted[successMessageSplitted.length-1];
	}
	
	}
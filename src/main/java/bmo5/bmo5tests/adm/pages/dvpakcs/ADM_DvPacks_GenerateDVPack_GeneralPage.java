package bmo5.bmo5tests.adm.pages.dvpakcs;

import net.thucydides.core.annotations.findby.By;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class  ADM_DvPacks_GenerateDVPack_GeneralPage extends AbstractAdmPage {

	@FindBy(css = "div#breadcrumb > div:nth-child(2) > div > a:nth-child(1)")
	private WebElement listViewButton;

	@FindBy(css = "input#name")
	private WebElement dvPackNameInputField;
	
	@FindBy(css = "input#dvpn")
	private WebElement dvPackNameInputFieldClone;

	@FindBy(css = "input#title")
	private WebElement dvPackTitleInputField;

	@FindBy(css = "input#subtitle")
	private WebElement dvPackSubTitleInputField;

	@FindBy(css = "input#description")
	private WebElement dvPackDescriptionInputField;

	@FindBy(css = "button.btn.pull-right")
	private WebElement continueButton;

	@FindBy(css = "select#type")
	private WebElement dvPackTypeDropdown;

	@FindBy(css = "select#database")
	private WebElement dvPackDataBaseDropdown;

	@FindBy(css = "select#industry_type")
	private WebElement industry;

	public void selectFromDropdownDvPackType(String typeDvPack) {
		selectFromDropdown(dvPackTypeDropdown, typeDvPack);
		Select dvPackType = new Select(dvPackTypeDropdown);
		WebElement option = dvPackType.getFirstSelectedOption();
		String selection= option.getText();
		Assert.assertTrue(typeDvPack.contains(selection));
	}

	public void selectADataBaseFromDropdownList(String database) {
		selectFromDropdown(dvPackDataBaseDropdown, database);
		Select databaseDvPack = new Select(dvPackDataBaseDropdown);
		WebElement option = databaseDvPack.getFirstSelectedOption();
		String selection= option.getText();
		Assert.assertTrue(database.contains(selection));
	}
	
	public void verifySelectedDatabase(String database){
		Assert.assertTrue(dvPackDataBaseDropdown.getAttribute("value").contains(database));
	}
	
	public void verifySelectedDvPackTypeFromDropDownList(String dvPackTypeValue){
		Assert.assertTrue(dvPackTypeDropdown.getAttribute("value").contains(dvPackTypeValue));
	}

	public void selectIndustryTypeFromDropdown(String industryType) {
		selectFromDropdown(industry, industryType);
		Select industryTypeSection = new Select(industry);
		WebElement option = industryTypeSection.getFirstSelectedOption();
		String selection= option.getText();
		Assert.assertTrue(industryType.contains(selection));
	}

	//	public void selectType(String system, String widget,String dataPack) {
	//		if(getDriver().findElement(By.cssSelector("div#content > div > div > div:nth-child(2) > form > div:nth-child(11) > div  > div > div > label:nth-child(1)")).getText().contains(system)) {
	//
	//		}
	//		else if(getDriver().findElement(By.cssSelector("div#content > div > div > div:nth-child(2) > form > div:nth-child(11) > div  > div > div > label:nth-child(2)")).getText().contains(widget)) {
	//
	//		}
	//		else if (getDriver().findElement(By.cssSelector("div#content > div > div > div:nth-child(2) > form > div:nth-child(11) > div  > div > div > label:nth-child(3)")).getText().contains(dataPack)){
	//
	//		}
	//		else {Assert.assertTrue((getDriver().findElement(By.cssSelector("div#content > div > div > div:nth-child(2) > form > div:nth-child(11) > div  > div > div > label:nth-child(4)")).getAttribute("disabled").contains("disabled")));
	//
	//		}
	//	}

	public void selectTypeForDvPack(String type) {
		if(getDriver().findElements(By.cssSelector("div#content > div > div > div:nth-child(2) > form > div:nth-child(11) > div  > div > div > label > input[value ="+type+"]")).size() == 1){
			getDriver().findElement(By.cssSelector("div#content > div > div > div:nth-child(2) > form > div:nth-child(11) > div  > div > div > label > input[value ="+type+"]")).click();
		}
		else{
			System.out.println("The option does not exist.");
		}
	}

	public void  verifySelectedDvPackType(String type) {
		if(getDriver().findElements(By.cssSelector("input[value ="+type+"]")).size() == 1){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("input[value ="+type+"]")).getAttribute("class").contains("1"));
		}
	}

	public void selectDefaultView(String defaultView) {
		if(getDriver().findElements(By.cssSelector("div#content > div > div > div:nth-child(2) > form > div:nth-child(12) > div > div > label > input[value="+defaultView+"]")).size() == 1) {
			getDriver().findElement(By.cssSelector("div#content > div > div > div:nth-child(2) > form > div:nth-child(12) > div > div > label > input[value="+defaultView+"]")).click();
		} 
		else {
			System.out.println("The option does not exist.");
		}
	} 

	public void verifySelectedDefaultView(String defaultView) {
		if(getDriver().findElements(By.cssSelector("div#content > div > div > div:nth-child(2) > form > div:nth-of-type(8) > div > div > label > input[value="+defaultView+"]")).size() == 1) {
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div#content > div > div > div:nth-child(2) > form > div:nth-of-type(8) > div > div > label > input[value="+defaultView+"]")).getAttribute("checked").contains("true"));
		} 
		else {
			System.out.println("The option does not exist.");
		}
		//Assert.assertTrue(getDriver().findElement(By.cssSelector("div#content > div > div > div:nth-child(2) > form > div:nth-child(12) > div > div > label > input")).getAttribute("checked").contains("1"));
	}

	public String inputNameForDvPack(String dvPackname) {
		int ran;
		ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		dvPackname = dvPackname + ran;
		dvPackNameInputField.clear();
		dvPackNameInputField.sendKeys(dvPackname);
		return dvPackname;
	}
	
	public String inputNameForDvPackClone(String dvPackname) {
		int ran;
		ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		dvPackname = dvPackname + ran;
		dvPackNameInputFieldClone.clear();
		dvPackNameInputFieldClone.sendKeys(dvPackname);
		return dvPackname;
	}
	
	public void verifyNameForDvPack(String dvPackName){
		Assert.assertTrue(dvPackNameInputField.getAttribute("value").contains(dvPackName));
	}
	
	public void verifyNameForDvPackClone(String dvPackName){
		Assert.assertTrue(dvPackNameInputFieldClone.getAttribute("value").contains(dvPackName));
	}

	public String inputDescriptionForDvPack(String dvPackDescriptionField) {
		int ran;
		ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		dvPackDescriptionField = dvPackDescriptionField + ran;
		dvPackDescriptionInputField.sendKeys(dvPackDescriptionField);
		return dvPackDescriptionField;
	}
	
	public void verifyDescriptionForDvPack(String dvPackDescription){
		Assert.assertTrue(dvPackDescriptionInputField.getAttribute("value").contains(dvPackDescription));
	}

	public String inputTitleForDvPack(String dvPackTitle) {
		int ran;
		ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		dvPackTitle = dvPackTitle + ran;
		dvPackTitleInputField.clear();
		dvPackTitleInputField.sendKeys(dvPackTitle);
		return dvPackTitle;
	}

	public void verifyTitleForDvPack(String dvPackTitle){
		Assert.assertTrue(dvPackTitleInputField.getAttribute("value").contains(dvPackTitle));
	}
	
	public String inputSubTitleForDvPack(String dvPackSubTitle) {
		int ran;
		ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		dvPackSubTitle = dvPackSubTitle + ran;
		dvPackSubTitleInputField.sendKeys(dvPackSubTitle);
		return dvPackSubTitle;
	}
	
	public void verifySubTitleForDvPack(String dvPackSubTitle){
		Assert.assertTrue(dvPackSubTitleInputField.getAttribute("value").contains(dvPackSubTitle));
	}

	public void clickAndVerifyContinueButton() {
		Assert.assertTrue(continueButton.isDisplayed());
		continueButton.click();
	}

	public void clickOnListViewButton() {
		Assert.assertTrue(listViewButton.isDisplayed());
		listViewButton.click();
	}
	
	public void verifyChartOptionFronDefaultViewIsDisabled(){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#content > div > div > div:nth-child(2) > form > div:nth-of-type(8) > div > div > label > input[value='WebTable']")).getAttribute("checked").contains("true"));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#content > div > div > div:nth-child(2) > form > div:nth-of-type(8) > div > div > label > input[value='DynamicChart']")).getAttribute("disabled").contains("true"));
	}
}
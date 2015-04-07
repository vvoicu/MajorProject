package bmo5.bmo5tests.adm.pages.subnational;

import java.util.Iterator;
import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class EntityMaintenancePage extends AbstractAdmPage {

	@FindBy(css="select#country_iso")
	private WebElement countryList;
	
	@FindBy(css="button#get_entity_body")
	private WebElement continueButton;
	
	@FindBy(css="input.btn.btn-link.evil.color")//evil color? haha :)
	private WebElement resetLink;
	
	@FindBy(css="a.btn.btn-link.evil.color")//evil color? haha :)
	private WebElement resetLinkEditPage;
	
	@FindBy(css="input#entity_code")
	private WebElement entityCodeInput;
	
	@FindBy(css="input#uneditable_entity_code")
	private WebElement unenditableEntityCode;
	
	@FindBy(css="input#entity_name")
	private WebElement entityNameInput;
	
	@FindBy(css="input#entity_level")
	private WebElement entityLevelInput;
	
	@FindBy(css="select#entity_type")
	private WebElement entityTypeList;
	
	@FindBy(css="select#cms_show")
	private WebElement cmsShowDropDown;
	
	@FindBy(css="select#web_show")
	private WebElement webShowDropDown;
	
	@FindBy(css="label#country_iso_label")
	private WebElement errorLabelCountry;
	
	@FindBy(css="section#entity_body > div:nth-of-type(1) > div > label")
	private WebElement errorLabelEntityCode;

	@FindBy(css="section#entity_body > div:nth-of-type(2) > div > label")
	private WebElement errorLabelEntityName;
	
	@FindBy(css="section#entity_body > div:nth-of-type(3) > div > label")
	private WebElement errorLabelEntityLevel;
	
	@FindBy(css="section#entity_body > div:nth-of-type(4) > div > label")
	private WebElement errorLabelEntityType;
	
	@FindBy(css="label.btn")
	private WebElement bulkUploadButton;
	
	@FindBy(css="a#entities_download_excel")
	private WebElement exportAllButton;
	
	@FindBy(css="a.btn.search-ndb")
	private WebElement searchButton;
	
	@FindBy(css="div.select-form-subnational.span6")
	private WebElement parentsList;
	
	@FindBy(css="a.add.btn")
	private WebElement newButton;
	
	@FindBy(css="input#country")
	private WebElement countryInputForSearch;
	
	@FindBy (css="input#entity_name")
	private WebElement entityNameInputForSearch;
	
	@FindBy(css="div div#DataTables_Table_0_wrapper table tbody tr td:nth-of-type(1)")
	private WebElement firstCellForNoResultsFoundMessage;
	
	@FindBy(css="button#add_entity_form_btn")
	private WebElement saveButton;
	
	@FindBy(css="button#edit_entity_form_btn")
	private WebElement editButton;
	
	@FindBy(css="a[href='/subnational/entity']")
	private WebElement listViewbutton;
	
	@FindBy(css="div.alert.alert-error")
	private WebElement errorMessage;
	
	@FindBy(css="div.alert.alert-success")
	private WebElement successMessage;
	
	@FindBy(css="div div#DataTables_Table_0_wrapper table tbody tr td:nth-of-type(1) a")
	private WebElement firstEntityCodeFromTable;
	
	
	public String selectCountry(String country){
		Select countryListSelect=selectByVisibleText(countryList, country);
	    return  countryListSelect.getFirstSelectedOption().getAttribute("value");
	}
	
	public void verifySelectedCountry(String country){
		Assert.assertTrue("Selected option is not the desired country",getSelectedValue(countryList).contains(country));
	}
	
	public void clickOnResetAndVerifySelectedOption(){
		clickOnResetButtonAddPage(); 
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div.widget-content > div:nth-of-type(2)> div.controls > *")).size()<=1);
	}
	
	public void verifyElementsDisplayed(){
		Assert.assertTrue("Country list is not displayed",countryList.isDisplayed());
		Assert.assertTrue("Continue button is not displayed",continueButton.isDisplayed());
		Assert.assertTrue("Save button is not displayed",saveButton.isDisplayed());
		verifySaveButtonIsDisabled();
		Assert.assertTrue("Reset link is not displayed",resetLink.isDisplayed());
		
	}
	
	public void verifyEntityElementsDisplayed(){
		Assert.assertTrue("Entity code input is not displayed",entityCodeInput.isDisplayed());
		Assert.assertTrue("Entity name input is not displayed",entityNameInput.isDisplayed());
		Assert.assertTrue("Entity level input is not displayed",entityLevelInput.isDisplayed());
		Assert.assertTrue("Entity type list is not displayed",entityTypeList.isDisplayed());
		Assert.assertTrue("Cms show drop down is not displayed",cmsShowDropDown.isDisplayed());
		Assert.assertTrue("Web show drop down is not displayed",webShowDropDown.isDisplayed());
		Assert.assertTrue("Parents list drop down is not displayed",parentsList.isDisplayed());
	}
	
	public void verifySaveButtonIsDisabled(){
		Assert.assertFalse("Save button is not disabled",saveButton.isEnabled());
	}
	
	public void verifySaveButtonIsEnabled(){
		Assert.assertTrue("Save button is not enabled",saveButton.isEnabled());
	}
	
	public void verifyEditButtonIsEnabled(){
		Assert.assertTrue("Save button is not enabled",editButton.isEnabled());
	}
	
	public void clickOnContinueButton(){
		continueButton.click();
	}
	
	public void clickOnSaveButton(){
		saveButton.click();
		waitABit(2000);
	}
	
	public void clickOnEditButton(){
		editButton.click();
		waitABit(2000);
	}
	
	public void clickOnContinueButtonAndVerifyErrorMessage(){
		clickOnContinueButton();
		if(getDriver().findElements(By.cssSelector("div.widget-content > div:nth-of-type(2)> div.controls > *")).size()>1){
			  Assert.assertTrue(errorLabelCountry.getText().contains("Country iso must be selected"));	
		}	
	}
	
	public void clickOnSaveButtonAndVerifyErrorMessages(){
		clickOnSaveButton();
	    Assert.assertTrue("Entity code Error message not displayed",errorLabelEntityCode.getText().contains("Entity code cannot be empty!"));	
	    Assert.assertTrue("Entity name Error message not displayed",errorLabelEntityName.getText().contains("Entity name cannot be empty!"));		
	    Assert.assertTrue("Entity level Error message not displayed",errorLabelEntityLevel.getText().contains("Entity level cannot be empty!"));	
	    Assert.assertTrue("Entity type Error message not displayed",errorLabelEntityType.getText().contains("Entity type must be selected!"));
	}
	
	
	public void typeEntityCode(String entityCode){
		entityCodeInput.clear();
		entityCodeInput.sendKeys(entityCode);
	}
	
	public void typeEntityLevel(String entityLevel){
		entityLevelInput.clear();
		entityLevelInput.sendKeys(entityLevel);
	}
	
	public void typeWrongEntityLevelSaveAndVerify(String wrongEntityLevel){
		 typeEntityLevel(wrongEntityLevel);
		 clickOnSaveButton();
		 Assert.assertTrue("Entity level Error message not displayed",errorLabelEntityLevel.getText().contains("Entity level must be an integer number greater than 0"));	
	}
	
	public void typeWrongEntityLevelOnEditSaveAndVerify(String wrongEntityLevel){
		 typeEntityLevel(wrongEntityLevel);
		 clickOnEditButton();
		 Assert.assertTrue("Entity level Error message not displayed",errorLabelEntityLevel.getText().contains("Entity level must be an integer number greater than 0"));	
	}
	
	public void typeWrongEntityCodeSaveAndVerify(String wrongEntityCode){
		 typeEntityCode(wrongEntityCode);
		 clickOnSaveButton();
		 Assert.assertTrue("Entity Code Error message not displayed",errorLabelEntityCode.getText().contains("Please enter an entity code formed by 10 characters"));	
	}
	
	public void typeEntityName(String entityName){
		entityNameInput.clear();
		entityNameInput.sendKeys(entityName);
	}
	
	public void selectEntityType(String entityType){
		selectByVisibleText(entityTypeList, entityType);
	}
	
	public void selectCMSShow(String cmsShowState){
		selectByVisibleText(cmsShowDropDown, cmsShowState);
	}
	
	public void selectWebShow(String webShowState){
		selectByVisibleText(webShowDropDown, webShowState);
	}
	
	public void assertSuccessMessageIsDisplayed(){
		//TODO Fix this
//		Assert.assertFalse(manageWidgets.checkAlertIsErrorMessage());
	}
	
	public void clickOnResetButtonAddPage(){
		resetLink.click();
	}
	
	public void clickOnResetButtonEditPage(){
		resetLinkEditPage.click();
	}

	public void verifyAscendingDescending(String listSelector) {
		List <WebElement> columnHeaders = getDriver().findElements(By.cssSelector(listSelector));
		Iterator <WebElement> iter = columnHeaders.iterator();
		
		while(iter.hasNext()) {
			WebElement column = iter.next();
			System.out.println(column.getText());
			if(!column.getAttribute("class").contains("unsorted")&&!column.getText().contains("Entity ID")){
				column.click();
				waitABit(3000);
				Assert.assertTrue("Column is not sorted in ascending order!",column.getAttribute("class").contains("sorting_asc"));
				column.click();
				waitABit(3000);
				Assert.assertTrue("Column is not sorted in descending order!",column.getAttribute("class").contains("sorting_desc"));	
				
			}
			
			else if(column.getText().contains("Entity ID")){
				Assert.assertTrue("Column is not sorted in ascending order!",column.getAttribute("class").contains("sorting_asc"));
				column.click();
				waitABit(3000);
				Assert.assertTrue("Column is not sorted in descending order!",column.getAttribute("class").contains("sorting_desc"));
			}
			
		    else{	
				System.out.println("All columns were sorted");
			}
		}
	}
	
	public void clickOnBulkUpload(){
		bulkUploadButton.click();
	}
	
	public void clickOnExportAll(){
		exportAllButton.click();
	}
	
	public void clickOnNewButton(){
        newButton.click();
	}
	
	public String selectParent(String parent){
		List<WebElement> labels = getDriver().findElements(By.cssSelector("div.subnational-parents > ul > li > label"));
		List<WebElement> inputs =getDriver().findElements(By.cssSelector("div.subnational-parents > ul > li > input"));
		String parentValue="";
		if(labels.size()>0){
			for(int i=0;i<labels.size();i++){
				if(labels.get(i).getText().contains(parent)){
					labels.get(i).click();
					parentValue=inputs.get(i).getAttribute("value");
				}
			}
		}
		return parentValue;
	}
	
	public void clickOnSearchButton(){
		searchButton.click();
		waitABit(2000);
	}
	
	public void typeCountryISOforSearch(String country){
		countryInputForSearch.clear();
		countryInputForSearch.sendKeys(country);
	}
	
	public void typeEntityNameForSearch(String entityName){
		entityNameInputForSearch.clear();
		entityNameInputForSearch.sendKeys(entityName);
	}
	
	public void verifySearchResults(String entityName){
		List <WebElement> nameColumnCells=getDriver().findElements(By.cssSelector("div div#DataTables_Table_0_wrapper table tbody tr td:nth-of-type(2)"));
		
		if(nameColumnCells.size()>0){
			for(WebElement nameCell:nameColumnCells){
				Assert.assertTrue("Results do not contain searched entity name",nameCell.getText().toLowerCase().contains(entityName));
			}
		}
		
		else{
			Assert.assertTrue("Message not displayed or table is empty",firstCellForNoResultsFoundMessage.getText().contains("No matching records found"));
		}
	}
	
	public void clickOnEntityCodeFromTable(String savedEntityCode){
		if(firstEntityCodeFromTable.getText().contains(savedEntityCode)){
			firstEntityCodeFromTable.click();
		}
	}
	
	public void clickListViewButton(){
		listViewbutton.click();
	}
	
	//TODO fix this
//	public void verifyAlreadyExistsError(){
//		boolean errormessage=false;
//		if (manageWidgets.checkAlertIsErrorMessage()) {
//			Assert.assertTrue("Wrong message",errorMessage.getText().contains("entity with this code already exists"));
//		} else {
//			Assert.assertTrue("No error message displayed", errormessage);
//		}
//	}
//	
//	public void verifySuccessfullySavedMessage(){
//		boolean errormessage=false;
//		if (!manageWidgets.checkAlertIsErrorMessage()) {
//			Assert.assertTrue("Wrong message",successMessage.getText().contains("entity successfully created"));
//		}
//		else {
//			Assert.assertTrue("No error message displayed", errormessage);
//		}
//	}
	
	public void verifyDataOnEditEntityPage(String entityCode, String entityLevel, String entityName, String entityType, String country, String cmsShow, String webShow,String parent){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("section#entity_body > div:nth-of-type(1)> div:nth-of-type(1)> input[disabled='disabled']")).size() == 1);
		Assert.assertTrue("Wrong entity code in edit page",unenditableEntityCode.getAttribute("value").contains(entityCode));
		Assert.assertTrue("Wrong entity level in edit page",entityLevelInput.getAttribute("value").contains(entityLevel));
		Assert.assertTrue("Wrong entity name in edit page",entityNameInput.getAttribute("value").contains(entityName));
		Assert.assertTrue("Wrong entity type selected",getSelectedValue(entityTypeList).contains(entityType));
		Assert.assertTrue("Wrong country selected",getSelectedValue(countryList).contains(country));
		Assert.assertTrue("Wrong cmsShow state selected",getSelectedValue(cmsShowDropDown).contains(cmsShow));
		Assert.assertTrue("Wrong webShow state selected",getSelectedValue(webShowDropDown).contains(webShow));
		verifyParentSelected(parent);
	}

	public void verifyParentSelected(String parent){
		List<WebElement> labels = getDriver().findElements(By.cssSelector("div.subnational-parents > ul > li > label"));
		List<WebElement> inputs =getDriver().findElements(By.cssSelector("div.subnational-parents > ul > li > input"));
		
		for(int i=0;i<labels.size();i++){
			if(labels.get(i).getText().contains(parent)){
				Assert.assertTrue("Parent is not selected",inputs.get(i).isSelected());
			}
		}
	}
	
	public void verifyDataOnEntityTablePage(String entityCode, String entityLevel, String entityName, String countryISO, String cmsShow, String webShow,String parent){
		List <WebElement> firstRowData=getDriver().findElements(By.cssSelector("div div#DataTables_Table_0_wrapper table tbody tr:nth-of-type(1) td"));
		Assert.assertTrue("Wrong entity code in table",firstRowData.get(0).getText().contains(entityCode));
		Assert.assertTrue("Wrong entity level in table",firstRowData.get(3).getText().contains(entityLevel));
		Assert.assertTrue("Wrong entity name in table",firstRowData.get(1).getText().contains(entityName));
		Assert.assertTrue("Wrong country in table",firstRowData.get(2).getText().contains(countryISO));
		Assert.assertTrue("Wrong cmsShow state in table",firstRowData.get(4).getText().contains(cmsShow));
		Assert.assertTrue("Wrong webShow state in table",firstRowData.get(5).getText().contains(webShow));
		if(!parent.equals("")){
		Assert.assertTrue("Wrong hierarchy in table",firstRowData.get(6).getText().contains(countryISO+" > "+parent));
		}
		else
		{
			Assert.assertTrue("Wrong hierarchy in table",firstRowData.get(6).getText().contains(countryISO));
		}
	}
}
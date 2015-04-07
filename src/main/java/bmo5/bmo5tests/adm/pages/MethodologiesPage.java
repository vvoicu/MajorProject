package bmo5.bmo5tests.adm.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class MethodologiesPage extends AbstractAdmPage{

	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(1)")
	private WebElement indexNameColumn;
	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(2)")
	private WebElement lastUpdateColumn;
	
	@FindBy(linkText = "List View")
	private WebElement listViewButton;
	
	@FindBy(linkText = "Help")
	private WebElement helpButton;

	@FindBy(css = "div[class='widget-box width80 percent '] h5")
	private WebElement editPageHeader;
	
	@FindBy(css = "div[class='controls percent-margin-left-60'] > input")
	private WebElement indexOrDatabaseInputBox;
	
	@FindBy(css = "select#type")
	private WebElement methodologyTypeDropDownList;
	
	@FindBy(css = "iframe#Content_ifr")
	private WebElement contentTextBox;
	
	@FindBy(css = "div.form-actions > button[type='reset']")
	private WebElement resetButton;
	
	@FindBy(css = "div.form-actions > button[type='submit']")
	private WebElement updateButton;
	
	@FindBy(css = "div[class='alert alert-success']")
	private WebElement confirmationMessage;
	
	public void verifyTableColumns(){
		Assert.assertTrue(indexNameColumn.getAttribute("aria-sort").contains("ascending"));
		indexNameColumn.click();
		Assert.assertTrue(indexNameColumn.getAttribute("aria-sort").contains("descending"));
		lastUpdateColumn.click();
		Assert.assertTrue(lastUpdateColumn.getAttribute("aria-sort").contains("ascending"));
		lastUpdateColumn.click();
		Assert.assertTrue(lastUpdateColumn.getAttribute("aria-sort").contains("descending"));
	}
	
	public void verifyEditPage(String indexOrDatabase, String indexOrDatabaseName, String methodologicalDetails, String briefOutlines){
		Assert.assertTrue(editPageHeader.getText().contains(indexOrDatabase));
		Assert.assertTrue(indexOrDatabaseInputBox.getAttribute("value").contains(indexOrDatabaseName));
		if(indexOrDatabase.contains("Index")){
			Assert.assertTrue(methodologyTypeDropDownList.findElement(By.cssSelector(" selected")).getText().contains(briefOutlines) && 
					methodologyTypeDropDownList.getText().contains(methodologicalDetails) && 
					methodologyTypeDropDownList.getText().contains(briefOutlines));
		}
	}
	
	public void clickOnListViewButtonAndVerify(){
		listViewButton.click();
		Assert.assertTrue(indexNameColumn.getAttribute("aria-sort").contains("ascending"));
	}
	
	public void clickOnResetButtonAndVerify(String indexOrDatabase, String indexOrDatabaseName, String methodologicalDetails, String briefOutlines){
		resetButton.click();
		Assert.assertTrue(editPageHeader.getText().contains(indexOrDatabase));
		Assert.assertTrue(indexOrDatabaseInputBox.getAttribute("value").contains(indexOrDatabaseName));
		if(indexOrDatabase.contains("Index")){
			Assert.assertTrue(methodologyTypeDropDownList.findElement(By.cssSelector(" selected")).getText().contains(briefOutlines) && 
					methodologyTypeDropDownList.getText().contains(methodologicalDetails) && 
					methodologyTypeDropDownList.getText().contains(briefOutlines));
		}
		Assert.assertTrue(contentTextBox.getText().isEmpty());
	}
	
	public void enterContent(String content){
		contentTextBox.sendKeys(content);
	}
	
	public void clickOnUpdateButtonAndVerify(String confirmationMessageUpdate, String indexOrDatabaseName){
		updateButton.click();
		Assert.assertTrue(confirmationMessage.getText().contains(indexOrDatabaseName + confirmationMessageUpdate));
	}
}

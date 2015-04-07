package bmo5.bmo5tests.adm.pages.dvpakcs;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;


public class Delete_DvPacksPage extends AbstractAdmPage {

	@FindBy (css="div#breadcrumb div:nth-child(2) >  div:nth-child(1) > a:nth-child(2)")
	private WebElement helpButton;
	
	@FindBy (css="div#help > div:nth-child(1) > h3:nth-child(2)")
	private WebElement helpWindowTitle;
	
	@FindBy (css="div#help > div:nth-child(3) > button")
	private WebElement helpWindowCloseButton;
	
	@FindBy(css = "div.dataTables_filter > label > input")
	private WebElement searchDvPackField;
	
	@FindBy(css = "table[id^='DataTables'] > tbody > tr:nth-child(1) > td:nth-child(8)")
	private WebElement typeColumn;
	
	@FindBy(css = "table[id^='DataTables'] > tbody > tr:nth-child(1) > td:nth-child(13) > a:nth-child(3)")
	private WebElement actionsColumnDeleteElement;
	
	@FindBy(css = "div[class='bootbox modal fade in']")
	private WebElement confirmDeleteWindow;
	
	@FindBy(css = "div[class='bootbox modal fade in'] > div:nth-child(3) > a:nth-child(2)")
	private WebElement confirmDeleteButton;
	
	@FindBy(css = "div[class='alert alert-success']")
	private WebElement deleteNotification;
	
	@FindBy(css = "table[id^='DataTables'] > tbody > tr:nth-child(1) > td:nth-child(1)")
	private WebElement dvPackId;
	
	@FindBy(css = "div[id^='DataTables']")
	private WebElement showResults;
	
	@FindBy(css = "a[class='btn btn-link btn-link-delete delete']")
	private WebElement deleteButtonFirstDvPack;
	
	@FindBy(css = "a[class='btn btn-primary']")
	private WebElement okButtonDeleteWindow;
	
	public void displayHelpWindow() {
		helpButton.click();
		waitABit(2000);
		Assert.assertTrue("The help window title is not correct", helpWindowTitle.getText().contains("Help")); 
		helpWindowCloseButton.click();
	}
	
	public void searchDvPackTemplateType(String type, String deleteMessage, String showNoResults) {
		searchDvPackField.click();
		searchDvPackField.sendKeys(type);
		element(typeColumn).waitUntilVisible();
		Assert.assertTrue("The type is not correct", typeColumn.getText().contains(type)); 
		String DvPAckID = dvPackId.getText();
		actionsColumnDeleteElement.click();
		element(confirmDeleteWindow).waitUntilVisible();
		confirmDeleteButton.click();
		element(deleteNotification).waitUntilVisible();
		Assert.assertTrue("The DvPack was not deleted", deleteNotification.getText().contains(deleteMessage)); 
		searchDvPackField.sendKeys(DvPAckID);
		Assert.assertTrue("The DvPackID was not deleted", showResults.getText().contains(showNoResults)); 
	}
	
	public void deleteDvPackById(String idDvPack){
		searchDvPackField.click();
		searchDvPackField.sendKeys(idDvPack);
		deleteButtonFirstDvPack.click();
		okButtonDeleteWindow.click();
	}

}

package bmo5.bmo5tests.adm.pages.widgets;

import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class KeyMarketForecastsPage extends AbstractAdmPage {

	@FindBy(css="div#key_market_forecasts_table_filter input")
	private WebElement searchInput;
	
	@FindBy(css="table#key_market_forecasts_table > tbody > tr > td:nth-of-type(1)")
	private WebElement firstRow;
	
	@FindBy(css="a#btnDeleteRow")
	private WebElement deleteButton;
	
	@FindBy(css="div.bootbox.modal.fade.in")
	private WebElement deleteModal;
	
	@FindBy(css="div.bootbox.modal.fade.in > div.modal-body")
	private WebElement deleteText;
	
	@FindBy(css="div.bootbox.modal.fade.in > div.modal-footer > a:nth-of-type(1)")
	private WebElement cancelButton;
	
	@FindBy(css="div.bootbox.modal.fade.in > div.modal-footer > a:nth-of-type(2)")
	private WebElement okButton;
	
	@FindBy(css="a#btn_add_row")
	private WebElement addRowButton;
	
	@FindBy(css="a#btn-save")
	private WebElement saveButton;
	
	public void typeSearchItem(String searchItem){
		searchInput.clear();
		searchInput.sendKeys(searchItem);
		searchInput.sendKeys(Keys.ENTER);
	}
	
	public void verifySearchedResults(String searchedItem){
    List <WebElement> services=getDriver().findElements(By.cssSelector("table#key_market_forecasts_table > tbody > tr > td:nth-of-type(1)"));
    List <WebElement> cells=getDriver().findElements(By.cssSelector("table#key_market_forecasts_table > tbody > tr:nth-of-type(1) > td"));
		if(cells.size()==3){
			for(WebElement service:services){
				Assert.assertTrue("Results do not contain searched service",service.getText().toLowerCase().contains(searchedItem));
			}
		}
		
		else {
			System.out.println("no results found");
			Assert.assertTrue("Message not displayed or table is empty",firstRow.getText().contains("No matching records found"));
		}
	}
	
	public void clickOnDeleteButtonVerifyAndDoAction(String action){
		deleteButton.click();
		Assert.assertTrue("Delete modal is not displayed",deleteModal.isDisplayed());
		Assert.assertTrue("Delete modal text is not displayed",deleteText.isDisplayed());
		Assert.assertTrue("Delete modal text is wrong",deleteText.getText().contains("Are you sure you want to delete this?"));
		Assert.assertTrue("Delete ok button is not displayed",okButton.isDisplayed());
		Assert.assertTrue("Delete cancel button is not displayed",cancelButton.isDisplayed());
		if(action.toLowerCase().equals("ok")){
			okButton.click();
		}
		else
			if(action.toLowerCase().equals("cancel"))
		{
			cancelButton.click();
		}
			else
			{
				System.out.println("Some undecided user :)");
				cancelButton.click();
			}
	}
	
	public void clickAddRowButton(){
		addRowButton.click();
	}
	
	public void clickOnSaveButton(){
		saveButton.click();
	}
}

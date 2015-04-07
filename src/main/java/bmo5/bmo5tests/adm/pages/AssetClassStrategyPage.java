package bmo5.bmo5tests.adm.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class AssetClassStrategyPage extends AbstractAdmPage {

//	public AssetClassStrategyPage(WebDriver driver) {
//		super(driver);
//	}

	@FindBy(css = "a[href='/widgets/financialmarkets/assetclassstrategy']")
	private WebElement assetClassStrategySubtab;
	
	@FindBy(css = "input#bulk")
	private WebElement chooseFileButton;
	
	@FindBy(css = "input[value='Upload selected file']")
	private WebElement uploadSelectedFileButton;
	
	@FindBy(css = "div#DataTables_Table_0_filter input")
	private WebElement searchInputBox;
	
	@FindBy(css = "a.btn.btn-primary")
	private WebElement confirmationDeletingARowButton;
	
	public void clickOnAssetClassStrategy(){
		assetClassStrategySubtab.click();
	}
	
	public void clickOnChooseFileButton(){
		chooseFileButton.click();
	}
	
	public void uploadFile(String upload){
		chooseFileButton.click();
		waitABit(2000);

		uploadFile(upload + ".xls", Constants.RESOURCES_MEDIA);
		waitABit(3000);
		
		uploadSelectedFileButton.click();
	}
	
	public void deleteOneItemFromTable(String upload){
		searchInputBox.sendKeys(upload);
		int numberOfItems = getDriver().findElements(By.cssSelector("table[class='table table-condensed table-bordered data-table dataTable'] > tbody > tr")).size();
		for(int i=1; i<=numberOfItems; i++){
			if(getDriver().findElement(By.cssSelector("table[class='table table-condensed table-bordered data-table dataTable'] > tbody > tr:nth-child(" + i + ") > td:nth-child(5)")).getText().contains("Inactive")){
				getDriver().findElement(By.cssSelector("table[class='table table-condensed table-bordered data-table dataTable'] > tbody > tr:nth-child(" + i + ") > td:nth-child(6) a")).click();
				confirmationDeletingARowButton.click();
				break;
			}
		}
		searchInputBox.sendKeys(upload);
		int numberOfItemsNew = getDriver().findElements(By.cssSelector("table[class='table table-condensed table-bordered data-table dataTable'] > tbody > tr")).size();
		if(numberOfItemsNew ==1){
			if(getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody >tr > td.dataTables_empty")).size()==1){
				System.out.println("There is no item anymore in list");
				Assert.assertTrue(numberOfItems == numberOfItemsNew);
			}
			else{
				Assert.assertTrue(numberOfItemsNew == numberOfItems - 1);
			}
		}
		else{
			Assert.assertTrue(numberOfItemsNew == numberOfItems - 1);
		}
	}
}

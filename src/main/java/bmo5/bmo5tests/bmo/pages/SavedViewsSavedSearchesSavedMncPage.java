package bmo5.bmo5tests.bmo.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class SavedViewsSavedSearchesSavedMncPage extends AbstractPage{
	
	@FindBy(css = "button > i.icon-c-folder-add")
	@CacheLookup
	private WebElement addIcon;
	
	@FindBy(css = "button#btn-lib-delete > i")
	private WebElement deleteIcon;
	
	@FindBy(css = "button#edit_product > i") 
	@CacheLookup
	private WebElement editIcon;
	
	@FindBy(css = "button#move-folder")
	@CacheLookup
	private WebElement moveIcon;
	
	@FindBy(css = "div.media-listing > div:nth-child(1) span.open-folder > div > input")
	@CacheLookup
	private WebElement newFolderBox;
	
	@FindBy(css = "section a:nth-of-type(2)")
	@CacheLookup 
	private WebElement printPagePreviewCancel;
	
	@FindBy(css = "div.container-fluid > div#result > div")
	@CacheLookup
	private WebElement messageAfterAddingAFolder;
	
	@FindBy(css = "div.modal-footer > button:nth-child(2)")
	@CacheLookup
	private WebElement deleteButtonModalWindow;
	
	@FindBy(css = "div.modal-footer > button:nth-child(1)")
	@CacheLookup
	private WebElement cancelDeleteButtonModalWindow;
	
	@FindBy(css = "a[href='/library/savedsearches/edit']")
	private WebElement newSavedSearchIconSavedSearch;
	
	@FindBy(css = "article  h4 ")
	private WebElement pageHeader;
	
	public void checkOnOneViewFromList(int itemNumber){
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div.media-listing i.icon-c-folder.margin-right-10")).size();
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing span.relative")).size();
		System.out.println("Number of folders " + numberOfFoldersDisplayed);
		System.out.println("Number of items " + numberOfItemsDisplayed);
		int newItemsNumber;
		if (numberOfItemsDisplayed > 0) {
			if (itemNumber <= numberOfItemsDisplayed && itemNumber > 0) {
				newItemsNumber = numberOfFoldersDisplayed + itemNumber; //div.media-listing > div > div span.relative a
				getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ newItemsNumber +") label")).click();
//				elementClick("div.media-listing > div > div:nth-child("+ newItemsNumber +") label");
			} else {
				newItemsNumber = numberOfFoldersDisplayed + 1;
				System.out.println("There aren't so many saved views displayed so check the first saved view");
//				elementClick("div.media-listing > div > div:nth-child("+ newItemsNumber +") label");
				getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ newItemsNumber +") label")).click();
			}
		} else {
			System.out.println("There aren't any saved views!");
		}
	}
	
	public void verifyAlphabeticalOrder(){
		waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
		waitABit(10000);
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div.media-listing i.icon-c-folder.margin-right-10")).size();
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing span.relative")).size();
		int newItemsNumber = numberOfFoldersDisplayed + 1;
		int numberOfItemsAndFoldersDisplayed = numberOfFoldersDisplayed + numberOfItemsDisplayed;
		
		String getFirstItem = null, getLastItem = null, random;
		
		if(numberOfItemsDisplayed > 0){
			if(numberOfItemsDisplayed ==1){
				System.out.println("There is only one item in list");
			}
			else{
				for(int i=newItemsNumber; i<=numberOfItemsAndFoldersDisplayed; i++){
					random = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child("+ i +")  a")).getText();
					if(StringUtils.isPureAscii(random)){
						getFirstItem = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child("+ i +")  a")).getText().toLowerCase();
						break;
					}
				}
				for(int i=numberOfItemsAndFoldersDisplayed; i>=newItemsNumber; i--){
					random = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child("+ i +")  a")).getText();
					if(StringUtils.isPureAscii(random)){
						getLastItem = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child("+ i +")  a")).getText().toLowerCase();
						break;
					}
				}
				System.out.println(getFirstItem);
				System.out.println(getLastItem);
				Assert.assertTrue(getFirstItem.compareTo(getLastItem) <= 0);
			}
		}
		else{
			System.out.println("There is no item in list");
		}
	}
	
	public void verifySortByDate(){
		waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
//		waitABit(10000);
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div.media-listing i.icon-c-folder.margin-right-10")).size();
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing span.relative")).size();
		int newItemsNumber = numberOfFoldersDisplayed + 1;
		int numberOfItemsAndFoldersDisplayed = numberOfFoldersDisplayed + numberOfItemsDisplayed;
		
		if(numberOfItemsDisplayed > 0){
			if(numberOfItemsDisplayed ==1){
				System.out.println("There is only one item in list");
			}
			else{
				Date date1 = null, date2 = null;  //div.media-listing > div > div:nth-child(2) > div > div > div > div:nth-child(3)
				String getFirstItem = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ newItemsNumber +") > div > div > div > div:nth-child(3)")).getText();
				String getLastItem = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ numberOfItemsAndFoldersDisplayed +")  > div > div > div > div:nth-child(3)")).getText();
				System.out.println(getFirstItem);
				System.out.println(getLastItem);
				DateFormat df1 = new SimpleDateFormat("dd MMM yyyy");
				DateFormat df2 = new SimpleDateFormat("dd MMM yyyy");
				try{
					date1 = df1.parse(getFirstItem);
					
					date2 = df2.parse(getLastItem);
				}
				catch(Exception ex){
					System.out.println(ex);
				}
				Assert.assertTrue(date1.before(date2) || date1.equals(date2));
			}
		}
		else{
			System.out.println("There is no item in list");
		}
	}
	
	public void verifyIfOneViewIsChecked(int itemNumber){
//		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div.media-listing i.icon-c-folder.margin-right-10")).size();
//		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing span.relative")).size();
//		System.out.println("Number of folders " + numberOfFoldersDisplayed);
//		System.out.println("Number of items " + numberOfItemsDisplayed);
//		int newItemsNumber;
//		if (numberOfItemsDisplayed > 0) {
//			if (itemNumber <= numberOfItemsDisplayed && itemNumber > 0) {
//				newItemsNumber = numberOfFoldersDisplayed + itemNumber; //div.media-listing > div > div span.relative a
//				Assert.assertTrue(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ newItemsNumber +") div.checker span")).getAttribute("class").contains("checked"));
//			} else {
//				newItemsNumber = numberOfFoldersDisplayed + 1;
//				System.out.println("There aren't so many saved views displayed so check the first saved view");
//				Assert.assertTrue(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ newItemsNumber +") div.checker span")).getAttribute("class").contains("checked"));
//			}
//		} else {
//			System.out.println("There aren't any saved views!");
//		}
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div.media-listing > div > div div.checker span.checked")).size() == 1);
	}
	
	public String checkOneFolderFromList(int folderNumber){
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div.media-listing i.icon-c-folder.margin-right-10")).size();
		System.out.println("Number of folders " + numberOfFoldersDisplayed);
		String itemTitle="";
		if (numberOfFoldersDisplayed > 0) {
			if (folderNumber <= numberOfFoldersDisplayed && folderNumber > 0) {
//				WebElement folderCheckBox = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ folderNumber +") input"));
//				if(folderCheckBox.getAttribute("class").contains("item select-all-folder content_remove")){
					itemTitle = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ folderNumber +") a")).getText();
					WebElement element = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ folderNumber +") label"));
					element.click();
//					elementClick("div.media-listing > div > div:nth-child("+ folderNumber +") label");
//				}
//				else{
//					System.out.println("Folder already checked");
//				}
//				
			} else {
				System.out.println("There aren't so many saved views displayed so check the first saved view");
//				WebElement folderCheckBox = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(1) input"));
//				if(folderCheckBox.getAttribute("class").contains("item select-all-folder content_remove")){
					itemTitle = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(1) a")).getText();
					WebElement element = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(1) label"));
					element.click();
//					elementClick("div.media-listing > div > div:nth-child(1) label");
//				}
//				else{
//					System.out.println("Folder already checked");
//				}
			}
		} else {
			System.out.println("There aren't any saved views!");
		}
		return itemTitle;
	}
	
	public void verifyActionIcons_SV_SMNC(int itemNumber){
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing i.icon-c-folder.margin-right-10")).size();
		if(numberOfItemsDisplayed == 0){
			System.out.println("There is no item");
		}
		else{
			Assert.assertTrue(addIcon.isDisplayed());
			Assert.assertTrue(moveIcon.isDisplayed());
			Assert.assertTrue(editIcon.isDisplayed());
			Assert.assertTrue(deleteIcon.isDisplayed());
		}
	}
	
	public void verifyActionIcons_SS(int itemNumber){
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div.media-listing span.relative")).size();
		if(numberOfFoldersDisplayed == 0){
			System.out.println("There is no item");
		}
		else{
			Assert.assertTrue(addIcon.isDisplayed());
			Assert.assertTrue(moveIcon.isDisplayed());
			Assert.assertTrue(editIcon.isDisplayed());
			Assert.assertTrue(deleteIcon.isDisplayed());
		}
	}
	
	public void createANewSavedSearch(){
		newSavedSearchIconSavedSearch.click();
	}
	
	public String clickOnOneSavedViewFromList(int itemNumber){
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing i.icon-c-folder.margin-right-10")).size();
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div.media-listing span.relative")).size();
		int newItemsNumber;
		String itemTitle="";
		if (numberOfItemsDisplayed > 0) {
			if (itemNumber <= numberOfItemsDisplayed && itemNumber > 0) {
				newItemsNumber = numberOfFoldersDisplayed + itemNumber;
				itemTitle = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + newItemsNumber + ")  a")).getText();
				getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + newItemsNumber + ")  a")).click();
			} else {
				newItemsNumber = numberOfFoldersDisplayed + 1;
				System.out.println("There aren't so many saved articles displayed so check the first saved article");
				itemTitle = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + newItemsNumber + ") a")).getText();
				getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + newItemsNumber + ") a")).click();
			}
		} else {
			System.out.println("There aren't any saved articles!");
		}
		return itemTitle;
	}
	
	
	public void clickOnEditItem(int itemNumber){
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing span.relative")).size();
		if(numberOfItemsDisplayed == 0){
			System.out.println("There is no item in listing");
		}
		else{
			element(editIcon).waitUntilVisible();
			elementClick("button#edit_product");
			//editIcon.click();
		}
	}
	
	public void moveToFolder(String folderName, int itemNumber) {
		System.out.println(getDriver().findElements(By.cssSelector("button#move-folder > i.icon-c-folder-add")).size());
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing span.relative")).size();
		if(numberOfItemsDisplayed == 0){
			System.out.println("There is no item in listing");
		}
		else{
			moveIcon.click();
			int numberOfFolders = getDriver().findElements(By.cssSelector("div[class='dropdown pull-left open'] > ul > li")).size();
			for(int i=1; i<= numberOfFolders; i++){
				if(getDriver().findElement(By.cssSelector("div[class='dropdown pull-left open'] > ul > li:nth-child(" + i + ") > a")).getText().contains(folderName)){
					getDriver().findElement(By.cssSelector("div[class='dropdown pull-left open'] > ul > li:nth-child(" + i + ") > a")).click();
					//waitForRenderedElements(messageAfterAddingAFolder);
					//Assert.assertTrue(messageAfterAddingAFolder.getText().contains("Articles successfully moved!"));
					break;
				}
			}
		}
	}
	
	public void deleteItemsAndVerify(){
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing span.relative")).size();
		if(numberOfItemsDisplayed == 0){
			System.out.println("There is no item in listing");
		}
		else{
			element(deleteIcon).waitUntilVisible();
			elementClick("button#btn-lib-delete > i");
			deleteButtonModalWindow.click();
			waitABit(5000);
			element(By.cssSelector("div#result div.alert.alert-success")).waitUntilVisible();
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div#result div.alert.alert-success")).getText().contains("Folders and searches successfully deleted!"));
		}
	}
	
	public void checkOneSavedSearchFromList(String savedSearchName){
		getDriver().findElement(By.cssSelector("")).click();
	}
}

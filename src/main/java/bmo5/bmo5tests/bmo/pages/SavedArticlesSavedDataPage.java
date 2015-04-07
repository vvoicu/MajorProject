package bmo5.bmo5tests.bmo.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.FileChecker;
import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class SavedArticlesSavedDataPage extends AbstractPage{
	
	@FindBy(css = "button#add_folder")
	@CacheLookup
	private WebElement addIcon;
	
	@FindBy(css = "button#move-folder")
	@CacheLookup
	private WebElement moveIcon;
	
	@FindBy(css = "button#library_print")
	@CacheLookup
	private WebElement printIcon;
	
	@FindBy(css = "button[href='#permission-modal-print']")
	@CacheLookup
	private WebElement printIconTrial;
	
	@FindBy(css = "div#permission-modal-print strong")
	private WebElement alertMessagePrint;
	
	@FindBy(css = "div#permission-modal-print div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialPrint;
	
	@FindBy(css = "button#library_download")
	@CacheLookup
	private WebElement downloadIcon;
	
	@FindBy(css = "button#library_download")
	@CacheLookup
	private WebElement downloadIconTrial;
	
	@FindBy(css = "button[href='#permission-modal-data-exports']")
	@CacheLookup
	private WebElement downloadIconSavedDataTrial;
	
	@FindBy(css = "div#permission-modal-pdf strong")
	private WebElement alertMessageDownload;
	
	@FindBy(css = "div#permission-modal-pdf div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialDownload;
	
	@FindBy(css = "div#permission-modal-data-exports strong")
	private WebElement alertMessageExport;
	
	@FindBy(css = "div#permission-modal-data-exports div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialExport;
	
	@FindBy(css = "button#btn-lib-delete")
	private WebElement deleteIcon;
	
	@FindBy(css = "div.container-fluid > div#result > div")
	private WebElement messageAfterAddingAFolder;
	
	@FindBy(css = "div.modal-footer > button:nth-child(2)")
	@CacheLookup
	private WebElement deleteButtonModalWindow;
	
	@FindBy(css = "div.modal-footer > button:nth-child(1)")
	@CacheLookup
	private WebElement cancelDeleteButtonModalWindow;
	
	@FindBy(css = "section a:nth-of-type(2)")
	@CacheLookup 
	private WebElement printPagePreviewCancel;
	
	@FindBy(css = "a > i.icon-c-email")
	@CacheLookup
	private WebElement emailIconArticle;
	
	@FindBy(css = "a > i.icon-c-floppy")
	private WebElement saveIconArticle;
	
	@FindBy(css = "a > i.icon-c-download")
	private WebElement downloadIconArticle;
	
	@FindBy(css = "a > i.icon-c-print")
	private WebElement printIconArticle;
	
	@FindBy(css = "div[class='btn-toolbar pull-left'] > a")
	@CacheLookup
	private WebElement backToPreviousPageButtonReport;
	
	@FindBy(css="div.modal-body > button.close")
	@CacheLookup
	private WebElement closeLink;
	
	public String checkOnOneItemFromList(int itemNumber){
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size();
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size();
		System.out.println(numberOfItemsDisplayed);
		int newItemsNumber;
		String itemTitle="";
		if (numberOfItemsDisplayed > 0) {
			if (itemNumber <= numberOfItemsDisplayed && itemNumber > 0) {
				newItemsNumber = numberOfFoldersDisplayed + itemNumber; 
				WebElement element = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ newItemsNumber +") div.span8 label"));
				element.click();
				itemTitle = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ newItemsNumber +")  a")).getText();
				System.out.println(itemTitle);
			} else {
				newItemsNumber = numberOfFoldersDisplayed + 1;
				System.out.println("There aren't so many saved articles displayed so check the first saved article");
				WebElement element = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ newItemsNumber +") div.span8 label"));
				element.click();
				getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ newItemsNumber +") div.span8 label")).click();
				itemTitle = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ newItemsNumber +") a")).getText();
				System.out.println(itemTitle);
			}
		} else {
			System.out.println("There aren't any saved articles!");
		}
		return itemTitle;
	}
	
	public int checkOnOneFolderFromList(int folderNumber){
		waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
		int numberOfFoldersDisplyed = getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size();
//		if(numberOfFoldersDisplyed > 0){
//			for(int i=1; i<=numberOfFoldersDisplyed; i++){
//				if(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + i + ") > div> div > div:nth-child(1) > div > h5 div.edit")).getText().contentEquals(folderName)){
//					System.out.println("Found " + i);
//					System.out.println(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + i + ") > div> div > div:nth-child(1) > div > h5 div.edit")).getText());
//					elementClick("div.media-listing > div:nth-of-type(" + i + ") span input");
//				}
//			}
//		}
//		else{
//			System.out.println("There is no folder in listing");
//		}
		if (numberOfFoldersDisplyed > 0) {
			if (folderNumber <= numberOfFoldersDisplyed && folderNumber > 0) {
				WebElement element = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-of-type(" + folderNumber + ") label"));
				element.click(); 
//				elementClick("div.media-listing > div > div:nth-of-type(" + folderNumber + ") label");
				//Assert.assertTrue(getDriver().findElement(By.cssSelector("div.media-listing div:nth-child(" + folderNumber + ") > div > div > div:nth-child(1) > div > div.checker > span")).getAttribute("class").contains("checked"));
			} else {
				System.out.println("There aren't so many saved articles displayed so check the first folder");
				WebElement element = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(1) label"));
				element.click();
//				elementClick("div.media-listing > div > div:nth-child(1) label");
				//Assert.assertTrue(getDriver().findElement(By.cssSelector("div.media-listing div:nth-child(1) > div > div > div:nth-child(1) > div > div.checker > span")).getAttribute("class").contains("checked"));
			}
		} else {
			System.out.println("There aren't any folders!");
		}
		return numberOfFoldersDisplyed;
	}
	
	public void verifyActionIcons(){
		if(getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size() == 0){
			System.out.println("There is no item in list");
		}
		else{
			Assert.assertTrue(addIcon.isDisplayed());
			Assert.assertTrue(moveIcon.isDisplayed());
			Assert.assertTrue(downloadIcon.isDisplayed());
			Assert.assertTrue(deleteIcon.isDisplayed());
		}
	}
	
	public void clickOnDeleteIconThenCancel(int itemNumber, int folderNumber){
		if(getDriver().findElements(By.cssSelector("button#library_download")).size() == 0){
			System.out.println("There is no item in listing");
		}
		else{
			deleteIcon.click();
			cancelDeleteButtonModalWindow.click();
		}
	}
	
	public void deleteSelectedItems(){
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div")).size();
		if(numberOfItemsDisplayed == 0){
			System.out.println("There is no item in listing");
		}
		else{
			element(deleteIcon).waitUntilVisible();
			deleteIcon.click();
			Sleeper.sleepTight(2000);
			deleteButtonModalWindow.click();
		}
	}
	
	public void moveToFolder(String folderName) {
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size();
		if(numberOfItemsDisplayed == 0){
			System.out.println("There is no item in listing");
		}
		else{
			moveIcon.click();
			int numberOfFolders = getDriver().findElements(By.cssSelector("div[class='btn-group dropdown pull-left open'] > ul > li")).size();
			for(int i=1; i<= numberOfFolders; i++){
				if(getDriver().findElement(By.cssSelector("div[class='btn-group dropdown pull-left open'] > ul > li:nth-child(" + i + ") > a")).getText().contains(folderName)){
					System.out.println("Found");
					getDriver().findElement(By.cssSelector("div[class='btn-group dropdown pull-left open'] > ul > li:nth-child(" + i + ") > a")).click();
					break;
				}
			}
		}
	}
	
	public void moveItemsAndFoldersToFolder(String folderName, int folderNumber){
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size();
		if(numberOfItemsDisplayed > 0){
			//checkOnOneFolderFromList(folderNumber);
			waitForRenderedElementsToBePresent(By.cssSelector("button#move-folder"));
			moveIcon.click();
//			waitForRenderedElementsToBePresent(By.cssSelector("div[class='dropdown pull-left'] > ul > li"));
			int numberOfFolders = getDriver().findElements(By.cssSelector("div[class='dropdown pull-left'] > ul > li")).size();
			for(int i=1; i<= numberOfFolders; i++){
				if(getDriver().findElement(By.cssSelector("div[class='btn-group dropdown pull-left open'] > ul > li:nth-child(" + i + ") > a")).getText().equals(folderName)){
					getDriver().findElement(By.cssSelector("div[class='btn-group dropdown pull-left open'] > ul > li:nth-child(" + i + ") > a")).click();
					//element(messageAfterAddingAFolder).waitUntilVisible();
					//Assert.assertTrue(messageAfterAddingAFolder.getText().contains("You should not select folders!") || messageAfterAddingAFolder.getText().contains("Only items can be moved into folders"));
				} //Only items can be moved into folders!
			}
		}
		else{
			System.out.println("There is no folder in listing");
		}
	}
	
	public String clickOnOneItemFromList(int itemNumber){
		element(By.cssSelector("div.media-listing")).waitUntilVisible();
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size();
		int numberOfFoldersDisplyed = getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size();
		System.out.println(numberOfItemsDisplayed);
		int newItemsNumber;
		String itemTitle="";
		if (numberOfItemsDisplayed > 0) {
			if (itemNumber <= numberOfItemsDisplayed && itemNumber > 0) {
				newItemsNumber = numberOfFoldersDisplyed + itemNumber;
				itemTitle = getDriver().findElement(By.cssSelector("div.media-listing  div:nth-child("+ newItemsNumber +") h5 a")).getText();
				getDriver().findElement(By.cssSelector("div.media-listing div:nth-child(" + newItemsNumber + ") h5  a")).click();
			} else {
				newItemsNumber = numberOfFoldersDisplyed + 1;
				System.out.println("There aren't so many saved articles displayed so check the first saved article");
				itemTitle = getDriver().findElement(By.cssSelector("div.media-listing div:nth-child(" + newItemsNumber + ") h5 a")).getText();
				getDriver().findElement(By.cssSelector("div.media-listing div:nth-child(" + newItemsNumber + ") h5  a")).click();
			}
		} else {
			System.out.println("There aren't any saved articles!");
		}
		return itemTitle;
	}
	
	public void printSelectedItem(){
		if(getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size() == 0){
			System.out.println("There is no item in listing");
		}
		else{
			printIcon.click();
//			WebElement element = getDriver().findElement(By.cssSelector("div#createFolder > div:nth-child(3) > button:nth-child(1)"));
//			element.click();
//			elementClick("button > i.icon-c-print");
			String winHandleBefore = getDriver().getWindowHandle();
			for (String winHandle : getDriver().getWindowHandles()) {
				getDriver().switchTo().window(winHandle);
			}
			printPagePreviewCancel.click();
			getDriver().switchTo().window(winHandleBefore);
		}
	}
	
	public void clickOnPrintButtonTrialUser(){
		if(getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size() == 0){
			System.out.println("There is no item in listing");
		}
		else{
			waitUntilElementExists(By.cssSelector("button[href='#permission-modal-print']"), 10);
//			printIconTrial.click();
			WebElement element = getDriver().findElement(By.cssSelector("button[href='#permission-modal-print']"));
			element.click();
//			elementClick("button[href='#permission-modal-print']");
			Assert.assertTrue(alertMessagePrint.isDisplayed());
			cancelButtonModalWindowTrialPrint.click();
		}
	}
	
	public void printSelectedArticleAndFolder(int folderNumber){
		if(getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size() == 0){
			System.out.println("There is no folder in listing");
		}
		else{
			printIcon.click();
			Assert.assertTrue(messageAfterAddingAFolder.getText().contains("Please select only articles!") || messageAfterAddingAFolder.getText().contains("Please select only reports!"));
		} 
	}
	
	public void downloadSelectedArticleAndFolder(){
		if(getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size() == 0){
			downloadIcon.click();
			Assert.assertTrue(messageAfterAddingAFolder.getText().contains("Please select only articles!")|| messageAfterAddingAFolder.getText().contains("Please select only reports!") || messageAfterAddingAFolder.getText().contains("Please select only data items!"));
		}
		else{
			System.out.println("There is no folder in listing");
		}
	}
	
	public void downloadSelectedItem(String extention){
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size();
		if(numberOfItemsDisplayed == 0){
			System.out.println("There is no item in listing");
		}
		else{
			downloadIcon.click();
			waitABit(2000);
			//TODO fix this
//			DataToolPage data = new DataToolPage(getDriver());
//			data.saveImageHandle2();
//			
			FileChecker fileChecker = new FileChecker();
			fileChecker.verifyExtentionExcelFileFromDataToolTrialUser(extention);
		}
	}
	
	public void clickonDownloadIconFromSavedDataTrialUser(){
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size();
		if(numberOfItemsDisplayed == 0){
			System.out.println("There is no item in listing");
		}
		else{
			downloadIconSavedDataTrial.click();
			Assert.assertTrue(alertMessageExport.isDisplayed());
			cancelButtonModalWindowTrialExport.click();
		}
	}
	
	public void downloadSelectedSavedArticles(String fileName){
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size();
		if(numberOfItemsDisplayed == 0){
			System.out.println("There is no item in listing");
		}
		else{
			downloadIcon.click();
			waitABit(2000);
			
			//TODO fix this
//			DataToolPage data = new DataToolPage(getDriver());
//			data.saveImageHandle2();
			
			FileChecker fileChecker = new FileChecker();
			fileChecker.verifyFileIsDownloadedRelatives(fileChecker.convertFileName(fileName));
		}
	}
	
	public void clickOnDownloadIconTrialUser(){
		if(getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size() == 0){
			System.out.println("There is no item in listing");
		}
		else{
			waitUntilElementExists(By.cssSelector("button[href='#permission-modal-pdf']"), 10);
//			downloadIconTrial.click();
//			elementClick("button[href='#permission-modal-pdf']");
			WebElement element = getDriver().findElement(By.cssSelector("button[href='#permission-modal-pdf']"));
			element.click();
			Assert.assertTrue(alertMessageDownload.isDisplayed());
			cancelButtonModalWindowTrialDownload.click();
		}
	}
	
	public void clickOnEmailIcon(){
		if(getDriver().findElements(By.cssSelector("a > i.icon-c-email")).size() == 1){
			emailIconArticle.click();
			closeLink.click();
		}
	}
	
	public void clickOnSaveIconReport() {
		if(getDriver().findElements(By.cssSelector("a > i.icon-c-floppy")).size() == 1){
			saveIconArticle.click();
			Assert.assertTrue(messageAfterAddingAFolder.getText().contains("The article already exists in Saved Content!") || messageAfterAddingAFolder.getText().contains("Sucessfully added the article to Saved Content"));
		}
	}

	public void clickOnPrintIconReport() {
		if(getDriver().findElements(By.cssSelector("a > i.icon-c-print")).size() == 1){
			printIconArticle.click();
			String winHandleBefore = getDriver().getWindowHandle();
			for (String winHandle : getDriver().getWindowHandles()) {
				getDriver().switchTo().window(winHandle);
			}
			printPagePreviewCancel.click();
			getDriver().switchTo().window(winHandleBefore);
		}
	}

	public void performDownload() {
		waitABit(2000);

		String script = "src\\test\\java\\drivers\\downloadTest.exe";
		Process p;
		try {
			p = Runtime.getRuntime().exec(script);
			p.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnDownloadIconReport(String fileName) {
		if(getDriver().findElements(By.cssSelector("a > i.icon-c-download")).size() == 1){
			downloadIconArticle.click();
			//TODO fix this
//			DataToolPage data = new DataToolPage(getDriver());
//			data.saveImageHandle2();
			FileChecker fileChecker = new FileChecker();
			fileChecker.verifyFileIsDownloadedRelatives(fileChecker.convertFileName(fileName));
		}
	}
	
	public void clickOnBackToPreviousPage() {
		if(getDriver().findElements(By.cssSelector("div[class='btn-toolbar pull-left'] > a")).size() == 1){
			backToPreviousPageButtonReport.click();
		}
	}
	
	public void verifyAlphabeticalOrder(){
		waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
		waitABit(10000);
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size();
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size();
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
				String[] firstItem = getFirstItem.split("[-]");
				String[] lastItem = getLastItem.split("[-]");
				System.out.println(firstItem[1]);
				System.out.println(lastItem[1]);
				Assert.assertTrue(firstItem[1].compareTo(lastItem[1]) <= 0);
			}
		}
		else{
			System.out.println("There is no item in list");
		}
	}
}

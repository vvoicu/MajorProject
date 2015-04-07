package bmo5.bmo5tests.bmo.pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.FileChecker;
import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class SavedReportsPage extends AbstractPage {
	@FindBy(css = "button#add_folder")
	@CacheLookup
	private WebElement addIcon;
	
	@FindBy(css = "button#move-folder")
	@CacheLookup
	private WebElement moveIcon;
	
	@FindBy(css = "button#library_print")
	@CacheLookup
	private WebElement printIcon;
	
	@FindBy(css = "button#library_download")
	@CacheLookup
	private WebElement downloadIcon;
	
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
	
	@FindBy(css = "div.span8 a > i.icon-c-email")
	@CacheLookup
	private WebElement emailIconArticle;
	
	@FindBy(css = "div.span8 a > i.icon-c-floppy")
	private WebElement saveIconArticle;
	
	@FindBy(css = "div.span8 a > i.icon-c-download")
	private WebElement downloadIconArticle;
	
	@FindBy(css = "div.span8 a > i.icon-c-print")
	private WebElement printIconArticle;
	
	@FindBy(css = "a#back-button")
	@CacheLookup
	private WebElement backToPreviousPageButtonReport;
	
	@FindBy(css="div.modal-body > button.close")
	@CacheLookup
	private WebElement closeLink;
	
	public int countReports(){
		return getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size();
	}
	
	public int countFolders(){
		return getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size();
	}
	
	public String clickOnOneReportFromList(int itemNumber){
		element(getDriver().findElement(By.cssSelector("div.media-listing"))).waitUntilVisible();
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size();
		int numberOfFoldersDisplyed = getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size();
		int newItemsNumber;
		String itemTitle="";
		if (numberOfItemsDisplayed > 0) {
			if (itemNumber <= numberOfItemsDisplayed && itemNumber > 0) {
				newItemsNumber = numberOfFoldersDisplyed + itemNumber + 9;
				itemTitle = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + newItemsNumber + ") div.span8  a")).getText();
				getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + newItemsNumber + ") div.span8  a")).click();
			} else {
				newItemsNumber = numberOfFoldersDisplyed + 10;
				System.out.println("There aren't so many saved articles displayed so check the first saved article");
				itemTitle = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + newItemsNumber + ") div.span8  a")).getText();
				getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + newItemsNumber + ") div.span8  a")).click();
			}
		} else {
			System.out.println("There aren't any saved articles!");
		}
		return itemTitle;
	}
	
	
	public int checkOnOneFolderFromSavedReportsList(int folderNumber){
		int numberOfFoldersDisplyed = getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size();
		System.out.println(numberOfFoldersDisplyed);
		System.out.println(folderNumber);
		int newFolderNumber;
		if (numberOfFoldersDisplyed > 0) {
			if (folderNumber <= numberOfFoldersDisplyed && folderNumber > 0) {
				newFolderNumber = folderNumber + 8;
				System.out.println(newFolderNumber);
				WebElement element = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + newFolderNumber + ")  div.span6 > label"));
				element.click();
			} else {
				System.out.println("There aren't so many saved articles displayed so check the first folder");
				getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(10)  div.span6 > label")).click();
			}
		} else {
			System.out.println("There aren't any folders!");
		}
		return numberOfFoldersDisplyed;
	}
	
	public String checkOneReportFromList(int reportNumber){
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div[class='accordion-group'] div.span6")).size();
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div[class='accordion-group'] div.span8")).size();
		int newItemsNumber;
		String itemTitle="";
		if (numberOfItemsDisplayed > 0) {
			if (reportNumber <= numberOfItemsDisplayed && reportNumber > 0) {
				newItemsNumber = numberOfFoldersDisplayed + reportNumber + 9; //div.media-listing > div > div:nth-child(9) div.span8 h5 a 
				System.out.println(newItemsNumber);
				WebElement element = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ newItemsNumber +")  div.span8 > label"));
				element.click();
				
			} else {
				newItemsNumber = numberOfFoldersDisplayed + 10;
				System.out.println("There aren't so many saved articles displayed so check the first saved article");
				WebElement element2 = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ newItemsNumber +")  div.span8 > label"));
				element2.click();
			}
		} else {
			System.out.println("There aren't any saved articles!");
		}
		return itemTitle;
	}
	
	public void verifyAlphabeticalOrder(){
		//TODO Fix this
//		DataToolPage data = new DataToolPage(getDriver());
//		data.waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
		waitABit(10000);
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div[class='accordion-group'] div.span6")).size();
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div[class='accordion-group'] div.span8")).size();
		int newItemsNumber = numberOfFoldersDisplayed + 10;
		int numberOfItemsAndFoldersDisplayed = numberOfFoldersDisplayed + numberOfItemsDisplayed + 9;
		
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
	
	public void verifyActionIcons(int itemNumber){
		if(countReports() > 0){
			Assert.assertTrue(addIcon.isDisplayed());
			Assert.assertTrue(downloadIcon.isDisplayed());
			Assert.assertTrue(deleteIcon.isDisplayed());
			
		}
		else{
			System.out.println("There is no item in list");
		}
	}
	
	public void clickOnDeleteIconThenCancel(int itemNumber, int folderNumber){
		if(countReports() == 0 || countFolders() == 0){
			System.out.println("There is no item in listing");
		}
		else{
			deleteIcon.click();
			cancelDeleteButtonModalWindow.click();
		}
	}
	
	public void deleteSelectedItems(int folderNumber, int itemNumber){
		if(countReports() == 0 && countFolders() == 0){
			System.out.println("There is no item in listing");
		}
		else{
			element(deleteIcon).waitUntilVisible();
			deleteIcon.click();
			Sleeper.sleepTight(2000);
			deleteButtonModalWindow.click();
		}
	}
	
	public void moveToFolder(String folderName, int itemNumber) {
		if(countReports() == 0 ){
			System.out.println("There is no item in listing");
		}
		else{
			moveIcon.click();
			int numberOfFolders = getDriver().findElements(By.cssSelector("div[class='dropdown pull-left open'] > ul > li")).size();
			for(int i=1; i<= numberOfFolders; i++){
				if(getDriver().findElement(By.cssSelector("div[class='dropdown pull-left open'] > ul > li:nth-child(" + i + ") > a")).getText().contains(folderName)){
					WebElement element = getDriver().findElement(By.cssSelector("div[class='dropdown pull-left open'] > ul > li:nth-child(" + i + ") > a"));
					element.click();
					break;
				}
			}
		}
	}
	
	public void moveItemsAndFoldersToFolder(String folderName, int folderNumber){
		if(getDriver().findElements(By.cssSelector("button#move-folder")).size() == 0){
			checkOnOneFolderFromSavedReportsList(folderNumber);
			waitForRenderedElementsToBePresent(By.cssSelector("button#move-folder"));
			moveIcon.click();
			waitForRenderedElementsToBePresent(By.cssSelector("ul#move > li"));
			int numberOfFolders = getDriver().findElements(By.cssSelector("ul#move > li")).size();
			for(int i=1; i<= numberOfFolders; i++){
				if(getDriver().findElement(By.cssSelector("ul#move > li:nth-child(" + i + ") > a")).getText().equals(folderName)){
					getDriver().findElement(By.cssSelector("ul#move > li:nth-child(" + i + ") > a")).click();
					//elementClick("div[class='dropdown pull-left open'] > ul > li:nth-child(" + i + ") > a");
					//element(messageAfterAddingAFolder).waitUntilVisible();
					//Assert.assertTrue(messageAfterAddingAFolder.getText().contains("You should not select folders!") || messageAfterAddingAFolder.getText().contains("Only items can be moved into folders"));
				} //Only items can be moved into folders!
			}
		}
		else{
			System.out.println("There is no folder in listing");
		}
	}
	
	public void printSelectedItem(int itemNumber){
		if(countReports() == 0 ){
			System.out.println("There is no item in listing");
		}
		else{
			waitUntilElementExists(By.cssSelector("button#library_print"), 10);
			printIcon.click();
			String winHandleBefore = getDriver().getWindowHandle();
			for (String winHandle : getDriver().getWindowHandles()) {
				getDriver().switchTo().window(winHandle);
			}
			printPagePreviewCancel.click();
			getDriver().switchTo().window(winHandleBefore);
		}
	}
	
	public void printSelectedArticleAndFolder(int folderNumber){
		if(countFolders() > 0){
			printIcon.click();
			Assert.assertTrue(messageAfterAddingAFolder.getText().contains("Please select only articles!") || messageAfterAddingAFolder.getText().contains("Please select only reports!"));
			
		}
		else{
			System.out.println("There is no folder in listing");
		}
	}
	
	public void downloadSelectedArticleAndFolder(int folderNumber){
		if(countFolders() > 0){
			downloadIcon.click();
			Assert.assertTrue(messageAfterAddingAFolder.getText().contains("Please select only reports!"));
		}
		else{
			System.out.println("There is no folder in listing");
		}
	}
	
	public void downloadSelectedItem(String fileName, int itemNumber){
		if(countReports() == 0 ){
			System.out.println("There is no item in listing");
		}
		else{
			waitUntilElementExists(By.cssSelector("button#library_download"), 10);
			downloadIcon.click();
			waitABit(2000);

//			String script = "src\\test\\java\\drivers\\downloadTestScript.exe";
//			Process p;
//			try {
//				p = Runtime.getRuntime().exec(script);
//				p.waitFor();
//			} catch (IOException | InterruptedException e) {
//				e.printStackTrace();
//			}
			//TODO Fix this
//			DataToolPage data = new DataToolPage(getDriver());
//			data.saveImageHandle1();
			FileChecker fileChecker = new FileChecker();
			fileChecker.verifyReportsAreDownloaded();
		}
	}
	
	public void clickOnEmailIcon(){
		if(getDriver().findElements(By.cssSelector("div.span8 a > i.icon-c-email")).size() == 1){
			emailIconArticle.click();
			closeLink.click();
		}
	}
	
	public void clickOnSaveIconReport() {
		if(getDriver().findElements(By.cssSelector("div.span8 a > i.icon-c-floppy")).size() == 1){
			saveIconArticle.click();
			Assert.assertTrue(messageAfterAddingAFolder.getText().contains("This report already exists in Saved Reports!"));
		}
	}

	public void clickOnPrintIconReport() {
		if(getDriver().findElements(By.cssSelector("div.span8 a > i.icon-c-print")).size() >= 1){
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
		if(getDriver().findElements(By.cssSelector("a > i.icon-c-download")).size() >= 1){
			downloadIconArticle.click();
			//TODO Fix this
//			DataToolPage data = new DataToolPage(getDriver());
//			data.saveImageHandle2();
			FileChecker fileChecker = new FileChecker();
			fileChecker.verifyFileIsDownloaded1(fileChecker.convertFileName(fileName));
		}
	}
	
	public void clickOnBackToPreviousPage() {
		if(getDriver().findElements(By.cssSelector("div[class='btn-toolbar pull-left'] > a")).size() == 1){
			backToPreviousPageButtonReport.click();
		}
	}
	
	public void editFolderName(int folderNumber, String newName){
		newName = newName +"_"+StringUtils.randomNumber(84000)+"_"+StringUtils.randomNumber(84000);
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size();
		if (numberOfFoldersDisplayed > 0) {
			if (folderNumber <= numberOfFoldersDisplayed && folderNumber > 0) {
				
				Actions actions  = new Actions(getDriver());
				actions.moveToElement(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + folderNumber + 9 + ") > div > div > div:nth-child(1) > div > h5 > a > span > div")));
				actions.click(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + folderNumber + 9 + ") > div > div > div:nth-child(1) > div > h5 > a > button i")));
				actions.perform();
				
				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(" + folderNumber + 9 +") div.edit input")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(" + folderNumber + 9 +") div.edit  input")).sendKeys(Keys.DELETE);
				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(" + folderNumber + 9 +") div.edit input")).sendKeys(newName);
				getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + folderNumber + 9 + ") > div > div > div:nth-child(1) > div form > button:nth-of-type(1)")).click();
				Assert.assertTrue(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + folderNumber + 9 +") > div > div > div:nth-child(1) > div > h5 > a > span > div")).getText().contains(newName));
				
			} else {
				System.out.println("There aren't so many folders displayed so check the first saved article");
				
				Actions actions  = new Actions(getDriver());
				actions.moveToElement(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(10) > div > div > div:nth-child(1) > div > h5 > a > span > div")));
				actions.click(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(10) > div > div > div:nth-child(1) > div > h5 > a > button i")));
				actions.perform();
				
				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(10) div.edit input")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(10) div.edit  input")).sendKeys(Keys.DELETE);
				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(10) div.edit input")).sendKeys(newName);
				getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(10) > div > div > div:nth-child(1) > div form > button:nth-of-type(1)")).click();
				waitABit(2000);
				Assert.assertTrue(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(10) > div > div > div:nth-child(1) > div > h5 > a > span > div")).getText().contains(newName));
			}
		} else {
			System.out.println("There aren't any folders!");
		}
		element(messageAfterAddingAFolder).waitUntilVisible();
		Assert.assertTrue(messageAfterAddingAFolder.getText().contains("Folder name successfully changed!") || messageAfterAddingAFolder.getText().contains("Folder name updated to " + newName + " !") || messageAfterAddingAFolder.getText().contains("Folder name already used!") || messageAfterAddingAFolder.getText().contains("update folder name successfull") || messageAfterAddingAFolder.getText().contains("Successfully updated the folder") || messageAfterAddingAFolder.getText().contains("Folder " + newName + "already used!"));
	}
	
	public void verifySortByDate(){
		waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
		waitABit(10000);
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size();
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size();
		int newItemsNumber = numberOfFoldersDisplayed + 11;
		int totalItemsPerPage = getDriver().findElements(By.cssSelector("div.media-listing > div > div")).size();
		System.out.println(numberOfFoldersDisplayed);
		System.out.println(numberOfItemsDisplayed);
		if(numberOfItemsDisplayed > 0){
			if(numberOfItemsDisplayed ==1){
				System.out.println("There is only one item in list");
			}
			else{
				Date date1 = null, date2 = null; //div.media-listing > div > div:nth-child(12) > div > div  > div > div:nth-child(2)
				String getFirstItem = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ newItemsNumber + ") > div > div  > div > div:nth-child(2)")).getText();
				System.out.println(getFirstItem);
				String getLastItem = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ totalItemsPerPage + ") > div > div  > div > div:nth-child(2)")).getText();
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
}

package bmo5.bmo5tests.bmo.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class SavedContentPage extends AbstractPage{

	@FindBy(css = "button#add_folder")
	@CacheLookup
	private WebElement addIcon;
	
	@FindBy(css = "button#btn-lib-delete")
	private WebElement deleteIcon;
	
	@FindBy(css = "button#edit_product")
	@CacheLookup
	private WebElement editIcon;
	
	@FindBy(css = "button#library_print")
	@CacheLookup
	private WebElement moveIcon;
	
	@FindBy(css = "article.span2 > div > ul:nth-child(3) > li > ul > li:nth-child(1) > a")
	@CacheLookup
	private WebElement savedArticlesLeftPanel;
	
	@FindBy(css = "article.span2 > div > ul:nth-child(3) > li > ul > li:nth-child(3) > a")
	@CacheLookup
	private WebElement savedDataLeftPanel;
	
	@FindBy(css = "article.span2 > div > ul:nth-child(3) > li > ul > li:nth-child(2) > a")
	@CacheLookup
	private WebElement savedReportsLeftPanel;
	
	@FindBy(css = "article.span2 > div > ul:nth-child(3) > li > ul > li:nth-child(4) > a")
	@CacheLookup
	private WebElement savedViewsLeftPanel;
	
	@FindBy(css = "article.span2 > div > ul:nth-child(3) > li > ul > li:nth-child(5) > a")
	@CacheLookup
	private WebElement savedSearchesLeftPanel;
	
	@FindBy(css = "article.span2 > div > ul:nth-child(3) > li > ul > li:nth-child(6) > a")
	@CacheLookup
	private WebElement savedMNCLeftPanel;
	
	@FindBy(css = "article.span2 > div > ul:nth-child(3) > li > ul > li.active")
	@CacheLookup
	private WebElement selectedItemLeftPanel;
	
	@FindBy(css = "div.container-fluid > h3")
	@CacheLookup
	private WebElement pageTitle;
	
	@FindBy(css = "ul.breadcrumb > li:last-child")
	@CacheLookup
	private WebElement breadcrumbLast;
	
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
	
	@FindBy(css = "div#createFolder ul#add > li:nth-child(1) > a")
	@CacheLookup
	private WebElement newFolderIconSavedSearch;
	
	@FindBy(css = "div#createFolder ul#add > li:nth-child(2) > a")
	@CacheLookup
	private WebElement newSavedSearchIconSavedSearch;
	
	@FindBy(css = "div[class='paginaxor pagination-listing pagination pagination-small  pagination-right pull-right'] > ul:nth-child(1) > li > a  > i.icon-c-angle-right")
	private WebElement nextIconTopContainer;
	
	@FindBy(css = "div[class='paginaxor pagination-listing pagination pagination-small  pagination-centered'] li a i.icon-c-angle-right ")
	private WebElement nextIconBottomContainer;
	
	@FindBy(css = "div[class='paginaxor pagination-listing pagination pagination-small  pagination-right pull-right'] i.icon-c-angle-double-right")
	private WebElement lastIconTopContainer;
	
	@FindBy(css = "div[class='paginaxor pagination-listing pagination pagination-small  pagination-centered'] i.icon-c-angle-double-right")
	private WebElement lastIconBottomContainer;
	
	@FindBy(css = "div[class='paginaxor pagination-listing pagination pagination-small  pagination-right pull-right'] i.icon-c-angle-left")
	private WebElement previousIconTopContainer;
	
	@FindBy(css = "div[class='paginaxor pagination-listing pagination pagination-small  pagination-centered'] i.icon-c-angle-left")
	private WebElement previousIconBottomContainer;
	
	@FindBy(css = "div[class='paginaxor pagination-listing pagination pagination-small  pagination-right pull-right'] i.icon-c-angle-double-left")
	private WebElement firstIconTopContainer;
	
	@FindBy(css = "div[class='paginaxor pagination-listing pagination pagination-small  pagination-centered'] i.icon-c-angle-double-left")
	private WebElement firstIconBottomContainer;
	
	@FindBy(css = "div[class='paginaxor pagination-listing pagination pagination-small  pagination-right pull-right'] > ul > li")
	@CacheLookup
	private WebElement topContainerPagination;
	
	@FindBy(css = "div[class='paginaxor pagination-listing pagination pagination-small  pagination-centered'] > ul:nth-child(1) > li")
	@CacheLookup
	private WebElement bottomContainerPagination;
	
	@FindBy(css = "div[class='paginaxor pagination-listing pagination pagination-small  pagination-right pull-right'] > ul:nth-child(1) > li:nth-child(3) > a")
	@CacheLookup
	private WebElement threeItemTopContainer;
	
	@FindBy(css = "article.span10 > h4")
	@CacheLookup
	private WebElement numberOfItemsFromHeader;
	
	@FindBy(css = "div[class='paginaxor pagination-listing pagination pagination-small  pagination-right pull-right'] > ul:nth-child(1) > li:last-child > a[data-page]")
	@CacheLookup
	private WebElement lastItemNumberTopContainer;
	
	@FindBy(css = "select#lib-sort-column")
	@CacheLookup
	private WebElement sortBySelectContainer;
	
	@FindBy(css = "select#lib-sort > option:nth-child(1)")
	@CacheLookup
	private WebElement sortBySavedDateOrderItem;
	
	@FindBy(css = "select#lib-sort > option:nth-child(2)")
	@CacheLookup
	private WebElement sortByAlphabeticalOrderItem;
	
	@FindBy(css = "article  h4 ")
	private WebElement pageHeader;
	
	@FindBy(css = "ul#move > li")
	private WebElement foldersContainer;
	
	@FindBy(css = "button#new-submit")
	private WebElement saveFolderButton;
	
	@FindBy(css = "input#select-all")
	private  WebElement selectAllCheckBox;
	
	public void verifyCorrectItemSavedArticlesLeftPanel(){
		Assert.assertTrue(selectedItemLeftPanel.getText().equals(savedArticlesLeftPanel.getText()));
	}
	
	public void verifyCorrectItemSavedReportsLeftPanel(){
		Assert.assertTrue(selectedItemLeftPanel.getText().equals(savedReportsLeftPanel.getText()));
	}
	
	public void verifyCorrectItemSavedViewsLeftPanel(){
		Assert.assertTrue(selectedItemLeftPanel.getText().equals(savedViewsLeftPanel.getText()));
	}
	
	public void verifyCorrectItemSavedSearchesLeftPanel(){
		Assert.assertTrue(selectedItemLeftPanel.getText().equals(savedSearchesLeftPanel.getText()));
	}
	
	public void verifyCorrectItemSavedMNCLeftPanel(){
		Assert.assertTrue(selectedItemLeftPanel.getText().equals(savedMNCLeftPanel.getText()));
	}
	
	public void verifyCorrectItemSavedDataLeftPanel(){
		Assert.assertTrue(selectedItemLeftPanel.getText().equals(savedDataLeftPanel.getText()));
	}

	public int numberOfItemsFromHeader(){
		String numberOfItemsFromHeaderString = numberOfItemsFromHeader.getText().replaceAll("[^0-9]", "");
		Integer numberOfItemsFromHeaderInteger = Integer.valueOf(numberOfItemsFromHeaderString);
		return numberOfItemsFromHeaderInteger;
	}
	
	public int numberOfItemsFromListingPerPage(){
		element(By.cssSelector("div.media-listing")).waitUntilVisible();
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size();
		System.out.println("Number of folders displayed: " + numberOfFoldersDisplayed);
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size();
		System.out.println("Number of items displayed: " + numberOfItemsDisplayed);
		int totalNumberOfItemsFromFolders = numberOfItemsDisplayed;
		int numberOfItemsFromFolderDisplayed,i=1;
		if(numberOfFoldersDisplayed > 0){
			for(i=1; i<=numberOfFoldersDisplayed; i++) {
				getDriver().findElement(By.cssSelector("div[class='media-listing'] > div:nth-child(" + i + ") div.span6 h5  span i:nth-child(1)")).click();
				Sleeper.sleepTight(3000);
				element(By.cssSelector("div.media-listing")).waitUntilVisible();
				numberOfItemsFromFolderDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div:nth-child("+ i +")  div.span8")).size();
				totalNumberOfItemsFromFolders += numberOfItemsFromFolderDisplayed;
				System.out.println("Number of elements from folder "+i+" is: "+numberOfItemsFromFolderDisplayed);
			}
			getDriver().findElement(By.cssSelector("div[class='media-listing'] > div:nth-child(" + numberOfFoldersDisplayed + ") div.span6 h5  span i:nth-child(1)")).click();
		}
		
		return totalNumberOfItemsFromFolders;
	}
	
	public int totalNumberOfListing(){
		element(By.cssSelector("div.media-listing")).waitUntilVisible();
		int numberOfItemsInPaginator = getDriver().findElements(By.cssSelector("div[class='paginaxor pagination-listing pagination pagination-small pagination-right pull-right'] > ul:nth-child(1) > li")).size();
		int numberOfPages = numberOfItemsInPaginator - 2;//if there id the "of" element "2" will be replaced by "3" !
		System.out.println("Number of pages: " + numberOfPages);
		int totalNumberOfItemsDisplayed;
		totalNumberOfItemsDisplayed = numberOfItemsFromListingPerPage();
		System.out.println("Number of items displayed on first page: " + totalNumberOfItemsDisplayed);
		Sleeper.sleepTight(2000);
		if(numberOfPages > 1 ){
			for(int i=2; i<=numberOfPages; i++){
				nextIconTopContainer.click();
				waitABit(3000);
				totalNumberOfItemsDisplayed += numberOfItemsFromListingPerPage();
				System.out.println("Number of items displayed on " + i + " page is:" + totalNumberOfItemsDisplayed);
			}
		}
		return totalNumberOfItemsDisplayed;
	}
	
	public void verifyNumberOfItems(){
		Assert.assertEquals(numberOfItemsFromHeader(), totalNumberOfListing());
		firstIconTopContainer.click();
		Sleeper.sleepTight(2000);
	}
	
	public void addNewFolder(String newFolderName) {
		waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
		addIcon.click();
		newFolderBox.sendKeys(newFolderName);
		saveFolderButton.click();
		waitABit(3000);
		Assert.assertTrue(messageAfterAddingAFolder.getText().contains("Folder successfully created!") || messageAfterAddingAFolder.getText().contains("Folder name already used!") || messageAfterAddingAFolder.getText().contains("folder successfully created")
				|| messageAfterAddingAFolder.getText().contains("Successfully created a new folder")
				|| messageAfterAddingAFolder.getText().contains("Folder " + newFolderName +" already used!"));
	}
	
	public void moveFolderIntoFolder(String existingFolderName){
		addIcon.click();
		String folderName = Integer.toString(StringUtils.randomNumber(10000));
		newFolderBox.sendKeys(folderName);
		try{
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e){
			System.out.println(e);
		}
		int numberOfFolders = getDriver().findElements(By.cssSelector("div.media-listing > div > div > div > div > div:nth-of-type(1) > div > h5 > a > span > div")).size();
		System.out.println(numberOfFolders);
		for(int i=1 ; i<= numberOfFolders; i++){
			System.out.println(i);
			if(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-of-type(" + i + ") > div > div > div:nth-of-type(1) > div > h5 > a > span > div")).getText().contentEquals(folderName)){
				System.out.println(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-of-type(" + i + ") > div > div > div:nth-of-type(1) > div > h5 > a > span > div")).getText());
				getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-of-type(" + i + ") > div > div > div:nth-of-type(1) > div > div > span ")).click();
				System.out.println("Clicked");
				break;
			}
		}
		moveIcon.click();
		int numberOfFolders2 = getDriver().findElements(By.cssSelector("ul#move > li")).size();
		System.out.println(numberOfFolders2);
		for(int j =1; j<=numberOfFolders2; j++){
			if(getDriver().findElement(By.cssSelector("ul#move > li:nth-child(" + j + ") > a")).getText().contains(folderName)){
				waitABit(5000);
				getDriver().findElement(By.cssSelector("ul#move > li:nth-child(" + j + ") > a")).click();
				waitABit(5000);
				System.out.println("Moved");
				break;
			}
		}
		//selectFromDropdown(foldersContainer, existingFolderName);
	}
	
	public boolean verifyMessageDisplayedAfterAddingAFolder(String folderName){
		boolean differentName = false;
		int numberOfFoldersDisplyed = getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size();
		for(int i=1; i<= numberOfFoldersDisplyed; i++){
			if(getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + i + ") > div >  div:nth-child(2) > h5 > a span > div")).getText().equals(folderName)){
				differentName = false;
				break;
			}
			else {
				differentName = true;
			}
		}
		return differentName;
	}

	/*public void verifyTheDefaultOrder() {
			element(By.cssSelector("div.media-listing")).waitUntilVisible();
			DateTransformer data1;
			int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div[class='accordion-group'] div.span8")).size();
			System.out.println(numberOfItemsDisplayed);
			int numberOfFoldersDisplyed = getDriver().findElements(By.cssSelector("div[class='accordion-group'] div.span6")).size();
			System.out.println(numberOfFoldersDisplyed);
			String firstItemToCompareString, secondItemToCompareString;
			Integer firstItemToCompareInt, secondItemToCompareInt;
			int newItemsNumber1, newItemsNumber2;
			boolean chronologicalOrder = false;
			for(int i=2; i<= numberOfItemsDisplayed; i++){
					newItemsNumber1 = numberOfFoldersDisplyed + i -1;
					System.out.println(newItemsNumber1);
					newItemsNumber2 = numberOfFoldersDisplyed + i;
					System.out.println(newItemsNumber2);
					firstItemToCompareString = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child("+ newItemsNumber1 +")  div[class='span2 text-center']")).getText();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");
					try {
						Date convertedDate = dateFormat.parse(firstItemToCompareString);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					firstItemToCompareString = firstItemToCompareString.replaceAll("[^0-9]", "");
					System.out.println(dateFormat);
					firstItemToCompareInt = Integer.valueOf(firstItemToCompareString);
					secondItemToCompareString = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child("+ newItemsNumber2 +")  div[class='span2 text-center']")).getText();
					SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd MMM YYYY");
					try {
						Date convertedDate = dateFormat.parse(secondItemToCompareString);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					secondItemToCompareString = secondItemToCompareString.replaceAll("[^0-9]", "");
					System.out.println(dateFormat2);
					secondItemToCompareInt = Integer.valueOf(secondItemToCompareString);
					if(firstItemToCompareInt <= secondItemToCompareInt) {
						chronologicalOrder = true;
					}
					else{
						chronologicalOrder = false;
						break;
					}
					//if(dateFormat.equals(dateFormat2) || dateFormat.)  {
						
					}
					
			}
			//Assert.assertTrue(chronologicalOrder);
	}*/	
	
	public void clickOnSavedReportsLeftPanel(){
		savedReportsLeftPanel.click();
	}
	
	public void clickOnSavedViewsLeftPanel(){
		savedViewsLeftPanel.click();
	}
	
	public void clickOnSavedSearchesLeftPanel(){
		savedSearchesLeftPanel.click();
	}
	
	public void verifyifSavedSearchesLeftPanelIsActive(){
		System.out.println(getDriver().findElement(By.cssSelector("article.span2 > div > ul:nth-child(3) > li > ul > li.active > a")).getText());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("article.span2 > div > ul:nth-child(3) > li > ul > li:nth-child(5)")).getAttribute("class").contains("active"));
	}
	
	public void clickOnSavedMNCLeftPanel(){
		savedMNCLeftPanel.click();
		System.out.println("done!");
	}

	public void clickOnSavedDataLeftPanel(){
		savedDataLeftPanel.click();
	}
	
	public void navigateThroughPages(){
		if(topContainerPagination.isDisplayed() && bottomContainerPagination.isDisplayed()){
			if(threeItemTopContainer.getText().equals("3")){
				nextIconTopContainer.click();
				Sleeper.sleepTight(2000);
				lastIconBottomContainer.click();
				Sleeper.sleepTight(2000);
				previousIconBottomContainer.click();
				Sleeper.sleepTight(2000);
				firstIconTopContainer.click();
				Sleeper.sleepTight(2000);
			}
			else{
				nextIconTopContainer.click();
				Sleeper.sleepTight(2000);
				firstIconTopContainer.click();
				Sleeper.sleepTight(2000);
			}
		}
		else{
			System.out.println("There is a single page with no paginators available");
		}
	}
	
	public void clickLastPageAndClickNewestSavedTable(String savedDataName){
		int numberOfItems=Integer.parseInt(numberOfItemsFromHeader.getAttribute("data-itemcount"));
		if(numberOfItems>15){
		if (topContainerPagination.isDisplayed()
				&& bottomContainerPagination.isDisplayed()) {
		//	if (threeItemTopContainer.getText().equals("3")) {
				lastIconBottomContainer.click();
					waitABit(5000);
			//	}
			}

		}
		clickSavedData(savedDataName);
	}
	
	public void clickSavedData(String savedDataName){
		element(By.cssSelector("div.media-listing")).waitUntilVisible();
		WebElement container = getDriver().findElement(By.cssSelector("div.media-listing"));
        List <WebElement> savedDataLinks=container.findElements(By.cssSelector("div.span8 > h5 > span > form > a > div"));
        int numberOfFolders=container.findElements(By.cssSelector("div.span6 > h5 > a > span > div")).size();
        savedDataName=savedDataName.replaceAll(" ", "");
       
        for(int i=0; i<savedDataLinks.size();i++){
        	if(savedDataLinks.get(i).getText().replaceAll(" ", "").contains(savedDataName)){
        		int j=i+1+numberOfFolders;
        		container.findElement(By.cssSelector("div:nth-of-type("+j+")> div > div > div > div > h5 > span > form > a")).click();
        	}   
        }
	}
	
	public void verifyOrderBySavedDate(){
		int numberOfItemsInPaginator = getDriver().findElements(By.cssSelector("div[class='paginaxor pagination-listing pagination pagination-small pagination-right pull-right'] > ul:nth-child(1) > li")).size();
		int numberOfPages = numberOfItemsInPaginator - 3;
		System.out.println("Number of pages: " + numberOfPages);
		//verifyTheDefaultOrder();
		if(numberOfPages > 1 ){
			for(int i=2; i<=numberOfPages; i++){
				nextIconTopContainer.click();
				waitABit(3000);
			//	verifyTheDefaultOrder();
			}
			firstIconBottomContainer.click();
		}
	}
	
	public String editFolderName(int folderNumber, String newName){
		newName = newName +"_"+StringUtils.randomNumber(84000)+"_"+StringUtils.randomNumber(84000);
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size();
//		for(int i=1; i<= numberOfFoldersDisplayed; i++){
//			if(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + i + ") > div > div > div:nth-child(1) > div > h5 > a > span > div")).getText().contentEquals(folderName)){
//				Actions actions  = new Actions(getDriver());
//				actions.moveToElement(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + i + ") > div > div > div:nth-child(1) > div > h5 > a > span > div")));
//				actions.click(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + i + ") > div > div > div:nth-child(1) > div > h5 > a > button i")));
//				actions.perform();
//				
//				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(" + i +") div.edit input")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
//				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(" + i +") div.edit  input")).sendKeys(Keys.DELETE);
//				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(" + i +") div.edit input")).sendKeys(newName);
//				getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + i +") > div > div > div:nth-child(1) > div form > button:nth-of-type(1)")).click();
//				Assert.assertTrue(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + i +") > div > div > div:nth-child(1) > div > h5 > a > span > div")).getText().contains(newName));
//				break;
//			}
//		}
		if (numberOfFoldersDisplayed > 0) {
			if (folderNumber <= numberOfFoldersDisplayed && folderNumber > 0) {
				
				Actions actions  = new Actions(getDriver());
				actions.moveToElement(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + folderNumber + ") > div > div > div:nth-child(1) > div > h5 > a > span > div")));
				actions.click(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + folderNumber + ") > div > div > div:nth-child(1) > div > h5 > a > button i")));
				actions.perform();
				
				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(" + folderNumber +") div.edit input")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(" + folderNumber +") div.edit  input")).sendKeys(Keys.DELETE);
				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(" + folderNumber +") div.edit input")).sendKeys(newName);
				getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + folderNumber +") > div > div > div:nth-child(1) > div form > button:nth-of-type(1)")).click();
				Assert.assertTrue(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(" + folderNumber +") > div > div > div:nth-child(1) > div > h5 > a > span > div")).getText().contains(newName));
				
			} else {
				System.out.println("There aren't so many folders displayed so check the first saved article");
				
				Actions actions  = new Actions(getDriver());
				actions.moveToElement(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(1) > div > div > div:nth-child(1) > div > h5 > a > span > div")));
				actions.click(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(1) > div > div > div:nth-child(1) > div > h5 > a > button i")));
				actions.perform();
				
				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(1) div.edit input")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(1) div.edit  input")).sendKeys(Keys.DELETE);
				getDriver().findElement(By.cssSelector("div.media-listing > div div:nth-child(1) div.edit input")).sendKeys(newName);
				getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(1) > div > div > div:nth-child(1) > div form > button:nth-of-type(1)")).click();
				waitABit(2000);
				Assert.assertTrue(getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(1) > div > div > div:nth-child(1) > div > h5 > a > span > div")).getText().contains(newName));
			}
		} else {
			System.out.println("There aren't any folders!");
		}
		element(messageAfterAddingAFolder).waitUntilVisible();
		Assert.assertTrue(messageAfterAddingAFolder.getText().contains("Folder name successfully changed!") || messageAfterAddingAFolder.getText().contains("Folder name updated to " + newName + " !") || messageAfterAddingAFolder.getText().contains("Folder name already used!") || messageAfterAddingAFolder.getText().contains("update folder name successfull") || messageAfterAddingAFolder.getText().contains("Successfully updated the folder") || messageAfterAddingAFolder.getText().contains("Folder " + newName + "already used!") || messageAfterAddingAFolder.getText().contains("Folder name successfully changed !"));
		return newName;
	}
	
	public void changeToAlphabeticalOrder(){
		waitABit(5000);
		waitUntilElementExists(By.cssSelector("select#lib-sort-column"), 20);
		selectFromDropdown(sortBySelectContainer,"Alphabetical Order");
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
				System.out.println(getFirstItem);
				System.out.println(getLastItem);
				Assert.assertTrue(getFirstItem.compareTo(getLastItem) <= 0);
			}
		}
		else{
			System.out.println("There is no item in list");
		}
	}
	
	public void verifySavedContentIsEmptySecondChildEnterpriseUser(){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div.media-listing div.accordion-heading")).size() == 0);
	}
	
	public void deleteAllSavedContent(){
		waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
		int numberOfItems = getDriver().findElements(By.cssSelector("div.media-listing div.accordion-heading")).size();
		while(numberOfItems > 0){
			if(numberOfItems < 15) {
				System.out.println(getDriver().findElements(By.cssSelector("div.media-listing div.accordion-heading")).size());
				waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
				if(verifyElementState("document.getElementById('select-all')")){
					deleteIcon.click();
					deleteButtonModalWindow.click();
				}
				else{
					WebElement element = getDriver().findElement(By.cssSelector("form#library-top > div:nth-of-type(3) > div > div > div > div > div:nth-of-type(1) span > label"));
					element.click();
					deleteIcon.click();
					deleteButtonModalWindow.click();
				}
				break;
			}
			else{
				System.out.println(getDriver().findElements(By.cssSelector("div.media-listing div.accordion-heading")).size());
				waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
				if(verifyElementState("document.getElementById('select-all')")){
					deleteIcon.click();
					deleteButtonModalWindow.click();
				}
				else{
					WebElement element = getDriver().findElement(By.cssSelector("form#library-top > div:nth-of-type(3) > div > div > div > div > div:nth-of-type(1) span > label"));
					element.click();
					deleteIcon.click();
					deleteButtonModalWindow.click();
					waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
				}
				numberOfItems = getDriver().findElements(By.cssSelector("div.media-listing div.accordion-heading")).size();
			}
		}
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div.media-listing div.accordion-heading")).size() == 0);
	}
	
	public void deleteAllSavedContentMnc(){
		waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
		int numberOfItems = getDriver().findElements(By.cssSelector("div.media-listing div.accordion-heading")).size();
		while(numberOfItems > 0){
			System.out.println(getDriver().findElements(By.cssSelector("div.media-listing div.accordion-heading")).size());
			waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
			WebElement element = getDriver().findElement(By.cssSelector("form#library-top > div:nth-of-type(3) > div > div > div > div > div >  div:nth-of-type(1) >  span > label"));
			element.click();
			deleteIcon.click();
			deleteButtonModalWindow.click();
			waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
			numberOfItems = getDriver().findElements(By.cssSelector("div.media-listing div.accordion-heading")).size();
		}
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div.media-listing div.accordion-heading")).size() == 0);
	}
	
	public void verifySortByDate(){
		waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
//		waitABit(10000);
		int numberOfFoldersDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span6")).size();
		int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing div.span8")).size();
		int newItemsNumber = numberOfFoldersDisplayed + 1;
		int numberOfItemsAndFoldersDisplayed = numberOfFoldersDisplayed + numberOfItemsDisplayed;
		
		if(numberOfItemsDisplayed > 0){
			if(numberOfItemsDisplayed ==1){
				System.out.println("There is only one item in list");
			}
			else{
				Date date1 = null, date2 = null;
				String getFirstItem = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ newItemsNumber +") > div > div > div > div:nth-child(2)")).getText();
				String getLastItem = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child("+ numberOfItemsAndFoldersDisplayed +")  > div > div > div > div:nth-child(2)")).getText();
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
}



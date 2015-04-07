package bmo5.bmo5tests.adm.pages.systemalerts;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class HelpPage extends AbstractAdmPage{

	@FindBy(css = "a[href='/systemalerts/help/add']")
	private WebElement addButton;
	
	@FindBy(css = "thead th:nth-child(1)")
	private WebElement typeColumnHeader;
	
	@FindBy(css = "thead th:nth-child(2)")
	private WebElement pageOrSubjectColumnHeader;
	
	@FindBy(css = "thead th:nth-child(3)")
	private WebElement chapterColumnHeader;
	
	@FindBy(css = "thead th:nth-child(4)")
	private WebElement statusColumnHeader;
	
	@FindBy(css = "thead th:nth-child(5)")
	private WebElement lastUpdatedColumnHeader;
	
	@FindBy(css = "div.btn-toolbar > div:nth-child(1) >a")
	private WebElement manageContentButton;
	
	@FindBy(css = "a.help.btn")
	private WebElement helpButton;
	
	@FindBy(css = "div.modal-footer > button")
	private WebElement closeButtonHelpWindow;
	
	@FindBy(css = "div#DataTables_Table_0_wrapper > div:nth-child(2) > div:nth-child(2) > div > ul > li i.icon-angle-right")
	private WebElement nextIcon;
	
	@FindBy(css = "div > div:nth-child(2) > div:nth-child(2) > div > ul > li  i.icon-angle-right")
	private WebElement nextIconManageHelpContent;
	
	@FindBy(css = "div#help-content-sortable-table_wrapper > div:nth-child(2) > div:nth-child(2) > div > ul > li  i.icon-angle-left")
	private WebElement previousIconManageHelpContent;
	
	@FindBy(css = "div#DataTables_Table_0_wrapper > div:nth-child(2) > div:nth-child(2) > div > ul > li  i.icon-angle-left")
	private WebElement previousIcon;
	
	@FindBy(css = "a.btn.btn-primary")
	private WebElement deleteWindowOKButton;
	
	@FindBy(css = "a.btn.null")
	private WebElement deleteWindowCancelButton;
	
	@FindBy(css = "ul#sidebar > li:nth-child(17) > a")
	private WebElement systemAlerts;
	
	@FindBy(css = "ul#sidebar > li:nth-child(17) > ul > li:nth-child(4) > a ")
	private WebElement help;
	
	@FindBy(css = "input#Chapter")
	private WebElement chapterNameBoxModalWindow;
	
	@FindBy(css = "input#chapter_name")
	private WebElement addNewChapterBoxModalWindow;
	
	@FindBy(css = "button#edit_chapter")
	private WebElement updateButtonModalWindow;
	
	@FindBy(css = "div#edit_modal button[type='reset']")
	private WebElement cancelLinkModalWindow;
	
	@FindBy(css = "div#add_modal button[type='reset']")
	private WebElement cancelLinkAddNewChapterModalWindow;
	
	@FindBy(css = "select[name='help-content-sortable-table_length']")
	private WebElement recordsPerPageSelectManageHelpContent;
	
	@FindBy(css = "div#help-content-sortable-table_filter input")
	private WebElement searchInput;
	
	@FindBy(css = "div#subchapters_table_filter input")
	private WebElement searchForSubchaptersInput;
	
	@FindBy(css = "a[href='#add_modal']")
	private WebElement addNewChapterButtonManageHelpContentButton;
	
	@FindBy(css = "button#add_chapter")
	private WebElement addNewChapterButtonModalWindow;
	
	@FindBy(css = "select#Type")
	@CacheLookup
	private WebElement typeContainer;
	
//	@FindBy(css = "input[id='Page Name']")
	@FindBy(css = "form.form-horizontal > div:nth-child(2) input.span11")
	private WebElement pageNameBoxAddNewSubChapterPage;
	
	@FindBy(id = "Content_ifr")
	private WebElement contentIframe;
	
	@FindBy(css = "body#tinymce > p")
	private WebElement textAreaInput;
	
	@FindBy(css = "form.form-horizontal > div:nth-child(5) > div > label ")
	private WebElement errorMessageContent;
	
	@FindBy(css = "button > i.icon-ok")
	private WebElement addSubChapterButton;
	
	@FindBy(css = "button[type='reset']")
	private WebElement resetFormAddingNewSubchapterLink;
	
	//@FindBy(css = "iframe#Content_ifr")
	//@FindBy(css = "body#tinymce > p")
	@FindBy(css = "table#Content_tbl > tbody > tr:nth-child(2) > td > iframe")
	private WebElement contentBoxNewSubChapter;
	
	@FindBy(css = "select#Chapter")
	private WebElement chaptersContainer;
	
	@FindBy(css = "select#Status")
	private WebElement statusContainer;
	
	@FindBy(css = "div#breadcrumb > div:nth-child(2) > div:nth-child(2) > a ")
	private WebElement addNewSubChapterButtonHelpPage;
	
	@FindBy(css = "div#breadcrumb a[href='/systemalerts/help'] ")
	private WebElement listViewButton;
	
	@FindBy(css = "select[name='DataTables_Table_0_length']")
	private WebElement selectRecordsPerPageDropDown;
	
	public void clickOnListViewButton(){
		listViewButton.click();
	}

	public void clickOnNewHelp(){
		element(addButton).waitUntilVisible();
		addButton.click();
	}
	
	public void verifyTableColumns(){
		Assert.assertTrue(typeColumnHeader.getAttribute("aria-sort").equals("ascending"));
		typeColumnHeader.click();
		Assert.assertTrue(typeColumnHeader.getAttribute("aria-sort").equals("descending"));
		pageOrSubjectColumnHeader.click();
		Assert.assertTrue(pageOrSubjectColumnHeader.getAttribute("aria-sort").equals("ascending"));
		chapterColumnHeader.click();
		Assert.assertTrue(chapterColumnHeader.getAttribute("aria-sort").equals("ascending"));
		statusColumnHeader.click();
		Assert.assertTrue(statusColumnHeader.getAttribute("aria-sort").equals("ascending"));
		lastUpdatedColumnHeader.click();
		Assert.assertTrue(lastUpdatedColumnHeader.getAttribute("aria-sort").equals("ascending"));
	}
	
	public void clickOnTypeColumnFromHeader(){
		typeColumnHeader.click();
	}
	
	public void clickOnPageOrSubjectColumnFromHeader(){
		pageOrSubjectColumnHeader.click();
	}
	
	public void clickOnChapterColumnFromHeader(){
		chapterColumnHeader.click();
	}
	
	public void clickOnStatusColumnFromHeader(){
		statusColumnHeader.click();
	}
	
	public void clickOnLastUpdatedColumnFromHeader(){
		lastUpdatedColumnHeader.click();
	}
	
	public void navigateToNextPage(){
		nextIcon.click();
	}
	
	public void navigateToPreviousPage(){
		previousIcon.click();
	}
	
	public void deleteOneItemFromListing(String pageName){
		int numberOfItems = getDriver().findElements(By.cssSelector("tbody > tr")).size();
		for(int i=1;i<=numberOfItems;i++){
			if(getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child( " + i + ") > td:nth-child(2) > a")).getText().equals(pageName)){
				getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child( " + i + ") > td:nth-child(6) > a")).click();
					deleteWindowOKButton.click();
					System.out.println("Deleted!!");
					break;
				}
			}
		//TODO fix this
//		ManageWidgetsPage manage = new ManageWidgetsPage(getDriver());
//		manage.selectRecordsPerPageAndVerify("All");
		int numberOfItemsNew = getDriver().findElements(By.cssSelector("tbody > tr")).size();
		Assert.assertTrue(numberOfItemsNew == numberOfItems - 1);
	}
	
	public void clickOnDeleteIconOfOneElementAndCancel(String name){
		int numberOfItems = getDriver().findElements(By.cssSelector("tbody > tr")).size();
		for(int i=1;i<=numberOfItems;i++){
			if(getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child( " + i + ") > td:nth-child(2) > a")).getText().equals(name)){
				getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child( " + i + ") > td:nth-child(6) > a")).click();
				deleteWindowCancelButton.click();
				break;
			}
		}
	}
	
	public void clickOnHelp(){
		systemAlerts.click();
		help.click();
	}
	
	public void clickOnManageContentButton(){
		manageContentButton.click();
	}
	
	public void clickOnUpArrowChapter(String chapterName){
		int numberOfChapters = getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr")).size();
		for(int i=1; i<=numberOfChapters; i++){
			if(getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).getText().equals(chapterName)){
				getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > div > button > i.icon-up-dir")).click();
				break;
			}
		}
	}
	
	public void clickOnDownArrowChapter(String chapterName){
		int numberOfChapters = getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr")).size();
		for(int i=1; i<=numberOfChapters; i++){
			if(getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).getText().equals(chapterName)){
				getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > div > button > i.icon-down-dir")).click();
				break;
			}
		}
	}
	
	public void clickOnDeleteButtonThenCancel(String chapterName){
		int numberOfChapters = getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr > td:nth-child(2)")).size();
		for(int i=1; i<=numberOfChapters; i++){
			if(getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).getText().equals(chapterName)){
				if(getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(5) > a")).size() == 1){
					getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(5) > a")).click();
					deleteWindowCancelButton.click();
					break;
				}
				else{
					System.out.println("This chapter has sub-chapters");
				}
			}
		}
	}
	
	public void deleteOneChapterFromList(String chapterName){
		int numberOfChapters = getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr > td:nth-child(2)")).size();
		boolean isAvailableAndPresent = false;
		for(int i=1; i<=numberOfChapters; i++){
			if(getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).getText().equals(chapterName)){
				if(getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(5) > a")).size() == 1){
				getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(5) > a")).click();
				deleteWindowOKButton.click();
				isAvailableAndPresent = true;
				break;
				}
				else{
					System.out.println("This chapter has sub-chapters");
				}
			}
		}
		if(isAvailableAndPresent == true){
			recordsPerPageSelect("All");
			int numberOfChaptersNew = getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr > td:nth-child(2)")).size();
			Assert.assertTrue(numberOfChaptersNew == numberOfChapters - 1);
		}
		else{
			System.out.println("The chapter is not available to be deleted or present");
		}
	}
	
	public void changeTheChaptersNameAndClickOnCancelButton(String newName, String oldName){
		int numberOfChapters = getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr")).size();
		
		for(int i=1; i<=numberOfChapters; i++){
			if(getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).getText().equals(oldName)){
				getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).click();
				chapterNameBoxModalWindow.click();
				chapterNameBoxModalWindow.sendKeys(Keys.chord(Keys.CONTROL,"a"));
				chapterNameBoxModalWindow.sendKeys(Keys.DELETE);
				chapterNameBoxModalWindow.sendKeys(newName);
				cancelLinkModalWindow.click();
				break;
			}
		}
	}
	
	public void changeTheChaptersNameAndClickOnUpdateButton(String newName, String oldName){
		int numberOfChapters = getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr")).size();
		boolean isPresent = false;
//		for(int i=1; i<=numberOfChapters; i++){
//			if(getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).getText().equals(newName)){
//				getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).click();
//				waitABit(5000);
//				deleteOneChapterFromList(newName);
//				waitABit(5000);
//				break;
//			}
//		}
//		waitABit(5000);
//		numberOfChapters = getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr")).size();
//		recordsPerPageSelect("All");
		for(int i=1; i<=numberOfChapters; i++){
			if(getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).getText().equals(newName)){
				System.out.println("There is already a chapter with this name");
				break;
			}
			else if(getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).getText().equals(oldName)){
				getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).click();
				chapterNameBoxModalWindow.click();
				chapterNameBoxModalWindow.sendKeys(Keys.chord(Keys.CONTROL,"a"));
				chapterNameBoxModalWindow.sendKeys(Keys.DELETE);
				chapterNameBoxModalWindow.sendKeys(newName);
				updateButtonModalWindow.click();
				break;
			}
		}
		waitABit(3000);
		numberOfChapters = getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr")).size();
		recordsPerPageSelect("All");
		for(int i=1; i<=numberOfChapters; i++){
			if(getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).getText().equals(newName)){
				isPresent = true;
				break;
			}
		}
		Assert.assertTrue(isPresent);
	}
	
	public void recordsPerPageSelect(String records){
		element(recordsPerPageSelectManageHelpContent).waitUntilVisible();
		element(recordsPerPageSelectManageHelpContent).selectByVisibleText(records);
		waitABit(5000);
		int numberOfItems = getDriver().findElements(By.cssSelector("div#content div.right-side > div:nth-child(2) > table > tbody > tr")).size();
		if(records.contains("All")){
			System.out.println("All records are displayed: " + numberOfItems);
		}
		else{
			Assert.assertTrue(numberOfItems <= Integer.parseInt(records));
		}
		
	}
	
	public void navigateToNextIconManageHelpContentPage(){
		nextIconManageHelpContent.click();
	}
	
	public void navigateToPreviousIconManageHelpContentPage(){
		previousIconManageHelpContent.click();
	}
	
	public void searchInputManageHelpContentPage(String search){
		String searchWord = search.toLowerCase();
		boolean check=false;
		element(searchInput).waitUntilVisible();
		searchInput.sendKeys(search);
		searchInput.sendKeys(Keys.ENTER);
		recordsPerPageSelect("All");
		int numberOfEntries = getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr")).size();
		int numberOfColumns;
		int a=0;
		String cellContent = null;
		if(numberOfEntries == 1){
			numberOfColumns = getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(1) >td")).size();
			if(numberOfColumns == 1){
				System.out.println("There are no results");
				numberOfEntries--;
				Assert.assertTrue(getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(1) >td:nth-child(1)")).getText().equals("No matching records found"));
			}
			else{
				for(int j=1; j<=numberOfColumns; j++){
					cellContent = getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(1) >td:nth-child(" + j + ")")).getText().toLowerCase();
					if(cellContent.contains(searchWord)){
						check = true;
					}
				}
				if(check==true){
					a++;
				}
			}
		}
		else{
			for(int i=1; i<=numberOfEntries; i++){
				check=false;
				numberOfColumns = getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child("+ i +") >td")).size();
				for(int j=1; j<=numberOfColumns; j++){
					cellContent = getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child("+ i +") >td:nth-child(" + j + ")")).getText().toLowerCase();
					if(cellContent.contains(searchWord)){
						check = true;
					}
				}
				if(check==true){
					a++;
				}
			}
		}
		System.out.println(a);
		Assert.assertTrue(numberOfEntries==a);
	}
	
	public void clickOnAddNewChapterButton(){
		addNewChapterButtonManageHelpContentButton.click();
	}
	
	public void completeChaptersNameAndClickOnCancel(String newName){
		addNewChapterBoxModalWindow.sendKeys(newName);
		cancelLinkAddNewChapterModalWindow.click();
//		element(By.cssSelector("table#help-content-sortable-table")).waitUntilVisible();
//		int numberOfChapters = getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr")).size();
//		boolean isNotPresent = true;
//		if(numberOfChapters > 1){
//			for(int i=1; i<=numberOfChapters; i++){
//				if(getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).getText().contains(newName)){
//					isNotPresent = false;
//					break;
//				}
//			}
//			Assert.assertTrue(isNotPresent);
//		}
//		else{
//			System.out.println("There is no item in listing");
//		}
	}
	
	public void completeChaptersNameAndClickOnAddButton(String newName){
		recordsPerPageSelect("All");
		int numberOfChapters = getDriver().findElements(By.cssSelector("table#help-content-sortable-table > tbody > tr")).size();
		boolean isPresent = false;
		for(int i=1; i<=numberOfChapters; i++){
			if(getDriver().findElement(By.cssSelector("table#help-content-sortable-table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).getText().equals(newName)){
				System.out.println("There is already a chapter with this name");
				isPresent = true;
				break;
			}
		}
		if(isPresent == true) {
			System.out.println("There is already a chapter with this name.");
			cancelLinkAddNewChapterModalWindow.click();
		}
		else{
			addNewChapterBoxModalWindow.sendKeys(newName);
			addNewChapterButtonModalWindow.click();
		}
	}
	
	public void searchForSubChaptersInputManageHelpContentPage(String search){
		element(searchForSubchaptersInput).waitUntilVisible();
		searchForSubchaptersInput.sendKeys(search);
		searchForSubchaptersInput.sendKeys(Keys.ENTER);
	}
	
	public void clickOnHelpButton(){
		helpButton.click();
		closeButtonHelpWindow.click();
	}
	
	public void selectTypeMenuItem(String menu){
		element(typeContainer).waitUntilVisible();
		//waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select#Type")));
//		typeContainer.click();
//		List<WebElement> itemsList = typeContainer.findElements(By.cssSelector("option"));
//		
//		for(WebElement elementNow:itemsList){
//			System.out.println(elementNow.getText());
//			if(elementNow.getText().contains(splitCamelCase(menu))){
//				elementNow.click();
//				elementNow.sendKeys(Keys.ENTER);
//				break;
//			}
//		}
		selectFromDropdown(typeContainer, menu);
	}	
	
	public void insertANameForPageNewSubChapterClickOnAddButtonAndVerify(String name){
		waitABit(5000);
		pageNameBoxAddNewSubChapterPage.sendKeys(name);
		waitABit(10000);
		addSubChapterButton.click();
		Assert.assertTrue(errorMessageContent.getText().contains("Content cannot be empty."));
	}
	
	public void selectChapterMenuItem(String menu){
		element(chaptersContainer).waitUntilVisible();
		//waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select#Type")));
		chaptersContainer.click();
		List<WebElement> itemsList = chaptersContainer.findElements(By.cssSelector("option"));
		
		for(WebElement elementNow:itemsList){
			System.out.println(elementNow.getText());
			if(elementNow.getText().contains(splitCamelCase(menu))){
				elementNow.click();
				elementNow.sendKeys(Keys.ENTER);
				break;
			}
		}
	}
	
	public void selectStatusMenuItem(String menu){
		element(statusContainer).waitUntilVisible();
		//waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select#Type")));
		statusContainer.click();
		List<WebElement> itemsList = statusContainer.findElements(By.cssSelector("option"));
		
		for(WebElement elementNow:itemsList){
			System.out.println(elementNow.getText());
			if(elementNow.getText().contains(splitCamelCase(menu))){
				elementNow.click();
				elementNow.sendKeys(Keys.ENTER);
				break;
			}
		}
	}
	
	public void completeContentBox(String content){
		contentBoxNewSubChapter.sendKeys(content);
	}
	
	public void clickOnAddNewSubChapterButton(){
		addNewSubChapterButtonHelpPage.click();
		waitABit(3000);
		Assert.assertTrue(typeContainer.isDisplayed());
		Assert.assertTrue(pageNameBoxAddNewSubChapterPage.isDisplayed());
		Assert.assertTrue(contentBoxNewSubChapter.isDisplayed());
		Assert.assertTrue(statusContainer.isDisplayed());
		Assert.assertTrue(addSubChapterButton.isDisplayed());
		Assert.assertTrue(resetFormAddingNewSubchapterLink.isDisplayed());
	}
	
	public void clickOnAddNewSubChapterPage(){
		addSubChapterButton.click();
	}
	
	public void resetFormAddingANewSubChapterAndVerify(){
		resetFormAddingNewSubchapterLink.click();
		Assert.assertTrue(pageNameBoxAddNewSubChapterPage.getText().isEmpty());
	}
	
	public void inserTextInTinymce(String content){
		element(contentIframe).waitUntilVisible();
		((JavascriptExecutor)getDriver()).executeScript("tinyMCE.activeEditor.selection.setContent('"+content+"')");
	}
	
	public void completeFieldsWithValidDataClickOnAddButtonAndVerify(String type, String content, String chapter, String pageName, String status){
//		selectTypeMenuItem(type);
		selectFromDropdown(typeContainer, type);
		element(pageNameBoxAddNewSubChapterPage).waitUntilPresent();
		element(pageNameBoxAddNewSubChapterPage).click();
		element(pageNameBoxAddNewSubChapterPage).clear();
		element(pageNameBoxAddNewSubChapterPage).sendKeys(pageName);
		selectFromDropdown(chaptersContainer, chapter);
//		selectChapterMenuItem(chapter);
//		CreateHelpPage createHelpPage = new CreateHelpPage(getDriver());
		inserTextInTinymce(content);
//		selectStatusMenuItem(status);
		selectFromDropdown(statusContainer, status);
		addSubChapterButton.click();
		waitABit(5000);
		selectFromDropdown(selectRecordsPerPageDropDown, "All");
		waitABit(2000);
		int numberOfItems = getDriver().findElements(By.cssSelector("tbody > tr")).size();
		boolean isPresent = false;
		for(int i=1; i<=numberOfItems;i++){
			if(getDriver().findElement(By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).getText().contains(pageName)){
				isPresent = true;
				break;
			}
		}
		Assert.assertTrue(isPresent);
	}
}

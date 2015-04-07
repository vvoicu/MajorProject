package bmo5.bmo5tests.adm.pages.widgets;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class HotTopicsPage extends AbstractAdmPage{
	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(1)")
	private WebElement widgetNameColumn;
	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(2)")
	private WebElement widgetTitleColumn;
	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(3)")
	private WebElement widgetStartDataColumn;
	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(4)")
	private WebElement widgetStatusColumn;
	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(5)")
	private WebElement widgetLastUpdatedColumn;
	
	@FindBy(css = "div.modal-footer > a:nth-child(1)")
	@CacheLookup
	private WebElement cancelDeletingWidgetPopUpWindowButton;
	
	@FindBy(css = "div.modal-footer > a:nth-child(2)")
	@CacheLookup
	private WebElement deleteWidgetPopUpWindowButton;
	
	@FindBy(css = "form.form-horizontal > div:nth-child(1) > div > input")
	private WebElement newWidgetName;
	
	@FindBy(css = "form.form-horizontal > div:nth-child(2) > div > input")
	private WebElement newWidgetTitle;
	
	@FindBy(css = "form.form-horizontal > div:nth-child(3) > div > textarea")
	private WebElement newWidgetCaption;
	
	@FindBy(css = "input#StartDate")
	private WebElement newWidgetStartDate;
	
	@FindBy(css = "input#EndDate")
	private WebElement newWidgetEndDate;
	
	@FindBy(css = "form.form-horizontal > div:nth-child(6) > div > div > select")
	@CacheLookup
	private WebElement newWidgetStatus;
	
	@FindBy(css = "button#add_hot_topic_form_btn")
	private WebElement newWidgetAddButton;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(7) > button:nth-child(2)")
	private WebElement newWidgetResetButton;
	
	@FindBy(css = "a[class='btn btn-link evil color']")
	private WebElement editWidgetResetButton;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(1) > div > label ") 
	@CacheLookup
	private WebElement newWidgetErrorName;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(2) > div > label ")
	@CacheLookup
	private WebElement newWidgetErrorTitle;
	
	@FindBy(css = "form.form-horizontal > div:nth-child(4) > div > label") 
	@CacheLookup
	private WebElement newWidgetErrorStartDate;
	
	@FindBy(css = "form.form-horizontal > div:nth-child(5) > div > label") 
	@CacheLookup
	private WebElement newWidgetErrorEndDate;
	
	@FindBy(css = "div.btn-toolbar > div > a[class='list btn']")
	@CacheLookup
	private WebElement listViewButton;
	
	@FindBy(css = "div.btn-toolbar > div > a[class='help btn']")
	@CacheLookup
	private WebElement helpButton;
	
	@FindBy(css = "div#breadcrumb > div.shortcut > span:last-child")
	@CacheLookup
	private WebElement lastItemBreadcrumbs;
	
	@FindBy(css = "div#breadcrumb > div.shortcut > span:nth-child(3)")
	@CacheLookup
	private WebElement childBreadcrumb;	
	
	@FindBy(css = "div#breadcrumb > div.shortcut > span:nth-child(2)")
	@CacheLookup
	private WebElement parentBreadcrumb;
	
	@FindBy(css= "div#help > div.modal-footer > button")
	private WebElement cancelButtonHelpWindow;
	
	@FindBy(css = "table#articles_added > tbody > tr:nth-child(N) > td:nth-child(3) > a ")
	@CacheLookup
	private WebElement editWidgetPageRemoveLink;
	
	@FindBy(css = "table#articles_added > tbody > tr:last-child > td > a ")
	@CacheLookup
	private WebElement editWidgetPageAddNewArticlesButton;
	
	@FindBy(css = "div.form-actions > button ")
	@CacheLookup
	private WebElement editWidgetPageSaveButton;
	
	@FindBy(css = "div.form-actions > a")
	@CacheLookup
	private WebElement editWidgetPageResetLink;
	
	@FindBy(css = "div.btn-toolbar > div > a[class='add btn']")
	@CacheLookup
	private WebElement editWidgetPageAddNewHotTopicWidget;
	
	@FindBy(css = "div#DataTables_Table_0_wrapper > div:nth-child(2) > div:nth-child(2) > div > ul > li i[class='icon-angle-right']")
	private WebElement next;
	
	@FindBy(css = "div#DataTables_Table_0_wrapper > div:nth-child(2) > div:nth-child(2) > div > ul > li i[class='icon-angle-left']")
	private WebElement previous;
	
	@FindBy(css = "div.btn-toolbar i[class='icon-help-circle']")
	private WebElement helpButtonMainPage;
	
	@FindBy(css = "div.btn-toolbar i.icon-plus")
	private WebElement newButtonMainPage;
	
	@FindBy(css = "a#btn_add_row")
	private WebElement addNewRowButton;
	
	@FindBy(css = "input#article_id")
	private WebElement newArticleIDBox;
	
	@FindBy(css = "button#update_hot_topic_form_btn")
	private WebElement saveButton;
	
	@FindBy(css = "label[class='help-block error']")
	private WebElement addAnewRowErrorMessage;
	
	@FindBy(css = "div[class='alert alert-success']")
	private WebElement addANewRowConfirmationMessage;
	
	@FindBy(css = "a#btn-cancel-new")
	private WebElement cancelAddingANewRowToTheWidget;
	
	@FindBy(css = "table#articles_added > tbody > tr:first-child > td:nth-child(4) > a")
	private WebElement removeFirstArticleButton;
	
	@FindBy(css = "a.btn.btn-primary")
	private WebElement deleteWindowOKButton;
	
	@FindBy(css = "a.btn.null")
	private WebElement deleteWindowCancelButton;
	
	@FindBy(css = "tr#gkey_new_row > td:nth-of-type(2) > input")
	private WebElement inputBMOHeadline;
	
	@FindBy(css = "label.help-block.error")
	private WebElement errorMessageEmptyHeadline;
	
	public void verifyTableColumns(){
		Assert.assertTrue(widgetNameColumn.getAttribute("aria-sort").contains("ascending"));
		widgetNameColumn.click();
		Assert.assertTrue(widgetNameColumn.getAttribute("aria-sort").contains("descending"));
		widgetTitleColumn.click();
		Assert.assertTrue(widgetTitleColumn.getAttribute("aria-sort").contains("ascending"));
		widgetStartDataColumn.click();
		Assert.assertTrue(widgetStartDataColumn.getAttribute("aria-sort").contains("ascending"));
		widgetStatusColumn.click();
		Assert.assertTrue(widgetStatusColumn.getAttribute("aria-sort").contains("ascending"));
		widgetLastUpdatedColumn.click();
		Assert.assertTrue(widgetLastUpdatedColumn.getAttribute("aria-sort").contains("ascending"));
	}
	
	public void clickOnNameColumn(){
		widgetNameColumn.click();
	}
	
	public void clickOnTitleColumn(){
		widgetTitleColumn.click();
	}
	
	public void clickOnStartDateColumn(){
		widgetStartDataColumn.click();
	}
	
	public void clickOnStatusColumn(){
		widgetStatusColumn.click();
	}
	
	public void clickOnLastUpdatedColumn(){
		widgetLastUpdatedColumn.click();
	}
	
	public void clickOnNewHotTopicWidgetButton(){
		editWidgetPageAddNewHotTopicWidget.click();
	}
	
	public void verifyAddHotTopicPage(){
		Assert.assertTrue(newWidgetName.isDisplayed() && newWidgetName.getText().isEmpty());
		Assert.assertTrue(newWidgetTitle.isDisplayed() && newWidgetTitle.getText().isEmpty());
		Assert.assertTrue(newWidgetStartDate.isDisplayed() && newWidgetStartDate.getText().isEmpty());
		Assert.assertTrue(newWidgetEndDate.isDisplayed() && newWidgetEndDate.getText().isEmpty());
		Assert.assertTrue(newWidgetStatus.isDisplayed());
		Assert.assertTrue(newWidgetAddButton.isDisplayed());
		Assert.assertTrue(newWidgetResetButton.isDisplayed());
		Assert.assertTrue(listViewButton.isDisplayed());
		Assert.assertTrue(helpButton.isDisplayed());
	}
	
	public void clickOnNextIcon(){
		next.click();
	}
	
	public void clickOnPreviousIcon(){
		previous.click();
	}
	
	public void clickOnHelpButton(){
		helpButtonMainPage.click();
	}
	
	public void verifyHelpModalWindowPresence(){
		waitABit(5000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.modal-header > h3")).getText().equalsIgnoreCase("Help"));
	}
	
	public void closeHelpWindow(){
		element(cancelButtonHelpWindow).waitUntilVisible();
		cancelButtonHelpWindow.click();
	}
	
	public void verifyHelpModalWindowAbsence(){
		waitABit(5000);
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div#help > div.modal-footer > button")).size() == 0);
//		Assert.assertFalse(cancelButtonHelpWindow.isDisplayed());
	}
	
	public void clickOnAddNewHotTopicWidget(){
		newButtonMainPage.click();
	}
	
	public void clickOnAddButtonWithoutCompletingAnyField(){
		newWidgetAddButton.click();
		Assert.assertTrue(newWidgetErrorName.getText().contains("Please enter the text for the alert"));
		Assert.assertTrue(newWidgetErrorTitle.getText().contains("Title cannot be empty!"));
		Assert.assertTrue(newWidgetErrorStartDate.getText().contains("Publish date cannot be empty! Please enter a valida data dd/mm/yyyy format!"));
		Assert.assertTrue(newWidgetErrorEndDate.getText().contains("Please enter a valida data dd/mm/yyyy format!"));
	}
	
	public void clickOnAddButtonAfterTheFieldsAreCompletedWithSpaces(){
		newWidgetName.sendKeys("               ");
		newWidgetTitle.sendKeys("                ");
		newWidgetStartDate.sendKeys("                ");
		newWidgetEndDate.sendKeys("                 ");
		newWidgetAddButton.click();
		Assert.assertTrue(newWidgetErrorName.getText().contains("Text can not start/end in blank spaces or contain only blank spaces"));
		Assert.assertTrue(newWidgetErrorTitle.getText().contains("Text can not start/end in blank spaces or contain only blank spaces"));
		Assert.assertTrue(newWidgetErrorStartDate.getText().contains("Publish date cannot be empty! Please enter a valida data dd/mm/yyyy format!"));
		Assert.assertTrue(newWidgetErrorEndDate.getText().contains("Please enter a valida data dd/mm/yyyy format!"));
	}
	
	public void completeStartAndDateWithInvalidDataClickOnAddAndVerify(String name, String title, String caption, String invalidStartDate, String invalidEndDate){
		newWidgetResetButton.click();
		newWidgetName.sendKeys(name);
		newWidgetTitle.sendKeys(title);
		newWidgetStartDate.sendKeys(invalidStartDate);
		newWidgetEndDate.sendKeys(invalidEndDate);
		newWidgetAddButton.click();
		Assert.assertTrue(newWidgetErrorStartDate.getText().contains("Publish date cannot be empty! Please enter a valida data dd/mm/yyyy format!"));
		Assert.assertTrue(newWidgetErrorEndDate.getText().contains("Please enter a valida data dd/mm/yyyy format!"));
	}
	
	public void clickOnResetButton(){
		newWidgetResetButton.click();
		Assert.assertTrue(newWidgetName.getText().isEmpty());
		Assert.assertTrue(newWidgetTitle.getText().isEmpty());
		Assert.assertTrue(newWidgetStartDate.getText().isEmpty());
		Assert.assertTrue(newWidgetEndDate.getText().isEmpty());
	}
	
	public void addANewHotTopicWidgetAndVerify(String name, String title, String caption, String startDate, String endDate){
		//newWidgetResetButton.click();
		newWidgetName.sendKeys(name);
		newWidgetTitle.sendKeys(title);
		newWidgetStartDate.sendKeys(startDate);
		newWidgetEndDate.sendKeys(endDate);
		newWidgetAddButton.click();
		Assert.assertTrue(addNewRowButton.isDisplayed());
		Assert.assertTrue(newWidgetName.getAttribute("value").contains(name));
		Assert.assertTrue(newWidgetTitle.getAttribute("value").contains(title));
		Assert.assertTrue(newWidgetStartDate.getAttribute("value").contains(startDate));
		Assert.assertTrue(newWidgetEndDate.getAttribute("value").contains(endDate));
	}
	
	public void clickOnSaveNewRowButtonWithoutCompletingAnyField(){
		addNewRowButton.click();
		saveButton.click();
		Assert.assertTrue(addAnewRowErrorMessage.getText().contains("This article id is not a number."));
		cancelAddingANewRowToTheWidget.click();
	}
	
	public void completeWithInvalidArticleIDAndClickOnSaveButton(String invalidArticleID, String bmoHeadline){
		addNewRowButton.click();
		newArticleIDBox.sendKeys(invalidArticleID);
		inputBMOHeadline.sendKeys(bmoHeadline);
		saveButton.click();
		Assert.assertTrue(addAnewRowErrorMessage.getText().contains("This article id is not a number."));
		cancelAddingANewRowToTheWidget.click();
	}
	
	public void completeWithInexistingArticleIDAndClickOnSaveButton(String inexistingArticleID, String bmoHeadline){
		addNewRowButton.click();
		newArticleIDBox.sendKeys(inexistingArticleID);
		inputBMOHeadline.sendKeys(bmoHeadline);
		saveButton.click();
		Assert.assertTrue(addAnewRowErrorMessage.getText().contains("This article id doesn't exist in the database. Please input a correct article id."));
		cancelAddingANewRowToTheWidget.click();
	}
	
	public void submitWithBlankBMOHeadline(String articleID){
		addNewRowButton.click();
		newArticleIDBox.sendKeys(articleID);
		saveButton.click();
		Assert.assertTrue(errorMessageEmptyHeadline.getText().contains("Headline cannot be empty"));
		cancelAddingANewRowToTheWidget.click();
	}
	
	public void addANewArticleToTheHotTopicWidget(String articleID, String bmoHeadline){
		int numberOfArticles = getDriver().findElements(By.cssSelector("table#articles_added > tbody > tr ")).size();
		for(int i=1; i<=numberOfArticles; i++){
			if(getDriver().findElement(By.cssSelector("table#articles_added > tbody > tr:nth-child(" + i +") > td:nth-child(1) ")).getText().equals(articleID)){
				System.out.println("Sorry, there is already the article in list.");
			}
			else{
					addNewRowButton.click();
					newArticleIDBox.sendKeys(articleID);
					inputBMOHeadline.sendKeys(bmoHeadline);
					saveButton.click();
					waitABit(2000);
					Assert.assertTrue(addANewRowConfirmationMessage.getText().contains("hot topic successfully updated"));
				}
		}
		
	}
	
	public void cancelAddingANewRowToTheWidget(){
		if(getDriver().findElements(By.cssSelector("a#btn_add_row")).size() > 0){
			addNewRowButton.click();
			cancelAddingANewRowToTheWidget.click();
		}
		else {
			System.out.println("There aren't any items in Hot Topics");
		}
	}
	
	public void removeFirstArticleFromList(){
		int numberOfArticleBefore = getDriver().findElements(By.cssSelector("table#articles_added > tbody > tr:first-child > td:nth-child(4) > a")).size();
		if( numberOfArticleBefore > 0){
			removeFirstArticleButton.click();
			int numberofArticlesAfter = getDriver().findElements(By.cssSelector("table#articles_added > tbody > tr:first-child > td:nth-child(4) > a")).size();
			Assert.assertTrue(numberOfArticleBefore == numberofArticlesAfter + 1);
		}
		else {
			System.out.println("There aren't any items in Hot Topics Top Menu");
		}
	}
	
	public void removeArticle(int articleNumber){
		int numberOfArticlessDisplayed = getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody > tr")).size();
		WebElement article;
		if (numberOfArticlessDisplayed > 0) {
			if (articleNumber <= numberOfArticlessDisplayed && articleNumber > 0) {
				article = element(By.cssSelector("tbody > tr:nth-child("+ articleNumber +")> td:nth-child(4) > a"));
			} else {
				System.out.println("There aren't so many items displayed in Hot Topics Top Menu so remove the first article");
				article = element(By.cssSelector("tbody > tr:nth-child(1)> td:nth-child(4) > a"));
			}
			article.click();
			deleteWindowOKButton.click();
		} else {
			System.out.println("There aren't any items in Hot Topics Top Menu");
		}
	}
	
	public void clickOnListViewButtonAndVerify(){
		if(getDriver().findElements(By.cssSelector("div.btn-toolbar > div > a[class='list btn']")).size() > 0){
			listViewButton.click();
			Assert.assertTrue(widgetNameColumn.isDisplayed());
		}
		else {
			System.out.println("There aren't any items in Hot Topics Top Menu");
		}
	}
	
	public void editHotTopic(String hotTopic){
		int numberOfHotTopicsDisplayed = getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody > tr")).size();
		for(int i=1; i<=numberOfHotTopicsDisplayed ; i++){
			if(getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(" + i + ") > td:nth-child(1) > a")).getText().contains(hotTopic)){
				element(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(" + i + ") > td:nth-child(1) > a")).click();
				break;
			}
		}
//		if (numberOfHotTopicsDisplayed > 0) {
//			if(getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(1) > td")).size() > 1){
//				if (hotTopicNumber <= numberOfHotTopicsDisplayed && hotTopicNumber > 0) {
//					hotTopicsArticle = element(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(" + hotTopicNumber + ") > td:nth-child(1) > a"));
//				} else {
//					System.out.println("There aren't so many items displayed in Hot Topics Top Menu so clicking the first article");
//					hotTopicsArticle = element(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(1) > td:nth-child(1) > a"));
//				}
//				hotTopicsArticle.click();
//			}
//			else {
//				System.out.println("There aren't any items in Hot Topics Top Menu");
//			}
//		} 
	}
	
	public void removeHotTopic(String hotTopic){
		int numberOfHotTopicsDisplayed = getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody > tr")).size();
//		boolean isRemoved = true;
		for(int i=1; i<=numberOfHotTopicsDisplayed ; i++){
			if(getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(" + i + ") > td:nth-child(1) > a")).getText().contains(hotTopic)){
				element(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(" + i + ") > td:nth-child(6) > a")).click();
				deleteWindowOKButton.click();
				break;
			}
		}
//		if (numberOfHotTopicsDisplayed > 0) {
//			for(int i=1; i<=numberOfHotTopicsDisplayed ; i++){
//				if(getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(" + i + ") > td:nth-child(1) > a")).getText().contains(hotTopic)){
//					isRemoved = false;
//					break;
//				}
//			}
//		 }
//		Assert.assertTrue(isRemoved);
		//TODO FIX this
//		ManageWidgetsPage manage = new ManageWidgetsPage(getDriver());
//		manage.selectRecordsPerPageAndVerify("All");
		int numberOfHotTopicsNow = getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody > tr")).size();
		Assert.assertTrue(numberOfHotTopicsNow == numberOfHotTopicsDisplayed - 1);
	}
	
	public String getHotTopicsName(){
		return newWidgetName.getText();
	}
	
	public String getHotTopicsTitle(){
		return newWidgetTitle.getText();
	}
	
	public String getHotTopicsStartDate(){
		return newWidgetStartDate.getText();
	}
	
	public String getHotTopicsEndDate(){
		return newWidgetEndDate.getText();
	}
	
	public void editWidgetResetFields(String newName, String newTitle, String newStartDate, String newEndDate){
		if(getDriver().findElements(By.cssSelector("form.form-horizontal > div:nth-child(1) > div > input")).size() > 0){
			String name, title, startDate, endDate;
			name = getHotTopicsName();
			title = getHotTopicsTitle();
			startDate = getHotTopicsStartDate();
			endDate = getHotTopicsEndDate();
			newWidgetName.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			newWidgetName.sendKeys(Keys.DELETE);
			newWidgetName.sendKeys(newName);
			newWidgetTitle.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			newWidgetTitle.sendKeys(Keys.DELETE);
			newWidgetTitle.sendKeys(newTitle);
			newWidgetStartDate.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			newWidgetStartDate.sendKeys(Keys.DELETE);
			newWidgetStartDate.sendKeys(newStartDate);
			newWidgetEndDate.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			newWidgetEndDate.sendKeys(Keys.DELETE);
			newWidgetEndDate.sendKeys(newEndDate);
			editWidgetResetButton.click();
			Assert.assertTrue(newWidgetName.getText().contains(name));
			Assert.assertTrue(newWidgetTitle.getText().contains(title));
			Assert.assertTrue(newWidgetStartDate.getText().contains(startDate));
			Assert.assertTrue(newWidgetEndDate.getText().contains(endDate));
		}
		else {
			System.out.println("There aren't any items in Hot Topics Top Menu");
	 }
	}
	
	public void editWidgetCompleteFieldsAndSave(String newName, String newTitle, String newStartDate, String newEndDate){
		if(getDriver().findElements(By.cssSelector("form.form-horizontal > div:nth-child(1) > div > input")).size() > 0){
			newWidgetName.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			newWidgetName.sendKeys(Keys.DELETE);
			newWidgetName.sendKeys(newName);
			newWidgetTitle.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			newWidgetTitle.sendKeys(Keys.DELETE);
			newWidgetTitle.sendKeys(newTitle);
			newWidgetStartDate.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			newWidgetStartDate.sendKeys(Keys.DELETE);
			newWidgetStartDate.sendKeys(newStartDate);
			newWidgetEndDate.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			newWidgetEndDate.sendKeys(Keys.DELETE);
			newWidgetEndDate.sendKeys(newEndDate);
			editWidgetPageSaveButton.click();
			Assert.assertTrue(addANewRowConfirmationMessage.getText().contains("hot topic successfully updated"));
			Assert.assertTrue(newWidgetName.getAttribute("value").contains(newName));
			Assert.assertTrue(newWidgetTitle.getAttribute("value").contains(newTitle));
			Assert.assertTrue(newWidgetStartDate.getAttribute("value").contains(newStartDate));
			Assert.assertTrue(newWidgetEndDate.getAttribute("value").contains(newEndDate));
		}
		else {
			System.out.println("There aren't any items in Hot Topics Top Menu");
	 }
	}
	
	public void clearFieldsAndSaveWidget(){
		if(getDriver().findElements(By.cssSelector("form.form-horizontal > div:nth-child(1) > div > input")).size() > 0){
			newWidgetName.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			newWidgetName.sendKeys(Keys.DELETE);
			newWidgetTitle.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			newWidgetTitle.sendKeys(Keys.DELETE);
			//newWidgetCaption.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			//newWidgetCaption.sendKeys(Keys.DELETE);
			newWidgetStartDate.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			newWidgetStartDate.sendKeys(Keys.DELETE);
			newWidgetEndDate.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			newWidgetEndDate.sendKeys(Keys.DELETE);
			saveButton.click();
			Assert.assertTrue(newWidgetErrorName.getText().contains("Please enter the text for the alert"));
			Assert.assertTrue(newWidgetErrorTitle.getText().contains("Title cannot be empty!"));
			Assert.assertTrue(newWidgetErrorStartDate.getText().contains("Publish date cannot be empty! Please enter a valida data dd/mm/yyyy format!"));
			Assert.assertTrue(newWidgetErrorEndDate.getText().contains("Please enter a valid data dd/mm/yyyy format!"));
		}
		else {
			System.out.println("There aren't any items in Hot Topics Top Menu");
	 }
	}
	
	public void clickOnAddNewWidgetFromEditPage(){
		if(getDriver().findElements(By.cssSelector("table#articles_added > tbody > tr:last-child > td > a ")).size() > 0){
			editWidgetPageAddNewArticlesButton.click();
			Assert.assertTrue(newWidgetName.isDisplayed() && newWidgetName.getText().isEmpty());
		}
		else {
			System.out.println("There aren't any items in Hot Topics Top Menu");
	 }
	}
	
	public void clickOnSaveWidgetButtonAndVerify(){
		if(getDriver().findElements(By.cssSelector("button#update_hot_topic_form_btn")).size() > 0){
			saveButton.click();
			Assert.assertTrue(addANewRowConfirmationMessage.getText().contains("hot topic successfully updated"));
		}
		else {
			System.out.println("There aren't any items in Hot Topics Top Menu");
	 }
	}
}

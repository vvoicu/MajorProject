package bmo5.bmo5tests.adm.pages.widgets;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class AnalystsChoicePage  extends AbstractAdmPage{
	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(1)")
	private WebElement idColumnHeader;
	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(2)")
	private WebElement nameColumnHeader;
	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(3)")
	private WebElement titleColumnHeader;
	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(4)")
	private WebElement lastUpdatedColumnHeader;
	
	@FindBy(css = "a.add.btn")
	private WebElement addNewWidgetButton;
	
	@FindBy(css = "a.help.btn")
	private WebElement helpButton;
	
	@FindBy(css = "div.modal-footer > button")
	private WebElement cancelLinkHellpWindow;
	
	@FindBy(css = "input#name")
	private WebElement nameBoxAddNew;
	
	@FindBy(css = "input#title")
	private WebElement titleBoxAddNew;
	
	@FindBy(css = "textarea#caption")
	private WebElement captionBoxAddNew;
	
	@FindBy(css = "select#analysts_choice_content_id")
	private WebElement contentDropDownListAddNew;
	
	@FindBy(css = "i.icon-ok")
	private WebElement addWidgetButton;
	
	@FindBy(css = "button#reset")
	private WebElement resetFormLink;
	
	@FindBy(css = "a.list.btn")
	private WebElement listViewButton;
	
	@FindBy(css = "div#DataTables_Table_0_wrapper > div:nth-child(2)  i.icon-angle-right")
	private WebElement nextIcon;
	
	@FindBy(css = "div#DataTables_Table_0_wrapper > div:nth-child(2)  i.icon-angle-left")
	private WebElement previousIcon;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(1) > div > label")
	private WebElement errorMessageName;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(2) > div > label")
	private WebElement errorMessageTitle;
	
	@FindBy(css = "div.alert.alert-success")
	private WebElement confirmationMessageAddedWidget;
	
	@FindBy(css = "a#btn_add_row")
	private WebElement addNewRowButton;
	
	@FindBy(css = "label[for='item_id']")
	private WebElement errorMessageArticleID;
	
	@FindBy(css = "label[for='video_id']")
	private WebElement errorMessageEmbeddedCodeForVideo;
	
	@FindBy(css = "input#item_id")
	private WebElement articleIDBox;
	
	@FindBy(css = "input#video_id")
	private WebElement embeddedCodeForVideoBox;
	
	@FindBy(css = "button#update_hot_topic_form_btn")
	private WebElement saveButton;
	
	@FindBy(css = "a#btn-cancel-new")
	private WebElement cancelAddingANewArticleLink;
	
	@FindBy(css = "a.btn.btn-primary")
	private WebElement deleteWindowOKButton;
	
	@FindBy(css = "a.btn.null")
	private WebElement deleteWindowCancelButton;
	
	public void clickOnNameColumnFromHeader(){
		nameColumnHeader.click();
	}
	
	public void verifyTableColumns(){
		Assert.assertTrue(idColumnHeader.getAttribute("aria-sort").contains("ascending"));
		idColumnHeader.click();
		Assert.assertTrue(idColumnHeader.getAttribute("aria-sort").contains("descending"));
		nameColumnHeader.click();
		Assert.assertTrue(nameColumnHeader.getAttribute("aria-sort").contains("ascending"));
		titleColumnHeader.click();
		Assert.assertTrue(titleColumnHeader.getAttribute("aria-sort").contains("ascending"));
		lastUpdatedColumnHeader.click();
		Assert.assertTrue(lastUpdatedColumnHeader.getAttribute("aria-sort").contains("ascending"));
	}
	
	public void clickOnIDColumnFromHeader(){
		idColumnHeader.click();
	}
	
	public void clickOnTitleColumnFromHeader(){
		titleColumnHeader.click();
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
	
	public void clickOnHelpButton(){
		helpButton.click();
	}
	
	public void clickOnAddNewWindgetButtonListingPage(){
		addNewWidgetButton.click();
	}
	
	public void submitWithoutCompletingAnyField(){
		addWidgetButton.click();
		Assert.assertTrue(errorMessageName.getText().contains("Name cannot be empty."));
		Assert.assertTrue(errorMessageTitle.getText().contains("Title cannot be empty."));
	}
	
	public void completeAllFieldsWithSpacesSubmitAndVerify(){
		nameBoxAddNew.sendKeys("                    ");
		titleBoxAddNew.sendKeys("                    ");
		captionBoxAddNew.sendKeys("                    ");
		addWidgetButton.click();		
		Assert.assertTrue(errorMessageName.getText().contains("Text cannot have blank spaces."));
		Assert.assertTrue(errorMessageTitle.getText().contains("Text cannot have blank spaces."));
	}
	
	public void selectContentType(String content){
	//	selectFromDropdown(contentDropDownListAddNew, content);
		Select contentTypeDropDown=new Select(contentDropDownListAddNew);
		contentTypeDropDown.selectByVisibleText(content);
	}
	
	public void completeFieldsWithValidDataClickOnResetLinkAndVerify(String name, String title, String caption, String item){
		nameBoxAddNew.sendKeys(name);
		titleBoxAddNew.sendKeys(title);
		captionBoxAddNew.sendKeys(caption);
		selectFromDropdown(contentDropDownListAddNew, item);
//		MenuNavigationPage page = new MenuNavigationPage(getDriver());
//		page.selectAnalystChoiseContent(item);
//		selectContentType(content);
		Sleeper.sleepTight(2000);
		resetFormLink.click();
		Assert.assertTrue(nameBoxAddNew.getText().isEmpty());
		Assert.assertTrue(titleBoxAddNew.getText().isEmpty());
		Assert.assertTrue(captionBoxAddNew.getText().isEmpty());
	}
	
	public void completeFieldsWithValidDataSubmitAndVerify(String name, String title, String caption, String item){
		nameBoxAddNew.sendKeys(name);
		titleBoxAddNew.sendKeys(title);
		captionBoxAddNew.sendKeys(caption);
//		contentDropDownListAddNew.click();
//		element(contentDropDownListAddNew).waitUntilVisible();
//		MenuNavigationPage page = new MenuNavigationPage(getDriver());
//		page.selectAnalystChoiseContent(item);
		selectFromDropdown(contentDropDownListAddNew, item);
//		selectContentType(content);
		Sleeper.sleepTight(2000);
		addWidgetButton.click();
		Assert.assertTrue(confirmationMessageAddedWidget.getText().contains("Successfully added Analyst Defined Widget"));
	}
	
	//TODO fix this
//	public void completeFieldsWithValidData(String name, String title, String caption, String contentType){
//		nameBoxAddNew.sendKeys(name+Integer.toString(StringUtils.randomNumber(10000)));
//		titleBoxAddNew.sendKeys(title+Integer.toString(StringUtils.randomNumber(10000)));
//		captionBoxAddNew.sendKeys(caption);
//		contentDropDownListAddNew.click();
//		element(contentDropDownListAddNew).waitUntilVisible();
//		MenuNavigationPage page = new MenuNavigationPage(getDriver());
//		page.selectAnalystChoiseContent(contentType);
//		Sleeper.sleepTight(2000);
//		addWidgetButton.click();
//		Assert.assertTrue(confirmationMessageAddedWidget.getText().contains("Successfully added Analyst Defined Widget"));
//	}
	
	public void createAnalystChoice(String name, String title, String caption, String content){
		nameBoxAddNew.sendKeys(name+Integer.toString(StringUtils.randomNumber(10000)));
		titleBoxAddNew.sendKeys(title+Integer.toString(StringUtils.randomNumber(10000)));
		captionBoxAddNew.sendKeys(caption);
		selectContentType(content);
		Sleeper.sleepTight(2000);
		addWidgetButton.click();
		Assert.assertTrue(confirmationMessageAddedWidget.getText().contains("Successfully added Analyst Defined Widget"));
	}
	
	public void clickOnAddNewRowButton(){
		if(getDriver().findElements(By.cssSelector("a#btn_add_row")).size() == 1){
			addNewRowButton.click();
			Assert.assertTrue(articleIDBox.isDisplayed());
			Assert.assertTrue(cancelAddingANewArticleLink.isDisplayed());
		}
	}
	
	public void clickOnAddNewRowVideoButton(){
		addNewRowButton.click();
		waitABit(4000);
		Assert.assertTrue(embeddedCodeForVideoBox.isDisplayed());
		Assert.assertTrue(cancelAddingANewArticleLink.isDisplayed());
	}
	
	public void clickOnSaveButtonWithoutCompleteTheArticleISBox(){
		if(getDriver().findElements(By.cssSelector("button#update_hot_topic_form_btn")).size() == 1){
			saveButton.click();
			Assert.assertTrue(errorMessageArticleID.getText().contains("This id must be a positive number."));
		}
	}
	
	public void clickOnSaveButtonWithoutCompleteTheEmbeddedCodeForVideo(){
		saveButton.click();
		Assert.assertTrue(addNewRowButton.isDisplayed());
	}
	
	public void completeArticleIdWithInvalidDataClickOnSaveButtonAndVerify(String invalidArticleID){
		if(getDriver().findElements(By.cssSelector("input#item_id")).size() == 1){
			articleIDBox.sendKeys(invalidArticleID);
			saveButton.click();
			Assert.assertTrue(errorMessageArticleID.getText().contains("This id must be a positive number."));
		}
	}
	
	public void completeEmbeddedCodeForVideoIdWithInvalidDataClickOnSaveButtonAndVerify(String embeddedCode){
		embeddedCodeForVideoBox.sendKeys(embeddedCode);
		saveButton.click();
		Assert.assertTrue(errorMessageEmbeddedCodeForVideo.getText().contains("This embedded code is not valid"));
	}
	
	public void completeArticleIDWitInexistingValueClickOnSaveButtonAndVerify(String inexistingArticleID){
		if(getDriver().findElements(By.cssSelector("input#item_id")).size() == 1){
			articleIDBox.sendKeys(inexistingArticleID);
			saveButton.click();
			Assert.assertTrue(errorMessageArticleID.getText().contains("This article id doesn't exist in the database. Please input a correct article id."));
		}
	}
	
	public void completeArticleIDWithValidDataSaveAndVerify(String articleID){
		if(getDriver().findElements(By.cssSelector("input#item_id")).size() == 1){
			articleIDBox.sendKeys(articleID);
			saveButton.click();
			int numberOfItemsInListing = getDriver().findElements(By.cssSelector("tbody > tr")).size() - 2;
			boolean isSaved = false;
			if(getDriver().findElement(By.cssSelector("tbody > tr:nth-child(" + numberOfItemsInListing + ") > td:nth-child(1)")).getText().contains(articleID)) {
				isSaved = true;
			}
			Assert.assertTrue(isSaved);
		}
	}
	
	public void completeEmbeddedCodeForVideoWithValidDataClcikOnSaveAndVerify(String embeddedCode){
		embeddedCodeForVideoBox.click();
		embeddedCodeForVideoBox.sendKeys(embeddedCode);
		saveButton.click();
		Assert.assertTrue(confirmationMessageAddedWidget.getText().contains("Successfully updated"));
	}
	
	public void removeArticle(int itemNumber){
		int numberOfItems = getDriver().findElements(By.cssSelector("table#articles_added tbody > tr")).size();
		if(numberOfItems > 0){
			if(itemNumber > 0 && itemNumber < numberOfItems){
				getDriver().findElement(By.cssSelector("tbody > tr:nth-child("+ itemNumber +")> td:nth-child(3) > a")).click();
			}
		}
		waitABit(5000);
		int numberOfItemsNow = getDriver().findElements(By.cssSelector("table#articles_added tbody > tr")).size();
		Assert.assertTrue(numberOfItemsNow == numberOfItems - 1);
	}
	
	public void clickOnListViewButton(){
		if(getDriver().findElements(By.cssSelector("a.list.btn")).size() == 1){
			listViewButton.click();
			
			Assert.assertTrue(nameColumnHeader.isDisplayed());
		}
	}
	
	public void clickOnOneItemFromListing(String itemName){
		int numberOfItems = getDriver().findElements(By.cssSelector("tbody > tr")).size();
		for(int i=1; i<=numberOfItems; i++){
			if(getDriver().findElement(By.cssSelector("tbody > tr:nth-child("+ i +")> td:nth-child(2) > a")).getText().equals(itemName)){
				getDriver().findElement(By.cssSelector("tbody > tr:nth-child("+ i +")> td:nth-child(2) > a")).click();
				break;
			}
		}
	}
	
	public void deleteOneItemFromListing(String itemName){
		int numberOfItems = getDriver().findElements(By.cssSelector("tbody > tr")).size();
		for(int i=1;i<=numberOfItems;i++){
			if(getDriver().findElement(By.cssSelector("tbody > tr:nth-child(" + i + " ) > td:nth-child(2) > a")).getText().equals(itemName)){
				getDriver().findElement(By.cssSelector("tbody > tr:nth-child("+ i +") > td:nth-child(5) > a")).click();
				deleteWindowOKButton.click();
				break;
			}
		}
		//TODO Fix this
//		ManageWidgetsPage manage = new ManageWidgetsPage(getDriver());
//		manage.selectRecordsPerPageAndVerify("All");
		int numberOfItemsNow = getDriver().findElements(By.cssSelector("tbody > tr")).size();
		Assert.assertTrue(numberOfItemsNow == numberOfItems - 1);
	}
	
	public void editTitle(String newTitle){
		if(getDriver().findElements(By.cssSelector("input#title")).size() == 1){
			titleBoxAddNew.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			titleBoxAddNew.sendKeys(Keys.DELETE);
			Sleeper.sleepTight(2000);
			titleBoxAddNew.sendKeys(newTitle);
			saveButton.click();
			Sleeper.sleepTight(2000);
			Assert.assertTrue(confirmationMessageAddedWidget.getText().contains("Successfully updated"));
			//Assert.assertTrue(titleBoxAddNew.getText().contains(newTitle));
		}
	}
	
	public void editWidgetEmptyFieldsSaveAndVerify(){
		if(getDriver().findElements(By.cssSelector("input#name")).size() == 1){
			nameBoxAddNew.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			nameBoxAddNew.sendKeys(Keys.DELETE);
			titleBoxAddNew.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			titleBoxAddNew.sendKeys(Keys.DELETE);
			saveButton.click();		
			Assert.assertTrue(errorMessageName.getText().contains("Name cannot be empty."));
			Assert.assertTrue(errorMessageTitle.getText().contains("Title cannot be empty."));
		}
	}
	
	public String getSavedName(){
		return nameBoxAddNew.getAttribute("value");
	}
	
	public String getSavedTitle() {
		return titleBoxAddNew.getAttribute("value");
	}
	
	
}

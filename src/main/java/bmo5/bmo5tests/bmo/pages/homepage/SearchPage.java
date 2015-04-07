package bmo5.bmo5tests.bmo.pages.homepage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class SearchPage extends AbstractPage{
	
	@FindBy(css = "ul.breadcrumb > li:last-child")
	private WebElement breadcrumbLast;
	
	@FindBy(css = "ul[class='nav nav-list dropdown-list no-max-height show']  > li > div:nth-child(1) > div > div > input")
	private WebElement allOfTheseWordsBox;
	
	@FindBy(css = "div#toggle-words > a[href='#more']")
	private WebElement showMoreLinkRefineBySection;
	
	@FindBy(css = "ul[class='nav nav-list dropdown-list no-max-height show'] > li > div:nth-child(2) > div > div > input")
	private WebElement theExactPhraseBox;
	
	@FindBy(css = "ul[class='nav nav-list dropdown-list no-max-height show'] > li > div:nth-child(3) > div > div > input")
	private WebElement anyOfTheseWordsBox;
	
	@FindBy(css = "ul[class='nav nav-list dropdown-list no-max-height show'] > li > div:nth-child(4) > div > div > input")
	private WebElement noneOfTheseWords;
	
	@FindBy(css = "div#toggle-words > a:nth-child(2)")
	private WebElement showLessLinkRefineBySection;
	
	@FindBy(css = "ul.type-search > li:nth-child(1) > label")
	private WebElement allContentButton;
	
	@FindBy(css = "ul.type-search > li:nth-child(2) > label)")
	private WebElement inTitleOnlyButton;
	
	@FindBy(css = "ul.type-search > li:nth-child(3) > label")
	private WebElement inFirstParagraphButton;
	
	@FindBy(css = "form#search_refine_form > ul:nth-child(2) > li > ul > li:nth-child(1) > label")
	private WebElement anytimeRadioButton;
	
	@FindBy(css = "form#search_refine_form > ul:nth-child(2) > li > ul > li:nth-child(2) > label")
	private WebElement withinLastWeekRadioButton;
	
	@FindBy(css = "form#search_refine_form > ul:nth-child(2) > li > ul > li:nth-child(3) > label")
	private WebElement withinLastMonthRadionButton;
	
	@FindBy(css = "form#search_refine_form > ul:nth-child(2) > li > ul > li:nth-child(4) > label")
	private WebElement withinLast3MonthsRadioButton;
	
	@FindBy(css = "form#search_refine_form > ul:nth-child(2) > li > ul > li:nth-child(5) > label ")
	private WebElement withinLast6MonthsRadioButton;
	
	@FindBy(css = "ul#publication-date > li.row-fluid input#new_form_start_date")
	private WebElement startDateBox;
	
	@FindBy(css = "ul#publication-date > li.row-fluid input#new_form_end_date")
	private WebElement endDateBox;
	
	@FindBy(css = "form#search_refine_form > ul:nth-child(3) > li > ul > li:nth-child(1) > label")
	private WebElement newsAndAnalysisCheckBox;
	
	@FindBy(css = "form#search_refine_form > ul:nth-child(3) > li > ul > li:nth-child(2) > label")
	private WebElement reportsCheckBox;

	@FindBy(css = " div.container-fluid > h3")
	private WebElement resultsTitle;
	
	@FindBy(css = "article#results > div:nth-of-type(2) > button:nth-child(1)")
	private WebElement selectAllLink;
	
	@FindBy(css = "article#results > div:nth-of-type(2) > button:nth-child(2)")
	private WebElement clearAllLink;
	
	@FindBy(css = "span.pull-right.btn-small-style > span > div:nth-of-type(1) > button")
	private WebElement sortByDefaultPublicationDateAndRelevanceToggler;
	
	@FindBy(css = "span.pull-right.btn-small-style > span > div:nth-of-type(1) > ul > li:nth-child(1) span")
	private WebElement publicationDateAndRelevanceFromDropDownList;
	
	@FindBy(css = "span.pull-right.btn-small-style > span > div:nth-of-type(1) > ul > li:nth-child(2) span")
	private WebElement publicationDateFromDropDownList;
	
	@FindBy(css = "span.pull-right.btn-small-style > span > div:nth-of-type(1) > ul > li:nth-child(3) span")
	private WebElement relevanceFromDropDownList;
	
	@FindBy(css = "span.pull-right.btn-small-style > span > div:nth-of-type(1) > button > div:nth-of-type(1)")
	private WebElement sortByOptionPublicationDateOrRelevance;
	
	@FindBy(css = "span.pull-right.btn-small-style > span > div:nth-of-type(2) > button")
	private WebElement sortByDescendingToggler;
	
	@FindBy(css = "span.pull-right.btn-small-style > span > div:nth-of-type(2) > ul > li:nth-child(1) span")
	private WebElement ascendingFromDropDownList;
	
	@FindBy(css = "span.pull-right.btn-small-style > span > div:nth-of-type(2) > ul > li:nth-child(2) span")
	private WebElement descendingFromDropDownList;
	
	@FindBy(css = "span.pull-right.btn-small-style > span > div:nth-of-type(2) > button > div:nth-of-type(1) ")
	private WebElement sortByOptionAscendingOrDescending;
	
	@FindBy(css = "span.pull-right.btn-small-style > button")
	private WebElement saveThisSearchButton;
	
	@FindBy(css = "span.pull-right.btn-small-style i.icon-c-floppy")
	private WebElement saveThisSearchButtonEnterpriseUser;
	
	@FindBy(css = "div#search-save-modal input#title")
	private WebElement searchTitleBox;
	
	@FindBy(css = "div#search-save-modal label.error ")
	private WebElement errorMessageSavingModalWindow;
	
	@FindBy(css = "div#result > div.alert.alert-success")
	private WebElement confirmationMessage;
	
	@FindBy(css = "div#search-save-modal button.btn.btn-link")
	private WebElement cancelSavingLink;
	
	@FindBy(css = "div#search-save-modal button#save")
	@CacheLookup
	private WebElement saveButtonFromModalWindow;
	
	@FindBy(css = "ul#publication-date li.row-fluid div:nth-child(1) label.error ")
	private WebElement errorMessageStartDate;
	
	@FindBy(css = "ul#publication-date li.row-fluid div:nth-child(2) label.error ")
	private WebElement errorMessageEndDate;
	
	@FindBy(css = "ul#publication-date li.row-fluid div:nth-child(2) label.error > p")
	private WebElement errorMessageStartDateGreaterThanEndDate;
	
	@FindBy(css = "div#clipboard a")
	private WebElement clipboard;
	
	@FindBy(css = "div#basket_items h3")
	private WebElement manageClipboardTitle;
	
	@FindBy(css = "div#basket_items button[href='#empty_basket']")
	private WebElement emptyBasketLinkClipboardWindow;
	
	@FindBy(css = "div#basket_items button[href='#clearall']")
	private WebElement clearAllLinkClipboadWindow;
	
	@FindBy(css = "div#basket_items button[href='#selectall']")
	private WebElement selectAllLinkClipboadWindow;
	
	@FindBy(css = "div#basket_items button[href='#print']")
	private WebElement printAllLinkClipboadWindow;
	
	@FindBy(css = "div#basket_items button#download_all")
	private WebElement downloadAllLinkClipboadWindow;
	
	@FindBy(css = "div#basket_items div.modal-footer > button:nth-of-type(2)")
	private WebElement addToSavedContentButtonClipboardWindow;
	
	@FindBy(css = "div#basket_items div.modal-footer > button:nth-of-type(1)")
	private WebElement updateButtonClipboardWindow;
	
	@FindBy(css = "div#basket_items > div:nth-child(3) > button:nth-child(2)")
	private WebElement cancelLinkClipboardWindow;
	
	@FindBy(css = "div#basket_items h3")
	private WebElement headerOfPrintPreviewWindow;
	
	@FindBy(css = "button > i.icon-white.icon-c-print.margin-right-10")
	private WebElement printButtonPrintModalWindow;
	
	@FindBy(css = "div#permission-enterprise-user strong")
	private WebElement alertMessageEnterprise;
	
	@FindBy(css = "div#permission-enterprise-user > div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowEnterprise;
	
	@FindBy(css = "div#permission-modal-print strong")
	private WebElement alertMessagePrint;
	
	@FindBy(css = "div#permission-modal-print div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialPrint;
	
	@FindBy(css = "div#permission-modal-print div:nth-child(2) > a")
	private WebElement contactAccountManagementButtonTrialPrint;
	
	@FindBy(css = "div#permission-modal-pdf strong")
	private WebElement alertMessageDownload;
	
	@FindBy(css = "div#permission-modal-pdf div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialDownload;
	
	@FindBy(css = "div#permission-modal-pdf div:nth-child(2) > a")
	private WebElement contactAccountManagementButtonTrialDownload;

	@FindBy(css = "div#permission-enterprise-user1 strong")
	private WebElement addToSavedContentAlertMessageEnterpriseUser;
	
	@FindBy(css = "div#permission-enterprise-user1 > div:nth-child(2) > button")
	private WebElement addToSavedContentCancelButtonEnterpriseUser;
	
	@FindBy(css = "div#permission-modal")
	private WebElement alertMessageNoEntitlements;
	
	@FindBy(css = " div#permission-modal > div.modal-footer button")
	private WebElement cancelButtonAlertMessageNoEntitlements;
	
	@FindBy(css = " div#permission-modal > div.modal-footer a")
	private WebElement contactAccountManagerButtonAlertMessageNoEntitlements;
	
	@FindBy(css = "div#basket_items > div.modal-header > button")
	private WebElement closeButtonManageClipboard;
	
	@FindBy(css = "section i.icon-c-cancel")
	@CacheLookup WebElement printPagePreviewCancel;
	
	public void verifyIfElementsArePresentPerPage(){
		Assert.assertTrue(allOfTheseWordsBox.isEnabled());
		Assert.assertTrue(showMoreLinkRefineBySection.isEnabled());
		Assert.assertTrue(verifyElementState("document.getElementById('new_form_content')"));
		Assert.assertTrue(verifyElementState("document.getElementById('new_form_publication_date_1')"));
		Assert.assertTrue(verifyElementState("document.getElementById('new_form_news_and_analysis')"));
		Assert.assertTrue(verifyElementState("document.getElementById('new_form_reports')"));
		Assert.assertTrue(sortByDefaultPublicationDateAndRelevanceToggler.isDisplayed());
		Assert.assertTrue(sortByDescendingToggler.isDisplayed());
	}
	
	public void clickOnInFirstParagraphButton(){
		inFirstParagraphButton.click();
		Assert.assertTrue(verifyElementState("document.getElementById('new_form_content_paragraph')"));
	}
	
	public void clickOnInTitleOnlyButton(){
		element(inTitleOnlyButton).waitUntilVisible();
		inTitleOnlyButton.click();
		Assert.assertTrue(verifyElementState("document.getElementById('new_form_content_title')"));
	}
	
	public void clickOnWithinLastSixMonthsButton(){
		withinLast6MonthsRadioButton.click();
		Assert.assertTrue(verifyElementState("document.getElementById('new_form_publication_date_5')"));
	}
	
	public void enterInvalidDataToPublicationDateAndVerify(String startDate, String endDate){
		startDateBox.sendKeys(startDate);
		endDateBox.sendKeys(endDate);
		startDateBox.click();
		Assert.assertTrue(errorMessageStartDate.getText().contains("Invalid date"));
		Assert.assertTrue(errorMessageEndDate.getText().contains("Invalid date"));
	}
	
	public void enterStartDateGreaterThanEndDateToPublicationDateAndVerify(String startDate, String endDate){
		startDateBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		startDateBox.sendKeys(Keys.DELETE);
		startDateBox.sendKeys(startDate);
		endDateBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		endDateBox.sendKeys(Keys.DELETE);
		endDateBox.sendKeys(endDate);
		Assert.assertTrue(errorMessageStartDateGreaterThanEndDate.getText().contains("End date should be greater"));
	}
	
	public void enterValidDataToPublicationDateAndVerify(String startDate, String endDate){
		startDateBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		startDateBox.sendKeys(Keys.DELETE);
		startDateBox.sendKeys(startDate);
		startDateBox.sendKeys(Keys.ENTER);
		endDateBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		endDateBox.sendKeys(Keys.DELETE);
		endDateBox.sendKeys(endDate);
		endDateBox.sendKeys(Keys.ENTER);
	}
	
	public void untickNewsAndAnalysisAndReportsCheckBoxesAndVerify(){
		newsAndAnalysisCheckBox.click();
		Sleeper.sleepTight(2000);
		Assert.assertFalse(verifyElementState("document.getElementById('new_form_news_and_analysis')"));
		Assert.assertTrue(verifyElementState("document.getElementById('new_form_reports')"));
		reportsCheckBox.click();
		Sleeper.sleepTight(2000);
		Assert.assertTrue(verifyElementState("document.getElementById('new_form_news_and_analysis')"));
		Assert.assertTrue(verifyElementState("document.getElementById('new_form_reports')"));
		reportsCheckBox.click();
		Sleeper.sleepTight(2000);
		Assert.assertTrue(verifyElementState("document.getElementById('new_form_news_and_analysis')"));
		Assert.assertFalse(verifyElementState("document.getElementById('new_form_reports')"));
	}
	
	public void clickOnOneItemFromGeographySection(int geographyNumber){
		if(getDriver().findElements(By.cssSelector("form#search_refine_form > ul:nth-child(5) > li > ul > li:nth-child(2) > ul > li > input#geography_" + geographyNumber)).size() == 1){
			getDriver().findElement(By.cssSelector("form#search_refine_form > ul:nth-child(5) > li > ul > li:nth-child(2) > ul > li > label[for='geography_" + geographyNumber + "']")).click();
		} else {
			System.out.println("This geography does not exist.");
		}
	}
	
	public void verifyIfTheItemFromGeographySectionIsChecked(int geographyNumber){
		if(getDriver().findElements(By.cssSelector("form#search_refine_form > ul:nth-child(5) > li > ul > li:nth-child(2) > ul > li > label[for='geography_" + geographyNumber + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('geography_" + geographyNumber + "')"));
		} else {
			System.out.println("This geography does not exist.");
		}
	}
	
	public void clickOnOneItemFromChannelsSection(int channelNumber){
		if(getDriver().findElements(By.cssSelector("form#search_refine_form > ul:nth-child(6) > li > ul > li:nth-child(2) > ul > li > label[for='channel_" + channelNumber + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("form#search_refine_form > ul:nth-child(6) > li > ul > li:nth-child(2) > ul > li > label[for='channel_" + channelNumber + "']")).click();
		} else {
			System.out.println("This channel does not exist.");
		}
	}
	
	public void verifyIfTheItemFromChannelsSectionIsChecked(int channelNumber){
		if(getDriver().findElements(By.cssSelector("form#search_refine_form > ul:nth-child(6) > li > ul > li:nth-child(2) > ul > li > label[for='channel_" + channelNumber + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('channel_" + channelNumber + "')"));
		} else {
			System.out.println("This channel does not exist.");
		}
	}
	
	public void clickOnOneItemFromCategoriesSection(int categoryNumber){
		if(getDriver().findElements(By.cssSelector("form#search_refine_form > ul:nth-child(7) > li > ul > li:nth-child(2) > ul > li > label[for='category_" + categoryNumber + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("form#search_refine_form > ul:nth-child(7) > li > ul > li:nth-child(2) > ul > li > label[for='category_" + categoryNumber + "']")).click();
		} else {
			System.out.println("This category does not exist.");
		}
	}
	
	public void verifyIfTheItemFromCategoriesSectionIsChecked(int categoryNumber){
		if(getDriver().findElements(By.cssSelector("form#search_refine_form > ul:nth-child(7) > li > ul > li:nth-child(2) > ul > li > label[for='category_" + categoryNumber + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('category_" + categoryNumber + "')"));
		} else {
			System.out.println("This category does not exist.");
		}
	}
	
	public void clickOnOneItemFromCompaniesSection(int companyNumber){
		if(getDriver().findElements(By.cssSelector("form#search_refine_form > ul:nth-child(8) > li > ul > li:nth-child(2) > ul > li > label[for='company_" + companyNumber + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("form#search_refine_form > ul:nth-child(8) > li > ul > li:nth-child(2) > ul > li > label[for='company_" + companyNumber + "']")).click();
		} else {
			System.out.println("This company does not exist.");
		}
	}
	
	public void verifyIfTheItemFromCompaniesSectionIsChecked(int companyNumber){
		if(getDriver().findElements(By.cssSelector("form#search_refine_form > ul:nth-child(8) > li > ul > li:nth-child(2) > ul > li > label[for='company_" + companyNumber + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('company_" + companyNumber + "')"));

		} else {
			System.out.println("This company does not exist.");
		}
	}
	
	public void sortByPublicationDateAndRelevanceAscendingOrder(){
		sortByDefaultPublicationDateAndRelevanceToggler.click();
		publicationDateAndRelevanceFromDropDownList.click();
		sortByDescendingToggler.click();
		ascendingFromDropDownList.click();
	}
	
	public void verifySortByPublicationDateAndRelevanceAscendingOrder(){
		Assert.assertTrue(sortByOptionPublicationDateOrRelevance.getText().contains("Publication Date and Relevance"));
		Assert.assertTrue(sortByOptionAscendingOrDescending.getText().contains("Ascending"));
	}
	
	public void sortByPublicationDateAscendingOrder(){
		sortByDefaultPublicationDateAndRelevanceToggler.click();
		publicationDateFromDropDownList.click();
		sortByDescendingToggler.click();
		ascendingFromDropDownList.click();
	}
	
	public void verifySortByPublicationDateAscendingOrder(){
		Assert.assertTrue(sortByOptionPublicationDateOrRelevance.getText().contains("Publication Date"));
		Assert.assertTrue(sortByOptionAscendingOrDescending.getText().contains("Ascending"));
	}
	
	public void sortByPublicationDateDescendingOrder(){
		sortByDefaultPublicationDateAndRelevanceToggler.click();
		publicationDateFromDropDownList.click();
		sortByDescendingToggler.click();
		descendingFromDropDownList.click();
	}
	
	public void verifySortByPublicationDateDescendingOrder(){
		Assert.assertTrue(sortByOptionPublicationDateOrRelevance.getText().contains("Publication Date"));
		Assert.assertTrue(sortByOptionAscendingOrDescending.getText().contains("Descending"));
	}
	
	public void sortByRelevace(){
		sortByDefaultPublicationDateAndRelevanceToggler.click();
		relevanceFromDropDownList.click();
	}
	
	public void verifySortByRelevace(){
		Assert.assertTrue(sortByOptionPublicationDateOrRelevance.getText().contains("Relevance"));
	}
	
	public void clickOnShowMoreAndCompleteAnyOfTheseWordsBox(String word){
		waitUntilElementExists(By.cssSelector("div.media-listing > div"), 30);
		showMoreLinkRefineBySection.click();
		Assert.assertTrue(showLessLinkRefineBySection.isEnabled());
		anyOfTheseWordsBox.click();
		anyOfTheseWordsBox.sendKeys(word);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		waitUntilElementDoesntExist(By.className("article.span12.loading"), 30);
		Assert.assertTrue(showMoreLinkRefineBySection.isDisplayed());
	}
	
	public void verifyRefineBySection(String word){
		waitUntilElementExists(By.cssSelector("div.media-listing > div"), 30);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form[class='form-vertical no-margin'] > ul:nth-child(1) > li:nth-child(2) > ul > li > div#controls  input")).getAttribute("value").contains(word));
	}
	
	public String clickOnSaveSearchButton(String saveTitle){
		saveThisSearchButton.click();
		searchTitleBox.click();
		int ran;
		ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		saveTitle = saveTitle + ran;
		searchTitleBox.sendKeys(saveTitle);
		saveButtonFromModalWindow.click();
		waitABit(2000);
		if(getDriver().findElements(By.cssSelector("div#result > div.alert.alert-success")).size() == 0){
			Assert.assertTrue(errorMessageSavingModalWindow.getText().contains("A search was already saved with the title " + saveTitle));
			cancelSavingLink.click();                                           
		}
		else{
			Assert.assertTrue(confirmationMessage.getText().contains("Your search was successfully saved"));
		}
		return saveTitle;
	}
	
	public void clickOnSaveSearchButtonEnterpriseUser(){
		saveThisSearchButtonEnterpriseUser.click();
		Assert.assertTrue(alertMessageEnterprise.isDisplayed());
		cancelButtonModalWindowEnterprise.click();
	}
	
	public void verifyShowMoreAndShowLessLinksFromRefineBySection(){
		showMoreLinkRefineBySection.click();
		Assert.assertTrue(allOfTheseWordsBox.isDisplayed());
		Assert.assertTrue(theExactPhraseBox.isDisplayed());
		Assert.assertTrue(anyOfTheseWordsBox.isDisplayed());
		Assert.assertTrue(noneOfTheseWords.isDisplayed());
		Assert.assertTrue(showLessLinkRefineBySection.isDisplayed());
		showLessLinkRefineBySection.click();
		Assert.assertTrue(showMoreLinkRefineBySection.isDisplayed());
	}
	
	public void checkArticlesFromListing(int numbeOfArticlesToBeChecked){
		for(int i=1;i<=numbeOfArticlesToBeChecked; i++){
			getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + i + ") label ")).click();
		}
//		for(int i=1;i<=5;i++){
//			
//			Assert.assertTrue(getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + i +") div.checker span")).getAttribute("class").contains("checked"));
//		}
	}
	
	public void checkAllItemsDisplayedOnPage(){
		selectAllLink.click();
		Assert.assertTrue(verifyElementState("document.getElementById('check-box')"));
	}
	
	public void checkAdditionalItemAndVerify(){
		//boolean isNotChecked;
		//int additional = 0;
		for(int i=1;i<=15;i++){
			if(getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + i +") div.checker span")).getAttribute("class").contains("checked")){
				continue;
			}
			else{
				getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + i + ") input ")).click();
			//	additional = i;
				break;
			}
		}
		/*Sleeper.sleepTight(5000);
		String script = "src\\test\\java\\drivers\\pressOkToAlert.exe";
		Process p;
		try {
			p = Runtime.getRuntime().exec(script);
			p.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		Sleeper.sleepTight(5000);
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			waitABit(2000);
			} 
		catch (Exception e) {
							System.out.println(e);
							}
		System.out.println(additional);*/
		/*if(getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + additional +") div.checker > span")).getAttribute("class").isEmpty()){
			isNotChecked = false;
			System.out.println("true");
		}
		else{
			isNotChecked = true;
			System.out.println("false");
		}
		Assert.assertTrue(isNotChecked);*/
		//System.out.println(getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + additional +") div.checker span")).getAttribute("class").contains("checked"));
		//Assert.assertFalse((getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + additional +") div.checker span")).getAttribute("class").contains("checked")));
		//Assert.assertTrue(getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + additional +") div.checker span")).getText().isEmpty());
	}
	
	public void verifyTheNumberOfArticlesFromManageClipboardTitle(int numberOfArticles){
		String numberOfArticlesString = getDriver().findElement(By.cssSelector("div.clipboard span.count")).getText();
		int numberOfArticlesFromClipboard = Integer.valueOf(numberOfArticlesString);
		Assert.assertTrue(numberOfArticles == numberOfArticlesFromClipboard);
	}
	
	public void clickOnClipboardAndVerify(){
//		element(clipboard).waitUntilVisible();
//		clipboard.click();
		waitUntilElementExists(By.cssSelector("div#clipboard a"), 60);
		elementClick("div#clipboard a");
		waitUntilElementExists(By.cssSelector("div#basket_items tbody > tr"), 60);
		Assert.assertTrue(manageClipboardTitle.getText().contains("Manage Clipboard"));
	}
	
	public void verifyTheNumberOfArticlesFromManageClipboardInsideIt(int numberOfArticles){
		String numberOfArticlesString = getDriver().findElement(By.cssSelector("div[class='pull-center-modal muted'] span.count")).getText();
		int numberOfArticlesFromClipboard = Integer.valueOf(numberOfArticlesString);
		Assert.assertTrue(numberOfArticles == numberOfArticlesFromClipboard);
	}
	
	public void verifyWordIsPresentInAllContentOfArticle(int articleNumber, String word){
		int numberOfArticles = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		String articleName = null;
		boolean isPresent = false;
		if(numberOfArticles > 0){
			if(articleNumber <= numberOfArticles && articleNumber > 0){
				articleName = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + articleNumber + ") h5 > a")).getText();
				getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + articleNumber + ") h5 > a")).click();
			}
			else{
				System.out.println("There are not so many articles in list, so click the first one");
				articleName = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(1) h5 > a")).getText();
				getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(1) h5 > a")).click();
			}
		}
		else{
			System.out.println("There are no results");
		}
		System.out.println(getDriver().findElement(By.cssSelector("div.article")).getText());
		if(articleName.contains(word)){
			isPresent = true;
		}
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.article")).getText().contains(word));
		Assert.assertTrue(isPresent);
	}
	
	public void verifyWordIsPresentInFirstParagraphOfArticle(int articleNumber, String word){
		int numberOfArticles = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		String articleName = null;
		boolean isPresent = false;
		if(numberOfArticles > 0){
			if(articleNumber <= numberOfArticles && articleNumber > 0){
				articleName = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + articleNumber + ") h5 > a")).getText();
				getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + articleNumber + ") h5 > a")).click();
			}
			else{
				System.out.println("There are not so many articles in list, so click the first one");
				articleName = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(1) h5 > a")).getText();
				getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(1) h5 > a")).click();
			}
		}
		else{
			System.out.println("There are no results");
		}
		Sleeper.sleepTight(3000);
		if(articleName.contains(word) || getDriver().findElement(By.cssSelector("div.mycontent p:nth-of-type(2)")).getText().contains(word)){
			isPresent = true;
		}
		Assert.assertTrue(isPresent);
	}
	
	public void verifyWordIsPresentOnlyInTitle(int articleNumber, String word){
		int numberOfArticles = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		String articleName = null;
		boolean isPresent = false;
		if(numberOfArticles > 0){
			if(articleNumber <= numberOfArticles && articleNumber > 0){
				articleName = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + articleNumber + ") h5 > a")).getText();
				System.out.println(articleName);
				System.out.println(word);
			}
			else{
				System.out.println("There are not so many articles in list, so verify the first one");
				articleName = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(1) h5 > a")).getText();
				System.out.println(articleName);
				System.out.println(word);
			}
		}
		else{
			System.out.println("There are no results");
		}
		if(articleName.contains(word)){
			isPresent = true;
		}
		Assert.assertTrue(isPresent);
	}
	
	public void clickOnPrintAllLinkAnCancel(){
		String nameOfTheFirstArticleFromClipboard = getDriver().findElement(By.cssSelector("table#basket-table > tbody > tr:nth-of-type(1) > td:nth-child(2)")).getText();
		System.out.println(nameOfTheFirstArticleFromClipboard);
		printAllLinkClipboadWindow.click();
		getDriver().findElement(By.cssSelector("div#basket_items h3")).click();
		waitABit(5000);
		Assert.assertTrue(printButtonPrintModalWindow.isDisplayed());
		Assert.assertTrue(cancelLinkClipboardWindow.isDisplayed());
		Assert.assertTrue(headerOfPrintPreviewWindow.getText().contains("Print Preview"));
		String nameOfTheFirstArticleFromPrinPreview = getDriver().findElement(By.cssSelector("div#basket_items div.modal-body.printable > div:nth-of-type(1) span")).getText();
		System.out.println(nameOfTheFirstArticleFromPrinPreview);
		Assert.assertTrue(nameOfTheFirstArticleFromPrinPreview.contains(nameOfTheFirstArticleFromClipboard));
		cancelLinkClipboardWindow.click();
		Assert.assertTrue(clipboard.isDisplayed());
	}
	
	public void clickOnPrintAllLinkTrialUser(){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div#basket_items button[href='#print']")).size() == 0);
		
	}
	
//	TODO fix this
//	public void clickOnDownloadLink(){
//		waitUntilElementExists(By.cssSelector("div#basket_items button#download_all"), 10);
//		downloadAllLinkClipboadWindow.click();
//		waitABit(10000);
//		DataToolPage data = new DataToolPage(getDriver());
//		data.saveImageHandle2();
//		FileChecker checker = new FileChecker();
//		checker.verifyFilesAreDownloaded();
//	}
//	
	public void clickOnDownloadLinkTrialUser(){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div#basket_items button#download_all")).size() == 0);
	}
	
	public void clickOnAddOnSavedContentButton(){
		selectAllLinkClipboadWindow.click();
		addToSavedContentButtonClipboardWindow.click();
		Sleeper.sleepTight(5000);
		String script = "src\\test\\java\\drivers\\pressOkToAlert.exe";
		Process p;
		try {
			p = Runtime.getRuntime().exec(script);
			p.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		waitABit(5000);
//		
//		WebElement element = getDriver().findElement(By.cssSelector("div.modal-backdrop.fade.in"));
//		element(element).waitUntilVisible();
//		element.click();
////		closeButtonManageClipboard.click();
//		waitABit(5000);
////		elementClick("div#basket_items > div.modal-header > button");
//		int numberOfArticles = getDriver().findElements(By.cssSelector("div.media-listing > div ")).size();
//		for(int i=1; i<=numberOfArticles; i++){
//			Assert.assertTrue(getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + i + ") > div.media-body > div#check-box span")).getAttribute("class").isEmpty());
//		}
	}
	
	public void verifyClipboardAfterAddedAllArticlesOnSavedContent(){
		waitUntilElementExists(By.cssSelector("div#basket_items > div:nth-child(3) > button:nth-child(2)"), 10);
		Assert.assertTrue(getDriver().findElements(By.cssSelector("table#basket-table > tbody > tr")).size() == 0);
		cancelLinkClipboardWindow.click();
		elementClick("div[class='modal-backdrop fade in']");
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div#clipboard a")).size() == 0);
	}
	
	public void clickOnAddOnSavedContentButtonEnterpriseUser(){
		selectAllLinkClipboadWindow.click();
		addToSavedContentButtonClipboardWindow.click();
		Assert.assertTrue(addToSavedContentAlertMessageEnterpriseUser.isDisplayed());
		addToSavedContentCancelButtonEnterpriseUser.click();
	}
	
	public void clickOnSaveIconArticleFromListEnterpriseUser(int articleNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		if (numberOfReportsDisplayed > 0) {
			if (articleNumber <= numberOfReportsDisplayed && articleNumber > 0) {
				elementClick("div.media-listing  > div:nth-child(" + articleNumber + ") > div:nth-child(2) > div:nth-child(1) a > i.icon-c-floppy");
				Assert.assertTrue(alertMessageEnterprise.isDisplayed());
				cancelButtonModalWindowEnterprise.click();
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				elementClick("div.media-listing  > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) a > i.icon-c-floppy");
				Assert.assertTrue(alertMessageEnterprise.isDisplayed());
				cancelButtonModalWindowEnterprise.click();
			}
		} else {
			System.out.println("There aren't any reports!");
		}
	}
	
	
	public void clickOnSaveIconArticleFromList(int articleNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		if (numberOfReportsDisplayed > 0) {
			if (articleNumber <= numberOfReportsDisplayed && articleNumber > 0) {
				elementClick("div.media-listing  > div:nth-child(" + articleNumber + ") > div:nth-child(2) > div:nth-child(1) a > i.icon-c-floppy");
				
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				elementClick("div.media-listing  > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) a > i.icon-c-floppy");
			}
		} else {
			System.out.println("There aren't any reports!");
		}
	}
	
	// TODO fix this
//	public void clickOnDownloadIconArticleFromList(int articleNumber){
//		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
//		DataToolPage data = new DataToolPage(getDriver());
//		FileChecker file = new FileChecker(); 
//		String articleName = "";
//		if (numberOfReportsDisplayed > 0) {
//			if (articleNumber <= numberOfReportsDisplayed && articleNumber > 0) {
//				articleName = getDriver().findElement(By.cssSelector("div.media-listing  > div:nth-child(" + articleNumber + ") > div:nth-child(1) a")).getText();
//				elementClick("div.media-listing  > div:nth-child(" + articleNumber + ") > div:nth-child(2) > div:nth-child(1) a > i.icon-c-download");
//				data.saveImageHandle2();
//				file.verifyFileIsDownloadedRelatives(file.convertFileName(articleName));
//			} else {
//				System.out.println("There aren't so many reports displayed so clicking the first report");
//				articleName = getDriver().findElement(By.cssSelector("div.media-listing  > div:nth-child(1) > div:nth-child(1) a")).getText();
//				elementClick("div.media-listing  > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) a > i.icon-c-download");
//				data.saveImageHandle2();
//				file.verifyFileIsDownloadedRelatives(file.convertFileName(articleName));
//			}
//		} else {
//			System.out.println("There aren't any reports!");
//		}
//	}
	
	public void clickOnPrintIconArticleFromList(int articleNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		String articleName = "";
		if (numberOfReportsDisplayed > 0) {
			if (articleNumber <= numberOfReportsDisplayed && articleNumber > 0) {
				articleName = getDriver().findElement(By.cssSelector("div.media-listing  > div:nth-child(" + articleNumber + ") > div:nth-child(1) a")).getText();
				elementClick("div.media-listing  > div:nth-child(" + articleNumber + ") > div:nth-child(2) > div:nth-child(1) a > i.icon-c-print");
				String winHandleBefore = getDriver().getWindowHandle();
				for (String winHandle : getDriver().getWindowHandles()) {
					getDriver().switchTo().window(winHandle);
				}
				Assert.assertTrue(getDriver().findElement(By.cssSelector("div.padding-20 > h4#use")).getText().contains(articleName));
				printPagePreviewCancel.click();
				getDriver().switchTo().window(winHandleBefore);
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				articleName = getDriver().findElement(By.cssSelector("div.media-listing  > div:nth-child(1) > div:nth-child(1) a")).getText();
				elementClick("div.media-listing  > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) a > i.icon-c-print");
				String winHandleBefore = getDriver().getWindowHandle();
				for (String winHandle : getDriver().getWindowHandles()) {
					getDriver().switchTo().window(winHandle);
				}
				Assert.assertTrue(getDriver().findElement(By.cssSelector("div.padding-20 > h4#use")).getText().contains(articleName));
				printPagePreviewCancel.click();
				getDriver().switchTo().window(winHandleBefore);
			}
		} else {
			System.out.println("There aren't any reports!");
		}
	}
	
	public void clickOnEmailIconArticleFromList(int articleNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		if (numberOfReportsDisplayed > 0) {
			if (articleNumber <= numberOfReportsDisplayed && articleNumber > 0) {
				elementClick("div.media-listing  > div:nth-child(" + articleNumber + ") > div:nth-child(2) > div:nth-child(1) a > i.icon-c-email");
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				elementClick("div.media-listing  > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) a > i.icon-c-email");
			}
		} else {
			System.out.println("There aren't any reports!");
		}
	}
	
	public void clickOnDownloadIconArticleFromListTrialUser(int articleNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		if (numberOfReportsDisplayed > 0) {
			if (articleNumber <= numberOfReportsDisplayed && articleNumber > 0) {
				elementClick("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(2) > div:nth-child(1) a > i.icon-c-download");
				Assert.assertTrue(alertMessageDownload.isDisplayed());
				cancelButtonModalWindowTrialDownload.click();
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				elementClick("div.media-listing  > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) a > i.icon-c-download");
				Assert.assertTrue(alertMessageDownload.isDisplayed());
				cancelButtonModalWindowTrialDownload.click();
			}
		} else {
			System.out.println("There aren't any reports!");
		}
	}
	

	public void clickOnPrintIconArticleFromListTrialUser(int articleNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		if (numberOfReportsDisplayed > 0) {
			if (articleNumber <= numberOfReportsDisplayed && articleNumber > 0) {
				elementClick("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(2) > div:nth-child(1) a > i.icon-c-print");
				Assert.assertTrue(alertMessagePrint.isDisplayed());
				cancelButtonModalWindowTrialPrint.click();
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				elementClick("div.media-listing  > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) a > i.icon-c-print");
				Assert.assertTrue(alertMessagePrint.isDisplayed());
				cancelButtonModalWindowTrialPrint.click();
			}
		} else {
			System.out.println("There aren't any reports!");
		}
	}
	
	public void clickOnNonPermissionArticleAndClickOnCancel(int articleNumber){
		waitABit(5000);
		int numberOfArticles = getDriver().findElements(By.cssSelector("article#results > div.media-listing > div")).size();
		if(numberOfArticles > 0){
			if(articleNumber > 0 && articleNumber < numberOfArticles){
				if(getDriver().findElement(By.cssSelector("article#results > div.media-listing > div:nth-child(" + articleNumber +") > div a")).getAttribute("class").contains("non-permission")){
					getDriver().findElement(By.cssSelector("article#results > div.media-listing > div:nth-child(" + articleNumber +") > div a")).click();
					Assert.assertTrue(alertMessageNoEntitlements.isDisplayed());
					cancelButtonAlertMessageNoEntitlements.click();
				}
				else{
					System.out.println("This article is enabled");
				}
				
			}
		}
	}
	
	public void clickOnNonPermissionArticleAndClickOnContactAccountManagerButton(int articleNumber){
		waitABit(5000);
		int numberOfArticles = getDriver().findElements(By.cssSelector("article#results > div.media-listing > div")).size();
		if(numberOfArticles > 0){
			if(articleNumber > 0 && articleNumber < numberOfArticles){
				if(getDriver().findElement(By.cssSelector("article#results > div.media-listing > div:nth-child(" + articleNumber +") > div a")).getAttribute("class").contains("non-permission")){
					getDriver().findElement(By.cssSelector("article#results > div.media-listing > div:nth-child(" + articleNumber +") > div a")).click();
					Assert.assertTrue(alertMessageNoEntitlements.isDisplayed());
					contactAccountManagerButtonAlertMessageNoEntitlements.click();
					waitABit(10000);
					Assert.assertTrue(getDriver().findElement(By.cssSelector("input#subject")).isDisplayed());
				}
				else{
					System.out.println("This article is enabled");
				}
				
			}
		}
	}
	
	public void verifyNonSubscribedContentIsChecked(){
		if(getDriver().findElements(By.cssSelector("div[class=' media  media-border clearfix'] ")).size() > 0){
			Assert.assertTrue(verifyElementState("document.getElementById('new_form_non_permissioned_content')"));
		}
	}
	
	public void verifyIfRefineBySectionContainsTheWordFromAdvancedSearch(String word){
		if(getDriver().findElements(By.cssSelector("div[class=' media  media-border clearfix'] ")).size() > 0){
			String valueFromSearchPage = getDriver().findElement(By.cssSelector("form#search_refine_form > ul:nth-child(1) > li:nth-child(2) > ul > li > div#controls  > div > div > input")).getAttribute("value").toLowerCase();
			Assert.assertTrue(valueFromSearchPage.contains(word.toLowerCase()));
		}
	}
	
	public void verifyIfRefineBySectionContainsTheCorrectLabel(String label){
		if(getDriver().findElements(By.cssSelector("div[class=' media  media-border clearfix'] ")).size() > 0){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("form#search_refine_form > ul:nth-child(1) > li:nth-child(2) > ul > li > div#controls  > div label")).getText().contains(label));
		}
	}
	
	public void verifyIfCorrectContentTypeIsChecked(String contentType){
	if(getDriver().findElements(By.cssSelector("div[class=' media  media-border clearfix'] ")).size() > 0){
		Assert.assertTrue(contentType.toLowerCase().contains(getDriver().findElement(By.cssSelector("ul.type-search input[checked='checked']")).getAttribute("value")));
		}
	}
	
	public void verifyIfGeographyIsChecked(String geography, String geographyId){
	if(getDriver().findElements(By.cssSelector("div[class=' media  media-border clearfix'] ")).size() > 0){
		System.out.println(geography);
		System.out.println(geographyId);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#geographies_filter input[checked='checked']")).getAttribute("id").contains(geographyId));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#geographies_filter > li:nth-child(2) > ul > li:nth-child(1) label")).getText().contains(geography));
		}
	}
	
	public void verifyIfChannelIsChecked(String channel, String channelId){
	if(getDriver().findElements(By.cssSelector("div[class=' media  media-border clearfix'] ")).size() > 0){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#channels_filter input[checked='checked']")).getAttribute("id").contains(channelId));
		System.out.println(getDriver().findElement(By.cssSelector("ul#channels_filter > li:nth-child(2) > ul > li:nth-child(1) label")).getText());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#channels_filter > li:nth-child(2) > ul > li:nth-child(1) label")).getText().contains(channel));
		}
	}
	
	public void verifyIfCategoryIsChecked(String category, int categoryNumber){
	if(getDriver().findElements(By.cssSelector("div[class=' media  media-border clearfix'] ")).size() > 0){
		Assert.assertTrue(verifyElementState("document.getElementById('category_" + categoryNumber + "'"));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#categories_filter > li:nth-child(2) > ul > li:nth-child(1) label")).getText().contains(category));
		}
	}
	
	public void verifyIfCompanyIsChecked(String company, String companyId){
	if(getDriver().findElements(By.cssSelector("div[class=' media  media-border clearfix'] ")).size() > 0){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#companies_filter input[checked='checked']")).getAttribute("id").contains(companyId));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#companies_filter > li:nth-child(2) > ul > li:nth-child(1) label")).getText().contains(company));
		}
	}
	
	public void checkOnePublicationDate(String dateValue){
		getDriver().findElement(By.cssSelector("ul#publication-date label[for='" + dateValue + "']")).click();
	}
	
	public void verifyPublicationDateFilter(String dateValue){
		Assert.assertTrue(verifyElementState("document.getElementById('" + dateValue + "')"));
//		Assert.assertTrue(getDriver().findElements(By.cssSelector("div#uniform-new_form_publication_date input[value='" + dateValue + "'][checked='checked']")).size() == 1);
	}
}

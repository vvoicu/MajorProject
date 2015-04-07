package bmo5.bmo5tests.bmo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class AdvancedSearchPage extends AbstractPage{
	
	@FindBy(css = "div#collapseOne > div > div:nth-child(1) > div > div > input ")
	@CacheLookup
	private WebElement allOfTheseWordsBox;
	
	@FindBy(css = "div#collapseOne > div > div:nth-child(2) > div > div > input")
	@CacheLookup
	private WebElement theExactPhraseBox;
	
	@FindBy(css = "div#collapseOne > div > div:nth-child(3) > div > div > input")
	@CacheLookup
	private WebElement anyOfTheseWordsBox;
	
	@FindBy(css = "div#collapseOne > div > div:nth-child(4) > div > div > input ")
	@CacheLookup
	private WebElement noneOfTheseWordsBox;
	
	@FindBy(css = "div#collapseOne > div > div:nth-child(5) > div > div:nth-child(1) > label")
	@CacheLookup
	private WebElement newsAndAnalysisCheckBox;
	
	@FindBy(css = "div#collapseOne > div > div:nth-child(5) > div > div:nth-child(2) > label")
	@CacheLookup
	private WebElement reportsCheckBox;
	
	@FindBy(css = "div#collapseOne > div > div:nth-child(5) > div > div:nth-child(3) > label")
	@CacheLookup
	private WebElement nonSubscribedContentCheckBox;
	
	@FindBy(css = "div#collapseOne > div > div:nth-child(5) > div.control-group  > div > div:nth-child(1)")
	@CacheLookup
	private WebElement typeAllContent;
	
	@FindBy(css = "div#collapseOne > div > div:nth-child(5) > div.control-group  > div > div:nth-child(2)")
	@CacheLookup
	private WebElement typeInTitleOnly;
	
	@FindBy(css = "div#collapseOne > div > div:nth-child(5) > div.control-group  > div > div:nth-child(3)")
	@CacheLookup
	private WebElement typeInFirstParagraph;
	
	@FindBy(css = "form#advanced_search_form > section:nth-child(2) > div > div:nth-child(1) > div > a > span")
	private WebElement searchWithinContentAccordionGroup;
	
	@FindBy(css = "div#accordion2 > div:nth-child(2)  > div:nth-child(1) > a")
	@CacheLookup
	private WebElement geographiesAccordionGroup;
	
	@FindBy(css = "div#accordion2 > div:nth-child(3)  > div:nth-child(1) > a")
	@CacheLookup
	private WebElement channelsAccordionGroup;
	
	@FindBy(css = "div#accordion2 > div:nth-child(4)  > div:nth-child(1) > a")
	@CacheLookup
	private WebElement companiesAccordionGroup;
	
	@FindBy(css = "div#accordion2 > div:nth-child(5)  > div:nth-child(1) > a")
	@CacheLookup
	private WebElement publicationDateAccordionGroup;
	
	@FindBy(css = "div#accordion2 > div:nth-child(6)  > div:nth-child(1) > a")
	@CacheLookup 
	private WebElement sortByAccordionGroup;
	
	@FindBy(css = "div#collapseTwo  input#geo_filt")
	@CacheLookup
	private WebElement geographiesTypeCountryToFilterListBox;
	
	@FindBy(css = "div#collapseThree input#chan_filt")
	@CacheLookup
	private WebElement channelsEnterChannelToFilterOptionsBox;
	
	@FindBy(css = "div#collapseFour input#comp_filt")
	@CacheLookup
	private WebElement companiesTypeToFilterListBox;
	
	@FindBy(css = "div#collapseFive > div > div:nth-child(1) > div > div:nth-child(1) > label")
	@CacheLookup
	private WebElement publicationDateDateRangeAnytime;
	
	@FindBy(css = "div#collapseFive > div > div:nth-child(1) > div > div:nth-child(2) > label")
	@CacheLookup
	private WebElement publicationDateDateRangeWithinLastWeek;
	
	@FindBy(css = "div#collapseFive > div > div:nth-child(1) > div > div:nth-child(3) > label")
	@CacheLookup
	private WebElement publicationDateDateRangeWithinLastMonth;
	
	@FindBy(css = "div#collapseFive > div > div:nth-child(1) > div > div:nth-child(4) > label")
	@CacheLookup
	private WebElement publicationDateDateRangeWithinLast3Months;
	
	@FindBy(css = "div#collapseFive > div > div:nth-child(1) > div > div:nth-child(5) > label")
	@CacheLookup
	private WebElement publicationDateDateRangeWithinLast6Months;
	
	@FindBy(css = "div#collapseFive > div > div:nth-child(2)  input#start_date")
	@CacheLookup
	private WebElement publicationDateStartDate;
	
	@FindBy(css = "div#collapseFive > div > div:nth-child(2)  input#end_date")
	@CacheLookup
	private WebElement publicationDateEndDate;
	
	@FindBy(css = "div#collapseSix > div > div > div > div:nth-child(1)")
	@CacheLookup
	private WebElement sortResultsByPublicationDateAndRelevance;
	
	@FindBy(css = "div#collapseSix > div > div > div > div:nth-child(2)")
	@CacheLookup
	private WebElement sortResultsByRelevance;
	
	@FindBy(css = "div#collapseSix > div > div > div > div:nth-child(3)")
	@CacheLookup
	private WebElement sortByPublicationDateOnly;
	
	@FindBy(css = "section[class = 'row-fluid border-top padding-top-20'] button[class = 'btn btn-link btn-link-reset']")
	@CacheLookup
	private WebElement clearFormLinkTopSavePage;
	
	@FindBy(css = "section[class = 'row-fluid padding-top-20'] button[class = 'btn btn-link btn-link-reset']")
	@CacheLookup
	private WebElement clearFormLinkTopPage;
	
	@FindBy(css = "form#advanced_search_form > section:nth-child(1) button[class='btn btn-wider btn-primary']")
	@CacheLookup
	private WebElement searchButtonTopPage;
	
	@FindBy(css = "section[class='row-fluid border-top padding-top-20'] button#save_srch")
	@CacheLookup
	private WebElement searchButtonTopSavePage;
	
	@FindBy(css = "section[class = 'row-fluid  padding-top-20'] button[class = 'btn btn-link btn-link-reset']")
	@CacheLookup
	private WebElement clearFormLinkBottomPage;
	
	@FindBy(css = "section[class = 'row-fluid  padding-top-20'] button#clear_search")
	@CacheLookup
	private WebElement searchButtonBottomSavePage;
	
	@FindBy(css = "form#advanced_search_form > section:nth-child(2) button[class='btn btn-wider btn-primary']")
	@CacheLookup
	private WebElement searchButtonBottomPage;
	
	@FindBy(css = "div#collapseTwo > div > div:nth-child(1) > div > button")
	@CacheLookup
	private WebElement clearLinkFromGeographiesSection;
	
	@FindBy(css = "div#collapseThree > div > div:nth-child(1) > div > button")
	@CacheLookup
	private WebElement clearLinkFromChannelsSection;
	
	@FindBy(css = "div#collapseFour > div > div:nth-child(1) > div > button")
	@CacheLookup
	private WebElement clearLinkFromCompaniesSection;
	
	@FindBy(css = "div#collapseFive > div > div > div > div > button")
	@CacheLookup
	private WebElement clearLinkFromPublicationDateSection;
	
	@FindBy(css = "ul[class='typeahead dropdown-menu'] >li:nth-child(2)")
	@CacheLookup
	private WebElement firstElementFromListing;
	
	@FindBy(css = "div.span12 > div > span")
	private WebElement errorMessage;
	
	@FindBy(css = "div#collapseFive > div > div:nth-child(2) div:nth-child(2) >div:nth-child(1) > label:nth-of-type(2)")
	private WebElement invalidStartDateErrorMessage;
	
	@FindBy(css = "div#collapseFive > div > div:nth-child(2) div:nth-child(2) >div:nth-child(2) > label:nth-of-type(2)")
	private WebElement invalidEndDateErrorMessage;
	
	@FindBy(css = "div#collapseFive > div > div:nth-child(2) div:nth-child(2) >div:nth-child(2) > label:nth-of-type(2) > p")
	private WebElement startDateShouldBeGraterThanEndDateErrorMessage;
	
	@FindBy(css = "div#geographies_move_remove i.icon-c-angle-right")
	private WebElement moveToRightPanelOneItemGeographySectionArrow;
	
	@FindBy(css = "div#companies_move_remove button#all_Groups_rightSelected")
	private WebElement moveToRightPanelOneItemCompaniesSectionArrow;
	
	@FindBy(css = "select[class='geographies from span12 valid'] option")
	private WebElement geographyLeftContainer;
	
	@FindBy(css = "div#geographies_move_remove button#all_Groups_rightAll")
	private WebElement moveToRightAllItemsGeographySectionArrow;
	
	@FindBy(css= "div#companies_move_remove button#all_Groups_rightAll")
	private WebElement moveToRightAllItemsCompaniesSectionArrow;
	
	@FindBy(css = "form#advanced_search_form input#search_title")
	private WebElement searchBoxTitle;
	
	@FindBy(css = "div.alert.alert-success")
	private WebElement confirmationMessageSavingSearch;
	
	@FindBy(css = "div.alert.alert-error")
	private WebElement errorMessageSavingSearch;
	
	@FindBy(css = "button.btn.btn-wider.btn-primary")
	private WebElement saveSearchButtonSaveSearchPage;
	
	@FindBy(css = "span[class = 'pull-right border-top padding-bottom-10'] a")
	private WebElement returnToSavedSearchesButton;
	
	public void completeAllOfTheseWordsBoxAndClickOnSearchButton(String characters){
		allOfTheseWordsBox.sendKeys(characters);
		firstElementFromListing.click();
		searchButtonTopPage.click();
	}
	
	public void completeAllOfTheseWordsBoxChangeThePublicationDateAnsClickOnSearchButton(String word){
		allOfTheseWordsBox.sendKeys(word);
		Assert.assertTrue(verifyElementState("document.getElementById('content_all_content')"));
//		Assert.assertTrue(typeAllContent.getAttribute("class").contains("checked"));
		publicationDateAccordionGroup.click();
		publicationDateDateRangeWithinLastMonth.click();
//		Assert.assertTrue(publicationDateDateRangeWithinLastMonth.getAttribute("class").contains("checked"));
		Assert.assertTrue(verifyElementState("document.getElementById('pub_date_last_month')"));
		searchButtonBottomPage.click();
		
	}
	
	public void completeAllOfTheseWordsBoxStartAndEndDateWithInvalidDataAndVerify(String word, String startDate, String endDate){
		allOfTheseWordsBox.sendKeys(word);
		Assert.assertTrue(verifyElementState("document.getElementById('content_all_content')"));
//		Assert.assertTrue(typeAllContent.getAttribute("class").contains("checked"));
		publicationDateAccordionGroup.click();
		publicationDateStartDate.sendKeys(startDate);
		publicationDateEndDate.sendKeys(endDate);
		searchButtonBottomPage.click();
		Assert.assertTrue(invalidStartDateErrorMessage.getText().contains("Please enter a valid date in the format dd/mm/yyyy."));
		Assert.assertTrue(invalidEndDateErrorMessage.getText().contains("Please enter a valid date in the format dd/mm/yyyy."));
	}
	
	public void completeTheExactPhraseBoxCheckOneContentTypeAndClickOnSearchButton(String word, String contentTypeValue){
		theExactPhraseBox.sendKeys(word);
//		getDriver().findElement(By.cssSelector("input#" + contentTypeValue)).click();
		elementClick("input#" + contentTypeValue);
		Assert.assertTrue(verifyElementState("document.getElementById('" + contentTypeValue + "')"));
//		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#uniform-" + contentTypeValue + " > span")).getAttribute("class").contains("checked"));
		publicationDateAccordionGroup.click();
//		Assert.assertTrue(publicationDateDateRangeAnytime.getAttribute("class").contains("checked"));
		Assert.assertTrue(verifyElementState("document.getElementById('publication_date_any')"));
		searchButtonTopPage.click(); 
	}
	
	public void completeAnyOfTheseWordsBoxAndClickOnSearchButton(String word){
		anyOfTheseWordsBox.sendKeys(word);
		searchButtonTopPage.click();
	}
	
	public void completeNoneOfTheseWordsBoxAndClickOnSearchButton(String word){
		noneOfTheseWordsBox.sendKeys(word);
		searchButtonTopPage.click();
	}
	
	public void completeAllOfTheseWordsBoxChangeSortingToRelevanceAndClickOnSearchButton(String word){
		allOfTheseWordsBox.sendKeys(word);
		sortByAccordionGroup.click();
		sortResultsByRelevance.click();
		searchButtonTopPage.click();
	}
	
	public void completeAllOfTheseWordsBoxChangeSortingToPublicationOnlyAndClickOnSearchButton(String word){
		allOfTheseWordsBox.sendKeys(word);
		sortByAccordionGroup.click();
		sortByPublicationDateOnly.click();
		searchButtonTopPage.click();
	}
	
	public String completeGeographyTitleMoveItToRightPanelAndVerify(int geographyNumber, String word){ 
		geographiesAccordionGroup.click();
		geographiesTypeCountryToFilterListBox.sendKeys(word);
		Sleeper.sleepTight(3000);
		int numberOfItemsInGeographyLeftContainer = getDriver().findElements(By.cssSelector("div#collapseTwo > div > div:nth-child(2)  > div > div:nth-child(1) > select > option")).size();
		int i;
		boolean objectFound = false, objectContains = false;
		for(i = 1; i<=numberOfItemsInGeographyLeftContainer; i++){
			objectContains = false;
			if(getDriver().findElement(By.cssSelector("div#collapseTwo > div > div:nth-child(2)  > div > div:nth-child(1) > select > option:nth-of-type(" + i + ")")).getText().contains("ame")){
				objectContains = true;
				Assert.assertTrue(objectContains);
			}
		}
		System.out.println(objectContains);
		String objectName = null;
		
		if (numberOfItemsInGeographyLeftContainer > 0) {
			if (geographyNumber <= numberOfItemsInGeographyLeftContainer && geographyNumber > 0) {
				System.out.println("Total no of items:" + numberOfItemsInGeographyLeftContainer);
				System.out.println("Item number" + geographyNumber);
				objectName = getDriver().findElement(By.cssSelector("div#collapseTwo > div > div:nth-child(2)  > div > div:nth-child(1) > select > option:nth-of-type(" + geographyNumber + ")")).getText();
				getDriver().findElement(By.cssSelector("div#collapseTwo > div > div:nth-child(2)  > div > div:nth-child(1) > select > option:nth-of-type(" + geographyNumber + ")")).click();;
				System.out.println(objectName);
			} else {
				System.out.println("Total no of itenms:" + numberOfItemsInGeographyLeftContainer);
				System.out.println("Item number" + geographyNumber);
				System.out.println("There aren't so many items displayed so clicking the first item");
				objectName = getDriver().findElement(By.cssSelector("div#collapseTwo > div > div:nth-child(2)  > div > div:nth-child(1) > select > option:nth-of-type(1)")).getText();
				getDriver().findElement(By.cssSelector("div#collapseTwo > div > div:nth-child(2)  > div > div:nth-child(1) > select > option:nth-of-type(1)")).click();
				System.out.println(objectName);
			}
		} else {
			System.out.println("There aren't any items");
			System.out.println(objectName);
		}		
		moveToRightPanelOneItemGeographySectionArrow.click();
		int numberOfItemsInRightPanelGeographies = getDriver().findElements(By.cssSelector("select#geographies > option")).size();
		for(i=1; i<=numberOfItemsInRightPanelGeographies; i++){
			if(getDriver().findElement(By.cssSelector("select#geographies > option:nth-child(" + i + ")")).getText().contains(objectName)){
				objectFound = true;
			}
		}
		Assert.assertTrue(objectFound);
//		searchButtonBottomPage.click();
		return objectName;
	}
	
	public String returnTheGeographyIdFromRightHandPanel() {
		String geographyId = getDriver().findElement(By.cssSelector("select#geographies > option")).getAttribute("value");
		return geographyId;
	}
	
	public String completeChannelTitleCheckChannelsAndVerify(int channelNumber, String word){
		channelsAccordionGroup.click();
		channelsEnterChannelToFilterOptionsBox.sendKeys(word);
		Sleeper.sleepTight(3000);
		getDriver().findElement(By.cssSelector("div#channelsleft ul.ltr > li.open > a > ins")).click();
		String channel = getDriver().findElement(By.cssSelector("div#channelsleft ul.ltr > li[class='open'] > a")).getText();
		System.out.println(channel);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#channelsleft ul.ltr > li[class='open'] > a")).getAttribute("class").contains("checked"));
//		searchButtonBottomPage.click();
		return channel.replaceAll(" ", "");
	}
	
	public String returnTheChannelIdChecked() {
		String channelId = getDriver().findElement(By.cssSelector("div#channelsleft ul.ltr > li[class='open']")).getAttribute("id");
		return channelId;
	}
	
	public String completeCompaniesTitleMoveItToRightPanelAndVerify(int companyNumber, String word){
		companiesAccordionGroup.click();
		companiesTypeToFilterListBox.sendKeys(word);
		Sleeper.sleepTight(3000);
		int numberOfItemsICompanyLeftContainer = getDriver().findElements(By.cssSelector("div#collapseFour > div > div:nth-child(2)  > div > div:nth-child(1) > select > option")).size();
		int i;
		boolean objectFound = false, objectContains = false;
		for(i = 1; i<=numberOfItemsICompanyLeftContainer; i++){
			objectContains = false;
			if(getDriver().findElement(By.cssSelector("div#collapseFour > div > div:nth-child(2)  > div > div:nth-child(1) > select > option:nth-of-type(" + i + ")")).getText().contains("ame")){
				objectContains = true;
				Assert.assertTrue(objectContains);
			}
		}
		System.out.println(objectContains);
		String objectName = null;
		
		if (numberOfItemsICompanyLeftContainer > 0) {
			if (companyNumber <= numberOfItemsICompanyLeftContainer && companyNumber > 0) {
				System.out.println("Total no of items:" + numberOfItemsICompanyLeftContainer);
				System.out.println("Item number" + companyNumber);
				objectName = getDriver().findElement(By.cssSelector("div#collapseFour > div > div:nth-child(2)  > div > div:nth-child(1) > select > option:nth-of-type(" + companyNumber + ")")).getText();
				getDriver().findElement(By.cssSelector("div#collapseFour > div > div:nth-child(2)  > div > div:nth-child(1) > select > option:nth-of-type(" + companyNumber + ")")).click();;
				System.out.println(objectName);
			} else {
				System.out.println("Total no of itenms:" + numberOfItemsICompanyLeftContainer);
				System.out.println("Item number" + companyNumber);
				System.out.println("There aren't so many items displayed so clicking the first item");
				objectName = getDriver().findElement(By.cssSelector("div#collapseFour > div > div:nth-child(2)  > div > div:nth-child(1) > select > option:nth-of-type(1)")).getText();
				getDriver().findElement(By.cssSelector("div#collapseFour > div > div:nth-child(2)  > div > div:nth-child(1) > select > option:nth-of-type(1)")).click();
				System.out.println(objectName);
			}
		} else {
			System.out.println("There aren't any items");
			System.out.println(objectName);
		}
	
		moveToRightPanelOneItemCompaniesSectionArrow.click();
		int numberOfItemsInRightPanelCompanies = getDriver().findElements(By.cssSelector("select#companies > option")).size();
		for(i=1; i<=numberOfItemsInRightPanelCompanies; i++){
			if(getDriver().findElement(By.cssSelector("select#companies > option:nth-child(" + i + ")")).getText().contains(objectName)){
				objectFound = true;
			}
		}
		Assert.assertTrue(objectFound);
//		searchButtonBottomPage.click();
		return objectName;
	}
	
	
	public String returnTheCompanyIdFromRightHandPanel() {
		String companyId = getDriver().findElement(By.cssSelector("select#companies > option")).getAttribute("value");
		return companyId;
	}
	
	public void moveAllGeographiesToRightPanelClearSectionAndVerify(){
		geographiesAccordionGroup.click();
		moveToRightAllItemsGeographySectionArrow.click();
		clearLinkFromGeographiesSection.click();
		Assert.assertTrue(getDriver().findElements(By.cssSelector("select#geographies > option")).isEmpty());
	}
	
	public void checkAllChannelsClearSectionAndVerify(){
		channelsAccordionGroup.click();
		int numberOfItemsInChannelSection = getDriver().findElements(By.cssSelector("div#channelsleft > ul > li")).size();
		int i=1;
		for(i=1; i<=numberOfItemsInChannelSection; i++){
			getDriver().findElement(By.cssSelector("div#channelsleft > ul > li:nth-child(" + i + ") > a > ins")).click();
		}
		clearLinkFromChannelsSection.click();
		for(i=1; i<=numberOfItemsInChannelSection; i++){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div#channelsleft > ul > li:nth-child(" + i + ") > a")).getAttribute("class").contains("unchecked"));
		}
	}
	
	public void moveAllCompaniesToRightPanelClearSectionAndVerify(){
		companiesAccordionGroup.click();
		moveToRightAllItemsCompaniesSectionArrow.click();
		clearLinkFromCompaniesSection.click();
		Assert.assertTrue(getDriver().findElements(By.cssSelector("select#companies > option")).isEmpty());
	}
	
	public void verifyPublicationDateErrorMessages(String startDate, String endDate, String startDateGraterThanEndDate, String endDateSmallerThanStartDate){
		publicationDateAccordionGroup.click();
		publicationDateStartDate.sendKeys(startDate);
		publicationDateEndDate.sendKeys(endDate);
		invalidStartDateErrorMessage.click();
		Assert.assertTrue(invalidStartDateErrorMessage.getText().contains("Please enter a valid date in the format dd/mm/yyyy"));
		Assert.assertTrue(invalidEndDateErrorMessage.getText().contains("Please enter a valid date in the format dd/mm/yyyy"));
		publicationDateStartDate.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		publicationDateStartDate.sendKeys(Keys.DELETE);
		publicationDateStartDate.sendKeys(startDateGraterThanEndDate);
		publicationDateEndDate.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		publicationDateEndDate.sendKeys(Keys.DELETE);
		publicationDateEndDate.sendKeys(endDateSmallerThanStartDate);
		Assert.assertTrue(startDateShouldBeGraterThanEndDateErrorMessage.getText().contains("End date should be greater"));
	}
	
	public void completeSomeSectionsClearFormAndVerify(String startDate, String endDate, String word){
		allOfTheseWordsBox.sendKeys(word);
		typeInFirstParagraph.click();
		publicationDateAccordionGroup.click();
		publicationDateStartDate.sendKeys(startDate);
		publicationDateEndDate.sendKeys(endDate);
		clearFormLinkBottomPage.click();
//		Assert.assertTrue(publicationDateDateRangeAnytime.getAttribute("class").contains("checked"));
		Assert.assertTrue(verifyElementState("document.getElementById('publication_date_any')"));
		searchWithinContentAccordionGroup.click();
		Assert.assertTrue(allOfTheseWordsBox.getText().isEmpty());
	}
	
	public void completeAllSectionClearFormAndVerifyFromSaveSearchPage(String word, String searchTitle){
		searchBoxTitle.sendKeys(searchTitle);
		searchWithinContentAccordionGroup.click();
		allOfTheseWordsBox.sendKeys(word);
		geographiesAccordionGroup.click();
		moveToRightAllItemsGeographySectionArrow.click();
		channelsAccordionGroup.click();
		int numberOfItemsInChannelSection = getDriver().findElements(By.cssSelector("div#channelsleft > ul > li")).size();
		int i=1;
		for(i=1; i<=numberOfItemsInChannelSection; i++){
			getDriver().findElement(By.cssSelector("div#channelsleft > ul > li:nth-child(" + i + ") > a > ins")).click();
		}
		companiesAccordionGroup.click();
		moveToRightAllItemsCompaniesSectionArrow.click();
		publicationDateAccordionGroup.click();
		publicationDateDateRangeWithinLast6Months.click();
		clearFormLinkBottomPage.click();
		Assert.assertTrue(searchBoxTitle.getText().isEmpty());
		searchWithinContentAccordionGroup.click();
		Assert.assertTrue(allOfTheseWordsBox.getText().isEmpty());
		geographiesAccordionGroup.click();
		Assert.assertEquals(getDriver().findElements(By.cssSelector("select#geographies > option")).size(), 0);
		channelsAccordionGroup.click();
		for(i=1; i<=numberOfItemsInChannelSection; i++){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div#channelsleft > ul > li:nth-child(" + i + ") > a")).getAttribute("class").contains("unchecked"));
		}
		companiesAccordionGroup.click();
		Assert.assertEquals(getDriver().findElements(By.cssSelector("select#companies > option")).size(), 0);
		publicationDateAccordionGroup.click();
		Assert.assertTrue(publicationDateDateRangeAnytime.getAttribute("class").contains("checked"));
	}
	
	public String completeAllSectionSaveSearchAndVerifyFromSaveSearchPage(String word){
		String searchTitle = String.valueOf(StringUtils.randomNumber(10000));
		searchBoxTitle.sendKeys(searchTitle);
		
		allOfTheseWordsBox.sendKeys(word);
		geographiesAccordionGroup.click();
		moveToRightAllItemsGeographySectionArrow.click();
		channelsAccordionGroup.click();
		int numberOfItemsInChannelSection = getDriver().findElements(By.cssSelector("div#channelsleft > ul > li")).size();
		int i=1;
		for(i=1; i<=numberOfItemsInChannelSection; i++){
			elementClick("div#channelsleft > ul > li:nth-child(" + i + ") > a > ins");
			waitABit(2000);
		}
		waitABit(3000);
		companiesAccordionGroup.click();
		waitABit(3000);
		moveToRightAllItemsCompaniesSectionArrow.click();
		waitABit(3000);
		publicationDateAccordionGroup.click();
		waitABit(3000);
		publicationDateDateRangeWithinLast6Months.click();
		waitABit(3000);
		saveTheSearchAndVerify();
		return searchTitle;
	}
	
	public void verifySaveSearchPage(){
		Assert.assertTrue(searchBoxTitle.isDisplayed());
		Assert.assertTrue(allOfTheseWordsBox.isDisplayed());
		Assert.assertTrue(theExactPhraseBox.isDisplayed());
		Assert.assertTrue(anyOfTheseWordsBox.isDisplayed());
		Assert.assertTrue(noneOfTheseWordsBox.isDisplayed());
		Assert.assertTrue(geographiesAccordionGroup.isDisplayed());
		Assert.assertTrue(channelsAccordionGroup.isDisplayed());
		Assert.assertTrue(companiesAccordionGroup.isDisplayed());
		Assert.assertTrue(publicationDateAccordionGroup.isDisplayed());
		Assert.assertTrue(sortByAccordionGroup.isDisplayed());
		Assert.assertTrue(searchButtonTopSavePage.isDisplayed());
		Assert.assertTrue(searchButtonBottomSavePage.isDisplayed());
		Assert.assertTrue(clearFormLinkTopSavePage.isDisplayed());
		Assert.assertTrue(clearFormLinkBottomPage.isDisplayed());
		Assert.assertTrue(returnToSavedSearchesButton.isDisplayed());
	}
	
	public void saveTheSearchAndVerify(){
		saveSearchButtonSaveSearchPage.click();
		Assert.assertTrue(confirmationMessageSavingSearch.getText().contains("Your search was successfully saved."));
	}
	
	//TODO fix this
//	public void completeAllSectionSaveSearchWithAnExistingNameAndVerifyFromSaveSearchPage(String word){
//		String searchTitle = completeAllSectionSaveSearchAndVerifyFromSaveSearchPage(word);
//		//TODO Fix this
////		HomePageHeaderPage homePageHeader = new HomePageHeaderPage(getDriver());
////		homePageHeader.clickOnSavedContent();
//		SavedContentPage savedContent = new SavedContentPage(getDriver());
//		savedContent.clickOnSavedSearchesLeftPanel();
//		SavedViewsSavedSearchesSavedMncPage savedSearch = new SavedViewsSavedSearchesSavedMncPage(getDriver());
//		waitABit(3000);
//		savedSearch.createANewSavedSearch();
//		element(searchBoxTitle).waitUntilVisible();
//		searchBoxTitle.sendKeys(searchTitle);
//		saveSearchButtonSaveSearchPage.click();
//		Assert.assertTrue(errorMessageSavingSearch.getText().contains("A saved search with this title already exists. Please choose a different title."));
//	}
	
	public void clickOnSearchButton(){
		searchButtonTopPage.click();
	}
	
	public void checkNonSubscribedContentBox(){
		nonSubscribedContentCheckBox.click();
//		Assert.assertTrue(nonSubscribedContentCheckBox.getAttribute("class").contains("checked"));
		Assert.assertTrue(verifyElementState("document.getElementById('non_permissioned_content')"));
		searchButtonTopPage.click();
	}
	
	public String clickOnPreviewArticleFromList(int articleNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		String articleTitle="";
		if (numberOfReportsDisplayed > 0) {
			if (articleNumber <= numberOfReportsDisplayed && articleNumber > 0) {
				waitABit(5000);
				if(getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child( "+ articleNumber +") > div:nth-child(2) > div > a.btn.btn-link.preview-article.hide-actions i")).getAttribute("class").contains("left")){
					System.out.println("Preview window is already open");
				}
				else{
					elementClick("div.media-listing > div:nth-child( "+ articleNumber +") > div:nth-child(2) > div > a.btn.btn-link.preview-article.hide-actions");
					articleTitle = getDriver().findElement(By.cssSelector("div.media-listing  > div:nth-child("+ articleNumber +") >  div:nth-child(1) > div > h5 > a")).getText();
				}
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				if(getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(1) > div:nth-child(2) > div > a.btn.btn-link.preview-article.hide-actions i")).getAttribute("class").contains("left")){
					System.out.println("Preview window is already open");
				}
				else{
					elementClick("div.media-listing > div:nth-child(1) > div:nth-child(2) > div > a.btn.btn-link.preview-article.hide-actions");
					articleTitle = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(1) > div:nth-child(2) > div > a.btn.btn-link.preview-article.hide-actions")).getText();
				}
			}
		} else {
			System.out.println("There aren't any reports!");
		}
		return articleTitle;
	}
	
	public void verifyAdvancedSearchPage(){
		Assert.assertTrue(allOfTheseWordsBox.isDisplayed());
		Assert.assertTrue(theExactPhraseBox.isDisplayed());
		Assert.assertTrue(anyOfTheseWordsBox.isDisplayed());
		Assert.assertTrue(noneOfTheseWordsBox.isDisplayed());
		Assert.assertTrue(geographiesAccordionGroup.isDisplayed());
		Assert.assertTrue(channelsAccordionGroup.isDisplayed());
		Assert.assertTrue(companiesAccordionGroup.isDisplayed());
		Assert.assertTrue(publicationDateAccordionGroup.isDisplayed());
		Assert.assertTrue(sortByAccordionGroup.isDisplayed());
		Assert.assertTrue(searchButtonTopPage.isDisplayed());
		Assert.assertTrue(searchButtonBottomPage.isDisplayed());
		Assert.assertTrue(clearFormLinkTopPage.isDisplayed());
		Assert.assertTrue(clearFormLinkBottomPage.isDisplayed());
	}
}


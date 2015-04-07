package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class SearchSteps extends AbstractSteps{

	private static final long serialVersionUID = 1L;

	@Step
	public void verifyBreadcrumbs(String breadcrumbString){
		homePageTopMenuPage().verifyBreadCrumb(breadcrumbString);
	}
	
	@StepGroup
	public void searchPerform(String threeCharacters){
		homePageHeaderPage().predictiveSearch(threeCharacters);
		homePageHeaderPage().clickSearch();
	}
	
	@Step
	public void verifyIfElementsArePresentPerPage(){
		searchPage().verifyIfElementsArePresentPerPage();
	}
	
	@Step
	public void clickOnInFirstParagraphButtonAndVerify(){
		searchPage().clickOnInFirstParagraphButton();
	}
	
	@Step
	public void clickOnInTitleOnlyButtonAndVerify(){
		searchPage().clickOnInTitleOnlyButton();
	}
	
	@Step 
	public void clickOnWithinLastSixMonthsButtonAndVerify(){
		searchPage().clickOnWithinLastSixMonthsButton();
	}
	
	@Step
	public void enterInvalidDataToPublicationDateAndVerify(String startDate, String endDate){
		searchPage().enterInvalidDataToPublicationDateAndVerify(startDate, endDate);
	}
	
	@Step
	public void enterStartDateGreaterThanEndDateToPublicationDateAndVerify(String startDate, String endDate){
		searchPage().enterStartDateGreaterThanEndDateToPublicationDateAndVerify(startDate, endDate);
	}
	
	@Step
	public void enterValidDataToPublicationDateAndVerify(String startDate, String endDate){
		searchPage().enterValidDataToPublicationDateAndVerify(startDate, endDate);
	}
	
	@Step
	public void untickNewsAndAnalysisAndReportsCheckBoxesAndVerify(){
		searchPage().untickNewsAndAnalysisAndReportsCheckBoxesAndVerify();
	}
	
	@Step
	public void checkOnIemFromGeographySection(int geographyNumber){
		searchPage().clickOnOneItemFromGeographySection(geographyNumber);
	}
	
	@Step
	public void checkOnIemFromChannelsSection(int channelNumber){
		searchPage().clickOnOneItemFromChannelsSection(channelNumber);
	}
	
	@Step
	public void checkOnIemFromCategoriesSection(int categoryNumber){
		searchPage().clickOnOneItemFromCategoriesSection(categoryNumber);
	}
	
	@Step
	public void checkOnIemFromCompaniesSection(int companyNumber){
		searchPage().clickOnOneItemFromCompaniesSection(companyNumber);
	}
	
	@Step
	public void sortByPublicationDateAndRelevanceAscendingOrder(){
		searchPage().sortByPublicationDateAndRelevanceAscendingOrder();
	}
	
	@Step
	public void sortByPublicationDateAscendingOrder(){
		searchPage().sortByPublicationDateAscendingOrder();
	}
	
	@Step
	public void sortByPublicationDateDescendingOrder(){
		searchPage().sortByPublicationDateDescendingOrder();
	}
	
	@Step
	public void sortByRelevace(){
		searchPage().sortByRelevace();
	}
	
	@Step
	public void clickOnShowMoreAndCompleteAnyOfTheseWordsBox(String word){
		searchPage().clickOnShowMoreAndCompleteAnyOfTheseWordsBox(word);
	}
	
	@Step
	public String clickOnSaveSearchButton(String saveTitle){
		return searchPage().clickOnSaveSearchButton(saveTitle);
	}
	
	@Step
	public void verifyShowMoreAndShowLessLinksFromRefineBySection(){
		homePageHeaderPage().clickSearch();
		searchPage().verifyShowMoreAndShowLessLinksFromRefineBySection();
	}
	
	@Step
	public void checkArticlesFromListing(int numbeOfArticlesToBeChecked){
		searchPage().checkArticlesFromListing(numbeOfArticlesToBeChecked);
	}
	
	@Step
	public void checkAllItemsDisplayedOnPage(){
		searchPage().checkAllItemsDisplayedOnPage();
	}
	
	@Step
	public void checkAdditionalItemAndVerify(){
		searchPage().checkAdditionalItemAndVerify();
	}
	
	@Step
	public void verifyTheNumberOfArticlesFromManageClipboardTitle(int numberOfArticles){
		searchPage().verifyTheNumberOfArticlesFromManageClipboardTitle(numberOfArticles);
	}
	
	@Step
	public void clickOnClipboardAndVerify(){
		searchPage().clickOnClipboardAndVerify();
	}
	
	@Step
	public void verifyTheNumberOfArticlesFromManageClipboardInsideIt(int numberOfArticles){
		searchPage().verifyTheNumberOfArticlesFromManageClipboardInsideIt(numberOfArticles);
	}
	
	@Step
	public void verifyWordIsPresentOnlyInTitle(int articleNumber, String word){
		searchPage().verifyWordIsPresentOnlyInTitle(articleNumber, word);
	}
	
	@Step
	public void verifyWordIsPresentInAllContentOfArticle(int articleNumber, String word){
		searchPage().verifyWordIsPresentInAllContentOfArticle(articleNumber, word);
	}
	
	@Step
	public void verifyWordIsPresentInFirstParagraphOfArticle(int articleNumber, String word){
		searchPage().verifyWordIsPresentInFirstParagraphOfArticle(articleNumber, word);
	}
	
	@Step
	public void clickOnPrintAllLinkAnCancel(){
		searchPage().clickOnPrintAllLinkAnCancel();
	}
	
	//TODO fix this
//	@Step
//	public void clickOnDownloadLink(){
//		searchPage().clickOnDownloadLink();
//	}
	
	@Step
	public void clickOnAddOnSavedContentButton(){
		searchPage().clickOnAddOnSavedContentButton();
	}
	
	@Step
	public void clickOnSaveIconArticleFromListEnterpriseUser(int articleNumber){
		searchPage().clickOnSaveIconArticleFromListEnterpriseUser(articleNumber);
	}
	
	@Step
	public void clickOnDownloadIconArticleFromListTrialUser(int articleNumber){
		searchPage().clickOnDownloadIconArticleFromListTrialUser(articleNumber);
	}
	
	@Step
	public void clickOnPrintIconArticleFromListTrialUser(int articleNumber){
		searchPage().clickOnPrintIconArticleFromListTrialUser(articleNumber);
	}
	
	@Step
	public void clickOnPrintAllLinkTrialUser(){
		searchPage().clickOnPrintAllLinkTrialUser();
	}
	
	@Step
	public void clickOnDownloadLinkTrialUser(){
		searchPage().clickOnDownloadLinkTrialUser();
	}
	
	@Step
	public void clickOnSaveSearchButtonEnterpriseUser(){
		searchPage().clickOnSaveSearchButtonEnterpriseUser();
	}
	
	@Step
	public void clickOnAddOnSavedContentButtonEnterpriseUser(){
		searchPage().clickOnAddOnSavedContentButtonEnterpriseUser();
	}
	
	@Step
	public void clickOnNonPermissionArticleAndClickOnCancel(int articleNumber){
		searchPage().clickOnNonPermissionArticleAndClickOnCancel(articleNumber);
	}
	
	@Step
	public void clickOnNonPermissionArticleAndClickOnContactAccountManagerButton(int articleNumber){
		searchPage().clickOnNonPermissionArticleAndClickOnContactAccountManagerButton(articleNumber);
	}
	
	@Step
	public void verifyNonSubscribedContentIsChecked(){
		searchPage().verifyNonSubscribedContentIsChecked();
	}
	
	@Step
	public void verifyIfTheItemFromGeographySectionIsChecked(int geographyNumber){
		searchPage().verifyIfTheItemFromGeographySectionIsChecked(geographyNumber);
	}
	
	@Step
	public void verifyIfTheItemFromChannelsSectionIsChecked(int channelNumber){
		searchPage().verifyIfTheItemFromChannelsSectionIsChecked(channelNumber);
	}
	
	@Step
	public void verifyIfTheItemFromCategoriesSectionIsChecked(int categoryNumber){
		searchPage().verifyIfTheItemFromCategoriesSectionIsChecked(categoryNumber);
	}
	
	@Step
	public void verifyIfTheItemFromCompaniesSectionIsChecked(int companyNumber){
		searchPage().verifyIfTheItemFromCompaniesSectionIsChecked(companyNumber);
	}
	
	@Step
	public void verifySortByPublicationDateAndRelevanceAscendingOrder(){
		searchPage().verifySortByPublicationDateAndRelevanceAscendingOrder();
	}
	
	@Step
	public void verifySortByPublicationDateAscendingOrder(){
		searchPage().verifySortByPublicationDateAscendingOrder();
	}
	
	@Step
	public void verifySortByPublicationDateDescendingOrder(){
		searchPage().verifySortByPublicationDateDescendingOrder();
	}
	
	@Step
	public void verifySortByRelevace(){
		searchPage().verifySortByRelevace();
	}
	
	@Step
	public void verifyClipboardAfterAddedAllArticlesOnSavedContent(){
		searchPage().verifyClipboardAfterAddedAllArticlesOnSavedContent();
	}
	
	@Step
	public void verifyIfCorrectContentTypeIsChecked(String contentType){
		searchPage().verifyIfCorrectContentTypeIsChecked(contentType);
	}
	
	//TODO fix this
//	@Step
//	public void clickOnDownloadIconArticleFromList(int articleNumber){
//		searchPage().clickOnDownloadIconArticleFromList(articleNumber);
//	}
	
	@Step
	public void clickOnPrintIconArticleFromList(int articleNumber){
		searchPage().clickOnPrintIconArticleFromList(articleNumber);
	}
	
	@Step
	public void clickOnEmailIconArticleFromList(int articleNumber){
		searchPage().clickOnEmailIconArticleFromList(articleNumber);
	}
	
	@Step
	public void clickOnSaveIconArticleFromList(int articleNumber){
		searchPage().clickOnSaveIconArticleFromList(articleNumber);
	}
	
	@Step
	public void verifyRefineBySection(String word){
		searchPage().verifyRefineBySection(word);
	}
	
	@Step
	public void checkOnePublicationDate(String dateValue){
		searchPage().checkOnePublicationDate(dateValue);
	}
	
	@Step
	public void verifyPublicationDateFilter(String dateValue){
		searchPage().verifyPublicationDateFilter(dateValue);
	}
}

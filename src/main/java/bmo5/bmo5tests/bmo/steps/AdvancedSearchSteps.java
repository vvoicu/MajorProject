package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class AdvancedSearchSteps extends AbstractSteps{

	private static final long serialVersionUID = 1L;

	@StepGroup
	public void completeAllOfTheseWordsBoxAndClickOnSearchButton(String characters, String breadcrumbsAdvancedSearch, String allWordsLabel){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().completeAllOfTheseWordsBoxAndClickOnSearchButton(characters);
		searchPage().verifyIfRefineBySectionContainsTheCorrectLabel(allWordsLabel);
		searchPage().verifyIfRefineBySectionContainsTheWordFromAdvancedSearch(characters);
	}
	
	@StepGroup
	public void completeAllOfTheseWordsBoxChangeThePublicationDateAnsClickOnSearchButton(String word, String breadcrumbsAdvancedSearch, String allWordsLabel){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().completeAllOfTheseWordsBoxChangeThePublicationDateAnsClickOnSearchButton(word);
		searchPage().verifyIfRefineBySectionContainsTheCorrectLabel(allWordsLabel);
		searchPage().verifyIfRefineBySectionContainsTheWordFromAdvancedSearch(word);
	}
	
	@StepGroup
	public void completeAllOfTheseWordsBoxStartAndEndDateWithInvalidDataAndVerify(String word, String startDate, String endDate, String breadcrumbsAdvancedSearch){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().completeAllOfTheseWordsBoxStartAndEndDateWithInvalidDataAndVerify(word, startDate, endDate);
	}
	
	@StepGroup
	public void completeTheExactPhraseBoxCheckOneContentTypeAndClickOnSearchButton(String word, String contentTypeValue, String breadcrumbsAdvancedSearch, String exactPhraseLabel){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().completeTheExactPhraseBoxCheckOneContentTypeAndClickOnSearchButton(word, contentTypeValue);
		searchPage().verifyIfRefineBySectionContainsTheCorrectLabel(exactPhraseLabel);
		searchPage().verifyIfRefineBySectionContainsTheWordFromAdvancedSearch(word);
		searchPage().verifyIfCorrectContentTypeIsChecked(contentTypeValue);
	}
	
	@StepGroup
	public void completeAnyOfTheseWordsBoxAndClickOnSearchButton(String word, String breadcrumbsAdvancedSearch, String anyWordsLabel){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().completeAnyOfTheseWordsBoxAndClickOnSearchButton(word);
		searchPage().verifyIfRefineBySectionContainsTheCorrectLabel(anyWordsLabel);
		searchPage().verifyIfRefineBySectionContainsTheWordFromAdvancedSearch(word);
	}
	
	@StepGroup
	public void completeNoneOfTheseWordsBoxAndClickOnSearchButton(String word, String breadcrumbsAdvancedSearch, String noneWordLabel){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().completeNoneOfTheseWordsBoxAndClickOnSearchButton(word);
		searchPage().verifyIfRefineBySectionContainsTheCorrectLabel(noneWordLabel);
		searchPage().verifyIfRefineBySectionContainsTheWordFromAdvancedSearch(word);
	}
	
	@StepGroup
	public void completeAllOfTheseWordsBoxChangeSortingToRelevanceAndClickOnSearchButton(String word, String breadcrumbsAdvancedSearch, String allWordsLabel){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().completeAllOfTheseWordsBoxChangeSortingToRelevanceAndClickOnSearchButton(word);
		searchPage().verifyIfRefineBySectionContainsTheCorrectLabel(allWordsLabel);
		searchPage().verifyIfRefineBySectionContainsTheWordFromAdvancedSearch(word);
		searchPage().verifySortByRelevace();
	}
	
	@StepGroup
	public void completeAllOfTheseWordsBoxChangeSortingToPublicationOnlyAndClickOnSearchButton(String word, String breadcrumbsAdvancedSearch, String allWordsLabel){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().completeAllOfTheseWordsBoxChangeSortingToPublicationOnlyAndClickOnSearchButton(word);
		searchPage().verifyIfRefineBySectionContainsTheCorrectLabel(allWordsLabel);
		searchPage().verifyIfRefineBySectionContainsTheWordFromAdvancedSearch(word);
		searchPage().verifySortByPublicationDateDescendingOrder();
	}
	
	@StepGroup
	public void completeGeographyTitleMoveItToRightPanelAndVerify(int geographyNumber, String word, String breadcrumbsAdvancedSearch){ 
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		String geography = advancedSearchPage().completeGeographyTitleMoveItToRightPanelAndVerify(geographyNumber, word);
		String geographyId = advancedSearchPage().returnTheGeographyIdFromRightHandPanel();
		advancedSearchPage().clickOnSearchButton();
		searchPage().verifyIfGeographyIsChecked(geography, geographyId);
	}
	
	@StepGroup
	public void completeChannelTitleCheckChannelsAndVerify(int channelNumber, String word, String breadcrumbsAdvancedSearch){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		String channel = advancedSearchPage().completeChannelTitleCheckChannelsAndVerify(channelNumber, word);
		String channelId = advancedSearchPage().returnTheChannelIdChecked();
		advancedSearchPage().clickOnSearchButton();
		searchPage().verifyIfChannelIsChecked(channel, channelId);
	}
	
	@StepGroup
	public void completeCompaniesTitleMoveItToRightPanelAndVerify(int companyNumber, String word, String breadcrumbsAdvancedSearch){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		String company = advancedSearchPage().completeCompaniesTitleMoveItToRightPanelAndVerify(companyNumber, word);
		String companyId = advancedSearchPage().returnTheCompanyIdFromRightHandPanel();
		advancedSearchPage().clickOnSearchButton();
		searchPage().verifyIfCompanyIsChecked(company, companyId);
	}
	
	@StepGroup
	public void moveAllGeographiesToRightPanelClearSectionAndVerify(String breadcrumbsAdvancedSearch){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().moveAllGeographiesToRightPanelClearSectionAndVerify();
	}
	
	@StepGroup
	public void checkAllChannelsClearSectionAndVerify(String breadcrumbsAdvancedSearch){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().checkAllChannelsClearSectionAndVerify();
	}
	
	@StepGroup
	public void moveAllCompaniesToRightPanelClearSectionAndVerify(String breadcrumbsAdvancedSearch){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().moveAllCompaniesToRightPanelClearSectionAndVerify();
	}
	
	@StepGroup
	public void verifyPublicationDateErrorMessages(String startDate, String endDate, String startDateGraterThanEndDate, String endDateSmallerThanStartDate, String breadcrumbsAdvancedSearch){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().verifyPublicationDateErrorMessages(startDate, endDate, startDateGraterThanEndDate, endDateSmallerThanStartDate);
	}
	
	@StepGroup
	public void completeSomeSectionsClearFormAndVerify(String startDate, String endDate, String word, String breadcrumbsAdvancedSearch){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().completeSomeSectionsClearFormAndVerify(startDate, endDate, word);
	}
	
	@StepGroup
	public void completeAllSectionClearFormAndVerifyFromSaveSearchPage(String word, String searchTitle, String breadcrumbsAdvancedSearch){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().completeAllSectionClearFormAndVerifyFromSaveSearchPage(word, searchTitle);
	}
	
	@StepGroup
	public String completeAllSectionSaveSearchAndVerifyFromSaveSearchPage(String word, String breadcrumbsAdvancedSearch){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		return advancedSearchPage().completeAllSectionSaveSearchAndVerifyFromSaveSearchPage(word);
	}
	
	//TODO fix this
//	@StepGroup
//	public void completeAllSectionSaveSearchWithAnExistingNameAndVerifyFromSaveSearchPage(String word, String breadcrumbsAdvancedSearch){
//		homePageHeaderPage().clickAdvancedSearch();
//		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
//		advancedSearchPage().verifyAdvancedSearchPage();
//		advancedSearchPage().completeAllSectionSaveSearchWithAnExistingNameAndVerifyFromSaveSearchPage(word);
//	}
//	
//	@StepGroup
//	public void completeAllSectionSaveSearchWithAnExistingNameAndVerifyFromSaveSearchPageAddNewSavedSearch(String word){
//		advancedSearchPage().completeAllSectionSaveSearchWithAnExistingNameAndVerifyFromSaveSearchPage(word);
//	}
	
	@StepGroup
	public void clickOnSearchButton(String breadcrumbsAdvancedSearch){
		homePageHeaderPage().clickAdvancedSearch();
		homePageHeaderPage().verifyBreadCrumbs(breadcrumbsAdvancedSearch);
		advancedSearchPage().verifyAdvancedSearchPage();
		advancedSearchPage().clickOnSearchButton();
	}
	
	@Step
	public void checkNonSubscribedContentBox(){
		advancedSearchPage().checkNonSubscribedContentBox();
	}
	
	@Step
	public String clickOnPreviewArticleFromList(int articleNumber){
		return advancedSearchPage().clickOnPreviewArticleFromList(articleNumber);
	}
	
	@Step
	public void verifySaveSearchPage(){
		advancedSearchPage().verifySaveSearchPage();
	}
	
	@Step
	public void verifyAdvancedSearchPage(){
		advancedSearchPage().verifyAdvancedSearchPage();
	}
}

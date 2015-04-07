package bmo5.bmo5tests.tests.bmo;

import junit.framework.TestCase;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import bmo5.bmo5tests.bmo.steps.AdvancedSearchSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.SearchSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Header.AdvancedSearch.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_004_1_AdvancedSearch.csv", separator=',')

public class Test_004_1_AdvancedSearch extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageHeaderSteps homeSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public AdvancedSearchSteps advancedSearchSteps;
	@Steps
	public SearchSteps searchSteps;

	public String username, password, characters, word, startDate, endDate, endDateSmaller, startDateGrater, invalidStartDate, invalidEndDate, geographyCharacters, channelCharacters, companyCharacters, contentTypeValue, breadcrumbsAdvancedSearch, allWordsLabel, exactPhraseLabel, anyWordsLabel, noneWordLabel;
	public int geographyNumber, channelNumber, companyNumber;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCharacters(String characters) {
		this.characters = characters;
	}
	public void setGeographyNumber(int geographyNumber) {
		this.geographyNumber = geographyNumber;
	}
	public void setChannelNumber(int channelNumber) {
		this.channelNumber = channelNumber;
	}
	public void setCompanyNumber(int companyNumber) {
		this.companyNumber = companyNumber;
	}
	
	public void setWord(String word){
		this.word = word;
	}
	
	public void setEndDateSmaller(String endDateSmaller){
		this.endDateSmaller = endDateSmaller;
	}
	
	public void setStartDateGrater(String startDateGrater){
		this.startDateGrater = startDateGrater;
	}
	
	public void setInvalidEndDate(String invalidEndDate){
		this.invalidEndDate = invalidEndDate;
	}
	
	public void setGeographyCharacters(String geographyCharacters){
		this.geographyCharacters = geographyCharacters;
	}
	
	public void setChannelCharacters(String channelCharacters){
		this.channelCharacters = channelCharacters;
	}
	
	public void setCompanyCharacters(String companyCharacters){
		this.companyCharacters = companyCharacters;
	}
	
	public void setInvalidStartDate(String invalidStartDate){
		this.invalidStartDate = invalidStartDate;
	}
	
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
	
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	@Test
	public void test_004_01_AdvancedSearch() {
		loginSteps.performLogin(username, password);
		advancedSearchSteps.completeAllOfTheseWordsBoxAndClickOnSearchButton(characters, breadcrumbsAdvancedSearch, allWordsLabel);
		advancedSearchSteps.completeAllOfTheseWordsBoxChangeThePublicationDateAnsClickOnSearchButton(word, breadcrumbsAdvancedSearch, allWordsLabel);
		advancedSearchSteps.completeAllOfTheseWordsBoxStartAndEndDateWithInvalidDataAndVerify(word, invalidStartDate, invalidEndDate, breadcrumbsAdvancedSearch);
		advancedSearchSteps.completeTheExactPhraseBoxCheckOneContentTypeAndClickOnSearchButton(word, contentTypeValue, breadcrumbsAdvancedSearch, exactPhraseLabel); // contentTypeValue = content_all_content or content_in_title or content_in_first_paragraph
		advancedSearchSteps.completeAnyOfTheseWordsBoxAndClickOnSearchButton(word, breadcrumbsAdvancedSearch, anyWordsLabel);
		advancedSearchSteps.completeNoneOfTheseWordsBoxAndClickOnSearchButton(word, breadcrumbsAdvancedSearch, noneWordLabel); 
		advancedSearchSteps.completeAllOfTheseWordsBoxChangeSortingToRelevanceAndClickOnSearchButton(word, breadcrumbsAdvancedSearch, allWordsLabel); 
		advancedSearchSteps.completeAllOfTheseWordsBoxChangeSortingToPublicationOnlyAndClickOnSearchButton(word, breadcrumbsAdvancedSearch, allWordsLabel); 
		advancedSearchSteps.completeGeographyTitleMoveItToRightPanelAndVerify(geographyNumber, geographyCharacters, breadcrumbsAdvancedSearch);
		advancedSearchSteps.completeChannelTitleCheckChannelsAndVerify(channelNumber, channelCharacters, breadcrumbsAdvancedSearch);
		advancedSearchSteps.completeCompaniesTitleMoveItToRightPanelAndVerify(companyNumber, companyCharacters, breadcrumbsAdvancedSearch);
		advancedSearchSteps.moveAllGeographiesToRightPanelClearSectionAndVerify(breadcrumbsAdvancedSearch);
		advancedSearchSteps.checkAllChannelsClearSectionAndVerify(breadcrumbsAdvancedSearch);
		advancedSearchSteps.moveAllCompaniesToRightPanelClearSectionAndVerify(breadcrumbsAdvancedSearch);
		advancedSearchSteps.verifyPublicationDateErrorMessages(invalidStartDate, invalidEndDate, startDateGrater, endDateSmaller, breadcrumbsAdvancedSearch);
		advancedSearchSteps.completeSomeSectionsClearFormAndVerify(startDate, endDate, word, breadcrumbsAdvancedSearch);
	}
}

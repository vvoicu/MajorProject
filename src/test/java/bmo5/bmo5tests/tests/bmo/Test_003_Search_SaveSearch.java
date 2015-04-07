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

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.MncMdgSteps;
import bmo5.bmo5tests.bmo.steps.SavedContentSteps;
import bmo5.bmo5tests.bmo.steps.SearchSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageTopMenuSteps;
import bmo5.bmo5tests.bmo.steps.homepage.SpecialReportsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Header.Search.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_003_SearchPage.csv", separator=',')

public class Test_003_Search_SaveSearch extends TestCase{
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	@Steps
	public HomePageTopMenuSteps homePageTopMenuSteps;
	@Steps
	public SearchSteps searchSteps;
	@Steps
	public SpecialReportsSteps specialReportsSteps;
	@Steps
	public SingleArticleSteps singleArticleSteps;
	@Steps
	public SavedContentSteps savedContentSteps;
	@Steps
	public MncMdgSteps mncMdgSteps;
	
	public String username, password, threeCharacters, saveTitle, word, itemsPerPage, startDate, endDate, startDateGrater, endDateSmaller, invalidStartDate, invalidEndDate, breadcrumbString, savedSearchName, savedSearchBreadcrumbs, dateValue;
	int geographyNumber, channelNumber, categoryNumber, companyNumber, articleNumber;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setThreeCharacters(String threeCharacters) {
		this.threeCharacters = threeCharacters;
	}
	public void setGeographyNumber(int geographyNumber){
		this.geographyNumber = geographyNumber;
	}
	
	public void setChannelNumber(int channelNumber){
		this.channelNumber = channelNumber;
	}
	
	public void setCategoryNumber(int categoryNumber){
		this.categoryNumber = categoryNumber;
	}
	
	public void setCompanyNumber(int companyNumber){
		this.companyNumber = companyNumber;
	}
	
	public void setArticleNumber(int articleNumber){
		this.articleNumber = articleNumber;
	}
	
	public void setSaveTitle(String saveTitle){
		this.saveTitle = saveTitle;
	}
	
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
	
	public void setWord(String word){
		this.word = word;
	}
	
	public void setEndDate(String endDate){
		this.endDate = endDate;
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
	
	public void setInvalidStartDate(String invalidStartDate){
		this.invalidStartDate = invalidStartDate;
	}
	
	@Test
	public void test_003_SearchPage() {
		loginSteps.performLogin(username, password);
		homePageHeaderSteps.clickOnSearchButtonAndVerify(breadcrumbString);
		searchSteps.checkOnIemFromGeographySection(geographyNumber);
		searchSteps.verifyIfTheItemFromGeographySectionIsChecked(geographyNumber);
		searchSteps.checkOnIemFromChannelsSection(channelNumber);
		searchSteps.verifyIfTheItemFromChannelsSectionIsChecked(channelNumber);
		searchSteps.checkOnIemFromCategoriesSection(categoryNumber);
		searchSteps.verifyIfTheItemFromCategoriesSectionIsChecked(categoryNumber);
		searchSteps.checkOnIemFromCompaniesSection(companyNumber);
		searchSteps.verifyIfTheItemFromCompaniesSectionIsChecked(companyNumber);
		
		savedSearchName = searchSteps.clickOnSaveSearchButton(saveTitle);
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.clickOnSavedSearchesFromLeftPanel();
		mncMdgSteps.verifySavedMNCInSavedCOntent(savedSearchBreadcrumbs, savedSearchName);
		searchSteps.verifyIfTheItemFromGeographySectionIsChecked(geographyNumber);
		searchSteps.verifyIfTheItemFromChannelsSectionIsChecked(channelNumber);
		searchSteps.verifyIfTheItemFromCategoriesSectionIsChecked(categoryNumber);
		searchSteps.verifyIfTheItemFromCompaniesSectionIsChecked(companyNumber);
		
		homePageHeaderSteps.clickOnSearchButtonAndVerify(breadcrumbString);
		searchSteps.clickOnShowMoreAndCompleteAnyOfTheseWordsBox(word);
		searchSteps.checkOnePublicationDate(dateValue);
		savedSearchName = searchSteps.clickOnSaveSearchButton(saveTitle);
		homePageHeaderSteps.clickOnSavedContent();
		savedContentSteps.clickOnSavedSearchesFromLeftPanel();
		mncMdgSteps.verifySavedMNCInSavedCOntent(savedSearchBreadcrumbs, savedSearchName);
		searchSteps.verifyRefineBySection(word);
		searchSteps.verifyPublicationDateFilter(dateValue);
	}
}

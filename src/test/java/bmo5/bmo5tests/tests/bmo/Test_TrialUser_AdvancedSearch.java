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
import bmo5.bmo5tests.bmo.steps.EmailPopUpWindowSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.PreviewArticleWindowSteps;
import bmo5.bmo5tests.bmo.steps.SearchSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Trial.Header.AdvancedSearch.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_TrialUser_AdvancedSearch.csv", separator = ',')

public class Test_TrialUser_AdvancedSearch extends TestCase {
	
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public HomePageHeaderSteps homePageHeaderSteps;
	
	@Steps
	public SearchSteps searchSteps;
	
	@Steps
	public SingleReportSteps singleReportSteps;
	
	@Steps
	public PreviewArticleWindowSteps previewArticleWindowSteps;
	
	@Steps
	public SingleArticleSteps singleArticleSteps;
	
	@Steps
	public AdvancedSearchSteps advancedSearchSteps;
	
	@Steps
	public EmailPopUpWindowSteps emailPopUpWindowSteps;
	
	String username, password, breadcrumbString, saveTitle;
	int articleNumber, numbeOfArticlesToBeChecked;
	
	@Test
	public void test_TrialUser_AdvancedSearch() {
		loginSteps.performLogin(username, password);		
		homePageHeaderSteps.clickOnSearchButtonAndVerify(breadcrumbString);
		
		searchSteps.clickOnSaveSearchButton(saveTitle);
		
		searchSteps.clickOnPrintIconArticleFromListTrialUser(articleNumber);
		searchSteps.clickOnDownloadIconArticleFromListTrialUser(articleNumber);
		searchSteps.clickOnSaveIconArticleFromList(articleNumber);
		searchSteps.clickOnEmailIconArticleFromList(articleNumber);
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		
		advancedSearchSteps.clickOnPreviewArticleFromList(articleNumber);
		//TODO fix this
//		previewArticleWindowSteps.clickOnPrintIconPreviewArticleTrialUser();
		advancedSearchSteps.clickOnPreviewArticleFromList(articleNumber);
		//TODO fix this
//		previewArticleWindowSteps.clickOnDownloadIconPreviewArticleTrialUser();
		advancedSearchSteps.clickOnPreviewArticleFromList(articleNumber);
		previewArticleWindowSteps.clickOnSaveIconPreviewArticle();
		//TODO fix this
//		previewArticleWindowSteps.clickOnEmailIconPreviewArticle();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		
		singleReportSteps.clickASpecialReportsFromListing(articleNumber);
		singleArticleSteps.clickOnPrintButtonArticleTrialUser();
		singleArticleSteps.clickOnDownloadButtonArticleTrialUser();
		singleArticleSteps.clickOnSaveButton();
		singleArticleSteps.clickOnEmailIconArticlePage();
		emailPopUpWindowSteps.verifyEmailWindowElements();
		emailPopUpWindowSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowSteps.closeEmailWondow();
		singleArticleSteps.clickOnBackToPreviousPage();
		
		searchSteps.checkArticlesFromListing(numbeOfArticlesToBeChecked);
		searchSteps.verifyTheNumberOfArticlesFromManageClipboardTitle(numbeOfArticlesToBeChecked);
		searchSteps.clickOnClipboardAndVerify();
		searchSteps.verifyTheNumberOfArticlesFromManageClipboardInsideIt(numbeOfArticlesToBeChecked);
		searchSteps.clickOnPrintAllLinkTrialUser();
		searchSteps.clickOnDownloadLinkTrialUser();
		searchSteps.clickOnAddOnSavedContentButton();
	}
}

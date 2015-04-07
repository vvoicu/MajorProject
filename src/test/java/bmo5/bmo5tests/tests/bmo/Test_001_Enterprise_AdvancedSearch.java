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

import bmo5.bmo5tests.bmo.steps.EmailPopUpWindowSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.PreviewArticleWindowSteps;
import bmo5.bmo5tests.bmo.steps.SearchSteps;
import bmo5.bmo5tests.bmo.steps.SingleArticleSteps;
import bmo5.bmo5tests.bmo.steps.SingleReportSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePageHeaderSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Enterprise.Header.AdvancedSearch.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enterprise_AdvancedSearch.csv", separator = ',')

public class Test_001_Enterprise_AdvancedSearch extends TestCase {
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST_IP)
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
	public EmailPopUpWindowSteps emailPopUpWindowsSteps;
	
	String username, password, breadcrumbString, fileName;
	int articleNumber, numbeOfArticlesToBeChecked;
	
	@Test
	public void test_001_Enterprise_AdvancedSearch() {
		homePageHeaderSteps.clickOnSearchButtonAndVerify(breadcrumbString);
		searchSteps.clickOnSaveSearchButtonEnterpriseUser();
		//TODO fix this
//		searchSteps.clickOnDownloadIconArticleFromList(articleNumber);
		searchSteps.clickOnSaveIconArticleFromListEnterpriseUser(articleNumber);
		searchSteps.clickOnPrintIconArticleFromList(articleNumber);
		searchSteps.clickOnEmailIconArticleFromList(articleNumber);
		emailPopUpWindowsSteps.verifyEmailWindowElements();
		emailPopUpWindowsSteps.verifySubjectIsEmptyForEnterprise();
		emailPopUpWindowsSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowsSteps.closeEmailWondow();
		
		fileName = singleArticleSteps.clickOnPreviewArticleSearchResultst(articleNumber);
		//TODO fix this
//		previewArticleWindowSteps.clickOnDownloadIconPreviewArticleFromSearch(fileName);
		previewArticleWindowSteps.clickOnSavePreviewArticleEnterpriseUser();
		singleArticleSteps.clickOnPreviewArticleSearchResultst(articleNumber);
		//TODO fix this
//		previewArticleWindowSteps.clickOnPrintIconPreviewArticle(fileName);
//		previewArticleWindowSteps.clickOnEmailIconPreviewArticle();
		emailPopUpWindowsSteps.verifyEmailWindowElements();
		emailPopUpWindowsSteps.verifySubjectIsEmptyForEnterprise();
		emailPopUpWindowsSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowsSteps.closeEmailWondow();
		
		fileName = singleReportSteps.clickASpecialReportsFromListing(articleNumber);
		//TODO fix this
//		singleArticleSteps.clickOnDownloadIconArticle(fileName);
		singleArticleSteps.clickOnSaveButtonArticleEnterpriseUser();
		singleArticleSteps.clickOnPrintIconArticle(fileName);
		singleArticleSteps.clickOnEmailIconArticlePage();
		emailPopUpWindowsSteps.verifyEmailWindowElements();
		emailPopUpWindowsSteps.verifySubjectIsEmptyForEnterprise();
		emailPopUpWindowsSteps.submitWithoutCompletingFieldsAndVerify();
		emailPopUpWindowsSteps.closeEmailWondow();
		singleArticleSteps.clickOnBackToPreviousPage();
		
		searchSteps.checkArticlesFromListing(numbeOfArticlesToBeChecked);
		searchSteps.verifyTheNumberOfArticlesFromManageClipboardTitle(numbeOfArticlesToBeChecked);
		searchSteps.clickOnClipboardAndVerify();
		searchSteps.verifyTheNumberOfArticlesFromManageClipboardInsideIt(numbeOfArticlesToBeChecked);
		searchSteps.clickOnPrintAllLinkAnCancel();
		searchSteps.clickOnClipboardAndVerify();
		//TODO fix this
//		searchSteps.clickOnDownloadLink();
		searchSteps.checkArticlesFromListing(numbeOfArticlesToBeChecked);
		searchSteps.verifyTheNumberOfArticlesFromManageClipboardTitle(numbeOfArticlesToBeChecked);
		searchSteps.clickOnClipboardAndVerify();
		searchSteps.verifyTheNumberOfArticlesFromManageClipboardInsideIt(numbeOfArticlesToBeChecked);
		searchSteps.clickOnAddOnSavedContentButtonEnterpriseUser();
	}
}

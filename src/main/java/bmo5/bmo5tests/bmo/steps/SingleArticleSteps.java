package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class SingleArticleSteps extends AbstractSteps {
	private static final long serialVersionUID = -129669637435510047L;

	@StepGroup
	public void singleArticleActions(int articleNumber, String articleName) {
		clickOnSaveButton();
		clickOnPrintIconArticle(articleName);
	//TODO fix this
		//	clickOnDownloadIconArticle(articleName);
		clickOnBackToPreviousPage();
		clickSingleArticle(articleNumber);
	}

	@StepGroup
	public void navigateLatestNews(String itemsPerPage) {
		latestNewsAnotherPageAnotherPage();
		latestNewsNextPage();
		latestNewsPreviousPage();
		latestNewsLastPage();
		latestNewsFirstPage();
		selectItemsPerPage(itemsPerPage);
	}
	
	@Step
	public void clickOnSaveButton(){
		singleArticlePage().clickOnSaveButtonArticle();
//		singleArticlePage().verifySaveButtonArticle();
	}
	
	@Step
	public void clickOnPrintIconArticle(String articleName){
		singleArticlePage().clickOnPrintButtonArticle(articleName);
	}
	
	@Step
	public void clickOnPrintIconReport(String articleName){
		singleArticlePage().clickOnPrintButtonReport(articleName);
	}

	//	TODO fix this	
//	@Step
//	public void clickOnDownloadIconArticle(String fileName){
//		singleArticlePage().clickOnDownloadButtonArticle(fileName);
//	}
	
	@Step
	public void clickOnBackToPreviousPage(){
		singleArticlePage().clickOnBackToPreviousPage();
	}
	
	@StepGroup
	public String clickSingleArticle(int articleNumber) {
		return singleArticlePage().clickArticle(articleNumber);
	}
	
	@Step
	public void verifyArticleBreadcrumb(String text){
		singleArticlePage().verifyBreadCrumbArticle(text);
	}
	
	@Step
	public void verifyArticleTitle(String text){
		singleArticlePage().verifyTitle(text);
	}
	
	@Step
	public void clickOnPreviewFirstArticle(){
		singleArticlePage().clickOnPreviewOfFirstArticleButton();
	}
	
	@Step
	public String clickPageNumber(int pageNumber) {
		return singleArticlePage().clickPageNumber(pageNumber);
	}
	
	@Step
	public void latestNewsAnotherPageAnotherPage() {
		singleArticlePage().clickOnLatestNewsAnotherPage();
	}
	
	@Step
	public void latestNewsNextPage() {
		singleArticlePage().clickOnLatestNewsNextPage();
	}
	
	@Step
	public void latestNewsPreviousPage() {
		singleArticlePage().clickLatestNewsPreviousPage();
	}
	
	@Step
	public void latestNewsLastPage() {
		singleArticlePage().clickOnLatestNewsLastPage();
	}
	
	@Step
	public void latestNewsFirstPage() {
		singleArticlePage().clickLatestNewsFirstPage();
	}
	
	@Step
	public void selectItemsPerPage(String value) {
		singleArticlePage().selectItemsPerPage(value);
	}
	
	@Step
	public String clickOnPreviewArticle(int articleNumber){
		return singleArticlePage().clickOnPreviewArticle(articleNumber);
	}
	
	@Step
	public void clickOnSaveArticleFromListing(int articleNumber){
		singleArticlePage().clickOnSaveIconArticleFromList(articleNumber);
	}

	@Step
	public void clickOnPrintArticleFromListing(int articleNumber){
		singleArticlePage().clickOnPrintIconArticleFromList(articleNumber);
	}

	//TODO fix this	
//	@Step
//	public void clickOnDownloadArticleFromListing(int articleNumber){
//		singleArticlePage().clickOnDownloadIconArticleFromList(articleNumber);
//	}
	
	@Step
	public void clickOnEmailArticleFromListing(int articleNumber){
		singleArticlePage().clickOnEmailIconArticleFromList(articleNumber);
	}	
	
	@Step
	public String getArticleNameFromBreadcrumbs(){
		return singleArticlePage().getArticleNameFromBreadcrums();
	}
	
	@Step
	public String getReportNameFromBreadcrumbs(){
		return singleArticlePage().getReportNameFromBreadcrums();
	}
	
	@Step
	public void clickOnEmailIconArticlePage(){
		singleArticlePage().clickOnEmailButtonArticle();
	}
	
	@Step
	public void clickOnSaveButtonArticleEnterpriseUser() {
		singleArticlePage().clickOnSaveButtonArticleEnterpriseUser();
	}
	
	@Step
	public void clickOnPrintButtonArticleTrialUser() {
		singleArticlePage().clickOnPrintButtonArticleTrialUser();
	}
	
	@Step
	public void clickOnDownloadButtonArticleTrialUser() {
		singleArticlePage().clickOnDownloadButtonArticleTrialUser();
	}

	@Step
	public void clickOnViewFullReportButtonArticleTrialUser() {
		singleArticlePage().clickOnViewFullReportButtonArticleTrialUser();
	}
	
	@Step
	public void clickOnSaveIconArticleFromListEnterpriseUser(int articleNumber){
		singleArticlePage().clickOnSaveIconArticleFromListEnterpriseUser(articleNumber);
	}
	
	@Step
	public void clickOnPrintIconArticleFromListTrialUser(int articleNumber){
		singleArticlePage().clickOnPrintIconArticleFromListTrialUser(articleNumber);
	}
	
	@Step
	public void clickOnDownloadIconArticleFromListTrialUser(int articleNumber){
		singleArticlePage().clickOnDownloadIconArticleFromListTrialUser(articleNumber);
	}
	
	@Step
	public String clickOnPrintIconArticleFromListTrialUserAndVerifyContactAccountManager(int articleNumber){
		return singleArticlePage().clickOnPrintIconArticleFromListTrialUserAndVerifyContactAccountManager(articleNumber);
	}
	
	@Step
	public String clickOnDownloadIconArticleFromListTrialUserAndVerifyContactAccountManager(int articleNumber){
		return singleArticlePage().clickOnDownloadIconArticleFromListTrialUserAndVerifyContactAccountManager(articleNumber);
	}
	
	@Step
	public String clickOnPreviewArticleSearchResultst(int articleNumber){
		return singleArticlePage().clickOnPreviewArticleSearchResultst(articleNumber);
	}
	
	@Step
	public void verifyIfActionIconsAreEnabled(){
		singleArticlePage().verifyIfActionIconsAreEnabled();
	}
//	TODO fix this
//	@Step
//	public void clickOnViewFullReportButtonArticle() {
//		singleArticlePage().clickOnViewFullReportButtonArticle();
//	}

	@Step
	public void verifyMediaActionsForReportsOnHover(int articleNumber) {
		singleArticlePage().verifyMediaActionsForReportsOnHover(articleNumber);
		
	}

	@Step
	public void verifyMediaActionsForTrialOnHover(int articleNumber) {
		singleArticlePage().verifyMediaActionsForTrialOnHover(articleNumber);
		
	}

	@Step
	public void verifyMediaActionsForTrialInPreview() {
		singleArticlePage().verifyMediaActionsForTrialInPreview();
		
	}

	@Step
	public void verifyMediaActionsForTrialInDetailArticle() {
		singleArticlePage().verifyMediaActionsForTrialInDetailArticle();
		
	}

	@Step
	public void verifySaveForTrial(int reportNumber,int articleNumber) {
		singleArticlePage().verifySaveForTrial(reportNumber,articleNumber);
		
	}

	@Step
	public void clickOnEmailIcon(int articleNumber) {
		singleArticlePage().clickOnEmail(articleNumber);
		
	}

	@Step
	public void verifySaveForTrialArticles(int articleNumber) {
		singleArticlePage().verifySaveForTrialArticles(articleNumber);
		
	}
}

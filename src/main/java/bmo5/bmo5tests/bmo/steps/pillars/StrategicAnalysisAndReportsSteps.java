package bmo5.bmo5tests.bmo.steps.pillars;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.NavigationItems;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class StrategicAnalysisAndReportsSteps extends AbstractSteps {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5558919734146206583L;

	@StepGroup
	public void navigateThroughPagesSteps() {
		nagivateToSecondPage();
		nagivateToNextPage();
		nagivateToPreviousPage();
		nagivateToLastPage();
		nagivateToFirstPage();
	}
	
	@StepGroup
	public void navigateThroughPagesPastVersions(){
		//strategicAnalysisAndReportsPage().navigateToItemPastVersions(NavigationItems.Last);
		strategicAnalysisAndReportsPage().navigateToItemPastVersions(NavigationItems.Five);
		strategicAnalysisAndReportsPage().navigateToItemPastVersions(NavigationItems.First);
		strategicAnalysisAndReportsPage().navigateToItemPastVersions(NavigationItems.Next);
		strategicAnalysisAndReportsPage().navigateToItemPastVersions(NavigationItems.Last);
		strategicAnalysisAndReportsPage().navigateToItemPastVersions(NavigationItems.Previous);
	}
	
	@Step
	public void clickOnLatestReportsArticle(int articleNumber) {
		strategicAnalysisAndReportsPage().clickLatestReportsArticle(articleNumber);
	}
	
	
	//TODO fix this
//	@Step
//	public void clickCountryReportsFirstArticle(int articleNumber) {
//		strategicAnalysisAndReportsPage().clickCountryReportsArticle(articleNumber);
//	}
//	
//	@Step
//	public void clickSpecialReportsFirstArticle(int articleNumber) {
//		strategicAnalysisAndReportsPage().clickSpecialReportsArticle(articleNumber);
//	}
	
	@Step
	public void clickExploreButtonDataPacks() {
		strategicAnalysisAndReportsPage().clickOnExploreButtonDataPacks();
	}
	
	@Step
	public void clickLatestReportsFirstArticle() {
		strategicAnalysisAndReportsPage().clickFirstArticle();
	}
	
	@Step
	public void navigateThroughPages(NavigationItems goTo) {
		strategicAnalysisAndReportsPage().navigateToItem(goTo);
	}
	
	@Step
	public void nagivateToSecondPage() {
		strategicAnalysisAndReportsPage().navigateToItem(NavigationItems.Two);
	}

	@Step
	public void nagivateToNextPage() {
		strategicAnalysisAndReportsPage().navigateToItem(NavigationItems.Next);
	}
	
	@Step
	public void nagivateToPreviousPage() {
		strategicAnalysisAndReportsPage().navigateToItem(NavigationItems.Previous);
	}
	
	@Step
	public void nagivateToLastPage() {
		strategicAnalysisAndReportsPage().navigateToItem(NavigationItems.Last);
	}
	
	@Step
	public void nagivateToFirstPage() {
		strategicAnalysisAndReportsPage().navigateToItem(NavigationItems.First);
	}
	
	@Step
	public void verifyNumberOfPastVersions(){
		strategicAnalysisAndReportsPage().verifyNumberOfPastVersions();
	}
	
	@Step
	public void clickAndVerifyServicesOfReportFromListing(int reportNumber, int serviceNumber){
		//TODO fix this
//		strategicAnalysisAndReportsPage().clickOnServicesOfOneReportFromList(reportNumber, serviceNumber);
	}
	
	@Step
	public void clickAndVerifyGeographiesOfReportFromListing(int reportNumber, int geographyNumber){
		//TODO fix this
//		strategicAnalysisAndReportsPage().clickOnGepraphiesOfOneReportFromList(reportNumber, geographyNumber);
	}
	
	@Step
	public void clickAndVerifyArchivesOfReportFromListing(int reportNumber, int archiveNumber){
		//TODO fix this
//		strategicAnalysisAndReportsPage().clickOnArchivesOfOneReportFromList(reportNumber, archiveNumber);
	}
	
	@Step
	public void verifyRelatedItems(int reportNumber){
		strategicAnalysisAndReportsPage().verifyRelatedItems(reportNumber);
	}
	
	//TODO fix this
	@Step
	public void clickOnViewFullReportIcon(int articleNumber){
//		strategicAnalysisAndReportsPage().clickOnViewFullReportIconArticleFromList(articleNumber);
	}
	
	@Step
	public void verifyFirstCategoryFromFilterAndListWithArticles(String firstCategory){
		strategicAnalysisAndReportsPage().verifyFirstCategoryFromFilterAndListWithArticles(firstCategory);
	}
	
	@Step
	public void verifySecondCategoryFromFilterAndListWithArticles(String secondCategory){
		strategicAnalysisAndReportsPage().verifySecondCategoryFromFilterAndListWithArticles(secondCategory);
	}
}

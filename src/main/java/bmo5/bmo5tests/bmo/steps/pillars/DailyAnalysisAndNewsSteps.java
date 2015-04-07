package bmo5.bmo5tests.bmo.steps.pillars;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class DailyAnalysisAndNewsSteps extends AbstractSteps {

	private static final long serialVersionUID = -7026388639630792347L;

	@StepGroup
	public void navigateLatestNews(String itemsPerPage) {
		latestNewsAnotherPageAnotherPage();
		latestNewsNextPage();
		latestNewsPreviousPage();
		latestNewsLastPage();
		latestNewsFirstPage();
		selectItemsPerPage(itemsPerPage);
	}

	@StepGroup
	//public void selectServiceClickClearFiltersAndVerifyDeselectedAndURL(String page,String service, String urlBeforeClearFilters,boolean selected) {
	 public void selectServiceClickClearFiltersAndVerifyDeselectedAndURL(String service, String serviceId, String urlBeforeClearFilters){
	    selectServiceFromLeftHand(service);
		clickClearFiltersAndWaitForLoadingToDisappear();
	//	verifyServiceAndSubservicesState(page,service,selected);
		verifyParentServiceIsDeselected(serviceId);
		verifyURL(urlBeforeClearFilters);
	}
	
	@StepGroup
	public void selectGeographyClickClearFiltersAndVerifyDeselectedAndURL(String breadcrumb,String country,String continent,String continentId,String countryId, String urlBeforeClearFilters) {
		selectGeographyFromFilter(breadcrumb, country,continent);
		clickClearFiltersAndWaitForLoadingToDisappear();
		verifyGeographyIsDeselected(countryId,continentId);
		verifyURL(urlBeforeClearFilters);
	}
	
	@StepGroup
//	public void verifyServicePivotAndFiltersSelected(String service, String breadcrumb, String country,String continent){
	public void verifyServicePivotAndFiltersSelected(String service,String countryId,String continentId){
		verifyPivotSelectedAndFilter(service);
		//verifyCountryIsSelected(breadcrumb, country,continent);
		verifyGeographyIsSelected(countryId,continentId);
	}
	
	@StepGroup
	//public void verifyGeographyPivotAndFiltersSelected(String geography, String breadcrumb, String service, boolean selected){
	public void verifyGeographyPivotAndFiltersSelected(String geography, String serviceId){
	   verifyPivotSelectedAndFilter(geography);
	   verifyParentServiceIsSelected(serviceId);
	   //verifyServiceAndSubservicesState(breadcrumb, service, selected);
	}

	@Step
	public String clickLatestNewsArticle(int articleNumber) {
		return dailyAnalysisAndNewsPage().clickLatestNewsArticle(articleNumber);
	}

	@Step
	public void latestNewsAnotherPageAnotherPage() {
		dailyAnalysisAndNewsPage().clickOnLatestNewsAnotherPage();
	}

	@Step
	public void latestNewsNextPage() {
		dailyAnalysisAndNewsPage().clickOnLatestNewsNextPage();
	}

	@Step
	public void latestNewsPreviousPage() {
		dailyAnalysisAndNewsPage().clickLatestNewsPreviousPage();
	}

	@Step
	public void latestNewsLastPage() {
		dailyAnalysisAndNewsPage().clickOnLatestNewsLastPage();
	}

	@Step
	public void latestNewsFirstPage() {
		dailyAnalysisAndNewsPage().clickLatestNewsFirstPage();
	}

	@Step
	public void clickOnLastPageHotTopics() {
		dailyAnalysisAndNewsPage().clickOnLastPageHotTopics();
	}
	
	@Step
	public void selectItemsPerPage(String value) {
		dailyAnalysisAndNewsPage().selectItemsPerPage(value);
	}
	
	@Step
	public void verifyItemsPerPage(String itemsPerPage) {
		dailyAnalysisAndNewsPage().verifyItemsPerPage(itemsPerPage);
		}
	
	@Step
	public void verifyPaginationIsPresent() {
		dailyAnalysisAndNewsPage().verifyPaginationIsPresent();	
	}
	
	@Step
	public void verifyArticlesOrReportsPerPage(String itemsPerPage, String itemSelector) {
		dailyAnalysisAndNewsPage().verifyArticlesOrReportsPerPage(itemsPerPage,itemSelector);
	}

	@Step
	public void verifyArticlesTitle(String itemSelector, String words) {
		dailyAnalysisAndNewsPage().verifyArticlesTitle(itemSelector, words);
	}
	
	@Step
	public void clickOnDailyAnalysissubtab(String analysis) {
		dailyAnalysisAndNewsPage().clickOnDailyAnalysis(analysis);

	}
	
	@Step
	public void clickNewsTab(String news) {
		dailyAnalysisAndNewsPage().clickOnNews(news);
	}
	
	@Step
	public void clickBreadCrumbs() {
		dailyAnalysisAndNewsPage().clickBreadcrumbs();
	}
	
	@Step
	public void verifyEntitledGeographyFromLeftHandFilter(String entitledService,String breadcrumb,String entitledGeography, String continentForEntitledGeo){
		dailyAnalysisAndNewsPage().verifyEntitledGeographyFromLeftHandFilter(entitledService,breadcrumb,entitledGeography,continentForEntitledGeo);
	}
	
	@Step
	public void verifyEntitledServiceFromLeftHandFilter(String entitledService){
		dailyAnalysisAndNewsPage().verifyEntitledServiceFromLeftHandFilter(entitledService);
	}

	@Step
	public void selectServiceFromLeftHand(String service){
		dailyAnalysisAndNewsPage().selectServiceFromLeftHand(service);
	}
	
	@Step
	public void verifyServiceAndSubservicesState(String page,String service, boolean selected){
		dailyAnalysisAndNewsPage().verifyServiceAndSubservicesState(page,service, selected);
	}
	
	@Step
	public void clickClearFiltersAndWaitForLoadingToDisappear(){
		dailyAnalysisAndNewsPage().clickClearFiltersAndWaitForLoadingToDisappear();
	}
	
	@Step
	public void clickClearFilters(){
		dailyAnalysisAndNewsPage().clickClearFilters();
	}
	
	@Step
	public void verifyURL(String urlBeforeClearFilters){
		dailyAnalysisAndNewsPage().verifyURL(urlBeforeClearFilters);
	}
	
	@Step
	public void selectContinentFromLeftHand(String geography){
		dailyAnalysisAndNewsPage().selectContinentFromLeftHand(geography); 
	}
	
	@Step
	public void verifyContinentIsDeselected(String breadcrumb,String geography){
		dailyAnalysisAndNewsPage().verifyContinentIsDeselected(breadcrumb,geography); 
	}
	
	@Step
	public void verifyPivotSelectedAndFilter(String pivot){
	dailyAnalysisAndNewsPage().verifyPivotSelectedAndFilter(pivot);
	}
	
	@Step
	public void selectGeographyFromFilter(String breadcrumb,String country, String continent){
		dailyAnalysisAndNewsPage().selectGeographyFromFilter(breadcrumb, country,continent);
	}
	
	@Step
	public void verifyCountryIsSelected(String breadcrumb, String geography, String continent){
		dailyAnalysisAndNewsPage().verifyCountryIsSelected(breadcrumb, geography,continent);
	}
	
	
	@Step
	public void verifyGeographyIsSelected(String countryId, String continentId){
		dailyAnalysisAndNewsPage().verifyGeographyIsSelected(countryId,continentId);
	}
	
	@Step
	public void verifyGeographyIsDeselected(String countryId, String continentId){
		dailyAnalysisAndNewsPage().verifyGeographyIsDeselected(countryId, continentId);
	}
	
	@Step
	public void verifyParentServiceIsSelected(String serviceId){
		dailyAnalysisAndNewsPage().verifyParentServiceIsSelected(serviceId);
	}
	
	@Step
	public void verifyParentServiceIsDeselected(String serviceId){
		dailyAnalysisAndNewsPage().verifyParentServiceIsDeselected(serviceId);
	}
	
	@Step
	public void verifyKeyMarketForecastsIsDisplayed(){
		dailyAnalysisAndNewsPage().verifyKeyMarketForecastsIsDisplayed();
	}
	
	@Step
	public List<String> getIndicatorsFromKeyMarketForecasts(){
		return dailyAnalysisAndNewsPage().getIndicatorsFromKeyMarketForecasts();
	}
	
	@Step
	public void compareIndicators(List<String> indicatorsFromAdm, List<String> indicatorsFromBMO){
		dailyAnalysisAndNewsPage().compareLists(indicatorsFromAdm, indicatorsFromBMO);
	}
	
	@Step
	public void clickOnClickHereToExploreFromKMF(String dvpackId){
		dailyAnalysisAndNewsPage().clickOnClickHereToExploreFromKMF(dvpackId);
	}
	
	@Step
	public String getCellValueFromKeyMarketForecasts(int i, int j){
		return dailyAnalysisAndNewsPage().getCellValueFromKeyMarketForecasts(i, j);
	}
	
	public String replaceDotWithComma(String stringToOperate){
		return dailyAnalysisAndNewsPage().replaceDotWithComma(stringToOperate);
	}
} 

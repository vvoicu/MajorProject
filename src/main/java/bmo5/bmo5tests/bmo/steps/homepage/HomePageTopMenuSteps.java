package bmo5.bmo5tests.bmo.steps.homepage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import org.junit.Assert;

import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class HomePageTopMenuSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	@StepGroup
	public void clickAndVerifyService(String  serviceTop,String serviceName) {
		clickService( serviceTop,serviceName);
		verifyBreadCrumb(serviceName);
	}

	@StepGroup
	public void clickAndVerifyGeography(String geographyTop,String continent, String country) {
		clickOnGeography(geographyTop,continent, country);
		verifyBreadCrumb(country);
	}

	@StepGroup
	public void clickAndVerifyCountryRisk(String  serviceTop,String serviceName) {
		clickService( serviceTop,serviceName);
		verifyBreadCrumb(serviceName);
	}

	@StepGroup
	public void clickAndVerifyFinancialMarkets(String serviceTop,String serviceName) {
		//clickFinancialMarkets();
		clickService( serviceTop,serviceName);
		verifyBreadCrumb(serviceName);
	}

	@StepGroup
	public void clickAndVerifyHotTopicsArticle(int articleNumber, String breadCrumb) {
		String articleText = clickHotTopicsArticle(articleNumber);
		Assert.assertFalse(articleText.isEmpty());
		//verifyBreadCrumb(articleText);
		//clickHotTopicsViewAll();
		verifyBreadCrumb(breadCrumb);
	}

	@StepGroup
	public void clickAndVerifySpecialReports() {
		clickOnSpecialReportsViewAll();
		verifyBreadCrumb("Special Reports");
	}

	@Step
	public void clickService(String serviceTop,String serviceName) {
		homePageTopMenuPage().clickOnService(serviceTop,serviceName);
	}

	@Step
	public void clickCountryRisk() {
		homePageTopMenuPage().clickOnCountryRisk();
	}

	@Step
	public void clickFinancialMarkets() {
		homePageTopMenuPage().clickOnFinancialMarkets();
	}

	@Step
	public String clickHotTopicsArticle(int articleNumber) {
		String articleText = "";
		articleText = homePageTopMenuPage().clickOnHotTopicsArticle(articleNumber);
		return articleText;
	}

	@Step
	public void clickHotTopicsViewAll() {
		homePageTopMenuPage().clickOnHotTopicsViewAll();
	}

	@Step
	public void clickOnSpecialReportsViewAll() {
		homePageTopMenuPage().clickOnSpecialReportsViewAll();
	}

	@Step
	public void clickOnWebinarsAndPodcastsFirstArticle() {
		homePageTopMenuPage().clickOnWebinarsAndPodcastsFirstArticle();
	}

	@Step
	public void clickOnWebinarsAndPodcastsViewAll() {
		homePageTopMenuPage().clickOnWebinarsAndPodcastsViewAll();
	}
	
	@Step
	public void verifyBreadCrumb(String text) {
		homePageTopMenuPage().verifyBreadCrumb(text);
	}
	
	@Step
	public void mouseOverHotTopics(){
		homePageTopMenuPage().mouseOverHotTopics();
	}
	
	@Step
	public void mouseOverWebinarsAndPodcasts(){
		homePageTopMenuPage().mouseOverWebinarsAndPodcasts();
	}
	
	@Step
	public void clickOnTheNameOfTheChildBreadcrumb(){
		homePageTopMenuPage().clickOnTheNameOfTheChildBreadcrumb();
	}
	
	@Step
	public void clickOnTheHomeBreadcrumb(){
		homePageTopMenuPage().clickOnTheHomeBreadcrumb();
	}
	
	@Step
	public void clickOnTheNameOfTheParentBreadcrumb(){
		homePageTopMenuPage().clickOnParentBreadcrumb();
	}
	
	@Step
	public void clickOnService() {
		homePageTopMenuPage().chooseAService();
	}
	
	@Step
	public void selectService(String serv,int column,int service) {
		homePageTopMenuPage().serviceList(serv,column,service);
	}

	@Step
	public void clickOnGeography(String geographyTop,String continent, String country) {
		homePageTopMenuPage().selectGeography(geographyTop,continent, country);
	}
	
	@Step
	public void selectServicefromTop(String serviceTop) {
		homePageTopMenuPage().clickOnServiceTopMenu(serviceTop);
	}

	@Step
	public void exportContacts() {
		homePageTopMenuPage().clickOnExportContacts();
	}
	
	@Step
	public  void selectFinancialMarkets() {
		homePageTopMenuPage().clickOnFinancialMarketsTab();
		
	}
	
	@Step
	public void verifyBreadCrumbAccount(String accountTitle) {
		homePageTopMenuPage().verifyBreadCrumbAccount(accountTitle);
	}
	
	@Step
	public void verifyGeoPivotBr(String geoPivot) {
		homePageTopMenuPage().verifyBreadCrumbAccount(geoPivot);
	}
	
	@Step
	public void verifyBreadCrumbForHeader(String advancedSearchTitle) {
		homePageTopMenuPage().verifyBreadCrumbAdvancedSearch(advancedSearchTitle) ;		
	}
	
	@Step
	public void verifyBackgroudColour() {
		homePageTopMenuPage().verifyBackgroudColourService();
	}
	
	@Step
	public void verifyBackgroudColourGeography() {
		homePageTopMenuPage().verifyBackgroudColourGeography();
	}

	@Step
	public void selectServicePivotForTrial(int column, int serviceNumber) {
		homePageTopMenuPage().selectServicePivotForTrial(column, serviceNumber);
	}
	
	@Step
	public void verifyEntitledService(String serviceTop, String entitledService){
		homePageTopMenuPage().verifyEntitledService(serviceTop, entitledService);
	}
	
	@Step
	public void verifyEntitledGeography(String geographyTop, String entitledGeography){
		homePageTopMenuPage().verifyEntitledGeography(geographyTop, entitledGeography);
	}
	
	@Step
	public void clickOnGeographyFromTopNavandShowGeographyDropDowns(String geographyTop, String continent){
		homePageTopMenuPage().showCountryDropDowns(geographyTop, continent);
	}
	
	@Step
	public void verifyCountryIsDisplayed(String geographyTop, String continent, String country){
		homePageTopMenuPage().verifyGeographyIsDisplayed(geographyTop, continent, country);
	}
	
	@Step
	public void verifyUnentitledGeography(String geographyTop, String entitledGeography){
		homePageTopMenuPage().verifyUnentitledGeographies(geographyTop,entitledGeography);
	}
	
	@Step
	public void verifyUnentitledServices(String serviceTop, String entitledService){
		homePageTopMenuPage().verifyUnentitledServicesPermissionModal(serviceTop,entitledService);
	}
	
	@Step
	public void assertAccountManagerWindowIsDisplayed(){
		homePageTopMenuPage().assertAccountManagerWindowIsDisplayed();
	}
}

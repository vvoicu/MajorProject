package bmo5.bmo5tests.bmo.pages.homepage;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class HomePageTopMenuPage extends AbstractPage {

	@FindBy(partialLinkText = "Service")
	@CacheLookup
	private WebElement service;

	@FindBy(linkText = "Country Risk")
	@CacheLookup
	private WebElement countryRisk;

	@FindBy(linkText = "Financial Markets")
	@CacheLookup
	private WebElement financialMarkets;

	@FindBy(css = "section#fixed-header > div:nth-child(1) > nav:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > a")
	@CacheLookup
	private WebElement geography;

	@FindBy(linkText = "Hot Topics")
	@CacheLookup
	private WebElement hotTopics;

	@FindBy(linkText = "Special Reports")
	@CacheLookup
	private WebElement specialReports;

	@FindBy(linkText = "Webinars & Podcasts")
	@CacheLookup
	private WebElement webinarsAndPodcasts;

	@FindBy(css = "div.navbar-inner > ul:nth-child(2) > li:nth-child(1) > ul > li > ul > li> a")//a[href='/hottopics']")
	@CacheLookup
	private WebElement hotTopicsViewAll;

	@FindBy(css = "a[href='/sar/reports/special']")
	@CacheLookup
	private WebElement specialReportsViewAll;

	@FindBy(css = "a[href='http://bmo5.businessmonitor.uat5/webinars']")
	@CacheLookup
	private WebElement webinarsAndPodcastsViewAll;

	@FindBy(css = "ul.breadcrumb > li.active")
	@CacheLookup
	private WebElement breadcrumbLast;
	
	@FindBy(css = "ul.breadcrumb > li.active")
	@CacheLookup
	private WebElement breadcrumbLastSar;
	
	@FindBy(css = "ul.breadcrumb > li:nth-of-type(3) > a")
	@CacheLookup
	private WebElement breadcrumbMiddle;

	@FindBy(css = "ul.breadcrumb > li:nth-child(4) > a")
	@CacheLookup
	private WebElement nameOfTheChildBreadcrumb;

	@FindBy(css = "ul.breadcrumb > li:nth-child(2) > a")
	@CacheLookup
	private WebElement homeBreadcrumb;

	@FindBy(css = "section#fixed-header > div:nth-child(1)> nav:nth-child(1) > div:nth-child(1)> ul:nth-child(1) > li:nth-child(5) > a")
	private WebElement serviceTopMenu;
	
	@FindBy(css = "ul.dropdown-menu.span9")
	@CacheLookup
	private WebElement serviceListContainer;
	
	@FindBy(css = "ul.dropdown-menu.span3.geography")
	@CacheLookup
	private WebElement geographyListContainer;
	
	@FindBy(css = "ul[class='dropdown-menu span6'] > li:nth-child(1) > h4 > a")
	@CacheLookup
	private WebElement webinarsAndPodcastsFirstArticle;
	

	@FindBy(css = "a[href='/mnc/home']")
	private WebElement clickExportExecutiveContacts;
	
	@FindBy(css = "nav.navbar.navbar-main > div > ul:nth-child(1) > li:nth-child(3) > a")//a[href='/dailyanalysisnews/daily_analysis_and_news?service=f']")
	private WebElement financialMarketsTab;
	
	@FindBy(css = "div#permission-modal-geography > div > p:nth-child(2)")
	private WebElement geographyPermissionModalText;
	
	@FindBy(css = "div#permission-modal-geography > div:nth-child(2) > button")
	private WebElement geographyPermissionModalCancelLink;
	
	@FindBy(css = "div#permission-modal-service > div > p:nth-child(2)")
	private WebElement servicePermissionModalText;
	
	@FindBy(css = "div#permission-modal-service > div:nth-child(2) > button")
	private WebElement servicePermissionModalCancelLink;
	
	public void clickOnFinancialMarketsTab() {
		financialMarketsTab.click();
	}
	
	public void clickOnExportContacts() {
		clickExportExecutiveContacts.click();
	}
	
	public void verifyServiceTopNav(String serviceTop){
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("section#fixed-header > div:nth-child(1) > nav:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a")).getText().contains(serviceTop));
		service.click();
	}
	
	public void clickOnService(String serviceTop,String serviceName) {
	    verifyServiceTopNav(serviceTop);
	    Assert.assertTrue("Service is not displayed",element(By.linkText(serviceName)).isDisplayed());
		element(By.linkText(serviceName)).click();
	}
	
	
	
	public void verifyBackgroudColourService() {
		waitABit(3000);
		if (getDriver().findElement(By.partialLinkText("Service")).getCssValue("background-color").compareToIgnoreCase("rgba(10,121,213)") == 0)
	{
		Assert.assertEquals("Not the right colour!", getDriver().findElement(By.partialLinkText("Service")).getCssValue("background-color"));
		}
	}
	
	public void selectServicePivotForTrial(int column, int serviceNumber) {
		chooseAService();
		System.out.println("clickeed!");
		element(getDriver().findElement(By.cssSelector("div.navbar-inner >  ul:nth-child(1) > li:nth-child(5) > ul"))).waitUntilPresent();
		System.out.println("waiting...");
		getDriver().findElement(By.cssSelector("div.navbar-inner >  ul:nth-child(1) > li:nth-child(5) > ul > li > ul:nth-child("+column+") > li:nth-child("+serviceNumber+") > a")).click();
		
	}
	public void verifyBackgroudColourGeography() {
		waitABit(3000);
		if (getDriver().findElement(By.partialLinkText("Geography")).getCssValue("background-color").compareToIgnoreCase("rgba(10,121,213)") == 0)
		{
			Assert.assertEquals("Not the right colour!", getDriver().findElement(By.partialLinkText("Geography")).getCssValue("background-color"));
		}
	}
    
	public void clickOnServiceTopMenu(String serviceTop) {
		waitUntilElementExists(By.cssSelector("section#fixed-header > div > nav:nth-child(1) > div > ul:nth-child(1) > li:nth-child(5) > a"), 30);
	//	Assert.assertTrue(getDriver().findElement(By.cssSelector("section#fixed-header > div > nav:nth-child(1) > div > ul:nth-child(1) > li:nth-child(5) > a")).getText().contains(serviceTop));
		serviceTopMenu.click();
		}
	
	public void clickOnCountryRisk() {
		countryRisk.click();
	}

	public void clickOnFinancialMarkets() {
		financialMarkets.click();
	}

	public void clickOnHotTopicsViewAll() {
		if(getDriver().findElements(By.cssSelector("li.dropdown > a#js-hot-topics")).size() == 1){
			getDriver().findElement(By.cssSelector("li.dropdown > a#js-hot-topics")).click();
			hotTopicsViewAll.click();
		}
		else{
			System.out.println("There is no Hot Topic");
		}
	}

	public void clickOnHotTopics() {
		if(getDriver().findElements(By.cssSelector("li.dropdown > a#js-hot-topics")).size() == 1){
			getDriver().findElement(By.cssSelector("li.dropdown > a#js-hot-topics")).click();
		}
		else{
			System.out.println("There is no Hot Topic");
		}
	}

	public void clickOnSpecialReportsViewAll() {
		specialReports.click();
		specialReportsViewAll.click();
	}

	public void clickOnWebinarsAndPodcastsViewAll() {
		if(getDriver().findElements(By.cssSelector("ul[class='nav pull-right'] > li")).size() == 3){
			getDriver().findElement(By.cssSelector("ul[class='nav pull-right'] > li:nth-child(3) > a")).click();
			webinarsAndPodcastsViewAll.click();
		}
		else if(getDriver().findElements(By.cssSelector("ul[class='nav pull-right'] > li")).size() == 2){
			getDriver().findElement(By.cssSelector("ul[class='nav pull-right'] > li:nth-child(2) > a")).click();
			webinarsAndPodcastsViewAll.click();
		}
		else{
			System.out.println("There is no Webinar or Podcast");
		}
	}

	public String clickOnHotTopicsArticle(int articleNumber) {
		String articleText = "";
		if(getDriver().findElements(By.cssSelector("div.navbar-inner > ul:nth-child(2) > li a#js-hot-topics")).size() == 1){
			getDriver().findElement(By.cssSelector("div.navbar-inner > ul:nth-child(2) > li a#js-hot-topics")).click();
			int numberOfHotTopicsDisplayed = getDriver().findElements(By.cssSelector("div.navbar-inner > ul:nth-child(2) > li:nth-child(1) > ul > li > ul > li a")).size() - 1; //- 2; //ul[class='nav pull-right'] > li:nth-child(1) > ul:nth-child(2) > li> ul.span4 >li
			System.out.println(numberOfHotTopicsDisplayed);
			WebElement hotTopicsArticle;
			hotTopics.click();
			if (numberOfHotTopicsDisplayed > 0) {
				if (articleNumber <= numberOfHotTopicsDisplayed && articleNumber > 0) {
					hotTopicsArticle = element(By.cssSelector("div.navbar-inner > ul:nth-child(2) > li:nth-child(1) > ul > li > ul > li:nth-child(" +articleNumber + ") > a"));//ul[class='nav pull-right'] > li:nth-child(1) > ul:nth-child(2) > li > ul.span4 > li:nth-child(" + articleNumber + ") > a
				} else {
					System.out.println("There aren't so many articles displayed in Hot Topics Top Menu so clicking the first article");
					hotTopicsArticle = element(By.cssSelector("div.navbar-inner > ul:nth-child(2) > li:nth-child(1) > ul > li > ul > li:nth-child(1) > a"));//ul[class='nav pull-right'] > li:nth-child(1) > ul:nth-child(2) >li > ul.span4 > li:nth-child(1) > a
				}
				articleText = hotTopicsArticle.getText();
				hotTopicsArticle.click();
			} else {
				System.out.println("There aren't any articles in Hot Topics Top Menu");
				articleText = "";
			}
		}
		else{
			System.out.println("There si no hot topic.");
		}
		return articleText;
	}
	
	public void verifyBreadCrumb(String text) {
		boolean contained = false;
		int numberOfBreadcrumbElements = getDriver().findElements(By.cssSelector("ul.breadcrumb > li")).size();
		System.out.println(numberOfBreadcrumbElements);
		int j = numberOfBreadcrumbElements -1;
		System.out.println(breadcrumbLast.getText());
		if (breadcrumbLast.getText().contains(text)) {
			contained = true;
		} else {
			if (getDriver().findElement(By.cssSelector("ul.breadcrumb > li:nth-of-type("+ j +")")).getText().contains(text)) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}
	
	
	public void verifyBreadCrumbSar(String text) {
		boolean contained = false;
		if (breadcrumbLastSar.getText().contains(text)) {
			contained = true;
		} else {
			if (breadcrumbMiddle.getText().contains(text)) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}
	
	public void verifyBreadCrumbAdvancedSearch(String text) {
		boolean contained = false;
		if (breadcrumbLast.getText().contains(text)) {
			contained = true;
		} else {
			if (breadcrumbMiddle.getText().contains(text)) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}
	
	public void verifyBreadCrumbAccount(String text) {
		boolean contained = false;
		if (breadcrumbMiddle.getText().contains(text)) {
			contained = true;
		} else {
			if (breadcrumbLast.getText().contains(text)) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}

	public void clickOnTheHotTopicBreadcrumb() {
		nameOfTheChildBreadcrumb.click();
	}

	public void clickOnTheHomeBreadcrumb() {
		if(getDriver().findElements(By.cssSelector("ul.breadcrumb > li:nth-child(2) a")).size() > 0){
			element(homeBreadcrumb).waitUntilVisible();
			homeBreadcrumb.click();
		}
		else{
			System.out.println("The homepage is already displayed.");
		}
	}

	public void clickOnParentBreadcrumb(){
		breadcrumbMiddle.click();
	}

	public void chooseAService(){
		service.click();
	}

	public void serviceList(String serv,int column,int service){
		element(serviceListContainer).waitUntilVisible();

		List<WebElement> allElements = serviceListContainer.findElements(By
				.cssSelector("li ul li a"));

		for (WebElement services : allElements) {
			if (services.getText().equals(serv)) {
				System.out.println("service selected!");
				Assert.assertTrue(getDriver().findElement(By.cssSelector("section#fixed-header > div > nav > div > ul:nth-child(1) > li:nth-child(5) > ul > li > ul:nth-child("+column+") > li:nth-child("+service+") > a")).getText().contains(serv));
				waitABit(3000);
				services.click();
				break;
			}
		}
		
	}

	public void selectGeography(String geographyTop,String continent, String country) {
		verifyGeographyTopNav(geographyTop);
		evaluateJavascript("var element =jQuery('a:contains(" + continent + ")');element.mouseover();");
		waitABit(10000);
		evaluateJavascript("" +
				"$('.navbar-inner > .nav > .dropdown.bmo > .dropdown-menu.span3.geography  > .dropdown-submenu > h4 > a:contains(" + continent + ")')" + 
				".trigger('mouseover')" +
				".parent().next('.dropdown-menu').show()" +
				".find('a:contains("+ country +")')[0].click()");
		                       //element(By.cssSelector("div.sidebar.well")).waitUntilVisible(); //not needed
		waitABit(10000);

		System.out.println("found!");
	}
	
	public void clickOnWebinarsAndPodcastsFirstArticle() {
		if(getDriver().findElements(By.cssSelector("ul[class='nav nav-right'] > li")).size() == 3){
			getDriver().findElement(By.cssSelector("ul[class='nav nav-right'] > li:nth-child(3) > a")).click();
			webinarsAndPodcastsFirstArticle.click();
		}
		else if(getDriver().findElements(By.cssSelector("ul[class='nav nav-right'] > li")).size() == 2){
			getDriver().findElement(By.cssSelector("ul[class='nav nav-right'] > li:nth-child(2) > a")).click();
			webinarsAndPodcastsFirstArticle.click();
		}
		else{
			System.out.println("There is no Webinar or Podcast");
		}
	}

	public void clickOnTheNameOfTheChildBreadcrumb() {
		nameOfTheChildBreadcrumb.click();
	}

	public void mouseOverWebinarsAndPodcasts(){
		if(getDriver().findElements(By.cssSelector("ul[class='nav nav-right'] > li")).size() == 3){
			mouseOverElement("ul[class='nav nav-right'] > li:nth-child(3) > a");
		}
		else if(getDriver().findElements(By.cssSelector("ul[class='nav nav-right'] > li")).size() == 2){
			mouseOverElement("ul[class='nav nav-right'] > li:nth-child(2) > a");
		}
		else{
			System.out.println("There is no Webinar or Podcast");
		}
	}

	public void mouseOverHotTopics(){
		if(getDriver().findElements(By.cssSelector("li.dropdown > a#js-hot-topics")).size() == 1){
			mouseOverElement("li.dropdown > a#js-hot-topics");
		}
		else{
			System.out.println("There is no Hot Topic");
		}
	}
	
	/**
	 * Verifies that only the service the user is entitled to is enabled, the rest are disabled (NPC on) or not displayed(NPC off)
	 * @param serviceTop
	 * @param entitledService
	 */
	public void verifyEntitledService(String serviceTop, String entitledService){
		verifyServiceTopNav(serviceTop);
		int columnNumber=0;
		int serviceNumber;
		WebElement serviceColumnContainer = getDriver().findElement(
				By.cssSelector("ul.dropdown-menu.span9"));
		List<WebElement> serviceColumns = serviceColumnContainer.findElements(By
				.cssSelector("ul"));

		for (int i=0;i<serviceColumns.size();i++) {
			columnNumber=i+1;
			WebElement  serviceListContainer= getDriver().findElement(By.cssSelector("ul.dropdown-menu.span9 > li > ul:nth-child("+columnNumber+")"));
			List<WebElement> services = serviceListContainer.findElements(By
					.cssSelector("li a"));
			
			for(int j=0;j<services.size();j++){
				serviceNumber=j+1;
				assertThatEntitledServiceIsEnabled(serviceNumber, columnNumber, entitledService, services.get(j).getText());
			}
		}
	}
	
	public void verifyUnentitledServicesPermissionModal(String serviceTop, String entitledService){
		verifyServiceTopNav(serviceTop);
		int columnNumber,randomServiceNumber;
	
		WebElement serviceColumnContainer = getDriver().findElement(
				By.cssSelector("ul.dropdown-menu.span9"));
		List<WebElement> serviceColumns = serviceColumnContainer.findElements(By
				.cssSelector("ul"));

		clickOnServiceTopMenu(serviceTop);
		columnNumber=generateRandomNumberBetweenTwoValues(1, serviceColumns.size());
	
			WebElement  serviceListContainer= getDriver().findElement(By.cssSelector("ul.dropdown-menu.span9 > li > ul:nth-child("+columnNumber+")"));
			List<WebElement> services = serviceListContainer.findElements(By
					.cssSelector("li"));
			if(services.size()>1){
			 randomServiceNumber=generateRandomNumberBetweenTwoValues(1, services.size());

			 if(getDriver().findElement(By.cssSelector("ul.dropdown-menu.span9 > li > ul:nth-child("+columnNumber+") > li:nth-child("+randomServiceNumber+")")).getAttribute("class").contains("disabled")){
			    	clickUnentitledServiceAndAssertAccountManagerWindowTextIsDisplayed(columnNumber, randomServiceNumber);
				}
			    else
			    {
			    	int nextRandomNum;
			    	if(randomServiceNumber==12){
			    		 nextRandomNum=randomServiceNumber-1;
			    	}
			    	else
			    		nextRandomNum=randomServiceNumber+1;
			    	    clickUnentitledServiceAndAssertAccountManagerWindowTextIsDisplayed(columnNumber, nextRandomNum);
			    }
			 waitABit(2000);
			}
			else{
				System.out.println("NPC is unticked in Client Accounts");
			}
	}
	
	public int generateRandomNumberBetweenTwoValues(int min, int max){
		Random random=new Random();
		 int randomNum = random.nextInt((max - min) + 1) + min;
		 return randomNum;
	}
	
	public void clickUnentitledServiceAndAssertAccountManagerWindowTextIsDisplayed(int columnNumber,int serviceNumber){
		element(By.cssSelector("ul.dropdown-menu.span9 > li > ul:nth-child("+columnNumber+") > li:nth-child("+serviceNumber+") > a")).click();
		System.out.println("Clicked the service: " + " ul.dropdown-menu.span9 > li > ul:nth-child("+columnNumber+") > li:nth-child("+serviceNumber+") > a");
        assertAccountManagerWindowIsDisplayed();
	}
	
	public void assertAccountManagerWindowIsDisplayed(){
		Assert.assertTrue("Contact Account Manager window text is not displayed",servicePermissionModalText.isDisplayed());
		servicePermissionModalCancelLink.click();
	}
	
	public void clickUnentitledGeographyAndAssertAccountManagerWindowTextIsDisplayed(int continentNumber,int columnNumber,int countryNumber){
		getDriver().findElement(By.cssSelector("div.navbar-inner > ul.nav > li.dropdown.bmo > ul.dropdown-menu.span3.geography > li:nth-child("+continentNumber+") > ul.dropdown-menu > li > ul:nth-child("+columnNumber+") > li:nth-child("+countryNumber+") > a")).click();	
		Assert.assertTrue("Contact Account Manager Window text is not displayed",geographyPermissionModalText.isDisplayed());
		geographyPermissionModalCancelLink.click();
	}
	
	public void assertThatEntitledServiceIsEnabled(int serviceNumber,int serviceColumnNumber, String entitledService, String currentService){
		if(currentService.contains(entitledService)){
			Assert.assertTrue("Entitled service is disabled",!getDriver().findElement(By.cssSelector("ul.dropdown-menu.span9 > li > ul:nth-child("+serviceColumnNumber+") > li:nth-child("+serviceNumber+")")).getAttribute("class").contains("disabled"));
			}
			else{
				Assert.assertTrue("Unentitled service is enabled",getDriver().findElement(By.cssSelector("ul.dropdown-menu.span9 > li > ul:nth-child("+serviceColumnNumber+") > li:nth-child("+serviceNumber+")")).getAttribute("class").contains("disabled"));
		}
	}
	
	public void assertThatEntitledGeographyIsEnabled(int countryNumber,int geographyColumnNumber,int continentNumber, String entitledGeography, String currentGeography){
		if(currentGeography.contains(entitledGeography)){
			Assert.assertTrue("Entitled country is not enabled ",!getDriver().findElement(By.cssSelector("div.navbar-inner > ul.nav > li.dropdown.bmo > ul.dropdown-menu.span3.geography > li:nth-child("+continentNumber+") > ul.dropdown-menu > li > ul:nth-child("+geographyColumnNumber+") > li:nth-child("+countryNumber+")")).getAttribute("class").contains("disabled"));
		}
		else{
			Assert.assertTrue("Unentitled country is not disabled ",getDriver().findElement(By.cssSelector("div.navbar-inner > ul.nav > li.dropdown.bmo > ul.dropdown-menu.span3.geography > li:nth-child("+continentNumber+") > ul.dropdown-menu > li > ul:nth-child("+geographyColumnNumber+") > li:nth-child("+countryNumber+")")).getAttribute("class").contains("disabled"));
		}
	}
	
	public void verifyGeographyTopNav(String geographyTop){
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("section#fixed-header > div:nth-child(1) > nav:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > a" )).getText().contains(geographyTop));
		geography.click();
	}

	public void verifyEntitledGeography(String geographyTop, String entitledGeography){
		
		WebElement continentsListContainer = getDriver().findElement(By.cssSelector("div.navbar-inner > ul.nav > li.dropdown.bmo > ul.dropdown-menu.span3.geography"));
		List<WebElement> continents = continentsListContainer.findElements(By.cssSelector("li > h4 > a"));
		int continentNumber, columnNumber, countryNumber;
		verifyGeographyTopNav(geographyTop);
		
		for(int i=0;i<continents.size();i++){
			showCountryDropDowns(geographyTop, continents.get(i).getText());
			continentNumber=i+1;
			WebElement countryColumnsContainer = getDriver().findElement(By.cssSelector("div.navbar-inner > ul.nav > li.dropdown.bmo > ul.dropdown-menu.span3.geography > li:nth-child("+continentNumber+") > ul.dropdown-menu > li"));
			List<WebElement> countryColumns = countryColumnsContainer.findElements(By.cssSelector("ul"));
			System.out.println("Continent: "+continents.get(i).getText());
			for(int j=0;j<countryColumns.size();j++){
				columnNumber=j+1;
				WebElement countriesContainer = getDriver().findElement(By.cssSelector("div.navbar-inner > ul.nav > li.dropdown.bmo > ul.dropdown-menu.span3.geography > li:nth-child("+continentNumber+") > ul.dropdown-menu > li > ul:nth-child("+columnNumber+")"));
				List<WebElement> countries = countriesContainer.findElements(By.cssSelector("li > a"));
	
				for (int k=0;k<countries.size();k++) {
					countryNumber=k+1;
					assertThatEntitledGeographyIsEnabled(countryNumber, columnNumber, continentNumber, entitledGeography, countries.get(k).getText());	
				}
			}
		}
	}
	
	public void verifyUnentitledGeographies(String geographyTop, String entitledGeography){
		
		WebElement continentsListContainer = getDriver().findElement(By.cssSelector("div.navbar-inner > ul.nav > li.dropdown.bmo > ul.dropdown-menu.span3.geography"));
		List<WebElement> continents = continentsListContainer.findElements(By.cssSelector("li > h4 > a"));
		int randomContinentNumber, randomColumnNumber, randomCountryNumber;
	
            randomContinentNumber=generateRandomNumberBetweenTwoValues(1, continents.size());
			verifyGeographyTopNav(geographyTop);
			showCountryDropDowns(geographyTop, continents.get(randomContinentNumber-1).getText());
			
			WebElement countryColumnsContainer = getDriver().findElement(By.cssSelector("div.navbar-inner > ul.nav > li.dropdown.bmo > ul.dropdown-menu.span3.geography > li:nth-child("+randomContinentNumber+") > ul.dropdown-menu > li"));
			List<WebElement> countryColumns = countryColumnsContainer.findElements(By.cssSelector("ul"));
			System.out.println("Continent: "+continents.get(randomContinentNumber-1).getText());
			randomColumnNumber=generateRandomNumberBetweenTwoValues(1, countryColumns.size());
			
				WebElement countriesContainer = getDriver().findElement(By.cssSelector("div.navbar-inner > ul.nav > li.dropdown.bmo > ul.dropdown-menu.span3.geography > li:nth-child("+randomContinentNumber+") > ul.dropdown-menu > li > ul:nth-child("+randomColumnNumber+")"));
				List<WebElement> countries = countriesContainer.findElements(By.cssSelector("li"));
				if(countries.size()>1){
				randomCountryNumber=generateRandomNumberBetweenTwoValues(1, countries.size());
				showCountryDropDowns(geographyTop, continents.get(randomContinentNumber-1).getText());
					
					if(getDriver().findElement(By.cssSelector("div.navbar-inner > ul.nav > li.dropdown.bmo > ul.dropdown-menu.span3.geography > li:nth-child("+randomContinentNumber+") > ul.dropdown-menu > li > ul:nth-child("+randomColumnNumber+") > li:nth-child("+randomCountryNumber+")")).getAttribute("class").contains("disabled")){
					clickUnentitledGeographyAndAssertAccountManagerWindowTextIsDisplayed(randomContinentNumber, randomColumnNumber, randomCountryNumber);
					}
					else
					{
						int nextRandomNumber=randomCountryNumber+1;
						clickUnentitledGeographyAndAssertAccountManagerWindowTextIsDisplayed(randomContinentNumber, randomColumnNumber, nextRandomNumber);
			}
		}
				else{
					System.out.println("NPC was unticked nothing to check");
				}
	}
	
	public void verifyGeographyIsDisplayed(String geographyTop, String continent, String country){
		 verifyGeographyTopNav(geographyTop);
		 showCountryDropDowns(geographyTop,continent);
		 Assert.assertTrue("Geography is not displayed",element(By.linkText(country)).isDisplayed());
		 //this method only verifies geography is displayed, please use the method selectGeography to select a geography from top nav
	     //element(By.linkText(country)).click();
	}
	
	public void showCountryDropDowns(String geographyTop, String continent){
		evaluateJavascript("var element =jQuery('a:contains(" + continent + ")');element.mouseover();");
		waitABit(5000);
		evaluateJavascript("" +
				"$('.navbar-inner > .nav > .dropdown.bmo > .dropdown-menu.span3.geography  > .dropdown-submenu > h4 > a:contains(" + continent + ")')" + 
				".trigger('mouseover')" +
				".parent().next('.dropdown-menu').show()");
	}
}
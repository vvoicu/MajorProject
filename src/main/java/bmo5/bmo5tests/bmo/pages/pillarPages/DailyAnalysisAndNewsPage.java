package bmo5.bmo5tests.bmo.pages.pillarPages;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
//import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class DailyAnalysisAndNewsPage extends AbstractPage {

	
	@FindBy(css = "li.btn-group.first > a:nth-child(1)")
	@CacheLookup
	private WebElement firstPage;
	
	@FindBy(css = "li[class='numbers active'] + li > a:nth-child(2)")
	@CacheLookup
	private WebElement anotherPage;
	
	@FindBy(css = "li.next.btn-group > a:nth-child(2)")
	@CacheLookup
	private WebElement nextPage;
	
	@FindBy(css = "li.btn-group.first > a:nth-child(3)")
	@CacheLookup
	private WebElement previousPage;
	
	@FindBy(css = "li.next.btn-group > a:nth-child(3)")
	@CacheLookup
	private WebElement lastPage;
	
	@FindBy(css="ul.unstyled li a.btn.btn-mini i.icon-c-angle-double-right")
	private WebElement lastPageHotTopics;
	
	@FindBy(css = "ul#pillars > li:nth-child(1) > div > a:nth-child(1)")
	private WebElement clickDailyAnalysis;

	@FindBy(css = "ul#pillars > li:nth-child(1) > div > a:nth-child(2)")
	@CacheLookup
	private WebElement newsButton;
	
	@FindBy(css = "ul#pillars > li:nth-child(1) > a > h4")
	//@CacheLookup
	private WebElement clickDailyAnalysisandNewsbreadcrumb;
	
	@FindBy(css = "ul.breadcrumb > li:nth-child(2) > a ")
	@CacheLookup
	private WebElement homeButton;
	
	@FindBy(css="a#filter-clear")
	@CacheLookup
	private WebElement clearFilters;
	
	public int countLatestNewsArticles() {
		int articles = 0;
		articles = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		return articles;
	}
	
	public String clickLatestNewsArticle(int articleNumber) {
		int articles = countLatestNewsArticles();
		String articleTitle = "";
		if (articles > 0 && articleNumber <= articles) {
			articleTitle = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1) > h5 > a")).getText();
			getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1) > h5 > a")).click();
			waitABit(5000);
		}
		return articleTitle;
	}
	
	public void clickOnLatestNewsAnotherPage() {
		anotherPage.click();
	}
	
	public void clickOnLatestNewsNextPage() {
		nextPage.click();
	}
	
	public void clickLatestNewsPreviousPage() {
		previousPage.click();
	}
	
	public void clickOnLatestNewsLastPage() {
		lastPage.click();
	}
	
	public void clickLatestNewsFirstPage() {
		firstPage.click();
	}
	
	public void clickOnLastPageHotTopics() {
		lastPageHotTopics.click();
	}
	
	public void selectItemsPerPage(String value) {
		Select itemsPerPage = new Select(getDriver().findElement(By.cssSelector("select.span1.input-pagination")));
		itemsPerPage.selectByValue(value);
	}

	public void verifyItemsPerPage(String itemsPerPage) {
		List<WebElement> elements = getDriver().findElements(By.cssSelector("select.span1.input-pagination option"));
		for (WebElement element:elements) {
			if(element.isSelected()){
				System.out.println(element.getText());
				Assert.assertTrue("items per page in dropdown not persisted!",element.getText().contains(itemsPerPage));
				//break;
			}
		}
	}
	
	public void verifyPaginationIsPresent() {
		Boolean isPresent = getDriver().findElements(By.cssSelector("#the-content-container > div.paginaxor.pagination-listing.pagination.pagination-small.pagination-centered")).size() > 0;
		Assert.assertTrue("The paginator is missing!",isPresent);
	}
	
	public void verifyArticlesOrReportsPerPage(String itemsPerPage, String itemSelector) {
		waitUntilElementExists(By.cssSelector(itemSelector), 45);
		List<WebElement> articles = getDriver().findElements(By.cssSelector(itemSelector));
		int articlesCount = articles.size();
		System.out.println(articlesCount);
		String count = Integer.toString(articlesCount);
		Assert.assertTrue("item count per page not persisted!",count.contains(itemsPerPage));		
	}

	public void verifyArticlesTitle(String itemSelector,String words) {
		List<WebElement> articles = getDriver().findElements(By.cssSelector(itemSelector));
		for (WebElement element:articles) {
			Assert.assertTrue(element.getText().contains(words));
		}
	}
	
	public void clickOnDailyAnalysis(String analysis) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#pillars > li:nth-child(1) > div > a:nth-child(1)")).getText().contains(analysis));
		clickDailyAnalysis.click();
	}

	public void clickOnNews(String news) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#pillars > li:nth-child(1) > div > a:nth-child(2)")).getText().contains(news));
		newsButton.click();
	}

	public void clickBreadcrumbs() {
		clickDailyAnalysisandNewsbreadcrumb.click();
		newsButton.click();
		homeButton.click();
	}
    
    public void verifyEntitledGeographyFromLeftHandFilter(String entitledService,String breadcrumb,String entitledGeography,String continentForEntitledGeo){
    	
		int geographySectionNumber=3;
		
		switch(breadcrumb){
		
		  case "Data Tool":
			  geographySectionNumber=2;
		      break;
		   
		  case "BMI Databases":
			  if(!entitledService.contains("Company Intelligence")){
			  if(entitledService.contains("Infrastructure")||entitledService.contains("Power")||entitledService.contains("Renewables")||entitledService.contains("Telecommunications")){
			  geographySectionNumber = 4;
				}
			}
			  break;
			  
		  default:
			  geographySectionNumber=3;
			  break;
		}
		
		List<WebElement> continents=getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > *"));
	
		for(int i=2;i<=continents.size();i++){
	
			System.out.println("Continent!!! "+getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> label")).getText());
		    Assert.assertTrue("Unentitled continent is displayed",getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> label")).getText().contains(continentForEntitledGeo));
			
		    if(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> label")).getText().contains(continentForEntitledGeo)){
			getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+") > button")).click();
			waitUntilElementExists(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+") > ul"), 5);
			WebElement countriesContainer=	getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul> li:nth-child("+i+") > ul"));
			List <WebElement> countries= countriesContainer.findElements(By.cssSelector("li > label"));
			
			    for(int j=0;j<countries.size();j++){
		
				System.out.println("Current country: " +countries.get(j).getText());
			    Assert.assertTrue("Unentitled countries are displayed in filter" , countries.get(j).getText().contains(entitledGeography));
				//getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+continentNumber+") > ul > li:nth-child("+countryNumber+") > label")).click();	
				}
			}
		}
	}
	
	public void verifyEntitledServiceFromLeftHandFilter(String entitledService){
		
		int serviceSectionNumber=3;
		
		if(getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+serviceSectionNumber+") >*")).size()==1) {
			System.out.println("No service here...");
		}
		
		else{	
		List<WebElement> services=getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+serviceSectionNumber+") > div.expandable-wrapper > ul > *"));
		
		for(int i=2;i<=services.size();i++){
			System.out.println("Service: "+getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+serviceSectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> label")).getText());
		    Assert.assertTrue("Unentitled service is displayed",getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+serviceSectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> label")).getText().contains(entitledService));
			}
		}
	}
	
	public void selectServiceFromLeftHand(String service){
		int serviceSectionNumber=3;
		if(getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+serviceSectionNumber+") >*")).size()==1) {
			System.out.println("No service here...");
		}
		
		else{
		getDriver().findElement(By.cssSelector("label[title='"+service+"']")).click();
		waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 50);
		waitUntilElementDoesntExist(By.cssSelector("div.click-blocker"), 50);
		waitUntilElementDoesntExist(By.cssSelector("article[class*='loading']"), 50);
		}
	}
	
	/**
	 * div/span was removed because uniform class was removed so this method will fail
	 * @param page
	 * @param service
	 * @param selected
	 */
	public void verifyServiceAndSubservicesState(String page,String service,boolean selected){
    int serviceSectionNumber=3;
		
		WebElement serviceContainer=getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+serviceSectionNumber+") > div.expandable-wrapper > ul"));
		List<WebElement> services=serviceContainer.findElements(By.cssSelector("li > label > div[id*='uniform-s_']"));
		
		for(int i=2;i<=services.size()+1;i++){
			
		    if(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+serviceSectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> label")).getText().contains(service)){
		    	if(selected){
		    	Assert.assertTrue("Service is not checked",getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+serviceSectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> label > div > span")).getAttribute("class").contains("checked"));
		    	}
		    	else{
		    		Assert.assertTrue("Service is checked",!getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+serviceSectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> label > div > span")).getAttribute("class").contains("checked"));
		    	}
		    	if(!page.equals("Reports")&& getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+serviceSectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+") >*")).size()>1){
		    	getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+serviceSectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> button")).click();
		    	
		    	WebElement subservicesContainer=getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+serviceSectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> ul"));
				List<WebElement> subservices = subservicesContainer.findElements(By.cssSelector("li > label > div > span"));
				
				for(int j=1; j<=subservices.size();j++){
					if(selected){
					Assert.assertTrue("Subservice is not checked",getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+serviceSectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> ul > li:nth-child("+j+") > label > div > span")).getAttribute("class").contains("checked"));		
					}
					else{
						Assert.assertTrue("Subservice is checked",!getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+serviceSectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> ul > li:nth-child("+j+") > label > div > span")).getAttribute("class").contains("checked"));		
						}
					}
				}
			}
		}
	}
	
	public void verifyParentServiceIsSelected(String serviceId){
		waitUntilElementDoesntExist(By.cssSelector("div.click-blocker"), 50);
		boolean isServiceSelected=verifyElementState("document.getElementById('s_"+serviceId+"')");
		Assert.assertTrue("Checkbox is not checked",isServiceSelected);
	}
	
	public void verifyParentServiceIsDeselected(String serviceId){
		waitUntilElementDoesntExist(By.cssSelector("div.click-blocker"), 50);
		boolean isServiceSelected=verifyElementState("document.getElementById('s_"+serviceId+"')");
		Assert.assertFalse("Checkbox is not checked",isServiceSelected);
	}
	
	public void clickClearFilters(){
		clearFilters.click();
	}
	
	public void clickClearFiltersAndWaitForLoadingToDisappear(){
		clickClearFilters();
    	waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 50);
    	waitUntilElementDoesntExist(By.cssSelector("div.click-blocker"), 50);
	}
	
	public void verifyURL(String urlBeforeClearFilters){
		Assert.assertEquals(urlBeforeClearFilters+"#", getDriver().getCurrentUrl());
	}
	
	public void selectContinentFromLeftHand(String geography){
		getDriver().findElement(By.cssSelector("label[title='"+geography+"']")).click();
		waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 50);
		waitUntilElementDoesntExist(By.cssSelector("div.click-blocker"), 50);
	}
	
	public void verifyContinentIsDeselected(String breadcrumb,String geography){
		int geographySectionNumber=returnSectionNumberForGeographySection(breadcrumb);
		List<WebElement> continents=getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul >*"));
	    System.out.println("Number of Continents: "+continents.size());
	    
		for(int i=2;i<=continents.size();i++){
			Assert.assertTrue("Geography is checked",!getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> label > div > span")).getAttribute("class").contains("checked"));
		    if(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> label")).getText().contains(geography)){
		    	if(getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+") >*")).size()>1){
		    	getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> button")).click();
		    	List<WebElement> countries=getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> ul >*"));//direct children
				
				for(int j=1; j<=countries.size();j++){
				Assert.assertTrue("Country is checked",!getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> ul > li:nth-child("+j+") > label > div > span")).getAttribute("class").contains("checked"));		
					}
				}
			}
		}
	}
	
	public void verifyPivotSelectedAndFilter(String pivot){
		Assert.assertTrue("Filter is missing",getDriver().findElements(By.cssSelector("div.sidebar.well")).size()==1);
		Assert.assertTrue("This is not the selected pivot",getDriver().findElement(By.cssSelector("div.sidebar.well > ul.nav.nav-list > li:nth-of-type(1) > h5")).getText().contains(pivot));
	}
	
	public void selectGeographyFromFilter(String breadcrumb,String country, String continent){
	    	int geographySectionNumber=returnSectionNumberForGeographySection(breadcrumb);
	    	waitUntilElementDoesntExist(By.cssSelector("div.click-blocker"), 50);
	    	List<WebElement> continents=getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul >*"));
		    System.out.println("Number of Continents: "+continents.size());
		    
			for(int i=2;i<=continents.size();i++){
			    if(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> label")).getText().contains(continent)){
			    	if(getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+") >*")).size()>1){
			    	getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> button")).click();
			    	List<WebElement> countries=getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> ul >*"));//direct children
                    System.out.println("Into the continent!!");
                    
					for(int j=1; j<=countries.size();j++){
						if(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> ul >li:nth-of-type("+j+") > label")).getText().contains(country)){
						System.out.println("Into the country...");
						getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> ul >li:nth-of-type("+j+") > label")).click();
						break;
						}
					}
				}
			}
		}
	}
	/**
	 * spam was removed so this method doesn't work anymore
	 * @param breadcrumb
	 * @param geography
	 * @param continent
	 */
	public void verifyCountryIsSelected(String breadcrumb,String geography, String continent){
			int geographySectionNumber=returnSectionNumberForGeographySection(breadcrumb);
			List<WebElement> continents=getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul >*"));
		    System.out.println("Number of Continents: "+continents.size());
		    
			for(int i=2;i<=continents.size();i++){
			    if(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> label")).getText().contains(continent)){
			    	if(getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+") >*")).size()>1){
			    	getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> button")).click();
			    	List<WebElement> countries=getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> ul >*"));//direct children
			    	  System.out.println("Into the continent!! verify selected");
					for(int j=1; j<=countries.size();j++){
					if(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> ul >li:nth-of-type("+j+") > label")).getText().contains(geography)){
					 System.out.println("Into the country...verify selected");
				    Assert.assertTrue("Country is not checked",getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+geographySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> ul > li:nth-child("+j+") > label > div > span")).getAttribute("class").contains("checked"));		
					break;	
						}
					}
				}
			}
		}
	}
	
	public void verifyGeographyIsSelected(String countryId,String continentId){
		waitUntilElementDoesntExist(By.cssSelector("div.click-blocker"), 50);
		boolean isCountrySelected=verifyElementState("document.getElementById('c_"+countryId+"')");
		boolean isContinentSelected=verifyElementState("document.getElementById('r_"+continentId+"')");
		Assert.assertTrue("Checkbox is not checked",isCountrySelected);
		Assert.assertTrue("Checkbox is not checked",isContinentSelected);
	}
	
	public void verifyGeographyIsDeselected(String countryId,String continentId){
		boolean isContinentSelected,isCountrySelected;
		waitUntilElementDoesntExist(By.cssSelector("div.click-blocker"), 50);
		if(!countryId.equals("")){
		isCountrySelected=verifyElementState("document.getElementById('c_"+countryId+"')");
		Assert.assertFalse("Checkbox is checked",isCountrySelected);
		}
		else{
			System.out.println("Country id is empty");
		}
		if(!continentId.equals("")){
		isContinentSelected=verifyElementState("document.getElementById('r_"+continentId+"')");
		Assert.assertFalse("Checkbox is checked",isContinentSelected);
		}
		else{
			System.out.println("Continent id is empty");
		}
	}
	
	public int returnSectionNumberForGeographySection(String breadcrumb){
		 int geographySectionNumber=0;
		
		 switch(breadcrumb){
		
		  case "Data Tool":
			  geographySectionNumber=2;
		      break;
		   
		  case "BMI Databases":
			  geographySectionNumber = 4;
			  break;
			  
		  default:
			  geographySectionNumber=3;
			  break;
		}
		return geographySectionNumber;
	}
	
	public void verifyKeyMarketForecastsIsDisplayed(){
		waitUntilElementExists(By.cssSelector("article#the-widget-container > div.media-widget.key-market-forecast"), 50);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("article#the-widget-container > div.media-widget.key-market-forecast")).isDisplayed());
	}
	
	public List<String> getIndicatorsFromKeyMarketForecasts(){
		List<String> keyMarketForecastsIndicators=new ArrayList<String>();
		List<WebElement> indicatorsElements=getDriver().findElements(By.cssSelector("article#the-widget-container > div.media-widget.key-market-forecast table > tbody > tr > td:nth-of-type(1)"));
		
		for(WebElement indicator:indicatorsElements){
			keyMarketForecastsIndicators.add(indicator.getText());
		}
		return keyMarketForecastsIndicators;
	}
	
	public void compareLists(List<String>list1 , List<String> list2){
		for(int i=0;i<list1.size();i++){
			System.out.println("Indicator adm: "+list1.get(i)+" and indicator from bmo: "+list2.get(i));
			Assert.assertTrue("Lists are not equal",list1.get(i).equals(list2.get(i)));
		}
	}
	
	public void clickOnClickHereToExploreFromKMF(String dvpackId){
		getDriver().findElement(By.cssSelector("article#the-widget-container > div.media-widget.key-market-forecast a[href*='/data/datatool/load?dvpack="+dvpackId+"']")).click();
	}
	
	public String getCellValueFromKeyMarketForecasts(int row, int column){
	String cellValue=null;
		List<WebElement> rows= getDriver().findElements(By.cssSelector("article#the-widget-container > div.media-widget.key-market-forecast table > tbody > tr"));
		List<WebElement> columns=getDriver().findElements(By.cssSelector("article#the-widget-container > div.media-widget.key-market-forecast table > tbody > tr >td"));
		if(row>1 &&row<=rows.size() && column>0 && column<=columns.size()){
			cellValue= getDriver().findElement(By.cssSelector("article#the-widget-container > div.media-widget.key-market-forecast table > tbody > tr:nth-of-type("+row+") > td:nth-of-type("+column+")")).getText();
		}
		return cellValue;
	}
	
	public String replaceDotWithComma(String stringToOperate){
		return stringToOperate.replaceAll(".", ",");
	}
}

package bmo5.bmo5tests.bmo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class WebinarsAndPodcastsPage extends AbstractPage{
	
	@FindBy(css = "div[class='sidebar well'] > ul:nth-of-type(2) > li > h5 ")
	private WebElement serviceTogglerLeftHandFilter;
	
	@FindBy(css="a[href='http://bmo.businessmonitor.uat5/webinars/add_to_calendar?id=10']")
	private WebElement addCalendarEventsWebinars;
	
	@FindBy(css = "div.btn-toolbar.pull-left > a")
	@CacheLookup
	private WebElement backToPreviousPage;

	public String selectService(int serviceNumber){
		waitUntilElementDoesntExist(By.cssSelector("div[class='sidebar well blocked']"), 15);
		int actualNumber=serviceNumber+1;
		int numberOfServicesDisplayed = getDriver().findElements(By.cssSelector("div[class='sidebar well'] > ul:nth-of-type(2) > li > ul > li")).size() - 1;
		WebElement service;
		String serviceText = "";
		if (numberOfServicesDisplayed > 0) {
			if (serviceNumber <= numberOfServicesDisplayed && serviceNumber > 0) {
				service = getDriver().findElement(By.cssSelector("div[class='sidebar well'] > ul:nth-of-type(2) > li > ul > li:nth-child( " + actualNumber  + ") > label"));
			} else {
				System.out.println("There aren't so many services displayed in the left filter panel");
				service = getDriver().findElement(By.cssSelector("div[class='sidebar well'] > ul:nth-of-type(2) > li > ul > li:nth-child(2) > label"));
			}
			serviceText = service.getText();
			service.click();
			return serviceText;
		} else {
			System.out.println("There aren't any services in the left filter panel");
			return serviceText = "";
		}
	}
	
	public String selectGeography(int geographyNumber){
		waitUntilElementDoesntExist(By.cssSelector("div[class='sidebar well blocked']"), 15);
		int actualNumber=geographyNumber+1;
		int numberOfGeographiesDisplayed = getDriver().findElements(By.cssSelector("div[class='sidebar well'] > ul:nth-of-type(1) > li > ul > li")).size() - 1;
		WebElement geography;
		String geographyText = "";
		if (numberOfGeographiesDisplayed > 0) {
			if (geographyNumber <= numberOfGeographiesDisplayed && geographyNumber > 0) {
				geography = getDriver().findElement(By.cssSelector("div[class='sidebar well'] > ul:nth-of-type(1) > li > ul > li:nth-child( " + actualNumber  + ") > label "));
			} else {
				System.out.println("There aren't so many services displayed in the left filter panel");
				geography = getDriver().findElement(By.cssSelector("div[class='sidebar well'] > ul:nth-of-type(1) > li > ul > li:nth-child(2) >label"));
			}
			geographyText = geography.getText();
			geography.click();
			return geographyText;
		} else {
			System.out.println("There aren't any services in the left filter panel");
			return geographyText = "";
		}
	}
	
	public void clickOnTheServiceToggler(){
		waitUntilElementDoesntExist(By.cssSelector("div[class='sidebar well blocked']"), 15);
		if(getDriver().findElements(By.cssSelector("div[class='sidebar well'] > ul:nth-of-type(2) > li > h5")).size() == 1){
			serviceTogglerLeftHandFilter.click();
		}
	}
	
	//TODO Fix this
//	public void webinarsAddToCalendarEvent() {
//		addCalendarEventsWebinars.click();
//		SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
//		singleArticle.performDownload();
//	}
//
//	public void verifyWebinarBreadcrumb(String widgetName){
//		if(getDriver().findElements(By.cssSelector("li#webinars_dropdown")).size() == 1){
//			SingleArticlePage sa = new SingleArticlePage(getDriver());
//			sa.verifyBreadCrumbArticle(widgetName);
//		}
//	}
//	
//	public void verifyTitle(String text) {
//		if(getDriver().findElements(By.cssSelector("li#webinars_dropdown")).size() == 1){
//			SingleArticlePage sa = new SingleArticlePage(getDriver());
//			sa.verifyTitle(text);
//		}
//	}
//	
//	public void verifyBreadcrumbs(String breadcrumbs){
//		if(getDriver().findElements(By.cssSelector("li#webinars_dropdown")).size() == 1){
//			HomePageHeaderPage hh = new HomePageHeaderPage(getDriver());
//			hh.verifyBreadCrumbs(breadcrumbs);
//		}
//	}
	
	public String clickOnAWebinarOrPodcast(int itemNumber) {
		String webinarOrPodcastTitle = "";
		if(getDriver().findElements(By.cssSelector("li#webinars_dropdown")).size() == 1){
			int itemsNumber = getDriver().findElements(By.cssSelector("div#the-content-container div.media-listing > div")).size();
			
			if(itemNumber > 0){
				if (itemNumber > 0 && itemNumber <= itemsNumber) {
					webinarOrPodcastTitle = getDriver().findElement(By.cssSelector("article div.media-listing > div:nth-child(" + itemNumber + ") > div:nth-child(1) > h5 > a")).getText();
					getDriver().findElement(By.cssSelector("article div.media-listing > div:nth-child(" + itemNumber + ") > div:nth-child(1) > h5 > a")).click();
				}
				else{
					System.out.println("There are not so manna articles, so click on the fisrt one!");
					webinarOrPodcastTitle = getDriver().findElement(By.cssSelector("article div.media-listing > div:nth-child(1) > div:nth-child(1) > h5 > a")).getText();
					getDriver().findElement(By.cssSelector("article div.media-listing > div:nth-child(1) > div:nth-child(1) > h5 > a")).click();
				}
			}
			else{
				System.out.println("There is no article in listing!");
			}
		}
		System.out.println(webinarOrPodcastTitle);
		return webinarOrPodcastTitle;
	}
	
	public void clickOnBackToPreviousPage() {
		if(getDriver().findElements(By.cssSelector("li#webinars_dropdown")).size() == 1){
			backToPreviousPage.click();
		}
		else{
			System.out.println("There is no webinar or podcast accessed.");
		}
	}
		
}

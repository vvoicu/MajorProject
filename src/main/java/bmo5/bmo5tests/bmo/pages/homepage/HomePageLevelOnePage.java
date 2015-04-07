package bmo5.bmo5tests.bmo.pages.homepage;

import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class HomePageLevelOnePage extends AbstractPage {
	
	@FindBy(css = "a.flex-prev")
	@CacheLookup
	private WebElement arrowPrevious;
	
	@FindBy(css = "a.flex-next")
	@CacheLookup
	private WebElement arrowNext;
	
	@FindBy(css = "ol[class='flex-control-nav flex-control-paging'] > li:nth-child(1) > a")
	@CacheLookup
	private WebElement circleOne;

	@FindBy(css = "ol[class='flex-control-nav flex-control-paging'] > li:nth-child(2) > a")
	@CacheLookup
	private WebElement circleTwo;
	
	@FindBy(css = "ol[class='flex-control-nav flex-control-paging'] > li:nth-child(3) > a")
	@CacheLookup
	private WebElement circleThree;
	
	@FindBy(css = "ul[class='nav nav-right'] > li:nth-child(3) > ul > li:nth-child(1) > h4 > a ")
	@CacheLookup
	private WebElement widgetOne;

	@FindBy(css = "ul[class='nav nav-right'] > li:nth-child(3) > ul > li:nth-child(3) > h4  a ")
	@CacheLookup
	private WebElement widgetTwo;
	
	@FindBy(css = "div#flex-viewport > ul > li:nth-child(2) > article:nth-child(3) > div:nth-child(1) > h4  a)")
	@CacheLookup
	private WebElement widgetThree;

	@FindBy(css="li#webinars_dropdown")
	@CacheLookup
	private WebElement webinarsAndPodcasts;
	
	@FindBy(css="div[class='modal webinar hide fade in'] button")
	@CacheLookup
	private WebElement closePreviewWidgetButton;	
	
	@FindBy(css="li#webinars_dropdown ul > li.text-center a strong")
	@CacheLookup
	private WebElement viewAllWidgetsAndPodcasts;
	
	@FindBy(css = "a[href='/sar/reports/results?sp=1']")
	private WebElement viewAllButtonSpecialReports;
	
	@FindBy(css = "div#home-carousel")
	private WebElement carousel;
	
	@FindBy(css = "div#home-carousel > div.flex-viewport > ul > li:nth-child(1) > article:nth-child(1) a")
	private WebElement firstArticleNameCarousel;
	
	@FindBy(css = "div#home-carousel > div.flex-viewport > ul > li:nth-child(1) > article:nth-child(3) a")
	private WebElement dvPackNameCarousel;
	
	@FindBy(css = "ul.flex-direction-nav i.icon-c-right-open-big")
	private WebElement nextArrowCarousel;
	
	@FindBy(css = "ul.flex-direction-nav i.icon-c-left-open-big")
	private WebElement previousArrowCarousel;
	
	public void clickOnWidget(int widget) {
		if (widget == 1) { widgetOne.click();}
		else if (widget == 2) { widgetTwo.click();}
		else { System.out.println("widg0et does not exist, so go to widget one"); widgetOne.click();}
	}
	
	public void clickOnPreviewPodcast(){
		if(getDriver().findElements(By.cssSelector("li#webinars_dropdown ul > li:nth-child(1) i.icon-c-play")).size() == 1){
			getDriver().findElement(By.cssSelector("li#webinars_dropdown ul > li:nth-child(1) i.icon-c-play")).click();
			System.out.println("Pocast preview");
		}
		else if(getDriver().findElements(By.cssSelector("li#webinars_dropdown ul > li:nth-child(3) i.icon-c-play")).size() == 1){
			getDriver().findElement(By.cssSelector("li#webinars_dropdown ul > li:nth-child(3) i.icon-c-play")).click();
			System.out.println("Pocast preview");
		}
		else{
			System.out.println("There is no podcast in the list");
		}
	}
	
	
	public void clickOnPreviewWebinar(){
		if(getDriver().findElements(By.cssSelector("li#webinars_dropdown ul > li:nth-child(1) div iframe")).size() == 1){
			getDriver().findElement(By.cssSelector("li#webinars_dropdown ul > li:nth-child(1) div iframe")).click();
			System.out.println("Webinar preview");
		}
		else if(getDriver().findElements(By.cssSelector("li#webinars_dropdown ul > li:nth-child(3) div iframe")).size() == 1){
			getDriver().findElement(By.cssSelector("li#webinars_dropdown ul > li:nth-child(3) div iframe")).click();
		}
		else{
			System.out.println("There is no webinar in the list");
			System.out.println("Webinar preview");
		}
	}
	
	
	public void clickOnCircle(int circle) {
		int numberOfCircles = getDriver().findElements(By.cssSelector("ol[class='flex-control-nav flex-control-paging'] > li")).size();
		if(numberOfCircles > 0){
			if(circle > 0 && circle < numberOfCircles){
				getDriver().findElement(By.cssSelector("ol[class='flex-control-nav flex-control-paging'] > li:nth-child( " + circle + ") > a")).click();
				Assert.assertTrue(getDriver().findElement(By.cssSelector("ol[class='flex-control-nav flex-control-paging'] > li:nth-child( " + circle + ") > a")).getAttribute("class").contains("flex-active"));
			}
			else{
				System.out.println("There are not so many items in carousel");
			}
		}
	}
	
	public void clickOnNextArrowFromCarousel(){
		waitUntilElementExists(By.cssSelector("ul.flex-direction-nav i.icon-c-right-open-big"), 20);
//		nextArrowCarousel.click();
		elementClick("ul.flex-direction-nav i.icon-c-right-open-big");
	}
	
	public void clickOnPreviousArrowFromCarousel(){
		waitUntilElementExists(By.cssSelector("ul.flex-direction-nav i.icon-c-left-open-big"), 20);
//		previousArrowCarousel.click();
		elementClick("ul.flex-direction-nav i.icon-c-left-open-big");
	}
	
	public void clickNonActiveCircle() {
		int activeCircleNumber = Integer.parseInt(element(By.cssSelector("a.flex-active")).getText());
		if (activeCircleNumber == 1 || activeCircleNumber == 2){
			element(By.cssSelector("ol[class='flex-control-nav flex-control-paging'] > li:nth-child(" + (activeCircleNumber + 1)  + ") > a")).click();
		} else {
			element(By.cssSelector("ol[class='flex-control-nav flex-control-paging'] > li:nth-child(" + (activeCircleNumber - 1)  + ") > a")).click();
		}
	}
	
	public void verifyHomePage(){
		Assert.assertTrue("HomePage is not displayed", viewAllButtonSpecialReports.isDisplayed());
	}
	
	public void previousArrow() {
		arrowPrevious.click();
	}
	
	public void nextArrow() {
		arrowNext.click();
	}

	public int countNumberOfWidgets() {
		List<WebElementFacade> widgetList = findAll(By.cssSelector("li.flex-active-slide > article"));
		return widgetList.size();
	}
	
	
	public void clickOnWidgetsAndPodcasts(){
		if(getDriver().findElements(By.cssSelector("li#webinars_dropdown")).size()==1){
			if(webinarsAndPodcasts.getAttribute("class").contains("open")){
				System.out.println("Webinars & Podcasts window in already open");
			}
			else{
				webinarsAndPodcasts.click();
				System.out.println("W&P clicked");
			}
		}
	}
	
	public void closePreviewWidgetButton(){
		if(getDriver().findElements(By.cssSelector("div[class='modal-backdrop fade in']")).size() == 1){
//			closePreviewWidgetButton.click();
			WebElement element = getDriver().findElement(By.cssSelector("div[class='modal-backdrop fade in']"));
			element.click();
//			elementClick("div[class='modal webinar hide fade in'] button");
			System.out.println("Closed preview");
		}
	}
	
	public void clickOnViewAllWidgetsAndPodcasts(){
		if(getDriver().findElements(By.cssSelector("li#webinars_dropdown ul > li:last-child > a > strong")).size() == 1) {
			getDriver().findElement(By.cssSelector("li#webinars_dropdown ul > li:last-child > a > strong")).click();
		}
		else{
			System.out.println("There is no webinar or podcast.");
		}
	}
	
	public String clickOnFirstArticleFromCarousel(){
		waitUntilElementExists(By.cssSelector("div#home-carousel"), 10);
		String articleName = null;
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#pillars")).isDisplayed());
		element(carousel).waitUntilVisible();
		if(getDriver().findElements(By.cssSelector("div#home-carousel")).size() > 0){
			element(getDriver().findElement(By.cssSelector("div#home-carousel > div.flex-viewport > ul > li.flex-active-slide > article:nth-child(1) a "))).waitUntilVisible();
			articleName = getDriver().findElement(By.cssSelector("div#home-carousel > div.flex-viewport > ul > li.flex-active-slide > article:nth-child(1) a ")).getText();
			WebElement element = getDriver().findElement(By.cssSelector("div#home-carousel > div.flex-viewport > ul > li.flex-active-slide > article:nth-child(1) a "));
			element.click();
		}
		else{
			System.out.println("There is no item in carousel");
		}
		return articleName;
	}
	
	public void clickOnDvPackFromCarousel(){
		waitUntilElementExists(By.cssSelector("div#home-carousel"), 10);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#pillars")).isDisplayed());
		element(carousel).waitUntilVisible();
		if(getDriver().findElements(By.cssSelector("div#home-carousel")).size() > 0){
			element(getDriver().findElement(By.cssSelector("div#home-carousel > div.flex-viewport > ul > li.flex-active-slide > article:nth-child(3) a"))).waitUntilVisible();
			WebElement element = getDriver().findElement(By.cssSelector("div#home-carousel > div.flex-viewport > ul > li.flex-active-slide > article:nth-child(3) a"));
			element.click();
		}
		else{
			System.out.println("There is no item in carousel");
		}
	}
	
	public void clickOnDvPackFromCarouselAndVerifyPermissionModal(){
		//TODO Fix this
//		BusinessRulesWidgetsPage brwPage=new BusinessRulesWidgetsPage(getDriver());
		waitUntilElementExists(By.cssSelector("div#home-carousel"), 10);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#pillars")).isDisplayed());
		element(carousel).waitUntilVisible();
		if(getDriver().findElements(By.cssSelector("div#home-carousel")).size() > 0){
			element(getDriver().findElement(By.cssSelector("div#home-carousel > div.flex-viewport > ul > li.flex-active-slide > article:nth-child(3) a"))).waitUntilVisible();
			WebElement element = getDriver().findElement(By.cssSelector("div#home-carousel > div.flex-viewport > ul > li.flex-active-slide > article:nth-child(3) a"));
			element.click();
			waitABit(2000);
//			brwPage.verifyPermissionModalByType("");
		}
		else{
			System.out.println("There is no item in carousel");
		}
	}
}

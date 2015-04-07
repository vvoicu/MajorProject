package bmo5.bmo5tests.bmo.pages.homepage;


import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import bmo5.bmo5tests.tools.bmo.AbstractPage;


public class HomePage extends AbstractPage {

	@FindBy (id = "home-carousel")
	private WebElement carouselHomePageBmoFive;
	@FindBy (css = "ol.flex-control-nav.flex-control-paging")
	private WebElement navigationalDotsCarousel;
	@FindBy (css = "section.row-fluid.level-two > article:nth-child(1)  > div > ul > li:nth-child(1)")
	private WebElement containerKeyGlobalViewArticles;
	@FindBy (css = "div.well >a.btn.btn-small")
	private WebElement exploreKeyForecastsButton;
	@FindBy (id = "js-hot-topics")
	private WebElement hotTopicsContainer;
	@FindBy (css = "section.row-fluid.level-three > article:nth-child(2)")
	private WebElement specialReportsContainerList;
	@FindBy (css = "section.row-fluid.level-three > article:nth-child(2) > div > a")
	private WebElement specialReportsContainer;
	@FindBy (css = "section.row-fluid.level-three > article:nth-child(3) >div > a")
	private WebElement webinarsAndPodcastsContainer;
	@FindBy (css = " a[href='/hottopics'] > strong ") 
	private WebElement hotTopicsViewAllButton;
	@FindBy (css = "div.navbar-inner > ul:nth-child(2) > li:nth-child(1) > ul.dropdown-menu")
	private WebElement hotTopicsContainerList;

	public void clickExploreButton() {

		Assert.assertTrue("not found!", exploreKeyForecastsButton.isDisplayed());
		exploreKeyForecastsButton.click();
	}

	public void clickViewAllSpecialReports() {
		specialReportsContainerList.click();
	}
	
	public void clickViewAllHotTopics() {
		hotTopicsContainer.click();
		element(hotTopicsContainerList).waitUntilVisible();
		hotTopicsContainerList.click();
		Assert.assertTrue("not found!", hotTopicsViewAllButton.isDisplayed());
		hotTopicsViewAllButton.click();
	}
	
	public void clickViewAllWebinarsAndPodcasts() {

		Assert.assertTrue("not found!", webinarsAndPodcastsContainer.isDisplayed());
		webinarsAndPodcastsContainer.click();
	}
	
	public void mouseOverCarousel() {
		Actions actions = new Actions(getDriver());
		WebElement menuHoverLink = getDriver().findElement(By.id("home-carousel"));
		actions.moveToElement(menuHoverLink);
		actions.click();
		actions.perform();
		waitABit(10000);
	}
	
	public void navigationalDots(int element) {

		element(navigationalDotsCarousel).waitUntilVisible();
		navigationalDotsCarousel.click();

		List<WebElement> allElements = navigationalDotsCarousel.findElements(By
				.cssSelector("li a"));

		for (WebElement dots : allElements) {
			if (dots.getText().equals(element)) {
				dots.click();

				break;
			}

		}
	}

	public void keyGlobalArticles() {
		element(containerKeyGlobalViewArticles).waitUntilVisible();
		containerKeyGlobalViewArticles.click();
		Assert.assertTrue("Article was not selected", containerKeyGlobalViewArticles.isDisplayed());
	}

	public void verifyHomePageTitlePresenceOfButtons( String keyViews, String keyForecasts, String hotTopic, String specialReport, String webinars) {
		waitABit(5000);
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(4) > article:nth-child(1) > div > h5")).getText().contains(keyViews));
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(4) > article:nth-child(2) > div > h5")).getText().contains(keyForecasts));
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(4) > article:nth-child(1) > div > a")).isDisplayed());
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(4) > article:nth-child(1) > div > a")).isDisplayed());
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article:nth-child(1) > div > h5")).getText().contains(hotTopic));
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article:nth-child(2) > div > h5")).getText().contains(specialReport));
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article:nth-child(3) > div > h5")).getText().contains(webinars));
		waitABit(3000);
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article:nth-child(1) > div > a")).isDisplayed());
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article:nth-child(2) > div > a")).isDisplayed());
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article:nth-child(3) > div > a")).isDisplayed());


	}

	public void verifyHomePageKeyGlobalViews(String keyGlobalViews){
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(4) > article:nth-child(1) > div > h5")).getText().contains(keyGlobalViews));
	}

}
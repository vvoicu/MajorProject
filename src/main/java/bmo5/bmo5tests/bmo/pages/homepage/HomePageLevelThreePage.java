package bmo5.bmo5tests.bmo.pages.homepage;

import net.thucydides.core.annotations.findby.FindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class HomePageLevelThreePage extends AbstractPage{

	@FindBy(css = "a[class='btn btn-small'][href='/hottopics']")
	@CacheLookup
	private WebElement hotTopicsViewAll;
	
	@FindBy(css = "section[class='row-fluid level-three'] > article:nth-child(2) > div > ul:nth-child(2) > li:nth-child(1) > a")
	@CacheLookup
	private WebElement specialReportsFirstArticle;
	
	@FindBy(css = "section[class='row-fluid level-three'] > article:nth-child(2) > div > a:nth-child(3)")
	@CacheLookup
	private WebElement specialReportsViewAll;
	
	@FindBy(css = "section[class='row-fluid level-three'] > article:nth-child(3) > div > ul:nth-child(2) > li:nth-child(1) > a")
	@CacheLookup
	private WebElement webinarsAndPodcastsFirstArticle;
	
	@FindBy(css = "section[class='row-fluid level-three'] > article:nth-child(3) > div > a:nth-child(3)")
	@CacheLookup
	private WebElement webinarsAndPodcastsViewAll;
	
	
	public void hotTopicsViewAll() {
		hotTopicsViewAll.click();
	}
	
	public void specialReportsFirstArticle() {
		specialReportsFirstArticle.click();
	}
	
	public void specialReportsClickOnArticle(int articleNumber) {
		int numberOfSpecialReports = getDriver().findElements(By.cssSelector("section[class='row-fluid level-three'] > article:nth-child(2) ul > li")).size();
		if (articleNumber > 0 && articleNumber < numberOfSpecialReports) {
			element(By.cssSelector("section.row-fluid level-three > article:nth-child(2) > div > ul:nth-child(2) > li:nth-child(" + articleNumber + ") > a")).click();
		} else {
			System.out.println("There are not so many reports");
		}
	}
	
	public void specialReportsViewAll() {
		specialReportsViewAll.click();
	}
	
	public void webinarsAndPodcastsFirstArticle() {
		webinarsAndPodcastsFirstArticle.click();
	}
	
	public void webinarsAndPodcastsClickOnArticle(int articleNumber) {
		int numberOfWebinarsAndPodcasts = getDriver().findElements(By.cssSelector("section[class='row-fluid level-three'] > article:nth-child(3) ul > li")).size();
		if (articleNumber > 0 && articleNumber < numberOfWebinarsAndPodcasts) {
			element(By.cssSelector("section.row-fluid level-three > article:nth-child(3) > div > ul:nth-child(2) > li:nth-child(" + articleNumber + ") > a")).click();
		} else {
			System.out.println("There are not so many webinars and podcasts");
		}
	}
	
	public void webinarsAndPodcastsViewAll() {
		webinarsAndPodcastsViewAll.click();
	}	
}

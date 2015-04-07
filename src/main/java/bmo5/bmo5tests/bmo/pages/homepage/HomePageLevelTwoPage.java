package bmo5.bmo5tests.bmo.pages.homepage;

import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class HomePageLevelTwoPage extends AbstractPage {

	@FindBy(css = "section[class='row-fluid level-two'] > article:nth-child(1) > div > a")
	@CacheLookup
	private WebElement keyGlobalViewsViewAll;
	
	@FindBy(partialLinkText = "Explore")
	@CacheLookup
	private WebElement exploreKeyGlobalForecasts;
	
	public void viewAllKeyGlobalViews() {
		keyGlobalViewsViewAll.click();
	}
	
	public void clickOnKeyGlobalViewsArticle(int article) {
		if (article > 0 && article < 9) {
		element(By.cssSelector("section[class='row-fluid level-two'] > article:nth-child(1) > div > ul:nth-child(2) > li:nth-child(" + article + ") > a")).click();
		}
	}
	
	public void clickOnKeyGlobalForecasts() {
		exploreKeyGlobalForecasts.click();
	}
	
	public String clickOnArticleFromKeyGlobalViews(int articleNumber){
		int numberOfArticles = getDriver().findElements(By.cssSelector("ul.listing.listing-bordered > li")).size();
		String articleName = null;
		if(numberOfArticles > 0){
			if(articleNumber > 0 && articleNumber < numberOfArticles){
				articleName = getDriver().findElement(By.cssSelector("ul.listing.listing-bordered > li:nth-child(" + articleNumber + ") a")).getText();
				getDriver().findElement(By.cssSelector("ul.listing.listing-bordered > li:nth-child(" + articleNumber + ") a")).click();
			}
			else{
				System.out.println("There are not so many articles in listing, so click the first one");
				articleName = getDriver().findElement(By.cssSelector("ul.listing.listing-bordered > li:nth-child(1) a")).getText();
				getDriver().findElement(By.cssSelector("ul.listing.listing-bordered > li:nth-child(1) a")).click();
			}
		}
		System.out.println(articleName);
		return articleName;
	}
	
	public String getCellValueFromKeyGlobalForecasts(int row, int column){
		String cellValue=null;
		List<WebElement>rows=getDriver().findElements(By.cssSelector("table[class = 'dvpack_table table table-condensed'] > tbody > tr"));
		List<WebElement>columns=getDriver().findElements(By.cssSelector("table[class = 'dvpack_table table table-condensed'] > tbody > tr > td"));
		if(row>0&&row<=rows.size()&&column>0&&column<=columns.size()){
		 cellValue= getDriver().findElement(By.cssSelector("table[class = 'dvpack_table table table-condensed'] > tbody > tr:nth-child("+row+") > td:nth-child("+column+")")).getText();
		}
		return cellValue;
	}
}

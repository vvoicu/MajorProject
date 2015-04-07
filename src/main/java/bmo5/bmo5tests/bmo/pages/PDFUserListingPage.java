package bmo5.bmo5tests.bmo.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class PDFUserListingPage extends AbstractPage{
	
	@FindBy(css = "div.sidebar.well > ul > li:nth-child(3) >ul")
	private WebElement dateRangeContainer;
	
	@FindBy(css = "div[class='btn-group bootstrap-select open'] > ul")
	private WebElement sortByItemContainer;
	
	@FindBy(css = "div[class='btn-group bootstrap-select open'] > ul")
	private WebElement sortByOrderContainer;
	
	@FindBy(css = "span.pull-right.btn-small-style >  span > div:nth-of-type(1) > button")
	private WebElement sortByItemDropDownList;
	
	@FindBy(css = "span.pull-right.btn-small-style >  span > div:nth-of-type(2) > button")
	private WebElement sortByOrderDropDownList;
	
	@FindBy(css = "div.btn-toolbar.pull-left > a")
	private WebElement backToPreviousPageButton;
	
	public void clickOnOneReportFromListing(int reportNumber){
		int numberOfReports = getDriver().findElements(By.cssSelector("div.media-listing  > div")).size();
//		String reportName;
		if(numberOfReports > 0){
			if(reportNumber < numberOfReports && reportNumber > 0){
//				reportName = getDriver().findElement(By.cssSelector("div.media-listing  > div:nth-child(" + reportNumber + ")  h5 >a")).getText();
				getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + reportNumber + ")  h5 >a")).click();
			}
			else{
				System.out.println("There are not so many report in listing, so click the first one.");
//				reportName = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(1) h5 >a")).getText();
				getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(1)  h5 > a")).click();
			}
		}
		else{
			System.out.println("There is no report in list.");
		}
	}
	
	public void clickOnViewArchiveOfOneReportFromListing(int reportNumber){
		int numberOfReports = getDriver().findElements(By.cssSelector("div.media-listing.border-top  > div > div > a:nth-child(2)")).size();
		if(numberOfReports > 0){
			if(reportNumber < numberOfReports && reportNumber > 0){
				if(getDriver().findElements(By.cssSelector("div.media-listing.border-top  > div:nth-child(" + reportNumber + ") > div > a")).size() == 2){
					getDriver().findElement(By.cssSelector("div.media-listing.border-top  > div:nth-child(" + reportNumber + ") > div > a:nth-child(1)")).click();
				}
				else{
					for(int i=reportNumber; i<=numberOfReports; i++){
						if(getDriver().findElements(By.cssSelector("div.media-listing.border-top  > div:nth-child(" + i + ") > div > a")).size() == 2){
							getDriver().findElement(By.cssSelector("div.media-listing.border-top  > div:nth-child(" + i + ") > div > a:nth-child(1)")).click();
							break;
						}
					}
				}
			}
			else{
				System.out.println("There are not so many reports in listing, so click the first one.");
				for(int i=1; i<=numberOfReports; i++){
					if(getDriver().findElements(By.cssSelector("div.media-listing.border-top  > div:nth-child(" + i + ") > div > a")).size() == 2){
						getDriver().findElement(By.cssSelector("div.media-listing.border-top  > div:nth-child(" + i + ") > div > a:nth-child(1)")).click();
						break;
					}
				}
			}
		}
		else{
			System.out.println("There is no report in list.");
		}
	}
	
	//TODO fix this
//	public void clickOnDownloadButtonOfOneItemFromViewArchivePage(int itemNumber){
//		int numberOfItems = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
//		String reportName;
////		SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
//		FileChecker fileChecker = new FileChecker();
//		if(numberOfItems > 0){
//			if(itemNumber < numberOfItems && itemNumber > 0){
//				reportName = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + itemNumber + ") > h4 > a")).getText();
//				getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + itemNumber + ") a")).click();
////				singleArticle.performDownload();
//				fileChecker.verifyFileIsDownloaded1(reportName);
//			}
//			else{
//				System.out.println("There are not so many report in listing, so click the first one.");
//				reportName = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(1) > h4 > a")).getText();
//				getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(1) a")).click();
////				singleArticle.performDownload();
//				fileChecker.verifyFileIsDownloaded1(reportName);
//			}
//		}
//		else{
//			System.out.println("There is no report in list.");
//		}
//	}
	
	public void selectDateRange(String dateRangeName){
		element(dateRangeContainer).waitUntilVisible();
		waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) >ul > li:nth-child(5) > label")));
		
		int numberOfPublicationDates = getDriver().findElements(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) >ul > li > label")).size();
		for(int i = 1; i<=numberOfPublicationDates; i++){
			if(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) >ul > li:nth-child(" + i + ") > label")).getAttribute("for").contains(dateRangeName)){
				getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) >ul > li:nth-child(" + i + ") > label")).click();
				Assert.assertTrue(verifyElementState("document.getElementById('" + dateRangeName + "-date')"));
				break;
			}
		}
	}
	
	public void selectSortByResultsItem(String sortByNameItem){
		element(sortByItemDropDownList).waitUntilVisible();
		sortByItemDropDownList.click();
		waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='btn-group bootstrap-select open'] > ul")));
		
		List<WebElement> itemsList = sortByItemContainer.findElements(By.cssSelector("span"));
		for(WebElement elementNow:itemsList){
			if(elementNow.getText().contains(sortByNameItem.toString())){  
				elementNow.click();
				break;
			}
		}
//		selectFromDropdown(sortByItemDropDownList, sortByNameItem);
		waitABit(10000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("span.pull-right.btn-small-style >  span > div:nth-of-type(1) > button > div.filter-option.pull-left")).getText().contains(sortByNameItem));
		
	}
	
	public void selectSortByResultsOrder(String sortByNameOrder){
		element(sortByOrderDropDownList).waitUntilVisible();
		sortByOrderDropDownList.click();
		waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='btn-group bootstrap-select open'] > ul")));
		List<WebElement> itemsList = sortByOrderContainer.findElements(By.cssSelector("span"));
		for(WebElement elementNow:itemsList){
			if(elementNow.getText().contains(sortByNameOrder.toString())){
				elementNow.click();
				break;
			}
		}
//		selectFromDropdown(sortByOrderDropDownList, sortByNameOrder);
		waitABit(10000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("span.pull-right.btn-small-style >  span > div:nth-of-type(2) > button > div.filter-option.pull-left")).getText().contains(sortByNameOrder));
	}
	
	public void clickOnBackToPreviousPageButton(){
		if(getDriver().findElements(By.cssSelector("div.btn-toolbar.pull-left > a")).size() > 0){
			backToPreviousPageButton.click();
		}
	}
}

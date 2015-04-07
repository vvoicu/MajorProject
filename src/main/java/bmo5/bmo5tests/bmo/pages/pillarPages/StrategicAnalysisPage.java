package bmo5.bmo5tests.bmo.pages.pillarPages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class StrategicAnalysisPage extends AbstractPage{
	
	@FindBy(css = "article > h4")
	@CacheLookup
	private WebElement articleTitleStrategicAnalysisPage;
	
	@FindBy(css = "i.icon-c-download")
	@CacheLookup
	private WebElement downloadIconArticle;
	
	@FindBy(css="div[class='btn-group pull-right'] i.icon-c-download")
	@CacheLookup
	private WebElement downloadIconPreviewWindow;
	
	public void verifyTitleStrategicAnalysisPage(String text){
		Assert.assertTrue("Article title did not contain " + text + "!",
				articleTitleStrategicAnalysisPage.getText().contains(text));
	}
	
	//TODO fix this
//	public void clickOnDownloadButtonArticleStrategicAnalysis(String fileName) {
//		downloadIconArticle.click();
//		SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
//		singleArticle.performDownload();
//		FileChecker fileChecker = new FileChecker();
//		fileChecker.verifyFileIsDownloadedRelatives(fileChecker.convertFileName(fileName));
//	}
//	
//	
//	public void clickOnDownloadIconPreviewArticleStrategicAnalysisPage(String fileName){
//		downloadIconPreviewWindow.click();
//		DataToolPage data = new DataToolPage(getDriver());
//		data.saveImageHandle2();
//		FileChecker fileChecker = new FileChecker();
//		System.out.println(fileChecker.convertFileName(fileName));
//		fileChecker.verifyFileIsDownloadedRelatives(fileChecker.convertFileName(fileName));
//	}
	
	//TODO fix this
//	public String clickOnArchivesOfOneArticleFromList(int articleNumber, int archiveNumber){
//		int numberOfArticlesDisplayed, numberOfArchives;
//		numberOfArticlesDisplayed = getDriver().findElements(By.cssSelector("div#sar-container h5")).size();
//		String archivesTitle="";
//		if (numberOfArticlesDisplayed > 0) {
//			if (articleNumber <= numberOfArticlesDisplayed && articleNumber > 0) {
//				if(getDriver().findElements(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > ul > li:last-child > a.get-sar-archive")).size() == 1){
//					getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > ul > li:last-child > a.get-sar-archive")).click();
//					Sleeper.sleepTight(10000);
//					numberOfArchives = getDriver().findElements(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:last-child > ul > li a.get-sar-archive")).size();
//					System.out.println(numberOfArchives);
//					if(numberOfArchives > 0){
//						if(archiveNumber < numberOfArchives && archiveNumber > 0){
//							String archiveTitle = getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:last-child > ul > li:nth-child("+ archiveNumber + ") > a.get-sar-archive")).getText();
//							 getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:last-child > ul > li:nth-child("+ archiveNumber + ") > a.get-sar-archive ")).click();
//							 SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
//							 singleArticle.verifyBreadCrumbArticle(archiveTitle);
//							 singleArticle.clickOnBackToPreviousPage();
//						}//div#sar-container > div:nth-child(3) > div:nth-child(1) > div.related > div.tab-content > div:last-child > ul > li:nth-child(3) > a
//						else if(getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:last-child > ul > li:nth-child(1)")).getText().contains("No results found")){
//							System.out.println("There is no archive in the list");
//						}
//						else{
//							System.out.println("There are not so many archives, so click the first one.");
//							String archiveTitle = getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:last-child > ul > li:nth-child(1) > a.get-sar-archive")).getText();
//							 getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:last-child > ul > li:nth-child(1) > a.get-sar-archive")).click();
//							 SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
//							 singleArticle.verifyBreadCrumbArticle(archiveTitle);
//							 singleArticle.clickOnBackToPreviousPage();
//						}
//					}
//					else{
//						System.out.println("There are no archives in the list.");
//					}
//				}
//				else{
//					System.out.println("There is no related content");
//				}
//				
//			} else {
//				System.out.println("There aren't so many reports displayed so clicking the first report");
//				
//				getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(1) > div.related > ul  > li:last-child > a.get-sar-archive")).click();
//				
//				Sleeper.sleepTight(5000);
//				numberOfArchives = getDriver().findElements(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:last-child > ul > li a.get-sar-archive")).size();
//				if(numberOfArchives > 0){
//					if(archiveNumber < numberOfArchives && archiveNumber > 0){
//						String archiveTitle = getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:last-child > ul > li:nth-child("+ archiveNumber + ") > a.get-sar-archive")).getText();
//						 getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:last-child > ul > li:nth-child("+ archiveNumber + ") > a.get-sar-archive ")).click();
//						 SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
//						 singleArticle.verifyBreadCrumbArticle(archiveTitle);
//						 singleArticle.clickOnBackToPreviousPage();
//					}
//					else if(getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:last-child > ul > li:nth-child(1)")).getText().contains("No results found")){
//						System.out.println("There is no archive in the list");
//					}
//					else{
//						System.out.println("There are not so many archives, so click the first one.");
//						String archiveTitle = getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:last-child > ul > li:nth-child(1) > a.get-sar-archive")).getText();
//						 getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:last-child > ul > li:nth-child(1) > a.get-sar-archive")).click();
//						 SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
//						 singleArticle.verifyBreadCrumbArticle(archiveTitle);
//						 singleArticle.clickOnBackToPreviousPage();
//					}
//				}
//				else{
//					System.out.println("There are no archives in the list.");
//				}
//			}
//		} else {
//			System.out.println("There aren't any reports!");
//		}
//		return archivesTitle;
//	}
	
	//TODO fix this
//	public String clickOnRelatedContentOfOneArticleFromList(int articleNumber, int relatedContentNumber){
//		int numberOfArticlesDisplayed, numberOfRelatedContents;
////		String articleTitle[];
//		numberOfArticlesDisplayed = getDriver().findElements(By.cssSelector("div#sar-container h5")).size();
////		HomePageTopMenuPage homePage = new HomePageTopMenuPage(getDriver());
//		String relatedContentTitle="";
//		if (numberOfArticlesDisplayed > 0) {
//			if (articleNumber <= numberOfArticlesDisplayed && articleNumber > 0) {
//				if(getDriver().findElements(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > ul > li:nth-child(2) > a.get-sar-related-content")).size() == 1){
//					getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > ul > li:nth-child(2) > a.get-sar-related-content")).click();
//					Sleeper.sleepTight(10000);
//					numberOfRelatedContents = getDriver().findElements(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li")).size();
//					if(numberOfRelatedContents > 0){
//						if(relatedContentNumber < numberOfRelatedContents && relatedContentNumber > 0){
////							 relatedContentTitle = getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li:nth-child("+ relatedContentNumber + ") > a")).getText();
////							 System.out.println(relatedContentTitle);
////							 articleTitle = relatedContentTitle.split("-");
////							 System.out.println(articleTitle.length);
//							 getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li:nth-child("+ relatedContentNumber + ") > a ")).click();
////							 if(articleTitle.length == 5){
////								 System.out.println(articleTitle);
////								 relatedContentTitle = articleTitle[2];
////								 System.out.println(relatedContentTitle);
////								 homePage.verifyBreadCrumb(relatedContentTitle);
////							 }
//							 SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
//							 singleArticle.clickOnBackToPreviousPage();
//						}
//						else{
//							System.out.println("There are not so many archives, so click the first one.");
////							relatedContentTitle = getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li:nth-child(1) > a")).getText();
////							articleTitle = relatedContentTitle.split("-");
////							 relatedContentTitle = articleTitle[2];
//							 getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li:nth-child(1) > a")).click();
////							 System.out.println(relatedContentTitle);
////							 articleTitle = relatedContentTitle.split("-");
////							 System.out.println(articleTitle.length);
////							 getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li:nth-child("+ relatedContentNumber + ") > a ")).click();
////							 if(articleTitle.length == 5){
////								 System.out.println(articleTitle);
////								 relatedContentTitle = articleTitle[2];
////								 System.out.println(relatedContentTitle);
////								 homePage.verifyBreadCrumb(relatedContentTitle);
////							 }
//							 SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
//							 singleArticle.clickOnBackToPreviousPage();
//						}
//					}
//					else{
//						System.out.println("There are no related contents in the list.");
//					}
//				}
//				else{
//					System.out.println("There is no related content to this article.");
//				}
//				
//			} else {
//				System.out.println("There aren't so many reports displayed so clicking the first report");
//				if(getDriver().findElements(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(1) > div.related > ul  > li:last-child > a.get-sar-related-content")).size() == 1){
//					getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(1) > div.related > ul  > li:last-child > a.get-sar-related-content")).click();
//					
//					Sleeper.sleepTight(5000);
//					numberOfRelatedContents = getDriver().findElements(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li")).size();
//					if(numberOfRelatedContents > 0){
//						if(relatedContentNumber < numberOfRelatedContents && relatedContentNumber > 0){
////							relatedContentTitle = getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li:nth-child("+ relatedContentNumber + ") > a")).getText();
//							 getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li:nth-child("+ relatedContentNumber + ") > a")).click();
////							 singleArticle.verifyBreadCrumbArticle(relatedContentTitle);
//							 SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
//							 singleArticle.clickOnBackToPreviousPage();
//						}
//						else{
//							System.out.println("There are not so many archives, so click the first one.");
////							 relatedContentTitle = getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li:nth-child(1) > a")).getText();
//							 getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li:nth-child(1) > a")).click();
////							 singleArticle.verifyBreadCrumbArticle(relatedContentTitle);
//							 SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
//							 singleArticle.clickOnBackToPreviousPage();
//						}
//					}
//					else{
//						System.out.println("There are no related contents in the list.");
//					}
//				}
//			}
//		} else {
//			System.out.println("There aren't any reports!");
//		}
//		return relatedContentTitle;
//	}
	
	public void verifyCategoryIsDeselected(String category){
		int categorySectionNumber=4, categoryNumber;
		WebElement categoryContainer=getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+categorySectionNumber+") > div.expandable-wrapper > ul"));
		List<WebElement> categories=categoryContainer.findElements(By.cssSelector("li > label > div[id*='uniform-c_']"));
		
		for(int i=0;i<categories.size();i++){
			categoryNumber=i+2;
			  if(getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+categorySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+categoryNumber+")> label")).getText().contains(category)){
				  Assert.assertTrue("Category is checked",!getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+categorySectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+categoryNumber+")> label > div > span")).getAttribute("class").contains("checked"));
			  }
		}
	}
	
	public void verifyNumberOfCategories(int categoryNumber){
		int numberOfCategoriesNow=getNumberOfCategories();
		Assert.assertEquals(categoryNumber, numberOfCategoriesNow);
	}
	
	public int getNumberOfCategories(){
		int categorySectionNumber=4;
		WebElement categoryContainer=getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+categorySectionNumber+") > div.expandable-wrapper > ul"));
		List<WebElement> categories=categoryContainer.findElements(By.cssSelector("li > label > div[id*='uniform-c_']"));
		return categories.size();
	}
	
	public void selectCategoryFromLeftHand(String category){
		if(getDriver().findElements(By.cssSelector("label[title='"+category+"']")).size()==1){
		getDriver().findElement(By.cssSelector("label[title='"+category+"']")).click();
		waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
		waitUntilElementDoesntExist(By.cssSelector("div.click-blocker"), 30);
		}
		else if(getDriver().findElements(By.cssSelector("ul#categories-list > li > label")).size()!=0){
			getDriver().findElement(By.cssSelector("ul#categories-list > li:nth-of-type(3) > label")).click();
			waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
			waitUntilElementDoesntExist(By.cssSelector("div.click-blocker"), 30);
		}
	}
}

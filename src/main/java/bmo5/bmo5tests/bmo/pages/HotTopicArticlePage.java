package bmo5.bmo5tests.bmo.pages;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class HotTopicArticlePage extends AbstractPage{
	
	@FindBy(css="ul.nav.nav-list.dropdown-list > li.active > a")
	@CacheLookup
	private WebElement firstHotTopicPanel;
	
	@FindBy(css="article > h4")
	@CacheLookup
	private WebElement pageNameHotTopic;
	
	@FindBy(css="div.container-fluid > h3")
	@CacheLookup
	private WebElement pageTitleHotTopic;
	
	@FindBy(css = "ul.breadcrumb > li:last-child")
	@CacheLookup
	private WebElement breadcrumbLast;
	
	@FindBy(css = "section i.icon-c-cancel")
	@CacheLookup WebElement printPagePreviewCancel;
	
	public String clickOnHotTopicFromLeftHandPanel(int articleNumber) {
		int numberOfHotTopicsDisplayed = getDriver().findElements(
				By.cssSelector("ul[class='nav nav-list dropdown-list'] > li")).size();
		WebElement hotTopicsArticle;
		String articleText = "";
		if (numberOfHotTopicsDisplayed > 0) {
			if (articleNumber <= numberOfHotTopicsDisplayed && articleNumber > 0) {
				hotTopicsArticle = element(By.cssSelector("div[class='sidebar well'] > ul > li > ul > li:nth-child(" + articleNumber + ") > a"));
			} else {
				System.out.println("There aren't so many articles displayed in Hot Topics Top Menu so clicking the first article");
				hotTopicsArticle = element(By
						.cssSelector("div[class='sidebar well'] > ul > li > ul > li:nth-child(1) > a"));
			}
			articleText = hotTopicsArticle.getText();
			hotTopicsArticle.click();
			return articleText;
		} else {
			System.out.println("There aren't any articles in Hot Topics Top Menu");
			return articleText = "";
		}
	}

	public void verifyFirstHotTopicPageName(){
		Assert.assertEquals(firstHotTopicPanel.getText(), pageNameHotTopic.getText());
	}
	
	public String getTheNameOfSelectedHotTopic(){
		System.out.println(element(By.cssSelector("div[class='sidebar well'] > ul > li > ul > li.active")).getText());
		return(element(By.cssSelector("div[class='sidebar well'] > ul > li > ul > li.active")).getText());
	}
	
	public int countArticles() {
		return getDriver().findElements(By.cssSelector("article div.media-listing > div")).size();
	}
	
	public String clickArticle(int articleNumber) {
		int articles = countArticles();
		String articleTitle = "";
		if(articles > 0){
			if (articleNumber > 0 && articleNumber <= articles) {
				articleTitle = getDriver().findElement(By.cssSelector("article div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1) > h5 > a")).getText();
				getDriver().findElement(By.cssSelector("article div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1) > h5 > a")).click();
			}
			else{
				System.out.println("There are not so manna articles, so click on the fisrt one!");
				articleTitle = getDriver().findElement(By.cssSelector("article div.media-listing > div:nth-child(1) > div:nth-child(1) > h5 > a")).getText();
				getDriver().findElement(By.cssSelector("article div.media-listing > div:nth-child(1) > div:nth-child(1) > h5 > a")).click();
			}
		}
		else{
			System.out.println("There is no article in listing!");
		}
		System.out.println(articleTitle);
		return articleTitle;
	}
	
	public void clickOnEmailIconArticleFromList(int articleNumber){
		int numberOfArticlesDisplayed = countArticles();
		if (numberOfArticlesDisplayed > 0) {
			if (articleNumber <= numberOfArticlesDisplayed	&& articleNumber > 0) {
				elementClick("article div.media-listing > div:nth-child(" + articleNumber + ")  a > i.icon-c-email");
			} else {
				System.out.println("There aren't so many articles displayed so click on the first article");
				elementClick("article div.media-listing > div:nth-child(1) a > i.icon-c-email");
			}
		} else {
			System.out.println("There aren't any articles");
		}
	}
	
	public void clickOnSaveIconArticleFromList(int articleNumber){
		int numberOfArticlesDisplayed = countArticles();
		if (numberOfArticlesDisplayed > 0) {
			if (articleNumber <= numberOfArticlesDisplayed && articleNumber > 0) {
				elementClick("article div.media-listing > div:nth-child(" + articleNumber + ")  a > i.icon-c-floppy");
//				Assert.assertTrue(getDriver().findElement(By.cssSelector("div#result > div")).isDisplayed());
			} else {
				System.out.println("There aren't so many articles displayed so click on the first article");
				elementClick("article div.media-listing > div:nth-child(1) a > i.icon-c-floppy");
//				Assert.assertTrue(getDriver().findElement(By.cssSelector("div#result > div")).isDisplayed());
			}
		} else {
			System.out.println("There aren't any articles");
		}
	}
	
	public void clickOnPrintIconArticleFromList(int articleNumber){
		int numberOfArticlesDisplayed = countArticles();
		String articleTitle = null;
		if (numberOfArticlesDisplayed > 0) {
			if (articleNumber <= numberOfArticlesDisplayed
					&& articleNumber > 0) {
				articleTitle = getDriver().findElement(By.cssSelector("article div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1)  > h5 > a")).getText();
				elementClick("article div.media-listing > div:nth-child(" + articleNumber + ")> div:nth-child(2) > div > a > i.icon-c-print");
				String winHandleBefore = getDriver().getWindowHandle();
				for (String winHandle : getDriver().getWindowHandles()) {
					getDriver().switchTo().window(winHandle);
				}
				printPagePreviewCancel.click();
				getDriver().switchTo().window(winHandleBefore);
			} else {
				System.out
						.println("There aren't so many articles displayed so click on the first article");
				articleTitle = getDriver().findElement(By.cssSelector("article div.media-listing > div:nth-child(1) > div:nth-child(1)  > h5 > a")).getText();
				elementClick("article div.media-listing > div:nth-child(1) a > i.icon-c-print");
				String winHandleBefore = getDriver().getWindowHandle();
				for (String winHandle : getDriver().getWindowHandles()) {
					getDriver().switchTo().window(winHandle);
				}
				Assert.assertTrue(getDriver().findElement(By.cssSelector("div.padding-20 > h4#use")).getText().contains(articleTitle));
				printPagePreviewCancel.click();
				getDriver().switchTo().window(winHandleBefore);
			}
		} else {
			System.out
					.println("There aren't any articles");
		}
	}
	
	//TODO fix this
//	public void clickOnDownloadIconArticleFromList(int articleNumber){
//		int numberOfArticlesDisplayed = countArticles();
//		String articleTitle="";
//		if (numberOfArticlesDisplayed > 0) {
//			if (articleNumber <= numberOfArticlesDisplayed
//					&& articleNumber > 0) {
//				elementClick("article div.media-listing > div:nth-child(" + articleNumber + ")  a > i.icon-c-download");
//				articleTitle = getDriver().findElement(By.cssSelector("article div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1)  > h5 > a")).getText();
//				DataToolPage data = new DataToolPage(getDriver());
//				data.saveImageHandle2();
//				FileChecker fileChecker = new FileChecker();
//				System.out.println(fileChecker.convertFileName(articleTitle));
//				fileChecker.verifyFileIsDownloadedRelatives(fileChecker.convertFileName(articleTitle));
//			} else {
//				System.out
//						.println("There aren't so many articles displayed so clicking the first article");
//				elementClick("article div.media-listing > div:nth-child(1)  a > i.icon-c-download");
//				articleTitle = getDriver().findElement(By.cssSelector("article div.media-listing > div:nth-child(1) > div:nth-child(1)  > h5 > a")).getText();
//				DataToolPage data = new DataToolPage(getDriver());
//				data.saveImageHandle2();
//				FileChecker fileChecker = new FileChecker();
//				System.out.println(fileChecker.convertFileName(articleTitle));
//				fileChecker.verifyFileIsDownloadedRelatives(fileChecker.convertFileName(articleTitle));
//			}
//		} else {
//			System.out
//					.println("There aren't any articles");
//		}
//	}
	
	public String clickOnPreviewArticle(int articleNumber){
		int numberOfHotTopicsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size() ;
		String articleTitle="";
		if (numberOfHotTopicsDisplayed > 0) {
			if (articleNumber <= numberOfHotTopicsDisplayed
					&& articleNumber > 0) {
				if(getDriver().findElements(By.cssSelector("div#media-preview-container div.media ")).size() == 1 && getDriver().findElement(By.cssSelector("div#media-preview-container div.media ")).isDisplayed()){
					System.out.println("Preview window is already open");
				}
				else{
					elementClick("article div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(2) > div:nth-child(2) > a");
					articleTitle = getDriver().findElement(By.cssSelector("article div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1) > h5 > a")).getText();
					waitUntilElementExists(By.cssSelector("button#close_preview"), 30);
				}
			} else {
				System.out.println("There aren't so many articles displayed so click on the first article");
				if(getDriver().findElements(By.cssSelector("div#media-preview-container div.media ")).size() == 1 && getDriver().findElement(By.cssSelector("div#media-preview-container div.media ")).isDisplayed()){
					System.out.println("Preview window is already open");
				}
				else{
					elementClick("article div.media-listing > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > a");
					articleTitle = getDriver().findElement(By.cssSelector("article div.media-listing > div:nth-child(1) > div:nth-child(1) > h5 > a  ")).getText();
					waitUntilElementExists(By.cssSelector("button#close_preview"), 30);
				}
			}
		} else {
			System.out
					.println("There aren't any articles");
		}
		return articleTitle;
	}
}

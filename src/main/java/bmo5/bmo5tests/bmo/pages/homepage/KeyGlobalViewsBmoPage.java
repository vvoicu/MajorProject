package bmo5.bmo5tests.bmo.pages.homepage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class KeyGlobalViewsBmoPage extends AbstractPage {

	@FindBy(css = "div#permission-enterprise-user strong")
	private WebElement alertMessageEnterprise;
	
	@FindBy(css = "div#permission-enterprise-user > div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowEnterprise;
	
	@FindBy(css = "div#permission-modal-print strong")
	private WebElement alertMessagePrint;
	
	@FindBy(css = "div#permission-modal-print div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialPrint;
	
	@FindBy(css = "div#permission-modal-print div:nth-child(2) > a")
	private WebElement contactAccountManagementButtonTrialPrint;
	
	@FindBy(css = "div#permission-modal-pdf strong")
	private WebElement alertMessageDownload;
	
	@FindBy(css = "div#permission-modal-pdf div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialDownload;
	
	@FindBy(css = "div#permission-modal-pdf div:nth-child(2) > a")
	private WebElement contactAccountManagementButtonTrialDownload;
	
	public void clickOnSaveButtonOfAnArticleFromListEnterpriseUser(int articleNumber){
		int numberOfArticles = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		if(numberOfArticles > 0){
			if(articleNumber < numberOfArticles && articleNumber > 0){
				elementClick("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(2) i.icon-c-floppy");
				Assert.assertTrue(alertMessageEnterprise.isDisplayed());
				cancelButtonModalWindowEnterprise.click();
			}
			else{
				elementClick("div.media-listing > div:nth-child(1) > div:nth-child(2) i.icon-c-floppy");
				Assert.assertTrue(alertMessageEnterprise.isDisplayed());
				cancelButtonModalWindowEnterprise.click();
			}
		}
		else{
			System.out.println("There is no article in listing");
		}
	}
	
	public void clickOnPrintButtonOfAnArticleFromListTrialUser(int articleNumber){
		int numberOfArticles = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		if(numberOfArticles > 0){
			if(articleNumber < numberOfArticles && articleNumber > 0){
				elementClick("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(2) i.icon-c-print");
				Assert.assertTrue(alertMessagePrint.isDisplayed());
				cancelButtonModalWindowTrialPrint.click();
//				Assert.assertTrue(getDriver().findElements(By.cssSelector("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(2) i.icon-c-print")).size() == 0);
			}
			else{
				elementClick("div.media-listing > div:nth-child(1) > div:nth-child(2) i.icon-c-print");
				Assert.assertTrue(alertMessagePrint.isDisplayed());
				cancelButtonModalWindowTrialPrint.click();
//				Assert.assertTrue(getDriver().findElements(By.cssSelector("div.media-listing > div:nth-child(1) > div:nth-child(2) i.icon-c-print")).size() == 0);
			}
		}
		else{
			System.out.println("There is no article in listing");
		}
	}
	
	public void clickOnDownloadButtonOfAnArticleFromListTrialUser(int articleNumber){
		int numberOfArticles = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		if(numberOfArticles > 0){
			if(articleNumber < numberOfArticles && articleNumber > 0){
				elementClick("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(2) i.icon-c-download");
				Assert.assertTrue(alertMessageDownload.isDisplayed());
				cancelButtonModalWindowTrialDownload.click();
//				Assert.assertTrue(getDriver().findElements(By.cssSelector("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(2) i.icon-c-download")).size() == 0);
			}
			else{
				elementClick("div.media-listing > div:nth-child(1) > div:nth-child(2) i.icon-c-download");
				Assert.assertTrue(alertMessageDownload.isDisplayed());
				cancelButtonModalWindowTrialDownload.click();
//				Assert.assertTrue(getDriver().findElements(By.cssSelector("div.media-listing > div:nth-child(1) > div:nth-child(2) i.icon-c-download")).size() == 0);
			}
		}
		else{
			System.out.println("There is no article in listing");
		}
	}

	public void clickOnViewFullReportButtonOfAnArticleFromList(int articleNumber){
		int numberOfArticles = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		if(numberOfArticles > 0){
			if(articleNumber < numberOfArticles && articleNumber > 0){
				if(getDriver().findElements(By.cssSelector("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(2) i.icon-c-book-open")).size() > 0){
					if(getDriver().findElements(By.cssSelector("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(2) i.icon-c-book-open")).size() > 0)
					elementClick("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(2) i.icon-c-book-open");
					Assert.assertTrue(alertMessageDownload.isDisplayed());
					cancelButtonModalWindowTrialDownload.click();
//					Assert.assertTrue(getDriver().findElements(By.cssSelector("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(2) i.icon-c-book-open")).size() == 0);
				}
				else{
					System.out.println("There is no View full report icon");
				}
			}
			else{
				if(getDriver().findElements(By.cssSelector("div.media-listing > div:nth-child(1) > div:nth-child(2) i.icon-c-book-open")).size() > 0) {
					elementClick("div.media-listing > div:nth-child(1) > div:nth-child(2) i.icon-c-book-open");
					Assert.assertTrue(alertMessageDownload.isDisplayed());
					cancelButtonModalWindowTrialDownload.click();
//					Assert.assertTrue(getDriver().findElements(By.cssSelector("div.media-listing > div:nth-child(1) > div:nth-child(2) i.icon-c-book-open")).size() == 0);
				}
				else{
					System.out.println("There is no View full report icon");
				}		
			}
		}
		else{
			System.out.println("There is no article in listing");
			
		}
	}
	
	public void clickOnPreviewArticleButtonOfAnArticleFromList(int articleNumber){
		int numberOfArticles = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		if(numberOfArticles > 0){
			if(articleNumber < numberOfArticles && articleNumber > 0){
				elementClick("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1) > div > span:nth-child(1)");
				elementClick("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(2) a[class='btn btn-link preview-article']");
			}
			else{
				elementClick("div.media-listing > div:nth-child(1) > div:nth-child(1) > div > span:nth-child(1)");
				elementClick("div.media-listing > div:nth-child(1) > div:nth-child(2) a[class='btn btn-link preview-article']");
			}
		}
		else{
			System.out.println("There is no article in listing");
		}
	}

	public void clickOnAnArticleFromList(int articleNumber){
		int numberOfArticles = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		if(numberOfArticles > 0){
			if(articleNumber < numberOfArticles && articleNumber > 0){
				elementClick("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1) a");
			}
			else{
				elementClick("div.media-listing > div:nth-child(1) > div:nth-child(1) a");
			}
		}
		else{
			System.out.println("There is no article in listing");
		}
	}
}

package bmo5.bmo5tests.bmo.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class SingleArticlePage extends AbstractPage {

	@FindBy(css = "i.icon-c-email")
	@CacheLookup
	private WebElement emailIconArticle;
	
	@FindBy(css = " i.icon-c-floppy")
	@CacheLookup
	private WebElement saveIconArticle;

	@FindBy(css = "div.media-listing")
	@CacheLookup
	private WebElement mediaListingsContainer;

	@FindBy(css = "i.icon-c-print")
	@CacheLookup
	private WebElement printIconArticle;

	@FindBy(css = "section i.icon-c-cancel")
	@CacheLookup WebElement printPagePreviewCancel;

	@FindBy(css = "i.icon-c-download")
	@CacheLookup
	private WebElement downloadIconArticle;

	@FindBy(css = "div.btn-toolbar.pull-left > a")
	@CacheLookup
	private WebElement backToPreviousPage;

	@FindBy(css = "ul.breadcrumb > li.active")
	@CacheLookup
	private WebElement breadcrumbLast;
	
	@FindBy(css = "div.container-fluid > div:nth-child(4)  > section > ul >  li.active")
	@CacheLookup
	private WebElement breadcrumbReport;

	@FindBy(css = "ul.breadcrumb > li:nth-child(3) > a")
	@CacheLookup
	private WebElement breadcrumbMiddle;

	@FindBy(css = "h4#use")
	@CacheLookup
	private WebElement articleTitle;
	
	@FindBy(css = "div.media-listing > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > a")
	@CacheLookup
	private WebElement firstArticlePreviewButton;

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
	
	@FindBy(css = "div[id*='permission-enterprise-user']")
	private WebElement alertMessageEnterprise;
	
	@FindBy(css = "div#permission-enterprise-user > div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowEnterprise;
	
	@FindBy(css = "div#permission-modal-print strong")
	private WebElement alertMessagePrint;
	
	@FindBy(css = "div#permission-modal-print div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialPrint;
	
	@FindBy(css ="div#permission-modal-print div:nth-child(2) > a")
	private WebElement contactAccountManagerButtonTrialPrint;
	
	@FindBy(css = "div#permission-modal-pdf strong")
	private WebElement alertMessageDownload;
	
	@FindBy(css = "div#permission-modal-pdf div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialDownload;
	
	@FindBy(css = "div#permission-modal-pdf div:nth-child(2) > a")
	private WebElement contactAccountManagementButtonTrialDownload;
	
	@FindBy(css = "i.icon-c-book-open")
	private WebElement viewFullReportIcon;
	
	public int countArticles() {
		return getDriver().findElements(By.cssSelector("div#the-content-container div.media-listing > div")).size();
	}

	public int countPaginators() {
		return getDriver().findElements(By.cssSelector("ul.unstyled > li.numbers > a")).size() - 3;
	}

	public String clickArticle(int articleNumber) {
		int articles = countArticles();
		String articleTitle = "";
		if(articles > 0){
			if (articleNumber > 0 && articleNumber <= articles) {
				articleTitle = getDriver().findElement(By.cssSelector("div#the-content-container div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1) > h5 > a")).getText();
				getDriver().findElement(By.cssSelector("div#the-content-container div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1) > h5 > a")).click();
			}
			else{
				System.out.println("There are not so manna articles, so click on the fisrt one!");
				articleTitle = getDriver().findElement(By.cssSelector("div#the-content-container div.media-listing > div:nth-child(1) > div:nth-child(1) > h5 > a")).getText();
				getDriver().findElement(By.cssSelector("div#the-content-container div.media-listing > div:nth-child(1) > div:nth-child(1) > h5 > a")).click();
			}
		}
		else{
			System.out.println("There is no article in listing!");
		}
		return articleTitle;
	}

	public String clickPageNumber(int pageNumber) {
		int pages = countPaginators();
		String pageNumberText = "";
		if (pages > 0 && pageNumber <= pages) {
			pageNumberText = getDriver().findElement(By.cssSelector("ul.unstyled > li:nth-child(" + pageNumber + ") > a")).getText();
			getDriver().findElement(By.cssSelector("ul.unstyled > li:nth-child(" + pageNumber + ") > a")).click();
		}
		return pageNumberText;
	}
	
	public void clickOnEmailButtonArticle(){
		if(getDriver().findElements(By.cssSelector("i.icon-c-email")).size() > 0){
			emailIconArticle.click();
		}
		else{
			System.out.println("There is no article accessed.");
		}
	}

	public void clickOnSaveButtonArticle() {
		if(getDriver().findElements(By.cssSelector("i.icon-c-floppy")).size() > 0){
			saveIconArticle.click();
		}
		else{
			System.out.println("There is no article accessed.");
		}
	}
	
	public void verifySaveButtonArticle(){
		if(getDriver().findElements(By.cssSelector("i.icon-c-floppy")).size() > 0){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > div:nth-of-type(1) > div")).getText().contains("Saved"));
		}
		else{
			System.out.println("There is no article accessed.");
		}
	}
	
	//TODO Fix this
//	public void clickOnViewFullReportButtonArticle() {
//		if(getDriver().findElements(By.cssSelector("i.icon-c-book-open")).size() > 0){
//			viewFullReportIcon.click();
//			DataToolPage data = new DataToolPage(getDriver());
//			data.saveImageHandle2();
//			FileChecker fileChecker = new FileChecker();
//			fileChecker.verifyViewFullReport();
//		}
//		else{
//			System.out.println("There is no article accessed.");
//		}
////		Assert.assertTrue(getDriver().findElements(By.cssSelector("i.icon-c-book-open")).size() == 0);
//	}
	
	public void clickOnSaveButtonArticleEnterpriseUser() {
		if(getDriver().findElements(By.cssSelector("a i.icon-c-floppy")).size() == 1){
			saveIconArticle.click();
			Assert.assertTrue(alertMessageEnterprise.isDisplayed());
			cancelButtonModalWindowEnterprise.click();
		}
		else{
			System.out.println("There is no article accessed.");
		}
	}

	public void clickOnPrintButtonArticle(String articleName) {
		if(getDriver().findElements(By.cssSelector("a i.icon-c-print")).size() > 0){
			printIconArticle.click();
			waitABit(4000);
			String winHandleBefore = getDriver().getWindowHandle();
			for (String winHandle : getDriver().getWindowHandles()) {
				getDriver().switchTo().window(winHandle);
			}
			waitUntilElementExists(By.cssSelector("div.padding-20 > h4#use"), 10);
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div.padding-20 > h4#use")).getText().contains(articleName));
			printPagePreviewCancel.click();
			getDriver().switchTo().window(winHandleBefore);
		}
		else{
			System.out.println("There is no article accessed.");
		}
		
	}

	public void clickOnPrintButtonReport(String articleName) {
		if(getDriver().findElements(By.cssSelector("a i.icon-c-print")).size() > 0){
			printIconArticle.click();
			waitABit(4000);
			String winHandleBefore = getDriver().getWindowHandle();
			for (String winHandle : getDriver().getWindowHandles()) {
				getDriver().switchTo().window(winHandle);
			}
			waitUntilElementExists(By.cssSelector("div.padding-20 > h3#use"), 10);
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div.padding-20 > h3#use")).getText().contains(articleName));
			printPagePreviewCancel.click();
			getDriver().switchTo().window(winHandleBefore);
		}
		else{
			System.out.println("There is no article accessed.");
		}
		
	}
	public void performDownload() {
		waitABit(2000);

		String script = "src\\test\\java\\drivers\\downloadTest.exe";
		Process p;
		try {
			p = Runtime.getRuntime().exec(script);
			p.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnPrintButtonArticleTrialUser() {
		if(getDriver().findElements(By.cssSelector("a i.icon-c-print")).size() == 1){
			printIconArticle.click();
			Assert.assertTrue(alertMessagePrint.isDisplayed());
			cancelButtonModalWindowTrialPrint.click();
		}
		else{
			System.out.println("There is no article accessed.");
		}
//		Assert.assertTrue(getDriver().findElements(By.cssSelector("i.icon-c-print")).size() == 0);
	}
	
	//TODO Fix this
//	public void clickOnDownloadButtonArticle(String fileName) {
//		if(getDriver().findElements(By.cssSelector("a i.icon-c-download")).size() == 1){
//			downloadIconArticle.click();
////			performDownload();
//			DataToolPage data = new DataToolPage(getDriver());
//			data.saveImageHandle2();
//			FileChecker fileChecker = new FileChecker();
//			fileChecker.verifyFileIsDownloadedRelatives(fileChecker.convertFileName(fileName));
//		}
//		else{
//			System.out.println("There is no article accessed.");
//		}
//		
//	}
	
	public void clickOnDownloadButtonArticleTrialUser() {
		if(getDriver().findElements(By.cssSelector("a i.icon-c-download")).size() >= 1){
			downloadIconArticle.click();
			Assert.assertTrue(alertMessageDownload.isDisplayed());
			cancelButtonModalWindowTrialDownload.click();
		}
		else{
			System.out.println("There is no article accessed.");
		}
//		Assert.assertTrue(getDriver().findElements(By.cssSelector("i.icon-c-download")).size() == 0);
	}
	
	public void clickOnViewFullReportButtonArticleTrialUser() {
		if(getDriver().findElements(By.cssSelector("i.icon-c-book-open")).size() >= 1){
			viewFullReportIcon.click();
			Assert.assertTrue(alertMessageDownload.isDisplayed());
			cancelButtonModalWindowTrialDownload.click();
		}
		else{
			System.out.println("There is no article accessed.");
		}
//		Assert.assertTrue(getDriver().findElements(By.cssSelector("i.icon-c-book-open")).size() == 0);
	}
	
	public void clickOnBackToPreviousPage() {
		if(getDriver().findElements(By.cssSelector("div.btn-toolbar.pull-left > a")).size() == 1){
			backToPreviousPage.click();
		}
		else{
			System.out.println("There is no article accessed.");
		}
	}

	public void verifyBreadCrumbArticle(String text) {
		boolean contained = false;
		if (text.contains(breadcrumbLast.getText())) {
			contained = true;
		} else {
			if (text.contains(breadcrumbMiddle.getText())) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}

	public void verifyTitle(String text) {
			Assert.assertTrue("Article title did not contain " + text + "!",
					articleTitle.getText().contains(text));
	}

	public void clickOnPreviewOfFirstArticleButton() {
		firstArticlePreviewButton.click();
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

	public void selectItemsPerPage(String value) {
		Select itemsPerPage = new Select(getDriver().findElement(
				By.cssSelector("select.span1.input-pagination")));
		itemsPerPage.selectByValue(value);
	}

	public String clickOnPreviewArticle(int articleNumber){
		int numberOfHotTopicsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size() ;
		String articleTitle="";
		if (numberOfHotTopicsDisplayed > 0) {
			if (articleNumber <= numberOfHotTopicsDisplayed
					&& articleNumber > 0) {
				elementClick("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(2) > div:nth-child(2) > a");
				articleTitle = getDriver().findElement(By.cssSelector("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1) > h5 > a")).getText();
				waitUntilElementExists(By.cssSelector("button#close_preview"),30);
			} else {
				System.out
						.println("There aren't so many articles displayed so click on the first article");
				elementClick("div#the-content-container > div.media-listing > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > a");
				articleTitle = getDriver().findElement(By.cssSelector("div#the-content-container > div.media-listing > div:nth-child(1) > div:nth-child(1) > h5 > a  ")).getText();
				waitUntilElementExists(By.cssSelector("button#close_preview"),30);
			}
		} else {
			System.out
					.println("There aren't any articles");
		}
		return articleTitle;
	}
	
	public void clickOnEmailIconArticleFromList(int articleNumber){
		int numberOfArticlesDisplayed = countArticles();
		if (numberOfArticlesDisplayed > 0) {
			if (articleNumber <= numberOfArticlesDisplayed	&& articleNumber > 0) {
				elementClick("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ")  a > i.icon-c-email");
			} else {
				System.out.println("There aren't so many articles displayed so click on the first article");
				elementClick("div#the-content-container > div.media-listing > div:nth-child(1) a > i.icon-c-email");
			}
		} else {
			System.out.println("There aren't any articles");
		}
	}
	
	public void clickOnSaveIconArticleFromList(int articleNumber){
		int numberOfArticlesDisplayed = countArticles();
		if (numberOfArticlesDisplayed > 0) {
			if (articleNumber <= numberOfArticlesDisplayed && articleNumber > 0) {
				elementClick("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ")  a > i.icon-c-floppy");
//				Assert.assertTrue(getDriver().findElement(By.cssSelector("div#result > div")).isDisplayed());
			} else {
				System.out.println("There aren't so many articles displayed so click on the first article");
				elementClick("div#the-content-container > div.media-listing > div:nth-child(1) a > i.icon-c-floppy");
//				Assert.assertTrue(getDriver().findElement(By.cssSelector("div#result > div")).isDisplayed());
			}
		} else {
			System.out.println("There aren't any articles");
		}
	}
	
	public void verifyMediaActionsForReportsOnHover(int articleNumber) {
		waitABit(3000);
		getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div >  div.tags ")).click();
		waitABit(3000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div > div > a > i.icon-c-download")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div > div > a > i.icon-c-print")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div > div > a > i.icon-c-email")).isDisplayed());
		System.out.println("Icons verified!!!");
	}
	
	public void clickOnSaveIconArticleFromListEnterpriseUser(int articleNumber){
		int numberOfArticlesDisplayed = countArticles();
		if (numberOfArticlesDisplayed > 0) {
			if (articleNumber <= numberOfArticlesDisplayed && articleNumber > 0) {
				elementClick("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ")  a > i.icon-c-floppy");
				Assert.assertTrue(alertMessageEnterprise.isDisplayed());
				cancelButtonModalWindowEnterprise.click();
			} else {
				System.out.println("There aren't so many articles displayed so click on the first article");
				elementClick("div#the-content-container > div.media-listing > div:nth-child(1) a > i.icon-c-floppy");
				Assert.assertTrue(alertMessageEnterprise.isDisplayed());
				cancelButtonModalWindowEnterprise.click();
			}
		} else {
			System.out.println("There aren't any articles");
		}
	}
	
	public void clickOnPrintIconArticleFromList(int articleNumber){
		String articleTitle = null;
		int numberOfArticlesDisplayed = countArticles();
		if (numberOfArticlesDisplayed > 0) {
			if (articleNumber <= numberOfArticlesDisplayed && articleNumber > 0) {
				articleTitle = getDriver().findElement(By.cssSelector("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1)  > h5 > a")).getText();
				elementClick("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ")  a > i.icon-c-print");
				String winHandleBefore = getDriver().getWindowHandle();
				for (String winHandle : getDriver().getWindowHandles()) {
					getDriver().switchTo().window(winHandle);
				}
				Assert.assertTrue(getDriver().findElement(By.cssSelector("div.padding-20 > h4#use")).getText().contains(articleTitle));
				printPagePreviewCancel.click();
				getDriver().switchTo().window(winHandleBefore);
			} else {
				System.out.println("There aren't so many articles displayed so click on the first article");
				articleTitle = getDriver().findElement(By.cssSelector("div#the-content-container > div.media-listing > div:nth-child(1) > div:nth-child(1)  > h5 > a")).getText();
				elementClick("div#the-content-container > div.media-listing > div:nth-child(1) a > i.icon-c-print");
				String winHandleBefore = getDriver().getWindowHandle();
				for (String winHandle : getDriver().getWindowHandles()) {
					getDriver().switchTo().window(winHandle);
				}
				Assert.assertTrue(getDriver().findElement(By.cssSelector("div.padding-20 > h4#use")).getText().contains(articleTitle));
				printPagePreviewCancel.click();
				getDriver().switchTo().window(winHandleBefore);
			}
		} else {
			System.out.println("There aren't any articles");
		}
	}
	
	public void clickOnPrintIconArticleFromListTrialUser(int articleNumber){
		int numberOfArticlesDisplayed = countArticles();
		if (numberOfArticlesDisplayed > 0) {
			if (articleNumber <= numberOfArticlesDisplayed	&& articleNumber > 0) {
				elementClick("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ")  a > i.icon-c-print");
				Assert.assertTrue(alertMessagePrint.isDisplayed());
				cancelButtonModalWindowTrialPrint.click();
//				Assert.assertTrue(getDriver().findElements(By.cssSelector("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ")  a > i.icon-c-print")).size() == 0);
			} else {
				System.out.println("There aren't so many articles displayed so click on the first article");
				elementClick("div#the-content-container > div.media-listing > div:nth-child(1) a > i.icon-c-print");
				Assert.assertTrue(alertMessagePrint.isDisplayed());
				cancelButtonModalWindowTrialPrint.click();
//				Assert.assertTrue(getDriver().findElements(By.cssSelector("div#the-content-container > div.media-listing > div:nth-child(1) a > i.icon-c-print")).size() == 0);
			}
		} else {
			System.out.println("There aren't any articles");
		}
	}
	
	public String clickOnPrintIconArticleFromListTrialUserAndVerifyContactAccountManager(int articleNumber){
		int numberOfArticlesDisplayed = countArticles();
		String articleTitle = "";
		if (numberOfArticlesDisplayed > 0) {
			if (articleNumber <= numberOfArticlesDisplayed	&& articleNumber > 0) {
				articleTitle = getDriver().findElement(By.cssSelector("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1)  > h5 > a")).getText();
				elementClick("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ")  a > i.icon-c-print");
				Assert.assertTrue(alertMessagePrint.isDisplayed());
				contactAccountManagerButtonTrialPrint.click();
			} else {
				System.out.println("There aren't so many articles displayed so click on the first article");
				articleTitle = getDriver().findElement(By.cssSelector("div#the-content-container > div.media-listing > div:nth-child(1) > div:nth-child(1)  > h5 > a")).getText();
				elementClick("div#the-content-container > div.media-listing > div:nth-child(1) a > i.icon-c-print");
				contactAccountManagerButtonTrialPrint.click();
			}
		} else {
			System.out.println("There aren't any articles");
		}
		System.out.println(articleTitle);
		return articleTitle;
	}
	
	//TODO Fix this
//	public void clickOnDownloadIconArticleFromList(int articleNumber){
//		int numberOfArticlesDisplayed = countArticles();
//		String articleTitle="";
//		if (numberOfArticlesDisplayed > 0) {
//			if (articleNumber <= numberOfArticlesDisplayed
//					&& articleNumber > 0) {
//				elementClick("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ")  a > i.icon-c-download");
//				articleTitle = getDriver().findElement(By.cssSelector("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1)  > h5 > a")).getText();
//				DataToolPage data = new DataToolPage(getDriver());
//				data.saveImageHandle2();
//				FileChecker fileChecker = new FileChecker();
//				System.out.println(fileChecker.convertFileName(articleTitle));
//				fileChecker.verifyFileIsDownloadedRelatives(fileChecker.convertFileName(articleTitle));
//			} else {
//				System.out
//						.println("There aren't so many articles displayed so clicking the first article");
//				elementClick("div#the-content-container > div.media-listing > div:nth-child(1)  a > i.icon-c-download");
//				articleTitle = getDriver().findElement(By.cssSelector("div#the-content-container > div.media-listing > div:nth-child(1) > div:nth-child(1)  > h5 > a")).getText();
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
	
	public void clickOnDownloadIconArticleFromListTrialUser(int articleNumber){
		int numberOfArticlesDisplayed = countArticles();
		if (numberOfArticlesDisplayed > 0) {
			if (articleNumber <= numberOfArticlesDisplayed && articleNumber > 0) {
				elementClick("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ")  a > i.icon-c-download");
				Assert.assertTrue(alertMessageDownload.isDisplayed());
				cancelButtonModalWindowTrialDownload.click();
//				Assert.assertTrue(getDriver().findElements(By.cssSelector("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ")  a > i.icon-c-download")).size() == 0);
			} else {
				System.out.println("There aren't so many articles displayed so clicking the first article");
				elementClick("div#the-content-container > div.media-listing > div:nth-child(1)  a > i.icon-c-download");
				Assert.assertTrue(alertMessageDownload.isDisplayed());
				cancelButtonModalWindowTrialDownload.click();
//				Assert.assertTrue(getDriver().findElements(By.cssSelector("div#the-content-container > div.media-listing > div:nth-child(1)  a > i.icon-c-download")).size() == 0);
			}
		} else {
			System.out.println("There aren't any articles");
		}
	}
	
	public String clickOnDownloadIconArticleFromListTrialUserAndVerifyContactAccountManager(int articleNumber){
		int numberOfArticlesDisplayed = countArticles();
		String articleTitle = "";
		if (numberOfArticlesDisplayed > 0) {
			if (articleNumber <= numberOfArticlesDisplayed && articleNumber > 0) {
				articleTitle = getDriver().findElement(By.cssSelector("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1)  > h5 > a")).getText();
				elementClick("div#the-content-container > div.media-listing > div:nth-child(" + articleNumber + ")  a > i.icon-c-download");
				Assert.assertTrue(alertMessageDownload.isDisplayed());
				contactAccountManagementButtonTrialDownload.click();
			} else {
				System.out.println("There aren't so many articles displayed so clicking the first article");
				articleTitle = getDriver().findElement(By.cssSelector("div#the-content-container > div.media-listing > div:nth-child(1) > div:nth-child(1)  > h5 > a")).getText();
				elementClick("div#the-content-container > div.media-listing > div:nth-child(1)  a > i.icon-c-download");
				Assert.assertTrue(alertMessageDownload.isDisplayed());
				contactAccountManagementButtonTrialDownload.click();
			}
		} else {
			System.out.println("There aren't any articles");
		}
		System.out.println(articleTitle);
		return articleTitle;
	}
	
	public String getArticleNameFromBreadcrums(){
		System.out.println(breadcrumbLast.getText());
		return breadcrumbLast.getText();
	}
	
	public String getReportNameFromBreadcrums(){
		System.out.println(breadcrumbReport.getText());
		return breadcrumbReport.getText();
	}
	
	public String clickOnPreviewArticleSearchResultst(int articleNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		String articleTitle="";
		if (numberOfReportsDisplayed > 0) {
			if (articleNumber <= numberOfReportsDisplayed && articleNumber > 0) {
				elementClick("div.media-listing > div:nth-child( "+ articleNumber +") > div:nth-child(2) > div > a.btn.btn-link.preview-article");
				articleTitle = getDriver().findElement(By.cssSelector("div.media-listing  > div:nth-child("+ articleNumber +") >  div:nth-child(1) > div > h5 > a")).getText();
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				elementClick("div.media-listing > div:nth-child(1) > div:nth-child(2) > div > a.btn.btn-link.preview-article");
				articleTitle = getDriver().findElement(By.cssSelector("div.media-listing  > div:nth-child(1) > div:nth-child(1) > div > h5 > a")).getText();
			}
		} else {
			System.out.println("There aren't any articles!");
		}
		return articleTitle;
	}

	public void verifyIfActionIconsAreEnabled(){
		Assert.assertTrue(downloadIconArticle.isEnabled());
		Assert.assertTrue(saveIconArticle.isEnabled());
		Assert.assertTrue(printIconArticle.isEnabled());
		Assert.assertTrue(emailIconArticle.isEnabled());
	}
	
	public void verifyMediaActionsForTrialOnHover(int articleNumber) {
		element(getDriver().findElement(By.cssSelector("div#the-content-container > div:nth-child(3) > div:nth-child("+articleNumber+") > div:nth-child(2)  > div > a > i.icon-c-floppy"))).waitUntilPresent();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#the-content-container > div:nth-child(3) > div:nth-child("+articleNumber+") > div:nth-child(2)  > div > a > i.icon-c-floppy")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#the-content-container > div:nth-child(3) > div:nth-child("+articleNumber+") > div:nth-child(2)  > div > a > i.icon-c-email")).isDisplayed());
	}
	
	public void verifySaveForTrial(int reportNumber,int articleNumber) {
		//waitABit(2000);
		element(getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child("+reportNumber+") > div > div.tags"))).click();
		element(getDriver().findElement(By.cssSelector("div#the-content-container > div:nth-child(3) > div:nth-child("+articleNumber+") > div:nth-child(2)  > div > a > i.icon-c-floppy"))).waitUntilPresent();
		element(getDriver().findElement(By.cssSelector("div#the-content-container > div:nth-child(3) > div:nth-child("+articleNumber+") > div:nth-child(2)  > div > a > i.icon-c-floppy"))).click();
		System.out.println("save clicked!");
		if(getDriver().findElements(By.cssSelector("div.alert.alert-success")).size() > 0){
		element(getDriver().findElement(By.cssSelector("div.alert.alert-success"))).waitUntilPresent();
		System.out.println("alert confirmation!");
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.alert.alert-success")).isDisplayed());
		} else if (getDriver().findElements(By.cssSelector("div.alert.alert-errors")).size() > 0) {
			element(getDriver().findElement(By.cssSelector("div.alert.alert-errors"))).waitUntilPresent();
			System.out.println("erorr alert!");
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div.alert.alert-errors")).isDisplayed());
		}
	}
	
	public void verifySaveForTrialArticles(int articleNumber) {
		//waitABit(2000);
		element(getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child("+articleNumber+") > div > div.tags"))).click();
		element(getDriver().findElement(By.cssSelector("div#the-content-container > div:nth-child(3) > div:nth-child("+articleNumber+") > div:nth-child(2)  > div > a > i.icon-c-floppy"))).waitUntilPresent();
		element(getDriver().findElement(By.cssSelector("div#the-content-container > div:nth-child(3) > div:nth-child("+articleNumber+") > div:nth-child(2)  > div > a > i.icon-c-floppy"))).click();
		System.out.println("save clicked!");
		if(getDriver().findElements(By.cssSelector("div.alert.alert-success")).size() > 0){
		element(getDriver().findElement(By.cssSelector("div.alert.alert-success"))).waitUntilPresent();
		System.out.println("alert confirmation!");
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.alert.alert-success")).isDisplayed());
		} else if (getDriver().findElements(By.cssSelector("div.alert.alert-errors")).size() > 0) {
			element(getDriver().findElement(By.cssSelector("div.alert.alert-errors"))).waitUntilPresent();
			System.out.println("erorr alert!");
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div.alert.alert-errors")).isDisplayed());
		}
	}
	public void clickOnEmail(int articleNumber) {
		//element(getDriver().findElement(By.cssSelector("div#the-content-container > div:nth-child(4) > div:nth-child("+articleNumber+") > div:nth-child(2)  > div > a > i.icon-c-email"))).waitUntilPresent();
		getDriver().findElement(By.cssSelector("div#the-content-container > div:nth-child(3) > div:nth-child("+articleNumber+") > div:nth-child(2)  > div > a > i.icon-c-email")).click();
}
	
	public void verifyMediaActionsForTrialInDetailArticle() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(6) > div > div:nth-child(2)  > a > i.icon-c-floppy")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(6) > div > div:nth-child(2)  > a > i.icon-c-email")).isDisplayed());
	}
	
	public void verifyMediaActionsForTrialInPreview() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#js-overflow > section > div > div:nth-child(1)  > div:nth-child(2) > a > i.icon-c-floppy")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#js-overflow > section > div > div:nth-child(1)  > div:nth-child(2) > a > i.icon-c-email")).isDisplayed());
	}
}

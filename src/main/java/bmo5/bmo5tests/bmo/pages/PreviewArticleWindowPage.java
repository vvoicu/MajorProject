package bmo5.bmo5tests.bmo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class PreviewArticleWindowPage extends AbstractPage{

	@FindBy(css="a[class='btn btn-tall']")
	@CacheLookup
	private WebElement readMoreButtonPreviewArticle;

	@FindBy(css="div.margin-top-20 > h4 > a > span")
	@CacheLookup
	private WebElement articleTitleFromPreviewArticleWindow;

	@FindBy(css="div[class='btn-group pull-right'] > a#contact-acc-preview ")
	@CacheLookup
	private WebElement emailIconPreviewWindow;

	@FindBy(css="div[class='btn-group pull-right'] > a > i.icon-c-floppy")
	@CacheLookup
	private WebElement saveIconPreviewWindow;

	@FindBy(css="div[class='btn-group pull-right'] > a > i.icon-c-floppy")
	@CacheLookup
	private WebElement saveIconReportPreviewWindow;

	@FindBy(css="div[class='btn-group pull-right']  i.icon-c-download")
	@CacheLookup
	private WebElement downloadIconPreviewWindow;

	@FindBy(css="div[class='btn-group pull-right'] i.icon-c-book-open")
	@CacheLookup
	private WebElement viewFullReportPreviewWindow;

	@FindBy(css="div[class='btn-group pull-right'] i.icon-c-print")
	@CacheLookup
	private WebElement printIconPreviewWindow;

	@FindBy(css="div.media > div.btn-toolbar > span")
	@CacheLookup
	private WebElement previewTitle;

	@FindBy(css = "button#close_preview")
	private WebElement closePreviewWindow;

	@FindBy(css = "i.icon-c-email")
	private WebElement emailIcon;

	@FindBy(css = "i.icon-c-floppy")
	private WebElement saveIcon;

	@FindBy(css = "i.icon-c-download")
	private WebElement downloadIcon;

	@FindBy(css = "i.icon-c-print")
	private WebElement printIcon;

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

	public void closePreviewWindow(){
		closePreviewWindow.click();
	}

	public void verifyIfPreviewWindowIsClosed(){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div#media-preview-container div.btn-toolbar > span")).size() == 0);
	}

	public void clickOnReadMoreButtonFromPreviewArticle(){
		waitUntilElementExists(By.cssSelector("button#close_preview"),30);
		element(readMoreButtonPreviewArticle).waitUntilVisible();
		readMoreButtonPreviewArticle.click();
	}

	public void verifyMediaActionsInsideAReport() {
		Assert.assertTrue("Not displayed!", emailIcon.isDisplayed());
		Assert.assertTrue("Not displayed!",saveIcon.isDisplayed());
		Assert.assertTrue("Not displayed!",downloadIcon.isDisplayed());
		Assert.assertTrue("Not displayed!", printIcon.isDisplayed());
	}

	public void verifyArticleTitleFromPreviewArticleWindow(String articleTitle){
		waitUntilElementExists(By.cssSelector("button#close_preview"),30);
		System.out.println(articleTitle);
		element(articleTitleFromPreviewArticleWindow).waitUntilVisible();
		System.out.println(articleTitleFromPreviewArticleWindow.getText());
		Assert.assertTrue(articleTitle.contains(articleTitleFromPreviewArticleWindow.getText()));
	}

	public void clickOnSaveIconPreviewArticle(){
		element(saveIconPreviewWindow).waitUntilVisible();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.btn-group.pull-right > a >i.icon-c-floppy")).isDisplayed());
		saveIconPreviewWindow.click();
	}

	public void clickOnSavePreviewArticleEnterpriseUser(){
		element(saveIconPreviewWindow).waitUntilVisible();
		saveIconPreviewWindow.click();
		Assert.assertTrue(alertMessageEnterprise.isDisplayed());
		cancelButtonModalWindowEnterprise.click();
	}

	//TODO fix this
//	public void clickOnPrintIconPreviewArticle(String articleName){
//		if(getDriver().findElements(By.cssSelector("div.affix-top.loading")).size() > 0){
//			waitUntilElementDoesntExist(By.cssSelector("div.affix-top.loading"), 40);
//		}
//		printIconPreviewWindow.click();
//		String winHandleBefore = getDriver().getWindowHandle();
//		for (String winHandle : getDriver().getWindowHandles()) {
//			getDriver().switchTo().window(winHandle);
//		}
//		System.out.println(articleName);
//		waitUntilElementExists(By.cssSelector("div.padding-20 > h4#use"), 10);
//		System.out.println(getDriver().findElement(By.cssSelector("div.padding-20 > h4#use")).getText());
//		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.padding-20 > h4#use")).getText().contains(articleName));
//		SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
//		singleArticle.printPagePreviewCancel.click();
//		getDriver().switchTo().window(winHandleBefore);
//	}
//
//	public void clickOnPrintIconPreviewReport(String reportName){
//		if(getDriver().findElements(By.cssSelector("div.affix-top.loading")).size() > 0){
//			waitUntilElementDoesntExist(By.cssSelector("div.affix-top.loading"), 40);
//		}
//		printIconPreviewWindow.click();
//		String winHandleBefore = getDriver().getWindowHandle();
//		for (String winHandle : getDriver().getWindowHandles()) {
//			getDriver().switchTo().window(winHandle);
//		}
//		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.padding-20 > h3#use")).getText().contains(reportName));
//		SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
//		singleArticle.printPagePreviewCancel.click();
//		getDriver().switchTo().window(winHandleBefore);
//	}
//
//	public void clickOnPrintIconPreviewArticleTrialUser(){
//		if(getDriver().findElements(By.cssSelector("div[class='btn-group pull-right'] i.icon-c-print")).size() > 0){
//			printIconPreviewWindow.click();
//			WebElement element = getDriver().findElement(By.cssSelector("div[class='btn-group pull-right'] i.icon-c-print"));
//			element.click();
//			Assert.assertTrue(alertMessagePrint.isDisplayed());
//			cancelButtonModalWindowTrialPrint.click();
//		}
//		else{
//			System.out.println("There is no article");
//		}
//	}
//
//	public void clickOnDownloadIconPreviewArticle(String fileName){
//		if(getDriver().findElements(By.cssSelector("div.affix-top.loading")).size() > 0){
//			waitUntilElementDoesntExist(By.cssSelector("div.affix-top.loading"), 40);
//		}
//		downloadIconPreviewWindow.click();
//		DataToolPage data = new DataToolPage(getDriver());
//		data.saveImageHandle2();
//		FileChecker fileChecker = new FileChecker();
//		System.out.println(fileChecker.convertFileName(fileName));
//		fileChecker.verifyFileIsDownloaded1(fileChecker.convertFileName(fileName));
//	}
//
//	public void clickOnDownloadIconPreviewArticleFromSearch(String fileName){
//		if(getDriver().findElements(By.cssSelector("div.affix-top.loading")).size() > 0){
//			waitUntilElementDoesntExist(By.cssSelector("div.affix-top.loading"), 40);
//		}
//		waitUntilElementExists(By.cssSelector("div[class='btn-group pull-right']  i.icon-c-download"), 40);
//		downloadIconPreviewWindow.click();
//		DataToolPage data = new DataToolPage(getDriver());
//		data.saveImageHandle2();
//		FileChecker fileChecker = new FileChecker();
//		System.out.println(fileChecker.convertFileName(fileName));
//		fileChecker.verifyFileIsDownloadedRelatives(fileChecker.convertFileName(fileName));
//	}
//	
//	public void clickOnDownloadIconPreviewArticleTrialUser(){
//		if(getDriver().findElements(By.cssSelector("div#js-overflow > section > div > div:nth-child(1) > div ")).size() > 0){
//			getDriver().findElement(By.cssSelector("div#js-overflow > section > div > div:nth-child(1) > div > a > i.icon-c-download")).click();
//			Assert.assertTrue(alertMessageDownload.isDisplayed());
//			cancelButtonModalWindowTrialDownload.click();
//		}
//		else{
//			System.out.println("There is no download icon");
//		}
//	}
//
//	public void clickOnDownloadIconPreviewReport(String fileName){
//		downloadIconPreviewWindow.click();
//		DataToolPage data = new DataToolPage(getDriver());
//		data.saveImageHandle2();
//		FileChecker fileChecker = new FileChecker();
//		System.out.println(fileChecker.convertFileName(fileName));
//		fileChecker.verifyFileIsDownloaded1(fileChecker.convertFileName(fileName));
//	}
//
//	public void clickOnEmailIconPreviewArticle(){
//		if(getDriver().findElements(By.cssSelector("div.affix-top.loading")).size() > 0){
//			waitUntilElementDoesntExist(By.cssSelector("div.affix-top.loading"), 20);
//		}
//		emailIconPreviewWindow.click();
//		waitABit(12000);
//	}
//
//	public String getTitleArticlePreviewWindow(){
//		return articleTitleFromPreviewArticleWindow.getText();
//	}
//
//	public void clickOnSaveIconReportFromPreviewWindow(){
//		if(getDriver().findElements(By.cssSelector("div.affix-top.loading")).size() > 0){
//			waitUntilElementDoesntExist(By.cssSelector("div.affix-top.loading"), 40);
//		}
//		saveIconReportPreviewWindow.click();
//	}
//
//	public void clickOnViewFullReportIconPreviewArticle(String fileName){
//		if(getDriver().findElements(By.cssSelector("div[class='btn-group pull-right'] i.icon-c-book-open")).size() > 0){
//			viewFullReportPreviewWindow.click();		
//			DataToolPage data = new DataToolPage(getDriver());
//			data.saveImageHandle2();
//			FileChecker fileChecker = new FileChecker();
//			fileChecker.verifyViewFullReport();
//		}
//		else{
//			System.out.println("There is no View full report action icon.");
//		}
//	}

	public void clickOnViewFullReportIconPreviewArticleTrialUser(){
		//		if(getDriver().findElements(By.cssSelector("div[class='btn-group pull-right'] i.icon-c-book-open")).size() > 0){
		//			viewFullReportPreviewWindow.click();
		//			Assert.assertTrue(alertMessageDownload.isDisplayed());
		//			cancelButtonModalWindowTrialDownload.click();
		//		}
		//		else{
		//			System.out.println("There is no article");
		//		}
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div[class='btn-group pull-right'] i.icon-c-book-open")).size() == 0);
	}
}

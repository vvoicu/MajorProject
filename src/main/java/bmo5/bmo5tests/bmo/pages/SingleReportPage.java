package bmo5.bmo5tests.bmo.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.FileChecker;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class SingleReportPage extends AbstractPage{
	
	@FindBy(css = "section i.icon-c-cancel")
	@CacheLookup 
	private WebElement printPagePreviewCancel;
	
	@FindBy(css = "div[class='btn-group btn-toolbar pull-right'] a > i.icon-c-email")
	@CacheLookup
	private WebElement emailIconReport;
		
	@FindBy(css = "div[class='btn-group btn-toolbar pull-right'] a > i.icon-c-floppy")
	@CacheLookup
	private WebElement saveIconReport;
	
	@FindBy(css = "div[class='btn-group btn-toolbar pull-right'] a > i.icon-c-download")
	@CacheLookup
	private WebElement downloadIconReport;
	
	@FindBy(css = "div[class='btn-group btn-toolbar pull-right'] > a > i.icon-c-print")
	@CacheLookup
	private WebElement printIconReport;
	
	@FindBy(css = "div[class='btn-toolbar pull-left'] > a")
	@CacheLookup
	private WebElement backToPreviousPageButtonReport;
	
	@FindBy(css = "div[class='pull-right drop-content-toggler'] > div > a")
	@CacheLookup
	private WebElement pastVersionsToggler;
	
	@FindBy(css = "div[class='pull-right drop-content-toggler'] > div > a > span")
	@CacheLookup
	private WebElement pastVersionsTogglerNumber;
	
	@FindBy(css = "	div.page-wrap > div:nth-child(1) > div >div ")
	@CacheLookup
	private WebElement saveItemAfterOpening;
	
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
	
	public void clickOnEmailIconReportFromList(int reportNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div#sar-reports-container > div")).size();
		if (numberOfReportsDisplayed > 0) {
			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
				elementClick("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(2) > div:nth-child(1) > a > i.icon-c-email");
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				elementClick("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a > i.icon-c-email");
			}
		} else {
			System.out.println("There aren't any reports!");
		}
	}
	
	
	public void clickOnSaveIconReportFromList(int reportNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div#sar-reports-container > div")).size();
		if (numberOfReportsDisplayed > 0) {
			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
				elementClick("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(2) > div:nth-child(1) > a > i.icon-c-floppy");
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				elementClick("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a > i.icon-c-floppy");
			}
		} else {
			System.out.println("There aren't any reports!");
		}
	}
	
	public void verifyMediaActionOnHoveredReport(int reportNumber) {
		Actions tag = new Actions(getDriver());
	     tag.moveToElement(getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child("+reportNumber+") > div > div.tags"))).build().perform();
		//element(getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child("+reportNumber+") > div > div.tags"))).click();
		System.out.println("clicked!");
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#sar-reports-container >div:nth-child("+reportNumber+") > div:nth-child(2) > div > a > i.icon-c-download")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#sar-reports-container >div:nth-child("+reportNumber+") > div:nth-child(2) > div > a > i.icon-c-print")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#sar-reports-container >div:nth-child("+reportNumber+") > div:nth-child(2) > div > a > i.icon-c-email")).isDisplayed());
	}
	
	public void verifyMediaActionsOnReportView() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > div:nth-child(1) >  div:nth-child(2) > a> i.icon-c-download")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > div:nth-child(1) >  div:nth-child(2) > a> i.icon-c-print")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > div:nth-child(1) >  div:nth-child(2) > a> i.icon-c-email")).isDisplayed());
	}
	
	public void verifyMediaActionInReportPreview() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#js-overflow > section > div > div:nth-child(1) > div > a > i.icon-c-download")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#js-overflow > section > div > div:nth-child(1) > div > a > i.icon-c-print")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#js-overflow > section > div > div:nth-child(1) > div > a > i.icon-c-email")).isDisplayed());
	}
	
	//TODO Fix this
//	public void clickOnDownloadIconReportFromList(int reportNumber){
//		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div#sar-reports-container > div")).size();
//		String reportTitle="";
//		if (numberOfReportsDisplayed > 0) {
//			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
//				elementClick("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(2) > div:nth-child(1) > a > i.icon-c-download");
//				reportTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > h5 > a")).getText();
//				DataToolPage data = new DataToolPage(getDriver());
//				data.saveImageHandle2();
//				FileChecker fileChecker = new FileChecker();
//				System.out.println(fileChecker.convertFileName(reportTitle));
//				fileChecker.verifyFileIsDownloaded1(fileChecker.convertFileName(reportTitle));
//			} else {
//				System.out.println("There aren't so many reports displayed so clicking the first report");
//				elementClick("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a > i.icon-c-download");
//				reportTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > h5 > a")).getText();
//				DataToolPage data = new DataToolPage(getDriver());
//				data.saveImageHandle2();
//				FileChecker fileChecker = new FileChecker();
//				System.out.println(fileChecker.convertFileName(reportTitle));
//				fileChecker.verifyFileIsDownloaded1(fileChecker.convertFileName(reportTitle));
//			}
//		} else {
//			System.out.println("There aren't any reports!");
//		}
//	}
	
	public void clickOnDownloadIconReportFromListTrialUser(int reportNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div#sar-reports-container > div")).size();
		if (numberOfReportsDisplayed > 0) {
			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
				elementClick("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(2) > div:nth-child(1) > a > i.icon-c-download");
				Assert.assertTrue(alertMessageDownload.isDisplayed());
				cancelButtonModalWindowTrialDownload.click();
//				Assert.assertTrue(getDriver().findElements(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(2) > div:nth-child(1) > a > i.icon-c-download")).size() == 0);
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				elementClick("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a > i.icon-c-download");
				Assert.assertTrue(alertMessageDownload.isDisplayed());
				cancelButtonModalWindowTrialDownload.click();
//				Assert.assertTrue(getDriver().findElements(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a > i.icon-c-download")).size() == 0);
			}
		} else {
			System.out.println("There aren't any reports!");
		}
	}
	
	public String clickOnDownloadIconReportFromListTrialUserAndVerifyContactAccountManager(int reportNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div#sar-reports-container > div")).size();
		String reportTitle="";
		if (numberOfReportsDisplayed > 0) {
			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
				reportTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > h5 > a")).getText();
				elementClick("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(2) > div:nth-child(1) > a > i.icon-c-download");
				Assert.assertTrue(alertMessageDownload.isDisplayed());
				contactAccountManagementButtonTrialDownload.click();
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				reportTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > h5 > a")).getText();
				elementClick("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a > i.icon-c-download");
				Assert.assertTrue(alertMessageDownload.isDisplayed());
				contactAccountManagementButtonTrialDownload.click();
			}
		} else {
			System.out.println("There aren't any reports!");
		}
		return reportTitle;
	}
	
	public void clickOnPrintIconReportFromList(int reportNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div#sar-reports-container > div")).size();
		if (numberOfReportsDisplayed > 0) {
			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
				elementClick("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(2) > div:nth-child(1) > a > i.icon-c-print");
				String winHandleBefore = getDriver().getWindowHandle();
				for (String winHandle : getDriver().getWindowHandles()) {
					getDriver().switchTo().window(winHandle);
				}
				printPagePreviewCancel.click();
				getDriver().switchTo().window(winHandleBefore);
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				elementClick("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a > i.icon-c-print");
				String winHandleBefore = getDriver().getWindowHandle();
				for (String winHandle : getDriver().getWindowHandles()) {
					getDriver().switchTo().window(winHandle);
				}
				printPagePreviewCancel.click();
				getDriver().switchTo().window(winHandleBefore);
			}
		} else {
			System.out.println("There aren't any reports!");
		}
	}
	
	public void clickOnPrintIconReportFromListTrialUser(int reportNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div#sar-reports-container > div")).size();
		if (numberOfReportsDisplayed > 0) {
			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
				elementClick("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(2) > div:nth-child(1) > a > i.icon-c-print");
				Assert.assertTrue(alertMessagePrint.isDisplayed());
				cancelButtonModalWindowTrialPrint.click();
//				Assert.assertTrue(getDriver().findElements(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(2) > div:nth-child(1) > a > i.icon-c-print")).size() == 0);
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				elementClick("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a > i.icon-c-print");
				Assert.assertTrue(alertMessagePrint.isDisplayed());
				cancelButtonModalWindowTrialPrint.click();
//				Assert.assertTrue(getDriver().findElements(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a > i.icon-c-print")).size() == 0);
			}
		} else {
			System.out.println("There aren't any reports!");
		}
	}
	
	public String clickOnPrintIconReportFromListTrialUserAndVerifyContactAccountManager(int reportNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div#sar-reports-container > div")).size();
		String reportTitle="";
		if (numberOfReportsDisplayed > 0) {
			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
				reportTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > h5 > a")).getText();
				elementClick("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(2) > div:nth-child(1) > a > i.icon-c-print");
				Assert.assertTrue(alertMessagePrint.isDisplayed());
				contactAccountManagementButtonTrialPrint.click();
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				reportTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > h5 > a")).getText();
				elementClick("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a > i.icon-c-print");
				Assert.assertTrue(alertMessagePrint.isDisplayed());
				contactAccountManagementButtonTrialPrint.click();
			}
		} else {
			System.out.println("There aren't any reports!");
		}
		return reportTitle;
	}
	
	public String clickOnPreviewReportFromList(int reportNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div#sar-reports-container > div")).size();
		String reportTitle="";
		if (numberOfReportsDisplayed > 0) {
			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
				elementClick("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(2) > div > a.btn.btn-link.preview-report");
				waitUntilElementDoesntExist(By.cssSelector("div.affix.loading"),50);
				reportTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > h5 > a")).getText();
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				elementClick("div#sar-reports-container > div:nth-child(1) > div:nth-child(2) > div a[class='btn btn-link preview-report']");
				reportTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > h5 > a")).getText();
			}
		} else {
			System.out.println("There aren't any reports!");
		}
		return reportTitle;
	}
	
	public String clickOnPreviewReportArchiveFromList(int reportNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		String reportTitle="";
		if (numberOfReportsDisplayed > 0) {
			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
				waitABit(5000);
				elementClick("div.media-listing > div:nth-child( "+ reportNumber +") > div:nth-child(2) > div > a.btn.btn-link.preview-report.hide-actions");
				reportTitle = getDriver().findElement(By.cssSelector("div.media-listing  > div:nth-child("+ reportNumber +") >  div:nth-child(1) > div > h5 > a")).getText();
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				elementClick("div.media-listing > div:nth-child(1) > div:nth-child(2) > div > a.btn.btn-link.preview-report");
				reportTitle = getDriver().findElement(By.cssSelector("div.media-listing  > div:nth-child(1) > div:nth-child(1) > div > h5 > a")).getText();
			}
		} else {
			System.out.println("There aren't any reports!");
		}
		return reportTitle;
	}
	
	public String clickOnPreviewReportsFromList(int reportNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		String reportTitle="";
		if (numberOfReportsDisplayed > 0) {
			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
				elementClick("div.media-listing > div:nth-child( "+ reportNumber +") > div:nth-child(2) > div > a.btn.btn-link.preview-report.hide-actions");
				reportTitle = getDriver().findElement(By.cssSelector("div.media-listing  > div:nth-child("+ reportNumber +") >  div:nth-child(1) > h5 > a")).getText();
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				elementClick("div.media-listing > div:nth-child(1) > div:nth-child(2) > div > a.btn.btn-link.preview-report");
				reportTitle = getDriver().findElement(By.cssSelector("div.media-listing  > div:nth-child(1) > div:nth-child(1) > div > h5 > a")).getText();
			}
		} else {
			System.out.println("There aren't any reports!");
		}
		return reportTitle;
	}
	//TODO Fix this
//	public void verifyDownloadFromHoveredMediaActions(int reportNumber) {
//		String reportTitle="";
//		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
//		if (numberOfReportsDisplayed > 0) {
//			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
//				waitABit(5000);
//				reportTitle = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + reportNumber + ")> div:nth-child(1) > div > h5 > a")).getText();
//				elementClick("div.media-listing > div:nth-child(" + reportNumber + ") div.media-actions a > i.icon-c-download");
//				DataToolPage data = new DataToolPage(getDriver());
//				data.saveImageHandle2();
//				FileChecker file = new FileChecker();
//				file.verifyFileIsDownloaded1(file.convertFileName(reportTitle));
//			} else {
//				System.out.println("There aren't so many reports displayed so clicking the first report");
//				reportTitle = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(1)> div:nth-child(1) > div > h5 > a")).getText();
//				elementClick("div.media-listing > div:nth-child(1) div.media-actions a > i.icon-c-download");
//				DataToolPage data = new DataToolPage(getDriver());
//				data.saveImageHandle2();
//				FileChecker file = new FileChecker();
//				file.verifyFileIsDownloaded1(file.convertFileName(reportTitle));
//			}
//		} else {
//			System.out.println("There aren't any reports!");
//		}
//	}
	public String clickOnOneReportFromList(int reportNumber){
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div#sar-reports-container > div")).size();
		String reportTitle="";
		if (numberOfReportsDisplayed > 0) {
			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
				reportTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > h5 > a")).getText();
				getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > h5 > a")).click();
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				reportTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > h5 > a")).getText();
				getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > h5 > a")).click();
			}
		} else {
			System.out.println("There aren't any reports!");
		}
		return reportTitle;
	}
	
	public String clickASpecialReportsFromListing(int reportNumber) {
		
		int numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div.media-listing > div")).size();
		String reportTitle="";
		if (numberOfReportsDisplayed > 0) {
			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
				reportTitle = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child("+ reportNumber +") > div:nth-child(1)  > div > h5 > a")).getText();
				getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child("+ reportNumber +") > div:nth-child(1)  > div > h5 > a")).click();
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				reportTitle = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(1) > div:nth-child(1) > div > h5 > a")).getText();
				getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(1) > div:nth-child(1) > div >  h5 > a")).click();
			}
		} else {
			System.out.println("There aren't any reports!");
		}
		return reportTitle;
	}
	public void clickOnSaveIconReport() {
		saveIconReport.click();
		Assert.assertTrue(saveItemAfterOpening.getText().contains("The article already exists in Saved Content!")|| saveItemAfterOpening.getText().contains("This report already exists in Saved Reports!") || saveItemAfterOpening.getText().contains("Report successfully saved!") || saveItemAfterOpening.getText().contains("Sucessfully added the article to Saved Content"));
	}
	public void saveEnterpriseIconInsideReport() {
		saveIconReport.click();
	}
	public void clickOnPrintIconReport(String reportName) {
		printIconReport.click();
		String winHandleBefore = getDriver().getWindowHandle();
		for (String winHandle : getDriver().getWindowHandles()) {
			getDriver().switchTo().window(winHandle);
		}
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.padding-20 > h3#use")).getText().contains(reportName));
		printPagePreviewCancel.click();
		getDriver().switchTo().window(winHandleBefore);
	}
	
	public void clickOnPrintIconReportTrialUser(){
		if(getDriver().findElements(By.cssSelector("div[class='btn-group btn-toolbar pull-right'] > a > i.icon-c-print")).size() > 0){
			printIconReport.click();
			Assert.assertTrue(alertMessagePrint.isDisplayed());
			cancelButtonModalWindowTrialPrint.click();
		}
		else{
			System.out.println("There is no print icon.");
		}
//		Assert.assertTrue(getDriver().findElements(By.cssSelector("div[class='btn-group btn-toolbar pull-right'] > a > i.icon-c-print")).size() == 0);
	}

	public void performDownload() {
		waitABit(2000);
		String script = "src\\test\\java\\drivers\\downloadTestScript.exe";
		Process p;
		try {
			p = Runtime.getRuntime().exec(script);
			p.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnDownloadIconReport(String fileName) {
		downloadIconReport.click();
		//TODO Fix this
//		DataToolPage data = new DataToolPage(getDriver());
//		data.saveImageHandle2();
		FileChecker fileChecker = new FileChecker();
		fileChecker.verifyFileIsDownloaded1(fileChecker.convertFileName(fileName));
	}
	
	public void clickOnDownloadIconReportTrialUser() {
		if(getDriver().findElements(By.cssSelector("i.icon-c-download")).size() > 0){
			downloadIconReport.click();
			Assert.assertTrue(alertMessageDownload.isDisplayed());
			cancelButtonModalWindowTrialDownload.click();
		}
		else{
			System.out.println("There is no download icon.");
		}
//		Assert.assertTrue(getDriver().findElements(By.cssSelector("i.icon-c-download")).size() == 0);
	}

	public void clickOnBackToPreviousPage() {
		backToPreviousPageButtonReport.click();
	}

	public void clickOnPastVersionsToggler(){
		if(getDriver().findElements(By.cssSelector("div[class='pull-right drop-content-toggler'] > div > a > span")).size() == 1){
			pastVersionsToggler.click();
		}
	}
	
	public void verifyIfPastVersionTogglerIsExpanded(){
		if(getDriver().findElements(By.cssSelector("div[class='pull-right drop-content-toggler'] > div > a > span")).size() == 1){
			Assert.assertTrue(getDriver().findElements(By.cssSelector("div[class='pull-right drop-content-toggler'] a[class='btn active']")).size() == 1);
		}
	}
	
	public void verifyIfPastVersionTogglerIsCollapsed(){
		if(getDriver().findElements(By.cssSelector("div[class='pull-right drop-content-toggler'] > div > a > span")).size() == 1){
			Assert.assertTrue(getDriver().findElements(By.cssSelector("div[class='pull-right drop-content-toggler'] a[class='btn'] ")).size() == 1);
		}
	}
	
	public void clickOnOneItemFromLeftHandPanelAndVerifyName(int itemNumber){
		int numberOfItemsDisplayed, itemNameNumber;
		numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("div#scrollContent > ul > li.nav-header > ul > li")).size();
		String itemTitle="", itemName= "";
		if (numberOfItemsDisplayed > 0) {
			if (itemNumber <= numberOfItemsDisplayed && itemNumber > 0) {
				itemTitle = getDriver().findElement(By.cssSelector("div#scrollContent > ul > li.nav-header > ul > li:nth-child(" + itemNumber + ") > a")).getText();
				getDriver().findElement(By.cssSelector("div#scrollContent > ul > li.nav-header > ul > li:nth-child(" + itemNumber + ") > a")).click();
				itemNameNumber = itemNumber + 2;
				itemName = getDriver().findElement(By.cssSelector("article > div:nth-child(" + itemNameNumber + ") > h4")).getText();
				Assert.assertTrue(itemName.contains(itemTitle));
			} else {
				System.out.println("There aren't so many items displayed so clicking the first item");
				itemTitle = getDriver().findElement(By.cssSelector("div#scrollContent > ul > li.nav-header > ul > li:nth-child(1) > a")).getText();
				getDriver().findElement(By.cssSelector("div#scrollContent > ul > li.nav-header > ul > li:nth-child(1) > a")).click();
				itemName = getDriver().findElement(By.cssSelector("article > div:nth-child(3) > h4")).getText();
				Assert.assertTrue(itemName.contains(itemTitle));
			}
		} else {
			System.out.println("There aren't any items in the left hand panel!");
		}
	}
	
	public void clickOnEmailIcon(){
		emailIconReport.click();
	}
	
	//TODO Fix this
//	public void verifyActionIconsOfPastVersions(int pastVersionNumber){
//		getDriver().manage().window().maximize();
//		if(getDriver().findElements(By.cssSelector("div[class='pull-right drop-content-toggler'] > div > a > span")).size() == 1){
//			int numberOfPastVersions = getDriver().findElements(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div")).size();
//			String pastVersionName;
//			if(numberOfPastVersions > 0){
//				if(pastVersionNumber > 0 && pastVersionNumber < numberOfPastVersions){
//					pastVersionName = getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(" + pastVersionNumber + ") > h5 > a")).getText();
//					
//					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(" + pastVersionNumber + ") > div > span:nth-of-type(1)")).click();
//					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(" + pastVersionNumber + ") > h5 > div > div > a > i.icon-c-email")).click();
//					EmailPopUpWindowPage email = new EmailPopUpWindowPage(getDriver());
//					email.submitWithoutCompletingAnyField();
//					email.completeFieldsAndClear();
//					email.closeEmailIconPageTitle();
//					
//					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(" + pastVersionNumber + ") > div > span:nth-of-type(1)")).click();
//					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div > div:nth-child(" + pastVersionNumber + ") > h5 > div > div > a > i.icon-c-floppy")).click();
//					waitUntilElementExists(By.cssSelector("div#result > div"), 15);
//					Assert.assertTrue(getDriver().findElement(By.cssSelector("div#result > div")).getText().contains("This report already exists in Saved Reports!") || (getDriver().findElement(By.cssSelector("div#result > div")).getText().contains("Report successfully saved!")));
//					
//					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(" + pastVersionNumber + ") > div > span:nth-of-type(1)")).click();
//					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(" + pastVersionNumber + ") > h5 > div > div > a > i.icon-c-download")).click();
//					System.out.println("Download button accessed");
//					performDownload();
//					FileChecker fileChecker = new FileChecker();
//					fileChecker.verifyFileIsDownloadedRelativesArchives(fileChecker.convertFileName(pastVersionName));
//					
//					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(" + pastVersionNumber + ") > div > span:nth-of-type(1)")).click();
//					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(" + pastVersionNumber + ") > h5 > div > div > a > i.icon-c-print")).click();
//					System.out.println("Print button accessed");
//					String winHandleBefore = getDriver().getWindowHandle();
//					for (String winHandle : getDriver().getWindowHandles()) {
//						getDriver().switchTo().window(winHandle);
//					}
//					Assert.assertTrue(pastVersionName.contains(getDriver().findElement(By.cssSelector("div.padding-20 > h3#use")).getText()));
//					printPagePreviewCancel.click();
//					getDriver().switchTo().window(winHandleBefore);
//				}
//				else{
//					System.out.println("There are not so many past versions, so verify the first one!");
//					pastVersionName = getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(1) > h5 > a")).getText();
//					
//					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(1) > div > span:nth-child(1)")).click();
//					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(1) > h5 > div > div > a > i.icon-c-email")).click();
//					EmailPopUpWindowPage email = new EmailPopUpWindowPage(getDriver());
//					email.submitWithoutCompletingAnyField();
//					email.completeFieldsAndClear();
//					email.closeEmailIconPageTitle();
//					
//					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(1) > div > span:nth-child(1)")).click();
//					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(1) > h5 > div > div > a > i.icon-c-floppy")).click();
//					Assert.assertTrue(getDriver().findElement(By.cssSelector("div#result > div")).isDisplayed());
//					
//					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(1) > div > span:nth-child(1)")).click();
//					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(1) > h5 > div > div > a > i.icon-c-download")).click();
//					performDownload();
//					FileChecker fileChecker = new FileChecker();
//					fileChecker.verifyFileIsDownloadedRelativesArchives(fileChecker.convertFileName(pastVersionName));
//					
//					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(1) > div > span:nth-child(1)")).click();
//					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(1) > h5 > div > div > a > i.icon-c-print")).click();
//					String winHandleBefore = getDriver().getWindowHandle();
//					for (String winHandle : getDriver().getWindowHandles()) {
//						getDriver().switchTo().window(winHandle);
//					}
//					Assert.assertTrue(pastVersionName.contains(getDriver().findElement(By.cssSelector("div.padding-20 > h3#use")).getText()));
//					printPagePreviewCancel.click();
//					getDriver().switchTo().window(winHandleBefore);
//				}
//			}
//			else{
//				System.out.println("There is no past version..");
//			}
//		}
//	}
//	
	public void verifyActionIconsOfPastVersionsTrialUsers(int pastVersionNumber){
		if(getDriver().findElements(By.cssSelector("div[class='pull-right drop-content-toggler'] > div > a > span")).size() == 1){
			getDriver().manage().window().maximize();
			int numberOfPastVersions = getDriver().findElements(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div")).size();
			if(numberOfPastVersions > 0){
				if(pastVersionNumber > 0 && pastVersionNumber < numberOfPastVersions){
					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(" + pastVersionNumber + ") > div > span:nth-of-type(1)")).click();
					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(" + pastVersionNumber + ") > h5 > div > div > a > i.icon-c-download")).click();
					Assert.assertTrue(alertMessageDownload.isDisplayed());
					cancelButtonModalWindowTrialDownload.click();
					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(" + pastVersionNumber + ") > div > span:nth-of-type(1)")).click();
					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(" + pastVersionNumber + ") > h5 > div > div >a > i.icon-c-print")).click();
					Assert.assertTrue(alertMessagePrint.isDisplayed());
					cancelButtonModalWindowTrialPrint.click();
				}
				else{
					System.out.println("There are not so many past versions, so verify the first one!");
					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(1) > div > span:nth-child(1)")).click();
					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(1) > h5 > div > div >a > i.icon-c-download")).click();
					Assert.assertTrue(alertMessageDownload.isDisplayed());
					cancelButtonModalWindowTrialDownload.click();
					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(1) > div > span:nth-child(1)")).click();
					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(1) > h5 > div > div >a > i.icon-c-print")).click();
					Assert.assertTrue(alertMessagePrint.isDisplayed());
					cancelButtonModalWindowTrialPrint.click();
				}
			}
			else{
				System.out.println("There is no past version..");
			}
		}
	}
	
	public String verifyDownloadAndContactAccountManagerFromPastVersionsForTrialUser(int pastVersionNumber){
		String pastVersionName = null;
		if(getDriver().findElements(By.cssSelector("div[class='pull-right drop-content-toggler'] > div > a > span")).size() == 1){
			getDriver().manage().window().maximize();
			int numberOfPastVersions = getDriver().findElements(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div")).size();
			if(numberOfPastVersions > 0){
				if(pastVersionNumber > 0 && pastVersionNumber < numberOfPastVersions){
					pastVersionName = getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(" + pastVersionNumber + ") > h5 > a")).getText();
					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(" + pastVersionNumber + ") > div > span:nth-of-type(1)")).click();
					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(" + pastVersionNumber + ") > h5 > div > div > a > i.icon-c-download")).click();
					Assert.assertTrue(alertMessageDownload.isDisplayed());
					contactAccountManagementButtonTrialDownload.click();
				}
				else{
					System.out.println("There are not so many past versions, so verify the first one!");
					pastVersionName = getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(1) > h5 > a")).getText();
					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(1) > div > span:nth-child(1)")).click();
					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(1) > h5 > div > div >a > i.icon-c-download")).click();
					Assert.assertTrue(alertMessageDownload.isDisplayed());
					contactAccountManagementButtonTrialDownload.click();
				}
			}
			else{
				System.out.println("There is no past version..");
			}
		}
		return pastVersionName;
	}
	
	public String verifyPrintAndContactAccountManagerFromPastVersionsForTrialUser(int pastVersionNumber){
		String pastVersionName = null;
		if(getDriver().findElements(By.cssSelector("div[class='pull-right drop-content-toggler'] > div > a > span")).size() == 1){
			getDriver().manage().window().maximize();
			int numberOfPastVersions = getDriver().findElements(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div")).size();
			if(numberOfPastVersions > 0){
				if(pastVersionNumber > 0 && pastVersionNumber < numberOfPastVersions){
					pastVersionName = getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(" + pastVersionNumber + ") > h5 > a")).getText();
					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(" + pastVersionNumber + ") > div > span:nth-of-type(1)")).click();
					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(" + pastVersionNumber + ") > h5 > div > div >a > i.icon-c-print")).click();
					Assert.assertTrue(alertMessagePrint.isDisplayed());
					contactAccountManagementButtonTrialPrint.click();
				}
				else{
					System.out.println("There are not so many past versions, so verify the first one!");
					pastVersionName = getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(1) > h5 > a")).getText();
					getDriver().findElement(By.cssSelector("div[class='media-listing media-list-view-past-versions'] > div:nth-child(1) > div > span:nth-child(1)")).click();
					getDriver().findElement(By.cssSelector("article > div.drop-content > div > div >div:nth-child(1) > h5 > div > div >a > i.icon-c-print")).click();
					Assert.assertTrue(alertMessagePrint.isDisplayed());
					contactAccountManagementButtonTrialPrint.click();
				}
			}
			else{
				System.out.println("There is no past version..");
			}
		}
		return pastVersionName;
	}
	
	public void verifyReportDetailMediaActions() {
		element((getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > div:nth-child(1) >  div:nth-child(2) > a> i.icon-c-floppy")))).waitUntilPresent();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > div:nth-child(1) > div:nth-child(2) > a> i.icon-c-floppy")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > div:nth-child(1) > div:nth-child(2) > a> i.icon-c-email")).isDisplayed());
	}
	
	public void verifyReportHoveredMediaActions(int reportNumber) {
		element(getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child("+reportNumber+") > div > div.tags"))).click();
		System.out.println("clicked!");
		element(getDriver().findElement(By.cssSelector("div#sar-reports-container >div:nth-child("+reportNumber+") > div:nth-child(2) > div > a > i.icon-c-floppy"))).waitUntilPresent();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#sar-reports-container >div:nth-child("+reportNumber+") > div:nth-child(2) > div > a > i.icon-c-floppy")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#sar-reports-container >div:nth-child("+reportNumber+") > div:nth-child(2) > div > a > i.icon-c-email")).isDisplayed());
	}
	
	public void verifyReportPreviewMediaActions() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#js-overflow > section > div > div:nth-child(1) > div > a > i.icon-c-floppy")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#js-overflow > section > div > div:nth-child(1) > div > a > i.icon-c-email")).isDisplayed());
	}
}

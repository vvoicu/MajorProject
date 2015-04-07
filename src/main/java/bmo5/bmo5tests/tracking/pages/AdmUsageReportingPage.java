package bmo5.bmo5tests.tracking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.tracking.AbstractTrackingPage;


/**
 * Usage Reporting page for ADM site
 */
public class AdmUsageReportingPage extends AbstractTrackingPage{

	public AdmUsageReportingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div#edit_users > a.btn")
	private WebElement selectUsersButton;
	
	@FindBy(id = "email")
	private WebElement emailField;
	
	@FindBy(id = "site_navigation")
	private WebElement siteNavigationCheckbox;
	
	@FindBy(id = "article_hits")
	private WebElement articleHitsCheckbox;
	
	@FindBy(id = "pdf_downloads")
	private WebElement pdfDownloadsCheckbox;
	
	@FindBy(id = "ndb_stats")
	private WebElement ndbStatsCheckbox;
	
	@FindBy(id = "company_stats")
	private WebElement companyStatsCheckbox;
	
	@FindBy(id = "session_logs")
	private WebElement concurrentLimitCheckbox;
	
	@FindBy(id = "dna_toolkit")
	private WebElement dnaToolkitCheckbox;
	
	@FindBy(id = "keyword_search")
	private WebElement keywordSearchCheckbox;
	
	@FindBy(id = "advanced_search")
	private WebElement advancedSearchCheckbox;
	
	@FindBy(id = "chart_builder")
	private WebElement chartBuilderCheckbox;
	
	@FindBy(id = "non_permission_content")
	private WebElement nonPermissionContentCheckbox;
	
	@FindBy(id = "burden_of_disease")
	private WebElement burdenOfDiseaseCheckbox;
	
	@FindBy(id = "commoditities_database")
	private WebElement commoditiesCheckbox;
	
	@FindBy(id = "global_mines")
	private WebElement globalMinesCheckbox;
	
	@FindBy(id = "global_refining")
	private WebElement globalRefiningCheckbox;
	
	@FindBy(id = "key_projects")
	private WebElement keyProjectsCheckbox;
	
	@FindBy(id = "mobile_operators")
	private WebElement mobileOperatorsCheckbox;
	
	@FindBy(id = "upstream_projects")
	private WebElement upstreamProjectsCheckbox;
	
	@FindBy(id = "feed_in_tariffs")
	private WebElement feedInTariffsCheckbox;
	
	@FindBy(id = "clipboard_activity")
	private WebElement clipboardActivityCheckbox;
	
	@FindBy(id = "summary_options_no_summary")
	private WebElement noSummaryReportingIncludedRadioButton;
	
	@FindBy(id = "summary_options_aggregate_by_month")
	private WebElement aggregateByMonthRadioButton;
	
	@FindBy(id = "summary_options_aggregate_by_user")
	private WebElement aggregateByUserNumberRadioButton;
	
	@FindBy(id = "sales_format")
	private WebElement salesFormatCheckbox;
	
	@FindBy(id = "start_date")
	private WebElement startDateField;
	
	@FindBy(id = "end_date")
	private WebElement endDateField;
	
	@FindBy(id = "export_data_to_excel")
	private WebElement exportDataToExcelButton;
	
	@FindBy(id = "report_was_queued")
	private WebElement reportWasQueuedModal;
	
	@FindBy(css = "div#report_was_queued div.modal-footer > button")
	private WebElement closeButtonFromReportWasQueuedModal;
	
	
	
	
	public String getSessionID(){
		String sessionID = getDriver().manage().getCookieNamed("session").toString();
		return sessionID;
	}
	
	public void clickOnSelectUsersButton(){
		element(selectUsersButton).waitUntilVisible();
		selectUsersButton.click();
	}
	
	public void emailInput(String userEmail){
		element(emailField).waitUntilVisible();
		emailField.clear();
		emailField.sendKeys(userEmail);
	}
	
	public void checkSiteNavigation(){
		element(siteNavigationCheckbox).waitUntilVisible();
		siteNavigationCheckbox.click();
	}
	
	public void checkArticleHits(){
		element(articleHitsCheckbox).waitUntilVisible();
		articleHitsCheckbox.click();
	}
	
	public void checkPdfDownloads(){
		element(pdfDownloadsCheckbox).waitUntilVisible();
		pdfDownloadsCheckbox.click();
	}
	
	public void checkNdbStats(){
		element(ndbStatsCheckbox).waitUntilVisible();
		ndbStatsCheckbox.click();
	}
	
	public void checkCompanyStats(){
		element(companyStatsCheckbox).waitUntilVisible();
		companyStatsCheckbox.click();
	}
	
	public void checkConcurrentLimit(){
		element(concurrentLimitCheckbox).waitUntilVisible();
		concurrentLimitCheckbox.click();
	}
	
	public void checkDnaToolKit(){
		element(dnaToolkitCheckbox).waitUntilVisible();
		dnaToolkitCheckbox.click();
	}
	
	public void checkKeywordSearch(){
		element(keywordSearchCheckbox).waitUntilVisible();
		keywordSearchCheckbox.click();
	}
	
	public void checkAdvancedSearch(){
		element(advancedSearchCheckbox).waitUntilVisible();
		advancedSearchCheckbox.click();
	}
	
	public void checkCartBuilder(){
		element(chartBuilderCheckbox).waitUntilVisible();
		chartBuilderCheckbox.click();
	}
	
	public void checkNonPermissionContent(){
		element(nonPermissionContentCheckbox).waitUntilVisible();
		nonPermissionContentCheckbox.click();
	}
	
	public void checkBurdenOfDisease(){
		element(burdenOfDiseaseCheckbox).waitUntilVisible();
		burdenOfDiseaseCheckbox.click();
	}
	
	public void checkCommodities(){
		element(commoditiesCheckbox).waitUntilVisible();
		commoditiesCheckbox.click();
	}
	
	public void checkGlobalMines(){
		element(globalMinesCheckbox).waitUntilVisible();
		globalMinesCheckbox.click();
	}
	
	public void checkGlobalRefining(){
		element(globalRefiningCheckbox).waitUntilVisible();
		globalRefiningCheckbox.click();
	}
	
	public void checkKeyProjects(){
		element(keyProjectsCheckbox).waitUntilVisible();
		keyProjectsCheckbox.click();
	}
	
	public void checkMobileOperators(){
		element(mobileOperatorsCheckbox).waitUntilVisible();
		mobileOperatorsCheckbox.click();
	}
	
	public void checkUpstreamProjects(){
		element(upstreamProjectsCheckbox).waitUntilVisible();
		upstreamProjectsCheckbox.click();
	}
	
	public void checkFeedInTariffs(){
		element(feedInTariffsCheckbox).waitUntilVisible();
		feedInTariffsCheckbox.click();
	}
	
	public void checkNoSummaryReportingIncluded(){
		element(noSummaryReportingIncludedRadioButton).waitUntilVisible();
		noSummaryReportingIncludedRadioButton.click();
	}
	
	public void checkAggregateByMonth(){
		element(aggregateByMonthRadioButton).waitUntilVisible();
		aggregateByMonthRadioButton.click();
	}
	
	public void checkAggregateByUserNumber(){
		element(aggregateByUserNumberRadioButton).waitUntilVisible();
		aggregateByUserNumberRadioButton.click();
	}
	
	public void checkSalesReportFormat(){
		element(salesFormatCheckbox).waitUntilVisible();
		salesFormatCheckbox.click();
	}

	public void insertStartDate(String startDate){
		element(startDateField).waitUntilVisible();
		element(startDateField).clear();
		startDateField.sendKeys(startDate);
	}
	
	public void insertEndDate(String endDate){
		element(endDateField).waitUntilVisible();
		element(endDateField).clear();
		endDateField.sendKeys(endDate);
	}
	
	public void clickExportReportToExcelButton(){
		element(exportDataToExcelButton).waitUntilVisible();
		exportDataToExcelButton.click();
	}
	
	public void clickCloseButtonFromReportWasQueuedModal(){
		element(reportWasQueuedModal).waitUntilVisible();
		element(closeButtonFromReportWasQueuedModal).waitUntilVisible();
		closeButtonFromReportWasQueuedModal.click();
	}
	
	public String returnReportID(){
		element(getDriver().findElement(ById.id("report_queued_message"))).waitUntilVisible();
		String textMessage = getDriver().findElement(ById.id("report_queued_message")).getText();
		String reportID = textMessage.replaceAll("[^0-9]", "").toString().trim();
		return reportID;
	}
	
	public void downloadReport(String reportID){
		navigateURL(Constants.YourReportsURL);
		element(getDriver().findElement(By.cssSelector("tr[id='"+reportID+"']"))).waitUntilVisible();
		while (!getDriver().findElement(By.cssSelector("tr[id='"+reportID+"'] > td:nth-child(7)")).getText().trim().contains("Completed")){
			getDriver().navigate().refresh();
			element(getDriver().findElement(By.cssSelector("tr[id='"+reportID+"']"))).waitUntilVisible();
		}
		element(getDriver().findElement(By.cssSelector("tr[id='"+reportID+"'] > td:nth-child(8) > a:nth-child(1)"))).waitUntilVisible();
		element(getDriver().findElement(By.cssSelector("tr[id='"+reportID+"'] > td:nth-child(8) > a:nth-child(1)"))).click();
		waitABit(10000);
	}

	public void deleteReport(String reportID){
		element(getDriver().findElement(By.cssSelector("tr[id='"+reportID+"'] > td:nth-child(8) > a:nth-child(2)"))).waitUntilVisible();
		element(getDriver().findElement(By.cssSelector("tr[id='"+reportID+"'] > td:nth-child(8) > a:nth-child(2)"))).click();
	}
	
	
}

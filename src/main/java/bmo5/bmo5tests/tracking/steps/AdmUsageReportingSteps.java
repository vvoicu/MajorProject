package bmo5.bmo5tests.tracking.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import bmo5.bmo5tests.tools.tracking.AbstractTrackingSteps;

public class AdmUsageReportingSteps extends AbstractTrackingSteps{
	
	private static final long serialVersionUID = -3234781128713122231L;

	public AdmUsageReportingSteps(Pages pages) {
		super(pages);
	}


	@Step
	public void getSessionID(){
		admUsageReportingPage().getSessionID();
	}
	
	@Step
	public void clickOnSelectUsersButton(){
		admUsageReportingPage().clickOnSelectUsersButton();
	}
	
	@Step
	public void emailInput(String userEmail){
		admUsageReportingPage().emailInput(userEmail);
	}
	
	@Step
	public void checkSiteNavigation(){
		admUsageReportingPage().checkSiteNavigation();
	}
	
	@Step
	public void checkArticleHits(){
		admUsageReportingPage().checkArticleHits();
	}
	
	@Step
	public void checkPdfDownloads(){
		admUsageReportingPage().checkPdfDownloads();
	}
	
	@Step
	public void checkNdbStats(){
		admUsageReportingPage().checkNdbStats();
	}
	
	@Step
	public void checkCompanyStats(){
		admUsageReportingPage().checkCompanyStats();
	}
	
	@Step
	public void checkConcurrentLimit(){
		admUsageReportingPage().checkConcurrentLimit();
	}
	
	@Step
	public void checkDnaToolKit(){
		admUsageReportingPage().checkDnaToolKit();
	}
	
	@Step
	public void checkKeywordSearch(){
		admUsageReportingPage().checkKeywordSearch();
	}
	
	@Step
	public void checkAdvancedSearch(){
		admUsageReportingPage().checkAdvancedSearch();
	}
	
	@Step
	public void checkCartBuilder(){
		admUsageReportingPage().checkCartBuilder();
	}
	
	@Step
	public void checkNonPermissionContent(){
		admUsageReportingPage().checkNonPermissionContent();
	}
	
	@Step
	public void checkBurdenOfDisease(){
		admUsageReportingPage().checkBurdenOfDisease();
	}
	
	@Step
	public void checkCommodities(){
		admUsageReportingPage().checkCommodities();
	}
	
	@Step
	public void checkGlobalMines(){
		admUsageReportingPage().checkGlobalMines();
	}
	
	@Step
	public void checkGlobalRefining(){
		admUsageReportingPage().checkGlobalRefining();
	}
	
	@Step
	public void checkKeyProjects(){
		admUsageReportingPage().checkKeyProjects();
	}
	
	@Step
	public void checkMobileOperators(){
		admUsageReportingPage().checkMobileOperators();
	}
	
	@Step
	public void checkUpstreamProjects(){
		admUsageReportingPage().checkUpstreamProjects();
	}
	
	@Step
	public void checkFeedInTariffs(){
		admUsageReportingPage().checkFeedInTariffs();
	}
	
	@Step
	public void checkNoSummaryReportingIncluded(){
		admUsageReportingPage().checkNoSummaryReportingIncluded();
	}
	
	@Step
	public void checkAggregateByMonth(){
		admUsageReportingPage().checkAggregateByMonth();
	}
	
	@Step
	public void checkAggregateByUserNumber(){
		admUsageReportingPage().checkAggregateByUserNumber();
	}
	
	
	@Step
	public void checkSalesReportFormat(){
		admUsageReportingPage().checkSalesReportFormat();
	}
	
	@Step
	public void insertStartDate(String startDate){
		admUsageReportingPage().insertStartDate(startDate);
	}
	
	@Step
	public void insertEndDate(String endDate){
		admUsageReportingPage().insertEndDate(endDate);
	}
	
	@Step
	public void clickExportReportToExcelButton(){
		admUsageReportingPage().clickExportReportToExcelButton();
	}
	
	@Step
	public String returnReportID(){
		return admUsageReportingPage().returnReportID();
	}
	
	@Step
	public void clickCloseButtonFromReportWasQueuedModal(){
		admUsageReportingPage().clickCloseButtonFromReportWasQueuedModal();
	}
		
	@Step
	public void downloadReport(String reportID){
		admUsageReportingPage().downloadReport(reportID);
	}
	
	@Step
	public void deleteReport(String reportID){
		admUsageReportingPage().deleteReport(reportID);
	}
	
}

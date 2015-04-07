package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import org.openqa.selenium.By;
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.tools.NavigationItems;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class SingleReportSteps extends AbstractSteps{

	private static final long serialVersionUID = 1L;

	@StepGroup
	public void verifyPastVersionSection(int pastVersionNumber){
		if(getDriver().findElements(By.cssSelector("div[class='pull-right drop-content-toggler'] a#toggler")).size() == 1){
//			verifyIfPastVersionTogglerIsCollapsed();
			clickOnPastVersionsToggler();
//			verifyIfPastVersionTogglerIsExpanded();
			//TODO fix this
			//	verifyActionIconsOfPastVersions(pastVersionNumber);
			strategicAnalysisAndReportsPage().verifyNumberOfPastVersions();
			strategicAnalysisAndReportsPage().navigateToItemPastVersions(NavigationItems.Five);
			strategicAnalysisAndReportsPage().navigateToItemPastVersions(NavigationItems.First);
			strategicAnalysisAndReportsPage().navigateToItemPastVersions(NavigationItems.Next);
			strategicAnalysisAndReportsPage().navigateToItemPastVersions(NavigationItems.Last);
			strategicAnalysisAndReportsPage().navigateToItemPastVersions(NavigationItems.Previous);
			Sleeper.sleepTight(2000);
			clickOnPastVersionsToggler();
			verifyIfPastVersionTogglerIsCollapsed();
		}
		else{
			System.out.println("There is no past version");
		}
	}

	@Step
	public void clickOnEmailIconOfOneReportFromListing(int reportNumber) {
		singleReportPage().clickOnEmailIconReportFromList(reportNumber);
	} 

	@Step
	public void clickOnSaveIconOfOneReportFromListing(int reportNumber) {
		singleReportPage().clickOnSaveIconReportFromList(reportNumber);
	} 

	//TODO fix this
//	@Step
//	public void clickOnDownloadIconOfOneReportFromListing(int reportNumber) {
//		singleReportPage().clickOnDownloadIconReportFromList(reportNumber);
//	} 

	@Step
	public void clickOnPrintIconOfOneReportFromListing(int reportNumber) {
		singleReportPage().clickOnPrintIconReportFromList(reportNumber);
	} 

	@Step
	public String clickOnPreviewOfOneReportFromListing(int reportNumber) {
		return singleReportPage().clickOnPreviewReportFromList(reportNumber);
	} 

	@Step
	public String clickOnOneReportFromListing(int reportNumber) {
		return singleReportPage().clickOnOneReportFromList(reportNumber);
	} 

	@Step
	public String  clickASpecialReportsFromListing(int reportNumber) {
		return singleReportPage(). clickASpecialReportsFromListing(reportNumber);
	} 

	@Step
	public void clickOnSaveIconReport(){
		singleReportPage().clickOnSaveIconReport();
	}

	@Step
	public void clickOnPrintIconReport(String reportName){
		singleReportPage().clickOnPrintIconReport(reportName);
	}

	@Step
	public void clickOnDownloadIconReport(String fileName){
		singleReportPage().clickOnDownloadIconReport(fileName);
	}

	@Step
	public void clickOnBackToPreviousPage(){
		singleReportPage().clickOnBackToPreviousPage();
	}

	@Step
	public void clickOnPastVersionsToggler(){
		singleReportPage().clickOnPastVersionsToggler();
	}

	@Step
	public void clickOnOneItemFromLeftHandPanel(int itemNumber){
		singleReportPage().clickOnOneItemFromLeftHandPanelAndVerifyName(itemNumber);;
	}

	@Step
	public void clickOnEmailIcon(){
		singleReportPage().clickOnEmailIcon();
	}

	//TODO fix this
//	@Step
//	public void verifyActionIconsOfPastVersions(int pastVersionNumber){
//		singleReportPage().verifyActionIconsOfPastVersions(pastVersionNumber);
//	}

	@Step
	public String clickOnPreviewReportArchiveFromList(int reportNumber) {
		return singleReportPage().clickOnPreviewReportArchiveFromList(reportNumber);
	}

	//TODO fix this
//	@Step
//	public void verifyDownloadFromHoveredMediaActions(int reportNumber) {
//		singleReportPage().verifyDownloadFromHoveredMediaActions(reportNumber);
//	}

	@Step
	public void clickOnPrintIconReportFromListTrialUser(int reportNumber){
		singleReportPage().clickOnPrintIconReportFromListTrialUser(reportNumber);
	}

	@Step
	public void clickOnDownloadIconReportFromListTrialUser(int reportNumber){
		singleReportPage().clickOnDownloadIconReportFromListTrialUser(reportNumber);
	}

	@Step
	public void clickOnPrintIconReportTrialUser(){
		singleReportPage().clickOnPrintIconReportTrialUser();
	}

	@Step
	public void clickOnDownloadIconReportTrialUser() {
		singleReportPage().clickOnDownloadIconReportTrialUser();
	}

	@Step
	public void verifyActionIconsOfPastVersionsTrialUsers(int pastVersionNumber){
		singleReportPage().verifyActionIconsOfPastVersionsTrialUsers(pastVersionNumber);
	}

	@Step
	public String clickOnPrintIconReportFromListTrialUserAndVerifyContactAccountManager(int reportNumber){
		return singleReportPage().clickOnPrintIconReportFromListTrialUserAndVerifyContactAccountManager(reportNumber);
	}

	@Step
	public String clickOnDownloadIconReportFromListTrialUserAndVerifyContactAccountManager(int reportNumber){
		return singleReportPage().clickOnDownloadIconReportFromListTrialUserAndVerifyContactAccountManager(reportNumber);
	}

	@Step
	public void saveEnterpriseIconInsideReport() {
		singleReportPage().saveEnterpriseIconInsideReport();
	}

	@Step
	public void verifyMediaActionOnHoveredReport(int reportNumber) {
		singleReportPage().verifyMediaActionOnHoveredReport(reportNumber);

	}

	@Step
	public void verifyMediaActionsOnReportView() {
		singleReportPage().verifyMediaActionsOnReportView();
	}

	@Step
	public void verifyMediaActionInReportPreview() {
		singleReportPage().verifyMediaActionInReportPreview();
	}

	@Step
	public void verifyReportHoveredMediaActions(int reportNumber) {
		singleReportPage().verifyReportHoveredMediaActions(reportNumber);
	}

	@Step
	public void verifyReportPreviewMediaActions() {
		singleReportPage().verifyReportPreviewMediaActions();
	}

	@Step
	public void verifyReportDetailMediaActions() {
		singleReportPage().verifyReportDetailMediaActions();

	}
	
	@Step
	public String clickOnPreviewReportsFromList(int reportNumber) {
		return singleReportPage().clickOnPreviewReportsFromList(reportNumber);
	}
	
	@Step
	public String verifyDownloadAndContactAccountManagerFromPastVersionsForTrialUser(int pastVersionNumber){
		return singleReportPage().verifyDownloadAndContactAccountManagerFromPastVersionsForTrialUser(pastVersionNumber);
	}
	
	@Step
	public String verifyPrintAndContactAccountManagerFromPastVersionsForTrialUser(int pastVersionNumber){
		return singleReportPage().verifyPrintAndContactAccountManagerFromPastVersionsForTrialUser(pastVersionNumber);
	}
	
	@Step
	public void verifyIfPastVersionTogglerIsExpanded(){
		singleReportPage().verifyIfPastVersionTogglerIsExpanded();
	}
	
	@Step
	public void verifyIfPastVersionTogglerIsCollapsed(){
		singleReportPage().verifyIfPastVersionTogglerIsCollapsed();
	}
}

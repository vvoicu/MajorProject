package bmo5.bmo5tests.bmo.steps.pillars;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class ReportsArchiveSteps extends AbstractSteps {
	
	private static final long serialVersionUID = 5871984679758645713L;

	@StepGroup
	public void searchByContinentAllServicesSortByService(String continentName){
		filterGeographyLeftList(continentName);
		selectGeographyByValue(continentName);
		clickGeographyRightSimpleArrow();
		selectAllServicesCheckboxAndVerifySelected();
		selectSortByServiceRadiobutton();
		clickSearchAndVerifyResultsContainerIsDisplayed();
	}
	
	@StepGroup
	public void searchByAllGeographiesAllServicesSortByTitle(){
		clickGeographyRightDoubleArrow();
		selectAllServicesCheckboxAndVerifySelected();
		selectSortByTitleRadiobutton();
		clickSearchAndVerifyResultsContainerIsDisplayed();
	}
	
	@StepGroup
	public void searchByOneCountryOneServiceDateRangeSortByPublicationDate(String country,String service,String startDate, String endDate){
		selectGeographyByValue(country);
		clickGeographyRightSimpleArrow();
		selectServiceByValue(service);
		selectDateRange(startDate, endDate);
		selectSortByPublicationDateRadiobutton();
		clickSearchAndVerifyResultsContainerIsDisplayed();
	}
	
	@StepGroup
	public void verifyAllElementsAreCleared(String sortByOption, String dateRangeOption){
		verifyReportTitleEmpty();
    	verifyGeographyFilterEmpty();
    	verifyGeographyRightListEmpty();
    	verifyGeographyLeftListSize();
    	verifyServicesUnchecked();
    	verifyDateRangeRadiobuttonSelected(sortByOption);
    	verifySortByRadiobuttonSelected(dateRangeOption);
	}
	
	@StepGroup
	public void selectOptionsFromLeftHandAndVerifySelected(String geographyName, String geographyCode, String serviceName, String serviceCode, String reportType, String reportCode){
		selectGeographyFromLeftHand(geographyName);
		verifyIfCountryIsSelected(geographyCode);
		selectServiceFromLeftHand(serviceName);
		verifyIfServiceIsSelected(serviceCode);
		selectReportTypeFromLeftHand(reportType);
		verifyIfReportTypeIsSelected(reportCode);
	}
	
	@StepGroup
	public void verifyOptionsFromLeftHandFilterAreDeselected(String geographyCode, String serviceCode, String reportCode){
		verifyGeographyIsDeselected(geographyCode);
		verifyServiceIsDeselected(serviceCode);
		verifyReportTypeIsDeselected(reportCode);
	}
	
	@StepGroup
	public void verifyBackToReportsArchiveSelections(String geoCodeBack,String country,String servCodeBack,String service,String startDate,String endDate,String sortByOption){
		reportsArchiveListingPage().backToReportsArchive();
		reportsArchiveLandingPage().verifyGeographySelectionInReportsArchiveInitialPage(geoCodeBack,country);
		reportsArchiveLandingPage().verifyServiceSelectionInReportsArchiveInitialPage(servCodeBack);
		reportsArchiveLandingPage().verifyStartEndDateInBackReportsArchivePage(startDate,endDate);
		reportsArchiveLandingPage().verifySortByIsSelected(sortByOption);
		reportsArchiveLandingPage().clickSearchAndVerifyResultsContainerIsDisplayed();
	}
	
	@Step
	public void typeSearchLettersAndVerifyReport(String searchLetters){
		reportsArchiveLandingPage().typeSearchLettersAndVerifyReport(searchLetters);
	}
	
	@Step
	public void clickSearchAndVerifyResultsContainerIsDisplayed(){
		reportsArchiveLandingPage().clickSearchAndVerifyResultsContainerIsDisplayed();
	}
	
	@Step
	public void clickClearLink(){
		reportsArchiveLandingPage().clickClearLink();
	}
	 
	@Step 
	public void clickGeographyRightSimpleArrow(){
		reportsArchiveLandingPage().clickGeographyRightSimpleArrow();
	}
	
	@Step
	public void typeReportTitle(String title){
		reportsArchiveLandingPage().typeReportTitle(title);
	}
	
	@Step 
	public void clickGeographyRightDoubleArrow(){
		reportsArchiveLandingPage().clickGeographyRightDoubleArrow();
	}
	
	@Step 
	public void filterGeographyLeftList(String continentName){
		reportsArchiveLandingPage(). filterGeographyLeftList(continentName);
	}
	
	@Step
	public void selectGeographyByValue(String country){
		reportsArchiveLandingPage().selectGeographyByValue(country);
	}
	
	@Step
	public void selectServiceByValue(String service){
		reportsArchiveLandingPage().selectServiceByValue(service);
	}
	
	@Step 
	public void selectAllServicesCheckboxAndVerifySelected(){
		reportsArchiveLandingPage().selectAllServicesCheckboxAndVerifySelected();
	}
	
	@Step
	public void selectSortByServiceRadiobutton(){
		reportsArchiveLandingPage().selectSortByServiceRadiobutton();
	}
	
	@Step
	public void selectSortByTitleRadiobutton(){
		reportsArchiveLandingPage().selectSortByTitleRadiobutton();
	}
	
	@Step
	public void selectSortByPublicationDateRadiobutton(){
		reportsArchiveLandingPage().selectSortByPublicationDateRadiobutton();
	}
	
	@Step
	public void selectWithinLastMonthRadiobutton(){
		reportsArchiveLandingPage().selectWithinLastMonthRadiobutton();
	}
	
	@Step
	public void verifySortByDateSelectedOption(){
		reportsArchiveListingPage().verifySortByDateSelectedOption(); 
	}
	
	@Step
	public void verifySortByTitleSelectedOption(){
		reportsArchiveListingPage().verifySortByTitleSelectedOption(); 
	}
	
	@Step
	public void verifySortByServiceSelectedOption(){
		reportsArchiveListingPage().verifySortByServiceSelectedOption(); 
	}
	
	@Step
	public void clickRightDoubleArrow(){
		reportsArchiveListingPage().clickRightDoubleArrow();
	}	
	
	@Step
	public void getNumberOfReportsAndVerifyResults(){
		reportsArchiveListingPage().getNumberOfReportsAndVerifyResults();
	}
	
	@Step
	public void selectDateRange(String startDate,String endDate){
		reportsArchiveLandingPage().selectDateRange(startDate, endDate);
	}
	
	@Step
	public void verifyGeographyFilterEmpty(){
		reportsArchiveLandingPage().verifyGeographyFilterEmpty();
	}
	
	@Step
	public void verifyReportTitleEmpty(){
		reportsArchiveLandingPage().verifyReportTitleEmpty();
	}
	
	@Step
	public void verifyGeographyRightListEmpty(){
		reportsArchiveLandingPage().verifyGeographyRightListEmpty();
	}
	
	@Step
	public void verifyGeographyLeftListSize(){
		reportsArchiveLandingPage().verifyGeographyLeftListSize();
	}
	
	@Step 
	public void verifyServicesUnchecked(){
		reportsArchiveLandingPage().verifyServicesUnchecked();
	}
	
	@Step
	public void verifyDateRangeRadiobuttonSelected(String sortByOption){
		reportsArchiveLandingPage().verifySortByIsSelected(sortByOption);
	}
	
	@Step
	public void verifySortByRadiobuttonSelected(String dateRangeOption){
		reportsArchiveLandingPage().verifyDataRangeIsSelected(dateRangeOption);
	}
	
	@Step
	public void verifyIfCountryIsSelected(String countryCode){
		reportsArchiveListingPage().verifyIfCountryIsSelected(countryCode);
	}
	
	@Step
	public void verifyIfServiceIsSelected(String serviceCode){
		reportsArchiveListingPage().verifyIfServiceIsSelected(serviceCode);
	}
	
	@Step
	public void verifyIfReportTypeIsSelected(String reportCode){
		reportsArchiveListingPage().verifyIfReportTypeIsSelected(reportCode);
	}
	
	@Step
	public void selectSortByServiceFromDropDown(){
		reportsArchiveListingPage().selectSortByServiceFromDropDown();
	}
	
	@Step 
	public void navigatePages(){
		reportsArchiveListingPage().navigatePages();
	}
	
	@Step
	public void selectServiceFromLeftHand(String serviceName){
		reportsArchiveListingPage().selectServiceFromLeftHand(serviceName);
	}
	
	@Step
	public void selectGeographyFromLeftHand(String geographyName){
		reportsArchiveListingPage().selectGeographyFromLeftHand(geographyName);
	}
	
	@Step
	public void selectReportTypeFromLeftHand(String reportTypeName){
		reportsArchiveListingPage().selectReportTypeFromLeftHand(reportTypeName);
	}
	
	@Step
	public void clickLeftDoubleArrow(){
		reportsArchiveListingPage().clickLeftDoubleArrow();
	}

	@Step
	public void searchMNCOperations() {
		reportsArchiveLandingPage().clickSearchAndVerifyResultsContainerIsDisplayed();
	}
	
	@Step
	public void clickOnBackToBMIReportsButtonAndVerifyBreadcrumb(){
		reportsArchiveListingPage().clickOnBackToBMIReportsButtonAndVerifyBreadcrumb();
	}
	
	@Step
	public void verifyServiceIsDeselected(String serviceCode){
		reportsArchiveListingPage().verifyServiceIsDeselected(serviceCode);
	}
	
	@Step
	public void verifyGeographyIsDeselected(String geographyCode){
		reportsArchiveListingPage().verifyGeographyIsDeselected(geographyCode);
	}
	
	@Step
	public void verifyReportTypeIsDeselected(String reportCode){
		reportsArchiveListingPage().verifyReportTypeIsDeselected(reportCode);
	}
	
}
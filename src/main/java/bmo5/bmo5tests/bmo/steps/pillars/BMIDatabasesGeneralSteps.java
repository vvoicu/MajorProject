package bmo5.bmo5tests.bmo.steps.pillars;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class BMIDatabasesGeneralSteps extends AbstractSteps{

	private static final long serialVersionUID = 455035537832662255L;

	@StepGroup
	public void selectGeography(String geography) {
		searchFilterGeographySection(geography);
		selectOneGeograpyFromFilter(geography);
	}
	
	@StepGroup
	public void selectOperator(String operator) {
		clickFilterOperatorsSection();
		selectOneOperatorFromFilter(operator);
	}
	
	@StepGroup
	public void selectIndicator(String indicator) {
		clickFilterIndicatorSection();
		selectOneIndicatorFromFilter(indicator);
	}
	
	@StepGroup
	public void selectAge(String age) {
		clickFilterAgeSection();
		selectOneAgeFromFilter(age);
	}	
	
	@StepGroup
	public void searchFilterGeographySection(String geography){
		bmiDatabasesGeneralPage().searchFilterGeographySection(geography);
	}
	
	@StepGroup
	public void selectGender(String gender) {
		clickFilterGenderSection();
		selectOneGenderFromFilter(gender);
	}
	
	@StepGroup
	public void verifyGeographyFilter(String continent){
		verifyIfOneRegionIsNotChecked(continent);
		checkOneRegion(continent);
		verifyIfOneRegionIsChecked(continent);
	}
	
	@Step
	public void selectIndicatorFromFilter(String indicator) {
		bmiDatabasesGeneralPage().expandIndicatorFromFilter(indicator);		
	}
	
	@Step
	public void displayDataChart() {
		bmiDatabasesGeneralPage().displayChart();
	}
	
	@Step
	public String saveNameChart(String name) {
		return bmiDatabasesGeneralPage().clickSaveTheChartName(name);
	}
	
	@Step
	public String saveTable(String name) {
		return bmiDatabasesGeneralPage().saveTable(name);
	}
	
	@Step
	public void clickSaveButton() {
		 bmiDatabasesGeneralPage().clickSavebutton(); 
	} 
	
	@Step
	public void verifySavedNameAndDateInSaveWindow(String savedName, String date) {
		 bmiDatabasesGeneralPage().verifySavedNameAndDateInSaveWindow( savedName,  date); 
	} 

	@Step
	public void cancelFromSaveDialogWindowOfDataChart() {
		bmiDatabasesGeneralPage().clickCancelFromSaveDialogWindow();
	}
	
	@Step
	public void clickOnOneDatabase(String databaseName){
		bmiDatabasesGeneralPage().clickOnOneDatabase(databaseName);
	}
	
	@Step
	public void clearFiltersLink() {
		bmiDatabasesGeneralPage().clickOnClearFilters();
	}
	
	@Step
	public void selectDatabaseFromDropdownList(String databaseName){
		bmiDatabasesGeneralPage().selectDatabaseFromDropdownList(databaseName);
	}
	@Step
	public void selectJourneyFromFilter (String option) {
		bmiDatabasesGeneralPage().selectJourneyFromFilter(option);
	}
	
	@Step
	public void journeyFilterDialogWindow() {
		bmiDatabasesGeneralPage().journeyFilterDialogWindow();
	}
	
	@Step
	public void confirmationJourneyInDialogWindow(String confirmation){
		bmiDatabasesGeneralPage().cancelOkJourneyFromFilter(confirmation);
	}
	
	@Step
	public void checkOneRegion(String continent){
		bmiDatabasesGeneralPage().checkOneRegion(continent);
	}
	
	@Step
	public void verifyIfOneRegionIsNotChecked(String continent){
		bmiDatabasesGeneralPage().verifyIfOneRegionIsNotChecked(continent);
	}
	
	@Step
	public void checkAllElementsFromGeographySectionAndVerify(){
		bmiDatabasesGeneralPage().checkAllElementsFromGeographySectionAndVerify();
	}
	
	@Step
	public void checkYearFromDateRangesSection(String year){
		bmiDatabasesGeneralPage().checkYearFromDateRangesSection(year);
	}
	
	@Step
	public void uncheckYearFromDateRangesSection(String year){
		bmiDatabasesGeneralPage().uncheckYearFromDateRangesSection(year);
	}
	
	@Step
	public void clickOnDateRangesToggler(){
		bmiDatabasesGeneralPage().clickOnDateRangesToggler();
	}
	
	@Step
	public void clickOnDisplayDataButton(){
		bmiDatabasesGeneralPage().clickOnDisplayDataButton();
	}
	
	@Step
	public void testNotAvailableForDatabaseName(String databaseName){
		bmiDatabasesGeneralPage().testNotAvailableForDatabaseName(databaseName);
	}
 
	@Step
	public void clickFilterGeographySection(){
		bmiDatabasesGeneralPage().clickFilterGeographySection();
	}
	
	@Step
	public void verifyCompanyContactsBreadcrumb(String breadcrumb) {
		bmiDatabasesGeneralPage().verifyBreadCrumbsForCompanyContacts(breadcrumb);		
	}

	
	@Step
	public void selectOneGeograpyFromFilter(String geography){
		bmiDatabasesGeneralPage().selectOneGeograpyFromFilter(geography);
	}
	
	@Step
	public void clickFilterOperatorsSection(){
		bmiDatabasesGeneralPage().clickFilterOperatorsSection();
	}
	
	@Step
	public void searchFilterOperatorsSection(String operator){
		bmiDatabasesGeneralPage().searchFilterOperatorsSection(operator);
	}

	@Step
	public void selectOneOperatorFromFilter(String operator){
		bmiDatabasesGeneralPage().selectOneOperatorFromFilter(operator);
	}
	
	@Step
	public void clickFilterIndicatorSection(){
		bmiDatabasesGeneralPage().clickFilterIndicatorSection();
	}
	
	@Step
	public void searchFilterIndicatorSection(String operator){
		bmiDatabasesGeneralPage().searchFilterIndicatorSection(operator);
	}
	
	@Step
	public void selectOneIndicatorFromFilter(String operator){
		bmiDatabasesGeneralPage().selectOneIndicatorFromFilter(operator);
	}
	
	@Step
	public void clickFilterAgeSection(){
		bmiDatabasesGeneralPage().clickFilterAgeSection();
	}
	
	@Step
	public void searchFilterAgeSection(String age){
		bmiDatabasesGeneralPage().searchFilterAgeSection(age);
	}
	
	@Step
	public void selectOneAgeFromFilter(String age){
		bmiDatabasesGeneralPage().selectOneAgeFromFilter(age);
	}
	
	@Step
	public void clickFilterGenderSection(){
		bmiDatabasesGeneralPage().clickFilterGenderSection();
	}
	
	@Step
	public void searchFilterGenderSection(String gender){
		bmiDatabasesGeneralPage().searchFilterGenderSection(gender);
	}
	
	@Step
	public void selectOneGenderFromFilter(String gender){
		bmiDatabasesGeneralPage().selectOneGenderFromFilter(gender);
	}
	
	@Step
	public void expandSectorFromFilter() {
		bmiDatabasesGeneralPage().expandSectorFromFilter();		
	}
	
	@Step
	public void selectProjectNameUserJourney(){
		bmiDatabasesKeyProjectsPage().selectProjectNameRadioButton();
	}
	
	@Step
	public void typeProjectName(String projectName){
		bmiDatabasesKeyProjectsPage().typeProjectName(projectName);
	}
	
	@Step
	public boolean verifyRefreshButtonDoesNotExist(){
		return bmiDatabasesGeneralPage().verifyRefreshButtonDoesNotExist();
	}
	
	@Step
	public void clickRefreshButton(){
		 bmiDatabasesGeneralPage().clickRefreshButton();
	}
	
	@Step
	public String verifyNewValueAfterRefresh( double newDoublValue, String newValue){
		return bmiDatabasesGeneralPage().verifyNewValueAfterRefresh( newDoublValue,newValue);
	}

	@Step
	public void verifyRefreshWarning(){
		bmiDatabasesGeneralPage().verifyRefreshWarning();
	}
	
	@Step
	public void clickOnOneSavedDvPack(String dvPackName){
		bmiDatabasesGeneralPage().clickOnOneSavedDvPack(dvPackName);
	}
	
	@Step
	public void clickOnTheArrowBesideSaveButton(){
		bmiDatabasesGeneralPage().clickOnTheArrowBesideSaveButton();
	}
	
	@Step
	public void verifyIfOneRegionIsChecked(String continent){
		bmiDatabasesGeneralPage().verifyIfOneRegionIsChecked(continent);
	}
	
	@Step
	public int filterSizeBeforeExpander(){
		return bmiDatabasesGeneralPage().filterSizeBeforeExpander();
	}
	
	@Step
	public void waitFiltersExpander(int size){
		bmiDatabasesGeneralPage().waitFiltersExpander(size);
	}
	
	@Step
	public void verifyMessagesForDisplayingLargeAmountOfData(){
		bmiDatabasesGeneralPage().verifyMessagesForDisplayingLargeAmountOfData();
	}

	@Step
	public void cancelSavePopUp(String cancel) {
		bmiDatabasesGeneralPage().cancelSavePopUp(cancel);
	}
	
	@Step
	public void clickOnBMIDatabaseAccordingToService(String service, int databaseNumber){
		bmiDatabasesGeneralPage().clickOnBMIDatabaseAccordingToService(service, databaseNumber);
	}
	
	@Step
	public void verifyUnentitledDatabases(String entitledService){
		bmiDatabasesGeneralPage().verifyUnentitledDatabases(entitledService);
	}
	
	@Step
	public void verifyEntitledDatabasesFromDropDownAccordingToService(String entitledService){
		bmiDatabasesGeneralPage().verifyEntitledDatabasesFromDropDownAccordingToService(entitledService); 
	}
	
	@Step
	public void verifyEntitledDatabasesAccordingToService(String entitledService){
		bmiDatabasesGeneralPage().verifyEntitledDatabasesAccordingToService(entitledService);
	}
	
	@Step
	public void verifyGeographyIsDeselected(String country, String continent){
		bmiDatabasesGeneralPage().verifyGeographyIsDeselected(country,continent);
	}
} 
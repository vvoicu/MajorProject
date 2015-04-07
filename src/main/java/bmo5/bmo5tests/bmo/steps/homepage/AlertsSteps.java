package bmo5.bmo5tests.bmo.steps.homepage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class AlertsSteps extends AbstractSteps {

	
	private static final long serialVersionUID = -2695209732024209197L;

	@StepGroup
	public void createNewReportAlert(String textPdfArea, String element) {
		addAlert();
		typeReportAlertName(textPdfArea);		
		selectGeographiesReport(element);
	}

	@StepGroup
	public void saveChangesOnCustomAlertAfterStopIt (String save) {
		selectACustomAlertFromList();
		selectStopCustomAlert(save);
		saveAlert(save);
	}

	@StepGroup
	public void clickOnAlert(String testName,int radioButtonIntra, int radButtonDaily, int radButtonWeekly) {
		selectACustomAlertFromList();
		clearEditCustomAlert();
		typeEditCustomName(testName);
		selectCustomFrequency(radioButtonIntra, radButtonDaily, radButtonWeekly);
	}

	@StepGroup
	public void tickUntickAllCustomCheckboxes(){
		checkAllCheckboxes();
		uncheckAllCheckBoxes();

	}

	@StepGroup
	public void operateOnReportAlert() {
		checkAllCheckboxes();
		uncheckAllCheckBoxes();
		tickAReportAlert();
		clickDelete();
		clickPopUpDelete();
	}

	@StepGroup
	public void selectCompany(String textCompanies, String companySearch) {
		selectCompanyOptionsAlerts(textCompanies);
		typeFirstThreeLettersCompany(companySearch);
	}

	@Step
	public void verifyBreadCrumbs(String text) {
		homePageHeaderPage().verifyBreadCrumbs(text);

	}

	@Step
	public void addAlert() {
		alertsPage().addANewAlert();
	}

	@Step
	public void uncheckAllCheckBoxes() {
		alertsPage().clickCheckBoxesALLUnCheck();
	}

	@Step
	public void checkAllCheckboxes() {
		alertsPage().clickCheckBoxesALLCheck();
	}

	@Step
	public void clearReportAlert(String alertNameArea) {
		alertsPage().clearReportTextArea(alertNameArea);
	}

	@Step
	public void selectButtondReportAlertCancel() {
		alertsPage().selectCancel();
	}

	@Step
	public void typeReportAlertName (String textPdfArea) {
		alertsPage().typeNameReportContainer(textPdfArea);
	}

	@Step
	public void typeAValidReportName(String textArea) {
		alertsPage().typeValidReportName(textArea);
	}

	@Step
	public void selectGeographiesReport(String element){
		alertsPage().selectGeographiesdReportAlert(element);

	}
	
	@Step
	public void selectSeriesReport(String series){
		alertsPage().selectSeriesReportAlert(series);

	}
	
	@Step
	public void serchForReportGeography(String geographySearch){
		alertsPage().typeReportAlertGeographies(geographySearch);

	}

	@Step
	public void selectAddAlertReportFrequency( int radButtonDaily, int radButtonWeekly){
		alertsPage().selectRadioButtonsNewReportAlert(radButtonDaily, radButtonWeekly);
	}

	@Step
	public void selectEditAlertReportFrequency(){
		alertsPage().selectRadioButtonsReportAlert();
	}

	@Step
	public void clickOnClearReport(String clear){
		alertsPage().clearReportButton(clear);
	}

	@Step
	public void selectSerieReportList(String element) {
		alertsPage().selectSeriesFromReportList( element);
	}
	@Step
	public void chooseSaveCancelAlert(String element) {
		alertsPage().cancelAlert(element);
	}
	
	@Step
	public void clickOnReportAlert() {
		alertsPage().selectAreportAlert();
	}

	@Step
	public void tickAReportAlert() {
		alertsPage().checkOneReportAlert();

	}

	@Step
	public void clearSeriesReport(String clearSeries) {
		alertsPage().clearReportSeriesButton(clearSeries);
	}

	@Step
	public void selectAlertBy(String value, String alpha) {
		alertsPage().alertSortBy(value,alpha);
	}

	@Step
	public void sortReportAlert(String alpha) {
		alertsPage().reportAlertSortBy(alpha);
	}

	@Step
	public void selectReportAlertsFromLeftPanel (String report) {
		alertsPage().clickOnReportAlert(report);
	}

	@Step
	public void clickAvailableReportAlert(String edit) {
		alertsPage().clickReportAlert(edit);
	}

	@Step
	public void clickDelete() {
		alertsPage().clickDelete();
	}

	@Step
	public void clickPopUpDelete() {
		alertsPage(). clickDeletePopUp();
	}

	@Step
	public void removeAlertMessage(String deleteMessage) {
		alertsPage().deleteAlertconfirmationMessage(deleteMessage);
	}
	
	@Step
	public void removeReportAlertMessage(String reportDeleted) {
		alertsPage().deleteReportAlertconfirmationMessage(reportDeleted);
	}

	@Step
	public void typeAlertName() {
		alertsPage().typeAlertNameField();
	}

	@Step
	public void typeTheFirstLettersForAGeography(String regionSearch) {
		alertsPage().typeFirstThreeLettersGeography(regionSearch);
	}

	@Step
	public void selectGeoForNewAlert (String textName)  {
		alertsPage().selectGeographiesForNewAlert(textName);
	}

	@Step
	public void selectCustomFrequency (int radioButtonIntra, int radButtonDaily,int radButtonWeekly)  {
		alertsPage().selectRadioButtonsAlert(radioButtonIntra, radButtonDaily, radButtonWeekly);
	}

	@Step
	public void selectFirstFrequencyForAddAlert () {
		alertsPage().checkFirstFrequency();
	}

	@Step
	public void selectGeographiesOptionsAlert(String textName) {
		alertsPage().selectGeographiesOptionsAlert(textName);
	}

	@Step
	public void clickOnServiceIndustries(String textService) {
		alertsPage().selectServiceOptionsAlerts(textService);
	}

	@Step
	public void clickOnServiceEditCustomAlertOption(String textService) {
		alertsPage().selectServiceOptionsEditAlerts(textService);
	}

	@Step
	public void selectAServiceIndustries(String searchForService,String element) {
		alertsPage().selectAService(searchForService,element);
	}

	@Step
	public void selectAGeography(String element) {
		alertsPage().selectGeographyFromList(element);
	}

	@Step
	public void selectCompanyOptionsAlerts(String textCompanies) {
		alertsPage().selectCompanyOptionsAlerts(textCompanies);
	}

	@Step
	public void typeFirstThreeLettersCompany(String companySearch) {
		alertsPage().typeFirstThreeLettersCompany(companySearch);	
	}

	@Step
	public void selectCompanyForEditCustomAlert(String textCompanies,String companySearch) {
		alertsPage().selectCompanyOptionsEditAlerts(textCompanies);
		//alertsPage().typeFirstThreeLettersCompany(companySearch);
	}
	
	@Step
	public void selectAndMoveACompany(String element) {
		alertsPage().selectACompany( element);	
	}
	
	@Step
	public void moveCompanyForNewAlerts(String element) {
		alertsPage().selectACompanyForNewAlerts(element);
	}
	
	@Step
	public void selectCompanyList(String element) {
		alertsPage().selectGeographyFromList(element);
	}
	
	@Step
	public void selectPlusButton(String searchForService,String element) {
		alertsPage().selectAService(searchForService,element);
	}

	@Step
	public void searchSeries(String searchSerie) {
		alertsPage().typeSeriesReportText(searchSerie);
	}

	@Step
	public void selectACustomAlertFromList() {
		alertsPage().clickOnAvailableAlert();
	}
	
	@Step 
	public void clearEditCustomAlert () {
		alertsPage().clearAlertTitle();
	}

	@Step
	public void typeEditCustomName(String testName) {
		alertsPage().typeAlertTextField(testName);
	}

	@Step
	public void saveAlert (String save) {
		alertsPage().saveAlert(save);
	}

	@Step
	public void selectStopCustomAlert(String save) {
		alertsPage().stopCustomAlert();
	}

	@Step
	public void selectRegionFromList(String element) {
		alertsPage().selectGeographyFromList(element);
	}

	@Step
	public void clickReportAlertFromList(String report) {
		alertsPage().clickOnReportAlert(report);
	}

	@Step
	public void editAReportAlert (String edit) {
		alertsPage().clickReportAlert(edit);
	}

	@Step
	public void stopReportAlert(String stopAlert) {
		alertsPage().clickOnStopReport(stopAlert);
	}

	@Step
	public void stopAlertTypeCustom() {
		alertsPage().stopCustomAlert();
	}

	@Step
	public void selectMacroAlert(String macroAlerts) {
		alertsPage().clickMacroAlert(macroAlerts);
	}

	@Step
	public void checkMacroAlertOption(String value) {
		alertsPage().containerMacro(value);
	}

	@Step
	public void clickCancelAlertButton(String value,String cancel) {
		alertsPage().clickCancel(value,cancel);		
	}

	@Step
	public void selectSectorAlertOption(String value) {
		alertsPage().containerSectorAlerts(value);
	}

	@Step
	public void clickOnSectorALerts(String sectorAlerts) {
		alertsPage().clickSectorAlert(sectorAlerts);

	}

	@Step
	public void verifySectorAlertsConfirmationMessage(String value) {
		alertsPage().verifySectorAlertsConfirmationMessage(value);
	}

	@Step
	public void clickSaveAlerts(String save) {
		alertsPage().clickOnSaveReportAlert(save); 

	}

	@Step
	public void selectBFSAlert(String financialAlert) {
		alertsPage().clickBFSAlert(financialAlert);		
	}

	@Step
	public void selectAGeographyFromCreatedCustomAlertsList(String geography) {
		alertsPage().selectAGeographyFromCreatedCustomAlerts(geography);		
	}

	@Step
	public void tickCustomAlertCheckbox() {
		alertsPage().tickCustomAlertCheckbox();	
	}

	@Step
	public void successAlertMessage() {
		alertsPage().successAlertMessage();		
	}

	@Step
	public void verifyCustumAlertsAreEmptyForSecondChildEnterpriseUser(){
		alertsPage().verifyCustumAlertsAreEmptyForSecondChildEnterpriseUser();
	}

	@Step
	public void selectGeographiesForReportAlerts (String element) {
		alertsPage().selectGeographyFromReportList(element);
	}

	@Step
	public void verifyReportAlertsAreEmptyForSecondChildEnterpriseUser(){
		alertsPage().verifyReportAlertsAreEmptyForSecondChildEnterpriseUser();
	}

	@Step
	public void deleteAllCustomAlerts(){
		alertsPage().deleteAllCustomAlerts();
	}

	@Step
	public void deleteAllReportAlerts(){
		alertsPage().deleteAllReportAlerts();
	}

	@Step
	public void verifyDailyMacroConfirmationMessage(String value) {
		alertsPage().verifyDailyMacroConfirmationMessage(value);

	}

	@Step
	public void verifyFinancialMarketsAlerts (String value) {
		alertsPage().containerFinancialMarketsAlerts(value);
	}

	@Step
	public void verifyFinancialMarketsConfirmationMessage(String value, String valueFMA) {
		alertsPage().verifyFinancialMarketsAlertsConfirmationMessage(value,valueFMA);

	}

	@Step
	public void verifyReportNewAlertMessage(String saveReportMessage) {
		alertsPage().verifySaveReportAlertMessage(saveReportMessage);

	}
	
	@Step
	public void verifyEditAlertSaveMessage(String editReportMessage) {
		alertsPage().verifySaveEditReportAlertMessage(editReportMessage);
	}

	@Step
	public void selectGeographiesForEditCustomAlert(String optionAlert) {
		alertsPage().selectGeographiesForEditCustomAlert(optionAlert);
		
	}

	@Step
	public void verifyPoliticsInDailyMacroAlerts(String politic) {
		alertsPage().verifyPoliticsInDailyMacroAlerts(politic);
		
	}

	@Step
	public void verifyErrorMessageOnSavingWithoutTitle(String error) {
		alertsPage().saveCustomReportAlertverifyErrorMessage(error);
		
	}
}
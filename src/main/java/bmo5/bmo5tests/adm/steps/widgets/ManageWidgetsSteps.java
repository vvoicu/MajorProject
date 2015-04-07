package bmo5.bmo5tests.adm.steps.widgets;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class ManageWidgetsSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = 1064380961629901497L;

	@StepGroup
	public void selectWidgetPageOptions(String widgetype, String area, String page, String hotTopicsPageNumber, String pivot, String npc, String cleanup, String name){
		selectTypeFroWidget(widgetype);  
		selectWidgetName(name);
	    addPageOptionToWidget(page,hotTopicsPageNumber);
		selectAreaWidget(area);
		pivotForWidget(pivot);
		selectNPCWidget(npc);
		clickOnWidgetCleanup(cleanup);
	}
	
	@StepGroup
	public void checkOptionsSelected(String npc, String cleanup, String area){
		checkNPCSelected(npc);
		checkCleanupSelected(cleanup);
		checkAreaSelected(area);
	}
	
	@Step
	public void createNewWidget(){
		manageWidgetsPage().clickOnNewButton();
	}

	@Step
	public void selectRecordsPerPageAndVerify(String records){
		manageWidgetsPage().selectRecordsPerPageAndVerify(records);
	}

	@Step
	public void searchInputAndVerify(String search){
		manageWidgetsPage().searchInputAndVerify(search);
	}
	
	@Step
	public void selectNameForEveryColumn() {
		manageWidgetsPage().selectMainColumnName();		
	}
	
	@Step
	public void clickHelpButton() {
		manageWidgetsPage().clickOnHelpButton();
	}
	
	@Step
	public void clickPopUpClose() {
		manageWidgetsPage().closeXClickOnItFromHelp();		
	}
	
	@Step
	public void deletePopUpWindow() {
		manageWidgetsPage().cancelDeleteWidget();		
	}
	
	@Step
	public void selectOkPopUpDelete() {
		manageWidgetsPage().deleteOkPopUpWindow ();		
	}
	
	@Step
	public void addWidgetOption() {
		manageWidgetsPage().addANewWidget();
		
	}
	@Step
	public String addPageOptionToWidget(String pageName, String hotTopicsPageNumber) {
		return manageWidgetsPage().addNewWidgetOptions(pageName, hotTopicsPageNumber);
	}
	
	@Step
	public void selectAreaWidget(String area) {
		manageWidgetsPage().chooseAreaWidget(area);
		}
	@Step
	public void pivotForWidget(String pivot) {
		manageWidgetsPage().selectPivotPoint(pivot);
	}
	
	@Step
	public void selectSlot(String slot){
		manageWidgetsPage().selectSlot(slot);
	}
	
	@Step
	public void selectTypeFroWidget(String widgetype) {
		manageWidgetsPage().selectWidgetType(widgetype);
	}
	
	@Step
	public void selectNPCWidget(String npc) {
		manageWidgetsPage().chooseNPCSensitiveOption(npc);
	}
	
	@Step
	public void clickOnWidgetCleanup(String cleanup){
	    manageWidgetsPage().clickOnWidgetCleanup(cleanup);
	}
	
	@Step
	public void addNewWidgetButtonFromForm () {
		manageWidgetsPage().addInsideWidgetFormButton();
	}
	@Step
	public String selectWidgetName(String name ) {
		return manageWidgetsPage().selectWidgetName(name);
	}
	@Step
	public void resetFormWidget () {
		manageWidgetsPage().clickOnResetButton();
	}
	@Step
	public void saveFromEditWidget() {
		manageWidgetsPage().clickOnSaveButton();
	}
	@Step
	public void chooseEditWidget() {
		manageWidgetsPage().clickOnEditButton();
	}
	@Step
	public void confirmationMessageWidget() {
		manageWidgetsPage().confirmSuccesfullySavedWidget();
	}
	
	@Step
	public void listViewWidget() {
		manageWidgetsPage().clickOnViewAllButton();
	}
	
	@Step
	public void addNewWidget() {
		manageWidgetsPage().addANewWidget();
	}
	
	@Step
	public void chooseHelpButton() {
		manageWidgetsPage().clickHelpButton();
	}
	
	@Step
	public void selectPivotName(String pivotPoint,String pivotName){
		manageWidgetsPage().selectPivotName(pivotPoint,pivotName);
	}
	
	@Step
	public void deleteFirstRow(){
		manageWidgetsPage().deleteFirstRow();
	}
	
	@Step
	public void clickAddButtonWithoutSelectingAnythingAndVerify(){
		manageWidgetsPage().clickAddButtonWithoutSelectingAnythingAndVerify();
	}
	
	@Step
	public boolean verifyIfWidgetPageRelationDoesNotExist(){
		return manageWidgetsPage().verifyIfWidgetPageRelationDoesNotExist();
	}
	
	@Step
	public void clickListViewButton(){
		manageWidgetsPage().clickListViewButton();
	}
	
	@Step
	public String changeSelectedOptionsRadiobuttons(String option){
	return	manageWidgetsPage().changeSelectedOptionsRadiobuttons(option);
	}
	
	@Step
	public void clickUpdateWidgetPageButton(){
		manageWidgetsPage().clickUpdateWidgetPageButton();
	}
	
	@Step
	public void checkNPCSelected(String npc){
		 manageWidgetsPage().checkNPCSelected(npc);
	}
	
	@Step
	public void checkCleanupSelected(String cleanup){
		 manageWidgetsPage().checkCleanupSelected(cleanup);
	}
	
	@Step
	public void checkAreaSelected(String area){
		 manageWidgetsPage().checkCleanupSelected(area);
	}
	
	@Step
	public void navigatePagesAndVerify(){
		manageWidgetsPage().navigatePagesAndVerify();
	}
	
	@Step
	public void searchWidgetByName(String widgetName){
		manageWidgetsPage().searchWidgetByName(widgetName);
	}
	
	@Step
	public boolean checkAlertIsErrorMessage(){
		return manageWidgetsPage().checkAlertIsErrorMessage();
	}
}

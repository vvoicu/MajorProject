package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class DataToolSteps extends AbstractSteps {

	private static final long serialVersionUID = -7113649556465331050L;


	@StepGroup
	public void filterExpandSearchSelectGeography(String geography) {
		expandFilterGeographySection();
		searchFilterGeographySection(geography);
		selectOneGeograpyFromFilter(geography);
	}

	@StepGroup
	public void filterExpandSearchSelectGeographyVerify(String geography){
		searchFilterGeographySection(geography);
		verifyIfGeographyIsChecked(geography);
	}

	@StepGroup
	public void filterExpandSearchSelectIndicator(String indicator) {
		expandFilterIndicatorSection();
		searchFilterIndicatorSection(indicator);
		selectOneIndicatorFromFilter(indicator);
	}

	//	@StepGroup
	//	public void filterSelectGeographyAndIndicator(String geography,String indicator) {
	//		
	//		expandFilterGeographySection();
	//		selectOneGeograpyFromFilter(geography);
	//		expandFilterIndicatorSection();
	//		selectOneIndicatorFromFilter(indicator);
	//	}

	@StepGroup
	public void filterExpandSelectDateRanges(String dateRanges) {
		expandFilterDateRangesSection();
		selectOneDateRangesFromFilter(dateRanges);
		verifyIfDateRangeIsChecked(dateRanges);
	}

	@StepGroup
	public void verifyChart() {
		verifySelectButtonIsPresent();
		verifySaveButtonIsPresent();
		verifyCharPrintButtonIsPresent();
		verifyChartExportButtonIsPresent();
		verifyChartAnnotateButtonIsPresent();
		verifyChartFormatButtonIsPresent();
		verifyChartIsPresent();
	}

	@StepGroup
	public void verifyTable() {

		verifySelectButtonIsPresent();
		verifySaveButtonIsPresent();
		verifyTableIsPresent();
	}

	@StepGroup
	public void addAndVerifyNewChartTextAnnotation(String annotationType, String textSize, String rotation, String description){

		clickAnnotationButton();
		clickNewAnnotationButton();
		newChartTextAnotation(annotationType,textSize,rotation,description);
		clickBackToAnotationList();
		clickNewAnnotationButton();
		newChartTextAnotation(annotationType,textSize,rotation,description);
		clickOnAddToChart();
		verifyEditTextAnnotationWindow(textSize,rotation,description);
	}

	@StepGroup
	public void addAndVerifyNewChartLineAnnotation(String annotationType, String lineType){

		clickAnnotationButton();
		clickNewAnnotationButton();
		newChartLineAnotation(annotationType,lineType);
		clickBackToAnotationList();
		clickNewAnnotationButton();
		newChartLineAnotation(annotationType,lineType);
		clickOnAddToChart();
		//		clickAnnotationButton();
		verifyNewLineAnnotation(lineType);
	}

	@StepGroup
	public void editAndVerifyChartTextAnnotation(String annotationType, String textSize, String rotation, String description, String newTextSize, String newRotation, String newDescription){

		clickAnnotationButton();
		clickNewAnnotationButton();
		newChartTextAnotation(annotationType,textSize,rotation,description);
		clickOnAddToChart();

		verifyEditTextAnnotationWindow(textSize,rotation,description);
		changeEditTextAnnotationWindow(newTextSize,newRotation,newDescription);
		clickEditTextAnotationWindowCancelButton();

		verifyEditTextAnnotationWindow(textSize,rotation,description);
		changeEditTextAnnotationWindow(newTextSize,newRotation,newDescription);
		clickEditAnotationWindowSaveButton();
		verifyEditTextAnnotationWindow(newTextSize,newRotation,newDescription);
	}

	@StepGroup
	public void editAndVerifyChartLineAnnotation(String annotationType, String lineType, String newLineType){

		clickAnnotationButton();
		clickNewAnnotationButton();
		newChartLineAnotation(annotationType,lineType);
		clickOnAddToChart();
		//		clickAnnotationButton();
		//		verifyNewLineAnnotation(lineType);

		//		clickEditAnotationFromList();
		verifyNewLineAnnotation(lineType);
		//		verifyEditLineAnnotationWindow(lineType);
		changeEditLineAnnotationWindow(newLineType);
		clickEditLineAnotationWindowCancelButton();

		//		clickAnnotationButton();
		//		clickEditAnotationFromList();
		//		verifyEditLineAnnotationWindow(lineType);
		verifyNewLineAnnotation(lineType);
		changeEditLineAnnotationWindow(newLineType);
		clickEditAnotationWindowSaveButton();
		clickAnnotationButton();
		verifyEditLineAnnotation(newLineType);
		//		verifyNewLineAnnotation(newLineType);
	}

	@StepGroup
	public void deleteAnnotationFromListAndEditWindow(String annotationTypeText, String AnnotationTypeLine, String textSize, String rotation, String description, String lineType){

		clickAnnotationButton();
		clickNewAnnotationButton();
		newChartTextAnotation(annotationTypeText,textSize,rotation,description);
		clickOnAddToChart();

		verifyEditTextAnnotationWindow(textSize,rotation,description);
		clickEditTextAnotationWindowRemoveButton();

		verifyChartAnnotationWasDeleted();

	}

	@StepGroup
	public void deleteLineAnnotationFromListAndEditWindow(String annotationType, String lineType){
		clickAnnotationButton();
		clickNewAnnotationButton();
		newChartLineAnotation(annotationType,lineType);
		clickOnAddToChart();

		verifyNewLineAnnotation(lineType);
		clickEditLineAnotationWindowRemoveButton();

		verifyChartLineAnnotationWasDeleted();
	}

	@StepGroup
	public void verifyChartFormatWindow(String geography, String indicator){

		verifyFormatWindowDefaultState();
		verifyFormatWindowSeries(geography,indicator);
	}

	@StepGroup
	public void selectFromFilters(String geography, String indicator){

		filterExpandSearchSelectGeography(geography);
		filterExpandSearchSelectIndicator(indicator);
		clickFilterDisplayDataButton();
	}

	@StepGroup
	public void verifyChartFormat(String geography, String indicator, String title, String subtitle, String formatDescription, String chartType,String indicatorSeries, String seriesType){

		clickChartFormatButton();
		verifyFormatWindowDefaultState();
		verifyFormatWindowSeries(geography,indicatorSeries);
		removeChartLegend();
		clickChartFormatButton();
		insertChartLegend();
		clickChartFormatButton();
		addChartTitleSubtitleDescriptionType(title,subtitle,formatDescription,chartType);
		clickChartFormatUpdateChartButton();
		verifyChartTitleSubtitle(title,subtitle);
		clickChartFormatButton();
		verifyChartTitleSubtitleDescriptionType(title,subtitle,formatDescription,chartType,seriesType);
	}

	@StepGroup
	public void addNewTableRandomCellAnnotation(String annotationType, String description){

		//		clickTableAnnotateButton();
		//		clickTableAnnotateNewButton();
		//		tableNewAnnotateBackToList();
		//		clickTableAnnotateNewButton();
		//		addVerifyTableRandomCellAnnotation(annotationType,description);
	}

	@StepGroup
	public void tableAddAndVerifyNewCellAnnotationList(String annotationType, String description, String row, String column){

		tableAddNewCellAnnotation(annotationType,description,row, column);
		tableVerifyNewCellAnnotation(description,row, column);
	}

	@StepGroup
	public void tableAddAndVerifyEditedCellAnnotationList(String description, String newDescription, String row, String column){

		tableEditCellAnnotationList(newDescription,row,column);
		tableVerifyEditCellAnnotation(newDescription,row,column);
	}

	@StepGroup
	public void addVerifyNewTableRowAnnotation(String annotationType, String description, String row, String column){

		tableAddNewRowAnnotation(annotationType,description,row,column);
		//		clickOnNewTableAnnotationListSaveButton();
		tableVerifyNewRowAnnotation(description,row);
		//		clickTableAnnotateButton();
		//		tableVerifyEditRowAnnotationList(description);
	}

	@StepGroup
	public void tableAddAndVerifyEditedRowAnnotationList(String description, String newDescription, String row, String column){

		tableEditRowAnnotationList(newDescription,row,column);
		tableVerifyEditRowAnnotation(newDescription,row);
	}

	@StepGroup
	public void tableDeleteCellAndRowAnnotation(String annotationTypeCell,String annotationTypeRow,String description,String row,String column){

		tableAddNewCellAnnotation(annotationTypeCell,description,row,column);
		clickOnTableCellAnnotationDeleteButton(row,column);
		verifyTableCellAnnotationWasDeleted(description);

		tableAddNewRowAnnotation(annotationTypeRow,description,row,column);		
		clickOnTableRowAnnotationDeleteButton(row);
		verifyTableRowAnnotationWasDeleted(description);
	}

	@StepGroup
	public void verifyFrequencyFilter(String frequency){
		clickOnFrequencyFilter();
		selectOneFrequencyFromFilter(frequency);
		verifyIfFrequencyIsChecked(frequency);
	}

	@StepGroup
	public void filterContainerForDataTool(String indicator, String Selectedindicator) {
		dataToolPage().clickFilterIndicatorSection();
		dataToolPage().searchFilterIndicatorSection(indicator);
		dataToolPage().selectOneIndicatorFromFilter(Selectedindicator);
	}
	
	@StepGroup
	public void filterContainerForDataToolVerify(String indicator, String Selectedindicator){
		dataToolPage().clickFilterIndicatorSection();
		dataToolPage().searchFilterIndicatorSection(indicator);
		verifyIfIndicatorIsChecked(returnTheIndicatorId(Selectedindicator));
	}
	
	@Step
	public void verifyButtonsAndFiltersSectionsAreDisabled(String breadcrumb,String databaseName){
        verifyExportButtonIsDisabled();
		verifyRawDataButtonIsDisabled();
		verifySaveButtonIsDisabled();
		verifyDisplayDataButton();
		verifyFilterSectionsAreDisabled(breadcrumb,databaseName);
		verifyLayoutButtonIsDisabled();
	}
	
	@Step
	public void expandFilterGeographySection() {
		dataToolPage().clickFilterGeographySection();
	}

	@Step
	public void searchFilterGeographySection(String geography) {
		dataToolPage().searchFilterGeographySection(geography);
	}

	@Step
	public void selectOneGeograpyFromFilter(String geography) {
		dataToolPage().selectOneGeograpyFromFilter(geography);
	}

	@Step
	public void expandFilterIndicatorSection() {
		dataToolPage().clickFilterIndicatorSection();
	}

	@Step
	public void searchFilterIndicatorSection(String indicator) {
		dataToolPage().searchFilterIndicatorSection(indicator);
	}

	@Step
	public void selectOneIndicatorFromFilter(String Selectedindicator) {
		dataToolPage().selectOneIndicatorFromFilter(Selectedindicator);
	}
	@Step
	public void selectIndicatorFromFilter(String Selectedindicator) {
		dataToolPage().selectOneIndicatorFromFilter(Selectedindicator);
	}

	@Step
	public void expandFilterDateRangesSection() {
		dataToolPage().clickFilterDateRangesSection();
	}

	@Step
	public void selectOneDateRangesFromFilter(String indicator) {
		dataToolPage().selectOneDateRangesFromFilter(indicator);
	}

	@Step
	public void clickFilterDownloadButton() {
		dataToolPage().clickFilterDownloadButton();
	}

	@Step
	public void clickFilterDisplayDataButton() {
		dataToolPage().clickFilterDisplayDataButton();
	}

	@Step
	public void verifySelectButtonIsPresent() {
		dataToolPage().selectButtonIsDisplayed();
	}

	@Step
	public void verifySaveButtonIsPresent() {
		dataToolPage().saveButtonIsDisplayed();
	}

	@Step
	public void verifyCharPrintButtonIsPresent() {
		dataToolPage().chartPrintButtonIsDisplayed();
	}

	@Step
	public void verifyChartExportButtonIsPresent() {
		dataToolPage().chartExportButtonIsDisplayed();
	}

	@Step
	public void verifyChartAnnotateButtonIsPresent() {
		dataToolPage().chartAnnotateButtonIsDisplayed();
	}

	@Step
	public void verifyChartFormatButtonIsPresent() {
		dataToolPage().chartFormatButtonIsDisplayed();
	}

	@Step
	public void verifyChartIsPresent() {
		dataToolPage().chartIsDisplayed();
	}

	@Step
	public void verifyTableIsPresent() {
		dataToolPage().tableIsDisplayed();
	}

	@Step
	public void verifySelectWindow() {
		dataToolPage().verifySelectWindow();
	}

	@Step
	public void verifySelectWindowContent(String geography, String indicator) {
		dataToolPage().verifySelectWindowContent(geography, indicator);
	}


	@Step
	public void removeSelectWindowContent() {
		dataToolPage().removeSelectWindowContent();
	}

	@Step
	public void printOSWindow() {
		dataToolPage().printOSWindow();
	}

	@Step
	public void verifyExportWindowDefaultState() {
		dataToolPage().verifyExportWindowDefaultState();
	}

	@Step
	public void verifyExportWidthField() {
		dataToolPage().verifyExportWidthField();
	}

	@Step
	public void verifyExportHeightField() {
		dataToolPage().verifyExportHeightField();
	}

	@Step
	public void verifyExportRadioButtons() {
		dataToolPage().verifyExportRadioButtons();
	}

	@Step
	public void verifyColorJPGExportImage() {
		dataToolPage().verifyColorJPGExportImage();
	}

	@Step
	public void verifyGrayscaleJPGExportImage() {
		dataToolPage().verifyGrayscaleJPGExportImage();
	}

	@Step
	public void verifyColorPNGExportImage() {
		dataToolPage().verifyColorPNGExportImage();
	}

	@Step
	public void verifyGrayscalePNGExportImage() {
		dataToolPage().verifyGrayscalePNGExportImage();
	}

	@Step
	public void clickAnnotationButton() {
		dataToolPage().clickAnnotationButton();
	}

	@Step
	public void clickNewAnnotationButton() {
		dataToolPage().clickNewAnnotationButton();
	}

	@Step
	public void newChartTextAnotation(String annotationType, String textSize, String rotation, String description) {
		dataToolPage().newChartTextAnotation(annotationType,textSize,rotation,description);
	}

	@Step
	public void newChartLineAnotation(String annotationType, String lineType) {
		dataToolPage().newChartLineAnotation(annotationType,lineType);
	}

	@Step
	public void clickBackToAnotationList() {
		dataToolPage().clickBackToAnotationList();
	}

	@Step
	public void clickOnAddToChart() {
		dataToolPage().clickOnAddToChart();
	}


	@Step
	public void verifyNewLineAnnotation(String lineType) {
		dataToolPage().verifyNewLineAnnotation(lineType);
	}

	@Step
	public void clickEditAnotationFromList() {
		dataToolPage().clickEditAnotationFromList();
	}

	@Step
	public void verifyEditTextAnnotationWindow(String textSize, String rotation, String description) {
		dataToolPage().verifyEditTextAnnotationWindow(textSize,rotation,description);
	}

	@Step
	public void verifyEditLineAnnotationWindow(String lineType) {
		dataToolPage().verifyEditLineAnnotationWindow(lineType);
	}

	@Step
	public void changeEditTextAnnotationWindow(String newTextSize, String newRotation, String newDescription) {
		dataToolPage().changeEditTextAnnotationWindow(newTextSize,newRotation,newDescription);
	}


	@Step
	public void changeEditLineAnnotationWindow(String newLineType) {
		dataToolPage().changeEditLineAnnotationWindow(newLineType);
	}

	@Step
	public void verifyEditTextAnnotation(String newTextSize, String newRotation, String newDescription) {
		dataToolPage().verifyEditTextAnnotation(newTextSize,newRotation,newDescription);
	}

	@Step
	public void verifyEditLineAnnotation(String newLineType) {
		dataToolPage().verifyEditLineAnnotation(newLineType);
	}

	@Step
	public void clickEditTextAnotationWindowRemoveButton() {
		dataToolPage().clickEditTextAnotationWindowRemoveButton();
	}

	@Step
	public void clickEditTextAnotationWindowCancelButton() {
		dataToolPage().clickEditTextAnotationWindowCancelButton();
	}

	@Step
	public void clickEditLineAnotationWindowRemoveButton() {
		dataToolPage().clickEditLineAnotationWindowRemoveButton();
	}

	@Step
	public void clickEditLineAnotationWindowCancelButton() {
		dataToolPage().clickEditLineAnotationWindowCancelButton();
	}

	@Step
	public void clickEditAnotationWindowSaveButton() {
		dataToolPage().clickEditAnotationWindowSaveButton();
	}

	@Step
	public void deleteChartAnnotationFromListWindow() {
		dataToolPage().deleteChartAnnotationFromListWindow();
	}

	@Step
	public void verifyChartAnnotationWasDeleted() {
		dataToolPage().verifyChartAnnotationWasDeleted();
	}

	@Step
	public void verifyChartLineAnnotationWasDeleted(){
		dataToolPage().verifyChartLineAnnotationWasDeleted();
	}

	@Step
	public void newChartLineAnnotationWindow(String annotationType, String lineType) {
		dataToolPage().newChartLineAnnotationWindow(annotationType,lineType);
	}

	@Step
	public void clickChartFormatButton() {
		dataToolPage().clickChartFormatButton();
	}

	@Step
	public void verifyFormatWindowDefaultState() {
		dataToolPage().verifyFormatWindowDefaultState();
	}

	@Step
	public void verifyFormatWindowSeries(String geography, String indicatorSeries) {
		dataToolPage().verifyFormatWindowSeries(geography,indicatorSeries);
	}

	@Step
	public void clickChartFormatUpdateChartButton() {
		dataToolPage().clickChartFormatUpdateChartButton();
	}

	@Step
	public void removeChartLegend() {
		dataToolPage().removeChartLegend();
	}

	@Step
	public void insertChartLegend() {
		dataToolPage().insertChartLegend();
	}

	@Step
	public void addChartTitleSubtitleDescriptionType(String title, String subtitle, String formatDescription, String chartType) {
		dataToolPage().addChartTitleSubtitleDescriptionType(title,subtitle,formatDescription,chartType);
	}

	@Step
	public void verifyChartTitleSubtitle(String title, String subtitle) {
		dataToolPage().verifyChartTitleSubtitle(title,subtitle);
	}

	@Step
	public void verifyChartTitleSubtitleDescriptionType(String title, String subtitle, String formatDescription, String chartType, String seriesType) {
		dataToolPage().verifyChartTitleSubtitleDescriptionType(title,subtitle,formatDescription,chartType,seriesType);
	}

	public void clickOnSaveChart() {
		dataToolPage().clickSaveButton();		
	}

	//	@Step
	//	public void addVerifyTableRandomCellAnnotation(String annotationType, String description) {
	//		dataToolPage().addVerifyTableRandomCellAnnotation(annotationType,description);
	//	}

	@Step
	public void tableAddNewCellAnnotation(String annotationType, String description,String row, String column) {
		dataToolPage().tableAddNewCellAnnotation(annotationType,description,row,column);
	}

	@Step
	public void tableVerifyNewCellAnnotation(String description, String row, String column) {
		dataToolPage().tableVerifyNewCellAnnotation(description,row,column);
	}

	@Step
	public void tableVerifyNewCellAnnotationList(String description) {
		dataToolPage().tableVerifyNewCellAnnotationList(description);
	}

	@Step
	public void clickOnEditTableAnnotationList() {
		dataToolPage().clickOnEditTableAnnotationList();
	}

	@Step
	public void tableEditCellAnnotationList(String newDescription, String row, String column) {
		dataToolPage().tableEditCellAnnotationList(newDescription,row,column);
	}

	@Step
	public void tableVerifyEditCellAnnotation(String newDescription, String row, String column) {
		dataToolPage().tableVerifyEditCellAnnotation(newDescription,row,column);
	}

	//	@Step
	//	public void clickOnEditTableAnnotationListSaveButton() {
	//		dataToolPage().clickOnEditTableAnnotationListSaveButton();
	//	}
	//
	//	@Step
	//	public void clickOnNewTableAnnotationListSaveButton() {
	//		dataToolPage().clickOnNewTableAnnotationListSaveButton();
	//	}

	@Step
	public void clickOnTableCellAnnotationDeleteButton(String row, String column) {
		dataToolPage().clickOnTableCellAnnotationDeleteButton(row,column);
	}

	@Step
	public void clickOnTableRowAnnotationDeleteButton(String row) {
		dataToolPage().clickOnTableRowAnnotationDeleteButton(row);
	}

	@Step
	public void tableAddNewRowAnnotation(String annotationType, String description, String row, String column) {
		dataToolPage().tableAddNewRowAnnotation(annotationType,description,row,column);
	}

	@Step
	public void tableVerifyNewRowAnnotation(String description, String row) {
		dataToolPage().tableVerifyNewRowAnnotation(description,row);
	}

	//	@Step
	//	public void tableVerifyEditRowAnnotationList(String description, String row) {
	//		dataToolPage().tableVerifyEditRowAnnotationList(description,row);
	//	}

	@Step
	public void tableEditRowAnnotationList(String description, String row, String column) {
		dataToolPage().tableEditRowAnnotationList(description,row,column);
	}

	@Step
	public void tableVerifyEditRowAnnotation(String description, String row) {
		dataToolPage().tableVerifyEditRowAnnotation(description,row);
	}

	@Step
	public void verifyTableCellAnnotationWasDeleted(String description) {
		dataToolPage().verifyTableCellAnnotationWasDeleted(description);
	}

	@Step
	public void verifyTableRowAnnotationWasDeleted(String description) {
		dataToolPage().verifyTableRowAnnotationWasDeleted(description);
	}

	@Step
	public void verifyDownloadQueueMessage() {
		dataToolPage().verifyDownloadQueueMessage();
	}

	@Step
	public void saveDataChart() {
		dataToolPage().clickSaveButton();

	}

	@Step
	public void clearFiltersInDataTool(String text) {
		dataToolPage().clearFiltersInDataTool(text);		
	}

	@Step
	public void goFullScreen() {
		dataToolPage().goFullScreen();		
	}

	@Step
	public void clickFilterDownloadButtonTrialUser(String extension) {
		dataToolPage().clickFilterDownloadButtonTrialUser(extension);
	}

	@Step
	public void clickFilterDownloadButtonTrialUserBMIAndRatings(){
		dataToolPage().clickFilterDownloadButtonTrialUserBMIAndRatings();
	}

	@Step
	public void clickOnPrintChartTrialUser(){
		dataToolPage().clickOnPrintChartTrialUser();
	}

	@Step
	public void clickSaveButtonEnterpriseUser() {
		dataToolPage().clickSaveButtonEnterpriseUser();
	}

	@Step
	public void verifyExportTrialUser() {
		dataToolPage().verifyExportTrialUser();
	}

	@Step
	public void verifyExportChart(String format, String extension){
		dataToolPage().verifyExportChart(format, extension);
	}

	@Step
	public void verifyExportTable(String extension){
		dataToolPage().verifyExportTable(extension);
	}

	public void verifyExportChartAndTable(String extension){
		dataToolPage().verifyExportChartAndTable(extension);
	}

	@Step
	public void clickOnChartRadioButton(){
		dataToolPage().clickOnChartRadioButton();
	}

	@Step
	public void clickOnTableRadioButton(){
		dataToolPage().clickOnTableRadioButton();
	}

	@Step
	public void clickOnTableAndChartRadioButton(){
		dataToolPage().clickOnTableAndChartRadioButton();
	}

	@Step
	public void clickOnExportButton(){
		dataToolPage().clickOnExportButton();
	}
	
	@Step
	public void getCellValueFromTableAndVerify(String cellValue, int row, int column){
		dataToolPage().getCellValueFromTableAndVerify(cellValue, row, column);
	}
	
	@Step
	public void getCellValueReplaceCommaAndVerify(String secondValue, int row, int column){
		dataToolPage().getCellValueReplaceCommaAndVerify( secondValue,  row,  column);
	}

	@Step
	public void verifyIfActionIconsAreEnabled(){
		dataToolPage().verifyIfActionIconsAreEnabled();
	}

	@Step
	public int filterSizeBeforeExpander(){
		return dataToolPage().filterSizeBeforeExpander();
	}
	
	@Step
	public void waitFiltersExpander(int size){
		dataToolPage().waitFiltersExpander(size);
	}

	@Step
	public void verifyIfDateRangeIsChecked(String dateRanges){
		dataToolPage().verifyIfDateRangeIsChecked(dateRanges);
	}

	@Step
	public void clickOnFrequencyFilter(){
		dataToolPage().clickOnFrequencyFilter();
	}

	@Step
	public void selectOneFrequencyFromFilter(String frequency){
		dataToolPage().selectOneFrequencyFromFilter(frequency);
	}

	@Step
	public void verifyIfFrequencyIsChecked(String frequency){
		dataToolPage().verifyIfFrequencyIsChecked(frequency);
	}

	@Step
	public void verifyIfGeographyIsChecked(String geography){
		dataToolPage().verifyIfGeographyIsChecked(geography);
	}
	
	@Step
	public void verifyIfIndicatorIsChecked(String indicator){
		dataToolPage().verifyIfIndicatorIsChecked(indicator);
	}
	
	@Step
	public String returnTheIndicatorId(String indicator){
		return dataToolPage().returnTheIndicatorId(indicator);
	}
	
	@Step
	public void clickFilterIndicatorSection() {
		dataToolPage().clickFilterIndicatorSection();
	}

	@Step
	public void verifyMessagesForDisplayingLargeAmountOfData(){
		dataToolPage().verifyMessagesForDisplayingLargeAmountOfData();
	}
 
	@Step
	public void verifyEntitledIndicatorFromLeftHandFilter(String entitledIndicator){
		dataToolPage().verifyEntitledIndicatorFromLeftHandFilter(entitledIndicator);
	}
	
	@Step
	public void verifyExportButtonIsDisabled(){
		dataToolPage().verifyExportButtonIsDisabled();
	}
	
	@Step
	public void verifyRawDataButtonIsDisabled(){
		dataToolPage().verifyRawDataButtonIsDisabled();
	}
	
	@Step
	public void verifySaveButtonIsDisabled(){
		dataToolPage().verifySaveButtonIsDisabled();
	}
	
	@Step
	public void verifyLayoutButtonIsDisabled(){
		dataToolPage().verifyLayoutButtonIsDisabled();
	}
	
	@Step
	public void verifyDisplayDataButton(){
		dataToolPage().verifyDisplayDataButtonIsDisabled();
	}
	
	@Step
	public void verifyFilterSectionsAreDisabled(String breadcrumb, String databaseName){
		dataToolPage().verifyFilterSectionsAreDisabled(breadcrumb,databaseName);
	}
	
	@Step
	public void verifyGeographyIsDeselectedDataTool(String country, String continent){
		dataToolPage().verifyGeographyIsDeselectedDataTool(country, continent);
	}

	@Step
	public void clickFilterDownloadButtonTrialUserForRatings(String extension) {
		dataToolPage().clickFilterDownloadButtonTrialUserForRatings(extension);
		
	}
}

package bmo5.bmo5tests.adm.steps.dvpacks;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class Adm_DvPacks_CreateDvPack_GeneralSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = 6478999550385611198L;

	@StepGroup
	public void clickOnClearFiltersButtonAndVerify(){
		clickOnClearFiltersButton();
		verifyIfFiltersAreCleared();
	}
	
	@StepGroup
	public void verifyTableWithAnnotation(String rowType,String name,String annotationDescription,String column, String annotationDescriptionColumn) {
		adm_DvPacks_CreateDvPack_GeneralPage().addStaticWidgetTableRowAnnotation(rowType,name, annotationDescription);
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnAddAnnotationToTheTable();
		adm_DvPacks_CreateDvPack_GeneralPage().verifyAnnotationAddedToTheWidgetTable();
		adm_DvPacks_CreateDvPack_GeneralPage().createCellTableAnnotation(column, annotationDescriptionColumn);
		adm_DvPacks_CreateDvPack_GeneralPage().verifyAnnotationCellAddedToTheWidgetTable();
	}
	
	@StepGroup
	public void verifyEditRowTableAnnotation(String newRowDescription,String deleteRow) {
		adm_DvPacks_CreateDvPack_GeneralPage().editRowAnnotationStaticWidgetTable(newRowDescription);
		adm_DvPacks_CreateDvPack_GeneralPage().verifyEditRowAnnotationStaticWidgetTable(newRowDescription);
		adm_DvPacks_CreateDvPack_GeneralPage().saveEditCellWidgetTableAnnotation();
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnAnnotationTableButton();
		adm_DvPacks_CreateDvPack_GeneralPage().deleteRowAnnotationTable(deleteRow);
		adm_DvPacks_CreateDvPack_GeneralPage().verifyAnnotationDropdownWidgetTable();
	}
	
	@StepGroup
	public void verifyEditCellTableAnnotation(String newCellDescription,String deleteCell) {
		adm_DvPacks_CreateDvPack_GeneralPage().editCellAnnotationStaticWidgetTable(newCellDescription);
		adm_DvPacks_CreateDvPack_GeneralPage().verifyEditCellAnnotationStaticWidgetTable(newCellDescription);
		adm_DvPacks_CreateDvPack_GeneralPage().saveEditCellWidgetTableAnnotation();
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnAnnotationTableButton();
		adm_DvPacks_CreateDvPack_GeneralPage().deleteCellAnnotationTable(deleteCell);
		adm_DvPacks_CreateDvPack_GeneralPage().verifyAnnotationDropdownWidgetTable();
	}
	
	@StepGroup
	public void addTextAnnotationToChartAndVerify(String annotationType, String size, String description, String rotation){
		clickOnAddAnnotateChartAndVerify();
		clickOnNewButtonAndVerify();
		selectChartAnnotationType(annotationType);
		selectTextSizeForTextAnnotationChart(size);
		typeADescritionForTextChartAnnotation(description);
		typeRotationForTextChartAnnotation(rotation);
		clickOnAddToChartButton();
		verifyChartTextAnnotation(description, size, rotation);
	}
	
	@StepGroup
	public void addArrowAnnotationToChartAndVerify(String annotationType, String lineType){
		clickOnAddAnnotateChartAndVerify();
		clickOnNewButtonAndVerify();
		selectChartAnnotationType(annotationType);
		selectLineType(lineType);
		clickOnAddToChartButton();
		verifyChartArrowAnnotation(lineType);
	}
	
	@StepGroup
	public void addLineAnnotationToChartAndVerify(String annotationType, String lineType){
		clickOnAddAnnotateChartAndVerify();
		clickOnNewButtonAndVerify();
		selectChartAnnotationType(annotationType);
		selectLineType(lineType);
		clickOnAddToChartButton();
		verifyChartLineAnnotation(lineType);
	}
	
	@StepGroup
	public void editCancelAndVerifyTextAnnotation(String description, String size, String rotation, String newDescription, String newSize, String newRotation){
		doubleClickOnATextAnnotation(description);
		verifyEditTextChartAnnotationWindow(description, size, rotation);
		replaceOldValuesFromEditChartTextAnnotation(newDescription, newSize, newRotation);
		clickOnCancelFromTextChartAnnotation();
		verifyChartTextAnnotation(description, size, rotation);
	}
	
	@StepGroup
	public void editSaveAndVerifyTextAnnotation(String description, String size, String rotation, String newDescription, String newSize, String newRotation){
		doubleClickOnATextAnnotation(description);
		verifyEditTextChartAnnotationWindow(description, size, rotation);
		replaceOldValuesFromEditChartTextAnnotation(newDescription, newSize, newRotation);
		clickOnSaveButtonFromTextChartAnnotation();
		verifyChartTextAnnotation(newDescription, newSize, newRotation);
	}
	
	@StepGroup
	public void removeAndVerifyTextAnnotation(String description, String size, String rotation){
		doubleClickOnATextAnnotation(description);
		verifyEditTextChartAnnotationWindow(description, size, rotation);
		clickOnRemoveTextChartAnnotationButton();
		verifyTextChartAnnotationIsRemoved(description);
	}
	
	@StepGroup
	public void editCancelAndVerifyArrowChartAnnotation(String lineType, String newLineType){
		doubleClickOnArrowAnnotation(lineType);
		verifyLineTypeFromEditChartAnnotationWindow(lineType);
		replaceOldLineTypeFromEditChartAnnotationWindow(newLineType);
		clickOnCancelLinkFromEditChartAnnotationWindow();
		verifyChartArrowAnnotation(lineType);
	}
	
	@StepGroup
	public void editSaveAndVerifyArrowChartAnnotation(String lineType, String newLineType){
		doubleClickOnArrowAnnotation(lineType);
		verifyLineTypeFromEditChartAnnotationWindow(lineType);
		replaceOldLineTypeFromEditChartAnnotationWindow(newLineType);
		clickOnSaveButtonFromTextChartAnnotation();
		verifyChartArrowAnnotation(newLineType);
	}
	
	@StepGroup
	public void removeAndVerifyArrowAnnotation(String lineType){
		doubleClickOnArrowAnnotation(lineType);
		verifyLineTypeFromEditChartAnnotationWindow(lineType);
		clickOnRemoveLinkFromEditChartAnnotationWindow();
		verifyArrowChartAnnotationIsRemoved(lineType);
	}
	
	@StepGroup
	public void editCancelAndVerifyLineChartAnnotation(String lineType, String newLineType){
		doubleClickOnLineAnnotation(lineType);
		verifyLineTypeFromEditChartAnnotationWindow(lineType);
		replaceOldLineTypeFromEditChartAnnotationWindow(newLineType);
		clickOnCancelLinkFromEditChartAnnotationWindow();
		verifyChartLineAnnotation(lineType);
	}
	
	@StepGroup
	public void editSaveAndVerifyLineChartAnnotation(String lineType, String newLineType){
		doubleClickOnLineAnnotation(lineType);
		verifyLineTypeFromEditChartAnnotationWindow(lineType);
		replaceOldLineTypeFromEditChartAnnotationWindow(newLineType);
		clickOnSaveButtonFromTextChartAnnotation();
		verifyChartLineAnnotation(newLineType);
	}
	
	@StepGroup
	public void removeAndVerifyLineAnnotation(String lineType){
		doubleClickOnLineAnnotation(lineType);
		verifyLineTypeFromEditChartAnnotationWindow(lineType);
		clickOnRemoveLinkFromEditChartAnnotationWindow();
		verifyLineChartAnnotationIsRemoved(lineType);
	}
	
	@StepGroup
	public void clickOnFormatChartAndVerify(String title, String subtitle, String description,String dvPackType){
		clickOnFormatButtonChart();
		verifyFormatWindowChart(title, subtitle, description,dvPackType);
		verifyXAxisFromFormatWindow(dvPackType);
	}
	
	@StepGroup
	public void clickOnFormatChartAndVerifyForTemplate(String title, String subtitle, String description, String dvPackType){
		clickOnFormatButtonChart();
		verifyFormatWindowChart(title, subtitle, description,dvPackType);
	}
	
	
	@StepGroup
	public void clickOnFormatTableAndVerify(String title, String description){
		clickOnFormatButtonTable();
		verifyFormatWindowTable(title, description);
	}
	
	@Step
	public void verifyTable(String country) {
		adm_DvPacks_CreateDvPack_GeneralPage().verifyWidgetStaticTabelCountryColumnAndFormatAnnotateButtons(country);
	}
	
	@Step
	public void selectDataFromFiltersNdb(String country, String indicator, String dateRangeFrom, String dateRangeTo, String dvpackType){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersNdb(country, indicator, dateRangeFrom, dateRangeTo, dvpackType);
	}
	
	@Step
	public void selectDataFromFiltersRatings(String country, String indicator, String dateRangeFrom, String dateRangeTo, String dvpackType){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersRatings(country, indicator, dateRangeFrom, dateRangeTo, dvpackType);
	}
	
	@Step
	public void selectDataFromFiltersKeyProjects(String region, String startDateOperator, String startYear, String endDateOperator, String endYear, String status, String sector, String fromValue, String toValue){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersKeyProjects(region, startDateOperator, startYear, endDateOperator, endYear, status, sector, fromValue, toValue);
	}
	
	@Step
	public void selectDataFromFiltersUpstreamProjects(String region, String status, String fromEstPeakOil, String toEstPeakOil, String fromEstPeakGas, String toEstPeakGas, String fromProjectCost, String toProjectCost, String onshoreOrOffshore, String hydrocarbonType){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersUpstreamProjects(region, status, fromEstPeakOil, toEstPeakOil, fromEstPeakGas, toEstPeakGas, fromProjectCost, toProjectCost, onshoreOrOffshore, hydrocarbonType);
	}
	
	@Step
	public void selectDataFromFiltersGlobalRefineries(String region, String status, String fromCapacityBD, String toCapacityBD, String fromCapacityTPA, String toCapacityTPA, String startDateOperator, String startYear, String endDateOperator, String endYear){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersGlobalRefineries(region, status, fromCapacityBD, toCapacityBD, fromCapacityTPA, toCapacityTPA, startDateOperator, startYear, endDateOperator, endYear);
	}
	
	@Step
	public void selectDataFromFiltersGlobalMines(String region, String metal, String fromCapex, String toCapex, String fromOreGrade, String toOreGrade, String dateRangeFrom, String dateRangeTo, String endDateOperator, String endYear, String letter, String status, String dvpackType){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersGlobalMines(region, metal, fromCapex, toCapex, fromOreGrade, toOreGrade, dateRangeFrom, dateRangeTo, endDateOperator, endYear, letter, status, dvpackType);
	}
	
	@Step
	public void selectDataFromFiltersBODD(String region, String indicator, String age, String gender, String dateRangeFrom, String dateRangeTo, String dvpackType){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersBODD(region, indicator, age, gender, dateRangeFrom, dateRangeTo, dvpackType);
	}
	
	@Step
	public void selectDataFromFiltersMOD(String region, String operator, String indicator, String dateRangeFrom, String dateRangeTo, String dvpackType){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersMOD(region, operator, indicator, dateRangeFrom, dateRangeTo, dvpackType);
	}
	
	@Step
	public void clickOnDisplayDataButtonAndVerify(){
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnDisplayDataButtonAndVerify();
	}
	
	@Step
	public void clickOnClearFiltersButton(){
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnClearFiltersButton();
	}
	
	@Step
	public void verifyIfFiltersAreCleared(){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyIfFiltersAreCleared();
	}
	
	@Step
	public void clickOnBackButton() {
		adm_DvPacks_CreateDvPack_GeneralPage().verifyAndClickOnBackButton();
	}
	
	@Step
	public void clickOnContinueButton(){
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnContinueButton();
	}
	
	@Step
	public int returnNumbeOfRowsFromTable(){
		return adm_DvPacks_CreateDvPack_GeneralPage().returnNumbeOfRowsFromTable();
	}
	
	@Step
	public void verifyButtonsPresenceForStaticDvPAck(){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyButtonsPresenceForStaticDvPAck();
	}
	
	@Step
	public void verifyButtonsPresenceForDynamicDvPack(){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyButtonsPresenceForDynamicDvPack();
	}
	
	@Step
	public void clickOnDisplayDataButtonFromLandingPageTemplateDvPack(){
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnDisplayDataButtonFromLandingPageTemplateDvPack();
	}
	
	@Step
	public void selectDataFromFiltersNdbTemplateDvPack(String indicator, String dateRangeFrom, String dateRangeTo, String dvpackType){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersNdbTemplateDvPack(indicator, dateRangeFrom, dateRangeTo, dvpackType);
	}
	
	@Step
	public void selectDataFromFiltersRatingsTemplateDvPack(String indicator, String dateRangeFrom, String dateRangeTo, String dvpackType){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersRatingsTemplateDvPack(indicator, dateRangeFrom, dateRangeTo, dvpackType);
	}
	
	@Step
	public void selectDataFromFiltersKeyProjectsTemplateDvPack(String startDateOperator, String startYear, String endDateOperator, String endYear, String status, String sector, String fromValue, String toValue){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersKeyProjectsTemplateDvPack(startDateOperator, startYear, endDateOperator, endYear, status, sector, fromValue, toValue);
	}
	
	@Step
	public void selectDataFromFiltersUpstreamProjectsTemplateDvPack(String status, String fromEstPeakOil, String toEstPeakOil, String fromEstPeakGas, String toEstPeakGas, String fromProjectCost, String toProjectCost, String onshoreOrOffshore, String hydrocarbonType){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersUpstreamProjectsTemplateDvPack(status, fromEstPeakOil, toEstPeakOil, fromEstPeakGas, toEstPeakGas, fromProjectCost, toProjectCost, onshoreOrOffshore, hydrocarbonType);
	}
	
	@Step
	public void selectDataFromFiltersGlobalRefineriesTemplateDvPack(String status, String fromCapacityBD, String toCapacityBD, String fromCapacityTPA, String toCapacityTPA, String startDateOperator, String startYear, String endDateOperator, String endYear){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersGlobalRefineriesTemplateDvPack(status, fromCapacityBD, toCapacityBD, fromCapacityTPA, toCapacityTPA, startDateOperator, startYear, endDateOperator, endYear);
	}
	
	@Step
	public void selectDataFromFiltersGlobalMinesTemplateDvPack(String metal, String fromCapex, String toCapex, String fromOreGrade, String toOreGrade, String dateRangeFrom, String dateRangeTo, String endDateOperator, String endYear, String letter, String status, String dvpackType){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersGlobalMinesTemplateDvPack(metal, fromCapex, toCapex, fromOreGrade, toOreGrade, dateRangeFrom, dateRangeTo, endDateOperator, endYear, letter, status, dvpackType);
	}
	
	@Step
	public void selectDataFromFiltersBODDTemplateDvPack(String indicator, String age, String gender, String dateRangeFrom, String dateRangeTo, String dvpackType){
		adm_DvPacks_CreateDvPack_GeneralPage().selectDataFromFiltersBODDTemplateDvPack(indicator, age, gender, dateRangeFrom, dateRangeTo, dvpackType);
	}
	
	@Step
	public void checkOneGeographyFromPreviewTemplateDvPack(String geography){
		adm_DvPacks_CreateDvPack_GeneralPage().checkOneGeographyFromPreviewTemplateDvPack(geography);
	}
	
	@Step
	public void verifyPreviewForPopUpWindow(){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyPreviewForPopUpWindow();
	}

	@Step
	public void clickOnAddAnnotateChartAndVerify(){
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnAddAnnotateChartAndVerify();
	}
	
	@Step
	public void clickOnNewButtonAndVerify(){
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnNewButtonAndVerify();
	}
	
	@Step
	public void selectChartAnnotationType(String annotationType){
		adm_DvPacks_CreateDvPack_GeneralPage().selectChartAnnotationType(annotationType);
	}
	
	@Step
	public void typeADescritionForTextChartAnnotation(String description){
		adm_DvPacks_CreateDvPack_GeneralPage().typeADescritionForTextChartAnnotation(description);
	}
	
	@Step
	public void typeRotationForTextChartAnnotation(String rotation){
		adm_DvPacks_CreateDvPack_GeneralPage().typeRotationForTextChartAnnotation(rotation);
	}
	
	@Step
	public void selectTextSizeForTextAnnotationChart(String size){
		adm_DvPacks_CreateDvPack_GeneralPage().selectTextSizeForTextAnnotationChart(size);
	}
	
	@Step
	public void selectLineType(String lineType){
		adm_DvPacks_CreateDvPack_GeneralPage().selectLineType(lineType);
	}
	
	@Step
	public void clickOnAddToChartButton(){
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnAddToChartButton();
	}
	
	@Step
	public void verifyChartTextAnnotation(String description, String size, String rotation){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyChartTextAnnotation(description, size, rotation);
	}
	
	@Step
	public void verifyChartArrowAnnotation(String lineType){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyChartArrowAnnotation(lineType);
	}
	
	@Step
	public void verifyChartLineAnnotation(String lineType){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyChartLineAnnotation(lineType);
	}
	
	@Step
	public void doubleClickOnATextAnnotation(String description){
		adm_DvPacks_CreateDvPack_GeneralPage().doubleClickOnATextAnnotation(description);
	}
	
	@Step
	public void verifyEditTextChartAnnotationWindow(String description, String size, String rotation){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyEditTextChartAnnotationWindow(description, size, rotation);
	}
	
	@Step
	public void replaceOldValuesFromEditChartTextAnnotation(String newDescription, String newSize, String newRotation){
		adm_DvPacks_CreateDvPack_GeneralPage().replaceOldValuesFromEditChartTextAnnotation(newDescription, newSize, newRotation);
	}
	
	@Step
	public void clickOnRemoveTextChartAnnotationButton(){
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnRemoveTextChartAnnotationButton();
	}
	
	@Step
	public void verifyTextChartAnnotationIsRemoved(String description){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyTextChartAnnotationIsRemoved(description);
	}
	
	@Step
	public void clickOnCancelFromTextChartAnnotation(){
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnCancelFromTextChartAnnotation();
	}
	
	@Step
	public void clickOnSaveButtonFromTextChartAnnotation(){
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnSaveButtonFromTextChartAnnotation();
	}
	
	@Step
	public void doubleClickOnArrowAnnotation(String lineType){
		adm_DvPacks_CreateDvPack_GeneralPage().doubleClickOnArrowAnnotation(lineType);
	}
	
	@Step
	public void doubleClickOnLineAnnotation(String lineType){
		adm_DvPacks_CreateDvPack_GeneralPage().doubleClickOnLineAnnotation(lineType);
	}
	
	@Step
	public void verifyLineTypeFromEditChartAnnotationWindow(String lineType){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyLineTypeFromEditChartAnnotationWindow(lineType);
	}
	
	@Step
	public void replaceOldLineTypeFromEditChartAnnotationWindow(String newLineType){
		adm_DvPacks_CreateDvPack_GeneralPage().replaceOldLineTypeFromEditChartAnnotationWindow(newLineType);
	}
	
	@Step
	public void clickOnRemoveLinkFromEditChartAnnotationWindow(){
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnRemoveLinkFromEditChartAnnotationWindow();
	}
	
	@Step
	public void verifyArrowChartAnnotationIsRemoved(String lineType){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyArrowChartAnnotationIsRemoved(lineType);
	}
	
	@Step
	public void verifyLineChartAnnotationIsRemoved(String lineType){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyLineChartAnnotationIsRemoved(lineType);
	}
	
	@Step
	public void clickOnCancelLinkFromEditChartAnnotationWindow(){
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnCancelLinkFromEditChartAnnotationWindow();
	}

	
	@Step
	public void verifyAnnotationsOnPreviewTable() {
		adm_DvPacks_CreateDvPack_GeneralPage().verifyAnnotationAddedToTheWidgetTable();
		adm_DvPacks_CreateDvPack_GeneralPage().verifyAnnotationCellAddedToTheWidgetTable();
	}

	
	@Step
	public void clickOnFormatButtonTable(){
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnFormatButtonTable();
	}
	
	@Step
	public void verifyFormatWindowTable(String title, String description){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyFormatWindowTable(title, description);
	}
	
	@Step
	public void clickOnFormatButtonChart(){
		adm_DvPacks_CreateDvPack_GeneralPage().clickOnFormatButtonChart();
	}
	
	@Step
	public void verifyChartTitle(String title){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyChartTitle(title);
	}
	
	@Step
	public void verifyChartSubtitle(String subtitle){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyChartSubtitle(subtitle);
	}
	
	@Step
	public void verifyXAxisFromFormatWindow(String dvpackType){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyXAxisFromFormatWindow(dvpackType);
	}
	
	@Step
	public void verifyFormatWindowChart(String title,String subtitle,String description,String dvpackType){
		adm_DvPacks_CreateDvPack_GeneralPage().verifyFormatWindowChart(title, subtitle, description, dvpackType);
	}

	@Step
	public void verifyTableMatchesFilterSelection() {
		adm_DvPacks_CreateDvPack_GeneralPage().verifyTableFilterMatchesCountrySelection();
		
	}
	
	@Step
	public List<String> getIndicators(){
		return adm_DvPacks_CreateDvPack_GeneralPage().getIndicators();
	}
}

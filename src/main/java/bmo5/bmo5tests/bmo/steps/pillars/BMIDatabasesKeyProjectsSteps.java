package bmo5.bmo5tests.bmo.steps.pillars;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import org.openqa.selenium.By;

import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class BMIDatabasesKeyProjectsSteps extends AbstractSteps{

	private static final long serialVersionUID = 5029495117507364288L;
	
	@StepGroup
	public void chooseFilterPanelOptions(){
		bmiDatabasesKeyProjectsPage().clickOnStartDate();
		bmiDatabasesKeyProjectsPage().clickOnStartDateDropdown();
		bmiDatabasesKeyProjectsPage().clickOnEndDateToggler();
		bmiDatabasesKeyProjectsPage().clickOnStatusToggler();
		bmiDatabasesKeyProjectsPage().clickOnSectorToggler();
		bmiDatabasesKeyProjectsPage().clickOnValuesToggler();
		bmiDatabasesKeyProjectsPage().clickOnDisplayDataButton();
	}
	
	@StepGroup
	public void verifyStatusFilter(String status){
		checkOneStatus(status);
		String statusId = returnTheStatusId(status);
		verifyStatusIsChecked(statusId);
		checkOneStatus(status);
		verifyIfStatusIsUnchecked(statusId);
		checkOneStatus(status);
		verifyStatusIsChecked(statusId);
	}
	
	@StepGroup
	public void verifyFiltersAfterOpeningSavedData(String character, String status, String fromInput, String toInput, String fromCapacity, String toCapacity){
		if(getDriver().findElements(By.cssSelector("div#dynamic_table > div.alert.alert-info")).size() == 1){
			System.out.println("Filter button is not available. No results were found.");
		}
		else{
//			bmiDatabasesUpstreamProjectsPage().verifyIfCompanyIsChecked(character);
			bmiDatabasesKeyProjectsPage().clickOnStatusToggler();
			String statusId = returnTheStatusId(status);
			bmiDatabasesKeyProjectsPage().verifyStatusIsChecked(statusId);
			bmiDatabasesKeyProjectsPage().clickOnValuesToggler();
			bmiDatabasesKeyProjectsPage().verifyTheFieldsFromValuesSection(fromInput, toInput);
			bmiDatabasesKeyProjectsPage().clickOnCapacityToggler();
			bmiDatabasesKeyProjectsPage().verifyFieldsFromCapacitySection(fromCapacity, toCapacity);
		}
	}
	
	@StepGroup
	public void checkUncheckAContinentAndVerify(String continent){
		verifyIfRegionIsNotChecked(continent);
		checkOneRegion(continent);
		verifyIfRegionIsChecked(continent);
	}
	
	@StepGroup
	public void checkUncheckASectorAndVerify(String sector){
		checkOneItemFromSector(sector);
		String sectorId = returnTheSectorId(sector);
		verifyIfSectorIsChecked(sectorId);
		checkOneItemFromSector(sector);
		verifyIfSectorIsNotChecked(sectorId);
		checkOneItemFromSector(sector);
		verifyIfSectorIsChecked(sectorId);
	}
	
	@Step
	public void verifyIfElementsArePresentAfterAccessingDatabases(){
		bmiDatabasesKeyProjectsPage().verifyIfElementsArePresentAfterAccessingDatabases();
	}
	
	@Step
	public void insertLettersInInputBoxFromGeographySection(String letters){
		bmiDatabasesKeyProjectsPage().insertLettersInInputBoxFromGeographySection(letters);
	}
	
	@Step
	public void verifyDatabaseBreadcrumb(String databaseName){
		bmiDatabasesKeyProjectsPage().verifyDatabaseBreadcrumb(databaseName);
	}
	
	@Step
	public void checkAllElementsFromGeographySectionAndVerify(){
		bmiDatabasesKeyProjectsPage().checkAllElementsFromGeographySectionAndVerify();
	}
	
	@Step
	public void selectOneOperatorFromStartDateSection(String operator){
		bmiDatabasesKeyProjectsPage().selectOneOperatorFromStartDateSection(operator);
	}
	
	@Step
	public void clickOnStartDateToggler(){
		bmiDatabasesKeyProjectsPage().clickOnStartDateToggler();
	}
	
	@Step
	public void clickOnEndDateToggler(){
		bmiDatabasesKeyProjectsPage().clickOnEndDateToggler();
	}
	
	@Step
	public void selectOneOperatorFromEndDateSection(String operator){
		bmiDatabasesKeyProjectsPage().selectOneOperatorFromEndDateSection(operator);
	}
	
	@Step
	public void clickOnStatusToggler(){
		bmiDatabasesKeyProjectsPage().clickOnStatusToggler();
	}
	
	@Step
	public void checkOneStatus(String status){
		bmiDatabasesKeyProjectsPage().checkOneStatus(status);
	}
	
	@Step
	public String returnTheStatusId(String status){
		return bmiDatabasesKeyProjectsPage().returnTheStatusId(status);
	}
	
	@Step
	public void clickOnSectorToggler(){
		bmiDatabasesKeyProjectsPage().clickOnSectorToggler();
	}
	
	@Step
	public void insertLettersInInputBoxSectorSection(String letters){
		bmiDatabasesKeyProjectsPage().insertLettersInInputBoxSectorSection(letters);
	}
	
	@Step
	public void checkAllElementsFromSectorSectionAndVerify(){
		bmiDatabasesKeyProjectsPage().checkAllElementsFromSectorSectionAndVerify();
	}
	
	@Step
	public void uncheckAllElementsFromSectorSectionAndVerify(){
		bmiDatabasesKeyProjectsPage().uncheckAllElementsFromSectorSectionAndVerify();
	}
	
	@Step
	public void clickOnValuesToggler(){
		bmiDatabasesKeyProjectsPage().clickOnValuesToggler();
	}
	
	@Step
	public void completeFieldsValuesSection(String fromInput, String toInput ){
		bmiDatabasesKeyProjectsPage().completeFieldsValuesSection(fromInput, toInput);
	}
	
	@Step
	public void clickOnDisplayDataButton(){
		bmiDatabasesKeyProjectsPage().clickOnDisplayDataButton();
	}
	
	@Step
	public void clickOnFilterToggler(){
		bmiDatabasesKeyProjectsPage().clickOnFilterToggler();
	}
	
	@Step
	public void clickOnCapacityToggler(){
		bmiDatabasesKeyProjectsPage().clickOnCapacityToggler();
	}
	
	@Step
	public void completeFieldsFromCapacitySection(String size, String fromCapacity, String toCapacity){
		bmiDatabasesKeyProjectsPage().completeFieldsFromCapacitySection(size, fromCapacity, toCapacity);
	}
	
	@Step
	public void clickOnFilterButton(){
		bmiDatabasesKeyProjectsPage().clickOnFilterButton();
	}
	
	@Step
	public void checkOneItemFromSector(String sector){
		bmiDatabasesKeyProjectsPage().checkOneItemFromSector(sector);
	}
	
	@Step
	public String returnTheSectorId(String sector){
		return bmiDatabasesKeyProjectsPage().returnTheSectorId(sector);
	}
	
	@Step
	public void verifyIfSectorIsChecked(String sector){
		bmiDatabasesKeyProjectsPage().verifyIfSectorIsChecked(sector);
	}
	
	@Step
	public void checkOneRegion(String continent){
		bmiDatabasesKeyProjectsPage().checkOneRegion(continent);
	}

	@Step
	public void verifyIfRegionIsNotChecked(String continent){
		bmiDatabasesKeyProjectsPage().verifyIfRegionIsNotChecked(continent);
	}
	
	@Step
	public void selectOneYearFromStartDateDropDownList(String year){
		bmiDatabasesKeyProjectsPage().selectOneYearFromStartDateDropDownList(year);
	}
	
	@Step
	public void selectOneYearFromEndDateDropDownList(String year){
		bmiDatabasesKeyProjectsPage().selectOneYearFromEndDateDropDownList(year);
	}
	
	@Step
	public void verifyIfRegionIsChecked(String continent){
		bmiDatabasesKeyProjectsPage().verifyIfRegionIsChecked(continent);
	}
	
	@Step
	public void verifyStatusIsChecked(String status){
		bmiDatabasesKeyProjectsPage().verifyStatusIsChecked(status);
	}
	
	@Step
	public void verifyTheFieldsFromValuesSection(String fromInput, String toInput){
		bmiDatabasesKeyProjectsPage().verifyTheFieldsFromValuesSection(fromInput, toInput);
	}
	
	@Step
	public void verifyFieldsFromCapacitySection(String fromCapacity, String toCapacity){
		bmiDatabasesKeyProjectsPage().verifyFieldsFromCapacitySection(fromCapacity, toCapacity);
	}
	
	@Step
	public void verifyIfStatusIsUnchecked(String status){
		bmiDatabasesKeyProjectsPage().verifyIfStatusIsUnchecked(status);
	}
	
	@Step
	public void verifyIfSectorIsNotChecked(String sector){
		bmiDatabasesKeyProjectsPage().verifyIfSectorIsNotChecked(sector);
	}
}
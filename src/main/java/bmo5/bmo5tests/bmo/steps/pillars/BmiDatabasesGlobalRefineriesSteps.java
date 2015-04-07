package bmo5.bmo5tests.bmo.steps.pillars;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import org.openqa.selenium.By;

import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class BmiDatabasesGlobalRefineriesSteps extends AbstractSteps{

	private static final long serialVersionUID = 7150741891738909072L;
	
	@StepGroup
	public void verifyStatusFilter(String status){
		verifyIfThStatusIsUnchecked(returnStatusId(status));
		checkOneItemFromStatusSection(status);
		verifyIfTheStatusIsChecked(returnStatusId(status));
	}
	
	@StepGroup
	public void verifyFiltersAfterOpeningSavedData(String status, String letter){
		if(getDriver().findElements(By.cssSelector("div#dynamic_table > div.alert.alert-info")).size() == 1){
			System.out.println("Filter button is not available. No results were found.");
		}
		else{
			bmiDatabasesGlobalMinesPage().verifyIfTheMetalIsChecked(returnStatusId(status));
			clickOnOwnerTogglerAndVerify();
			verifyIfOneLetterFromOwnerFilterIsChecked(letter);
		}
	}
	
	@StepGroup
	public void verifyOwnerFilter(String letter){
//		verifyIfOneLetterFromOwnerFilterIsNotChecked(letter);
		checkOneLetterInOwnerFilter(letter);
		verifyIfOneLetterFromOwnerFilterIsChecked(letter);
	}
	
	@Step
	public void clickOnCapacityBDTogglerAndVerify(){
		bmiDatabasesGlobalRefineriesPage().clickOnCapacityBDTogglerAndVerify();
	}

	@Step
	public void clickOnCapacityTPATogglerAndVerify(){
		bmiDatabasesGlobalRefineriesPage().clickOnCapacityTPATogglerAndVerify();
	}
	
	@Step
	public void clickOnStartDateTogglerAndVerify(){
		bmiDatabasesGlobalRefineriesPage().clickOnStartDateTogglerAndVerify();
	}
	
	@Step
	public void clickOnEndDateTogglerAndVerify(){
		bmiDatabasesGlobalRefineriesPage().clickOnEndDateTogglerAndVerify();
	}
	
	@Step
	public void clickOnOwnerTogglerAndVerify(){
		bmiDatabasesGlobalRefineriesPage().clickOnOwnerTogglerAndVerify();
	}
	
	@Step
	public void selectCapacityBDFromDropDown(String capacityBD){
		bmiDatabasesGlobalRefineriesPage().selectCapacityBDFromDropDown(capacityBD);
	}
	
	@Step
	public void selectCapacityTPAFromDropDown(String capacityTPA){
		bmiDatabasesGlobalRefineriesPage().selectCapacityTPAFromDropDown(capacityTPA);
	}
	
	@Step
	public void checkOneLetterInOwnerFilter(String letter){
		bmiDatabasesGlobalRefineriesPage().checkOneLetterInOwnerFilter(letter);
	}
	
	@Step
	public void verifyIfOneLetterFromOwnerFilterIsChecked(String letter){
		bmiDatabasesGlobalRefineriesPage().verifyIfOneLetterFromOwnerFilterIsChecked(letter);
	}
	
	@Step
	public void verifyIfOneLetterFromOwnerFilterIsNotChecked(String letter){
		bmiDatabasesGlobalRefineriesPage().verifyIfOneLetterFromOwnerFilterIsNotChecked(letter);
	}
	
	@Step
	public void checkOneItemFromStatusSection(String status){
		bmiDatabasesGlobalRefineriesPage().checkOneItemFromStatusSection(status);
	}
	
	@Step
	public void verifyIfTheStatusIsChecked(String status){
		bmiDatabasesGlobalRefineriesPage().verifyIfTheStatusIsChecked(status);
	}
	
	@Step
	public void verifyIfThStatusIsUnchecked(String status){
		bmiDatabasesGlobalRefineriesPage().verifyIfThStatusIsUnchecked(status);
	}
	
	@Step
	public String returnStatusId(String status){
		return bmiDatabasesGlobalRefineriesPage().returnStatusId(status);
	}
	
	@Step
	public void clickOnFilterToggler(){
		bmiDatabasesGlobalRefineriesPage().clickOnFilterToggler();
	}
}

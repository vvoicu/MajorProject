package bmo5.bmo5tests.bmo.steps.pillars;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class BmiDatabasesFeedInTariffsSteps extends AbstractSteps{

	private static final long serialVersionUID = 8378282902680856112L;

	@Step
	public void clickOnSectorToggler(){
		bmiDatabasesFeedInTariffsPage().clickOnSectorToggler();
	}
	
	@Step
	public void insertLettersInSectorInputBox(String letters){
		bmiDatabasesFeedInTariffsPage().insertLettersInSectorInputBox(letters);
	}
	
	@Step
	public void checkSector(String letters){
		bmiDatabasesFeedInTariffsPage().checkSector(letters);
	}
	
	@Step
	public void clickOnDateRangesToggler(){
		bmiDatabasesFeedInTariffsPage().clickOnDateRangesToggler();
	}
	
	@Step
	public void checkOneYearFromDateRangesSection(String dateRange){
		bmiDatabasesFeedInTariffsPage().checkOneYearFromDateRangesSection(dateRange);
	}
	
	@Step
	public void clickOnDownloadRawDataButtonTrialUser(){
		bmiDatabasesFeedInTariffsPage().clickOnDownloadRawDataButtonTrialUser();
	}
	
	@Step
	public void checkOneYearFromDaterangesSection(String dateRange){
		bmiDatabasesFeedInTariffsPage().checkOneYearFromDaterangesSection(dateRange);
	}
	
	@Step
	public void clickOnDaterangesToggler(){
		bmiDatabasesFeedInTariffsPage().clickOnDaterangesToggler();
	}
	
	@Step
	public void insertThreeLettersInInputBoxFromSectorSectionAndVerify(String threeLetters){
		bmiDatabasesFeedInTariffsPage().insertThreeLettersInInputBoxFromSectorSectionAndVerify(threeLetters);
	}
	
	@Step
	public void checkOneOptionFromSectorFilter(String sector){
		bmiDatabasesFeedInTariffsPage().checkOneOptionFromSectorFilter(sector);
	}
	
	@Step
	public void verifyIfOptionFromSectorFilterIsChecked(String sector){
		bmiDatabasesFeedInTariffsPage().verifyIfOptionFromSectorFilterIsChecked(sector);
	}
}

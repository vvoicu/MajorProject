package bmo5.bmo5tests.bmo.steps.pillars;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import org.junit.Assert;
import org.openqa.selenium.By;

import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class BMIDatabasesMobileOperatorsSteps extends AbstractSteps{

	private static final long serialVersionUID = -6045861515868381329L;

	@StepGroup
	public void verifyDateRangesFilter(String dateRange){
		verifyIfYearIsUnChecked(dateRange);
		checkOneYearFromDateRangesSection(dateRange);
		verifyIfYearIsChecked(dateRange);
	}
	
	@StepGroup
	public void verifyFiltersAfterOpeningSavedData(String continent, String letter, String indicator, String dateRange){
		if(getDriver().findElements(By.cssSelector("div#dynamic_table > div.alert.alert-info")).size() == 1){
			System.out.println("There are no results");
			Assert.assertTrue(getDriver().findElements(By.cssSelector("button#dvpack-save[disabled]")).size() == 1);
		}
		else{
			verifyIfRegionIsChecked(continent);
			clickOnOperatorToggler();
			verifyIfLetterIsChecked(letter);
			clickOnIndicatorToggler();
			verifyIfOneIndicatorIsChecked(returnTheIndicatorId(indicator));
			clickOnDateRangesToggler();
			verifyIfYearIsChecked(dateRange);
		}
	}
	
	@StepGroup
	public void verifyGeographyFilter(String continent){
		verifyIfRegionIsNotChecked(continent);
		checkOneRegion(continent);
		verifyIfRegionIsChecked(continent);
	}
	
	@StepGroup
	public void verifyOperatorsFilter(String letter){
		verifyIfLetterIsNotChecked(letter);
		checkOneLetterFromOperatorSection(letter);
		verifyIfLetterIsChecked(letter);
	}
	
	@StepGroup
	public void verifyIndicatorFilter(String indicator){
		String indicatorId = returnTheIndicatorId(indicator);
		verifyIfOneIndicatorIsNotChecked(indicatorId);
		checkOneIndicatorFromIndicatorSection(indicator);
		verifyIfOneIndicatorIsChecked(indicatorId);
	}
	
	@Step
	public void clickOnGeographyTogglerAndVerify(){
		bmiDatabasesMobileOperatorsPage().clickOnGeographyTogglerAndVerify();
	}
	
	@Step
	public void clickOnOperatorToggler(){
		bmiDatabasesMobileOperatorsPage().clickOnOperatorToggler();
	}
	
	@Step
	public void insertThreeLettersInInputBoxFromOperatorsSectionAndVerify(String threeLetters){
		bmiDatabasesMobileOperatorsPage().insertThreeLettersInInputBoxFromOperatorsSectionAndVerify(threeLetters);
	}
	
	@Step
	public void checkOneLetterFromOperatorSection(String letter){
		bmiDatabasesMobileOperatorsPage().checkOneLetterFromOperatorSection(letter);
	}
	
	@Step
	public void clickOnIndicatorToggler(){
		bmiDatabasesMobileOperatorsPage().clickOnIndicatorToggler();
	}
	
	@Step
	public String returnTheIndicatorId(String indicator){
		return bmiDatabasesMobileOperatorsPage().returnTheIndicatorId(indicator);
	}
	
	@Step
	public void clickOnDisplayDataButton(){
		bmiDatabasesMobileOperatorsPage().clickOnDisplayDataButton();
	}
	
	@Step
	public void checkOneYearFromDateRangesSection(String dateRange){
		bmiDatabasesMobileOperatorsPage().checkOneYearFromDateRangesSection(dateRange);
	}
	
	@Step
	public void clickOnDateRangesToggler(){
		bmiDatabasesMobileOperatorsPage().clickOnDateRangesToggler();
	}
	
	@Step
	public void checkOneRegion(String continent){
		bmiDatabasesMobileOperatorsPage().checkOneRegion(continent);
	}
	
	@Step
	public void verifyIfRegionIsNotChecked(String continent){
		bmiDatabasesMobileOperatorsPage().verifyIfRegionIsNotChecked(continent);
	}

	@Step
	public void downloadTheFeedInTariffsData() {
		bmiDatabasesMobileOperatorsPage().downloadTheFeedInTariffsData();		
	}
	
	@Step
	public void verifyIfRegionIsChecked(String continent){
		bmiDatabasesMobileOperatorsPage().verifyIfRegionIsChecked(continent);
	}
	
	@Step
	public void verifyIfLetterIsChecked(String letter){
		bmiDatabasesMobileOperatorsPage().verifyIfLetterIsChecked(letter);
	}
	
	@Step
	public void verifyIfOneIndicatorIsChecked(String indicator){
		bmiDatabasesMobileOperatorsPage().verifyIfOneIndicatorIsChecked(indicator);
	}
	
	@Step
	public void verifyIfOneIndicatorIsNotChecked(String indicator){
		bmiDatabasesMobileOperatorsPage().verifyIfOneIndicatorIsNotChecked(indicator);
	}
	
	@Step
	public void verifyIfYearIsChecked(String dateRange){
		bmiDatabasesMobileOperatorsPage().verifyIfYearIsChecked(dateRange);
	}
	
	@Step
	public void verifyIfYearIsUnChecked(String dateRange){
		bmiDatabasesMobileOperatorsPage().verifyIfYearIsUnChecked(dateRange);
	}
	
	@Step
	public void checkOneIndicatorFromIndicatorSection(String indicator){
		bmiDatabasesMobileOperatorsPage().checkOneIndicatorFromIndicatorSection(indicator);
	}
	
	@Step
	public void checkOneLetterFromSectorSection(String letter){
		bmiDatabasesMobileOperatorsPage().checkOneLetterFromSectorSection(letter);
	}
	
	@Step
	public void verifyIfLetterIsNotChecked(String letter){
		bmiDatabasesMobileOperatorsPage().verifyIfLetterIsNotChecked(letter);
	}
	
	@Step
	public void verifyFiltersAreClered(){
		bmiDatabasesMobileOperatorsPage().verifyFiltersAreClered();
	}
	
	@Step
	public void verifyGeographyInTable(){
		bmiDatabasesMobileOperatorsPage().verifyGeographyInTable();
	}
	
	@Step
	public void verifyOperatorInTable(){
		bmiDatabasesMobileOperatorsPage().verifyOperatorInTable();
	}
	
	@Step
	public void verifyIndicatorInTable(){
		bmiDatabasesMobileOperatorsPage().verifyIndicatorInTable();
	}
	
	@Step
	public void verifyDateRangesInTable(String year){
		bmiDatabasesMobileOperatorsPage().verifyDateRangesInTable(year);
	}
}

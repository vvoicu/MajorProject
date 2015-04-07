package bmo5.bmo5tests.bmo.steps.pillars;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import org.junit.Assert;
import org.openqa.selenium.By;

import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class BMIDatabasesBurdenOfDiseaseSteps extends AbstractSteps{

	private static final long serialVersionUID = -4209574585646940858L;

	@StepGroup
	public void verifyIndicatorFilter(String indicator){
		verifyIfIndicatorIsUnChecked(returnThIndicatorId(indicator));
		checkOneItemFromIndicatorSection(indicator);
		verifyIfIndicatorIsChecked(returnThIndicatorId(indicator));
	}
	
	@StepGroup
	public void verifyAgeFilter(String age){
		verifyIfAgeIsUnChecked(age);
		checkOneItemAndVerifyFromAgeSection(age);
		verifyIfAgeIsChecked(age);
	}
	
	@StepGroup
	public void verifyGenderFilter(String gender){
		verifyIfGenderIsUnChecked(gender);
		checkOneItemAndVerifyFromGenderSection(gender);
		verifyIfGenderIsChecked(gender);
	}
	
	@StepGroup
	public void verifyDateRangeFilter(String year){
		verifyIfDateRangeIsUnChecked(year);
		checkYearFromDateRangesSection(year);
		verifyIfDateRangeIsChecked(year);
	}
	
	@StepGroup
	public void verifyFiltersAfterOpeningSavedData(String continent, String indicator, String age, String gender, String year){
		if(getDriver().findElements(By.cssSelector("div#dynamic_table > div.alert.alert-info")).size() == 1){
			System.out.println("There are no results");
			Assert.assertTrue(getDriver().findElements(By.cssSelector("button#dvpack-save[disabled]")).size() == 1);
		}
		else{
			bmiDatabasesGeneralPage().verifyIfOneRegionIsChecked(continent);
			clickOnIndicatorToggler();
			verifyIfIndicatorIsChecked(returnThIndicatorId(indicator));
			clickOnAgeToggler();
			verifyIfAgeIsChecked(age);
			clickOnGenderToggler();
			verifyIfGenderIsChecked(gender);
			clickOnDateRangesToggler();
			verifyIfDateRangeIsChecked(year);
		}
	}
	
	@StepGroup
	public void clickAndVerifyCategoryTabFromIndicatorFilter(){
		clickOnCategoryTabFromIndicatorFilter();
		verifyIfCategoryTabFromIndicatorFilterIsActive();
	}
	
	@Step
	public void clickOnIndicatorToggler(){
		bmiDatabasesBurdenOfDiseasePage().clickOnIndicatorToggler();
	}
	
	@Step
	public void insertThreeLettersInInputBoxFromIndicatorSectionAndVerify(String threeLetters){
		bmiDatabasesBurdenOfDiseasePage().insertThreeLettersInInputBoxFromIndicatorSectionAndVerify(threeLetters);
	}
	
	@Step
	public void checkOneItemFromIndicatorSection(String indicator){
		bmiDatabasesBurdenOfDiseasePage().checkOneItemFromIndicatorSection(indicator);
	}
	
	@Step
	public void clickOnAgeToggler(){
		bmiDatabasesBurdenOfDiseasePage().clickOnAgeToggler();
	}
	
	@Step
	public void checkOneItemAndVerifyFromAgeSection(String age){
		bmiDatabasesBurdenOfDiseasePage().checkOneItemAndVerifyFromAgeSection(age);
	}
	
	@Step
	public void clickOnGenderToggler(){
		bmiDatabasesBurdenOfDiseasePage().clickOnGenderToggler();
	}
	
	@Step
	public void checkOneItemAndVerifyFromGenderSection(String gender){
		bmiDatabasesBurdenOfDiseasePage().checkOneItemAndVerifyFromGenderSection(gender);
	}
	
	@Step
	public void clickOnDateRangesToggler(){
		bmiDatabasesBurdenOfDiseasePage().clickOnDateRangesToggler();
	}
	
	@Step
	public void checkYearFromDateRangesSection(String year){
		bmiDatabasesBurdenOfDiseasePage().checkYearFromDateRangesSection(year);
	}
	
	@Step
	public void clickOnDisplayDataButton(){
		bmiDatabasesBurdenOfDiseasePage().clickOnDisplayDataButton();
	}
	
	@Step
	public void verifyIfIndicatorIsChecked(String indicator){
		bmiDatabasesBurdenOfDiseasePage().verifyIfIndicatorIsChecked(indicator);
	}
	
	@Step
	public void verifyIfIndicatorIsUnChecked(String indicator){
		bmiDatabasesBurdenOfDiseasePage().verifyIfIndicatorIsUnChecked(indicator);
	}
	
	@Step
	public String returnThIndicatorId(String indicator){
		return bmiDatabasesBurdenOfDiseasePage().returnThIndicatorId(indicator);
	}
	
	@Step
	public void verifyIfAgeIsChecked(String age){
		bmiDatabasesBurdenOfDiseasePage().verifyIfAgeIsChecked(age);
	}
	
	@Step
	public void verifyIfAgeIsUnChecked(String age){
		bmiDatabasesBurdenOfDiseasePage().verifyIfAgeIsUnChecked(age);
	}
	
	@Step
	public void verifyIfGenderIsChecked(String gender){
		bmiDatabasesBurdenOfDiseasePage().verifyIfGenderIsChecked(gender);
	}
	
	@Step
	public void verifyIfGenderIsUnChecked(String gender){
		bmiDatabasesBurdenOfDiseasePage().verifyIfGenderIsUnChecked(gender);
	}
	
	@Step
	public void verifyIfDateRangeIsChecked(String year){
		bmiDatabasesBurdenOfDiseasePage().verifyIfDateRangeIsChecked(year);
	}
	
	@Step
	public void verifyIfDateRangeIsUnChecked(String year){
		bmiDatabasesBurdenOfDiseasePage().verifyIfDateRangeIsUnChecked(year);
	}
	
	@Step
	public void clickOnCategoryTabFromIndicatorFilter(){
		bmiDatabasesBurdenOfDiseasePage().clickOnCategoryTabFromIndicatorFilter();
	}
	
	@Step
	public void verifyIfCategoryTabFromIndicatorFilterIsActive(){
		bmiDatabasesBurdenOfDiseasePage().verifyIfCategoryTabFromIndicatorFilterIsActive();
	}
	
	@Step
	public void verifyFiltersAreCleared(){
		bmiDatabasesBurdenOfDiseasePage().verifyFiltersAreCleared();
	}
	
	@Step
	public void verifyGeographyInTable(){
		bmiDatabasesBurdenOfDiseasePage().verifyGeographyInTable();
	}
	
	@Step
	public void verifyIndicatorInTable(String indicator){
		bmiDatabasesBurdenOfDiseasePage().verifyIndicatorInTable(indicator);
	}
	
	@Step
	public void verifyAgeInTable(String age){
		bmiDatabasesBurdenOfDiseasePage().verifyAgeInTable(age);
	}
	
	@Step
	public void verifyGenderInTable(String gender){
		bmiDatabasesBurdenOfDiseasePage().verifyGenderInTable(gender);
	}
	
	@Step
	public void verifyDateRangesInTable(String year){
		bmiDatabasesBurdenOfDiseasePage().verifyDateRangesInTable(year);
	}
}

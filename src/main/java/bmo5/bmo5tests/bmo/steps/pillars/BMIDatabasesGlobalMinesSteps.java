package bmo5.bmo5tests.bmo.steps.pillars;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import org.openqa.selenium.By;

import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class BMIDatabasesGlobalMinesSteps extends AbstractSteps{

	private static final long serialVersionUID = 455035537832662255L;

	@StepGroup
	public void verifyTheMetalFilter(String metal){
		verifyIfTheMetalIsUnchecked(metal);
		checkOneItemFromMetalSection(metal);
		verifyIfTheMetalIsChecked(metal);
	}
	
	@StepGroup
	public void verifyCompanyFilter(String letter){
		verifyOneLetterIsNotChecked(letter);
		checkOneLetterAndVerifyFromCompanySection(letter);
		verifyOneLetterIsChecked(letter);
	}
	
	@StepGroup
	public void verifyStatusFilter(String status){
		verifyIfThestatusIsUnChecked(returnTheStatusId(status));
		checkItemFromStatusSection(status);
		verifyIfThestatusIsChecked(returnTheStatusId(status));
	}
	
	@StepGroup
	public void verifyFiltersAfterOpeningSavedData(String metal, String letter, String status){
		if(getDriver().findElements(By.cssSelector("div#dynamic_table > div.alert.alert-info")).size() == 1){
			System.out.println("Filter button is not available. No results were found.");
		}
		else{
			verifyIfTheMetalIsChecked(metal);
			clickOnCompanyToggler();
			verifyOneLetterIsChecked(letter);
			clickOnStatusToggler();
			verifyIfThestatusIsChecked(returnTheStatusId(status));
		}
	}

	@Step
	public void checkOneItemFromMetalSection(String metal){
		bmiDatabasesGlobalMinesPage().checkOneItemFromMetalSection(metal);
	}
	
	@Step
	public void clickOnMetalToggler(){
		bmiDatabasesGlobalMinesPage().clickOnMetalToggler();
	}
	
	@Step
	public void clickOnCompanyToggler(){
		bmiDatabasesGlobalMinesPage().clickOnCompanyToggler();
	}
	
	@Step
	public void checkOneLetterAndVerifyFromCompanySection(String letter){
		bmiDatabasesGlobalMinesPage().checkOneLetterAndVerifyFromCompanySection(letter);
	}
	
	@Step
	public void verifyOneLetterIsNotChecked(String letter){
		bmiDatabasesGlobalMinesPage().verifyOneLetterIsNotChecked(letter);
	}
	
	@Step
	public void clickOnCapexToggler(){
		bmiDatabasesGlobalMinesPage().clickOnCapexToggler();
	}
	
	@Step
	public void selectCapexValue(String capexValue){
		bmiDatabasesGlobalMinesPage().selectCapexValue(capexValue);
	}
	
	@Step
	public void clickOnOreGrandeToggler(){
		bmiDatabasesGlobalMinesPage().clickOnOreGrandeToggler();
	}
	
	@Step
	public void selectOreGrandeValue(String oreGrandeValue){
		bmiDatabasesGlobalMinesPage().selectOreGrandeValue(oreGrandeValue);
	}
	
	@Step
	public void clickOnStatusToggler(){
		bmiDatabasesGlobalMinesPage().clickOnStatusToggler();
	}
	
	@Step
	public void checkItemFromStatusSection(String status){
		bmiDatabasesGlobalMinesPage().checkItemFromStatusSection(status);
	}
	
	@Step
	public String returnTheStatusId(String status){
		return bmiDatabasesGlobalMinesPage().returnTheStatusId(status);
	}
 
	@Step
	public void clickOnFilterToggler(){
		bmiDatabasesGlobalMinesPage().clickOnFilterToggler();
	}
	
	@Step
	public void verifyIfTheMetalIsChecked(String metal){
		bmiDatabasesGlobalMinesPage().verifyIfTheMetalIsChecked(metal);
	}
	
	@Step
	public void verifyIfTheMetalIsUnchecked(String metal){
		bmiDatabasesGlobalMinesPage().verifyIfTheMetalIsUnchecked(metal);
	}
	
	@Step
	public void verifyOneLetterIsChecked(String letter){
		bmiDatabasesGlobalMinesPage().verifyOneLetterIsChecked(letter);
	}
	
	@Step
	public void verifyIfThestatusIsChecked(String status){
		bmiDatabasesGlobalMinesPage().verifyIfThestatusIsChecked(status);
	}
	
	@Step
	public void verifyIfThestatusIsUnChecked(String status){
		bmiDatabasesGlobalMinesPage().verifyIfThestatusIsUnChecked(status);
	}
}

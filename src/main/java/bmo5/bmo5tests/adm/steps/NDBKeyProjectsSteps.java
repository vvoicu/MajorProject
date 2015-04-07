package bmo5.bmo5tests.adm.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class NDBKeyProjectsSteps extends AbstractAdmSteps{
	
	private static final long serialVersionUID = -4311502182016306087L;

	@StepGroup
	public void selectOptionsToFilter(String column, String operator, String dataToSearch){
		selectColumnFromDropDown(column);
		selectOperatorFromDropDown(operator);
		typeDataToSearch(dataToSearch);
	}
	
	@StepGroup
	public void verifyKeyProjectTableAndFilter(String column, String operator, String dataToSearch){
		verifyNDBKeyProjectsTableIsDisplayed();
		clickSearchIcon();
		selectOptionsToFilter(column, operator, dataToSearch);
		clickFindButton();
		clickFindButton();// table doesn't update until find button is clicked twice
		clickCloseFilterButton();
	}
	
	@Step
	public void clickSearchIcon(){
		ndbKeyProjectsPage().clickSearchIcon();
	}
	
	@Step
	public void selectColumnFromDropDown(String column){
		ndbKeyProjectsPage().selectColumnFromDropDown(column);
	}
	
	@Step
	public void selectOperatorFromDropDown(String operator){
		ndbKeyProjectsPage().selectOperatorFromDropDown(operator);
	}
	
	@Step
	public void typeDataToSearch(String dataToSearch){
		ndbKeyProjectsPage().typeDataToSearch(dataToSearch);
	}
	
	@Step
	public void verifyNDBKeyProjectsTableIsDisplayed(){
		ndbKeyProjectsPage().verifyNDBKeyProjectsTableIsDisplayed();
	}
	
	@Step
	public void clickFindButton(){
		ndbKeyProjectsPage().clickFindButton();
	}
	
	@Step
	public void clickCloseFilterButton(){
		ndbKeyProjectsPage().clickCloseFilterButton();
	}
	
	@Step
	public String getProjectNameFromFirstRow(){
		return ndbKeyProjectsPage().getProjectNameFromFirstRow();
	}
	
	@Step
	public String typeValueInUSDollarsAndPressEnter(String value, String oldValue,double newDoubleValue, double oldDoubleValue){
		return ndbKeyProjectsPage().typeValueInUSDollarsAndPressEnter(value,oldValue,newDoubleValue,oldDoubleValue);
	} 
	
	@Step
	public String getOldValue(){
		return ndbKeyProjectsPage().getOldValueUsDollars();
	}
	
	@Step
	public void typeOldValue(String oldValue){
		ndbKeyProjectsPage().typeOldValue(oldValue);
	}
}

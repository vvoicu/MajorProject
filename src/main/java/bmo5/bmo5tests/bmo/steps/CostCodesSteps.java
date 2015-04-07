package bmo5.bmo5tests.bmo.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class CostCodesSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	@StepGroup
	public void changeAndVerifyTheCostCodeName(String labelO,String labelT,String labelTh, String labelF,String newCostCode) {
		costCodesPage().changeTheCostCodesNameAndVerify(labelO,labelT,labelTh,labelF,newCostCode);
		costCodesPage().clickOnSaveButton();
		costCodesPage().verifyCosCodesNameChanges(newCostCode);
	}
	
	@StepGroup
	public void verifyResetAllAction(String message) {
		clickOnResetAllCosCodes();
		clickOnSaveCosCodes();
		costCodesPage().verifyResetAllAction(message);
	}
	
	@StepGroup
	public void verifyCostCodesEmptyFields(String button,String mandatoryCCMessage,String message) {
		selectAnyButtonToContinueOrToResetTheFields(button);
		costCodesPage().verifyCostCodesEmptyFieldsMessage(mandatoryCCMessage,message);
	}
	
	@Step
	public void selectLabelFour(String nameFour) {
		costCodesPage().selectLabelFour(nameFour);	
	}
	
	@Step
	public void selectAnyButtonToContinueOrToResetTheFields(String button) {
		costCodesPage().selectContinueOrClearAllButton(button);		
	}
	
	@Step
	public void verifyCostCodesMessage() {
		costCodesPage().showMessageCostCodes();		
	}
	
	@Step
	public void selectCostCodesFromLeftPanel(String costCodes) {
		costCodesPage().selectCostCodesFromLeftPanel(costCodes);
	}
	
	@Step
	public void clickOnResetAllCosCodes() {
		costCodesPage().resetAllCostCodes();
	}
	
	@Step
	public void clickOnSaveCosCodes() {
		costCodesPage().clickOnSaveButton();
	}
	
	@Step
	public void verifyTheCostCodeNameExistsInTheField(String nameOne,String nameTwo,String nameThree,String nameFour) {
		costCodesPage().verifyTheCostCodeNameExistsInTheField(nameOne, nameTwo, nameThree, nameFour);
	}
	
	@Step
	public void verifyUserMatchesTrialWithCostCOdes(String username) {
		costCodesPage().verifyCosCodesIsAppliedOnTrial(username);
	}
	
	@Step
	public void inputCostCodesAtLogin(String labelOneName,String labelTwoName,String labelThreeName, String labelFourName,String costCodeNameF, String costCodeNameS, String costCodeNameT, String costCodeNameFo) {
		costCodesPage().inputCostCodesNameAtLogin(labelOneName, labelTwoName, labelThreeName, labelFourName, costCodeNameF, costCodeNameS, costCodeNameT, costCodeNameFo);
	}

	@Step
	public void verifyEmptyCostCodesFields() {
		costCodesPage().verifyEmptyCostCodesFields();
		
	}
}
package bmo5.bmo5tests.adm.steps.widgets;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class KeyGlobalForecastsSteps extends AbstractAdmSteps{
	private static final long serialVersionUID = 1L;

	@StepGroup
	public void addDataClickSaveAndVerifyMessage(String inputType, String invalidData,  String inputTypeForm, String errorMessage) {
		clickDvpackIdInput(inputType);
		typeDvpackId(inputTypeForm,invalidData);
		clickSaveButton();
		verifyErrorMessage(errorMessage, inputType);
	}
	
	@StepGroup
	public void  typeInvalidDataAndVerifyErrorMessage(String errorMessage, String inputType, String inputTypeForm, String invalidData){
		typeDvpackId(inputTypeForm,invalidData);
		clickSaveButton();
		verifyErrorMessage(errorMessage, inputType);
	}
	
	@Step
	public void clickDvpackIdInput(String inputType) {
		kgfPage().clickDvpackIdInput(inputType);
	}
	
	@Step
	public void typeDvpackId(String inputTypeForm, String dvpackId){
		kgfPage().typeDvpackId(inputTypeForm, dvpackId);
	}
	
	@Step
	public void clickSaveButton(){
		kgfPage().clickSaveButton();
	}
	
	@Step
	public String getTextForDvpackIdInput(String inputType){
		return kgfPage().getTextForDvpackIdInput(inputType);
	}
	
	@Step
	public void verifyErrorMessage(String errorMessage,String inputType){
		kgfPage().verifyErrorMessage(errorMessage, inputType);
	}
	
	@Step
	public void verifyCellIsDisplayed(String inputType){
		kgfPage().verifyCellIsDisplayed(inputType);
		
	}
}

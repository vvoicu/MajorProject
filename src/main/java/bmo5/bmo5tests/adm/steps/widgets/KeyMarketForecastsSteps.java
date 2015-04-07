package bmo5.bmo5tests.adm.steps.widgets;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class KeyMarketForecastsSteps extends AbstractAdmSteps{
	private static final long serialVersionUID = -5048545187567974331L;

	@StepGroup
	public void typeSearchItemAndVerifyResults(String searchItem){
		typeSearchItem(searchItem);
		verifySearchedResults(searchItem);
	}
	
	@StepGroup
	public void typeInvalidDataSaveAndVerify(String dvpackIdInputSelector, String dvpackId, String errorMessage, String errorMessageLabel){
		kgfPage().typeDvpackId(dvpackIdInputSelector, dvpackId);
		clickOnSaveButton();
		kgfPage().verifyErrorMessage(errorMessage, errorMessageLabel);
	}
	
	@Step
	public void typeSearchItem(String searchItem){
		keyMarketForecastsPage().typeSearchItem(searchItem);
	}
	
	@Step
	public void verifySearchedResults(String searchedItem){
		keyMarketForecastsPage().verifySearchedResults(searchedItem);
	}
	
	@Step
	public void clickOnDeleteButtonVerifyAndDoAction(String action){
		keyMarketForecastsPage().clickOnDeleteButtonVerifyAndDoAction(action);
	}
	
	@Step
	public void clickOnAddRowButton(){
		keyMarketForecastsPage().clickAddRowButton();
	}
	
	@Step
	public void clickOnSaveButton(){
		keyMarketForecastsPage().clickOnSaveButton();
	}
}

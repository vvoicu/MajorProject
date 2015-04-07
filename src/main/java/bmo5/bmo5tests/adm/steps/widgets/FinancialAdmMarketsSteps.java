package bmo5.bmo5tests.adm.steps.widgets;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class FinancialAdmMarketsSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = 6536863679830688882L;

	@StepGroup
	public void selectRegionForecasts (String region) {
		financialMarketsPage().clickOnRegionName(region);
		//financialMarketsPage().clickOkTitleOption ();
		//financialMarketsPage().clickGeography();
	}
	
	@Step
	public void clickOnKeyForecasts(){
		financialMarketsPage().clickOnKeyForecasts ();
	}
	
	@Step 
	public void editKeyTitle() {
		financialMarketsPage().editRegionTitleOption ();
		//financialMarketsPage().doEditKeyTitle();
	}
	
	@Step
	public void clickOnRegionName(String region){
		financialMarketsPage().clickOnRegionName(region);
	}
	
	@Step
	public String chooseAnIndicator(String finalText, String indicator, String region){
		return financialMarketsPage().chooseAnIndicator(finalText, indicator, region);
	}
	
	@Step
	public String chooseAGeography(String region, String geography, String finalText){
		return financialMarketsPage().chooseAGeography(region, geography, finalText);
	}
	
	@Step
	public void enterADescription(String region, String description){
		financialMarketsPage().enterADescription(region, description);
	}
	
	@Step
	public void clickOnAddRowButton(String region, String indicator, String geography, String description){
		financialMarketsPage().clickOnAddRowButton(region, indicator, geography, description);
	}
	
	@Step
	public void deleteRow(String region, String indicator, String geography, String description){
		financialMarketsPage().deleteRow(region, indicator, geography, description);
	}
}
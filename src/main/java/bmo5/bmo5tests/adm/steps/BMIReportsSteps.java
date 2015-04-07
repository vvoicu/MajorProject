package bmo5.bmo5tests.adm.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class BMIReportsSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = 9072902004639009189L;

	@Step
	public void selectRegionOrCountry(String region){
		bmiReportsPage().selectRegionOrCountry(region);
	}
	
	@Step
	public void selectService(String service){
		bmiReportsPage().selectService(service);
	}
	
	@Step
	public void selectPublicationFrequency(String publicationFrequency){
		bmiReportsPage().selectPublicationFrequency(publicationFrequency);
	}
	
	@Step
	public void insertKeyword(String keyword){
		bmiReportsPage().insertKeyword(keyword);
	}
	
	@Step
	public void insertProductCode(String productCode){
		bmiReportsPage().insertProductCode(productCode);
	}
	
	@Step
	public void clickOnSearchButton(){
		bmiReportsPage().clickOnSearchButton();
	}
	
	@Step
	public void clickOnResetButtonAndVerify(){
		bmiReportsPage().clickOnResetButtonAndVerify();
	}
	
	@Step
	public String clickOnReportFromTable(int reportNumber){
		return bmiReportsPage().clickOnReportFromTable(reportNumber);
	}
	
	@Step
	public void verifyThatAllProductTitlesContainTheKeyword(String keyword){
		bmiReportsPage().verifyThatAllProductTitlesContainTheKeyword(keyword);
	}
	
	@Step
	public void verifyTheReportFromListingPage(String productCode){
		bmiReportsPage().verifyTheReportFromListingPage(productCode);
	}
}

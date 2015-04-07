package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class PDFUserLandingSteps  extends AbstractSteps{

	private static final long serialVersionUID = -882425711373065765L;

	@Step
	public void verifyPDFBreadcrumbs(String pdfBreadcrumb){
		pdfUserLandingPage().verifyPDFBreadcrumbs(pdfBreadcrumb);
	}
	
	@Step
	public void typeThreeLettersOfAReportTitle(String threeLetters, int itemNumber){
		pdfUserLandingPage().typeThreeLettersOfAReportTitleAndChooseOneItem(threeLetters, itemNumber);
	}
	
	@Step
	public String typeThreeLettersInGeographyBoxAndMoveOneItem(String threeLetters, int itemNumber){
		return pdfUserLandingPage().typeThreeLettersInGeographyBoxAndMoveOneItem(threeLetters, itemNumber);
	}
	
	@Step
	public void verifyIfGeographyIsCheckedInLHF(String geographyName){
		pdfUserLandingPage().verifyIfGeographyIsCheckedInLHF(geographyName);
	}
	
	@Step
	public void selectAllServices(){
		pdfUserLandingPage().selectAllServices();
	}
	
//	TODO fix this
//	@Step
//	public void verifyIfAllServicesAreCheckedInLHF(){
//		pdfUserLandingPage().verifyIfAllServicesAreCheckedInLHF();
//	}
	
	@Step
	public void clickOnSearchButton(){
		pdfUserLandingPage().clickOnSearchButton();
	}
	
	@Step
	public void selectAllCountries(){
		pdfUserLandingPage().selectAllCountries();
	}
//	TODO fix this
//	@Step
//	public void verifyIfAllGeographiesAreCheckedInLHF(){
//		pdfUserLandingPage().verifyIfAllGeographiesAreCheckedInLHF();
//	}
	
	@Step
	public String selectAService(int itemNumber){
		return pdfUserLandingPage().selectAService(itemNumber);
	}
	
	@Step
	public void verifyIfServiceIsCheckedInLHF(String serviceName){
		pdfUserLandingPage().verifyIfServiceIsCheckedInLHF(serviceName);
	}
	
	@Step
	public void checkDateRangeAndVerify(String dateRange){
		pdfUserLandingPage().checkDateRangeAndVerify(dateRange);
	}
	
	@Step
	public void verifyIfDateRangeIsCheckedInLHF(String dateRange){
		pdfUserLandingPage().verifyIfDateRangeIsCheckedInLHF(dateRange);
	}
	
	@Step
	public void checkSortByResultsAndVerify(String sortBy){
		pdfUserLandingPage().checkSortByResultsAndVerify(sortBy);
	}
	
	@Step
	public void verifySortBy(String sortBy){
		pdfUserLandingPage().verifySortBy(sortBy);
	}
	
	@Step
	public void enterValidStartAndEndDate(String startDate, String endDate){
		pdfUserLandingPage().enterValidStartAndEndDate(startDate, endDate);
	}
	
	@Step
	public void verifyStartDateAndEndDateFromLHF(String startDate, String endDate){
		pdfUserLandingPage().verifyStartDateAndEndDateFromLHF(startDate, endDate);
	}
	
	@StepGroup
	public void clickOnHomeBreadcrumb(String pdfBreadcrumb){
		pdfUserLandingPage().clickOnHomeBreadcrumb();
		pdfUserLandingPage().verifyPDFBreadcrumbs(pdfBreadcrumb);
	}
	
	@Step
	public void clickOnClearLinkAndVerifyTheForm(){
		pdfUserLandingPage().clickOnClearLinkAndVerifyTheForm();
	}
}

package bmo5.bmo5tests.bmo.steps.homepage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.NavigationEnum;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class SpecialReportsSteps extends AbstractSteps{

	private static final long serialVersionUID = -7501727059637553067L;

	@Step
	public void navigateLatestNews(String itemsPerPage) {
		selectItemsPerPageAndVerify(itemsPerPage);		
	}
	
	@Step
	public String clickLatestNewsArticle(int articleNumber) {
		return  specialReportsPage().clickLatestNewsArticle(articleNumber);
	}
	
	@StepGroup
	public void selectItemsPerPageAndVerify(String value) {
		 specialReportsPage().selectItemsPerPage(value);
		 specialReportsPage().verifySelectionItemsPerPage(value);
	}
	
	@Step
	public void navigateToItem(NavigationEnum value) {
		specialReportsPage().navigateToItem(value);
	}
	
	@Step
	public void navigateToItemSearchResults(NavigationEnum value) {
		specialReportsPage().navigateToItemSearchResultsPage(value);
	}
	
	@Step
	public void clickSpecialReportsup() {
		specialReportsPage().clickOnSpecialReportsup();	}
	
	@StepGroup
	public String clickSpecialReportsTopMenu(int reportNumber, String backToPreviousButon) {
		specialReportsPage().clickOnSpecialReportsTop() ;
		String reportName ="";
		reportName = specialReportsPage().selectOneReportFromDropDown(reportNumber);
		specialReportsPage().verifyActionsButtonsFromReport();
		specialReportsPage().verifyPastVersionPresenceInReport();
		specialReportsPage().backToPreviousPage(backToPreviousButon);
		return reportName;
		
	}
	
	@Step
	public void navigateToItemPDFUser(NavigationEnum goTo) {
		specialReportsPage().navigateToItemPDFUser(goTo);
	}
	
	@Step
	public void verifyMediaActionsFromPreview() {
		specialReportsPage().verifyMediaActionsFromPreview();		
	}
	
	@StepGroup
	public void accessReadButtonAndBackToPreviousButtonAndVerifyInsideActions(String readButton) {
		specialReportsPage().accessReadButtonAndBackToPreviousButtonAndVerifyInsideActions(readButton);
		specialReportsPage().verifyActionsButtonsFromReport();
	}
	
	@Step
	public void backToPreviousReportListingPage (String backToPreviousButon) {
		specialReportsPage().backToPreviousPage(backToPreviousButon);
	}
}




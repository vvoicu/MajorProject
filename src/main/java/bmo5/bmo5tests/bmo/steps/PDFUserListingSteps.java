package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class PDFUserListingSteps extends AbstractSteps{

	private static final long serialVersionUID = -3669909488651732562L;

	@Step
	public void clickOnOneReportFromListing(int reportNumber){
		pdfUserListingPage().clickOnOneReportFromListing(reportNumber);
	}
	
	@Step
	public void clickOnViewArchiveOfOneReportFromListing(int reportNumber){
		pdfUserListingPage().clickOnViewArchiveOfOneReportFromListing(reportNumber);
	}
	//TODO fix this
//	@Step
//	public void clickOnDownloadButtonOfOneItemFromViewArchivePage(int itemNumber){
//		pdfUserListingPage().clickOnDownloadButtonOfOneItemFromViewArchivePage(itemNumber);
//	}
	
	@Step
	public void selectDateRange(String dateRangeName){
		pdfUserListingPage().selectDateRange(dateRangeName);
	}
	
	@Step
	public void selectSortByResultsItem(String sortByNameItem){
		pdfUserListingPage().selectSortByResultsItem(sortByNameItem);
	}
	
	@Step
	public void selectSortByResultsOrder(String sortByNameOrder){
		pdfUserListingPage().selectSortByResultsOrder(sortByNameOrder);
	}
	
	@Step
	public void clickOnBackToPreviousPageButton(){
		pdfUserListingPage().clickOnBackToPreviousPageButton();
	}
}

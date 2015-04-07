package bmo5.bmo5tests.adm.steps.subnational;


import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class BulkUploadLogSteps extends AbstractAdmSteps{

	/**
	 * 
	 */
	private static final long serialVersionUID = -735705937021999572L;

		@Step
		public void selectItemsPerPage(String value) {
			bulkUploadLogPage().selectItemsPerPage(value);
			
		}
		
		@Step
		public Date enterStartDate(String startDateKeys) throws ParseException {
			return bulkUploadLogPage().enterStartDate(startDateKeys);
			 
		}
		
		@Step
		public Date enterEndDate(String endDateKeys) throws ParseException {
			 return bulkUploadLogPage().enterEndDate(endDateKeys);
			
		}
		
		@Step
		public void clickOnSearchButton() {
			bulkUploadLogPage().clickOnSearchButton();
			
		}
		
		@Step
		public void verifySearchResultsOnStartDate(Date simpleDate) throws ParseException {
			bulkUploadLogPage().verifySearchResultsOnStartDate(simpleDate);	
		}
		
		
		@Step
		public void verifySearchResultsOnEndDate(Date simpleDate) throws ParseException {
			bulkUploadLogPage().verifySearchResultsOnEndDate(simpleDate);	
		}
		
		@Step
		public void verifyAscendingDescending(String listSelector) throws InterruptedException {
			bulkUploadLogPage().verifyAscendingDescending(listSelector);
			
		}

//		@Step
//		public String extractReportName(){
//			return bulkUploadLogPage().extractReportName();
//		}

		@Step
		public List<String> readExcelFile(List<String> names) {
			return bulkUploadLogPage().readExcelFile(names);
		}
		
		@Step
		public List<String> clickOnDownloadAndVerify(int max) {
			return bulkUploadLogPage().clickOnDownloadAndVerify(max);
		}
		
		@Step
		public void saveImageHandleFirst() {
			bulkUploadLogPage().saveImageHandleFirst();
		}
		
		@Step
		public void saveImageHandle() {
			bulkUploadLogPage().saveImageHandle();
		}
		
		@Step
		public List<String> verifyFileName(String fileName) {
			return bulkUploadLogPage().verifyFileName(fileName);
		}
		
//		@Step
//		public void fileWriter(String content) {
//			bulkUploadLogPage().fileWriter(content);
//		}
		
		@Step
		public List<String> uploadBulkFiles() throws IOException {
			return bulkUploadLogPage().uploadBulkFiles();
		}
	
		@Step
		public void compareResults(List<String> uploaded,List<String> processed,List<String> downloaded) {
			bulkUploadLogPage().compareResults(uploaded,processed, downloaded);
		}
		
		@Step
		public void deleteDownloadedFiles(String fileName) {
			bulkUploadLogPage().deleteDownloadedFiles(fileName);
		}
}

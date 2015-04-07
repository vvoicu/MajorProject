package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class SavedReportsSteps extends AbstractSteps{

	private static final long serialVersionUID = 1085057458871310592L;

	@Step
	public String checkOneReportFromList(int reportNumber){
		return savedReportsPage().checkOneReportFromList(reportNumber);
	}
	
	@Step
	public void checkOnOneFolderFromSavedReportsList(int folderNumber){
		savedReportsPage().checkOnOneFolderFromSavedReportsList(folderNumber);
	}
	
	@Step
	public String clickOnOneReportFromList(int itemNumber){
		return savedReportsPage().clickOnOneReportFromList(itemNumber);
	}
	
	@Step
	public void verifyActionIconsAfterSelectingItems(int itemNumber){
		savedReportsPage().verifyActionIcons(itemNumber);
	}
	
	@Step
	public void deleteSelectedItems(int folderNumber, int itemNumber){
		savedReportsPage().deleteSelectedItems(folderNumber, itemNumber);
	}
	
	@Step
	public void clickOnDeleteIcon(int itemNumber, int folderNumber){
		savedReportsPage().clickOnDeleteIconThenCancel(itemNumber, folderNumber);
	}
	
	@Step
	public void moveToFolder(String folderName, int itemNumber){
		savedReportsPage().moveToFolder(folderName, itemNumber);
	}
	
	@Step
	public void moveItemsAndFoldersToFolder(String folderName, int folderNumber){
		savedReportsPage().moveItemsAndFoldersToFolder(folderName, folderNumber);
	}
	
	@Step
	public void printSelectedItem(int itemNumber){
		savedReportsPage().printSelectedItem(itemNumber);
	}
	
	@Step
	public void downloadSelectedItem(String fileName, int itemNumber){
		savedReportsPage().downloadSelectedItem(fileName, itemNumber);
	}
	
	@Step
	public void printSelectedArticleAndFolder(int itemNumber){
		savedReportsPage().printSelectedArticleAndFolder(itemNumber);
	}
	
	@Step
	public void downloadSelectedArticleAndFolder(int folderNumber){
		savedReportsPage().downloadSelectedArticleAndFolder(folderNumber);
	}
	
	@Step
	public void clickOnEmailIcon(){
		savedReportsPage().clickOnEmailIcon();
	}
	
	@Step
	public void clickOnSaveIconReport(){
		savedReportsPage().clickOnSaveIconReport();
	}
	
	@Step
	public void clickOnPrintIconReport(){
		savedReportsPage().clickOnPrintIconReport();
	}
	
	@Step
	public void clickOnDownloadIconReport(String fileName){
		savedReportsPage().clickOnDownloadIconReport(fileName);
	}
	
	@Step
	public void clickOnBackToPreviousPage(){
		savedReportsPage().clickOnBackToPreviousPage();
	}
	
	@StepGroup
	public void verifyAlphabeticalOrder(){
		savedContentPage().changeToAlphabeticalOrder();
		savedReportsPage().verifyAlphabeticalOrder();
	}
	
	@Step
	public void editFolderName(int folderNumber, String newName){
		savedReportsPage().editFolderName(folderNumber, newName);
	}
	
	@Step
	public void verifySortByDate(){
		savedReportsPage().verifySortByDate();
	}
}

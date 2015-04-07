package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class SavedArticlesSavedDataSteps extends AbstractSteps{

	private static final long serialVersionUID = 7210590358664799579L;

	@Step
	public String checkOneItemFromListing(int itemNumber) {
		return savedArticlesSavedDataPage().checkOnOneItemFromList(itemNumber);
	} 
	
	@Step
	public String clickOneItemFromListing(int itemNumber) {
		return savedArticlesSavedDataPage().clickOnOneItemFromList(itemNumber);
	} 
	
	@Step
	public int checkOneFolderFromListing(int folderNumber){
		return savedArticlesSavedDataPage().checkOnOneFolderFromList(folderNumber);
	}
	
	@Step
	public void verifyActionIconsAfterSelectingItems(){
			savedArticlesSavedDataPage().verifyActionIcons();
	}
	
	@Step
	public void deleteSelectedItems(){
		savedArticlesSavedDataPage().deleteSelectedItems();
	}
	
	@Step
	public void clickOnDeleteIcon(int itemNumber, int folderNumber){
		savedArticlesSavedDataPage().clickOnDeleteIconThenCancel(itemNumber, folderNumber);
	}
	
	@Step
	public void moveToFolder(String folderName){
		savedArticlesSavedDataPage().moveToFolder(folderName);
	}
	
	@Step
	public void moveItemsAndFoldersToFolder(String folderName, int folderNumber){
		savedArticlesSavedDataPage().moveItemsAndFoldersToFolder(folderName, folderNumber);
	}
	
	@Step
	public void printSelectedItem(){
		savedArticlesSavedDataPage().printSelectedItem();
	}
	
	@Step
	public void clickOnPrintButtonTrialUser(){
		savedArticlesSavedDataPage().clickOnPrintButtonTrialUser();
	}
	
	@Step
	public void downloadSelectedItem(String extention){
		savedArticlesSavedDataPage().downloadSelectedItem(extention);
	}
	
	@Step
	public void downloadSelectedSavedArticles(String fileName){
		savedArticlesSavedDataPage().downloadSelectedSavedArticles(fileName);
	}
	
	@Step
	public void clickOnDownloadIconTrialUser(){
		savedArticlesSavedDataPage().clickOnDownloadIconTrialUser();
	}
	
	@Step
	public void clickonDownloadIconFromSavedDataTrialUser(){
		savedArticlesSavedDataPage().clickonDownloadIconFromSavedDataTrialUser();
	}
	
	@Step
	public void printSelectedArticleAndFolder(int itemNumber){
		savedArticlesSavedDataPage().printSelectedArticleAndFolder(itemNumber);
	}
	
	@Step
	public void downloadSelectedArticleAndFolder(){
		savedArticlesSavedDataPage().downloadSelectedArticleAndFolder();
	}
	
	@Step
	public void clickOnEmailIcon(){
		savedArticlesSavedDataPage().clickOnEmailIcon();
	}
	
	@Step
	public void clickOnSaveIconReport(){
		savedArticlesSavedDataPage().clickOnSaveIconReport();
	}
	
	@Step
	public void clickOnPrintIconReport(){
		savedArticlesSavedDataPage().clickOnPrintIconReport();
	}
	
	@Step
	public void clickOnDownloadIconReport(String fileName){
		savedArticlesSavedDataPage().clickOnDownloadIconReport(fileName);
	}
	
	@Step
	public void clickOnBackToPreviousPage(){
		savedArticlesSavedDataPage().clickOnBackToPreviousPage();
	}
	
	@Step
	public void changeToAlphabeticalOrder(){
		savedContentPage().changeToAlphabeticalOrder();
		savedArticlesSavedDataPage().verifyAlphabeticalOrder();
	}
}

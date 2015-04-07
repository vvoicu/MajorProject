package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class SavedContentSteps extends AbstractSteps{
	private static final long serialVersionUID = 1L;

	@StepGroup
	public void verifySavedArticlesBreadcrumbs(String myBmoBreadcrumbs, String savedArticlesBreadcrumbs){
		homePageTopMenuPage().verifyBreadCrumb(myBmoBreadcrumbs);
		homePageTopMenuPage().verifyBreadCrumb(savedArticlesBreadcrumbs);
	}
	
	@StepGroup
	public void verifySavedReportsBreadcrumbs(String myBmoBreadcrumbs, String savedReportsBreadcrumbs){
		homePageTopMenuPage().verifyBreadCrumb(myBmoBreadcrumbs);
		homePageTopMenuPage().verifyBreadCrumb(savedReportsBreadcrumbs);
	}
	
	@StepGroup
	public void verifySavedViewsBreadcrumbs(String myBmoBreadcrumbs, String savedViewsBreadcrumbs){
		homePageTopMenuPage().verifyBreadCrumb(myBmoBreadcrumbs);
		homePageTopMenuPage().verifyBreadCrumb(savedViewsBreadcrumbs);
	}
	
	@StepGroup
	public void verifySavedSearchesBreadcrumbs(String myBmoBreadcrumbs, String savedSearchesBreadcrumbs){
		homePageTopMenuPage().verifyBreadCrumb(myBmoBreadcrumbs);
		homePageTopMenuPage().verifyBreadCrumb(savedSearchesBreadcrumbs);
	}
	
	@StepGroup
	public void verifySavedMNCBreadcrumbs(String myBmoBreadcrumbs, String savedMncBreadcrumbs){
		homePageTopMenuPage().verifyBreadCrumb(myBmoBreadcrumbs);
		homePageTopMenuPage().verifyBreadCrumb(savedMncBreadcrumbs);
	}
	
	@StepGroup
	public void verifySavedDataBreadcrumbs(String myBmoBreadcrumbs, String savedDataBreadcrumbs){
		homePageTopMenuPage().verifyBreadCrumb(myBmoBreadcrumbs);
		homePageTopMenuPage().verifyBreadCrumb(savedDataBreadcrumbs);
	}
	
	@Step
	public void verifySavedArticlesLeftPanel(){
		savedContentPage().verifyCorrectItemSavedArticlesLeftPanel();
	}
	
	@Step
	public void verifySavedReportsLeftPanel(){
		savedContentPage().verifyCorrectItemSavedReportsLeftPanel();
	}
	
	@Step
	public void verifySavedViewsLeftPanel(){
		savedContentPage().verifyCorrectItemSavedViewsLeftPanel();
	}
	
	@Step
	public void verifySavedSearchesLeftPanel(){
		savedContentPage().verifyCorrectItemSavedSearchesLeftPanel();
	}
	
	@Step
	public void verifySavedMNCLeftPanel(){
		savedContentPage().verifyCorrectItemSavedMNCLeftPanel();
	}
	
	@Step
	public void verifySavedDataLeftPanel(){
		savedContentPage().verifyCorrectItemSavedDataLeftPanel();
	}
	
	@Step
	public void clickOnSavedReportsFromLeftPanel(){
		savedContentPage().clickOnSavedReportsLeftPanel();
	}
	
	@Step
	public void clickOnSavedViewsFromLeftPanel(){
		savedContentPage().clickOnSavedViewsLeftPanel();
	}
	
	@Step
	public void clickOnSavedSearchesFromLeftPanel(){
		savedContentPage().clickOnSavedSearchesLeftPanel();
	}
	
	@Step
	public void verifyifSavedSearchesLeftPanelIsActive(){
		savedContentPage().verifyifSavedSearchesLeftPanelIsActive();
	}
	
	@Step
	public void clickOnSavedMNCFromLeftPanel(){
		savedContentPage().clickOnSavedMNCLeftPanel();
	}
	
	@Step
	public void clickOnSavedDataFromLeftPanel(){
		savedContentPage().clickOnSavedDataLeftPanel();
	}
	
	@Step
	public void navigateThroughPages(){
		savedContentPage().navigateThroughPages();
	}
	
	@Step
	public void verifyNumberOfItemsDisplayed(){
		savedContentPage().verifyNumberOfItems();
	}
	
	@Step
	public void addNewFolder(String newFolderName){
		savedContentPage().addNewFolder(newFolderName);
	}
	
	@Step
	public void verifyOrderBySavedDate(){
		savedContentPage().verifyOrderBySavedDate();
	}
	
	@Step
	public String editFolder(int folderNumber, String newFolderName){
		return savedContentPage().editFolderName(folderNumber, newFolderName);
	}
	
	@Step
	public void changeToAlphabeticalOrder(){
		savedContentPage().changeToAlphabeticalOrder();
		savedContentPage().verifyAlphabeticalOrder();
	}
	
	@Step
	public void moveFolderIntoFolder(String existingFolderName){
		savedContentPage().moveFolderIntoFolder(existingFolderName);
	}
	
	@Step
	public void verifySavedContentIsEmptySecondChildEnterpriseUser(){
		savedContentPage().verifySavedContentIsEmptySecondChildEnterpriseUser();
	}
	
	@Step
	public void deleteAllSavedContent(){
		savedContentPage().deleteAllSavedContent();
	}

	
	@Step
	public void clickLastPageAndClickNewestSavedData(String savedDataName){
		 savedContentPage().clickLastPageAndClickNewestSavedTable(savedDataName);
	}

	
	@Step
	public void verifySortByDate(){
		savedContentPage().verifySortByDate();
	}

	@Step
	public void deleteAllSavedContentMnc() {
		savedContentPage().deleteAllSavedContentMnc();
		
	}

}

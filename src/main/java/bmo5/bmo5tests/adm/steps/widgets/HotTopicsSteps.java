package bmo5.bmo5tests.adm.steps.widgets;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class HotTopicsSteps  extends AbstractAdmSteps{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Step
	public void clickOnNameColumn(){
		hotTopicsPage().clickOnNameColumn();
	}
	
	@Step
	public void clickOnTitleColumn(){
		hotTopicsPage().clickOnTitleColumn();
	}
	
	@Step
	public void clickOnStartDateColumn(){
		hotTopicsPage().clickOnStartDateColumn();
	}
	
	@Step
	public void clickOnStatusColumn(){
		hotTopicsPage().clickOnStatusColumn();
	}
	
	@Step
	public void clickOnLastUpdatedColumn(){
		hotTopicsPage().clickOnLastUpdatedColumn();
	}
	
	@Step
	public void clickOnNewHotTopicWidgetButton(){
		hotTopicsPage().clickOnNewHotTopicWidgetButton();
	}
	
	@Step
	public void navigateToNextPage(){
		hotTopicsPage().clickOnNextIcon();
	}
	
	@Step
	public void navigateToPreviousPage(){
		hotTopicsPage().clickOnPreviousIcon();
	}
	
	@Step
	public void clickOnHelpButton(){
		hotTopicsPage().clickOnHelpButton();
	}
	
	@Step
	public void closeHelpWindow(){
		hotTopicsPage().closeHelpWindow();
	}
	
	@Step
	public void clickOnNewHotTopicButton(){
		hotTopicsPage().clickOnNewHotTopicWidgetButton();
	}
	
	@Step
	public void verifyAddHotTopicPage(){
		hotTopicsPage().verifyAddHotTopicPage();
	}
	
	@Step
	public void clickOnAddButtonWithoutCompletingAnyField(){
		hotTopicsPage().clickOnAddButtonWithoutCompletingAnyField();
	}
	
	@Step
	public void clickOnAddButtonAfterTheFieldsAreCompletedWithSpaces(){
		hotTopicsPage().clickOnAddButtonAfterTheFieldsAreCompletedWithSpaces();
	}
	
	@Step
	public void completeStartAndDateWithInvalidDataClickOnAddAndVerify(String name, String title, String caption, String invalidStartDate, String invalidEndDate){
		hotTopicsPage().completeStartAndDateWithInvalidDataClickOnAddAndVerify(name, title, caption, invalidStartDate, invalidEndDate);
	}
	
	@Step
	public void clickOnResetButtonAndVerify(){
		hotTopicsPage().clickOnResetButton();
	}
	
	@Step
	public void addANewHotTopicWidgetAndVerify(String name, String title, String caption, String startDate, String endDate){
		hotTopicsPage().addANewHotTopicWidgetAndVerify(name, title, caption, startDate, endDate);
	}
	
	@Step
	public void clickOnAddNewRowButtonWithoutCompletingAnyField(){
		hotTopicsPage().clickOnSaveNewRowButtonWithoutCompletingAnyField();
	}
	
	@Step
	public void completeWithInvalidArticleIDAndClickOnSaveButton(String invalidArticleID, String bmoHeadline){
		hotTopicsPage().completeWithInvalidArticleIDAndClickOnSaveButton(invalidArticleID, bmoHeadline);
	}
	
	@Step
	public void completeWithInexistingArticleIDAndClickOnSaveButton(String inexistingArticleID, String bmoHeadline){
		hotTopicsPage().completeWithInexistingArticleIDAndClickOnSaveButton(inexistingArticleID, bmoHeadline);
	}
	
	@Step
	public void submitWithBlankBMOHeadline(String articleID){
		hotTopicsPage().submitWithBlankBMOHeadline(articleID);
	}
	
	@Step
	public void addANewArticleToTheHotTopicWidget(String articleID, String bmoHeadline){
		hotTopicsPage().addANewArticleToTheHotTopicWidget(articleID, bmoHeadline);
	}
	
	@Step
	public void removeFirstArticleFromList(){
		hotTopicsPage().removeFirstArticleFromList();
	}
	
	@Step
	public void clickOnListViewButtonAndVerify(){
		hotTopicsPage().clickOnListViewButtonAndVerify();
	}
	
	@Step
	public void clickOnOneHotTopicFromListing(String hotTopic){
		hotTopicsPage().editHotTopic(hotTopic);
	}
	
	@Step
	public void removeHotTopic(String hotTopic){
		hotTopicsPage().removeHotTopic(hotTopic);
	}
	
	@Step
	public void editWidgetPageResetFields(String newName, String newTitle, String newStartDate, String newEndDate){
		hotTopicsPage().editWidgetResetFields(newName, newTitle, newStartDate, newEndDate);
	}
	
	@Step
	public void editWidgetCompleteFieldsAndSave(String newName, String newTitle, String newStartDate, String newEndDate){
		hotTopicsPage().editWidgetCompleteFieldsAndSave(newName, newTitle, newStartDate, newEndDate);
	}
	
	@Step
	public void clearAllFieldsClickOnSaveButtonAndVerify(){
		hotTopicsPage().clearFieldsAndSaveWidget();
	}
	
	@Step
	public void clickOnSaveWidgetButtonAndVerify(){
		hotTopicsPage().clickOnSaveWidgetButtonAndVerify();
	}
	
	@Step
	public void verifyTableColumns(){
		hotTopicsPage().verifyTableColumns();
	}
	
	@Step
	public void verifyHelpModalWindowPresence(){
		hotTopicsPage().verifyHelpModalWindowPresence();
	}
	
	@Step
	public void verifyHelpModalWindowAbsence(){
		hotTopicsPage().verifyHelpModalWindowAbsence();
	}
}

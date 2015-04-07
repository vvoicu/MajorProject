package bmo5.bmo5tests.adm.steps.systemalerts;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import org.apache.commons.lang3.RandomStringUtils;

import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;
import bmo5.bmo5tests.tools.adm.SelectEnums.StatusSelect;

public class HelpSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -7062127794534708823L;

	@Step
	public void clickOnNewHelp(){
		helpPage().clickOnNewHelp();
	}

	@StepGroup
	public String createContextualHelp(String path, String content) {
		String helpName = Constants.HELP_PREFIX + RandomStringUtils.randomAlphanumeric(5);
//		createHelpPage().typeSelect(HelpType.Contextual);
		createHelpPage().pageNameInput(helpName);
		createHelpPage().pagePathInput(path);
		createHelpPage().pageContentInput(content);
		createHelpPage().statusSelect(StatusSelect.Active);
		createHelpPage().clickOnAddButton();
		return helpName;
	}
	
	@Step
	public void clickOnTypeColumnFromHeader(){
		helpPage().clickOnTypeColumnFromHeader();
	}
	
	@Step
	public void clickOnPageOrSubjectColumnFromHeader(){
		helpPage().clickOnPageOrSubjectColumnFromHeader();
	}
	
	@Step
	public void clickOnChapterColumnFromHeader(){
		helpPage().clickOnChapterColumnFromHeader();
	}
	
	@Step
	public void clickOnStatusColumnFromHeader(){
		helpPage().clickOnStatusColumnFromHeader();
	}
	
	@Step
	public void clickOnLastUpdatedColumnFromHeader(){
		helpPage().clickOnLastUpdatedColumnFromHeader();
	}
	
	@Step
	public void navigateToNextPage(){
		helpPage().navigateToNextPage();
	}
	
	@Step
	public void navigateToPreviousPage(){
		helpPage().navigateToPreviousPage();
	}
	
	@Step
	public void deleteOneItemFromListingAndVerify(String pageName){
		helpPage().deleteOneItemFromListing(pageName);
	}
	
	@Step
	public void clickOnDeleteIconOfOneElementCancelAndVerify(String name){
		helpPage().clickOnDeleteIconOfOneElementAndCancel(name);
	}
	
	@Step
	public void clickOnHelp(){
		helpPage().clickOnHelp();
	}
	
	@Step
	public void clickOnManageContentButton(){
		helpPage().clickOnManageContentButton();
	}
	
	@Step
	public void clickOnUpArrowChapter(String chapterName){
		helpPage().clickOnUpArrowChapter(chapterName);
	}
	
	@Step
	public void clickOnDownArrowChapter(String chapterName){
		helpPage().clickOnDownArrowChapter(chapterName);
	}
	
	@Step
	public void clickOnDeleteButtonThenCancel(String chapterName){
		helpPage().clickOnDeleteButtonThenCancel(chapterName);
	}
	
	@Step
	public void deleteOneChapterFromList(String chapterName){
		helpPage().deleteOneChapterFromList(chapterName);
	}
	
	@Step
	public void changeTheChaptersNameAndClickOnCancelButton(String newName, String oldName){
		helpPage().changeTheChaptersNameAndClickOnCancelButton(newName, oldName);
	}
	
	@Step
	public void changeTheChaptersNameAndClickOnUpdateButton(String newName, String oldName){
		helpPage().changeTheChaptersNameAndClickOnUpdateButton(newName, oldName);
	}
	
	@Step
	public void recordsPerPageSelect(String records){
		helpPage().recordsPerPageSelect(records);
	}
	
	@Step
	public void navigateToNextIconManageHelpContentPage(){
		helpPage().navigateToNextIconManageHelpContentPage();
	}
	
	@Step
	public void navigateToPreviousIconManageHelpContentPage(){
		helpPage().navigateToPreviousIconManageHelpContentPage();
	}
	
	@Step
	public void searchInputManageHelpContentPage(String search){
		helpPage().searchInputManageHelpContentPage(search);
	}
	
	@Step
	public void clickOnAddNewChapterButton(){
		helpPage().clickOnAddNewChapterButton();
	}
	
	@Step
	public void completeChaptersNameAndClickOnCancel(String newName){
		helpPage().completeChaptersNameAndClickOnCancel(newName);
	}
	
	@Step
	public void completeChaptersNameAndClickOnAddButton(String newName){
		helpPage().completeChaptersNameAndClickOnAddButton(newName);
	}
	
	@Step
	public void searchForSubChaptersInputManageHelpContentPage(String search){
		helpPage().searchForSubChaptersInputManageHelpContentPage(search);
	}
	
	@Step
	public void clickOnHelpButton(){
		helpPage().clickOnHelpButton();
	}
	
	@Step
	public void selectTypeMenuItem(String menu){
		helpPage().selectTypeMenuItem(menu);
	}
	
	@Step
	public void insertANameForPageNewSubChapterClickOnAddButtonAndVerify(String name){
		helpPage().insertANameForPageNewSubChapterClickOnAddButtonAndVerify(name);
	}
	
	@Step
	public void selectChapterMenuItem(String menu){
		helpPage().selectChapterMenuItem(menu);
	}
	
	@Step
	public void selectStatusMenuItem(String menu){
		helpPage().selectStatusMenuItem(menu);
	}
	
	@StepGroup
	public void completeContentBox(String content){
		helpPage().completeContentBox(content);
		createHelpPage().pageContentInput(content);
	}
	
	@Step
	public void clickOnAddNewSubChapterButton(){
		helpPage().clickOnAddNewSubChapterButton();
	}
	
	@Step
	public void clickOnAddNewSubChapterPage(){
		helpPage().clickOnAddNewSubChapterPage();
	}
	
	@Step
	public void resetFormAddingANewSubChapterAndVerify(){
		helpPage().resetFormAddingANewSubChapterAndVerify();
	}
	
	@Step
	public void completeFieldsWithValidDataClickOnAddButtonAndVerify(String type, String content, String chapter, String pageName, String status){
		helpPage().completeFieldsWithValidDataClickOnAddButtonAndVerify(type, content, chapter, pageName, status);
	}
	
	@Step
	public void clickOnListViewButton(){
		helpPage().clickOnListViewButton();
	}
	
	@Step
	public void verifyTableColumns(){
		helpPage().verifyTableColumns();
	}
}

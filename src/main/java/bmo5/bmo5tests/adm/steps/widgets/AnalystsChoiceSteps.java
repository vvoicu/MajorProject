package bmo5.bmo5tests.adm.steps.widgets;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class AnalystsChoiceSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = 3457602603953476829L;

	@Step
	public void clickOnNameColumnFromHeader(){
		analystsChoicePage().clickOnNameColumnFromHeader();
	}
	
	@Step
	public void clickOnIDColumnFromHeader(){
		analystsChoicePage().clickOnIDColumnFromHeader();
	}
	
	@Step
	public void clickOnTitleColumnFromHeader(){
		analystsChoicePage().clickOnTitleColumnFromHeader();
	}
	
	@Step
	public void clickOnLastUpdatedColumnFromHeader(){
		analystsChoicePage().clickOnLastUpdatedColumnFromHeader();
	}
	
	@Step
	public void navigateToNextPage(){
		analystsChoicePage().navigateToNextPage();
	}
	
	@Step
	public void navigateToPreviousPage(){
		analystsChoicePage().navigateToPreviousPage();
	}
	
	@Step
	public void clickOnHelpButton(){
		analystsChoicePage().clickOnHelpButton();
	}
	
	@Step
	public void clickOnAddNewWindgetButtonListingPage(){
		analystsChoicePage().clickOnAddNewWindgetButtonListingPage();
	}
	
	@Step
	public void createAnalystChoice(String name, String title, String caption, String content){
		analystsChoicePage().createAnalystChoice(name, title, caption, content);
	}
	
	@Step
	public void submitWithoutCompletingAnyField(){
		analystsChoicePage().submitWithoutCompletingAnyField();
	}
	
	@Step
	public void completeAllFieldsWithSpacesSubmitAndVerify(){
		analystsChoicePage().completeAllFieldsWithSpacesSubmitAndVerify();
	}
	
	@Step
	public void completeFieldsWithValidDataClickOnResetLinkAndVerify(String name, String title, String caption, String item){
		analystsChoicePage().completeFieldsWithValidDataClickOnResetLinkAndVerify(name, title, caption, item);
	}
	
	@Step
	public void completeFieldsWithValidDataSubmitAndVerify(String name, String title, String caption, String item){
		analystsChoicePage().completeFieldsWithValidDataSubmitAndVerify(name, title, caption, item);
	}
	
	@Step
	public void completeFieldsWithValidData(String name, String title, String caption, String contentType){
		//TODO fix this
//		analystsChoicePage().completeFieldsWithValidData(name, title, caption, contentType);
	}
	
	@Step
	public void clickOnAddNewRowButton(){
		analystsChoicePage().clickOnAddNewRowButton();
	}
	
	@Step
	public void clickOnSaveButtonWithoutCompleteTheArticleIDBox(){
		analystsChoicePage().clickOnSaveButtonWithoutCompleteTheArticleISBox();
	}
	
	@Step
	public void completeArticleIdWithInvalidDataClickOnSaveButtonAndVerify(String invalidArticleID){
		analystsChoicePage().completeArticleIdWithInvalidDataClickOnSaveButtonAndVerify(invalidArticleID);
	}
	
	@Step
	public void completeArticleIDWitInexistingValueClickOnSaveButtonAndVerify(String inexistingArticleID){
		analystsChoicePage().completeArticleIDWitInexistingValueClickOnSaveButtonAndVerify(inexistingArticleID);
	}
	
	@Step
	public void completeArticleIDWithValidDataSaveAndVerify(String articleID){
		analystsChoicePage().completeArticleIDWithValidDataSaveAndVerify(articleID);
	}
	
	@Step
	public void removeArticle(int itemNumber){
		analystsChoicePage().removeArticle(itemNumber);
	}
	
	@Step
	public void clickOnListViewButton(){
		analystsChoicePage().clickOnListViewButton();
	}
	
	@Step
	public void clickOnOneItemFromListing(String itemName){
		analystsChoicePage().clickOnOneItemFromListing(itemName);
	}
	
	@Step
	public void deleteOneItemFromListing(String itemName){
		analystsChoicePage().deleteOneItemFromListing(itemName);
	}
	
	@Step
	public void editTitle(String newTitle){
		analystsChoicePage().editTitle(newTitle);
	}
	
	@Step
	public void editWidgetEmptyFieldsSaveAndVerify(){
		analystsChoicePage().editWidgetEmptyFieldsSaveAndVerify();
	}
	
	@Step
	public void clickOnSaveButtonWithoutCompleteTheEmbeddedCodeForVideo(){
		analystsChoicePage().clickOnSaveButtonWithoutCompleteTheEmbeddedCodeForVideo();
	}
	
	@Step
	public void completeEmbeddedCodeForVideoIdWithInvalidDataClickOnSaveButtonAndVerify(String embeddedCode){
		analystsChoicePage().completeEmbeddedCodeForVideoIdWithInvalidDataClickOnSaveButtonAndVerify(embeddedCode);
	}
	
	@Step
	public void completeEmbeddedCodeForVideoWithValidDataClickOnSaveAndVerify(String embeddedCode){
		analystsChoicePage().completeEmbeddedCodeForVideoWithValidDataClcikOnSaveAndVerify(embeddedCode);
	}
	
	@Step
	public void clickOnAddNewRowVideoButton(){
		analystsChoicePage().clickOnAddNewRowVideoButton();
	}
	
	@Step
	public String getSavedTitle(){
		return analystsChoicePage().getSavedTitle();
	}
	
	@Step
	public String getSavedName(){
		return analystsChoicePage().getSavedName();
	}
	
	@Step
	public void verifyTableColumns(){
		analystsChoicePage().verifyTableColumns();
	}
}

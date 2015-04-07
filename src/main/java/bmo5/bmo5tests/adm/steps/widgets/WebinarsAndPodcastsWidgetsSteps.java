package bmo5.bmo5tests.adm.steps.widgets;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class WebinarsAndPodcastsWidgetsSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -217812948945977814L;

	@StepGroup
	public void selectTaggingOptions(String geography, String channel) {
		webinarsAndPodcastsWidgetsPage().moveAllGeographiesToRightPanel();
		webinarsAndPodcastsWidgetsPage().selectOnePRimaryGeography(geography);
		webinarsAndPodcastsWidgetsPage().moveAllServicesToRightPanel();
		webinarsAndPodcastsWidgetsPage().selectOnePrimaryChannel(channel);
		
	}
	
	@Step
	public void nagigateToNextPage(){
		webinarsAndPodcastsWidgetsPage().nagigateToNextPage();
	}
	
	@Step
	public void navigateToPreviousPage(){
		webinarsAndPodcastsWidgetsPage().navigateToPreviousPage();
	}
	
	@Step
	public void clickOnStartDateColumnFromHeader(){
		webinarsAndPodcastsWidgetsPage().clickOnStartDateColumnFromHeader();
	}
	
	@Step
	public void clickOnEndDateColumnFromHeader(){
		webinarsAndPodcastsWidgetsPage().clickOnEndDateColumnFromHeader();
	}
	
	@Step
	public void clickOnLAstUpdatedFromHeader(){
		webinarsAndPodcastsWidgetsPage().clickOnLAstUpdatedFromHeader();
	}
	
	@Step
	public void clickOnContentTypeFromHeader(){
		webinarsAndPodcastsWidgetsPage().clickOnContentTypeFromHeader();
	}
	
	@Step
	public void clickOnHelpButton(){
		webinarsAndPodcastsWidgetsPage().clickOnHelpButton();
	}
	
	@Step
	public void clickOnOneItemFromListing(String itemName){
		webinarsAndPodcastsWidgetsPage().clickOnOneItemFromListing(itemName);
	}
	
	@Step
	public void  recordsPerPageSelect(String records){
		webinarsAndPodcastsWidgetsPage().recordsPerPageSelect(records);
	}
	
	@Step
	public void updateWidgetAndVerify(String title, String shortCaption, String detailedCaption, String startDate, String endDate){
		webinarsAndPodcastsWidgetsPage().updateWidgetAndVerify(title, shortCaption, detailedCaption, startDate, endDate);
	}
	
	@Step
	public void clickOnListViewButton(){
		webinarsAndPodcastsWidgetsPage().clickOnListViewButton();
	}
	
	@Step
	public void deleteOnOneItemFromListing(String itemName){
		webinarsAndPodcastsWidgetsPage().deleteOnOneItemFromListing(itemName);
	}
	
	@Step
	public void changeTheNumberFromDropDownItems(String item){
		webinarsAndPodcastsWidgetsPage().changeTheNumberFromDropDownItems(item);
	}
	
	@Step
	public void clickOnNewButton(){
		webinarsAndPodcastsWidgetsPage().clickOnNewButton();
	}
	
	@Step
	public void clickOnSaveButtonWithoutCompletingAnyField(){
		webinarsAndPodcastsWidgetsPage().clickOnSaveButtonWithoutCompletingAnyField();
	}
	
	@Step
	public void completeAllFieldsWithSpacesSaveAndVerify(){
		webinarsAndPodcastsWidgetsPage().completeAllFieldsWithSpacesSaveAndVerify();
	}
	
	@Step
	public void completeStartAndEndDateWithInvalidDataAndVerify(String title, String shortCaption, String detailedCaption, String invalidStartDate, String invalidEndDate, String embeddedCode, String geography, String channel, String company){
		webinarsAndPodcastsWidgetsPage().completeStartAndEndDateWithInvalidDataAndVerify(title, shortCaption, detailedCaption, invalidStartDate, invalidEndDate, embeddedCode, geography, channel, company);
	}
	
	@Step
	public void completeStartDateGraterThanEndDateSaveAndVerify(String startDateGrater, String endDateSmaller){
		webinarsAndPodcastsWidgetsPage().completeStartDateGraterThanEndDateSaveAndVerify(startDateGrater, endDateSmaller);
	}
	
	@Step
	public void clickOnResetFormLinkAndVerify(){
		webinarsAndPodcastsWidgetsPage().clickOnResetFormLinkAndVerify();
	}
	
	@Step
	public void completeAllFieldsWithValidDataSaveAndVerify(String title, String shortCaption, String detailedCaption, String startDate, String endDate, String embeddedCode, String geography, String channel, String company){
		webinarsAndPodcastsWidgetsPage().completeAllFieldsWithValidDataSaveAndVerify(title, shortCaption, detailedCaption, startDate, endDate, embeddedCode, geography, channel, company);
	}
	
	@Step
	public void createPodcasts(String title, String shortCaption, String detailedCaption, String startDate, String endDate, String embeddedCodePodcast, String geography, String channel, String company){
		webinarsAndPodcastsWidgetsPage().createPodcasts(title, shortCaption, detailedCaption, startDate, endDate, embeddedCodePodcast, geography, channel, company);
	}
	
	@Step
	public void verifyTableColumns(){
		webinarsAndPodcastsWidgetsPage().verifyTableColumns();
	}
	
	@Step
	public void navigatePagesAndVerify(){
		webinarsAndPodcastsWidgetsPage().navigatePagesAndVerify();
	}
	
}

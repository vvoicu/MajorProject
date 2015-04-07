package bmo5.bmo5tests.adm.steps.widgets;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class EventsSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = 6536863679830688882L;

	@Step
	public void clickOnStartDateAndVerifyTheOrder(){
		eventsPage().clickOnStartDateAndVerifyTheOrder();
	}
	
	@Step
	public void clickOnEndDateAndVerifyTheOrder(){
		eventsPage().clickOnEndDateAndVerifyTheOrder();
	}
	
	@Step
	public void clickOnLAstUpdatedAndVerifyTheOrder(){
		eventsPage().clickOnLAstUpdatedAndVerifyTheOrder();
	}
	
	@Step
	public void clickOnHelpButton(){
		eventsPage().clickOnHelpButton();
	}
	
	@Step
	public void clickOnAddANewEventButton(){
		eventsPage().clickOnAddANewEventButton();
	}
	
	@Step
	public void submitWithoutCompletingAnyFieldAndVerify(){
		eventsPage().submitWithoutCompletingAnyFieldAndVerify();
	}
	
	@Step
	public void completeTheFieldsWithSpacesSubmitAndVerify(){
		eventsPage().completeTheFieldsWithSpacesSubmitAndVerify();
	}
	
	@Step
	public void completeDateAndTimeFieldsWithInvalidDataSubmitAndVerify(String title, String caption, String invalidStartDate, String invalidStartTime, String invalidEndDate, String invalidEndTime, String location){
		eventsPage().completeDateAndTimeFieldsWithInvalidDataSubmitAndVerify(title, caption, invalidStartDate, invalidStartTime, invalidEndDate, invalidEndTime, location);
	}
	
	@Step
	public void completeStartDateGraterThanEndDateSubmitAndVerify(String title, String caption, String startDateGrater, String startTime, String endDateSmaller, String endTime, String location){
		eventsPage().completeStartDateGraterThanEndDateSubmitAndVerify(title, caption, startDateGrater, startTime, endDateSmaller, endTime, location);
	}
	
	@Step
	public void resetAllFieldsAndVerify(){
		eventsPage().resetAllFieldsAndVerify();
	}
	
	@Step
	public void completeAllFieldsWithValidDataAndVerify(String title, String caption, String startDate, String startTime, String endDate, String endTime, String location){
		eventsPage().completeAllFieldsWithValidDataAndVerify(title, caption, startDate, startTime, endDate, endTime, location);
	}
	
	@Step
	public void clickOnListViewButtonAndVerify(){
		eventsPage().clickOnListViewButtonAndVerify();
	}
	
	@Step
	public void clickOnOneItemFromList(String eventName){
		eventsPage().clickOnOneItemFromList(eventName);
	}
	
	@Step
	public void updateAllFieldsWithValisData(String title, String caption, String startDate, String startTime, String endDate, String endTime, String location){
		eventsPage().updateAllFieldsWithValisData(title, caption, startDate, startTime, endDate, endTime, location);
	}
	
	@Step
	public void removeOneItemFromList(String eventName){
		eventsPage().removeOneItemFromList(eventName);
	}
	
	@Step
	public void verifyTableColumns(){
		eventsPage().verifyTableColumns();
	}
}

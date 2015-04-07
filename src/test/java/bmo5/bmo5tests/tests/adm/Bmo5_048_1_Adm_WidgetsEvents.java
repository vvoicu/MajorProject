package bmo5.bmo5tests.tests.adm;

import junit.framework.TestCase;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.widgets.EventsSteps;
import bmo5.bmo5tests.adm.steps.widgets.HotTopicsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Widgets.Events.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_048_1_ADM_Widgets_Events.csv", separator=',')

public class Bmo5_048_1_Adm_WidgetsEvents extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps admLoginSteps;
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	@Steps
	public EventsSteps eventsSteps;
	@Steps
	public HotTopicsSteps hotTopicsSteps;
	
	public String username, password, title, caption, location, startTime, endTime, startDate, endDate,itemsPerPage, invalidStartDate, invalidStartTime, invalidEndDate, invalidEndTime, startDateGrater, endDateSmaller, newTitle, eventsBreadcrumbs, addNewEventBreadcrumbs, editEventBreadcrumbs;
	int eventNumber;
	
	@Test
	public void bmo5_048_1_Adm_WidgetsEvents(){
		admLoginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Events);
		menuNavigationSteps.verifyBreadCrumb(eventsBreadcrumbs);
		manageWidgetsSteps.navigatePagesAndVerify();
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPage);
		eventsSteps.verifyTableColumns();
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
		
		eventsSteps.clickOnAddANewEventButton();
		menuNavigationSteps.verifyBreadCrumb(addNewEventBreadcrumbs);
		eventsSteps.submitWithoutCompletingAnyFieldAndVerify();
		eventsSteps.completeDateAndTimeFieldsWithInvalidDataSubmitAndVerify(title, caption, invalidStartDate, invalidStartTime, invalidEndDate, invalidEndTime, location);
		eventsSteps.resetAllFieldsAndVerify();
		eventsSteps.completeStartDateGraterThanEndDateSubmitAndVerify(title, caption, startDateGrater, startTime, endDateSmaller, endTime, location);
		eventsSteps.resetAllFieldsAndVerify();
		eventsSteps.completeAllFieldsWithValidDataAndVerify(title, caption, startDate, startTime, endDate, endTime, location);
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
		eventsSteps.clickOnListViewButtonAndVerify();
		
		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPage);
		eventsSteps.clickOnOneItemFromList(title);
		menuNavigationSteps.verifyBreadCrumb(editEventBreadcrumbs);
		eventsSteps.updateAllFieldsWithValisData(newTitle, caption, startDate, startTime, endDate, endTime, location);
		eventsSteps.clickOnListViewButtonAndVerify();

		manageWidgetsSteps.selectRecordsPerPageAndVerify(itemsPerPage);
		eventsSteps.removeOneItemFromList(newTitle);
	}
}

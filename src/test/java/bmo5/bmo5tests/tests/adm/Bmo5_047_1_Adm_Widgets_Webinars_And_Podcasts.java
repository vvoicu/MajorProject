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
import bmo5.bmo5tests.adm.steps.widgets.HotTopicsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.adm.steps.widgets.WebinarsAndPodcastsWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Widgets.WebinarsAndPodcasts.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_047_1_ADM_Widgets_WebinarsAndPodcasts.csv", separator=',')

public class Bmo5_047_1_Adm_Widgets_Webinars_And_Podcasts extends TestCase {
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
	public WebinarsAndPodcastsWidgetsSteps webinarsAndPodcastsSteps;
	@Steps
	public HotTopicsSteps hotTopicsSteps; 
	
	public String username, password, titleWebinar, titlePodcast, startDate, endDate,itemsPerPage, shortCaption, detailedCaption, item, invalidStartDate, invalidEndDate, embeddedCodeWebinar, geography, channel, company, startDateGrater, endDateSmaller, embeddedCodePodcast, webinarsAndPodcastsBreadcrumbs, addWebinarOrPodcastBreadcrumbs, editBreadcrumbs;
	int itemNumber;
		
	@Test
	public void bmo5_047_1_Adm_Widgets_Webinars_And_Podcasts(){
		admLoginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Webinars);
		menuNavigationSteps.verifyBreadCrumb(webinarsAndPodcastsBreadcrumbs);
		webinarsAndPodcastsSteps.navigatePagesAndVerify();
		webinarsAndPodcastsSteps.verifyTableColumns();
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
		webinarsAndPodcastsSteps.clickOnNewButton();
		menuNavigationSteps.verifyBreadCrumb(addWebinarOrPodcastBreadcrumbs);
		webinarsAndPodcastsSteps.clickOnSaveButtonWithoutCompletingAnyField();
		webinarsAndPodcastsSteps.completeAllFieldsWithSpacesSaveAndVerify();
		webinarsAndPodcastsSteps.completeStartAndEndDateWithInvalidDataAndVerify(titleWebinar, shortCaption, detailedCaption, invalidStartDate, invalidEndDate, embeddedCodeWebinar, geography, channel, company);
		webinarsAndPodcastsSteps.completeStartDateGraterThanEndDateSaveAndVerify(startDateGrater, endDateSmaller);
		webinarsAndPodcastsSteps.clickOnResetFormLinkAndVerify();
		webinarsAndPodcastsSteps.completeAllFieldsWithValidDataSaveAndVerify(titleWebinar, shortCaption, detailedCaption, startDate, endDate, embeddedCodeWebinar, geography, channel, company);
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
		webinarsAndPodcastsSteps.clickOnListViewButton();
		webinarsAndPodcastsSteps.clickOnNewButton();
		menuNavigationSteps.verifyBreadCrumb(addWebinarOrPodcastBreadcrumbs);
		webinarsAndPodcastsSteps.createPodcasts(titlePodcast, shortCaption, detailedCaption, startDate, endDate, embeddedCodePodcast, geography, channel, company); 
		hotTopicsSteps.clickOnHelpButton();
		hotTopicsSteps.verifyHelpModalWindowPresence();
		hotTopicsSteps.closeHelpWindow();
		webinarsAndPodcastsSteps.clickOnListViewButton();
		webinarsAndPodcastsSteps.recordsPerPageSelect(itemsPerPage);
		webinarsAndPodcastsSteps.clickOnOneItemFromListing(titleWebinar);
		menuNavigationSteps.verifyBreadCrumb(editBreadcrumbs);
		webinarsAndPodcastsSteps.updateWidgetAndVerify(titleWebinar, shortCaption, detailedCaption, startDate, endDate);
		webinarsAndPodcastsSteps.clickOnListViewButton();
		webinarsAndPodcastsSteps.recordsPerPageSelect(itemsPerPage);
		webinarsAndPodcastsSteps.deleteOnOneItemFromListing(titleWebinar);
		webinarsAndPodcastsSteps.recordsPerPageSelect(itemsPerPage);
		webinarsAndPodcastsSteps.deleteOnOneItemFromListing(titlePodcast);
		webinarsAndPodcastsSteps.changeTheNumberFromDropDownItems(item);
	}
}

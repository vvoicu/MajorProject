package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class WebinarsAndPodcastsSteps extends AbstractSteps{
	
	private static final long serialVersionUID = 1L;

	@Step
	public String clickOnAService(int serviceNumber){
		return webinarsAndPodcastsPage().selectService(serviceNumber);
	}
	
	@Step
	public String clickOnAGeography(int geographyNumber){
		return webinarsAndPodcastsPage().selectGeography(geographyNumber);
	}
	
	@Step
	public void clickOnTheServiceToggler(){
		webinarsAndPodcastsPage().clickOnTheServiceToggler();
	}

	//TODO fix this
//	@Step
//	public void webinarsAddToCalendar() {
//		webinarsAndPodcastsPage().webinarsAddToCalendarEvent();
//	}
//	
//	@Step
//	public void verifyWebinarBreadcrumb(String widgetName){
//		webinarsAndPodcastsPage().verifyWebinarBreadcrumb(widgetName);
//	}
//	
//	@Step
//	public void verifyTitle(String text) {
//		webinarsAndPodcastsPage().verifyTitle(text);
//	}
//	
//	@Step
//	public void verifyBreadcrumbs(String breadcrumbs){
//		webinarsAndPodcastsPage().verifyBreadcrumbs(breadcrumbs);
//	}
	
	@Step
	public String clickOnAWebinarOrPodcast(int itemNumber) {
		return webinarsAndPodcastsPage().clickOnAWebinarOrPodcast(itemNumber);
	}
	
	@Step
	public void clickOnBackToPreviousPage() {
		webinarsAndPodcastsPage().clickOnBackToPreviousPage();
	}
}

package bmo5.bmo5tests.bmo.steps.homepage;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;


public class HomeSteps extends AbstractSteps {

	private static final long serialVersionUID = 8858564152118641503L;

	@StepGroup
	public void carouselMouseOver(int element) {
		homePageHeaderPage().clickLogo();
		homePage().mouseOverCarousel();
		homePage().navigationalDots(element) ;
	}
	
	@Step
	public void keyGlobalSelectArticle() {
		homePage().keyGlobalArticles();	
	}
	
	@Step
	public void exploreKeyForecasts() {
		homePage().clickExploreButton();		
	}
	
	@Step
	public void viewAllHotTopics() {
		homePage().clickViewAllHotTopics();
	}
	
	@Step
	public void viewAllSpecialReports() {
		homePage().clickViewAllSpecialReports();
	}
	
	@Step
	public void viewAllWebinarsAndPodcasts() {
		homePage().clickViewAllWebinarsAndPodcasts();		
	}
	
	@Step
	public void verifyHomePageTitlePresenceOfButtons( String keyViews, String keyForecasts, String hotTopic, String specialReport, String webinars) {
		homePage().verifyHomePageTitlePresenceOfButtons( keyViews, keyForecasts, hotTopic, specialReport, webinars);
	}
	
	@Step
	public void verifyHomePageKeyGlobalViews(String keyGlobalViews){
		homePage().verifyHomePageKeyGlobalViews(keyGlobalViews);
	}
}
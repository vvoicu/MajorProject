package bmo5.bmo5tests.bmo.steps.homepage;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class HomePageLevelOneSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void verifyHomePage() {
		homePageLevelOnePage().verifyHomePage();
	}
	
	@StepGroup
	public void clickOnWidgetFromDropDownList(int widgetNumber){
		homePageLevelOnePage().clickOnWidgetsAndPodcasts();
		homePageLevelOnePage().clickOnWidget(widgetNumber);
	}
	
	@StepGroup
	public void clickOnPreviewWebinarOrPodcastFromDropDownList(){
		homePageLevelOnePage().clickOnWidgetsAndPodcasts();
		homePageLevelOnePage().clickOnPreviewPodcast();
		homePageLevelOnePage().closePreviewWidgetButton();
		homePageLevelOnePage().clickOnWidgetsAndPodcasts();
		homePageLevelOnePage().clickOnPreviewWebinar();
		homePageLevelOnePage().closePreviewWidgetButton();
	}
	
	@Step
	public void clickOnClosePreviewWidgetButton(){
		homePageLevelOnePage().closePreviewWidgetButton();
	}
	
	@StepGroup
	public void clickOnViewAllWidgetsAndPodcastsLink(){
		homePageLevelOnePage().clickOnWidgetsAndPodcasts();
		homePageLevelOnePage().clickOnViewAllWidgetsAndPodcasts();
	}
	
	@Step
	public String clickOnFirstArticleFromCarousel(){
		return homePageLevelOnePage().clickOnFirstArticleFromCarousel();
	}

	@Step
	public void clickOnDvPackFromCarousel(){
		homePageLevelOnePage().clickOnDvPackFromCarousel();
	}
	
	@Step
	public void clickOnCircle(int circle) {
		homePageLevelOnePage().clickOnCircle(circle);
	}
	
	@Step
	public void clickOnNextArrowFromCarousel(){
		homePageLevelOnePage().clickOnNextArrowFromCarousel();
	}
	
	@Step
	public void clickOnPreviousArrowFromCarousel(){
		homePageLevelOnePage().clickOnPreviousArrowFromCarousel();
	}
	
	@Step
	public void clickOnDvPackFromCarouselAndVerifyPermissionModal(){
		homePageLevelOnePage().clickOnDvPackFromCarouselAndVerifyPermissionModal();
	}
}

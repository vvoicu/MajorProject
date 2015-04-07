package bmo5.bmo5tests.bmo.steps.homepage;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class HomePageLevelThreeSteps extends AbstractSteps {

	private static final long serialVersionUID = 1147314629239587394L;

	@Step
	public void hotTopicsViewAll() {
		homePageLevelThreePage().hotTopicsViewAll();
	}
	
	@Step
	public void specialReportsFirstArticle() {
		homePageLevelThreePage().specialReportsFirstArticle();
	}
	
	@Step
	public void specialReportsClickOnArticle(int articleNumber) {
		homePageLevelThreePage().specialReportsClickOnArticle(articleNumber);
	}
	
	@Step
	public void specialReportsViewAll() {
		homePageLevelThreePage().specialReportsViewAll();
	}
	
	@Step
	public void webinarsAndPodcastsFirstArticle() {
		homePageLevelThreePage().webinarsAndPodcastsFirstArticle();
	}
	
	@Step
	public void webinarsAndPodcastsClickOnArticle(int articleNumber) {
		homePageLevelThreePage().webinarsAndPodcastsClickOnArticle(articleNumber);
	}
	
	@Step
	public void webinarsAndPodcastsViewAll() {
		homePageLevelThreePage().webinarsAndPodcastsViewAll();
	}
}

package bmo5.bmo5tests.bmo.steps.homepage;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class HomePageLevelTwoSteps extends AbstractSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3149913151900052327L;

	@Step
	public void viewAllKeyGlobalViews() {
		homePageLevelTwoPage().viewAllKeyGlobalViews();
	}
	
	@Step
	public void clickOnKeyGlobalViewsArticle(int article) {
		homePageLevelTwoPage().clickOnKeyGlobalViewsArticle(article);
	}
	
	@Step
	public void clickOnKeyGlobalForecasts() {
		homePageLevelTwoPage().clickOnKeyGlobalForecasts();
	}
	
	@Step
	public String clickOnArticleFromKeyGlobalViews(int articleNumber){
		return homePageLevelTwoPage().clickOnArticleFromKeyGlobalViews(articleNumber);
	}

	@Step
	public String getCellValueFromKeyGlobalForecasts(int i, int j){
		return homePageLevelTwoPage().getCellValueFromKeyGlobalForecasts(i,j);
	}
}

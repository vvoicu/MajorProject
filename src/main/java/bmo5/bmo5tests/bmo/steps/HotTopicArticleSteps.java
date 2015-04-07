package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import org.junit.Assert;

import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class HotTopicArticleSteps extends AbstractSteps {

	private static final long serialVersionUID = -3560848079630226415L;

	@StepGroup
	public void hotTopicArticleActions(int articleNumber){
		clickOnHotTopicFromHandLeftPanel(articleNumber);
		verifyHotTopicSelected(articleNumber);
	}

	@Step
	public String clickOnHotTopicFromHandLeftPanel(int articleNumber){
		return hotTopicArticlePage().clickOnHotTopicFromLeftHandPanel(articleNumber);
	}

	@Step
	public void verifyHotTopicSelected(int articleNumber){
		Assert.assertEquals(homePageTopMenuPage().clickOnHotTopicsArticle(articleNumber), hotTopicArticlePage().getTheNameOfSelectedHotTopic());
	}
	
	@Step
	public void verifyNamePageFirstHotTopic(){
		hotTopicArticlePage().verifyFirstHotTopicPageName();
	}
	
	@Step
	public String clickArticle(int articleNumber) {
		return hotTopicArticlePage().clickArticle(articleNumber);
	}
	
	@Step
	public void clickOnEmailIconArticleFromList(int articleNumber){
		hotTopicArticlePage().clickOnEmailIconArticleFromList(articleNumber);
	}
	
	@Step
	public void clickOnSaveIconArticleFromList(int articleNumber){
		hotTopicArticlePage().clickOnSaveIconArticleFromList(articleNumber);
	}
	
	@Step
	public void clickOnPrintIconArticleFromList(int articleNumber){
		hotTopicArticlePage().clickOnPrintIconArticleFromList(articleNumber);
	}
	
	//TODO fix this
//	@Step
//	public void clickOnDownloadIconArticleFromList(int articleNumber){
//		hotTopicArticlePage().clickOnDownloadIconArticleFromList(articleNumber);
//	}
	
	@Step
	public String clickOnPreviewArticle(int articleNumber){
		return hotTopicArticlePage().clickOnPreviewArticle(articleNumber);
	}
}

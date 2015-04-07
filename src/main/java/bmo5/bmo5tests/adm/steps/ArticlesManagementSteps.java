package bmo5.bmo5tests.adm.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class ArticlesManagementSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = 1887774312467195547L;

	@Step
	public void selectRegion(String region){
		articlesManagementPage().selectRegion(region);
	}
	
	@Step
	public void selectChannel(String channel){
		articlesManagementPage().selectChannel(channel);
	}
	
	@Step
	public void selectCategory(String category){
		articlesManagementPage().selectCategory(category);
	}
	
	@Step
	public void selectSource(String source){
		articlesManagementPage().selectSource(source);
	}
	
	@Step
	public void insertKeyword(String keyword){
		articlesManagementPage().insertKeyword(keyword);
	}
	
	@Step
	public void insertArticleNumber(String articleNumber){
		articlesManagementPage().insertArticleNumber(articleNumber);
	}
	
	@Step
	public void clickOnSearchButton(){
		articlesManagementPage().clickOnSearchButton();
	}
	
	@Step
	public void checkArticles(int number){
		articlesManagementPage().checkArticles(number);
	}
	
	@Step
	public void clickOnArticleManagementFromLeftSidebar(){
		articlesManagementPage().clickOnArticleManagementFromLeftSidebar();
	}
	
	@Step
	public void clickOnOpenerAndVerify(){
		articlesManagementPage().clickOnOpenerAndVerify();
	}

	@Step
	public void verifyRegionSelected(String region){
		articlesManagementPage().verifyRegionSelected(region);
	}
	
	@Step
	public void verifyChannelSelected(String channel){
		articlesManagementPage().verifyChannelSelected(channel);
	}
	
	@Step
	public void verifyCategorySelected(String category){
		articlesManagementPage().verifyCategorySelected(category);
	}
	
	@Step
	public void verifySourceSelected(String source){
		articlesManagementPage().verifySourceSelected(source);
	}
	
	@Step
	public void verifyKeyword(String keyword){
		articlesManagementPage().verifyKeyword(keyword);
	}
	
	@Step
	public void verifyArticleNumberInsideArticle(String articleNumber){
		articlesManagementPage().verifyArticleNumberInsideArticle(articleNumber);
	}
	
	@Step
	public String clickOnAnArticleFromList(int articleNumber){
		return articlesManagementPage().clickOnAnArticleFromList(articleNumber);
	}
	
	@Step
	public void verifyRegionInsideArticlePreview(String region){
		articlesManagementPage().verifyRegionInsideArticlePreview(region);
	}
	
	@Step
	public void verifyChannelInsideArticlePreview(String channel){
		articlesManagementPage().verifyChannelInsideArticlePreview(channel);
	}
	
	@Step
	public void verifyArticleTitleInsideArticlePreview(String articleTitle){
		articlesManagementPage().verifyArticleTitleInsideArticlePreview(articleTitle);
	}
	
	@Step
	public void verifyCategoryInsideArticlePreview(String category){
		articlesManagementPage().verifyCategoryInsideArticlePreview(category);
	}
	
	@Step
	public void verifyThatAllHeadersContainTheKeyword(String keyword){
		articlesManagementPage().verifyThatAllHeadersContainTheKeyword(keyword);
	}
	
	@Step
	public void clickOnLogo(){
		articlesManagementPage().clickOnLogo();
	}
}

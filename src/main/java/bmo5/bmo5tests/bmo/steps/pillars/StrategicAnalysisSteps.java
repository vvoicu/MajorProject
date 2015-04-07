package bmo5.bmo5tests.bmo.steps.pillars;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class StrategicAnalysisSteps extends AbstractSteps{

	private static final long serialVersionUID = -7548585734653030948L;

	@StepGroup
	public void selectCategoryClearfiltersAndVerifyCategoryIsDeselected(String category){
		selectCategoryFromLeftHand(category);
		dailyAnalysisAndNewsPage().clickClearFiltersAndWaitForLoadingToDisappear();
	//	verifyCategoryIsDeselected(category);
	}
	
	@StepGroup
	public void selectCategoryAndVerifyDeselectedAndNumberOfCategories(int numberOfCategories, String category,String urlBeforeClearFilters){
		verifyNumberOfCategories(numberOfCategories);
        selectCategoryClearfiltersAndVerifyCategoryIsDeselected(category);
		verifyNumberOfCategories(numberOfCategories);
		dailyAnalysisAndNewsPage().verifyURL(urlBeforeClearFilters);
	}
	
	@Step
	public void verifyArticleTitleStrategicAnalysisPage(String text){
		strategicAnalysisPage().verifyTitleStrategicAnalysisPage(text);
	}
	
	@Step
	public void clickOnDownloadIconArticleStrategicAnalysis(String fileName){
		//TODO fix this
//		strategicAnalysisPage().clickOnDownloadButtonArticleStrategicAnalysis(fileName);
	}
	
	@Step
	public void clickOnDownloadIconPreviewArticleStrategicAnalysisPage(String fileName){
		//TODO fix this
//		strategicAnalysisPage().clickOnDownloadIconPreviewArticleStrategicAnalysisPage(fileName);
	}
	
//	@Step
//	public String clickOnArchivesOfOneArticleFromList(int articleNumber, int archiveNumber){
//		//TODO fix this
////		return strategicAnalysisPage().clickOnArchivesOfOneArticleFromList(articleNumber, archiveNumber);
//	}
//	
//	@Step
//	public String clickOnRelatedContentOfOneArticleFromList(int articleNumber, int relatedContentNumber){
//		//TODO fix this
////		return strategicAnalysisPage().clickOnRelatedContentOfOneArticleFromList(articleNumber, relatedContentNumber);
//	}
	
	@Step
	public void verifyCategoryIsDeselected(String category){
		strategicAnalysisPage().verifyCategoryIsDeselected(category);
	}
	
	@Step
	public void verifyNumberOfCategories(int categoryNumber){
		strategicAnalysisPage().verifyNumberOfCategories(categoryNumber);
	}
	
	@Step
	public int getNumberOfCategories(){
		return strategicAnalysisPage().getNumberOfCategories();
	}
	
	@Step
	public void selectCategoryFromLeftHand(String category){
		strategicAnalysisPage().selectCategoryFromLeftHand(category);
	}
	
	
}

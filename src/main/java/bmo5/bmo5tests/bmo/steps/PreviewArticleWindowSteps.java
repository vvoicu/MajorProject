package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class PreviewArticleWindowSteps extends AbstractSteps{

	private static final long serialVersionUID = -129669637435510047L;

	@Step
	public void clickOnReadMoreButtonFromPreviewArticle(){
		previewArticleWindowPage().clickOnReadMoreButtonFromPreviewArticle();
	}

	@Step
	public void verifyArticleTitleFromPreviewArticleWindow(String articleTitle){
		previewArticleWindowPage().verifyArticleTitleFromPreviewArticleWindow(articleTitle);
	}

	@Step
	public void clickOnSaveIconPreviewArticle(){
		previewArticleWindowPage().clickOnSaveIconPreviewArticle();
	}

	//TODO fix this
//	@Step
//	public void clickOnPrintIconPreviewArticle(String articleName){
//		previewArticleWindowPage().clickOnPrintIconPreviewArticle(articleName);
//	}
//
//	@Step
//	public void clickOnDownloadIconPreviewArticle(String fileName){
//		previewArticleWindowPage().clickOnDownloadIconPreviewArticle(fileName);
//	}
//
//	@Step
//	public void clickOnViewFullReportIconPreviewArticle(String fileName){
//		previewArticleWindowPage().clickOnViewFullReportIconPreviewArticle(fileName);
//	}
//
//	@Step
//	public void clickOnEmailIconPreviewArticle(){
//		previewArticleWindowPage().clickOnEmailIconPreviewArticle();
//	}
//
//	@StepGroup
//	public void verifyPreviewArticleWindow(String fileName){
//		previewArticleWindowPage().verifyArticleTitleFromPreviewArticleWindow(fileName);
//		previewArticleWindowPage().clickOnSaveIconPreviewArticle();
//		previewArticleWindowPage().clickOnDownloadIconPreviewArticle(fileName);
//		previewArticleWindowPage().clickOnPrintIconPreviewArticle(fileName);
//		previewArticleWindowPage().clickOnEmailIconPreviewArticle();
//	}
//
//	@Step
//	public String getArticleNameFromPreviewWindow(){
//		return previewArticleWindowPage().getTitleArticlePreviewWindow();
//	}
//
//	@Step
//	public void clickOnSaveIconReportFromPreviewWindow(){
//		previewArticleWindowPage().clickOnSaveIconReportFromPreviewWindow();
//	}

	@Step
	public void closePreviewWindow(){
		previewArticleWindowPage().closePreviewWindow();
	}

	@Step
	public void verifyMediaActionsInsideAReport() {
		previewArticleWindowPage().verifyMediaActionsInsideAReport();		
	}

	@Step
	public void clickOnSavePreviewArticleEnterpriseUser(){
		previewArticleWindowPage().clickOnSavePreviewArticleEnterpriseUser();
	}

	//TODO fix this
//	@Step
//	public void clickOnPrintIconPreviewArticleTrialUser(){
//		previewArticleWindowPage().clickOnPrintIconPreviewArticleTrialUser();
//	}
//
//	@Step
//	public void clickOnDownloadIconPreviewArticleTrialUser(){
//		previewArticleWindowPage().clickOnDownloadIconPreviewArticleTrialUser();
//	}

	@Step
	public void clickOnViewFullReportIconPreviewArticleTrialUser(){
		previewArticleWindowPage().clickOnViewFullReportIconPreviewArticleTrialUser();
	}

	//TODO fix this
//	@Step
//	public void clickOnPrintIconPreviewReport(String reportName){
//		previewArticleWindowPage().clickOnPrintIconPreviewReport(reportName);
//	}
//	
//	@Step
//	public void clickOnDownloadIconPreviewArticleFromSearch(String fileName){
//		previewArticleWindowPage().clickOnDownloadIconPreviewArticleFromSearch(fileName);
//	}
}

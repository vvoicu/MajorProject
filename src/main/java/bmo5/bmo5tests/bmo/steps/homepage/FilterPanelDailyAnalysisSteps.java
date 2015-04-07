package bmo5.bmo5tests.bmo.steps.homepage;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;


public class FilterPanelDailyAnalysisSteps extends AbstractSteps {

	private static final long serialVersionUID = 8858564152118641503L;

	@Step
	public void selectGeographyfromPanel(String value) {
		//filterPanelDailyAnalysisPage().clickServicePanel();
		filterPanelDailyAnalysisPage().selectRegion(value) ;
	}
	
	@Step
	public void selectArticleList(String value) {
		filterPanelDailyAnalysisPage(). clickAnArticle(value);
	}
	
	@Step
	public String clickArticle(int articleNumber) {
		return filterPanelDailyAnalysisPage().clickArticle(articleNumber);
	}
	
	@Step
	public void verifyBreadCrumb(String articleTitle) {
		filterPanelDailyAnalysisPage().verifyBreadCrumb(articleTitle);
	}
	
	@Step
	public void goHome(String home) {
		filterPanelDailyAnalysisPage().clickHome(home);
	}
	
	@Step
	public void clickOnPreviewArticle(int articleNumber) {
		//filterPanelDailyAnalysisPage().clickOnPreviewArticle();
		filterPanelDailyAnalysisPage().clickOnPreviewArticle(articleNumber);
	}
	
	@Step
	public void goBackPreviousPage() {
		filterPanelDailyAnalysisPage().verifyBackPreviousPage();
	}
	
	@Step
	public void clickOnReadMore() {
		filterPanelDailyAnalysisPage().clickReadMore();
	}
	
	@Step
	public void clickOnSaveView(String name) {
		filterPanelDailyAnalysisPage().clickOnSaveView(name);		
	}
	@Step
	public void clickOnSaveViewForIpLogin() {
		filterPanelDailyAnalysisPage().clickSaveViewForIpLogin();
	}
	
	@Step
	public void saveArticleDetail() {
		filterPanelDailyAnalysisPage().saveArticleDetail();
	}
	
	@Step
	public void saveArticleAfterHover() {
		filterPanelDailyAnalysisPage().saveArticleAfterHover();
	}
	
	@Step
	public void saveFromPreviewArticle() {
		filterPanelDailyAnalysisPage().saveFromPreviewArticle();
	}
	
	@Step
	public void verifyMediaActionsFromPreview() {
	filterPanelDailyAnalysisPage().verifyMediaActionsFromPreview(); 	
	}
	
	@Step
	public void cancelEnteprisePopUpWindow() {
		filterPanelDailyAnalysisPage().cancelEnteprisePopUpWindow();		
	}
	
	@Step
	public void clickSaveViewForIpLogin(String name) {
		filterPanelDailyAnalysisPage().clickSaveViewForIpLogin();
	}
	
	@Step
	public void clickOnTags(int articleNumber) {
		filterPanelDailyAnalysisPage().selectTags(articleNumber);
	}
	
	@Step
	public void saveArticleDetailReports() {
		filterPanelDailyAnalysisPage().saveArticleDetailReports();
	}

	@Step
	public void verifyBreadcrumbServicePivot(String service) {
		filterPanelDailyAnalysisPage().verifyBreadcrumbServicePivot(service);
	}

	@Step
	public void saveMessageConfirmation() {
	filterPanelDailyAnalysisPage().saveMessageConfirmation();
		
	}

	@Step
	public void verifyPreviewMediaActions() {
		filterPanelDailyAnalysisPage().verifyPreviewMediaActions();
		
	}

	@Step
	public void verifyArticleViewMediaActions() {
		filterPanelDailyAnalysisPage().verifyArticleViewMediaActions();
		
	}

	@Step
	public void verifyOnHoveredeArticleMediaActios(int articleNumber) {
		filterPanelDailyAnalysisPage().verifyOnHoveredeArticleMediaActios(articleNumber);		
	}

	@Step
	public void selectTags(int articleNumber) {
		filterPanelDailyAnalysisPage().selectTags(articleNumber);		
	}

	@Step
	public void verifyFilterSelection(String region) {
		filterPanelDailyAnalysisPage().verifyFilterSelection(region);
		
	}
	
	@Step
	public void verifyFilterSelectionService(String service) {
		filterPanelDailyAnalysisPage().verifyFilterSelectionService(service);
		
	}
}
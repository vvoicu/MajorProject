package bmo5.bmo5tests.bmo.steps.homepage;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.NavigationItems;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class FilterPanelNewsSteps extends AbstractSteps {

	private static final long serialVersionUID = 8858564152118641503L;
	
	@Step
	public void selectPanelRegion(String value) {
		filterPanelNewsPage().selectRegion(value);
	}
	
	@Step
	public void verifyPreviousArticlebutton() {
		filterPanelNewsPage().verifyPreviousArticlebutton();
	}
	
	@Step
	public String clickLatestNewsArticle(int articleNumber) {
		return filterPanelNewsPage().clickLatestNewsArticle(articleNumber);
	}
	
	@Step
	public void clickNewsArticle() {
		filterPanelNewsPage().clickFirstArticleTitleFromList();
	}
	
	@Step
	public void selectItemsPerPage(String value) {
		 filterPanelNewsPage().selectItemsPerPage(value);
	}
	
	@Step
	public void navigateToItem(NavigationItems value) {
		filterPanelNewsPage().navigateToItem(value);
	}
	
	@Step
	public void navigateToItemMdg(NavigationItems value) {
		filterPanelNewsPage().navigateToItemMdg(value);
	}
	
	@Step
	public void navigateToItemReports(NavigationItems goTo) {
		filterPanelNewsPage().navigateToItemReports(goTo);
	}
}
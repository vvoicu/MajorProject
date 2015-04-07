package bmo5.bmo5tests.adm.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class StrategicContentCategoriesSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -6031551599887206632L;
	
	@StepGroup
	public void verifyTableColumns(){
		verifyTableIsSortedAscendingByService();
		clickOnServiceColumnFromHeader();
		verifyTableIsSortedDescendingByService();
		clickOnCategoryColumnFromHeader();
		verifyTableIsSortedAscendingByCategory();
		clickOnCategoryColumnFromHeader();
		verifyTableIsSortedDescendingByCategory();
		clickOnLastUpdatedColumnFromHeader();
		verifyTableIsSortedAscendingByLastUpdated();
		clickOnLastUpdatedColumnFromHeader();
		verifyTableIsSortedDescendingByLastUpdated();
		clickOnByWhomColumnFromHeader();
		verifyTableIsSortedAscendingByByWhom();
		clickOnByWhomColumnFromHeader();
		verifyTableIsSortedDescendingByByWhom();
	}
	
	@StepGroup
	public void moveOneCategoryToRightPanel(String category){
		enterDataInSearchInputBoxEndVerify(category);
		clickOnOneCategoryFromLeftPanel(category);
		clickOnRightArrow();
		verifyCategoryExistInRightPanel(category);
	}

	@Step
	public void verifyTableIsSortedAscendingByService(){
		strategicContentCategoriesPage().verifyTableIsSortedAscendingByService();
	}
	
	@Step
	public void clickOnServiceColumnFromHeader(){
		strategicContentCategoriesPage().clickOnServiceColumnFromHeader();
	}
	
	@Step
	public void verifyTableIsSortedDescendingByService(){
		strategicContentCategoriesPage().verifyTableIsSortedDescendingByService();
	}
	
	@Step
	public void verifyTableIsSortedAscendingByCategory(){
		strategicContentCategoriesPage().verifyTableIsSortedAscendingByCategory();
	}
	
	@Step
	public void clickOnCategoryColumnFromHeader(){
		strategicContentCategoriesPage().clickOnCategoryColumnFromHeader();
	}
	
	@Step
	public void verifyTableIsSortedDescendingByCategory(){
		strategicContentCategoriesPage().verifyTableIsSortedDescendingByCategory();
	}
	
	@Step
	public void clickOnLastUpdatedColumnFromHeader(){
		strategicContentCategoriesPage().clickOnLastUpdatedColumnFromHeader();
	}
	
	@Step
	public void verifyTableIsSortedAscendingByLastUpdated(){
		strategicContentCategoriesPage().verifyTableIsSortedAscendingByLastUpdated();
	}
	
	@Step
	public void verifyTableIsSortedDescendingByLastUpdated(){
		strategicContentCategoriesPage().verifyTableIsSortedDescendingByLastUpdated();
	}
	
	@Step
	public void verifyTableIsSortedAscendingByByWhom(){
		strategicContentCategoriesPage().verifyTableIsSortedAscendingByByWhom();
	}
	
	@Step
	public void clickOnByWhomColumnFromHeader(){
		strategicContentCategoriesPage().clickOnByWhomColumnFromHeader();
	}
	
	@Step
	public void verifyTableIsSortedDescendingByByWhom(){
		strategicContentCategoriesPage().verifyTableIsSortedDescendingByByWhom();
	}
	
	@Step
	public void verifyBreadcrumbs(){
		strategicContentCategoriesPage().verifyBreadcrumbs();
	}
	
	@Step
	public void clickOnServiceFromTableAndVerify(String service){
		strategicContentCategoriesPage().clickOnServiceFromTableAndVerify(service);
	}
	
	@Step
	public void clickOnListViewButtonAndVerify(){
		strategicContentCategoriesPage().clickOnListViewButtonAndVerify();
	}
	
	@Step
	public void clickOnCancelButtonAndVerify(){
		strategicContentCategoriesPage().clickOnCancelButtonAndVerify();
	}
	
	@Step
	public void enterDataInSearchInputBoxEndVerify(String word){
		strategicContentCategoriesPage().enterDataInSearchInputBoxEndVerify(word);
	}
	
	@Step
	public void clickOnOneCategoryFromLeftPanel(String category){
		strategicContentCategoriesPage().clickOnOneCategoryFromLeftPanel(category);
	}
	
	@Step
	public void clickOnRightArrow(){
		strategicContentCategoriesPage().clickOnRightArrow();
	}
	
	@Step
	public void verifyCategoryExistInRightPanel(String category){
		strategicContentCategoriesPage().verifyCategoryExistInRightPanel(category);
	}
	
	@Step
	public void clickOnSaveButtonAndVerify(){
		strategicContentCategoriesPage().clickOnSaveButtonAndVerify();
	}
	
	@Step
	public void clickOnDefaultView(){
		strategicContentCategoriesPage().clickOnDefaultView();
	}
	
	@Step
	public void clickOnService(){
		strategicContentCategoriesPage().clickOnService();
	}
}

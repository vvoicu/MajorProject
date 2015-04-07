package bmo5.bmo5tests.bmo.steps.pillars;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class FilterPanelSteps extends AbstractSteps {

	private static final long serialVersionUID = 8858564152118641503L;

	@StepGroup
	public void clickOnLeftPanelGeography(String continent, String country) {
		clickGeography();
		clickLevelOne(continent);
		clickLevelTwo(country);
	}
	
	@StepGroup
	public void clickOnLeftPanelService(String service, String subService) {
		clickService();
		clickLevelOne(service);
		clickLevelTwo(subService);
	}
	
	@Step
	public void clickGeography() {
		filterPanelPage().clickOnGeography();
	}
	
	@Step
	public void clickService() {
		filterPanelPage().clickOnService();
	}
	
	@Step
	public void clickLevelOne(String levelOne) {
		filterPanelPage().clickOnLeftPanelLevelOne(levelOne);
	}
	
	@Step
	public void clickLevelTwo(String levelTwo) {
		filterPanelPage().clickOnLeftPanelLevelTwo(levelTwo);
	}
	
	@Step
	public void clickOnClearFilters() {
		filterPanelPage().clearFilters();
	}
	
	@Step
	public void clickOnSaveView() {
		filterPanelPage().saveView();
	}
}

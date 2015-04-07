package bmo5.bmo5tests.bmo.steps.homepage;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class FiltersPanelGeoPivotSteps extends AbstractSteps {

	private static final long serialVersionUID = 8858564152118641503L;

	@Step
	public void checkServiceOrSubService(String service) {
		filtersPanelGeoPivotPage().selectServiceOrSubService(service);
	}
	
	@Step
	public void checkCategory(String category) {
		filtersPanelGeoPivotPage().selectCategory(category);
	}
	
	@Step
	public void verifyContent(String category, String service, String country){
		filtersPanelGeoPivotPage().verifyContent(category, service, country);
	}

	@Step
	public void verifySelectedService() {
		filtersPanelGeoPivotPage().verifySelectedService();
	}

	@Step
	public void verifySelectedCategory(String categoryId) {
		filtersPanelGeoPivotPage().verifySelectedCategory(categoryId);
		
	}

	@Step
	public void verifyClearFilterLink(String clearFilter, String all) {
		filtersPanelGeoPivotPage().verifyClearFilterLink(clearFilter,all);
		
	}
}
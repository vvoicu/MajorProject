package bmo5.bmo5tests.bmo.steps.pillars;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class ReportsSteps extends AbstractSteps {

	private static final long serialVersionUID = 8858564152118641503L;

	@StepGroup
	public void clickServiceGeographyToColapseExpandFromPanel() {
		reportsPage().clickServiceGeographyPanel();
		reportsPage().clickServiceGeographyPanel();
	}
	
	@StepGroup
	public void chooseAServiceFromLeftPanel(String service) {
		reportsPage().searchFilterServiceSection(service);
		reportsPage().panelGeographyListAndVerify(service);
		
	}
	@Step
	public void chooseAGeographyFromPanel(String element) {
		reportsPage().panelServiceGeographyListAndVerify(element);
	}
	
	@Step
	public void verifyBreadcrumbs(String breadcrumb) {
		reportsPage().verifyBreadCrumbForServicePivot(breadcrumb); 
	}
	
	@Step
	public void verifyBreadCrumb(String breadcrumb) {
		reportsPage().verifyBreadCrumb(breadcrumb);
	}

	@Step
	public void clearFilter(String clear, String all) {
		reportsPage().clearFilter(clear, all);
		
	}

//	@Step
//	public void verifyGeographyInFilter() {
//		reportsPage().verifyGeographyInFilter();
//		
//	}
}
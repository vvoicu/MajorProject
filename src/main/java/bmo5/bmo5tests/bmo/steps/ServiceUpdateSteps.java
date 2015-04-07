package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class ServiceUpdateSteps extends AbstractSteps{

	private static final long serialVersionUID = 1L;

	@Step
	public void verifyUpdates() {
		serviceUpdatePage().verifyUpdate();
	}
	
	@Step
	public void verifyNewUpdates() {
		serviceUpdatePage().verifyNewUpdate();
	}
	@Step
	public void closeServiceUpdateWindow() {
		serviceUpdatePage().closeServiceUpdate();
	}
	
}

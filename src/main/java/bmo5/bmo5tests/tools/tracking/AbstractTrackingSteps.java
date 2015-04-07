package bmo5.bmo5tests.tools.tracking;

import bmo5.bmo5tests.tracking.pages.AdmUsageReportingPage;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;


public class AbstractTrackingSteps extends ScenarioSteps {

	private static final long serialVersionUID = -8264542787518371173L;

	public AbstractTrackingSteps(Pages pages) {
		super(pages);
	}
	
	public void navigateTo(String url){
		getDriver().get(url);
	}
	
	public void reloadPage(){
		getDriver().navigate().refresh();
	}
	
	public AdmUsageReportingPage admUsageReportingPage(){
		return getPages().currentPageAt(AdmUsageReportingPage.class);
	}
	

}

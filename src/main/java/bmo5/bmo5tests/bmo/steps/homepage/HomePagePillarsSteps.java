package bmo5.bmo5tests.bmo.steps.homepage;

import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class HomePagePillarsSteps extends AbstractSteps{

	private static final long serialVersionUID = 1L;

	@StepGroup
	public String clickOnNavigationalTabByLinkTextAndVerify(String linkText){
		homePagePillarsPage().clickOnNavigationalTabByLinkTextAndVerify(linkText);
		return getDriver().getCurrentUrl();
	}
	
}

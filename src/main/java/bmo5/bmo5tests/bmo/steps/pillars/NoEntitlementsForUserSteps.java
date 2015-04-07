package bmo5.bmo5tests.bmo.steps.pillars;


import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class NoEntitlementsForUserSteps extends AbstractSteps {

	private static final long serialVersionUID = 8858564152118641503L;

	@StepGroup
	public void popUpOptionSelected() {
		noEntitlementsForUserPage().clickPopUpWindow();
	//	noEntitlementsForUserPage().clickCancelButton();
		noEntitlementsForUserPage().clickOnContactAccountManager();
	}
}
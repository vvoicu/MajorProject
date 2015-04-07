package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class AuthenticationTypesSteps extends AbstractSteps{

	private static final long serialVersionUID = 1L;

	@Step
	public void clickOnLink(String urlLink) {
		authenticationTypesPage().clickOnLink(urlLink);
	}
	
	@Step
	public void loginByForm(String formEnvironment, String username, String password) {
		authenticationTypesPage().loginByForm(formEnvironment,username,password);
	}
	
	@Step
	public void loginPageIsDisplayed() {
		authenticationTypesPage().loginPageIsDisplayed();
	}
}

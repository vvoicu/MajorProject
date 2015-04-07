package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class ForgotPasswordSteps extends AbstractSteps{

	private static final long serialVersionUID = 1L;

	@StepGroup
	public void goBackToLogin() {
		loginPage().clickForgotPassword();
		forgotPasswordPage().backToLogin();
		forgotPasswordPage().verifyLoginButtonExists();
	}
	
	@StepGroup
	public void retrievePassword(String email) {
		loginPage().clickForgotPassword();
		forgotPasswordPage().retrievePassword(email);
	}
	
	@Step
	public void verifyRetrievePassword(String validation) {
		forgotPasswordPage().verifyRetrievePassword(validation);
	}
}

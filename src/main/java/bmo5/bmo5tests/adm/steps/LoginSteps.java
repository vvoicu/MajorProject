package bmo5.bmo5tests.adm.steps;

import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class LoginSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -3234781128713122231L;

	@StepGroup
	public void performLogin(String username, String password) {
		loginPage().usernameInput(username);
		loginPage().passwordInput(password);
		loginPage().clickOnLogin();		
	}

	
}

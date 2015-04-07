package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class LoginSteps extends AbstractSteps{

	private static final long serialVersionUID = 3257791519582318360L;
	
	@StepGroup
	public void verifyPerformLogin(String placeholderEmail,String user,String placeholderPass, String pass){
		loginPage().inputUserName(placeholderEmail,user);
		loginPage().inputPassWord(placeholderPass,pass);
		loginPage().clickOnLogin();
	}
	
	@StepGroup
	public void performLogin(String user, String pass)
	{
		loginPage().inputUsername(user);
		loginPage().inputPassword(pass);
		loginPage().clickOnLogin();
	}
	
	//TODO fix this
//	@Step
//	public void verifyLogin(String validation) {
//		loginPage().verifyLogIn(validation);
//	}
	
}

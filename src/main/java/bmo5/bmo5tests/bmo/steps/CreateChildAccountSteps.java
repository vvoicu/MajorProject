package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class CreateChildAccountSteps extends AbstractSteps{

	private static final long serialVersionUID = 3257791519582318360L;
	
	@Step
	public void createChildAccountLeaveEmptyFields(){
		createChildAccountPage().createChildAccountLeaveEmptyFields();
	}
	
	@Step
	public void createChildAccountWithInvalidEmails(String invalidEmail1, String invalidEmail2, String invalidEmail3, String invalidEmail4, String invalidEmail5, String validPassword1, String firstName, String lastName){
		createChildAccountPage().createChildAccountWithInvalidEmails(invalidEmail1, invalidEmail2, invalidEmail3, invalidEmail4, invalidEmail5, validPassword1, firstName, lastName);
	}
	
	@Step
	public void createChildAccountWithNotIdenticalEmails(String validEmail1, String validEmail2){
		createChildAccountPage().createChildAccountWithNotIdenticalEmails(validEmail1, validEmail2);
	}
	
	@Step
	public void createChildAccountWithInvalidPasswords(String firstName, String lastName, String invalidPassword, String validEmail1){
		createChildAccountPage().createChildAccountWithInvalidPasswords(firstName, lastName, invalidPassword, validEmail1);
	}
	
	@Step
	public void createChildAccountWithNotIdenticalPasswords(String validPassword1, String validPassword2, String validEmail1){
		createChildAccountPage().createChildAccountWithNotIdenticalPasswords(validPassword1, validPassword2, validEmail1);
	}
	
	@Step
	public void createChildAccountWithEmailAlreadyUsed(String validPassword1, String emailAlreadyUsed, String firstName, String lastName){
		createChildAccountPage().createChildAccountWithEmailAlreadyUsed(validPassword1, emailAlreadyUsed, firstName, lastName);
	}
	
	@Step
	public String createChildAccountWithValidData(String firstName, String lastName, String validPassword1, String randomValidEmail){
		return createChildAccountPage().createChildAccountWithValidData(firstName, lastName, validPassword1, randomValidEmail);
	}
	
	@Step
	public void loginWithNewUserCreated(String password1, String randomEmail){
		createChildAccountPage().loginWithNewUserCreated(password1, randomEmail);
	}
	
	@Step
	public void verifyChildAccountIntoAdm(String randomValidEmail, String parentEmail){
		createChildAccountPage().verifyChildAccountIntoAdm(randomValidEmail, parentEmail);
	}
	
	@Step
	public void loginFromEnterprise(String username, String password){
		createChildAccountPage().loginFromEnterprise(username, password);
	}
	
	@Step
	public void logoutChild(){
		createChildAccountPage().logoutChild();
	}

	@Step
	public void logoutTheIpUser() {
		createChildAccountPage().logoutTheIpUser();
		
	}
	
	@Step
	public void verifyMessageForEnterpriseChildLoginOnBmo(String errorMessage) {
		createChildAccountPage().verifyMessageForEnterpriseChildLoginOnBmo(errorMessage);
		
	}
}

package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class EntrepriseLoginSteps extends AbstractSteps{

	private static final long serialVersionUID = 3257791519582318360L;

	@StepGroup
	public void performLogin(String user, String pass){
		entrepriseAccountPage().inputUsername(user);
		entrepriseAccountPage().inputPassword(pass);
		//entrepriseAccountPage().clickOnLogin();
		entrepriseAccountPage().clickOnLoginButton();
	}
	
	@Step
	public void verifyEntrepriseLogin(){
		entrepriseAccountPage().verifyEntreprisePage();
	}
	
	@Step
	public void verifyEntrepriseAccountSection(String enterpriseBmo){
		entrepriseAccountPage().verifyEnterpriseAccount(enterpriseBmo);
	}
	
	@Step
	public void verifyLogin(String validation) {
		if(validation.contains("correct")){ loginPage().verifyCorrectLogin(); homePageHeaderPage().clickOnLogout(); }
		else { entrepriseAccountPage().verifyWrongLogin(); }
	}

	@Step
	public void retrievePassword(String email) {
		entrepriseAccountPage().forgotPassword(email);
		
	}

	@Step
	public void verifyAccountForEnterprise(String profile, String subscription, String accountContact) {
		entrepriseAccountPage().verifyAccountForEnterprise(profile,subscription,accountContact);
	}
	
	@Step
	public void verifyBreadcrumb(String text, String textSubs, String textContactAccount) {
		entrepriseAccountPage().verifyBreadCrumb(text,textSubs,textContactAccount);		
	}
	
	@Step
	public void verifyForgotPassword(String email) {
		entrepriseAccountPage().verifyForgotPasswordlink(email);		
	}
}

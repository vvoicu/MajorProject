package bmo5.bmo5tests.tests.bmo;

import junit.framework.TestCase;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.CreateChildAccountSteps;
import bmo5.bmo5tests.adm.steps.ClientAccountsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Enterprise.Children.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enterprise_CreateChildAccount.csv", separator=',')

public class Test_001_Enterprise_CreateChildAccount extends TestCase {
	
	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST_IP)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public bmo5.bmo5tests.adm.steps.LoginSteps admLoginSteps;
	
	@Steps
	public CreateChildAccountSteps createChildAccountSteps;
	
	@Steps
	public ClientAccountsSteps clientAccountsSteps;
	
	public String message,invalidEmail1,invalidEmail2,invalidEmail3,invalidEmail4,invalidEmail5,validEmail1,validEmail2,emailAlreadyUsed,validPassword1,validPassword2,firstName,lastName,validEmail,admUsername,admPassword,parentEmail,invalidPassword,randomValidEmail, validEmailNewCreated;
		
	@Test
	public void test_001_Enterprise_CreateChildAccount() {
		createChildAccountSteps.createChildAccountLeaveEmptyFields();
		createChildAccountSteps.createChildAccountWithInvalidEmails(invalidEmail1, invalidEmail2, invalidEmail3, invalidEmail4, invalidEmail5, validPassword1, firstName, lastName);
		createChildAccountSteps.createChildAccountWithNotIdenticalEmails(validEmail1, validEmail2);
		createChildAccountSteps.createChildAccountWithNotIdenticalPasswords(validPassword1, validPassword2, validEmail);
		createChildAccountSteps.createChildAccountWithInvalidPasswords(firstName, lastName, invalidPassword, validEmail1);
		createChildAccountSteps.createChildAccountWithEmailAlreadyUsed(validPassword1, emailAlreadyUsed, firstName, lastName);
		validEmailNewCreated = createChildAccountSteps.createChildAccountWithValidData(firstName, lastName, validPassword1, randomValidEmail);
		//createChildAccountSteps.loginWithNewUserCreated(validPassword1, validEmailNewCreated);
		admLoginSteps.getDriver().get(Constants.ADM_HOST);
		admLoginSteps.performLogin(admUsername,admPassword);
		clientAccountsSteps.gotoClientAccountspage();
		clientAccountsSteps.performSearch(validEmailNewCreated);
		createChildAccountSteps.verifyChildAccountIntoAdm(validEmailNewCreated, parentEmail);
		
		loginSteps.getDriver().get(Constants.BMO_HOST_IP);
		createChildAccountSteps.logoutTheIpUser();
		loginSteps.getDriver().get(Constants.BMO_HOST);
		loginSteps.performLogin(emailAlreadyUsed, validPassword1);
		createChildAccountSteps.verifyMessageForEnterpriseChildLoginOnBmo(message);
	}
}
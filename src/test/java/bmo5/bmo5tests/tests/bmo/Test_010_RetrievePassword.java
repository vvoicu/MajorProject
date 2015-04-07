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

import bmo5.bmo5tests.bmo.steps.ForgotPasswordSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Authentication.ForgotPassword.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_010_RetrievePassword.csv", separator=',')

public class Test_010_RetrievePassword extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;
	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;
	
	@Steps
	public ForgotPasswordSteps forgotSteps;

	public String email;
	public String validation;
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void setValidation(String validation) {
		this.validation = validation;
	}

	@Test
	public void test_010_RetrievePassword() {
		forgotSteps.retrievePassword(email);
		forgotSteps.verifyRetrievePassword(validation);
		driver.get(Constants.BMO_HOST);
		forgotSteps.goBackToLogin();
	}
}
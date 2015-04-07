package bmo5.bmo5tests.tests.adm;


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
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.systemalerts.ClientUpdatesSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.SystemAlerts.ClientsUpdates.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Test_Adm_SystemAlerts_ClientsUpdates.csv", separator=',')

public class Test_Adm_SystemAlerts_ClientsUpdates extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;

	@Steps
	public MenuNavigationSteps menuNavigationSteps;

	@Steps
	public ClientUpdatesSteps clientUpdatesSteps;

	public String username, password,name, words, day,nameTwo,wordsTwo,endDay,upload,nameThree, breadcrumb;

	@Test

	public void test_Adm_SystemAlerts_ClientsUpdates(){
		loginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.SystemAlerts);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ClientsUpdates);
		clientUpdatesSteps.addNewClientUpdate(breadcrumb);
		clientUpdatesSteps.verifyNewUpdatesformAndCreateIt(name, words, day);
		clientUpdatesSteps.addNewClientUpdate(breadcrumb);
		clientUpdatesSteps.createAndVerifyStaticUpdate(nameTwo, wordsTwo, day,endDay);
		clientUpdatesSteps.addNewClientUpdate(breadcrumb);
		clientUpdatesSteps.createAlertWithImageAndPublishDate(nameThree, words, day,upload); 
	}
}
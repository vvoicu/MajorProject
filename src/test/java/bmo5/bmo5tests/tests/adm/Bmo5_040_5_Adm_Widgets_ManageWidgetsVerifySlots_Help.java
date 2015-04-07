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

import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.widgets.AddWidgetSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Widgets.ManageWidgets.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_040_5_Adm_Widgets_ManageWidgets_VerifySlots_Help.csv", separator=',')

public class Bmo5_040_5_Adm_Widgets_ManageWidgetsVerifySlots_Help extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	@Steps
	public AddWidgetSteps addWidgetSteps;
	
	public String username, password, itemsPerPage,search,area,npc,pivot,widgetype,manageWidgetsBreadcrumb,editWidgetPageBreadcrumb;
	@Test
	
	public void bmo5_040_5_Adm_Widgets_ManageWidgets_VerifySlots_Help(){
		loginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageWidgets);
		menuNavigationSteps.verifyBreadCrumb(manageWidgetsBreadcrumb);
		manageWidgetsSteps. chooseEditWidget();
		menuNavigationSteps.verifyBreadCrumb(editWidgetPageBreadcrumb);
		manageWidgetsSteps.listViewWidget();
		manageWidgetsSteps. chooseEditWidget();
		manageWidgetsSteps.addNewWidget();
		manageWidgetsSteps.chooseHelpButton();
		manageWidgetsSteps.clickPopUpClose();
		manageWidgetsSteps.listViewWidget();
		manageWidgetsSteps. chooseEditWidget();
		manageWidgetsSteps.clickHelpButton();
	}
}
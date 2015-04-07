package bmo5.bmo5tests.tests.adm;
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
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.widgets.AddWidgetSteps;
import bmo5.bmo5tests.adm.steps.widgets.AnalystsChoiceSteps;
import bmo5.bmo5tests.adm.steps.widgets.BusinessRulesWidgetsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;
import bmo5.bmo5tests.tools.adm.SelectEnums.WidgetSelect;

@Story(Application.Adm.Widgets.ManageWidgets.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_040_ADM_ManageWidgets.csv", separator=',')

public class Bmo5_040_Adm_Widgets_ManageWidgets_CreateEditDelete {
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
	@Steps
	public BusinessRulesWidgetsSteps businessRulesWidgetsSteps;
	@Steps
	public AnalystsChoiceSteps analystsChoiseSteps;
	
	public String title,pageToEdit, caption, manageWidgetsBreadcrumb,contentType,articleId, username, password, itemsPerPage,search,area,npc,pivot,widgetype,page,name,slot,cleanup, hotTopicsPageNumber;
	
	@Test
	public void bmo5_040Adm_ManageWidgets_CreateEditDelete(){
		loginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectAnalystsChoise(WidgetSelect.Analyst);
		Sleeper.sleepTight(5000);
		analystsChoiseSteps.clickOnAddNewWindgetButtonListingPage();
		analystsChoiseSteps.createAnalystChoice(name, title, caption, contentType);
		analystsChoiseSteps.clickOnAddNewRowButton();
		analystsChoiseSteps.completeArticleIDWithValidDataSaveAndVerify(articleId);
		String savedName=analystsChoiseSteps.getSavedName();
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageWidgets);
		menuNavigationSteps.verifyBreadCrumb(manageWidgetsBreadcrumb);
		manageWidgetsSteps.addWidgetOption();
		manageWidgetsSteps.selectWidgetPageOptions( widgetype+"s" , area,  page,  hotTopicsPageNumber,  pivot,  npc,  cleanup,savedName);
		manageWidgetsSteps.resetFormWidget();
		manageWidgetsSteps.clickListViewButton();
		manageWidgetsSteps.addWidgetOption();
		manageWidgetsSteps.clickAddButtonWithoutSelectingAnythingAndVerify();
		manageWidgetsSteps.selectWidgetPageOptions( widgetype+"s", area,  page,  hotTopicsPageNumber,  pivot,  npc,  cleanup, savedName);
		manageWidgetsSteps.checkOptionsSelected(npc, cleanup, area);
		if(businessRulesWidgetsSteps.checkSlotsAvailable()){
		manageWidgetsSteps.addNewWidgetButtonFromForm();
		Sleeper.sleepTight(3000);
		manageWidgetsSteps.confirmationMessageWidget();
		if(!manageWidgetsSteps.verifyIfWidgetPageRelationDoesNotExist()){
		businessRulesWidgetsSteps.searchWidgetByNameAndClickEditButton(savedName);
		manageWidgetsSteps.checkOptionsSelected(npc, cleanup, area);
		npc=manageWidgetsSteps.changeSelectedOptionsRadiobuttons(npc);
		cleanup=manageWidgetsSteps.changeSelectedOptionsRadiobuttons(cleanup);
		manageWidgetsSteps.addPageOptionToWidget(pageToEdit, hotTopicsPageNumber);
		manageWidgetsSteps.selectNPCWidget(npc);
		manageWidgetsSteps.clickOnWidgetCleanup(cleanup);
		if(businessRulesWidgetsSteps.checkSlotsAvailable()){
		manageWidgetsSteps.clickUpdateWidgetPageButton();
		Sleeper.sleepTight(3000);
		manageWidgetsSteps.confirmationMessageWidget();
		businessRulesWidgetsSteps.searchWidgetByNameAndClickEditButton(savedName);
		manageWidgetsSteps.checkOptionsSelected(npc, cleanup, area);
		}
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectAnalystsChoise(WidgetSelect.Analyst);
		businessRulesWidgetsSteps.deleteWidgetsByName(savedName);
		businessRulesWidgetsSteps.searchWidgetByNameAndVerifyDeleted(savedName);
			}
		}
	}
}

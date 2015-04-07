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
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.ADM_DvPacks_Listing_GeneralSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Create_And_Delete_CMSTemplateDvPackTableSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.DvPacks.ManageDvPacks.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_058_22_ADM_Create_And_Delete_CMSTemplateDvPackTable.csv", separator=',')

public class Bmo5_058_22_Adm_DvPacks_Create_And_Delete_CMSTemplateDvPackTable extends TestCase {

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
	public ADM_DvPacks_Listing_GeneralSteps adm_DvPacks_listingSteps;
	@Steps 
	public Create_And_Delete_CMSTemplateDvPackTableSteps create_And_Delete_CMSTemplateDvPackTableSteps;
	
	public String username, password,name,title,subtitle,description,type,year,text, databaseType, searchGeography, indicator1, indicator2, dateRangeValue, dateRanges, sectorIndicator, metalIndicator, tableMessage, deleteMessage, showNoResults, primaryGeography,primaryChannel, primaryCompany;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name+"_"+StringUtils.randomNumber(84000)+"_"+StringUtils.randomNumber(84000);
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void setYear(String year) {
		this.year = year;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}
	
	public void setIndicator1(String indicator1) {
		this.indicator1 = indicator1;
	}
	
	public void setIndicator2(String indicator2) {
		this.indicator2 = indicator2;
	}
	
	public void setMetalIndicator(String metalIndicator) {
		this.metalIndicator = metalIndicator;
	}
	
	public void setTableMessager(String tableMessage) {
		this.tableMessage = tableMessage;
	}
	
	public void setShowNoResults(String showNoResults) {
		this.showNoResults = showNoResults;
	}
	
	public void setDeleteMessage(String deleteMessage) {
		this.deleteMessage = deleteMessage;
	}
	
	@Test
	
	public void bmo5_058_22_Adm_DvPacks_Create_And_Delete_CMSTemplate_Table(){
		loginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageDVPacks);
		Sleeper.sleepTight(4000);
		adm_DvPacks_listingSteps.verifyBreadcrumbsDVPacks();
		adm_DvPacks_listingSteps.verifyColumnName();
		create_And_Delete_CMSTemplateDvPackTableSteps.displayHelpWindow();
		create_And_Delete_CMSTemplateDvPackTableSteps.createTemplateDvPackTable(name, title, subtitle, description, type, databaseType);
		create_And_Delete_CMSTemplateDvPackTableSteps.verifyBackbutton(name, title, subtitle, description, type, databaseType);
		create_And_Delete_CMSTemplateDvPackTableSteps.selectIndicators(indicator1, indicator2, dateRangeValue);
		create_And_Delete_CMSTemplateDvPackTableSteps.displayTable();
		create_And_Delete_CMSTemplateDvPackTableSteps.saveTablePreviewPage(name, title, tableMessage);
		create_And_Delete_CMSTemplateDvPackTableSteps.checkTableIntoListView(name, title, databaseType, type, deleteMessage, showNoResults);
	}
}
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
import bmo5.bmo5tests.adm.steps.dvpacks.Create_StaticDvPack_WidgetType_SelectOptionSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.DvPacks.ManageDvPacks.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_058_4_ADM_Create_StaticDvPack_WidgetType_SelectOption.csv", separator=',')

public class Bmo5_058_4_Adm_DvPacks_Create_Static_DvPack_WidgetType_SelectOption  extends TestCase {

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
	public Create_StaticDvPack_WidgetType_SelectOptionSteps create_StaticDvPack_WidgetType_SelectOptionSteps;
	
	public String username, password,name,title,subtitle,description,type,year,text, databaseType, searchGeography, indicator, dateRanges, sectorIndicator, metalIndicator, tableMessage, dvPackId;
	public String primaryGeography,primaryChannel, primaryCompany;
	
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
	
	public void setSearchGeography(String searchGeography) {
		this.searchGeography = searchGeography;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	
	public void setDateRanges(String dateRanges) {
		this.dateRanges = dateRanges;
	}
	
	public void setMetalIndicator(String metalIndicator) {
		this.metalIndicator = metalIndicator;
	}
	
	public void setTableMessager(String tableMessage) {
		this.tableMessage = tableMessage;
	}
	
	public void setPrimaryCompanyr(String primaryCompany) {
		this.primaryCompany = primaryCompany;
	}
	
	public void setPrimaryChannel(String primaryChannel) {
		this.primaryChannel = primaryChannel;
	}
	
	public void setPrimaryGeography(String primaryGeography) {
		this.primaryGeography = primaryGeography;
	}
	
	@Test
	
	public void bmo5_058_4_Adm_DvPacks_Create_Static_DvPack_WidgetType_SelectOption(){
		loginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageDVPacks);
		Sleeper.sleepTight(4000);
		adm_DvPacks_listingSteps.verifyBreadcrumbsDVPacks();
		adm_DvPacks_listingSteps.verifyColumnName();
		create_StaticDvPack_WidgetType_SelectOptionSteps.createDvPackTableLead(name, title, subtitle, description, type, databaseType);
		create_StaticDvPack_WidgetType_SelectOptionSteps.verifyStaticDvPack();
		create_StaticDvPack_WidgetType_SelectOptionSteps.selectGeography(searchGeography);
		create_StaticDvPack_WidgetType_SelectOptionSteps.selectMetalIndicator(metalIndicator);
		create_StaticDvPack_WidgetType_SelectOptionSteps.displayTable(primaryGeography,searchGeography, metalIndicator);
		create_StaticDvPack_WidgetType_SelectOptionSteps.saveDvPackTableLead(title, name, tableMessage, primaryGeography, primaryChannel, primaryCompany, searchGeography, metalIndicator);
		dvPackId = create_StaticDvPack_WidgetType_SelectOptionSteps.checkTableIntoListView(name, title, databaseType, type);
		create_StaticDvPack_WidgetType_SelectOptionSteps.deleteOneItemFromList(dvPackId);
	}
}
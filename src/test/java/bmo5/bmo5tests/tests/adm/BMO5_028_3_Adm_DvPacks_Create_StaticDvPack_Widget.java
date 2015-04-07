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
import bmo5.bmo5tests.adm.steps.dvpacks.Create_StaticDvPack_WidgetTypeSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.DvPacks.ManageDvPacks.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "BMO5_028_3_Created_Dv_Packs.csv", separator=',')

public class BMO5_028_3_Adm_DvPacks_Create_StaticDvPack_Widget extends TestCase {

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
	public Create_StaticDvPack_WidgetTypeSteps create_StaticDvPack_WidgetTypeSteps;
	
	public String username, password,name,title,subtitle,description,type,databaseType,geography,indicator,dateRanges;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}
	
	public void setSearchGeography(String geography){
		this.geography = geography;
	}
	
	public void setIndicator(String indicator){
		this.indicator = indicator;
	}
	
	public void setDateRanges(String dateRanges){
		this.dateRanges = dateRanges;
	}

	
	@Test
	public void bmo5_028_3_Adm_DvPacks_Create_StaticDvPack_Widget(){
		loginSteps.performLogin(username,password);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageDVPacks);
		Sleeper.sleepTight(4000);
		adm_DvPacks_listingSteps.verifyBreadcrumbsDVPacks();
		adm_DvPacks_listingSteps.verifyColumnName();
		
		String dvpname = name+String.valueOf(StringUtils.randomNumber(10000));
		create_StaticDvPack_WidgetTypeSteps.firstSteptoCreateaDvPack(dvpname,title,subtitle,description,type,databaseType);
		
		create_StaticDvPack_WidgetTypeSteps.verifyStaticDVPacks();
		create_StaticDvPack_WidgetTypeSteps.verifytheBackbutton (dvpname,title,subtitle,description,type,databaseType);
		create_StaticDvPack_WidgetTypeSteps.selectGeographies(geography);
		create_StaticDvPack_WidgetTypeSteps.selectIndicators(indicator);
		Sleeper.sleepTight(4000);
		create_StaticDvPack_WidgetTypeSteps.selectDatesRanges(dateRanges);
		Sleeper.sleepTight(4000);
		create_StaticDvPack_WidgetTypeSteps.selectDisplayChart(title);
		Sleeper.sleepTight(4000);
		
	}
}
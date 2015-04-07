package bmo5.bmo5tests.adm.steps.dvpacks;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;


public class Create_StaticDvPack_WidgetType_SelectOptionSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -7062127794534708823L;

	@Step
	public void displayHelpWindow(){
		create_StaticDVPack_WidgetType_SelectOptionPage().displayHelpWindow();
	}

	@Step
	public void createDvPackChartNDB(String name, String title, String subtitle, String description, String type,String databaseType){
		create_StaticDVPack_WidgetType_SelectOptionPage().createDvPackChartNDB(name, title, subtitle, description, type, databaseType);
	}
	
	@Step
	public void createDvPackTableLead(String name, String title, String subtitle, String description, String type,String databaseType){
		create_StaticDVPack_WidgetType_SelectOptionPage().createDvPackTableLead(name, title, subtitle, description, type, databaseType);
	}
	
	@Step
	public void verifyStaticDvPack() {
		create_StaticDVPack_WidgetType_SelectOptionPage().verifyStaticDvPack();
	}

	@Step
	public void verifyBackbutton(String name, String title, String subtitle, String description, String type, String databaseType) {
		create_StaticDVPack_WidgetType_SelectOptionPage().verifyBackbutton(name, title, subtitle, description, type, databaseType);
	}
	
	@Step
	public void  selectGeography(String searchGeography) {
		create_StaticDVPack_WidgetType_SelectOptionPage().selectGeography(searchGeography);
	}
	
	@Step
	public void  selectIndicator(String indicator) {
		create_StaticDVPack_WidgetType_SelectOptionPage().selectIndicator(indicator);
	}
	
	@Step
	public void  selectDateRanges(String dateRanges) {
		create_StaticDVPack_WidgetType_SelectOptionPage().selectDateRanges(dateRanges);
	}
	
	@Step
	public void  displayChart(String title) {
		create_StaticDVPack_WidgetType_SelectOptionPage().displayChart(title);
	}
	
	@Step
	public void  displaySelectWindow() {
		create_StaticDVPack_WidgetType_SelectOptionPage().displaySelectWindow();
	}
	
	@Step
	public void  selectMetalIndicator(String indicator) {
		create_StaticDVPack_WidgetType_SelectOptionPage().selectMetalIndicator(indicator);
	}
	
	@Step
	public void  displayTable(String primaryGeography, String searchGeography, String metalIndicator) {
		create_StaticDVPack_WidgetType_SelectOptionPage().displayTable(primaryGeography, searchGeography, metalIndicator);
	}
	
	@Step
	public void  saveDvPackTableLead(String title, String name, String tableMessage, String primaryGeography, String primaryChannel, String primaryCompany, String searchGeography, String metalIndicator) {
		create_StaticDVPack_WidgetType_SelectOptionPage().saveDvPackTableLead(title, name, tableMessage, primaryGeography, primaryChannel, primaryCompany, searchGeography, metalIndicator);
	}
	
	@Step
	public String checkTableIntoListView(String name, String title, String databaseType, String type) {
		return create_StaticDVPack_WidgetType_SelectOptionPage().checkTableIntoListView(name, title, databaseType, type);
	}
	
	//@Step
	//public void displaySVG() {
		//create_StaticDVPack_WidgetType_SelectOptionPage().displaySVG();
	//}
	
	@Step
	public void deleteFirstDVPackWidget(){
		create_StaticDVPack_WidgetType_SelectOptionPage().deleteFirstDVPackWidget();
	}
	
	@Step
	public void deleteOneItemFromList(String idDvPack){
		create_StaticDVPack_WidgetType_SelectOptionPage().deleteOneItemFromList(idDvPack);
	}
}
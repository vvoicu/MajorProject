package bmo5.bmo5tests.adm.steps.dvpacks;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;


public class Create_DynamicDvPackTable_WidgetTypeSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -7062127794534708823L;

	@StepGroup
	public String createDynamicDataPackDvpack(String name, String title, String database, String searchGeography, String indicator){
		 addNewDvpackButton();
	     typeNameAndTitle(name, title);
		 clickDatapackTypeRadiobutton();
		 selectDatabase(database);
		 clickContinueButton();
		 selectGeography(searchGeography);
		 selectIndicator(indicator);
		 clickDisplayDataButton();
		 clickSecondContinueButton();
		 String dvpackID="";
		 return dvpackID;
	}
	
	@Step
	public void displayHelpWindow(){
		create_DynamicDvPackTable_WidgetTypePage().displayHelpWindow();
	}
	

	@Step
	public void verifyBackbutton(String name, String title, String subtitle, String description, String type, String databaseType) {
		create_DynamicDvPackTable_WidgetTypePage().verifyBackbutton(name, title, subtitle, description, type, databaseType);
	}
	
	@Step
	public void createTemplateDvPackTable(String name, String title, String subtitle, String description, String type, String databaseType) {
		create_DynamicDvPackTable_WidgetTypePage().createTemplateDvPackTable(name, title, subtitle, description, type, databaseType);
	}
	
	@Step
	public void selectIndicator(String indicator) {
		create_DynamicDvPackTable_WidgetTypePage().selectIndicator(indicator);
	}
	
	@Step
	public void selectGeography (String searchGeography) {
		create_DynamicDvPackTable_WidgetTypePage().selectGeography (searchGeography);
	}
	
	@Step
	public void displayTable() {
		create_DynamicDvPackTable_WidgetTypePage().displayTable();
	}
	
	@Step
	public void clickDisplayDataButton() {
		create_DynamicDvPackTable_WidgetTypePage().clickDisplayDataButton();
	}
	
	@Step
	public String saveDvPackTable(String title,String name, String tableMessage, String primaryGeography, String primaryChannel, String primaryCompany, String searchGeography, String indicator) {
		return create_DynamicDvPackTable_WidgetTypePage().saveDvPackTable( title, name, tableMessage, primaryGeography,  primaryChannel,  primaryCompany,  searchGeography,  indicator);
	}
	
	@Step
	public String checkTableIntoListView(String name, String title, String databaseType, String type) {
		return create_DynamicDvPackTable_WidgetTypePage().checkTableIntoListView(name, title, databaseType, type);
	}
	
	@Step
	public void clickDatapackTypeRadiobutton(){
		create_DynamicDvPackTable_WidgetTypePage().clickDatapackTypeRadiobutton();
	}
	
	@Step
	public void selectDatabase(String database){
		create_DynamicDvPackTable_WidgetTypePage().selectDatabase(database);
	}
	
	@Step
	public void typeNameAndTitle(String name, String title){
		create_DynamicDvPackTable_WidgetTypePage().typeNameAndTitle(name, title);
	}
	
	@Step
	public void addNewDvpackButton(){
		create_DynamicDvPackTable_WidgetTypePage().addNewDvpack();
	}
	
	@Step
	public void clickContinueButton(){
		create_DynamicDvPackTable_WidgetTypePage().clickContinueButton();
	}
	
	@Step
	public void clickSecondContinueButton(){
		create_DynamicDvPackTable_WidgetTypePage().clickContinueButtonToPreviewSection();
	}
	
	@Step
	public void clickDvpackListButton(){
		create_DynamicDvPackTable_WidgetTypePage().clickDvpackList();
	}
	
	@Step
	public String getDVpackID(){
		return create_DynamicDvPackTable_WidgetTypePage().getDvpackID();
	}
}

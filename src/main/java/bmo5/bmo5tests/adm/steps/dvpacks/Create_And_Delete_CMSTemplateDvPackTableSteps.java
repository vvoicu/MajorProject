package bmo5.bmo5tests.adm.steps.dvpacks;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;


public class Create_And_Delete_CMSTemplateDvPackTableSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -7062127794534708823L;

	@Step
	public void displayHelpWindow(){
		create_And_Delete_CMSTemplateDvPackTablePage().displayHelpWindow();
	}
	

	@Step
	public void verifyBackbutton(String name, String title, String subtitle, String description, String type, String databaseType) {
		create_And_Delete_CMSTemplateDvPackTablePage().verifyBackbutton(name, title, subtitle, description, type, databaseType);
	}
	
	@Step
	public void createTemplateDvPackTable(String name, String title, String subtitle, String description, String type, String databaseType) {
		create_And_Delete_CMSTemplateDvPackTablePage().createTemplateDvPackTable(name, title, subtitle, description, type, databaseType);
	}
	
	@Step
	public void selectIndicators(String indicator1, String indicator2, String dateRangeValue) {
		create_And_Delete_CMSTemplateDvPackTablePage().selectIndicators(indicator1, indicator2, dateRangeValue);
	}
	
	@Step
	public void displayTable() {
		create_And_Delete_CMSTemplateDvPackTablePage().displayTable();
	}
	
	@Step
	public void saveTablePreviewPage(String name, String title,String tableMessage) {
		create_And_Delete_CMSTemplateDvPackTablePage().saveTablePreviewPage(name, title, tableMessage);
	}
	
	@Step
	public void checkTableIntoListView(String name,String title,String databaseType,String type, String deleteMessage, String showNoResults) {
		create_And_Delete_CMSTemplateDvPackTablePage().checkTableIntoListView(name, title, databaseType, type, deleteMessage, showNoResults);
	}
	
}
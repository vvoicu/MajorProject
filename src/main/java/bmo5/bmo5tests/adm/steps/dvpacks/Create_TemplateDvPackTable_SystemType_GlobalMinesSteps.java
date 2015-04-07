package bmo5.bmo5tests.adm.steps.dvpacks;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;


public class Create_TemplateDvPackTable_SystemType_GlobalMinesSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -7062127794534708823L;

	@Step
	public void displayHelpWindow(){
		create_TemplateDvPackTable_SystemType_GlobalMinesPage().displayHelpWindow();
	}
	

	@Step
	public void verifyBackbutton(String name, String title, String subtitle, String description, String type, String databaseType) {
		create_TemplateDvPackTable_SystemType_GlobalMinesPage().verifyBackbutton(name, title, subtitle, description, type, databaseType);
	}
	
	@Step
	public void createTemplateDvPackTable(String name, String title, String subtitle, String description, String type, String databaseType) {
		create_TemplateDvPackTable_SystemType_GlobalMinesPage().createTemplateDvPackTable(name, title, subtitle, description, type, databaseType);
	}
	
	@Step
	public void selectIndicators() {
		create_TemplateDvPackTable_SystemType_GlobalMinesPage().selectIndicators();
	}
	
	@Step
	public void displayTable() {
		create_TemplateDvPackTable_SystemType_GlobalMinesPage().displayTable();
	}
	
	@Step
	public void saveTablePreviewPage(String name, String title,String tableMessage) {
		create_TemplateDvPackTable_SystemType_GlobalMinesPage().saveTablePreviewPage(name, title, tableMessage);
	}
	
	@Step
	public void checkTableIntoListView(String name,String title,String databaseType,String type) {
		create_TemplateDvPackTable_SystemType_GlobalMinesPage().checkTableIntoListView(name, title, databaseType, type);
	}
	
}
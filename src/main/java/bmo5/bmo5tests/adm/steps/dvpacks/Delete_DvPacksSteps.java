package bmo5.bmo5tests.adm.steps.dvpacks;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;


public class Delete_DvPacksSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -7062127794534708823L;

	@Step
	public void displayHelpWindow(){
		delete_DvPacksPage().displayHelpWindow();
	}
	
	@Step
	public void searchDvPackTemplateType(String type, String deleteMessage, String showNoResults){
		delete_DvPacksPage().searchDvPackTemplateType(type, deleteMessage, showNoResults);
	}
	
	@Step
	public void deleteDvPackById(String idDvPack){
		delete_DvPacksPage().deleteDvPackById(idDvPack);
	}
}

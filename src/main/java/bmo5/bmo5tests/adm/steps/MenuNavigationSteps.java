package bmo5.bmo5tests.adm.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;
import bmo5.bmo5tests.tools.adm.SelectEnums.AnalystsChoiceContentSelect;
import bmo5.bmo5tests.tools.adm.SelectEnums.WidgetSelect;

public class MenuNavigationSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -2907965617633783143L;

	@Step
	public void admLogout(){
		menuNavigationPage().admLogout();
	}
	
	@Step
	public void selectMenuItem(AdmMenuItems menu){
		menuNavigationPage().selectMenuItem(menu);
	}
	
	@Step
	public void selectAnalystsChoise(WidgetSelect item){
		menuNavigationPage().selectAnalystChoise(item);
	}
	
	@Step
	public void selectAnalystChoiseContent(AnalystsChoiceContentSelect item){
		menuNavigationPage().selectAnalystChoiseContent(item);
	}

	@Step
	public void verifyBreadCrumb(String text) {
		menuNavigationPage().verifyBreadCrumb(text);
	}
}

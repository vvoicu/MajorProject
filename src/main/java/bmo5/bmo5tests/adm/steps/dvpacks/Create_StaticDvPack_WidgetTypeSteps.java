package bmo5.bmo5tests.adm.steps.dvpacks;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;


public class Create_StaticDvPack_WidgetTypeSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -7062127794534708823L;

	@Step
	public void firstSteptoCreateaDvPack(String dvpname, String title, String subtitle, String description, String type,String databaseType){
		create_StaticDVPack_WidgetTypePage().createDvPackFirstStep(dvpname, title, subtitle, description, type, databaseType);
	}
	
	@Step
	public void verifyStaticDVPacks() {
		create_StaticDVPack_WidgetTypePage().verifyStaticDvPack();
	}

	@Step
	public void verifytheBackbutton(String dvpname, String title, String subtitle, String description, String type, String databasetype) {
		create_StaticDVPack_WidgetTypePage().verifyBackbutton (dvpname,title,subtitle,description,type,databasetype);
	}
	
	@Step
	public void  selectGeographies(String searchGeography) {
		create_StaticDVPack_WidgetTypePage().selectGeography(searchGeography);
	}
	
	@Step
	public void  selectIndicators(String indicator) {
		create_StaticDVPack_WidgetTypePage().selectIndicator(indicator);
	}
	
	@Step
	public void  selectDatesRanges(String dateRanges) {
		create_StaticDVPack_WidgetTypePage().selectDateRanges(dateRanges);
	}
	
	@Step
	public void  selectDisplayChart(String title) {
		create_StaticDVPack_WidgetTypePage().displayChart(title);
	}
	
}
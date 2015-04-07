package bmo5.bmo5tests.adm.steps.dvpacks;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;


public class Adm_DvPacks_CreateDvPack_Custom_GeneralSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -7062127794534708823L;

	@Step
	public void firstSteptoCreateaDvPack(String name, String title, String subtitle, String description, String type){
		create_CustomDVPack_SystemTypePage().createDvPackFirstStep(name, title, subtitle, description, type);
	}
	
	@Step
	public void verifyCustomDVPacks() {
		create_CustomDVPack_SystemTypePage().verifyCustomDvPack();
	}

	@Step
	public void insertRowdata(String year, String text) {
		create_CustomDVPack_SystemTypePage().insertrawdata(year, text);
	}
	
	@Step
	public void verifyPreviewDvpack() {
		create_CustomDVPack_SystemTypePage().verifyPreviewDvpack();
	}
	
	@Step
	public void verifyAproveandContinue(String title) {
	create_CustomDVPack_SystemTypePage().aproveAndcontinue(title);
	}
	
	@Step
	public void orderColumns() {
	adm_DvPacks_listingPage().orderColumn();
	}
	
	@Step
	public void verifyCreatedDvpack(String name) {
	create_CustomDVPack_SystemTypePage().verifyCreated(name);
	}
	
	@Step
	public void clickOnContinueButtonFromEditPage(){
		create_CustomDVPack_SystemTypePage().clickOnContinueButtonFromEditPage();
	}
	
	@Step
	public void clickContinueButtonFromPreviewPage(){
		create_CustomDVPack_SystemTypePage().clickContinueButtonFromPreviewPage();
	}
	
	@Step
	public void verifyButtonsPresenceForStaticDvPAck(){
		create_CustomDVPack_SystemTypePage().verifyButtonsPresenceForCustomDvPAck();
	}
}
package bmo5.bmo5tests.adm.steps.dvpacks;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class ADM_DvPacks_GenerateDVPack_GeneralSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -7062127794534708823L;

	@StepGroup
	public void selectDvPackTypeTypeAndDefaultView(String dvPackType, String type, String defaultView){
		selectFromDropdownDvPackType(dvPackType);
		selectTypeForDvPack(type);
		selectDefaultView(defaultView);
	}
	
	@StepGroup
	public void selectDvpackType(String dvPackType, String type){
		selectFromDropdownDvPackType(dvPackType);
		selectTypeForDvPack(type);
	}
	
	@StepGroup
	public void verifyEditDvPackPage(String dvPackName, String dvPackTitle, String dvPackDescription, String dvPackTypeValue, String database, String type, String defaultView){
		verifyNameForDvPack(dvPackName);
		verifyTitleForDvPack(dvPackTitle);
		verifyDescriptionForDvPack(dvPackDescription);
		verifySelectedDvPackTypeFromDropDownList(dvPackTypeValue);
		verifySelectedDatabase(database);
		verifySelectedType(type);
		verifySelectedDefaultView(defaultView);
	}
	
	@StepGroup
	public void verifyEditDvPackPageForClone(String dvPackName, String dvPackTitle, String dvPackDescription, String dvPackTypeValue, String database, String type, String defaultView){
		verifyNameForDvPackClone(dvPackName);
		verifyTitleForDvPack(dvPackTitle);
		verifyDescriptionForDvPack(dvPackDescription);
		verifySelectedDvPackTypeFromDropDownList(dvPackTypeValue);
		verifySelectedDatabase(database);
		verifySelectedType(type);
		verifySelectedDefaultView(defaultView);
	}
	
	@StepGroup
	public void verifyTypeAndDefaultView(String type, String defaultView){
		verifySelectedType(type);
		verifySelectedDefaultView(defaultView);
	}

	@Step
	public void  selectFromDropdownDvPackType(String type) {
		adm_DvPacks_GenerateDVPack_GeneralPage().selectFromDropdownDvPackType(type);
	}

	@Step
	public void  selectADataBaseFromDropdownList(String database) {
		adm_DvPacks_GenerateDVPack_GeneralPage().selectADataBaseFromDropdownList(database);
	}
	
	@Step
	public void selectTypeForDvPack(String type){
		adm_DvPacks_GenerateDVPack_GeneralPage().selectTypeForDvPack(type);
	}
	
	@Step
	public void selectDefaultView(String defaultView) {
		adm_DvPacks_GenerateDVPack_GeneralPage().selectDefaultView(defaultView);
	}
	
	@Step
	public  String inputNameForDvPack(String dvPackname) {
		return adm_DvPacks_GenerateDVPack_GeneralPage().inputNameForDvPack(dvPackname);
	}
	
	@Step
	public  String inputDescriptionForDvPack(String dvPackDescription){
		return adm_DvPacks_GenerateDVPack_GeneralPage().inputDescriptionForDvPack(dvPackDescription);
	}
	
	@Step
	public  String inputTitleForDvPack(String dvPackTitle){
		return adm_DvPacks_GenerateDVPack_GeneralPage().inputTitleForDvPack(dvPackTitle);
	}
	
	@Step
	public void clickAndVerifyContinueButton() {
		adm_DvPacks_GenerateDVPack_GeneralPage().clickAndVerifyContinueButton();
	}
	
	@Step
	public void clickOnListViewButton() {
		adm_DvPacks_GenerateDVPack_GeneralPage().clickOnListViewButton();
	}
	
	@Step
	public void selectAnIndustryRisk(String industryType) {
		adm_DvPacks_GenerateDVPack_GeneralPage().selectIndustryTypeFromDropdown(industryType);
	}
	
	@Step
	public String inputSubTitleForDvPack(String dvPackSubTitle) {
		return adm_DvPacks_GenerateDVPack_GeneralPage().inputSubTitleForDvPack(dvPackSubTitle);
	}
	
	@Step
	public void verifySelectedType(String type) {
		adm_DvPacks_GenerateDVPack_GeneralPage().verifySelectedDvPackType(type);
	}
	
	@Step
	public void verifySelectedDefaultView(String defaultView){
		adm_DvPacks_GenerateDVPack_GeneralPage().verifySelectedDefaultView(defaultView);
	}
	
	@Step
	public void verifyChartOptionFronDefaultViewIsDisabled(){
		adm_DvPacks_GenerateDVPack_GeneralPage().verifyChartOptionFronDefaultViewIsDisabled();
	}
	
	@Step
	public void verifyNameForDvPack(String dvPackName){
		adm_DvPacks_GenerateDVPack_GeneralPage().verifyNameForDvPack(dvPackName);
	}
	
	@Step
	public void verifyDescriptionForDvPack(String dvPackDescription){
		adm_DvPacks_GenerateDVPack_GeneralPage().verifyDescriptionForDvPack(dvPackDescription);
	}
	
	@Step
	public void verifyTitleForDvPack(String dvPackTitle){
		adm_DvPacks_GenerateDVPack_GeneralPage().verifyTitleForDvPack(dvPackTitle);
	}
	
	@Step
	public void verifySubTitleForDvPack(String dvPackSubTitle){
		adm_DvPacks_GenerateDVPack_GeneralPage().verifySubTitleForDvPack(dvPackSubTitle);
	}
	
	@Step
	public void verifySelectedDatabase(String database){
		adm_DvPacks_GenerateDVPack_GeneralPage().verifySelectedDatabase(database);
	}
	
	@Step
	public void verifySelectedDvPackTypeFromDropDownList(String dvPackTypeValue){
		adm_DvPacks_GenerateDVPack_GeneralPage().verifySelectedDvPackTypeFromDropDownList(dvPackTypeValue);
	}
	
	@Step
	public String inputNameForDvPackClone(String dvPackname) {
		return adm_DvPacks_GenerateDVPack_GeneralPage().inputNameForDvPackClone(dvPackname);
	}
	
	@Step
	public void verifyNameForDvPackClone(String dvPackName){
		adm_DvPacks_GenerateDVPack_GeneralPage().verifyNameForDvPackClone(dvPackName);
	}
 }
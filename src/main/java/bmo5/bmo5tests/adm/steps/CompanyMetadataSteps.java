package bmo5.bmo5tests.adm.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class CompanyMetadataSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = 1055412875130276856L;
	
	@StepGroup
	public void deleteCompanyAndVerify(String companyName){
		deleteCompany();
		verifyCompanyIsDeleted(companyName);
	}
	
	@Step
	public void clickOnNewButtonAndVerify(){
		companyMetadataPage().clickOnNewButtonAndVerify();
	}
	
	@Step
	public void clickOnSaveWithoutCompletingTheFormAndVerify(){
		companyMetadataPage().clickOnSaveWithoutCompletingTheFormAndVerify();
	}
	
	@Step
	public void clickOnResetButton(){
		companyMetadataPage().clickOnResetButton();
	}

	@Step
	public String completeTheFormWithDataAndSave(String companyName, String state, String nationlity, String service){
		return companyMetadataPage().completeTheFormWithDataAndSave(companyName, state, nationlity, service);
	}
	
	@Step
	public void insertCompanyNameInsearchInput(String companyName){
		companyMetadataPage().insertCompanyNameInsearchInput(companyName);
	}
	
	@Step
	public void selectOneCompany(String companyName){
		companyMetadataPage().selectOneCompany(companyName);
	}
	
	@Step
	public void verifyCompanyData(String companyName, String state, String nationality, String service){
		companyMetadataPage().verifyCompanyData(companyName, state, nationality, service);
	}
	
	@Step
	public void deleteCompany(){
		companyMetadataPage().deleteCompany();
	}
	
	@Step
	public void verifyCompanyIsDeleted(String companyName){
		companyMetadataPage().verifyCompanyIsDeleted(companyName);
	}
	
	@Step
	public void verifyPageTitle(String pageTitle){
		companyMetadataPage().verifyPageTitle(pageTitle);
	}
	
	@Step
	public void completeTheFormWithoutNationalitySaveAndVerify(String companyName, String state, String service){
		companyMetadataPage().completeTheFormWithoutNationalitySaveAndVerify(companyName, state, service);
	}
	
	@Step
	public void completeCompanyNameWithAnExistingOneSaveAndVerify(String companyName, String state, String nationlity, String service){
		companyMetadataPage().completeCompanyNameWithAnExistingOneSaveAndVerify(companyName, state, nationlity, service);
	}
	
	@Step
	public String editCompanyWithNewData(String companyName, String state, String nationality, String service){
		return companyMetadataPage().editCompanyWithNewData(companyName, state, nationality, service);
	}
	
	@Step
	public void selectOneServiceToExportData(String service){
		companyMetadataPage().selectOneServiceToExportData(service);
	}
	
	@Step
	public void clickOnExportCompaniesForSelectedSector(){
		companyMetadataPage().clickOnExportCompaniesForSelectedSectorAndVerify();
	}
}

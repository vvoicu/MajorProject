package bmo5.bmo5tests.adm.steps.subnational;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class EntityMaintenanceSteps extends AbstractSteps {
	private static final long serialVersionUID = -3290137550266779012L;

	@StepGroup
	public String typeValidData(String entityCode, String entityName, String entityLevel, String entityType, String cmsShowState, String webShowState, String parent){
		typeEntityCode(entityCode);
		typeEntityName(entityName);
		typeEntityLevel(entityLevel);
		selectEntityType(entityType);
		selectCMSShow(cmsShowState);
		selectWebShow(webShowState);
		return selectParent(parent);
	}
	
	@StepGroup
	public void typeSearchItemAndClickSearch(String countryISO, String entityName){
		typeCountryISOforSearch(countryISO);
		typeEntityNameForSearch(entityName);
		clickOnSearchButton();
	}
	
	@StepGroup
	public void typeInvalidData(String wrongEntityLevel, String negativeNumber, String realNumber,String wrongEntityCode){
		typeWrongEntityLevelSaveAndVerify(wrongEntityLevel);
		typeWrongEntityLevelSaveAndVerify(negativeNumber);
		typeWrongEntityLevelSaveAndVerify(realNumber);
		typeWrongEntityCodeSaveAndVerify(wrongEntityCode);
	}
	
	@StepGroup
	public void verifySaveButtonDisabledAndElementsDisplayed(){
		verifySaveButtonIsDisabled();
		verifyElementsDisplayed();
	}
	
	@StepGroup
	public void verifySaveButtonEnabledAndElementsDisplayed(){
		verifySaveButtonIsEnabled();
		verifyEntityElementsDisplayed();
	}
	
	@StepGroup
	public void clickOnListViewSearchAndVerifyEdit(String entityName, String entityCode,String entityLevel,String entityType, String country, String cmsShowState, String webShowState, String parent){
	    clickListViewButton();
		typeSearchItemAndClickSearch("", entityName);
		clickOnEntityCodeFromTable(entityCode);
		verifyDataOnEditEntityPage(entityCode, entityLevel, entityName, entityType, country,cmsShowState,webShowState,parent);
	}
	
	@Step
	public void verifyElementsDisplayed(){
		entityMaintenancePage().verifyElementsDisplayed();
	}
	
	@Step
	public void clickOnEditButton(){
		entityMaintenancePage().clickOnEditButton();
	}
	
	@Step
	public void verifyEntityElementsDisplayed(){
		entityMaintenancePage().verifyEntityElementsDisplayed();
	}
	
	@Step
	public String selectCountry(String country){
		return entityMaintenancePage().selectCountry(country);
	}
	
	
	@Step
	public void clickOnContinueButton(){
		entityMaintenancePage().clickOnContinueButton();
	}
	
	@Step
	public void clickOnContinueButtonAndVerifyErrorMessage(){
		entityMaintenancePage().clickOnContinueButtonAndVerifyErrorMessage();
	}
	
	@Step
	public void verifySaveButtonIsDisabled(){
		entityMaintenancePage().verifySaveButtonIsDisabled();
	}
	
	@Step
	public void verifySaveButtonIsEnabled(){
		entityMaintenancePage().verifySaveButtonIsEnabled();
	}
	
	@Step
	public void verifyEditButtonIsEnabled(){
		entityMaintenancePage().verifyEditButtonIsEnabled();
	}

	@Step
	public void typeEntityCode(String entityCode){
		 entityMaintenancePage().typeEntityCode(entityCode);
	}
	
	@Step
	public void clickOnSaveWithoutCompletingAndVerifyErrorMessages(){
		entityMaintenancePage().clickOnSaveButtonAndVerifyErrorMessages();
	}
	
	@Step
	public void typeWrongEntityLevelSaveAndVerify(String wrongEntityLevel){
		entityMaintenancePage().typeWrongEntityLevelSaveAndVerify(wrongEntityLevel);
	}
	
	@Step
	public void typeWrongEntityLevelOnEditSaveAndVerify(String wrongEntityLevel){
		entityMaintenancePage().typeWrongEntityLevelOnEditSaveAndVerify(wrongEntityLevel);
	}
	
	@Step
	public void typeWrongEntityCodeSaveAndVerify(String wrongEntityCode){
		entityMaintenancePage().typeWrongEntityCodeSaveAndVerify(wrongEntityCode);
	}
	
	@Step
	public void typeEntityName(String entityName){
		entityMaintenancePage().typeEntityName(entityName);
	}
	
	@Step
	public void typeEntityLevel(String entityLevel){
		entityMaintenancePage().typeEntityLevel(entityLevel);
	}
	
	@Step
	public void selectEntityType(String entityType){
		entityMaintenancePage().selectEntityType(entityType);
	}
	
	@Step
	public void selectCMSShow(String cmsShowState){
		entityMaintenancePage().selectCMSShow(cmsShowState);
	}
	
	@Step
	public void selectWebShow(String webShowState){
		entityMaintenancePage().selectWebShow(webShowState);
	}
	
	@Step
	public void clickOnSaveButton(){
		entityMaintenancePage().clickOnSaveButton();
	}
	
	@Step
	public void assertSuccessMessageIsDisplayed(){
		entityMaintenancePage().assertSuccessMessageIsDisplayed();
	}
	
	@Step
	public void verifyAscendingDescending(String listSelector){
		entityMaintenancePage().verifyAscendingDescending(listSelector);
	}
	
	@Step
	public void clickOnBulkUpload(){
		entityMaintenancePage().clickOnBulkUpload();
	}
	
	@Step
	public void clickOnExportAll(){
		entityMaintenancePage().clickOnExportAll();
	}
	
	@Step
	public void clickOnNewButton(){
		entityMaintenancePage().clickOnNewButton();
	}
	
	@Step
	public void clickOnResetAndVerifySelectedOption(){
		entityMaintenancePage().clickOnResetAndVerifySelectedOption();
	}
	
	@Step
	public void clickOnResetButtonEditPage(){
		entityMaintenancePage().clickOnResetButtonEditPage();
	}
	
	@Step
	public void typeCountryISOforSearch(String countryISO){
		entityMaintenancePage().typeCountryISOforSearch(countryISO);
	}
	
	@Step
	public void typeEntityNameForSearch(String entityName){
		entityMaintenancePage().typeEntityNameForSearch(entityName);
	}
	
	@Step
	public void clickOnSearchButton(){
		entityMaintenancePage().clickOnSearchButton();
	}
	
	@Step
	public void verifySearchResults(String entityName){
		entityMaintenancePage().verifySearchResults(entityName);
	}
	
	@Step
	public String selectParent(String parent){
		return entityMaintenancePage().selectParent(parent);
	}
	
	@Step
	public void clickOnEntityCodeFromTable(String savedEntityCode){
		entityMaintenancePage().clickOnEntityCodeFromTable(savedEntityCode);
	}
	
	@Step
	public void clickListViewButton(){
		entityMaintenancePage().clickListViewButton();
	}
	
	@Step
	public void verifyAlreadyExistsError(){
		//TODO Fix this
//		entityMaintenancePage().verifyAlreadyExistsError();
	}
	
	@Step
	public void verifySuccessfullySavedMessage(){
		//TODO Fix this
//		entityMaintenancePage().verifySuccessfullySavedMessage();
	}
	
	@Step
	public void verifyDataOnEditEntityPage(String entityCode, String entityLevel, String entityName, String entityType, String country, String cmsShow, String webShow, String parent){
		entityMaintenancePage().verifyDataOnEditEntityPage(entityCode,entityLevel,entityName,entityType,country,cmsShow,webShow,parent);
	}
	
	@Step
	public void verifyDataOnEntityTablePage(String entityCode, String entityLevel,String entityName, String countryISO, String cmsShow, String webShow, String parentCode){
		entityMaintenancePage().verifyDataOnEntityTablePage(entityCode, entityLevel, entityName, countryISO, cmsShow, webShow, parentCode);
	}
}

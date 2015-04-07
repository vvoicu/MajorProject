package bmo5.bmo5tests.adm.steps.dvpacks;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class DatapackSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -9204034662112427840L;
	
	@StepGroup
	public void selectPrimaryTaggingOptions(String geography, String service, String company){
		selectGeographyPrimaryTagging(geography);
		selectServicePrimaryTagging(service);
		selectCompanyPrimaryTagging(company);
	}

	@Step
	public void clickAddNewDatapackButton(){
		datapacksPage().clickAddNewDatapackButton();
	}
	
	@Step
	public void clickDvpacksMenu(){
		datapacksPage().clickDvpacksMenu();
	}
	
	@Step
	public void clickDatapacksMenu(){
		datapacksPage().clickDatapacksMenu();
	}
	
	@Step
	public void clickManageDvpacksMenu(){
		datapacksPage().clickManageDvpacksMenu();
	}
	
	@Step
	public String typeDatapackTitle(String title){
		return datapacksPage().typeDatapackTitle(title);
	}
	
	@Step
	public void selectDataPackType(String datapackType){
		datapacksPage().selectDataPackType(datapackType);
	}
	
	@Step
	//TODO fix this
	public void uploadExcel(String excelName){
//		datapacksPage().uploadExcel(excelName);
	}
	
	@Step
	public void selectGeographyPrimaryTagging(String geography){
		datapacksPage().selectGeographyPrimaryTagging(geography);
	}
	
	@Step
	public void selectServicePrimaryTagging(String service){
		datapacksPage().selectServicePrimaryTagging(service);
	}
	
	@Step
	public void selectCompanyPrimaryTagging(String company){
		datapacksPage().selectCompanyPrimaryTagging(company);
	}
	
	@Step
	public void clickContinueButton(){
		datapacksPage().clickContinueButton();
	}
	
	@Step
	public void typeDvpackID(String dvpackID){
		datapacksPage().typeDvpackId(dvpackID);
	}
	
	@Step
	public void clickListViewButton(){
		datapacksPage().clickListViewButton();
	}

	@Step
	public void typeSavedDatapackTitle(String title){
		datapacksPage().searchSavedDataPackTitle(title);
	}
	
	@Step
	public void clickDeleteButtonForADatapack(){
		datapacksPage().clickDeleteButtonForADatapack();
	}
	
	@Step
	public void verifySuccessMessage(){
		datapacksPage().verifySuccessMessage();
	}
	
	@Step
	//TODO Fix this
	public void verifySuccessfullySavedMessage(){
//		datapacksPage().verifySuccessfullySavedMessage();
	}
	
	@Step
	public void verifySelectedTagging(String service, String geography, String company){
		datapacksPage().verifySelectedTagging(service, geography, company);
	}
	
	@Step
	public void verifySelectedDatapackType(String datapackType){
		datapacksPage().verifySelectedDatapackType(datapackType);
	}
	
	@Step
	public void verifyTitleAndDvpackId(String datapackTitle, String dvpackId){
		datapacksPage().verifyTitleAndDvpackId(datapackTitle, dvpackId);
	}
	
	@Step
	public void clickContinueWithoutCompletingAndVerifyErrorMessage(){
		datapacksPage().clickContinueWithoutCompletingAndVerifyErrorMessage();
	}
	
	@Step
	public void verifyElementsDisplayed(){
		datapacksPage().verifyElementsDisplayed();
	}
	
	@Step
	public void verifyErrorMessagesExistOrDoesntExists(byte existState){
		datapacksPage().verifyErrorMessageExistOrDoesntExists(existState);
	}
	
	@Step
	public void typeDvpackIdAndVerifyErrorMessage(String dvpackId){
		datapacksPage().typeDvpackIdAndVerifyErrorMessage(dvpackId);
	}
}

package bmo5.bmo5tests.bmo.steps.pillars;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import org.junit.Assert;
import org.openqa.selenium.By;

import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class BMIDatabasesUpstreamProjectsSteps extends AbstractSteps{

	private static final long serialVersionUID = -3649291952360884177L;

	@StepGroup
	public void verifyStatusFilter(String status){
		verifyIfStatusIsUnChecked(returnTheStatusId(status));
		checkOneStatus(status);
		verifyIfStatusIsChecked(returnTheStatusId(status));
	}
	
	@StepGroup
	public void verifyOnshoreOffshoreFilter(String onshoreOrOffshore){
		verifyIfOnshoreOrOffshoreIsUnChecked(onshoreOrOffshore);
		checkOneOnshoreOrOffshore(onshoreOrOffshore);
		verifyIfOnshoreOrOffshoreIsChecked(onshoreOrOffshore);
	}
	
	@StepGroup
	public void verifyHydrocarbonTypeFilter(String hydrocarbonType){
		verifyIfHydrocarbonTypeIsUnChecked(hydrocarbonType);
		checkOneHydrocarbonType(hydrocarbonType);
		verifyIfHydrocarbonTypeIsChecked(hydrocarbonType);
	}
	
	@StepGroup
	public void verifyRightHandFiltersAfterOpeningSavedData(String character, String status, String fromProjectCost, String toProjectCost, String onshoreOrOffshore, String hydrocarbonType){
		if(getDriver().findElements(By.cssSelector("div#dynamic_table > div.alert.alert-info")).size() == 1){
			System.out.println("There are no results");
			Assert.assertTrue(getDriver().findElements(By.cssSelector("button#dvpack-save[disabled]")).size() == 1);
		}
		else{
			verifyIfCompanyIsChecked(character);
			clickOnStatusToggler();
			verifyIfStatusIsChecked(returnTheStatusId(status));
			clickOnProjectCostToggler();
			verifyValuesFromProjectCostSection(fromProjectCost, toProjectCost);
			clickOnOnshoreOffshoreToggler();
			verifyIfOnshoreOrOffshoreIsChecked(onshoreOrOffshore);
			clickOnHydrocarbonToggler();
			verifyIfHydrocarbonTypeIsChecked(hydrocarbonType);
		}
	}
	
	@StepGroup
	public void verifyCompaniesFiler(String character){
		checkOneCompany(character);
		verifyIfCompanyIsChecked(character);
	}
	
	@Step
	public void verifyLeftHandFilter(){
		bmiDatabasesUpstreamProjectsPage().verifyLeftHandFilter();
	}
	
	@Step
	public void clickOnStatusToggler(){
		bmiDatabasesUpstreamProjectsPage().clickOnStatusToggler();
	}
	
	@Step
	public void checkOneStatus(String status){
		bmiDatabasesUpstreamProjectsPage().checkOneStatus(status);
	}
	
	@Step
	public String returnTheStatusId(String status){
		return bmiDatabasesUpstreamProjectsPage().returnTheStatusId(status);
	}
	
	@Step
	public void clickOnPeakOilToggler(){
		bmiDatabasesUpstreamProjectsPage().clickOnPeakOilToggler();
	}
	
	@Step
	public void selectValuesIntoPeakOilSection(String peakOilValue){
		bmiDatabasesUpstreamProjectsPage().selectValuesIntoPeakOilSection(peakOilValue);
	}
	
	@Step
	public void clickOnPeakGasToggler(){
		bmiDatabasesUpstreamProjectsPage().clickOnPeakGasToggler();
	}
	
	@Step
	public void selectValuesIntoPeakGasSection(String peakGasValue){
		bmiDatabasesUpstreamProjectsPage().selectValuesIntoPeakGasSection(peakGasValue);
	}
	
	@Step
	public void clickOnProjectCostToggler(){
		bmiDatabasesUpstreamProjectsPage().clickOnProjectCostToggler();
	}
	
	@Step
	public void insertValuesIntoProjectCostSection(String fromProjectCost, String toProjectCost){
		bmiDatabasesUpstreamProjectsPage().insertValuesIntoProjectCostSection(fromProjectCost, toProjectCost);
	}
	
	@Step
	public void clickOnOnshoreOffshoreToggler(){
		bmiDatabasesUpstreamProjectsPage().clickOnOnshoreOffshoreToggler();
	}
	
	@Step
	public void checkOneOnshoreOrOffshore(String onshoreOrOffshore){
		bmiDatabasesUpstreamProjectsPage().checkOneOnshoreOrOffshore(onshoreOrOffshore);
	}
	
	@Step
	public void clickOnHydrocarbonToggler(){
		bmiDatabasesUpstreamProjectsPage().clickOnHydrocarbonToggler();
	}
	
	@Step
	public void checkOneHydrocarbonType(String hydrocarbonType){
		bmiDatabasesUpstreamProjectsPage().checkOneHydrocarbonType(hydrocarbonType);
	}
	
	@Step
	public void clickOnClearFilters(){
		bmiDatabasesUpstreamProjectsPage().clickOnClearFilters();
	}
	
	@Step
	public void verifyPaginator(){
		bmiDatabasesUpstreamProjectsPage().verifyPaginator();
	}
	
	@Step
	public void clickOnFilterToggler(){
		bmiDatabasesUpstreamProjectsPage().clickOnFilterToggler();
	}
	
	@Step
	public void checkOneCompany(String character){
		bmiDatabasesUpstreamProjectsPage().checkOneCompany(character);
	}
	
	@Step
	public void verifyIfCompanyIsChecked(String character){
		bmiDatabasesUpstreamProjectsPage().verifyIfCompanyIsChecked(character);
	}
	
	@Step
	public void verifyIfStatusIsChecked(String status){
		bmiDatabasesUpstreamProjectsPage().verifyIfStatusIsChecked(status);
	}
	
	@Step
	public void verifyIfStatusIsUnChecked(String status){
		bmiDatabasesUpstreamProjectsPage().verifyIfStatusIsUnChecked(status);
	}
	
	@Step
	public void verifyValuesFromProjectCostSection(String fromProjectCost, String toProjectCost){
		bmiDatabasesUpstreamProjectsPage().verifyValuesFromProjectCostSection(fromProjectCost, toProjectCost);
	}
	
	@Step
	public void verifyIfOnshoreOrOffshoreIsChecked(String onshoreOrOffshore){
		bmiDatabasesUpstreamProjectsPage().verifyIfOnshoreOrOffshoreIsChecked(onshoreOrOffshore);
	}
	
	@Step
	public void verifyIfOnshoreOrOffshoreIsUnChecked(String onshoreOrOffshore){
		bmiDatabasesUpstreamProjectsPage().verifyIfOnshoreOrOffshoreIsUnChecked(onshoreOrOffshore);
	}
	
	@Step
	public void verifyIfHydrocarbonTypeIsChecked(String hydrocarbonType){
		bmiDatabasesUpstreamProjectsPage().verifyIfHydrocarbonTypeIsChecked(hydrocarbonType);
	}
	
	@Step
	public void verifyIfHydrocarbonTypeIsUnChecked(String hydrocarbonType){
		bmiDatabasesUpstreamProjectsPage().verifyIfHydrocarbonTypeIsUnChecked(hydrocarbonType);
	}
}

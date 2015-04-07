package bmo5.bmo5tests.bmo.steps.pillars;



import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class DataAndForecastingSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	@StepGroup
	public void verifyAllRatingsOnDataAndaForecastingPage (String text, String textNew,String operationalRisk, String securitys, String projects, String autosBr,String commercialBr,String consumerBr
			,String foodBr, String itBr,String infraBr,String InsBr,String medicalBr,String MinBr,String oilBr,String petroBr,String pharmaBr,String powerBr,String estateBr,String renewBr,String retBr,String telecomBr,String tourismBr) {
		verifyRatingsRedirectioningLink(text,textNew);
		verifyOperationalRiskLink(operationalRisk);
		verifySecurityLink(securitys);
		verifyProjectLink(projects);
		verifyAutosLink(autosBr);
		verifyCommercialLink(commercialBr);
		verifyConsumerLink(consumerBr);
		verifyFoodLink(foodBr);
		verifyInfoLink(itBr);
		verifyInfrastructureLink(infraBr);
		verifyInsuranceLink(InsBr);
		verifyMiningLink(MinBr);
		verifyOilAndGasLink(oilBr);
		verifyPetrochemicalsLink(petroBr);
		verifyPharmaLink(pharmaBr);
		verifyPowerLink(powerBr);
		verifyRealEstateLink(estateBr);
		verifyRenewablesLink(renewBr);
		verifyRetailLink(retBr);
		verifyTelecomLink(telecomBr);
		verifyTourismLink(tourismBr);
		verifyMedicalDevicesLink(medicalBr);
		
	}
	
	@StepGroup
	public void verifyAllBmiDatabasesOnDataAndForecastingPage(String burden, String burdenBr,String executive,String executiveBr,String globalMin,String glogalMinBr,String globalRef,String globalRefBr,String infraKey,String infraKeyBr,String mdg,String mdgBr,String mobile,
			String mobileBr,String powerKey,String powerKeyBr,String feed,String feedBr,String renewKey,String renewKeyBr,String upstream,String upstreamBr) {
		verifyBurdenOfDiseaseLink(burden, burdenBr);
		verifyExecutiveCOntactsLink(executive, executiveBr);
		verifyGlobalMinesLink(globalMin, glogalMinBr);
		verifyGlobalRefineriesLink(globalRef, globalRefBr);
		verifyInfrastructureKeyLink(infraKey, infraKeyBr);
		verifyMedicalGuideLink(mdg, mdgBr);
		verifyMobileOperatorsLink(mobile, mobileBr);	
		verifyPowerKeyLink(powerKey, powerKeyBr);
		verifyRenewableFeedInTariffsLink(feed, feedBr);
		verifyRenewablesKeyLink(renewKey, renewKeyBr);
		verifyUpstreamLink(upstream, upstreamBr);
		
	}
	
	@StepGroup
	public void verifyDataToolRedirection(String text) {
		dataAndForecastingPage().verifyDataToolRedirection();
		//dataAndForecastingPage().verifyBreadCrumb(text);
		dataAndForecastingPage().clickOnDataAndForecastingBreadcrumb ();
		}
	
	@StepGroup
	public void verifyRatingsRedirectioningLink(String text, String textNew) {
		dataAndForecastingPage().verifyRatingsRedirectioningLink(text);
		dataAndForecastingPage().verifyCountryRiskLink(textNew);
	}
	
	@StepGroup
	public void selectIndicatorPanel(String element) {
		dataAndForecastingPage().clickIndicatorLeftPanel();
		dataAndForecastingPage().clickIndicatorFromPanelCheckBox(element);
	}
	
	@Step
	public void selectDataTool(String dataTool) {
		dataAndForecastingPage().clickOnDataTool(dataTool);
	}
	
	@Step
	public void leftPanelGeographies(String element) {
		dataAndForecastingPage().selectGeographyFromPanel(element);
	}
	
	@Step
	public void leftPanelGeographyCheckbox(String element) {
		dataAndForecastingPage().clickGeographyFromPanel(element);
	}

	@Step
	public void clickGeographyLeftPanel(String element) {
		dataAndForecastingPage().clickGeographyFromPanel(element);
	}
	
	@Step
	public void selectIndicatorFromList(String element) {
		dataAndForecastingPage().clickIndicatorFromPanel(element);
	}
	
	@Step
	public void clickIndicatorList(String element){
		dataAndForecastingPage().clickIndicatorFromPanelCheckBox(element);
	}
	
	@Step
	public void selectDateRangesPanel(String checkbox) {
		dataAndForecastingPage().clickDateRangesLeftPanel();
		//dataAndForecastingPage().typeDateRangesLeftPanel(checkbox);
	}
	
	@Step
	public void selectDisplayData() {
		dataAndForecastingPage().clickDisplayDatabutton();
	}
	
	@Step
	public void clickDownloadbutton() {
		dataAndForecastingPage().clickOnDownloadDataTool();		
	}

	@Step
	public void clickDataAndForecastingTab(String dataTab) {
		dataAndForecastingPage().clickOnDataAndForecastingTab(dataTab);
	}
	
	@Step
	public void selectSubTabDataAndForecasting(String element) {
		dataAndForecastingPage().chooseSubTabDataAndForecasting(element);

	}
	@Step
	public void clickCountryRiskTab() {
		dataAndForecastingPage().clickOnCountryRiskTab();


	}
	@Step
	public void verifyBreadcrumbsForCountryRisk(String text) {
		dataAndForecastingPage().verifyBreadCrumbForCountryRisk( text);	
	}
	
	@Step
	public void clickOnBMIDatabasesLink(String infra) {
		dataAndForecastingPage().clickOnkeyProjectsLink(infra);		
	}
	
	@Step
	public void verifyBreadcrumbsForKeyProjects(String breadcrumbText) {
		dataAndForecastingPage().verifyBreadCrumbForCountryRisk( breadcrumbText);		
	}
	
	@Step
	public void verifyBreadcrumbsForContactAccountManager(String breadcrumbText) {
		dataAndForecastingPage().verifyBreadCrumbForCountryRisk(breadcrumbText);		
	}
	
	@Step
	public void verifyBreadcrumbsForDataAndForecasting(String breadcrumbText) {
		dataAndForecastingPage().verifyBreadCrumbForCountryRisk(breadcrumbText);;		
	}

	@Step
	public void clickOnClickToExporeDataButton(){
		dataAndForecastingPage().clickOnClickToExporeDataButton();
	}

	@Step
	public void clickOnSecurityTab(String security){
		dataAndForecastingPage().clickOnSecurityTab(security);
	}

	@Step
	public void selectOneRatingFromDropDownList(String ratingName){
		dataAndForecastingPage().selectOneRatingFromDropDownList(ratingName);
	}
	
	@Step
	public void clickOnDownloadDataTool(String extension) {
		dataAndForecastingPage().clickOnDownloadDataToolAndVerify(extension);
	}
	
	@Step
	public void selectProjectFinance(String projRisk) {
		dataAndForecastingPage().clickOnProjectFinance(projRisk);
	}
	
	@Step
	public void selectAnIndustryFromList(String ratingName) {
		//dataAndForecastingPage().selectMiningIndustry (); 
		dataAndForecastingPage().selectOneRatingFromDropDownList(ratingName);
	}
	
	@Step
	public void verifySubTabsPresenceOnPage(String data, String rating,String database, String cr,String operational, String security, String project, String industry, String autos, String commercial, String consumer, String food, String info, String infra, 
			String insurance,String medical, String mining, String oil,String petro,String pharma, String power, String estate, String renew, String ret, String telecom, String tourism) {
		dataAndForecastingPage().verifySubTabsPresenceOnPage(data, rating, database, cr,operational,security,project,industry,autos,commercial,consumer,food, info,
				infra,insurance,medical,mining,oil,petro,pharma,power,estate,renew,ret,telecom,tourism);
	}
	
	@Step
	public void verifySecurityLink(String textNew) {
		dataAndForecastingPage().verifySecurityLink(textNew);
	}
	
	@Step
	public void verifyOperationalRiskLink(String textNew) {
		dataAndForecastingPage().verifyOperationalRiskLink(textNew);
	}
	
	@Step
	public void verifyBreadcrumbRatings(String textNew) {
		dataAndForecastingPage().verifyBreadCrumbRatings(textNew);
	}
	
	@Step
	public void verifyProjectLink(String textNew) {
		dataAndForecastingPage().verifyProjectFinanceLink(textNew);
	}
	
	@Step
	public void verifyAutosLink(String textNew) {
		dataAndForecastingPage().verifyAutosLink(textNew);
	}
	
	@Step
	public void verifyCommercialLink(String textNew) {
		dataAndForecastingPage().verifyCommercialLink(textNew);
	}
	
	@Step
	public void verifyConsumerLink(String textNew) {
		dataAndForecastingPage().verifyConsumerLink(textNew);
	}
	
	@Step
	public void verifyFoodLink(String textNew) {
		dataAndForecastingPage().verifyFoodAndDrinkLink(textNew);
	}
	
	@Step
	public void verifyInfoLink(String textNew) {
		dataAndForecastingPage().verifyInfoTechLink(textNew);
	}
	
	@Step
	public void verifyInfrastructureLink(String textNew) {
		dataAndForecastingPage().verifyInfrastructureLink(textNew);
	}
	
	@Step
	public void verifyInsuranceLink(String textNew) {
		dataAndForecastingPage().verifyInsuranceLink(textNew);
	}
	
	@Step
	public void verifyMedicalDevicesLink(String textNew) {
		dataAndForecastingPage().verifyMedicalDevicesLink(textNew);
	}
	
	@Step
	public void verifyMiningLink(String textNew) {
		dataAndForecastingPage().verifyMiningLink(textNew);
	}
	
	@Step
	public void verifyOilAndGasLink(String textNew) {
		dataAndForecastingPage().verifyOilAndGasink(textNew);
	}
	
	@Step
	public void verifyPetrochemicalsLink(String textNew) {
		dataAndForecastingPage().verifyPetrochemicalsLink(textNew);
	}
	
	@Step
	public void verifyPharmaLink(String textNew) {
		dataAndForecastingPage().verifyPharmaLink(textNew);
	}
	
	@Step
	public void verifyPowerLink(String textNew) {
		dataAndForecastingPage().verifyPowerLink(textNew);
	}
	
	@Step
	public void verifyRealEstateLink(String textNew) {
		dataAndForecastingPage().verifyRealEstateLink(textNew);
	}
	
	@Step
	public void verifyRenewablesLink(String textNew) {
		dataAndForecastingPage().verifyRenewablesLink(textNew);
	}
	
	@Step
	public void verifyRetailLink(String textNew) {
		dataAndForecastingPage().verifyRetailLink(textNew);
	}
	
	@Step
	public void verifyTelecomLink(String textNew) {
		dataAndForecastingPage().verifyTelecomLink(textNew);
	}
	
	@Step
	public void verifyTourismLink(String textNew) {
		dataAndForecastingPage().verifyTourismLink(textNew);
	}
	
	@Step
	public void verifyBMIDatabasesRedirection(String text) {
		dataAndForecastingPage().verifyBMIDatabaseLink(text);
		
	}
	
	@Step
	public void verifyBurdenOfDiseaseLink(String burden,String textNew) {
		dataAndForecastingPage().verifyBurdenOfDiseaseLink(burden, textNew);
	}
	
	@Step
	public void verifyMedicalGuideLink(String mdg,String textNew) {
		dataAndForecastingPage().verifyMedicalDistributorsGuideLink(mdg, textNew);
	}
	
	@Step
	public void verifyExecutiveCOntactsLink(String executive,String textNew) {
		dataAndForecastingPage().verifyExecutiveLink(executive, textNew);
	}
	
	@Step
	public void verifyGlobalMinesLink(String globalMin,String textNew) {
		dataAndForecastingPage().verifyGLobalLink(globalMin, textNew);
	}
	
	@Step
	public void verifyGlobalRefineriesLink(String globalRef,String textNew) {
		dataAndForecastingPage().verifyGLobalRefinLink(globalRef, textNew);
	}
	@Step
	public void verifyInfrastructureKeyLink(String infraKey,String textNew) {
		dataAndForecastingPage().verifyInfrastructureLink(infraKey, textNew);
	}
	
	@Step
	public void verifyMobileOperatorsLink(String mobile,String textNew) {
		dataAndForecastingPage().verifyMobileLink(mobile, textNew);
	}
	
	@Step
	public void verifyPowerKeyLink(String powerKey,String textNew) {
		dataAndForecastingPage().verifyPowerLink(powerKey, textNew);
	}
	
	@Step
	public void verifyRenewableFeedInTariffsLink(String feed ,String textNew) {
		dataAndForecastingPage().verifyFeedInTariffsLink(feed, textNew);
	}
	@Step
	public void verifyRenewablesKeyLink(String renewKey,String textNew) {
		dataAndForecastingPage().verifyRenewableKeyLink(renewKey, textNew);
	}
	
	@Step
	public void verifyUpstreamLink(String upstream,String textNew) {
		dataAndForecastingPage().verifyUpstreamLink(upstream, textNew);
	}
	
	@Step
	public void downloadAndVerifyGeneralDvPack(String extension1, String extension2){
		dataAndForecastingPage().downloadAndVerifyGeneralDvPack(extension1, extension2);
	}
	
	@Step
	public void selectRatingTypeByPartialLink(String ratingName){
		dataAndForecastingPage().clickOnRatingByPartialLink(ratingName);
	}
}



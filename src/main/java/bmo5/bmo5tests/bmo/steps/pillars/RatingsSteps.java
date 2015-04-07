package bmo5.bmo5tests.bmo.steps.pillars;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class RatingsSteps extends AbstractSteps {

	private static final long serialVersionUID = 8858564152118641503L;
	
	@StepGroup
	public void exapndGeographyFromFilter(String geography) {
		ratingsPage().exapndGeographyFromFilter(geography);
		ratingsPage().selectOneGeograpyFromFilter(geography);
		ratingsPage().verifySelectedCountryInFilter(geography);
	}
	
	@StepGroup
	public void verifyThePartOfRatingsRewards(String info, String infoBr,String infra, String infraBr,String insurance, String insuranceBr,String mining, String miningBr, String oil, String oilBr,String petro,
			String petroBr, String pharma, String pharmaBr, String power, String powerBr, String estate, String estateBr,String renew, String renewBr,String telecom, String telecomBr ) {
		selectInfoTec(info);
		dataAndForecastingPage().verifyBreadCrumbRatings(infoBr);
		saveRating();
		clickOnFirstCountruForSecurityTable();
		saveRating();
		selectInfrastructure(infra);
		dataAndForecastingPage().verifyBreadCrumbRatings(infraBr);
		saveRating();
		clickOnFirstCountruForSecurityTable();
		saveRating();
		selectInsurance(insurance);
		dataAndForecastingPage().verifyBreadCrumbRatings(insuranceBr);
		saveRating();
		clickOnFirstCountruForSecurityTable();
		saveRating();
		selectMining(mining);
		dataAndForecastingPage().verifyBreadCrumbRatings(miningBr);
		saveRating();
		clickOnFirstCountruForSecurityTable();
		saveRating();
		selectOil(oil);
		dataAndForecastingPage().verifyBreadCrumbRatings(oilBr);
		saveRating();
		clickOnFirstCountruForSecurityTable();
		saveRating();
		selectPetrochemicals(petro);
		dataAndForecastingPage().verifyBreadCrumbRatings(petroBr);
		saveRating();
		clickOnFirstCountruForSecurityTable();
		saveRating();
		selectPharma(pharma);
		dataAndForecastingPage().verifyBreadCrumbRatings(pharmaBr);
		saveRating();
		clickOnFirstCountruForSecurityTable();
		saveRating();
		selectPower(power);
		dataAndForecastingPage().verifyBreadCrumbRatings(powerBr);
		saveRating();
		clickOnFirstCountruForSecurityTable();
		saveRating();
		selectEstate(estate);
		dataAndForecastingPage().verifyBreadCrumbRatings(estateBr);
		saveRating();
		clickOnFirstCountruForSecurityTable();
		saveRating();
		selectRenewables(renew);
		dataAndForecastingPage().verifyBreadCrumbRatings(renewBr);
		saveRating();
		clickOnFirstCountruForSecurityTable();
		saveRating();
		selectTelecom(telecom);
		dataAndForecastingPage().verifyBreadCrumbRatings(telecomBr);
		saveRating();
		clickOnFirstCountruForSecurityTable();
		saveRating();
		
	}
	
	@StepGroup
	public void verifyUnentitledRatings(String entitledService){
		verifyUnentitledRatingsLeftContainer(entitledService);
		verifyUnentitledRatingsRightContainer(entitledService);
	}
	
	@Step
	public void selectOneGeograpyFromFilter(String geography){
		ratingsPage().selectOneGeograpyFromFilter(geography);
	}
	
	@Step
	public void selectInfoTec(String rating) {
		ratingsPage().selectRatingFromDropDown(rating);
	}
	
	@Step
	public void selectInfrastructure(String rating) {
		ratingsPage().selectRatingFromDropDown(rating);
	}
	
	@Step
	public void selectInsurance(String rating) {
		ratingsPage().selectRatingFromDropDown(rating);
	}
	
	@Step
	public void selectMining(String rating) {
		ratingsPage().selectRatingFromDropDown(rating);
	}
	
	@Step
	public void selectOil(String rating) {
		ratingsPage().selectRatingFromDropDown(rating);
	}
	
	@Step
	public void selectPetrochemicals(String rating) {
		ratingsPage().selectRatingFromDropDown(rating);
	}
	
	@Step
	public void selectPharma(String rating) {
		ratingsPage().selectRatingFromDropDown(rating);
	}
	
	@Step
	public void selectPower(String rating) {
		ratingsPage().selectRatingFromDropDown(rating);
	}
	
	@Step
	public void selectEstate(String rating) {
		ratingsPage().selectRatingFromDropDown(rating);
	}
	
	@Step
	public void selectRenewables(String rating) {
		ratingsPage().selectRatingFromDropDown(rating);
	}
	
	@Step
	public void selectTelecom(String rating) {
		ratingsPage().selectRatingFromDropDown(rating);
	}
	
	@Step
	public void saveRating() {
		ratingsPage().saveRatings();
	}
	
	@Step
	public void clickOnTheFirstCountryFromCRTable() {
		ratingsPage().clickOnTheFirstCountryFromCRTable();
	}
	
	@Step
	public void ClickOnDownloadRatings() {
		ratingsPage().ClickOnDownloadRatings();		
	}
	
	@Step
	public void clickOnDownloadRatingsTrialUser() {
		ratingsPage().verifyRatingsDownloadForTrialUser();
	}
	
	@Step
	public void downloadFirstTableOfACountry() {
		ratingsPage().downloadFirstTableOfACountry();
	}
	
	
	@Step
	public void downloadPeerGroupRatingTable() {
		ratingsPage().downloadPeerGroupRatingTable();
	} 
	
	@Step
	public void selectFromRatingDropdown(String rating) {
		ratingsPage().selectRatingFromDropDown(rating);
	}
	
	@Step
	public void downloadPeerGroupRatingTableOnly() {
		ratingsPage().downloadPeerGroup();
	}
	
	@Step
	public String saveRatingAsRegular(String ratingSavedName,String message) {
		return ratingsPage().saveRatingAsRegular(ratingSavedName,message);
	}
	
	@Step
	public void downloadExcelRatingTable() {
		ratingsPage().downloadExcelRatingTable();
		
	}
	
	@Step
	public void downloadRegionalPeerTable() {
		ratingsPage(). downloadRegionalPeerTable();
	}
	
	@Step
	public void clickOnACountryFromTableSecurityRiskRating(String country){
		ratingsPage().clickOnACountryFromTableSecurityRiskRating(country);
	}
	
	@Step
	public void clickOnIndicatorsTogglerFromFilter(){
		ratingsPage().clickOnIndicatorsTogglerFromFilter();
	}
	
	@Step
	public void clickOnRatingTogglerFromFilter(){
		ratingsPage().clickOnRatingTogglerFromFilter();
	}
	
	@Step
	public void checkOneIndicatorFromList(String indicator){
		ratingsPage().checkOneIndicatorFromList(indicator);
	}
	
	@Step
	public void checkOneRatingFromList(String rating){
		ratingsPage().checkOneRatingFromList(rating);
	}
	
	@Step
	public void clickOnDisplayDataButton(){
		ratingsPage().clickOnDisplayDataButton();
	}
	
	@Step
	public void selectACountryFromTheTable(String geography) {
		ratingsPage().selectACountryFromTheTable(geography);
	}

	@Step
	public void expandRiskRewardFromFilterForCountryRisk(String value) {
		ratingsPage().expandRiskRewardFromFilterForCountryRisk(value);
	}
	
	@Step
	public void expandDateRange(String value) {
		ratingsPage().expandDateRange(value); 
	}
	
	@Step
	public void clickAndVerifySovereignMethodology() {
		ratingsPage().clickAndVerifySovereignMethodology();		
	}
	
	@Step
	public void clickOnFirstCountruForSecurityTable() {
		ratingsPage().clickOnFirstCountruForSecurityTable();
	}
	
	@Step
	public void closeMethodologyButton() {
		ratingsPage().closeMethodologyButton();		
	}
	
	@Step
	public void clickOnBriefMethodology() {
		ratingsPage().clickOnBriefMethodology();;
	}
	
	@Step
	public void clickOnSovereignRiskToggler(String value) {
		//ratingsPage().expandSovereignRiskRatingFromFilter();
		ratingsPage().expandRiskRewardFromFilterForCountryRisk(value);
	}
	
	@Step
	public void verifyRatingsTable(String shortTermP,String longTermP,String shortTermE, String longTermE, String opRisk, String crIndex) {
		ratingsPage().verifyRatingsTable(shortTermP,longTermP,shortTermE, longTermE, opRisk,crIndex);
	}
	
	@Step
	public void verifySecurityRiskTable(String titleOfRating,String securityIndex,String domestic, String shortTerm) {
		ratingsPage().verifySecurityRiskTable(titleOfRating,securityIndex,domestic,shortTerm);
	}
	
	@Step
	public void verifySecurityProjectFinanceAndIndustryRisk() {
		ratingsPage().verifySecurityProjectFinanceAndIndustryRisk();
		
	}
	
	@Step
	public void verifyProjectFinanceTable(String titleOfRating,String projIndex,String finance, String operation, String construction) {
		ratingsPage().verifyProjectFinanceTable(titleOfRating,projIndex, finance,operation,construction);
	}
	
	@Step
	public void verifyIndustryRiskRewardTable(String titleOfRating) {
		ratingsPage().verifyIndustryRiskRewardTable(titleOfRating);
		
	}
	
	@Step
	public void verifyTourismTelecomRetailRatings (String titleOfRating,String riskRewardRet,String rewardsRet,String risksRet) {
		ratingsPage().verifyTourismTelecomRetailRatings(titleOfRating,riskRewardRet,rewardsRet,risksRet);
	}
	
	@Step
	public void verifyInsuranceRating(String titleOfRating,String riskRewIndex,String reward,String risks,String industryRisk) {
		ratingsPage().verifyInsuranceRating(titleOfRating,riskRewIndex,reward,risks,industryRisk);
	}

	@Step
	public void verifyOilAndGasRating(String titleOfRating,String combinedIndex,String upstreamIndex, String downstreamIndex) {
		ratingsPage().verifyOilAndGasRating(titleOfRating,combinedIndex,upstreamIndex,downstreamIndex);
	}

	@Step
	public void verifyMedicalDevicesRating(String titleOfRating,String rewards,String risksMed,String mdIndex) {
		ratingsPage().verifyMedicalDevicesRating(titleOfRating,rewards,risksMed,mdIndex);
	}
	
	@Step
	public void verifyCrRatingColumn() {
		ratingsPage().verifyCRRating();
		
	}

	@Step
	public void verifyCountryArticleOrPeerGroupTable(String dateRange,String regPeer) {
	ratingsPage().verifyCountryArticleOrPeerGroupTable(dateRange,regPeer);
		
	}

	@Step
	public void verifyDateRangeMatchesArticleDatesRiskSummary(String dateRange) {
		ratingsPage().verifyDateRangeMatchesArticleDatesRiskSummary(dateRange);
		
	}

	@Step
	public void verifyMethodologyOnRatings(String moreMethodology, String brief, String save) throws InterruptedException {
		ratingsPage().verifyMethodologyOnRatings(moreMethodology, brief, save);
		
	}

	@Step
	public void verifyBriefOnRatings(String moreMethodology, String brief,String save) {
		ratingsPage().verifyBriefOnRatings(moreMethodology, brief, save);
		
	}

	@Step
	public void verifyMethodologyOnRatingsIndustries(String moreMethodology,
			String brief, String save) {
		ratingsPage().verifyMethodologyOnRatingsIndustries(moreMethodology, brief, save);
		
	}

	@Step
	public void verifyBriefOnRatingsProjectRisk(String moreMethodology, String brief,String save) {
		ratingsPage().verifyBriefOnRatingsProjectRisk(moreMethodology, brief, save);
		
	}

	@Step
	public void verifyMethodologyOnRatingsProjectRisk(String moreMethodology, String brief,String save) {
		ratingsPage().verifyMethodologyOnRatingsProjectRisk(moreMethodology, brief, save);
		
	}

	@Step
	public void verifyBriefOnRatingsIndustriesAndSecurity(
			String moreMethodology, String brief,
			String save) {
		ratingsPage().verifyBriefOnRatingsIndustriesAndSecurity(moreMethodology, brief, save);
		
	}

	@Step
	public void verifySavedRatingCR(String one, String geography) {
		ratingsPage().verifySavedRatingCR(one,geography);
		
	}
	
	@Step
	public void verifySavedRatingBrCR(String breadcrumb) {
		ratingsPage().verifyBrCROnSavedRating(breadcrumb);
		
	}
	
	@Step
	public void verifyEntitledGeographyFromLeftHandFilterRatings(String entitledGeography,String continentForEntitledGeo){
	ratingsPage().verifyEntitledGeographyFromLeftHandFilterRatings(entitledGeography, continentForEntitledGeo);
	}
	
	@Step
	public void verifyUnentitledRatingsLeftContainer(String entitledService){
		ratingsPage().verifyUnentitledRatingsLeftContainer(entitledService);
	}

	@Step
	public void verifyRatingsOperationalRiskTable(String labour, String logistics,String trade, String crime, String opRisk) {
		ratingsPage().verifyRatingsOperationalRiskTable(labour,logistics,trade,crime,opRisk);
		
	}

	@Step
	public void verifyMethodologyOnRatingsPoliticalRisk(String moreMethodology,
			String brief, String parameterTitle, String save) {
		ratingsPage().verifyMethodologyOnRatingsPoliticalRisk(moreMethodology, brief, save);
		
	}
	
	@Step
	public void clickGeographySection(){
		ratingsPage().clickGeographySection();
	}
	
	@Step
	public void verifyOptionIsDeselectedRatings(String filterSection, String selectedParentOption){
		ratingsPage().verifyOptionIsDeselectedRatings(filterSection, selectedParentOption);
	}
	
	@Step
	public int getTableRowsSize(){
		return ratingsPage().getTableRowsSize();
	}
	
	@Step
	public void verifyTableRowsSize(int expectedNumber,int actualNumber){
		ratingsPage().verifyTableRows(expectedNumber, actualNumber);
	}
	
	@Step
	public void verifyUnentitledRatingsRightContainer(String entitledService){
		ratingsPage().verifyUnentitledRatingsRightContainer(entitledService);
	}
	
	@Step
	public boolean verifyIfEntitledServiceIsInfrastructureandCheckPRojectRiskIndex(String entitledService){
		return ratingsPage().verifyIfEntitledServiceIsInfrastructureandCheckPRojectRiskIndex(entitledService);
	}
	
	@Step
	public void verifyBriefAndMethodologyPresenceOnPage() {
		ratingsPage().verifyBriefAndMethodologyPresenceOnPage();
		
	}
	
	@Step
	public void downloadHandle() {
		ratingsPage().downloadHandle();
	}
}
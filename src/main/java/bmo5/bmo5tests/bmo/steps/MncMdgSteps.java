package bmo5.bmo5tests.bmo.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class MncMdgSteps extends AbstractSteps{

	private static final long serialVersionUID = 1L;

	@StepGroup
	public void searchMNC(String search,String companyTitle,String companyName) {
		mncMdgPage().clickSearchButton(search);		
		mncMdgPage().typeCompanyName(companyTitle,companyName);
		mncMdgPage().clickSearchButton(search);	
	}
	
	@StepGroup
	public void jobSearch(String jobTitle,String jobName) {
		mncMdgPage().typeJobName(jobTitle,jobName);
		mncMdgPage().clickOnClearButton();
	}
	
	@StepGroup
	public void clickOnSearchButtonOptions(int itemNumber,String breadcrumbCompany,String details, String text) {
		mncMdgPage().selectACompanyFromList(itemNumber);
		//mncPage().clickPrintButton();
		mncMdgPage().verifyBreadCrumb(breadcrumbCompany);
		mncMdgPage().verifyPresenceOfPrintAndCompanyDetailsInsideACompany(details);
		mncMdgPage().selectTextFromPrintArticle(text);
		//mncMdgPage().clickPrintButton();
		//mncMdgPage().clickPrintInsidePrintButton();
		//mncPage().clickCloseInsidePrintButton(); not visible
	}
	
	@StepGroup
	public void doASearchForMdg(String search,String companyTitle,String companyName) {
		mncMdgPage().clickSearchButton(search);
		mncMdgPage().typeCompanyName(companyTitle,companyName);
		mncMdgPage().clickSearchButton(search);
		mncMdgPage().clickOnClearButton();
	}
	
	@StepGroup
	public void doASerachForMnc(String companyTitle,String companyName,String search) {
		mncMdgPage().typeCompanyName(companyTitle,companyName);
		mncMdgPage().clickSearchButton(search);
	}
	
	@StepGroup
	public void doASearchForACompany(String search,String companyTitle,String companyName) {
		mncMdgPage().typeCompanyName(companyTitle,companyName);
		mncMdgPage().clickSearchButton(search);
	}
	
	@StepGroup
	public void selectOptionMDG(String companyTitle,String location) {
		mncMdgPage().selectMDGOptions();
		mncMdgPage().typeCompanyName(companyTitle,location);
		mncMdgPage().clickClearButton();
	}
	
	@StepGroup
	public void selectAJob(String jobOption) {
		mncMdgPage().selectJobFromMDGOptions();
		mncMdgPage().searchForJob(jobOption);		
	}
	
	@StepGroup
	public void doASearchForMdgCompany(String companyTitle,String companyName,String search) {
		mncMdgPage().typeCompanyName(companyTitle,companyName);
		mncMdgPage().clickSearchButton(search);
	}
	
	@StepGroup
	public String verifySaveInCompanyDetail(String companyName,String text) {
	mncMdgPage().verifySaveInsideMncCompany(companyName);	
	return mncMdgPage().clickOnSave(companyName, text);
	}
	
	@StepGroup
	public void selecBimoAccount(String logout,String account) {
	 mncMdgPage().selectMyBimo();
	 mncMdgPage().dropdownBimo(logout,account);
	}
	
	@StepGroup
	public void logOutFromBimo() {
		mncMdgPage().selectMyBimo();
		mncMdgPage().logOutBimo();		
	}
	
	@StepGroup
	public void verifyMyBmoAndSelectAccoutForMdg(String logout,String account) {
		mncMdgPage().selectMyBimo();
		mncMdgPage().dropdownBimoMdg(logout, account);
	}
	
	@StepGroup
	public void verifyPrintForCompanySavedInMnc(String companyName) {
		mncMdgPage().checkSavedMncFromList();
		mncMdgPage().verifyPresenceOfPrint();
	}
	
	@StepGroup
	public void verifyPrintForCompanySavedInMncCI(String companyName) {
		mncMdgPage().checkSavedMncFromList();
		mncMdgPage().verifyPresenceOfPrint();
	}
	
	@Step
	public void clickOnPrint(String companyName) {
		mncMdgPage().clickOnPrint(companyName);
	}
	
	@Step
	public void verifyPrintForCompanyOrSearch(String companyName) {
		mncMdgPage().verifyIfIsMncCompanyOrMncSearch(companyName);
	}
	
	@Step
	public void verifyPrintForCompanyOrSearchCI(String companyName) {
		mncMdgPage().verifyIfIsMncCompanyOrMncSearchCI(companyName);
	}
	
	@Step
	public void addressSearch(String address,String adressName) {
		mncMdgPage().typeAdressTextArea(address,adressName);
	}
	
	@Step
	public void clickCompanyLocation(String companyLoc) {
		mncMdgPage().clickCompanyLocationGeography(companyLoc);		
	}
	
	@Step
	public void typeCompanyLocation(String location) {
		mncMdgPage().searchForCompanyLocation(location);	
	}
	
	@Step
	public void clickOnSearchButton(String search) {
		mncMdgPage().clickSearchButton(search);	
	}
	
	@Step
	public void verifyBreadCrumbs(String text) {
		mncMdgPage().verifyBreadCrumbForCountryRisk(text);
	}
	
	@Step
	public void clickOnSearchMnc(String search) {
		mncMdgPage().clickSearchButton(search);
	}
	
	@Step
	public String saveSearchPopUp(String text) {
		return mncMdgPage().clickSaveThisSearchButton(text);
	}
	
	@Step
	public void companiesSearch(String companies) {
		mncMdgPage().typeCompany(companies);
	}
	
	@Step
	public void productSearch(String product) {
		mncMdgPage().typeProduct(product);
	}
	
	@Step
	public void exportAction() {
		mncMdgPage().selectExportButton();		
	}
	
	@Step
	public String clickOnSaveThisSearch(String text) {
		return mncMdgPage().clickSaveThisSearchButton(text);		
	}
	
	@Step
	public void clearCompanyButton() {
		mncMdgPage().clickOnClearCompany();
	}
	
	@Step
	public void clickCompanyNationality(String companyNat) {
		mncMdgPage().clickCompanyNationality(companyNat);
	}
	
	@Step
	public void clickOnJobOption(String job) {
		mncMdgPage().expandOnJob(job);
	}
	
	@Step
	public void clickJobOption() {
		mncMdgPage().expandMDGJob();
	}
	
	
	@Step
	public void clickOnIndustryOption(String industry) {
		mncMdgPage().expandOnIndustry(industry);
	}
	
	@Step
	public void clearCompanyNationalityButton() {
		mncMdgPage().clickOnClearNationality();
	}
	
	@Step
	public void nationalitySearchFilter(String nationality) {
		mncMdgPage().searchForNationality(nationality);
	}
	
	@Step
	public void selectRegionFromList(String element) {
		mncMdgPage().selectGeographyFromList(element);
	}
	
	@Step
	public void selectNationalityFromList(String element) {
		mncMdgPage().selectNationalityFromList(element);;
	}
	
	@Step
	public void selectJobFromList(String element) {
		mncMdgPage().selectJobFromList(element);
	}
	
	@Step
	public void selectIndustryFromList(String element) {
		mncMdgPage().selectIndustryFromList(element);
	}
	
	@Step
	public void typeJobName(String jobOption) {
		mncMdgPage().searchForJob(jobOption);		
	}
	
	@Step
	public void typeIndustryName(String industry) {
		mncMdgPage().searchForIndustry(industry);;		
	}
	
	@Step
	public void clearJobList() {
		mncMdgPage().clickOnClearJob();
	}
	
	@Step
	public void clearIndustryList() {
		mncMdgPage().clickOnClearIndustry();
	}
	
	@Step
	public void selectWebinarsAndPodcasts(String breadcrumb) {
		mncMdgPage().selectWebinars(breadcrumb);
	}
	
	@Step
	public void verifyWebinarsBreadcrumb(String breadcrumb) {
		mncMdgPage().verifyBreadCrumbsForWebinars(breadcrumb);		
	}
	
	@Step
	public void saveMncSearchForEnterprise() {
		mncMdgPage().saveMncSearchForEnterprise();
	}
	
	@Step
	public void verifyBreadCrumb(String breadcrumbName) {
		mncMdgPage().verifyBreadCrumb(breadcrumbName);
	}
	
	@Step
	public void verifyCompanyProfileOnPage() {
		mncMdgPage().verifyCompanyProfileOnPage();
	}
	
	@Step
	public void verifyCompanyProfileAsMdgOnPage() {
		mncMdgPage().verifyCompanyProfileAsMdgOnPage();
	}
	
	@Step
	public void clickOnExportAndVerify(String extension) {
		mncMdgPage().clickOnExportAndVerify(extension);		
	}
	
	@Step
	public void exportMNCTrialUserMessage(String extension) {
		mncMdgPage().exportAsTrialUser(extension);
	}

	@Step
	public void verifyMdgExpandableSectionsName(String companyLoc,String job) {
		mncMdgPage().verifyMdgExpandableSectionsName(companyLoc, job);
		
	}

	@Step
	public void goBackToTheInitialPage() {
		mncMdgPage().goBackToTheInitialPage();		
	}

	@Step
	public void verifyPaginatorOnPage() {
		mncMdgPage().verifyPaginatorOnPage();
		
	}

	@Step
	public void verifyPaginatorOnPageMdg() {
		mncMdgPage().verifyPaginatorOnPageMdg();
		
	}

	@Step
	public void verifySavedMNCInSavedCOntent(String savedMnc, String saveMncName) {
		mncMdgPage().verifySavedMNCInSavedCOntent(savedMnc, saveMncName);
		
	}

	@Step
	public void verifySavedMncMatchesCompanySearchSelections(String company) {
		mncMdgPage().verifySavedMncMatchesCompanySearchSelections(company);
		
	}

	@Step
	public void clickOnTheCompanyFromTheList() {
		mncMdgPage().clickOnTheCompanyFromTheList();
		
	}
	}
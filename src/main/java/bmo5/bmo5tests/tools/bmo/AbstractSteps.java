package bmo5.bmo5tests.tools.bmo;

import net.thucydides.core.steps.ScenarioSteps;
import bmo5.bmo5tests.adm.pages.ClientAccountsPage;
import bmo5.bmo5tests.adm.pages.subnational.EntityMaintenancePage;
import bmo5.bmo5tests.bmo.pages.AdvancedSearchPage;
import bmo5.bmo5tests.bmo.pages.AuthenticationTypesPage;
import bmo5.bmo5tests.bmo.pages.BmoGuidePage;
import bmo5.bmo5tests.bmo.pages.CostCodesPage;
import bmo5.bmo5tests.bmo.pages.CreateChildAccountPage;
import bmo5.bmo5tests.bmo.pages.DataToolPage;
import bmo5.bmo5tests.bmo.pages.EmailPopUpWindowPage;
import bmo5.bmo5tests.bmo.pages.EntrepriseAccountPage;
import bmo5.bmo5tests.bmo.pages.ForgotPasswordPage;
import bmo5.bmo5tests.bmo.pages.HotTopicArticlePage;
import bmo5.bmo5tests.bmo.pages.LoginPage;
import bmo5.bmo5tests.bmo.pages.MncMdgPage;
import bmo5.bmo5tests.bmo.pages.MyAccountPage;
import bmo5.bmo5tests.bmo.pages.PDFUserLandingPage;
import bmo5.bmo5tests.bmo.pages.PDFUserListingPage;
import bmo5.bmo5tests.bmo.pages.PreviewArticleWindowPage;
import bmo5.bmo5tests.bmo.pages.SavedArticlesSavedDataPage;
import bmo5.bmo5tests.bmo.pages.SavedContentPage;
import bmo5.bmo5tests.bmo.pages.SavedReportsPage;
import bmo5.bmo5tests.bmo.pages.SavedViewsSavedSearchesSavedMncPage;
import bmo5.bmo5tests.bmo.pages.ServiceUpdatePage;
import bmo5.bmo5tests.bmo.pages.SingleArticlePage;
import bmo5.bmo5tests.bmo.pages.SingleReportPage;
import bmo5.bmo5tests.bmo.pages.WebinarsAndPodcastsPage;
import bmo5.bmo5tests.bmo.pages.homepage.AlertsPage;
import bmo5.bmo5tests.bmo.pages.homepage.FilterPanelDailyAnalysisPage;
import bmo5.bmo5tests.bmo.pages.homepage.FilterPanelNewsPage;
import bmo5.bmo5tests.bmo.pages.homepage.FilterPanelSpecialRepPage;
import bmo5.bmo5tests.bmo.pages.homepage.FiltersPanelGeoPivotPage;
import bmo5.bmo5tests.bmo.pages.homepage.FinancialMarketsPage;
import bmo5.bmo5tests.bmo.pages.homepage.FooterPage;
import bmo5.bmo5tests.bmo.pages.homepage.HomePage;
import bmo5.bmo5tests.bmo.pages.homepage.HomePageHeaderPage;
import bmo5.bmo5tests.bmo.pages.homepage.HomePageLevelOnePage;
import bmo5.bmo5tests.bmo.pages.homepage.HomePageLevelThreePage;
import bmo5.bmo5tests.bmo.pages.homepage.HomePageLevelTwoPage;
import bmo5.bmo5tests.bmo.pages.homepage.HomePagePillarsPage;
import bmo5.bmo5tests.bmo.pages.homepage.HomePageTopMenuPage;
import bmo5.bmo5tests.bmo.pages.homepage.KeyGlobalViewsBmoPage;
import bmo5.bmo5tests.bmo.pages.homepage.SearchPage;
import bmo5.bmo5tests.bmo.pages.homepage.SpecialReportsPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.BMIDatabasesBurdenOfDiseasePage;
import bmo5.bmo5tests.bmo.pages.pillarPages.BMIDatabasesGeneralPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.BMIDatabasesGlobalMinesPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.BMIDatabasesKeyProjectsPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.BMIDatabasesMobileOperatorsPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.BMIDatabasesUpstreamProjectsPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.BmiDatabasesFeedInTariffsPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.BmiDatabasesGlobalRefineriesPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.DailyAnalysisAndNewsPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.DataAndForecastingPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.FilterPanelPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.NoEntitlementsForUserPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.RatingsPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.ReportsArchiveLandingPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.ReportsArchiveListingPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.ReportsPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.StrategicAnalysisAndReportsPage;
import bmo5.bmo5tests.bmo.pages.pillarPages.StrategicAnalysisPage;

public class AbstractSteps extends ScenarioSteps {

	private static final long serialVersionUID = -8264542787518371173L;

	
	public void navigateTo(String url){
		getDriver().get(url);
	}

	public LoginPage loginPage() {
		return getPages().currentPageAt(LoginPage.class);
	}

	public EntrepriseAccountPage entrepriseAccountPage() {
		return getPages().currentPageAt(EntrepriseAccountPage.class);
		
	}
	public HomePageHeaderPage homePageHeaderPage() {
		return getPages().currentPageAt(HomePageHeaderPage.class);
	}

	public ForgotPasswordPage forgotPasswordPage() {
		return getPages().currentPageAt(ForgotPasswordPage.class);
	}

	public HomePageTopMenuPage homePageTopMenuPage() {
		return getPages().currentPageAt(HomePageTopMenuPage.class);
	}

	public HomePageLevelOnePage homePageLevelOnePage() {
		return getPages().currentPageAt(HomePageLevelOnePage.class);
	}

	public HomePageLevelTwoPage homePageLevelTwoPage(){
		return getPages().currentPageAt(HomePageLevelTwoPage.class);
	}
	
	public HomePageLevelThreePage homePageLevelThreePage(){
		return getPages().currentPageAt(HomePageLevelThreePage.class);
	}
	
	public HomePagePillarsPage homePagePillarsPage() {
		return getPages().currentPageAt(HomePagePillarsPage.class);
	}

	public DailyAnalysisAndNewsPage dailyAnalysisAndNewsPage() {
		return getPages().currentPageAt(DailyAnalysisAndNewsPage.class);
	}

	public FilterPanelPage filterPanelPage() {
		return getPages().currentPageAt(FilterPanelPage.class);
	}

	public StrategicAnalysisAndReportsPage strategicAnalysisAndReportsPage() {
		return getPages().currentPageAt(StrategicAnalysisAndReportsPage.class);
	}

	public ServiceUpdatePage serviceUpdatePage() {
		return getPages().currentPageAt(ServiceUpdatePage.class);
	}

	public ReportsArchiveLandingPage reportsArchiveLandingPage() {
		return getPages().currentPageAt(ReportsArchiveLandingPage.class);
	}

	public ReportsArchiveListingPage reportsArchiveListingPage() {
		return getPages().currentPageAt(ReportsArchiveListingPage.class);
	}

	public MyAccountPage myAccountPage() {
		return getPages().currentPageAt(MyAccountPage.class);
	}

	public HotTopicArticlePage hotTopicArticlePage() {
		return getPages().currentPageAt(HotTopicArticlePage.class);
	}

	public SingleArticlePage singleArticlePage() {
		return getPages().currentPageAt(SingleArticlePage.class);
	}

	public WebinarsAndPodcastsPage webinarsAndPodcastsPage() {
		return getPages().currentPageAt(WebinarsAndPodcastsPage.class);
	}

	public SpecialReportsPage specialReportsPage() {
		return getPages().currentPageAt(SpecialReportsPage.class);
	}

	public FilterPanelSpecialRepPage filterPanelSpecialRepPage() {
		return getPages().currentPageAt(FilterPanelSpecialRepPage.class);
	}

	public FilterPanelNewsPage filterPanelNewsPage() {
		return getPages().currentPageAt(FilterPanelNewsPage.class);
	}

	public FilterPanelDailyAnalysisPage filterPanelDailyAnalysisPage() {
		return getPages().currentPageAt(FilterPanelDailyAnalysisPage.class);
	}

	public EmailPopUpWindowPage emailPopUpWindowPage() {
		return getPages().currentPageAt(EmailPopUpWindowPage.class);
	}

	public PreviewArticleWindowPage previewArticleWindowPage() {
		return getPages().currentPageAt(PreviewArticleWindowPage.class);
	}
	
	public SingleReportPage singleReportPage(){
		return getPages().currentPageAt(SingleReportPage.class);
	}
	
	public SavedContentPage savedContentPage(){
		return getPages().currentPageAt(SavedContentPage.class);
	}
	
	public FooterPage footerPage(){
		return getPages().currentPageAt(FooterPage.class);
	}
	
	public AdvancedSearchPage advancedSearchPage(){
		return getPages().currentPageAt(AdvancedSearchPage.class);
	}
	
	public SearchPage searchPage(){
		return getPages().currentPageAt(SearchPage.class);
	}
	
	public DataAndForecastingPage dataAndForecastingPage() {
		return getPages().currentPageAt(DataAndForecastingPage.class);
	}
	
	public FiltersPanelGeoPivotPage filtersPanelGeoPivotPage() {
		return getPages().currentPageAt(FiltersPanelGeoPivotPage.class);
	}
	
	public DataToolPage dataToolPage() {
		return getPages().currentPageAt(DataToolPage.class);
	}
	
	public ReportsPage reportsPage() {
		return getPages().currentPageAt(ReportsPage.class);
	}
	
	public NoEntitlementsForUserPage noEntitlementsForUserPage() {
		return getPages().currentPageAt(NoEntitlementsForUserPage.class);
	}
	
	public MncMdgPage mncMdgPage() {
		return getPages().currentPageAt(MncMdgPage.class);
	}
	
	public PDFUserLandingPage pdfUserLandingPage(){
		return getPages().currentPageAt(PDFUserLandingPage.class);
	}
	
	public PDFUserListingPage pdfUserListingPage(){
		return getPages().currentPageAt(PDFUserListingPage.class);
	}

	public FinancialMarketsPage financialMarketsPage() {
		return getPages().currentPageAt(FinancialMarketsPage.class);
	}
	
	public HomePage homePage() {
		return getPages().currentPageAt(HomePage.class);
	}
	
	public ClientAccountsPage clientAccountsPage() {
		return getPages().currentPageAt(ClientAccountsPage.class);
	}
	
	public StrategicAnalysisPage strategicAnalysisPage(){
		return getPages().currentPageAt(StrategicAnalysisPage.class);
	}
	
	public BMIDatabasesKeyProjectsPage bmiDatabasesKeyProjectsPage(){
		return getPages().currentPageAt(BMIDatabasesKeyProjectsPage.class);
	}

	public BMIDatabasesGlobalMinesPage bmiDatabasesGlobalMinesPage(){
		return getPages().currentPageAt(BMIDatabasesGlobalMinesPage.class);
	}

	public BMIDatabasesGeneralPage bmiDatabasesGeneralPage(){
		return getPages().currentPageAt(BMIDatabasesGeneralPage.class);
	}
	
	public BMIDatabasesMobileOperatorsPage bmiDatabasesMobileOperatorsPage(){
		return getPages().currentPageAt(BMIDatabasesMobileOperatorsPage.class);
	}
	
	public BMIDatabasesBurdenOfDiseasePage bmiDatabasesBurdenOfDiseasePage(){
		return getPages().currentPageAt(BMIDatabasesBurdenOfDiseasePage.class);
	}
	
	public CostCodesPage costCodesPage(){
		return getPages().currentPageAt(CostCodesPage.class);
	}
	
	public AlertsPage alertsPage() {
		return getPages().currentPageAt(AlertsPage.class);
	}
	
	public SavedArticlesSavedDataPage savedArticlesSavedDataPage(){
		return getPages().currentPageAt(SavedArticlesSavedDataPage.class);
	}
	
	public SavedReportsPage savedReportsPage(){
		return getPages().currentPageAt(SavedReportsPage.class);
	}
	
	public SavedViewsSavedSearchesSavedMncPage savedViewsSavedSearchesSavedMncPage(){
		return getPages().currentPageAt(SavedViewsSavedSearchesSavedMncPage.class);
	}
	
	public BmoGuidePage bmoGuidePage(){
		return getPages().currentPageAt(BmoGuidePage.class);
	}
	
	public BMIDatabasesUpstreamProjectsPage bmiDatabasesUpstreamProjectsPage(){
		return getPages().currentPageAt(BMIDatabasesUpstreamProjectsPage.class);
	}

	public CreateChildAccountPage createChildAccountPage(){
		return getPages().currentPageAt(CreateChildAccountPage.class);
	}
	
	public KeyGlobalViewsBmoPage keyGlobalViewsBmoPage(){
		return getPages().currentPageAt(KeyGlobalViewsBmoPage.class);
	}

	public RatingsPage ratingsPage(){
		return getPages().currentPageAt(RatingsPage.class);
	}

	public BmiDatabasesFeedInTariffsPage bmiDatabasesFeedInTariffsPage(){
		return getPages().currentPageAt(BmiDatabasesFeedInTariffsPage.class);
	}
	
	public AuthenticationTypesPage authenticationTypesPage(){
		return getPages().currentPageAt(AuthenticationTypesPage.class);
	}
	
	public BmiDatabasesGlobalRefineriesPage bmiDatabasesGlobalRefineriesPage(){
		return getPages().currentPageAt(BmiDatabasesGlobalRefineriesPage.class);
	}
	
	public EntityMaintenancePage entityMaintenancePage(){
		return getPages().currentPageAt(EntityMaintenancePage.class);
	}
}

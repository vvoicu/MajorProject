package bmo5.bmo5tests.tools.adm;

import net.thucydides.core.steps.ScenarioSteps;
import bmo5.bmo5tests.adm.pages.ArticlesManagementPage;
import bmo5.bmo5tests.adm.pages.AssetClassStrategyPage;
import bmo5.bmo5tests.adm.pages.BMIReportsPage;
import bmo5.bmo5tests.adm.pages.BmiReportsAddProductPage;
import bmo5.bmo5tests.adm.pages.ClientAccountsPage;
import bmo5.bmo5tests.adm.pages.CompanyMetadataPage;
import bmo5.bmo5tests.adm.pages.LoginPage;
import bmo5.bmo5tests.adm.pages.MenuNavigationPage;
import bmo5.bmo5tests.adm.pages.MethodologiesPage;
import bmo5.bmo5tests.adm.pages.NDBKeyProjectsPage;
import bmo5.bmo5tests.adm.pages.StrategicContentCategoriesPage;
import bmo5.bmo5tests.adm.pages.dvpakcs.ADM_DvPacks_GenerateDVPack_GeneralPage;
import bmo5.bmo5tests.adm.pages.dvpakcs.ADM_DvPacks_Listing_GeneralPage;
import bmo5.bmo5tests.adm.pages.dvpakcs.Adm_DvPacks_CreateDvPack_GeneralPage;
import bmo5.bmo5tests.adm.pages.dvpakcs.Adm_Dvpacks_CreateDvpack_CustomDvPack_GeneralPage;
import bmo5.bmo5tests.adm.pages.dvpakcs.Adm_Dvpacks_PreviewAndAprove_GeneralPage;
import bmo5.bmo5tests.adm.pages.dvpakcs.Create_And_Delete_CMSTemplateDvPackTablePage;
import bmo5.bmo5tests.adm.pages.dvpakcs.Create_DynamicDvPackTable_WidgetTypePage;
import bmo5.bmo5tests.adm.pages.dvpakcs.Create_StaticDvPack_WidgetTypePage;
import bmo5.bmo5tests.adm.pages.dvpakcs.Create_StaticDvPack_WidgetType_SelectOptionPage;
import bmo5.bmo5tests.adm.pages.dvpakcs.Create_TemplateDvPackTable_SystemType_GlobalMinesPage;
import bmo5.bmo5tests.adm.pages.dvpakcs.DatapacksPage;
import bmo5.bmo5tests.adm.pages.dvpakcs.Delete_DvPacksPage;
import bmo5.bmo5tests.adm.pages.subnational.BulkUploadLogPage;
import bmo5.bmo5tests.adm.pages.subnational.EntityMaintenancePage;
import bmo5.bmo5tests.adm.pages.subnational.EntityTypePage;
import bmo5.bmo5tests.adm.pages.systemalerts.ClientUpdatesPage;
import bmo5.bmo5tests.adm.pages.systemalerts.CreateHelpPage;
import bmo5.bmo5tests.adm.pages.systemalerts.HelpPage;
import bmo5.bmo5tests.adm.pages.widgets.AddWidgetPage;
import bmo5.bmo5tests.adm.pages.widgets.AnalystsChoicePage;
import bmo5.bmo5tests.adm.pages.widgets.BusinessRulesWidgetsPage;
import bmo5.bmo5tests.adm.pages.widgets.CarouselEditPage;
import bmo5.bmo5tests.adm.pages.widgets.CarouselPage;
import bmo5.bmo5tests.adm.pages.widgets.EventsPage;
import bmo5.bmo5tests.adm.pages.widgets.FinancialAdmMarketsPage;
import bmo5.bmo5tests.adm.pages.widgets.HotTopicsPage;
import bmo5.bmo5tests.adm.pages.widgets.KeyGlobalForecastsPage;
import bmo5.bmo5tests.adm.pages.widgets.KeyGlobalViewsPage;
import bmo5.bmo5tests.adm.pages.widgets.KeyMarketForecastsPage;
import bmo5.bmo5tests.adm.pages.widgets.ManageWidgetsPage;
import bmo5.bmo5tests.adm.pages.widgets.WebinarsAndPodcastsWidgetsPage;

/**
 * These steps will contain pages only from adm package
 *
 */
public class AbstractAdmSteps extends ScenarioSteps{

	private static final long serialVersionUID = 7447106821715801605L;

	public void navigateTo(String url){
		getDriver().get(url);
	}
	
	public LoginPage loginPage(){
		return getPages().currentPageAt(LoginPage.class);
	}
	
	public MenuNavigationPage menuNavigationPage(){
		return getPages().currentPageAt(MenuNavigationPage.class);
	}
	
	public ManageWidgetsPage manageWidgetsPage(){
		return getPages().currentPageAt(ManageWidgetsPage.class);
	}
	
	public AddWidgetPage addWidgetPage(){
		return getPages().currentPageAt(AddWidgetPage.class);
	}
	
	public HelpPage helpPage(){
		return getPages().currentPageAt(HelpPage.class);
	}
	
	public ADM_DvPacks_Listing_GeneralPage adm_DvPacks_listingPage() {
		return getPages().currentPageAt(ADM_DvPacks_Listing_GeneralPage.class);
	}
	
	public Adm_Dvpacks_PreviewAndAprove_GeneralPage admDvpacks_PreviewAndAprovePage(){
		return getPages().currentPageAt(Adm_Dvpacks_PreviewAndAprove_GeneralPage.class);
	}
	
	public Adm_Dvpacks_CreateDvpack_CustomDvPack_GeneralPage create_CustomDVPack_SystemTypePage() {
		return getPages().currentPageAt(Adm_Dvpacks_CreateDvpack_CustomDvPack_GeneralPage.class);
	}
	
	public CreateHelpPage createHelpPage(){
		return getPages().currentPageAt(CreateHelpPage.class);
	}
	
	public HotTopicsPage hotTopicsPage(){
		return getPages().currentPageAt(HotTopicsPage.class);
	}

	public ClientAccountsPage clientAccountsPage(){
		return getPages().currentPageAt(ClientAccountsPage.class);
	}
	
	public CarouselPage carouselPage(){
		return getPages().currentPageAt(CarouselPage.class);
	}
	
	public KeyGlobalViewsPage keyGlobalViewsPage(){
		return getPages().currentPageAt(KeyGlobalViewsPage.class);
	}
	
	public EventsPage eventsPage(){
		return getPages().currentPageAt(EventsPage.class);
	}
	
	public AnalystsChoicePage analystsChoicePage(){
		return getPages().currentPageAt(AnalystsChoicePage.class);
	}
	
	public BusinessRulesWidgetsPage businessRulesWidgetsPage(){
		return getPages().currentPageAt(BusinessRulesWidgetsPage.class);
	}
	
	public WebinarsAndPodcastsWidgetsPage webinarsAndPodcastsWidgetsPage(){
		return getPages().currentPageAt(WebinarsAndPodcastsWidgetsPage.class);
	}
	
	public FinancialAdmMarketsPage financialMarketsPage(){
		return getPages().currentPageAt(FinancialAdmMarketsPage.class);
	}
	
	public Create_StaticDvPack_WidgetTypePage create_StaticDVPack_WidgetTypePage(){
		return getPages().currentPageAt(Create_StaticDvPack_WidgetTypePage.class);
	}
	
	public Create_StaticDvPack_WidgetType_SelectOptionPage create_StaticDVPack_WidgetType_SelectOptionPage(){
		return getPages().currentPageAt(Create_StaticDvPack_WidgetType_SelectOptionPage.class);
	}
	
	public Create_TemplateDvPackTable_SystemType_GlobalMinesPage create_TemplateDvPackTable_SystemType_GlobalMinesPage(){
		return getPages().currentPageAt(Create_TemplateDvPackTable_SystemType_GlobalMinesPage.class);
	}
	
	public Create_And_Delete_CMSTemplateDvPackTablePage create_And_Delete_CMSTemplateDvPackTablePage(){
		return getPages().currentPageAt(Create_And_Delete_CMSTemplateDvPackTablePage.class);
	}
	
	public Create_DynamicDvPackTable_WidgetTypePage create_DynamicDvPackTable_WidgetTypePage(){
		return getPages().currentPageAt(Create_DynamicDvPackTable_WidgetTypePage.class);
	}

	public Delete_DvPacksPage delete_DvPacksPage(){
		return getPages().currentPageAt(Delete_DvPacksPage.class);
	}
	
	public CarouselEditPage carouselEditPage(){
		return getPages().currentPageAt(CarouselEditPage.class);
	}
	
	public ArticlesManagementPage articlesManagementPage(){
		return getPages().currentPageAt(ArticlesManagementPage.class);
	}
	
	public DatapacksPage datapacksPage(){
		return getPages().currentPageAt(DatapacksPage.class);
	}
	
	public AssetClassStrategyPage assetClassStrategyPage(){
		return getPages().currentPageAt(AssetClassStrategyPage.class);
	}
	
	public NDBKeyProjectsPage ndbKeyProjectsPage(){
		return getPages().currentPageAt(NDBKeyProjectsPage.class);
	}
	
	public ClientUpdatesPage clientUpdatesPage(){
		return getPages().currentPageAt(ClientUpdatesPage.class);
	}
	
	public Adm_DvPacks_CreateDvPack_GeneralPage adm_DvPacks_CreateDvPack_GeneralPage(){
		return getPages().currentPageAt(Adm_DvPacks_CreateDvPack_GeneralPage.class);
	}
	
	public ADM_DvPacks_GenerateDVPack_GeneralPage adm_DvPacks_GenerateDVPack_GeneralPage() {
		return getPages().currentPageAt(ADM_DvPacks_GenerateDVPack_GeneralPage.class);
	} 
	
	public StrategicContentCategoriesPage strategicContentCategoriesPage() {
		return getPages().currentPageAt(StrategicContentCategoriesPage.class);
	}
	
	public MethodologiesPage methodologiesPage() {
		return getPages().currentPageAt(MethodologiesPage.class);
	}
	
	public KeyGlobalForecastsPage kgfPage(){
		return getPages().currentPageAt(KeyGlobalForecastsPage.class);
	}
	
	public EntityTypePage entityTypePage() {
		return getPages().currentPageAt(EntityTypePage.class);
	}
	
	public BulkUploadLogPage bulkUploadLogPage() {
		return getPages().currentPageAt(BulkUploadLogPage.class);
	}
	
	public EntityMaintenancePage entityMaintenancePage(){
		return getPages().currentPageAt(EntityMaintenancePage.class);
	} 
	
	public KeyMarketForecastsPage keyMarketForecastsPage(){
		return getPages().currentPageAt(KeyMarketForecastsPage.class);
	} 
	
	public CompanyMetadataPage companyMetadataPage(){
		return getPages().currentPageAt(CompanyMetadataPage.class);
	} 
	
	public BMIReportsPage bmiReportsPage(){
		return getPages().currentPageAt(BMIReportsPage.class);
	} 
	
	public BmiReportsAddProductPage bmiReportsAddProductPage(){
		return getPages().currentPageAt(BmiReportsAddProductPage.class);
	} 
}

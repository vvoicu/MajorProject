package bmo5.bmo5tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import bmo5.bmo5tests.tests.adm.Adm_AccountManagement_ClientAccounts_CreateChild;
import bmo5.bmo5tests.tests.adm.Adm_AccountManagement_ClientAccounts_CreateUser;
import bmo5.bmo5tests.tests.adm.Adm_AccountManagement_ClientAccounts_DuplicateUser;
import bmo5.bmo5tests.tests.adm.BMO5_028_1_Adm_DvPacks_listing;
import bmo5.bmo5tests.tests.adm.Bmo5_022_7_StrategicContentCategories;
import bmo5.bmo5tests.tests.adm.Bmo5_040_1_Adm_WidgetsManageWidgetsPage;
import bmo5.bmo5tests.tests.adm.Bmo5_040_2_Adm_Widgets_ManageWidgets_Search_DeleteHelp;
import bmo5.bmo5tests.tests.adm.Bmo5_040_5_Adm_Widgets_ManageWidgetsVerifySlots_Help;
import bmo5.bmo5tests.tests.adm.Bmo5_040_Adm_Widgets_ManageWidgets_CreateEditDelete;
import bmo5.bmo5tests.tests.adm.Bmo5_042_1_Adm_Widgets_Hot_Topics;
import bmo5.bmo5tests.tests.adm.Bmo5_042_2_Adm_Widgets_Hot_Topics_New;
import bmo5.bmo5tests.tests.adm.Bmo5_043_1_Adm_Widgets_Analysts_Choice;
import bmo5.bmo5tests.tests.adm.Bmo5_043_2_Adm_Widgets_Analysts_Choice_New;
import bmo5.bmo5tests.tests.adm.Bmo5_044_Adm_Widgets_Key_Global_Views;
import bmo5.bmo5tests.tests.adm.Bmo5_045_Adm_WidgetsCarousel;
import bmo5.bmo5tests.tests.adm.Bmo5_045_Adm_Widgets_Key_Global_Forecasts;
import bmo5.bmo5tests.tests.adm.Bmo5_047_1_Adm_Widgets_Webinars_And_Podcasts;
import bmo5.bmo5tests.tests.adm.Bmo5_048_1_Adm_WidgetsEvents;
import bmo5.bmo5tests.tests.adm.Bmo5_050_1_Adm_Help_Page;
import bmo5.bmo5tests.tests.adm.Bmo5_050_2_Adm_Help_Search_And_Delete;
import bmo5.bmo5tests.tests.adm.Bmo5_058_22_Adm_DvPacks_Create_And_Delete_CMSTemplateDvPackTable;
import bmo5.bmo5tests.tests.adm.Bmo5_059_1_Adm_FinancialMarketsAssetClassStrategy;
import bmo5.bmo5tests.tests.adm.Bmo5_059_2_Adm_Widgets_FinancialMarketsKeyForecasts;
import bmo5.bmo5tests.tests.adm.Bmo5_064_3_Adm_Datapacks;
import bmo5.bmo5tests.tests.adm.Bmo5_064_Adm_DataPacks_CreateDatapackAddToBmo;
import bmo5.bmo5tests.tests.adm.Bmo5_070_Adm_KeyMarketForecasts;
import bmo5.bmo5tests.tests.adm.Bmo5_074_1_Adm_Subnational_EntityTable;
import bmo5.bmo5tests.tests.adm.Bmo5_074_2_Adm_Subnational_CreateEntity;
import bmo5.bmo5tests.tests.adm.Bmo5_074_3_Adm_Subnational_EditEntity;
import bmo5.bmo5tests.tests.adm.Bmo5_074_4_Adm_EntityTypeCRUD;
import bmo5.bmo5tests.tests.adm.Bmo5_074_5_Adm_BulkUploadLogTest;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_AnalystChoiceWidgetAddToBmo;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_BusinessRulesWidgets_AnalystsChoiceContent;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_BusinessRulesWidgets_DeleteAllAutomatedWidgets;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_BusinessRulesWidgets_DvPacks;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_BusinessRulesWidgets_Media;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_Business_RulesWidgets;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_Datapack_Table;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_System_Chart;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_System_Table;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_Widget_Chart;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_Widget_Table;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_DvPacks_CreateDvPack_Static_System_Chart;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_DvPacks_CreateDvPack_Static_System_Table;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_DvPacks_CreateDvPack_Static_Widget_Chart;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_DvPacks_CreateDvPack_Static_Widget_Table;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_DvPacks_CreateDvPack_Template_System_Chart;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_DvPacks_CreateDvPack_Template_System_Table;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_DvPacks_CreateDvpack_Custom_System_Chart;
import bmo5.bmo5tests.tests.adm.Bmo5_Adm_DvPacks_DeleteDvPack_Static_Widget_Table;
import bmo5.bmo5tests.tests.adm.Test_039_11_Articles_Management;
import bmo5.bmo5tests.tests.adm.Test_039_13_BmiReports_ProductSearch;
import bmo5.bmo5tests.tests.adm.Test_039_14_CompanyMetadata;
import bmo5.bmo5tests.tests.bmo.Test_025_2_DataAndForecastingPage_UserDoesNotHaveEntitlementsForCountryRisk;
import bmo5.bmo5tests.tests.bmo.Test_066_1_Adm_Bmo_Optional_CostCodes;
import bmo5.bmo5tests.tests.bmo.Test_066_Adm_Bmo_Mandatory_CostCodes;
import bmo5.bmo5tests.tests.bmo.Test_Authentication_Enterprise_Login_By_Form_Based;
import bmo5.bmo5tests.tests.bmo.Test_Authentication_Enterprise_Login_By_Ip_And_Url;
import bmo5.bmo5tests.tests.bmo.Test_Authentication_Enterprise_Login_By_Url;
import bmo5.bmo5tests.tests.bmo.Test_Filters_ClearFilters_BMIDatabases_MO_and_BOD;
import bmo5.bmo5tests.tests.bmo.Test_Filters_ClearFilters_DataTool;
import bmo5.bmo5tests.tests.bmo.Test_Filters_ClearFilters_GeographyPivot;
import bmo5.bmo5tests.tests.bmo.Test_Filters_ClearFilters_Ratings;
import bmo5.bmo5tests.tests.bmo.Test_Filters_ClearFilters_ServicePivot;
import bmo5.bmo5tests.tests.bmo.Test_LessEntitlements_AnalystChoiceWidget;
import bmo5.bmo5tests.tests.bmo.Test_LessEntitlements_BMIDatabases;
import bmo5.bmo5tests.tests.bmo.Test_LessEntitlements_BusinessRulesWidgets;
import bmo5.bmo5tests.tests.bmo.Test_LessEntitlements_CarouselDvpack;
import bmo5.bmo5tests.tests.bmo.Test_LessEntitlements_Geography_Pivot;
import bmo5.bmo5tests.tests.bmo.Test_LessEntitlements_KeyGlobalForecasts;
import bmo5.bmo5tests.tests.bmo.Test_LessEntitlements_Ratings;
import bmo5.bmo5tests.tests.bmo.Test_LessEntitlements_Service_Pivot;
import bmo5.bmo5tests.tests.bmo.Test_Persistence_AcrossTabs_GeographyPivot;
import bmo5.bmo5tests.tests.bmo.Test_Perssistence_AcrossTabs_ServicePivot;
import bmo5.bmo5tests.tests.bmo.Test_RegularUser_KeyGlobalForecasts;
import bmo5.bmo5tests.tests.bmo.Test_RegularUser_KeyGlobalViews;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_AdvancedSearch;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_Analysis;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_Carousel;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_CompanyIntelligence_Export;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_ContactAccountManager;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_CostCodes;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_DailyViews;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_DataAndForecasting_DvPack;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_DataTool;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_HotTopics;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_KeyGlobalForecasts;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_KeyGlobalViews;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_News;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_Ratings;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_Reports;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_ReportsAndStrategicContent;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_ReportsArchive;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_SavedContent_SavedArticles;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_SavedContent_SavedData;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_SavedContent_SavedReports;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_SpecialReports;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_StrategicContent;
import bmo5.bmo5tests.tests.bmo.Test_TrialUser_Widgets;

@RunWith(Suite.class)
@SuiteClasses({
	
	 Test_TrialUser_AdvancedSearch.class,
	    Test_TrialUser_Carousel.class,
	    Test_TrialUser_CompanyIntelligence_Export.class,
	    Test_TrialUser_ContactAccountManager.class,
	    Test_TrialUser_DailyViews.class,
	    Test_TrialUser_Analysis.class,
	    Test_TrialUser_News.class,
	    Test_TrialUser_DataAndForecasting_DvPack.class,
	    Test_TrialUser_DataTool.class,
	    Test_TrialUser_HotTopics.class,
	    Test_TrialUser_KeyGlobalForecasts.class,
	    Test_TrialUser_KeyGlobalViews.class,
	    Test_TrialUser_Ratings.class,
	    Test_TrialUser_ReportsAndStrategicContent.class,
	    Test_TrialUser_Reports.class,
	    Test_TrialUser_StrategicContent.class,
	    Test_TrialUser_ReportsArchive.class,
	    Test_TrialUser_SpecialReports.class,
	    Test_TrialUser_SavedContent_SavedArticles.class,
	    Test_TrialUser_SavedContent_SavedReports.class,
	    Test_TrialUser_SavedContent_SavedData.class,
	    Test_TrialUser_Widgets.class,
	   
	    Adm_AccountManagement_ClientAccounts_CreateUser.class,
	    Adm_AccountManagement_ClientAccounts_DuplicateUser.class,
	    Adm_AccountManagement_ClientAccounts_CreateChild.class,
		Bmo5_022_7_StrategicContentCategories.class,
		BMO5_028_1_Adm_DvPacks_listing.class,
		Bmo5_040_1_Adm_WidgetsManageWidgetsPage.class,
		Bmo5_040_2_Adm_Widgets_ManageWidgets_Search_DeleteHelp.class,
		Bmo5_040_Adm_Widgets_ManageWidgets_CreateEditDelete.class,
		Bmo5_040_5_Adm_Widgets_ManageWidgetsVerifySlots_Help.class,
		Bmo5_042_1_Adm_Widgets_Hot_Topics.class,
		Bmo5_042_2_Adm_Widgets_Hot_Topics_New.class,
		Bmo5_043_1_Adm_Widgets_Analysts_Choice.class,
		Bmo5_043_2_Adm_Widgets_Analysts_Choice_New.class,
		Bmo5_044_Adm_Widgets_Key_Global_Views.class,
		Bmo5_045_Adm_WidgetsCarousel.class,
		Bmo5_047_1_Adm_Widgets_Webinars_And_Podcasts.class,
		Bmo5_048_1_Adm_WidgetsEvents.class,
		Bmo5_050_1_Adm_Help_Page.class,
		Bmo5_050_2_Adm_Help_Search_And_Delete.class,
		Bmo5_058_22_Adm_DvPacks_Create_And_Delete_CMSTemplateDvPackTable.class,
		Bmo5_059_1_Adm_FinancialMarketsAssetClassStrategy.class,
		Bmo5_059_2_Adm_Widgets_FinancialMarketsKeyForecasts.class,
		Bmo5_045_Adm_Widgets_Key_Global_Forecasts.class,
		Bmo5_Adm_Business_RulesWidgets.class,
		Bmo5_Adm_BusinessRulesWidgets_DvPacks.class,
		Bmo5_Adm_BusinessRulesWidgets_Media.class,
		Bmo5_Adm_BusinessRulesWidgets_AnalystsChoiceContent.class,
		Bmo5_064_Adm_DataPacks_CreateDatapackAddToBmo.class,
		Bmo5_064_3_Adm_Datapacks.class,
		Bmo5_070_Adm_KeyMarketForecasts.class,
		Bmo5_074_1_Adm_Subnational_EntityTable.class,
		Bmo5_074_2_Adm_Subnational_CreateEntity.class,
		Bmo5_074_3_Adm_Subnational_EditEntity.class,
		Bmo5_074_4_Adm_EntityTypeCRUD.class,
		Bmo5_074_5_Adm_BulkUploadLogTest.class,
		Bmo5_Adm_AnalystChoiceWidgetAddToBmo.class,
		Bmo5_Adm_DvPacks_CreateDvpack_Custom_System_Chart.class,
		Bmo5_Adm_DvPacks_CreateDvPack_Static_System_Chart.class,
		Bmo5_Adm_DvPacks_CreateDvPack_Static_System_Table.class,
		Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_System_Chart.class,
		Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_System_Table.class,
		Bmo5_Adm_DvPacks_CreateDvPack_Template_System_Chart.class,
		Bmo5_Adm_DvPacks_CreateDvPack_Template_System_Table.class,
		Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_Datapack_Table.class,
		Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_Widget_Chart.class,
		Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_Widget_Table.class,
		Bmo5_Adm_DvPacks_CreateDvPack_Static_Widget_Chart.class,
		Bmo5_Adm_DvPacks_CreateDvPack_Static_Widget_Table.class,
		Bmo5_Adm_DvPacks_DeleteDvPack_Static_Widget_Table.class,
		Test_039_11_Articles_Management.class,
		Test_039_13_BmiReports_ProductSearch.class,
		Test_039_14_CompanyMetadata.class,
		
		Test_025_2_DataAndForecastingPage_UserDoesNotHaveEntitlementsForCountryRisk.class,
		
		Test_RegularUser_KeyGlobalForecasts.class,
		Test_RegularUser_KeyGlobalViews.class,
		
		Test_LessEntitlements_Geography_Pivot.class,
		Test_LessEntitlements_Service_Pivot.class,
		Test_LessEntitlements_Ratings.class,
		Test_LessEntitlements_BusinessRulesWidgets.class,
		Test_LessEntitlements_AnalystChoiceWidget.class,
		Test_LessEntitlements_BMIDatabases.class,
		Test_LessEntitlements_CarouselDvpack.class,
		Test_LessEntitlements_KeyGlobalForecasts.class,
		Test_Filters_ClearFilters_GeographyPivot.class,
		Test_Filters_ClearFilters_ServicePivot.class,
		Test_Filters_ClearFilters_DataTool.class,
		Test_Filters_ClearFilters_BMIDatabases_MO_and_BOD.class,
		Test_Filters_ClearFilters_Ratings.class,
		Test_Perssistence_AcrossTabs_ServicePivot.class,
		Test_Persistence_AcrossTabs_GeographyPivot.class,
		
		Test_Authentication_Enterprise_Login_By_Url.class,
		Test_Authentication_Enterprise_Login_By_Ip_And_Url.class,
		Test_Authentication_Enterprise_Login_By_Form_Based.class,
		Bmo5_Adm_BusinessRulesWidgets_DeleteAllAutomatedWidgets.class,
		Test_TrialUser_CostCodes.class,
		Test_066_Adm_Bmo_Mandatory_CostCodes.class,
		Test_066_1_Adm_Bmo_Optional_CostCodes.class,

})
public class SuiteNodeTwo {

}

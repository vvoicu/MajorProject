package bmo5.bmo5tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import bmo5.bmo5tests.tests.bmo.*;

@RunWith(Suite.class)
@SuiteClasses({
	Test_060_1_BmiDatabases_Key_Projects_Filters.class,
	Test_060_2_BmiDatabases_Global_Mines_Filters.class,
	Test_060_3_BmiDatabases_Mobile_Operators_Filters.class,
	Test_060_4_BmiDatabases_Burden_Of_Disease_Filters.class,
	Test_060_5_BmiDatatabes_UpstreamProjects_Filters.class,
	Test_060_6_BmiDatabases_DVPacksChart.class,
	Test_060_6_BmiDatabases_LargeAmountOfData.class,
	Test_060_7_BmiDatabases_Mobile_Operators_Table.class,
	Test_060_8_BmiDatabases_Burden_Of_Disease_Table.class,
	Test_060_10_BmiDatabases_DvPacks_Chart_Print.class,
	Test_060_11_BmiDatabases_DvPacks_Chart_Select.class,
	Test_060_12_BmiDatabases_DvPacks_Chart_Export.class,
	Test_060_13_BmiDatabases_DvPacks_Chart_New_Text_Annotation.class,
	Test_060_14_BmiDatabases_DvPacks_Chart_Edit_Text_Annotation.class,
	Test_060_15_BmiDatabases_DvPacks_Chart_Delete_Text_And_Line_Annotation.class,
	Test_060_16_BmiDatabases_DvPacks_Chart_New_Line_Annotation.class,
	Test_060_17_BmiDatabases_DvPacks_Chart_Edit_Line_Annotation.class,
	Test_060_19_BmiDatabases_DvPacks_Chart_Format.class,
	Test_060_20_BmiDatabases_DvPacks_Table_Add_New_Cell_Annotation.class,
	Test_060_21_BmiDatabases_DvPacks_Table_Edit_New_Cell_Annotation.class,
	Test_060_22_BmiDatabases_DvPacks_Table_Delete_Cell_And_Row_Annotations.class,
	Test_060_23_BmiDatabases_DvPacks_Table_Add_New_Row_Annotation.class,
	Test_060_24_BmiDatabases_DvPacks_Table_Edit_New_Row_Annotation.class,
	Test_060_26_Bmi_Databases_FeedInTariffs.class,
	Test_060_27_Bmi_Databases_ExecutiveContacts.class,
	Test_060_30_BmiDatabses_GlobalRefineries_Filters.class,
	Test_69_Bmi_Databases_MedicalDistributorsGuide.class,
	Test_063_2_SavedData_RefreshKeyProjects.class,
	
	Test_001_02_01_Enterprise_Login_Login.class,
	Test_001_Enterprise_Login_MyBmo.class,
    Test_001_Enterprise_AdvancedSearch.class,
    Test_001_Enterprise_CreateChildAccount.class,
    Test_001_Enterprise_CompanyIntelligence.class,
    Test_001_Enterprise_HotTopics.class,
    Test_001_Enteprise_DailyViews_Save.class,
    Test_001_Enterprise_Analysis.class,
    Test_001_Enterprise_News.class,
    Test_001_Enterprise_ReportsAndStrategicContent.class,
    Test_001_Enterprise_ReportsArchive.class,
    Test_001_Enterprise_Reports_Save.class,
    Test_001_Enterprise_SpecialReports_Save.class,
    Test_001_Enterprise_DataAndForecasting_DvPack.class,
    Test_001_Enterprise_DataTool.class,
    Test_001_Enterprise_BmiDatabases.class,
    Test_001_Enterprise_Carousel.class,
    Test_001_Enterprise_KeyGlobalViews.class,
    Test_001_Enterprise_KeyGlobalForecasts.class,
    Test_001_Enterprise_ContactUs_Email.class,
    Test_001_Enterprise_Widgets.class,
    Test_001_Enterprise_CostCodes.class,
    Test_001_Enterprise_Logout.class,
})
public class SuiteNodeThree {

}

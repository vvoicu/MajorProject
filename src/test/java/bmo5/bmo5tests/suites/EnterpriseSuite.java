package bmo5.bmo5tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import bmo5.bmo5tests.tests.bmo.*;

@RunWith(Suite.class)
@SuiteClasses({
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

public class EnterpriseSuite {

}

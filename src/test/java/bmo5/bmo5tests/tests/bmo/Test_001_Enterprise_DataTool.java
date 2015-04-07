package bmo5.bmo5tests.tests.bmo;

import junit.framework.TestCase;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.homepage.HomePagePillarsSteps;
import bmo5.bmo5tests.bmo.steps.pillars.BMIDatabasesGeneralSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;

@Story(Application.Enterprise.Pillars.DataAndForecasting.DataTool.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX + "Test_001_Enterprise_DataTool.csv", separator = ',')

public class Test_001_Enterprise_DataTool extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST_IP)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	@Steps
	public HomePagePillarsSteps homePagePillarSteps;
	
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	@Steps
	public BMIDatabasesGeneralSteps bmiDatabasesGeneralSteps;

	String geography, indicatorOne, dataToolBreadcrumbs, dataTool, formatJpg, formatPng, extentionJpg, extentionPng, extentionXls;
	
	@Test
	public void test_001_Enterprise_DataTool() {
		homePagePillarSteps.clickOnNavigationalTabByLinkTextAndVerify(dataToolBreadcrumbs);
		dataToolSteps.filterExpandSearchSelectGeography(geography);
		dataToolSteps.filterExpandSearchSelectIndicator(indicatorOne);
		dataToolSteps.clickFilterDisplayDataButton();
		dataToolSteps.clickSaveButtonEnterpriseUser();
		dataToolSteps.clickOnExportButton();
		dataToolSteps.verifyExportWindowDefaultState();
		dataToolSteps.verifyExportChart(formatJpg, extentionJpg);
		dataToolSteps.verifyExportChart(formatPng, extentionPng);
		dataToolSteps.clickOnTableRadioButton();
		dataToolSteps.verifyExportTable(extentionXls);
		dataToolSteps.clickOnTableAndChartRadioButton();
		dataToolSteps.verifyExportChartAndTable(extentionXls);
		dataAndForecastingSteps.clickOnDownloadDataTool(extentionXls);
	}
}

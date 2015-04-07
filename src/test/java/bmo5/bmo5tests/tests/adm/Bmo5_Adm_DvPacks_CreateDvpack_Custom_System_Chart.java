package bmo5.bmo5tests.tests.adm;

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

import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.ADM_DvPacks_GenerateDVPack_GeneralSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.ADM_DvPacks_Listing_GeneralSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Adm_DvPacks_CreateDvPack_GeneralSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Adm_Dvpacks_PreviewAndAprove_GeneralSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Adm_DvPacks_CreateDvPack_Custom_GeneralSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.adm.steps.widgets.WebinarsAndPodcastsWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;


@Story(Application.Adm.DvPacks.ManageDvPacks.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_Adm_DvPacks_CreateDvpack_Custom_System_Chart.csv", separator=',')

public class Bmo5_Adm_DvPacks_CreateDvpack_Custom_System_Chart extends TestCase {

	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	
	@Steps 
	public ADM_DvPacks_Listing_GeneralSteps adm_DvPacks_listingSteps;
	
	@Steps 
	public Adm_DvPacks_CreateDvPack_Custom_GeneralSteps customDvPackSteps;
	
	@Steps
	public Adm_DvPacks_CreateDvPack_GeneralSteps adm_DvPacks_CreateDvPack_GeneralSteps;
	
	@Steps 
	public ADM_DvPacks_Listing_GeneralSteps adm_DvPacks_Listing_GeneralSteps;
	
	@Steps
	public ADM_DvPacks_GenerateDVPack_GeneralSteps adm_DvPacks_GenerateDVPack_GeneralSteps;
	
	@Steps
	public Adm_Dvpacks_PreviewAndAprove_GeneralSteps adm_Dvpacks_PreviewAndAprove_GeneralSteps;
	
	@Steps
	public WebinarsAndPodcastsWidgetsSteps webinarsAndPodcastsSteps;
	
	public String username, password,name,title,subtitle,description,type, years, data,newButtonText,generateDvPacksPageBreadcrumbs,dvPackType,defaultView,expectedDvPackname, expectedDvPackTitle, expectedDvPackDescription,expectedDvPackSubtitle;
    public String dvPackname,dvPackTitle,dvPackSubTitle,dvPackDescription,editDvPackPageBreadcrumbs,createCustomDvPackPageBreadcrumbs,dvPackId,previewDvPackPageBreadcrumbs,confirmationpageBreadcrumbs,renderType,geography, channel;
    public String textAnnotationType, size, rotation,newDescription, newSize, newRotation,arrowAnnotationType, lineType,newLineType,lineAnnotationType;
    private static int line = 0;
	public void setName(String name) {
		this.name = name+"_"+StringUtils.randomNumber(84000)+"_"+StringUtils.randomNumber(84000);
	}
	
	@Test
	
	public void bmo5_Adm_DvPacks_CreateDvpack_Custom_System_Chart(){
		loginSteps.performLogin(username,password);
		line++;
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageDVPacks);
		adm_DvPacks_Listing_GeneralSteps.verifyBreadcrumbsDVPacks();
		adm_DvPacks_Listing_GeneralSteps.verifyColumnName();
		adm_DvPacks_Listing_GeneralSteps.clickOnAddNewDvPackButton(newButtonText);
		menuNavigationSteps.verifyBreadCrumb(generateDvPacksPageBreadcrumbs);
		adm_DvPacks_GenerateDVPack_GeneralSteps.selectDvPackTypeTypeAndDefaultView(dvPackType, type, defaultView);
		expectedDvPackname = adm_DvPacks_GenerateDVPack_GeneralSteps.inputNameForDvPack(dvPackname);
		expectedDvPackTitle = adm_DvPacks_GenerateDVPack_GeneralSteps.inputTitleForDvPack(dvPackTitle);
		expectedDvPackSubtitle = adm_DvPacks_GenerateDVPack_GeneralSteps.inputSubTitleForDvPack(dvPackSubTitle);
		expectedDvPackDescription = adm_DvPacks_GenerateDVPack_GeneralSteps.inputDescriptionForDvPack(dvPackDescription);
		adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
		menuNavigationSteps.verifyBreadCrumb(createCustomDvPackPageBreadcrumbs);
	//	adm_DvPacks_CreateDvPack_GeneralSteps.clickOnBackButton();//I can't reproduce this manually, automated test doesn't display the chart if it goes back
	//	menuNavigationSteps.verifyBreadCrumb(editDvPackPageBreadcrumbs);
	//	adm_DvPacks_GenerateDVPack_GeneralSteps.verifyTypeAndDefaultView(dvPackType, defaultView);
	//	adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
	//	menuNavigationSteps.verifyBreadCrumb(createCustomDvPackPageBreadcrumbs);
	//	adm_DvPacks_GenerateDVPack_GeneralSteps.clickAndVerifyContinueButton();
		customDvPackSteps.insertRowdata(years, data);
		customDvPackSteps.clickOnContinueButtonFromEditPage();
		customDvPackSteps.verifyButtonsPresenceForStaticDvPAck();
		
		adm_DvPacks_CreateDvPack_GeneralSteps.addTextAnnotationToChartAndVerify(textAnnotationType, size, description, rotation);
		adm_DvPacks_CreateDvPack_GeneralSteps.editCancelAndVerifyTextAnnotation(description, size, rotation, newDescription, newSize, newRotation);
		adm_DvPacks_CreateDvPack_GeneralSteps.editSaveAndVerifyTextAnnotation(description, size, rotation, newDescription, newSize, newRotation);
		adm_DvPacks_CreateDvPack_GeneralSteps.removeAndVerifyTextAnnotation(newDescription, newSize, newRotation);
		
		adm_DvPacks_CreateDvPack_GeneralSteps.addArrowAnnotationToChartAndVerify(arrowAnnotationType, lineType);
		adm_DvPacks_CreateDvPack_GeneralSteps.editCancelAndVerifyArrowChartAnnotation(lineType, newLineType);
		adm_DvPacks_CreateDvPack_GeneralSteps.editSaveAndVerifyArrowChartAnnotation(lineType, newLineType);
		adm_DvPacks_CreateDvPack_GeneralSteps.removeAndVerifyArrowAnnotation(newLineType);
		
		adm_DvPacks_CreateDvPack_GeneralSteps.addLineAnnotationToChartAndVerify(lineAnnotationType, lineType);
		adm_DvPacks_CreateDvPack_GeneralSteps.editCancelAndVerifyLineChartAnnotation(lineType, newLineType);
		adm_DvPacks_CreateDvPack_GeneralSteps.editSaveAndVerifyLineChartAnnotation(lineType, newLineType);
		adm_DvPacks_CreateDvPack_GeneralSteps.removeAndVerifyLineAnnotation(newLineType);
		
		adm_DvPacks_CreateDvPack_GeneralSteps.verifyChartTitle(expectedDvPackTitle);
		adm_DvPacks_CreateDvPack_GeneralSteps.verifyChartSubtitle(expectedDvPackSubtitle);
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnFormatChartAndVerify(expectedDvPackTitle, expectedDvPackSubtitle, expectedDvPackDescription,dvPackType);
		customDvPackSteps.clickContinueButtonFromPreviewPage();
		menuNavigationSteps.verifyBreadCrumb(previewDvPackPageBreadcrumbs);
		if(type.equals("widget")){
		webinarsAndPodcastsSteps.selectTaggingOptions(geography, channel);
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
		}
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyNameFromPreview(expectedDvPackname);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyTitleFromPreview(expectedDvPackTitle);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.verifyChartIsDisplayedInPreview();
		adm_DvPacks_CreateDvPack_GeneralSteps.clickOnContinueButton();
		menuNavigationSteps.verifyBreadCrumb(confirmationpageBreadcrumbs);
		dvPackId = adm_Dvpacks_PreviewAndAprove_GeneralSteps.getDvpackIDConfirmationPage(Constants.ADM_RESOURCES_PREFIX + "Bmo5_Adm_DvPacks_CreateDvpack_Custom_System_Chart.csv", line);
		adm_Dvpacks_PreviewAndAprove_GeneralSteps.clickOnDvPackListButton();
		adm_DvPacks_Listing_GeneralSteps.checkTableIntoListView(dvPackId, expectedDvPackname, expectedDvPackTitle, type, renderType, "", dvPackType);
		
	}
}

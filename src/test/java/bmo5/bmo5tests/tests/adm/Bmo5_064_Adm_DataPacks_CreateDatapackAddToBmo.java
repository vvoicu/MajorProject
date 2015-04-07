package bmo5.bmo5tests.tests.adm;

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
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.Create_DynamicDvPackTable_WidgetTypeSteps;
import bmo5.bmo5tests.adm.steps.dvpacks.DatapackSteps;
import bmo5.bmo5tests.adm.steps.widgets.BusinessRulesWidgetsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

@Story(Application.Adm.Widgets.BusinessRulesWidgets.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_064_1_2_Adm_DataPacks.csv", separator=',')

public class Bmo5_064_Adm_DataPacks_CreateDatapackAddToBmo {
	@Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages(defaultUrl = Constants.ADM_HOST)
	public Pages pages;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public  bmo5.bmo5tests.bmo.steps.LoginSteps bmo5LoginSteps;
	
	@Steps
	public LoginSteps admLoginSteps;
	
	@Steps
	public MenuNavigationSteps menuNavigationSteps;
	
	@Steps
	public BusinessRulesWidgetsSteps businessRulesWidgetsSteps;
	
	@Steps
	public DatapackSteps datapackSteps;
	
	@Steps
	public ManageWidgetsSteps manageWidgetsSteps;
	
	@Steps
	public Create_DynamicDvPackTable_WidgetTypeSteps create_DynamicDvPackTable_WidgetTypeSteps;
	
	public String bmo5Username, bmo5Password,admUsername,searchGeography, admPassword, name,analysis,news, title,excelName,parentIndicator, database,geographyTaggingOption, serviceTaggingOption,companyTaggingOption, datapackType,dvpackID,reportIssueNumber;
	public String status,extension, refine, contentType, contextType, subContextType,slotsFrom,slotsTo, navCondGeo, navCondService, navCondCat, navCondComp,retOutGeo, retOutService, retOutCat, retOutComp, taggingTypeGeo, taggingTypeService, taggingTypeCategory, taggingTypeCompany, page, widgetType, area,slot,pivotPoint, pivotName, npcSens,cleanupWidget,savedName,widgetId,savedTitle, continent,otherRating, records,deleteWidget,serviceLeftHandFilter,geographyLeftHandFilter,serviceException, articleTypeNumber,serviceOptionToRefine,geographyOptionToRefine, hotTopicsPageNumber,countryId,addException,articleId;
	int itemNumber;
	public String widgetContainer,optionId,	widgetContainerSAR,	widgetContainerPreview,	divsReports,divsSAR,download;

	@Test
	public void bmo5_064_Adm_DataPacks_CreateDatapackAddToBmo() {
		loginSteps.performLogin(admUsername, admPassword);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		if (datapackType.equals("dvpack")) {
		
			menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageDVPacks);
			create_DynamicDvPackTable_WidgetTypeSteps.createDynamicDataPackDvpack(name, title, database,searchGeography, parentIndicator);
			dvpackID = create_DynamicDvPackTable_WidgetTypeSteps.getDVpackID(); 
			menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		}
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DataPacks);
		datapackSteps.clickAddNewDatapackButton();
		String savedDatapackTitle=datapackSteps.typeDatapackTitle(title);
		datapackSteps.selectDataPackType(datapackType);
		if (datapackType.equals("upload_excel")) {
			datapackSteps.uploadExcel(excelName);
		}

		if (datapackType.equals("dvpack")) {
			datapackSteps.typeDvpackID(dvpackID);
		}
		datapackSteps.selectPrimaryTaggingOptions(geographyTaggingOption,
				serviceTaggingOption, companyTaggingOption);
		datapackSteps.clickContinueButton();
		datapackSteps.verifySuccessMessage();
		datapackSteps.verifySuccessfullySavedMessage();
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.BusinessRulesWidgets);
		Sleeper.sleepTight(1000);
		businessRulesWidgetsSteps.clickOnBuildNewWidgetButton();
	
		businessRulesWidgetsSteps.typeWidgetName(name);
		businessRulesWidgetsSteps.typeWidgetTitle(title);
		businessRulesWidgetsSteps.selectContentType(contentType);
		businessRulesWidgetsSteps.selectContextType(contextType);
		businessRulesWidgetsSteps.selectSubContextType(contextType, subContextType);
		businessRulesWidgetsSteps.selectStatusRadiobutton(status);
		businessRulesWidgetsSteps.selectRefineRadiobutton(refine);
		businessRulesWidgetsSteps.clickOnBuildWidgetButton();
		businessRulesWidgetsSteps.verifyEditWidgetPage(name,title,contentType,contextType);
		
		businessRulesWidgetsSteps.clickAddNewRuleLink();
		businessRulesWidgetsSteps.typeSlotsFromValue(slotsFrom);
	    businessRulesWidgetsSteps.typeSlotsToValue(slotsTo);	
	    
	    if(contextType.equals("Details")){
	    	businessRulesWidgetsSteps.clickArticleType(articleTypeNumber);
	    }
	    
	    businessRulesWidgetsSteps.selectConditions(navCondGeo, navCondService, navCondCat, navCondComp);
        businessRulesWidgetsSteps.selectReturnedOutputOptions(retOutGeo, retOutService, retOutCat, retOutComp);
        businessRulesWidgetsSteps.selectTaggingType(taggingTypeGeo, taggingTypeService,taggingTypeCategory, taggingTypeCompany);
        businessRulesWidgetsSteps.clickAddRuleButton();
        
        savedName=businessRulesWidgetsSteps.getSavedName();
        savedTitle=businessRulesWidgetsSteps.getSavedTitle();
        
	    if(contextType.equals("General")){
			businessRulesWidgetsSteps.clickOnExceptionsMiniTab();
			businessRulesWidgetsSteps.clickAddNewExceptionButton();
			if(pivotPoint.contains("Industry")&&addException.equals("yes")){
				businessRulesWidgetsSteps.selectServiceExcption(serviceException);
				businessRulesWidgetsSteps.clickOnBuildWidgetButton();
				
			} 
		}
     
        menuNavigationSteps.selectMenuItem(AdmMenuItems.ManageWidgets);
        manageWidgetsSteps.addWidgetOption();
        String subPageName=	manageWidgetsSteps.addPageOptionToWidget(page,hotTopicsPageNumber);
		manageWidgetsSteps.selectTypeFroWidget(widgetType);
		widgetId=manageWidgetsSteps.selectWidgetName(savedName); 
		manageWidgetsSteps.selectAreaWidget(area);
		manageWidgetsSteps.selectNPCWidget(npcSens);
		manageWidgetsSteps.pivotForWidget(pivotPoint);
		manageWidgetsSteps.selectPivotName(pivotPoint,pivotName);
	//	manageWidgetsSteps.selectSlot(slot);
		manageWidgetsSteps.clickOnWidgetCleanup(cleanupWidget);
		if(businessRulesWidgetsSteps.checkSlotsAvailable()){
		manageWidgetsSteps.addNewWidgetButtonFromForm ();
		manageWidgetsSteps.confirmationMessageWidget();
		menuNavigationSteps.admLogout();
		businessRulesWidgetsSteps.navigateTo(Constants.BMO_HOST);
		bmo5LoginSteps.performLogin(bmo5Username, bmo5Password);	
//TODO fix this
		//		businessRulesWidgetsSteps.clickOnSelectedPage(page,pivotPoint, pivotName, continent, otherRating,analysis,news, itemNumber, contentType,subContextType, serviceLeftHandFilter, geographyLeftHandFilter,subPageName,countryId, articleTypeNumber, articleId, reportIssueNumber);
		
		if(page.contains("Preview")){
		//	businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInPreview(savedTitle);
			businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle,widgetContainerPreview);
			businessRulesWidgetsSteps.clickFirstArticleFromWidget(widgetContainerPreview, savedTitle, widgetId, contentType);
			if(download.equals("yes")){
				//TODO fix this
				//		businessRulesWidgetsSteps.verifyDownloadedExcel(extension);
			}
		}
		
		else if(page.contains("Hot Topics")){
			boolean foundHotTopic =businessRulesWidgetsSteps.checkHotTopicsAvailableOnBmoAndClick(subPageName);
			if(foundHotTopic){
				//businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInRatingsExplorationPageAndDetails(savedTitle);
				businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle, widgetContainer);
				businessRulesWidgetsSteps.clickFirstArticleFromWidget(widgetContainer, savedTitle, widgetId, contentType);
				if(download.equals("yes")){
					//TODO fix this
					//		businessRulesWidgetsSteps.verifyDownloadedExcel(extension);
				}
			}
		}
		
		else if(page.equals("Strategic Analysis & Reports")){
			businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInReportsAndSARPages(savedTitle, widgetContainerSAR,divsSAR);
			businessRulesWidgetsSteps.clickFirstArticleFromWidget(widgetContainerSAR, savedTitle, widgetId, contentType);
			if(download.equals("yes")){
				//TODO fix this
				//				businessRulesWidgetsSteps.verifyDownloadedExcel(extension);
			}
		}
		
		else if(page.equals("Reports")^page.equals("Strategic Analysis")){
			businessRulesWidgetsSteps.checkIfWidgetIsDisplayedInReportsAndSARPages(savedTitle, widgetContainerSAR, divsReports);
			businessRulesWidgetsSteps.clickFirstArticleFromWidget(widgetContainerSAR, savedTitle, widgetId, contentType);
			if(download.equals("yes")){
				//TODO fix this
				//				businessRulesWidgetsSteps.verifyDownloadedExcel(extension);
			}
		}
	
		else{
		businessRulesWidgetsSteps.checkIfWidgetIsDisplayed(savedTitle,widgetContainer);
		businessRulesWidgetsSteps.clickFirstArticleFromWidget(widgetContainer, savedTitle, widgetId, contentType);
		if(download.equals("yes")){
			//TODO fix this
//			businessRulesWidgetsSteps.verifyDownloadedExcel(extension);
				}
			}
	
		if(refine.equals("1")){
				if(pivotPoint.equals("Geography")){	
			businessRulesWidgetsSteps.clickServiceFromLeftHandFilter(serviceOptionToRefine);
			if(page.equals("Reports")^page.equals("Strategic Analysis")){
			businessRulesWidgetsSteps.selectRefineOptionForWidget(serviceOptionToRefine, savedTitle, widgetContainerSAR,optionId);
			}
			else if(page.equals("Strategic Analysis & Reports")){
				businessRulesWidgetsSteps.selectRefineOptionForWidget(serviceOptionToRefine, savedTitle, widgetContainerSAR,optionId);
			}
			else
				businessRulesWidgetsSteps.selectRefineOptionForWidget(serviceOptionToRefine, savedTitle, widgetContainer,optionId);
			
	   }
		else if(pivotPoint.equals("Industry")) {
			businessRulesWidgetsSteps.clickContinentFromLeftHandFilter(geographyOptionToRefine);
			if(page.equals("Reports")^page.equals("Strategic Analysis")){
			businessRulesWidgetsSteps.selectRefineOptionForWidget(geographyOptionToRefine, savedTitle, widgetContainerSAR,optionId);
			}
			else if(page.equals("Strategic Analysis & Reports")){
				businessRulesWidgetsSteps.selectRefineOptionForWidget(geographyOptionToRefine, savedTitle, widgetContainerSAR,optionId);
			}
			else
				businessRulesWidgetsSteps.selectRefineOptionForWidget(geographyOptionToRefine, savedTitle, widgetContainer,optionId);
		}
		}
		
//		if(!serviceException.equals("")){
//			businessRulesWidgetsSteps.selectFinancialMartketsTopNav();
//			businessRulesWidgetsSteps.checkIfWidgetIsNotDisplayed(savedTitle);
//		}
		}
		else{
			System.out.println("No Slots available, skip this test!");
	//		log.info("No Slots available, skip this test!");
			menuNavigationSteps.admLogout();//end current session to avoid caching and test failures.
		}
		//TODO check for errors
		businessRulesWidgetsSteps.navigateTo(Constants.ADM_HOST);
		loginSteps.performLogin(admUsername, admPassword);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DVPacks);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.DataPacks);
		datapackSteps.typeSavedDatapackTitle(savedDatapackTitle);
	    Sleeper.sleepTight(2000);
		datapackSteps.clickDeleteButtonForADatapack();
		menuNavigationSteps.selectMenuItem(AdmMenuItems.Widgets);
		menuNavigationSteps.selectMenuItem(AdmMenuItems.BusinessRulesWidgets);
		businessRulesWidgetsSteps.deleteWidgetsByName(savedName);
		}
}

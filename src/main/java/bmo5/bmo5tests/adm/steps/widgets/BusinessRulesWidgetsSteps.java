package bmo5.bmo5tests.adm.steps.widgets;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;

public class BusinessRulesWidgetsSteps extends AbstractAdmSteps{
	
	private static final long serialVersionUID = -6545856029780858884L;
//    private boolean found;
	

	@StepGroup
	public void selectConditions(String geography, String service, String category, String company){
		selectConditionGeography(geography);
		selectConditionService(service);
		selectConditionCategory(category);
		selectConditionCompany(company);
	}
	
	@StepGroup
	public void selectReturnedOutputOptions(String geography, String service, String category, String company){
		selectRetOutputGeography(geography);
		selectRetOutputService(service);
		selectRetOutputCategory(category);
		selectRetOutputCompany(company);
	}
	
	@StepGroup
	public void selectTaggingType(String taggingTypeGeo, String taggingTypeService, String taggingTypeCategory, String taggingTypeCompany){
		selectTaggingTypeGeography(taggingTypeGeo);
		selectTaggingTypeService(taggingTypeService);
		selectTaggingTypeCategory(taggingTypeCategory);
		selectTaggingTypeCompany(taggingTypeCompany);
	}
	
	@StepGroup
	public void clickFirstArticleAndCheckSaveButtonForEnterprise(String widgetContainer, String savedWidgetTitle, String widgetId, String contentType){
		clickFirstArticleFromWidget(widgetContainer, savedWidgetTitle, widgetId, contentType);
		clickSaveButtonAndCheckModal();
	}
	
	//TODO fix this
//	@StepGroup
//	public void clickViewMoreButtonAndVerifySaveForEnterprise(String widgetContainer, String savedTitle, String contentType, String widgetId){
//		found=clickViewMoreButton(widgetContainer, savedTitle,contentType,widgetId); 
//		if(found){
//	    verifySaveButtonEnterpriseViewMoreListing();
//		}
//	}
//	
//	@StepGroup
//	public void clickViewMoreButtonAndVerifyDownloadAndPrintForTrial(String widgetContainer, String savedTitle, String contentType, String widgetId){
//		found=clickViewMoreButton(widgetContainer, savedTitle,contentType,widgetId); 
//		if(found){
//		verifyDownloadTrialViewMoreListing();
//		verifyPrintTrialViewMoreListing();
//		}
//	}
	
	@StepGroup
	public void clickFirstArticleAndCheckDownloadAndPrintButtonForTrial(String widgetContainer, String savedWidgetTitle, String widgetId, String contentType){
		clickFirstArticleFromWidget(widgetContainer, savedWidgetTitle, widgetId, contentType);
		clickPrintButtonAndCheckModal();
		clickDownloadButtonAndCheckModal();
	}
	
	@StepGroup
	public void clickFirstArticleAndVerifyPageNotFound(String widgetContainer, String savedWidgetTitle, String widgetId, String contentType){
		clickFirstArticleFromWidget(widgetContainer, savedWidgetTitle, widgetId, contentType);
		businessRulesWidgetsPage().verifyPageNotFoundIsNotDisplayed();
	}
	
	@StepGroup
	public void selectOptionsForBuildWidget(String name, String title, String contentType, String contextType, String subContextType, String status, String refine, String viewMore){
		typeWidgetName(name); 
		typeWidgetTitle(title);
		selectContentType(contentType);
		selectContextType(contextType);
		selectSubContextType(contextType, subContextType);
		selectStatusRadiobutton(status);
		selectRefineRadiobutton(refine);
		selectViewMoreRadiobutton(viewMore);
	    clickOnBuildWidgetButton();
	}
	
	@Step
	public void clickOnBuildNewWidgetButton(){
		businessRulesWidgetsPage().clickOnBuildNewWidgetButton();
	}
	
	@Step
	public void selectStatusRadiobutton(String status){
		businessRulesWidgetsPage().selectStatusRadiobutton( status);
	}
	
	@Step
	public void selectRefineRadiobutton(String refine){
		businessRulesWidgetsPage().selectRefineRadiobutton( refine);
	}
	
	@Step
	public void selectViewMoreRadiobutton(String viewMore){
		businessRulesWidgetsPage().selectViewMoreRadiobutton( viewMore);
	}
	
	@Step
	public void typeWidgetName(String name){
		businessRulesWidgetsPage().typeName(name);
	}
	
	@Step
	public void typeWidgetTitle(String title){
		businessRulesWidgetsPage().typeTitle(title);
	}
	
	@Step
	public void selectContentType(String contentType){
		businessRulesWidgetsPage().selectContentType(contentType);
	}
	
	@Step
	public void selectContextType(String contextType){
		businessRulesWidgetsPage().selectContextType(contextType);
	}
	
	@Step
	public void selectSubContextType(String contextType, String subContextType){
		businessRulesWidgetsPage().selectSubContextType(contextType, subContextType);
	}
	
	@Step
	public void clickOnBuildWidgetButton(){
		 businessRulesWidgetsPage().clickOnBuildWidgetButton();
	}

	@Step
	public void clickAddNewRuleLink(){
		businessRulesWidgetsPage().clickAddNewRuleLink();
	}
	
	@Step
	public void verifyEditWidgetPage(String name, String title, String contentType, String contextType){
		businessRulesWidgetsPage().verifyEditWidgetPage(name, title, contentType,contextType);
	}

	@Step
	public void verifyEditWidgetDvPackPage(String name, String title, String contentType, String displayOption){
		businessRulesWidgetsPage().verifyEditWidgetDvPackPage(name, title, contentType, displayOption);
	}
	
	@Step
	public void typeSlotsToValue(String toValue){
		businessRulesWidgetsPage().typeSlotsToValue(toValue);
	}
	
	@Step
	public void typeSlotsFromValue(String fromValue){
		businessRulesWidgetsPage().typeSlotsFromValue(fromValue);
	}
	
	@Step
	public void selectConditionGeography(String geography){
		businessRulesWidgetsPage().selectConditionGeography(geography);
	}
	
	@Step
	public void selectConditionService(String service){
		businessRulesWidgetsPage().selectConditionService(service);
	}
	
	@Step
	public void selectConditionCategory(String category){
		businessRulesWidgetsPage().selectConditionCategory(category);
	}
	
	@Step
	public void selectConditionCompany(String company){
		businessRulesWidgetsPage().selectConditionCompany(company);
	}
	
	@Step
	public void selectRetOutputGeography(String geography){
		businessRulesWidgetsPage().selectRetOutputGeography(geography);
	}
	
	@Step
	public void selectRetOutputService(String service){
		businessRulesWidgetsPage().selectRetOutputService(service);
	}
	
	@Step
	public void selectRetOutputCategory(String category){
		businessRulesWidgetsPage().selectRetOutputCategory(category);
	}
	
	@Step
	public void selectRetOutputCompany(String company){
		businessRulesWidgetsPage().selectRetOutputcompany(company);
	}
	
	@Step
	public void selectTaggingTypeGeography(String taggingTypeGeography){
		businessRulesWidgetsPage().selectTaggingTypeGeography(taggingTypeGeography);
	}
	
	@Step
	public void selectTaggingTypeService(String taggingTypeService){
		businessRulesWidgetsPage().selectTaggingTypeService(taggingTypeService);
	}
	
	@Step
	public void selectTaggingTypeCategory(String taggingTypeCategory){
		businessRulesWidgetsPage().selectTaggingTypeCategory(taggingTypeCategory);
	}
	
	@Step
	public void selectTaggingTypeCompany(String taggingTypeCompany){
		businessRulesWidgetsPage().selectTaggingTypeCompany(taggingTypeCompany);
	}
	
	@Step
	public void clickAddRuleButton(){
		businessRulesWidgetsPage().clickAddRuleButton();
	}
	
	@Step 
	public String getSavedName(){
		return businessRulesWidgetsPage().getSavedName();
	}
	
	@Step 
	public String getSavedTitle(){
		return businessRulesWidgetsPage().getSavedTitle();
	}
	
	//TODO fix this
//	@Step
//	public void clickOnSelectedPage(String page,String pivotPoint, String pivotName, String continent, String otherRating,String analysis,String news, int itemNumber, String contentType, String subContextType, String serviceLeftHandFilter, String geographyLeftHandFilter, String subPageName, String countryId, String articleType, String articleId, String reportIssueNumber){
//		businessRulesWidgetsPage().clickOnSelectedPage(page ,pivotPoint, pivotName, continent,otherRating,analysis,news,itemNumber, contentType, subContextType, serviceLeftHandFilter,geographyLeftHandFilter,subPageName,countryId, articleType,articleId,reportIssueNumber);
//	} 
//	
	@Step
	public void checkIfWidgetIsDisplayed(String savedTitle, String widgetContainer){
		  businessRulesWidgetsPage().checkIfWidgetIsDisplayed(savedTitle, widgetContainer);
	}

	@Step
	public void checkIfWidgetIsDisplayedInReportsAndSARPages(String savedWidgetTitle, String widgetContainer, String divs){
		 businessRulesWidgetsPage().checkIfWidgetIsDisplayedInReportsAndSARPages(savedWidgetTitle, widgetContainer, divs);
	}
	@Step
	public void recordsPerPageSelect(String records){
		businessRulesWidgetsPage().recordsPerPageSelect(records);
	}

	@Step
	public void deleteWidget (String widgetId){
		businessRulesWidgetsPage().deleteWidget(widgetId);
	}
	@Step
	public void deleteAllWidgets(String widgetName, String records){
		businessRulesWidgetsPage().deleteAllWidgets(widgetName, records);
	}
	
	@Step
	public void clickOnExceptionsMiniTab(){
		businessRulesWidgetsPage().clickOnExceptionsMiniTab();
	}
	
	@Step
	public String getSavedContextType(){
		return businessRulesWidgetsPage().getSavedContextType();
	}
	
	@Step
	public void clickAddNewExceptionButton(){
		businessRulesWidgetsPage().clickAddNewExceptionButton();
	}
	
    @Step
    public void selectServiceExcption(String serviceException){
    	businessRulesWidgetsPage().selectServiceExcption(serviceException);
    }
    
    @Step 
    public void clickArticleType(String articleTypeNumber){
    	businessRulesWidgetsPage().clickArticleType(articleTypeNumber);
    }
    
    @Step
    public void selectPivotService(String pivotName){
    	businessRulesWidgetsPage().selectPivotService(pivotName);
    }
    
    @Step
    public void selectFinancialMartketsTopNav(){
    	businessRulesWidgetsPage().selectFinancialMarketsTopNav();
    }
    
    @Step
    public void selectRefineOptionForWidget(String optionToRefine, String savedWidgetTitle, String widgetContainer, String optionId){
    	businessRulesWidgetsPage().selectRefineOptionForWidget(optionToRefine, savedWidgetTitle, widgetContainer, optionId);
    }
    
    @Step
    public void clickServiceFromLeftHandFilter(String service){
    	businessRulesWidgetsPage().clickServiceFromLeftHandFilter(service);
    }
    
    @Step
    public void clickGeographyFromLeftHandFilter(String country,String countryId, String continent){
    	businessRulesWidgetsPage().clickGeographyFromLeftHandFilter(country,countryId, continent);
    }
    
    @Step
    public void clickContinentFromLeftHandFilter(String continent){
    	businessRulesWidgetsPage().clickContinentFromLeftHandFilter(continent);
    }

    @Step
    public void selectDisplayOptionForDvPack(String displayOption){
    	businessRulesWidgetsPage().selectDisplayOptionForDvPack(displayOption);
    }

//    @Step
//    public void clickOnAnArticleAccordingToArticleType(String page, String articleId){
//    	businessRulesWidgetsPage().clickOnAnArticleAccordingToArticleType(page, articleId);
//    }
    
    @Step
    public void insertRuleDvPack(String ruleTitle, String ruleDvPackId){
    	businessRulesWidgetsPage().insertRuleDvPack(ruleTitle, ruleDvPackId);
    }
    
    @Step
    public void clickOnSelectedPageForDvPacksAndMedia(String page, String subPageName){
    	businessRulesWidgetsPage().clickOnSelectedPageForDvPacksAndMedia(page, subPageName);
    }
    
    @Step
    public void clickOnListViewButton(){
    	businessRulesWidgetsPage().clickOnListViewButton();
    }
    
    @Step
    public void deleteWidgetsByName(String widgetName){
    	businessRulesWidgetsPage().deleteWidgetsByName(widgetName);
    }
    
    @Step
    public void insertRuleMedia(String timing, String upload){
    	businessRulesWidgetsPage().insertRuleMedia(timing, upload);
    }
    
    @Step
    public boolean checkSlotsAvailable(){
    	return businessRulesWidgetsPage().checkSlotsAvailable();
    }
    
    @Step
    public boolean checkHotTopicsAvailableOnBmoAndClick(String pageName){
    	return businessRulesWidgetsPage().clickHotTopicsByName(pageName);
    }
     
    @Step
    public void clickFirstArticleFromWidget(String widgetContainer, String savedWidgetTitle, String widgetId, String contentType){
    	businessRulesWidgetsPage().clickFirstArticleFromWidget(widgetContainer, savedWidgetTitle,widgetId, contentType); 
    }

    @Step
    public void clickSaveButtonAndCheckModal(){
    	businessRulesWidgetsPage().clickSaveButtonAndCheckModalDisplayed();
    }
    
    @Step
    public void clickPrintButtonAndCheckModal(){
    	businessRulesWidgetsPage().clickPrintButtonAndCheckModal();
    }
    
    @Step
    public void clickDownloadButtonAndCheckModal(){
    	businessRulesWidgetsPage().clickDownloadButtonAndCheckModal();
    }
    
  //TODO fix this
//    @Step
//    public void clickViewMoreButtonAndVerifyIcons(String widgetContainer, String savedWidgetTitle, String contentType, String widgetId){
//    	businessRulesWidgetsPage().clickViewMoreButtonAndVerifyIcons(widgetContainer,savedWidgetTitle,contentType, widgetId);
//    }
    
    @Step
    public void searchWidgetByNameAndClickEditButton(String widgetName){
    	businessRulesWidgetsPage().searchWidgetbyNameAndClickEdit(widgetName);
    }
    
    @Step
    public void searchWidgetByNameAndVerifyDeleted(String widgetName){
    	//TODO Fix this
//    	businessRulesWidgetsPage().searchWidgetByNameAndVerifyDeleted(widgetName);
    }
    
    @Step
    public void selectOptionAndDeleteWidgetByName(String widgetName, AdmMenuItems option){
    	//TODO Fix this
//    	businessRulesWidgetsPage().selectOptionAndDeleteWidgetByName(widgetName, option);
    }
    
    @Step
    public boolean clickViewMoreButton(String widgetContainer, String savedWidgetTitle, String contentType, String widgetId){
    return	businessRulesWidgetsPage().clickViewMoreButton(widgetContainer, savedWidgetTitle, contentType, widgetId);
    }
    
    @Step
    public void clickOnUnentitledItemFromViewMoreListingAndVerifyIconsDontExistAndModal(String contentType){
    	businessRulesWidgetsPage().clickOnUnentitledItemFromViewMoreListingAndVerifyIconsDontExistAndModal(contentType);
    }
    
    @Step
    public void clickEntitledItemFromViewMorelisting(String contentType){
    	businessRulesWidgetsPage().clickEntitledItemFromViewMoreListing(contentType);
    }
   
  //TODO fix this
//    @Step
//    public void verifySaveButtonEnterpriseViewMoreListing(){
//    	businessRulesWidgetsPage().verifySaveButtonEnterpriseViewMoreListing();
//    }
//    
//    @Step
//    public void verifyDownloadTrialViewMoreListing(){
//    	businessRulesWidgetsPage().verifyDownloadTrialViewMoreListing();
//    }
//    
//    @Step
//    public void verifyPrintTrialViewMoreListing(){
//    	businessRulesWidgetsPage().verifyPrintTrialViewMoreListing();
//    }
//    
//    @Step
//    public void clickDownloadButtonAndVerifyDownloadedReport(String widgetContainer, String savedWidgetTitle, String contentType, String widgetId){
//    	businessRulesWidgetsPage().clickDownloadButtonAndVerifyDownloadedReport(widgetContainer,savedWidgetTitle,contentType,widgetId);
//    }
    
    @Step
    public void clickDownloadButtonForReportWidgetTrialUser(String widgetContainer, String savedWidgetTitle, String contentType, String widgetId){
    	businessRulesWidgetsPage().clickDownloadButtonForReportWidgetTrialUser(widgetContainer, savedWidgetTitle, contentType, widgetId);
    }
    
    @Step
    public void verifyPermissionModalByType(String type){
    	businessRulesWidgetsPage().verifyPermissionModalByType(type);
    }
    
    @Step
    public void clickOnDvpackLinkFromWidget(String widgetContainer){
    	businessRulesWidgetsPage().clickOnDvpackLinkFromWidget(widgetContainer);
    }
  
  //TODO fix this
//    @Step
//    public void verifyDownloadedExcel(String extension){
//    	businessRulesWidgetsPage().verifyDownloadedExcel(extension);
//    }
}

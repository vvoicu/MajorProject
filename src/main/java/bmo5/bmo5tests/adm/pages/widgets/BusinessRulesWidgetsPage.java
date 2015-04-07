package bmo5.bmo5tests.adm.pages.widgets;


import java.util.List;

//import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.adm.AbstractAdmPage;
//import org.apache.log4j.PropertyConfigurator;

public class BusinessRulesWidgetsPage extends AbstractAdmPage {


	@FindBy(css = "a[class='add btn']")
	private WebElement buildNewWidgetButton;

	@FindBy(css = "input[id='Name']")
	private WebElement nameInput;

	@FindBy(css = "input[id='Title']")
	private WebElement titleInput;

	@FindBy(css = "select[id='ContentType']")
	private WebElement contentTypeDropDown;

	@FindBy(css = "select[id='ContextType']")
	private WebElement contextTypeDropDown;
	
	@FindBy(css = "select#SubContext")
	private WebElement subContextTypeDropDown;
	
	@FindBy(css="button#build_widget_btn")
	private WebElement buildWidgetButton;
	
	@FindBy(css="div#business_rules_list > div > a")
	private WebElement addNewRuleLink;
	
	@FindBy(css = "div.alert.alert-success")
	private WebElement confirmMessageCreatedWidget;
	
	@FindBy(css = "input#SlotsFrom")
	private WebElement slotsFromInput;
	
	@FindBy(css = "input#SlotsTo")
	private WebElement slotsToInput;
	
	@FindBy(css = "select#Geography_1")
	private WebElement condGeographyDropDown;
	
	@FindBy(css = "select#Service_1")
	private WebElement condServiceDropDown;
	
	@FindBy(css = "select#Category_1")
	private WebElement condCategoryDropDown;
	
	@FindBy(css = "select#Company_1")
	private WebElement condCompanyDropDown;
	
	@FindBy(css = "select#GeographyRule")
	private WebElement retOutputGeographyDropDown;
	
	@FindBy(css = "select#ServiceRule")
	private WebElement retOutputServiceDropDown;
	
	@FindBy(css = "select#CategoryRule")
	private WebElement retOutputCategoryDropDown;
	
	@FindBy(css = "select#CompanyRule")
	private WebElement retOutputCompanyDropDown;
	
	@FindBy(css = "button#add_rule_btn")
	private WebElement addRuleButton;
	
	@FindBy(css = "select[name='DataTables_Table_0_length']")
	private WebElement 	recordsPerPageSelect;
	
	@FindBy(css = "table#DataTables_Table_0 > tbody")
	private WebElement businessRulesWidgetsTable;
	
	@FindBy(css = "div.bootbox.modal.fade.in")
	private WebElement deletePopUpWindow;

	@FindBy(css = "a.btn.btn-primary")
	private WebElement okDeletePopUpWindow;
	
	@FindBy(css="li[class*=restrictions] > a")
	private WebElement exceptionsTab;

	@FindBy(css="a#btn_add_row")
	private WebElement addNewExceptionButton;
	
	@FindBy(css="select#RestrictedService")
	private WebElement serviceExceptionDropdown;
	
	@FindBy(css="button#dropdownMenu1")
	private WebElement refineByButton;
	
	@FindBy(css="div[class='sidebar well'] > ul > li > ul")
	private WebElement hotTopicsContainer;
	
	@FindBy(css="div.sidebar.well > ul > li:nth-child(3) > div > ul > li:nth-child(1) > input")
    private WebElement geographySearchInput;
	
	@FindBy(css = "input#DVPack")
	private WebElement dvPackId;
	
	@FindBy(css = "button#add_rule_btn")
	private WebElement saveRuleButton;
	
	@FindBy(css = "a.list.btn")
	private WebElement listViewButton;
	
	@FindBy(css = "div.dataTables_filter > label > input")
	private WebElement searchInput;
	
	@FindBy(css = "a[class='btn btn-mini delete'] ")
	private WebElement deleteFirstWidget;
	
	@FindBy(css = "a[class='btn btn-mini'] ")
	private WebElement editFirstWidget;
	
	@FindBy(css = "a[class='btn btn-primary']")
	private WebElement okDeleteWindow;
	
	@FindBy(css = "input#Media")
	private WebElement chooseFileButton;
	
	@FindBy(css = "input#Timing")
	private WebElement timingInputBox;
	
	@FindBy(css = "a.list.btn > i.icon-edit")
	private WebElement editButtonElement;
	
	@FindBy(css="i.icon-c-floppy")
	private WebElement saveArticleButton;
	
	@FindBy(css="div[class*='media-listing'] > div:nth-child(1) > div:nth-child(2) > div > a > i.icon-c-download")
	private WebElement downloadArticleListingButton;
	
	@FindBy(css="i.icon-c-download")
	private WebElement downloadArticleButton;
	
	@FindBy(css="i.icon-c-print")
	private WebElement printArticleButton;
	
	@FindBy(css="div[id='permission-enterprise-user']")
	private WebElement enterpriseUserModal;
	
	@FindBy(css="div[id='permission-enterprise-user'] > div:nth-child(2) > button")
	private WebElement cancelLinkEnterpriseModal;
	
	@FindBy(css="div[id*='permission-modal-pdf']")
	private WebElement trialUserModalDownload;
	
	@FindBy(css="div[id*='permission-modal-pdf'] > div:nth-child(2) > button")
	private WebElement cancelLinkTrialUserModalDownload;
	
	@FindBy(css="div[id*='permission-modal-print']")
	private WebElement trialUserModalPrint;
	
	@FindBy(css="div[id*='permission-modal-print'] > div:nth-child(2) > button")
	private WebElement cancelLinkTrialUserModalPrint;
	
	@FindBy(css="ul[id*='refine_options'] > ul > li > button")
	private WebElement plusButtonRefineBy;
	
	@FindBy(css="i.icon-c-email")
	private WebElement emailButton;
	
	@FindBy(css="div#email-acc-manager-modal > div > button")
	private WebElement contactAccountManagerWindowCloseButton;
	
	@FindBy(css="button#close_preview")
	private WebElement closePreviewArticleWindow;
	
	@FindBy(css="div.alert.alert-error")
	private WebElement errorMessage;
	
	@FindBy(css="div#media-preview-container span.media-type")
	private WebElement articleTitleLink;
	
	@FindBy(css="ul.breadcrumb > li.active")
	private WebElement breadcrumbWidgetTitle;
	
	@FindBy(css="div#result > div")
	private WebElement message;
	
	@FindBy(css = "i.icon-c-cancel")
	private WebElement printPagePreviewCancel;
	
//	 static final Logger log = Logger.getLogger(BusinessRulesWidgetsPage.class);
	 
	public void clickOnListViewButton(){
		listViewButton.click();
	}
	
	public void clickOnBuildNewWidgetButton() {
		buildNewWidgetButton.click();
	}
	
	public void selectStatusRadiobutton(String status){
		getDriver().findElement(By.cssSelector("input#Status_"+status)).click();
	}
	
	public void selectRefineRadiobutton(String refine){
		getDriver().findElement(By.cssSelector("input#Refine_"+refine)).click();
	}
	
	public void selectViewMoreRadiobutton(String viewMore){
		getDriver().findElement(By.cssSelector("input#ViewAll_"+viewMore)).click();
	}

	public void typeName(String name) {
		nameInput.sendKeys(name+Integer.toString(StringUtils.randomNumber(10000)));
	}
	
	public void typeTitle(String title) {
	    titleInput.sendKeys(title+Integer.toString(StringUtils.randomNumber(10000)));
	}
	
	public void selectContentType(String contentType){
		selectFromDropdown(contentTypeDropDown, contentType);
		waitABit(1000);
	}
	
	public void selectContextType(String contextType){
		
		selectFromDropdown(contextTypeDropDown, contextType);
	}
		
	public void selectSubContextType(String contextType, String subcontextType){
		
			if(contextType.equals("General")){
				selectFromDropdown(subContextTypeDropDown,subcontextType);
			}
		}
	
	public void clickOnBuildWidgetButton() {
		buildWidgetButton.click();
	}
	
	public void clickAddNewRuleLink(){
		addNewRuleLink.click();
	}
	
	public void verifyEditWidgetPage(String name, String title, String contentType, String contextType){
		Assert.assertTrue(element(confirmMessageCreatedWidget).isDisplayed());
		Assert.assertTrue("This is not the selected name"+name, nameInput.getAttribute("value").contains(name));
		Assert.assertTrue("This is not the selected title"+title, titleInput.getAttribute("value").contains(title));
		
		checkSelectedOptionDropDown("ContentType", contentType);
		checkSelectedOptionDropDown("ContextType", contextType);
	
	} 
	
	public void verifyEditWidgetDvPackPage(String name, String title, String contentType, String displayOption){
		Assert.assertTrue(confirmMessageCreatedWidget.isDisplayed());
		waitABit(2000);
		Assert.assertTrue("This is not the selected name"+name, nameInput.getAttribute("value").contains(name));
		Assert.assertTrue("This is not the selected title"+title, titleInput.getAttribute("value").contains(title));
		
		checkSelectedOptionDropDown("ContentType", contentType);
	}
	
	public void checkSelectedOptionDropDown(String dropDownID, String optionToCheck){
		Select dropDown= new Select(getDriver().findElement(By.id(dropDownID)));
		WebElement selectedOption=dropDown.getFirstSelectedOption();
	    Assert.assertTrue("This is not the selected option", selectedOption.getText().contains(optionToCheck));	
	}
	
	public void typeSlotsToValue(String toValue){
		slotsToInput.clear();
		slotsToInput.sendKeys(toValue);
	}
	
	public void typeSlotsFromValue(String fromValue){
		slotsFromInput.clear();
		slotsFromInput.sendKeys(fromValue);
	}
	
	public void selectConditionGeography(String geography){
		selectFromDropdown(condGeographyDropDown,geography);
	}
	
	public void selectConditionService(String service){
		selectFromDropdown(condServiceDropDown,service);
	}
	
	public void selectConditionCategory(String category){
		selectFromDropdown(condCategoryDropDown, category);
	}
	
	public void selectConditionCompany(String company){
		selectFromDropdown(condCompanyDropDown, company);
	}
	
	public void selectRetOutputGeography(String geography){
		selectFromDropdown(retOutputGeographyDropDown, geography);
	}
	
	public void selectRetOutputService(String service){
		selectFromDropdown(retOutputServiceDropDown, service);
	}
	
	public void selectRetOutputCategory(String category){
		selectFromDropdown(retOutputCategoryDropDown, category);
	}
	
	public void selectRetOutputcompany(String company){
		selectFromDropdown(retOutputCompanyDropDown, company);
	}
	
	public void selectTaggingTypeGeography(String taggingTypeGeography){
		elementClick("input#MatchGeography"+taggingTypeGeography);
	}
	
	public void selectTaggingTypeService(String taggingTypeService){
		elementClick("input#MatchService"+taggingTypeService);
	}
	
	public void selectTaggingTypeCategory(String taggingTypeCategory){
		elementClick("input#MatchCategory"+taggingTypeCategory);
	}
	
	public void selectTaggingTypeCompany(String taggingTypeCompany){
		elementClick("input#MatchCompany"+taggingTypeCompany);
	}
	
	public void clickAddRuleButton(){
		elementClick("button#add_rule_btn");
		//TODO Fix this
//		AbstractPage absPage=new AbstractPage(getDriver());
//		absPage.waitUntilElementDoesntExist(By.cssSelector("input#SlotsTo"), 20);
	}

	public String getSavedName() {
		return element(nameInput).getAttribute("value");
	}
	
	public String getSavedTitle() {
		return element(titleInput).getAttribute("value");
	}
	
	public String getSavedContextType(){
		Select dropDown= new Select(getDriver().findElement(By.id("ContextType")));
		WebElement selectedOption=dropDown.getFirstSelectedOption();
		return selectedOption.getText();
		
	}
	
	public void clickServiceFromLeftHandFilter(String service){
		getDriver().findElement(By.cssSelector("label[title='"+service+"']")).click();
	}
	
	public void clickGeographyFromLeftHandFilter(String country, String countryId, String continent) {
		geographySearchInput.sendKeys(country);
		// div.sidebar.well > ul > li:nth-child(3) > div > ul > li:nth-child(1)
		// > input
		waitABit(2000);
		if(!getDriver().findElement(By.cssSelector("div#uniform-c_"+countryId+" > span")).getAttribute("class").equals("checked")){
		getDriver().findElement(By.cssSelector("input#c_" + countryId)).click();
	//	AbstractPage absPage= new AbstractPage(getDriver());
	//	absPage.waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"), 30);
	//	absPage.waitUntilElementDoesntExist(By.cssSelector("div.click-blocker"), 30);
	}else
		System.out.println("This country is already selected");
	}
	
	public void clickContinentFromLeftHandFilter(String continent){
		geographySearchInput.clear();
		geographySearchInput.sendKeys(Keys.ENTER);
		waitABit(2000);
		getDriver().findElement(By.cssSelector("label[title='"+continent+"']")).click();
		waitABit(3000);
	}
	
	//TODO fix this
//	public void clickOnSelectedPage(String page,String pivotPoint, String pivotName, String continent, String otherRating,String analysis,String news, int itemNumber, String contentType, String subContextType,String serviceLeftHandFilter,String countryLeftHandFilter, String subPageName, String countryId, String articleType, String articleId, String reportIssueNumber){
//		
//		 SingleArticlePage singleArticle=new SingleArticlePage(getDriver());
//		 DailyAnalysisAndNewsPage dailyAnalysisAndNews=new DailyAnalysisAndNewsPage(getDriver());
//    	 HomePageTopMenuPage homePageTopMenu=new HomePageTopMenuPage(getDriver());
//    	 
//		switch(page){ 
//		  case "Analysis": 
//		  getDriver().findElement(By.cssSelector("a[href='/dailyanalysisnews/daily_analysis_articles']")).click();
//		  checkPivot( pivotName,  pivotPoint,  continent, subContextType, serviceLeftHandFilter,countryLeftHandFilter,countryId);
//	
//          break;
//          
//		  case "Daily Analysis & News": 
//		  getDriver().findElement(By.cssSelector("a[href='/dailyanalysisnews/daily_analysis_and_news']")).click();
//		  checkPivot( pivotName,  pivotPoint,  continent,subContextType, serviceLeftHandFilter,countryLeftHandFilter,countryId);
//		  break;
//		  
//		  case "News" :
//		  getDriver().findElement(By.cssSelector("a[href='/dailyanalysisnews/daily_news_articles']")).click();
//		  checkPivot( pivotName,  pivotPoint,  continent,subContextType, serviceLeftHandFilter,countryLeftHandFilter,countryId);
//		  break;
//		  
//		  case "Strategic Analysis & Reports" : 
//		  getDriver().findElement(By.cssSelector("a[href='/sar/']")).click();
//		  checkPivot( pivotName,  pivotPoint,  continent,subContextType, serviceLeftHandFilter,countryLeftHandFilter,countryId);
//		  break;
//		  
//		  case "Strategic Analysis":  
//		  getDriver().findElement(By.cssSelector("a[href='/sar/sa']")).click();
//		  checkPivot( pivotName,  pivotPoint,  continent,subContextType, serviceLeftHandFilter,countryLeftHandFilter,countryId);
//		  break;
//		  
//		  case "Reports":  
//		  getDriver().findElement(By.cssSelector("a[href='/sar/reports']")).click();
//		  checkPivot( pivotName,  pivotPoint,  continent,subContextType, serviceLeftHandFilter,countryLeftHandFilter,countryId);
//		  break;
//		  
//		  case "Ratings Exploration":  
//		  getDriver().findElement(By.cssSelector("a[href='/data/ratings']")).click();
//		  waitABit(3000);
//		  checkIndustryForRatingsExploration( pivotName, otherRating);
//		  break;
//		  
//		  case "Analysis Details":
//			  
//			if (articleType.equals("1")) {
//				dailyAnalysisAndNews.clickOnDailyAnalysis(analysis);
//				dailyAnalysisAndNews.clickLatestNewsArticle(itemNumber);
//			}
//			  
//			  else{
//				  getDriver().navigate().to(Constants.BMO_DOMAIN + "/article/view?article="+ articleId+ "&active_pillar=Analysis");
//			  }
//		  break;
//			  
//		  case "News Details":
//			  
//			if (articleType.equals("1")) {
//				dailyAnalysisAndNews.clickOnNews(news);
//				dailyAnalysisAndNews.clickLatestNewsArticle(itemNumber);
//			}
//		  
//			else {
//				getDriver().navigate().to(Constants.BMO_DOMAIN + "/article/view?article="+ articleId + "&active_pillar=News");
//			}
//		  break;  
//		  
//		  case "Report Details" : 
//		  getDriver().navigate().to(Constants.BMO_DOMAIN + "/sar/reports/view?productid="+articleId+"&issue="+reportIssueNumber);
//		  break;
//		  
//		  case "Strategic Content Details" : 
//			if (articleType.equals("1")) {
//				getDriver().findElement(By.cssSelector("a[href='/sar/sa']")).click();
//				singleArticle.clickArticle(itemNumber);
//			}
//
//			else {
//
//				getDriver().navigate().to(Constants.BMO_DOMAIN + "/article/view?article="+ articleId+ "&active_pillar=Strategic Content");
//			}
//		  break;
//			  
//		  case "Article Preview" :  
//			
//			if (contentType.equals("Analysis")) {
//				dailyAnalysisAndNews.clickOnDailyAnalysis(analysis);
//				if (articleType.equals("1")) {
//
//					singleArticle.clickOnPreviewArticle(itemNumber);
//                    
//				} else {
//
//					findAndClickPreviewArticleAccordingToArticleId(articleId);
//				}
//			}
//			  
//			if (contentType.equals("News")) {
//				dailyAnalysisAndNews.clickOnNews(news);
//				if (articleType.equals("1")) {
//					
//					singleArticle.clickOnPreviewArticle(itemNumber);
//					
//				} else {
//
//					findAndClickPreviewArticleAccordingToArticleId(articleId);
//				}
//
//			}
//			
//			//element("div#media-preview-container > div:nth-child(2) > section >article[class*='business-rules-widgets']").waitUntilVisible();
//		  break;
//			  
//		  case "Strategic Content Preview"	: 
//			getDriver().findElement(By.cssSelector("a[href*='/sar/sa']"))
//					.click();
//			if (articleType.equals("1")) {
//				System.out.println("Clicked strategic content");
//				singleArticle.clickOnPreviewArticle(itemNumber);
//			} else {
//				findAndClickPreviewSAArticleAccordingToArticleId(articleId);
//			}
//		   
//			//element("div#media-preview-container > div:nth-child(2) > section >article[class*='business-rules-widgets']").waitUntilVisible();
//		  break;	  
//		
//		  case "Hot Topics" : 
//          homePageTopMenu.clickOnHotTopicsViewAll();
//		  break;
//		  
//		  case "Webinars & Podcasts" :
//		  homePageTopMenu.clickOnWebinarsAndPodcastsViewAll();
//		  break;
//		  
//		  case "Webinars & Podcasts Article Details" :
//		  homePageTopMenu.clickOnWebinarsAndPodcastsViewAll();
//	      singleArticle.clickArticle(itemNumber);
//		  break;
//		  
//		}
//	}
	
	public void clickOnSelectedPageForDvPacksAndMedia(String page, String subPageName){
   // TODO fix this
		//	 HomePageTopMenuPage homePageTopMenu=new HomePageTopMenuPage(getDriver());
   	 
		switch(page){ 
		  case "Analysis": 
		  getDriver().findElement(By.cssSelector("a[href='/dailyanalysisnews/daily_analysis_articles']")).click();
         break;
         
		  case "Daily Analysis & News": 
		  getDriver().findElement(By.cssSelector("a[href='/dailyanalysisnews/daily_analysis_and_news']")).click();
		  break;
		  
		  case "News" :
		  getDriver().findElement(By.cssSelector("a[href='/dailyanalysisnews/daily_news_articles']")).click();
		  break;
		  
		  case "Strategic Analysis & Reports" : 
		  getDriver().findElement(By.cssSelector("a[href='/sar/']")).click();
		  break;
		  
		  case "Strategic Analysis":  
		  getDriver().findElement(By.cssSelector("a[href='/sar/sa']")).click();
		  break;
		  
		  case "Reports":  
		  getDriver().findElement(By.cssSelector("a[href='/sar/reports']")).click();
		  break;
		  
		  case "Hot Topics" : 
        // homePageTopMenu.clickOnHotTopicsViewAll();
         clickHotTopicsByName(subPageName);
		  break;
		}
	}
	
	public void clickOnDvpackLinkFromWidget(String widgetContainer){
		getDriver().findElement(By.cssSelector(widgetContainer+"div#dv_packs ul > li.flex-active-slide > div > a")).click();
	}
	
	public void selectPivotContinent(String pivotName){
		
			  getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(2) > div:nth-child(1) > nav > div > ul:nth-child(1) > li:nth-child(3) > a")).click();
	       	  WebElement geographyContainer= getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(2) > div:nth-child(1) > nav > div > ul:nth-child(1) > li:nth-child(3) > ul"));
			  List <WebElement> continents = geographyContainer.findElements(By.cssSelector("li > h4 > a"));
			  
		for (WebElement continent : continents) {
			try {
				if (continent.getText().contains(pivotName)) {
					continent.click();
				}
			} catch (StaleElementReferenceException sere) {

			}
		} 	  
	}
	
	public void selectPivotService(String pivotName){
		  getDriver().findElement(By.cssSelector("div.container-fluid > section > div:nth-child(1) > nav > div > ul:nth-child(1) > li:last-child > a")).click();
          WebElement serviceListContainer =getDriver().findElement(By.cssSelector("ul.dropdown-menu.span9"));
			List<WebElement> services = serviceListContainer.findElements(By
					.cssSelector("li ul li a"));

		for (WebElement service : services) {
			try {
				if (service.getText().equals(pivotName)) {
					service.click();
					waitABit(2000);
				}
			} catch (StaleElementReferenceException sere) {

			}
		}
}
	
	public void selectFinancialMarketsTopNav(){
		 getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(2) > div:nth-child(1) > nav > div > ul:nth-child(1) > li:nth-child(3) > a")).click();
	}
	
	public void selectGeography(String continent, String country) {
		 getDriver().findElement(By.cssSelector("div.container-fluid > section > div:nth-child(1) > nav > div > ul:nth-child(1) > li:nth-child(3) > a")).click();

			evaluateJavascript("var element =jQuery('a:contains(" + continent + ")');element.mouseover();");
			waitABit(10000);
			evaluateJavascript("" +
					"$('.navbar-inner > .nav > .dropdown.bmo > .dropdown-menu.span3.geography  > .dropdown-submenu > h4 > a:contains(" + continent + ")')" + 
					".trigger('mouseover')" +
					".parent().next('.dropdown-menu').show()" +
					".find('a:contains("+ country +")')[0].click()");
			          
			waitABit(10000);

			System.out.println("found!");
	}
	
	public int checkIfPivotNameIsAContinent(String pivotName) {

		if (pivotName.equals("Africa") ^ pivotName.equals("Asia")
				^ pivotName.equals("Europe") ^ pivotName.equals("Caribbean")
				^ pivotName.equals("Latin America")
				^ pivotName.equals("North America")
				^ pivotName.equals("Middle East")) {

			return 1;

		} else

			return 0;

	}
	
	//TODO fix this
//	public void checkPivot(String pivotName, String pivotPoint, String continent, String subContextType, String service, String country, String countryId){
//		DailyAnalysisAndNewsPage danPage= new DailyAnalysisAndNewsPage(getDriver());
//		  if(!pivotName.equals("")&&pivotPoint.equals("Geography")&&checkIfPivotNameIsAContinent(pivotName)==1){
//			   selectPivotContinent(pivotName);
//				  if(subContextType.equals("Pivot + filters")){
//					  danPage.selectServiceFromLeftHand(service);
//			  } 
//		  }
//		  
//		  if(!pivotName.equals("")&&pivotPoint.equals("Geography")&&checkIfPivotNameIsAContinent(pivotName)==0){
//			  selectGeography(continent, pivotName);
//			  if(subContextType.equals("Pivot + filters")){
//				  danPage.selectServiceFromLeftHand(service);
//			  } 
//		  }
//		  if(!pivotName.equals("")&&pivotPoint.equals("Industry")){
//			  selectPivotService(pivotName);
//			  waitABit(2000);
//			  if(subContextType.equals("Pivot + filters")){
//				  danPage.selectGeographyFromFilter("", country, continent);
//			  } 
//		  }
//	}
	
	public boolean checkSlotsAvailable(){

		WebElement slotDropDown=getDriver().findElement(By.cssSelector("select#Slot"));
		List<WebElement> options= slotDropDown.findElements(By.cssSelector("option"));
		if(options.size()>=1)
			return true;
		else
		return false;
	}
	
	public void checkIndustryForRatingsExploration(String pivotName,String otherRating){
		switch(pivotName){
		case "Country Risk":
			 
			 if(otherRating.equals("Yes")){
				 getDriver().findElement(By.cssSelector("a[href='/data/ratings/sovereign/']")).click();
			 }else
			 //if you select Country Risk the widget is also displayed for Sovereign Risk Ratings
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/countryrisk/']")).click();
			 break;
			 
		case "Infrastructure":
			
			 if(otherRating.equals("Yes")){
				 getDriver().findElement(By.cssSelector("a[href='/data/ratings/finance/?rservice=61']")).click();
			 }else
			 //if you select infrastructure the widget is also displayed for Project Finance
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=6']")).click();
			 break;	 
			 
		case "Defence & Security":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=8']")).click();
			 break;
			 
		case "Mining":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=17']")).click();
			 break;
			 
		case "Oil & Gas":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=2']")).click();
			 break;
			 
		case "Real Estate":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=22']")).click();
			 break; 
			 
		case "Telecommunications":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=1']")).click();
			 break; 
			 
		case "Power":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=18']")).click();
			 break;	
			 
		case "Information Technology":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=13']")).click();
			 break;
			 
		case "Insurance":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=16']")).click();
			 break; 
			 
		case "Retail":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=25']")).click();
			 break; 
			 
		case "Renewables":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=28']")).click();
			 break;
			 
		case "Pharmaceuticals & Healthcare":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=3']")).click();
			 break;
			 
		case "Tourism":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=12']")).click();
			 break;
		
		case "Commercial Banking":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=15']")).click();
			 break;
			 
		case "Consumer Electronics":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=20']")).click();
			 break;
			 
		case "Petrochemicals":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=14']")).click();
			 break;
			 
		case "Autos":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=4']")).click();
			 break;
			 
		case "Food & Drink":
			 getDriver().findElement(By.cssSelector("a[href='/data/ratings/riskreward/?rservice=5']")).click();
			 break;
			 
		}	 
		
	}
	
	public boolean checkIfWidgetIsDisplayed(String savedWidgetTitle, String widgetContainer) {
		waitUntilElementDoesntExist(By.cssSelector("div.click-blocker"), 80);
		waitUntilElementExists(By.cssSelector(widgetContainer), 50);
		WebElement businessRulesWidgetsContainer = getDriver().findElement(
				By.cssSelector(widgetContainer));
		List<WebElement> businessRuleWidgets = businessRulesWidgetsContainer
				.findElements(By.cssSelector("div >  h4"));
		 boolean widgetsDisplayed=false;
		 boolean foundWidget=false;
		if (businessRuleWidgets.size() >= 1) {
			widgetsDisplayed=true;
			for (WebElement businessRuleWidget : businessRuleWidgets) {
				
				if (businessRuleWidget.getText().contains(savedWidgetTitle)) {
		//			log.info("Displayed widget title: "
		//					+ businessRuleWidget.getText());
					System.out.println("Displayed widget title: "+ businessRuleWidget.getText());
					foundWidget=true;
				}
			}
			if (!foundWidget) {
		//		log.warn("There is no widget with this name");
				Assert.assertTrue("The created widget was not displayed on the page !",foundWidget);
			}
			
		} else{
			//log.warn("There are no widgets on this page!");
			Assert.assertTrue("There are no widgets on this page!",widgetsDisplayed);
		}
		return foundWidget;
	}

	public boolean checkIfWidgetIsDisplayedInReportsAndSARPages(String savedWidgetTitle, String widgetContainer, String divs) {
	//	PropertyConfigurator.configure("log4j.properties");
		List <WebElement> divElements= getDriver().findElements(By.cssSelector(divs));//article#content-wrapper > div:nth-child(2) > *  gets only the direct children
		System.out.println("Number of divs: "+divElements.size());
		boolean widgetsDisplayed=false;
	    boolean foundWidget=false;
		if(divElements.size()>1){//container for widget is not present when there are no widgets, cannot control this, so it's a temporary fix
			//if just one div exists, then only the listing page is present without the widgets
	    waitUntilElementDoesntExist(By.cssSelector("div.click-blocker"), 80);
	    waitUntilElementExists(By.cssSelector(widgetContainer), 80);
	    WebElement businessRulesWidgetsContainer = getDriver().findElement(By.cssSelector(widgetContainer));
		List<WebElement> businessRuleWidgets = businessRulesWidgetsContainer
				.findElements(By.cssSelector("div >  h4"));
		if (businessRuleWidgets.size() >= 1) {
			widgetsDisplayed=true;
			for (WebElement businessRuleWidget : businessRuleWidgets) {
				
				if (businessRuleWidget.getText().contains(savedWidgetTitle)) {
					System.out.println("Displayed widget title: "+ businessRuleWidget.getText());
					//log.info("Displayed widget title: "
					//		+ businessRuleWidget.getText());
					foundWidget=true;
				}
			}
			
			if (!foundWidget) {
				Assert.assertTrue("The created widget was not displayed on the page !",foundWidget);
				//log.warn("There is no widget with this name");
			}
		} 
		}
		else{
			//log.warn("There are no widgets on this page!");
			Assert.assertTrue("There are no widgets on this page!",widgetsDisplayed);
		}
		return foundWidget;
	}
	
	public void recordsPerPageSelect(String records){
		element(recordsPerPageSelect).waitUntilVisible();
		element(recordsPerPageSelect).selectByVisibleText(records);
	}
	
	public void deleteWidget (String widgetId) {
		getDriver().navigate().to(Constants.ADM_DELETE_WIDGET+widgetId);
	}
	
	public void deleteAllWidgets(String widgetName, String records) {

		List<WebElement> widgetRows = businessRulesWidgetsTable.findElements(By
				.cssSelector("tr"));
		int j = widgetRows.size();
		try {
			for (int i = 1; i <= j; i++) {

				List<WebElement> cells = widgetRows.get(i - 1).findElements(By.cssSelector("td"));
				String foundWidgetName = cells.get(0).getText();
				
				while (foundWidgetName.contains(widgetName) && i <= j) {
					
					businessRulesWidgetsTable.findElement(By.cssSelector("tr:nth-child(" + i+ ") > td:nth-child(9) > a")).click();
					element(deletePopUpWindow).waitUntilVisible();
					deletePopUpWindow.click();
					Assert.assertTrue("Not Found",
							okDeletePopUpWindow.isDisplayed());
					okDeletePopUpWindow.click();
					recordsPerPageSelect(records);
					waitABit(2000);
					j = j - 1;
				}
			}
		} catch (StaleElementReferenceException sere) {
		}
	}
	
	public void deleteWidgetsByName(String widgetName){
		searchInput.click();
		searchInput.clear();
		searchInput.sendKeys(widgetName);
		deleteFirstWidget.click();
		okDeleteWindow.click();
	}
	//TODO fix this
//	public void searchWidgetByNameAndVerifyDeleted(String widgetName){
//		searchInput.click();
//		searchInput.sendKeys(widgetName);
////		ManageWidgetsPage manageWidget=new ManageWidgetsPage(getDriver());
////		Assert.assertTrue("Widget was not deleted",manageWidget.verifyIfWidgetPageRelationDoesNotExist());
//	}
	public void searchWidgetbyNameAndClickEdit(String widgetName){
		searchInput.click();
		searchInput.sendKeys(widgetName);
		editFirstWidget.click();
	}
	
	public void clickOnExceptionsMiniTab(){
		exceptionsTab.click();
	}
	
	public void clickAddNewExceptionButton(){
		addNewExceptionButton.click();
	}
	
	public void selectServiceExcption(String serviceException){
		selectFromDropdown(serviceExceptionDropdown, serviceException);		
	}
	
	public void clickArticleType(String articleTypeNumber){
		getDriver().findElement(By.cssSelector("input#article_type_"+articleTypeNumber)).click();
	}
	
	public void clickRefineByButton(){
		refineByButton.click();
	}
	
	public void selectRefineOptionForWidget(String optionToRefine, String savedWidgetTitle, String widgetContainer, String optionId) {
		 waitUntilElementDoesntExist(By.cssSelector("article.span5.business-rules-widgets.asyncWidgets.loading"), 50);
         WebElement businessRulesWidgetsContainer = getDriver().findElement(By.cssSelector(widgetContainer));
     	 List<WebElement> businessRuleWidgetsTitles = businessRulesWidgetsContainer.findElements(By.cssSelector("div >  h4"));
         if (businessRuleWidgetsTitles.size() >= 1) {
             
             	 for(int i=0; i<businessRuleWidgetsTitles.size();i++){
             		 try{
         				if (businessRuleWidgetsTitles.get(i).getText().contains(savedWidgetTitle)) {
         					System.out.println("Saved widget title"+businessRuleWidgetsTitles.get(i).getText());
         					int j=0;
         					j=i+1;
                            getDriver().findElement(By.xpath("//div["+j+"]/div[1]/button")).click();
                            element(getDriver().findElement(By.xpath("//div["+j+"]/div[1]/ul/ul/li[1]/button"))).click();//CLICK PLUS BUTTON
                       //   waitABit(2000);
                       //   elementClick("div#sar > div > ul > ul:nth-child(2) > li > input#"+optionId);//select a service
                          //TODO Fix this
//                            AbstractPage absPage=new AbstractPage(getDriver());
//                            absPage.waitUntilElementDoesntExist(By.cssSelector("div.loading"), 30);
         					}				
             		 }catch(StaleElementReferenceException sere){
             			 
             		 }
         			
     			}
			
		} else
			System.out.println("There are no widgets on this page!");	
	}
	
	public boolean clickHotTopicsByName(String pageName) {
		List<WebElement> hotTopicsTitles = hotTopicsContainer.findElements(By
				.cssSelector("li a"));
		boolean found = false;
		try{
		for (WebElement hotTopicsTitle : hotTopicsTitles) {
			if(!pageName.equals("")){//if one hot topic was selected and not all of them
			if (hotTopicsTitle.getText().equals(pageName)) { 
				hotTopicsTitle.click();
				found = true;
				break;
				}
			}
			else {
				hotTopicsTitles.get(0).click();//widget is displayed on all hot topics so click the first one
			    found=true;
				}
			}
		}
		catch(StaleElementReferenceException sere){
			
		}
		if (!found) {
			System.out.println("Selected hot topic from Manage Widgets is either inactive or not displayed in BMO5");
		}
		return found;		
	}


	public void selectDisplayOptionForDvPack(String displayOption){
		getDriver().findElement(By.cssSelector("input#display_options_"+displayOption)).click();
	}

	public void findAndClickPreviewArticleAccordingToArticleId(String articleId) {
		WebElement mediaListing = getDriver().findElement(By.cssSelector("div#content-wrapper > div:nth-child(2) > div#the-content-container > div.media-listing"));
		List<WebElement> articles = mediaListing.findElements(By.cssSelector("div[class*='media'] > div:nth-child(2) > div:nth-child(2) > a"));

		for (int i=0;i<=articles.size()-1;i++) {
			if (articles.get(i).getAttribute("data-article-id").equals(articleId)) {
				System.out.println("found id!!!");
				//TODO Fix this
//				AbstractPage abstractPage=new AbstractPage(getDriver());
//			    i=i+1;
//				abstractPage.elementClick("div#content-wrapper > div:nth-child(2) > div#the-content-container > div.media-listing > div:nth-child("+i+") > div:nth-child(2) > div:nth-child(2) > a");
				waitABit(2000);
				break;
			}
		}
	}
	
	public void findAndClickPreviewSAArticleAccordingToArticleId(String articleId) {
		WebElement mediaListing = getDriver().findElement(By.cssSelector("div#content-wrapper > div:nth-child(2) > div#the-content-container > div#sar-container"));
		List<WebElement> articles = mediaListing.findElements(By.cssSelector("div[class*='media media-item-sa '] > div:nth-child(2) > div:nth-child(2) > a"));

		for (int i=0;i<=articles.size()-1;i++) {
			if (articles.get(i).getAttribute("data-article-id").equals(articleId)) {
				System.out.println("found id!!!");
				//TODO Fix this
//				AbstractPage abstractPage=new AbstractPage(getDriver());
				i=i+1;
//				abstractPage.elementClick("div#content-wrapper > div:nth-child(2) > div#the-content-container > div#sar-container  > div:nth-child("+i+") > div:nth-child(2) > div:nth-child(2) > a");
				break;
			}
		}
	}
	
	public void insertRuleDvPack(String ruleTitle, String ruleDvPackId){
		titleInput.sendKeys(ruleTitle+Integer.toString(StringUtils.randomNumber(10000)));
		dvPackId.sendKeys(ruleDvPackId);
		saveRuleButton.click();
	}
	
	public void insertRuleMedia(String timing, String upload){
		chooseFileButton.click();
		waitABit(2000);

		uploadFile(upload, Constants.RESOURCES_MEDIA);
		
		timingInputBox.sendKeys(timing);
		saveRuleButton.click();
		waitABit(2000);
		editButtonElement.click();
	}
	
	//methods for enterprise
	
	public void clickFirstArticleFromWidget(String widgetContainer, String savedWidgetTitle, String widgetId, String contentType){
		
		WebElement businessRulesWidgetsContainer = getDriver().findElement(By.cssSelector(widgetContainer));
		List<WebElement> businessRuleWidgetsTitles = businessRulesWidgetsContainer.findElements(By.cssSelector("div > h4"));
        if (businessRuleWidgetsTitles.size() >= 1) {
        
        	 for(int i=0; i<businessRuleWidgetsTitles.size();i++){
				try {
					if (businessRuleWidgetsTitles.get(i).getText().contains(savedWidgetTitle)&&!contentType.equals("Video")) {
						System.out.println("Saved widget title"+ businessRuleWidgetsTitles.get(i).getText());
						if(contentType.contains("Reports")){
							if(getDriver().findElement(By.cssSelector("div[id='reports_"+widgetId+"'] > div:nth-child(1) > div")).getAttribute("class").contains("disabled")){
								getDriver().findElement(By.cssSelector("div[id='reports_"+widgetId+"'] > div:nth-child(1) > div > div > h5 > a")).click();
								waitABit(2000);
								verifyPermissionModalByType(contentType.toLowerCase());
								}else{
						            getDriver().findElement(By.cssSelector("div[id='reports_"+widgetId+"'] > div:nth-child(1) > div > div > h5 > a")).click();
					             	waitABit(2000);
							}
						}
						
						else if(contentType.contains("DV Packs")){
						            getDriver().findElement(By.cssSelector("div[id='dv_packs_"+widgetId+"'] > div:nth-child(1) > div > ul > li:nth-of-type(2) h5 > a")).click();
					             	waitABit(2000);
						}
						
						else if(contentType.equals("Articles")||contentType.equals("Analysis")||contentType.equals("News")||contentType.equals("Analysts Choice")||contentType.equals("Data Packs")||contentType.equals("DV Packs")){
							if(getDriver().findElement(By.cssSelector("div[id='articles_"+widgetId+"'] > div:nth-child(1) > div")).getAttribute("class").contains("disabled")){
								getDriver().findElement(By.cssSelector("div[id='articles_"+widgetId+"'] > div:nth-child(1) > div > div > h5 > a")).click();
								waitABit(2000);
								if(contentType.equals("Data Packs")){
									verifyPermissionModalByType("datapacks");
								}else{
								verifyPermissionModalByType("");
								}
							}else{
							getDriver().findElement(By.cssSelector("div[id='articles_"+widgetId+"'] > div:nth-child(1) > div > div > h5 > a")).click();
							waitABit(2000);
							}
						}
						else{
							if(getDriver().findElement(By.cssSelector("div[id='sar_"+widgetId+"'] > div:nth-child(1) > div")).getAttribute("class").contains("disabled")){
								getDriver().findElement(By.cssSelector("div[id='sar_"+widgetId+"'] > div:nth-child(1) > div > div > h5 > a")).click();
								waitABit(2000);
								verifyPermissionModalByType("");
							}else{
							getDriver().findElement(By.cssSelector("div[id='sar_"+widgetId+"'] > div:nth-child(1) > div > div > h5 > a")).click();
							waitABit(2000);
							}
						}
					}
				} catch (StaleElementReferenceException sere) {

				}
			}
		}
  
	}
	
	public void clickSaveButtonAndCheckModalDisplayed(){
			saveArticleButton.click();
			assertEnterpriseModal();
	}
	
	public void assertEnterpriseModal(){
		Assert.assertTrue(enterpriseUserModal.isDisplayed());
		cancelLinkEnterpriseModal.click();
		waitABit(2000);
	}
	
	public void clickDownloadButtonAndCheckModal(){
		downloadArticleButton.click();
		waitABit(2000);
		verifyPermissionModalByType("pdf");
	}
	
	public void clickPrintButtonAndCheckModal(){
		printArticleButton.click();
		waitABit(2000);
		verifyPermissionModalByType("print");
	}

	//TODO fix this
//    public void clickViewMoreButtonAndVerifyIcons(String widgetContainer, String savedWidgetTitle, String contentType, String widgetId){
//
//		clickViewMoreButton(widgetContainer, savedWidgetTitle, contentType,widgetId);
//		clickIconsViewMoreListing(contentType);
//		waitABit(2000);
//		clickPreviewViewMoreListing(contentType);
//
//	}
    
    public boolean clickViewMoreButton(String widgetContainer, String savedWidgetTitle, String contentType, String widgetId){
		WebElement businessRulesWidgetsContainer = getDriver().findElement(By.cssSelector(widgetContainer));
	    List<WebElement> businessRuleWidgetsTitles = businessRulesWidgetsContainer.findElements(By.cssSelector("div >  h4"));
        List<WebElement> numberOfContent;
        boolean found=false;
        if (businessRuleWidgetsTitles.size() >= 1) {
        	 for(int i=0; i<businessRuleWidgetsTitles.size();i++){
        		 try{
    				if (businessRuleWidgetsTitles.get(i).getText().contains(savedWidgetTitle)) {
    					System.out.println("Saved widget title"+businessRuleWidgetsTitles.get(i).getText());
    					if(contentType.contains("Reports")){
    						numberOfContent=getDriver().findElements(By.cssSelector("div[id='reports_"+widgetId+"'] > div > div > div > h5 > a"));
    						System.out.println("Number of content: "+ numberOfContent.size());
    						if(numberOfContent.size()>=5){
    							found=true;
    							getDriver().findElement(By.cssSelector("div[id='reports_"+widgetId+"'] > div > div > div:last-child > a")).click();
    							Assert.assertTrue("Wrong widget!",breadcrumbWidgetTitle.getText().contains(savedWidgetTitle));
    						}
    					}
    						else if(contentType.equals("Analysis")||contentType.equals("News")||contentType.equals("Analysts Choice")||contentType.equals("Data Packs")){
    							numberOfContent=getDriver().findElements(By.cssSelector("div[id='articles_"+widgetId+"'] > div > div > div > h5 > a"));
        						System.out.println("Number of content: "+ numberOfContent.size());
        						if(numberOfContent.size()>=5){
        							found=true;
        							getDriver().findElement(By.cssSelector("div[id='articles_"+widgetId+"'] > div > div > div:last-child > a")).click();
        							Assert.assertTrue("Wrong widget!",breadcrumbWidgetTitle.getText().contains(savedWidgetTitle));
        						}
    						}
    						else{
    							
    							numberOfContent=getDriver().findElements(By.cssSelector("div[id='sar_"+widgetId+"'] > div > div > div > h5 > a"));
        						System.out.println("Number of content: "+ numberOfContent.size());
        						if(numberOfContent.size()>=5){
        							found=true;
        							getDriver().findElement(By.cssSelector("div[id='sar_"+widgetId+"'] > div > div > div:last-child > a")).click();
        							Assert.assertTrue("Wrong widget!",breadcrumbWidgetTitle.getText().contains(savedWidgetTitle));
        						}
    						}
    					}
				} catch (StaleElementReferenceException sere) {

				}

			}
		}
        return found;
    }

    //TODO fix this
//	public void clickIconsViewMoreListing(String contentType) {
//	   clickOnDownloadIconArticleFromList(contentType);
//	   waitABit(2000);
//       elementClick("div.media-listing > div:nth-child(1) > div:nth-child(2) > div > a > i.icon-c-floppy");
//       waitABit(3000);
//		if (contentType.contains("Analys") || contentType.contains("News")) {
//			checkMessage(
//					"Article added successfully to Saved Content - available in 'My BMO'",
//					"The article already exists in Saved Content!","An error has occured while saving your report. Please try again");
//		} else if (contentType.contains("Reports")) {
//			checkMessage(
//					"Report successfully saved!",
//					"This report already exists in Saved Reports!","An error has occured while saving your report. Please try again");
//		}
//       elementClick("div.media-listing > div:nth-child(1) > div:nth-child(2) > div > a > i.icon-c-print");
//       printArticle();
//  //   elementClick("div.btn-group > a:last-child > i.icon-c-email");
////     waitABit(2000);
// //    contactAccountManagerWindowCloseButton.click();
//	}

	public void clickPreviewViewMoreListing(String contentType) {
		if(contentType.contains("Analys")||contentType.contains("News")){
     elementClick("div.media-listing > div:nth-child(1) > div:nth-child(2) >  div:nth-child(2) > a");
     waitABit(5000);
     Assert.assertTrue("Title is not displayed, preview didn't load",articleTitleLink.isDisplayed());
		}
		else if (contentType.contains("Reports")){
			 elementClick("div.media-listing >div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:last-child");
		     waitABit(5000);
		     Assert.assertTrue("Title is not displayed, preview didn't load",articleTitleLink.isDisplayed());
		}
//     downloadArticleButton.click();
//     saveArticleButton.click();
//     printArticleButton.click();
//     emailButton.click();
   //  closePreviewArticleWindow.click();
	}
//	//TODO fix this
// public void selectOptionAndDeleteWidgetByName(String widgetName, AdmMenuItems option){
//	    MenuNavigationPage menuNavigation=new MenuNavigationPage(getDriver());
//	    ManageWidgetsPage manageWidgets= new ManageWidgetsPage(getDriver());
//	    BusinessRulesWidgetsPage businessRulesWidgetsPage=new BusinessRulesWidgetsPage(getDriver());
//	//    menuNavigation.selectMenuItem(AdmMenuItems.Widgets);
//	//    Sleeper.sleepTight(2000);
//	    menuNavigation.selectMenuItem(AdmMenuItems.Widgets);
//	    Sleeper.sleepTight(2000);
//	    menuNavigation.selectMenuItem(option);
//	    manageWidgets.searchWidgetByName(widgetName);
//	   if( !manageWidgets.verifyIfWidgetPageRelationDoesNotExist()){
//		Sleeper.sleepTight(2000);
//		businessRulesWidgetsPage.deleteWidgetsByName(widgetName);
//	   }
// }
 
	//TODO fix this
// public void clickOnDownloadIconArticleFromList(String contentType){
//	if(contentType.contains("Analys")||contentType.contains("News")){
//		        String articleTitle="";
//				element(downloadArticleListingButton).click();
//				articleTitle = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(1)  > h5 > a")).getText();
//                System.out.println("Article title before converting: " +articleTitle);
//                downloadArticles(articleTitle);
//	}
//	else if (contentType.contains("Reports")){
//		    String reportTitle="";
//			element(downloadArticleListingButton).click();
//			reportTitle = getDriver().findElement(By.cssSelector("div.media-listing > div > div:nth-child(1)  > h5 > a")).getText();
//            System.out.println("Report title before converting: " +reportTitle);
//			downloadReport(reportTitle);
//		}
//	}
 
	//TODO fix this
//     public void downloadReport(String reportTitle){
//	    DataToolPage data = new DataToolPage(getDriver());
//		data.saveImageHandle2();
//		FileChecker fileChecker = new FileChecker();
//		System.out.println("Report title converted: "+fileChecker.convertFileName(reportTitle));
//		fileChecker.verifyFileIsDownloaded1(fileChecker.convertFileName(reportTitle));
// }
// 
//     public void downloadArticles(String articleTitle){
//		DataToolPage data = new DataToolPage(getDriver());
//		data.saveImageHandle2();
//		FileChecker fileChecker = new FileChecker();
//		System.out.println("Article title converted: "+fileChecker.convertFileName(articleTitle));
//		fileChecker.verifyFileIsDownloadedRelatives(fileChecker.convertFileName(articleTitle));
// }
 
    public void checkMessage(String successMessageText,String errorMessageText,String errorMessageText2){
	 if (message.getAttribute("class").contains("error")){
		System.out.println("Error message is: "+message.getText());
		Assert.assertTrue( message.getText().contains(errorMessageText)|| message.getText().contains(errorMessageText2));
	 }
	 else
		 if(message.getAttribute("class").contains("success")){
			 System.out.println("success message is: "+message.getText());
			 Assert.assertTrue( message.getText().contains(successMessageText));
		 }
 }
 
	public void printArticle(){
		String winHandleBefore = getDriver().getWindowHandle();
		for (String winHandle : getDriver().getWindowHandles()) {
			getDriver().switchTo().window(winHandle);
		}
		printPagePreviewCancel.click();
		getDriver().switchTo().window(winHandleBefore);
	}
	
	public void clickOnUnentitledItemFromViewMoreListingAndVerifyIconsDontExistAndModal(String contentType){
		WebElement mediaContainer= getDriver().findElement(By.cssSelector("div.media-listing"));
		List<WebElement> viewMoreListingItems=mediaContainer.findElements(By.cssSelector("div.widget-item.media"));
		
		for(int i=1;i<=viewMoreListingItems.size();i++){
			if(viewMoreListingItems.get(i-1).getAttribute("class").contains("disabled")){
			Assert.assertTrue("Another div is displayed (div with action icons)",getDriver().findElements(By.cssSelector("div.media-listing > div:nth-of-type("+i+") >*")).size()==1);
			getDriver().findElement(By.cssSelector("div.media-listing > div:nth-of-type("+i+") > div > h5 > a")).click();
			waitABit(2000);
			verifyPermissionModalByType(contentType.toLowerCase());
			break;
			}	
		}
	}
	
	public void clickEntitledItemFromViewMoreListing(String contentType){
		WebElement mediaContainer= getDriver().findElement(By.cssSelector("div.media-listing"));
		List<WebElement> viewMoreListingItems=mediaContainer.findElements(By.cssSelector("div.widget-item.media"));
		
		for(int i=1;i<=viewMoreListingItems.size();i++){
			if(!viewMoreListingItems.get(i-1).getAttribute("class").contains("disabled")){
			
				if(!contentType.contains("Reports")){
				System.out.println("Checking if this article link is valid...");
				getDriver().findElement(By.cssSelector("div.media-listing > div:nth-of-type("+i+") > div > h5 > a")).click();
				verifyPageNotFoundIsNotDisplayed();
				break;
			}
			else{
				//check if print preview is displayed if yes the report has html view
				if(getDriver().findElements(By.cssSelector("div.media-listing > div:nth-of-type("+i+") > div.media-actions > div >*")).size()==5){
					System.out.println("This is a report...");
					getDriver().findElement(By.cssSelector("div.media-listing > div:nth-of-type("+i+") > div > h5 > a")).click();
					verifyPageNotFoundIsNotDisplayed();
					break;
					}
				}
			}
		}
	}
	
	public void verifyPermissionModalByType(String type){
		if(type.equals("reports")||type.equals("pdf")||type.equals("print")||type.equals("service")||type.equals("data-exports")||type.equals("geography")||type.equals("datapacks")){
			Assert.assertTrue("Account Manager text is not displayed",getDriver().findElement(By.cssSelector("div[id='permission-modal-"+type+"']")).isDisplayed());
			element(getDriver().findElement(By.cssSelector("div[id*='permission-modal-"+type+"'] > div:nth-child(2) > button"))).click();
			waitABit(2000);
		}else{
			Assert.assertTrue("Account Manager text is not displayed",getDriver().findElement(By.cssSelector("div[id='permission-modal']")).isDisplayed());
			element(getDriver().findElement(By.cssSelector("div[id='permission-modal'] > div:nth-child(2) > button"))).click();
			waitABit(2000);
		}
	}
	
	public void verifyPageNotFoundIsNotDisplayed(){
		System.out.println("Verifying links...");
		Assert.assertTrue("Page not found is displayed",!getDriver().findElement(By.cssSelector("body")).getText().contains("Page not found"));
	}
	//TODO fix this
	
//	public void verifySaveButtonEnterpriseViewMoreListing(){
//		clickRandomIconViewMoreListing("floppy");
//	    waitABit(2000);
//	    assertEnterpriseModal();
//	}
//	
//	public void verifyDownloadTrialViewMoreListing(){
//		clickRandomIconViewMoreListing("download");
//	    waitABit(2000);
//	    verifyPermissionModalByType("pdf");
//	}
	
	//TODO fix this
//	public void verifyPrintTrialViewMoreListing(){
//		clickRandomIconViewMoreListing("print");
//	    waitABit(2000);
//	    verifyPermissionModalByType("print");
//	}

	//TODO fix this
//	public void clickRandomIconViewMoreListing(String iconType){
//		WebElement mediaContainer= getDriver().findElement(By.cssSelector("div.media-listing"));
//		List<WebElement> viewMoreListingItems=mediaContainer.findElements(By.cssSelector("div.widget-item.media"));
//		HomePageTopMenuPage homeTopMenuPage= new HomePageTopMenuPage(getDriver());
//		int random= homeTopMenuPage.generateRandomNumberBetweenTwoValues(1, viewMoreListingItems.size());
//		System.out.println("Random item number: "+random);
//		
//		if(!iconType.equals("download")){
//	    elementClick("div.media-listing > div:nth-of-type("+random+") > div:nth-child(2) > div > a >i.icon-c-"+iconType);
//		}
//		else{
//			getDriver().findElement(By.cssSelector("div.media-listing > div:nth-of-type("+random+") > div:nth-child(2) > div > a >i.icon-c-download")).click();
//		}
//	}

	//TODO fix this	
//	public void clickDownloadButtonAndVerifyDownloadedReport(String widgetContainer, String savedWidgetTitle, String contentType, String widgetId){
//		WebElement businessRulesWidgetsContainer = getDriver().findElement(By.cssSelector(widgetContainer));
//	    List<WebElement> businessRuleWidgetsTitles = businessRulesWidgetsContainer.findElements(By.cssSelector("div >  h4"));
//        if (businessRuleWidgetsTitles.size() >= 1) {
//        	 for(int i=0; i<businessRuleWidgetsTitles.size();i++){
//        		 try{
//    				if (businessRuleWidgetsTitles.get(i).getText().contains(savedWidgetTitle)) {
//    					System.out.println("Saved widget title"+businessRuleWidgetsTitles.get(i).getText());
//    					if(contentType.contains("Reports")){
//    						String reportTitle=getDriver().findElement(By.cssSelector("div[id='reports_"+widgetId+"'] > div > div > div > h5 > a")).getText();
//    						if(getDriver().findElements(By.cssSelector("div[id='reports_"+widgetId+"'] > div > div > div > div:nth-child(2) > a > i.icon-c-download")).size()==1){
//    						getDriver().findElement(By.cssSelector("div[id='reports_"+widgetId+"'] > div > div > div > div:nth-child(2) > a > i.icon-c-download")).click();
//    						downloadReport(reportTitle);
//    						}
//    					}
//    				}
//				} catch (StaleElementReferenceException sere) {
//
//				}
//			}
//		}  
//	}
	
	public void clickDownloadButtonForReportWidgetTrialUser(String widgetContainer, String savedWidgetTitle, String contentType, String widgetId){
		WebElement businessRulesWidgetsContainer = getDriver().findElement(By.cssSelector(widgetContainer));
	    List<WebElement> businessRuleWidgetsTitles = businessRulesWidgetsContainer.findElements(By.cssSelector("div >  h4"));
        if (businessRuleWidgetsTitles.size() >= 1) {
        	 for(int i=0; i<businessRuleWidgetsTitles.size();i++){
        		 try{
    				if (businessRuleWidgetsTitles.get(i).getText().contains(savedWidgetTitle)) {
    					System.out.println("Saved widget title"+businessRuleWidgetsTitles.get(i).getText());
    					if(contentType.contains("Reports")){
    						if(getDriver().findElements(By.cssSelector("div[id='reports_"+widgetId+"'] > div > div > div > div:nth-child(2) > a > i.icon-c-download")).size()==1){
    						getDriver().findElement(By.cssSelector("div[id='reports_"+widgetId+"'] > div > div > div > div:nth-child(2) > a > i.icon-c-download")).click();
    						verifyPermissionModalByType("pdf");
    						}
    					}
    				}
				} catch (StaleElementReferenceException sere) {

				}
			}
		}  
	}
	//TODO fix this
//	public void verifyDownloadedExcel(String extension){
//		DataToolPage dataToolPage=new DataToolPage(getDriver());
//		dataToolPage.saveImageHandle2();
//		waitABit(3000);
//		FileChecker file = new FileChecker();
//		file.verifyExtentionExcelFile(extension);
//	}
}
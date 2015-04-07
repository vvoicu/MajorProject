package bmo5.bmo5tests.bmo.pages.pillarPages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class ReportsArchiveListingPage extends AbstractPage {

	
	@FindBy(css="button[class='btn dropdown-toggle'] > div")
	@CacheLookup
	private WebElement sortByDateServiceTitleButton;
	
	@FindBy(css="i[class='icon-c-angle-double-right']")
	@CacheLookup
	private WebElement rightDoubleArrow;
	
	@FindBy(css="i[class='icon-c-angle-double-left']")
	@CacheLookup
	private WebElement leftDoubleArrow;
	
	@FindBy(css="div#latest-articles-pagination > ul.unstyled > li:last-child a")
	private WebElement lastPageNumber;
	
	@FindBy(css="article[id*='results']")
	private WebElement reportsListingContainer;
	
	@FindBy(css="article[id='results'] div  h4")
	private WebElement resultsHeader;
	
	@FindBy(css="ul[class='dropdown-menu'] > li:nth-child(2) > a > span")
	private WebElement serviceSortOption;
	
	@FindBy(css="ul[class='unstyled'] > li:nth-child(2) > a")
	private WebElement secondPage;
	
	@FindBy(css="li[class='next'] > a")
	private WebElement nextPage;
	
	@FindBy(css="li[class='prev'] > a")
	private WebElement previousPage;

	@FindBy(css = "div[class='sidebar well']>ul>li:nth-child(5)>ul>li>ul")
	@CacheLookup
	private WebElement leftHandContainerServices;

	@FindBy(css = "div[class='sidebar well']>ul>li:nth-child(4)>ul>li>ul")
	private WebElement leftHandContainerGeographies;

	@FindBy(css = "div[class='sidebar well']>ul>li:nth-child(6)>ul>li>ul")
	@CacheLookup
	private WebElement leftHandContainerReports;
	
	@FindBy(css = "span[class*='pull-right'] > a[class*='btn btn-small']")
	private WebElement backToBMIReportsButton;
	
	@FindBy(css="ul.breadcrumb > li.active")
	private WebElement currentPageBreadcrumb;
	
//	private Create_StaticDvPack_WidgetType_SelectOptionPage createDvpackPageAdm=new Create_StaticDvPack_WidgetType_SelectOptionPage(getDriver());
	WebElement showMoreLink;
	
	public void verifySortByDateSelectedOption(){
		Assert.assertTrue(sortByDateServiceTitleButton.getText().contains("Publication Date"));
			
	}
	
	public void verifySortByServiceSelectedOption(){
		Assert.assertTrue(sortByDateServiceTitleButton.getText().contains("Service"));
			
	}
	
	public void verifySortByTitleSelectedOption(){
		Assert.assertTrue(sortByDateServiceTitleButton.getText().contains("Title"));
			
	}
	
	public void clickRightDoubleArrow(){
		rightDoubleArrow.click();
	}
	
	public void clickLeftDoubleArrow(){
		leftDoubleArrow.click();
	}
	
	public void clickLastPageNumber(){
		lastPageNumber.click();
	}
	
	public String getLastPageNumber(){
		return lastPageNumber.getText();
	}
	
	public String getNumberOfResultsDisplayed(){
		String[] splittedResults= new String[100];
		try{
        splittedResults = resultsHeader.getText().split(" ");
	
		}catch(StaleElementReferenceException sere){
			
		}
		return splittedResults[0];
	}
	
	public void getNumberOfReportsAndVerifyResults() {
	int numberOfResultsDisplayed=Integer.parseInt(getNumberOfResultsDisplayed());
		if (!(numberOfResultsDisplayed <=15)) {
			    waitABit(2000);
			    clickRightDoubleArrow();
				waitABit(3000);
				System.out.println("1");
				Assert.assertEquals(String.valueOf((Integer.parseInt(getLastPageNumber()) - 1)* 15+ getNumberOfReportsPerPage()),getNumberOfResultsDisplayed().trim());
				System.out.println("2");			
			
		} else{
			System.out.println("3");
			Assert.assertEquals(String.valueOf(getNumberOfReportsPerPage()),getNumberOfResultsDisplayed().trim());
		}		
	}
	
	 
	public int getNumberOfReportsPerPage(){
		List<WebElement> reports = reportsListingContainer.findElements(By.cssSelector("div[class=' media clearfix ']"));
			
		return reports.size();
	}
	
	public void verifyIfCountryIsSelected(String geographyCode){ //country=AO
		geographyCode=geographyCode.trim();
		Assert.assertTrue("not found!", verifyElementState("document.getElementById('geography_"+geographyCode+"')"));
	    waitUntilLoadingDoesNotExistAndVerifyContainerDisplayed();
	}
	
	public void verifyIfServiceIsSelected(String serviceCode){
		Assert.assertTrue("not found!", verifyElementState("document.getElementById('service_"+serviceCode+"')"));
	}
	
	public void verifyIfReportTypeIsSelected(String reportCode){
		if(reportCode.contains("special_reports")){
	     Assert.assertTrue("Report type is not selected", verifyElementState("document.getElementById('new_form_"+reportCode+"')"));
		}
		else {
			 Assert.assertTrue("Report type is not selected", verifyElementState("document.getElementById('report_"+reportCode+"')"));
		}
	}
	
	public void selectSortByServiceFromDropDown(){
		sortByDateServiceTitleButton.click();
		serviceSortOption.click();
		waitUntilLoadingDoesNotExistAndVerifyContainerDisplayed();
	}
	
	public void clickSecondPage(){
		secondPage.click();
		waitABit(2000);
	}
	
	public void clickNextPage(){
		nextPage.click();
		waitABit(2000);
	}
	
	public void clickPreviousPage(){
		previousPage.click();
		waitABit(2000);
	}

	public void navigatePages(){
		clickSecondPage();
		waitUntilLoadingDoesNotExistAndVerifyContainerDisplayed();
		clickRightDoubleArrow();
		waitUntilLoadingDoesNotExistAndVerifyContainerDisplayed();
		clickLeftDoubleArrow();
		waitUntilLoadingDoesNotExistAndVerifyContainerDisplayed();
		clickNextPage();
		waitUntilLoadingDoesNotExistAndVerifyContainerDisplayed();
		clickPreviousPage();
		waitUntilLoadingDoesNotExistAndVerifyContainerDisplayed();
	}

	public void selectGeographyFromLeftHand(String geographyName) {
		List<WebElement> geographies = leftHandContainerGeographies.findElements(By
				.cssSelector("li>label"));
		clickShowMoreUntilNotDisplayed("geographies_filter");
		for (WebElement geography : geographies) {
			try {
				if (geography.getText().contains(geographyName)) {
					geography.click();
					break;
				}
			} catch (StaleElementReferenceException sere) {
				
			}

		}
		waitUntilLoadingDoesNotExistAndVerifyContainerDisplayed();
	}
	
	public void clickShowMoreUntilNotDisplayed(String container) {
		if(container.contains("report")){
	
			List <WebElement> showMoreDiv=getDriver().findElements(By.cssSelector("li[id='"+container+"'] > ul > li:nth-child(2) > ul > div"));
			System.out.println("Number of div from last ul: "+showMoreDiv.size());
			if(showMoreDiv.size()>0){
			showMoreLink=getDriver().findElement(By.cssSelector("li[id='"+container+"'] > ul > li:nth-child(2) > ul > div > a[class*='more']"));
			while (!showMoreLink.getAttribute("style").contains("display: none;")) {
				showMoreLink.click();
				}
			}
		}

		else{
			List <WebElement> showMoreDiv=getDriver().findElements(By.cssSelector("ul[id='"+container+"'] > li > ul > div"));
			if(showMoreDiv.size()>0){
            showMoreLink=getDriver().findElement(By.cssSelector("ul[id='"+container+"'] > li > ul > div > a[class*='more']"));
			}
		}

	}
	
	public void selectServiceFromLeftHand(String serviceName) {
		List<WebElement> services = leftHandContainerServices.findElements(By
				.cssSelector("li>label"));
		clickShowMoreUntilNotDisplayed("services_filter");
		for (WebElement service : services) {
			try {
				if (service.getText().contains(serviceName)) {
					service.click();
					break;
				}
			} catch (StaleElementReferenceException sere) {
				
			}

		}
		waitUntilLoadingDoesNotExistAndVerifyContainerDisplayed();
	}

	public void selectReportTypeFromLeftHand(String reportTypeName) {
		List<WebElement> reports = leftHandContainerReports.findElements(By
				.cssSelector(" li>label"));
		clickShowMoreUntilNotDisplayed("report_types");
		for (WebElement reportType : reports) {
			try {
				if (reportType.getText().contains(reportTypeName)) {
					reportType.click();
					break;
				}
			} catch (StaleElementReferenceException sere) {
				
			}

		}	
		waitUntilLoadingDoesNotExistAndVerifyContainerDisplayed();
	}
	
	public void waitUntilLoadingDoesNotExistAndVerifyContainerDisplayed(){
		//TODO Fix this
//		createDvpackPageAdm.waitUntilElementDoesntExist(By.cssSelector("div.loading"),20);
		verifyContainerDisplayedResultsPage();
	}
	
	public void verifyContainerDisplayedResultsPage(){
		Assert.assertTrue("Listing not loaded ",reportsListingContainer.isDisplayed());
	}
	
	public void clickOnBackToBMIReportsButtonAndVerifyBreadcrumb(){
		backToBMIReportsButton.click();
		Assert.assertTrue("This is not Reports Archive page or breadcrumb is wrong",currentPageBreadcrumb.getText().equals("Reports Archive"));
	}
	
	public void verifyServiceIsDeselected(String serviceCode){
		Assert.assertFalse("Service is not deselected!", verifyElementState("document.getElementById('service_"+serviceCode+"')"));
	}
	
	public void verifyGeographyIsDeselected(String geographyCode){
		geographyCode.trim();
		Assert.assertFalse("Geography is not deselected!", verifyElementState("document.getElementById('geography_"+geographyCode+"')"));
	}
	
	public void verifyReportTypeIsDeselected(String reportCode){
		
		if(reportCode.contains("special_reports")){
			Assert.assertFalse("Report is not deselected!", verifyElementState("document.getElementById('new_form_"+reportCode+"')"));
	 
		}
		else {
			Assert.assertFalse("Report is not deselected!", verifyElementState("document.getElementById('report_"+reportCode+"')"));
		}
	}
	
	public void backToReportsArchive() {
		backToBMIReportsButton.click();
	}
}
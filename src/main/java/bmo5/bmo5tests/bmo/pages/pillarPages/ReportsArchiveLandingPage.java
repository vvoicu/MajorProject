package bmo5.bmo5tests.bmo.pages.pillarPages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class ReportsArchiveLandingPage extends AbstractPage {

	@FindBy(id="q")
	@CacheLookup
	private WebElement reportTitleInput;
	
	@FindBy(id="geographies_filter")
	@CacheLookup
	private WebElement geographyFilterInput;
	
	@FindBy(css= "body > ul > li:nth-child(2) > a")
	@CacheLookup
	private WebElement elementList;
	
	@FindBy(css= "body > ul")
	@CacheLookup
	private WebElement reportsList; 
	
	@FindBy(css="form#bmi_reports_search_form > div:nth-child(1) > div > button:nth-child(1)")//form > div > div > button[type='submit']")
	@CacheLookup
	private WebElement searchButton;
	
	@FindBy(css="form > div > div > button[type='reset']")
	@CacheLookup
	private WebElement resetButton;
	
	@FindBy(css="select[class*='geographies'] > option")
	@CacheLookup
	private WebElement geographyOption;
	
	@FindBy(css="select[class*='geographies']")
	@CacheLookup
	private WebElement geographyList;
	
	@FindBy(css="div[class='btn-multiselect-group'] > a > i[class='icon-c-angle-right']")
	@CacheLookup
	private WebElement rightSimpleArrow;
	
	@FindBy(css="i[class='icon-c-angle-double-right']")
	@CacheLookup
	private WebElement rightDoubleArrow;
	
	@FindBy(css="div#date-container > div:nth-child(4) > div > span:nth-child(2) > label") //div[id='uniform-sort_by_service']")
	@CacheLookup
	private WebElement serviceSortRadiobutton;
	
	@FindBy(css="div#date-container > div:nth-child(4) > div > span:nth-child(3) > label") //div[id='uniform-sort_by_title']")
	@CacheLookup
	private WebElement titleSortRadiobutton;
	
	@FindBy(css="div#date-container > div:nth-child(4) > div > span:nth-child(1) > label")
	@CacheLookup
	private WebElement publicationDateSortRadiobutton;
	
	@FindBy(css="div[id='uniform-publication_date_lastmonth']")
	@CacheLookup
	private WebElement withinLastMonthRadiobutton;
	
	@FindBy(css="div[id='uniform-publication_date_any']")
	@CacheLookup
	private WebElement anytimeRadiobutton;
	
	@FindBy(css="div[id='services_checkboxes'] > div > label")
	@CacheLookup
	private WebElement allServicesCheckbox;
	
	@FindBy(id="start_date")
	@CacheLookup
	private WebElement startDateInput;
	
	@FindBy(id="end_date")
	@CacheLookup
	private WebElement endDateInput;
	
	private List<WebElement> geographies=find(By.cssSelector("select[class*='geographies']")).findElements(By.tagName("option"));
	private List <WebElement> servicesCheckboxes=find(By.cssSelector("div[class*='services_container']")).findElements(By.cssSelector("div label div span"));
	private int geographyListSize=geographies.size();
	
	public void typeSearchLettersAndVerifyReport(String searchLetters){
		reportTitleInput.sendKeys(searchLetters);
		String reportName=elementList.getText();
		elementList.click();
		clickSearchAndVerifyResultsContainerIsDisplayed();
		Assert.assertTrue("Title is not as expected", getDriver().findElement(By.cssSelector("div[class*='media-listing'] > div > div  h5 > a")).getText().contains(reportName));
	}
	
	
	public void typeReportTitle(String title){
		reportTitleInput.sendKeys(title);
	}
	
	public void clickSearchAndVerifyResultsContainerIsDisplayed(){
		searchButton.click();
		//TODO Fix this
//		ReportsArchiveListingPage reportsArchiveResults= new ReportsArchiveListingPage(getDriver());
//		reportsArchiveResults.verifyContainerDisplayedResultsPage();
	}
	
	public void clickGeographyRightSimpleArrow(){
		rightSimpleArrow.click();
	}
	
	public void clickGeographyRightDoubleArrow(){
		rightDoubleArrow.click();
	}
	
	public void filterGeographyLeftList(String continentName){
		geographyFilterInput.sendKeys(continentName);
	}
	
	public void selectAllServicesCheckboxAndVerifySelected(){
		allServicesCheckbox.click();
		
		for(WebElement service: servicesCheckboxes){
			Assert.assertTrue("Not all checkboxes are checked!",service.getAttribute("class").contains("checked"));
		}
	}
	
	public void selectSortByServiceRadiobutton(){
		serviceSortRadiobutton.click();
	}
	
	public void selectSortByTitleRadiobutton(){
		titleSortRadiobutton.click();
	}
	
	public void selectSortByPublicationDateRadiobutton(){
		publicationDateSortRadiobutton.click();
	}
	
	public void selectWithinLastMonthRadiobutton(){
		withinLastMonthRadiobutton.click();
	}
	
	public void selectGeographyByValue(String geography){

		for(WebElement geographyLabel:geographies){
			if(geographyLabel.getText().contains(geography)){
				geographyLabel.click();
			}
		}
	}
	
	public void selectServiceByValue(String service){
		List<WebElement> services=find(By.cssSelector("div[class*='services_container']")).findElements(By.cssSelector("div label"));
		
		for(WebElement serviceLabel:services){
			if(serviceLabel.getText().contains(service)){
				serviceLabel.click();
			}
		}
	}
	
	public void selectDateRange(String startDate, String endDate){
		startDateInput.sendKeys(startDate);
		endDateInput.sendKeys(endDate);
	}
	
	public void clickClearLink(){
		resetButton.click();
	}
	
	public void verifyGeographyFilterEmpty(){
		Assert.assertTrue("Geography filter input is not empty!",geographyFilterInput.getAttribute("value").equals(""));
	}
	
	public void verifyReportTitleEmpty(){
		Sleeper.sleepTight(5000);
		Assert.assertTrue("Report title input is not empty!",reportTitleInput.getAttribute("value").equals(""));
	}
	
	public void verifyGeographyRightListEmpty(){
		Assert.assertTrue("List is not empty",find(By.cssSelector("select[id='geographies']")).findElements(By.tagName("option")).size()==0);
	}
	
	public void verifyGeographyLeftListSize(){
		Assert.assertTrue("List has all geographies",find(By.cssSelector("select[class*='geographies']")).findElements(By.tagName("option")).size()==geographyListSize);
	}
	
	public void verifyServicesUnchecked(){
		for(WebElement service: servicesCheckboxes){
			Assert.assertFalse("Not all checkboxes are unchecked!",service.getAttribute("class").contains("checked"));
		}
	}
	
	public void verifyGeographySelectionInReportsArchiveInitialPage(String geoCodeBack,String country) {
		Assert.assertTrue("Geography is not in right list",getDriver().findElement(By.cssSelector("select#geographies > option[value='"+geoCodeBack+"']")).getText().contains(country));
	}
	
	public void verifyServiceSelectionInReportsArchiveInitialPage(String servCodeBack) {
		Assert.assertTrue("Service is not selected!", verifyElementState("document.getElementById('services_"+servCodeBack+"')"));
	}
	
	public void verifyStartEndDateInBackReportsArchivePage(String startDate,String endDate) {
		Assert.assertTrue("Wrong start date",getDriver().findElement(By.cssSelector("input#start_date")).getAttribute("value").contains(startDate));
		Assert.assertTrue("Wrong end date",getDriver().findElement(By.cssSelector("input#end_date")).getAttribute("value").contains(endDate));
	}
	
	public void verifySortByIsSelected(String sortOption) {
		Assert.assertTrue("Sort by is not selected", verifyElementState("document.getElementById('sort_by_"+sortOption+"')"));
	}
	
	public void verifyDataRangeIsSelected(String dateRangeOption) {
		Assert.assertTrue("Date range is not selected", verifyElementState("document.getElementById('publication_date_"+dateRangeOption+"')"));
	}
}

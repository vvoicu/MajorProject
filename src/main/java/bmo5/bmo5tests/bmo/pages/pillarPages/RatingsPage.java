package bmo5.bmo5tests.bmo.pages.pillarPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class RatingsPage extends AbstractPage {

	@FindBy(css = "div.media-widget-action.risk-save.active > a > i")
	private WebElement saveRatings;

	@FindBy(id = "excel-download")
	private WebElement downloadRawDataOnExcel;

	@FindBy(css = "div#permission-modal-pdf strong")
	private WebElement alertMessageDownload;

	@FindBy(css = "div#permission-modal-pdf div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialDownload;

	@FindBy(css = "td#pager_left > table > tbody > tr > td:nth-child(2) > div")
	private WebElement excelDownloadPeerGroup;

	@FindBy(css = "td#country_pager_left > table > tbody > tr > td:nth-child(2) > div > span")
	private WebElement excelDownloadRating;

	@FindBy(css = "form#risk_filter > div:nth-child(2) > ul:nth-child(1) > li > h5")
	private WebElement geographyTogglerFromFilter;

	@FindBy(css = "form#risk_filter > div:nth-child(2) > ul:nth-child(2) > li > h5")
	private WebElement indicatorsTogglerFromFilter;

	@FindBy(css = "form#risk_filter > div:nth-child(2) > ul:nth-child(3) > li > h5")
	private WebElement ratingTogglerFromFilter;

	@FindBy(css = "ul#id-geo > li:nth-child(1) > input")
	private WebElement searchRatingGeographyFilter;

	@FindBy(css = "form#risk_filter > div:nth-child(2) > ul:nth-child(1) > li > ul ")//ul#id-geo")
	private WebElement geographyList;

	@FindBy(css = "form#risk_filter > div:nth-child(2)  > ul:nth-child(2) > li i")
	private WebElement indicatorsArrowFromFilter;

	@FindBy(css = "form#risk_filter > div:nth-child(2)  > ul:nth-child(3) > li i")
	private WebElement ratingArrowFromFilter;

	@FindBy(css = "button#form-submit")
	private WebElement displayDataButton;

	@FindBy(css = "form#risk_filter > div:nth-child(2) > ul:nth-child(2) > li > ul ") 
	private WebElement indicatorsContainer;

	@FindBy(css = "form#risk_filter > div:nth-child(2) > ul:nth-child(3) > li > ul ")
	private WebElement ratingContainer;

	@FindBy(css = "table#list  > tbody:nth-child(1) ")
	private WebElement tableRating;

	@FindBy(css = "form#risk_filter >div:nth-child(2) > ul:nth-child(3) > li > h5 ")
	private WebElement selectRiskRewardForSelectedCountryFromFilter;

	@FindBy(css = "ul#id-rating > div ")
	private WebElement riskRewardFilterList;

	@FindBy(id = "date_range")
	private WebElement dateRangeToggler;

	@FindBy(id = "form#risk_filter > div:nth-child(2) > ul:nth-child(4) > li > ul")
	private WebElement containerDateRange;

	//@FindBy(css = "div.tabRatings > ul >li:nth-child(1) > a")
	
	@FindBy(css = "div#tab-methodological")
	private WebElement moreMethodologicalDetail;

	@FindBy(css = "div#tab-methodological > div:nth-child(1)> table > tbody:nth-child(1) > tr:nth-child(1) > td > h5")
	private WebElement titleForSovereignMethodology;

	@FindBy(css = "button.btn-link.btn-close-tab")
	private WebElement closeMethodologyButton;

	@FindBy(css = "div.tabRatings > ul > li:nth-child(2) > a")
	private WebElement briefMethodologyRating;

	//@FindBy(css = "div.tabRatings > div > div:nth-child(1) > div:nth-child(1) > table > tbody > tr:nth-child(2) > td  > h5:nth-child(1)")
	
	@FindBy(css = "div#tab-methodological > div.content-tab-brief.content-tabs.hidden-overflow table tbody tr td h2")
	private WebElement ratingScoreTitle;

	@FindBy(css = "form#risk_filter > div:nth-child(2) > ul:nth-child(3) > li > h5")
	private WebElement sovereignRiskToggler;

	@FindBy(css = "form#risk_filter > div:nth-child(4) > div:nth-child(1) > button")
	private WebElement downloadRawForTrialUser;



	
	public void expandSovereignRiskRatingFromFilter() {
		sovereignRiskToggler.click();
	}
	
	public void clickOnBriefMethodology() {
		briefMethodologyRating.click();
		waitABit(5000);
		Assert.assertTrue("not found!!!", ratingScoreTitle.getText().contains("Ratings Score Guide"));
	}

	public void closeMethodologyButton() {
		closeMethodologyButton.click();
	}

	public void clickAndVerifySovereignMethodology() {
		element(moreMethodologicalDetail).waitUntilVisible();
		moreMethodologicalDetail.click();
		waitABit(5000);
		Assert.assertTrue("not found!!!", titleForSovereignMethodology.getText().contains("Sovereign Risk Ratings Methodology"));
	}

	public void expandDateRange(String value) {
		dateRangeToggler.click();
		element(containerDateRange).waitUntilVisible();
		WebElement element = containerDateRange.findElement(By.cssSelector("label[title='"+value+"'] > div > span"));
		element(element).click();
		waitABit(5000);
	}

	public void expandRiskRewardFromFilterForCountryRisk(String value) {
		selectRiskRewardForSelectedCountryFromFilter.click();
		element(riskRewardFilterList).waitUntilVisible();
//		WebElement element = riskRewardFilterList.findElement(By.cssSelector("input[data-actual-value='"+value+"'] > label "));
//		element(element).click();
		
//		waitABit(5000);
//		Assert.assertTrue(element.isSelected());
		
		getDriver().findElement(By.cssSelector("ul#id-rating > div > li > label[for='"+value+"']")).click();
		
		Assert.assertTrue("not found!", verifyElementState("document.getElementById('"+value+"')"));
	}

	public void verifyCRRating() {
		WebElement element = getDriver().findElement(By.cssSelector("div#gview_list"));
		List<WebElement> rowCollection = element.findElements(By.cssSelector("table#list > tbody > tr"));
		System.out.println("Numer of rows in this table: "+rowCollection.size());
		//Here i_RowNum and i_ColNum, i am using to indicate Row and Column numbers. It may or may not be required in real-time Test Cases.       
		int i_RowNum = 1;
		for(WebElement rowElement:rowCollection)
		{
			List<WebElement> colCollection = rowElement.findElements(By.cssSelector("td:last-child"));
			int i_ColNum = 1;
			for(WebElement colElement:colCollection)
			{
				System.out.println("Row "+i_RowNum+" Column "+i_ColNum+" Data "+colElement.getText());
				i_ColNum = i_ColNum+1;
			}
			i_RowNum = i_RowNum+1;
		}
	}

	public void selectACountryFromTheTable(String geography) {
		element(tableRating).waitUntilVisible();
		WebElement element = tableRating.findElement(By.cssSelector("td[title='"+geography+"'] > a"));
		element(element).click();
	}

	public void saveRatings() {
		element(saveRatings).waitUntilVisible();
		saveRatings.click();
		waitABit(5000);
		element(getDriver().findElement(By.cssSelector("div#permission-enterprise-user > div:nth-child(1) > p > strong"))).waitUntilPresent();
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div#permission-enterprise-user > div:nth-child(1) > p > strong")).getText().contains("Please login with your child account credentials in order to be able to save content. If you do not have a child account, please create one from My BMI") );
		getDriver().findElement(By.cssSelector("div#permission-enterprise-user > div:nth-child(2) > button")).click();
	}

	public void downloadExcelRatingTable() {
		excelDownloadRating.click();
		downloadHandle();
	}

	public String saveRatingAsRegular(String ratingSavedName,String message){
		waitABit(3000);
		getDriver().findElement(By.cssSelector("div.media-widget-action.risk-save.active > div > button:nth-child(1)")).click();
		waitABit(5000);
		int ran;
		ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		ratingSavedName = ratingSavedName +ran;
		getDriver().findElement(By.cssSelector("div#modal-save-countryrisk > form > div:nth-child(1) > input:nth-child(2)")).sendKeys(ratingSavedName);
		waitABit(5000);

		getDriver().findElement(By.cssSelector("div#modal-save-countryrisk > div > a:nth-child(2)")).click();
		waitABit(10000);
		if (getDriver().findElement(By.cssSelector("div#modal-overwrite-save > div:nth-child(1) > p.error")).isDisplayed()) {
			getDriver().findElement(By.cssSelector("div#modal-overwrite-save > div:nth-child(2) > a:nth-child(2)")).click();
			}
			else if (getDriver().findElements(By.cssSelector("div.alert.alert-success")).size() ==1){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div.alert.alert-success")).getText().contains(message));}
		return ratingSavedName; 
	}

	public void verifySavedRatingCR(String one,String geography) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("span#geo-counter")).getText().contains(one));
		verifySelectedCountryInFilter(geography);
	}

	public void  verifyBrCROnSavedRating(String breadcrumb) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul.breadcrumb > li.active")).getText().contains(breadcrumb));
	}

	public void clickOnTheFirstCountryFromCRTable() {
		getDriver().findElement(By.cssSelector("table#list > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(3) > a")).click();
	}

	public void clickOnFirstCountruForSecurityTable() {
		getDriver().findElement(By.cssSelector("table#list > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > a")).click();
	}

	public void ClickOnDownloadRatings() {
		downloadRawDataOnExcel.click();
	}

	public void verifyRatingsDownloadForTrialUser() {
		downloadRawForTrialUser.click();
		waitABit(5000);
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#permission-modal-data-exports > div:nth-child(1) > p > strong")).getText().contains("Data Exports are not available for your account. Please contact your account manager, who will contact you promptly."));
		waitABit(3000);
		getDriver().findElement(By.cssSelector("div#permission-modal-data-exports > div:nth-child(2) > button")).click();
		waitABit(3000);
		getDriver().findElement(By.cssSelector("table#list > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(3) > a")).click();
		waitABit(10000);
		getDriver().findElement(By.cssSelector("td#country_pager_left >table > tbody> tr > td:nth-child(2)> div")).click();
		waitABit(5000);
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#permission-modal-data-exports > div:nth-child(1) > p > strong")).getText().contains("Data Exports are not available for your account. Please contact your account manager, who will contact you promptly."));
		waitABit(3000);
		getDriver().findElement(By.cssSelector("div#permission-modal-data-exports > div:nth-child(2) > button")).click();
		waitABit(5000);
		getDriver().findElement(By.cssSelector("a#peer-trigger")).click();
		waitABit(5000);
		excelDownloadPeerGroup.click();
		waitABit(5000);
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#permission-modal-data-exports > div:nth-child(1) > p > strong")).getText().contains("Data Exports are not available for your account. Please contact your account manager, who will contact you promptly."));
		waitABit(3000);
		getDriver().findElement(By.cssSelector("div#permission-modal-data-exports > div:nth-child(2) > button")).click();
	}

	public void verifySecurityProjectFinanceAndIndustryRisk() {
	//	downloadRawForTrialUser.click();
//		waitABit(5000);
//		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#permission-modal-data-exports > div:nth-child(1) > p > strong")).getText().contains("Data Exports are not available for your account. Please contact your account manager, who will contact you promptly."));
//		waitABit(3000);
//		getDriver().findElement(By.cssSelector("div#permission-modal-data-exports > div:nth-child(2) > button")).click();
//		waitABit(3000);
//		getDriver().findElement(By.cssSelector("table#list > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > a")).click();
//		waitABit(10000);
//		downloadRawForTrialUser.click();
//		waitABit(5000);
//		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#permission-modal-data-exports > div:nth-child(1) > p > strong")).getText().contains("Data Exports are not available for your account. Please contact your account manager, who will contact you promptly."));
//		waitABit(3000);
//		getDriver().findElement(By.cssSelector("div#permission-modal-data-exports > div:nth-child(2) > button")).click();
	}

	public void clickOnDownloadRatingsTrialUser() {
		//			Assert.assertTrue(alertMessageDownload.isDisplayed());
		//			cancelButtonModalWindowTrialDownload.click();
		Assert.assertTrue(getDriver().findElements(By.id("excel-download")).size() == 0);
	}

	public void downloadFirstTableOfACountry() {
		//			getDriver().findElement(By.cssSelector("td#country_pager_left >table > tbody> tr > td:nth-child(2)> div")).click();
		//			Assert.assertTrue(alertMessageDownload.isDisplayed());
		//			cancelButtonModalWindowTrialDownload.click();
		Assert.assertTrue(getDriver().findElements(By.cssSelector("a#csExport")).size() == 0);
	}

	public void downloadPeerGroupRatingTable() {
		//			getDriver().findElement(By.cssSelector("a#peer-trigger")).click();
		//			excelDownloadPeerGroup.click();
		//			waitABit(5000);
		//			Assert.assertTrue(alertMessageDownload.isDisplayed());
		//			cancelButtonModalWindowTrialDownload.click();
		Assert.assertTrue(getDriver().findElements(By.cssSelector("a#peer-trigger")).size() == 0);
	}

	public void  downloadRegionalPeerTable() {
		//getDriver().findElement(By.cssSelector("a#peer-trigger")).click();
		excelDownloadPeerGroup.click();
		waitABit(5000);
		downloadHandle();
	}

	public void verifyCountryArticleOrPeerGroupTable(String dateRange,String regPeer) {
		if (getDriver().findElements(By.cssSelector("div.tabbable > ul > li.active.rs_tab > a")).size() > 0) {
			System.out.println("Article on page!");
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div#risk-summary > div:nth-child(2)")).isDisplayed());
			Assert.assertTrue(getDriver().findElement(By.cssSelector("button.btn.btn-small.dropdown-toggle.rs_button_month")).isDisplayed());
			Assert.assertTrue(getDriver().findElement(By.cssSelector("button.btn.btn-small.dropdown-toggle.rs_button")).isDisplayed());
			waitABit(3000);
			verifyDateRangeMatchesArticleDatesRiskSummary(dateRange);
			waitABit(5000);
			Assert.assertTrue(getDriver().findElement(By.cssSelector("a#peer-trigger")).getText().contains(regPeer));
			getDriver().findElement(By.cssSelector("a#peer-trigger")).click();
		}
		else if(getDriver().findElements(By.cssSelector("a#peer-trigger")).size() > 0 || getDriver().findElements(By.cssSelector("div#gview_list > div:nth-child(1) > span")).size() > 0) {
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div#gview_list > div:nth-child(1) > span")).getText().contains(regPeer));
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div#gview_list")).isDisplayed());
		}
	}

	public void verifyDateRangeMatchesArticleDatesRiskSummary(String dateRange) {
		if (getDriver().findElements(By.cssSelector("button.btn.btn-small.dropdown-toggle.rs_button_month")).size() > 0){
			String drodownSummary = getDriver().findElement(By.cssSelector("button.btn.btn-small.dropdown-toggle.rs_button")).getText();
			System.out.println(drodownSummary);
			Assert.assertTrue(getDriver().findElement(By.cssSelector("h5#date_range")).getText().contains(dateRange));
			System.out.println("1");
			getDriver().findElement(By.cssSelector("h5#date_range")).click();
			System.out.println("2");
			waitABit(4000);
			String containerDateRange = getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-child(2) > ul:nth-child(4) > li > ul > li > input")).getAttribute("id");
			System.out.println(containerDateRange);
			waitABit(8000);
			if (drodownSummary.matches(containerDateRange)) {
				System.out.println("Dropdown matches LH filter!!!");
				Assert.assertTrue(true);}
		} else if (getDriver().findElements(By.cssSelector("button.btn.btn-small.dropdown-toggle.rpg_button")).size() > 0) {
			System.out.println("Only the Peer Group Table is displayed on page");
			String drodownSummary = getDriver().findElement(By.cssSelector("button.btn.btn-small.dropdown-toggle.rpg_button")).getText();
			System.out.println(drodownSummary);
			Assert.assertTrue(getDriver().findElement(By.cssSelector("h5#date_range")).getText().contains(dateRange));
			System.out.println("1");
			getDriver().findElement(By.cssSelector("h5#date_range")).click();
			System.out.println("2");
			waitABit(4000);
			String containerDateRange = getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-child(2) > ul:nth-child(4) > li > ul > li > input")).getAttribute("id");
			System.out.println(containerDateRange);
			waitABit(8000);
			if (drodownSummary.matches(containerDateRange)) {
				System.out.println("Dropdown matches LH filter!!!");
				Assert.assertTrue(true);}
		}
	}

	public void downloadPeerGroup() {
		//			excelDownloadPeerGroup.click();
		//			waitABit(5000);
		//			Assert.assertTrue(alertMessageDownload.isDisplayed());
		//			cancelButtonModalWindowTrialDownload.click();
		Assert.assertTrue(getDriver().findElements(By.cssSelector("a#peer-trigger")).size() == 0);
	}

	public void selectRatingFromDropDown(String rating) {
		selectFromDropdown(getDriver().findElement(By.cssSelector("select#goto")), rating);
	}

	public void downloadHandle() {
		String mainWindow = getDriver().getWindowHandle();
		getDriver().switchTo().activeElement();
		waitABit(5000);
		Robot newRobot;
		try {
			newRobot = new Robot();
			newRobot.keyPress(KeyEvent.VK_ESCAPE);
			newRobot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		getDriver().switchTo().window(mainWindow);
	}

	public void exapndGeographyFromFilter(String geography) {
		geographyTogglerFromFilter.click();
		waitABit(3000);
		//	Assert.assertTrue(getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-child(2) > ul:nth-child(1) > li > h5 > span > i")).getAttribute("class").contains("icon-c-right-dir"));
		searchRatingGeographyFilter.sendKeys(geography);
		waitABit(5000);
	}
	
	public void clickGeographySection(){
		geographyTogglerFromFilter.click();
	}

	public void selectOneGeograpyFromFilter(String geography) {
		element(geographyList).waitUntilVisible();
		//waitUntilElementDoesntExist(By.cssSelector("div.loading"), 30);
		WebElement element = geographyList.findElement(By.cssSelector("label[title='"+geography+"']"));
		element(element).click();
		waitABit(4000);
		System.out.println("selected!");
	}

	public void verifySelectedCountryInFilter(String geography) {
		geographyTogglerFromFilter.click();
	//	searchRatingGeographyFilter.clear();
		searchRatingGeographyFilter.sendKeys(geography);
		waitABit(4000);
		if (getDriver().findElements(By.cssSelector("form#risk_filter > div:nth-child(2) > ul:nth-child(1) > li > ul > li >ul > li > label > div > span.checked")).size() == 1){
			System.out.println("Geography found!!!!");
			waitABit(2000);
			Assert.assertTrue(getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-child(2) > ul:nth-child(1) > li > ul > li >ul > li > label > div > span.checked > input")).getAttribute("checked").contains(""));
		}
	}


	public void waitUntilElementDoesntExist(By by, int waitSeconds) {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		boolean elementPresent = false;
		for (int i = 0; i < waitSeconds; i++) {
			try {
				waitABit(1000);
				getDriver().findElement(by);
				elementPresent = true;
			} catch (Exception e) {
				getDriver().manage().timeouts()
				.implicitlyWait(30, TimeUnit.SECONDS);
				elementPresent = false;
				break;
			}
		}
		Assert.assertFalse("The element did not disappear after "
				+ waitSeconds + " seconds!", elementPresent);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void checkOneIndicatorFromList(String indicator){
		int numberOfIndicators = getDriver().findElements(By.cssSelector("ul#id-indicator > li")).size();
		String indInitialStatus = getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-child(2) > ul:nth-child(2) > li > h5 > span > span")).getText();
		for(int i=1; i<=numberOfIndicators; i++){
			if(getDriver().findElement(By.cssSelector("ul#id-indicator > li:nth-child(" + i + ") label")).getText().contains(indicator)){
				getDriver().findElement(By.cssSelector("ul#id-indicator > li:nth-child(" + i + ") label")).click();
				break;
			}
		}
		String indStatus = getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-child(2) > ul:nth-child(2) > li > h5 > span > span")).getText();
		System.out.println("status from All changed!");
		Assert.assertTrue(indInitialStatus != indStatus);
		waitABit(2000);
	}

	public void clickOnACountryFromTableSecurityRiskRating(String country){
		int numberOfCountries = getDriver().findElements(By.cssSelector("table#list > tbody:nth-child(1) > tr:nth-child(2)")).size();
		for(int i = 2; i <= numberOfCountries; i++){
			if(getDriver().findElement(By.cssSelector("table#list > tbody:nth-child(1) > tr:nth-child(" + i + ") > td:nth-child(1) > a")).getText().contains(country)){
				getDriver().findElement(By.cssSelector("table#list > tbody:nth-child(1) > tr:nth-child(" + i + ") > td:nth-child(1) > a")).click();
				break;
			}
		}
	}

	public void clickOnIndicatorsTogglerFromFilter(){
		indicatorsTogglerFromFilter.click();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-child(2) > ul:nth-child(2) > li > h5 > span > i")).getAttribute("class").contains("icon-c-down-dir"));
		waitABit(5000);
	}

	public void clickOnRatingTogglerFromFilter(){
		ratingTogglerFromFilter.click();
		Assert.assertTrue(ratingArrowFromFilter.getAttribute("class").contains("down"));
	}		

	public void checkOneRatingFromList(String rating){
		int numberOfIndicators = getDriver().findElements(By.cssSelector("div#rating_div > li")).size();
		for(int i=1; i<=numberOfIndicators; i++){
			if(getDriver().findElement(By.cssSelector("div#rating_div >  li:nth-child(" + i + ") label")).getText().contains(rating)){
				getDriver().findElement(By.cssSelector("div#rating_div > li:nth-child(" + i + ") label")).click();
				break;
			}
		}
	}

	public void clickOnDisplayDataButton(){
		displayDataButton.click();
	}

	public void verifyRatingsTable(String shortTermP,String longTermP,String shortTermE, String longTermE, String opRisk, String crIndex) {
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#gview_list")).isDisplayed());
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(1) > div")).isDisplayed());
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(2) > div")).isDisplayed());
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(3) > div")).isDisplayed());
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(4) > div")).getText().contains(shortTermP));
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(9) > div")).getText().contains(longTermP));
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(14) > div")).getText().contains(shortTermE));
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(20) > div")).getText().contains(longTermE));
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(27) > div")).getText().contains(opRisk));
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(32) > div")).getText().contains(crIndex));
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("div#jqgh_rank  ")).isDisplayed());
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("div#jqgh_rank_selection")).isDisplayed());
		getDriver().findElement(By.cssSelector("th#list_country > div > span > span:nth-child(2)")).click();
		waitABit(20000);
		verifyTableLine();
			if (getDriver().findElement(( By.cssSelector("div#jqgh_country > span > span:nth-child(2)"))).isDisplayed())
		{	
				getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).click();
				waitABit(16000);
				verifyTableLine();
		}
	}

	public void verifyRatingsOperationalRiskTable(String labour, String logistics,String trade, String crime, String opRisk) {
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#gview_list")).isDisplayed());
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(1) > div")).isDisplayed());
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(2) > div")).isDisplayed());
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(3) > div")).isDisplayed());
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(4) > div")).getText().contains(labour));
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(14) > div")).getText().contains(logistics));
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(24) > div")).getText().contains(trade));
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(34) > div")).getText().contains(crime));
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(45) > div")).getText().contains(opRisk));
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("div#jqgh_rank  ")).isDisplayed());
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("div#jqgh_rank_selection")).isDisplayed());
		getDriver().findElement(By.cssSelector("th#list_country > div > span > span:nth-child(2)")).click();
		waitABit(20000);
		verifyTableLine();
			if (getDriver().findElement(( By.cssSelector("div#jqgh_country > span > span:nth-child(2)"))).isDisplayed())
		{		
				getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).click();
				waitABit(20000);
				verifyTableLine();
		}
	}
	
	public void verifyTableLine() {
		String str,found = "false";
		java.util.List<WebElement> rows = getDriver().findElement(By.cssSelector("div#gbox_list")).findElements(By.tagName("tr"));
		for(WebElement row : rows)
		{
			java.util.List<WebElement> cols=row.findElements(By.tagName("td"));
			for(WebElement col : cols)
			{
				str = col.getText().trim();
				if(str.matches(getDriver().findElement(By.cssSelector("table#list > tbody > tr:nth-child(2) > td")).getText()))
				{
					java.util.List<WebElement> vals = row.findElements(By.tagName("td"));
					for(WebElement v:vals)
					{
						System.out.println(v.getText());
					}
					found = "true";
				}
			}
			if(found.matches("true"))
			{
				break;
			}
		}      
	}

	public void verifySecurityRiskTable(String titleOfRating, String securityIndex,String domestic, String shortTerm) {
		waitABit(5000);
		if (getDriver().findElement(By.cssSelector("article#content-wrapper > div:nth-child(3) > h4")).getText().contains(titleOfRating) ) {
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#gview_list > div:nth-child(1) > span")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#jqgh_country")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(1) > div")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(2) > div")).getText().contains(securityIndex));
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(6) > div")).getText().contains(domestic));
			waitABit(2000);
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(7) > div")).getText().contains(shortTerm));
			waitABit(5000);
			getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(1)")).click();
			waitABit(15000);
			verifyTableLine();
			waitABit(5000);
			Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).isDisplayed());
			getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).click();
			waitABit(16000);
			verifyTableLine();
		}
	}

	public void verifyProjectFinanceTable(String titleOfRating, String projIndex, String finance, String operation, String construction) {
		if (getDriver().findElement(By.cssSelector("article#content-wrapper > div:nth-child(4) > h4")).getText().contains(titleOfRating) ) {
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#gbox_list")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#jqgh_country")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(1) > div")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(2) > div")).getText().contains(projIndex));
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(3) > div")).getText().contains(finance));
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(7) > div")).getText().contains(operation));
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(11) > div")).getText().contains(construction));
			waitABit(5000);
			getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(1)")).click();
			waitABit(15000);
			verifyTableLine();
			waitABit(5000);
			Assert.assertTrue("not found!",getDriver().findElement( By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).isDisplayed());
			getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).click();
			waitABit(16000);
			verifyTableLine();
		}
	}

	public void verifyIndustryRiskRewardTable(String titleOfRating) {
		if (getDriver().findElement(By.cssSelector("article#content-wrapper > div:nth-child(3) > h4")).getText().contains(titleOfRating)) {				
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#gbox_list")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#jqgh_country")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(1) > div")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(2) > div")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(5) > div")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(8) > div")).isDisplayed());
			waitABit(5000);
			getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(1)")).click();
			waitABit(15000);
			verifyTableLine();
			waitABit(5000);
			Assert.assertTrue("not found!",getDriver().findElement( By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).isDisplayed());
			getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).click();
			waitABit(16000);
			verifyTableLine();
		}
	}
	
	public void verifyTourismTelecomRetailRatings(String titleOfRating,String riskRewardRet,String rewardsRet,String risksRet) {
		if (getDriver().findElement(By.cssSelector("article#content-wrapper > div:nth-child(3) > h4")).getText().contains(titleOfRating)) {				
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#gbox_list")).isDisplayed());
			System.out.println("1");
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#jqgh_country")).isDisplayed());
			System.out.println("2");
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(1) > div")).isDisplayed());
			System.out.println("3");
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(2) > div")).getText().contains(riskRewardRet));
			System.out.println("4");
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(3) > div")).getText().contains(rewardsRet));
			System.out.println("5");
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(6) > div")).getText().contains(risksRet));
			System.out.println("6");
			waitABit(5000);
			getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(1)")).click();
			System.out.println("7");
			waitABit(30000);
			verifyTableLine();
			System.out.println("8");
			waitABit(5000);
			Assert.assertTrue("not found!",getDriver().findElement( By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).isDisplayed());
			getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).click();
			waitABit(16000);
			verifyTableLine();
		}
	}
	
	public void verifyInsuranceRating (String titleOfRating,String riskRewIndex,String reward,String risks,String industryRisk) {
		if (getDriver().findElement(By.cssSelector("article#content-wrapper > div:nth-child(3) > h4")).getText().contains(titleOfRating)) {				
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#gbox_list")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#jqgh_country")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(1) > div")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(2) > div")).getText().contains(riskRewIndex));
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(3) > div")).getText().contains(reward));
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(8) > div")).getText().contains(risks));
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(9) > div")).getText().contains(industryRisk));
			waitABit(5000);
			getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(1)")).click();
			waitABit(15000);
			verifyTableLine();
			waitABit(5000);
			Assert.assertTrue("not found!",getDriver().findElement( By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).isDisplayed());
			getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).click();
			waitABit(16000);
			verifyTableLine();
			} 
		}

	public void verifyOilAndGasRating(String titleOfRating,String combinedIndex,String upstreamIndex, String downstreamIndex) {
		if (getDriver().findElement(By.cssSelector("article#content-wrapper > div:nth-child(3) > h4")).getText().contains(titleOfRating)) {				
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#gbox_list")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#jqgh_country")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(1) > div")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(2) > div")).getText().contains(combinedIndex));
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(3) > div")).getText().contains(upstreamIndex));
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(10) > div")).getText().contains(downstreamIndex));
			waitABit(5000);
			getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(1)")).click();
			waitABit(15000);
			verifyTableLine();
			waitABit(5000);
			Assert.assertTrue("not found!",getDriver().findElement( By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).isDisplayed());
			getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).click();
			waitABit(16000);
			verifyTableLine();
			} 
	}

	public void verifyMedicalDevicesRating(String titleOfRating,String rewards,String risksMed,String mdIndex) {
		if (getDriver().findElement(By.cssSelector("article#content-wrapper > div:nth-child(3) > h4")).getText().contains(titleOfRating)) {				
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#gbox_list")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#jqgh_country")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(1) > div")).isDisplayed());
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(2) > div")).getText().contains(rewards));
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(5) > div")).getText().contains(risksMed));
			Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("tr.ui-jqgrid-labels.ui-sortable > th:nth-child(8) > div")).getText().contains(mdIndex));
			waitABit(5000);
			getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(1)")).click();
			waitABit(15000);
			verifyTableLine();
			waitABit(5000);
			Assert.assertTrue("not found!",getDriver().findElement( By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).isDisplayed());
			getDriver().findElement(By.cssSelector("div#jqgh_country > span > span:nth-child(2)")).click();
			waitABit(16000);
			verifyTableLine();
			} 
	}
	
	public void verifyMethodologyOnRatings(String moreMethodology, String brief, String save) throws InterruptedException {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("article#content-wrapper >div:nth-child(2) > div:nth-child(6) > ul > li:nth-child(1) > a")).getText().contains(moreMethodology));
		getDriver().findElement(By.cssSelector("article#content-wrapper >div:nth-child(2) > div:nth-child(6) > ul > li:nth-child(1) > a")).click();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#tab-methodological")).getSize()!=null);
		//this must be verified
		//boolean scrollBarPresent = (boolean) ((JavascriptExecutor)getDriver()).executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
		//Assert.assertTrue(scrollBarPresent);
		//or
		//JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		//jse.executeScript("window.scrollBy(0,200)");
		
		/*Assert.assertTrue(getDriver().findElement(By.cssSelector("a.read-more-link.read-link.read-more > i")).getAttribute("class").contains("icon-c-chevron-down"));
		getDriver().findElement(By.cssSelector("a.read-more-link.read-link.read-more > i")).click();
		waitABit(3000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("a.read-more-link.read-less.show > i")).getAttribute("class").contains("icon-c-chevron-up"));
		
		

		Actions dragger = new Actions(getDriver());

		WebElement draggablePartOfScrollbar = getDriver().findElement(By.cssSelector("#tab-methodological > div:nth-child(1) > table:nth-child(1)"));

		int numberOfPixelsToDragTheScrollbarDown = 100;

		dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(
				0,numberOfPixelsToDragTheScrollbarDown).release().perform();

		or...
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		//locate web element you need for scroll and its height
		WebElement element = getDriver().findElement(By.cssSelector(""));
		String blockHeight = "return arguments[0].offsetHeight";

		String myscript = "arguments[0].scrollTop"+jse.executeScript(blockHeight,element);

		element.click();
		Thread.sleep(3000);
		try {
		jse.executeScript(myscript, element); 
		}catch(Error e) {
			System.err.println();
		}
		
		*/
		getDriver().findElement(By.cssSelector("button.btn-link.btn-close-tab")).click();
		waitABit(2000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.btn-group.saved-data > button")).getText().contains(save));
	}
	
	public void verifyMethodologyOnRatingsPoliticalRisk(String moreMethodology, String brief, String save) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("article#content-wrapper >div:nth-child(2) > div:nth-child(6) > ul > li:nth-child(1) > a")).getText().contains(moreMethodology));
		//	Assert.assertTrue(getDriver().findElement(By.cssSelector("article#content-wrapper >div:nth-child(2) > div:nth-child(4) > ul > li:nth-child(2) > a")).getText().contains(brief));
		getDriver().findElement(By.cssSelector("article#content-wrapper >div:nth-child(2) > div:nth-child(6) > ul > li:nth-child(1) > a")).click();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#tab-methodological")).getSize()!=null);
		getDriver().findElement(By.cssSelector("button.btn-link.btn-close-tab")).click();
		waitABit(2000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.btn-group.saved-data > button")).getText().contains(save));
	}

	public void verifyMethodologyOnRatingsIndustries(String moreMethodology, String brief,String save) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("article#content-wrapper >div:nth-child(2) > div > ul > li:nth-child(1) > a")).getText().contains(moreMethodology));
		getDriver().findElement(By.cssSelector("article#content-wrapper >div:nth-child(2) > div > ul > li:nth-child(1) > a")).click();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#tab-methodological")).getSize()!=null);
		getDriver().findElement(By.cssSelector("button.btn-link.btn-close-tab")).click();
		waitABit(2000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.btn-group.saved-data > button")).getText().contains(save));
	}

	public void verifyMethodologyOnRatingsProjectRisk(String moreMethodology, String brief,String save) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("article#content-wrapper >div:nth-child(3) >  ul > li:nth-child(1) > a")).getText().contains(moreMethodology));
		getDriver().findElement(By.cssSelector("article#content-wrapper >div:nth-child(3) >  ul > li:nth-child(1) > a")).click();
		waitABit(3000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#tab-methodological")).getSize()!=null); 
		getDriver().findElement(By.cssSelector("button.btn-link.btn-close-tab")).click();
		waitABit(2000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.btn-group.saved-data > button")).getText().contains(save));
	}
	
	public void verifyBriefOnRatings(String moreMethodology, String brief,String save) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("article#content-wrapper >div:nth-child(2) > div:nth-child(6) > ul > li:nth-child(2) > a")).getText().contains(brief));
		getDriver().findElement(By.cssSelector("article#content-wrapper >div:nth-child(2) > div:nth-child(6) > ul > li:nth-child(2) > a")).click();
		waitABit(3000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#tab-brief")).getSize()!=null);
		getDriver().findElement(By.cssSelector("button.btn-link.btn-close-tab")).click();
		waitABit(2000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.btn-group.saved-data > button")).getText().contains(save));
	}

	public void verifyBriefOnRatingsIndustriesAndSecurity(String moreMethodology, String brief,String save) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("article#content-wrapper > div:nth-child(2) > div >ul > li:nth-child(2) > a")).getText().contains(brief));
		getDriver().findElement(By.cssSelector("article#content-wrapper > div:nth-child(2) > div >ul > li:nth-child(2) > a")).click();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#tab-brief")).getSize()!=null);
		getDriver().findElement(By.cssSelector("button.btn-link.btn-close-tab")).click();
		waitABit(2000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.btn-group.saved-data > button")).getText().contains(save));
	}

	public void verifyBriefOnRatingsProjectRisk(String moreMethodology, String brief,String save) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("article#content-wrapper > div:nth-child(3) > ul > li:nth-child(2) > a")).getText().contains(brief));
		getDriver().findElement(By.cssSelector("article#content-wrapper > div:nth-child(3) > ul > li:nth-child(2) > a")).click();
		waitABit(3000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#tab-brief")).getSize()!=null);
		getDriver().findElement(By.cssSelector("button.btn-link.btn-close-tab")).click();
		waitABit(2000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.btn-group.saved-data > button")).getText().contains(save));
	}
	
   public void verifyEntitledGeographyFromLeftHandFilterRatings(String entitledGeography,String continentForEntitledGeo){
		List<WebElement> continents=getDriver().findElements(By.cssSelector("form#risk_filter > div:nth-of-type(2) > ul.nav.nav-list > li > ul#id-geo>*"));
	    getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-of-type(2) > ul.nav.nav-list > li > h5")).click();
	    
		for(int i=2;i<=continents.size();i++){
			System.out.println("Continent!!! "+getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-of-type(2) > ul.nav.nav-list > li > ul#id-geo > li:nth-child("+i+") > label")).getText());
			Assert.assertTrue("Other unentitled continent is displayed",getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-of-type(2) > ul.nav.nav-list > li > ul#id-geo > li:nth-child("+i+") > label")).getText().contains(continentForEntitledGeo));
			
			if(getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-of-type(2) > ul.nav.nav-list > li > ul#id-geo > li:nth-child("+i+") > label")).getText().contains(continentForEntitledGeo)){
			getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-of-type(2) > ul.nav.nav-list > li > ul#id-geo > li:nth-child("+i+") > button")).click();
			waitUntilElementExists(By.cssSelector("form#risk_filter > div:nth-of-type(2) > ul.nav.nav-list > li > ul#id-geo > li:nth-child("+i+") > ul"), 5);
			WebElement countriesContainer=	getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-of-type(2) > ul.nav.nav-list > li > ul#id-geo > li:nth-child("+i+") > ul"));
			List <WebElement> countries= countriesContainer.findElements(By.cssSelector("li > label"));

			    for(int j=0;j<countries.size();j++){
				System.out.println("Current country: " +countries.get(j).getText());
			    Assert.assertTrue("Unentitled countries are displayed in filter" , countries.get(j).getText().contains(entitledGeography));
				}
			}
		}
	}

	public void verifyUnentitledRatingsLeftContainer(String entitledService){
	WebElement leftContainer=getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(1)"));
	List<WebElement> ratingsSubContainers=leftContainer.findElements(By.cssSelector("div[class*='row-fluid']"));
	//TODO Fix this
//	HomePageTopMenuPage homePage=new HomePageTopMenuPage(getDriver());
	
	for(int i=1; i<=ratingsSubContainers.size();i++){
		
	WebElement firstContainer=	getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(1) > div:nth-child("+i+")"));
	List<WebElement> ratingsFirstContainer=firstContainer.findElements(By.cssSelector("div[class*='span6 widget']"));
	
		for(int j =1; j<= ratingsFirstContainer.size();j++){
	
			if(!getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(1) > div:nth-child("+i+") > div:nth-child("+j+") > h4 > a")).getText().contains(entitledService)&&!getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(1) > div:nth-child("+i+") > div:nth-child("+j+") > h4 > a")).getText().contains("Project Risk Index")){
				Assert.assertTrue("Unentitled rating is enabled",getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(1) > div:nth-child("+i+") > div:nth-child("+j+")")).getAttribute("class").contains("disabled")||getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(1) > div:nth-child("+i+")" )).getAttribute("class").contains("disabled"));
				getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(1) > div:nth-child("+i+") > div:nth-child("+j+") > a")).click();
				System.out.println("Clicked unentitled rating: "+getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(1) > div:nth-child("+i+") > div:nth-child("+j+") > h4 > a")).getText());
				waitABit(2000);
//				homePage.assertAccountManagerWindowIsDisplayed();
				waitABit(2000);
				}
			else
				Assert.assertTrue("Entitled rating is disabled",!getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(1) > div:nth-child("+i+") > div:nth-child("+j+")")).getAttribute("class").contains("disabled")||!getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(1) > div:nth-child("+i+")" )).getAttribute("class").contains("disabled"));
			}
		}
	}
	
	public void verifyUnentitledRatingsRightContainer(String entitledService){
	WebElement rightContainer=getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(2) > div[class='row-fluid'] > div > div"));
	List<WebElement> ratingsSubContainers=rightContainer.findElements(By.cssSelector("ul"));
	//TODO Fix this
//	HomePageTopMenuPage homePage=new HomePageTopMenuPage(getDriver());
	
	for(int i=1; i<=ratingsSubContainers.size();i++){
		
	WebElement secondContainer=	getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(2) > div[class='row-fluid'] > div > div >ul:nth-child("+i+")"));
	List<WebElement> ratingsFirstContainer=secondContainer.findElements(By.cssSelector("li"));
	
		for(int j =1; j<= ratingsFirstContainer.size();j++){
	
			if(!getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(2) > div[class='row-fluid'] > div > div >ul:nth-child("+i+")> li:nth-child("+j+") > a")).getText().contains(entitledService)&&!getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(1) > div:nth-child("+i+") > div:nth-child("+j+") > h4 > a")).getText().contains("Project Risk Index")){
				Assert.assertTrue("Unentitled rating is enabled",getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(2) > div[class='row-fluid'] > div > div >ul:nth-child("+i+")> li:nth-child("+j+")")).getAttribute("class").contains("disabled"));
				getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(2) > div[class='row-fluid'] > div > div >ul:nth-child("+i+")> li:nth-child("+j+") > a")).click();
				System.out.println("Clicked unentitled rating: "+getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(2) > div[class='row-fluid'] > div > div > ul:nth-child("+i+")> li:nth-child("+j+") > a")).getText());
				waitABit(2000);
//				homePage.assertAccountManagerWindowIsDisplayed();
				waitABit(2000);
				break; //get out of the loop once a rating is checked
				//comment the break if you want to check all ratings :)
				}
			else
				Assert.assertTrue("Entitled rating is disabled",!getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(2) > div[class='row-fluid'] > div > div >ul:nth-child("+i+")> li:nth-child("+j+")")).getAttribute("class").contains("disabled"));
			}
		}
	}
	
	public boolean verifyIfEntitledServiceIsInfrastructureandCheckPRojectRiskIndex(String entitledService){
		if(entitledService.equals("Infrastructure")){
			getDriver().findElement(By.cssSelector("article.span10 > div:nth-child(1) > div:nth-of-type(2) > div:nth-of-type(2) > h4 > a")).click();
			return true;
		}else
			return false;
	}
	
	/** div/span was removed (uniform class was removed) and so this method doesn't work anymore (checkboxes are greyed out)
	 * Verifies parents and all children of the selected parent are deselected 
	 * @param filterSection - The section for which the verify is done (E.g. Geography section = geo, Indicators section =indicator, Index score section = rating)
	 * @param selectedParentOption - The option that was selected before clear filters; 
	 */
	public void verifyOptionIsDeselectedRatings(String filterSection, String selectedParentOption){
		int sectionNumber=0;
		 boolean isIndicatorSelected,isScoreSelected, isContinentSelected;
		switch(filterSection){
		
		  case "geo":
			  sectionNumber=1;
		      break;
		      
		  case "indicator":
			  sectionNumber=2;
		      break;
		      
		  case "rating":
			  sectionNumber=3;
		      break;
		}
		selectedParentOption=selectedParentOption.trim();
		System.out.println(selectedParentOption);
		  
		if(filterSection.equals("geo")){
	    isContinentSelected=verifyElementState("document.getElementById('"+selectedParentOption+"')");
	    Assert.assertFalse("Parent is checked",isContinentSelected);	
		}
		if(filterSection.equals("indicator")){
		isIndicatorSelected=verifyElementState("document.getElementById('ind_"+selectedParentOption+"')");
		getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-of-type(2) > ul:nth-of-type("+sectionNumber+") > li > h5")).click();
		Assert.assertFalse("Parent is checked",isIndicatorSelected);
		}
		if(filterSection.equals("rating")){
		isScoreSelected=verifyElementState("document.getElementById('"+selectedParentOption+"')");
		getDriver().findElement(By.cssSelector("form#risk_filter > div:nth-of-type(2) > ul:nth-of-type("+sectionNumber+") > li > h5")).click();
		Assert.assertFalse("Parent is checked",isScoreSelected);
		}
	}
	
	public int getTableRowsSize(){
		List<WebElement> tableRows=tableRating.findElements(By.cssSelector("tr"));
		System.out.println("Number of rows inside index table: "+tableRows.size());
		return tableRows.size();
	}
	
	public void verifyTableRows(int expectedNumber, int actualNumber){
		Assert.assertEquals(expectedNumber,actualNumber);
	}
	
	public void verifyBriefAndMethodologyPresenceOnPage() {
		if(getDriver().findElements(By.cssSelector("div.tabRatings > ul > li > a[href='#tab-brief']")).size() == 1) {
			Assert.assertTrue("Brief outline is not present on the page!!!!", getDriver().findElement(By.cssSelector("div.tabRatings > ul > li > a[href='#tab-brief']")).isDisplayed());
		} else if(getDriver().findElements(By.cssSelector("div.tabRatings > ul > li > a[href='#tab-brief']")).size() == 1 && getDriver().findElements(By.cssSelector("div.tabRatings > ul > li > a[href='#tab-methodological']")).size() == 1){
			Assert.assertTrue("Brief outline is not present on the page!!!!", getDriver().findElement(By.cssSelector("div.tabRatings > ul > li > a[href='#tab-brief']")).isDisplayed());
			Assert.assertTrue("Methodology is not on page!", getDriver().findElement(By.cssSelector("div.tabRatings > ul > li > a[href='#tab-methodological']")).isDisplayed());
		}
				else
		{
			Assert.assertTrue("Methodology is not on page!", getDriver().findElement(By.cssSelector("div.tabRatings > ul > li > a[href='#tab-methodological']")).isDisplayed());
		}
	}
}

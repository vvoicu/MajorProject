package bmo5.bmo5tests.bmo.pages;



import java.awt.event.KeyEvent;
import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.desktop.DesktopKeyboard;

import bmo5.bmo5tests.tools.FileChecker;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class MncMdgPage extends AbstractPage {

	@FindBy(css = "button.btn.btn-wider.btn-primary")
	private WebElement searchButton;

	@FindBy(css = "button.btn.btn-link.all-reset ")
	private WebElement clearFormButton;

	@FindBy(id = "company-name")
	private WebElement comapanyTextArea;

	@FindBy(id = "address")
	private WebElement adressTextArea; 

	@FindBy(id = "job-title")
	private WebElement jobTextArea;

	@FindBy(css = "div#accordion2 > div:nth-child(1) > div > a")
	private WebElement expandCompanyLocationGeography;	

	@FindBy(css = "div#accordion2 > div:nth-child(2) > div > a")
	//@CacheLookup
	private WebElement expandCompanyNationality;

	@FindBy(id = "geo_filt")
	private WebElement geographySearchLocation;

	@FindBy(css = "div#accordion2")
	private WebElement containerMNCOptionsToSelect;

	@FindBy(css = "div.media-listing.clearfix.company-search-results > ul:nth-child(1)")
	private WebElement containerForCompaniesList;

	@FindBy(css = "div.btn-toolbar.pull-right")
	private WebElement printButton;

	@FindBy(css = "address > strong")
	private WebElement textInsidePrintDetails;

	@FindBy(css = "div.pull-right > a:nth-child(1) ")
	private WebElement clickPrintinsidePrintArticle;

	@FindBy(css = "div.pull-right > a:nth-child(2)")
	private WebElement clickCloseinsidePrintArticle;

	@FindBy(css = "a[href='/home']")
	private WebElement firstBreadcrumb;

	@FindBy(css = "ul.breadcrumb li.active ")
	private WebElement lastBreadcrumb;

	@FindBy(id = "cr")
	private WebElement companiesRepresentedTextArea;

	@FindBy(id = "product-areas")
	private WebElement productAreasTextField;

	@FindBy(css = "button.btn.btn-link.reset-geographies")
	private WebElement clearButton;

	@FindBy(id = "job_filt")
	private WebElement jobSearchFilter;

	@FindBy(id = "sjob")
	private WebElement expandJobOption;

	@FindBy(css = "a#csExport")
	private WebElement exportButton;

	@FindBy(css = "div.container-fluid > section:nth-child(6) > article > button")
	private WebElement saveThisSearchButton;

	@FindBy(css = "button.btn.btn-link.reset-geographies")
	private WebElement clearCompanyLocation;

	@FindBy(css = "button.btn.btn-link.reset-nationalities")
	private WebElement clearCompanyNationality;

	@FindBy(css = "button.btn.btn-link.reset-jobs")
	private WebElement clearJob;

	@FindBy(css = "button.btn.btn-link.reset-industries")
	private WebElement clearIndustry;

	@FindBy(id = "nat_filt")
	private WebElement nationalitySearchFilter;

	@FindBy(id = "industries_filt")
	private WebElement industrySearchFilter; 

	@FindBy (id = "all_geographies")
	private WebElement geographyList;

	@FindBy (id = "natleft")
	private WebElement nationalityList;

	@FindBy (id = "jobleft")
	private WebElement jobList;

	@FindBy ( id = "coleft")
	private WebElement industryList;

	@FindBy ( css= "div.navbar-inner > ul > li > a")
	private WebElement webinarsTopPage;

	@FindBy(css =" li#webinars_dropdown > ul > li.text-center > a")
	private WebElement webinarsAndPodcastsViewAll;

	@FindBy(css = "a.btn.dropdown-toggle")
	private WebElement myBimoTopPage;

	@FindBy(css = "ul.dropdown-menu.pull-right > li:nth-child(3) > a")
	private WebElement myBimoAccountFromDropDown;

	@FindBy(css = "ul.dropdown-menu.pull-right > li:nth-child(5) > span > a")
	private WebElement myBimoLogOut;

	@FindBy (css = "div#mnc-save-modal button.btn.btn-primary")
	private WebElement clickPopUpSaveSearch;

	@FindBy ( css = "input#title")
	private WebElement textAreaPopUpSaveSearch;

	@FindBy(css = "ul.breadcrumb > li.active")
	private WebElement breadcrumbLast;

	@FindBy(css = "ul.breadcrumb > li:nth-child(2) > a")    
	private WebElement breadcrumbFirst;

	@FindBy(css = "div#permission-modal-data-exports strong")
	private WebElement alertMessageExport;

	@FindBy(css = "div#permission-modal-data-exports > div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialExportWindow;
	
	@FindBy(css = "a[href='/authentication/logout']")
	private WebElement logoutButton;

	@FindBy(css = "a[href='/account/profile/my_profile']")
	private WebElement accountDropdown;
	
	@FindBy(css = "a[href='#company-save-modal']")
	private WebElement printCompanyDetail;
	
	@FindBy(css = "div.alert.alert-success")
	private WebElement successMessage;
	
	@FindBy(css = "div#subscriptions > h5")
	private WebElement selectedCompanyProfile;
	
	@FindBy(css = "article > div.paginaxor.pagination-listing.pagination.pagination-small.pagination-centered")//div.container-fluid > section:nth-child(7) > section:nth-child(2) >article >  div:nth-child(2)")
	private WebElement paginatorMdg;
	
	
	public void selectWebinars(String breadcrumb) {
		if (getDriver().findElements(By.cssSelector("li#webinars_dropdown > a")).size() == 1)
		{
			webinarsTopPage.click();
			webinarsAndPodcastsViewAll.click();
			Assert.assertTrue(getDriver().findElement(By.cssSelector("li#webinars_dropdown > a")).getText().contains(breadcrumb));
		}  
		else {
			System.out.println("There are no Webinars& Podcasts on the page!!!");
		}
	}

	public void selectMyBimo() {
		myBimoTopPage.click();
	}

	public void logOutBimo() {
		element(myBimoLogOut).waitUntilVisible();
		myBimoLogOut.click();
	}

	public void dropdownBimo(String logout,String account) {
		element(myBimoAccountFromDropDown).waitUntilVisible();
		Assert.assertTrue(logoutButton.getText().contains(logout));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > header > div > div > div > ul > li:nth-child(3) > a")).getText().contains(account));
		myBimoAccountFromDropDown.click();
	}

	public void dropdownBimoMdg(String logout,String account) {
		element(myBimoAccountFromDropDown).waitUntilVisible();
		waitABit(3000);
		Assert.assertTrue(logoutButton.getText().contains(logout));
		Assert.assertTrue(accountDropdown.getText().contains(account));
		myBimoAccountFromDropDown.click();
	}

	public void selectExportButton() {
		Assert.assertTrue("Not selected!!", exportButton.isDisplayed());
		exportButton.click();
	}

	public void clickOnClearCompany() {
		Assert.assertTrue("Not selected!!",clearCompanyLocation.isDisplayed());
		clearCompanyLocation.click();
	}

	public void clickOnClearJob() {
		clearJob.click();
	}

	public void clickOnClearIndustry() {
		Assert.assertTrue("Not selected!!",clearIndustry.isDisplayed());
		clearIndustry.click();
	}

	public void selectJobFromMDGOptions() {
		expandJobOption.click();
	}

	public void exportAsTrialUser (String extension) {
		if(getDriver().findElements(By.cssSelector("button#filter-download-data")).size() > 0){
			System.out.println("DV Pack from Data Tool or BMI Databases");
			exportButton.click();
			saveImageHandle2();
			//			saveImageHandle1();
			FileChecker file = new FileChecker();
			file.verifyExtentionExcelFileFromDataToolTrialUser(extension);
		}
			else if(getDriver().findElements(By.cssSelector("button[href='#permission-modal-data-exports']")).size() > 0){
			System.out.println("Dv Pack from Ratings");
			getDriver().findElement(By.cssSelector("button[href='#permission-modal-data-exports']")).click();
			Assert.assertTrue(alertMessageExport.isDisplayed());
			cancelButtonModalWindowTrialExportWindow.click();
		}
	}

	public void saveImageHandle2() {
		String mainWindow = getDriver().getWindowHandle();
		getDriver().switchTo().activeElement();
		waitABit(3000);
		Keyboard keyboard = new DesktopKeyboard();
		waitABit(1000);
		keyboard.keyDown(KeyEvent.VK_ENTER);
		keyboard.keyUp(KeyEvent.VK_ENTER);
		getDriver().switchTo().window(mainWindow);
	}

	public void clickSearchButton(String search) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("button.btn.btn-wider.btn-primary")).getText().contains(search));
		searchButton.click();
	}

	public void typeCompanyName(String companyTitle,String companyName) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input#company-name")).getAttribute("placeholder").contains(companyTitle));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input#company-name")).getAttribute("value").contains(""));
		comapanyTextArea.sendKeys(companyName);
	}

	public void typeAdressTextArea(String address,String adressName) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input#address")).getAttribute("value").contains(""));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input#address")).getAttribute("placeholder").contains(address));
		adressTextArea.sendKeys(adressName);
		adressTextArea.clear();
	}

	public void typeJobName(String jobTitle,String jobName) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input#job-title")).getAttribute("value").contains(""));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input#job-title")).getAttribute("placeholder").contains(jobTitle));
		jobTextArea.sendKeys(jobName);
		jobTextArea.clear();
	}

	public void searchForJob(String jobOption) {
		jobSearchFilter.sendKeys(jobOption);
	}

	public void searchForNationality(String nationality) {
		nationalitySearchFilter.sendKeys(nationality);
	}

	public void searchForIndustry(String industry) {
		industrySearchFilter.sendKeys( industry);
	}

	public void verifyMdgExpandableSectionsName(String companyLoc,String job) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#CompanySearch > section:nth-child(9) > div > div > div > div > div:nth-child(1) > div:nth-child(1) > div > h5")).getText().contains(companyLoc));
		evaluateJavascript("$(\"div#accordion2 > div:nth-child(1) > div > a\").click();");
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#CompanySearch > section:nth-child(9) > div > div > div > div > div:nth-child(2) > div:nth-child(1) > div > h5")).getText().contains(job));
	}

	public void clickCompanyLocationGeography(String companyLoc) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#CompanySearch > section:nth-child(3) > div > div > div > div > div:nth-child(1) > div:nth-child(1) > div > h5")).getText().contains(companyLoc));
		evaluateJavascript("$(\"div#accordion2 > div:nth-child(1) > div > a\").click();");
		waitABit(5000);
	}

	public void clickCompanyNationality(String companyNat) {
		waitABit(2000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#CompanySearch > section:nth-child(3) > div > div > div > div > div:nth-child(2) > div:nth-child(1) > div > h5")).getText().contains(companyNat));
		evaluateJavascript("$(\"div#accordion2 > div:nth-child(2) > div > a\").click();");
		waitABit(5000);
	}

	public void expandOnJob(String job) {
		waitABit(2000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#CompanySearch > section:nth-child(3) > div > div > div > div > div:nth-child(3) > div:nth-child(1) > div > h5")).getText().contains(job));
		evaluateJavascript("$(\"div#accordion2 > div:nth-child(3) > div > a\").click();");
		waitABit(5000);
	}

	public void expandMDGJob() {
		waitABit(2000);
		evaluateJavascript("$(\"div#accordion2 > div:nth-child(2) > div > a\").click();");
		waitABit(5000);
	}

	public void expandOnIndustry(String industry) {
		waitABit(2000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#CompanySearch > section:nth-child(3) > div > div > div > div > div:nth-child(4) > div:nth-child(1) > div > h5")).getText().contains(industry));
		evaluateJavascript("$(\"div#accordion2 > div:nth-child(4) > div > a\").click();");
		waitABit(5000);
	}

	public void selectACompanyFromList(int itemNumber){
		int numberOfItems = getDriver().findElements(By.cssSelector("div.media-listing.clearfix.company-search-results > ul:nth-child(1) ")).size();
		if(numberOfItems > 0 ){
			if(itemNumber < numberOfItems && itemNumber > 0){
				getDriver().findElement(By.cssSelector("div.media-listing.clearfix.company-search-results > ul:nth-child(1) > li:nth-child("+ itemNumber +" ) > div > h5 > a")).click();
			}
			else {
				getDriver().findElement(By.cssSelector("div.media-listing.clearfix.company-search-results > ul:nth-child(1) > li:nth-child(1) > div > h5 > a")).click();

			}
		}
		else {
			System.out.println("There is no item in listing");
		}
	}

	public void clickPrintButton() {
		waitABit(2000);
		Assert.assertTrue("Not found Print company detail on page!", printCompanyDetail.isDisplayed());
		printCompanyDetail.click();
	}

	public void selectTextFromPrintArticle(String text) {
		textInsidePrintDetails.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		textInsidePrintDetails.sendKeys(text);
	}

	public void clickPrintInsidePrintButton() {
		clickPrintinsidePrintArticle.click();
	}

	public void clickCloseInsidePrintButton() {
		clickCloseinsidePrintArticle.click();

	}

	public void verifyBreadCrumbForCountryRisk(String text) {
		boolean contained = false;
		if (text.contains(lastBreadcrumb.getText())) {
			contained = true;
		} else {
			if (text.contains(firstBreadcrumb.getText())) {
				contained = true;
				waitABit(5000);	
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
		waitABit(5000);	
	}

	public void clickOnClearButton() {
		clearFormButton.click();
	}

	public void typeCompany(String companies){
		companiesRepresentedTextArea.sendKeys(companies);
		companiesRepresentedTextArea.clear();
	}

	public void typeProduct(String product){
		productAreasTextField.sendKeys(product);
		productAreasTextField.clear();
	}

	public void selectMDGOptions() {
		WebElement option = getDriver().findElement(By.cssSelector("div#accordion2 > div:nth-child(1) > div.accordion-heading"));
		option.click();

	}

	public void clickClearButton() {
		clearButton.click();
	}

	public String clickSaveThisSearchButton(String text) {
		saveThisSearchButton.click();
		int ran;
		ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		text = text + ran;
		textAreaPopUpSaveSearch.sendKeys(text);
		System.out.println(text);
		clickPopUpSaveSearch.click();
		waitABit(5000);
		element(successMessage).waitUntilPresent();
		Assert.assertTrue(successMessage.isDisplayed());
		return text;
	}

	public void verifySavedMncMatchesCompanySearchSelections(String company) {
		Assert.assertTrue(comapanyTextArea.getAttribute("value").contains(company));
	}

	public void verifySavedMNCInSavedCOntent(String savedMnc,String saveMncName) {
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div.row-fluid.no-margin-left > div > div > div > div > div > div > div > h5 > form > span > a[data-orig_value ='"+saveMncName+"']")).size() == 1);
		getDriver().findElement(By.cssSelector("div.row-fluid.no-margin-left > div > div > div > div > div > div > div > h5 > form > span > a[data-orig_value ='"+saveMncName+"']")).click();
	}

	public void saveMncSearchForEnterprise() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("button#save_button")).isDisplayed());
		saveThisSearchButton.click();
		waitABit(3000);
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div#permission-enterprise-user > div:nth-child(1) > p > strong")).getText().contains("Please login with your child account credentials in order to be able to save content. If you do not have a child account, please create one from My BMI") );
		getDriver().findElement(By.cssSelector("div#permission-enterprise-user > div:nth-child(2) > button")).click();
	}

	public void clickOnClearNationality() {
		clearCompanyNationality.click();		
	}

	private List<WebElement> getVisibleMoveButtons(){
		List<WebElement> moveButtonGroupList = getDriver().findElements(By.cssSelector("div.btn-multiselect-group"));
		WebElement moveButtonGroup = moveButtonGroupList.get(0);
		for (WebElement elem : moveButtonGroupList){
			if (element(elem).isVisible()) {
				moveButtonGroup = elem;
				break;
			}
		}
		return element(moveButtonGroup).findElements(By.cssSelector("button"));
	}

	public void selectGeographyFromList(String element){
		element(geographyList).waitUntilVisible();
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("select#all_geographies")).isDisplayed());
		System.out.println("in selectGeographyFromList");
		int counterGeo = getDriver().findElements(By.cssSelector("select#all_geographies > option")).size();
		System.out.println(counterGeo);
		int counterEmptyList = getDriver().findElements(By.cssSelector("select#selected_geographies")).size() -1;
		System.out.println(counterEmptyList);
		List<WebElement> allElements = geographyList.findElements(By.tagName("option"));

				for (WebElement region : allElements) {
			if (region.getText().equals(element)) {
				region.click();
				waitABit(10000);
				break;
			}

		}
		List<WebElement> moveButtonList = getVisibleMoveButtons();
		moveButtonList.get(1).click();
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("select#selected_geographies")).getText().contains(element) );
		int counterAfterMovingGeo = getDriver().findElements(By.cssSelector("select#all_geographies > option")).size();
		int counterAfterMovingGeoList = getDriver().findElements(By.cssSelector("select#selected_geographies > option")).size();
		System.out.println(counterAfterMovingGeo);
		System.out.println(counterAfterMovingGeoList);
		waitABit(3000);
		Assert.assertTrue("not found the counter list!!!",counterAfterMovingGeo == counterGeo  - 1);
		Assert.assertTrue(counterAfterMovingGeoList == counterEmptyList + 1);
	}

	public void selectNationalityFromList(String element){
		element(nationalityList).waitUntilVisible();
		System.out.println("in selectnationalityList");
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("select#natleft")).isDisplayed());
		System.out.println("in selectGeographyFromList");
		int counterNat = getDriver().findElements(By.cssSelector("select#natleft > option")).size();
		System.out.println(counterNat);
		int counterEmptyList = getDriver().findElements(By.cssSelector("select#selected_nationalities")).size() -1;
		System.out.println(counterEmptyList);
		List<WebElement> allElements = nationalityList.findElements(By.tagName("option"));

		for (WebElement region : allElements) {
			if (region.getText().equals(element)) {
				region.click();
				waitABit(10000);
				break;
			}

		}

		List<WebElement> moveButtonList = getVisibleMoveButtons();
		moveButtonList.get(1).click();
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("select#selected_nationalities")).getText().contains(element) );
		int counterAfterMovingNat = getDriver().findElements(By.cssSelector("select#natleft > option")).size();
		int counterAfterMovingNatList = getDriver().findElements(By.cssSelector("select#selected_nationalities > option")).size();
		System.out.println(counterAfterMovingNat);
		System.out.println(counterAfterMovingNatList);
		waitABit(3000);
		Assert.assertTrue("not found the counter list!!!",counterAfterMovingNat == counterNat  - 1);
		Assert.assertTrue(counterAfterMovingNatList == counterEmptyList + 1);
	}

	public void selectJobFromList(String element){
		element(jobList).waitUntilVisible();
		System.out.println("in selectjobList");
		int counterJob = getDriver().findElements(By.cssSelector("select#jobleft > option")).size();
		System.out.println(counterJob);
		int counterEmptyList = getDriver().findElements(By.cssSelector("select#selected_job_functions")).size() -1;
		System.out.println(counterEmptyList);
		List<WebElement> allElements = jobList.findElements(By.tagName("option"));

		for (WebElement region : allElements) {
			if (region.getText().equals(element)) {
				region.click();
				waitABit(10000);
				break;
			}

		}

		List<WebElement> moveButtonList = getVisibleMoveButtons();
		moveButtonList.get(1).click();
		waitABit(5000);
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("select#selected_job_functions")).getText().contains(element) );
		int counterAfterMovingJob = getDriver().findElements(By.cssSelector("select#jobleft > option")).size();
		int counterAfterMovingJobList = getDriver().findElements(By.cssSelector("select#selected_job_functions > option")).size();
		System.out.println(counterAfterMovingJob);
		System.out.println(counterAfterMovingJobList);
		waitABit(3000);
		Assert.assertTrue(counterAfterMovingJobList == counterEmptyList + 1);
	}

	public void selectIndustryFromList(String element){
		element(industryList).waitUntilVisible();
		System.out.println("in selectIndustryFromList");
		int counterInd = getDriver().findElements(By.cssSelector("select#coleft > option")).size();
		System.out.println(counterInd);
		int counterEmptyList = getDriver().findElements(By.cssSelector("select#selected_industries")).size() -1;
		System.out.println(counterEmptyList);
		List<WebElement> allElements = industryList.findElements(By.tagName("option"));

		for (WebElement region : allElements) {
			if (region.getText().equals(element)) {
				region.click();
				waitABit(10000);
				break;
			}

		}

		List<WebElement> moveButtonList = getVisibleMoveButtons();
		moveButtonList.get(1).click();
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("select#selected_industries")).getText().contains(element) );
		int counterAfterMovingInd = getDriver().findElements(By.cssSelector("select#coleft > option")).size();
		int counterAfterMovingIndList = getDriver().findElements(By.cssSelector("select#selected_industries > option")).size();
		System.out.println(counterAfterMovingInd);
		System.out.println(counterAfterMovingIndList);
		waitABit(3000);
		Assert.assertTrue("not found the counter list!!!",counterAfterMovingInd == counterInd  - 1);
		Assert.assertTrue(counterAfterMovingIndList == counterEmptyList + 1);
	}

	public void verifyBreadCrumbsForWebinars(String breadcrumb) {
		if (getDriver().findElements(By.cssSelector("div.navbar-inner > ul >  li > a")).size() == 1)
		{
			webinarsTopPage.click();
			webinarsAndPodcastsViewAll.click();

			boolean contained = false;
			if (breadcrumb.contains(lastBreadcrumb.getText())) {
				contained = true;
			} else {
				if (breadcrumb.contains(firstBreadcrumb.getText())) {
					contained = true;
					waitABit(10000);	
				}
			}
			Assert.assertTrue("Breadcrum did not contain " + breadcrumb + "!", contained);
			waitABit(7000);	
		}

	}

	public void verifyBreadCrumb(String text) {
		boolean contained = false;
		if (breadcrumbLast.getText().contains(text)) {
			contained = true;
		} else {
			if (breadcrumbFirst.getText().contains(text)) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}

	public void verifyPresenceOfPrintAndCompanyDetailsInsideACompany(String details) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(6) > div:nth-child(2) > div > a > i")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(6) > div:nth-child(1) > h4")).getText().contains(details));

	}

	public void verifyCompanyProfileOnPage() {
		Assert.assertTrue("not found!!!",selectedCompanyProfile.isDisplayed());
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("div#subscriptions > div:nth-child(2)")).isDisplayed());
	}

	public void verifyPaginatorOnPage() {
		element(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(7) > article > div.paginaxor.pagination-listing.pagination.pagination-small.pagination-centered"))).waitUntilPresent();
		waitABit(3000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(7) > article > div.paginaxor.pagination-listing.pagination.pagination-small.pagination-centered")).isDisplayed());
	}

	public void verifyPaginatorOnPageMdg() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(7) > section > article > div.paginaxor.pagination-listing.pagination.pagination-small.pagination-centered")).isDisplayed());
	}

	public void verifyCompanyProfileAsMdgOnPage() {
		waitABit(5000);
		Assert.assertTrue("not found!!!",selectedCompanyProfile.isDisplayed());
		Assert.assertTrue("not found!", paginatorMdg.isDisplayed());
	}

	public void clickOnExportAndVerify(String extension) {
		waitABit(3000);
		saveImageHandle1();
		waitABit(3000);
		FileChecker file = new FileChecker();
		file.verifyExtentionExcelFileMnc(extension);
	}
	public void saveImageHandle1() {
		String mainWindow = getDriver().getWindowHandle();
		getDriver().switchTo().activeElement();

		waitABit(3000);

		Keyboard keyboard = new DesktopKeyboard();
		keyboard.keyDown(KeyEvent.VK_DOWN);
		keyboard.keyUp(KeyEvent.VK_DOWN);
		waitABit(1000);
		keyboard.keyDown(KeyEvent.VK_ENTER);
		keyboard.keyUp(KeyEvent.VK_ENTER);

		getDriver().switchTo().window(mainWindow);
	}

	public void goBackToTheInitialPage() {
		for(String winHandle : getDriver().getWindowHandles()){
			getDriver().switchTo().window(winHandle);
		}
		getDriver().close();
	}

	public void verifySaveInsideMncCompany(String companyName) {
		waitABit(4000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(6) > div:nth-child(1) > address > strong" )).getText().contains(companyName));	
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(6) > div:nth-child(2) > div > a")).isDisplayed());
	}

	public String clickOnSave(String companyName, String text) {
		getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(6) > div:nth-child(2) > div > a")).click();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input#companyName")).getAttribute("value").equals(companyName));
		System.out.println("verified!");
		waitABit(3000);
		getDriver().findElement(By.cssSelector("input#companyName")).clear();
		int ran;
		ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		text = text + ran;
		getDriver().findElement(By.cssSelector("input#companyName")).sendKeys(text);
		System.out.println(text);
		getDriver().findElement(By.cssSelector("div.modal-footer > button:nth-child(2)")).click();
		waitABit(5000);
		element(getDriver().findElement(By.cssSelector("div.alert.alert-success"))).waitUntilPresent();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.alert.alert-success")).isDisplayed());
		return text;
	}

	public void searchForCompanyLocation(String companyLoc) {
		geographySearchLocation.sendKeys(companyLoc);
	}

	public void clickOnTheCompanyFromTheList() {
		getDriver().findElement(By.cssSelector("div.media-listing.clearfix.company-search-results > ul > li:nth-child(1) > div > h5 > a")).click();
	}

	public void verifyPresenceOfPrint() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("button#library_print_companies")).isDisplayed());
		getDriver().findElement(By.cssSelector("button#library_print_companies")).click();
	}

	public void checkSavedMncFromList() {
		element(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(6) > article:nth-child(2) > div:nth-child(4) >  div.media-listing > div:nth-child(1)  > div:nth-child(1) > div > div > div > div > label"))).click();
		waitABit(3000);
	}

	public void checkSavedMncCIFromList() {
		element(getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(7) > article:nth-child(2) > div:nth-child(4) >  div.media-listing > div:nth-child(1)  > div:nth-child(1) > div > div > div > div > label"))).click();
		waitABit(3000);
	}

	public void verifyIfIsMncCompanyOrMncSearch(String companyName) {
		if (getDriver().findElements(By.cssSelector("div.alert.alert-error")).size() == 1) {
			System.out.println("A search was saved here!");
			getDriver().findElement(By.cssSelector("div.accordion-heading.accordion-checkbox >div > div > div:nth-child(1) > div > span > label[for='select-all']")).click();
			waitABit(2000);
			getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(6) > article:nth-child(2) > div:nth-child(4) >  div.media-listing > div  > div:nth-child(1) > div > div > div > div > label")).click();
			//clickOnPrint(companyName);
			waitABit(3000);
			Assert.assertTrue(getDriver().findElement(By.cssSelector("button#library_print_companies")).isDisplayed());
		} else
		{
			System.out.println("Not necessary, it is company!!!");
		}
	}

	public void verifyIfIsMncCompanyOrMncSearchCI(String companyName) {
		if (getDriver().findElements(By.cssSelector("div.alert.alert-error")).size() == 1) {
			System.out.println("A search was saved here!");
			getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(7) > article:nth-child(2) > div:nth-child(4) >  div.media-listing > div:nth-child(1)  > div:nth-child(2) > div > div > div > div > label")).click();
			clickOnPrint(companyName);
		} else
		{
			System.out.println("Not necessary, it is company!!!");
		}
	}

	public void clickOnPrint(String companyName) {
		getDriver().findElement(By.cssSelector("button#library_print_companies")).click();
		String winHandleBefore = getDriver().getWindowHandle();
		for (String winHandle : getDriver().getWindowHandles()) {
			getDriver().switchTo().window(winHandle);
		}
//		waitUntilElementExists(By.cssSelector("div.myDivToPrint > div:nth-child(2) > address > strong"), 10);
//		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.myDivToPrint > div:nth-child(2) > address > strong")).getText().contains(companyName));
		waitABit(3000);
		//TODO fix this
//		SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
//		singleArticle.printPagePreviewCancel.click();
		getDriver().switchTo().window(winHandleBefore);
	}

}



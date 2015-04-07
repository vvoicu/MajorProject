package bmo5.bmo5tests.adm.pages.dvpakcs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class DatapacksPage extends AbstractAdmPage {

	@FindBy(css = "a[class='add btn']")
	private WebElement dataPackAddButton;
	
	@FindBy(css="input#title")
	private WebElement titleInput;
	
	@FindBy(css="input#type_upload_excel")
	private WebElement uploadExcelRadiobutton;
	
	@FindBy(css="input#type_dvpack")
	private WebElement dvpackRadiobutton;
	
	@FindBy(css = "ul#sidebar > li:last-child > a > span")
	private WebElement admMenuDvpacks;
	
	@FindBy(css = "ul#sidebar > li:nth-child(19)>ul>li:nth-child(2)> a > span")
	private WebElement admMenuDatapacks;
	
	@FindBy(css = "ul#sidebar > li:nth-child(19)> ul > li > a > span")
	private WebElement admMenuManageDvpacks;
	
	@FindBy(css="input#bulk")
	private WebElement browseButton;
	
	@FindBy(css="select#all_Geography")
	private WebElement geographiesList;
	
	@FindBy(css="select#Geography")
	private WebElement selectedGeographiesList;
	
	@FindBy(css="select#all_Services")
	private WebElement servicesList;
	
	@FindBy(css="select#Services")
	private WebElement selectedServicesList;
	
	@FindBy(css="select#primary_service")
	private WebElement primaryServiceList;
	
	@FindBy(css="button#all_Geography_rightSelected")
	private WebElement geographyRightSelectButton;
	
	@FindBy(css="button#all_Services_rightSelected")
	private WebElement serviceRightSelectButton;
	
	@FindBy(css="select#primary_iso")
	private WebElement primaryGeographyList;
	
	@FindBy(css="select#all_Companies")
	private WebElement companiesList;
	
	@FindBy(css="select#Company")
	private WebElement selectedCompaniesList;
	
	@FindBy(css="select#primary_company")
	private WebElement primaryCompanyList;
	
	@FindBy(css="button#all_Companies_rightSelected")
	private WebElement companyRightSelectButton;
	
	@FindBy(css="button#add_data_pack_form_btn")
	private WebElement datapackContinueButton;
	
	@FindBy(css="input#dvpack_id")
	private WebElement dvpackIDInput;
	
	@FindBy(css="div.btn-toolbar > div > a")
	private WebElement listViewButton;
	
	@FindBy(css="div#datapacks_table_filter > label > input")
	private WebElement searchDatapackInput;
	
	@FindBy(css="table#datapacks_table> tbody > tr > td:last-child > a")
	private WebElement deleteButton;
	
	@FindBy(css = "a.btn.btn-primary")
	private WebElement okDeletePopUpWindow;
	
	@FindBy(css = "div.bootbox.modal.fade.in")
	private WebElement deletePopUpWindow;
	
	@FindBy(css="div.alert.alert-error")
	private WebElement errorMessage;
	
	@FindBy(css="div.alert.alert-success")
	private WebElement successMessage;
	
	@FindBy(css="div.widget-content  div:nth-of-type(1) > div:nth-of-type(1) > label")
	private WebElement errorTitleInput;
	
	@FindBy(css="div.widget-content  div:nth-of-type(4) > div:nth-of-type(3) > label")
	private WebElement errorGeographyList;
	
	@FindBy(css="div.widget-content  div:nth-of-type(5) > div:nth-of-type(1) > label")
	private WebElement errorPrimaryGeographyDropdown;
	
	@FindBy(css="div.widget-content  div:nth-of-type(6) > div:nth-of-type(3) > label")
	private WebElement errorServiceList;
	
	@FindBy(css="div.widget-content  div:nth-of-type(7) > div:nth-of-type(1)> label")
	private WebElement errorPrimaryServiceDropdown;
	
	@FindBy(css="div.widget-content  div:nth-of-type(5) > div:nth-of-type(1) > label")
	private WebElement errorDvpackId;
	
//	ManageWidgetsPage manageWidgets= new ManageWidgetsPage(getDriver());
	
	public void clickAddNewDatapackButton(){
		dataPackAddButton.click();
	}
	
	public void clickDvpacksMenu(){
		admMenuDvpacks.click();
		waitABit(2000);
	}
	public void clickDatapacksMenu(){
		admMenuDatapacks.click();
		waitABit(2000);
	}
	
	public void clickManageDvpacksMenu(){
		admMenuManageDvpacks.click();
		waitABit(2000);
	}
	public String typeDatapackTitle(String title){
		String randomTitle=title+Integer.toString(StringUtils.randomNumber(10000));
		titleInput.sendKeys(randomTitle);
		return randomTitle;
	}
	
	public void selectDataPackType(String datapackType){
		WebElement datapackTypeRadiobutton=getDriver().findElement(By.cssSelector("input#type_"+datapackType));
		datapackTypeRadiobutton.click();
		if(datapackType.equals("dvpack")){
			Assert.assertTrue("DvpackID input doesn't exists",getDriver().findElements(By.cssSelector("input#dvpack_id")).size()==1);
			Assert.assertTrue("DvpackID input is not displayed",dvpackIDInput.isDisplayed());	
		}else{
			Assert.assertTrue("Browser button doesn't exists",getDriver().findElements(By.cssSelector("input#bulk")).size()==1);
			Assert.assertTrue("Browser button is not displayed",browseButton.isDisplayed());	
		}
	}
	
	//TODO Fix this
//	public void uploadExcel(String excelName){
//		 browseButton.click();
//		 waitABit(2000);
//		 BusinessRulesWidgetsPage businessRulesWidgetsPage= new BusinessRulesWidgetsPage(getDriver());
//		 businessRulesWidgetsPage.uploadFile(excelName, Constants.RESOURCES_EXCEL);
//	}
	
	public void selectGeographyTaggingOption(String geography) {
		selectByVisibleText(geographiesList,geography);
		geographyRightSelectButton.click();
	}
	
	public void selectGeographyPrimaryTagging(String geography){
		selectGeographyTaggingOption(geography);
		List<WebElement> selectedGeographies=primaryGeographyList.findElements(By.cssSelector("option"));
		
		for(WebElement selectedGeography: selectedGeographies){
			if(selectedGeography.getText().contains(geography)){
				selectByVisibleText(primaryGeographyList,geography);
				break;
			}
		}
	}
	
	public void selectServiceTaggingOption(String service) {
		selectByVisibleText(servicesList,service);
		serviceRightSelectButton.click();
	}
	
	public void selectServicePrimaryTagging(String service){
		selectServiceTaggingOption(service);
		List<WebElement> selectedServices=primaryServiceList.findElements(By.cssSelector("option"));
		
		for(WebElement selectedService: selectedServices){
			if(selectedService.getText().contains(service)){
				selectByVisibleText(primaryServiceList,service);
				break;
			}
		}
	}
	
	public void selectCompanyTaggingOption(String company) {
		selectByVisibleText(companiesList,company);
		companyRightSelectButton.click();
	}
	
	public void selectCompanyPrimaryTagging(String company){
		selectCompanyTaggingOption(company);
		List<WebElement> selectedCompanies=primaryCompanyList.findElements(By.cssSelector("option"));
		
		for(WebElement selectedCompany: selectedCompanies){
			if(selectedCompany.getText().contains(company)){
				selectByVisibleText(primaryCompanyList,company);
				break;
			}
		}
	}
	
	public void clickContinueButton(){
		datapackContinueButton.click();
	}
	
	public void verifySuccessMessage(){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div.alert.alert-success")).size()==1);
	}
	
	public void typeDvpackId(String dvpackID){
		dvpackIDInput.clear();
		dvpackIDInput.sendKeys(dvpackID);
	}
	
	public void clickListViewButton(){
		listViewButton.click();
	}
	
	public void searchSavedDataPackTitle(String savedDatapackTitle){
		searchDatapackInput.sendKeys(savedDatapackTitle);
	}
	
	public void clickDeleteButtonForADatapack(){
		deleteButton.click();
		element(deletePopUpWindow).waitUntilVisible();
		deletePopUpWindow.click();
		Assert.assertTrue("Not Found",
				okDeletePopUpWindow.isDisplayed());
		okDeletePopUpWindow.click();
	}
	
	//TODO fix this
//	public void verifyAlreadyExistsError(){
//		boolean errormessage=false;
//		if (manageWidgets.checkAlertIsErrorMessage()) {
//			Assert.assertTrue("Wrong message",errorMessage.getText().contains("add a message here :)"));
//		} else {
//			Assert.assertTrue("No error message displayed", errormessage);
//		}
//	}
//	
//	public void verifySuccessfullySavedMessage(){
//		boolean errormessage=false;
//		if (!manageWidgets.checkAlertIsErrorMessage()) {
//			Assert.assertTrue("Wrong message",successMessage.getText().contains("Data Pack successfully created."));
//		}
//		else {
//			Assert.assertTrue("No error message displayed", errormessage);
//		}
//	}
	
	public String getDatapackTitle(){
		return titleInput.getAttribute("value");
	}
	
	public String getDvpackIdFromEditPage(){
		return dvpackIDInput.getAttribute("placeholder");
	}
	
	public void verifySelectedTagging(String service, String geography, String company){
		List<WebElement> selectedServices=getAllOptions(selectedServicesList);
		List<WebElement> selectedGeographies=getAllOptions(selectedGeographiesList);
		List<WebElement> selectedCompanies=getAllOptions(selectedCompaniesList);
		
		if (selectedServices.size()>0){
		Assert.assertTrue("Wrong service was selected", selectedServices.get(0).getText().contains(service));
		}
		
		if (selectedGeographies.size()>0){
			Assert.assertTrue("Wrong geography was selected", selectedGeographies.get(0).getText().contains(geography));
		}
		
		if(selectedCompanies.size()>0){
			Assert.assertTrue("Wrong company was selected", selectedCompanies.get(0).getText().contains(company));
		}
	}
	
	public void verifySelectedDatapackType(String datapackType){
		if(datapackType.equals("dvpack")){
		Assert.assertTrue("Wrong datapackType selected",dvpackRadiobutton.getAttribute("checked").contains("true"));
		}
		else{
		Assert.assertTrue("Wrong datapackType selected",uploadExcelRadiobutton.getAttribute("checked").contains("true"));	
		}
	}
	
	public void verifyTitleAndDvpackId(String datapackTitle, String dvpackId){
		Assert.assertTrue("Wrong datapack title",getDatapackTitle().contains(datapackTitle));
		Assert.assertTrue("Wrong dvpack id",getDvpackIdFromEditPage().contains(dvpackId));
	}
	
	public void clickContinueWithoutCompletingAndVerifyErrorMessage(){
		clickContinueButton();
		Assert.assertTrue("Wrong error message for title input",errorTitleInput.getText().contains("Title cannot be empty!"));
		Assert.assertTrue("Wrong error message for geography list",errorGeographyList.getText().contains("At least one geography must be selected!"));
		Assert.assertTrue("Wrong error message for geography primary drop down",errorPrimaryGeographyDropdown.getText().contains("You must select a primary geography!"));
		Assert.assertTrue("Wrong error message for service list",errorServiceList.getText().contains("At least one channel must be selected!"));
		Assert.assertTrue("Wrong error message for service primary drop down",errorPrimaryServiceDropdown.getText().contains("You must select a primary channel!"));
	}
	
	/**
	 * Verifies if error messages exist. If existsState=1 and size()=1 then elements exists, 
	 * otherwise if existsState=0 and size()=0 element doesn't exist
	 * 
	 * @param existState
	 */
	public void verifyErrorMessageExistOrDoesntExists(byte existsState){
		if(existsState==0||existsState==1){
		Assert.assertTrue("Error message for title input doesn't exists",getDriver().findElements(By.cssSelector("div.widget-content  div:nth-of-type(1) > div:nth-of-type(1) > label")).size()==existsState);
		Assert.assertTrue("Error message for geography list doesn't exists",getDriver().findElements(By.cssSelector("div.widget-content  div:nth-of-type(4) > div:nth-of-type(3) > label")).size()==existsState);
		Assert.assertTrue("Error message for geography primary drop down doesn't exists",getDriver().findElements(By.cssSelector("div.widget-content  div:nth-of-type(5) > div:nth-of-type(1) > label")).size()==existsState);
		Assert.assertTrue("Error message for service list doesn't exists",getDriver().findElements(By.cssSelector("div.widget-content  div:nth-of-type(6) > div:nth-of-type(3) > label")).size()==existsState);
		Assert.assertTrue("Error message for service primary drop down doesn't exists",getDriver().findElements(By.cssSelector("div.widget-content  div:nth-of-type(7) > div:nth-of-type(1)> label")).size()==existsState);
		}
		else{
			System.out.println("Wrong value");
		}
	}
	
	public void typeDvpackIdAndVerifyErrorMessage(String dvpackId){
		typeDvpackId(dvpackId);
		clickContinueButton();
		Assert.assertTrue("Error message for dvpackId doesn't exists",getDriver().findElements(By.cssSelector("div.widget-content  div:nth-of-type(5) > div:nth-of-type(1) > label")).size()==1);
		Assert.assertTrue("Error message for dvpackId is wrong ",errorDvpackId.getText().contains("Please insert a valid dv pack id."));
	}
	
	public void verifyElementsDisplayed(){
		Assert.assertTrue("Input title doesn't exist",getDriver().findElements(By.cssSelector("input#title")).size()==1);
		Assert.assertTrue("Input title is not displayed",titleInput.isDisplayed());
		Assert.assertTrue("Upload excel radiobutton doesn't exists",getDriver().findElements(By.cssSelector("input#type_upload_excel")).size()==1);
		Assert.assertTrue("Upload excel radiobutton is not displayed",uploadExcelRadiobutton.isDisplayed());
		Assert.assertTrue("Dvpack type radiobutton doesn't exists",getDriver().findElements(By.cssSelector("input#type_dvpack")).size()==1);
		Assert.assertTrue("Dvpack type radiobutton is not displayed",dvpackRadiobutton.isDisplayed());
		Assert.assertTrue("All geographies list doesn't exists",getDriver().findElements(By.cssSelector("select#all_Geography")).size()==1);
		Assert.assertTrue("Al geographies list is not displayed",geographiesList.isDisplayed());
		Assert.assertTrue("Right side geo list doesn't exists",getDriver().findElements(By.cssSelector("select#Geography")).size()==1);
		Assert.assertTrue("Right side geo list is not displayed",selectedGeographiesList.isDisplayed());
		Assert.assertTrue("All services list doesn't exists",getDriver().findElements(By.cssSelector("select#all_Services")).size()==1);
		Assert.assertTrue("All services list is not displayed",servicesList.isDisplayed());
		Assert.assertTrue("Right side service list doesn't exists",getDriver().findElements(By.cssSelector("select#Services")).size()==1);
		Assert.assertTrue("Right side service list is not displayed",selectedServicesList.isDisplayed());
		Assert.assertTrue("Primary geo drop down doesn't exists",getDriver().findElements(By.cssSelector("select#primary_iso")).size()==1);
		Assert.assertTrue("Primary geo drop down is not displayed",primaryGeographyList.isDisplayed());
		Assert.assertTrue("Primary service drop down doesn't exists",getDriver().findElements(By.cssSelector("select#primary_service")).size()==1);
		Assert.assertTrue("Primary service drop down is not displayed",primaryServiceList.isDisplayed());
		Assert.assertTrue("All companies list doesn't exists",getDriver().findElements(By.cssSelector("select#all_Companies")).size()==1);
		Assert.assertTrue("All companies list is not displayed",companiesList.isDisplayed());
		Assert.assertTrue("Right side company list doesn't exists",getDriver().findElements(By.cssSelector("select#Company")).size()==1);
		Assert.assertTrue("Right side company list is not displayed",selectedCompaniesList.isDisplayed());
		Assert.assertTrue("Primary company drop down doesn't exists",getDriver().findElements(By.cssSelector("select#primary_company")).size()==1);
		Assert.assertTrue("Primary company drop down is not displayed",primaryCompanyList.isDisplayed());
	}
}

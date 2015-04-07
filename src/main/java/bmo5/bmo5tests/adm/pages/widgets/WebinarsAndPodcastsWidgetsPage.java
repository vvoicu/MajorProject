package bmo5.bmo5tests.adm.pages.widgets;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class WebinarsAndPodcastsWidgetsPage  extends AbstractAdmPage{
	
	@FindBy(css = "thead > tr:nth-child(1) > th:nth-child(2)")
	private WebElement startDateColumnFromHeader;
	
	@FindBy(css = "thead > tr:nth-child(1) > th:nth-child(3)")
	private WebElement endDateColumnFromHeader;
	
	@FindBy(css = "thead > tr:nth-child(1) > th:nth-child(4)")
	private WebElement contentTypeColumnFromHeader;
	
	@FindBy(css = "thead > tr:nth-child(1) > th:nth-child(5)")
	private WebElement lastUpdatedColumnFromHeader;
	
	@FindBy(css = "a.add.btn")
	private WebElement newWidgetButton;
	
	@FindBy(css = "a.help.btn")
	private WebElement helpButton;
	
	@FindBy(css = "a.btn > i.icon-list")
	private WebElement listViewButton;
	
	@FindBy(css = "div.modal-footer > button")
	private WebElement closeHelpWindowButton;
	
	@FindBy(css = "input#title")
	private WebElement titleBox;
	
	@FindBy(css = "textarea#short_caption")
	private WebElement shortCaptionBox;
	
	@FindBy(css = "textarea#detailed_caption")
	private WebElement detailedCaptionBox;
	
	@FindBy(css = "input#content_type_webinar")
	private WebElement webinarRadioButton;
	
	@FindBy(css = "input#content_type_podcast")
	private WebElement podcastRadioButton;
	
	@FindBy(css = "textarea#vimeo_code")
	private WebElement embeddedVimeoCodeBox;
	
	@FindBy(css = "input#start_date")
	private WebElement startDateBox;
	
	@FindBy(css = "input#end_date")
	private WebElement endDateBox;
	
	@FindBy(css = "select#primary_iso")
	private WebElement primaryGeographyDropDownList;
	
	@FindBy(css = "select#primary_service")
	private WebElement primaryChannelDropDownList;
	
	@FindBy(css = "select#primary_company")
	private WebElement primaryCompanyDropDownList;
	
	@FindBy(css = "button#add_hot_topic_form_btn")
	private WebElement saveButton;
	
	@FindBy(css = "div.form-actions > a")
	private WebElement resetFormLink;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(1) > div > label")
	private WebElement errorMessageTitle;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(2) > div > label")
	private WebElement errorMessageShortCaption;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(3) > div > label")
	private WebElement errorMessageDetailedCaption;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(5) > div > label")
	private WebElement errorMessageEmbeddedVimeoCode;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(6) > div > label")
	private WebElement errorMessageStartDate;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(7) > div > label")
	private WebElement errorMessageEndDate;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(8) > div > label")
	private WebElement errorMessageGeographiesSection;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(9) > div > label")
	private WebElement errorMessagePrimaryGrography;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(10) > div > label")
	private WebElement errorMessageServicesChannelsSection;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(11) > div > label")
	private WebElement errorMessagePrimaryChannel;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(12) > div > label")
	private WebElement errorMessageCompaniesSection;
	
	@FindBy(css = "form.form-horizontal > div:nth-of-type(13) > div > label")
	private WebElement errorMessagePrimaryCompany;
	
	@FindBy(css = "div#webinars_table_wrapper > div:nth-child(2) > div:nth-child(2) > div > ul > li > a > i.icon-angle-right")
	private WebElement nextIcon;
	
	@FindBy(css = "div#webinars_table_wrapper > div:nth-child(2) > div:nth-child(2) > div > ul > li > a > i.icon-angle-left")
	private WebElement previousIcon;
	
	@FindBy(css = "div#webinars_table_wrapper > div:nth-child(2) > div:nth-child(2) > div > ul > li > a > i.icon-angle-double-left")
	private WebElement firstIcon;
	
	@FindBy(css = "div#webinars_table_wrapper > div:nth-child(2) > div:nth-child(2) > div > ul > li > a > i.icon-angle-double-right")
	private WebElement lastIcon;
	
	@FindBy(css = "select[name='webinars_table_length']")
	private WebElement recordsPerPageSelect;
	
	@FindBy(css = "button#all_Geography_rightAll")
	private WebElement moveAllGeographiesToRightPanelButton;
	
	@FindBy(css = "button#all_Services_rightAll")
	private WebElement moveAllServicesToRightPanelButton;
	
	@FindBy(css = "button#all_Companies_rightAll")
	private WebElement moveAllCompaniesToRightPanelButton;
	
	@FindBy(css = "div.alert.alert-success")
	private WebElement confirmationMessage;
	
	@FindBy(css = "a.btn.btn-primary")
	private WebElement deleteWindowOKButton;
	
	@FindBy(css = "a.btn.null")
	private WebElement deleteWindowCancelButton;
	
	@FindBy(css = "select#Status")
	private WebElement dropDownListItemsContainer;
	
	@FindBy(css = "select#Geography")
	private WebElement rightPanelGeographySection;
	
	@FindBy(css = "select#Services")
	private WebElement rightPanelServicesSection;
	
	@FindBy(css = "select#Company")
	private WebElement rightPanelCompanySection;
	
	public void nagigateToNextPage(){
		nextIcon.click();
	}
	
	public void navigateToPreviousPage(){
		previousIcon.click();
	}
	
	public void verifyTableColumns(){
		startDateColumnFromHeader.click();
		Assert.assertTrue(startDateColumnFromHeader.getAttribute("aria-sort").equals("ascending"));
		startDateColumnFromHeader.click();
		Assert.assertTrue(startDateColumnFromHeader.getAttribute("aria-sort").equals("descending"));
		endDateColumnFromHeader.click();
		Assert.assertTrue(endDateColumnFromHeader.getAttribute("aria-sort").equals("ascending"));
		contentTypeColumnFromHeader.click();
		Assert.assertTrue(contentTypeColumnFromHeader.getAttribute("aria-sort").equals("ascending"));
		lastUpdatedColumnFromHeader.click();
		Assert.assertTrue(lastUpdatedColumnFromHeader.getAttribute("aria-sort").equals("ascending"));
	}
	
	public void clickOnStartDateColumnFromHeader(){
		startDateColumnFromHeader.click();
	}
	
	public void clickOnEndDateColumnFromHeader(){
		endDateColumnFromHeader.click();
	}
	
	public void clickOnLAstUpdatedFromHeader(){
		lastUpdatedColumnFromHeader.click();
	}
	
	public void clickOnContentTypeFromHeader(){
		contentTypeColumnFromHeader.click();
	}
	
	public void clickOnHelpButton(){
		helpButton.click();
		closeHelpWindowButton.click();
	}
	
	public void clickOnOneItemFromListing(String itemName){
		int numberOfItems = getDriver().findElements(By.cssSelector("tbody > tr")).size();
		for(int i =1; i<=numberOfItems; i++) {
			if(getDriver().findElement(By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(1) > a")).getText().contains(itemName)){
				getDriver().findElement(By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(1) > a")).click();
				break;
			}
		}
	}
	
	public void recordsPerPageSelect(String records){
		element(recordsPerPageSelect).waitUntilVisible();
		element(recordsPerPageSelect).selectByVisibleText(records);
		waitABit(5000);
		int numberOfItems = getDriver().findElements(By.cssSelector("div#content div.right-side > div:nth-child(2) > table > tbody > tr")).size();
		if(records.contains("All")){
			System.out.println("All records are displayed: " + numberOfItems);
		}
		else{
			Assert.assertTrue(numberOfItems <= Integer.parseInt(records));
		}
	}
	
	public void updateWidgetAndVerify(String title, String shortCaption, String detailedCaption, String startDate, String endDate){
		titleBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		titleBox.sendKeys(Keys.DELETE);
		titleBox.sendKeys(title);
		shortCaptionBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		shortCaptionBox.sendKeys(Keys.DELETE);
		shortCaptionBox.sendKeys(shortCaption);
		detailedCaptionBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		detailedCaptionBox.sendKeys(Keys.DELETE);
		detailedCaptionBox.sendKeys(detailedCaption);
		startDateBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		startDateBox.sendKeys(Keys.DELETE);
		startDateBox.sendKeys(startDate);
		endDateBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		endDateBox.sendKeys(Keys.DELETE);
		endDateBox.sendKeys(endDate);
		saveButton.click();
		Assert.assertTrue(confirmationMessage.getText().contains("successfully updated"));
	}
	
	public void clickOnListViewButton(){
		listViewButton.click();
		Assert.assertTrue(contentTypeColumnFromHeader.isDisplayed());
	}
	
	public void deleteOnOneItemFromListing(String itemName){
		int numberOfItems = getDriver().findElements(By.cssSelector("tbody > tr")).size();
		for(int i=1; i<=numberOfItems; i++) {
			if(getDriver().findElement(By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(1) > a")).getText().contains(itemName)){
				getDriver().findElement(By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(6) > a")).click();
				deleteWindowOKButton.click();
				break;
			}
		}
		recordsPerPageSelect("All");
		int numberOfItemsNew = getDriver().findElements(By.cssSelector("tbody > tr")).size();
		if(numberOfItemsNew == 1){
			if(getDriver().findElements(By.cssSelector("tbody > tr:nth-child(1) > td")).size() == 1){
				System.out.println("There is no item in list anymore");
				Assert.assertTrue(getDriver().findElement(By.cssSelector("tbody > tr:nth-child(1) > td")).getText().equals("No data available in table"));
				numberOfItemsNew--;
			}
		}
		Assert.assertTrue(numberOfItemsNew == numberOfItems - 1);
	}
	
	public void changeTheNumberFromDropDownItems(String item){
		element(dropDownListItemsContainer).waitUntilVisible();
		waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select#Status option")));
		dropDownListItemsContainer.click();
		List<WebElement> itemsList = dropDownListItemsContainer.findElements(By.cssSelector("option"));
		for(WebElement elementNow:itemsList){
			if(elementNow.getText().contains(item.toString())){  
				elementNow.click();
				Sleeper.sleepTight(2000);
				try {
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					waitABit(2000);
					} catch (Exception e) {
						System.out.println(e);
					}
				break;
			}
		}
	}
	
	public void clickOnNewButton(){
		newWidgetButton.click();
		Assert.assertTrue(titleBox.isDisplayed());
	}
	
	public void clickOnSaveButtonWithoutCompletingAnyField(){
		saveButton.click();
		Assert.assertTrue(errorMessageTitle.getText().contains("Title cannot be empty!"));
		Assert.assertTrue(errorMessageShortCaption.getText().contains("Short caption cannot be empty!"));
		Assert.assertTrue(errorMessageDetailedCaption.getText().contains("Detailed caption cannot be empty!"));
		Assert.assertTrue(errorMessageEmbeddedVimeoCode.getText().contains("Code cannot be empty!"));
		Assert.assertTrue(errorMessageStartDate.getText().contains("Start date cannot be empty! Please enter a valid data dd/mm/yyyy format for start date!"));
		Assert.assertTrue(errorMessageEndDate.getText().contains("End date cannot be empty! Please enter a valid data dd/mm/yyyy format for end date!"));
		Assert.assertTrue(errorMessageGeographiesSection.getText().contains("At least one geography must be selected!"));
		Assert.assertTrue(errorMessagePrimaryGrography.getText().contains("You must select a primary geography!"));
		Assert.assertTrue(errorMessageServicesChannelsSection.getText().contains("At least one channel must be selected!"));
		Assert.assertTrue(errorMessagePrimaryChannel.getText().contains("You must select a primary channel!"));
	}
	
	public void completeAllFieldsWithSpacesSaveAndVerify(){
		titleBox.sendKeys("                ");
		shortCaptionBox.sendKeys("                ");
		detailedCaptionBox.sendKeys("                ");
		embeddedVimeoCodeBox.sendKeys("                ");
		startDateBox.sendKeys("                ");
		endDateBox.sendKeys("                ");
		saveButton.click();
		Assert.assertTrue(errorMessageTitle.getText().contains("Title cannot be empty! Please do not enter white spaces!"));
		Assert.assertTrue(errorMessageShortCaption.getText().contains("Short caption cannot be empty!"));
		Assert.assertTrue(errorMessageDetailedCaption.getText().contains("Detailed caption cannot be empty!"));
		Assert.assertTrue(errorMessageEmbeddedVimeoCode.getText().contains("Code cannot be empty!"));
		Assert.assertTrue(errorMessageStartDate.getText().contains("Start date cannot be empty! Please enter a valid data dd/mm/yyyy format for start date!"));
		Assert.assertTrue(errorMessageEndDate.getText().contains("End date cannot be empty! Please enter a valid data dd/mm/yyyy format for end date!"));
		Assert.assertTrue(errorMessageGeographiesSection.getText().contains("At least one geography must be selected!"));
		Assert.assertTrue(errorMessagePrimaryGrography.getText().contains("You must select a primary geography!"));
		Assert.assertTrue(errorMessageServicesChannelsSection.getText().contains("At least one channel must be selected!"));
		Assert.assertTrue(errorMessagePrimaryChannel.getText().contains("You must select a primary channel!"));
	}
	
	public void selectOnePRimaryGeography(String geography){
		waitABit(3000);
		selectFromDropdown(primaryGeographyDropDownList, geography);
		Select geographyName = new Select(primaryGeographyDropDownList);
	    WebElement option = geographyName.getFirstSelectedOption();
	    String selection= option.getText();
		Assert.assertTrue(geography.contains(selection));
	}
	
	public void selectOnePrimaryChannel(String channel){
		waitABit(5000);
		selectFromDropdown(primaryChannelDropDownList, channel);
		primaryChannelDropDownList.click();
		System.out.println("channel selected!");
		Select channelName = new Select(primaryChannelDropDownList);
	    WebElement option = channelName.getFirstSelectedOption();
	    String selection= option.getText();
		Assert.assertTrue(channel.contains(selection));
	}
	
	public void selectOnePrimaryCompany(String company){
		selectFromDropdown(primaryCompanyDropDownList, company);
	}
	
	public void completeStartAndEndDateWithInvalidDataAndVerify(String title, String shortCaption, String detailedCaption, String invalidStartDate, String invalidEndDate, String embeddedCodeWebinar, String geography, String channel, String company){
		titleBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		titleBox.sendKeys(Keys.DELETE);
		titleBox.sendKeys(title);
		shortCaptionBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		shortCaptionBox.sendKeys(Keys.DELETE);
		shortCaptionBox.sendKeys(shortCaption);
		detailedCaptionBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		detailedCaptionBox.sendKeys(Keys.DELETE);
		detailedCaptionBox.sendKeys(detailedCaption);
		embeddedVimeoCodeBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		embeddedVimeoCodeBox.sendKeys(Keys.DELETE);
		embeddedVimeoCodeBox.sendKeys(embeddedCodeWebinar);
		startDateBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		startDateBox.sendKeys(Keys.DELETE);
		startDateBox.sendKeys(invalidStartDate);
		endDateBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		endDateBox.sendKeys(Keys.DELETE);
		endDateBox.sendKeys(invalidStartDate);
		moveAllGeographiesToRightPanelButton.click();
		waitABit(2000);
		selectOnePRimaryGeography(geography);
		moveAllServicesToRightPanelButton.click();
		waitABit(2000);
		selectOnePrimaryChannel(channel);
		moveAllCompaniesToRightPanelButton.click();
		waitABit(2000);
		selectOnePrimaryCompany(company);
		Sleeper.sleepTight(2000);
		saveButton.click();
		Assert.assertTrue(errorMessageStartDate.getText().contains("Please enter a valid data dd/mm/yyyy format for start date!"));
		Assert.assertTrue(errorMessageEndDate.getText().contains("Please enter a valid data dd/mm/yyyy format for end date!"));
	}
	
	public void completeStartDateGraterThanEndDateSaveAndVerify(String startDateGrater, String endDateSmaller){
		startDateBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		startDateBox.sendKeys(Keys.DELETE);
		startDateBox.sendKeys(startDateGrater);
		endDateBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		endDateBox.sendKeys(Keys.DELETE);
		endDateBox.sendKeys(endDateSmaller);
		saveButton.click();
		Assert.assertTrue(errorMessageEndDate.getText().contains("End date is sooner than start date"));
	}
	
	public void clickOnResetFormLinkAndVerify(){
		resetFormLink.click();
		Assert.assertTrue(titleBox.getText().isEmpty());
		Assert.assertTrue(shortCaptionBox.getText().isEmpty());
		Assert.assertTrue(detailedCaptionBox.getText().isEmpty());
		Assert.assertTrue(embeddedVimeoCodeBox.getText().isEmpty());
		Assert.assertTrue(startDateBox.getText().isEmpty());
		Assert.assertTrue(endDateBox.getText().isEmpty());
		Assert.assertTrue(rightPanelGeographySection.getText().isEmpty());
		Assert.assertTrue( getDriver().findElements(By.cssSelector("select#primary_iso > option")).size()==1);
		Assert.assertTrue(rightPanelServicesSection.getText().isEmpty());
		Assert.assertTrue(getDriver().findElements(By.cssSelector("select#primary_service > option ")).size()==1);
		Assert.assertTrue(rightPanelCompanySection.getText().isEmpty());
		Assert.assertTrue(getDriver().findElements(By.cssSelector("select#primary_company > option ")).size()==1);
	}
	
	public void completeAllFieldsWithValidDataSaveAndVerify(String title, String shortCaption, String detailedCaption, String startDate, String endDate, String embeddedCodeWebinar, String geography, String channel, String company){
		titleBox.sendKeys(title);
		shortCaptionBox.sendKeys(shortCaption);
		detailedCaptionBox.sendKeys(detailedCaption);
		embeddedVimeoCodeBox.sendKeys(embeddedCodeWebinar);
		startDateBox.sendKeys(startDate);
		endDateBox.sendKeys(endDate);
		moveAllGeographiesToRightPanelButton.click();
		waitABit(2000);
		selectOnePRimaryGeography(geography);
		moveAllServicesToRightPanelButton.click();
		waitABit(2000);
		selectOnePrimaryChannel(channel);
		moveAllCompaniesToRightPanelButton.click();
		waitABit(2000);
		selectOnePrimaryCompany(company);
		saveButton.click();
		Assert.assertTrue(confirmationMessage.getText().contains(" successfully created"));
	}
	
	public void createPodcasts(String title, String shortCaption, String detailedCaption, String startDate, String endDate, String embeddedCodePodcast, String geography, String channel, String company){
		titleBox.sendKeys(title);
		shortCaptionBox.sendKeys(shortCaption);
		detailedCaptionBox.sendKeys(detailedCaption);
		podcastRadioButton.click();
		embeddedVimeoCodeBox.sendKeys(embeddedCodePodcast);
		startDateBox.sendKeys(startDate);
		endDateBox.sendKeys(endDate);
		moveAllGeographiesToRightPanelButton.click();
		waitABit(2000);
		selectOnePRimaryGeography(geography);
		moveAllServicesToRightPanelButton.click();
		waitABit(2000);
		selectOnePrimaryChannel(channel);
		moveAllCompaniesToRightPanelButton.click();
		waitABit(2000);
		selectOnePrimaryCompany(company);
		saveButton.click();
		Assert.assertTrue(confirmationMessage.getText().contains(" successfully created"));
	}
	
	public void navigatePagesAndVerify(){
//		String infoTextNumberOfEntries=getDriver().findElement(By.cssSelector("div.dataTables_info")).getText(); 
		String infoTextNumberOfEntries=getDriver().findElement(By.cssSelector("div#webinars_table_info")).getText();
		String infoTextSplitted[]=infoTextNumberOfEntries.split(" ");
		String totalNumberOfEntriesWithoutComma = infoTextSplitted[5].replaceAll("[^a-zA-Z0-9]", "");
		int totalNumberOfEntries=Integer.parseInt(totalNumberOfEntriesWithoutComma);
		int totalNumberOfPages;
		if(totalNumberOfEntries>10){
		if(totalNumberOfEntries%10==0){
			totalNumberOfPages=totalNumberOfEntries/10;
		}
		else
			totalNumberOfPages=totalNumberOfEntries/10+1;
			
		System.out.println("total number of pages: "+totalNumberOfPages);
		nextIcon.click();
		previousIcon.click();
		lastIcon.click();
		if(totalNumberOfPages>=5){
		Assert.assertTrue("Number of pages do not match",getDriver().findElement(By.cssSelector("div#webinars_table_wrapper > div:nth-child(2) >  div:nth-child(2) > div > ul > li:nth-child(7) > a")).getText().equals(String.valueOf(totalNumberOfPages)));
		}	
		else if (totalNumberOfPages==4){
			Assert.assertTrue("Number of pages do not match",getDriver().findElement(By.cssSelector("div#webinars_table_wrapper > div:nth-child(2) >  div:nth-child(2) > div > ul > li:nth-child(6) > a")).getText().equals(String.valueOf(totalNumberOfPages)));
		}
		else if(totalNumberOfPages==3){
			Assert.assertTrue("Number of pages do not match",getDriver().findElement(By.cssSelector("div#webinars_table_wrapper > div:nth-child(2) >  div:nth-child(2) > div > ul > li:nth-child(5) > a")).getText().equals(String.valueOf(totalNumberOfPages)));
		}
		
		else if(totalNumberOfPages==2){
			Assert.assertTrue("Number of pages do not match",getDriver().findElement(By.cssSelector("div#webinars_table_wrapper > div:nth-child(2) >  div:nth-child(2) > div > ul > li:nth-child(4) > a")).getText().equals(String.valueOf(totalNumberOfPages)));
		}
		
		
		firstIcon.click();
		Assert.assertTrue("Didn't click first page or paginator didn't work",getDriver().findElement(By.cssSelector("div#webinars_table_wrapper > div:nth-child(2) >  div:nth-child(2) > div > ul > li:nth-child(3) > a")).getText().equals("1"));
		}
		else{
			System.out.println("Number of paginator elements is : " + getDriver().findElements(By.cssSelector("div#webinars_table_wrapper > div:nth-child(2) >  div:nth-child(2) > div > ul > li > a > *")).size());
			Assert.assertTrue("Page 1 missing",getDriver().findElement(By.cssSelector("div#webinars_table_wrapper > div:nth-child(2) >  div:nth-child(2) > div > ul > li:nth-child(3) > a")).getText().equals("1"));
		}
	}
	
	public void moveAllGeographiesToRightPanel() {
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("select#all_Geography > option")).isDisplayed());
		int counterGeo = getDriver().findElements(By.cssSelector("select#all_Geography > option")).size();
		int countEmpty = getDriver().findElements(By.cssSelector("select#Geography > option")).size();
		System.out.println("the list size is :" + counterGeo);
		System.out.println("the list size is :" + countEmpty);
		element(moveAllGeographiesToRightPanelButton).click();
		System.out.println("clicked!!!!!!!!!!!!!!!!!!!!!");
		waitABit(5000);
		int countGeoAfter = getDriver().findElements(By.cssSelector("select#Geography > option")).size();
		Assert.assertTrue("Button not clicked!",countGeoAfter == counterGeo);
	}
	
	public void moveAllServicesToRightPanel() {
		Assert.assertTrue("not found!", getDriver().findElement(By.cssSelector("select#all_Services > option")).isDisplayed());
		int counterServ = getDriver().findElements(By.cssSelector("select#all_Services > option")).size();
		int countEmpty = getDriver().findElements(By.cssSelector("select#Services > option")).size();
		System.out.println("the list size is :" + counterServ);
		System.out.println("the list size is :" + countEmpty);
		element(moveAllServicesToRightPanelButton).click();
		waitABit(10000);
		System.out.println("services moved!");
		int countServAfter = getDriver().findElements(By.cssSelector("select#Services > option")).size();
		Assert.assertTrue("Button not clicked!",countServAfter == counterServ);
	}
}

	

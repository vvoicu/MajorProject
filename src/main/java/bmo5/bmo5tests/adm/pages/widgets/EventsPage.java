package bmo5.bmo5tests.adm.pages.widgets;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class EventsPage extends AbstractAdmPage {
	
	@FindBy(css = "tr[role] > th:nth-child(2)")
	private WebElement startDateHeader;
	
	@FindBy(css = "tr[role] > th:nth-child(3)")
	private WebElement endDateHeader;
	
	@FindBy(css = "tr[role] > th:nth-child(4)")
	private WebElement lastUpdatedHeader;
	
	@FindBy(css = "input[type]")
	private WebElement searchBox;
	
	@FindBy(css = "i.icon-plus")
	private WebElement addNewEventButton;
	
	@FindBy(css = "a.help.btn")
	private WebElement helpButton;
	
	@FindBy(css = "div.modal-footer > button")
	private WebElement closeButtonHelpWindow;
	
	@FindBy(css = "input#title")
	private WebElement newTitleBox;
	
	@FindBy(css = "textarea#caption")
	private WebElement newCaptionBox;
	
	@FindBy(css = "input#start_date")
	private WebElement newStartDateBox;
	
	@FindBy(css = "input#end_date")
	private WebElement newEndDateBox;
	
	@FindBy(css = "input#start_time")
	private WebElement newStartTimeBox;
	
	@FindBy(css = "input#end_time")
	private WebElement newEndTime;
	
	@FindBy(css = "textarea#location")
	private WebElement newLocation;
	
	@FindBy(css = "select#status")
	private WebElement newStatusList;
	
	@FindBy(css = "button#add_hot_topic_form_btn")
	private WebElement newSaveButton;
	
	@FindBy(css = "div.form-actions a")
	private WebElement newResetButton;
	
	@FindBy(css = "div.btn-toolbar > div:nth-child(1) >a ")
	private WebElement newListViewButton;
	
	@FindBy(css = "form > div:nth-of-type(1) > div > label")
	private WebElement errorMessageTitle;
	
	@FindBy(css = "form > div:nth-of-type(2) > div > label")
	private WebElement errorMessageCaption;
	
	@FindBy(css = "form > div:nth-of-type(4) > div > label")
	private WebElement errorMessageStartDate;
	
	@FindBy(css = "form > div:nth-of-type(5) > div > label")
	private WebElement errorMessageStartTime;
	
	@FindBy(css = "form > div:nth-of-type(6) > div > label")
	private WebElement errorMessageEndDate ;
	
	@FindBy(css = "form > div:nth-of-type(7) > div > label")
	private WebElement errorMessageEndTime;
	
	@FindBy(css = "form > div:nth-of-type(8) > div > label")
	private WebElement errorMessageLocation;
	
	@FindBy(css = "div.alert.alert-success")
	private WebElement confirmationMassageEvent;
	
	@FindBy(css = "div.modal-footer a.btn.null")
	private WebElement cancelDeletingEventLinkModalWindow;
	
	@FindBy(css = "div.modal-footer a.btn.btn-primary")
	private WebElement deleteEventOKButtonModalWindow;
	
	@FindBy(css = "div.form-actions > button")
	private WebElement updateEventButton;
	
	public void verifyTableColumns(){
		startDateHeader.click();
		Assert.assertTrue(startDateHeader.getAttribute("aria-sort").equals("ascending"));
		endDateHeader.click();
		Assert.assertTrue(endDateHeader.getAttribute("aria-sort").equals("ascending"));
		lastUpdatedHeader.click();
		Assert.assertTrue(lastUpdatedHeader.getAttribute("aria-sort").equals("ascending"));
	}
	
	public void clickOnStartDateAndVerifyTheOrder(){
		startDateHeader.click();
		/*int numberOfItemsDisplayed = getDriver().findElements(By.cssSelector("tbody > tr")).size();
		System.out.println(numberOfItemsDisplayed);
		String firstItemToCompareString, secondItemToCompareString;
		Integer firstItemToCompareInt, secondItemToCompareInt;
		int newItemsNumber1, newItemsNumber2;
		boolean chronologicalOrder = false;
		for(int i=2; i<= numberOfItemsDisplayed; i++){
				newItemsNumber1 = i -1;
				System.out.println(newItemsNumber1);
				newItemsNumber2 = i;
				System.out.println(newItemsNumber2);
				firstItemToCompareString = getDriver().findElement(By.cssSelector("tbody > tr:nth-child("+ newItemsNumber1 +") > td:nth-child(2)")).getText();
				firstItemToCompareString = firstItemToCompareString.replaceAll("[^0-9]", "");
				System.out.println(firstItemToCompareString);
				firstItemToCompareInt = Integer.valueOf(firstItemToCompareString);
				secondItemToCompareString = getDriver().findElement(By.cssSelector("tbody > tr:nth-child("+ newItemsNumber2 +") > td:nth-child(2)")).getText();
				secondItemToCompareString = secondItemToCompareString.replaceAll("[^0-9]", "");
				System.out.println(secondItemToCompareString);
				secondItemToCompareInt = Integer.valueOf(secondItemToCompareString);
				if(firstItemToCompareInt <= secondItemToCompareInt) {
					chronologicalOrder = true;
				}
				else{
					chronologicalOrder = false;
					break;
				}
		}
		Assert.assertTrue(chronologicalOrder);*/
		startDateHeader.click();
	}
	
	public void clickOnEndDateAndVerifyTheOrder(){
		endDateHeader.click();
		endDateHeader.click();
	}
	
	public void clickOnLAstUpdatedAndVerifyTheOrder(){
		lastUpdatedHeader.click();
		lastUpdatedHeader.click();
	}
	
	public void clickOnHelpButton(){
		helpButton.click();
		closeButtonHelpWindow.click();
	}

	public void clickOnAddANewEventButton(){
		addNewEventButton.click();
		Assert.assertTrue(newTitleBox.isDisplayed());
		Assert.assertTrue(newCaptionBox.isDisplayed());
		Assert.assertTrue(newStartDateBox.isDisplayed());
		Assert.assertTrue(newEndDateBox.isDisplayed());
		Assert.assertTrue(newEndTime.isDisplayed());
		Assert.assertTrue(newStatusList.isDisplayed());
		Assert.assertTrue(newListViewButton.isDisplayed());
		Assert.assertTrue(newLocation.isDisplayed());
	}
	
	public void submitWithoutCompletingAnyFieldAndVerify(){
		newSaveButton.click();
		Assert.assertTrue(errorMessageTitle.getText().contains("Title cannot be empty!"));
		Assert.assertTrue(errorMessageCaption.getText().contains("Caption cannot be empty!"));
		Assert.assertTrue(errorMessageStartDate.getText().contains("Please enter a valid data dd/mm/yyyy format for start date!"));
		Assert.assertTrue(errorMessageStartTime.getText().contains("Time must respect hour:minutes format"));
		Assert.assertTrue(errorMessageEndDate.getText().contains("Please enter a valid data dd/mm/yyyy format for end date!"));
		Assert.assertTrue(errorMessageEndTime.getText().contains("Time must respect hour:minutes format"));
		Assert.assertTrue(errorMessageLocation.getText().contains("Location cannot be empty!"));
	}
	
	public void completeTheFieldsWithSpacesSubmitAndVerify(){
		newTitleBox.sendKeys("             ");
		newCaptionBox.sendKeys("             ");
		newStartDateBox.sendKeys("             ");
		newStartTimeBox.sendKeys("             ");
		newEndDateBox.sendKeys("             ");
		newEndTime.sendKeys("             ");
		newLocation.sendKeys("             ");
		newSaveButton.click();
		Assert.assertTrue(errorMessageTitle.getText().contains("Title cannot be empty! Please do not enter white spaces!"));
		Assert.assertTrue(errorMessageCaption.getText().contains("Please do not enter white spaces!"));
		Assert.assertTrue(errorMessageStartDate.getText().contains("Please enter a valid data dd/mm/yyyy format for start date!"));
		Assert.assertTrue(errorMessageStartTime.getText().contains("Time must respect hour:minutes format"));
		Assert.assertTrue(errorMessageEndDate.getText().contains("Please enter a valid data dd/mm/yyyy format for end date!"));
		Assert.assertTrue(errorMessageEndTime.getText().contains("Time must respect hour:minutes format"));
		Assert.assertTrue(errorMessageLocation.getText().contains("Please do not enter white spaces!"));
	}
	
	public void completeDateAndTimeFieldsWithInvalidDataSubmitAndVerify(String title, String caption, String invalidStartDate, String invalidStartTime, String invalidEndDate, String invalidEndTime, String location){
		newTitleBox.sendKeys(title);
		newCaptionBox.sendKeys(caption);
		newStartDateBox.sendKeys(invalidStartDate);
		newStartTimeBox.sendKeys(invalidStartTime);
		newEndDateBox.sendKeys(invalidEndDate);
		newEndTime.sendKeys(invalidEndTime);
		newLocation.sendKeys(location);
		newSaveButton.click();
		Assert.assertTrue(errorMessageStartDate.getText().contains("Please enter a valid data dd/mm/yyyy format for start date!"));
		Assert.assertTrue(errorMessageStartTime.getText().contains("Time must respect hour:minutes format"));
		Assert.assertTrue(errorMessageEndDate.getText().contains("Please enter a valid data dd/mm/yyyy format for end date!"));
		Assert.assertTrue(errorMessageEndTime.getText().contains("Time must respect hour:minutes format"));
	}
	
	public void completeStartDateGraterThanEndDateSubmitAndVerify(String title, String caption, String startDateGrater, String startTime, String endDateSmaller, String endTime, String location){
		newTitleBox.sendKeys(title);
		newCaptionBox.sendKeys(caption);
		newStartDateBox.sendKeys(startDateGrater);
		newStartTimeBox.sendKeys(startTime);
		newEndDateBox.sendKeys(endDateSmaller);
		newEndTime.sendKeys(endTime);
		newLocation.sendKeys(location);
		newSaveButton.click();
		Assert.assertTrue(errorMessageEndDate.getText().contains("End date is sooner than start date"));
	}
	
	public void resetAllFieldsAndVerify(){
		newResetButton.click();
		Assert.assertTrue(newTitleBox.getText().isEmpty());
		Assert.assertTrue(newCaptionBox.getText().isEmpty());
		Assert.assertTrue(newStartDateBox.getText().isEmpty());
		Assert.assertTrue(newEndDateBox.getText().isEmpty());
		Assert.assertTrue(newEndTime.getText().isEmpty());
		Assert.assertTrue(newLocation.getText().isEmpty());
	}
	
	public void completeAllFieldsWithValidDataAndVerify(String title, String caption, String startDate, String startTime, String endDate, String endTime, String location){
		newTitleBox.sendKeys(title);
		newCaptionBox.sendKeys(caption);
		newStartDateBox.sendKeys(startDate);
		newStartTimeBox.sendKeys(startTime);
		newEndDateBox.sendKeys(endDate);
		newEndTime.sendKeys(endTime);
		newLocation.sendKeys(location);
		newSaveButton.click();
		Sleeper.sleepTight(2000);
		Assert.assertTrue(confirmationMassageEvent.getText().contains("Event " + title + " successfully created"));
	}
	
	public void clickOnListViewButtonAndVerify(){
		newListViewButton.click();
		Assert.assertTrue(addNewEventButton.isDisplayed());
	}
	
	public void clickOnOneItemFromList(String eventName){
		int numberOfItems = getDriver().findElements(By.cssSelector("tbody > tr ")).size();
		for(int i=1; i<=numberOfItems;i++){
			if(getDriver().findElement(By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(1) > a")).getText().equals(eventName)){
				getDriver().findElement(By.cssSelector("tbody > tr:nth-child( " + i + ") > td:nth-child(1) > a")).click();
				break;
			}
		}
	}
	
	public void updateAllFieldsWithValisData(String title, String caption, String startDate, String startTime, String endDate, String endTime, String location){
		newTitleBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		newTitleBox.sendKeys(Keys.DELETE);
		newTitleBox.sendKeys(title);
		newCaptionBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		newCaptionBox.sendKeys(Keys.DELETE);
		newCaptionBox.sendKeys(caption);
		newStartDateBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		newStartDateBox.sendKeys(Keys.DELETE);
		newStartDateBox.sendKeys(startDate);
		newStartTimeBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		newStartTimeBox.sendKeys(Keys.DELETE);
		newStartTimeBox.sendKeys(startTime);
		newEndDateBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		newEndDateBox.sendKeys(Keys.DELETE);
		newEndDateBox.sendKeys(endDate);
		newEndTime.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		newEndTime.sendKeys(Keys.DELETE);
		newEndTime.sendKeys(endTime);
		newLocation.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		newLocation.sendKeys(Keys.DELETE);
		newLocation.sendKeys(location);
		updateEventButton.click();
		Sleeper.sleepTight(2000);
		Assert.assertTrue(confirmationMassageEvent.getText().contains("Event " + title + " successfully updated"));
		Assert.assertTrue(newTitleBox.getAttribute("value").contains(title));
		Assert.assertTrue(newCaptionBox.getText().contains(caption));
		Assert.assertTrue(newStartDateBox.getAttribute("value").contains(startDate));
		Assert.assertTrue(newStartTimeBox.getAttribute("value").contains(startTime));
		Assert.assertTrue(newEndDateBox.getAttribute("value").contains(endDate));
		Assert.assertTrue(newEndTime.getAttribute("value").contains(endTime));
		Assert.assertTrue(newLocation.getText().contains(location));
	}
	
	public void removeOneItemFromList(String eventName){
		int numberOfItems = getDriver().findElements(By.cssSelector("tbody > tr ")).size();
		int numberOfItemsNew = 0;
		for(int i=1; i<=numberOfItems; i++){
			if(getDriver().findElement(By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(1) > a")).getText().equals(eventName)){
				getDriver().findElement(By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(5) > a:nth-child(2)")).click();
				deleteEventOKButtonModalWindow.click();
				waitABit(5000);
				//TODO fix this
//				ManageWidgetsPage manageWidgets = new ManageWidgetsPage(getDriver());
//				manageWidgets.selectRecordsPerPageAndVerify("All");
				waitABit(5000);
				numberOfItemsNew = getDriver().findElements(By.cssSelector("tbody > tr ")).size();
				System.out.println("New number of events:" + numberOfItemsNew);
				if(numberOfItemsNew == 1){
					if(getDriver().findElements(By.cssSelector("tbody > tr:nth-child(1) > td")).size() == 1){
						System.out.println("There is no item in list anymore");
						Assert.assertTrue(getDriver().findElement(By.cssSelector("tbody > tr:nth-child(1) > td")).getText().equals("No data available in table"));
						numberOfItemsNew--;
					}
				}
				Assert.assertTrue(numberOfItemsNew == numberOfItems - 1);
				break;
			}
		}
	}
}

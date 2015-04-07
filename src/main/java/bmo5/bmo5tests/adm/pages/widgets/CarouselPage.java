package bmo5.bmo5tests.adm.pages.widgets;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class CarouselPage extends AbstractAdmPage{
	
	@FindBy(css = "a#btn_add_row")
	private WebElement addNewRowButton;
	
	@FindBy(css = "div.form-actions > button")
	private WebElement saveButton;
	
	@FindBy(css = "a.help.btn")
	private WebElement helpButton;
	
	@FindBy(css = "div.modal-footer > button")
	private WebElement closeButtonHelpWindow;
	
	@FindBy(css = "input#new_article_id")
	private WebElement newArticleIDBox;
	
	@FindBy(css = "input#new_report_id")
	private WebElement newReportIDBox;
	
	@FindBy(css = "input#new_dvpack_id")
	private WebElement newDVPackIDBox;
	
	@FindBy(css = "input#chk_new_row")
	private WebElement statusCheckBox;
	
	@FindBy(css = "a#btn-cancel-new")
	private WebElement cancelAddingANewRowLink;
	
	@FindBy(css = "label[for='new_article_id']")
	private WebElement errorMessageArticleId;
	
	@FindBy(css = "label[for='new_article_id']")
	private WebElement errorMessageReportId;
	
	@FindBy(css = "label[for='new_article_id']")
	private WebElement errorMessageDVPackId;
	
	public void verifyHelpButton(){
		helpButton.click();
		closeButtonHelpWindow.click();
	}
	
	public void clickOnAddNewButtonAndSaveWithoutCompletingAnyFieldAndVerify(){
		addNewRowButton.click();
		saveButton.click();
		Assert.assertTrue(errorMessageArticleId.getText().contains("Required field"));
		Assert.assertTrue(errorMessageReportId.getText().contains("Required field"));
		Assert.assertTrue(errorMessageDVPackId.getText().contains("Required field"));
		cancelAddingANewRowLink.click();
	}
	
	public void clickOnAddNewButtonCompleteFieldsWithValidDataSaveAndVerify(String articleID, String reportID, String dvPackID){
		int numberOfItemsInCarouselBefore = getDriver().findElements(By.cssSelector("table#carousel_items > tbody > tr")).size();
		addNewRowButton.click();
		newArticleIDBox.sendKeys(articleID);
		newReportIDBox.sendKeys(reportID);
		newDVPackIDBox.sendKeys(dvPackID);
		statusCheckBox.click();
		saveButton.click();
		int numberOfItemsInCarouselAfter = getDriver().findElements(By.cssSelector("table#carousel_items > tbody > tr")).size();
		Assert.assertTrue(numberOfItemsInCarouselBefore == numberOfItemsInCarouselAfter - 1);
//		Assert.assertTrue(getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-child(" + numberOfItemsInCarousel +") > td:nth-child(2)")).getText().equals(articleID));
//		Assert.assertTrue(getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-child(" + numberOfItemsInCarousel +") > td:nth-child(3)")).getText().equals(reportID));
//		Assert.assertTrue(getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-child(" + numberOfItemsInCarousel +") > td:nth-child(4)")).getText().equals(dvPackID));
//		Assert.assertTrue(getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-child(" + numberOfItemsInCarousel +") > td:nth-child(5) input")).getAttribute("checked").contains("checked"));
	}
	
	public void clickOnAddButtonCompleteFieldsWithInvalidDataAndVerify(String intalidArticleID, String invalidReportID, String invaliDvPackID){
		addNewRowButton.click();
		newArticleIDBox.sendKeys(intalidArticleID);
		newReportIDBox.sendKeys(invalidReportID);
		newDVPackIDBox.sendKeys(invaliDvPackID);
		statusCheckBox.click();
		saveButton.click();
		Assert.assertTrue(errorMessageArticleId.getText().contains("Please input a valid article id"));
		Assert.assertTrue(errorMessageReportId.getText().contains("Please input a valid article id"));
		Assert.assertTrue(errorMessageDVPackId.getText().contains("Please input a valid article id"));
		cancelAddingANewRowLink.click();
	}
	
	public void clickOnAddNewButtonCancelAndVerify(){
		addNewRowButton.click();
		Assert.assertTrue(newArticleIDBox.isDisplayed());
		Assert.assertTrue(newReportIDBox.isDisplayed());
		Assert.assertTrue(newDVPackIDBox.isDisplayed());
		Assert.assertTrue(statusCheckBox.isDisplayed());
		cancelAddingANewRowLink.click();
		Assert.assertTrue(addNewRowButton.isDisplayed());
	}
	
	public void removeOneItemFromCarousel(String dvPackID){
		int numberOfItemsInCarousel = getDriver().findElements(By.cssSelector("table#carousel_items > tbody > tr")).size();
		for(int i=1; i<=numberOfItemsInCarousel; i++){
			if(getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-child(" + i + ") > td:nth-child(4)")).getText().equals(dvPackID)){
				getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-child(" + i + ") > td:nth-child(6) > a:nth-of-type(1) ")).click();
				break;
			}
		}
		int numberOfItemsInCarouselNew = getDriver().findElements(By.cssSelector("table#carousel_items > tbody > tr")).size();
		Assert.assertTrue(numberOfItemsInCarouselNew == numberOfItemsInCarousel - 1);
//		String carouselID = null;
//		boolean isDeleted = false;
//		if(numberOfItemsInCarousel > 0){
//			if(itemNumber < numberOfItemsInCarousel && itemNumber > 0){
//				carouselID = getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-child(" + itemNumber + ") > td:nth-child(1)")).getText();
//				System.out.println(carouselID);
//				getDriver().findElement(By.cssSelector("tbody > tr:nth-child(" + itemNumber + ") > td:nth-child(6) > a:nth-of-type(1) ")).click();
//			}
//			else{
//				System.out.println("There are not so many items in carousel, so remove the first item.");
//				carouselID = getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-child(1) > td:nth-child(1)")).getText();
//				System.out.println(carouselID);
//				getDriver().findElement(By.cssSelector("tbody > tr:nth-child(1) > td:nth-child(6) > a:nth-of-type(1) ")).click();
//			}
//		}
//		else{
//			System.out.println("There are not any items in carousel.");
//		}
//		
//		Sleeper.sleepTight(2000);
//		if(numberOfItemsInCarousel > 1){
//			for(int i=1; i<=numberOfItemsInCarousel - 1; i++){
//				System.out.println(getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-child(1) > td:nth-child(1)")).getText());
//				if (getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-child(1) > td:nth-child(1)")).getText().contains(carouselID)){
//					isDeleted = false;
//					break;
//				}
//				else{
//					isDeleted = true;
//				}
//			}
//			Assert.assertTrue(isDeleted);
//		}
//		else{
//			System.out.println("There is no item in listing anymore.");
//		}
	}
	
	public void clickOnEditLinkOfOneItemFromCarousel(int itemNumber){
		int numberOfItemsInCarousel = getDriver().findElements(By.cssSelector("table#carousel_items > tbody > tr")).size();
		if(numberOfItemsInCarousel > 0){
			if(itemNumber < numberOfItemsInCarousel && itemNumber > 0){
				getDriver().findElement(By.cssSelector("tbody > tr:nth-child(" + itemNumber + ") > td:nth-child(6) > a:nth-of-type(2) ")).click();
			}
			else{
				System.out.println("There are not so many items in carousel, so remove the first item.");
				getDriver().findElement(By.cssSelector("tbody > tr:nth-child(1) > td:nth-child(6) > a:nth-of-type(2) ")).click();
			}
		}
		else{
			System.out.println("There are not any items in carousel.");
		}
	}
	
//	public void clickOnEditLinkOfFirstInactiveItemFromCarousel(){
//		int numberOfItemsInCarousel = getDriver().findElements(By.cssSelector("table#carousel_items > tbody > tr")).size();
//		for(int i=1; i<=numberOfItemsInCarousel; i++){
//			if(getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-child(" + i + ") > td:nth-child(5)")).getAttribute("checked").contains("checked")){
//				continue;
//			}
//			else{
//				getDriver().findElement(By.cssSelector("tbody > tr:nth-child(1) > td:nth-child(6) > a:nth-of-type(2) ")).click();
//			}
//		}
//	}
	
	public void removeAllItemsByName(String dvPackID){
		int numberOfItemsInCarousel = getDriver().findElements(By.cssSelector("table#carousel_items > tbody > tr")).size();
		System.out.println(numberOfItemsInCarousel);
		boolean isDeleted = false;
		int i=1;
		do{
			if(getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-child(" + i + ") > td:nth-child(4)")).getText().contains(dvPackID)){
				getDriver().findElement(By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(6) > a:nth-of-type(1) ")).click();
				Sleeper.sleepTight(2000);
				i = i -1;
			}
			i++;
			numberOfItemsInCarousel = getDriver().findElements(By.cssSelector("table#carousel_items > tbody > tr")).size();
			System.out.println(numberOfItemsInCarousel);
		}
		while(i<=numberOfItemsInCarousel);
		int newnumberOfItemsInCarousel = getDriver().findElements(By.cssSelector("table#carousel_items > tbody > tr")).size();
		if(numberOfItemsInCarousel > 1){
			for(i=1; i<=newnumberOfItemsInCarousel; i++){
				if (getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-child(" + i + ") > td:nth-child(4)")).getText().contains(dvPackID)){
					isDeleted = false;
					break;
				}
				else{
					isDeleted = true;
				}
			}
			Assert.assertTrue(isDeleted);
		}
		else{
			System.out.println("There is no item in listing anymore.");
		}
	}
	
	public void setCreatedCarouselActive(String carouselID){
		WebElement carouselContainer=getDriver().findElement(By.cssSelector("table#carousel_items > tbody"));
		
		List<WebElement> rows=carouselContainer.findElements(By.cssSelector("tr"));
		
		for(int i=1;i<=rows.size();i++){
			if(getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-of-type("+i+")")).getAttribute("data-id").contains(carouselID)){
			if(!getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-of-type("+i+")")).getAttribute("class").contains("success")){
				getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-of-type("+i+") > td:nth-of-type(5) > div > label > input")).click();
				break;
				}
			}
		}
	}
	
	public String getCarouselID(){
		System.out.println("Created carousel ID: "+getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-of-type(1)")).getAttribute("data-id"));
		return getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-of-type(1)")).getAttribute("data-id");
	}
	
	public int deselectAnActiveItem(){
		WebElement carouselContainer=getDriver().findElement(By.cssSelector("table#carousel_items > tbody"));
		
		List<WebElement> rows=carouselContainer.findElements(By.cssSelector("tr[class*='success']"));
		if(rows.size()==5){
		for(int i=1;i<=rows.size();i++){
		
			if(getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-of-type("+i+")")).getAttribute("class").contains("success")){
				System.out.println("Going to click checkbox number" +i);
				getDriver().findElement(By.cssSelector("table#carousel_items > tbody > tr:nth-of-type("+i+") > td:nth-of-type(5) > div > label > input")).click();
				break;
				}
			}
		}
		return rows.size();
	}
	
	public void clickSaveButton(){
		saveButton.click();
	}
}
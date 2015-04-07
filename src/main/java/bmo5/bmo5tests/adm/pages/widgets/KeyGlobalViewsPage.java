package bmo5.bmo5tests.adm.pages.widgets;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class KeyGlobalViewsPage extends AbstractAdmPage{
	
	@FindBy(css = "a#btn_add_row")
	private WebElement addNewRowButton;
	
	@FindBy(css = "a.help.btn")
	private WebElement helpButton;
	
	@FindBy(css = "div.modal-footer > button")
	private WebElement closeButtonHelpWindow;
	
	@FindBy(css = "div.form-actions > button")
	private WebElement updateFormButton;
	
	@FindBy(css = "input#article_id")
	private WebElement newArticleIDBox;
	
	@FindBy(css = "input#headline")
	private WebElement newHeadlineBox;
	
	@FindBy(css = "a#btn-cancel-new")
	private WebElement cancelAddingANewRowLink;
	
	@FindBy(css = "label[for='article_id']")
	private WebElement errorMessageInvalidArticleID;
	
	@FindBy(css = "label[for='headline']")
	private WebElement errorMessageEmptyHeadline;
	
	public void addANewRowWithoutCompletingAnyFieldAndVerify(){
		addNewRowButton.click();
		updateFormButton.click();
		//verify...
		cancelAddingANewRowLink.click();
	}

	public void addANewRowWithInvalidArticleIDAndVerify(String invalidArticleID, String headlineText){
		addNewRowButton.click();
		newArticleIDBox.sendKeys(invalidArticleID);
		newHeadlineBox.sendKeys(headlineText);
		updateFormButton.click();
		Assert.assertTrue(errorMessageInvalidArticleID.getText().contains("This article id is not a number"));
		cancelAddingANewRowLink.click();
	}
	
	public void addANewRowWithInexistingArticleIDAndVerify(String inexistingArticleID, String headlineText){
		addNewRowButton.click();
		newArticleIDBox.sendKeys(inexistingArticleID);
		newHeadlineBox.sendKeys(headlineText);
		updateFormButton.click();
		Assert.assertTrue(errorMessageInvalidArticleID.getText().contains("This article id doesn't exist in the database. Please input a correct article id"));
		cancelAddingANewRowLink.click();
	}
	
	public void addNewRowWithoutCompletingHeadlineAndVerify(String articleID){
		addNewRowButton.click();
		newArticleIDBox.sendKeys(articleID);
		updateFormButton.click();
		Assert.assertTrue(errorMessageEmptyHeadline.getText().contains("Headline cannot be empty."));
		cancelAddingANewRowLink.click();
	}
	
	public void cancelAddingANewRowAndVerify(){
		addNewRowButton.click();
		Assert.assertTrue(newArticleIDBox.isDisplayed());
		Assert.assertTrue(newHeadlineBox.isDisplayed());
		Assert.assertTrue(cancelAddingANewRowLink.isDisplayed());
		cancelAddingANewRowLink.click();
		Assert.assertTrue(addNewRowButton.isDisplayed());
	}
	
	public void addANewRowAndVerify(String articleID, String headlineText){
		addNewRowButton.click();
		newArticleIDBox.sendKeys(articleID);
		newHeadlineBox.sendKeys(headlineText);
		updateFormButton.click();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("tbody.ui-sortable > tr:last-child > td:nth-child(1)")).getText().contains(articleID));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("tbody.ui-sortable > tr:last-child > td:nth-child(2)")).getText().contains(headlineText));
	}
	
	public void clickOnHelpButton(){
		helpButton.click();
		closeButtonHelpWindow.click();
	}
	
	public void editOneItemFromListing(String itemName, String newName){
		int numberOfItems = getDriver().findElements(By.cssSelector("tbody.ui-sortable > tr")).size();
		for(int i=1; i<=numberOfItems ; i++){
			if(getDriver().findElement(By.cssSelector("tbody.ui-sortable > tr:nth-child("+ i +")> td:nth-child(2) > div")).getText().equals(itemName)){
				
//				Actions action = new Actions(getDriver());
//				  action.doubleClick(getDriver().findElement(By.cssSelector("tbody.ui-sortable > tr:nth-child("+ i +")> td:nth-child(2) > div"))).build().perform();
				getDriver().findElement(By.cssSelector("tbody.ui-sortable > tr:nth-child("+ i +")> td:nth-child(2) > div")).click();
				
				getDriver().findElement(By.cssSelector("tbody.ui-sortable > tr:nth-child("+ i +")> td:nth-child(2) div > form > input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				getDriver().findElement(By.cssSelector("tbody.ui-sortable > tr:nth-child("+ i +")> td:nth-child(2) div > form > input")).sendKeys(Keys.DELETE);
				getDriver().findElement(By.cssSelector("tbody.ui-sortable > tr:nth-child("+ i +")> td:nth-child(2) div > form > input")).sendKeys(newName);
//				getDriver().findElement(By.cssSelector("tbody.ui-sortable > tr:nth-child("+ i +")> td:nth-child(2) div > form > input")).sendKeys(Keys.ENTER);
				waitABit(2000);
						try {
				
							Robot robot = new Robot();
							robot.keyPress(KeyEvent.VK_ENTER);
							robot.keyRelease(KeyEvent.VK_ENTER);
							waitABit(2000);
						} catch (Exception e) {
							System.out.println(e);
						}

				waitABit(3000);
//				action.doubleClick(getDriver().findElement(By.cssSelector("tbody.ui-sortable > tr:nth-child("+ i +")> td:nth-child(2) > div"))).build().perform();
				Assert.assertTrue(getDriver().findElement(By.cssSelector("tbody.ui-sortable > tr:nth-child("+ i +")> td:nth-child(2) div")).getText().contains(newName));
				break;
			}
		}
	}
	
	public void removeOneItemFromListing(String itemName){
		waitABit(5000);
		int numberOfItems = getDriver().findElements(By.cssSelector("tbody.ui-sortable > tr")).size();
		for(int i=1; i<=numberOfItems ; i++){
			if(getDriver().findElement(By.cssSelector("tbody.ui-sortable > tr:nth-child("+ i +")> td:nth-child(2) > div")).getText().equals(itemName)){
				getDriver().findElement(By.cssSelector("tbody.ui-sortable > tr:nth-child("+ i +")> td:nth-child(5) > a")).click();
				break;
			}
		}
		waitABit(5000);
		int newNumberOfItems =  getDriver().findElements(By.cssSelector("tbody.ui-sortable > tr")).size();
		Assert.assertTrue(newNumberOfItems == numberOfItems - 1);
	}
	
	public void clickOnUpdateButtonWithoutCompletingAnyFieldAndVerify(){
		addNewRowButton.click();
		updateFormButton.click();
		Assert.assertTrue(addNewRowButton.isDisplayed());
	}
}

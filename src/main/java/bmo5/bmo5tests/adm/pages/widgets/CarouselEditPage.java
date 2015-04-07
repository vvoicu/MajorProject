package bmo5.bmo5tests.adm.pages.widgets;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class CarouselEditPage extends AbstractAdmPage{
	@FindBy(css = "input#article_id")
	private WebElement articleIDBox;

	@FindBy(css = "input#report_id")
	private WebElement reportIDBox;
	
	@FindBy(css = "input#dvpack_id")
	private WebElement dvpackIDBox;
	
	@FindBy(css = "input.chk_active_carousell")
	private WebElement statusCheckBox;
	
	@FindBy(css = "button > i.icon-ok")
	private WebElement updateButton;
	
	@FindBy(css = "a.btn.btn-link.evil.color")
	private WebElement resetLink;
	
	@FindBy(css = "div.btn-toolbar a > i.icon-list")
	private WebElement listViewButton;
	
	@FindBy(css = "div#wdg_carousel > div:nth-of-type(1) label.help-block.error")
	private WebElement errorMessageArticleID;
	
	@FindBy(css = "div#wdg_carousel > div:nth-of-type(2) label.help-block.error")
	private WebElement errorMessageReportID;
	
	@FindBy(css = "div#wdg_carousel > div:nth-of-type(3) label.help-block.error")
	private WebElement errorMessageDVPackID;
	
	public void deleteAllDataAndClickOnUpdateButtonThenClickOnResetLink(){
		String articleID = articleIDBox.getText();
		String reportID = reportIDBox.getText();
		String dvpackID = dvpackIDBox.getText();
		articleIDBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		articleIDBox.sendKeys(Keys.DELETE);
		reportIDBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		reportIDBox.sendKeys(Keys.DELETE);
		dvpackIDBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		dvpackIDBox.sendKeys(Keys.DELETE);
		updateButton.click();
		Assert.assertTrue(errorMessageArticleID.getText().contains("Required field"));
		Assert.assertTrue(errorMessageReportID.getText().contains("Required field"));
		Assert.assertTrue(errorMessageDVPackID.getText().contains("Required field"));
		resetLink.click();
		Assert.assertTrue(articleIDBox.getText().contentEquals(articleID));
		Assert.assertTrue(reportIDBox.getText().contentEquals(reportID));
		Assert.assertTrue(dvpackIDBox.getText().contentEquals(dvpackID));
	}
	
	public void completeFieldsWithInvalidDataAndClickOnUpdateButton(String invalidArticleID, String invalidReportID, String invalidDvpackID){
		articleIDBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		articleIDBox.sendKeys(Keys.DELETE);
		articleIDBox.sendKeys(invalidArticleID);
		reportIDBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		reportIDBox.sendKeys(Keys.DELETE);
		reportIDBox.sendKeys(invalidReportID);
		dvpackIDBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		dvpackIDBox.sendKeys(Keys.DELETE);
		dvpackIDBox.sendKeys(invalidDvpackID);
		updateButton.click();
		Assert.assertTrue(errorMessageArticleID.isDisplayed());
		Assert.assertTrue(errorMessageReportID.isDisplayed());
		Assert.assertTrue(errorMessageDVPackID.isDisplayed());
	}
	
	public void clickOnListViewButton(){
		listViewButton.click();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#wdg_carousel")).isDisplayed());
	}
}

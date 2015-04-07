package bmo5.bmo5tests.bmo.pages.pillarPages;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class NoEntitlementsForUserPage extends AbstractPage {


	@FindBy(css = "div#permission-modal-service")
	private WebElement popUpWindowForNoEntitlements;

	@FindBy(css = "div#permission-modal-service > div:nth-child(2) > button") 
	private WebElement cancelButton;

	@FindBy(css = "div#permission-modal-service > div:nth-child(2) > a") 
	private WebElement contactAccountManagerButton;

	public void clickPopUpWindow() {
		popUpWindowForNoEntitlements.click();
	}
	public void clickCancelButton() {
		cancelButton.click();
		Assert.assertTrue("Not Found!!!!", getDriver().findElement(By.cssSelector("div#permission-modal-service > div:nth-child(2) > button")).getText().contains("Cancel"));
	}

	public void clickOnContactAccountManager() {
		contactAccountManagerButton.click();
	}
	
}

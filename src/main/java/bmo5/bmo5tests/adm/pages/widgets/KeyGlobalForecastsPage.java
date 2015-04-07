package bmo5.bmo5tests.adm.pages.widgets;



import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class KeyGlobalForecastsPage extends AbstractAdmPage {

	@FindBy(css="button[type='submit']")
	private WebElement saveButton;
	
	public void clickDvpackIdInput(String inputType) {
		WebElement kgfDvpackIdCell = getDriver().findElement(By.cssSelector(inputType));
		kgfDvpackIdCell.click();
	}
	
	public void typeDvpackId(String inputTypeForm, String dvpackId){
		WebElement kgfDvpackIdInput = getDriver().findElement(By.cssSelector(inputTypeForm));
		kgfDvpackIdInput.clear();
		kgfDvpackIdInput.sendKeys(dvpackId);
	}
	
	public void clickSaveButton(){
		saveButton.click();
		waitABit(1000);
	}
	
	public String getTextForDvpackIdInput(String inputType){
		WebElement kgfDvpackIdCell = getDriver().findElement(By.cssSelector(inputType));
		return kgfDvpackIdCell.getText();
	}
	
	public void verifyErrorMessage(String errorMessage, String inputType){
		Assert.assertTrue("Error message not displayed",getTextForDvpackIdInput(inputType).contains(errorMessage));
	}
	
	public void verifyCellIsDisplayed(String inputType){
		WebElement kgfDvpackIdCell = getDriver().findElement(By.cssSelector(inputType));
		Assert.assertTrue("Table dvpack id cell is not displayed!!",kgfDvpackIdCell.isDisplayed());
		System.out.println(inputType);
		System.out.println(kgfDvpackIdCell.getText());
	}
}

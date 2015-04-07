package bmo5.bmo5tests.bmo.pages.pillarPages;

import net.thucydides.core.annotations.findby.FindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class FilterPanelPage extends AbstractPage {


	@FindBy(id = "filter-clear")
	@CacheLookup
	private WebElement clearFilters;
	
	@FindBy(css = "div.btn-group.saved-data > button.btn.btn-small:nth-child(1)")
	@CacheLookup
	private WebElement saveView;
	
	@FindBy(xpath = "//h5[contains(text(), 'Geography')]")
	@CacheLookup
	private WebElement geography;
	
	@FindBy(xpath = "//h5[contains(text(), 'Service')]")
	@CacheLookup
	private WebElement service;
	
	
	public void clearFilters() {
		clearFilters.click();
	}
	
	public void saveView() {
		saveView.click();
	}
	
	public void clickOnGeography() {
		geography.click();
	}
	
	public void clickOnService() {
		service.click();
	}
	
	public void clickOnLeftPanelLevelOne(String levelOne) {
		getDriver().findElement(By.cssSelector("label[class='radio'][for*='" + levelOne + "'] > div > span > input")).click();
		getDriver().findElement(By.cssSelector("label[class='radio'][for*='" + levelOne + "'] + button")).click();
	}
	
	public void clickOnLeftPanelLevelTwo(String levelTwo) {
		getDriver().findElement(By.cssSelector("label[class='checkbox'][for*='" + levelTwo + "'] > div > span > input")).click();
	}
}

package bmo5.bmo5tests.bmo.pages.homepage;

import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class FiltersPanelGeoPivotPage extends AbstractPage {
	
	@FindBy(css = "ul[class='nav nav-list dropdown-list show']")
	private WebElement serviceContainer;
	
	@FindBy(css = "ul#categories-list")
	private WebElement categoryContainer;
	
	public void selectServiceOrSubService(String service) {
		List<WebElement> serviceList = serviceContainer.findElements(By.className("checkbox"));
		for (WebElement serv:serviceList) {
			if (serv.getText().contains(service)) {
				serv.click();
				break;
			}
		}
	}
	
	public void verifySelectedService () {
		element(getDriver().findElement(By.cssSelector("ul.nav.nav-list.dropdown-list.show  > li > label > div > span[class='checked']"))).waitUntilPresent();
		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("ul.nav.nav-list.dropdown-list.show  > li > label > div > span[class='checked']")).isDisplayed());
	}
	
	public void verifySelectedCategory(String categoryId) {
//		element(getDriver().findElement(By.cssSelector("ul#categories-list > li > label > div > span[class='checked']"))).waitUntilPresent();
//		Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("ul#categories-list > li > label > div > span[class='checked']")).isDisplayed());
		Assert.assertTrue(verifyElementState("document.getElementById('"+categoryId+"')"));
	}
	
	public void selectCategory(String category) {
		List<WebElement> categoryList = categoryContainer.findElements(By.className("checkbox"));
		for(WebElement categ:categoryList) {
			if(categ.getText().contains(category)){
				categ.click();
			}
		}
		waitABit(10000);
	}
	
	public void verifyContent(String category, String service, String country){

		Assert.assertTrue("Reports do not contain selected category " + category,
				getDriver().findElement(By.cssSelector("li#category-sidebar > div > ul > li:nth-child(11) > label")).getText().contains(category));
		waitABit(3000);
		Assert.assertTrue("Reports do not contain selected service " + service,
				getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > div > ul > li:nth-child(10) > label")).getText().contains(service));
		waitABit(3000);
		Assert.assertTrue("Reports do not contain selected geography " + country,
				getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(1) > h5 ")).getText().contains(country));
	}

	public void verifyClearFilterLink(String clearFilter, String all) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("a#filter-clear")).getText().contains(clearFilter));
		getDriver().findElement(By.cssSelector("a#filter-clear")).click();
		waitABit(9000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("span.badge.badge-info.service-count")).getText().contains(all));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("span.badge.badge-info.category-count")).getText().contains(all));
	}
}


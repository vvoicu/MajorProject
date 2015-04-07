package bmo5.bmo5tests.bmo.pages.pillarPages;


import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class ReportsPage extends AbstractPage {

	@FindBy(css = "div.sidebar.well > ul:nth-child(1) >li:nth-child(3) > h5")
	private WebElement clickServiceGeographyFromPanel;

	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li:nth-child(3) > div > ul")
	private WebElement selectServiceFromPanel;

	@FindBy(css = "ul.breadcrumb > li:nth-child(3) ")
	private WebElement subBreadcrumb;

	@FindBy(css = "")
	private WebElement breadcrumbElementSelectedFromPanel;

	@FindBy(css = "ul.nav.nav-list.dropdown-list.show > li:nth-child(1) > input")
	private WebElement textAreaServiceFilter;

	@FindBy(css = "ul.breadcrumb > li.active")
	@CacheLookup
	private WebElement breadcrumbLast;

	@FindBy(css = "ul.breadcrumb > li:nth-child(3) > a")
	@CacheLookup
	private WebElement breadcrumbMiddle;

	public void clickServiceGeographyPanel() {
		clickServiceGeographyFromPanel.click();
	}

	public void panelServiceGeographyListAndVerify(String service) {
		element(selectServiceFromPanel).waitUntilVisible();
		String geographyBadgeBefore = getDriver().findElement(By.cssSelector("span.badge.badge-info.geography-count")).getText();
		WebElement element = selectServiceFromPanel.findElement(By.cssSelector("label[title='"+service+"']"));
		element(element).click();
		Assert.assertTrue(element.getText().contains(service));
		waitABit(7000);
		String geographyBadge = getDriver().findElement(By.cssSelector("span.badge.badge-info.geography-count")).getText();
//			if(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > div > ul > li > label > div > span.checked > input")).isSelected()) {
//			System.out.println("Geography found!");
//		}
		Assert.assertTrue("not found!", verifyElementState("document.getElementById('r_A')"));
		Assert.assertTrue(geographyBadge != geographyBadgeBefore );
	}

	public void panelGeographyListAndVerify(String service) {
		element(selectServiceFromPanel).waitUntilVisible();
		String serviceBadgeBefore = getDriver().findElement(By.cssSelector("span.badge.badge-info.service-count")).getText();
		WebElement element = selectServiceFromPanel.findElement(By.cssSelector("label[title='"+service+"']"));
		element(element).click();
		Assert.assertTrue(element.getText().contains(service));
		waitABit(7000);
		String serviceBadge = getDriver().findElement(By.cssSelector("span.badge.badge-info.service-count")).getText();
//			if(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > div > ul > li > label")).isSelected()) {
//			System.out.println("Geography found!");
//		}
		Assert.assertTrue(verifyElementState("document.getElementById('s_19')"));
		Assert.assertTrue(serviceBadge != serviceBadgeBefore );
	}

	public void searchFilterServiceSection(String service) {
		element(textAreaServiceFilter).waitUntilVisible();
		textAreaServiceFilter.sendKeys(service);
		waitABit(5000);
	}

	public void clearFilter(String clear,String all) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("a#filter-clear")).getText().contains(clear));
		getDriver().findElement(By.cssSelector("a#filter-clear")).click();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("span.badge.badge-info.service-count")).getText().contains(all));
	}

	public void verifyBreadCrumbForServicePivot(String text) {
		boolean contained = false;
		if (text.contains(subBreadcrumb.getText())) {
			contained = true;
		} else {
			String element = ((WebElement) selectServiceFromPanel.findElements(By.tagName("label"))).getText();
			if (text.contains(element)) {
				contained = true;
				waitABit(10000);	
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
		waitABit(10000);	
	}

	public void verifyBreadCrumb(String text) {
		boolean contained = false;
		if (breadcrumbLast.getText().contains(text)) {
			contained = true;
		} else {
			if (breadcrumbMiddle.getText().contains(text)) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}
}

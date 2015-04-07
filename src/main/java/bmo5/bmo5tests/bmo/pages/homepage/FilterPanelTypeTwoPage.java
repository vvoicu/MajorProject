package bmo5.bmo5tests.bmo.pages.homepage;

import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class FilterPanelTypeTwoPage extends AbstractPage {

	@FindBy(id = "geographies_filter")
	private WebElement geography;

	@FindBy(id = "services_filter")
	@CacheLookup
	private WebElement service;

	@FindBy(id = "reports_refine_form")
	private WebElement dropBox;

	@FindBy(css = " a[href='/sar/reports/download?product_code=RA0074&issue=RA0074_20130701.pdf']")
	private WebElement clickOnReport;

	@FindBy(linkText = "Special Reports")
	@CacheLookup
	private WebElement specialReports;

	@FindBy(css = "ul.breadcrumb li:last-child ")
	private WebElement breadcrumbLast;

	@FindBy(css = "ul.breadcrumb li:first-child a[href='/home']")
	private WebElement breadcrumbFirst;

	@FindBy(css = "ul.breadcrumb > li:nth-child(2) > a")
	private WebElement clickHome;

	@FindBy(css = "table.ui-datepicker-calendar")
	private WebElement datePicker;
	// @FindBy(id="ui-datepicker-div" )
	// private WebElement datePicker;

	@FindBy(id = "new_form_start_date")
	private WebElement clickDatepicker;
	
	@FindBy(css = "button.btn")
	private WebElement clickUpdateButton;
	

	public void clickOnDate() {
		clickDatepicker.click();
	}

	public void clickOnHome() {
		clickHome.click();
	}

	public void clickOnReport() {
		clickOnReport.click();
	}

	public void clickFilterPanelGeography() {
		element(geography).waitUntilVisible();

		List<WebElement> CHECKBOXlist = geography.findElements(By
				.className("checkbox"));

		for (int i = 0; i < CHECKBOXlist.size(); i++) {
			System.out.println(CHECKBOXlist.get(i).isSelected());
		}

		for (int i = 0; i < CHECKBOXlist.size();) {
			CHECKBOXlist.get(i).click();
			waitABit(10000);
			break;
		}

	}

	public void verifyCheckbox() {
		element(dropBox).waitUntilVisible();
		List<WebElement> labels = dropBox.findElements(By
				.cssSelector("ul.nav.nav-list.dropdown-list"));

		for (WebElement label1 : labels) {
			String labelnow = label1.findElement(By.cssSelector("label"))
					.getAttribute("class");
			System.out.println(labelnow);
			if (label1.getText().contains("Anytime")) {
				label1.click();
				waitABit(10000);
				break;

			} else if (label1.getText().contains("Within last week")) {
				label1.click();
				waitABit(5000);

			} else if (label1.getText().contains("Within last month")) {
				label1.click();
				waitABit(5000);

			} else if (label1.getText().contains("Within last 3 months")) {
				label1.click();
				waitABit(5000);

			} else if (label1.getText().contains("Within last 6 months")) {
				label1.click();
				waitABit(5000);

			}
		}
	}

	public void clickFilterPanelService() {

		element(service).waitUntilVisible();

		List<WebElement> checkboxlist = service.findElements(By
				.className("checkbox"));

		for (int i = 0; i < checkboxlist.size(); i++) {
			System.out.println(checkboxlist.get(i).isSelected());
		}

		for (int i = 0; i < checkboxlist.size();) {
			checkboxlist.get(i).click();
			waitABit(10000);
			break;
		}

	}


	public void verifyBreadcrumbs(String text) {
		boolean contained = false;

		if (breadcrumbLast.getText().contains(text)) {
			contained = true;
		} else {
			if (breadcrumbFirst.getText().contains(text)) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}

	public void setDate(String day) {
		element(datePicker).waitUntilVisible();
		List<WebElement> allElements = datePicker.findElements(By.tagName("td a"));

		for (WebElement cell : allElements){
			if (cell.getText().equals(day)) {
				cell.click();
				break;
			}

		}
	}
}

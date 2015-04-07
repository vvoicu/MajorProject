package bmo5.bmo5tests.bmo.pages.pillarPages;

import java.awt.event.KeyEvent;
import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.desktop.DesktopKeyboard;

import bmo5.bmo5tests.tools.FileChecker;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class DataAndForecastingPage extends AbstractPage {

	@FindBy(css = "section.row-fluid > ul:nth-child(1) > li:nth-child(3) > div > a:nth-child(1)")
	private WebElement dataToolButton;

	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li > ul > li >input")
	private WebElement typeGeographyAreaDataTool;

	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li >ul ")
	private WebElement containerGeographyPanel;

	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li:nth-child(3) > h5 ")
	private WebElement indicatorLeftPanelContainer;

	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li:nth-child(3) > div > ul ")
	private WebElement containerIndicator;

	@FindBy(css = "div.sidebar.well > ul:nth-child(2) > li > ul > li:nth-child(1) ")
	private WebElement indicatorTextType;

	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li:nth-child(4) > h5 ")
	private WebElement dateRangesClick;

	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li:nth-child(4) > ul")
	private WebElement containerDateRanges;

	@FindBy(css = "ul.nav.nav-list.dropdown-list.show")
	private WebElement containerDateRangesList;

	@FindBy(css = "button#filter-download-data")
	private WebElement downloadButtonPanel;

	@FindBy(id = "filter-display-data")
	private WebElement displayDataButton;

	@FindBy(id = "filter-download-data")
	private WebElement downloadDataButton;

	@FindBy(css = "ul#pillars > li:nth-child(3) > a > h4")
	private WebElement dataAndForecastingTab;

	@FindBy(css = "ul#pillars > li:nth-child(3) > div:nth-child(2)")
	private WebElement containerSubTabDataAndForecasting;

	@FindBy(css = "a[href='/data/ratings/countryrisk/']")
	private WebElement countryRiskTab;

	@FindBy(css = "a[href='/home']")
	private WebElement firstBreadcrumb;

	@FindBy(css = "a[href='/data/ratings']")
	private WebElement BreadcrumbCountryRisk;

	@FindBy(css = "a[href='/data/ratings/riskreward/?rservice=8']")
	private WebElement securityTab;

	@FindBy(css = "ul.breadcrumb li.active")
	private WebElement lastBreadcrumb;

	@FindBy(css = "div.container-fluid > section:nth-child(5) > article:nth-child(2) > div:nth-child(1) > div:nth-child(1) > h4 > a ")
	private WebElement keyProjectsLink;

	@FindBy(css = "article[class = 'span12 height-limiter'] > div:nth-child(1) > a[class='btn btn-small explore-data'] ")
	private WebElement clickToExploreDataButton;

	@FindBy(css = "select#goto")
	private WebElement ratingTypeContainer;

	@FindBy(css = "div.span12.padding-top-20 ul")
	private WebElement industryRiskContainer;

	@FindBy(css = "div.container-fluid > section:nth-child(5) > article > div:nth-child(1) > a > h4")
	private WebElement dataTool;

	@FindBy(css = "div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > a > h4")
	private WebElement ratings;

	@FindBy(css = "div.container-fluid > section:nth-child(5) > article > div:nth-child(3) > a > h4")
	private WebElement bmiDatabases;

	@FindBy(css = "div.container-fluid > section:nth-child(5) > article > div:nth-child(1) > a:nth-child(2)")
	private WebElement exploreDataButton;

	@FindBy(css = "ul.breadcrumb > li.active")
	@CacheLookup
	private WebElement breadcrumbLast;

	@FindBy(css = "ul.breadcrumb > li:nth-child(2) > a")
	@CacheLookup
	private WebElement breadcrumbFirst;

	@FindBy(css = "ul.breadcrumb > li:nth-child(2) > a")
	@CacheLookup
	private WebElement breadcrumbSecond;

	@FindBy(css = "a[href='/data/ratings']")
	private WebElement ratingsLink;

	@FindBy(css = "a[href='/data/ratings/countryrisk/']")
	// div.container-fluid > section:nth-child(5) > article > div:nth-child(2) >
	// div > div > div > div > div:nth-child(1) > h5:nth-child(1) > a
	private WebElement countryRiskLink;

	@FindBy(css = "a[href='/data/ratings/riskreward/?rservice=8']")
	// div.container-fluid > section:nth-child(5) > article > div:nth-child(2) >
	// div > div > div > div > div:nth-child(1) > h5:nth-child(2) > a")
	private WebElement securityLink;

	@FindBy(css = "a[href='/data/ratings/operationalrisk?rservice=30']")
	private WebElement operationalLink;

	@FindBy(css = "a[href='/data/ratings/finance/?rservice=61']")
	// div.container-fluid > section:nth-child(5) > article > div:nth-child(2) >
	// div > div > div > div > div:nth-child(1) > h5:nth-child(3) > a")
	private WebElement projectFinanceLink;

	@FindBy(css = "div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > h5")
	// div.container-fluid > section:nth-child(5) > article > div:nth-child(2) >
	// div > div > div > div > div:nth-child(2) > div > h5")
	private WebElement industryReward;

	@FindBy(css = "div.well.no-background")
	private WebElement noDvPackDataAndFor;

	public void clickOnDataAndForecastingTab(String dataTab) {
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("ul#pillars > li:nth-child(3) >  a > h4"))
				.getText().contains(dataTab));
		dataAndForecastingTab.click();
	}

	public void clickOnkeyProjectsLink(String infra) {
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article:nth-child(2) > div:nth-child(1) > div:nth-child(1) > h4 > a "))
				.getText().contains(infra));
		keyProjectsLink.click();
	}

	public void clickOnDownloadDataTool() {
		downloadDataButton.click();
	}

	public void clickOnProjectFinance(String projRisk) {
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("a[href='/data/ratings/finance/?rservice=61']"))
				.getText().contains(projRisk));
		getDriver().findElement(
				By.cssSelector("a[href='/data/ratings/finance/?rservice=61']"))
				.click();
	}

	public void clickOnDownloadDataToolAndVerify(String extension) {
		// downloadDataButton.click();
		waitUntilElementExists(By.cssSelector("button#filter-download-data"),
				20);
		elementClick("button#filter-download-data");
		waitABit(3000);
		saveImageHandle2();
		waitABit(3000);
		FileChecker file = new FileChecker();
		file.verifyExtentionExcelFile(extension);
	}

	public void saveImageHandle2() {
		String mainWindow = getDriver().getWindowHandle();
		getDriver().switchTo().activeElement();

		waitABit(3000);
		Keyboard keyboard = new DesktopKeyboard();
		waitABit(1000);
		keyboard.keyDown(KeyEvent.VK_ENTER);
		keyboard.keyUp(KeyEvent.VK_ENTER);

		getDriver().switchTo().window(mainWindow);
	}

	public void saveImageHandle1() {
		String mainWindow = getDriver().getWindowHandle();
		getDriver().switchTo().activeElement();

		waitABit(3000);

		Keyboard keyboard = new DesktopKeyboard();
		keyboard.keyDown(KeyEvent.VK_DOWN);
		keyboard.keyUp(KeyEvent.VK_DOWN);
		waitABit(1000);
		keyboard.keyDown(KeyEvent.VK_ENTER);
		keyboard.keyUp(KeyEvent.VK_ENTER);

		getDriver().switchTo().window(mainWindow);
	}

	public void clickOnDataTool(String dataTool) {
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("ul#pillars > li:nth-child(3) > div > a:nth-child(1)"))
				.getText().contains(dataTool));
		dataToolButton.click();
		waitABit(2000);
		if (getDriver().findElement(By.partialLinkText("Geography"))
				.getCssValue("background-color")
				.compareToIgnoreCase("rgba(10,121,213)") == 0) {
			Assert.assertEquals("Not the right colour!",
					getDriver().findElement(By.partialLinkText("Geography"))
							.getCssValue("background-color"));
		}
	}

	public void clickOnCountryRiskTab() {
		countryRiskTab.click();
		waitABit(10000);
	}

	public void typeGeography(String text) {
		typeGeographyAreaDataTool.sendKeys(text);
	}

	public void clickIndicatorLeftPanel() {
		indicatorLeftPanelContainer.click();
	}

	public void typeIndicatorLeftPanel() {
		indicatorTextType.sendKeys("Inf");
	}

	public void clickDateRangesLeftPanel() {
		dateRangesClick.click();
	}

	public void typeDateRangesLeftPanel(String checkbox) {
		element(containerDateRanges).waitUntilVisible();
		List<WebElement> allElements = containerDateRanges.findElements(By
				.cssSelector("li label"));

		for (WebElement cell : allElements) {
			if (cell.getText().equals(checkbox)) {
				cell.click();
				break;
			}

		}
	}

	public void chooseSubTabDataAndForecasting(String element) {

		element(containerSubTabDataAndForecasting).waitUntilVisible();
		List<WebElement> allElements = containerSubTabDataAndForecasting
				.findElements(By.tagName("a"));

		for (WebElement cell : allElements) {
			if (cell.getText().equals(element)) {
				cell.click();
				break;
			}

		}
	}

	public void clickOnDownloadButton() {
		downloadButtonPanel.click();
	}

	public void selectGeographyFromPanel(String element) {
		element(containerGeographyPanel).waitUntilVisible();
		System.out.println("in containerGeographyPanel");
		List<WebElement> allElements = containerGeographyPanel.findElements(By
				.cssSelector(" li button"));

		for (WebElement region : allElements) {
			if (region.getText().equals(element)) {
				region.click();
				break;
			}

		}

	}

	public void clickGeographyFromPanel(String element) {
		element(containerGeographyPanel).waitUntilVisible();
		System.out.println("in containerGeographyPanel");
		List<WebElement> allElements = containerGeographyPanel.findElements(By
				.cssSelector(" li label "));

		for (WebElement region : allElements) {
			if (region.getText().equals(element)) {
				region.click();
				break;
			}

		}
		System.out.println("selected!!!");

	}

	public void clickIndicatorFromPanel(String element) {
		element(containerIndicator).waitUntilVisible();
		System.out.println("in containerIndicatorList");
		List<WebElement> allElements = containerIndicator.findElements(By
				.cssSelector("li:nth-child(2) button"));

		for (WebElement region : allElements) {
			if (region.getText().equals(element)) {
				region.click();
				break;
			}

		}
		System.out.println("selected!!!");

	}

	public void clickIndicatorFromPanelCheckBox(String element) {
		element(containerIndicator).waitUntilVisible();
		System.out.println("in containerIndicatorList");
		List<WebElement> allElements = containerIndicator.findElements(By
				.cssSelector("li:nth-child(2) label"));

		for (WebElement indicator : allElements) {
			if (indicator.getText().equals(element)) {
				indicator.click();
				break;
			}

		}
		System.out.println("selected!!!");

	}

	public void clickDisplayDatabutton() {
		displayDataButton.click();
	}

	public void verifyBreadCrumbForCountryRisk(String text) {
		boolean contained = false;
		if (text.contains(lastBreadcrumb.getText())) {
			contained = true;
		} else {
			if (text.contains(BreadcrumbCountryRisk.getText())) {
				contained = true;
				waitABit(10000);
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
		waitABit(10000);
	}

	public void clickOnClickToExporeDataButton() {
		clickToExploreDataButton.click();
	}

	public void clickOnSecurityTab(String security) {
		Assert.assertTrue(securityTab.getText().contains(security));
		securityTab.click();
	}

	public void selectOneRatingFromDropDownList(String ratingName) {
		waitABit(5000);
		selectFromDropdown(ratingTypeContainer, ratingName);
		Select rating = new Select(ratingTypeContainer);
		WebElement option = rating.getFirstSelectedOption();
		String selection = option.getText();
		Assert.assertTrue(ratingName.contains(selection));
	}

	public void clickOnRatingByPartialLink(String ratingName) {
		getDriver().findElement(By.partialLinkText(ratingName)).click();
		waitABit(5000);
	}

	public void selectMiningIndustry(String mining) {
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("a[href='/data/ratings/countryrisk/']"))
				.getText().contains(mining));
		getDriver().findElement(
				By.cssSelector("a[href='/data/ratings/countryrisk/']")).click();
		waitABit(5000);
	}

	public void verifySubTabsPresenceOnPage(String data, String rating,
			String database, String cr, String operational, String security,
			String project, String industry, String autos, String commercial,
			String consumer, String food, String info, String infra,
			String insurance, String medical, String mining, String oil,
			String petro, String pharma, String power, String estate,
			String renew, String ret, String telecom, String tourism) {
		Assert.assertTrue("not found!", dataTool.getText().contains(data));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#ratings > div:nth-child(1) > a > h4"))
						.getText().contains(rating));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("a[href='/data/databases'] > h4"))
						.getText().contains(database));
		Assert.assertTrue("not found!", countryRiskLink.getText().contains(cr));
		Assert.assertTrue("not found!",
				operationalLink.getText().contains(operational));
		Assert.assertTrue("not found!",
				securityLink.getText().contains(security));
		Assert.assertTrue("not found!",
				projectFinanceLink.getText().contains(project));
		Assert.assertTrue("not found!",
				industryReward.getText().contains(industry));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(1) > a"))
						.getText().contains(autos));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(2) > a"))
						.getText().contains(commercial));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div >  div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(3) > a"))
						.getText().contains(consumer));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(4) > a"))
						.getText().contains(food));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(5) > a"))
						.getText().contains(info));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(1) > a"))
						.getText().contains(infra));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(2) > a"))
						.getText().contains(insurance));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(4) > a"))
						.getText().contains(mining));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(5) > a"))
						.getText().contains(oil));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(4) > li:nth-child(1) > a"))
						.getText().contains(petro));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(4) > li:nth-child(2) > a"))
						.getText().contains(pharma));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(4) > li:nth-child(3) > a"))
						.getText().contains(power));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(4) > li:nth-child(4) > a"))
						.getText().contains(estate));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(4) > li:nth-child(5) > a"))
						.getText().contains(renew));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(5) > li:nth-child(1) > a"))
						.getText().contains(ret));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(5) > li:nth-child(2) > a"))
						.getText().contains(telecom));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(5) > li:nth-child(3) > a"))
						.getText().contains(tourism));
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(3) > a"))
						.getText().contains(medical));
		waitABit(30000);
	}

	public void verifyDataToolRedirection() {
		if (getDriver()
				.findElements(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(1) > div:nth-of-type(1) > div> div> p"))
				.size() == 1) {
			String noDvPack = getDriver()
					.findElement(
							By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(1) > div:nth-of-type(1) > div> div> p "))
					.getText();
			Assert.assertTrue(getDriver()
					.findElement(
							By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(1) > div:nth-of-type(1) > div> div> p "))
					.getText().contains(noDvPack));
		} else {
			Assert.assertTrue(
					"not found!",
					getDriver()
							.findElement(
									By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(1) > a"))
							.isDisplayed());
			exploreDataButton.click();
			waitABit(4000);
			String breadcrumb = breadcrumbLast.getText();
			System.out.println(breadcrumb);
			waitABit(3000);
			Assert.assertTrue("the breadcrumb is not right!", breadcrumbLast
					.getText().contains(breadcrumb));
		}
	}

	public void verifyBreadCrumb(String text) {
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

	public void verifyBreadCrumbRatings(String textNew) {
		boolean contained = false;
		if (breadcrumbLast.getText().contains(textNew)) {
			contained = true;
		} else {
			if (breadcrumbSecond.getText().contains(textNew)) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + textNew + "!",
				contained);
	}

	public void clickOnDataAndForecastingBreadcrumb() {
		waitABit(3000);
		if (getDriver().findElements(By.cssSelector("div.well.no-background")).size() == 1) {
			System.out
					.println("No table/chart on page!!/already verified this!");
		} else if(getDriver().findElements(By.cssSelector("a.btn.btn-small.explore-data")).size() == 1){
			getDriver().findElement(
					By.cssSelector("ul.breadcrumb > li:nth-child(3) > a"))
					.click();
		}
	}

	public void verifyRatingsRedirectioningLink(String text) {
		ratingsLink.click();
		waitABit(5000);
		verifyBreadCrumb(text);
		waitABit(3000);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
	}

	public void verifyOperationalRiskLink(String textNew) {
		operationalLink.click();
		waitABit(5000);
		verifyBreadCrumbRatings(textNew);
		waitABit(3000);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
	}

	public void verifyCountryRiskLink(String textNew) {
		countryRiskLink.click();
		verifyBreadCrumbRatings(textNew);
		waitABit(3000);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
	}

	public void verifySecurityLink(String textNew) {
		securityLink.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyProjectFinanceLink(String textNew) {
		projectFinanceLink.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyAutosLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(1) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(1) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyCommercialLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(2) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(2) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyConsumerLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(3) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(3) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyFoodAndDrinkLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(4) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(4) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyInfoTechLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(5) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(5) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyInfrastructureLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(6) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(1) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyInsuranceLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(7) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(2) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyMedicalDevicesLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(7) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(3) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyMiningLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(8) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(4) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyPetrochemicalsLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(1) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(4) > li:nth-child(1) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyPharmaLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(2) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(4) > li:nth-child(2) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyPowerLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(3) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(4) > li:nth-child(3) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyRealEstateLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(4) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(4) > li:nth-child(4) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyRenewablesLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(5) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(4) > li:nth-child(5) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyRetailLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(6) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(5) > li:nth-child(1) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyTelecomLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(7) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(5) > li:nth-child(2) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyTourismLink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(8) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(5) > li:nth-child(3) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyOilAndGasink(String textNew) {
		// getDriver().findElement(By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > ul:nth-child(2) > li:nth-child(9) > a")).click();
		getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(5) > article > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div > ul:nth-child(3) > li:nth-child(5) > a"))
				.click();
		verifyBreadCrumbRatings(textNew);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
		waitABit(3000);
	}

	public void verifyBMIDatabaseLink(String text) {
		getDriver().findElement(
				By.cssSelector("a[href='/data/databases'] > h4")).click();
		waitABit(5000);
		verifyBreadCrumb(text);
		waitABit(3000);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
	}

	public void verifyBurdenOfDiseaseLink(String burden, String textNew) {
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#databases > div > div > div > div > ul:nth-child(1) > li:nth-child(1) > a"))
						.getText().contains(burden));
		getDriver()
				.findElement(
						By.cssSelector("div#databases > div > div > div > div > ul:nth-child(1) > li:nth-child(1) > a"))
				.click();
		waitABit(5000);
		verifyBreadCrumbRatings(textNew);
		waitABit(3000);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
	}

	public void verifyMedicalDistributorsGuideLink(String mdg, String textNew) {
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#databases > div > div > div > div > ul:nth-child(2) > li:nth-child(3) > a"))
						.getText().contains(mdg));
		getDriver()
				.findElement(
						By.cssSelector("div#databases > div > div > div > div > ul:nth-child(2) > li:nth-child(3) > a"))
				.click();
		waitABit(5000);
		verifyBreadCrumbRatings(textNew);
		waitABit(3000);
		dataAndForecastingTab.click();
	}

	public void verifyExecutiveLink(String executive, String text) {
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#databases > div > div > div > div > ul:nth-child(1) > li:nth-child(2) > a"))
						.getText().contains(executive));
		getDriver()
				.findElement(
						By.cssSelector("div#databases > div > div > div > div > ul:nth-child(1) > li:nth-child(2) > a"))
				.click();
		waitABit(5000);
		verifyBreadCrumbForCountryRisk(text);
		waitABit(3000);
		getDriver().findElement(
				By.cssSelector("ul#pillars > li:nth-child(3) > a > h4"))
				.click();
	}

	public void verifyGLobalLink(String globalMin, String textNew) {
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#databases > div > div > div > div > ul:nth-child(1) > li:nth-child(3) > a"))
						.getText().contains(globalMin));
		getDriver()
				.findElement(
						By.cssSelector("div#databases > div > div > div > div > ul:nth-child(1) > li:nth-child(3) > a"))
				.click();
		waitABit(5000);
		verifyBreadCrumbRatings(textNew);
		waitABit(3000);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
	}

	public void verifyGLobalRefinLink(String globalRef, String textNew) {
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#databases > div > div > div > div > ul:nth-child(2) > li:nth-child(1) > a"))
						.getText().contains(globalRef));
		getDriver()
				.findElement(
						By.cssSelector("div#databases > div > div > div > div > ul:nth-child(2) > li:nth-child(1) > a"))
				.click();
		waitABit(5000);
		verifyBreadCrumbRatings(textNew);
		waitABit(3000);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
	}

	public void verifyInfrastructureLink(String infraKey, String textNew) {
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#databases > div > div > div > div > ul:nth-child(2) > li:nth-child(2) > a"))
						.getText().contains(infraKey));
		getDriver()
				.findElement(
						By.cssSelector("div#databases > div > div > div > div > ul:nth-child(2) > li:nth-child(2) > a"))
				.click();
		waitABit(5000);
		verifyBreadCrumbRatings(textNew);
		waitABit(3000);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
	}

	public void verifyMobileLink(String mobile, String textNew) {
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#databases > div > div > div > div > ul:nth-child(2) > li:nth-child(4) > a"))
						.getText().contains(mobile));
		getDriver()
				.findElement(
						By.cssSelector("div#databases > div > div > div > div > ul:nth-child(2) > li:nth-child(4) > a"))
				.click();
		waitABit(5000);
		verifyBreadCrumbRatings(textNew);
		waitABit(3000);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
	}

	public void verifyPowerLink(String powerKey, String textNew) {
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#databases > div > div > div > div > ul:nth-child(3) > li:nth-child(1) > a"))
						.getText().contains(powerKey));
		getDriver()
				.findElement(
						By.cssSelector("div#databases > div > div > div > div > ul:nth-child(3) > li:nth-child(1) > a"))
				.click();
		waitABit(5000);
		verifyBreadCrumbRatings(textNew);
		waitABit(3000);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
	}

	public void verifyFeedInTariffsLink(String feed, String textNew) {
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#databases > div > div > div > div > ul:nth-child(3) > li:nth-child(2) > a"))
						.getText().contains(feed));
		getDriver()
				.findElement(
						By.cssSelector("div#databases > div > div > div > div > ul:nth-child(3) > li:nth-child(2) > a"))
				.click();
		waitABit(5000);
		verifyBreadCrumbRatings(textNew);
		waitABit(3000);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
	}

	public void verifyRenewableKeyLink(String renewKey, String textNew) {
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#databases > div > div > div > div > ul:nth-child(3) > li:nth-child(3) > a"))
						.getText().contains(renewKey));
		getDriver()
				.findElement(
						By.cssSelector("div#databases > div > div > div > div > ul:nth-child(3) > li:nth-child(3) > a"))
				.click();
		waitABit(5000);
		verifyBreadCrumbRatings(textNew);
		waitABit(3000);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
	}

	public void verifyUpstreamLink(String upstream, String textNew) {
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#databases > div > div > div > div > ul:nth-child(3) > li:nth-child(4) > a"))
						.getText().contains(upstream));
		getDriver()
				.findElement(
						By.cssSelector("div#databases > div > div > div > div > ul:nth-child(3) > li:nth-child(4) > a"))
				.click();
		waitABit(5000);
		verifyBreadCrumbRatings(textNew);
		waitABit(3000);
		getDriver().findElement(
				By.cssSelector("ul.breadcrumb > li:nth-child(3) > a")).click();
	}

	public void downloadAndVerifyGeneralDvPack(String extension1,
			String extension2) {
		waitUntilElementExists(By.cssSelector("button#filter-download-data"),
				20);
		elementClick("button#filter-download-data");
		waitABit(3000);
		saveImageHandle2();
		waitABit(3000);
		FileChecker file = new FileChecker();
		if (getDriver()
				.findElement(By.cssSelector("ul.breadcrumb > li.active"))
				.getText().contains("Data Tool")
				|| getDriver()
						.findElement(
								By.cssSelector("ul.breadcrumb > li:nth-child(4)"))
						.getText().contains("BMI Databases")) {
			file.verifyExtentionExcelFileForGeneralDvPack(extension1);
		} else {
			file.verifyExtentionExcelFileForGeneralDvPack(extension2);
		}
	}
}
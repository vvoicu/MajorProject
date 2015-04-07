package bmo5.bmo5tests.bmo.pages.homepage;

import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class FilterPanelDailyAnalysisPage extends AbstractPage {

	@FindBy(css = "div.sidebar.well ul:nth-child(2)  li h5")
	private WebElement clickServicePanel;

	@FindBy(css = "ul.nav.nav-list.dropdown-list.show")
	private WebElement selectServicePanel;

	@FindBy(css = "div.media-listing")
	private WebElement selectArticleList;

	@FindBy(css = "ul.nav.nav-list.dropdown-list.show")
	private WebElement selectGeographyPanel;

	@FindBy(css = "ul.breadcrumb > li:nth-child(2)")
	private WebElement breadcrumbFirst;

	@FindBy(css = "ul.breadcrumb > li:nth-child(3) > a")
	private WebElement breadcrumbServPivot;

	@FindBy(css = "ul.breadcrumb > li:nth-child(6)")
	private WebElement breadcrumbLast;

	@FindBy(css = "ul.breadcrumb li:nth-child(2) a")
	private WebElement clickHome;

	@FindBy(css = "div.media-actions div:nth-child(2) a")
	private WebElement clickPreviewArticle;

	@FindBy(css = "div.btn-toolbar.pull-left > a")
	private WebElement backPreviousPage;

	@FindBy(css = "a.btn.btn-tall")
	private WebElement clickReadMore;

	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li:nth-child(3) > div > ul")
	private WebElement selectGeographyFromPanel;

	@FindBy(css = "div.btn-group.saved-data > button:nth-child(1)")
	private WebElement saveViewButton;

	@FindBy(css = "div.container-fluid > section:nth-child(6) > div > div:nth-child(2) > a > i.icon-c-floppy")
	// div.page-wrap > div:nth-child(1) > section:nth-child(6) >
	// div:nth-child(1) > div > div:nth-child(2) >
	// a:nth-child(1)")//div.btn-group.btn-toolbar.pull-right > a:nth-child(2) > i")
	private WebElement saveArticleDetail;

	@FindBy(css = "div#permission-enterprise-user > div:nth-child(1) > p > strong")
	private WebElement enterpriseMessageForSavePopUp;

	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li:nth-child(3) > div > ul")
	private WebElement selectServiceFromPanel;

	@FindBy(css = "ul.nav.nav-list.dropdown-list.show > li:nth-child(1) > input")
	private WebElement textAreaServiceFilter;

	public void clickOnSaveView(String saveView) {
		Assert.assertTrue(
				"not found!!!",
				getDriver()
						.findElement(
								By.cssSelector("div.btn-group.saved-data > button:nth-child(1)"))
						.getText().contains(saveView));
		saveViewButton.click();
		waitABit(5000);
		int ran;
		ran = 100 + (int) (Math.random() * ((10000 - 100) + 1));
		getDriver().findElement(By.cssSelector("input#saved_view_name"))
				.sendKeys("view" + ran);
		waitABit(5000);
		getDriver().findElement(By.cssSelector("button#save-view")).click();
		waitABit(10000);
	}

	public void saveMessageConfirmation() {
		element(
				getDriver().findElement(
						By.cssSelector("div.alert.alert-success")))
				.waitUntilPresent();
		Assert.assertTrue(getDriver().findElement(
				By.cssSelector("div.alert.alert-success")).isDisplayed());
	}

	public void clickSaveViewForIpLogin() {
		getDriver().findElement(By.cssSelector("div.btn.btn-link")).click();
		waitABit(5000);
		getDriver()
				.findElement(
						By.cssSelector("div#permission-enterprise-user > div:nth-child(2) > button"))
				.click();
	}

	public void clickBackPreviousButton() {
		backPreviousPage.click();
	}

	public void clickServicePanel() {
		clickServicePanel.click();
	}

	public void clickHome(String home) {
		Assert.assertTrue(getDriver()
				.findElement(By.cssSelector("a[href='/home']")).getText()
				.contains(home));
		clickHome.click();
	}

	public void clickOnPreviewArticle() {
		clickPreviewArticle.click();
	}

	public void clickReadMore() {
		waitABit(20000);
		clickReadMore.click();
	}

	public void verifyBackPreviousPage() {
		// Assert.assertTrue("Not found!",
		// getDriver().findElement(By.cssSelector("div.btn-toolbar.pull-left > a ")).getText().contains("« Back to previous page "));
		getDriver().findElement(
				By.cssSelector("a[href='javascript:history.back()']")).click();// "div.container-fluid > section:nth-child(6) > div > div:nth-child(1) > a")).click();

	}

	public void selectRegion(String region) {
		element(selectGeographyFromPanel).waitUntilVisible();
		WebElement element = selectGeographyFromPanel.findElement(By
				.cssSelector("label[title='" + region + "']"));
		element(element).click();
		waitABit(4000);
		Assert.assertTrue(element.getText().contains(region));

	}

	public void verifyBreadcrumbServicePivot(String text) {
		boolean contained = false;
		if (text.contains(breadcrumbServPivot.getText())) {
			contained = true;
		} else {
			if (text.contains(breadcrumbFirst.getText())) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}

	public void clickAnArticle(final String value) {
		List<WebElement> options = selectArticleList.findElements(By
				.cssSelector(" div div h5.media-heading "));

		for (WebElement option : options) {
			if (value.equals(option.getText())) {
				option.click();
				break;
			}
		}
	}

	public int countLatestNewsArticles() {
		int articles = 0;
		articles = getDriver().findElements(
				By.cssSelector("div.media-listing > div")).size();
		return articles;
	}

	public String clickArticle(int articleNumber) {
		int articles = countLatestNewsArticles();
		String articleTitle = "";
		if (articles > 0 && articleNumber <= articles) {
			articleTitle = getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1) > h5 > a")).getText();
			getDriver().findElement(By.cssSelector("div.media-listing > div:nth-child(" + articleNumber + ") > div:nth-child(1) > h5 > a")).click();
		}
		return articleTitle;
	}

	public void clickOnPreviewArticle(int articleNumber) {
		waitUntilElementExists(By.cssSelector("div.media-listing > div"), 20);
		int numberOfArticlesDisplayed = getDriver().findElements(
				By.cssSelector("div.media-listing > div")).size();
		if (numberOfArticlesDisplayed > 0) {
			if (articleNumber <= numberOfArticlesDisplayed && articleNumber > 0) {
				// getDriver()
				// .findElement(
				// By.cssSelector("div.media-listing > div:nth-child("
				// + articleNumber
				// +
				// ") > div:nth-child(1) > div:nth-of-type(1) > span:nth-of-type(1)"))
				// .click();
				elementClick("div.media-listing > div:nth-child("
						+ articleNumber
						+ ") > div:nth-child(2) > div:nth-child(2) > a");
			} else {
				System.out
						.println("There aren't so many articles displayed in Daily Analysis so clicking the first article");
				elementClick("div.media-listing > div:nth-child(1) > div:nth-child(1) > div:nth-of-type(1) > span:nth-of-type(1)");
				elementClick("div.media-listing > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > a");
			}
		} else {
			System.out
					.println("There aren't any articles in Daily Analysis Page");
		}
	}

	public void verifyPreviewMediaActions() {
		waitABit(5000);
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div#media-preview-container > div:nth-child(2) > section > div > div:nth-child(1) > div > a:nth-child(1) "))
				.isDisplayed());
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div#media-preview-container > div:nth-child(2) > section > div > div:nth-child(1) > div > a:nth-child(2) "))
				.isDisplayed());
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div#media-preview-container > div:nth-child(2) > section > div > div:nth-child(1) > div > a:nth-child(3) "))
				.isDisplayed());
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div#media-preview-container > div:nth-child(2) > section > div > div:nth-child(1) > div > a:nth-child(4) "))
				.isDisplayed());
		waitABit(3000);
	}

	public void clickOnTags() {
		getDriver()
				.findElement(
						By.cssSelector("div#the-content-container > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span"))
				.click();
	}

	public void selectTags(int articleNumber) {
		// element(getDriver().findElement(By.cssSelector("div#the-content-container > div:nth-child(4) > div:nth-child("+articleNumber+") > div > div.tags "))).waitUntilPresent();
		element(
				getDriver()
						.findElement(
								By.cssSelector("div#the-content-container > div:nth-child(3) > div:nth-child("
										+ articleNumber + ") > div > div.tags ")))
				.click();
		System.out.println("done!");
	}

	public void verifyOnHoveredeArticleMediaActios(int articleNumber) {
		Actions tag = new Actions(getDriver());
		tag.moveToElement(
				getDriver()
						.findElement(
								By.cssSelector("div#the-content-container > div:nth-child(3) > div:nth-child("
										+ articleNumber + ") > div > div.tags ")))
				.build().perform();
		waitABit(3000);
		// element(getDriver().findElement(By.cssSelector("div#the-content-container > div:nth-child(3) > div:nth-child("+articleNumber+") > div > div.tags "))).click();
		element(
				getDriver()
						.findElement(
								By.cssSelector("div.media-listing > div:nth-child("
										+ articleNumber
										+ ") > div:nth-child(2) > div > a > i.icon-c-download")))
				.waitUntilPresent();
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div.media-listing > div:nth-child("
								+ articleNumber
								+ ") > div:nth-child(2) > div > a > i.icon-c-download"))
				.isDisplayed());
		System.out.println("verified!");
		Assert.assertTrue(getDriver().findElement(
				By.cssSelector("div.media-listing > div:nth-child("
						+ articleNumber
						+ ") > div:nth-child(2) > div > a > i.icon-c-print"))
				.isDisplayed());
		System.out.println("verified!");
		Assert.assertTrue(getDriver().findElement(
				By.cssSelector("div.media-listing > div:nth-child("
						+ articleNumber
						+ ") > div:nth-child(2) > div > a > i.icon-c-email"))
				.isDisplayed());
		System.out.println("verified!");

	}

	public void saveArticleAfterHover() {
		element(
				getDriver()
						.findElement(
								By.cssSelector("div#the-content-container > div:nth-child(3)> div:nth-child(1) > div:nth-child(1) > div.tags")))
				.waitUntilPresent();
		element(
				getDriver()
						.findElement(
								By.cssSelector("div#the-content-container > div:nth-child(3)> div:nth-child(1) > div:nth-child(1) > div.tags")))
				.click();
		element(
				getDriver()
						.findElement(
								By.cssSelector("div#the-content-container > div:nth-child(3)> div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a > i.icon-c-floppy")))
				.click();
		waitABit(5000);
		element(enterpriseMessageForSavePopUp).waitUntilVisible();
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#permission-enterprise-user > div:nth-child(1) > p > strong"))
						.getText()
						.contains(
								"Please login with your child account credentials in order to be able to save content. If you do not have a child account, please create one from My BMI"));
		getDriver()
				.findElement(
						By.cssSelector("div#permission-enterprise-user > div:nth-child(2) > button"))
				.click();

	}

	public void cancelEnteprisePopUpWindow() {
		waitABit(3000);
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#permission-enterprise-user > div:nth-child(1) > p > strong"))
						.getText()
						.contains(
								"Please login with your child account credentials in order to be able to save content. If you do not have a child account, please create one from My BMI"));
		getDriver()
				.findElement(
						By.cssSelector("div#permission-enterprise-user > div:nth-child(2) > button"))
				.click();
	}

	public void saveFromPreviewArticle() {
		waitABit(5000);
		getDriver()
				.findElement(
						By.cssSelector("div#js-overflow > section > div > div:nth-child(1)  > div > a > i.icon-c-floppy"))
				.click();
		waitABit(5000);
		// element(enterpriseMessageForSavePopUp).waitUntilVisible();
		// Assert.assertTrue("not found!",getDriver().findElement(By.cssSelector("div#permission-enterprise-user > div:nth-child(1) > p > strong")).getText().contains("Please login with your child account credentials in order to be able to save content. If you do not have a child account, please create one from My BMI"));
		getDriver()
				.findElement(
						By.cssSelector("div#permission-enterprise-user > div:nth-child(2) > button"))
				.click();
		waitABit(25000);
	}

	public void verifyMediaActionsFromPreview() {
		waitABit(7000);
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div.btn-group.pull-right > a > i.icon-c-download"))
				.isDisplayed());
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div.btn-group.pull-right > a > i.icon-c-print"))
				.isDisplayed());
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div.btn-group.pull-right > a > i.icon-c-email"))
				.isDisplayed());
	}

	public void verifyBreadCrumb(String text) {
		boolean contained = false;
		if (text.contains(breadcrumbLast.getText())) {
			contained = true;
		} else {
			if (text.contains(breadcrumbFirst.getText())) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}

	public void saveArticleDetail() {
		waitABit(5000);
		saveArticleDetail.click();
		element(enterpriseMessageForSavePopUp).waitUntilVisible();
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#permission-enterprise-user > div:nth-child(1) > p > strong"))
						.getText()
						.contains(
								"Please login with your child account credentials in order to be able to save content. If you do not have a child account, please create one from My BMI"));
		waitABit(5000);
		getDriver()
				.findElement(
						By.cssSelector("div#permission-enterprise-user > div:nth-child(2) > button"))
				.click();
	}

	public void saveArticleDetailReports() {
		waitABit(5000);
		getDriver()
				.findElement(
						By.cssSelector("div.page-wrap > div:nth-child(1) > section:nth-child(6) > div:nth-child(1) > div:nth-child(2) > a > i.icon-c-floppy"))
				.click();
		element(enterpriseMessageForSavePopUp).waitUntilVisible();
		Assert.assertTrue(
				"not found!",
				getDriver()
						.findElement(
								By.cssSelector("div#permission-enterprise-user > div:nth-child(1) > p > strong"))
						.getText()
						.contains(
								"Please login with your child account credentials in order to be able to save content. If you do not have a child account, please create one from My BMI"));
		waitABit(5000);
		getDriver()
				.findElement(
						By.cssSelector("div#permission-enterprise-user > div:nth-child(2) > button"))
				.click();
	}

	public void verifyArticleViewMediaActions() {
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(6) > div > div:nth-child(2)  > a > i.icon-c-download"))
				.isDisplayed());
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(6) > div > div:nth-child(2)  > a > i.icon-c-print"))
				.isDisplayed());
		Assert.assertTrue(getDriver()
				.findElement(
						By.cssSelector("div.container-fluid > section:nth-child(6) > div > div:nth-child(2)  > a > i.icon-c-email"))
				.isDisplayed());
	}

	public void verifyFilterSelection(String region) {
		if (getDriver()
				.findElements(
						By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > div > ul > li > label > div > span.checked"))
				.size() == 1) {
			System.out
					.println("Verifying the selected elements from filter...");
			Assert.assertTrue(getDriver()
					.findElement(
							By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > div > ul > li > label > div > span.checked"))
					.isDisplayed());
			Assert.assertTrue(getDriver().findElement(
					By.cssSelector("a#filter-clear")).isDisplayed());
			WebElement element = selectGeographyFromPanel.findElement(By
					.cssSelector("label[title='" + region + "']"));
			waitABit(4000);
			Assert.assertTrue(element.getText().contains(region));
		} else {
			System.out.println("There is no selection made in filter!!!");
		}
	}

	public void verifyFilterSelectionService(String service) {
		if (getDriver()
				.findElements(
						By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > div > ul > li > label > div > span.checked"))
				.size() == 1) {
			System.out
					.println("Verifying the selected elements from filter...");
			Assert.assertTrue(getDriver()
					.findElement(
							By.cssSelector("div.sidebar.well > ul > li:nth-child(3) > div > ul > li > label > div > span.checked"))
					.isDisplayed());
			Assert.assertTrue(getDriver().findElement(
					By.cssSelector("a#filter-clear")).isDisplayed());
			element(textAreaServiceFilter).waitUntilVisible();
			// textAreaServiceFilter.sendKeys(service);
			waitABit(5000);
			// element(element).click();
			WebElement element = selectServiceFromPanel.findElement(By
					.cssSelector("label[title='" + service + "']"));
			// element(element).click();
			Assert.assertTrue(element.getText().contains(service));

		} else {
			System.out.println("There is no selection made in filter!!!");
		}
	}
}

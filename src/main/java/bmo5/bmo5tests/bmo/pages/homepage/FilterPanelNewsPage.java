package bmo5.bmo5tests.bmo.pages.homepage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import bmo5.bmo5tests.tools.NavigationItems;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class FilterPanelNewsPage extends AbstractPage {

	@FindBy(css = "ul.nav.nav-list.dropdown-list.show")
	private WebElement geography;

	@FindBy(css = "	ul.nav.nav-list.dropdown-list.show > li.quick-search > input")
	private WebElement geographySearch;

	@FindBy(css = "div.media-listing")
	private WebElement selectArticleList;

	@FindBy(css = "")
	private WebElement clickArticleButtons;

	@FindBy(css = "a[href ='javascript:history.back()']")
	private WebElement backtoPreviousArticle;

	@FindBy(css = "div#the-content-container  div.paginaxor.pagination-listing.pagination.pagination-small.pagination-centered:nth-child(4)")
	private WebElement navigationContainer;
	@FindBy(css = "article.span8.offset1 div.paginaxor.pagination-listing.pagination.pagination-small.pagination-centered")
	private WebElement navigationContainerMdg;

	@FindBy(css = "div#the-content-container div[class = 'paginaxor pagination-listing pagination pagination-small  pagination-centered'] ")
	private WebElement navigationContainerReports;

	@FindBy(css="div[class='paginaxor pagination-listing pagination pagination-small pagination-right pull-right'] > ul > li")
	@CacheLookup
	private WebElement topNavigationContainerLibrary;

	@FindBy(css = "div.media-listing > div:nth-child(1) > div:nth-child(1) > h5 > a")
	private WebElement selectFirstArticleFromList;

	public void chooseRegion() {
		geography.click();
	}

	public void clickFirstArticleTitleFromList() {
		//element(selectFirstArticleFromList).waitUntilVisible();
		selectFirstArticleFromList.click();
		waitABit(5000);
	}
	public void clickArticle() {
		selectArticleList.click();
	}

	public void verifyPreviousArticlebutton() {
		Assert.assertTrue("not found!", backtoPreviousArticle.isDisplayed());
		backtoPreviousArticle.click();
	}

	public void clickArticleButtons(String value) {
		element(clickArticleButtons).waitUntilVisible();
		List<WebElement> options = clickArticleButtons.findElements(By
				.cssSelector("div a i"));

		for (WebElement option : options) {
			if (value.equals(option.getText())) {
				option.click();
				waitABit(10000);
				break;
			}
		}
	}

	public void selectRegion(final String value) {
		geographySearch.sendKeys("Asia");
		element(geography).waitUntilVisible();
		List<WebElement> options = geography.findElements(By.tagName("label"));

		for (WebElement option : options) {
			if (value.equals(option.getText())) {
				option.click();
				waitABit(10000);
				break;
			}
		}
	}

	public void navigateToItem(NavigationItems goTo) {
		element(navigationContainer).waitUntilVisible();
		String hrefPrefix = getDriver().getCurrentUrl();

		List<WebElement> listItems = navigationContainer.findElements(By
				.cssSelector("li a"));
		WebElement initialState = navigationContainer.findElement(By
				.cssSelector("li.active a"));
		for (WebElement elementNow : listItems) {
			if (goTo.getCode().contains(initialState.getAttribute("data-page"))) {
				System.out.println("Element is already active");
				break;
			} else if (elementNow.getAttribute("href").contentEquals(
					hrefPrefix + "#")) {
				String elementClass = elementNow.findElement(
						By.cssSelector("i")).getAttribute("class");
				System.out.println("");
				if (elementClass.contains(goTo.getCode())) {
					elementNow.click();
					System.out.println("The page is displayed");
					break;
				}
			} else {
				if (goTo.getCode().contains(
						elementNow.getAttribute("data-page"))) {
					elementNow.click();
					System.out.println(" final ");
					break;
				}
			}
		}
	}


	public void navigateToItemMdg(NavigationItems goTo) {
		element(navigationContainerMdg).waitUntilVisible();
		String hrefPrefix = getDriver().getCurrentUrl();

		List<WebElement> listItems = navigationContainerMdg.findElements(By
				.cssSelector("li a"));
		WebElement initialState = navigationContainerMdg.findElement(By
				.cssSelector("li.active a"));
		for (WebElement elementNow : listItems) {
			if (goTo.getCode().contains(initialState.getAttribute("data-page"))) {
				System.out.println("Element is already active");
				break;
			} else if (elementNow.getAttribute("href").contentEquals(
					hrefPrefix + "#")) {
				String elementClass = elementNow.findElement(
						By.cssSelector("i")).getAttribute("class");
				System.out.println("");
				if (elementClass.contains(goTo.getCode())) {
					elementNow.click();
					System.out.println("The page is displayed");
					break;
				}
			} else {
				if (goTo.getCode().contains(
						elementNow.getAttribute("data-page"))) {
					elementNow.click();
					System.out.println(" final ");
					break;
				}
			}
		}
	}
	public int countLatestNewsArticles() {
		int articles = 0;
		articles = getDriver().findElements(
				By.cssSelector("div.media-listing.border-top > div")).size();
		return articles;
	}

	public String clickLatestNewsArticle(int articleNumber) {
		int articles = countLatestNewsArticles();
		String articleTitle = "";
		if (articles > 0 && articleNumber <= articles) {
			articleTitle = getDriver()
					.findElement(
							By.cssSelector("div.media-listing.border-top > div:nth-child("
									+ articleNumber
									+ ") > div:nth-child(1) > h4 > a"))
									.getText();
			getDriver()
			.findElement(
					By.cssSelector("div.media-listing.border-top > div:nth-child("
							+ articleNumber
							+ ") > div:nth-child(2) > h4 > a")).click();
		}
		return articleTitle;
	}

	public void selectItemsPerPage(String value) {
		selectFromDropdown(getDriver().findElement(By.cssSelector("select.span1.input-pagination")), value);
		waitABit(6000);
		getDriver().findElement(By.cssSelector("select.span1.input-pagination ")).click();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("select.span1.input-pagination")).getAttribute("value").contains(value));
	}

	public void navigateToItemReports(NavigationItems goTo) {

		waitUntilElementDoesntExist(By.cssSelector("div.media-listing.loading"),50);

		element(navigationContainerReports).waitUntilVisible();
		String hrefPrefix = getDriver().getCurrentUrl();

		List<WebElement> listItems = navigationContainerReports.findElements(By
				.cssSelector("li a"));
		WebElement initialState = navigationContainerReports.findElement(By
				.cssSelector("li.active a"));
		for (WebElement elementNow : listItems) {
			if (goTo.getCode().contains(initialState.getAttribute("data-page"))) {
				System.out.println("Element is already active");
				break;
			} else if (elementNow.getAttribute("href").contentEquals(
					hrefPrefix + "#")) {
				String elementClass = elementNow.findElement(
						By.cssSelector("i")).getAttribute("class");
				System.out.println("");
				if (elementClass.contains(goTo.getCode())) {
					elementNow.click();
					System.out.println("The page is displayed");
					break;
				}
			} else {
				if (goTo.getCode().contains(
						elementNow.getAttribute("data-page"))) {
					elementNow.click();
					System.out.println(" final ");
					break;
				}
			}
		}
	}

	public void waitUntilElementDoesntExist(By by, int waitSeconds) {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		boolean elementPresent = false;
		for (int i = 0; i < waitSeconds; i++) {
			try {
				waitABit(1000);
				getDriver().findElement(by);
				elementPresent = true;
			} catch (Exception e) {
				getDriver().manage().timeouts()
				.implicitlyWait(30, TimeUnit.SECONDS);
				elementPresent = false;
				break;
			}
		}
		Assert.assertFalse("The element did not disappear after "
				+ waitSeconds + " seconds!", elementPresent);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}

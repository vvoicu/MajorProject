package bmo5.bmo5tests.bmo.pages.homepage;

import java.io.IOException;
import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.NavigationEnum;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class SpecialReportsPage extends AbstractPage {

	@FindBy(id = "latest-articles-pagination")
	private WebElement navigationContainer;

	@FindBy(css = "div.navbar-inner ul:last-child li:nth-child(2) a[data-toggle='dropdown']")
	private WebElement specialReportsup;

	@FindBy(css = "a[href='/sar/reports/special']" )
	private WebElement specialReportsViewall;

	@FindBy(css = "div#latest-articles-pagination")
	private WebElement searchResultsNavigationContainer;

	@FindBy(css = "div#latest-articles-pagination")
	private WebElement navigationContainerPDFUser;

	@FindBy(css = "div.page-wrap >div > section:nth-child(2) > div > nav > div > ul:nth-child(2) > li:nth-child(2) > ul > li > ul")
	private WebElement dropdownSpecialReports;

	@FindBy (css = "div#js-overflow > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > a.btn.btn-tall")
	private WebElement readMoreButton;

	@FindBy(id = "back-button")
	private WebElement backToPreviousButton;

	@FindBy(css = "div.btn-group.btn-toolbar.pull-right > a:nth-child(1) ")
	private WebElement downloadButton;
	
	@FindBy(css = "div.btn-group.btn-toolbar.pull-right > a:nth-child(2) ")
	private WebElement saveButton;
	
	@FindBy(css = "div.btn-group.btn-toolbar.pull-right > a:nth-child(3) ")
	private WebElement printButton;
	
	@FindBy(css = "div.btn-group.btn-toolbar.pull-right > a:nth-child(4) ")
	private WebElement emailButton;
	
	
	private void goThroughList(NavigationEnum goTo) {
		List<WebElement> itemsList = navigationContainer.findElements(By
				.cssSelector("li.numbers"));

		for (WebElement itemNow : itemsList) {

			String valueNow = itemNow.findElement(By.cssSelector("input"))
					.getAttribute("value");
			System.out.println(valueNow);
			System.out.println(goTo.getCode());
			if (valueNow.contains(goTo.getCode())) {
				itemNow.findElement(By.cssSelector("a")).click();
				waitABit(5000);
				break;
			}
		}
	}

	public void navigateToItem(NavigationEnum goTo) {
		element(navigationContainer).waitUntilVisible();

		WebElement initialState = navigationContainer.findElement(By
				.cssSelector("li.active input"));

		if (goTo.getCode().contains(initialState.getAttribute("value"))) {
			System.out.println("Element is already active");
		} else {
			String valueFirst = navigationContainer.findElement(
					By.cssSelector("li:first-child")).getAttribute("class");

			if (goTo.getCode().contains(NavigationEnum.First.getCode())
					| goTo.getCode()
					.contains(NavigationEnum.Previous.getCode())
					&& valueFirst.contains(NavigationEnum.First.getCode())) {
				navigationContainer.findElement(
						By.cssSelector("li." + goTo.getCode() + " a")).click();

			} else{

				if (goTo.getCode().contains(NavigationEnum.First.getCode())
						| goTo.getCode()
						.contains(NavigationEnum.Next.getCode())
						&& valueFirst.contains(NavigationEnum.First.getCode())) {
					navigationContainer.findElement(
							By.cssSelector("li." + goTo.getCode() + " a")).click();

				}else 
				{
					if (goTo.getCode().contains(NavigationEnum.First.getCode())
							| goTo.getCode()
							.contains(NavigationEnum.Last.getCode())
							&& valueFirst.contains(NavigationEnum.First.getCode())) {
						navigationContainer.findElement(
								By.cssSelector("li." + goTo.getCode() + " a")).click();

					}


					else {
						goThroughList(goTo);
					}

				}
			}
		}
	}

	public void navigateToItemSearchResultsPage(NavigationEnum goTo) {
		element(searchResultsNavigationContainer).waitUntilVisible();

		WebElement initialState = searchResultsNavigationContainer.findElement(By
				.cssSelector("li.active input"));

		if (goTo.getCode().contains(initialState.getAttribute("value"))) {
			System.out.println("Element is already active");
		} else {
			String valueFirst = searchResultsNavigationContainer.findElement(
					By.cssSelector("li:first-child")).getAttribute("class");

			if (goTo.getCode().contains(NavigationEnum.First.getCode())
					| goTo.getCode()
					.contains(NavigationEnum.Previous.getCode())
					&& valueFirst.contains(NavigationEnum.First.getCode())) {
				searchResultsNavigationContainer.findElement(
						By.cssSelector("li." + goTo.getCode() + " a")).click();

			} else{

				if (goTo.getCode().contains(NavigationEnum.First.getCode())
						| goTo.getCode()
						.contains(NavigationEnum.Next.getCode())
						&& valueFirst.contains(NavigationEnum.First.getCode())) {
					searchResultsNavigationContainer.findElement(
							By.cssSelector("li." + goTo.getCode() + " a")).click();

				}else 
				{
					if (goTo.getCode().contains(NavigationEnum.First.getCode())
							| goTo.getCode()
							.contains(NavigationEnum.Last.getCode())
							&& valueFirst.contains(NavigationEnum.First.getCode())) {
						searchResultsNavigationContainer.findElement(
								By.cssSelector("li." + goTo.getCode() + " a")).click();

					}


					else {
						goThroughList(goTo);
					}

				}
			}
		}
	}

	public void navigateToItemPDFUser(NavigationEnum goTo) {
		element(navigationContainerPDFUser).waitUntilVisible();

		WebElement initialState = navigationContainerPDFUser.findElement(By
				.cssSelector("li.active input"));

		if (goTo.getCode().contains(initialState.getAttribute("value"))) {
			System.out.println("Element is already active");
		} else {
			String valueFirst = navigationContainerPDFUser.findElement(
					By.cssSelector("li:first-child")).getAttribute("class");

			if (goTo.getCode().contains(NavigationEnum.First.getCode())
					| goTo.getCode()
					.contains(NavigationEnum.Previous.getCode())
					&& valueFirst.contains(NavigationEnum.First.getCode())) {
				navigationContainerPDFUser.findElement(
						By.cssSelector("li." + goTo.getCode() + " a")).click();

			} else{

				if (goTo.getCode().contains(NavigationEnum.First.getCode())
						| goTo.getCode()
						.contains(NavigationEnum.Next.getCode())
						&& valueFirst.contains(NavigationEnum.First.getCode())) {
					navigationContainerPDFUser.findElement(
							By.cssSelector("li." + goTo.getCode() + " a")).click();

				}else 
				{
					if (goTo.getCode().contains(NavigationEnum.First.getCode())
							| goTo.getCode()
							.contains(NavigationEnum.Last.getCode())
							&& valueFirst.contains(NavigationEnum.First.getCode())) {
						navigationContainerPDFUser.findElement(
								By.cssSelector("li." + goTo.getCode() + " a")).click();

					}


					else {
						goThroughList(goTo);
					}

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
			articleTitle = getDriver().findElement(By.cssSelector("div.media-listing.border-top > div:nth-child("+ articleNumber + ") > ul:nth-child(1) > h4 > a")).getText();
			getDriver().findElement(By.cssSelector("div.media-listing.border-top > div:nth-child("+ articleNumber + ") > ul:nth-child(2) > h4 > a")).click();
		}
		return articleTitle;
	}



	public void selectItemsPerPage(String value) {
		Select itemsPerPage = new Select(getDriver().findElement(By.cssSelector("select.span1.input-pagination")));
		itemsPerPage.selectByValue(value);
	}
	
	public void verifySelectionItemsPerPage(String value){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("select.span1.input-pagination > option[selected]")).getText().contains(value));
	}

	public void clickOnSpecialReportsup() {
		specialReportsup.click();
		specialReportsViewall.click();

	}
	public void clickOnSpecialReportsTop() {
		specialReportsup.click();
	}

	public void performDownload() {
		waitABit(2000);

		String script = "src\\test\\java\\drivers\\downloadTest.exe";
		Process p;
		try {
			p = Runtime.getRuntime().exec(script);
			p.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}


	public String selectOneReportFromDropDown(int reportNumber) {

		int reporDropdowntList = getDriver().findElements(By.cssSelector("section#fixed-header > div > nav > div > ul:nth-child(2) > li:nth-child(2) > ul")).size();
		String reportTitle ="";

		if (reporDropdowntList > 0) {
			if (reportNumber <= reporDropdowntList && reportNumber > 0) {
				reportTitle = getDriver().findElement(By.cssSelector("section#fixed-header > div > nav > div > ul:nth-child(2) > li:nth-child(2) > ul > li > ul > li:nth-child("+ reportNumber+") > a")).getText();
				getDriver().findElement(By.cssSelector("section#fixed-header > div > nav > div > ul:nth-child(2) > li:nth-child(2) > ul > li > ul > li:nth-child("+ reportNumber+") > a")).click();
			} else {
				System.out.println("There aren't so many reports displayed so clicking the first report");
				reportTitle = getDriver().findElement(By.cssSelector("section#fixed-header > div > nav > div > ul:nth-child(2) > li:nth-child(2) > ul > li > ul > li:nth-child(1) > a")).getText();
				getDriver().findElement(By.cssSelector("section#fixed-header > div > nav > div > ul:nth-child(2) > li:nth-child(2) > ul > li > ul > li:nth-child(1) > a")).click();
			}
		} else {
			System.out.println("fail, wrong number of elements found");
		}
//		waitABit(3000);
//		DataToolPage data = new DataToolPage(getDriver());
//		data.saveImageHandle2();
//		FileChecker fileChecker = new FileChecker();
//		fileChecker.verifyFileIsDownloaded1(fileChecker.convertFileName(reportTitle));
//		waitABit(3000);
		return reportTitle;
	}

	public void verifyMediaActionsFromPreview() {
		waitABit(10000);
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#js-overflow > section:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div > a:nth-child(1)")).isDisplayed());
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#js-overflow > section:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div > a:nth-child(2)")).isDisplayed());
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#js-overflow > section:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div > a:nth-child(3)")).isDisplayed());
		Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("div#js-overflow > section:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div > a:nth-child(4)")).isDisplayed());

	}

	public void accessReadButtonAndBackToPreviousButtonAndVerifyInsideActions(String readButton) {
		Assert.assertTrue("not found!!!", readMoreButton.getText().contains(readButton));
		//waitABit(3000);
		readMoreButton.click();
		waitABit(3000);
		
	}
	public void verifyActionsButtonsFromReport() {
		waitABit(5000);
		Assert.assertTrue("not found!!!", downloadButton.isDisplayed());
		Assert.assertTrue("not found!!!", saveButton.isDisplayed());
		Assert.assertTrue("not found!!!", printButton.isDisplayed());
		Assert.assertTrue("not found!!!", emailButton.isDisplayed());
		//Assert.assertTrue("not found!!!", getDriver().findElement(By.cssSelector("a#toggler")).isDisplayed());
		waitABit(5000);
		
	}
	
	public void backToPreviousPage(String backToPreviousButon) {
	waitABit(2000);
//	Assert.assertTrue("not found!!!", backToPreviousButton.getText().contains(backToPreviousButon));
//	backToPreviousButton.click();
	Assert.assertTrue(getDriver().findElement(By.cssSelector("a#back-button")).isEnabled());
	elementClick("a#back-button");
	}
	
	public void verifyPastVersionPresenceInReport() {
		if(getDriver().findElements(By.cssSelector("a#toggler")).size() ==1) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("a#toggler")).isDisplayed());
	} else
	{
		System.out.println("There is no Past Versions option!");
	}
	}
}







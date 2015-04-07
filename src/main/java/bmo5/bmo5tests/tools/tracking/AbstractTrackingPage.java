package bmo5.bmo5tests.tools.tracking;

import java.util.concurrent.TimeUnit;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class AbstractTrackingPage extends PageObject {

	public AbstractTrackingPage(WebDriver driver) {
		super(driver);
	}

	public void navigateURL(String url) {
		getDriver().get(url);
	}
	
	public void reloadPage(){
		getDriver().navigate().refresh();
	}

	public void elementFocus(String element) {
		evaluateJavascript("var element =jQuery(' " + element
				+ " ');element.focus();");
	}

	public void elementClick(String element) {
		evaluateJavascript("$('" + element + "').click();");
	}

	public boolean verifyElementPresentAndContains(String cssSelector,
			String text) {
		try {
			if (getDriver().findElement(By.cssSelector(cssSelector)).getText()
					.contains(text)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Could not locate this element " + cssSelector);
		}
		return false;
	}

	public WebElement getElementWhenVisible(By locator, int timeoutSeconds) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
				.withTimeout(timeoutSeconds, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		return element;
	}
	
	public void mouseOverElement(String element) {
		getDriver().findElement(By.cssSelector(element)).sendKeys("");
	}

}

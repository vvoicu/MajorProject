package bmo5.bmo5tests.tools.bmo;

import java.util.concurrent.TimeUnit;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class AbstractPage extends PageObject {

	public void navigateURL(String url) {
		getDriver().get(url);
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
	
	public WebElement waitUntilElementExists(By by, int waitSeconds) {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement element = null;
		for (int i = 0; i < waitSeconds; i++)
			try {
				element = getDriver().findElement(by);
				getDriver().manage().timeouts()
						.implicitlyWait(30, TimeUnit.SECONDS);
				break;
			} catch (Exception e) {
				// no need to do anything
			}
		Assert.assertTrue("The searched element was not found after "
				+ waitSeconds + " seconds!", element != null);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return element;
	}
	
	public boolean verifyElementState(String element){
		boolean result;
		String jsScript = "var checkbox="+element+";"
			     +"var selected=false;"
			    +"if(checkbox.checked ||checkbox.indeterminate)"
			    +"selected=true;"
			    +"return selected;";
		
	    result=(boolean)evaluateJavascript(jsScript);
		System.out.println("checkbox is: "+result);
		return result;
	}
}

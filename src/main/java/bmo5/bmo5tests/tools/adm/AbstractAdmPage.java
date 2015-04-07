package bmo5.bmo5tests.tools.adm;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.thucydides.core.pages.PageObject;

import org.apache.commons.csv.CSVFormat;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.desktop.DesktopKeyboard;

import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.CsvFile;

public class AbstractAdmPage extends PageObject {

//	public AbstractAdmPage(WebDriver driver) {
//		super(driver);
//	}
	
	public void elementFocus(String element) {
		evaluateJavascript("var element =jQuery(' " + element
				+ " ');element.focus();");
	}

	public void elementClick(String element) {
		evaluateJavascript("$('" + element + "').click();");
	}

	public static String splitCamelCase(String s) {
		   return s.replaceAll(
		      String.format("%s|%s|%s",
		         "(?<=[A-Z])(?=[A-Z][a-z])",
		         "(?<=[^A-Z])(?=[A-Z])",
		         "(?<=[A-Za-z])(?=[^A-Za-z])"
		      ),
		      " "
		   );
		}
	
	
	public void reloadPage(){
		getDriver().navigate().refresh();
	}
	
	public void uploadFile(String fileName, String resourcesFolder){
		String mainWindow = getDriver().getWindowHandle();
		getDriver().switchTo().activeElement();
		System.out.println(Constants.ADM_RESOURCES_PREFIX+ resourcesFolder + fileName);
		File f = new File(Constants.ADM_RESOURCES_PREFIX+ resourcesFolder + fileName);
		
		waitABit(3000);
		Keyboard keyboard = new DesktopKeyboard();
		waitABit(1000);
        		
		try {
			keyboard.paste(f.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		keyboard.keyDown(KeyEvent.VK_ENTER);
		keyboard.keyUp(KeyEvent.VK_ENTER);                 

		getDriver().switchTo().window(mainWindow);
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
		Assert.assertTrue("The searched element was not found after " + waitSeconds + " seconds!", element != null);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return element;
	}
	
	public void replaceOneValueInCsvFile(String path, int line, String newValue) throws Exception{
			CsvFile file = new CsvFile(path, CSVFormat.RFC4180);
			file.write(line, newValue);
	}
	
	public String getSelectedValue(WebElement selectWebElement){
		Select selectElement=new Select(selectWebElement);
		return selectElement.getFirstSelectedOption().getText();
	}
	
	public Select selectByVisibleText(WebElement selectWebElement,String text){
		Select selectElement=new Select(selectWebElement);
		selectElement.selectByVisibleText(text);
		return selectElement;
	}
	
	public List<WebElement> getAllOptions(WebElement selectWebElement){
		Select selectElement=new Select(selectWebElement);
		return selectElement.getOptions();
	}
}

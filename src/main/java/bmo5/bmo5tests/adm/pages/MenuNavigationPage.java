package bmo5.bmo5tests.adm.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;
import bmo5.bmo5tests.tools.adm.SelectEnums.AnalystsChoiceContentSelect;
import bmo5.bmo5tests.tools.adm.SelectEnums.WidgetSelect;

public class MenuNavigationPage extends AbstractAdmPage{


//	@FindBy(css = "ul#sidebar li:nth-child(18)")
//	private WebElement navigationContainer;
	@FindBy(css = "ul#sidebar")
	private WebElement navigationContainer;
	
	@FindBy(css = "select#analysts_choice_content_id")
	private WebElement selectContainer;
	
	@FindBy(css = "i.icon-logout.icon-large")
	private WebElement logout;
	
	@FindBy(css = "div#breadcrumb > div > span.current")
	private WebElement breadcrumbLast;
	
	@FindBy(css = "div#breadcrumb > div > span:nth-child(2)")
	private WebElement breadcrumbMiddle;
	
	public void admLogout(){
		element(logout).waitUntilVisible();
		logout.click();
	}

	public void selectMenuItem(AdmMenuItems menu){
		element(navigationContainer).waitUntilVisible();
//		waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul#sidebar li:nth-child(17)")));
//		navigationContainer.click();
		List<WebElement> itemsList = navigationContainer.findElements(By.cssSelector("li > a > span"));
		
		for(WebElement elementNow:itemsList){
			if(elementNow.getText().contains(splitCamelCase(menu.name()))){
				elementNow.click();
				break;
			}
		}
	}	
	
	public void selectAnalystChoise(WidgetSelect item){
		element(navigationContainer).waitUntilVisible();
		waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul#sidebar li:nth-child(18)")));
		
		List<WebElement> itemsList = navigationContainer.findElements(By.cssSelector("span"));
		for(WebElement elementNow:itemsList){
			if(elementNow.getText().contains(item.toString())){  
				elementNow.click();
				break;
			}
		}
	}
	
	public void selectAnalystChoiseContent(AnalystsChoiceContentSelect item){
		element(selectContainer).waitUntilVisible();
		waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select#analysts_choice_content_id option")));
		
		List<WebElement> itemsList = selectContainer.findElements(By.cssSelector("option"));
		for(WebElement elementNow:itemsList){
			if(elementNow.getText().contains(item.toString())){  
				elementNow.click();
				Sleeper.sleepTight(2000);
				try {
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					waitABit(2000);
					} catch (Exception e) {
						System.out.println(e);
					}
				break;
			}
		}
	}
	
	public void selectAnalystChoiseContent(String item){
		element(selectContainer).waitUntilVisible();
		waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select#analysts_choice_content_id option")));
		
		List<WebElement> itemsList = selectContainer.findElements(By.cssSelector("option"));
		for(WebElement elementNow:itemsList){
			if(elementNow.getText().contains(item)){  
				elementNow.click();
				Sleeper.sleepTight(2000);
				try {
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					waitABit(2000);
					} catch (Exception e) {
						System.out.println(e);
					}
				break;
			}
		}
	}
	
	public void verifyBreadCrumb(String text) {
		//TODO Fix this
//		AbstractPage a = new AbstractPage(getDriver());
//		a.waitUntilElementExists(By.cssSelector("div#breadcrumb span.current"), 10000);
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

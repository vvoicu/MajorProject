package bmo5.bmo5tests.bmo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class ServiceUpdatePage extends AbstractPage{
	
	@FindBy(css = "div#service-modal > div:nth-child(1) > h4")
	@CacheLookup
	private WebElement windowTitle;
	
	@FindBy(css = "div#service-modal > div.modal-header > button")
	@CacheLookup
	private WebElement closeButton;
	
	@FindBy(css = "div#service-modal > div.modal-body > p")
	@CacheLookup
	private WebElement windowUpdate;
	
	@FindBy(css = " a#service-updates > span")
	@CacheLookup
	private WebElement newUpdate;
	
	public void verifyUpdate() {
		if (windowTitle.getText().contains("There are no service updates")) {System.out.println("There are service updates");}
			else { System.out.println("There are no service updates");} 
		
	}
	public void closeServiceUpdate() {
		closeButton.click();
	}

	public void verifyNewUpdate() {
		System.out.println("nr update");
		String text=newUpdate.getText();
		System.out.println(text);
		
	}
	
}

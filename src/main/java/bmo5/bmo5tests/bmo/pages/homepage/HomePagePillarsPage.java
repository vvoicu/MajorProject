package bmo5.bmo5tests.bmo.pages.homepage;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class HomePagePillarsPage extends AbstractPage {


	@FindBy(css="ul#pillars > li:nth-child(3) > div > a:nth-child(3)")//div.container-fluid > h3")
	@CacheLookup
	private WebElement subtabTitle;
	
	@FindBy(css = "ul.breadcrumb li.active")
	private WebElement lastBreadcrumb;
	
	public void clickOnNavigationalTabByLinkTextAndVerify(String linkText){
		getDriver().findElement(By.linkText(linkText)).click();
		Assert.assertTrue(lastBreadcrumb.getText().contains(linkText));
	}

	public void verifySubtabTitle(String text){
		boolean contained = false;
		if (subtabTitle.getText().contains(text)) {
			contained = true;
		}
		Assert.assertTrue("Subtab title did not contain " + text + "!", contained);
	}
}

package bmo5.bmo5tests.bmo.pages;

import net.thucydides.core.annotations.findby.FindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class BaseTemplate extends AbstractPage {

	@FindBy(css = "a.brand")
	@CacheLookup
	private WebElement bmiLogo;
	
	@FindBy(css = "a.btn")
	@CacheLookup
	private WebElement help;
	
	@FindBy(partialLinkText = "Terms & Conditions")
	@CacheLookup
	private WebElement termsAndConditions;
	
	@FindBy(partialLinkText = "Track Record")
	@CacheLookup
	private WebElement trackRecord;
	
	@FindBy(partialLinkText = "Contact us")
	@CacheLookup
	private WebElement contactUs;
}

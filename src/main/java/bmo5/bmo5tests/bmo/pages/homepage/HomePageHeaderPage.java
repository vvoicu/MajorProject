package bmo5.bmo5tests.bmo.pages.homepage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import net.thucydides.core.annotations.findby.By;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class HomePageHeaderPage extends AbstractPage{

	@FindBy(css="div.sidebar.well ul:nth-child(1)  li:nth-child(1)  ul")
	private WebElement containerAccountList;

	@FindBy(css = "div.container-fluid > header > div:nth-child(1) > a")
	@CacheLookup
	private WebElement logo;

	@FindBy(id = "appendedInputButtons")
	@CacheLookup
	private WebElement searchTextBox;

	@FindBy(css = "button > i.icon-c-search")
	@CacheLookup
	private WebElement searchButton;

	@FindBy(css= "body > ul[class='typeahead dropdown-menu']")
	@CacheLookup
	private WebElement predictiveList; 

	@FindBy(css= "body > ul > li:nth-child(3) > a")
	@CacheLookup
	private WebElement elementList;

	@FindBy(partialLinkText = "Advanced search")
	@CacheLookup
	private WebElement advancedSearchButton;

	@FindBy(css = "a[href$='help-modal']")
	@CacheLookup
	private WebElement help;

	@FindBy(css=" a[href='/img/BMO_v4_quick_ref.pdf']")
	@CacheLookup
	private WebElement helpGuide;

	@FindBy(css = "div.modal-navigation.clearfix > div > a:nth-child(3)")
	@CacheLookup
	private WebElement helpTerms;

	@FindBy(linkText = "Print")
	@CacheLookup
	private WebElement helpPrint;

	@FindBy(css = "div#help-modal >div:nth-child(3 ) > div > div:nth-child(1) > ul > li > a ")
	private WebElement helpContentlink;

	@FindBy(id = "help-index")
	@CacheLookup
	private WebElement helpIndex;

	@FindBy(id = "service-updates")
	@CacheLookup
	private WebElement serviceUpdates;
	
	@FindBy(css = "div#service-modal > div:nth-child(1) > h4")
	private WebElement serviceUpdatesNameFromModal;

	@FindBy(css = "div#service-modal > div:nth-child(1) > button")
	private WebElement closeButtonModalWindowServiceUpdates;

	@FindBy(linkText = "Account")
	private WebElement account;

	@FindBy(css = "ul.dropdown-menu.pull-right > li:first-child")
	@CacheLookup
	private WebElement welcomeUserMessage;

	@FindBy(linkText = "Email Alerts")
	@CacheLookup
	private WebElement emailAlerts;

	@FindBy(linkText = "Saved Content")
	@CacheLookup
	private WebElement savedContent;

	@FindBy(partialLinkText = "Logout")
	@CacheLookup
	private WebElement logout;

	@FindBy(css = "a.btn.dropdown-toggle > i.icon-c-user")
	@CacheLookup
	private WebElement myBmoIcon;

	@FindBy(css = "ul.dropdown-menu.pull-right")
	@CacheLookup
	private WebElement dropdownMyBmoIcon;

	@FindBy(css = "a[href='/home/total_analysis']")
	private WebElement methodologyButton;

	@FindBy(css = "a[href='/home']")
	private WebElement home;

	@FindBy(css = "ul.breadcrumb >  li.active")
	private WebElement breadcrumbLast;

	@FindBy(css = "ul.breadcrumb li:nth-child(2) > a")   
	private WebElement breadcrumbFirst;

	@FindBy(css = "div#help-modal button.close")
	private WebElement closeHelpButton;

	@FindBy(css = "div.btn-group.pull-right.form-inline > div > ul >li:nth-child(2) > a ")
	private WebElement contactUsMtBmoDropdown;

	@FindBy(css = "input#email")
	private WebElement verifyUsernameAtLogin;
	
	@FindBy(css = "div.container-fluid > div:nth-child(6) > div:nth-child(2) > img")
	private WebElement imageMethodology;
	
	@FindBy(css = "div.container-fluid > div:nth-child(6) > div:nth-child(1) > h3")
	private WebElement methodologyTitle;
	
	@FindBy(css = "div.container-fluid > header > div > a")
	private WebElement bmiLogoTop;
	
	@FindBy(css = "body > div#help-modal > div:nth-child(1) > h3")
	private WebElement helpNameFromHeader;

	
	public void clickOnContactUsFromMyBmoDropdown(String contactUs) {
		Assert.assertTrue("Not found!!!", getDriver().findElement(By.cssSelector("div.btn-group.pull-right.form-inline > div > ul >li:nth-child(2) > a")).getText().contains(contactUs));
		contactUsMtBmoDropdown.click();
	}
	
	public void clickCloseButton() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#help-modal > div:nth-child(1) > button")).isDisplayed());
		closeHelpButton.click();
	}

	public void containerAccountOptions(String value){
		element(containerAccountList).waitUntilVisible();
		List<WebElement> options = containerAccountList.findElements(By
				.cssSelector("li"));

		for (WebElement option : options) {
			if (value.equals(option.getText())) {
				option.click();
				waitABit(10000);
				break;
			}
		}
	}
	
	public void clickOnHomeBreadcrumb() {
		Assert.assertTrue(home.isDisplayed());
		home.click();
		waitABit(3000);
		Assert.assertTrue(logo.isDisplayed());
	}
	
	public void clickOnMethodologyIcon() {
		methodologyButton.click();
	}
	
	public void clickOnMyBmoIcon() {
		myBmoIcon.click();
		waitABit(4000);
	}

	public void searchFor(String keyword) {
		searchTextBox.sendKeys(keyword);
		searchButton.click();
	}

	public void predictiveSearch(String threecharacters) {
		searchTextBox.sendKeys(threecharacters);
		Assert.assertTrue("Predictiv Search drop down list is not displayed", predictiveList.isDisplayed());
		elementList.click();	
	}

	public void clickSearch() {
		searchButton.click();
	}

	public void clickAdvancedSearch() { 
		advancedSearchButton.click();
	}

	public void clickHelp(String helpName) {
		help.click();
		waitABit(3000);
		Assert.assertTrue(helpNameFromHeader.getText().contains(helpName));
	}

	public void closeHelp(String close) {
		waitABit(2000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#help-modal > div:nth-child(1) > button.close")).getAttribute("class").contains(close));
		closeHelpButton.click();
	}

	public void verifyHeaderpresence() {
		if (getDriver().findElements(By.cssSelector("div.btn-group.pull-right.form-inline > div.btn-group")).size() == 4) {
		Assert.assertTrue(help.isDisplayed());
		Assert.assertTrue(serviceUpdates.isDisplayed());
		Assert.assertTrue(methodologyButton.isDisplayed());
		Assert.assertTrue(myBmoIcon.isDisplayed());
		} else
		{System.out.println("The Header is not found!!");}
	}

	public void clickServiceUpdates(String updates) {
		accessServiceUpdates();
		waitABit(2000);
		Assert.assertTrue("not found!", serviceUpdatesNameFromModal.getText().contains(updates));
		closeButtonModalWindowServiceUpdates.click();
	}

	public void accessServiceUpdates() {
		serviceUpdates.click();
	}

	public void verifyEmailFromAccountMatchesTheUserCreatedEmail(String correctEmail) {
		waitABit(3000);
		String emailFromAccountPage = getDriver().findElement(By.cssSelector("article.span10 > div:nth-of-type(1) > dl > dd:nth-of-type(2)")).getText();
		Assert.assertTrue(correctEmail.equals(emailFromAccountPage));
	}
	public void verifyPageMethodology(String total) {
		clickOnMethodologyIcon();
		Assert.assertTrue(methodologyTitle.getText().contains(total));
	}
	
	public void clickMyBmoAccountDropdown() {
		myBmoIcon.click();
		waitABit(2000);
		account.click();
	}

	public void verifyMyBmoSection() {
		clickOnMyBmoIcon();
		waitABit(3000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.btn-group.pull-right.form-inline > div > ul > li:nth-child(2) > a")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.btn-group.pull-right.form-inline > div > ul > li:nth-child(3) > a")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.btn-group.pull-right.form-inline > div > ul > li:nth-child(4) > a")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.btn-group.pull-right.form-inline > div > ul > li:nth-child(5) > a")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.btn-group.pull-right.form-inline > div > ul > li:nth-child(6) > span > a")).isDisplayed());
		waitABit(2000);
		account.click();

	}

	public void clickLogo() {
		Assert.assertTrue(bmiLogoTop.getAttribute("class").contains("brand"));
		logo.click();
	}

	public void verifyMyBmoIconDropdownWelcomeNameMessage() {
		Assert.assertTrue("Title does not contain Welcome user message", welcomeUserMessage.getText().contains("Welcome"));
	}

	public void clickOnSavedContent() {
		clickOnMyBmoIcon();
		waitABit(2000);
		savedContent.click();

	}

	public void verifyIfSavedContentIsActive(){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(3) h5 i")).getAttribute("class").contains("icon-c-down-dir"));
	}

	public void clickOnEmailAlerts() {
		waitUntilElementExists(By.cssSelector("a[href ='/alerts/customalerts/list']"), 4);
		Assert.assertTrue("There are no alerts found!", getDriver().findElement(By.cssSelector("a[href ='/alerts/customalerts/list']")).getText().contains("Email Alerts"));
		emailAlerts.click();
	}

	public void helpQuickReferenceGuide(String reference) {
		helpGuide.click();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("a[href='/img/BMO_v4_quick_ref.pdf']")).getText().contains(reference));
		String winHandleBefore = getDriver().getWindowHandle();
		for (String winHandle : getDriver().getWindowHandles()) {
			getDriver().switchTo().window(winHandle);
		}
		waitABit(20000);
		Assert.assertTrue(getDriver().getCurrentUrl().endsWith(".pdf"));
		//Assert.assertTrue(getDriver().findElement(By.cssSelector("div#pageContainer1")).isEnabled());
		getDriver().close();
		getDriver().switchTo().window(winHandleBefore);
	}

	public void helpTermsAndConditions() {
		helpTerms.click();
		Assert.assertTrue(getDriver().getCurrentUrl().endsWith("legal"));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#terms-conditions > h4")).getText().contains("Terms & Conditions"));
	}

	public void helpPrint(String print)  {
		element(getDriver().findElement(By.cssSelector("a#print_content"))).waitUntilPresent();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("a#print_content")).getText().contains(print));
		helpPrint.click();

	}

	public void cancelPrinting() {
		String mainWindow = getDriver().getWindowHandle();
		getDriver().switchTo().activeElement();

		waitABit(5000);

		Robot newRobot;
		try {
			newRobot = new Robot();
			newRobot.keyPress(KeyEvent.VK_ESCAPE);
			newRobot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		getDriver().switchTo().window(mainWindow);
	}


	public void helpContentLink() {
		waitABit(5000);
		element(helpContentlink).waitUntilVisible();
		helpContentlink.click();
		waitABit(5000);

	}

	public void clickOnIndex(String index) {
		Assert.assertTrue("not found!!!!",getDriver().findElement(By.cssSelector("a#help-index")).getText().contains(index));
		helpIndex.click();
	}

	public void verifyBreadCrumbs(String text) {
		boolean contained = false;

		if (breadcrumbLast.getText().contains(text)) {
			contained = true;
		} else {
			if (breadcrumbFirst.getText().contains(text)) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}

	//
	//	public void clickOnFirstArticleFromCarousel(){
	//		waitABit(2000);
	//		if(getDriver().findElements(By.cssSelector("div#home-carousel")).size() > 0){
	//			elementClick("div#home-carousel > div.flex-viewport > ul > li:nth-child(1) > article");
	//		}
	//		else{
	//			System.out.println("There is no item in carousel");
	//		}
	//	}
	//	
	//	public void clickOnDvPackFromCarousel(){
	//		if(getDriver().findElements(By.cssSelector("div#home-carousel > div.flex-viewport > ul > li:nth-child(3) > article")).size() > 0){
	//			elementClick("div#home-carousel > div.flex-viewport > ul > li:nth-child(3) > article");
	//		}
	//		else{
	//			System.out.println("There is no item in carousel");
	//		}
	//	}

	public void verifyMyBmoForIpUser(String email) {
		getDriver().navigate().to(Constants.BMO5UserProfilePage);
		waitABit(2000);
		if (getDriver().findElements(By.cssSelector("ul#js-mybmo-menu")).size() == 1){
			System.out.println("Only Account is displayed in this section!!!");
			elementClick("ul#js-mybmo-menu > li:nth-child(1) > a:nth-child(1)");
			waitUntilElementExists(By.cssSelector("article.span10 > div:nth-of-type(1) > dl > dd:nth-of-type(2)"), 30);
			String emailFromAccountPage = getDriver().findElement(By.cssSelector("article.span10 > div:nth-of-type(1) > dl > dd:nth-of-type(2)")).getText();
			Assert.assertTrue(email.equals(emailFromAccountPage));
		}
	}
	
	public void verifyMethodologyImage() {
		waitABit(5000);
		Assert.assertTrue("not found!!!", imageMethodology.isDisplayed());
	}

	public void clickOnLogout(){
		clickOnMyBmoIcon();
		logout.click();
		waitABit(3000);
		Assert.assertTrue(verifyUsernameAtLogin.isDisplayed());
	}
}

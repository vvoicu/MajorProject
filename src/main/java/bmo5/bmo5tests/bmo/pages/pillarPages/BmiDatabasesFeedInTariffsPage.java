package bmo5.bmo5tests.bmo.pages.pillarPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class BmiDatabasesFeedInTariffsPage  extends AbstractPage{

	@FindBy(css = "aside > form > div > ul > li:nth-child(4) > ul > li.quick-search > input")
	private WebElement sectorInputBox;

	@FindBy(css = "aside > form > div > ul > li:nth-child(4) > h5")
	private WebElement sectorToggler;
	
	@FindBy(css = "aside > form > div > ul > li:nth-child(5) > h5")
	private WebElement dateRangesToggler;
	
	@FindBy(css = "button#filter-renewables-action")
	private WebElement downloadRawDataButton;
	
	@FindBy(css = "div#permission-modal-pdf strong")
	private WebElement alertMessageDownload;
	
	@FindBy(css = "div#permission-modal-pdf div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialDownload;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(5) > h5 > span > i")
	private WebElement arrowDaterangesToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(5)  > h5")
	private WebElement daterangesToggler;
	 
	 @FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) > h5 > span > i")
	 private WebElement arrowSectorToggler;
	 
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) input.input-block-level")
	private WebElement inputBoxSectorSection;
		
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(6) > div > ul > li:nth-child(1) > input")
	private WebElement inputBoxIndicatorSection;
		
	 
	public void insertLettersInSectorInputBox(String letters){
		sectorInputBox.sendKeys(letters);
	}
	
	public void checkSector(String letters){
		waitABit(3000);
		element(sectorInputBox).waitUntilVisible();
		int numberOfLetters = getDriver().findElements(By.cssSelector("aside > form > div > ul > li:nth-child(4) > ul > li")).size() - 1;
		int i, j;
		for(i=1;i<=numberOfLetters;i++){
			j = i+1;
			if(getDriver().findElement(By.cssSelector("aside > form > div > ul > li:nth-child(4) > ul > li:nth-of-type(" + j + ") > label")).getText().contains(letters)){
				getDriver().findElement(By.cssSelector("aside > form > div > ul > li:nth-child(4) > ul > li:nth-of-type(" + j + ") > label > div > span")).click();
				Assert.assertTrue(getDriver().findElement(By.cssSelector("aside > form > div > ul > li:nth-child(4) > ul > li:nth-of-type(" + j + ") > label > div > span")).getAttribute("class").contains("checked"));
				break;
			}
		}
	}
	
	public void clickOnDateRangesToggler(){
		dateRangesToggler.click();
	}
	
	public void checkOneYearFromDateRangesSection(String dateRange){
		int numberOfLetters = getDriver().findElements(By.cssSelector("aside > form > div > ul > li:nth-child(5) > ul > li")).size();
		int i, j, k;
		boolean isChecked;
		for(i=1;i<=numberOfLetters;i++){
			j = i+1;
			if(getDriver().findElement(By.cssSelector("aside > form > div > ul > li:nth-child(5) > ul > li:nth-child(" + j + ") > label")).getText().contains(dateRange)){
				getDriver().findElement(By.cssSelector("aside > form > div > ul > li:nth-child(5) > ul > li:nth-child(" + j + ") > label > div > span")).click();
				int numberOfRegionsPerContinent = getDriver().findElements(By.cssSelector("aside > form > div > ul > li:nth-child(5) > ul > li:nth-child(" + j + ") > ul > li")).size();
				for(k=1; k<=numberOfRegionsPerContinent; k++){
					if(getDriver().findElement(By.cssSelector("aside > form > div > ul > li:nth-child(5) > ul > li:nth-of-type(" + j + ") > ul > li:nth-child(" + k + ") > label > div > span")).getAttribute("class").contains("checked")){
						isChecked = true;
					}
					else{
						isChecked = false;
						System.out.println("Item not checked");
						Assert.assertTrue(isChecked);
						break;
					}
				}
				break;
			}
		}
	}
	
	public void checkOneYearFromDaterangesSection(String dateRange){
		int numberOfLetters = getDriver().findElements(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(5) > ul > li")).size() - 1;
		int i, j, k;
		boolean isChecked;
		for(i=1;i<=numberOfLetters;i++){
			j = i+1;
			if(getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(5) > ul > li:nth-child(" + j + ") > label")).getText().contains(dateRange)){
				getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(5) > ul > li:nth-child(" + j + ") > label > div > span")).click();
				int numberOfRegionsPerContinent = getDriver().findElements(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(5) > ul > li:nth-child(" + j + ") > ul > li")).size();
				for(k=1; k<=numberOfRegionsPerContinent; k++){
					if(getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(5) > ul > li:nth-of-type(" + j + ") > ul > li:nth-child(" + k + ") > label > div > span")).getAttribute("class").contains("checked")){
						isChecked = true;
					}
					else{
						isChecked = false;
						System.out.println("Item not checked");
						Assert.assertTrue(isChecked);
						break;
					}
				}
				break;
			}
		}
	}
	
	public void clickOnDaterangesToggler(){
		daterangesToggler.click();
		waitABit(10000);
		Assert.assertTrue(arrowDaterangesToggler.getAttribute("class").contains("icon-c-down-dir"));
	}
	
	public void clickOnSectorToggler(){
		sectorToggler.click();
		Assert.assertTrue(arrowSectorToggler.getAttribute("class").contains("down"));
	}

	
	public void clickOnDownloadRawDataButtonTrialUser(){
		downloadRawDataButton.click();
		Assert.assertTrue(alertMessageDownload.isDisplayed());
		cancelButtonModalWindowTrialDownload.click();
	}
	
	
	public void insertThreeLettersInInputBoxFromSectorSectionAndVerify(String threeLetters){
		inputBoxSectorSection.sendKeys(threeLetters);
	}
	
	public void insertThreeLettersInInputBoxFromIndicatorSectionAndVerify(String threeLetters){
		inputBoxIndicatorSection.sendKeys(threeLetters);
	}
	
	public void checkOneOptionFromSectorFilter(String sector){
		getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(4) > ul > li label[title='" + sector + "'] span")).click();
		waitABit(4000);
		String sectorName = getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(4) > ul > li label[title='" + sector + "']")).getText();
		System.out.println(sectorName);
		Assert.assertTrue(sectorName.matches(sector));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(4) > ul > li > label > div > span.checked > input")).getAttribute("id").contains("ind_Biogas"));
	}
	
	public void verifyIfOptionFromSectorFilterIsChecked(String sector){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(4) > ul > li label[title='" + sector + "'] span.checked")).size() == 1);
	}
}

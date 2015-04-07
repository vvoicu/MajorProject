package bmo5.bmo5tests.bmo.pages.pillarPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class BMIDatabasesMobileOperatorsPage extends AbstractPage{
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) > h5")
	private WebElement geographyToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(5) > h5")
	 private WebElement operatorsToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(6) > h5")
	private WebElement indicatorToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(7) > h5")
	private WebElement dateRangesToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) > h5 > span > i")
	private WebElement arrowGeographyToggler;
	
	 @FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(5) > h5 > span > i")
	 private WebElement arrowOperatorsToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(6) > h5 > span > i")
	private WebElement arrowIndicatorToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(7) > h5 > span > i")
	private WebElement arrowDateRangesToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li.quick-search > input")
	private WebElement inputBoxOperatorsSection;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(5) > ul > li.quick-search > input")
	private WebElement inputBoxSSection;
	
	@FindBy(css = "button#filter-display-data")
	private WebElement displayDataButton;
	
	@FindBy(css = "div#dynamic_char")
	private WebElement chart;
	
	@FindBy(css = "button#print-dvpack")
	private WebElement printChartButton;
	
	@FindBy(css = "div#dynamic_table > div > div > div:nth-child(1) > div > table > thead > tr > th:nth-child(1)")
	private WebElement countryColumnHeaderElement;
	
	@FindBy(css = "div#dynamic_table > div > div > div:nth-child(1) > div > table > thead > tr > th:nth-child(2)")
	private WebElement indicatorColumnHeaderElement;
	
	@FindBy(css = "div#dynamic_table > div > div > div:nth-child(1) > div > table > thead > tr > th:nth-child(3)")
	private WebElement operatorColumnHeaderElement;
	
	@FindBy(css = "article.span10 > div:nth-child(2) > div:nth-child(2) > div")
	private WebElement warningMessageTooManyLinesElement;
	
	@FindBy(css = "button#filter-renewables-action")
	private WebElement downloadButton;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(6) > div > ul > li:nth-child(1) > input")
	private WebElement inputBoxIndicatorSection;
	
	public void downloadTheFeedInTariffsData() {
		downloadButton.click();
	}
	
	public void clickOnGeographyTogglerAndVerify(){
		geographyToggler.click();
		Assert.assertTrue(arrowGeographyToggler.getAttribute("class").contains("down"));
	}
	
	public void checkOneRegion(String continent){
		if(getDriver().findElements(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(4) li > label[title='" + continent + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(4) li > label[title='" + continent + "']")).click();
		}
	}
	
	public void verifyIfRegionIsChecked(String continent){
		if(getDriver().findElements(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(4) li > label[title='" + continent + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + continent + "')"));
		}
	}
	
	public void verifyIfRegionIsNotChecked(String continent){
		if(getDriver().findElements(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(4) li > label[title='" + continent + "']")).size() == 1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + continent + "')"));
		}
	}

	public void clickOnOperatorToggler(){
		operatorsToggler.click();
		Assert.assertTrue(arrowOperatorsToggler.getAttribute("class").contains("down"));
	}
	
	public void insertThreeLettersInInputBoxFromOperatorsSectionAndVerify(String threeLetters){
		inputBoxOperatorsSection.sendKeys(threeLetters);
	}
	
	public void checkOneLetterFromOperatorSection(String letter){
		if(getDriver().findElements(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(5) li > label[title='" + letter + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(5) li > label[title='" + letter + "']")).click();
		}
	}
	
	public void verifyIfLetterIsChecked(String letter){
		if(getDriver().findElements(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(5) li > label[title='" + letter + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + letter + "')"));
		}
	}
	
	public void verifyIfLetterIsNotChecked(String letter){
		if(getDriver().findElements(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(5) li > label[title='" + letter + "']")).size() == 1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + letter + "')"));
		}
	}
	
	public void clickOnIndicatorToggler(){
		indicatorToggler.click();
		Assert.assertTrue(arrowIndicatorToggler.getAttribute("class").contains("down"));
	}
	
	public void verifyIfOneIndicatorIsChecked(String indicator){
		if(getDriver().findElements(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(6) li > label[title='" + indicator + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + indicator + "')"));
		}
	}
	
	public void verifyIfOneIndicatorIsNotChecked(String indicator){
		if(getDriver().findElements(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(6) li > label[title='" + indicator + "']")).size() == 1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + indicator + "')"));
		}
	}
	
	public void clickOnDateRangesToggler(){
		dateRangesToggler.click();
		Assert.assertTrue(arrowDateRangesToggler.getAttribute("class").contains("down"));
	}
	
	public void checkOneYearFromDateRangesSection(String dateRange){
		if(getDriver().findElements(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(7) li > label[title='" + dateRange + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(7) li > label[title='" + dateRange + "']")).click();
		}
	}
	
	public void verifyIfYearIsChecked(String dateRange){
		if(getDriver().findElements(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(7) li > label[title='" + dateRange + "']")).size() == 1){
			Assert.assertTrue(verifyElementState("document.getElementById('" + dateRange + "')"));
		}
	}
	
	public void verifyIfYearIsUnChecked(String dateRange){
		if(getDriver().findElements(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(7) li > label[title='" + dateRange + "']")).size() == 1){
			Assert.assertFalse(verifyElementState("document.getElementById('" + dateRange + "')"));
		}
	}

	public void clickOnDisplayDataButton(){
		displayDataButton.click();
		Sleeper.sleepTight(2000);
	}
	
	public void checkOneIndicatorFromIndicatorSection(String indicator){
		if(getDriver().findElements(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(6) li > label[title='" + indicator + "']")).size() == 1){
			getDriver().findElement(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(6) li > label[title='" + indicator + "']")).click();
		}
	}
	
	public String returnTheIndicatorId(String indicator){
		String indicatorId = null;
		indicatorId = getDriver().findElement(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(6) li > label[title='" + indicator + "']")).getAttribute("for");
		return indicatorId;
	}
	
	public void checkOneLetterFromSectorSection(String letter){
		int numberOfSectors = getDriver().findElements(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li")).size() - 1;
		int i, j, k;
		boolean isChecked;
		for(i=1;i<=numberOfSectors;i++){
			j=i+1;
			if(getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li:nth-child(" + j + ") > label")).getText().contains(letter)){
				getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li:nth-child(" + j + ") > label > div > span")).click();
				int numberOfSubSectors = getDriver().findElements(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li:nth-child(" + j + ") > ul > li")).size();
				for(k=1; k<=numberOfSubSectors; k++){
					if(getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li:nth-child(" + j + ") > ul > li:nth-child(" + k + ") > label > div > span")).getAttribute("class").contains("checked")){
						isChecked = true;
					}
					else{
						isChecked = false;
						System.out.println("Item not checked");
						Assert.assertTrue(isChecked);
						waitABit(10000);
						break;
					}
				}
			}
		}
	}
	
	public void verifyFiltersAreClered(){
		Assert.assertTrue(arrowGeographyToggler.getAttribute("class").contains("down"));
		Assert.assertTrue(operatorsToggler.getAttribute("class").contains("inactive"));
		Assert.assertTrue(indicatorToggler.getAttribute("class").contains("inactive"));
		Assert.assertTrue(dateRangesToggler.getAttribute("class").contains("inactive"));
		Assert.assertTrue(displayDataButton.getAttribute("class").contains("disabled"));
	}
	
	public void verifyGeographyInTable(){
		waitUntilElementExists(By.cssSelector("div#dynamic_table div.DTFC_LeftBodyWrapper"), 20);
		String geography = null;
		int numberOfRows = getDriver().findElements(By.cssSelector("div.DTFC_LeftBodyLiner> table > tbody > tr")).size();
		for(int i=1; i<=numberOfRows; i++){
			geography = getDriver().findElement(By.cssSelector("div.DTFC_LeftBodyLiner> table > tbody > tr:nth-child(" + i + ") > td:nth-child(1)")).getText();
			System.out.println(geography);
			Assert.assertTrue(verifyElementState("document.getElementById('" + geography + "')"));
		}
	}
	
	public void verifyOperatorInTable(){
		waitUntilElementExists(By.cssSelector("div#dynamic_table div.DTFC_LeftBodyWrapper"), 20);
		int numberOfRows = getDriver().findElements(By.cssSelector("div.DTFC_LeftBodyLiner> table > tbody > tr")).size();
		String operator = null, operatorId = null;
		for(int i=1; i<=numberOfRows; i++){
			operator = getDriver().findElement(By.cssSelector("div.DTFC_LeftBodyLiner> table > tbody > tr:nth-child(" + i + ") > td:nth-child(3)")).getText();
			operatorId = getDriver().findElement(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(5) li > label[title='" + operator + "']")).getAttribute("for");
			Assert.assertTrue(verifyElementState("document.getElementById('" + operatorId + "')"));
		}
	}
	
	public void verifyIndicatorInTable(){
		waitUntilElementExists(By.cssSelector("div#dynamic_table div.DTFC_LeftBodyWrapper"), 20);
		int numberOfRows = getDriver().findElements(By.cssSelector("div.DTFC_LeftBodyLiner> table > tbody > tr")).size();
		String indicator = null, indicatorId = null;
		for(int i=1; i<=numberOfRows; i++){
			indicator = getDriver().findElement(By.cssSelector("div.DTFC_LeftBodyLiner> table > tbody > tr:nth-child(" + i + ") > td:nth-child(2)")).getText();
			System.out.println(indicator);
			indicator = indicator.replaceAll(", Operators, BMI", "");
			System.out.println(indicator);
			indicatorId = getDriver().findElement(By.cssSelector("ul[class='nav nav-list'] > li:nth-of-type(6) li > label[title='" + indicator + "']")).getAttribute("for");
			Assert.assertTrue(verifyElementState("document.getElementById('" + indicatorId + "')"));
		}
	}
	
	public void verifyDateRangesInTable(String year){
		String lastTwoCharacters = year.substring(year.length() - 2);
		System.out.println(lastTwoCharacters);
		int numberOfColumns = getDriver().findElements(By.cssSelector("div#dynamic_table div.dataTables_scrollHeadInner tr > th")).size();
		String lastTwoCharactersOfColumn, column;
		for(int i=4; i<=numberOfColumns; i++){
			column = getDriver().findElement(By.cssSelector("div#dynamic_table div.dataTables_scrollHeadInner tr > th:nth-child(" + i + ")")).getText();
			lastTwoCharactersOfColumn = column.substring(column.length() - 2);
			System.out.println(lastTwoCharactersOfColumn);
			Assert.assertTrue(lastTwoCharacters.endsWith(lastTwoCharactersOfColumn));
		}
	}
}

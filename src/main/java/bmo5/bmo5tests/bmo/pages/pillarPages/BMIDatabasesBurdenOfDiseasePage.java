package bmo5.bmo5tests.bmo.pages.pillarPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class BMIDatabasesBurdenOfDiseasePage extends AbstractPage{
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(3) > h5 i")
	private WebElement arrowGeographyFilter;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) > h5")
	private WebElement indicatorToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(5) > h5[data-section-name='age']")
	private WebElement ageToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(7) > h5")
	private WebElement genderToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(9) > h5")
	private WebElement dateRangesToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) > h5 > span > i")
	private WebElement arrowIndicatorToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(5) > h5 > span > i")
	private WebElement arrowAgeToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(7) > h5 > span > i")
	private WebElement arrowGenderToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(9) > h5 > span > i")
	private WebElement arrowDateRangesToggler;
	
	@FindBy(css = "aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) > div > ul > li:nth-child(1) > input")
	private WebElement inputBoxIndicatorSection;
	
	@FindBy(css = "article.span10 > div:nth-child(2) > div:nth-child(2) > div")
	private WebElement warningMessageTooManyLinesElement;
	
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
	
	@FindBy(css = "ul#indTab > li > a[data-indicator-by='category']")
	private WebElement categoryTabFromIndicatorFilter;
	
	public void clickOnIndicatorToggler(){
		indicatorToggler.click();
		Assert.assertTrue(arrowIndicatorToggler.getAttribute("class").contains("down"));
	}
	
	public void insertThreeLettersInInputBoxFromIndicatorSectionAndVerify(String threeLetters){
		inputBoxIndicatorSection.sendKeys(threeLetters);
	}
	
	public void checkOneItemFromIndicatorSection(String indicator){
		waitUntilElementDoesntExist(By.cssSelector("div.loading"),70);
		getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) label[title='" + indicator + "']")).click();
	}
	
	public String returnThIndicatorId(String indicator){
		return getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-child(4) label[title='" + indicator + "']")).getAttribute("for");
	}
	
	public void verifyIfIndicatorIsChecked(String indicator){
		Assert.assertTrue(verifyElementState("document.getElementById('" + indicator + "')"));	
	}
	
	public void verifyIfIndicatorIsUnChecked(String indicator){
		Assert.assertFalse(verifyElementState("document.getElementById('" + indicator + "')"));	
	}
	
	public void clickOnAgeToggler(){
		ageToggler.click();
		Assert.assertTrue(arrowAgeToggler.getAttribute("class").contains("down"));
	}
	
	public void checkOneItemAndVerifyFromAgeSection(String age){
		getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(5) > ul > li label[title='" + age + "']")).click();
	}
	
	public void verifyIfAgeIsChecked(String age){
		Assert.assertTrue(verifyElementState("document.getElementById('" + age + "')"));
	}
	
	public void verifyIfAgeIsUnChecked(String age){
		Assert.assertFalse(verifyElementState("document.getElementById('" + age + "')"));
	}
	
	public void clickOnGenderToggler(){
		genderToggler.click();
		Assert.assertTrue(arrowGenderToggler.getAttribute("class").contains("down"));
	}
	
	public void checkOneItemAndVerifyFromGenderSection(String gender){
		getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(7) > ul > li label[title='" + gender + "']")).click();
	}
	
	public void verifyIfGenderIsChecked(String gender){
		Assert.assertTrue(verifyElementState("document.getElementById('" + gender + "')"));
	}
	
	public void verifyIfGenderIsUnChecked(String gender){
		Assert.assertFalse(verifyElementState("document.getElementById('" + gender + "')"));
	}
	
	public void clickOnDateRangesToggler(){
		dateRangesToggler.click();
		Assert.assertTrue(arrowDateRangesToggler.getAttribute("class").contains("down"));
	}
	
	public void checkYearFromDateRangesSection(String year){
		getDriver().findElement(By.cssSelector("aside.span2 > form > div:nth-child(1) > ul > li:nth-of-type(9) > ul > li label[title='" + year + "']")).click();
	}
	
	public void verifyIfDateRangeIsChecked(String year){
		Assert.assertTrue(verifyElementState("document.getElementById('" + year + "')"));
	}
	
	public void verifyIfDateRangeIsUnChecked(String year){
		Assert.assertFalse(verifyElementState("document.getElementById('" + year + "')"));
	}
	
	public void clickOnDisplayDataButton(){
		displayDataButton.click();
		Sleeper.sleepTight(2000);
		Assert.assertTrue(warningMessageTooManyLinesElement.isDisplayed());
	}
	
	public void clickOnCategoryTabFromIndicatorFilter(){
		categoryTabFromIndicatorFilter.click();
	}
	
	public void verifyIfCategoryTabFromIndicatorFilterIsActive(){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#indTab > li.active > a")).getAttribute("data-indicator-by").contains("category"));
	}
	
	public void verifyFiltersAreCleared(){
		Assert.assertTrue(arrowGeographyFilter.getAttribute("class").contains("down"));
		Assert.assertTrue(indicatorToggler.getAttribute("class").contains("inactive"));
		Assert.assertTrue(ageToggler.getAttribute("class").contains("inactive"));
		Assert.assertTrue(genderToggler.getAttribute("class").contains("inactive"));
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
	
	public void verifyIndicatorInTable(String indicator){
		waitUntilElementExists(By.cssSelector("div#dynamic_table div.DTFC_LeftBodyWrapper"), 20);
		int numberOfColumns = getDriver().findElements(By.cssSelector("div#dynamic_table div.DTFC_LeftBodyWrapper table tbody > tr > td:nth-child(2)")).size();
		for(int z=1; z<=numberOfColumns; z++){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div#dynamic_table div.DTFC_LeftBodyWrapper table tbody > tr:nth-child(" + z + ") > td:nth-child(2)")).getText().contains(indicator));
		}
	}
	
	public void verifyAgeInTable(String age){
		waitUntilElementExists(By.cssSelector("div#dynamic_table div.DTFC_LeftBodyWrapper"), 20);
		int numberOfColumns = getDriver().findElements(By.cssSelector("div#dynamic_table div.DTFC_LeftBodyWrapper table tbody > tr > td:nth-child(3)")).size();
		for(int z=1; z<=numberOfColumns; z++){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div#dynamic_table div.DTFC_LeftBodyWrapper table tbody > tr:nth-child(" + z + ") > td:nth-child(3)")).getText().equalsIgnoreCase(age));
		}
	}
	
	public void verifyGenderInTable(String gender){
		waitUntilElementExists(By.cssSelector("div#dynamic_table div.DTFC_LeftBodyWrapper"), 20);
		int numberOfColumns = getDriver().findElements(By.cssSelector("div#dynamic_table div.DTFC_LeftBodyWrapper table tbody > tr > td:nth-child(4)")).size();
		for(int z=1; z<=numberOfColumns; z++){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div#dynamic_table div.DTFC_LeftBodyWrapper table tbody > tr:nth-child(" + z + ") > td:nth-child(4)")).getText().equalsIgnoreCase(gender));
		}
	}
	
	public void verifyDateRangesInTable(String year){
		String lastTwoCharacters = year.substring(year.length() - 2);
		System.out.println(lastTwoCharacters);
		int numberOfColumns = getDriver().findElements(By.cssSelector("div#dynamic_table div.dataTables_scrollHeadInner tr > th")).size();
		String lastTwoCharactersOfColumn, column;
		for(int i=5; i<=numberOfColumns; i++){
			column = getDriver().findElement(By.cssSelector("div#dynamic_table div.dataTables_scrollHeadInner tr > th:nth-child(" + i + ")")).getText();
			lastTwoCharactersOfColumn = column.substring(column.length() - 2);
			System.out.println(lastTwoCharactersOfColumn);
			Assert.assertTrue(lastTwoCharacters.endsWith(lastTwoCharactersOfColumn));
		}
	}
}

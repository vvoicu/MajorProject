package bmo5.bmo5tests.bmo.pages.homepage;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class FinancialMarketsPage  extends AbstractPage {

	@FindBy( css = "a#asset_button")//"financial-markets-content")
	private WebElement assetClassStrategyTab;

	@FindBy( id = "available_regions")
	private WebElement dropdownAssetStrategy;

	@FindBy( id = "forecast_button")
	private WebElement keyForecastsTab;

	@FindBy(id = "available_regions")
	//	@CacheLookup
	private WebElement dropdowndKeyForecsts;

	@FindBy(css = "div#asset_class_strategy > table")
	private WebElement tableClassStrategy; 

	@FindBy(css = "div#key_forecasts > div:nth-child(2)")
	private WebElement tableKeyForecstsExchangeRate; 

	@FindBy(css = "div#key_forecasts > div:nth-child(4)")
	private WebElement tableKeyForecastsInterestRate; 


	public void selectKeyForecastsFromDropdown(String keyRegion) {
		keyForecastsTab.click();
		selectFromDropdown(getDriver().findElement(By.cssSelector("div#financial-markets-content > div:nth-child(1) > select#available_regions")), keyRegion);
	}
	public void selectARegionForAssetClassStrategy(String assetRegion) {
		waitABit(5000);
		assetClassStrategyTab.click();
		selectFromDropdown(getDriver().findElement(By.cssSelector("div#financial-markets-content > div:nth-child(1) > select#available_regions")), assetRegion);
		waitABit(5000);
	}

	public void verifyTableOfAssetStrategyIsPresent() {
		if (getDriver().findElements(By.cssSelector("div#asset_class_strategy > p > em")).size() == 1){
			Assert.assertTrue("message not found!", getDriver().findElement(By.cssSelector("div#asset_class_strategy > p > em")).getText().contains("No results were found"));
			System.out.println("There is no table displayed!");

		}
		else {
			Assert.assertTrue("not found!", tableClassStrategy.isDisplayed());
		}

	}

	public void verifyTableOfKeyForecastsIsPresent(String eRate, String iRate) {
		if (getDriver().findElements(By.cssSelector("div#asset_class_strategy > p > em")).size() == 1){
			Assert.assertTrue("message not found!", getDriver().findElement(By.cssSelector("div#asset_class_strategy > p > em")).getText().contains("No results were found"));
			System.out.println("There is no Key Forecasts set From Adm!!!");
		}
			else
		{
			Assert.assertTrue("no title there!", getDriver().findElement(By.cssSelector("div#key_forecasts > h4:nth-child(1)")).getText().contains(eRate));
			Assert.assertTrue("not found!", tableKeyForecstsExchangeRate.isDisplayed());
			waitABit(5000);
			Assert.assertTrue("no title there!", getDriver().findElement(By.cssSelector("div#key_forecasts > h4:nth-child(3)")).getText().contains(iRate));
			Assert.assertTrue("not found!", tableKeyForecastsInterestRate.isDisplayed());
		}
	}

}

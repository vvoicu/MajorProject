package bmo5.bmo5tests.bmo.steps.homepage;


import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class FinancialMarketsSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void selectKeyForecstsOption(String keyRegion) {
		financialMarketsPage().selectKeyForecastsFromDropdown(keyRegion);
	}
	
	@Step
	public void selectARegionForAssetClassStrategy(String assetRegion) {
		financialMarketsPage().selectARegionForAssetClassStrategy(assetRegion);
	}
	
	@Step
	public void verifyTableOfAssetStrategyIsPresent() {
		financialMarketsPage().verifyTableOfAssetStrategyIsPresent();
	}
	
	@Step
	public void selectKeyForecasts(String keyRegion) {
		financialMarketsPage().selectKeyForecastsFromDropdown(keyRegion);
	}

	@Step
	public void verifyTableOfKeyForecasts(String eRate, String iRate) {
		financialMarketsPage().verifyTableOfKeyForecastsIsPresent(eRate,iRate);
	}
}
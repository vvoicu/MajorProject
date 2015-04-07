package bmo5.bmo5tests.adm.pages.widgets;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class FinancialAdmMarketsPage extends AbstractAdmPage {
	
	@FindBy(css = "div.widget-content")
	private WebElement containerRegions;
	
	@FindBy(css = "a[href='/widgets/financialmarkets/keyforecasts']")
	private WebElement keyForecastsSubtab;
	
	@FindBy(css = "div#primary_global_edit")
	private WebElement editRegionTitle;
	
	@FindBy(css = "div#primary_global_edit > form > input")
	private WebElement editKeytitle;
	
	@FindBy(css = "div#primary_global_edit > form > button:nth-child(1)")
	private WebElement okEditTitlebutton;
	
	@FindBy(css = "input#globalprimary_indicator")
	private WebElement indicatorInputBox;
	
	@FindBy(css = "input#globalprimary_geography")
	private WebElement geopgraphyInputBox;
	
	@FindBy(css = "input#globalprimary_description")
	private WebElement descriptionInputBox;
	
	@FindBy(css = "button#primary_global_submit")
	private WebElement addRowButton;
	
	@FindBy(css = "table#primary_global_table > thead > tr:nth-child(2) > td:nth-child(1) > div > ul li")
	private WebElement indicatorsList;
	
	@FindBy(css = "button#btn_confirm")
	private WebElement conformDeletingTheRowButton;
	
	@FindBy(css = "div[class='alert alert-success fade in']")
	private WebElement confirmationMessage;
	
	public void clickOnKeyForecasts () {
		keyForecastsSubtab.click();
	}
	
	public void editRegionTitleOption () {
		editRegionTitle.click();
	}
	
	public void clickOkTitleOption () {
		okEditTitlebutton.click();
		
	}
	
	public void doEditKeyTitle() {
		editKeytitle.sendKeys("test0001");
	}
	
	public void selectARegion(String geography) {
		
	element(containerRegions).waitUntilVisible();
	
	List<WebElement> allElements = containerRegions.findElements(By.tagName("div"));

	for (WebElement region : allElements) {
		if (region.getText().equals(geography)) {
			region.click();
			waitABit(5000);
			break;
		}
	}
		
	}
	
	public void clickGeography() {
		waitABit(2000);
		evaluateJavascript("$(\"div.widget-content > div:nth-child(1) >div > div:nth-child(1)\").click();");
		waitABit(10000);
	}
	
	public void clickOnRegionName(String region){
		WebElement element = getDriver().findElement(By.cssSelector("div[class='widget-box width100 percent widget-overflow '] > div.widget-content > div > div > div:nth-child(1) > div a[href='#" + region + "']"));
		element.click();
	}
	
	public String chooseAnIndicator(String finalText, String indicator, String region){
		getDriver().findElement(By.cssSelector("input#" + region + "primary_indicator")).sendKeys(indicator);
		waitABit(1500);
		List<WebElement> listButtons = getDriver().findElements(By.cssSelector("div.control-group ul.typeahead > li"));
		for (WebElement elemNow:listButtons){
			String elemText = elemNow.getText();
			System.out.println(elemNow.getAttribute("data-value"));
			if(elemText.contains(finalText)){				
				element(elemNow).click();
				break;
			}
		}
		return getDriver().findElement(By.cssSelector("input#" + region + "primary_indicator")).getText();
	}
	
	
	public String chooseAGeography(String region, String geography, String finalText){
		getDriver().findElement(By.cssSelector("input#" + region + "primary_geography")).sendKeys(geography);
		waitABit(1500);
		List<WebElement> listButtons = getDriver().findElements(By.cssSelector("div.control-group ul.typeahead > li"));
		for (WebElement elemNow:listButtons){
			String elemText = elemNow.getText();
			System.out.println(elemNow.getAttribute("data-value"));
			if(elemText.contains(finalText)){				
				element(elemNow).click();
				break;
			}
		}
		return getDriver().findElement(By.cssSelector("input#" + region + "primary_geography")).getText();
	}
	
	public void enterADescription(String region, String description){
		getDriver().findElement(By.cssSelector("input#" + region + "primary_description")).sendKeys(description);
		getDriver().findElement(By.cssSelector("table#primary_" + region + "_table > thead > tr:nth-child(2) > td:nth-child(3) > div")).click();
	}
	
	public void clickOnAddRowButton(String region, String indicator, String geography, String description){
//		addRowButton.click();
		getDriver().findElement(By.cssSelector("button#primary_"+ region +"_submit")).click();
		waitABit(2000);
		String indicatorNameLastRow = getDriver().findElement(By.cssSelector("table#primary_" + region + "_table > tbody > tr:last-child > td:nth-child(1)")).getText();
		String geographyNameLastRow = getDriver().findElement(By.cssSelector("table#primary_" + region + "_table > tbody > tr:last-child > td:nth-child(2)")).getText();
		String desciptionNameLastRow = getDriver().findElement(By.cssSelector("table#primary_" + region + "_table > tbody > tr:last-child > td:nth-child(3)")).getText();
		Assert.assertTrue(indicatorNameLastRow.contains(indicator));
		Assert.assertTrue(geographyNameLastRow.contains(geography));
		Assert.assertTrue(desciptionNameLastRow.contains(description));
	}
	
	public void deleteRow(String region, String indicator, String geography, String description){
		int numberOfRows = getDriver().findElements(By.cssSelector("table#primary_" + region + "_table > tbody > tr")).size();
		System.out.println("Number of rows:" + numberOfRows);
		for(int i=1; i<=numberOfRows; i++){
			if(getDriver().findElement(By.cssSelector("table#primary_" + region + "_table > tbody > tr:nth-child(" + i + ") > td:nth-child(1)")).getText().contains(indicator)
				&& getDriver().findElement(By.cssSelector("table#primary_" + region + "_table > tbody > tr:nth-child(" + i + ") > td:nth-child(2)")).getText().contains(geography)
					&& getDriver().findElement(By.cssSelector("table#primary_" + region + "_table > tbody > tr:nth-child(" + i + ") > td:nth-child(3)")).getText().contains(description)
					){
						System.out.println("Found!!!!");
						getDriver().findElement(By.cssSelector("table#primary_" + region + "_table > tbody > tr:nth-child(" + i + ") > td:nth-child(9) > button")).click();
						conformDeletingTheRowButton.click();
						waitABit(1500);
						Assert.assertTrue(confirmationMessage.isDisplayed());
						break;
					}
			}
	} 
}
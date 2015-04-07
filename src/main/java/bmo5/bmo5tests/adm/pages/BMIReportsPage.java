package bmo5.bmo5tests.adm.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class BMIReportsPage extends AbstractAdmPage{

	
	@FindBy(css = "select#region")
	private WebElement geographyDropDownList;
	
	@FindBy(css = "select#service")
	private WebElement serviceDropDownList;
	
	@FindBy(id= "keyword")
	private WebElement keywordInbutBox;
	
	@FindBy(id = "code")
	private WebElement productCodeInputBox;
	
	@FindBy(css = "select#frequency")
	private WebElement frequencyDropDownList;
	
	@FindBy(css = "button[type='submit']")
	private WebElement searchButton;
	
	@FindBy(css = "button[type='reset']")
	private WebElement resetButton;
	
	@FindBy(css = "div#breadcrumb > h4")
	private WebElement searchResultsPage;
	
	public void selectRegionOrCountry(String region){
		selectFromDropdown(geographyDropDownList, region);
	}
	
	public void selectService(String service){
		selectFromDropdown(serviceDropDownList, service);
	}
	
	public void selectPublicationFrequency(String publicationFrequency){
		selectFromDropdown(frequencyDropDownList, publicationFrequency);
	}
	
	public void insertKeyword(String keyword){
		keywordInbutBox.sendKeys(keyword);
	}
	
	public void insertProductCode(String productCode){
		productCodeInputBox.sendKeys(productCode);
	}
	
	public void clickOnSearchButton(){
		searchButton.click();
	}
	
	public void clickOnResetButtonAndVerify(){
		resetButton.click();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("select#region > option[selected]")).getText().contains("All"));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("select#service > option[selected]")).getText().contains("All"));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("select#frequency > option[selected]")).getText().contains("All"));
	}
	
	public String clickOnReportFromTable(int reportNumber){
		int numberOfReports = getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody > tr")).size();
		System.out.println(numberOfReports);
		String reportName = null;
		if (numberOfReports > 0) {
			if (reportNumber <= numberOfReports && reportNumber > 0) {
				System.out.println("Should click");
				reportName = getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(" + reportNumber + ") > td:nth-child(2)")).getText();
				getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(" + reportNumber + ") > td:nth-child(1) a")).click();
				}
			else{
				System.out.println("Wrong");
			}
		} else {
			System.out.println("There is no article in listing.");
		}
		return reportName;
	}
	
	public void verifyThatAllProductTitlesContainTheKeyword(String keyword){
		int numberOfArticles = getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody > tr")).size();
		for(int i=1; i<=numberOfArticles; i++){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(" + i + ") > td:nth-child(1) a")).getText().contains(keyword));
		}
	}
	
	public void verifyTheReportFromListingPage(String productCode){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody > tr")).size() == 1);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(1) > td:nth-child(2)")).getText().contains(productCode));
	}
	
}
	

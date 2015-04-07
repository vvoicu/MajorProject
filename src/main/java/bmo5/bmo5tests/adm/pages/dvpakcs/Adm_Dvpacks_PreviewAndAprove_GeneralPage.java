package bmo5.bmo5tests.adm.pages.dvpakcs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class Adm_Dvpacks_PreviewAndAprove_GeneralPage extends AbstractAdmPage{
	
	@FindBy(css = "div.right-side > div:nth-child(2)  h3")
	private WebElement dvpackNameText;
	
	@FindBy(css = "div.right-side > div:nth-child(2)  h4:nth-child(2)")
	private WebElement dvpackTitleText;
	
	@FindBy(css = "div.right-side > div:nth-child(2)  h4:nth-child(3)")
	private WebElement dvpackSubTitleText;
	
	@FindBy(css= "table.dvpack_table.dataTable")
	private WebElement dvpackPreviewTable;
	
	@FindBy(css= "table.dvpack_table.dataTable > tbody")
	private WebElement dvpackPreviewTableBody;
	
	@FindBy(css="div[id*='dvpack_container_']")
	private WebElement dvpackPreviewChartContainer;
	
	@FindBy(css = "div.right-side > div:nth-child(2) > h4")
	private WebElement dvpackText;
	
	@FindBy(css = "button#list")
	private WebElement dvPackListButton;
	
	public void verifyTitleFromPreview(String expectedTitle){
		Assert.assertEquals(expectedTitle.trim(), dvpackTitleText.getText().trim());
	}
	
	public void verifyNameFromPreview(String expectedName){
		Assert.assertEquals(expectedName.trim(), dvpackNameText.getText().trim());
	}
	
	public void verifySubtitleFromPreview(String expectedSubtitle){
		Assert.assertEquals(expectedSubtitle.trim(), dvpackSubTitleText.getText().trim());
	}
	
	public void verifyNumberOfRowsFromTableInPreview(int expectedNumberRows){
		List<WebElement> rows=dvpackPreviewTableBody.findElements(By.cssSelector("tr"));
		
		Assert.assertEquals(expectedNumberRows, rows.size());
	}
	
	public void verifyChartIsDisplayedInPreview(){
		Assert.assertTrue(dvpackPreviewChartContainer.isDisplayed());
	}
	
	public String getDvpackIDConfirmationPage(String path, int line){
		Assert.assertTrue(dvpackText.isDisplayed());
		String[] successMessageSplitted=dvpackText.getText().split(" ");
		System.out.println("Created dvpack id: " +successMessageSplitted[successMessageSplitted.length-1]);
		try { // 1,62
			replaceOneValueInCsvFile(path, line, successMessageSplitted[successMessageSplitted.length-1]);
		} catch (Exception e) { //"C:\\Users\\QAtraining\\workspace\\BMO5 Automation Webdriver Thucydides\\src\\test\\java\\resources\\adm\\Bmo5_Adm_DvPacks_CreateDvPack_Dynamic_System_Chart.csv"
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return successMessageSplitted[successMessageSplitted.length-1];
	}
	
	public void verifyMessageConfirmationPage(){
		Assert.assertTrue(dvpackText.isDisplayed());
		Assert.assertTrue(dvpackText.getText().contains("Your DVPack has been successfully created and has the id"));//I know it's hardcoded :)
	}
	
	public void clickOnDvPackListButton(){
		dvPackListButton.click();
	}
}

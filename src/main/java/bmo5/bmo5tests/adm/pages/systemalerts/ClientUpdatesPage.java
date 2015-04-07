package bmo5.bmo5tests.adm.pages.systemalerts;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AbstractAdmPage;



public class ClientUpdatesPage extends AbstractAdmPage{


	@FindBy(css = "div#breadcrumb > div:nth-child(1) >  span:last-child")
	private  WebElement breadcrumbClientUpdatesLast;
	
	@FindBy(css = "div#breadcrumb > div:nth-child(1) >  span:nth-child(2)")
	private  WebElement breadcrumbClientUpdatesFirst;
	
	@FindBy(css = "div#breadcrumb > div:nth-child(2) >  div:nth-child(1) > a")
	private  WebElement addClientUpdate;
	
	@FindBy(css = "div#breadcrumb > div:nth-child(2) >  div:nth-child(2) > a")
	private  WebElement helpButton;
	
	@FindBy(css = "div#help > div:nth-child(4) > button")
	private WebElement closeHelp;
	
	@FindBy(css = "div#DataTables_Table_0_length > label > select")
	private WebElement recordsPerPageDropdown;
	
	@FindBy(css = "div#DataTables_Table_0 > table")
	private WebElement tablePresenceOnPage;
	
	@FindBy(css = "div#DataTables_Table_0 > thead > tr > th:nth-child(1) ")
	private WebElement IDColumn;
	
	@FindBy(css = "div#DataTables_Table_0 > table >thead > tr > th:nth-child(2)")
	private WebElement titleColumn;
	
	@FindBy(css = "div#DataTables_Table_0 > table > thead > tr > th:nth-child(3)")
	private WebElement pubishDateColumn;
	
	@FindBy(css = "div#DataTables_Table_0 > table > thead > tr > th:nth-child(4)")
	private WebElement expiryDateColumn;
	
	@FindBy(css = "div#DataTables_Table_0 > table > thead > tr > th:nth-child(5)")
	private WebElement actionsColumn;
	
	@FindBy(css = "div#content > div > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > form > div:nth-child(1) > label")
	private WebElement title;
	
	@FindBy(css = "div#content > div > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > form > div:nth-child(2) > label")
	private WebElement textOption;
	
	@FindBy(css = "div#content > div > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > form > div:nth-child(3) > label")
	private WebElement publishD;
	
	@FindBy(css = "div#content > div > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > form > div:nth-child(4) > label")
	private WebElement expiryD;
	
	@FindBy(css = "div.fileupload.fileupload-new > span:nth-child(1)")
	private WebElement selectFile;
	
	@FindBy(css = "div.widget-content > form > div:nth-child(10) > button:nth-child(1) ")
	private WebElement save;
	
	@FindBy(css = "div.form-actions > button.btn.btn-link.evil.color")
	private WebElement reset;
	
	public void addNewClientUpdate(String text) {
		Assert.assertTrue(addClientUpdate.isDisplayed());
		addClientUpdate.click();
		waitABit(3000);
		System.out.println("New was clicked!");
		boolean contained = false;
		if (breadcrumbClientUpdatesLast.getText().contains(text)) {
			contained = true;
		} else {
			if (breadcrumbClientUpdatesFirst.getText().contains(text)) {
				contained = true;
			}
		}
		Assert.assertTrue("Breadcrum did not contain " + text + "!", contained);
	}
	
	public void verifyAddClientUpdateFormAndAddAlertWithStartDate() {
		Assert.assertTrue(title.isDisplayed());
		Assert.assertTrue(textOption.isDisplayed());
		Assert.assertTrue(publishD.isDisplayed());
		Assert.assertTrue(expiryD.isDisplayed());
		Assert.assertTrue(selectFile.isDisplayed());
		Assert.assertTrue(save.isDisplayed());
		Assert.assertTrue(reset.isDisplayed());
		waitABit(3000);}
	
	public void selectFirstAlertOptions(String name,String words,String day) {		
//		System.out.println("before");
//		element(getDriver().findElement(By.cssSelector("input#Title"))).waitUntilVisible();
//		getDriver().findElement(By.cssSelector("input#Title")).click();
//		getDriver().findElement(By.cssSelector("input#Title")).clear();
//		System.out.println("before");
		getDriver().findElement(By.cssSelector("input#Title")).click();
		element(getDriver().findElement(By.cssSelector("input#Title"))).sendKeys("update1");
		
		element(getDriver().findElement(By.cssSelector("iframe#Text_ifr"))).waitUntilVisible();
		((JavascriptExecutor)getDriver()).executeScript("tinyMCE.activeEditor.selection.setContent('"+words+"')");
		
		getDriver().findElement(By.cssSelector("input#PublishDate")).click();
		// getDriver().findElement(By.cssSelector("input#new_form_end_date")).click();
		 waitABit(4000);
		 WebElement dateWidget = getDriver().findElement(By.id("ui-datepicker-div"));  
//		  List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
		  List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
		    
		  for (WebElement cell: columns){  
  
		   if (cell.getText().equals(day)){  
		   cell.findElement(By.linkText(day)).click(); 
		   System.out.println("date chosen!");
		   waitABit(5000);
		   System.out.println("done");
		   getDriver().findElement(By.cssSelector("input#PublishDate")).click();
			waitABit(5000);
			Assert.assertTrue("not found!!!",getDriver().findElement(By.cssSelector("table.ui-datepicker-calendar > tbody > tr > td > a.ui-state-default.ui-state-active ")).isDisplayed());
		   break; 
		  	}
		  }
		  
	}
	
	public void verifyAndCreateAStaticUpdate(String nameTwo,String wordsTwo,String day) {
		Assert.assertTrue(title.isDisplayed());
		Assert.assertTrue(textOption.isDisplayed());
		Assert.assertTrue(publishD.isDisplayed());
		Assert.assertTrue(expiryD.isDisplayed());
		Assert.assertTrue(selectFile.isDisplayed());
		Assert.assertTrue(save.isDisplayed());
		Assert.assertTrue(reset.isDisplayed());
		
		getDriver().findElement(By.cssSelector("div.widget-content >  form > div:nth-child(1) > div > input")).sendKeys(nameTwo);
		element(getDriver().findElement(By.cssSelector("iframe#Text_ifr"))).waitUntilVisible();
		((JavascriptExecutor)getDriver()).executeScript("tinyMCE.activeEditor.selection.setContent('"+wordsTwo+"')");
		
		getDriver().findElement(By.cssSelector("input#PublishDate")).click();
		// getDriver().findElement(By.cssSelector("input#new_form_end_date")).click();
		 waitABit(4000);
		 WebElement dateWidget = getDriver().findElement(By.id("ui-datepicker-div"));  
//		  List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
		  List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
		    
		  for (WebElement cell: columns){  
  
		   if (cell.getText().equals(day)){  
		   cell.findElement(By.linkText(day)).click(); 
		   System.out.println("date chosen!");
		   waitABit(5000);
		   System.out.println("done");
		   getDriver().findElement(By.cssSelector("input#PublishDate")).click();
			waitABit(5000);
			Assert.assertTrue("not found!!!",getDriver().findElement(By.cssSelector("table.ui-datepicker-calendar > tbody > tr > td > a.ui-state-default.ui-state-active ")).isDisplayed());
		   break; 
		  	}
		  } 	  
	}
	public void selectExpiryDate(String dayExpire) {
		getDriver().findElement(By.cssSelector("input#ExpireDate")).click();
		 WebElement dateWidget = getDriver().findElement(By.id("ui-datepicker-div"));  
//		  List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
		  List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
		    
		  for (WebElement cell: columns){  
 
		   if (cell.getText().equals(dayExpire)){  
		   cell.findElement(By.linkText(dayExpire)).click(); 
		   System.out.println("date chosen!");
		   waitABit(5000);
		   System.out.println("done");
		   getDriver().findElement(By.cssSelector("input#ExpireDate")).click();
			waitABit(5000);
			Assert.assertTrue("not found!!!",getDriver().findElement(By.cssSelector("table.ui-datepicker-calendar > tbody > tr > td > a.ui-state-default.ui-state-active ")).isDisplayed());
		   break; 
		  	}
		  } 	  
		
	}
	
	
	public void tickStaticOption() {
		element(getDriver().findElement(By.cssSelector("label.checkbox"))).waitUntilPresent();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("label.checkbox")).isDisplayed());
		getDriver().findElement(By.cssSelector("label.checkbox > input")).click();
	}
	
	public void clickOnSave() {
		waitABit(4000);
		save.click();
	}
	
	public void clickOnListView() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("a.list.btn")).isDisplayed());
		getDriver().findElement(By.cssSelector("a.list.btn")).click();
	}
	
	public void uploadImage(String upload) {
		getDriver().findElement(By.cssSelector("input#photo")).click();
		waitABit(2000);

		uploadFile(upload + ".jpg", Constants.RESOURCES_MEDIA);
		waitABit(3000);
		
	}
	
	public void verifyClientUpdatesInTheList(String name) {
		getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr > td > a")).getText().contains(name);
	}
}

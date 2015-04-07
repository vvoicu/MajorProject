package bmo5.bmo5tests.adm.pages.dvpakcs;

import net.thucydides.core.annotations.findby.By;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.StringUtils;
import bmo5.bmo5tests.tools.adm.AbstractAdmPage;


public class Adm_Dvpacks_CreateDvpack_CustomDvPack_GeneralPage extends AbstractAdmPage {

	@FindBy(css="div#breadcrumb div:nth-child(2) >  div:nth-child(1) > a:nth-child(1)")
	private WebElement newbutton;
	
	@FindBy(id="name")
	private WebElement dvpackname;
	
	@FindBy(id="title")
	private WebElement dvpacktitle;
	
	@FindBy(id="subtitle")
	private WebElement dvpacksubtitle;
	
	@FindBy(id="description")
	private WebElement dvpackdescription;
	
	@FindBy(id="app_type_system")
	private WebElement typesystem;
	
	@FindBy (id = "default_view_DynamicChart")
	private WebElement defaultview;
	
	@FindBy (css="div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > div:nth-child(14) > button")
	private WebElement continuebutton;
	
	@FindBy (css="div#breadcrumb > div:nth-child(1) > span:nth-child(3)")
	private WebElement breadcrumb;
	
	@FindBy (css="div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(4) > div:nth-child(2) > label")
	private WebElement titleinput;
	
	@FindBy (id = "raw_data")
	private WebElement rawdata;
	
	//@FindBy (css="div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(4) > div:nth-child(6) > button")
	@FindBy(css="button.btn.pull-right")
	private WebElement continueButtonFromEditPage;
	
	@FindBy (css="div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h3")
	private WebElement charttitle;
	
	@FindBy (css="div#breadcrumb >  div:nth-child(2) > button#continue-w")
	private WebElement continueButtonFromPreviewDvpack;
	
	@FindBy (css="div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)>h3")
	private WebElement chartstitle;
	
	@FindBy (id="continue")
	private WebElement aprovecontinue;
	
	@FindBy (css=" div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > h4")
	private WebElement message;
	
	@FindBy (id="list")
	private WebElement dvpacklist;
	
	@FindBy (css="table#DataTables_Table_0 > thead > tr > th:nth-child(6)")
	private WebElement datecreated;
	
	@FindBy (css="table#DataTables_Table_0 > tbody > tr:nth-child(1) > td:nth-child(2)")
	private WebElement namefromtable;
	
	public void createDvPackFirstStep(String name, String title, String subtitle, String description, String type) {
		newbutton.click();
		String searchTitle = String.valueOf(StringUtils.randomNumber(10000));
		dvpackname.sendKeys(name + searchTitle);
		dvpacktitle.sendKeys(title);
		
		dvpackdescription.sendKeys(description);
		Select dvpacktype = new Select(getDriver().findElement(
				By.cssSelector("select#type")));
		dvpacktype.selectByValue(type);
		waitABit(2000);
//		String database=getDriver().findElement(By.cssSelector("select#database")).getAttribute("disabled");
//		System.out.println(database);
//		if(database.equals("true")){System.out.println("Database is disabled");}
//		else {System.out.println("Database is not disabled");}
		typesystem.click();
		defaultview.click();
		dvpacksubtitle.sendKeys(subtitle);
		continueButtonFromEditPage.click();
		
	}
	public void verifyCustomDvPack() {
		Assert.assertTrue("The breadcrumb is not correct", breadcrumb.getText().contains("Custom DV Pack")); 
		//Assert.assertTrue("The field title is not correct", titleinput.getText().contains("          Paste raw data here ")); 
	}
	
	public void insertrawdata(String years, String data) {
		rawdata.sendKeys(" ");
		rawdata.sendKeys(years);
		rawdata.sendKeys(Keys.RETURN);
		String dataAll[]=data.split("/");
		for (int i=0;i<dataAll.length;i++){
			rawdata.sendKeys(dataAll[i]);
			rawdata.sendKeys(Keys.RETURN);
		}
	}
	
	public void clickOnContinueButtonFromEditPage(){
		continueButtonFromEditPage.click();
	   waitABit(3000);
	}
	
	public void verifyPreviewDvpack() {
		Assert.assertTrue("The breadcrumb is not correct", breadcrumb.getText().contains("Preview DV Pack")); 
		Assert.assertTrue("The title is not correct", charttitle.getText().contains("Generate Custom DV Pack")); 
		continueButtonFromPreviewDvpack.click();
	}
	
	public void clickContinueButtonFromPreviewPage(){
		continueButtonFromPreviewDvpack.click();
	}
	
	public void verifyPreviewDvpack2(String name) {
		continueButtonFromPreviewDvpack.click();
		Assert.assertTrue("The breadcrumb is not correct", breadcrumb.getText().contains("Preview DV Pack")); 
		Assert.assertTrue("The title is not correct", chartstitle.getText().contains(name)); 
	}
	
	public void aproveAndcontinue(String title) {
		aprovecontinue.click();
		Assert.assertTrue("The breadcrumb is not correct", breadcrumb.getText().contains("Confirmation"));
		Assert.assertTrue("The chart has not been successfully created", message.getText().contains("has been successfully created and has the id"));
	}
	
	public void verifyCreated(String name) {
		dvpacklist.click();
		datecreated.click();
		datecreated.click();
		Assert.assertTrue("The chart has not been successfully created", namefromtable.getText().contains(name));
	}
	
	public void verifyButtonsPresenceForCustomDvPAck(){
		waitUntilElementExists(By.cssSelector("div#dynamic_chart"), 40);
		if(getDriver().findElements(By.cssSelector("div.alert.alert-info")).size()==0){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("button#load-chart-format")).size() == 1);
		Assert.assertTrue(getDriver().findElements(By.cssSelector("button#load-chart-annotate")).size() == 1);
		}
	}
}
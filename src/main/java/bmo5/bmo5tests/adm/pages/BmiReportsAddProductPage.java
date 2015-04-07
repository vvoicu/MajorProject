package bmo5.bmo5tests.adm.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class BmiReportsAddProductPage extends AbstractAdmPage{


	@FindBy(id = "productCode")
	private WebElement productCodeInputBox;
	
	@FindBy(id = "ProductTitle")
	private WebElement productTitleInputBox;
	
	@FindBy(id = "ShortTitle")
	private WebElement shortTitleInputBox;
	
	@FindBy(id = "ISSN")
	private WebElement issnInputBox;
	
	@FindBy(id = "PublicationFreqID")
	private WebElement publicationFrequencyContainer;
	
	@FindBy(id = "SeriesID")
	private WebElement seriesContainer;
	
	@FindBy(id = "bundle_associated")
	private WebElement bundlesContainer;
	
	@FindBy(id = "reportRuleID")
	private WebElement reportRuleset;
	
	@FindBy(id = "all_Geography")
	private WebElement allGeographiesContainer;
	
	@FindBy(id = "Geography")
	private WebElement selectedGeographiesContainer;
	
	@FindBy(id = "primary_iso")
	private WebElement primaryGeographyContainer;
	
	@FindBy(id = "all_Service")
	private WebElement allServicesContainer;
	
	@FindBy(id = "Service")
	private WebElement selectedServicesContainer;
	
	@FindBy(id = "primary_service")
	private WebElement primaryServiceContainer;
	
	@FindBy(id = "showHeadline_1")
	private WebElement cmsShowHeadlineYes;
	
	@FindBy(id = "showHeadline_0")
	private WebElement cmsShowHeadlineNo;
	
	@FindBy(id = "addIssueNumber_1")
	private WebElement cmsAddIssueNumberYes;
	
	@FindBy(id = "addIssueNumber_0")
	private WebElement cmsAddIssueNumberNo;
	
	@FindBy(id = "addVolumeNumber_1")
	private WebElement cmsAddVolumeNumberYes;
	
	@FindBy(id = "addVolumeNumber_0")
	private WebElement cmsAddVolumeNumberNo;
	
	@FindBy(id = "CMSShow_Y")
	private WebElement cmsShowYes;
	
	@FindBy(id = "CMSShow_N")
	private WebElement cmsShowNo;
	
	@FindBy(id = "StoreShow_1")
	private WebElement storeShowYes;
	
	@FindBy(id = "StoreShow_0")
	private WebElement storeShowNo;
	
	@FindBy(id = "PDF_YN")
	private WebElement pdf;
	
	@FindBy(id = "issuebuilder_yn_Y")
	private WebElement issueBuilderYes;
	
	@FindBy(id = "issuebuilder_yn_N")
	private WebElement issueBuilderNo;
	
	public void verifyProductCode(String productCode){
		Assert.assertTrue(productCodeInputBox.getAttribute("value").contains(productCode));
	}
	
	public void verifyPublicationFrequency(String publicationFrequency){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("select#PublicationFreqID > option[selected]")).getText().contains(publicationFrequency));
	}
	
	public void verifySelectedService(String service){
		Assert.assertTrue(selectedServicesContainer.getText().contains(service));
	}
	
	public void verifySelectedGeography(String geography){
		Assert.assertTrue(selectedGeographiesContainer.getText().contains(geography));
	}
}

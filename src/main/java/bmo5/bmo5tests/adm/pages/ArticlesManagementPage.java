package bmo5.bmo5tests.adm.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class ArticlesManagementPage extends AbstractAdmPage{
//	public ArticlesManagementPage(WebDriver driver) {
//		super(driver);
//	}
	
	@FindBy(css = "select#region")
	private WebElement regionsContainer;
	
	@FindBy(css = "select#channel")
	private WebElement channelsContainer;
	
	@FindBy(css = "select#categories")
	private WebElement categoriesContainer;
	
	@FindBy(css = "select#source")
	private WebElement sourcesContainer;
	
	@FindBy(css = "input#keyword")
	private WebElement keywordInputBox;
	
	@FindBy(css = "input#article")
	private WebElement articleNumberInputBox;
	
	@FindBy(css = "button.btn > i.icon-search")
	private WebElement searchButton;
	
	@FindBy(css = "ul#sidebar > li:nth-of-type(4) > a")
	private WebElement articles;
	
	@FindBy(css = "ul#sidebar > li:nth-of-type(4) > ul > li:nth-of-type(1) > a")
	private WebElement management;
	
	@FindBy(css = "div.opener i")
	private WebElement searchForArticlesOpener;
	
	@FindBy(css = "div.widget-content > form > div:nth-child(7) div")
	private WebElement articleIdFromArticlePreview;
	
	@FindBy(css = "div.widget-content > div:nth-of-type(1) > form > div:nth-child(1) div")
	private WebElement regionFromArticlePreview;
	
	@FindBy(css = "div.widget-content > div:nth-of-type(1) > form > div:nth-child(3) div")
	private WebElement serviceFromArticlePreview;
	
	@FindBy(css = "div[class='widget-box width800 '] h1")
	private WebElement articleTitleFromArticlePreview;
	
	@FindBy(css = "div.widget-content > div:nth-of-type(1) > form > div:nth-child(5) div")
	private WebElement categoryFromArticlePreview;
	
	@FindBy(css = "a[class='centered brand']")
	private WebElement logo;
	
	public void clickOnArticleManagementFromLeftSidebar(){
		articles.click();
		waitABit(2000);
		management.click();
	}
	
	public void selectRegion(String region){
		selectFromDropdown(regionsContainer, region);
	}
	
	public void selectChannel(String channel){
		selectFromDropdown(channelsContainer, channel);
	}
	
	public void selectCategory(String category){
		selectFromDropdown(categoriesContainer, category);
	}
	
	public void selectSource(String source){
		selectFromDropdown(sourcesContainer, source);
	}
	
	public void insertKeyword(String keyword){
		keywordInputBox.sendKeys(keyword);
	}
	
	public void insertArticleNumber(String articleNumber){
		articleNumberInputBox.sendKeys(articleNumber);
	}
	
	public void clickOnSearchButton(){
		searchButton.click();
	}
	
	public void checkArticles(int number){
		int numberOfArticles = getDriver().findElements(By.cssSelector("table[class='table table-condensed table-bordered data-table dataTable'] > tbody > tr")).size();
		if (numberOfArticles > 0) {
			if (number < numberOfArticles && number > 0) {
				for (int i = 1; i <= number; i++) {

					if (getDriver().findElement(By.cssSelector("table[class='table table-condensed table-bordered data-table dataTable'] > tbody > tr:nth-child("+ i + ") > td:nth-child(9) > input")).getAttribute("is_checked").equals("0")) {
						getDriver().findElement(By.cssSelector("table[class='table table-condensed table-bordered data-table dataTable'] > tbody > tr:nth-child("+ i+ ") > td:nth-child(9) > input")).click();
					}
				}
			} else {
				System.out.println("There are not so many articles in listing");
				for (int i = 1; i <= numberOfArticles; i++) {
					
					if (getDriver().findElement(By.cssSelector("table[class='table table-condensed table-bordered data-table dataTable'] > tbody > tr:nth-child("+ i + ") > td:nth-child(9) > input")).getAttribute("is_checked").equals("0")) {
						getDriver().findElement(By.cssSelector("table[class='table table-condensed table-bordered data-table dataTable'] > tbody > tr:nth-child("+ i+ ") > td:nth-child(9) > input")).click();
					}
				}
			}
		} else {
			System.out.println("There is no article in listing.");
		}
	}
	
	public void clickOnOpenerAndVerify(){
		searchForArticlesOpener.click();
		Assert.assertTrue(regionsContainer.isDisplayed());
		Assert.assertTrue(channelsContainer.isDisplayed());
		Assert.assertTrue(categoriesContainer.isDisplayed());
		Assert.assertTrue(sourcesContainer.isDisplayed());
		Assert.assertTrue(keywordInputBox.isDisplayed());
		Assert.assertTrue(articleNumberInputBox.isDisplayed());
		Assert.assertTrue(searchButton.isDisplayed());
	}
	
	public void verifyRegionSelected(String region){
		Select select = new Select(regionsContainer);
		Assert.assertTrue(select.getFirstSelectedOption().getText().contains(region));
	}
	
	public void verifyChannelSelected(String channel){
		Select select = new Select(channelsContainer);
		Assert.assertTrue(select.getFirstSelectedOption().getText().contains(channel));
	}
	
	public void verifyCategorySelected(String category){
		Select select = new Select(categoriesContainer);
		Assert.assertTrue(select.getFirstSelectedOption().getText().contains(category));
	}
	
	public void verifySourceSelected(String source){
		Select select = new Select(sourcesContainer);
		Assert.assertTrue(select.getFirstSelectedOption().getText().contains(source));
	}
	
	public void verifyKeyword(String keyword){
		Assert.assertTrue(keywordInputBox.getAttribute("value").contains(keyword));
	}
	
	public void verifyArticleNumberInsideArticle(String articleNumber){
		Assert.assertTrue(articleIdFromArticlePreview.getText().contains(articleNumber));
	}
	
	public String clickOnAnArticleFromList(int articleNumber){
		int numberOfArticles = getDriver().findElements(By.cssSelector("table[class='table table-condensed table-bordered data-table dataTable'] > tbody > tr")).size();
		String articleName = null;
		if (numberOfArticles > 0) {
			if (articleNumber <= numberOfArticles && articleNumber > 0) {
				articleName = getDriver().findElement(By.cssSelector("table[class='table table-condensed table-bordered data-table dataTable'] > tbody > tr:nth-child(" + articleNumber + ") > td:nth-child(3) a")).getText();
				getDriver().findElement(By.cssSelector("table[class='table table-condensed table-bordered data-table dataTable'] > tbody > tr:nth-child(" + articleNumber + ") > td:nth-child(2) a")).click();
				}
		} else {
			System.out.println("There is no article in listing.");
		}
		return articleName;
	}
	
	public void verifyRegionInsideArticlePreview(String region){
		Assert.assertTrue(regionFromArticlePreview.getText().contains(region));
	}
	
	public void verifyChannelInsideArticlePreview(String channel){
		Assert.assertTrue(serviceFromArticlePreview.getText().contains(channel));
	}
	
	public void verifyArticleTitleInsideArticlePreview(String articleTitle){
		Assert.assertTrue(articleTitleFromArticlePreview.getText().contains(articleTitle));
	}
	
	public void verifyCategoryInsideArticlePreview(String category){
		Assert.assertTrue(categoryFromArticlePreview.getText().contains(category));
	}
	
	public void verifyThatAllHeadersContainTheKeyword(String keyword){
		int numberOfArticles = getDriver().findElements(By.cssSelector("table[class='table table-condensed table-bordered data-table dataTable'] > tbody > tr")).size();
		for(int i=1; i<=numberOfArticles; i++){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("table[class='table table-condensed table-bordered data-table dataTable'] > tbody > tr:nth-child(" + i + ") > td:nth-child(3) a")).getText().contains(keyword));
		}
	}
	
	public void clickOnLogo(){
		logo.click();
	}
}

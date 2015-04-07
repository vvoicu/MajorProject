package bmo5.bmo5tests.adm.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class StrategicContentCategoriesPage extends AbstractAdmPage{


	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(1)")
	private WebElement serviceColumnHeader;
	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(2)")
	private WebElement categoriesColumnHeader;
	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(3)")
	private WebElement lastUpdatedColumnHeader;
	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(4)")
	private WebElement byWhomColumnHeader;
	
	@FindBy(css = "div#breadcrumb a[href='/articles/categories']")
	private WebElement listViewButton;
	
	@FindBy(css = "button#reset-categories")
	private WebElement cancelButton;
	
	@FindBy(css = "button#save_strategicContent")
	private WebElement saveButton;
	
	@FindBy(css = "input#filter-categories")
	private WebElement searchCategoriesInputBox;
	
	@FindBy(css = "button#move-selected-right")
	private WebElement moveToRightSelectedCategoriesButton;
	
	@FindBy(css = "a[href='/articles/categories/default']")
	private WebElement defaultOrderOption;
	
	@FindBy(css = "a[href='/articles/categories']")
	private WebElement serviceOption;
	
	public void verifyTableIsSortedAscendingByService(){
		Assert.assertTrue(serviceColumnHeader.getAttribute("aria-sort").contains("ascending"));
	}
	
	public void clickOnServiceColumnFromHeader(){
		serviceColumnHeader.click();
	}
	
	public void verifyTableIsSortedDescendingByService(){
		Assert.assertTrue(serviceColumnHeader.getAttribute("aria-sort").contains("descending"));
	}
	
	public void verifyTableIsSortedAscendingByCategory(){
		Assert.assertTrue(categoriesColumnHeader.getAttribute("aria-sort").contains("ascending"));
	}
	
	public void clickOnCategoryColumnFromHeader(){
		categoriesColumnHeader.click();
	}
	
	public void verifyTableIsSortedDescendingByCategory(){
		Assert.assertTrue(categoriesColumnHeader.getAttribute("aria-sort").contains("descending"));
	}
	
	public void verifyTableIsSortedAscendingByLastUpdated(){
		Assert.assertTrue(lastUpdatedColumnHeader.getAttribute("aria-sort").contains("ascending"));
	}
	
	public void clickOnLastUpdatedColumnFromHeader(){
		lastUpdatedColumnHeader.click();
	}
	
	public void verifyTableIsSortedDescendingByLastUpdated(){
		Assert.assertTrue(lastUpdatedColumnHeader.getAttribute("aria-sort").contains("descending"));
	}
	
	public void verifyTableIsSortedAscendingByByWhom(){
		Assert.assertTrue(byWhomColumnHeader.getAttribute("aria-sort").contains("ascending"));
	}
	
	public void clickOnByWhomColumnFromHeader(){
		byWhomColumnHeader.click();
	}
	
	public void verifyTableIsSortedDescendingByByWhom(){
		Assert.assertTrue(byWhomColumnHeader.getAttribute("aria-sort").contains("descending"));
	}
	
	public void verifyBreadcrumbs(){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#breadcrumb > div:nth-child(1) > span:nth-child(1)")).getText().contains("Home"));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#breadcrumb > div:nth-child(1) > span:nth-child(2)")).getText().contains("Control Panel"));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#breadcrumb > div:nth-child(1) > span:nth-child(3)")).getText().contains("SC Categories Order"));
	}
	
	public void clickOnServiceFromTableAndVerify(String service){
		int numverOfServices = getDriver().findElements(By.cssSelector("table > tbody > tr")).size();
		int i=0;
		for(i = 1; i<=numverOfServices; i++){
			if(getDriver().findElement(By.cssSelector("table > tbody > tr:nth-child(" + i + ") > td > a")).getText().contains(service)){
				getDriver().findElement(By.cssSelector("table > tbody > tr:nth-child(" + i + ") > td > a")).click();
				break;
			}
		}
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.categories-title > h5")).getText().contains(service));
	}
	
	public void clickOnListViewButtonAndVerify(){
		listViewButton.click();
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div#DataTables_Table_0_wrapper > table")).size() == 1);
	}
	
	public void clickOnCancelButtonAndVerify(){
		cancelButton.click();
		Assert.assertTrue(getDriver().findElements(By.cssSelector("ul#sortable > li")).size() == 0);
	}
	
	public void enterDataInSearchInputBoxEndVerify(String word){
		searchCategoriesInputBox.clear();
		waitABit(5000);
		searchCategoriesInputBox.sendKeys(word);
		waitABit(5000);
		int numberOfCategories = getDriver().findElements(By.cssSelector("ul#droppable > li ")).size();
		System.out.println(numberOfCategories);
		for(int i=1; i<=numberOfCategories; i++){
			System.out.println(getDriver().findElement(By.cssSelector("ul#droppable > li:nth-of-type(" + i + ")")).getText());
			Assert.assertTrue(getDriver().findElement(By.cssSelector("ul#droppable > li:nth-of-type(" + i + ")")).getText().contains(word));
		}
	}
	
	public void clickOnOneCategoryFromLeftPanel(String category){
		getDriver().findElement(By.cssSelector("ul#droppable > li[realval='" + category + "']")).click();
	}
	
	public void clickOnRightArrow(){
		moveToRightSelectedCategoriesButton.click();
	}
	
	public void verifyCategoryExistInRightPanel(String category){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("ul#sortable > li[realval='" + category + "']")).size() == 1);
	}
	
	public void clickOnSaveButtonAndVerify(){
		saveButton.click();
		waitUntilElementExists(By.cssSelector("table#DataTables_Table_0 > tbody"), 30);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.alert.alert-success")).getText().contains("Successfully changed data! If new categories have been added, the sort order should be changed in Control Panel > SC Categories Order > Default Categories"));
	}
	
	public void clickOnDefaultView(){
		defaultOrderOption.click();
	}
	
	public void clickOnService(){
		serviceOption.click();
	}
}

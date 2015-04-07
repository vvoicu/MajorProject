package bmo5.bmo5tests.adm.pages.subnational;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class EntityTypePage extends AbstractAdmPage{

	
	@FindBy(css="div.btn-group:nth-child(2) > a:nth-child(1)") 
	private WebElement exportButton;
	
	@FindBy(css="button[type='submit']") 
	private WebElement saveButton;
	
	@FindBy(css=" a#btn_add_row.btn.pull-right")
	private WebElement newButton;

	@FindBy(css="form > table > tbody > tr > td:nth-of-type(2) > input")
	private WebElement newInputType;
	
	@FindBy(css="#btn-save")
	private WebElement newInputSaveButton;
	
	@FindBy(css="#btn-cancel-new")
	private WebElement newInputCancel;
	
	@FindBy(css="div.alert.alert-error")
	private WebElement alertBox;
	
	@FindBy(css="div.modal-footer a.btn.btn-primary")
	private WebElement confirmDeleteButton;
	
	@FindBy(css="select[name='entity_type_management_length']")
	private WebElement recordsPerPageContainer;
	
	@FindBy(css="div#entity_type_management_filter.dataTables_filter label input")
	private WebElement searchBox;
	
	@FindBy(css="tbody tr.odd td.dataTables_empty")
	private WebElement searchRes;

	public void verifyExportedContent(String name) { 
		String path = "C:\\Users\\"+System.getProperty("user.name")+"\\Downloads\\"+name;
		System.out.println(path);
		BufferedReader inputReader = null;	
		try {
			inputReader = new BufferedReader(new FileReader(path)); //<---exported file name
			String nextLine = null;
			String stringToCheck = getDriver().findElement(By.name("thead tr th.sorting")).getText(); //name of column
			System.out.println(stringToCheck);
			try {
				if((nextLine = inputReader.readLine()) != null) 
					Assert.assertTrue((nextLine.contains(stringToCheck))) ;
			} catch (IOException e) {
				e.printStackTrace();
			}		
			}
		catch(FileNotFoundException e1) {
			       e1.printStackTrace();
			} 
		finally {
				try {
					inputReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public void clickOnNewEntityType() {
		newButton.click();	
	}

	private static String removeLastChars(String str) {
		return str.substring(0,str.length()-4);
	}

	public void verifyLastUpdatedColumn() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		Date now = new Date();		
		String updatedColumn = getDriver().findElement(By.cssSelector(" tbody tr:nth-of-type(1) td.sorting_1")).getText(); 
		System.out.println(updatedColumn); //string
		String nowString = sdf.format(now); //date--->string
		System.out.println(nowString); 
		Assert.assertTrue(updatedColumn.contains(removeLastChars(nowString)));	
	}
	
	public void typeEntityType(String newType){
		newInputType.clear();
		newInputType.sendKeys(newType);
	}
	
	public void addNewEntityType(String newType) {
		newButton.click();
		typeEntityType(newType);
		newInputSaveButton.click();
		waitABit(2000);
	}
	
	public void cancelAddingNewEntity(String newType){
		newButton.click();
		typeEntityType(newType);
		newInputCancel.click();
	}

	public void verifyErrorMessage(String errorMsg) {
		String alert = alertBox.getText().toString();
		System.out.println(alert);
		Assert.assertTrue(alert.contains(errorMsg));
	}
	
	public int deleteEntityType() {
		List <WebElement> tableBef = getDriver().findElements(By.cssSelector("table tbody td.edit"));
		int beforeDelete = tableBef.size();
		System.out.println(beforeDelete);
		List<WebElement> deleteList = getDriver().findElements(By.cssSelector("a.btn.btn-mini.delete"));
		deleteList.get(0).click();
		confirmDeleteButton.click();
		return beforeDelete;
	}
	
	public void verifyIsDeleted(int beforeDelete) {
		List <WebElement> tableAft = getDriver().findElements(By.cssSelector("table tbody td.edit"));
		int afterDelete = tableAft.size();
		System.out.println(afterDelete);
		Assert.assertTrue(beforeDelete > afterDelete);
	}
	
	public void confirmDelete() {
		confirmDeleteButton.click();
	}
	
	public void selectRecordsPerPageAndVerify(String records){
		waitABit(3000);
		selectFromDropdown(recordsPerPageContainer, records);
		waitABit(5000);
		int numberOfItems = getDriver().findElements(By.cssSelector(".table-bordered.dataTable tbody tr")).size();
		if(records.contains("All")){
			System.out.println("All records are displayed: " + numberOfItems);
		}
		else{
			Assert.assertTrue(numberOfItems <= Integer.parseInt(records));
		}
	}
	
	public void exportAll(){
		exportButton.click();
	}
	
	public void searchEntityType(String word) {
		searchBox.click();
		searchBox.sendKeys(word);
		List <WebElement> filteredList = getDriver().findElements(By.cssSelector("table tbody td.edit"));
		if(filteredList.size()>0){
		for(WebElement item:filteredList) {
			Assert.assertTrue("Wrong results!",item.getText().contains(word));
			System.out.println(item.getText());
		}
		}
		else {
			Assert.assertTrue("No results message is not displayed!",searchRes.getText().contains("No matching records found"));
		}
	}
}
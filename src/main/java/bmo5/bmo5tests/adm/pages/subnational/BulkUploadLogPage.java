package bmo5.bmo5tests.adm.pages.subnational;

import java.awt.event.KeyEvent;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.desktop.DesktopKeyboard;

import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class BulkUploadLogPage extends AbstractAdmPage {

	@FindBy(css = "#start_date")
	private WebElement startDate;

	@FindBy(css = "#end_date")
	private WebElement endDate;

	@FindBy(css = "div.btn-group.search-button a.btn")
	private WebElement searchButton;
	
	@FindBy(css = "thead tr th:nth-child(1)")
	private WebElement dateColumn;
	
	@FindBy(css = "thead tr th:nth-child(2)")
	private WebElement processingStartedColumn;
	
	@FindBy(css = "thead tr th:nth-child(3)")
	private WebElement processingEndedColumn;
	
	@FindBy(css = "thead tr th:nth-child(4)")
	private WebElement importStatusColumn;
	
	@FindBy(css="tr.odd:nth-child(1) > td:nth-child(6) > a:nth-child(1)")
	private WebElement processedEntry;
	
	@FindBy(css="#bulkupload")
	private WebElement bulkInput;
	
	
	public void selectItemsPerPage(String value) {
		Select itemsPerPage = new Select(getDriver().findElement(
				By.cssSelector("div.table-search.row-fluid div.span6 div#DataTables_Table_0_length.dataTables_length label select")));
		itemsPerPage.selectByValue(value);
	}

	public Date enterStartDate(String startDateKeys) throws ParseException {
		startDate.click();
		startDate.sendKeys(startDateKeys);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date simpleDate = sdf.parse(startDateKeys);
		return simpleDate;
	}

	public Date enterEndDate(String endDateKeys) throws ParseException {
		endDate.click();
		endDate.sendKeys(endDateKeys);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date simpleDate = sdf.parse(endDateKeys);
		System.out.println(simpleDate);
		return simpleDate;
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void verifySearchResultsOnStartDate(Date simpleDate)
			throws ParseException {
		List<WebElement> processingStartedColumn = getDriver().findElements(
				By.cssSelector("tr td:nth-child(1)"));
		Iterator<WebElement> itr = processingStartedColumn.iterator();
		while (itr.hasNext()) {
			WebElement record = itr.next();
			String input = record.getText(); //very long string
			if(input.length()>0){
			String output = input.substring(0, 10);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate = sdf.parse(output); //date
			Assert.assertTrue(parsedDate.after(simpleDate));
			System.out.println(parsedDate + " is after " + simpleDate);
			}			
		}
	}

	public void verifySearchResultsOnEndDate(Date simpleDate)
			throws ParseException {
		List<WebElement> processingEndedColumn = getDriver().findElements(
				By.cssSelector("tr td:nth-child(1)"));
		Iterator<WebElement> itr = processingEndedColumn.iterator();
		while (itr.hasNext()) {
			WebElement record = itr.next();
			String input = record.getText(); //very long string
			if(input.length()>0){
			String output = input.substring(0, 10);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate = sdf.parse(output); //date
			Assert.assertTrue(parsedDate.before(simpleDate));
			System.out.println(parsedDate + " is before " + simpleDate);
			}			
		}
	}

	public void verifyAscendingDescending(String listSelector) throws InterruptedException {
		List <WebElement> columnHeaders = getDriver().findElements(By.cssSelector(listSelector));
		Iterator <WebElement> iter = columnHeaders.iterator();		
		while(iter.hasNext()) {
			WebElement column = iter.next();
			if(!column.getAttribute("class").contains("disabled")){
				column.click();
				Thread.sleep(2000);
				Assert.assertTrue("Column is not sorted in ascending order!",column.getAttribute("class").contains("sorting_asc"));
				column.click();
				Thread.sleep(2000);
				Assert.assertTrue("Column is not sorted in descending order!",column.getAttribute("class").contains("sorting_desc"));		
			}
			else{	
				System.out.println("All columns were sorted");			
			}
		}	
	}
	
//	public String extractReportName() {
//		  String getHrefValue = processedEntry.getAttribute("href");
//		  String name = getHrefValue
//		   // .substring(getHrefValue.lastIndexOf("/") + 1);
//				  .substring(82);
//		  System.out.println(name);
//		  return name;
//		 }

	public void saveImageHandleFirst() {
		String mainWindow = getDriver().getWindowHandle();
		getDriver().switchTo().activeElement();
		waitABit(3000);
		Keyboard keyboard = new DesktopKeyboard();
		keyboard.keyDown(KeyEvent.VK_DOWN);
		keyboard.keyUp(KeyEvent.VK_DOWN);
		waitABit(3000);
		keyboard.keyDown(KeyEvent.VK_ENTER);
		keyboard.keyUp(KeyEvent.VK_ENTER);
		getDriver().switchTo().window(mainWindow);
	}
	
	public void saveImageHandle() {
		String mainWindow = getDriver().getWindowHandle();
		getDriver().switchTo().activeElement();
		waitABit(3000);
		Keyboard keyboard = new DesktopKeyboard();
		keyboard.keyDown(KeyEvent.VK_ENTER);
		keyboard.keyUp(KeyEvent.VK_ENTER);
		getDriver().switchTo().window(mainWindow);
	}

	public List<String> verifyFileName(String fileName){
		String name = null;
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
		List<String> listOfNames = new ArrayList<String>();
		for(File fileNow:listOfFiles){		
			System.out.println("File name : " + fileNow.getName());
			if(fileNow.getName().contains(fileName)){
				name = fileNow.getName();
				listOfNames.add(name);
			}
		}
		return listOfNames;	
	}		
	
	public List<String> readExcelFile(List<String> listOfNames) {
		List<String> statusesFromExcel = new ArrayList<String>(7);
		for(int i = 0;i<listOfNames.size();i++){
		try {
			String path = "C:\\Users\\"+System.getProperty("user.name")+"\\Downloads\\"+listOfNames.get(i);
			FileInputStream fileInputStream = new FileInputStream(path);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet worksheet = workbook.getSheet("Sheet1");
			XSSFRow row7 = worksheet.getRow(6);				
			XSSFCell cellI7 = row7.getCell((short) 8);
			String i7Val = cellI7.getStringCellValue();
			//statusesFromExcel.add(i2Val);
			//System.out.println(i7Val);
			switch(i7Val) {
			case "Inserted":
				statusesFromExcel.add("Completed");
				break;
			case "Updated":
				statusesFromExcel.add("Completed");
				break;
			case "Skipped Already Exists":
				statusesFromExcel.add("Completed");
				break;
			case "Skipped Parent Does Not Exist":
				statusesFromExcel.add("Rejected");
				break;
			case "Skipped Undefined Error":
				statusesFromExcel.add("Rejected");
				break;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		return statusesFromExcel;
	}
	
//	public void fileWriter(String content) {
//		try {
//			File file = new File("src/test/java/resources/adm/bulkUpload.txt");
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//			FileWriter fwrite = new FileWriter(file.getAbsoluteFile());
//			BufferedWriter bwrite = new BufferedWriter(fwrite);
//			bwrite.write(content);;
//			bwrite.close();
//			System.out.println("Done");
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public List<String> uploadBulkFiles() throws IOException {
		List<String> statusesFromFileNames = new ArrayList<String>(7);
		File folder = new File(Constants.ADM_RESOURCES_PREFIX+Constants.RESOURCES_MEDIA);
		File[] listOfFiles = folder.listFiles();
		for(File fileName : listOfFiles) {
			if(fileName.isFile() && fileName.getName().contains("SUBNAT")) {
					JavascriptExecutor js = (JavascriptExecutor)getDriver();
				    js.executeScript("var main = document.getElementById('bulkupload').removeAttribute('class');");
					waitABit(2000);
					bulkInput.sendKeys(fileName.getCanonicalPath());
					if(fileName.getName().contains("Completed")) {
						statusesFromFileNames.add("Completed");
					}
					else{
						statusesFromFileNames.add("Rejected");
					}
					waitABit(5000);
					Assert.assertTrue(getDriver().getPageSource().contains("Your request is scheduled, please wait."));
			}
			
		}
		return statusesFromFileNames;
	}
	
	public List<String> clickOnDownloadAndVerify(int max) {
		List<String> status = new ArrayList<String>(max);
		List<WebElement> statusItems = getDriver().findElements(
				By.cssSelector("tbody tr td:nth-of-type(4)"));
		for (int i = 0; i <= max; i++) {
			status.add(statusItems.get(i).getText());
		}
		for (int i = 0; i <= max; i++) {
			List<WebElement> downloadItems = getDriver().findElements(
					By.cssSelector("tbody td a"));
			downloadItems.get(i).click();
			if (i == 0) {
				saveImageHandleFirst();
			} else {
				saveImageHandle();
			}
		}
		return status;
	}
	
	public void deleteDownloadedFiles(String fileName) {
		String name = null;
		File rootFolder = new File(Constants.DOWNLOAD_FOLDER_PATH);
		File[] listOfFiles = rootFolder.listFiles(); 
		List<String> listOfNames = new ArrayList<String>();
		for(File fileNow:listOfFiles){		
			System.out.println("File name : " + fileNow.getName());
			if(fileNow.getName().contains(fileName)){
				name = fileNow.getName();
				fileNow.delete();
				listOfNames.add(name);
			}
		}
	}
	
	public void compareResults(List<String> uploaded, List<String> processed, List<String> downloaded) {
		Collections.reverse(uploaded);
		Collections.reverse(downloaded);
		System.out.println(uploaded);
		System.out.println(processed);
		System.out.println(downloaded);
		Assert.assertEquals(uploaded, processed);	
		Assert.assertEquals(processed, downloaded);
	}

}

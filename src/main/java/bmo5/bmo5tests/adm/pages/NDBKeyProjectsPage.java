package bmo5.bmo5tests.adm.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class NDBKeyProjectsPage extends AbstractAdmPage{


	@FindBy(css = "span.ui-icon.ui-icon-search")
	private WebElement searchIcon;
	
	@FindBy(css="div#searchcntfbox_list")
	private WebElement searchContainer;
	
	@FindBy(css="table.group.ui-widget.ui-widget-content > tbody > tr:nth-child(3) > td.columns > select")
	private WebElement tableColumnsDropDown;
	
	@FindBy(css="table.group.ui-widget.ui-widget-content > tbody > tr:nth-child(3) > td.operators > select")
	private WebElement operatorsDropDown;
	
	@FindBy(css="table.group.ui-widget.ui-widget-content > tbody > tr:nth-child(3) > td.data > input")
	private WebElement dataInput;
	
	@FindBy(css="div.ui-jqgrid-bdiv")
	private WebElement ndbKeyProjectsTableContainer;
	
	@FindBy(css="a.ui-jqdialog-titlebar-close.ui-corner-all")
	private WebElement closeFilterButton;
	
	@FindBy(css="div.ui-jqgrid-bdiv > div > table > tbody > tr:nth-child(2) > td:nth-child(10)")
	private WebElement valueCell;
	
	@FindBy(css="div.ui-jqgrid-bdiv > div > table > tbody > tr:nth-child(2) > td:nth-child(11) > input")
	private WebElement valueInput;
	
	@FindBy(css="div#searchcntfbox_list > div > table#fbox_list_2 > tbody > tr:nth-child(2) > td:nth-child(2) > a#fbox_list_search")
	private WebElement findButton;
	
	@FindBy(css="div.ui-jqgrid-bdiv > div > table > tbody > tr:nth-child(2) > td:nth-child(4)")
	private WebElement firstRowProjectName;
	
	public void clickSearchIcon(){
		searchIcon.click();
		verifySearchFilterIsDisplayed();
	}
	
	public void verifySearchFilterIsDisplayed(){
		Assert.assertTrue("Search Filter not displayed",searchContainer.isDisplayed());
	}
	
	public void selectColumnFromDropDown(String column){
		Select columnDropDown=new Select(tableColumnsDropDown);
		columnDropDown.selectByVisibleText(column);
	}
	
	public void selectOperatorFromDropDown(String operator){
		Select operatorsDropdown=new Select(operatorsDropDown);
		operatorsDropdown.selectByVisibleText(operator);
	}
	
	public void typeDataToSearch (String dataToSearch){
		dataInput.sendKeys(dataToSearch);
	}
	
	public void clickFindButton(){
		findButton.click();
		waitABit(3000);
	}
	
	public void verifyNDBKeyProjectsTableIsDisplayed(){
		Assert.assertTrue("Table is not displayed",ndbKeyProjectsTableContainer.isDisplayed());
	}
	
	public void clickCloseFilterButton(){
		closeFilterButton.click();
		verifyNDBKeyProjectsTableIsDisplayed();
		waitABit(3000);
	}
	
	public String getProjectNameFromFirstRow(){
		return firstRowProjectName.getText();
	}
	
	public String typeValueInUSDollarsAndPressEnter(String value,String oldValue, double newDoubleValue, double oldDoubleValue){
		if(oldValue.equals(value)){
			newDoubleValue=newDoubleValue+1;
			value= new Double(newDoubleValue).toString();
		}
		valueCell.click();
		valueInput.clear();
		valueInput.sendKeys(value);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		waitABit(2000);
		return value;
	}
	
	public void typeOldValue(String oldValue){
		valueCell.click();
		valueInput.clear();
		valueInput.sendKeys(oldValue);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public String getOldValueUsDollars(){
		return valueCell.getText();
	}
}

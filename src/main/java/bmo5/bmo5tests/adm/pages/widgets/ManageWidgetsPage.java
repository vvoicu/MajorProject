package bmo5.bmo5tests.adm.pages.widgets;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class ManageWidgetsPage extends AbstractAdmPage{

	@FindBy(css = "a[href='/widgets/managewidgets/add']")
	private WebElement newButton;

	@FindBy(css = "select[name='DataTables_Table_0_length']")
	private WebElement recordsPerPageSelect;

	@FindBy(css = "div#DataTables_Table_0_filter input")
	private WebElement searchInput;
	
	@FindBy(id = "DataTables_Table_0")
	private WebElement containerTableManageWidgets;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(1)")
	private WebElement containerTablePageColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(2)")
	private WebElement containerTableAreaColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(3)")
	private WebElement containerTableSlotColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(4)")
	private WebElement containerTablePivotPointColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(5)")
	private WebElement containerTableNPCColumn;
	
	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(6)")
	private WebElement containerTableCleanupWidgetColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(7)")
	private WebElement containerTableWidgetNameColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(8)")
	private WebElement containerTableWidgetTitleColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(9)")
	private WebElement containerTableActionsColumn;

	@FindBy(css = "a.help.btn")
	private WebElement helpButton;

	@FindBy(id = "help")
	private WebElement containerHelpPopUp;

	@FindBy(css = "button.btn")
	private WebElement closeHelpPopUpButton;

	@FindBy(css = "button.close")
	private WebElement closeXButton;

	@FindBy(css = "i.icon-trash")
	private WebElement deleteWidgetPageButton;

	@FindBy(css = "div.bootbox.modal.fade.in")
	private WebElement deletePopUpWindow;

	@FindBy(css = "a.btn.null")
	private WebElement cancelDeletePopUpWindow;

	@FindBy(css = "a.btn.btn-primary")
	private WebElement okDeletePopUpWindow;

	@FindBy(css = "a.add.btn")
	private WebElement addNewWidget;

	@FindBy(css = "button#add_widge_page_form_btn")
	private WebElement addWidgetFormButton;

	@FindBy(css = "div.widget-content >form > div:nth-child(5) > div > label:nth-child(1) ")
	private WebElement containerAreaRadioButtons;

	@FindBy(id = "PivotType")
	private WebElement pivotPointDropdown;
	
	@FindBy(id = "PivotName")
	private WebElement pivotNameDropdown;

	@FindBy(id = "Slot")
	private WebElement slotDropdown;

	@FindBy(id = "WidgetCategory")
	private WebElement widgetType;
	
	@FindBy(css= "div.widget-content > form > div:nth-child(10)> div > label:nth-child(1)> input" )
	private WebElement widgetCleanup;

	@FindBy(id = "reset")
	private WebElement resetButton;

	@FindBy(id = "update_widget_page")
	private WebElement saveEditWidgetButton;
	
	@FindBy(css = "table#DataTables_Table_0  > tbody > tr:nth-child(1) > td:nth-child(9) > a:nth-child(1)")
	private WebElement editWidgetButton;
	
	@FindBy(css = "div.alert.alert-success")
	private WebElement confirmMessageSavedWidget;
	
	@FindBy(css = "div.alert.alert-error.fade.in")
	private WebElement errorWidgetMessage;
	
	@FindBy(css = "a.list.btn")
	private WebElement listViewButton;

	@FindBy(id = "Widget")
	private WebElement widgetName;
	
	@FindBy(id="slot_message")
	private WebElement slotMessage;
	
	@FindBy(id = "Page")
	private WebElement pageDropDown;
	
	@FindBy(id = "SubPages")
	private WebElement hotTopicsSubPagesDropDown;
	
	@FindBy(css = "a.btn.btn-mini.delete")
	private WebElement deleteButton;
	
	@FindBy(css = "select[name='DataTables_Table_0_length']")
	private WebElement recordsPerPageContainer;
	
	@FindBy(css="a[href='/widgets/managewidgets']")
	private WebElement listViewbutton;
	
	@FindBy(css="button#update_widget_page")
	private WebElement updateWidgetPageButton;
	
	@FindBy(css="i.icon-angle-right")
	private WebElement nextPageArrow;
	
	@FindBy(css="i.icon-angle-double-right")
	private WebElement lastPageArrow;
	
	@FindBy(css="i.icon-angle-double-left")
	private WebElement firstPageArrow;
	
	@FindBy(css="i.icon-angle-left")
	private WebElement previousPageArrow;
	
	public void clickOnViewAllButton() {
		Assert.assertTrue(listViewButton.isDisplayed());
		listViewButton.click();
		waitABit(5000);
	}
	
	public void confirmSuccesfullySavedWidget () {
			Assert.assertTrue(element(confirmMessageSavedWidget).isDisplayed());
	}
	
	public void clickOnResetButton() {
		resetButton.click();
		waitABit(5000);
		Assert.assertEquals("Please select a category",new Select(widgetType).getFirstSelectedOption().getText());
		Assert.assertEquals("Please select a page",new Select(pageDropDown).getFirstSelectedOption().getText());
		Assert.assertEquals("None",new Select(pivotPointDropdown).getFirstSelectedOption().getText());
		//Assert.assertEquals("1",new Select(slotDropdown).getFirstSelectedOption().getText()); //bug BMONG
		checkAllRadiobuttonsAreReset();
	}
	
	public void clickOnSaveButton() {
		
		if (saveEditWidgetButton.isDisplayed()){
			saveEditWidgetButton.click();}
			else 
				{
				if (errorWidgetMessage.isDisplayed())
			
			{selectFromDropdown(slotDropdown, "1");
			saveEditWidgetButton.click();}
		else {
			
		System.out.println("Not found!");;
		}
		
		waitABit(5000);
	}}
	public void clickOnEditButton() {
		editWidgetButton.click();
		waitABit(5000);
	}
	
	public void clickOnWidgetCleanup(String cleanup) {
		elementClick("input#CleanupWidget_"+cleanup);
	}
	
	public void selectPivotPoint(String pivot ) {
		selectFromDropdown(pivotPointDropdown, pivot);
	}
	
	public void selectPivotName(String pivotPoint,String pivotName ) {
		if(!(pivotPoint.equals("All")^pivotPoint.equals("None"))){
		selectFromDropdown(pivotNameDropdown, pivotName);
		}
	}
	
	public String selectWidgetName(String name) {
		Select widgetNameSelect=new Select(widgetName);
		widgetNameSelect.selectByVisibleText(name);
		return widgetNameSelect.getFirstSelectedOption().getAttribute("value");
		//selectFromDropdown(hotTopicsSubPagesDropDown, name);
	}
	
	public void selectSlot(String slotNumber) {
		selectFromDropdown(slotDropdown, slotNumber);
	}
	
	public void selectWidgetType(String widgetype) {
		selectFromDropdown(widgetType, widgetype);
	}
	public void addANewWidget () {
		addNewWidget.click();
	}
	public void addInsideWidgetFormButton() {
		elementClick("button#add_widge_page_form_btn");
		
//	if(getDriver().findElement(By.cssSelector("div.alert.alert-error.fade.in")).isDisplayed()){
//		selectFromDropdown(slotDropdown, "3");
//		
//	}else{
//		Assert.assertTrue("No message is displayed", getDriver().findElement(By.cssSelector("div.alert.alert-success")).isDisplayed());}
//	}
		}
	
	public void cancelDeleteWidget() {
		deleteWidgetPageButton.click();
		element(deletePopUpWindow).waitUntilVisible();
		deletePopUpWindow.click();
		Assert.assertTrue("Cancel button for delete not found", cancelDeletePopUpWindow.isDisplayed());
		cancelDeletePopUpWindow.click();
	}
	public void clickHelpButton() {
		helpButton.click();
	}
	
	public void deleteOkPopUpWindow () {
		deleteWidgetPageButton.click();
		element(deletePopUpWindow).waitUntilVisible();
		deletePopUpWindow.click();
		Assert.assertTrue("Not Found", okDeletePopUpWindow.isDisplayed());
		okDeletePopUpWindow.click();
	}

	public void clickOnNewButton(){
		element(newButton).waitUntilVisible();
		newButton.click();
	}

	public void clickOnHelpButton(){
		helpButton.click();
		element(containerHelpPopUp).waitUntilVisible();
		containerHelpPopUp.click();
		closeHelpPopUpButton.click();
	}
	
	public void closeXClickOnItFromHelp() {
		helpButton.click();
		element(containerHelpPopUp).waitUntilVisible();
		containerHelpPopUp.click();
		closeXButton.click();
	}
	
	public void selectRecordsPerPageAndVerify(String records){
		waitABit(3000);
		selectFromDropdown(recordsPerPageContainer, records);
		waitABit(5000);
		int numberOfItems = getDriver().findElements(By.cssSelector("div#content div.right-side > div:nth-child(2) > table > tbody > tr")).size();
		if(records.contains("All")){
			System.out.println("All records are displayed: " + numberOfItems);
		}
		else{
			Assert.assertTrue(numberOfItems <= Integer.parseInt(records));
		}
	}

	public void searchInputAndVerify(String search){
		String searchWord = search.toLowerCase();
		boolean check=false;
		element(searchInput).waitUntilVisible();
		searchInput.sendKeys(search);
		searchInput.sendKeys(Keys.ENTER);
		selectRecordsPerPageAndVerify("All");
		int numberOfEntries = getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody > tr")).size();
		int numberOfColumns;
		int a=0;
		String cellContent = null;
		if(numberOfEntries == 1){
			numberOfColumns = getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(1) >td")).size();
			if(numberOfColumns == 1){
				System.out.println("There are no results");
				numberOfEntries--;
				Assert.assertTrue(getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(1) >td:nth-child(1)")).getText().equals("No matching records found"));
			}
			else{
				for(int j=1; j<=numberOfColumns; j++){
					cellContent = getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(1) >td:nth-child(" + j + ")")).getText().toLowerCase();
					if(cellContent.contains(searchWord)){
						check = true;
					}
				}
				if(check==true){
					a++;
				}
			}
		}
		else{
			for(int i=1; i<=numberOfEntries; i++){
				check=false;
				numberOfColumns = getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child("+ i +") >td")).size();
				for(int j=1; j<=numberOfColumns; j++){
					cellContent = getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child("+ i +") >td:nth-child(" + j + ")")).getText().toLowerCase();
					if(cellContent.contains(searchWord)){
						check = true;
					}
				}
				if(check==true){
					a++;
				}
			}
		}
		System.out.println(a);
		Assert.assertTrue(numberOfEntries==a);
	}
	
	public void selectMainColumnName() {
		Assert.assertTrue(containerTablePageColumn.getAttribute("aria-sort").equals("ascending"));
		containerTablePageColumn.click();
		Assert.assertTrue(containerTablePageColumn.getAttribute("aria-sort").equals("descending"));
		containerTableAreaColumn.click();
		Assert.assertTrue(containerTableAreaColumn.getAttribute("aria-sort").equals("ascending"));
		containerTableSlotColumn.click();
		Assert.assertTrue(containerTableSlotColumn.getAttribute("aria-sort").equals("ascending"));
		containerTablePivotPointColumn.click();
		Assert.assertTrue(containerTablePivotPointColumn.getAttribute("aria-sort").equals("ascending"));
		containerTableNPCColumn.click();
		Assert.assertTrue(containerTableNPCColumn.getAttribute("aria-sort").equals("ascending"));
		containerTableCleanupWidgetColumn.click();
		Assert.assertTrue(containerTableCleanupWidgetColumn.getAttribute("aria-sort").equals("ascending"));
		containerTableWidgetNameColumn.click();
		Assert.assertTrue(containerTableWidgetNameColumn.getAttribute("aria-sort").equals("ascending"));
		containerTableWidgetTitleColumn.click();
		Assert.assertTrue(containerTableWidgetTitleColumn.getAttribute("aria-sort").equals("ascending"));
		containerTableActionsColumn.click();
	}
	
	public String addNewWidgetOptions(String pageName, String hotTopicsPageNumber) {
		selectFromDropdown(pageDropDown, pageName);
		 String selectPageName="";
		if(pageName.equals("Hot Topics")&&hotTopicsSubPagesDropDown.findElements(By.cssSelector("option")).size()>=2){
		Select selectHotTopicsSubPages=new Select(hotTopicsSubPagesDropDown);
		 
	    if(hotTopicsSubPagesDropDown.findElements(By.cssSelector("option")).size()==2 || Integer.parseInt(hotTopicsPageNumber)>hotTopicsSubPagesDropDown.findElements(By.cssSelector("option")).size() ){
	    selectHotTopicsSubPages.selectByIndex(0);    	
	    }else if(Integer.parseInt(hotTopicsPageNumber)<=hotTopicsSubPagesDropDown.findElements(By.cssSelector("option")).size())
	    	 selectHotTopicsSubPages.selectByIndex(Integer.parseInt(hotTopicsPageNumber));
	    if(Integer.parseInt(hotTopicsPageNumber)!=0){
	    	  selectPageName= selectHotTopicsSubPages.getFirstSelectedOption().getText();
	    }
	  
		}
		return  selectPageName;
	    
	}
	
	public void chooseAreaWidget(String area) {
		elementClick("input#AreaWP_"+area);

	}
	
	public void chooseNPCSensitiveOption(String npc) {
		elementClick("input#NPCSensitive_"+npc);
	}
	
	public void deleteFirstRow(){
		deleteButton.click();
		okDeletePopUpWindow.click();
	}
	
	public void clickAddButtonWithoutSelectingAnythingAndVerify(){
	addWidgetFormButton.click();
	Assert.assertEquals("Category can not be empty!",getDriver().findElement(By.cssSelector("div.widget-content > form > div > div > div > label")).getText());
	Assert.assertEquals("Page can not be empty",getDriver().findElement(By.cssSelector("div.widget-content > form > div:nth-child(3)> div > div > label")).getText());
	Assert.assertEquals("You need to select an area!",getDriver().findElement(By.cssSelector("div.widget-content > form > div:nth-child(5) > div > label:last-child")).getText());
	Assert.assertEquals("Set the NPC Sensitive flag!",getDriver().findElement(By.cssSelector("div.widget-content > form > div:nth-child(9) > div > label:last-child")).getText());
	Assert.assertEquals("Set the Cleanup Widget flag!",getDriver().findElement(By.cssSelector("div.widget-content > form > div:nth-child(10) > div > label:last-child")).getText());
	}
	
	public boolean verifyIfWidgetPageRelationDoesNotExist(){
		return getDriver().findElement(By.cssSelector("tbody[role='alert'] > tr > td")).getText().equals("No matching records found");
	}
	
	public void clickListViewButton(){
		listViewbutton.click();
	}
	
	public String changeSelectedOptionsRadiobuttons(String option){
		String updatedOption="";
		if(option.equals("0")){
			updatedOption=String.valueOf(Integer.parseInt(option)+1);
		}else if (option.equals("1")){
			updatedOption=String.valueOf(Integer.parseInt(option)-1);
		}
		return updatedOption;
	}
	
	public void clickUpdateWidgetPageButton(){
		updateWidgetPageButton.click();
	}
	
	public void checkNPCSelected(String npc){
		
		if(npc.equals("1")){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("input#NPCSensitive_"+npc)).getAttribute("is_checked").equals("1"));
		}
			else if(npc.equals("0")){
				Assert.assertTrue(getDriver().findElement(By.cssSelector("input#CleanupWidget_"+npc)).getAttribute("is_checked").equals("1"));
		}
	}
	
	public void checkCleanupSelected(String cleanup){
		if(cleanup.equals("1")){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("input#CleanupWidget_"+cleanup)).getAttribute("is_checked").equals("1"));
		}
			else if(cleanup.equals("0")){
				Assert.assertTrue(getDriver().findElement(By.cssSelector("input#CleanupWidget_"+cleanup)).getAttribute("is_checked").equals("1"));
		}
	}
	
	public void checkAreaSelected(String area){

		if(area.equals("3rd_column")){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("input#AreaWP_"+area)).getAttribute("is_checked").equals("1"));
		}
			else if(area.equals("preview")){
				Assert.assertTrue(getDriver().findElement(By.cssSelector("input#AreaWP_"+area)).getAttribute("is_checked").equals("1"));
			}
			else if(area.equals("bottom")){
				Assert.assertTrue(getDriver().findElement(By.cssSelector("input#AreaWP_"+area)).getAttribute("is_checked").equals("1"));
			}
	}
	
	public void checkAllRadiobuttonsAreReset(){
		WebElement formContainer=getDriver().findElement(By.cssSelector("form.form-horizontal"));
		List<WebElement> radiobuttons=formContainer.findElements(By.cssSelector("div.control-group > label > input"));
		for(WebElement radiobutton:radiobuttons){
			Assert.assertTrue(radiobutton.getAttribute("is_checked").equals("0"));
		}
	}
	
	public void navigatePagesAndVerify(){
		 //  String infoTextNumberOfEntries=getDriver().findElement(By.cssSelector("div.dataTables_info")).getText(); 
		   String infoTextNumberOfEntries=getDriver().findElement(By.cssSelector("div#DataTables_Table_0_info")).getText();
		   String infoTextSplitted[]=infoTextNumberOfEntries.split(" ");
		   String totalNumberOfEntriesWithoutComma = infoTextSplitted[5].replaceAll("[^a-zA-Z0-9]", "");
		   int totalNumberOfEntries=Integer.parseInt(totalNumberOfEntriesWithoutComma);
		   int totalNumberOfPages;
		   if(totalNumberOfEntries>10){
		   if(totalNumberOfEntries%10==0){
		    totalNumberOfPages=totalNumberOfEntries/10;
		   }
		   else
		    totalNumberOfPages=totalNumberOfEntries/10+1;
		    
		   System.out.println("total number of pages: "+totalNumberOfPages);
		   nextPageArrow.click();
		   previousPageArrow.click();
		   lastPageArrow.click();
		   waitABit(1000);
		   if(totalNumberOfPages>=5){
		    System.out.println("pageNumber in paginator:"+getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > div:nth-of-type(2) > div:nth-of-type(2)  ul > li:nth-child(7) > a")).getText());
		   Assert.assertTrue("Number of pages do not match1",getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > div:nth-of-type(2) > div:nth-of-type(2)  ul > li:nth-child(7) > a")).getText().equals(String.valueOf(totalNumberOfPages)));
		   } 
		   else if (totalNumberOfPages==4){
		    Assert.assertTrue("Number of pages do not match2",getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > div:nth-of-type(2) >  div:nth-of-type(2) ul > li:nth-child(6) > a")).getText().equals(String.valueOf(totalNumberOfPages)));
		   }
		   else if(totalNumberOfPages==3){
		    Assert.assertTrue("Number of pages do not match3",getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > div:nth-of-type(2) >  div:nth-of-type(2)  ul > li:nth-child(5) > a")).getText().equals(String.valueOf(totalNumberOfPages)));
		   }
		   
		   else if(totalNumberOfPages==2){
		    Assert.assertTrue("Number of pages do not match4",getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > div:nth-of-type(2) >  div:nth-of-type(2)  ul > li:nth-child(4) > a")).getText().equals(String.valueOf(totalNumberOfPages)));
		   }
		   
		   firstPageArrow.click();
		   waitABit(1000);
		   Assert.assertTrue("Didn't click first page or paginator didn't work",getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > div:nth-of-type(2) >  div:nth-of-type(2)  ul > li:nth-child(3) > a")).getText().equals("1"));
		   }
		   else{
		    System.out.println("Number of paginator elements is : " + getDriver().findElements(By.cssSelector("div#DataTables_Table_0_wrapper > div:nth-of-type(2) >  div:nth-of-type(2)  ul > li > a > *")).size());
		    Assert.assertTrue("Page 1 missing",getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > div:nth-of-type(2) >  div:nth-of-type(2)  ul > li:nth-child(3) > a")).getText().equals("1"));
		   }
		  }
	
	public void searchWidgetByName(String widgetName){
		//TODO Fix this
//		AbstractPage abstrPage=new AbstractPage(getDriver());
//		abstrPage.waitUntilElementExists(By.cssSelector("div#DataTables_Table_0_filter input"), 10);
		searchInput.clear();
		searchInput.click();
		searchInput.sendKeys(widgetName);
	}
	
	public boolean checkAlertIsErrorMessage(){
		
		if(getDriver().findElement(By.cssSelector("div.row-fluid > div:nth-child(2) > div:nth-of-type(2)")).getAttribute("class").contains("error")){
			return true;
		}
		else 
			return false;
	}
}

package bmo5.bmo5tests.adm.pages.dvpakcs;

import net.thucydides.core.annotations.findby.By;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class ADM_DvPacks_Listing_GeneralPage extends AbstractAdmPage {


	@FindBy(css = "ul#sidebar > li:nth-child(19)> a > span:nth-child(2)")
	private WebElement pageSelectDV;

	@FindBy(css = "ul#sidebar > li:nth-child(19) > ul:nth-child(2) > li > a > span:nth-child(1)")
	private WebElement pageSelectManageDV;

	@FindBy(css = "div#breadcrumb > div:nth-child(1) > a:nth-child(1)")
	private WebElement breadcrumb1;

	@FindBy(css = "div#breadcrumb > div:nth-child(1) > a:nth-child(2)")
	private WebElement breadcrumb2;

	@FindBy(css = "div#breadcrumb > div:nth-child(1) > a:nth-child(3)")
	private WebElement breadcrumb3;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(1)")
	private WebElement firstColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(2)")
	private WebElement secondColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(3)")
	private WebElement thirdColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(4)")
	private WebElement forthColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(5)")
	private WebElement fifthColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(6)")
	private WebElement sixthColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(7)")
	private WebElement seventhColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(8)")
	private WebElement eightColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(9)")
	private WebElement nineColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(10)")
	private WebElement tenthColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(11)")
	private WebElement elevenColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(12)")
	private WebElement twelveColumn;

	@FindBy(css = "table#DataTables_Table_0 > thead > tr > th:nth-child(13)")
	private WebElement thirteenColumn;

	@FindBy(css = "div#DataTables_Table_0_info")
	private WebElement recordsinfo;

	@FindBy(css = "table#DataTables_Table_0 > tbody > tr:nth-child(1) > td:nth-child(13) > a:nth-child(2) ")
	private WebElement clone;

	@FindBy(css = "div#DataTables_Table_0_wrapper > div:nth-child(2) > div:nth-child(2) > div > ul > li:nth-child(2) >a ")
	private WebElement previousarrow;

	@FindBy(css =  "div#DataTables_Table_0_wrapper > div:nth-child(2) > div:nth-child(2) > div > ul > li:nth-child(1) >a ")
	private WebElement previousdoublearrow;

	@FindBy(css = "div#DataTables_Table_0_wrapper > div:nth-child(2) > div:nth-child(2) > div > ul > li:nth-child(7) >a ")
	private WebElement nextdoublearrow;

	@FindBy(css = "a.add.btn")
	private WebElement newButton;

	@FindBy(css = "a.help.btn")
	private WebElement editLink;

	@FindBy(css = "a.help.btn")
	private WebElement helpButton;
	
	@FindBy(css = "div#DataTables_Table_0_filter input")
	private WebElement searchDvPackField;

	public void selectManageDVPacks(){
		pageSelectDV.click();
		Sleeper.sleepTight(4000);
		pageSelectManageDV.click();

	}

	public void verifyManageDVPacksPage() {
		Assert.assertTrue("The breadcrumb is not correct", breadcrumb1.getText().contains("Home")); 
		Assert.assertTrue("The breadcrumb is not correct", breadcrumb2.getText().contains("DV Packs")); 
		Assert.assertTrue("The breadcrumb is not correct", breadcrumb3.getText().contains("Manage DV Packs")); 


	}

	// should be changed,already created a new one
	public void verifyTable() {
		Assert.assertTrue("The column name is not correct", firstColumn.getText().contains("Dvpack ID")); 
		Assert.assertTrue("The column name is not correct", secondColumn.getText().contains("Dvpack Name")); 
		Assert.assertTrue("The column name is not correct", thirdColumn.getText().contains("Title")); 
		Assert.assertTrue("The column name is not correct", forthColumn.getText().contains("Subtitle")); 
		Assert.assertTrue("The column name is not correct", fifthColumn.getText().contains("Description")); 
		Assert.assertTrue("The column name is not correct", sixthColumn.getText().contains("Date Created")); 
		Assert.assertTrue("The column name is not correct", seventhColumn.getText().contains("Last Updated")); 
		Assert.assertTrue("The column name is not correct", eightColumn.getText().contains("Type")); 
		Assert.assertTrue("The column name is not correct", nineColumn.getText().contains("Render Type")); 
		Assert.assertTrue("The column name is not correct", tenthColumn.getText().contains("By Whom")); 
		Assert.assertTrue("The column name is not correct", elevenColumn.getText().contains("Database")); 
		Assert.assertTrue("The column name is not correct", twelveColumn.getText().contains("DV Pack Type")); 
		Assert.assertTrue("The column name is not correct", thirteenColumn.getText().contains("Actions")); 
	}

	public void changeNumberofrecordsperpage() {
		int tenrecords = 10;
		int twentyfiverecords = 25;
		int fiftyrecords=50;
		String total = recordsinfo.getText();
		String[] totalentries = total.split(" ");
		String totalEntrieWithoutComma = totalentries[5].replaceAll("[^a-zA-Z0-9]", "");
		String totalentrie = totalEntrieWithoutComma;
		int totalentrieinteger = Integer.parseInt(totalentrie);
		System.out.println("The number of total entries are " +totalentrie);
		if(totalentrieinteger > 10 ){
			Select itemsPerPage = new Select(getDriver().findElement(By.cssSelector("div#DataTables_Table_0_length > label > select")));
			itemsPerPage.selectByValue("25");
			Sleeper.sleepTight(4000);
			String text = recordsinfo.getText();
			String[] parts = text.split(" ");
			String entries = parts[3];
			int entriesinteger = Integer.parseInt(entries);

			if( entriesinteger <= twentyfiverecords && entriesinteger >= tenrecords) {
				System.out.println("The number of records per page is correct" +twentyfiverecords);
			} else {
				System.out.println("The number of records per page is not correct");
			}

			if(totalentrieinteger > 25) {
				itemsPerPage.selectByValue("50");
				Sleeper.sleepTight(4000);
				String text2 = recordsinfo.getText();
				String[] parts2 = text2.split(" ");
				String entries2 = parts2[3];
				int entriesinteger2 = Integer.parseInt(entries2);

				if( entriesinteger2 <= fiftyrecords && entriesinteger2 >= twentyfiverecords) {
					System.out.println("The number of records per page is correct" + fiftyrecords);}
				else {
					System.out.println("The number of records per page is not correct");
				}
			} else {
				System.out.println("All entries are on the page");
			}
		} else {
			System.out.println("All entries are on the page");
		}
	}

	public void pagination() {
		//		int pagenumber;
		//		Select itemsPerPage = new Select(getDriver().findElement(
		//				By.cssSelector("div#DataTables_Table_0_length > label > select")));
		//		itemsPerPage.selectByValue("10");
		//		String text=recordsinfo.getText();
		//		String[] parts= text.split(" ");
		//		String totalentrie=parts[5];
		//		int totalentries=Integer.parseInt(totalentrie);
		//		if(totalentries%10==0) {pagenumber=totalentries/10;}
		//		else {pagenumber=totalentries/10+1;}
		//
		//		if (pagenumber>1){  int nextarrow=pagenumber+2+1,doublearrow=pagenumber+2+2;
		//
		//		getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > div:nth-child(2) > div:nth-child(2) > div > ul > li:nth-child(" + nextarrow + ") > a")).click();
		//		Sleeper.sleepTight(4000);
		//		String nexttext=recordsinfo.getText();
		//		String[] nextparts= nexttext.split(" ");
		//		String pageentrie1=nextparts[1];
		//		int pageentries1=Integer.parseInt(pageentrie1);
		//		if(pageentries1==11){System.out.println("Next arrow works");}
		//		else {System.out.println("Next arrow does not work");}
		//
		//		previousarrow.click();
		//		String previoustext=recordsinfo.getText();
		//		String[] previousparts= previoustext.split(" ");
		//		String pageentrie2=previousparts[1];
		//		int pageentries2=Integer.parseInt(pageentrie2);
		//		if(pageentries2==1){System.out.println("Previous arrow works");}
		//		else {System.out.println("Previous arrow does not work");}
		//
		//		getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > div:nth-child(2) > div:nth-child(2) > div > ul > li:nth-child(" + doublearrow + ") > a")).click();
		//		String doublenexttext=recordsinfo.getText();
		//		String[] doublenextparts= doublenexttext.split(" ");
		//		String pageentrie3=doublenextparts[3];
		//		int pageentries3=Integer.parseInt(pageentrie3);
		//		if(pageentries3==totalentries){System.out.println("Double next arrow works");}
		//		else {System.out.println("Double next arrow does not work");}
		//
		//		previousdoublearrow.click();
		//		String previousdoubletext=recordsinfo.getText();
		//		String[] previousdoubleparts= previousdoubletext.split(" ");
		//		String pageentrie4=previousdoubleparts[1];
		//		int pageentries4=Integer.parseInt(pageentrie4);
		//		if(pageentries4==1){System.out.println("Previous arrow works");}
		//		else {System.out.println("Previous arrow does not work");}
		//		}
		//
		//		else {System.out.println("All entries are on the page.Next arrow is not available");}
		//
		nextdoublearrow.click();
		previousarrow.click();
		previousdoublearrow.click();
	}

	public void orderColumn(){

		String s1 = getDriver().findElement(By.cssSelector(" table#DataTables_Table_0 > tbody > tr:nth-child(1) > td:nth-child(1)")).getText();
		String s2 = getDriver().findElement(By.cssSelector(" table#DataTables_Table_0 > tbody > tr:nth-child(2) > td:nth-child(1)")).getText();
		System.out.println("Comparing \"" + s1 + "\" to \"" + s2 + "\"...");
		int comparisonResult = s1.compareTo(s2);
		System.out.println("The result of the comparison was " + comparisonResult);
		System.out.print("This means that \"" + s1 + "\" ");
		if(comparisonResult < 0){
			System.out.println("lexicographically precedes \"" + s2 + "\".");
			System.out.println("The column is ordered.");
		}else if(comparisonResult > 0){
			System.out.println("lexicographically follows \"" + s2 + "\".");
			System.out.println("The column is not ordered.");
		}else{
			System.out.println("equals \"" + s2 + "\".");
			System.out.println("The column is ordered.");
		}

		firstColumn.click();
		String s11 = getDriver().findElement(By.cssSelector(" table#DataTables_Table_0 > tbody > tr:nth-child(1) > td:nth-child(1)")).getText();
		String s22 = getDriver().findElement(By.cssSelector(" table#DataTables_Table_0 > tbody > tr:nth-child(2) > td:nth-child(1)")).getText();
		System.out.println("Comparing \"" + s11 + "\" to \"" + s22 + "\"...");
		int comparisonResult2 = s11.compareTo(s22);
		System.out.println("The result of the comparison was " + comparisonResult2);
		System.out.print("This means that \"" + s11 + "\" ");
		if(comparisonResult2 < 0){
			System.out.println("lexicographically precedes \"" + s22 + "\".");
			System.out.println("The column is not ordered.");
		}else if(comparisonResult > 0){
			System.out.println("lexicographically follows \"" + s22 + "\".");
			System.out.println("The column is  ordered.");
		}else{
			System.out.println("equals \"" + s2 + "\".");
			System.out.println("The column is ordered.");
		}


	}

	public void cloneDVPack() {
		String text=recordsinfo.getText();
		String[] parts= text.split(" ");
		String pageentrie=parts[1];
		int pageentries=Integer.parseInt(pageentrie);
		if(pageentries==0){System.out.println("There are no data in the table.");}
		else {
			String dvpackname = getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(1) > td:nth-child(2)")).getText();
			System.out.println(dvpackname);
			String title = getDriver().findElement(By.cssSelector(" table#DataTables_Table_0 > tbody > tr:nth-child(1) > td:nth-child(3)")).getText();
			System.out.println(title);
			String subtitle = getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr:nth-child(1) > td:nth-child(4)")).getText();
			System.out.println(subtitle);
			String database = getDriver().findElement(By.cssSelector(" table#DataTables_Table_0 > tbody > tr:nth-child(1) > td:nth-child(10)")).getText();
			System.out.println("database "+database);
			String dvpacktype = getDriver().findElement(By.cssSelector(" table#DataTables_Table_0 > tbody > tr:nth-child(1) > td:nth-child(11)")).getText();
			System.out.println("type "+dvpacktype);
			clone.click();
			String clonedvpackname = getDriver().findElement(By.cssSelector(" input#dvpn")).getAttribute("value");
			System.out.println(clonedvpackname);
			String clonetitle = getDriver().findElement(By.cssSelector("input#title")).getAttribute("value");
			System.out.println(clonetitle);
			String clonesubtitle = getDriver().findElement(By.cssSelector("input#subtitle")).getAttribute("value");
			System.out.println(clonesubtitle);
			String clonedvpacktype = getDriver().findElement(By.cssSelector("select#type")).getAttribute("value");
			System.out.println("cloneType " + clonedvpacktype);
			String clonedatabase = getDriver().findElement(By.cssSelector("select#database")).getAttribute("value");
			System.out.println("clonedatabase "+ clonedatabase);
			if(dvpackname.equals(clonedvpackname) && title.equals(clonetitle) && subtitle.equals(clonesubtitle) && database.equals(clonedatabase) && dvpacktype.equals(clonedvpacktype)){System.out.println("Clone button works");}
			else {System.out.println("Clone button does not work.");}

		}
	}

	public void clickOnAddNewDvPackButton(String newButtonText) {
		Assert.assertTrue(newButton.getText().contains(newButtonText));
		newButton.click();
	}

	public void clickOnHelpButton(String help) {
		Assert.assertTrue(helpButton.getText().contains(help));
		helpButton.click();
	}

	public void verifyTableColumnsTitleOnPage(String dvPackId,String dvPackName,String title, String subtitle,String description,String dateCreated,String lastUpdated,String type,String renderType,String byWhom,String database,String dvPackType,String actions) {
		Assert.assertTrue("The column name is not correct", firstColumn.getText().contains(dvPackId)); 
		Assert.assertTrue("The column name is not correct", secondColumn.getText().contains(dvPackName)); 
		Assert.assertTrue("The column name is not correct", thirdColumn.getText().contains(title)); 
		Assert.assertTrue("The column name is not correct", forthColumn.getText().contains(subtitle)); 
		Assert.assertTrue("The column name is not correct", fifthColumn.getText().contains(description)); 
		Assert.assertTrue("The column name is not correct", sixthColumn.getText().contains(dateCreated)); 
		Assert.assertTrue("The column name is not correct", seventhColumn.getText().contains(lastUpdated)); 
		Assert.assertTrue("The column name is not correct", eightColumn.getText().contains(type)); 
		Assert.assertTrue("The column name is not correct", nineColumn.getText().contains(renderType)); 
		Assert.assertTrue("The column name is not correct", tenthColumn.getText().contains(byWhom)); 
		Assert.assertTrue("The column name is not correct", elevenColumn.getText().contains(database)); 
		Assert.assertTrue("The column name is not correct", twelveColumn.getText().contains(dvPackType)); 
		Assert.assertTrue("The column name is not correct", thirteenColumn.getText().contains(actions)); 
	}

	public void clickOnEditLink(String rowNumber) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > table > tbody > tr:nth-child("+rowNumber+") > td:nth-child(13) > a:nth-child(1)")).isDisplayed());
		getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > table > tbody > tr:nth-child("+rowNumber+") > td:nth-child(13) > a:nth-child(1)")).click();
	}

	public void clickOnCloneLink(String rowNumber) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > table > tbody > tr:nth-child("+rowNumber+") > td:nth-child(13) > a:nth-child(2)")).isDisplayed());
		getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > table > tbody > tr:nth-child("+rowNumber+") > td:nth-child(13) > a:nth-child(2)")).click();
	}

	public void clickOnDeleteLink(String rowNumber) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > table > tbody > tr:nth-child("+rowNumber+") > td:nth-child(13) > a:nth-child(3)")).isDisplayed());
		getDriver().findElement(By.cssSelector("div#DataTables_Table_0_wrapper > table > tbody > tr:nth-child("+rowNumber+") > td:nth-child(13) > a.btn.btn-link.btn-link-delete.delete:nth-child(3)")).click();
	}
	
	public void checkTableIntoListView(String dvPackId, String name, String title, String type, String renderType, String databaseType, String dvPackType) {
		waitUntilElementExists(By.cssSelector("div.dvpacks-table"), 30);
		searchDvPackField.click();
		searchDvPackField.sendKeys(dvPackId);
		waitUntilElementExists(By.cssSelector("table#DataTables_Table_0 > tbody > tr"), 30);
		Assert.assertTrue(getDriver().findElements(By.cssSelector("table#DataTables_Table_0 > tbody > tr")).size() == 1);
		Assert.assertTrue("The id of the dv pack is not correct", getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr > td:nth-child(1)")).getText().contains(dvPackId));
		Assert.assertTrue("The name of the dv pack is not correct", getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr > td:nth-child(2)")).getText().contains(name));
		Assert.assertTrue("The title of the dv pack is not correct", getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr > td:nth-child(3)")).getText().contains(title));
		Assert.assertTrue("The type of the dv pack is not correct", getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr > td:nth-child(8)")).getText().contains(type));
		Assert.assertTrue("The render type of the dv pack is not correct", getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr > td:nth-child(9)")).getText().contains(renderType));
		Assert.assertTrue("The database of the dv pack is not correct", getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr > td:nth-child(11)")).getText().contains(databaseType));
		Assert.assertTrue("The dv pack type of the dv pack is not correct", getDriver().findElement(By.cssSelector("table#DataTables_Table_0 > tbody > tr > td:nth-child(12)")).getText().contains(dvPackType));
		
	}
}


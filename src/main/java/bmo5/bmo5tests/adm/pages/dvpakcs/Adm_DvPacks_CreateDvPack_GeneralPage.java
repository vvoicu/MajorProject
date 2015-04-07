package bmo5.bmo5tests.adm.pages.dvpakcs;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;

public class Adm_DvPacks_CreateDvPack_GeneralPage extends AbstractAdmPage{

	@FindBy(css = "button#filter-display-data")
	private WebElement displayDataButton;
	
	@FindBy(css = "button#filter-clear")
	private WebElement clearFiltersButton;
	
	@FindBy(css = "button#back")
	private WebElement backButton;
	
	@FindBy(css = "button#continue")
	private WebElement continueButton;
	
	@FindBy(css = "table.dvpack_table.dataTable > tbody")
	private WebElement dvpackPreviewTableBody;
	
	@FindBy(css = "div#modal-geographies a")
	private WebElement cancelLinkFromPreviewForWindow;
	
	@FindBy(css = "button#filter-preview-data")
	private WebElement displayDataButtonFromLandingPageTemplateDvPack;
	
	@FindBy(css = "button#load-chart-annotate")
	private WebElement annotateChartButton;
	
	@FindBy(css = "button#load-chart-annotate > i")
	private WebElement annotateChartButtonArrow;
	
	@FindBy(css = "form#form-annotation-list > button")
	private WebElement newButtonAnnotateChart;
	
	@FindBy(css = "select#annotation-type")
	private WebElement annotationTypeContainer;
	
	@FindBy(css = "input#annotation-description")
	private WebElement descriptionChartAnnotationInputBox;
	
	@FindBy(css = "input#annotation-text-rotation")
	private WebElement rotationChartTextAnnoationInputBox;
	
	@FindBy(css = "select#annotation-text-size")
	private WebElement textSizeContainer;
	
	@FindBy(css = "form#form-annotation-new button.btn.submit")
	private WebElement addToChartButtonAnnotateChart;
	
	@FindBy(css = "form#form-annotation-new button.btn.btn-link")
	private WebElement backToListButtonAnnotateChart;
	
	@FindBy(css = "select#annotation-line-type")
	private WebElement lineTypeContainer;
	
	@FindBy(css = "select#text-annotation-size")
	private WebElement textSizeContainerFromEditChartAnnotationWindow;
	
	@FindBy(css = "input#text-annotation-rotation")
	private WebElement rotationInputBoxFromEditChartAnnotationWindow;
	
	@FindBy(css = "input#text-annotation-text")
	private WebElement descriptionInputBoxFromEditChartAnnotationWindow;
	
	@FindBy(css = "button#text-annotation-remove")
	private WebElement removeLinkFromEditTextChartAnnotationWindow;
	
	@FindBy(css = "button#text-annotation-cancel")
	private WebElement cancelLinkFromEditTextChartAnnotationWindow;
	
	@FindBy(css = "button[class='btn btn-small submit']")
	private WebElement saveButtonFromEditChartAnnotationWindow;
	
	@FindBy(css = "select#line-annotation-dashstyle")
	private WebElement lineTypeContainerFromEditAnnotationWindow;
	
	@FindBy(css = "button#line-annotation-remove")
	private WebElement removeLinkFromEditAnnotationWindow;
	
	@FindBy(css = "button#line-annotation-cancel")
	private WebElement cancelLinkFromEditAnnotationWindow;
	
	@FindBy(css = "button#load-table-format")
	private WebElement formatButtonTable;
	
	@FindBy(css = "button#load-chart-format")
	private WebElement formatButtonChart;
	
	@FindBy(css = "button#update-table")
	private WebElement updateTableButton;
	
	@FindBy(css = "button#update-chart")
	private WebElement updateChartButton;
	
	@FindBy(css = "select#render-type")
	private WebElement renderTypeContainerFormatChartWindow;
	
	@FindBy(css = "select#x-text-direction")
	private WebElement xAxisOrientationContainerFormatChartwindow;
	
	@FindBy(css = "button#legend-reset")
	private WebElement resetLegendButton;
	
	@FindBy(css = "button#legend-disable")
	private WebElement removeLegendButton;
	
	@FindBy(css = "button#legend-enable")
	private WebElement moveLegendButton;
	
	@FindBy(css = "input#chart-markers")
	private WebElement markersCheckBox;
	
	@FindBy(css = "input#left_yaxis_min")
	private WebElement minInputBoxY1axis;
	
	@FindBy(css = "input#left_yaxis_max")
	private WebElement maxInputBoxY1axis;
	
	@FindBy(css = "input#left_yaxis_incr")
	private WebElement incrementsInputBoxY1axis;
	
	@FindBy(css = "input#right_yaxis_min")
	private WebElement minInputBoxY2axis;
	
	@FindBy(css = "input#right_yaxis_max")
	private WebElement maxInputBoxY2axis;
	
	@FindBy(css = "input#right_yaxis_incr")
	private WebElement incrementsInputBoxY2axis;
	
	@FindBy(css = "select[class='chart-type-selection custom-size']")
	private WebElement chartTypeContainerFormatWindow;
	
	@FindBy(css = "input#stacked-flag")
	private WebElement stackedCheckBoxFormatWindow;
	
	@FindBy(css = "input#enable_grid_lines-flag")
	private WebElement enableGridLinesCheckBoxFormatWindow;
	
	@FindBy(css = "select#table-annotation-type ")
	private WebElement containerTypeTableAnnotation;
	
	public List<String> indicators=new ArrayList<String>();
	
	public void checkOneParent(int filterNumber, String parentName){
		waitUntilElementDoesntExist(By.cssSelector("div.loading"), 10);
		waitUntilElementExists(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + filterNumber + ") li > label"), 10);
		WebElement element = getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + filterNumber + ")"));
		List<WebElement> parents =  element.findElements(By.cssSelector(" li > label"));
		for(WebElement parent:parents){
			try{
				if(parent.getText().contains(parentName)){
					parent.click();
					break;
				}
			} catch (StaleElementReferenceException sere) {
				
			}
		}
	}
	
	public void checkOneChild(int filterNumber, String childName){
		waitUntilElementExists(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + filterNumber + ") li > label"), 10);
		WebElement searchInputBox = getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + filterNumber + ")  li.quick-search > input"));
		searchInputBox.sendKeys(childName);
		waitUntilElementDoesntExist(By.cssSelector("div.loading"), 10);
		waitUntilElementExists(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + filterNumber + ") li > label"), 10);
		WebElement element = getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + filterNumber + ")"));
		List<WebElement> children = element.findElements(By.cssSelector(" li > label")); //[style='display: list-item;']
		for(WebElement child:children){
			System.out.println(child.getText());
			try{
				if(child.getText().contains(childName)){
					child.click();
					break;
				}
			} catch (StaleElementReferenceException sere) {
				
			}
		}
	}
	
	public void selectOptionsFromDropDownLists(int filterNumber, String optionOne, String optionTwo){
		selectFromDropdown(getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + filterNumber + ") ul  div.controls > select:nth-child(1)")), optionOne);
		selectFromDropdown(getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + filterNumber + ") ul  div.controls > select:nth-child(2)")), optionTwo);
	}
	
	public void selectDateRangesFromDropDownLists(String dateRangeFrom, String dateRangeTo, String dvpackType){
		  //aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(5) label.checkbox
		if(dvpackType.equals("Static")){
		  selectFromDropdown(getDriver().findElement(By.cssSelector("select#start_token")), dateRangeFrom);
		  selectFromDropdown(getDriver().findElement(By.cssSelector("select#end_token")), dateRangeTo);
		}
		else{
		   selectFromDropdown(getDriver().findElement(By.cssSelector("select#start_date")), dateRangeFrom);
		   selectFromDropdown(getDriver().findElement(By.cssSelector("select#end_date")), dateRangeTo);
		}
	}
	
	public void insertValuesIntoBoxes(int filterNumber, String firstInput, String secondInput){
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + filterNumber + ") ul> div:nth-child(1) input")).sendKeys(firstInput);
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + filterNumber + ") ul> div:nth-child(2) input")).sendKeys(secondInput);
	}
	
	public void verifyPreviewForPopUpWindow(){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#modal-geographies h3")).getText().contains("Preview for:"));
		Assert.assertTrue(cancelLinkFromPreviewForWindow.isDisplayed());
		Assert.assertTrue(displayDataButton.isDisplayed());
	}
	
	public void checkOneGeographyFromPreviewTemplateDvPack(String geography){
		waitUntilElementExists(By.cssSelector("div#modal-geographies > div.modal-body > ul > li > ul li label"), 10);
		WebElement searchInputBox = getDriver().findElement(By.cssSelector("div#modal-geographies > div.modal-body > ul > li > ul li.quick-search > input"));
		searchInputBox.sendKeys(geography);
		waitUntilElementDoesntExist(By.cssSelector("div.loading"), 10);
		waitUntilElementExists(By.cssSelector("div#modal-geographies > div.modal-body > ul > li > ul li > label"), 10);
		WebElement element = getDriver().findElement(By.cssSelector("div#modal-geographies > div.modal-body > ul > li > ul"));
		List<WebElement> children = element.findElements(By.cssSelector(" li > label")); //[style='display: list-item;']
		for(WebElement child:children){
			System.out.println(child.getText());
			try{
				if(child.getText().contains(geography)){
					child.click();
					break;
				}
			} catch (StaleElementReferenceException sere) {
				
			}
		}
	}
	
	public void clickOnDisplayDataButtonFromLandingPageTemplateDvPack(){
		displayDataButtonFromLandingPageTemplateDvPack.click();
	}
	
	/**
	 * This method can be used for NDB and Ratings databases.
	 * It selects from filters one country, one indicator and date ranges interval(e.g. -2 , +2)
	 * @param country
	 * @param indicator
	 * @param dateRangeFrom: the first value of the date ranges interval that means: current year + that value(here: 2014 - 2 = 2012)
	 * @param dateRangeTo: the second value of the date ranges interval that means: current year + that value(here: 2014 + 2 = 2016)
	 */
	public void selectDataFromFiltersNdb(String country, String indicator, String dateRangeFrom, String dateRangeTo, String dvpackType){
		int numberOfFilters = getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") div.controls select")).size() > 0){
				selectDateRangesFromDropDownLists(dateRangeFrom, dateRangeTo, dvpackType);
			}
			else if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ")  li.quick-search > input")).size() == 1){
					if(i==1){
						checkOneChild(i, country);
					}
					else{
						checkOneChild(i, indicator);
					}
				}
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	public void selectDataFromFiltersRatings(String country, String indicator, String dateRangeFrom, String dateRangeTo, String dvpackType){
		int numberOfFilters = getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") div.controls select")).size() > 0){
				selectDateRangesFromDropDownLists(dateRangeFrom, dateRangeTo, dvpackType);
			}
			else if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ")  li.quick-search > input")).size() == 1){
					if(i==1){
						checkOneChild(i, country);
					}
					else{
						checkOneParent(i, indicator);
					}
				}
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	/**
	 * This method can be used for Key Projects Databases: Infrastructure, Power, Renewables
	 * @param region
	 * @param startDateOperator
	 * @param startYear
	 * @param endDateOperator
	 * @param endYear
	 * @param status
	 * @param sector
	 * @param fromValue
	 * @param toValue
	 */
	public void selectDataFromFiltersKeyProjects(String region, String startDateOperator, String startYear, String endDateOperator, String endYear, String status, String sector, String fromValue, String toValue){
		int numberOfFilters = getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") div.controls select")).size() > 0){
				if(i==2){
					selectOptionsFromDropDownLists(i, startDateOperator, startYear);
				}
				else{
					selectOptionsFromDropDownLists(i, endDateOperator, endYear);
				}
			}
			else if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				if(i == 1){
					checkOneParent(i, region);
				}
				else if(i == 4){
					checkOneParent(i, status);
				}
				else{
					checkOneParent(i, sector);
				}
				
			}
			else if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") input[type='text'][value]")).size() > 0){
				insertValuesIntoBoxes(i, fromValue, toValue);
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	public void selectDataFromFiltersUpstreamProjects(String region, String status, String fromEstPeakOil, String toEstPeakOil, String fromEstPeakGas, String toEstPeakGas, String fromProjectCost, String toProjectCost, String onshoreOrOffshore, String hydrocarbonType){
		int numberOfFilters = getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				if(i == 1){
					checkOneParent(i, region);
				}
				else if(i == 2){
					checkOneParent(i, status);
				}
				else if(i == 6){
					checkOneParent(i, onshoreOrOffshore);
				}
				else{
					checkOneParent(i, hydrocarbonType);
				}
			}
			else if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") input[type='text'][value]")).size() > 0){
				if(i == 3){
					insertValuesIntoBoxes(i, fromEstPeakOil, toEstPeakOil);
				}
				else if(i == 4){
					insertValuesIntoBoxes(i, fromEstPeakGas, toEstPeakGas);
				}
				else{
					insertValuesIntoBoxes(i, fromProjectCost, toProjectCost);
				}
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	public void selectDataFromFiltersGlobalRefineries(String region, String status, String fromCapacityBD, String toCapacityBD, String fromCapacityTPA, String toCapacityTPA, String startDateOperator, String startYear, String endDateOperator, String endYear){
		int numberOfFilters = getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") div.controls select")).size() > 0){
				if(i == 5){
					selectOptionsFromDropDownLists(i, startDateOperator, startYear);
				}
				else{
					selectOptionsFromDropDownLists(i, endDateOperator, endYear);
				}
			}
			else if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				if(i == 1){
					checkOneParent(i, region);
				}
				else{
					checkOneParent(i, status);
				}
			}
			else if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") input[type='text'][value]")).size() > 0){
				if(i == 3){
					insertValuesIntoBoxes(i, fromCapacityBD, toCapacityBD);
				}
				else{
					insertValuesIntoBoxes(i, fromCapacityTPA, toCapacityTPA);
				}
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	public void selectDataFromFiltersGlobalMines(String region, String metal, String fromCapex, String toCapex, String fromOreGrade, String toOreGrade, String dateRangeFrom, String dateRangeTo, String endDateOperator, String endYear, String letter, String status, String dvpackType){
		int numberOfFilters = getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") div.controls select")).size() > 0){
				selectDateRangesFromDropDownLists(dateRangeFrom, dateRangeTo, dvpackType);
			}
			else if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				if(i == 1){
					checkOneParent(i, region);
				}
				else if(i == 2){
					checkOneParent(i, metal);
				}
				else if(i == 3){
					checkOneParent(i, letter);
				}
				else{
					checkOneParent(i, status);
				}
			}
			else if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") input[type='text'][value]")).size() > 0){
				if(i == 5){
					insertValuesIntoBoxes(i, fromCapex, toCapex);
				}
				else{
					insertValuesIntoBoxes(i, fromOreGrade, toOreGrade);
				}
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	public void selectDataFromFiltersBODD(String region, String indicator, String age, String gender, String dateRangeFrom, String dateRangeTo, String dvpackType){
		int numberOfFilters = getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") div.controls select")).size() > 0){
				selectDateRangesFromDropDownLists(dateRangeFrom, dateRangeTo, dvpackType);
			}
			else if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				if(i == 1){
					checkOneParent(i, region);
				}
				else if(i == 2){
					checkOneParent(i, indicator);
				}
				else if(i == 3){
					checkOneParent(i, age);
				}
				else{
					checkOneParent(i, gender);
				}
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	public void selectDataFromFiltersMOD(String region, String operator, String indicator, String dateRangeFrom, String dateRangeTo, String dvpackType){
		int numberOfFilters = getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") div.controls select")).size() > 0){
				selectDateRangesFromDropDownLists(dateRangeFrom, dateRangeTo, dvpackType);
			}
			else if(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				if(i == 1){
					checkOneParent(i, region);
				}
				else if(i == 2){
					checkOneParent(i, operator);
				}
				else{
					checkOneParent(i, indicator);
				}
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	/**
	 * This method can be used for NDB and Ratings databases.
	 * It selects from filters one country, one indicator and date ranges interval(e.g. -2 , +2)
	 * @param country
	 * @param indicator
	 * @param dateRangeFrom: the first value of the date ranges interval that means: current year + that value(here: 2014 - 2 = 2012)
	 * @param dateRangeTo: the second value of the date ranges interval that means: current year + that value(here: 2014 + 2 = 2016)
	 */
	public void selectDataFromFiltersNdbTemplateDvPack(String indicator, String dateRangeFrom, String dateRangeTo, String dvpackType){
		int numberOfFilters = getDriver().findElements(By.cssSelector("div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") div.controls select")).size() > 0){
				selectDateRangesFromDropDownLists(dateRangeFrom, dateRangeTo, dvpackType);
			}
			else if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ")  li.quick-search > input")).size() == 1){
					checkOneChild(i, indicator);
				}
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	public void selectDataFromFiltersRatingsTemplateDvPack(String indicator, String dateRangeFrom, String dateRangeTo, String dvpackType){
		int numberOfFilters = getDriver().findElements(By.cssSelector("div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") div.controls select")).size() > 0){
				selectDateRangesFromDropDownLists(dateRangeFrom, dateRangeTo, dvpackType);
			}
			else if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ")  li.quick-search > input")).size() == 1){
					checkOneParent(i, indicator);
				}
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	/**
	 * This method can be used for Key Projects Databases: Infrastructure, Power, Renewables
	 * @param region
	 * @param startDateOperator
	 * @param startYear
	 * @param endDateOperator
	 * @param endYear
	 * @param status
	 * @param sector
	 * @param fromValue
	 * @param toValue
	 */
	public void selectDataFromFiltersKeyProjectsTemplateDvPack(String startDateOperator, String startYear, String endDateOperator, String endYear, String status, String sector, String fromValue, String toValue){
		int numberOfFilters = getDriver().findElements(By.cssSelector("div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") div.controls select")).size() > 0){
				if(i == 1){
					selectOptionsFromDropDownLists(i, startDateOperator, startYear);
				}
				else{
					selectOptionsFromDropDownLists(i, endDateOperator, endYear);
				}
			}
			else if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				if(i == 3){
					checkOneParent(i, status);
				}
				else{
					checkOneParent(i, sector);
				}
				
			}
			else if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") input[type='text'][value]")).size() > 0){
				insertValuesIntoBoxes(i, fromValue, toValue);
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	public void selectDataFromFiltersUpstreamProjectsTemplateDvPack(String status, String fromEstPeakOil, String toEstPeakOil, String fromEstPeakGas, String toEstPeakGas, String fromProjectCost, String toProjectCost, String onshoreOrOffshore, String hydrocarbonType){
		int numberOfFilters = getDriver().findElements(By.cssSelector("div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				if(i == 1){
					checkOneParent(i, status);
				}
				else if(i == 5){
					checkOneParent(i, onshoreOrOffshore);
				}
				else{
					checkOneParent(i, hydrocarbonType);
				}
			}
			else if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") input[type='text'][value]")).size() > 0){
				if(i == 2){
					insertValuesIntoBoxes(i, fromEstPeakOil, toEstPeakOil);
				}
				else if(i == 3){
					insertValuesIntoBoxes(i, fromEstPeakGas, toEstPeakGas);
				}
				else{
					insertValuesIntoBoxes(i, fromProjectCost, toProjectCost);
				}
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	public void selectDataFromFiltersGlobalRefineriesTemplateDvPack(String status, String fromCapacityBD, String toCapacityBD, String fromCapacityTPA, String toCapacityTPA, String startDateOperator, String startYear, String endDateOperator, String endYear){
		int numberOfFilters = getDriver().findElements(By.cssSelector("div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") div.controls select")).size() > 0){
				if(i == 4){
					selectOptionsFromDropDownLists(i, startDateOperator, startYear);
				}
				else{
					selectOptionsFromDropDownLists(i, endDateOperator, endYear);
				}
			}
			else if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				checkOneParent(i, status);
			}
			else if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") input[type='text'][value]")).size() > 0){
				if(i == 2){
					insertValuesIntoBoxes(i, fromCapacityBD, toCapacityBD);
				}
				else{
					insertValuesIntoBoxes(i, fromCapacityTPA, toCapacityTPA);
				}
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	public void selectDataFromFiltersGlobalMinesTemplateDvPack(String metal, String fromCapex, String toCapex, String fromOreGrade, String toOreGrade, String dateRangeFrom, String dateRangeTo, String endDateOperator, String endYear, String letter, String status, String dvpackType){
		int numberOfFilters = getDriver().findElements(By.cssSelector("div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") div.controls select")).size() > 0){
				selectDateRangesFromDropDownLists(dateRangeFrom, dateRangeTo, dvpackType);
			}
			else if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				if(i == 1){
					checkOneParent(i, metal);
				}
				else if(i == 2){
					checkOneParent(i, letter);
				}
				else{
					checkOneParent(i, status);
				}
			}
			else if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") input[type='text'][value]")).size() > 0){
				if(i == 4){
					insertValuesIntoBoxes(i, fromCapex, toCapex);
				}
				else{
					insertValuesIntoBoxes(i, fromOreGrade, toOreGrade);
				}
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	public void selectDataFromFiltersBODDTemplateDvPack(String indicator, String age, String gender, String dateRangeFrom, String dateRangeTo, String dvpackType){
		int numberOfFilters = getDriver().findElements(By.cssSelector("div.sidebar.well > ul ")).size();
		int i, j;
		for(i=1; i<=numberOfFilters; i++){
//			getDriver().findElement(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") h5")).click();
//			Assert.assertTrue(getDriver().findElements(By.cssSelector("aside#dvpack-sidebar > div.sidebar.well > ul:nth-of-type(" + i + ") i.icon-down-dir")).size() == 1);
			if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") div.controls select")).size() > 0){
				selectDateRangesFromDropDownLists(dateRangeFrom, dateRangeTo, dvpackType);
			}
			else if(getDriver().findElements(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + i + ") input[type='checkbox']")).size() > 0){
				if(i == 1){
					checkOneParent(i, indicator);
				}
				else if(i == 2){
					checkOneParent(i, age);
				}
				else{
					checkOneParent(i, gender);
				}
			}
			else{
				System.out.println("There is no such element");
			}
			j = i+1;
			if(j<=numberOfFilters){
				getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-of-type(" + j + ") h5")).click();
			}
			else{
				System.out.println("Data has been selected from all filters.");
			}
		}
	}
	
	public void clickOnDisplayDataButtonAndVerify(){
		displayDataButton.click();
		System.out.println("done!");
	}
	
	public void clickOnClearFiltersButton(){
		clearFiltersButton.click();
		Sleeper.sleepTight(5000);
	}
	
	public void verifyIfFiltersAreCleared(){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(1) h5 > span > span")).getText().contains("0"));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(2) h5")).getAttribute("class").contains("inactive"));
//		Assert.assertTrue(displayDataButton.getAttribute("class").contains("inactive") || displayDataButton.getAttribute("disabled").contains("disabled"));
	}
	
	public void verifyAndClickOnBackButton() {
		Assert.assertTrue(backButton.isDisplayed());
		backButton.click();
	}
	
	public void clickOnContinueButton(){
//		continueButton.click();
		elementClick("button#continue");
	}
	
	public int returnNumbeOfRowsFromTable(){
		if(getDriver().findElements(By.cssSelector("div#dynamic_table > table")).size()==1){
			return 	dvpackPreviewTableBody.findElements(By.cssSelector("tr")).size();
		}else
			return 0;
	}
	
	public void verifyButtonsPresenceForStaticDvPAck(){
		waitUntilElementExists(By.cssSelector("table.dvpack_table.dataTable > tbody tr"), 40);
		Assert.assertTrue(getDriver().findElements(By.cssSelector("button#load-dvpack-select")).size() == 1);
		Assert.assertTrue(getDriver().findElements(By.cssSelector("button#load-table-format")).size() == 1 || getDriver().findElements(By.cssSelector("button#load-chart-format")).size() == 1);
		Assert.assertTrue(getDriver().findElements(By.cssSelector("button#load-table-annotate")).size() == 1);
		Assert.assertTrue(getDriver().findElements(By.cssSelector("button#load-chart-annotate")).size() == 1);
	}
	
	public void verifyButtonsPresenceForDynamicDvPack(){
		waitUntilElementExists(By.cssSelector("table.dvpack_table.dataTable > tbody tr"), 40);
		Assert.assertTrue(getDriver().findElements(By.cssSelector("button#load-dvpack-select")).size() == 1);
		Assert.assertTrue(getDriver().findElements(By.cssSelector("button#load-table-format")).size() == 1 || getDriver().findElements(By.cssSelector("button#load-chart-format")).size() == 1);
		Assert.assertTrue(getDriver().findElements(By.cssSelector("button#load-table-annotate")).size() == 0);
		Assert.assertTrue(getDriver().findElements(By.cssSelector("button#load-chart-annotate")).size() == 0);
	}
	
	public void verifyWidgetStaticTabelCountryColumnAndFormatAnnotateButtons(String country) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#dynamic_table > table  > thead > tr > th[class = 'dvpack_table_header_entry dvpack_table_data_type_country']")).getText().contains(country));
		System.out.println("table found!");
		if(getDriver().findElements(By.cssSelector("button#load-table-annotate")).size() ==1){
			System.out.println("annotate button found!");
		Assert.assertTrue(getDriver().findElement(By.cssSelector("button#load-table-annotate")).isDisplayed());}
		else
		{
			System.out.println("A dynamic table widget is created now!");
			Assert.assertTrue(getDriver().findElement(By.cssSelector("button#load-table-format")).isDisplayed());
		}
		
	}
	
	public void clickOnAddAnnotateChartAndVerify(){
		annotateChartButton.click();
		Assert.assertTrue(annotateChartButtonArrow.getAttribute("class").contains("down"));
		Assert.assertTrue(newButtonAnnotateChart.isDisplayed());
	}
	
	public void clickOnNewButtonAndVerify(){
		newButtonAnnotateChart.click();
		Assert.assertTrue(annotationTypeContainer.isDisplayed());
		Assert.assertTrue(descriptionChartAnnotationInputBox.isDisplayed());
		Assert.assertTrue(rotationChartTextAnnoationInputBox.isDisplayed());
		Assert.assertTrue(textSizeContainer.isDisplayed());
		Assert.assertTrue(backToListButtonAnnotateChart.isDisplayed());
		Assert.assertTrue(addToChartButtonAnnotateChart.isDisplayed());
	}
	
	public void selectChartAnnotationType(String annotationType){
		selectFromDropdown(annotationTypeContainer, annotationType);
	}
	
	public void typeADescritionForTextChartAnnotation(String description){
		descriptionChartAnnotationInputBox.sendKeys(description);
	}
	
	public void typeRotationForTextChartAnnotation(String rotation){
		rotationChartTextAnnoationInputBox.sendKeys(rotation);
	}
	
	public void selectTextSizeForTextAnnotationChart(String size){
		selectFromDropdown(textSizeContainer, size);
	}
	
	public void selectLineType(String lineType){
		selectFromDropdown(lineTypeContainer, lineType);
	}
	
	public void clickOnAddToChartButton(){
		addToChartButtonAnnotateChart.click();
	}
	
	public void verifyChartTextAnnotation(String description, String size, String rotation){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("svg > g.highcharts-annotation-text")).getAttribute("data-text").contains(description));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("svg > g.highcharts-annotation-text")).getAttribute("data-fontsize").contains(size));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("svg > g.highcharts-annotation-text")).getAttribute("data-rotation").contains(rotation));
	}
	
	public void verifyChartArrowAnnotation(String lineType){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("svg > g.highcharts-annotation-arrow")).getAttribute("data-dashstyle").contains(lineType));
	}
	
	public void verifyChartLineAnnotation(String lineType){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("svg > g.highcharts-annotation-line")).getAttribute("data-dashstyle").contains(lineType));
	}

	public void doubleClickOnATextAnnotation(String description){
		Actions action = new Actions(getDriver());
		action.doubleClick(getDriver().findElement(By.cssSelector("g.highcharts-annotation-text[data-text='" + description + "']"))).build().perform();
		waitABit(5000);
	}
	
	public void verifyEditTextChartAnnotationWindow(String description, String size, String rotation){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div[class='popover bottom in'] h3")).getText().contains("Edit annotation"));
		Assert.assertTrue(getDriver().findElements(By.cssSelector("select#text-annotation-size > option[value='" + size + "'][selected]")).size() == 1);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input#text-annotation-rotation")).getAttribute("value").contains(rotation));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input#text-annotation-text")).getAttribute("value").contains(description));
	}
	
	public void replaceOldValuesFromEditChartTextAnnotation(String newDescription, String newSize, String newRotation){
		selectFromDropdown(textSizeContainerFromEditChartAnnotationWindow, newSize);
		rotationInputBoxFromEditChartAnnotationWindow.clear();
		rotationInputBoxFromEditChartAnnotationWindow.sendKeys(newRotation);
		descriptionInputBoxFromEditChartAnnotationWindow.clear();
		descriptionInputBoxFromEditChartAnnotationWindow.sendKeys(newDescription);
	}
	
	public void clickOnRemoveTextChartAnnotationButton(){
		removeLinkFromEditTextChartAnnotationWindow.click();
	}
	
	public void verifyTextChartAnnotationIsRemoved(String description){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("g.highcharts-annotation-text[data-text='" + description + "']")).size() == 0);
	}
	
	public void clickOnCancelFromTextChartAnnotation(){
		cancelLinkFromEditTextChartAnnotationWindow.click();
	}
	
	public void clickOnSaveButtonFromTextChartAnnotation(){
		saveButtonFromEditChartAnnotationWindow.click();
	}
	
	public void doubleClickOnArrowAnnotation(String lineType){
		Actions action = new Actions(getDriver());
		action.doubleClick(getDriver().findElement(By.cssSelector("g.highcharts-annotation-arrow[data-dashstyle='" + lineType + "']"))).build().perform();
		waitABit(5000);
	}
	
	public void doubleClickOnLineAnnotation(String lineType){
		Actions action = new Actions(getDriver());
		action.doubleClick(getDriver().findElement(By.cssSelector("g.highcharts-annotation-line[data-dashstyle='" + lineType + "']"))).build().perform();
		waitABit(5000);
	}
	
	public void verifyLineTypeFromEditChartAnnotationWindow(String lineType){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div[class='popover bottom in'] h3")).getText().contains("Edit annotation"));
		Assert.assertTrue(getDriver().findElements(By.cssSelector("select#line-annotation-dashstyle > option[value='" + lineType + "'][selected]")).size() == 1);
	}
	
	public void replaceOldLineTypeFromEditChartAnnotationWindow(String newLineType){
		selectFromDropdown(lineTypeContainerFromEditAnnotationWindow, newLineType);
	}
	
	public void clickOnRemoveLinkFromEditChartAnnotationWindow(){
		removeLinkFromEditAnnotationWindow.click();
	}
	
	public void verifyArrowChartAnnotationIsRemoved(String lineType){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("g.highcharts-annotation-arrow[data-dashstyle='" + lineType + "']")).size() == 0);
	}
	
	public void verifyLineChartAnnotationIsRemoved(String lineType){
		Assert.assertTrue(getDriver().findElements(By.cssSelector("g.highcharts-annotation-line[data-dashstyle='" + lineType + "']")).size() == 0);
	}
	
	public void clickOnCancelLinkFromEditChartAnnotationWindow(){
		cancelLinkFromEditAnnotationWindow.click();
	}
	
	public void addStaticWidgetTableRowAnnotation(String rowType,String row,String annotationDescription) {
		getDriver().findElement(By.cssSelector("button#load-table-annotate")).click();
		waitABit(5000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.dropdown-menu.datatool-form.annotate_table_dvpack > form:nth-child(1) > h5")).getText().contains("Add Annotations to your table"));
		System.out.println("Annotation dropdown found!");
		waitABit(4000);
		element(getDriver().findElement(By.cssSelector("form#table-annotation-form > button"))).click();
		waitABit(4000);
		selectAnnotationType(rowType);
		//selectFromDropdown(getDriver().findElement(By.cssSelector("form#table-new-annotation > div:nth-child(1) > div > select")), cell);
		waitABit(4000);
		//selectFromDropdown(containerTypeTableAnnotation, row);
		System.out.println("type selected!");
		waitABit(4000);
//		Select rowName = new Select(getDriver().findElement(By.cssSelector("select#table-new-row ")));
//		System.out.println("instance selected!");
//		waitABit(4000);
//	    WebElement option = rowName.getFirstSelectedOption();
//	    System.out.println("row!");
//	    String selection= option.getText();
//		Assert.assertTrue(row.contains(selection));
		selectRowInstanceDropDown();
		
		getDriver().findElement(By.cssSelector("input#table-annotation-description")).sendKeys(annotationDescription);
	}
	
	public void selectAnnotationType(String rowType) {
		selectFromDropdown(getDriver().findElement(By.cssSelector("select#table-annotation-type")), rowType);
	   }
	
	public void clickOnAddAnnotationToTheTable() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#table-new-annotation > div:nth-child(7) > button:nth-child(2)")).isDisplayed());
		getDriver().findElement(By.cssSelector("form#table-new-annotation > div:nth-child(7) > button:nth-child(2)")).click();
	}
	
	public void verifyAnnotationAddedToTheWidgetTable() {
		waitABit(4000);
	    Assert.assertTrue(getDriver().findElement(By.cssSelector("div#dynamic_table > table > tbody > tr[class ='dvpack_table_row'] >td")).isDisplayed());
	}
	
	public void verifyAnnotationCellAddedToTheWidgetTable() {
		waitABit(4000);
	    Assert.assertTrue(getDriver().findElement(By.cssSelector("div#dynamic_table > table > tbody > tr[class ='dvpack_table_row'] >td[class ='dvpack_table_row_entry dvpack_table_cell_annotation']")).getAttribute("data-annotationid").contains("1"));
	}
	
	public void selectRowInstanceDropDown() {
		Select rowName = new Select(getDriver().findElement(By.cssSelector("select#table-new-row")));
	    rowName.selectByValue("0");
	}
	
	public void selectColumnInstanceDropdown() {
		Select colName = new Select(getDriver().findElement(By.cssSelector("select#table-new-column")));//form#table-new-annotation > div:nth-child(3) > div > div:nth-child(2)  > select ")));
	    colName.selectByValue("0");
	}
	
	public void addStaticWidgetTableCellAnnotation() {
		getDriver().findElement(By.cssSelector("button#load-table-annotate")).click();
		waitABit(5000);
		//getDriver().findElement(By.cssSelector("div#table-actions > div> div:nth-child(1) > div > form#table-new-annotation")).click();
		System.out.println("1");
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.dropdown-menu.datatool-form.annotate_table_dvpack > form:nth-child(1) > h5")).getText().contains("Add Annotations to your table"));
		System.out.println("Annotation dropdown found!");
		waitABit(4000);
		element(getDriver().findElement(By.cssSelector("div#table-actions > div > div:nth-child(1)  > div > form:nth-child(1) > button"))).click();
		
	}
	
	public void createCellTableAnnotation(String column,String annotationDescriptionColumn) {
		getDriver().findElement(By.cssSelector("button#load-table-annotate")).click();
		waitABit(5000);
		//getDriver().findElement(By.cssSelector("div#table-actions > div> div:nth-child(1) > div > form#table-new-annotation")).click();
		System.out.println("1");
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div.dropdown-menu.datatool-form.annotate_table_dvpack > form:nth-child(1) > h5")).getText().contains("Add Annotations to your table"));
		System.out.println("Annotation dropdown found!");
		waitABit(4000);
		element(getDriver().findElement(By.cssSelector("form#table-annotation-form > button"))).click();
//		selectFromDropdown(getDriver().findElement(By.cssSelector("form#table-new-annotation >div:nth-child(2) > div:nth-child(1) > select")), column);
//		Select colName = new Select(getDriver().findElement(By.cssSelector("form#table-new-annotation >div:nth-child(2) > div:nth-child(1) > select")));
//	    WebElement option = colName.getFirstSelectedOption();
//	    String selection= option.getText();
//		Assert.assertTrue(column.contains(selection));
		System.out.println("cell selected!");
		selectRowInstanceDropDown();
	    selectColumnInstanceDropdown();
		getDriver().findElement(By.cssSelector("input#table-annotation-description")).sendKeys(annotationDescriptionColumn);
		clickOnAddAnnotationToTheTable();
	}
	
	public void editRowAnnotationStaticWidgetTable(String newRowDescription) {
		Actions action = new Actions(getDriver());
	    action.doubleClick(getDriver().findElement(By.cssSelector("div#dynamic_table > table > tbody > tr[class ='dvpack_table_row'] >td"))).build().perform();
	    element(getDriver().findElement(By.cssSelector("input#edit-table-annotation-description"))).clear();
	    element(getDriver().findElement(By.cssSelector("input#edit-table-annotation-description"))).sendKeys(newRowDescription);
	}
	
	public void verifyEditRowAnnotationStaticWidgetTable(String newRowDescription) {
		waitUntilElementExists(By.cssSelector("div#dynamic_table > table > tbody > tr[class ='dvpack_table_row'] >td"), 40);
		WebElement markedRow = getDriver().findElement(By.cssSelector("div#dynamic_table > table > tbody > tr[class ='dvpack_table_row'] >td"));
		element(markedRow).waitUntilVisible();
		String row = markedRow.getText();
		System.out.println(row);
		System.out.println(newRowDescription);
		Assert.assertTrue("Description is not the same",row.equals(newRowDescription));
	}
	
	public void editCellAnnotationStaticWidgetTable(String newCellDescription) {
		Actions action = new Actions(getDriver());
	    action.doubleClick(getDriver().findElement(By.cssSelector("div#dynamic_table > table > tbody > tr[class ='dvpack_table_row'] >td[class ='dvpack_table_row_entry dvpack_table_cell_annotation']"))).build().perform();
	    element(getDriver().findElement(By.cssSelector("input#edit-table-annotation-description"))).clear();
	    element(getDriver().findElement(By.cssSelector("input#edit-table-annotation-description"))).sendKeys(newCellDescription);
	}
	
	public void verifyEditCellAnnotationStaticWidgetTable(String newCellDescription) {
		waitUntilElementExists(By.cssSelector("div#dynamic_table > table > tbody > tr[class ='dvpack_table_row'] >td[class ='dvpack_table_row_entry dvpack_table_cell_annotation']"), 40);
		WebElement markedCell = getDriver().findElement(By.cssSelector("div#dynamic_table > table > tbody > tr[class ='dvpack_table_row'] >td[class ='dvpack_table_row_entry dvpack_table_cell_annotation']"));
		element(markedCell).waitUntilVisible();
		String cell= markedCell.getText();
		System.out.println(cell);
		System.out.println(newCellDescription);
		Assert.assertTrue("Description is not the same",cell.equals(newCellDescription));
	}
	
	public void saveEditCellWidgetTableAnnotation() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#table-edit-annotation > div:nth-child(5) > button:nth-child(3)")).isDisplayed());
		getDriver().findElement(By.cssSelector("form#table-edit-annotation > div:nth-child(5) > button:nth-child(3)")).click();
	}
	
	public void deleteRowAnnotationTable(String deleteRow) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#table-annotation-form > table:nth-child("+deleteRow+") > tbody > tr > td > div.pull-right > button")).isDisplayed());
		getDriver().findElement(By.cssSelector("form#table-annotation-form > table:nth-child("+deleteRow+") > tbody > tr > td > div.pull-right > button")).click();
	}
		
	public void deleteCellAnnotationTable(String deleteCell) {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#table-annotation-form > table:nth-child("+deleteCell+") > tbody > tr > td > div.pull-right > button")).isDisplayed());
		getDriver().findElement(By.cssSelector("form#table-annotation-form > table:nth-child("+deleteCell+") > tbody > tr > td > div.pull-right > button")).click();
	}
	
	public void clickOnAnnotationTableButton() {
		Assert.assertTrue(getDriver().findElement(By.cssSelector("button#load-table-annotate")).isDisplayed());
		getDriver().findElement(By.cssSelector("button#load-table-annotate")).click();
	}
	
	public void verifyAnnotationDropdownWidgetTable() {
		getDriver().findElement(By.cssSelector("button#load-table-annotate")).click();
		Assert.assertTrue(getDriver().findElement(By.cssSelector("button#table-annotation-form > h5")).getText().contains("Add Annotations to your table"));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("button#table-annotation-form > button")).getText().contains("New"));
		System.out.println("The Annotation dropdown is empty!");
	
	}
	
	public void clickOnFormatButtonTable(){
		formatButtonTable.click();
	}
	
	public void verifyFormatWindowTable(String title, String description){
		waitUntilElementExists(By.cssSelector("input[name='title']"), 30);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input[name='title']")).getAttribute("value").contains(title));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input[name='description']")).getAttribute("value").contains(description));
		Assert.assertTrue(updateTableButton.isDisplayed());
	}
	
	public void clickOnFormatButtonChart(){
		formatButtonChart.click();
	}
	
	public void verifyFormatWindowChart(String title, String subtitle, String description, String dvpackType){
		waitUntilElementExists(By.cssSelector("input[name='title']"), 30);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input[name='title']")).getAttribute("value").contains(title));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input[name='subtitle']")).getAttribute("value").contains(subtitle));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("input[name='description']")).getAttribute("value").contains(description));
		if(!dvpackType.equals("Custom")){
			Assert.assertTrue(getDriver().findElements(By.cssSelector("select#render-type > option[value='DynamicChart'][selected]")).size() == 1);
		}
		Assert.assertTrue(xAxisOrientationContainerFormatChartwindow.isDisplayed());
		Assert.assertTrue(resetLegendButton.isDisplayed());
		Assert.assertTrue(removeLegendButton.isDisplayed());
		Assert.assertTrue(moveLegendButton.isDisplayed());
		if(!dvpackType.equals("Custom")&&!dvpackType.equals("Template")){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div#x-axis > label")).getText().contains("X axis"));
		Assert.assertTrue(getDriver().findElements(By.cssSelector("div#x-axis > input")).size() > 0);
		}
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div[class='border-top details-axis clearfix border-bottom'] label")).getText().contains("Y axis"));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div[class='first-yaxis span12'] > span:nth-child(1)")).getText().contains("#1"));
		Assert.assertTrue(getDriver().findElement(By.cssSelector("div[class='second-yaxis margin-top-5 span12'] > span:nth-child(1)")).getText().contains("#2"));
		Assert.assertTrue(minInputBoxY1axis.isDisplayed());
		Assert.assertTrue(maxInputBoxY1axis.isDisplayed());
		Assert.assertTrue(incrementsInputBoxY1axis.isDisplayed());
		Assert.assertTrue(minInputBoxY2axis.isDisplayed());
		Assert.assertTrue(maxInputBoxY2axis.isDisplayed());
		Assert.assertTrue(incrementsInputBoxY2axis.isDisplayed());
		Assert.assertTrue(getDriver().findElements(By.cssSelector("select[class='chart-type-selection custom-size'] option[value='line'][selected]")).size() == 1);
		Assert.assertTrue(stackedCheckBoxFormatWindow.isDisplayed());
		Assert.assertTrue(enableGridLinesCheckBoxFormatWindow.isDisplayed());
		Assert.assertTrue(updateChartButton.isDisplayed());
	}
	
	public void verifyChartTitle(String title){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("text.highcharts-title > tspan")).getText().contains(title));
	}
	
	public void verifyChartSubtitle(String subtitle){
		Assert.assertTrue(getDriver().findElement(By.cssSelector("text.highcharts-subtitle > tspan")).getText().contains(subtitle));
	}
	
	public void verifyXAxisFromFormatWindow(String dvpackType){
		if(!dvpackType.equals("Custom")&&!dvpackType.equals("Template")){
		int numberOfYearsFromChart = getDriver().findElements(By.cssSelector("g[class='highcharts-axis-labels highcharts-xaxis-labels'] > text")).size();
		int numberOfYearsFromFormatWindow = getDriver().findElements(By.cssSelector("div#x-axis > input")).size();
		Assert.assertTrue(numberOfYearsFromChart == numberOfYearsFromFormatWindow);
		String yearFromChart = null, yearFromFormatWindow = null;
		for(int i=1; i<=numberOfYearsFromChart; i++){
			yearFromChart = getDriver().findElement(By.cssSelector("g[class='highcharts-axis-labels highcharts-xaxis-labels'] > text:nth-child(" + i + ") > tspan")).getText();
			yearFromFormatWindow = getDriver().findElement(By.cssSelector("div#x-axis > input:nth-of-type(" + i + ")")).getAttribute("value");
			Assert.assertTrue(yearFromChart.contains(yearFromFormatWindow));
			}
		}
	}

	public void verifyTableFilterMatchesCountrySelection() {
		String geographyFromTable = getDriver().findElement(By.cssSelector("div#dynamic_table > table > tbody > tr:nth-child(1) > td:nth-child(1)")).getText();
		System.out.println(geographyFromTable);
		waitABit(5000);
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(1) > li > h5 ")).click();
		waitUntilElementExists(By.cssSelector("div.sidebar.well > ul:nth-child(1) > li > ul"), 40);
		WebElement searchInputBox = getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(1) > li > ul > li.quick-search > input"));
		searchInputBox.clear();
		waitABit(3000);
		searchInputBox.sendKeys(geographyFromTable);
		WebElement element = getDriver().findElement(By.cssSelector("div.sidebar.well > ul:nth-child(1) > li > ul"));
		List<WebElement> children = element.findElements(By.cssSelector(" li > label")); 
		for(WebElement child:children){
			System.out.println(child.getText());
			try{
				if(child.getAttribute("title").equals(geographyFromTable)){
					System.out.println("Geography found!!");
					Assert.assertTrue("Geography was not found!", child.getText().contains(geographyFromTable));
					break;
				}
			} catch (StaleElementReferenceException sere) {
				
			}
		}
	}
	
	public List<String> getIndicators(){
		List <WebElement> indicatorsElements=getDriver().findElements(By.cssSelector("table.dvpack_table.dataTable > tbody > tr > td:nth-of-type(2)"));
		System.out.println("Number of indicators" + indicatorsElements.size());
		for(WebElement indicator:indicatorsElements){
			indicators.add(indicator.getText());
		}
		return indicators;
	}	
}

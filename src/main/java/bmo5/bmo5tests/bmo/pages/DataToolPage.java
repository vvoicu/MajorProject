package bmo5.bmo5tests.bmo.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.desktop.DesktopKeyboard;

import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.FileChecker;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class DataToolPage extends AbstractPage {


	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li:nth-child(2)")
	private WebElement filterGeographySection;

	@FindBy(css = "div.sidebar.well > ul > li:nth-child(2) > div > ul ")
	private WebElement filterGeographySectionExpanded;

	@FindBy(css = "div.sidebar.well > ul > li:nth-child(2) > div > ul > li:nth-child(1) > input")
	private WebElement searchFilterGeographySection;

	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li:nth-child(3) > h5")
	private WebElement filterIndicatorSection;

	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li:nth-child(3) > div > ul")
	private WebElement filterIndicatorSectionExpanded;

	@FindBy(css = "div.sidebar.well > ul:nth-child(1) > li:nth-child(3) > div > ul > li:nth-child(1) > input")
	private WebElement searchFilterIndicatorSection;

	@FindBy(css = "h5[data-section-name='date_ranges']")
	private WebElement filterDateRangesSection;

	@FindBy(css = "div.sidebar.well > ul:nth-of-type(1) > li:nth-of-type(4) > ul")
	private WebElement filterDateRangesSectionExpanded;

	@FindBy(css = "button#filter-download-data")
	private WebElement filterDownloadButton;
	
	@FindBy(css = "div.btn-group.btn-block-full > button:nth-child(1)")
	private WebElement filterDownloadButtonTrialUser;

	@FindBy(css = "button#filter-display-data")
	private WebElement filterDisplayDataButton;

	@FindBy(css = "button#load-dvpack-select")
	private WebElement selectButton;

	@FindBy(css = "button#dvpack-save")
	private WebElement saveButton;
	
	@FindBy(css = "i.icon-c-floppy")
	private WebElement saveButtonEnterpriseUser;

	@FindBy(css = "button#print-dvpack")
	private WebElement chartPrintButton;

	@FindBy(css = "button#load-chart-export")
	private WebElement chartExportButton;

	@FindBy(css = "button#load-chart-annotate")
	private WebElement chartAnnotateButton;

	@FindBy(css = "button#load-chart-format")
	private WebElement chartFormatButton;

	@FindBy(css = "div#dynamic_chart")
	private WebElement chartGraph;

	@FindBy(css = "div#dynamic_table")
	private WebElement table;

//	@FindBy(css = "div.dropdown-menu.datatool-form.select_dvpack > form > ul")
	@FindBy(css = "ul.nav.nav-list.nav-select.ui-sortable")
	private WebElement selectWindow;

	@FindBy(css = "div.dropdown-menu.datatool-form.select_dvpack > form > div > button#apply-select")
	private WebElement selectWindowApplyButton;

	@FindBy(css = "div.dropdown-menu.datatool-form.select_dvpack > form > div > button#reset-select")
	private WebElement selectWindowResetButton;

	@FindBy(css = "div.dropdown-menu.datatool-form.select_dvpack > form > ul > li:nth-child(1) label")
	private WebElement firstElementFromSelectWindow;

	@FindBy(css = "div.dropdown-menu.datatool-form.export_chart_dvpack > form")
	private WebElement exportWindow;

	@FindBy(css = "button#load-chart-export")
	private WebElement exportChartButton;

//	@FindBy(css = "form#export-chart-form > div:nth-child(3) > div:nth-child(1) > label:nth-child(1) > div > span")
//	private WebElement colorRadioButton;
//
//	@FindBy(css = "form#export-chart-form > div:nth-child(3) > div:nth-child(1) > label:nth-child(2) > div > span")
//	private WebElement grayscaleRadioButton;
//
//	@FindBy(css = "form#export-chart-form > div:nth-child(4) > div:nth-child(1) > label:nth-child(1) > div > span")
//	private WebElement jpgRadioButton;
//
//	@FindBy(css = "form#export-chart-form > div:nth-child(4) > div:nth-child(1) > label:nth-child(2) > div > span")
//	private WebElement pngRadioButton;

	@FindBy(css = "form#form-annotation-list")
	private WebElement chartAnnotationListWindow;

	@FindBy(css = "form#form-annotation-list > button.btn")
	private WebElement chartAnnotationNewButton;

	@FindBy(css = "form#form-annotation-new")
	private WebElement chartAnnotationNewWindow;

	@FindBy(css = "select#annotation-type")
	private WebElement chartAnnotationType;
	
	@FindBy(css = "select#annotation-text-size")
	private WebElement chartAnnotationTextSize;
	
	@FindBy(css = "select#annotation-line-type")
	private WebElement chartAnnotationLineType;
	
	@FindBy(css = "input#annotation-text-rotation")
	private WebElement chartAnnotationRotation;
	
	@FindBy(css = "input#annotation-description")
	private WebElement chartAnnotationDescription;
	
	@FindBy(css = "form#form-annotation-new > div:nth-child(2) > div:nth-child(1) > label")
	private WebElement chartAnnotationRequiredDescription;
	
	@FindBy(css = "div.sp-replacer.sp-light > div.sp-preview > div.sp-preview-inner")
	private WebElement chartNewAnnotationTextColorBox;
	
	@FindBy(css = "div.sp-container.sp-light.sp-input-disabled.sp-palette-disabled.sp-initial-disabled > div.sp-picker-container")
	private WebElement chartAnnotationColorPickerContainer;
	
	@FindBy(css = "div.sp-container.sp-light.sp-input-disabled.sp-palette-disabled.sp-initial-disabled > div.sp-picker-container > div:nth-child(3) > button.sp-choose")
	private WebElement chartAnnotationColorPickerChooseButton;
	
	@FindBy(css = "div.sp-container.sp-light.sp-input-disabled.sp-palette-disabled.sp-initial-disabled > div.sp-picker-container > div:nth-child(3) > a.sp-cancel")
	private WebElement chartAnnotationColorPickerCancel;
	
	@FindBy(css = "button.btn.btn-link")
	private WebElement chartNewAnnotationBackToListButton;
	
	@FindBy(css = "button.btn.submit")
	private WebElement chartNewAnnotationAddToChartButton;
	
	@FindBy(css = "table.table.table-striped.table-condensed.table-striped-datatool")
	private WebElement chartAnnotationListTextList;
	
	@FindBy(css = "table.table.table-striped.table-condensed.table-striped-datatool")
	private WebElement chartAnnotationListLineList;
	
	@FindBy(css = "table.table.table-striped.table-condensed.table-striped-datatool > tbody > tr > td:nth-child(1)")
	private WebElement chartAnnotationListDescription;
	
	@FindBy(css = "div.sp-replacer.sp-light.sp-disabled > div.sp-preview > div.sp-preview-inner")
	private WebElement chartAnnotationListColorBox;
	
	@FindBy(css = "table.table.table-striped.table-condensed.table-striped-datatool > tbody > tr > td:nth-child(3)")
	private WebElement chartAnnotationListFontSize;
	
	@FindBy(css = "table.table.table-striped.table-condensed.table-striped-datatool > tbody > tr > td:nth-child(1)")
	private WebElement chartAnnotationListLineType;
	
	@FindBy(css = "table.table.table-striped.table-condensed.table-striped-datatool > tbody > tr > td:nth-child(4)")
	private WebElement chartAnnotationListTextRotation;
	
	@FindBy(css = "button.btn.btn-link.btn-small.edit-annotation")
	private WebElement chartAnnotationListEditButton;
	
	@FindBy(css = "button.btn.btn-link.btn-small.delete-annotation")
	private WebElement chartAnnotationListDeleteButton;
	
	@FindBy(css = "div.popover-content")
	private WebElement chartEditAnnotationWindow;

	@FindBy(css = "select#text-annotation-size")
	private WebElement chartEditAnnotationTextSize;
	
	@FindBy(css = "select#line-annotation-dashstyle")
	private WebElement chartEditAnnotationLineType;
	
	@FindBy(css = "input#text-annotation-rotation")
	private WebElement chartEditAnnotationRotation;
	
	@FindBy(css = "div.controls.margin-left-100 > div.sp-replacer.sp-light.sp-disabled > div.sp-preview > div.sp-preview-inner")
	private WebElement chartEditAnnotationColor;
	
	@FindBy(css = "input#text-annotation-text")
	private WebElement chartEditAnnotationDescription;
	
	@FindBy(css = "button#text-annotation-remove")
	private WebElement chartEditTextAnnotationRemoveButton;
	
	@FindBy(css = "button#text-annotation-cancel")
	private WebElement chartEditTextAnnotationCancelButton;
	
	@FindBy(css = "button.btn.btn-small.submit")
	private WebElement chartEditAnnotationSaveButton;
	
	@FindBy(css = "button#line-annotation-remove")
	private WebElement chartEditLineAnnotationRemoveButton;
	
	@FindBy(css = "button#line-annotation-cancel")
	private WebElement chartEditLineAnnotationCancelButton;
	
	@FindBy(css = "div.dropdown-menu.datatool-form.format_chart_dvpack")
	private WebElement chartFormatWindow;
	
	@FindBy(css = "input.format_title")
	private WebElement chartFormatTitleField;
	
	@FindBy(css = "input.format_subtitle")
	private WebElement chartFormatSubtitleField;
	
	@FindBy(css = "input.format_description")
	private WebElement chartFormatDescriptionField;

	@FindBy(css = "button#legend-reset")
	private WebElement chartFormatLegendResetButton;
	
	@FindBy(css = "button#legend-disable")
	private WebElement chartFormatLegendDisableButton;
	
	@FindBy(css = "button#legend-enable")
	private WebElement chartFormatLegendEnableButton;
	
	@FindBy(css = "select.chart-type-selection")
	private WebElement chartFormatChartType;
	
	@FindBy(css = "table.table.table-striped.table-condensed.table-striped-datatool")
	private WebElement chartFormatWindowTableSeries;
	
	@FindBy(css = "text[class='highcharts-title'] > tspan")
	private WebElement chartTitle;
	
	@FindBy(css = "text[class='highcharts-subtitle'] > tspan")
	private WebElement chartSubtitle;
	
	@FindBy(css = "button#update-chart")
	private WebElement chartFormatUpdateChartButton;
	
	@FindBy(css = "g.highcharts-legend")
	private WebElement chartLegend;
	
	@FindBy(css = "select#add-table-annotation-type")
	private WebElement tableNewAnnotationType;
	
	@FindBy(css = "select#table-new-row")
	private WebElement tableNewAnnotationInstanceRow;
	
	@FindBy(css = "select#table-new-column")
	private WebElement tableNewAnnotationInstanceColumn;
	
	@FindBy(css = "input#add-table-annotation-description")
	private WebElement tableNewAnnotationDescription;
	
	@FindBy(css = "form#table-new-annotation > div:nth-child(4) > div > div > div > div.sp-preview-inner")
	private WebElement tableNewAnnotationColorBox;
	
	@FindBy(css = "button.btn.btn-small.submit")
	private WebElement tableAnnotationSaveButton;
	
	@FindBy(css = "table.table.table-striped.table-condensed.table-striped-datatool")
	private WebElement tableAnnotationsList;
	
	@FindBy(css = "button.btn.btn-link.btn-small.edit-annotation")
	private WebElement tableAnnotationsListEditButton;
	
	@FindBy(css = "button.btn.btn-link.btn-small.delete-annotation")
	private WebElement tableAnnotationsListDeleteButton;

	@FindBy(css = "form#table-edit-annotation")
	private WebElement tableEditAnnotationWindow;

	@FindBy(css = "form#table-edit-annotation > div > button.btn.btn-link")
	private WebElement tableEditAnnotationCacelButton;
	
	@FindBy(css = "form#table-edit-annotation > div > button.btn.submit.margin-right-10")
	private WebElement tableEditAnnotationSaveButton;
	
	@FindBy(css = "input#edit-table-annotation-description")
	private WebElement tableEditAnnotationDescription;
	
	@FindBy(css = "div.loading")
	private WebElement loading;
	
	@FindBy(css = "div.dropdown-menu.datatool-form.select_dvpack_loading")
	private WebElement selectLoading;
	
	@FindBy(id = "filter-clear")
	private WebElement clearFilters;
	
	@FindBy(css = "")
	private WebElement lineTypeDropdownList;
	
	@FindBy(css = "div#permission-enterprise-user strong")
	private WebElement alertMessageEnterprise;
	
	@FindBy(css = "div#permission-enterprise-user > div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowEnterprise;
	
	@FindBy(css = "div#permission-modal-data-exports > div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialExportWindow;
	
	@FindBy(css = "div#permission-modal-print strong")
	private WebElement alertMessagePrint;
	
	@FindBy(css = "div#permission-modal-print div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialPrint;
	
	@FindBy(css = "div#permission-modal-print div:nth-child(2) > a")
	private WebElement contactAccountManagementButtonTrialPrint;
	
	@FindBy(css = "div#permission-modal-pdf strong")
	private WebElement alertMessageDownload;
	
	@FindBy(css = "div#permission-modal-data-exports strong")
	private WebElement alertMessageExport;
	
	@FindBy(css = "div#permission-modal-pdf div:nth-child(2) > button")
	private WebElement cancelButtonModalWindowTrialDownload;
	
	@FindBy(css = "div#permission-modal-pdf div:nth-child(2) > a")
	private WebElement contactAccountManagementButtonTrialDownload;
	
	@FindBy(css = "div#modal-save-dvpack input")
	private WebElement savedDataInputBox;
	
	@FindBy(css = "div#modal-save-dvpack a.btn.btn-primary")
	private WebElement saveButtonModalWindow;
	
//	@FindBy(css = "form#export-chart-form > div span > input[value='chart']")
	@FindBy(css = "form#export-chart-form > div:nth-child(1) label")
	private WebElement exportWindowChartRadioButton;
	
//	@FindBy(css = "form#export-chart-form > div span > input[value='table']")
	@FindBy(css = "form#export-chart-form > div:nth-child(2) label")
	private WebElement exportWindowTableRadioButton;
	
//	@FindBy(css = "form#export-chart-form > div span > input[value='both']")
	@FindBy(css = "form#export-chart-form > div:nth-child(3) label")
	private WebElement exportWindowChartAndTableRadioButton;
	
	@FindBy(css = "form#export-chart-form > div:nth-child(4) select")
	private WebElement exportWindowSelectFormatContainer;
	
	@FindBy(css = "button#export_the_chart")
	private WebElement exportWindowExportChartButton;
	
	@FindBy(css = "button#export_the_table")
	private WebElement exportWindowExportTableButton;
	
	@FindBy(css = "button#export_both_chart_and_table")
	private WebElement exportWindowExportChartAndTableButton;
	
	@FindBy(css = "aside.span2.sidebar-wrapper")
	private WebElement filtersArea;
	
	@FindBy(css = "h5[data-section-name='frequency']")
	private WebElement frequencyToggler;
	
	@FindBy(css = "h5[data-section-name='frequency'] i")
	private WebElement frequencyTogglerArrow;
	
	@FindBy(css = "div#dynamic_chart > div.alert.alert-info")
	private WebElement alertMessageForChart;
	
	@FindBy(css = "div#dynamic_table > div.alert.alert-info")
	private WebElement alertMessageForTable;
	
	private List<WebElement> rows= getDriver().findElements(By.cssSelector("div.dataTables_scroll > div.dataTables_scrollBody > table > tbody > tr"));
	private List<WebElement> columns=getDriver().findElements(By.cssSelector("div.dataTables_scroll > div.dataTables_scrollBody > table > tbody > tr > td"));

	public void clearFiltersInDataTool(String text) {
		Assert.assertTrue("not displayed!!!", clearFilters.getText().equals(text));
		clearFilters.click();
	}
	public void clickFilterGeographySection() {
		element(filterGeographySection).waitUntilVisible();
		filterGeographySection.click();
	}

	public void searchFilterGeographySection(String searchGeography) {
		element(searchFilterGeographySection).waitUntilVisible();
		
		waitUntilElementDoesntExist(By.cssSelector("div.loading"),50);
		
		if(searchGeography.equals("Global")){
		}
		else if(searchGeography.equals("Africa")){
		}
		else if(searchGeography.equals("Asia")){
		}
		else if(searchGeography.equals("Caribbean")){
		}
		else if(searchGeography.equals("Europe")){
		}
		else if(searchGeography.equals("Latin America")){
		}
		else if(searchGeography.equals("Middle East")){
		}
		else if(searchGeography.equals("North America")){
		}
		else{
		searchFilterGeographySection.sendKeys(searchGeography);
		}
	}

	public void clickFilterIndicatorSection() {
		element(filterIndicatorSection).waitUntilVisible();
		filterIndicatorSection.click();
	}

	public void searchFilterIndicatorSection(String searchIndicator) {
		element(searchFilterIndicatorSection).waitUntilVisible();
		waitUntilElementDoesntExist(By.cssSelector("div.loading"),50);
		searchFilterIndicatorSection.sendKeys(searchIndicator);
	}

	public void clickFilterDateRangesSection() {
		filterDateRangesSection.click();
	}

	public void selectOneGeograpyFromFilter(String geography) {
		
		element(filterGeographySectionExpanded).waitUntilVisible();
		
		waitUntilElementDoesntExist(By.cssSelector("div.loading"),50);
		
		WebElement element = filterGeographySectionExpanded.findElement(By.cssSelector("label[title='"+geography+"'].checkbox"));
		element(element).click();
	}
	
	public void verifyIfGeographyIsChecked(String geography){
		Assert.assertTrue(verifyElementState("document.getElementById('" + geography + "')"));
	}

	public void selectOneIndicatorFromFilter(String indicator) {
		waitABit(2000);

		element(filterIndicatorSectionExpanded).waitUntilVisible();

		waitUntilElementDoesntExist(By.cssSelector("div.loading"),50);
		
		WebElement element = filterIndicatorSectionExpanded.findElement(By.cssSelector("label[title='"+indicator+"']"));
		element(element).click();
	}
	
	public String returnTheIndicatorId(String indicator){
		return getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-child(3) ul > li label[title='" + indicator + "']")).getAttribute("for");
	}
	
	public void verifyIfIndicatorIsChecked(String indicator){
		Assert.assertTrue(verifyElementState("document.getElementById('" + indicator + "')"));
	}

	public void selectOneDateRangesFromFilter(String dateRanges) {
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-of-type(4) > ul > li > label[title='" + dateRanges + "']")).click();
	}
	
	public void verifyIfDateRangeIsChecked(String dateRanges){
		Assert.assertTrue(verifyElementState("document.getElementById('" + dateRanges + "')"));
	}
	
	public void clickOnFrequencyFilter(){
		frequencyToggler.click();
		Assert.assertTrue(frequencyTogglerArrow.getAttribute("class").contains("down"));
	}
	
	public void selectOneFrequencyFromFilter(String frequency){
		getDriver().findElement(By.cssSelector("div.sidebar.well > ul > li:nth-of-type(5) > ul > li > label[title='" + frequency + "']")).click();
	}
	
	public void verifyIfFrequencyIsChecked(String frequency){
		Assert.assertTrue(verifyElementState("document.getElementById('" + frequency + "')"));
	}

	public void clickFilterDownloadButton() {
		element(filterDownloadButton).waitUntilEnabled();
		filterDownloadButton.click();
	}
	
	public void clickFilterDownloadButtonTrialUserBMIAndRatings(){
		element(filterDownloadButtonTrialUser).waitUntilEnabled();
		filterDownloadButtonTrialUser.click();
		Assert.assertTrue(alertMessageExport.isDisplayed());
		cancelButtonModalWindowTrialExportWindow.click();
	}
	
	public void clickFilterDownloadButtonTrialUser(String extension) {
		waitUntilElementExists(By.cssSelector("button#filter-download-data"), 30);
		elementClick("button#filter-download-data");
		saveImageHandle2();
		FileChecker file = new FileChecker();
		file.verifyExtentionExcelFileFromDataToolTrialUser(extension);
//		Assert.assertTrue(getDriver().findElements(By.cssSelector("button#filter-download-data")).size() == 0);
	}
	
	public void clickFilterDownloadButtonTrialUserForRatings(String extension) {
		waitUntilElementExists(By.cssSelector("button#excel-download"), 30);
		elementClick("button#excel-download");
		saveImageHandle2();
		FileChecker file = new FileChecker();
		file.verifyExtentionExcelFileFromDataToolTrialUser(extension);
//		Assert.assertTrue(getDriver().findElements(By.cssSelector("button#filter-download-data")).size() == 0);
	}

	public void clickFilterDisplayDataButton() {
		element(filterDownloadButton).waitUntilEnabled();
		filterDisplayDataButton.click();
		waitUntilElementDoesntExist(By.cssSelector("div.loading"),50);
	}
	
	public int filterSizeBeforeExpander(){
		element(filtersArea).waitUntilPresent();
		int size = element(filtersArea).getSize().getWidth();
		return size;
	}
	
	public void waitFiltersExpander(int size){	
		element(getDriver().findElement(By.cssSelector("article#content-wrapper"))).click();
		int i = 1;
		while(element(filtersArea).getSize().getWidth() != size && i < 60){
			waitABit(1000);
			i++;
		}
		Assert.assertTrue("Filter was not minimized or 60 seconds passed", element(filtersArea).getSize().getWidth() == size);
	}

	public void selectButtonIsDisplayed() {
		element(selectButton).waitUntilVisible();
		Assert.assertTrue(selectButton.isDisplayed());
	}
	
	public void clickSaveButton() {
		if(getDriver().findElements(By.cssSelector("div#dynamic_table > div.alert.alert-info")).size() == 1){
			System.out.println("There are no results");
			Assert.assertTrue(getDriver().findElements(By.cssSelector("button#dvpack-save[disabled]")).size() == 1);
		}
		else{
			saveButton.click();
		}
	}
	
	public void clickSaveButtonEnterpriseUser() {
		if(getDriver().findElements(By.cssSelector("i.icon-c-floppy")).size() == 1){
			saveButtonEnterpriseUser.click();
			Assert.assertTrue(alertMessageEnterprise.isDisplayed());
			cancelButtonModalWindowEnterprise.click();
		}
	}
	
	public void saveButtonIsDisplayed() {
		element(saveButton).waitUntilVisible();
		Assert.assertTrue(saveButton.isDisplayed());
	}

	public void chartPrintButtonIsDisplayed() {
		element(chartPrintButton).waitUntilVisible();
		Assert.assertTrue(chartPrintButton.isDisplayed());
	}

	public void chartExportButtonIsDisplayed() {
		element(chartExportButton).waitUntilVisible();
		Assert.assertTrue(chartExportButton.isDisplayed());
	}

	public void chartAnnotateButtonIsDisplayed() {
		element(chartAnnotateButton).waitUntilVisible();
		Assert.assertTrue(chartAnnotateButton.isDisplayed());
	}

	public void chartFormatButtonIsDisplayed() {
		element(chartFormatButton).waitUntilVisible();
		Assert.assertTrue(chartFormatButton.isDisplayed());
	}

	public void chartIsDisplayed() {
		element(chartGraph).waitUntilVisible();
		Assert.assertTrue(chartGraph.isDisplayed());
	}


	public void tableIsDisplayed() {
		element(table).waitUntilVisible();
		Assert.assertTrue(table.isDisplayed());
	}

	public void verifySelectWindow() {
		selectButton.click();
		waitUntilElementDoesntExist(By.cssSelector("div.dropdown-menu.datatool-form.select_dvpack_loading"),50);
		element(selectWindow).waitUntilVisible();
		Assert.assertTrue(selectWindow.isDisplayed());
		element(selectWindowApplyButton).waitUntilVisible();
		Assert.assertTrue(selectWindowApplyButton.isDisplayed());
		element(selectWindowResetButton).waitUntilVisible();
		Assert.assertTrue(selectWindowResetButton.isDisplayed());
	}

	public void verifySelectWindowContent(String geography, String indicator) {
		element(selectWindow).waitUntilVisible();

		String firstElementGeoInd = getDriver().findElement(
				By.cssSelector("ul#sortable > li:nth-child(1) label")).getText();

		Assert.assertTrue("Select window does not contain "
				+ firstElementGeoInd, firstElementGeoInd.contains(geography));
		Assert.assertTrue("Select window does not contain "
				+ firstElementGeoInd, firstElementGeoInd.contains(indicator));
	}

	public void removeSelectWindowContent() {
		element(selectWindow).waitUntilVisible();

		String firstElementGeoInd = getDriver().findElement(
				By.cssSelector("ul#sortable > li:nth-child(1) label")).getText();

		firstElementFromSelectWindow.click();
		selectWindowApplyButton.click();
		element(chartGraph).waitUntilVisible();
		waitABit(5000);
		selectButton.click();
		waitUntilElementDoesntExist(By.cssSelector("div.dropdown-menu.datatool-form.select_dvpack_loading"),50);
		element(selectWindow).waitUntilVisible();

		String secondElementGeoInd = getDriver().findElement(
				By.cssSelector("ul#sortable > li:nth-child(1) label")).getText();

		Assert.assertFalse("Select window contain " + secondElementGeoInd,
				secondElementGeoInd.contains(firstElementGeoInd));

		selectWindowResetButton.click();
		element(chartGraph).waitUntilVisible();
		selectButton.click();
		waitUntilElementDoesntExist(By.cssSelector("div.dropdown-menu.datatool-form.select_dvpack_loading"),50);
		element(selectWindow).waitUntilVisible();

		String thirdElementGeoInd = getDriver().findElement(
				By.cssSelector("ul#sortable > li:nth-child(1) label")).getText();

		Assert.assertTrue("Select window does not contain "
				+ thirdElementGeoInd,
				thirdElementGeoInd.contains(firstElementGeoInd));
	}

	public void printOSWindow() {
		element(chartPrintButton).waitUntilVisible();
		chartPrintButton.click();
		printHandle();
	} 

	public void printHandle() {
		String mainWindow = getDriver().getWindowHandle();
		getDriver().switchTo().activeElement();

		waitABit(5000);

		Robot newRobot;
		try {
			newRobot = new Robot();

			newRobot.keyPress(KeyEvent.VK_SPACE);
			newRobot.keyRelease(KeyEvent.VK_SPACE);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		getDriver().switchTo().window(mainWindow);
	}
	
	public void clickOnPrintChartTrialUser(){
		if(getDriver().findElements(By.cssSelector("div#chart-actions > div:nth-child(1) > div:nth-child(1) > button")).size() > 0){
			waitUntilElementExists(By.cssSelector("div#chart-actions > div:nth-child(1) > div:nth-child(1) > button"), 30);
			getDriver().findElement(By.cssSelector("div#chart-actions > div:nth-child(1) > div:nth-child(1) > button")).click();
			Assert.assertTrue(alertMessagePrint.isDisplayed());
			cancelButtonModalWindowTrialPrint.click();
		}
		else{
			System.out.println("There is no chart available");
		}
//		Assert.assertTrue(getDriver().findElements(By.cssSelector("button#print-dvpack")).size() == 0);
	}
	
	public void clickOnExportButton(){
//		chartExportButton.click();
		waitUntilElementExists(By.cssSelector("div#dynamic_table > div > div"), 20);
		WebElement exportButton = getDriver().findElement(By.cssSelector("button#load-chart-export"));
		exportButton.click();
//		elementClick("button#load-chart-export > i");
		waitABit(3000);
		Assert.assertTrue(getDriver().findElement(By.cssSelector("form#export-chart-form")).isDisplayed());
	}

	public void verifyExportWindowDefaultState() {
//		element(chartExportButton).waitUntilVisible();
//		chartExportButton.click();
//		element(exportWindow).waitUntilVisible();

		Assert.assertTrue(exportWindowChartRadioButton.isDisplayed());
		Assert.assertTrue(exportWindowTableRadioButton.isDisplayed());
		Assert.assertTrue(exportWindowChartAndTableRadioButton.isDisplayed());
		Assert.assertTrue(exportWindowExportChartButton.isDisplayed());
		
//		String defaultWidth = "800";
//		String widthDefault = getDriver()
//				.findElement(By.cssSelector("input#export_width")).getText()
//				.trim();
//		Assert.assertTrue("Default width is not " + defaultWidth,
//				defaultWidth.contains(widthDefault));
//
//		String defaultHeight = "600";
//		String heightDefault = getDriver()
//				.findElement(By.cssSelector("input#export_height")).getText()
//				.trim();
//		Assert.assertTrue("Default height is not " + defaultHeight,
//				defaultHeight.contains(heightDefault));
//
//		WebElement colorRadioButton = getDriver()
//				.findElement(
//						By.cssSelector("form#export-chart-form > div:nth-child(3) > div:nth-child(1) > label:nth-child(1) > div:nth-child(1) > span"));
//		String colorRadioButtonState = "";
//		try {
//			colorRadioButtonState = colorRadioButton.getAttribute("class");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Assert.assertTrue("The color radio button is not selected",
//				colorRadioButtonState.contains("checked"));
//
//		WebElement jpgRadioButton = getDriver()
//				.findElement(
//						By.cssSelector("form#export-chart-form > div:nth-child(4) > div:nth-child(1) > label:nth-child(1) > div:nth-child(1) > span"));
//		String jpgRadioButtonState = "";
//		try {
//			jpgRadioButtonState = jpgRadioButton.getAttribute("class");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Assert.assertTrue("The JPG radio button is not selected",
//				jpgRadioButtonState.contains("checked"));
//
//		element(exportChartButton).waitUntilVisible();
//		Assert.assertTrue(exportChartButton.isDisplayed());
	}
	
	public void verifyExportTrialUser() {
		if(getDriver().findElements(By.cssSelector("div#main-actions button[href='#permission-modal-data-exports']")).size() > 0){
			waitUntilElementExists(By.cssSelector("div#main-actions button[href='#permission-modal-data-exports']"), 10);
			getDriver().findElement(By.cssSelector("div#main-actions button[href='#permission-modal-data-exports']")).click();
			Assert.assertTrue(alertMessageExport.isDisplayed());
			cancelButtonModalWindowTrialExportWindow.click();
		}
//		Assert.assertTrue(getDriver().findElements(By.cssSelector("button#load-chart-export")).size() == 0);
	}

	public void verifyExportWidthField() {
		element(exportWindow).waitUntilVisible();
		getDriver().findElement(By.cssSelector("input#export_width")).sendKeys(
				".This is a test");
		exportChartButton.click();
		waitABit(3000);

		WebElement widthErrorMessage = getDriver()
				.findElement(
						By.cssSelector("div.dropdown-menu.datatool-form.export_chart_dvpack > form > div:nth-child(1) > div > label"));
		String widthErrorMessageIs = "";
		try {
			widthErrorMessageIs = widthErrorMessage.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue("The width error message is not present",
				widthErrorMessageIs.contains("Please enter a valid number."));

		getDriver().findElement(By.cssSelector("input#export_width")).clear();
		exportChartButton.click();
		waitABit(3000);

		WebElement widthFieldIsRequired = getDriver()
				.findElement(
						By.cssSelector("div.dropdown-menu.datatool-form.export_chart_dvpack > form > div:nth-child(1) > div > label"));
		String widthRequiredMessageIs = "";
		try {
			widthRequiredMessageIs = widthFieldIsRequired.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue("The width error message is not present",
				widthRequiredMessageIs.contains("This field is required."));

		getDriver().findElement(By.cssSelector("input#export_width")).sendKeys(
				"800");
	}

	public void verifyExportHeightField() {
		element(exportWindow).waitUntilVisible();
		getDriver().findElement(By.cssSelector("input#export_height")).sendKeys(".This is a test");
		exportChartButton.click();
		waitABit(3000);

		WebElement heightErrorMessage = getDriver().findElement(
						By.cssSelector("div.dropdown-menu.datatool-form.export_chart_dvpack > form > div:nth-child(2) > div > label"));
		String heightErrorMessageIs = "";
		try {
			heightErrorMessageIs = heightErrorMessage.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue("The height error message is not present",
				heightErrorMessageIs.contains("Please enter a valid number."));

		getDriver().findElement(By.cssSelector("input#export_height")).clear();
		exportChartButton.click();
		waitABit(3000);

		WebElement heightFieldIsRequired = getDriver().findElement(
						By.cssSelector("div.dropdown-menu.datatool-form.export_chart_dvpack > form > div:nth-child(2) > div > label"));
		String heightRequiredMessageIs = "";
		try {
			heightRequiredMessageIs = heightFieldIsRequired.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue("The height error message is not present",
				heightRequiredMessageIs.contains("This field is required."));

		getDriver().findElement(By.cssSelector("input#export_height"))
				.sendKeys("600");
	}

	public void verifyExportRadioButtons() {
		
		element(exportWindowChartRadioButton).waitUntilVisible();
		element(exportWindowTableRadioButton).waitUntilVisible();
//		element(jpgRadioButton).waitUntilVisible();
//		element(pngRadioButton).waitUntilVisible();
//
//		/* Click on grayscale radio button and verify it */
//		grayscaleRadioButton.click();
//		WebElement grayscaleButton = getDriver()
//				.findElement(
//						By.cssSelector("form#export-chart-form > div:nth-child(3) > div:nth-child(1) > label:nth-child(2) > div:nth-child(1) > span"));
//		String grayscaleButtonState = "";
//		try {
//			grayscaleButtonState = grayscaleButton.getAttribute("class");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Assert.assertTrue("The grayscale radio button is not selected",
//				grayscaleButtonState.contains("checked"));
//
//		/* Click on color radio button and verify it */
//		colorRadioButton.click();
//		WebElement colorButton = getDriver()
//				.findElement(
//						By.cssSelector("form#export-chart-form > div:nth-child(3) > div:nth-child(1) > label:nth-child(1) > div:nth-child(1) > span"));
//		String colorButtonState = "";
//		try {
//			colorButtonState = colorButton.getAttribute("class");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Assert.assertTrue("The color radio button is not selected",
//				colorButtonState.contains("checked"));
//
//		/* Click on PNG radio button and verify it */
//		pngRadioButton.click();
//		WebElement pngButton = getDriver()
//				.findElement(
//						By.cssSelector("form#export-chart-form > div:nth-child(3) > div:nth-child(1) > label:nth-child(1) > div:nth-child(1) > span"));
//		String pngButtonState = "";
//		try {
//			pngButtonState = pngButton.getAttribute("class");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Assert.assertTrue("The PNG radio button is not selected",
//				pngButtonState.contains("checked"));
//
//		/* Click on JPG radio button and verify it */
//		jpgRadioButton.click();
//		WebElement jpgButton = getDriver()
//				.findElement(
//						By.cssSelector("form#export-chart-form > div:nth-child(3) > div:nth-child(1) > label:nth-child(1) > div:nth-child(1) > span"));
//		String jpgButtonState = "";
//		try {
//			jpgButtonState = jpgButton.getAttribute("class");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Assert.assertTrue("The JPG radio button is not selected",
//				jpgButtonState.contains("checked"));
	}

	public static void deleteFile(String filePath, String fileType) {
		String fileName = filePath + fileType;
		// A File object to represent the filename
		File f = new File(fileName);

		// Make sure the file or directory exists and isn't write protected
		if (!f.exists())
			throw new IllegalArgumentException(
					"Delete: no such file or directory: " + fileName);

		if (!f.canWrite())
			throw new IllegalArgumentException("Delete: write protected: "
					+ fileName);

		// If it is a directory, make sure it is empty
		if (f.isDirectory()) {
			String[] files = f.list();
			if (files.length > 0)
				throw new IllegalArgumentException(
						"Delete: directory not empty: " + fileName);
		}

		// Attempt to delete it
		boolean success = f.delete();

		if (!success)
			throw new IllegalArgumentException("Delete: deletion failed");
	}

	public void saveImageHandle1() {
		String mainWindow = getDriver().getWindowHandle();
		getDriver().switchTo().activeElement();

		waitABit(3000);

		Keyboard keyboard = new DesktopKeyboard();
		keyboard.keyDown(KeyEvent.VK_DOWN);
		keyboard.keyUp(KeyEvent.VK_DOWN);
		waitABit(1000);
		keyboard.keyDown(KeyEvent.VK_ENTER);
		keyboard.keyUp(KeyEvent.VK_ENTER);

		getDriver().switchTo().window(mainWindow);
	}

	public void saveImageHandle2() {
		String mainWindow = getDriver().getWindowHandle();
		getDriver().switchTo().activeElement();

		waitABit(3000);
		Keyboard keyboard = new DesktopKeyboard();
		waitABit(1000);
		keyboard.keyDown(KeyEvent.VK_ENTER);
		keyboard.keyUp(KeyEvent.VK_ENTER);

		getDriver().switchTo().window(mainWindow);
	}

	public void verifyColorJPGExportImage() {

//		element(colorRadioButton).waitUntilVisible();
//		element(jpgRadioButton).waitUntilVisible();
//		colorRadioButton.click();
//		jpgRadioButton.click();

		String fileType = "chart_color.jpg";
		String filePath = Constants.DOWNLOAD_FOLDER_PATH;

		Integer siteWidth;
		Integer siteHeight;
		String siteWidthString = getDriver().findElement(
				By.cssSelector("input#export_width")).getAttribute("value");
		String siteHeightString = getDriver().findElement(
				By.cssSelector("input#export_height")).getAttribute("value");

		siteWidth = Integer.valueOf(siteWidthString);
		siteHeight = Integer.valueOf(siteHeightString);

		exportChartButton.click();

		saveImageHandle1();
		waitABit(3000);
		BufferedImage bimg;
		try {
			bimg = ImageIO.read(new File(filePath + fileType));
			int width = bimg.getWidth();
			int height = bimg.getHeight();
			Assert.assertTrue(
					"The image width is not equal with the choosen width",
					siteWidth.equals(Integer.valueOf(width)));
			Assert.assertTrue(
					"The image height is not equal with the choosen height",
					siteHeight.equals(Integer.valueOf(height)));

			deleteFile(filePath, fileType);
		} catch (IOException e) {
			Assert.fail("Failed to read " + filePath + fileType +" image!");
			e.printStackTrace();
		}

	}

	public void verifyGrayscaleJPGExportImage() {

//		element(grayscaleRadioButton).waitUntilVisible();
//		element(jpgRadioButton).waitUntilVisible();
//		grayscaleRadioButton.click();
//		jpgRadioButton.click();

		String fileType = "chart_grayscale.jpg";
		String filePath = Constants.DOWNLOAD_FOLDER_PATH;

		Integer siteWidth;
		Integer siteHeight;
		String siteWidthString = getDriver().findElement(By.cssSelector("input#export_width")).getAttribute("value");
		String siteHeightString = getDriver().findElement(
				By.cssSelector("input#export_height")).getAttribute("value");

		siteWidth = Integer.valueOf(siteWidthString);
		siteHeight = Integer.valueOf(siteHeightString);

		exportChartButton.click();

		saveImageHandle2();
		waitABit(3000);
		BufferedImage bimg;
		try {
			bimg = ImageIO.read(new File(filePath + fileType));
			int width = bimg.getWidth();
			int height = bimg.getHeight();
			Assert.assertTrue(
					"The image width is not equal with the choosen width",
					siteWidth.equals(Integer.valueOf(width)));
			Assert.assertTrue(
					"The image height is not equal with the choosen height",
					siteHeight.equals(Integer.valueOf(height)));

			deleteFile(filePath, fileType);
		} catch (IOException e) {
			Assert.fail("Failed to read " + filePath + fileType +" image!");
			e.printStackTrace();
		}

	}

	public void verifyColorPNGExportImage() {

//		element(colorRadioButton).waitUntilVisible();
//		element(pngRadioButton).waitUntilVisible();
//		colorRadioButton.click();
//		pngRadioButton.click();

		String fileType = "chart_color.png";
		String filePath = Constants.DOWNLOAD_FOLDER_PATH;

		Integer siteWidth;
		Integer siteHeight;
		String siteWidthString = getDriver().findElement(
				By.cssSelector("input#export_width")).getAttribute("value");
		String siteHeightString = getDriver().findElement(
				By.cssSelector("input#export_height")).getAttribute("value");

		siteWidth = Integer.valueOf(siteWidthString);
		siteHeight = Integer.valueOf(siteHeightString);

		exportChartButton.click();

		saveImageHandle1();
		waitABit(3000);
		BufferedImage bimg;
		try {
			bimg = ImageIO.read(new File(filePath + fileType));
			int width = bimg.getWidth();
			int height = bimg.getHeight();
			Assert.assertTrue(
					"The image width is not equal with the choosen width",
					siteWidth.equals(Integer.valueOf(width)));
			Assert.assertTrue(
					"The image height is not equal with the choosen height",
					siteHeight.equals(Integer.valueOf(height)));

			deleteFile(filePath, fileType);
		} catch (IOException e) {
			Assert.fail("Failed to read " + filePath + fileType +" image!");
			e.printStackTrace();
		}
	}

	public void verifyGrayscalePNGExportImage() {

//		element(grayscaleRadioButton).waitUntilVisible();
//		element(pngRadioButton).waitUntilVisible();
//		grayscaleRadioButton.click();
//		pngRadioButton.click();

		String fileType = "chart_grayscale.png";
		String filePath = Constants.DOWNLOAD_FOLDER_PATH;

		Integer siteWidth;
		Integer siteHeight;
		String siteWidthString = getDriver().findElement(
				By.cssSelector("input#export_width")).getAttribute("value");
		String siteHeightString = getDriver().findElement(
				By.cssSelector("input#export_height")).getAttribute("value");

		siteWidth = Integer.valueOf(siteWidthString);
		siteHeight = Integer.valueOf(siteHeightString);

		exportChartButton.click();

		saveImageHandle2();
		waitABit(3000);
		BufferedImage bimg;
		try {
			bimg = ImageIO.read(new File(filePath + fileType));
			int width = bimg.getWidth();
			int height = bimg.getHeight();
			Assert.assertTrue(
					"The image width is not equal with the choosen width",
					siteWidth.equals(Integer.valueOf(width)));
			Assert.assertTrue(
					"The image height is not equal with the choosen height",
					siteHeight.equals(Integer.valueOf(height)));

			deleteFile(filePath, fileType);
		} catch (IOException e) {
			Assert.fail("Failed to read " + filePath + fileType +" image!");
			e.printStackTrace();
		}

	}
	
	public void verifyExportChart(String format, String extension){
		waitUntilElementExists(By.cssSelector("form#export-chart-form > div:nth-child(4) select"), 30);
		selectFromDropdown(exportWindowSelectFormatContainer, format);
		exportWindowExportChartButton.click();
		saveImageHandle1();
		waitABit(3000);
		FileChecker file = new FileChecker();
		file.verifyExtentionJpgOrPngFile(extension);
	}
	
	public void verifyExportTable(String extension){
		waitUntilElementExists(By.cssSelector("button#export_the_table"), 10);
		exportWindowExportTableButton.click();
		saveImageHandle2();
		waitABit(3000);
		FileChecker file = new FileChecker();
		file.verifyExtentionExcelFile(extension);
	}
	
	public void verifyExportChartAndTable(String extension){
		waitUntilElementExists(By.cssSelector("button#export_both_chart_and_table"), 10);
		exportWindowExportChartAndTableButton.click();
		saveImageHandle2();
		waitABit(3000);
		FileChecker file = new FileChecker();
		file.verifyExtentionExcelFile(extension);
	}
	
	public void clickOnChartRadioButton(){
		exportWindowChartRadioButton.click();
		Assert.assertTrue(exportWindowExportChartButton.isDisplayed());
	}
	
	public void clickOnTableRadioButton(){
		exportWindowTableRadioButton.click();
		Assert.assertTrue(exportWindowExportTableButton.isDisplayed());
	}
	
	public void clickOnTableAndChartRadioButton(){
		exportWindowChartAndTableRadioButton.click();
		Assert.assertTrue(exportWindowExportChartAndTableButton.isDisplayed());
	}
	
	public void clickAnnotationButton(){
		element(chartAnnotateButton).waitUntilVisible();
		chartAnnotateButton.click();
		element(chartAnnotationListWindow).waitUntilVisible();
	}
	
	public void clickNewAnnotationButton(){
		element(chartAnnotationListWindow).waitUntilVisible();
		element(chartAnnotationNewButton).waitUntilVisible();
		chartAnnotationNewButton.click();
	}
	
	public void newChartTextAnotationWindow(String annotationType, String textSize, String rotation, String description){
		
		element(chartAnnotationNewWindow).waitUntilVisible();

		element(chartAnnotationType).waitUntilVisible();
		String locatorAnnotationType = "select.select-annotation-type";
		selectFromDropdownList(locatorAnnotationType,annotationType);

		element(chartAnnotationTextSize).waitUntilVisible();
		String locatorTextSize = "select.select-text-size";
		selectFromDropdownList(locatorTextSize, textSize);

		element(chartAnnotationRotation).waitUntilVisible();
		element(chartAnnotationRotation).clear();
		element(chartAnnotationRotation).sendKeys(rotation);

		element(chartAnnotationDescription).waitUntilVisible();
		element(chartAnnotationDescription).clear();
		element(chartAnnotationDescription).sendKeys(description);
	}
	
	public void newChartLineAnnotationWindow(String annotationType, String lineType){
		
		element(chartAnnotationNewWindow).waitUntilVisible();
		element(chartAnnotationType).waitUntilVisible();
		String locatorAnnotationType = "select.select-annotation-type";
		selectFromDropdownList(locatorAnnotationType,annotationType);
		
		element(chartAnnotationLineType).waitUntilVisible();
		String locatorLineType = "select#annotation-line-type";
		selectFromDropdownList(locatorLineType, lineType);
	}
	
	public String addNewChartAnotationWindowColor(WebElement colorBoxElement){
		String color = element(colorBoxElement).getAttribute("style");
		return color;
	}
	
	public void newChartTextAnotation(String annotationType, String textSize, String rotation, String description){
		newChartTextAnotationWindow(annotationType,textSize,rotation,description);
		addNewChartAnotationWindowColor(chartNewAnnotationTextColorBox);
	}
	
	public void newChartLineAnotation(String annotationType, String lineType){
		newChartLineAnnotationWindow(annotationType,lineType);
		addNewChartAnotationWindowColor(chartNewAnnotationTextColorBox);
	}
	
//	public void verifyNewTextAnnotation(String textSize, String rotation, String description){
//		
//		String descriptionText = element(chartAnnotationListDescription).getText();
//		Assert.assertTrue("Text description is not the same", descriptionText.contains(description));
//		
//		String firstColor = addNewChartAnotationWindowColor(chartNewAnnotationTextColorBox);
//		List<Integer> firstRGB = StringUtils.getAllIntegerNumbersFromString(firstColor);
//		int firstColorR = firstRGB.get(0);
//		int firstColorG = firstRGB.get(1);
//		int firstColorB = firstRGB.get(2);
//		
//		String secondColor = element(chartAnnotationListColorBox).getAttribute("style");
//		List<Integer> secondRGB = StringUtils.getAllIntegerNumbersFromString(secondColor);
//		int secondColorR = secondRGB.get(0);
//		int secondColorG = secondRGB.get(1);
//		int secondColorB = secondRGB.get(2);
//		
//		Assert.assertEquals("RGB R color is not the same",firstColorR,secondColorR);
//		Assert.assertEquals("RGB G color is not the same",firstColorG,secondColorG);
//		Assert.assertEquals("RGB B color is not the same",firstColorB,secondColorB);
//		
//		String fontSize = element(chartAnnotationListFontSize).getText();
//		Assert.assertTrue("Text size is not the same", fontSize.contains(textSize));
//		
//		String textRotation = element(chartAnnotationListTextRotation).getText();
//		Assert.assertTrue("Text rotation is not the same", textRotation.contains(rotation));
//	}
	
	public void clickTspan(String text){
		List<WebElement> tspanList = getDriver().findElements(By.tagName(("tspan")));
		
		for(WebElement currentSpan:tspanList){
			if(currentSpan.getText().contains(text)){
				Actions action = new Actions(getDriver());
			    action.doubleClick(currentSpan).build().perform();
				break;
			}
		}
	}
	
	
	public void verifyEditTextAnnotationWindow(String textSize, String rotation, String description){
		
		waitABit(2000);
		clickTspan(description);
		
		waitABit(2000);
		element(chartEditAnnotationTextSize).waitUntilPresent();
		String anotTextSize = new Select(chartEditAnnotationTextSize).getFirstSelectedOption().getAttribute("value");
		Assert.assertTrue("Text size is not the same", anotTextSize.contains(textSize));
		
		element(chartEditAnnotationRotation).waitUntilPresent();
		String anotRotation = element(chartEditAnnotationRotation).getAttribute("value");
		Assert.assertTrue("Text rotation is not the same", anotRotation.contains(rotation));
		
		element(chartEditAnnotationDescription).waitUntilPresent();
		String descriptionText = element(chartEditAnnotationDescription).getAttribute("value");
		Assert.assertTrue("Text description is not the same", descriptionText.contains(description));
		waitABit(2000);
	}
	
	
	public void changeEditTextAnnotationWindow(String newTextSize, String newRotation, String newDescription){
		
		element(chartEditAnnotationTextSize).waitUntilPresent();
		String locatorTextSize = "select#text-annotation-size";
		selectFromDropdownList(locatorTextSize,newTextSize);
		
		element(chartEditAnnotationRotation).waitUntilPresent();
		element(chartEditAnnotationRotation).clear();
		element(chartEditAnnotationRotation).sendKeys(newRotation);
		
		element(chartEditAnnotationDescription).waitUntilPresent();
		element(chartEditAnnotationDescription).clear();
		element(chartEditAnnotationDescription).sendKeys(newDescription);
	}
	
	
	public void verifyNewLineAnnotation(String lineType){
		if(getDriver().findElements(By.cssSelector("g.highcharts-annotation-line")).size() == 1){
			Actions action = new Actions(getDriver());
		      action.doubleClick(getDriver().findElement(By.cssSelector("g.highcharts-annotation-line > path:nth-child(2)"))).build().perform();
		      waitABit(10000);
		  	String chartType = new Select(getDriver().findElement(By.cssSelector("select#line-annotation-dashstyle"))).getFirstSelectedOption().getAttribute("value");
			Assert.assertTrue("The title field is not empty",chartType.equals(lineType));
		}
		else{
			System.out.println("Couldn`t find any line annotation..");
		}
//		String lineStyle = element(chartAnnotationListLineType).getText();
//		Assert.assertTrue("Annotation line type is not the same", lineStyle.contains(lineType));
//		
//		String firstColor = addNewChartAnotationWindowColor(chartNewAnnotationTextColorBox);
//		List<Integer> firstRGB = StringUtils.getAllIntegerNumbersFromString(firstColor);
//		int firstColorR = firstRGB.get(0);
//		int firstColorG = firstRGB.get(1);
//		int firstColorB = firstRGB.get(2);
//		
//		String secondColor = element(chartAnnotationListColorBox).getAttribute("style");
//		List<Integer> secondRGB = StringUtils.getAllIntegerNumbersFromString(secondColor);
//		int secondColorR = secondRGB.get(0);
//		int secondColorG = secondRGB.get(1);
//		int secondColorB = secondRGB.get(2);
//		
//		Assert.assertEquals("RGB R color is not the same",firstColorR,secondColorR);
//		Assert.assertEquals("RGB G color is not the same",firstColorG,secondColorG);
//		Assert.assertEquals("RGB B color is not the same",firstColorB,secondColorB);
	}
	
	public void clickBackToAnotationList(){
		element(chartNewAnnotationBackToListButton).waitUntilPresent();
		chartNewAnnotationBackToListButton.click();
		element(chartAnnotationListWindow).waitUntilVisible();
	}
	
	public void clickOnAddToChart(){
		element(chartNewAnnotationAddToChartButton).waitUntilPresent();
		chartNewAnnotationAddToChartButton.click();
	}
		
	public void selectFromDropdownList(String locator, String element) {
		Select itemsPerPage = new Select(getDriver().findElement(
				By.cssSelector(locator)));
		itemsPerPage.selectByValue(element);
	}
	
	public void clickEditAnotationFromList(){
		element(chartAnnotationListEditButton).waitUntilPresent();
		chartAnnotationListEditButton.click();
		element(chartEditAnnotationWindow).waitUntilVisible();
	}
	
	public void doubleClickOnLineAnnotation(){
		
	}
	
	public void verifyEditLineAnnotationWindow(String lineType){
		
		element(chartEditAnnotationLineType).waitUntilVisible();
		String editLineTypeValue = getDriver().findElement(By.xpath("//select[@id='line-annotation-dashstyle']")).getAttribute("value");
		Assert.assertTrue("Annotation line type is not the same",editLineTypeValue.contains(lineType));
	}
		
	
	public void changeEditLineAnnotationWindow(String newLineType){
		
		element(chartEditAnnotationLineType).waitUntilVisible();
		String locatorLineType = "select#line-annotation-dashstyle";
		selectFromDropdownList(locatorLineType,newLineType);
		
	}
	
	public void verifyEditTextAnnotation(String newTextSize, String newRotation, String newDescription) {

		String descriptionText = element(chartAnnotationListDescription).getText();
		Assert.assertTrue("Text description is not the same",descriptionText.contains(newDescription));

		String fontSize = element(chartAnnotationListFontSize).getText();
		Assert.assertTrue("Text size is not the same",fontSize.contains(newTextSize));

		String textRotation = element(chartAnnotationListTextRotation).getText();
		Assert.assertTrue("Text rotation is not the same",textRotation.contains(newRotation));
	}
	
	public void verifyEditLineAnnotation(String newLineType){

		String lineType = element(chartAnnotationListLineType).getText();
		Assert.assertTrue("Text description is not the same",lineType.contains(newLineType));
		
	}
	
	public void clickEditTextAnotationWindowRemoveButton(){
		element(chartEditTextAnnotationRemoveButton).waitUntilPresent();
		chartEditTextAnnotationRemoveButton.click();
		element(chartEditLineAnnotationRemoveButton).waitUntilNotVisible();
	}
	
	public void clickEditTextAnotationWindowCancelButton(){
		element(chartEditTextAnnotationCancelButton).waitUntilPresent();
		chartEditTextAnnotationCancelButton.click();
	}
	

	public void clickEditLineAnotationWindowRemoveButton(){
		waitUntilElementExists(By.cssSelector("button#line-annotation-remove"), 30);
		chartEditLineAnnotationRemoveButton.click();
	}
	
	public void clickEditLineAnotationWindowCancelButton(){
		element(chartEditLineAnnotationCancelButton).waitUntilPresent();
		chartEditLineAnnotationCancelButton.click();
	}
	
	public void clickEditAnotationWindowSaveButton(){
		element(chartEditAnnotationSaveButton).waitUntilPresent();
		chartEditAnnotationSaveButton.click();
	}
		
	public void deleteChartAnnotationFromListWindow(){
		element(chartAnnotationListDeleteButton).waitUntilPresent();
		chartAnnotationListDeleteButton.click();
	}
	
	public void verifyChartAnnotationWasDeleted(){
		boolean elementPresent = false;
		try {
			getDriver().findElement(By.className("highcharts-annotation-text"));
			elementPresent = true;
		} catch (Exception e) {
			elementPresent = false;
		}
		Assert.assertFalse("Annotation was not deleted", elementPresent);
	}
	
	public void verifyChartLineAnnotationWasDeleted(){
		waitUntilElementDoesntExist(By.className("highcharts-annotation-line"), 10);
		boolean elementPresent = false;
		try {
			getDriver().findElement(By.className("highcharts-annotation-line"));
			elementPresent = true;
		} catch (Exception e) {
			elementPresent = false;
		}
		Assert.assertFalse("Annotation was not deleted", elementPresent);
	}
	
	public void clickChartFormatButton(){
		element(chartFormatButton).waitUntilVisible();
		chartFormatButton.click();
	}
	
	public void verifyFormatWindowDefaultState(){
		element(chartFormatWindow).waitUntilVisible();
		
		Assert.assertTrue("The title field is not empty",chartFormatTitleField.getAttribute("value").equals(""));
		Assert.assertTrue("The title field is not empty",chartFormatSubtitleField.getAttribute("value").equals(""));
		Assert.assertTrue("The title field is not empty",chartFormatDescriptionField.getAttribute("value").equals(""));
		
		String chartType = new Select(getDriver().findElement(By.xpath("//select[@class='chart-type-selection']"))).getFirstSelectedOption().getAttribute("value");
		Assert.assertTrue("The title field is not empty",chartType.equals("line"));
		
	}
	
	public void verifyFormatWindowSeries(String geography, String indicatorSeries) {
		element(chartFormatWindowTableSeries).waitUntilVisible();

		WebElement element=getDriver().findElement(By.cssSelector("table.table.table-striped.table-condensed.table-striped-datatool > tbody"));
		List<WebElement> rowCollection = element.findElements(By.cssSelector("tr"));
		
		int i_RowNum = 1;
		for (WebElement rowElement : rowCollection) {
			
			List<WebElement> colCollection = rowElement.findElements(By.cssSelector("td"));
			String firstTD = colCollection.get(0).getText();
			Assert.assertTrue("The row " + i_RowNum + " does not contain the selected geography", firstTD.contains(geography));
			Assert.assertTrue("The row " + i_RowNum + " does not contain the selected indicator", firstTD.contains(indicatorSeries));
			
			i_RowNum = i_RowNum + 1;
		}
	}
	
	public void clickChartFormatUpdateChartButton(){
		element(chartFormatUpdateChartButton).waitUntilVisible();
		chartFormatUpdateChartButton.click();
		waitABit(2000);
	}
	
	public void removeChartLegend(){
		
		element(chartFormatLegendDisableButton).waitUntilVisible();
		chartFormatLegendDisableButton.click();
		waitABit(2000);
		
		boolean elementPresent = false;
		try {
			getDriver().findElement(By.className("g.highcharts-legend"));
			elementPresent = true;
		} catch (Exception e) {
			elementPresent = false;
		}
		Assert.assertFalse("Chart legend was not removed", elementPresent);
	}
	
	public void insertChartLegend(){
		element(chartFormatLegendResetButton).waitUntilVisible();
		chartFormatLegendResetButton.click();
		waitABit(2000);
		element(chartLegend).waitUntilVisible();
		Assert.assertTrue(chartLegend.isDisplayed());
	}
	
	public void addChartTitleSubtitleDescriptionType(String title, String subtitle, String formatDescription, String chartType){
		
		element(chartFormatTitleField).waitUntilVisible();
		element(chartFormatTitleField).clear();
		element(chartFormatTitleField).sendKeys(title);
		
		element(chartFormatSubtitleField).waitUntilVisible();
		element(chartFormatSubtitleField).clear();
		element(chartFormatSubtitleField).sendKeys(subtitle);
		
		element(chartFormatDescriptionField).waitUntilVisible();
		element(chartFormatDescriptionField).clear();
		element(chartFormatDescriptionField).sendKeys(formatDescription);
		
		String locatorChartType = "select.chart-type-selection";
		selectFromDropdownList(locatorChartType,chartType);
	}
	
	public void verifyChartTitleSubtitle(String title, String subtitle){

		element(getDriver().findElement(By.cssSelector("text[class='highcharts-title']"))).waitUntilVisible();
		Assert.assertTrue("Chart title is not the same",getDriver().findElement(By.cssSelector("text[class='highcharts-title'] > tspan")).getText().contains(title));
		
		element(getDriver().findElement(By.cssSelector("text[class='highcharts-subtitle']"))).waitUntilVisible();
		Assert.assertTrue("Chart title is not the same",getDriver().findElement(By.cssSelector("text[class='highcharts-subtitle'] > tspan")).getText().contains(subtitle));
	}
	
//	public void verifyChartTitleSubtitle(String title, String subtitle){

//		element(getDriver().findElement(By.cssSelector("text[class='highcharts-title']"))).waitUntilVisible();
//		Assert.assertTrue("Chart title is not the same",getDriver().findElement(By.cssSelector("text[class='highcharts-title'] > tspan")).getText().contains(title));
//		Assert.assertTrue("Chart title is not the same",getDriver().findElement(By.xpath("//text[@class='highcharts-title']/tspan")).getText().contains(title));
		
//		System.out.println("----------------------in the method");
//		
//		clickChartFormatButton();
//		clickChartFormatButton();

//		waitABit(4000);
//		getDriver().switchTo().activeElement();
//
//		waitABit(4000);
		
//		WebElement dinaChart = getDriver().findElement(By.cssSelector("div#dynamic_chart"));
//		
//		System.out.println("Found dinaChart");
//		
//
//		
//		WebElement titleBit = getDriver().findElement(By.cssSelector("*.highcharts-title"));
//		
//		System.out.println("Elem loading");
//		System.out.println("Elem now: " + element(titleBit).getAttribute("class"));
//		System.out.println("Elem bool: " + element(titleBit).getWrappedElement().getText());
		
//		List<WebElement> textContainers = dinaChart.findElements(By.tagName("text"));
//		
//		for(WebElement textNow: textContainers){
//			
//			System.out.println("Elem now: " + element(textNow).getAttribute("class"));
//
//			System.out.println("Elem x: " + textNow.findElement(By.tagName("tspan")).getAttribute("x"));
//			WebElement tspanNow = textNow.findElement(By.tagName("tspan"));
//			
////			boolean isTrue = element(tspanNow).getTextValue()
//			System.out.println("Elem bool: " + element(titleBit).getWrappedElement());
//		}
//		System.out.println("----------------------out the method");
		
//	}
	
	
	public void verifyChartTitleSubtitleDescriptionType(String title, String subtitle, String formatDescription, String chartType, String seriesType){
		element(chartFormatTitleField).waitUntilVisible();
		Assert.assertTrue("The title is not the same",chartFormatTitleField.getAttribute("value").equals(title));
		
		element(chartFormatSubtitleField).waitUntilVisible();
		Assert.assertTrue("The subtitle is not the same",chartFormatSubtitleField.getAttribute("value").equals(subtitle));
		
		element(chartFormatDescriptionField).waitUntilVisible();
		Assert.assertTrue("The description is not the same",chartFormatDescriptionField.getAttribute("value").equals(formatDescription));
		
		String cType = new Select(getDriver().findElement(By.cssSelector("select.chart-type-selection"))).getFirstSelectedOption().getAttribute("value");
		Assert.assertTrue("The title field is not empty",cType.equals(chartType));
		
		
//		WebElement element=getDriver().findElement(By.cssSelector("table.table.table-striped.table-condensed.table-striped-datatool > tbody"));
//		List<WebElement> rowCollection = element.findElements(By.cssSelector("tr"));
//		
//		int i_RowNum = 1;
//		for (WebElement rowElement : rowCollection) {
//			
//			List<WebElement> colCollection = rowElement.findElements(By.cssSelector("td:nth-of-type(5)"));
//			String seriesType = new Select (colCollection.get(2).findElement(By.cssSelector("select.select-series-type"))).getFirstSelectedOption().getAttribute("value");
//			Assert.assertTrue("The row " + i_RowNum + " does not contain the selected Series Type: " + chartType, seriesType.contains(chartType));
//			
//			i_RowNum = i_RowNum + 1;
//		}
		
		selectFromDropdown(getDriver().findElement(By.cssSelector("table.table.table-striped.table-condensed.table-striped-datatool > tbody > tr > td:nth-child(4) > select")), seriesType);
	}
	
//	public void addVerifyTableRandomCellAnnotation(String annotationType, String description){
//		
//		int rowCount=getDriver().findElements(By.cssSelector("table.dvpack_table.dataTable > tbody > tr")).size();
//		System.out.println("int rowCount= " + rowCount);
//		int columnCount=getDriver().findElements(By.cssSelector("table.dvpack_table.dataTable > tbody > tr:nth-child(1) > td")).size();
//		System.out.println("int columnCount" + columnCount);
//		
//		int row = StringUtils.randomNumber(rowCount);
//		System.out.println("random row is " + row);
//		String r = String.valueOf(row);
//		String newRow = String.valueOf(row+1);
//		int column = StringUtils.randomNumber(columnCount);
//		System.out.println("random column is " + column);
//		String c = String.valueOf(column);
//		String newColumn = String.valueOf(column+1);
//		
//		element(tableNewAnnotationType).waitUntilVisible();
//		String type = "select#table-annotation-type";
//		selectFromDropdownList(type,annotationType);
//		String t = "new";
//		genericFillTableCellAnnotation(r,c,description,t,tableNewAnnotationDescription);
//		
//		element(tableNewAnnotationSaveButton).waitUntilVisible();
//		element(tableNewAnnotationSaveButton).click();
//		
//		waitABit(2000);
//		WebElement markedCell = getDriver().findElement(By.cssSelector("table.dvpack_table.dataTable > tbody > tr:nth-child(" + newRow + ") > td:nth-child(" + newColumn + ")"));
//		element(markedCell).waitUntilVisible();
//		String cell = markedCell.getAttribute("title");
//		Assert.assertTrue("Description is not the same",cell.equals(description));
//		
//	}
	
	public void goFullScreen(){
		element(getDriver().findElement(By.className("brand"))).waitUntilVisible();
		getDriver().findElement(By.className("brand")).sendKeys(Keys.F11);
	}
		
	public void tableAddNewCellAnnotation(String annotationType, String description, String row, String column){
//		getDriver().findElement(By.cssSelector("article#content-wrapper > div[class='media-widget'] h4")).click();
		waitUntilElementExists(By.cssSelector("div#dynamic_table > div[class='dataTables_wrapper no-footer']"), 20);
//		getDriver().findElement(By.cssSelector("div.dataTables_wrapper > div:nth-child(1) >div.dataTables_scroll >  div.dataTables_scrollBody > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")")).click();
		Actions action = new Actions(getDriver());
//		new Actions(driver).moveToElement(element).perform();
		action.moveToElement(getDriver().findElement(By.cssSelector("div.dataTables_wrapper > div:nth-child(1) >div.dataTables_scroll >  div.dataTables_scrollBody > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")"))).build().perform();
		Sleeper.sleepTight(5000);
	    action.doubleClick(getDriver().findElement(By.cssSelector("div.dataTables_wrapper > div:nth-child(1) >div.dataTables_scroll >  div.dataTables_scrollBody > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")"))).build().perform();
		
		element(tableNewAnnotationType).waitUntilVisible();
		String type = "select#add-table-annotation-type";
		selectFromDropdownList(type,annotationType);
		
		element(tableNewAnnotationDescription).waitUntilVisible();
		element(tableNewAnnotationDescription).clear();
		element(tableNewAnnotationDescription).sendKeys(description);

//		String t = "new";
//		genericFillTableCellAnnotation("1","3",description,t,tableNewAnnotationDescription);
		Sleeper.sleepTight(3000);
		element(tableAnnotationSaveButton).waitUntilVisible();
		element(tableAnnotationSaveButton).click();
		
		waitUntilElementDoesntExist(By.cssSelector("button.btn.btn-small.submit"), 20);
	}
	
	public void tableVerifyNewCellAnnotation(String description, String row, String column){
		
		genericVerifyCellAnnotation(description,row,column);
	}
	
	public void genericVerifyCellAnnotation(String description, String row, String column){
		
		waitABit(2000);
		WebElement markedCell = getDriver().findElement(By.cssSelector("div.dataTables_wrapper > div:nth-child(1) >div.dataTables_scroll >  div.dataTables_scrollBody > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")"));
		element(markedCell).waitUntilVisible();
		String cell = markedCell.getAttribute("title");
		Assert.assertTrue("Description is not the same",cell.equals(description));
	}
	
	public void genericVerifyCellAnnotationList(String row, String column, String description){
		
		WebElement element=getDriver().findElement(By.cssSelector("table.table.table-striped.table-condensed.table-striped-datatool > tbody"));
		List<WebElement> rowCollection = element.findElements(By.cssSelector("tr"));
		
		int i_RowNum = 1;
		for (WebElement rowElement : rowCollection) {
			
			List<WebElement> colCollection = rowElement.findElements(By.cssSelector("td"));
			String firstTD = colCollection.get(0).getText();
			Assert.assertTrue("The row " + i_RowNum + " does not contain the inserted description", firstTD.contains(description));
			String secondTD = colCollection.get(1).getText();
			Assert.assertTrue("The row " + i_RowNum + " does not contain the selected row", secondTD.contains(row));
			String thirdTD = colCollection.get(2).getText();
			Assert.assertTrue("The row " + i_RowNum + " does not contain the selected column", thirdTD.contains(column));
			
			i_RowNum = i_RowNum + 1;
		}
	}
	
	public void tableVerifyNewCellAnnotationList(String description){
		
		int rowCount=getDriver().findElements(By.cssSelector("table.dvpack_table.dataTable > tbody > tr")).size();
		int columnCount=getDriver().findElements(By.cssSelector("table.dvpack_table.dataTable > tbody > tr:nth-child(1) > td")).size();
		
		String row = String.valueOf(rowCount-1);
		String column = String.valueOf(columnCount-1);
		
		genericVerifyCellAnnotationList(row,column,description);
	}
	
	public void clickOnEditTableAnnotationList(){
		element(tableAnnotationsListEditButton).waitUntilVisible();
		tableAnnotationsListEditButton.click();
		element(tableEditAnnotationWindow).waitUntilVisible();		
	}
	
	public void tableEditCellAnnotationList(String newDescription,String row, String column){

		Actions action = new Actions(getDriver());
	    action.doubleClick(getDriver().findElement(By.cssSelector("div.dataTables_wrapper > div:nth-child(1) >div.dataTables_scroll >  div.dataTables_scrollBody > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")"))).build().perform();
		
		
		element(tableEditAnnotationDescription).waitUntilVisible();
		element(tableEditAnnotationDescription).clear();
		element(tableEditAnnotationDescription).sendKeys(newDescription);
		
//		String t = "new";
//		genericFillTableCellAnnotation("1","3",description,t,tableNewAnnotationDescription);
		
		element(tableAnnotationSaveButton).waitUntilVisible();
		element(tableAnnotationSaveButton).click();
		
	}
	

	public void tableVerifyEditCellAnnotation(String newDescription, String row, String column){
		
		genericVerifyCellAnnotation(newDescription,row,column);
	}
	
//	public void tableVerifyEditCellAnnotationList(String description){
//		
//		int rowCount=getDriver().findElements(By.cssSelector("table.dvpack_table.dataTable > tbody > tr")).size();
//		int columnCount=getDriver().findElements(By.cssSelector("table.dvpack_table.dataTable > tbody > tr:nth-child(1) > td")).size();
//		
//		String row = String.valueOf(rowCount-2);
//		String column = String.valueOf(columnCount-2);
//		
//		genericVerifyCellAnnotationList(row,column,description);
//	}
	
	public void genericFillTableCellAnnotation(String row, String column, String description, String type, WebElement element){
		
		String instanceRow = "select#table-"+type+"-row";
		String instanceColumn = "select#table-"+type+"-column";
		selectFromDropdownList(instanceRow,row);
		
		selectFromDropdownList(instanceColumn,column);
		
		element(element).waitUntilVisible();
		element(element).clear();
		element(element).sendKeys(description);
	}
	
//	public void clickOnEditTableAnnotationListSaveButton(){
//		element(tableEditAnnotationSaveButton).waitUntilVisible();
//		tableEditAnnotationSaveButton.click();
//	}
	
//	public void clickOnNewTableAnnotationListSaveButton(){
//		element(tableNewAnnotationSaveButton).waitUntilVisible();
//		tableNewAnnotationSaveButton.click();
//	}
	
	public void clickOnTableCellAnnotationDeleteButton(String row, String column){
//		while(getDriver().findElements(By.cssSelector("button.btn.btn-link.btn-small.delete-annotation")).size() ==0){
			Actions action = new Actions(getDriver());
		    action.doubleClick(getDriver().findElement(By.cssSelector("div.dataTables_wrapper > div:nth-child(1) >div.dataTables_scroll >  div.dataTables_scrollBody > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")"))).build().perform();
//		}
		element(tableAnnotationsListDeleteButton).waitUntilVisible();
		tableAnnotationsListDeleteButton.click();
	}
	
	public void clickOnTableRowAnnotationDeleteButton(String row){
		waitABit(5000);
		evaluateJavascript("var dd =jQuery('div.dataTables_wrapper > div:nth-child(1) >div.dataTables_scroll >  div.dataTables_scrollBody > table > tbody > tr:nth-child(1) > td:nth-child(1)').eq(0);dd.dblclick();");
//
//		Actions action = new Actions(getDriver());
//		action.doubleClick(getDriver().findElement(By.cssSelector("table.dvpack_table.dataTable > tbody > tr:nth-child("+row+") > td:nth-child(1)"))).build().perform();

		element(tableAnnotationsListDeleteButton).waitUntilVisible();
		tableAnnotationsListDeleteButton.click();
	}
	
	public void tableAddNewRowAnnotation(String annotationType, String description, String row, String column){
		waitUntilElementExists(By.cssSelector("div.dataTables_wrapper > div:nth-child(1) >div.dataTables_scroll >  div.dataTables_scrollBody > table"), 10);
		Sleeper.sleepTight(5000);
		Actions action = new Actions(getDriver());
	    action.doubleClick(getDriver().findElement(By.cssSelector("div.dataTables_wrapper > div:nth-child(1) >div.dataTables_scroll >  div.dataTables_scrollBody > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")"))).build().perform();
		
		element(tableNewAnnotationType).waitUntilVisible();
		String type = "select#add-table-annotation-type";
		selectFromDropdownList(type,annotationType);
		
		element(tableNewAnnotationDescription).waitUntilVisible();
		element(tableNewAnnotationDescription).clear();
		element(tableNewAnnotationDescription).sendKeys(description);
		
		element(tableAnnotationSaveButton).waitUntilVisible();
		element(tableAnnotationSaveButton).click();

		waitUntilElementDoesntExist(By.cssSelector("button.btn.btn-small.submit"), 20);
	}
	
	public void tableVerifyNewRowAnnotation(String description, String row){
		
		waitABit(3000);
		WebElement markedRow = getDriver().findElement(By.cssSelector("div.dataTables_wrapper > div.DTFC_ScrollWrapper > div.DTFC_LeftWrapper  > div.DTFC_LeftBodyWrapper > div > table > tbody > tr:nth-child(" + row + ") > td"));
		String vrow = markedRow.getText();
		Assert.assertTrue("Description is not the same",vrow.equals(description));
		
	}
	
//	public void tableVerifyEditRowAnnotationList(String description, String row){
//		
//		int rowCount=getDriver().findElements(By.cssSelector("table.dvpack_table.dataTable > tbody > tr")).size();
//		System.out.println("row count is: " + rowCount);
//		
//		String row = String.valueOf(rowCount-1);
//		System.out.println("the row number is:" + row);
//		
//		WebElement element=getDriver().findElement(By.cssSelector("table.table.table-striped.table-condensed.table-striped-datatool > tbody"));
//		List<WebElement> rowCollection = element.findElements(By.cssSelector("tr"));
//		
//		int i_RowNum = 1;
//		for (WebElement rowElement : rowCollection) {
//			
//			List<WebElement> colCollection = rowElement.findElements(By.cssSelector("td"));
//			String firstTD = colCollection.get(0).getText();
//			Assert.assertTrue("The row " + i_RowNum + " does not contain the inserted description", firstTD.contains(description));
//			String secondTD = colCollection.get(1).getText();
//			Assert.assertTrue("The row " + i_RowNum + " does not contain the selected row", secondTD.contains(row));
//			
//			i_RowNum = i_RowNum + 1;
//		}
//	}
	
	public void tableEditRowAnnotationList(String newDescription, String row, String column){
		
		Actions action = new Actions(getDriver());
	    action.doubleClick(getDriver().findElement(By.cssSelector("div.dataTables_wrapper > div:nth-child(1) >div.dataTables_scroll >  div.dataTables_scrollBody > table > tbody > tr:nth-child("+row+") > td:nth-child(1)"))).build().perform();
		
		element(tableEditAnnotationDescription).waitUntilVisible();
		element(tableEditAnnotationDescription).clear();
		element(tableEditAnnotationDescription).sendKeys(newDescription);
				
		elementClick("button.btn.btn-small.submit");
		
//		element(tableAnnotationSaveButton).waitUntilVisible();
//		element(tableAnnotationSaveButton).click();

	}
	
	public void tableVerifyEditRowAnnotation(String newDescription, String row){
		waitUntilElementExists(By.cssSelector("div.dataTables_wrapper > div.DTFC_ScrollWrapper > div.DTFC_LeftWrapper  > div.DTFC_LeftBodyWrapper > div > table > tbody > tr:nth-child(" + row + ") > td"), 40);
		WebElement markedCell = getDriver().findElement(By.cssSelector("div.dataTables_wrapper > div.DTFC_ScrollWrapper > div.DTFC_LeftWrapper  > div.DTFC_LeftBodyWrapper > div > table > tbody > tr:nth-child(" + row + ") > td"));
		element(markedCell).waitUntilVisible();
		String cell = markedCell.getText();
		System.out.println(cell);
		System.out.println(newDescription);
		Assert.assertTrue("Description is not the same",cell.equals(newDescription));
	}
	
	public void verifyTableCellAnnotationWasDeleted(String description){
		waitABit(5000);
		boolean elementPresent = false;
		try {
			getDriver().findElement(By.cssSelector("div.dataTables_wrapper > div:nth-child(1) >div.dataTables_scroll >  div.dataTables_scrollBody > table td[title='"+description+"']"));
			elementPresent = true;
		} catch (Exception e) {
			elementPresent = false;
		}
		Assert.assertFalse("Annotation was not deleted", elementPresent);
	}
	
	public void verifyTableRowAnnotationWasDeleted(String description){
		waitABit(5000);
		boolean elementPresent = false;
		try {
			getDriver().findElement(By.cssSelector("div.dataTables_wrapper > div:nth-child(1) >div.dataTables_scroll >  div.dataTables_scrollBody > table tr.dvpack_table_row.dvpack_table_row_annotation"));
			elementPresent = true;
		} catch (Exception e) {
			elementPresent = false;
		}
		Assert.assertFalse("Annotation was not deleted", elementPresent);
	}
	
	public void verifyDownloadQueueMessage(){
		waitUntilElementExists(By.cssSelector("section#fixed-header div.alert.alert-info "), 20);
		
		String queueMessage = getDriver().findElement(By.cssSelector("section#fixed-header div.alert.alert-info ")).getText();
		Assert.assertTrue("The queue message is not displayed",queueMessage.contains("Your download is being processed.Please search for more data, continue to navigate or click refresh on your browser"));
	}

//	public void selectAnnotationColor(int r, int g, int b) {
//		System.out.println("In selectAnnotationColor method");
//		evaluateJavascript(String
//				.format("jQuery('div.sp-container.sp-light.sp-input-disabled.sp-palette-disabled.sp-initial-disabled > div.sp-picker-container > div.sp-top.sp-cf > div.sp-top-inner > div.sp-color').css('style','background-color: rgb(%d, %d, %d);');",
//						r, g, b));
//	}
		
//	public WebElement getElementWhenVisible(By locator, int timeoutSeconds) {
//		  Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
//		    .withTimeout(timeoutSeconds * 2, TimeUnit.SECONDS)
//		    .pollingEvery(500, TimeUnit.MILLISECONDS)
//		    .ignoring(NoSuchElementException.class);
//
////		  WebElement element = wait.until(ExpectedConditions
////		    .visibilityOfElementLocated(locator));
//		  WebElement element = getDriver().findElement(locator);
//		  $(element).waitUntilVisible();
//		  return element;
//		 }
//	 
	public void waitTableToLoad(){
		
	}
	
	public void getCellValueFromTableAndVerify(String cellValue,int row, int column){
		String cellValueFromTable=null;
		if(row>0 &&row<=rows.size() && column>0 && column<=columns.size()){
		element(getDriver().findElement(By.cssSelector("div.dataTables_scroll > div.dataTables_scrollBody > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")"))).waitUntilVisible();
	    cellValueFromTable = getDriver().findElement(By.cssSelector("div.dataTables_scroll > div.dataTables_scrollBody > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")")).getText();
		}
		System.out.println(cellValue);
		System.out.println(cellValueFromTable);
		Assert.assertTrue(cellValueFromTable.contains(cellValue));
	}
	
	public void getCellValueReplaceCommaAndVerify(String cellValue, int row, int column){
	String cellValueFromTable=null;
	if(row>0 &&row<=rows.size() && column>0 && column<=columns.size()){
	element(getDriver().findElement(By.cssSelector("div.dataTables_scroll > div.dataTables_scrollBody > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")"))).waitUntilVisible();
	cellValueFromTable = getDriver().findElement(By.cssSelector("div.dataTables_scroll > div.dataTables_scrollBody > table > tbody > tr:nth-child("+row+") > td:nth-child("+column+")")).getText();
	}
		System.out.println(cellValue);
		cellValueFromTable=cellValueFromTable.replaceAll(",","");
		System.out.println(cellValueFromTable);
		Assert.assertTrue(cellValueFromTable.contains(cellValue));
	}
	
	public void verifyIfActionIconsAreEnabled(){
		Assert.assertTrue(chartExportButton.isEnabled());
		Assert.assertTrue(chartPrintButton.isEnabled());
		Assert.assertTrue(chartAnnotateButton.isEnabled());
		Assert.assertTrue(saveButton.isEnabled());
		Assert.assertTrue(chartFormatButton.isEnabled());
		Assert.assertTrue(filterDownloadButton.isEnabled());
		Assert.assertTrue(filterDisplayDataButton.isEnabled());
	}
	
	public void verifyMessagesForDisplayingLargeAmountOfData(){
		waitUntilElementExists(By.cssSelector("div#dynamic_chart > div.alert.alert-info"), 10);
		Assert.assertTrue(alertMessageForChart.getText().contains("Please refine your selection, charts cannot contain more than 20 data series"));
		Assert.assertTrue(alertMessageForTable.getText().contains("Please refine your selection, tables cannot contain more than 60 data series"));
	}
	
    public void verifyEntitledIndicatorFromLeftHandFilter(String entitledIndicator){
		
		int indicatorSectionNumber=3;
		
		if(entitledIndicator.equals("Country Risk")){
			entitledIndicator="Macro-Economic Data";
		}
		
		List<WebElement>  indicators=getDriver().findElements(By.cssSelector("ul.nav.nav-list > li:nth-child("+indicatorSectionNumber+") > div.expandable-wrapper > ul > *"));
		
		for(int i=2;i<=indicators.size();i++){
			System.out.println("Indicator: "+getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+indicatorSectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> label")).getText());
		    Assert.assertTrue("Unentitled indicator is displayed",getDriver().findElement(By.cssSelector("ul.nav.nav-list > li:nth-child("+indicatorSectionNumber+") > div.expandable-wrapper > ul > li:nth-child("+i+")> label")).getText().contains(entitledIndicator));
			}
	}
    
    public void verifyExportButtonIsDisabled(){
    	try{
    		exportChartButton.getAttribute("disabled").contains("");
    	}catch(NullPointerException npe){
    		Assert.assertTrue("Export button is enabled", 0 == 1); // :)
    		//an enabled button doesn't have attribute disabled so it always throws NullPointerException 
    		//instead of the ugly message I added a try/catch and an Assert with a value that is always false (0==1 is false...for integer numbers at least :))
    		//so the test will fail with the message "Button is enabled" instead of the ugly message NullPointerException gives.
    	}
    }
    
    public void verifyRawDataButtonIsDisabled(){
    	Assert.assertTrue("Raw Data button is not disabled",filterDownloadButton.getAttribute("class").contains("disabled"));
    }
    
    public void verifySaveButtonIsDisabled(){
    	try{
    		saveButton.getAttribute("disabled").contains("");
    	}
    	catch(NullPointerException npe){
    		Assert.assertTrue("Save button is enabled", 0 == 1); // :)
    	}
    }
    
    public void verifyLayoutButtonIsDisabled(){
		try {
			selectButton.getAttribute("disabled").contains("");

		} catch (NullPointerException npe) {
			Assert.assertTrue("Layout button is enabled", 0 == 1); // :)
		}
	}
    
    public void verifyDisplayDataButtonIsDisabled(){
    	Assert.assertTrue("Display data button is not disabled",filterDisplayDataButton.getAttribute("class").contains("disabled"));
    }
    
    public void verifyFilterSectionsAreDisabled(String breadcrumb, String databaseName){
    	WebElement filterContainer=getDriver().findElement(By.cssSelector("ul.nav.nav-list"));
    	List <WebElement> sections=filterContainer.findElements(By.cssSelector("li > h5"));
  
    			System.out.println("Sections: "+sections.size());
    		
    			for(WebElement section :sections){
    				if(!section.getText().contains("Geography")){
    				Assert.assertTrue("Section is not disabled",section.getAttribute("class").contains("inactive"));
			}
		}
	}
    
	public void verifyGeographyIsDeselectedDataTool(String country,String continent){
		boolean isContinentSelected,isCountrySelected;
		if(!country.equals("")){
		isCountrySelected=verifyElementState("document.getElementById('"+country+"')");
		Assert.assertFalse("Checkbox is checked",isCountrySelected);
		}
		if(!continent.equals("")){
		isContinentSelected=verifyElementState("document.getElementById('"+continent+"')");
		Assert.assertFalse("Checkbox is checked",isContinentSelected);
		}
	}
}

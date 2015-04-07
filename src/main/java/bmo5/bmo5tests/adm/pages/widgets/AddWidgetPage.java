package bmo5.bmo5tests.adm.pages.widgets;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;
import bmo5.bmo5tests.tools.adm.SelectEnums.NPCSelect;
import bmo5.bmo5tests.tools.adm.SelectEnums.PageAreaSelect;

public class AddWidgetPage extends AbstractAdmPage {


	@FindBy(css = "select#Page")
	private WebElement pageSelect;

	@FindBy(id = "AreaWP_3rd_column")
	private WebElement thirdColumn;
	
	@FindBy(id = "AreaWP_preview")
	private WebElement previewColumn;
	
	@FindBy(id = "AreaWP_bottom")
	private WebElement bottomColumn;
	
	@FindBy(id = "PivotType")
	private WebElement pivotTypeSelect;
	
	@FindBy(id = "Slot")
	private WebElement slotSelect;
	
	@FindBy(id = "NPCSensitive_1")
	private WebElement npcYes;
	
	@FindBy(id = "NPCSensitive_0")
	private WebElement npcNo;
	
	@FindBy(id = "WidgetCategory")
	private WebElement widgetCategorySelect;
	
	@FindBy(id = "Widget")
	private WebElement widgetSelect;
	
	@FindBy(id = "add_widge_page_form_btn")
	private WebElement addWidgetButton;
	
	
	/**
	 * Page Select:
	 * valid values: TBD
	 * @param pageName
	 */
	public void pageSelect(String pageName) {		
		element(pageSelect).waitUntilVisible();
		element(pageSelect).selectByVisibleText(pageName);
	}

	/**
	 * Radio Button for Area select:
	 * valid values: Third Column ,  Preview  , Bottom
	 * @param area
	 */
	public void areaSelect(String area) {
		if (splitCamelCase(PageAreaSelect.ThirdColumn.name()).contains(area)) {
			element(thirdColumn).waitUntilVisible();
			thirdColumn.click();
		}
		if (splitCamelCase(PageAreaSelect.Preview.name()).contains(area)) {
			element(previewColumn).waitUntilVisible();
			previewColumn.click();
		}
		if (splitCamelCase(PageAreaSelect.Bottom.name()).contains(area)) {
			element(bottomColumn).waitUntilVisible();
			bottomColumn.click();
		}
	}

	/**
	 * valid values: All, Geography, Industry
	 * @param pivot
	 */
	public void pivotPointSelect(String pivot){
		element(pivotTypeSelect).waitUntilVisible();
		element(pivotTypeSelect).selectByVisibleText(pivot);
	}
	
	/**
	 * valid values: 1, 2, 3
	 * @param pivot
	 */
	public void slotSelect(String slot){
		element(slotSelect).waitUntilVisible();
		element(slotSelect).selectByVisibleText(slot);
	}

	/**
	 * Radio Button for NPC select:
	 * valid values: Yes , No
	 * @param npc
	 */
	public void npcSelect(String npc) {
		if (NPCSelect.Yes.name().contains(npc)) {
			element(npcYes).waitUntilVisible();
			npcYes.click();
		}
		if (NPCSelect.No.name().contains(npc)) {
			element(npcNo).waitUntilVisible();
			npcNo.click();
		}
	}

	/**
	 * Widget Category Select:
	 * valid values: Analyst choice, Widgets
	 * @param widgetCategory
	 */
	public void widgetCategorySelect(String widgetCategory) {
		element(widgetCategorySelect).waitUntilVisible();
		element(widgetCategorySelect).selectByVisibleText(widgetCategory);
		
	}

	/**
	 * Widget Select:
	 * valid values: TBD
	 * @param widget
	 */
	public void widgetSelect(String widget) {
		element(widgetSelect).waitUntilVisible();
		element(widgetSelect).selectByVisibleText(widget);
		
	}
	
	public void addWidget() {
		element(addWidgetButton).waitUntilVisible();
		addWidgetButton.click();
		
	}
}

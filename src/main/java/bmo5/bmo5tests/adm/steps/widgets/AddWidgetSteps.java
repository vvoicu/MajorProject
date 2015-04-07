package bmo5.bmo5tests.adm.steps.widgets;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class AddWidgetSteps extends AbstractAdmSteps {

	private static final long serialVersionUID = -8146041904145113035L;

	@StepGroup
	public void addWidget(String page, String area, String pivot, String slot,
			String npc, String widgetCategory, String widget) {
		pageSelect(page);
		areaSelect(area);
		pivotPointSelect(pivot);
		slotSelect(slot);
		npcSelect(npc);
		widgetCategorySelect(widgetCategory);
//		widgetSelect(widget);
		addWidget();

	}

	@Step
	public void pageSelect(String page) {
		addWidgetPage().pageSelect(page);
	}

	@Step
	public void areaSelect(String area) {
		addWidgetPage().areaSelect(area);
	}

	@Step
	public void pivotPointSelect(String pivot) {
		addWidgetPage().pivotPointSelect(pivot);
	}

	@Step
	public void slotSelect(String slot) {
		addWidgetPage().slotSelect(slot);
	}

	@Step
	public void npcSelect(String npc) {
		addWidgetPage().npcSelect(npc);
	}

	@Step
	public void widgetCategorySelect(String widgetCategory) {
		addWidgetPage().widgetCategorySelect(widgetCategory);
	}

	@Step
	public void widgetSelect(String widget) {
		addWidgetPage().widgetSelect(widget);
	}

	@Step
	public void addWidget() {
		addWidgetPage().addWidget();
	}
}

package bmo5.bmo5tests.bmo.steps.homepage;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class FilterPanelSpecialRepSteps extends AbstractSteps {

	private static final long serialVersionUID = 8858564152118641503L;

	@Step
	public void clickOnLeftPanelGeography(int itemGeo,String geoCheck) {
		filterPanelSpecialRepPage().clickOnLeftPanelLevelOne(itemGeo,geoCheck);
	}

	@Step
	public void clickOnLeftPanelService(int service) {
		filterPanelSpecialRepPage().clickOnLeftPanelLevelFour(service);
	}

	@Step
	public void verifyBreadcrumbs(String specialReports){
		filterPanelSpecialRepPage().verifyBreadcrumbs(specialReports);
	}

	@Step
	public void clickHome() {
		filterPanelSpecialRepPage().clickOnHome();

	}
	
	@Step
	public void clickOnDatePicker(String day) {
		filterPanelSpecialRepPage().setDate(day);
		
	}

	@Step
	public void selectAndVerifyPublicationDateRadioOptions(int anytime, int lastWeek, int lastM, int lastThreeM, int lastSixM, String sixM, String any) {
		filterPanelSpecialRepPage().verifyCheckbox(anytime, lastWeek, lastM, lastThreeM, lastSixM, sixM, any);
		
	}

	@Step
	public void searchForAllWordsFilter(String searchTerm,String specialReportTitleNo) {
		filterPanelSpecialRepPage().searchForAllOfTheseWords(searchTerm, specialReportTitleNo);
		
	}
}


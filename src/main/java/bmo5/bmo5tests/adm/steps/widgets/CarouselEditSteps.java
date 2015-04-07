package bmo5.bmo5tests.adm.steps.widgets;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class CarouselEditSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = 3232789789272079695L;

	@Step
	public void deleteAllDataAndClickOnUpdateButtonThenClickOnResetLink(){
		carouselEditPage().deleteAllDataAndClickOnUpdateButtonThenClickOnResetLink();
	}
	
	@Step
	public void completeFieldsWithInvalidDataAndClickOnUpdateButton(String invalidArticleID, String invalidReportID, String invalidDvpackID){
		carouselEditPage().completeFieldsWithInvalidDataAndClickOnUpdateButton(invalidArticleID, invalidReportID, invalidDvpackID);
	}
	
	@Step
	public void clickOnListViewButton(){
		carouselEditPage().clickOnListViewButton();
	}
}

package bmo5.bmo5tests.adm.steps.widgets;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class CarouselSteps extends AbstractAdmSteps{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4082404936914996838L;

	@Step
	public void clickOnAddNewButtonAndSaveWithoutCompletingAnyFieldAndVerify(){
		carouselPage().clickOnAddNewButtonAndSaveWithoutCompletingAnyFieldAndVerify();
	}
	
	@Step
	public void clickOnAddNewButtonCompleteFieldsWithValidDataSaveAndVerify(String articleID, String reportID, String dvPackID){
		carouselPage().clickOnAddNewButtonCompleteFieldsWithValidDataSaveAndVerify(articleID, reportID, dvPackID);
	}
	
	@Step
	public void clickOnAddButtonCompleteFieldsWithInvalidDataAndVerify(String intalidArticleID, String invalidReportID, String invaliDvPackID){
		carouselPage().clickOnAddButtonCompleteFieldsWithInvalidDataAndVerify(intalidArticleID, invalidReportID, invaliDvPackID);
	}
	
	@Step
	public void clickOnAddNewButtonCancelAndVerify(){
		carouselPage().clickOnAddNewButtonCancelAndVerify();
	}
	
	@Step
	public void removeOneItemFromCarousel(String dvPackID){
		carouselPage().removeOneItemFromCarousel(dvPackID);
	}
	
	@Step
	public void clickOnEditLinkOfOneItemFromCarousel(int itemNumber){
		carouselPage().clickOnEditLinkOfOneItemFromCarousel(itemNumber);
	}
	
	@Step
	public void removeAllItemsByName(String dvPackID){
		carouselPage().removeAllItemsByName(dvPackID);
	}
	
	@Step
	public void verifyHelpButton(){
		carouselPage().verifyHelpButton();
	}
	
	@Step
	public String getCarouselID(){
		return carouselPage().getCarouselID();
	}
	
	@Step
	public void setCreatedCarouselActive(String carouselID){
		carouselPage().setCreatedCarouselActive(carouselID);
	}
	
	@Step
	public void clickSaveButton(){
		carouselPage().clickSaveButton();
	}
	
	@Step
	public int deselectAnActiveItem(){
	return carouselPage().deselectAnActiveItem();
	}
}

package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class SavedViewsSavedSearchesSavedMncSteps extends AbstractSteps{

	private static final long serialVersionUID = 5074902179220816777L;

	@Step
	public String clickOneSavedViewFromListing(int itemNumber) {
		return savedViewsSavedSearchesSavedMncPage().clickOnOneSavedViewFromList(itemNumber);
	} 
	
	@Step
	public void verifyActionIconsAfterSelectingItems_SV_SMNC(int itemNumber){
		savedViewsSavedSearchesSavedMncPage().verifyActionIcons_SV_SMNC(itemNumber);
	}
	
	@Step
	public void verifyActionIcons_SS(int itemNumber){
		savedViewsSavedSearchesSavedMncPage().verifyActionIcons_SS(itemNumber);
	}

	@Step
	public void createANewSavedSearch(){
		savedViewsSavedSearchesSavedMncPage().createANewSavedSearch();
	}
	
	@Step
	public void clickOnEditIcon(int itemNumber){
		savedViewsSavedSearchesSavedMncPage().clickOnEditItem(itemNumber);
	}
	
	@Step
	public void checkOnOneViewFromList(int itemNumber){
		savedViewsSavedSearchesSavedMncPage().checkOnOneViewFromList(itemNumber);
	}
	
	@Step
	public void moveToFolder(String folderName, int itemNumber) {
		savedViewsSavedSearchesSavedMncPage().moveToFolder(folderName, itemNumber);
	}
	
	@Step
	public String checkOneFolderFromList(int folderNumber){
		return savedViewsSavedSearchesSavedMncPage().checkOneFolderFromList(folderNumber);
	}
	
	@Step
	public void verifyIfOneViewIsChecked(int itemNumber){
		savedViewsSavedSearchesSavedMncPage().verifyIfOneViewIsChecked(itemNumber);
	}
	
	@Step
	public void deleteItemsAndVerify(){
		savedViewsSavedSearchesSavedMncPage().deleteItemsAndVerify();
	}
	
	@StepGroup
	public void verifyAlphabeticalOrder(){
		savedContentPage().changeToAlphabeticalOrder();
		savedViewsSavedSearchesSavedMncPage().verifyAlphabeticalOrder();
	}
	
	@Step
	public void verifySortByDate(){
		savedViewsSavedSearchesSavedMncPage().verifySortByDate();
	}
}

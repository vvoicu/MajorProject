package bmo5.bmo5tests.adm.steps.widgets;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class KeyGlobalViewsSteps extends AbstractAdmSteps {

	private static final long serialVersionUID = 8500176342181970237L;

	@Step
	public void addANewRowWithoutCompletingAnyFieldAndVerify(){
		keyGlobalViewsPage().addANewRowWithoutCompletingAnyFieldAndVerify();
	}
	
	@Step
	public void addANewRowWithInvalidArticleIDAndVerify(String invalidArticleID, String headlineText){
		keyGlobalViewsPage().addANewRowWithInvalidArticleIDAndVerify(invalidArticleID, headlineText);
	}
	
	@Step
	public void addANewRowWithInexistingArticleIDAndVerify(String inexistingArticleID, String headlineText){
		keyGlobalViewsPage().addANewRowWithInexistingArticleIDAndVerify(inexistingArticleID, headlineText);
	}
	
	@Step
	public void addNewRowWithoutCompletingHeadlineAndVerify(String articleID){
		keyGlobalViewsPage().addNewRowWithoutCompletingHeadlineAndVerify(articleID);
	}
	
	@Step
	public void cancelAddingANewRowAndVerify(){
		keyGlobalViewsPage().cancelAddingANewRowAndVerify();
	}
	
	@Step
	public void addANewRowAndVerify(String articleID, String headlineText){
		keyGlobalViewsPage().addANewRowAndVerify(articleID, headlineText);
	}
	
	@Step
	public void clickOnHelpButton(){
		keyGlobalViewsPage().clickOnHelpButton();
	}
	
	@Step
	public void removeOneItemFromListing(String itemName){
		keyGlobalViewsPage().removeOneItemFromListing(itemName);
	}
	
	@Step
	public void clickOnUpdateButtonWithoutCompletingAnyFieldAndVerify(){
		keyGlobalViewsPage().clickOnUpdateButtonWithoutCompletingAnyFieldAndVerify();
	}
	
	@Step
	public void editOneItemFromListing(String itemName, String newName){
		keyGlobalViewsPage().editOneItemFromListing(itemName, newName);
	}
}

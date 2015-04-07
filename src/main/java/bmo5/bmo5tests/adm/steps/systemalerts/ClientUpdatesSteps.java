package bmo5.bmo5tests.adm.steps.systemalerts;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class ClientUpdatesSteps  extends AbstractAdmSteps{

	private static final long serialVersionUID = -7062127794534708823L;

	@StepGroup
	public void createAndVerifyStaticUpdate(String nameTwo, String wordsTwo, String day,String endDay) {
		clientUpdatesPage().verifyAndCreateAStaticUpdate(nameTwo, wordsTwo, day);
		clientUpdatesPage().selectExpiryDate(endDay);
		clientUpdatesPage().tickStaticOption();
		clientUpdatesPage().clickOnSave();
		
	}
	
	@StepGroup
	public void verifyNewUpdatesformAndCreateIt(String name,String words,String day) {
		clientUpdatesPage().verifyAddClientUpdateFormAndAddAlertWithStartDate();
		clientUpdatesPage().selectFirstAlertOptions(name, words, day);
		clientUpdatesPage().clickOnSave();
		
	}
	
	@StepGroup
	public void createAlertWithImageAndPublishDate(String nameThree,String words,String day,String upload) {
		clientUpdatesPage().verifyAndCreateAStaticUpdate(nameThree, words, day);
		clientUpdatesPage().uploadImage(upload);
		clientUpdatesPage().clickOnSave();
		
	}
	@Step
	public void addNewClientUpdate(String breadcrumb) {
	clientUpdatesPage().addNewClientUpdate(breadcrumb);
	}
	
	@Step
	public void saveCLientUpdate() {
		clientUpdatesPage().clickOnSave();
	}

	@Step
	public void createAlertWithPublishDateAndImageUpload(String nameTwo, String wordsTwo, String day) {
		clientUpdatesPage().verifyAndCreateAStaticUpdate(nameTwo, wordsTwo, day);
	}

	
		
	
}


package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class EmailPopUpWindowSteps extends AbstractSteps {

	private static final long serialVersionUID = -129669637435510047L;
	
	@Step
	public void firstEmailTestPreviewArticle(){
		emailPopUpWindowPage().firstEmailTestFromPreviewArticle();
	}
	
	@Step
	public void secondEmailTestPreviewArticle(){
		emailPopUpWindowPage().secondEmailTestFromPreviewArticle();
	}
	
	
	@Step
	public void closeEmailWondow(){
		emailPopUpWindowPage().closeEmailIconPageTitle();
	}
	
	@Step
	public void verifyEmailWindowElements(){
		emailPopUpWindowPage().verifyEmailIconPreviewArticle();
	}
	
	@Step
	public void verifySubjectIsEmptyForEnterprise(){
		emailPopUpWindowPage().verifySubjectIsEmptyForEnterprise();
	}
	
	@Step
	public void submitWithoutCompletingFieldsAndVerify(){
		emailPopUpWindowPage().submitWithoutCompletingAnyField();
	}
	
	@Step
	public void submitWithSpacesInFieldsAndVerify(){
		emailPopUpWindowPage().submitWithSpacesInFields();
	}
	
	@Step
	public void completeFieldsClearAndVerify(){
		emailPopUpWindowPage().completeFieldsAndClear();
	}
	
	@Step
	public void completeFieldsSubmitAndVerify(){
		emailPopUpWindowPage().completeFieldsAndSubmit();
	}
}

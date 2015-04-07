package bmo5.bmo5tests.adm.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class MethodologiesSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -6039878539172499652L;

	@Step
	public void verifyTableColumns(){
		methodologiesPage().verifyTableColumns();
	}
	
	@Step
	public void verifyEditPage(String indexOrDatabase, String indexOrDatabaseName, String methodologicalDetails, String briefOutlines){
		methodologiesPage().verifyEditPage(indexOrDatabase, indexOrDatabaseName, methodologicalDetails, briefOutlines);
	}
	
	@Step
	public void clickOnListViewButtonAndVerify(){
		methodologiesPage().clickOnListViewButtonAndVerify();
	}
	
	@Step
	public void clickOnResetButtonAndVerify(String indexOrDatabase, String indexOrDatabaseName, String methodologicalDetails, String briefOutlines){
		methodologiesPage().clickOnResetButtonAndVerify(indexOrDatabase, indexOrDatabaseName, methodologicalDetails, briefOutlines);
	}
	
	@Step
	public void enterContent(String content){
		methodologiesPage().enterContent(content);
	}
	
	@Step
	public void clickOnUpdateButtonAndVerify(String confirmationMessageUpdate, String indexOrDatabaseName){
		methodologiesPage().clickOnUpdateButtonAndVerify(confirmationMessageUpdate, indexOrDatabaseName);
	}
}

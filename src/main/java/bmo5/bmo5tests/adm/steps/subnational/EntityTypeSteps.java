package bmo5.bmo5tests.adm.steps.subnational;

import java.text.ParseException;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class EntityTypeSteps extends AbstractAdmSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8236271613651814774L;

	@Step
	public void exportAll() {
		entityTypePage().exportAll();
	}

	@Step
	public void verifyExportedContent(String name) {
		entityTypePage().verifyExportedContent(name);	
	}
	
	@Step
	public void clickOnNewEntityType() {
		entityTypePage().clickOnNewEntityType();		
	}
	@Step
	public void verifyLastUpdatedColumn() throws ParseException {
		entityTypePage().verifyLastUpdatedColumn();
	}	
	@Step
	public void typeEntityType(String newType) {
		entityTypePage().typeEntityType(newType);
	}
	@Step
	public void addNewEntityType(String newType) {
		entityTypePage().addNewEntityType(newType);
	}
	@Step
	public void cancelAddingNewEntity(String newType) {
		entityTypePage().cancelAddingNewEntity(newType);
	}
	@Step
	public void verifyErrorMessage(String errorMsg) {
		entityTypePage().verifyErrorMessage(errorMsg);
	}
	@Step
	public int deleteEntityType() {
		return entityTypePage().deleteEntityType();
	}
	@Step
	public void confirmDelete() {
		entityTypePage().confirmDelete();
	}	
	@Step
	public void verifyIsDeleted(int beforeDelete) {
		entityTypePage().verifyIsDeleted(beforeDelete);
	}
	@Step
	public void selectRecordPerPageAndVerify(String records) {
		entityTypePage().selectRecordsPerPageAndVerify(records);
	}
	@Step
	public void searchEntityType(String word) {
		entityTypePage().searchEntityType(word);
	}
}
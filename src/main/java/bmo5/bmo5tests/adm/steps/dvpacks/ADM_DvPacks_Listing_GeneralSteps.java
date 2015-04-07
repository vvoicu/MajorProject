package bmo5.bmo5tests.adm.steps.dvpacks;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class ADM_DvPacks_Listing_GeneralSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -7062127794534708823L;

	@Step
	public void clickOnDvPacksPanel(){
		adm_DvPacks_listingPage().selectManageDVPacks();
	}
	
	@Step
	public void verifyBreadcrumbsDVPacks() {
		adm_DvPacks_listingPage().verifyManageDVPacksPage();
	}

	@Step
	public void verifyColumnName() {
		adm_DvPacks_listingPage().verifyTable();
	}
	
	@Step
	public void verifyNumberofRecordsperPage() {
	adm_DvPacks_listingPage().changeNumberofrecordsperpage();
	}
	
	@Step
	public void verifyPagination() {
	adm_DvPacks_listingPage().pagination();
	}
	
	@Step
	public void orderColumns() {
	adm_DvPacks_listingPage().orderColumn();
	}
	
	@Step
	public void verifyCloneDvPackbutton() {
		adm_DvPacks_listingPage().cloneDVPack();
	}
	
	@Step
	public void verifyTableColumnsTitleOnPage(String dvPackId,String dvPackName,String title, String subtitle,String description,String dateCreated,String lastUpdated,String type,String renderType,String byWhom,String database,String dvPackType,String actions) {
		adm_DvPacks_listingPage().verifyTableColumnsTitleOnPage(dvPackId, dvPackName, title, subtitle, description, dateCreated, lastUpdated, type, renderType, byWhom, database, dvPackType, actions);
	} 
	
	@Step
	public void clickOnEditLink(String rowNumber) {
		adm_DvPacks_listingPage().clickOnEditLink(rowNumber);
	}
	
	@Step
	public void clickOnCloneLink(String rowNumber) {
		adm_DvPacks_listingPage().clickOnCloneLink(rowNumber);
	}
	
	@Step
	public void clickOnDeleteLink(String rowNumber) {
		adm_DvPacks_listingPage().clickOnDeleteLink(rowNumber);
	}
	
	@Step
	public void clickOnHelpButton(String help) {
		adm_DvPacks_listingPage().clickOnHelpButton(help);
	}
	
	@Step
	public void clickOnAddNewDvPackButton(String newButtonText) {
		adm_DvPacks_listingPage().clickOnAddNewDvPackButton(newButtonText);
	}
	
	@Step
	public void checkTableIntoListView(String dvPackId, String name, String title, String type, String renderType, String databaseType, String dvPackType) {
		adm_DvPacks_listingPage().checkTableIntoListView(dvPackId, name, title, type, renderType, databaseType, dvPackType);
	}
}

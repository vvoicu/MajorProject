package bmo5.bmo5tests.tests.adm;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;






import bmo5.bmo5tests.adm.steps.LoginSteps;
import bmo5.bmo5tests.adm.steps.MenuNavigationSteps;
import bmo5.bmo5tests.adm.steps.subnational.BulkUploadLogSteps;
import bmo5.bmo5tests.adm.steps.subnational.EntityTypeSteps;
import bmo5.bmo5tests.adm.steps.widgets.KeyGlobalForecastsSteps;
import bmo5.bmo5tests.adm.steps.widgets.ManageWidgetsSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;
import bmo5.bmo5tests.tools.adm.AdmMenuItems;
import junit.framework.TestCase;

	@Story(Application.Adm.Subnational.class)
	@RunWith(ThucydidesParameterizedRunner.class)
	@UseTestDataFrom(value = Constants.ADM_RESOURCES_PREFIX + "Bmo5_074_4_Adm_EntityTypeCRUD.csv", separator=',')
	
	public class Bmo5_074_4_Adm_EntityTypeCRUD extends TestCase {
		
		@Managed(uniqueSession = true)
		public WebDriver driver;
		
		@ManagedPages(defaultUrl = Constants.ADM_HOST)
		public Pages pages;
		
		@Steps
		public LoginSteps admLoginSteps;
		
		@Steps
		public EntityTypeSteps entityTypeSteps;
	
		@Steps
		public MenuNavigationSteps menuNavigationSteps;
		
		@Steps
		public ManageWidgetsSteps manageWidgetsSteps;
		
		@Steps
		public KeyGlobalForecastsSteps kgfSteps;
		
		@Steps
		public BulkUploadLogSteps bulkUploadLogSteps;
		
		public String username , password, inputType, inputTypeForm, errorMessageForEmptyInput, errorMessageForInvalidData, alreadyExists, newEntityType, updatedColumn, inputNew, 
						newTypeEmptyString, newTypeAlreadyExists, newTypeOk, errorMsgForNull, errorMsgForAlreadyExists, itemsPerPage100, alertMsgOk, listSelector, fileName, lastChildOfBreadcrumb, word ;

		@Test
		public void Test_EntityTypeCRUD() throws Exception, Throwable {
			admLoginSteps.performLogin(username,password);
			driver.manage().window().maximize();
			menuNavigationSteps.selectMenuItem(AdmMenuItems.National);
			menuNavigationSteps.selectMenuItem(AdmMenuItems.EntityTypeMaintenance);
			menuNavigationSteps.verifyBreadCrumb(lastChildOfBreadcrumb);
			kgfSteps.verifyCellIsDisplayed(inputType);
			kgfSteps.addDataClickSaveAndVerifyMessage(inputType, inputTypeForm, "", errorMessageForEmptyInput);
			kgfSteps.addDataClickSaveAndVerifyMessage(inputType, inputTypeForm, alreadyExists, errorMessageForInvalidData);
			entityTypeSteps.addNewEntityType(newTypeEmptyString);
			entityTypeSteps.verifyErrorMessage(errorMsgForNull);
			entityTypeSteps.addNewEntityType(newTypeAlreadyExists);
			entityTypeSteps.verifyErrorMessage(errorMsgForAlreadyExists);		
			entityTypeSteps.addNewEntityType(newTypeOk);
			entityTypeSteps.verifyLastUpdatedColumn();
			entityTypeSteps.selectRecordPerPageAndVerify(itemsPerPage100);
			int beforeDelete = entityTypeSteps.deleteEntityType();
			entityTypeSteps.selectRecordPerPageAndVerify(itemsPerPage100);
			entityTypeSteps.verifyIsDeleted(beforeDelete);
			bulkUploadLogSteps.verifyAscendingDescending(listSelector);
			entityTypeSteps.exportAll();
			bulkUploadLogSteps.saveImageHandleFirst();
			bulkUploadLogSteps.verifyFileName(fileName);
			entityTypeSteps.searchEntityType(word);
		}
	}
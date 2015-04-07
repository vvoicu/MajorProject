package bmo5.bmo5tests.adm.steps.dvpacks;
import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;
public class Adm_Dvpacks_PreviewAndAprove_GeneralSteps extends AbstractAdmSteps {
	private static final long serialVersionUID = 3805567480009003544L;

	@Step
	public void verifyTitleFromPreview(String expectedTitle){
		admDvpacks_PreviewAndAprovePage().verifyTitleFromPreview(expectedTitle);
	}
	
	@Step
	public void verifyNameFromPreview(String expectedName){
		admDvpacks_PreviewAndAprovePage().verifyNameFromPreview(expectedName);
	}
	
	@Step
	public void verifyNumberOfRowsFromTableInPreview(int expectedNumberRows){
		admDvpacks_PreviewAndAprovePage().verifyNumberOfRowsFromTableInPreview(expectedNumberRows);
	}
	
	@Step
	public void verifySubtitleFromPreview(String expectedSubtitle){
		admDvpacks_PreviewAndAprovePage().verifySubtitleFromPreview(expectedSubtitle);
	}
	
	@Step
	public void verifyChartIsDisplayedInPreview(){
		admDvpacks_PreviewAndAprovePage().verifyChartIsDisplayedInPreview();
	}
	
	@Step
	public String getDvpackIDConfirmationPage(String path,int line){
		return admDvpacks_PreviewAndAprovePage().getDvpackIDConfirmationPage(path, line);
	}
	
	@Step
	public void clickOnDvPackListButton(){
		admDvpacks_PreviewAndAprovePage().clickOnDvPackListButton();
	}
}

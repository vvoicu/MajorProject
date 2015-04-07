package bmo5.bmo5tests.bmo.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class BmoGuideSteps extends AbstractSteps{

	private static final long serialVersionUID = 6217661623715045392L;

	@Step
	public void verifyNavigationModalWindow(){
		bmoGuidePage().verifyNavigationModalWindow();
	}
	
	@Step
	public void verifyTabStructureWindow(){
		bmoGuidePage().verifyTabStructureWindow();
	}
	
	@Step
	public void verifyLeftHandNavigation(){
		bmoGuidePage().verifyLeftHandNavigation();
	}
	
	@Step
	public void clickOnNextButtonFromLeftHandNavigationPivotPointAndVerify(){
		bmoGuidePage().clickOnNextButtonFromLeftHandNavigationPivotPointAndVerify();
	}
	
	public void clickOnNextButtonFromLeftHandNavigationDataToolAndVerify(){
		bmoGuidePage().clickOnNextButtonFromLeftHandNavigationDataToolAndVerify();
	}
	
	@Step
	public void clickOnBackButtonFromDownloadAndDisplayDataWindowAndVerify(){
		bmoGuidePage().clickOnBackButtonFromDownloadAndDisplayDataWindowAndVerify();
	}
	
	@Step
	public void removeForNowTheBMOGuideAndVerify(){
		bmoGuidePage().removeForNowTheBMOGuideAndVerify();
	}
	
	@Step
	public void stopBMOGuideAndVerify(){
		bmoGuidePage().stopBMOGuideAndVerify();
	}
}

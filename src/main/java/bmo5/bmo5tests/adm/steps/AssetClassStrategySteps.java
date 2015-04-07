package bmo5.bmo5tests.adm.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class AssetClassStrategySteps extends AbstractAdmSteps{

	private static final long serialVersionUID = -42696827468852041L;

	@Step
	public void clickOnAssetClassStrategy(){
		assetClassStrategyPage().clickOnAssetClassStrategy();
	}
	
	@Step
	public void clickOnChooseFileButton(){
		assetClassStrategyPage().clickOnChooseFileButton();
	}
	
	@Step
	public void uploadFile(String upload){
		assetClassStrategyPage().uploadFile(upload);
	}
	
	@Step
	public void deleteOneItemFromTable(String upload){
		assetClassStrategyPage().deleteOneItemFromTable(upload);
	}
}

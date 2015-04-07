package bmo5.bmo5tests.bmo.steps.homepage;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.bmo.AbstractSteps;

public class KeyGlobalViewsBmoSteps extends AbstractSteps {

	private static final long serialVersionUID = -7533827450770002484L;

	@Step
	public void clickOnSaveButtonOfAnArticleFromListEnterpriseUser(int articleNumber){
		keyGlobalViewsBmoPage().clickOnSaveButtonOfAnArticleFromListEnterpriseUser(articleNumber);
	}
	
	@Step
	public void clickOnPrintButtonOfAnArticleFromListTrialUser(int articleNumber){
		keyGlobalViewsBmoPage().clickOnPrintButtonOfAnArticleFromListTrialUser(articleNumber);
	}
	
	@Step
	public void clickOnDownloadButtonOfAnArticleFromListTrialUser(int articleNumber){
		keyGlobalViewsBmoPage().clickOnDownloadButtonOfAnArticleFromListTrialUser(articleNumber);
	}
	
	@Step
	public void clickOnViewFullReportButtonOfAnArticleFromList(int articleNumber){
		keyGlobalViewsBmoPage().clickOnViewFullReportButtonOfAnArticleFromList(articleNumber);
	}
	
	@Step
	public void clickOnPreviewArticleButtonOfAnArticleFromList(int articleNumber){
		keyGlobalViewsBmoPage().clickOnPreviewArticleButtonOfAnArticleFromList(articleNumber);
	}
	
	@Step
	public void clickOnAnArticleFromList(int articleNumber){
		keyGlobalViewsBmoPage().clickOnAnArticleFromList(articleNumber);
	}
}

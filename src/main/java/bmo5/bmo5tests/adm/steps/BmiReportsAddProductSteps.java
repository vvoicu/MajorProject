package bmo5.bmo5tests.adm.steps;

import net.thucydides.core.annotations.Step;
import bmo5.bmo5tests.tools.adm.AbstractAdmSteps;

public class BmiReportsAddProductSteps extends AbstractAdmSteps{

	private static final long serialVersionUID = 8933945555309145129L;

	@Step
	public void verifyProductCode(String productCode){
		bmiReportsAddProductPage().verifyProductCode(productCode);
	}
	
	@Step
	public void verifyPublicationFrequency(String publicationFrequency){
		bmiReportsAddProductPage().verifyPublicationFrequency(publicationFrequency);
	}
	
	@Step
	public void verifySelectedService(String service){
		bmiReportsAddProductPage().verifySelectedService(service);
	}
	
	@Step
	public void verifySelectedGeography(String geography){
		bmiReportsAddProductPage().verifySelectedGeography(geography);
	}
}

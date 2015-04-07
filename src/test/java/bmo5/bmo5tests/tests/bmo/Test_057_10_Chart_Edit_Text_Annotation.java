package bmo5.bmo5tests.tests.bmo;


import junit.framework.TestCase;
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

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.HomePage.Pillars.DataAndForecasting.DataTool.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_057_10_Chart_Edit_Text_Annotation.csv", separator = ',')


public class Test_057_10_Chart_Edit_Text_Annotation extends TestCase{
	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages(defaultUrl = Constants.BMO_HOST)
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public DataAndForecastingSteps dataAndForecastingSteps;
	
	@Steps
	public DataToolSteps dataToolSteps;
	
	public String username, password, geography, indicator, dateRanges, filePath, annotationType, textSize, rotation, description, newTextSize, newRotation, newDescription,dataTool;
	
	public Integer colorR, colorG, colorB;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setGeography(String geography){
		this.geography = geography;
	}

	public void setIndicator(String indicator){
		this.indicator = indicator;
	}
	
	public void setDateRanges(String dateRanges){
		this.dateRanges = dateRanges;
	}
	
	public void setAnnotationType(String annotationType){
		this.annotationType = annotationType;
	}
	
	public void setTextSize(String textSize){
		this.textSize = textSize;
	}
	
	public void setRotation(String rotation){
		this.rotation = rotation;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setColorR(int colorR){
		this.colorR = colorR;
	}
	
	public void setColorG(int colorG){
		this.colorG = colorG;
	}
	
	public void setColorB(int colorB){
		this.colorB = colorB;
	}
	
	public void setNewTextSize(String newTextSize){
		this.newTextSize = newTextSize;
	}
	
	public void setNewRotation(String newRotation){
		this.newRotation = newRotation;
	}
	
	public void setNewDescription(String newDescription){
		this.newDescription = newDescription;
	}
	
	
	@Test
	public void test_057_10_Chart_Edit_Text_Annotation() {
		loginSteps.performLogin(username, password);
		dataToolSteps.goFullScreen();
		dataAndForecastingSteps.selectDataTool(dataTool);
		dataToolSteps.filterExpandSearchSelectGeography(geography);
		dataToolSteps.filterExpandSearchSelectIndicator(indicator);
		dataToolSteps.clickFilterDisplayDataButton();
		dataToolSteps.editAndVerifyChartTextAnnotation(annotationType,textSize,rotation,description,newTextSize,newRotation,newDescription);
		
	}
}
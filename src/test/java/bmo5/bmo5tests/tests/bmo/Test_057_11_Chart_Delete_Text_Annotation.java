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
import org.openqa.selenium.browserlaunchers.Sleeper;

import bmo5.bmo5tests.bmo.steps.LoginSteps;
import bmo5.bmo5tests.bmo.steps.pillars.DataAndForecastingSteps;
import bmo5.bmo5tests.bmo.steps.DataToolSteps;
import bmo5.bmo5tests.tools.Application;
import bmo5.bmo5tests.tools.Constants;


@Story(Application.HomePage.Pillars.DataAndForecasting.DataTool.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BMO_RESOURCES_PREFIX	+ "Test_057_11_Chart_Delete_Text_Annotation.csv", separator = ',')


public class Test_057_11_Chart_Delete_Text_Annotation extends TestCase{
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
	
	public String username, password, geography, indicator, dateRanges, filePath, annotationTypeText, annotationTypeLine, textSize, rotation, description, lineType,dataTool;
	
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
	
	public void setAnnotationTypeText(String annotationTypeText){
		this.annotationTypeText = annotationTypeText;
	}
	
	public void setAnnotationTypeLine(String annotationTypeLine){
		this.annotationTypeLine = annotationTypeLine;
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
	
	public void setLineType(String lineType){
		this.lineType = lineType;
	}
	
	
	@Test
	public void test_057_11_Chart_Delete_Text_Annotation() {
		loginSteps.performLogin(username, password);
		dataToolSteps.goFullScreen();
		dataAndForecastingSteps.selectDataTool(dataTool);
		dataToolSteps.filterExpandSearchSelectGeography(geography);
		dataToolSteps.filterExpandSearchSelectIndicator(indicator);
//		dataToolSteps.filterExpandSelectDateRanges(dateRanges);
		dataToolSteps.clickFilterDisplayDataButton();
		Sleeper.sleepTight(5000);
		dataToolSteps.deleteAnnotationFromListAndEditWindow(annotationTypeText,annotationTypeLine,textSize,rotation,description,lineType);
		dataToolSteps.deleteLineAnnotationFromListAndEditWindow(annotationTypeLine, lineType);
	}
}
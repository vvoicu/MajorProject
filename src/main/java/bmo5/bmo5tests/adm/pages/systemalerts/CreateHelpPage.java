package bmo5.bmo5tests.adm.pages.systemalerts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;
import bmo5.bmo5tests.tools.adm.SelectEnums.HelpType;
import bmo5.bmo5tests.tools.adm.SelectEnums.StatusSelect;

public class CreateHelpPage extends AbstractAdmPage{


	@FindBy(css = "select#Type")
	private WebElement typeSelect;
	
	@FindBy(id = "Page Name")
	private WebElement pageNameInput;
	
	@FindBy(id = "Page URL")
	private WebElement pagePathInput;
	
	@FindBy(id = "Content_ifr")
	private WebElement contentIframe;
	
	@FindBy(css = "body#tinymce > p")
	private WebElement textAreaInput;
	
	@FindBy(id = "Status")
	private WebElement statusSelect;
	
	@FindBy(css = "div.form-actions button:first-child")
	private WebElement addButton;
	
		
	public void typeSelect(HelpType type){
		element(typeSelect).waitUntilVisible();
		element(typeSelect).selectByVisibleText(type.name());
	}

	public void pageNameInput(String name) {
		element(pageNameInput).waitUntilVisible();
		pageNameInput.sendKeys(name);
		
	}

	public void pagePathInput(String path) {
		element(pagePathInput).waitUntilVisible();
		pagePathInput.sendKeys(path);
		
	}
	
	public void pageContentInput(String content) {
		element(contentIframe).waitUntilVisible();
		getDriver().switchTo().frame(contentIframe);
		
		element(textAreaInput).waitUntilVisible();
		textAreaInput.click();
		textAreaInput.clear();
		textAreaInput.sendKeys(content);
		waitABit(2000);

		getDriver().findElement(By.tagName("body")).click();
		getDriver().findElement(By.tagName("body")).clear();
		getDriver().findElement(By.tagName("body")).sendKeys(content);
		String script = "src\\test\\java\\drivers\\SendText.exe";
		Process p;
		try {
			p = Runtime.getRuntime().exec(script);
			p.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
//		getDriver().findElement(By.tagName("body")).click();
//		getDriver().findElement(By.tagName("body")).clear();
//		getDriver().findElement(By.tagName("body")).sendKeys(content);
//		(JavascriptExecutor)driver.executeScript("tinyMCE.activeEditor.setContent('<h1>Native API text</h1> TinyMCE')");
//		getDriver().execute_script("CKEDITOR.instances.ckeditor.insertHtml('<p>Christchurch</p>')");
//		getDriver().execute_script("tinyMCE.activeEditor.insertContent('<p>Christchurch</p>')");
		waitABit(5000);
//		Assert.assertTrue(textAreaInput.getText().contains(content));
		
		getDriver().switchTo().defaultContent();
	}
	
	public void statusSelect(StatusSelect status){
		element(statusSelect).waitUntilVisible();
		element(statusSelect).selectByVisibleText(status.name());
	}

	public void clickOnAddButton(){
		element(addButton).waitUntilVisible();
		addButton.click();
	}
}

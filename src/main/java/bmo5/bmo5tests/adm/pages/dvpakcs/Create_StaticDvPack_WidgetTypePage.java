package bmo5.bmo5tests.adm.pages.dvpakcs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import bmo5.bmo5tests.tools.adm.AbstractAdmPage;


public class Create_StaticDvPack_WidgetTypePage extends AbstractAdmPage {

	@FindBy(css="div#breadcrumb div:nth-child(2) >  div:nth-child(1) > a:nth-child(1)")
	private WebElement newbutton;
	
	@FindBy(id="name")
	private WebElement dvpackname;
	
	@FindBy(id="title")
	private WebElement dvpacktitle;
	
	@FindBy(id="subtitle")
	private WebElement dvpacksubtitle;
	
	@FindBy(id="description")
	private WebElement dvpackdescription;
	
	@FindBy(id="app_type_widget")
	private WebElement typewidget;
	
	@FindBy (id = "default_view_DynamicChart")
	private WebElement defaultviewchart;
	
	@FindBy(css="button.btn.pull-right")
	private WebElement continuebutton;
	
	@FindBy (css="div#breadcrumb > div:nth-child(1) > span:nth-child(3)")
	private WebElement breadcrumb;
	
	@FindBy (css="div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(4) > div:nth-child(2) > label")
	private WebElement titleinput;
	
	@FindBy (id = "back")
	private WebElement backbutton;
	
	@FindBy(css="button.btn.pull-right")
	private WebElement continuebutton2;
	
	@FindBy (css="div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h3")
	private WebElement charttitle;
	
	@FindBy (css="div#breadcrumb >  div:nth-child(2) > button#continue-w")
	private WebElement continuebutton3;
	
	@FindBy (css="div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)>h3")
	private WebElement chartstitle;
	
	@FindBy (id="continue")
	private WebElement aprovecontinue;
	
	@FindBy (css=" div#content > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > h4")
	private WebElement message;
	
	@FindBy (id="list")
	private WebElement dvpacklist;
	
	@FindBy (css="table#DataTables_Table_0 > thead > tr > th:nth-child(6)")
	private WebElement datecreated;
	
	@FindBy (css="table#DataTables_Table_0 > tbody > tr:nth-child(1) > td:nth-child(2)")
	private WebElement namefromtable;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(2) > label:nth-child(1) > input")
	private WebElement global;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(3) > label:nth-child(2) > input")
	private WebElement africa;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(4) > label:nth-child(2) > input")
	private WebElement asia;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(5) > label:nth-child(2) >  input")
	private WebElement caribbean;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(6) > label:nth-child(2) >  input")
	private WebElement europe;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(7) > label:nth-child(2) >  input")
	private WebElement latinamerica;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(8) > label:nth-child(2) >  input")
	private WebElement middleeast;
	
	@FindBy (css=" li.nav-header > ul:nth-child(2) > li:nth-child(9) > label:nth-child(2) >  input")
	private WebElement northamerica;
	
	@FindBy (css="input.input-block-level")
	private WebElement searchfilter;
	
	@FindBy (css=" li.nav-header > ul:nth-child(3) > li:nth-child(43) > label > div > span > input")
	private WebElement country;
	
	@FindBy (css="li.nav-header > h5 > span.pull-right > i.icon-right-dir")
	private WebElement indicatorSection;
	
	@FindBy (css="li.nav-header > div.expandable-wrapper > ul:nth-child(2) > li.quick-search > input.input-block-level")
	private WebElement indicatorFilter;
	
	@FindBy (css="li.nav-header > div.expandable-wrapper > ul.nav.nav-list")
	private WebElement filterIndicatorSectionExpanded;
	
	@FindBy (css="li.nav-header > div:nth-child(2) > ul:nth-child(2)")
	private WebElement dataRangeSection;
	
	@FindBy (css="button#filter-display-data")
	private WebElement displayDataButton;
	
	@FindBy (css="div.highcharts-container > svg > text:nth-of-type(1) > tspan")
	private WebElement chartTitle;
	
	@FindBy (css="li.nav-header > ul.nav.nav-list")
	private WebElement filterGeographySectionExpanded;
	
	@FindBy (css="ul.nav.nav-list > li.nav-header > ul.nav.nav-list.dropdown-list.show")
	private WebElement filterDateRangesSectionExpanded;
	
	@FindBy (css="div.sidebar.well > ul:nth-child(3) > li.nav-header > h5 > span.pull-right > i.icon-right-dir")
	private WebElement dateranges;
	
	
	public void createDvPackFirstStep(String dvpname, String title, String subtitle, String description, String type, String databasetype) {
		newbutton.click();
//		String searchTitle = String.valueOf(StringUtils.randomNumber(10000));
		dvpackname.sendKeys(dvpname);
		dvpacktitle.sendKeys(title);
		
		dvpackdescription.sendKeys(description);
		Select dvpacktype = new Select(getDriver().findElement(
				By.cssSelector("select#type")));
		dvpacktype.selectByValue(type);
		Select database = new Select(getDriver().findElement(
				By.cssSelector("select#database")));
		database.selectByValue(databasetype);
		typewidget.click();
		defaultviewchart.click();
		dvpacksubtitle.sendKeys(subtitle);
		continuebutton.click();
		
	}
	public void verifyStaticDvPack() {
		Assert.assertTrue("The breadcrumb is not correct", breadcrumb.getText().contains("Create Static DV Pack")); 
 
	}
	
	public void verifyBackbutton(String dvpname, String title, String subtitle, String description, String type, String databasetype) {
		backbutton.click();
		String backdvpackname=getDriver().findElement(By.cssSelector("input#name")).getAttribute("value");
		String backtitle=getDriver().findElement(By.cssSelector("input#title")).getAttribute("value");
		String backsubtitle=getDriver().findElement(By.cssSelector("input#subtitle")).getAttribute("value");
		String backdescription=getDriver().findElement(By.cssSelector("input#description")).getAttribute("value");
		String backdvpacktype=getDriver().findElement(By.cssSelector("select#type")).getAttribute("value");
		String backdatabase=getDriver().findElement(By.cssSelector("select#database")).getAttribute("value");

		if(dvpname.equals(backdvpackname) && title.equals(backtitle) && subtitle.equals(backsubtitle) && databasetype.equals(backdatabase) && type.equals(backdvpacktype)){System.out.println("Back button works");}
		else {
		Assert.assertTrue("Back button does not work.", dvpname.equals(backdvpackname) && title.equals(backtitle) && subtitle.equals(backsubtitle) && databasetype.equals(backdatabase) && type.equals(backdvpacktype));
		}

		if(dvpname.equals(backdvpackname) && title.equals(backtitle) && subtitle.equals(backsubtitle) && description.equals(backdescription) && databasetype.equals(backdatabase) && type.equals(backdvpacktype)){
			System.out.println("Back button works");
			}
		else {
			Assert.assertTrue("Back button does not work.", dvpname.equals(backdvpackname) && title.equals(backtitle) && subtitle.equals(backsubtitle) && databasetype.equals(backdatabase) && type.equals(backdvpacktype));
		}

		continuebutton2.click();
	}
	
	public void selectGeography (String searchGeography) {
		System.out.println("Geography : " + searchGeography );
		if(searchGeography.equals("Global")){ global.click();
		}
		else if(searchGeography.equals("Africa")){ africa.click();
		}
		else if(searchGeography.equals("Asia")){ asia.click();
		}
		else if(searchGeography.equals("Caribbean")){ caribbean.click();
		}
		else if(searchGeography.equals("Europe")){ europe.click();
		}
		else if(searchGeography.equals("Latin America")){ latinamerica.click();
		}
		else if(searchGeography.equals("Middle East")){ middleeast.click();
		}
		else if(searchGeography.equals("North America")){ northamerica.click();
		}
		else{
			
		searchfilter.sendKeys(searchGeography);
		waitABit(3000);
		element(filterGeographySectionExpanded).waitUntilVisible();
		WebElement element = filterGeographySectionExpanded.findElement(By.cssSelector("label[title='"+searchGeography+"'].checkbox"));
		element(element).click();
		}
	}
	
	public void selectIndicator(String indicator) {
		System.out.println("Indicator : " + indicator);
		indicatorSection.click();
		element(filterIndicatorSectionExpanded).waitUntilVisible();
		waitABit(5000);
		indicatorFilter.sendKeys(indicator);
		waitUntilElementDoesntExist(By.cssSelector("div.loading"),30);
		element(filterIndicatorSectionExpanded.findElement(By.cssSelector("label[title='"+indicator+"']"))).click();
	
	}
	
	public void selectDateRanges(String dateRanges) {
		System.out.println("DateRanges : " + dateRanges);
		dateranges.click();
		element(filterDateRangesSectionExpanded).waitUntilVisible();
		waitUntilElementDoesntExist(By.cssSelector("div.loading"),30);
		System.out.println("DateRanges : " + dateRanges);
	
		List<WebElement> allElements = filterDateRangesSectionExpanded
				.findElements(By.cssSelector(" li label "));

		for (WebElement region : allElements) {
			if (region.getText().equals(dateRanges)) {
				region.click();
				break;
			}
		}
	}
	
	public void displayChart(String title) {
		displayDataButton.click();
		Assert.assertTrue("The breadcrumb is not correct", chartTitle.getText().contains(title));
	}

	public void waitUntilElementDoesntExist(By by, int waitSeconds) {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		boolean elementPresent = false;
		for (int i = 0; i < waitSeconds; i++) {
			try {
				waitABit(1000);
				getDriver().findElement(by);
				elementPresent = true;
			} catch (Exception e) {
				getDriver().manage().timeouts()
						.implicitlyWait(30, TimeUnit.SECONDS);
				elementPresent = false;
				break;
			}
		}
		Assert.assertFalse("The element did not disappear after "
				+ waitSeconds + " seconds!", elementPresent);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
}
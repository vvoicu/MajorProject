package bmo5.bmo5tests.bmo.pages.pillarPages;

import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
//import org.openqa.selenium.support.CacheLookup;

import bmo5.bmo5tests.tools.NavigationItems;
import bmo5.bmo5tests.tools.bmo.AbstractPage;

public class StrategicAnalysisAndReportsPage extends AbstractPage {


	@FindBy(css = "div#sar-container > div:first-child > div:first-child > h5 > a")
//	@CacheLookup
	private WebElement firstArticle;
	
	@FindBy(css="div.span5 > div.media-widget:nth-child(3) > div.well > div > span")
//	@CacheLookup
	private WebElement exploreButtonDataPacks;
	
	@FindBy(css="article[class='span12 media-parent-sa'] > div:nth-of-type(2)")
//	@CacheLookup
	private WebElement navigationContainer;
	
	@FindBy(css="div.well > div:nth-of-type(2)")
//	@CacheLookup
	private WebElement navigationContainerPastVersions;
	
	@FindBy(css="div[class='well'] > div:nth-of-type(2) > ul:nth-child(1) > li:nth-child(7) > a")
//	@CacheLookup
	private WebElement lastPageNumberPastVersions;
	
	@FindBy(css = "div[class='pull-right drop-content-toggler'] > div > a > span")
//	@CacheLookup
	private WebElement pastVersionsTogglerNumber;
	
	public void clickFirstArticle() {
		firstArticle.click();
	}
	
	public void clickLatestReportsArticle(int articleNumber) {
		int latestReports = getDriver().findElements(By.cssSelector("div#sar-container > div")).size();
		if (latestReports > 0 && articleNumber <= latestReports) {
			String articleText = getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child('" + articleNumber + "') > div:first-child > h5 > a")).getText();
			getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child('" + articleNumber + "') > div:first-child > h5 > a")).click();
			Assert.assertTrue("Click on Latest Reports article number " + articleNumber + "wasn't successful", getDriver().findElement(By.cssSelector("ul.breadcrumb > li:last-child")).getText().contains(articleText));
		}
	}
	//TODO fix this
//	public void clickCountryReportsArticle(int articleNumber) {
//		int countryReports = getDriver().findElements(By.cssSelector("div.span5 > div.media-widget:nth-child(1) > div.well > a")).size();
//		if (countryReports > 0 && articleNumber <= countryReports) {
//			String articleName = getDriver().findElement(By.cssSelector("div.span5 > div.media-widget:nth-child(1) > div.well > a:nth-of-type(" + articleNumber + ") > span")).getText();
//			getDriver().findElement(By.cssSelector("div.span5 > div.media-widget:nth-child(1) > div.well > a:nth-of-type(" + articleNumber + ") > span")).click();
//			DataToolPage data = new DataToolPage(getDriver());
//			data.saveImageHandle2();
//			FileChecker fileChecker = new FileChecker();
//			System.out.println(fileChecker.convertFileName(articleName));
//			fileChecker.verifyFileIsDownloaded1(fileChecker.convertFileName(articleName));
//		}
//	}
//	
//	public void clickSpecialReportsArticle(int articleNumber) {
//		int specialReports = getDriver().findElements(By.cssSelector("div.span5 > div.media-widget:nth-child(2) > div.well > a")).size();
//		if (specialReports > 0 && articleNumber <= specialReports) {
//			String articleName = getDriver().findElement(By.cssSelector("div.span5 > div.media-widget:nth-child(2) > div.well > a:nth-of-type(" + articleNumber + ") > span")).getText();
//			getDriver().findElement(By.cssSelector("div.span5 > div.media-widget:nth-child(2) > div.well > a:nth-of-type(" + articleNumber + ") > span")).click();
//			DataToolPage data = new DataToolPage(getDriver());
//			data.saveImageHandle2();
//			FileChecker fileChecker = new FileChecker();
//			System.out.println(fileChecker.convertFileName(articleName));
//			fileChecker.verifyFileIsDownloaded1(fileChecker.convertFileName(articleName));
//		}
//	}
	
	public void clickOnExploreButtonDataPacks(){
		exploreButtonDataPacks.click();
	}
	
	public void navigateToItem(NavigationItems goTo) {
//		waitForRenderedElementsToDisappear(By.cssSelector("div#sar-reports-container.loading"));
		element(navigationContainer).waitUntilVisible();
		String hrefPrefix = getDriver().getCurrentUrl();

		List<WebElement> listItems = navigationContainer.findElements(By.cssSelector("li a"));
		WebElement initialState = navigationContainer.findElement(By.cssSelector("li.active a"));
		for (WebElement elementNow : listItems) {
			if (goTo.getCode().contains(initialState.getAttribute("data-page"))) {
				System.out.println("Element is already active");
				break;
			} else if (elementNow.getAttribute("href").contentEquals(hrefPrefix + "#")) {
						String elementClass = elementNow.findElement(By.cssSelector("i")).getAttribute("class");
						if (elementClass.contains(goTo.getCode())) {
							elementNow.click();
							break;
						}
					} 
					else {
						if (goTo.getCode().contains(elementNow.getAttribute("data-page"))) {
							elementNow.click();
							break;
				}	
			}
		}
	}
	
	public void navigateToItemPastVersions(NavigationItems goTo) {
		int totalPastVersions;
		if(getDriver().findElements(By.cssSelector("div[class='pull-right drop-content-toggler'] > div > a > span")).size() == 1){
			totalPastVersions = Integer.valueOf(pastVersionsTogglerNumber.getText());
			System.out.println(totalPastVersions);
			if(totalPastVersions > 5){
			  element(navigationContainerPastVersions).waitUntilVisible();
			  String hrefPrefix = getDriver().getCurrentUrl();
			  List<WebElement> listItems = navigationContainerPastVersions.findElements(By.cssSelector("li a"));
			  WebElement initialState = navigationContainerPastVersions.findElement(By.cssSelector("li.active a"));
			  for (WebElement elementNow : listItems) {
			   if (goTo.getCode().contains(initialState.getAttribute("data-page"))) {
			    System.out.println("Element is already active");
			    break;
			   } else if (elementNow.getAttribute("href").contentEquals(hrefPrefix + "#")) {
			    String elementClass = elementNow.findElement(By.cssSelector("i")).getAttribute("class");
			    if (elementClass.contains(goTo.getCode())) {elementNow.click();
			     break;
			    }
			   } else {
			    if (goTo.getCode().contains(elementNow.getAttribute("data-page"))) {
			     elementNow.click();
			     break;
			    }
			   }
			  }
			  }
			else {
				System.out.println("There are no paginators");
			}
		}
	}
	
	public void verifyNumberOfPastVersions(){
		int totalPastVersions;
		int totalNumberOfItems;
		if(getDriver().findElements(By.cssSelector("div[class='pull-right drop-content-toggler'] > div > a > span")).size() == 1 ){
			totalPastVersions = Integer.valueOf(pastVersionsTogglerNumber.getText());
			System.out.println(totalPastVersions);
			waitForRenderedElementsToBePresent(By.cssSelector("div.well > div:nth-child(1) > div"));
			if(totalPastVersions > 5){
				Integer lastPageNumber;
				lastPageNumber = Integer.valueOf(lastPageNumberPastVersions.getText());
				lastPageNumberPastVersions.click();
				waitABit(3000);
				waitForRenderedElementsToBePresent(By.cssSelector("div.well > div > div "));
				int numberOfItemsPerPage = getDriver().findElements(By.cssSelector("div.well > div[class='media-listing media-list-view-past-versions'] > div ")).size();
				System.out.println("Number of items per last page: " + numberOfItemsPerPage);
				Sleeper.sleepTight(2000);
				totalNumberOfItems = (lastPageNumber - 1) * 5 + numberOfItemsPerPage;
				System.out.println(totalNumberOfItems);
				Assert.assertEquals(totalNumberOfItems, totalPastVersions);
			}
			
			else{
				//totalPastVersions = Integer.valueOf(pastVersionsTogglerNumber.getText());
				//System.out.println(totalPastVersions);
				waitForRenderedElementsToBePresent(By.cssSelector("div.well > div:nth-child(1) > div"));
				int numberOfItemsPerPage = getDriver().findElements(By.cssSelector("div.well > div[class='media-listing media-list-view-past-versions'] > div ")).size();
				System.out.println("Number of items per last page: " + numberOfItemsPerPage);
				Sleeper.sleepTight(2000);
				Assert.assertEquals(numberOfItemsPerPage, totalPastVersions);
			}
		}
		else{
			System.out.println("There is no past version");
		}
	}
	
	//TODO fix this
//	public String clickOnServicesOfOneReportFromList(int reportNumber,int serviceNumber){
//		int numberOfReportsDisplayed, numberOfServices2;
//		Integer numberOfServices, numberOfServices3;
//		numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div#sar-reports-container > div")).size();
//		boolean sameServiceName = false;
//		String servicesTitle="";
//		if (numberOfReportsDisplayed > 0) {
//			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
//				servicesTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > ul > li:nth-child(2) > a")).getText();
//				System.out.println(servicesTitle); 
//				servicesTitle = servicesTitle.replaceAll("[^0-9]", "");
//				if(servicesTitle.isEmpty()){
//					numberOfServices=0;
//				} else {
//					numberOfServices = Integer.valueOf(servicesTitle);
//				}
//				System.out.println(numberOfServices);
//				getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > ul > li:nth-child(2) > a")).click();
//				Sleeper.sleepTight(5000);
//				numberOfServices2 = getDriver().findElements(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li")).size();
//				System.out.println(numberOfServices2);
//				numberOfServices3 = Integer.valueOf(numberOfServices2);
//				System.out.println(numberOfServices3);
//				if(numberOfServices==numberOfServices3){
//					sameServiceName=true;
//				}
//				String serviceTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li:nth-child("+ serviceNumber + ") > a > span")).getText();
//				 getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li:nth-child("+ serviceNumber + ") > a > span")).click();
//				 DataToolPage data = new DataToolPage(getDriver());
//				 data.saveImageHandle2();
//				 FileChecker fileChecker = new FileChecker();
//				System.out.println(fileChecker.convertFileName(serviceTitle));
//				fileChecker.verifyFileIsDownloadedRelatives(fileChecker.convertFileName(serviceTitle));
//			} else {
//				System.out.println("There aren't so many reports displayed so clicking the first report");
//				servicesTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > ul > li:nth-child(2) > a")).getText();
//				servicesTitle = servicesTitle.replaceAll("[^0-9]", "");
//				if(servicesTitle.isEmpty()){
//					numberOfServices=0;
//				} else {
//					numberOfServices = Integer.valueOf(servicesTitle);
//				}
//				getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > ul > li:nth-child(2) > a")).click();
//				numberOfServices2 = getDriver().findElements(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li")).size();
//				numberOfServices3 = Integer.valueOf(numberOfServices);
//				if(numberOfServices==numberOfServices3){
//					sameServiceName=true;
//				}
//				String serviceTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li:nth-child(1) > a > span")).getText();
//				 getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(1) > ul > li:nth-child(1) > a > span")).click();
//				 DataToolPage data = new DataToolPage(getDriver());
//				 data.saveImageHandle2();
//				 FileChecker fileChecker = new FileChecker();
//				System.out.println(fileChecker.convertFileName(serviceTitle));
//				fileChecker.verifyFileIsDownloadedRelatives(fileChecker.convertFileName(serviceTitle));
//			}
//		} else {
//			System.out.println("There aren't any reports!");
//		}
//		Assert.assertTrue(sameServiceName);
//		return servicesTitle;
//	}
	
	//TODO fix this
//	public String clickOnGepraphiesOfOneReportFromList(int reportNumber, int geographyNumber){
//		int numberOfReportsDisplayed, numberOfGepraphies2;
//		Integer numberOfGepraphies, numberOfGepraphies3;
//		numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div#sar-reports-container > div")).size();
//		boolean numberOfItems = false;
//		String geopraphiesTitle="";
//		if (numberOfReportsDisplayed > 0) {
//			System.out.println("First if");
//			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
//				geopraphiesTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > ul > li:nth-child(3) > a")).getText();
//				System.out.println(geopraphiesTitle); 
//				geopraphiesTitle = geopraphiesTitle.replaceAll("[^0-9]", "");
//				System.out.println("Second if");
//				if(geopraphiesTitle.isEmpty()){
//					numberOfGepraphies=0;
//					System.out.println("Third if");
//				} else {
//					numberOfGepraphies = Integer.valueOf(geopraphiesTitle);
//					System.out.println("Third elseif");
//				}
//				System.out.println("numberOfGepraphies: " + numberOfGepraphies);
//				getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > ul > li:nth-child(3) > a")).click();
//				Sleeper.sleepTight(5000);
//				numberOfGepraphies2 = getDriver().findElements(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(2) > ul > li")).size();
//				System.out.println(numberOfGepraphies2);
//				numberOfGepraphies3 = Integer.valueOf(numberOfGepraphies2);
//				System.out.println("numberOfGepraphies3: " + numberOfGepraphies3);
//				if(numberOfGepraphies.equals(numberOfGepraphies3)) {
//					numberOfItems=true;
//					System.out.println("If four");
//				}
//				else{
//					System.out.println("Fail comparison");
//				}
//				String geogeaphyTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(2) > ul > li:nth-child("+ geographyNumber + ") > a > span")).getText();
//				getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(2) > ul > li:nth-child("+ geographyNumber + ") > a > span")).click();
//				DataToolPage data = new DataToolPage(getDriver());
//				data.saveImageHandle2();
//				FileChecker fileChecker = new FileChecker();
//				System.out.println(fileChecker.convertFileName(geogeaphyTitle));
//				fileChecker.verifyFileIsDownloadedRelatives(fileChecker.convertFileName(geogeaphyTitle));
//			} else {
//				System.out.println("Second elseif");
//				System.out.println("There aren't so many reports displayed so clicking the first report");
//				geopraphiesTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > ul > li:nth-child(3) > a")).getText();
//				geopraphiesTitle = geopraphiesTitle.replaceAll("[^0-9]", "");
//				if(geopraphiesTitle.isEmpty()){
//					numberOfGepraphies=0;
//					System.out.println("If 5");
//				} else {
//					System.out.println("ElseIf 5");
//					numberOfGepraphies = Integer.valueOf(geopraphiesTitle);
//				}
//				getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > ul > li:nth-child(3) > a")).click();
//				numberOfGepraphies2 = getDriver().findElements(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:nth-child(2) > ul > li")).size();
//				numberOfGepraphies3 = Integer.valueOf(numberOfGepraphies2);
//				if(numberOfGepraphies==numberOfGepraphies3){
//					System.out.println("If 6");
//					numberOfItems=true;
//				}
//				String geogeaphyTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(2) > ul > li:nth-child("+ geographyNumber + ") > a > span")).getText();
//				 getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(2) > ul > li:nth-child("+ geographyNumber + ") > a > span")).click();
//				 DataToolPage data = new DataToolPage(getDriver());
//				 data.saveImageHandle2();
//				 FileChecker fileChecker = new FileChecker();
//				System.out.println(fileChecker.convertFileName(geogeaphyTitle));
//				fileChecker.verifyFileIsDownloadedRelatives(fileChecker.convertFileName(geogeaphyTitle));
//			}
//		} else {
//			System.out.println("First elseif");
//			System.out.println("There aren't any reports!");
//		}
//		Assert.assertTrue(numberOfItems);
//		return geopraphiesTitle;
//	}
	
	//TODO fix this
//	public String clickOnArchivesOfOneReportFromList(int reportNumber, int archiveNumber){
//		int numberOfReportsDisplayed, numberOfArchives2;
//		Integer numberOfArchives, numberOfArchives3;
//		numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div#sar-reports-container > div")).size();
//		boolean bool = false;
//		String archivesTitle="";
//		if (numberOfReportsDisplayed > 0) {
//			if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
//				archivesTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div:nth-of-type(2) > ul > li:nth-child(2) > a")).getText();
//				System.out.println(archivesTitle); //div#sar-reports-container > div:nth-child(6) > div:nth-child(1) > div:nth-of-type(2) > div > div:nth-child(3) > ul > li:nth-child(1) > a > span
//				archivesTitle = archivesTitle.replaceAll("[^0-9]", "");
//				if(archivesTitle.isEmpty()){
//					numberOfArchives=0;
//				} else {
//					numberOfArchives = Integer.valueOf(archivesTitle);
//				}
//				System.out.println(numberOfArchives);
//				getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > ul > li:nth-child(2) > a")).click();
//				Sleeper.sleepTight(5000);
//				numberOfArchives2 = getDriver().findElements(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(3) > ul > li")).size();
//				System.out.println(numberOfArchives2);
//				numberOfArchives3 = Integer.valueOf(numberOfArchives2);
//				System.out.println(numberOfArchives3);
//				if(numberOfArchives==numberOfArchives3){
//					bool=true;
//				}
//				if(numberOfArchives > 0){
//					if(archiveNumber < numberOfArchives && archiveNumber > 0){
////						String archiveTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(3) > ul > li:nth-child("+ archiveNumber + ") > a > span")).getText();
//						 getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(3) > ul > li:nth-child("+ archiveNumber + ") > a > span")).click();
//						 SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
////						 singleArticle.performDownload();
////						 FileChecker fileChecker = new FileChecker();
////						System.out.println(fileChecker.convertFileName(archiveTitle));
////						fileChecker.verifyFileIsDownloadedRelativesArchives(fileChecker.convertFileName(archiveTitle));
//						 singleArticle.clickOnBackToPreviousPage();
//					}
//					else{
//						System.out.println("There are not so many archives, so click the first one!");
////						String archiveTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(3) > ul > li:nth-child(1) > a > span")).getText();
//						 getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > div.tab-content > div:nth-child(3) > ul > li:nth-child(1) > a > span")).click();
//						 SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
////						 singleArticle.performDownload();
////						 FileChecker fileChecker = new FileChecker();
////						System.out.println(fileChecker.convertFileName(archiveTitle));
////						fileChecker.verifyFileIsDownloadedRelativesArchives(fileChecker.convertFileName(archiveTitle));
//						 singleArticle.clickOnBackToPreviousPage();
//					}
//				}
//				else{
//					System.out.println("There is no archive in the list!");
//				}
//				
//			} else {
//				System.out.println("There aren't so many reports displayed so clicking the first report");
//				archivesTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > ul > li:nth-child(4) > a")).getText();
//				archivesTitle = archivesTitle.replaceAll("[^0-9]", "");
//				if(archivesTitle.isEmpty()){
//					numberOfArchives=0;
//				} else {
//					numberOfArchives = Integer.valueOf(archivesTitle);
//				}
//				getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > ul > li:nth-child(4) > a")).click();
//				numberOfArchives2 = getDriver().findElements(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:nth-child(3) > ul > li")).size();
//				numberOfArchives3 = Integer.valueOf(numberOfArchives2);
//				if(numberOfArchives==numberOfArchives3){
//					bool=true;
//				}
//				if(numberOfArchives > 0){
//					if(archiveNumber < numberOfArchives && archiveNumber > 0){
////						String archiveTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:nth-child(3) > ul > li:nth-child("+ archiveNumber + ") > a > span")).getText();
//						 getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:nth-child(3) > ul > li:nth-child("+ archiveNumber + ") > a > span")).click();
//						 SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
////						 singleArticle.performDownload();
////						 FileChecker fileChecker = new FileChecker();
////						System.out.println(fileChecker.convertFileName(archiveTitle));
////						fileChecker.verifyFileIsDownloadedRelativesArchives(fileChecker.convertFileName(archiveTitle));
//						 singleArticle.clickOnBackToPreviousPage();
//					}
//					else{
////						String archiveTitle = getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:nth-child(3) > ul > li:nth-child(1) > a > span")).getText();
//						 getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > div.tab-content > div:nth-child(3) > ul > li:nth-child(1) > a > span")).click();
//						 SingleArticlePage singleArticle = new SingleArticlePage(getDriver());
////						 singleArticle.performDownload();
////						 FileChecker fileChecker = new FileChecker();
////						System.out.println(fileChecker.convertFileName(archiveTitle));
////						fileChecker.verifyFileIsDownloadedRelativesArchives(fileChecker.convertFileName(archiveTitle));
//						 singleArticle.clickOnBackToPreviousPage();
//					}
//				}
//				else{
//					System.out.println("There is no archive in the list!");
//				}
//			}
//		} else {
//			System.out.println("There aren't any reports!");
//		}
//		Assert.assertTrue(bool);
//		return archivesTitle;
//	}
	
		public void verifyRelatedItems(int reportNumber){
			boolean bool=false;
			int numberOfReportsDisplayed;
			numberOfReportsDisplayed = getDriver().findElements(By.cssSelector("div#sar-reports-container > div")).size();
			if (numberOfReportsDisplayed > 0) {
				if (reportNumber <= numberOfReportsDisplayed && reportNumber > 0) {
					if(getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > ul > li:nth-child(2) > a")).getText().contains("Services") 
							&& ( getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > ul > li:nth-child(3) > a")).getText().contains("Geographies"))
								&& ( getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(" + reportNumber + ") > div:nth-child(1) > div.related > ul > li:nth-child(4) > a")).getText().contains("Archives"))) {
						bool=true;
					}
				}
			}
			else {
					System.out.println("There aren't so many reports displayed so clicking the first report");
					if(getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > ul > li:nth-child(2) > a")).getText().contains("Services") 
							&& (getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > ul > li:nth-child(3) > a")).getText().contains("Geographies"))
								&& (getDriver().findElement(By.cssSelector("div#sar-reports-container > div:nth-child(1) > div:nth-child(1) > div.related > ul > li:nth-child(4) > a")).getText().contains("Archives"))) {
						bool=true;
					}
			}
			Assert.assertTrue(bool);
		}
		
		public int countArticles() {
			return getDriver().findElements(
					By.cssSelector("div.media-listing > div")).size();
		}
		
		//TODO fix this
//		public void clickOnViewFullReportIconArticleFromList(int articleNumber){
//			int numberOfArticlesDisplayed = countArticles();
////			String articleTitle="";
//			if (numberOfArticlesDisplayed > 0) {
//				if (articleNumber <= numberOfArticlesDisplayed
//						&& articleNumber > 0) {
//					if(getDriver().findElements(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(2) i.icon-c-book-open")).size() > 0){
//						elementClick("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(2) i.icon-c-book-open");
////						articleTitle = getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(" + articleNumber + ") > div:nth-child(2) i.icon-c-book-open")).getText();
//						DataToolPage data = new DataToolPage(getDriver());
//						data.saveImageHandle2();
//						FileChecker fileChecker = new FileChecker();
//						fileChecker.verifyViewFullReport();
//					}
//					else{
//						System.out.println("This article does not have View Full Report option");
//					}
//					
//				} else {
//					System.out.println("There aren't so many articles displayed so clicking the first article");
//					if(getDriver().findElements(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(2) i.icon-c-book-open")).size() > 0){
//						elementClick("div#sar-container > div:nth-child(1) > div:nth-child(2) i.icon-c-book-open");
////						articleTitle = getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(1) > div:nth-child(2) i.icon-c-book-open")).getText();
//						DataToolPage data = new DataToolPage(getDriver());
//						data.saveImageHandle2();
//						FileChecker fileChecker = new FileChecker();
//						fileChecker.verifyViewFullReport();
//					}
//					else{
//						System.out.println("This article does not have View Full Report option");
//					}
//				}
//			} else {
//				System.out.println("There aren't any articles");
//			}
//		}
		
		public void verifyFirstCategoryFromFilterAndListWithArticles(String firstCategory){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("li#category-sidebar > div > ul > li:nth-child(3) label")).getAttribute("title").contains(firstCategory));
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(1)  > div.media-body > h5 > a > span")).getText().contains(firstCategory));
		}
		
		public void verifySecondCategoryFromFilterAndListWithArticles(String secondCategory){
			Assert.assertTrue(getDriver().findElement(By.cssSelector("li#category-sidebar > div > ul > li:nth-child(4) label")).getAttribute("title").contains(secondCategory));
			Assert.assertTrue(getDriver().findElement(By.cssSelector("div#sar-container > div:nth-child(2)  > div.media-body > h5 > a > span")).getText().contains(secondCategory));
		}
}

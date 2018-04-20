package by.htp.onlinerautomation.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


import by.htp.onlinerautomation.driver.DriverSingleton;
import by.htp.onlinerautomation.pages.ServicesMainPage;
import by.htp.onlinerautomation.pages.ServicesPerformersPage;


public class Steps {
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void goToPerformersPage(){
		ServicesMainPage servicesPage = new ServicesMainPage(driver);
		servicesPage.openPage();
		servicesPage.goToPerformersPage();
	}

	public String getServiceRegionName() {
		ServicesPerformersPage servicesPerformersPage = new ServicesPerformersPage(driver);
		logger.info("Found service region: " + servicesPerformersPage.getServiceRegionName());
		return servicesPerformersPage.getServiceRegionName();
	}
	
	public int getPerformersNumberByRegion() {
		ServicesPerformersPage servicesPerformersPage = new ServicesPerformersPage(driver);		
		int count = servicesPerformersPage.getPerformersNumberByServiceRegion();
		logger.info("Number of found by region performers: " + count);
		return count;
	}
	
	public int getPerformersNumberByTypeOfService() throws InterruptedException {
		ServicesPerformersPage servicesPerformersPage = new ServicesPerformersPage(driver);		
		int count = servicesPerformersPage.getPerformersNumberByTypeOfService();
		logger.info("Number of found by type of service performers: " + count);
		return count;
	}
	
	public int getPerformersNumber() throws InterruptedException {
		ServicesPerformersPage servicesPerformersPage = new ServicesPerformersPage(driver);		
		int count = servicesPerformersPage.getPerformersList();
		logger.info("Number of found performers: " + count);
		return count;
	}

}
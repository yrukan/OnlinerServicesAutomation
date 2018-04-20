package by.htp.onlinerautomation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.onlinerautomation.steps.Steps;

public class OnlinerAutomationTest {

	private Steps steps;	

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}
		
	@Test(description = "Test 1: Check that performers from Minsk region are found")
	public void checkPerformersNumberByRegion() {
		steps.goToPerformersPage();		
		Assert.assertNotEquals(steps.getPerformersNumberByRegion(), 0, "Performers from SERVICE_REGION are not found");
	}
	
	@Test(description = "Test 2: Check that performers are found by 'Sofrware installation and setup' type of service")
	public void checkPerformersNumberByTypeOfService() throws InterruptedException {
		steps.goToPerformersPage();		
		Assert.assertNotEquals(steps.getPerformersNumberByTypeOfService(), 0, "Performers are not found by 'Sofrware installation and setup' type of service");
	}
	
	@Test(description = "Test 3: Find performers with offers > 3 and responces > 3")
	public void findPerformers() throws InterruptedException {
		steps.goToPerformersPage();		
		Assert.assertNotEquals(steps.getPerformersNumber(), 0, "Performers with offers > 3 and responces > 3 are not found");
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
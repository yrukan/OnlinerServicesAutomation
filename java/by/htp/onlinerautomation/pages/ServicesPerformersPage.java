package by.htp.onlinerautomation.pages;

import org.apache.logging.log4j.Logger;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ServicesPerformersPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://s.onliner.by/profiles";	

	@FindBy(xpath = "//*[@id=\'service-list\']/div[2]/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/ul/li[1]/label/span/span[2]/span")
	private WebElement serviceRegion;
	
	@FindBy(xpath = "//*[@id=\'service-list\']/div[2]/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/ul/li[1]/label/span/span[1]")
	private WebElement checkboxServiceRegion;
	
	@FindBy(xpath = "//*[@id=\'service-list\']/div[2]/div/div/div[2]")
	private WebElement listPerformers;
	
	@FindBy(xpath = "//*[@id=\'service-list\']/div[2]/div/div/div[1]/div[1]/div[2]")
	private WebElement formServices;	
	
	@FindBy(xpath = "//*[@id=\"service-list\"]/div[2]/div/div/div[1]/div[1]/div[2]/div/div[2]/div/div/div[11]/div[1]/a")	                 
	private WebElement dropdownTypeOfService;	
	
	@FindBy(xpath = "//*[@id=\'service-list\']/div[2]/div/div/div[1]/div[1]/div[2]/div/div[2]/div/div/div[11]/div[2]/ul/li[1]/label/span")
	private WebElement checkboxService;	

	public ServicesPerformersPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Performers page is opened");
	}	

	public String getServiceRegionName()
	{
		return serviceRegion.getText();
	}
	
	public int getPerformersNumberByServiceRegion() {
		
		checkboxServiceRegion.click();		
		List<WebElement> performers = listPerformers.findElements(By.className("service-offers__data"));		
		logger.info("Number of found by region performers: " + performers.size());
		return performers.size(); 
	}
	
    public int getPerformersNumberByTypeOfService() throws InterruptedException {
		
    	checkboxServiceRegion.click();    	
    	Select select = new Select(dropdownTypeOfService);    	
    	
    	checkboxService.click();		
		List<WebElement> performers = listPerformers.findElements(By.className("service-offers__data"));		
		logger.info("Number of found by type of service performers: " + performers.size());
		return performers.size(); 
	}
    
   public int getPerformersList() throws InterruptedException {
		
	   //List<WebElement> performers = listPerformers.findElements(By.className("service-offers__list"));
	   List<WebElement> performers = listPerformers.findElements(By.xpath("//*[@id='service-list']/div[2]/div/div/div[2]/search-profiles-list/div"));
	   
	   int count = 0;
	   
	   for(WebElement we: performers) {
		   String[] subStr;
		   String delimeter = " ";
		  
		   String response = we.findElement(By.xpath("//*[@id=\'service-list\']/div[2]/div/div/div[2]/search-profiles-list/div/div/div[1]/search-profiles-item/div/div/div[1]/div/div/div/div/rating-popover/div/a/span[2]")).getText();		   
		   
		   subStr = response.split(delimeter);
		   int response_num = Integer.parseInt(subStr[0]);
		   System.out.println("response_num " + response_num);
		   
		   String offers = we.findElement(By.xpath("//*[@id=\'service-list\']/div[2]/div/div/div[2]/search-profiles-list/div/div/div[1]/search-profiles-item/div/div/div[1]/div/div/div/a[1]")).getText();		   
		   subStr = offers.split(delimeter);		   
		   int offers_num = Integer.parseInt(subStr[1]);
		   System.out.println("offers_num " + offers_num);
		   		   
		   String customer = we.findElement(By.xpath("//*[@id=\"service-list\"]/div[2]/div/div/div[2]/search-profiles-list/div/div/div[1]/search-profiles-item/div/div/div[1]/div/a/span[2]/span")).getText();
		   System.out.println("Customer name = " + customer);
		   
		   
		   if(response_num > 3 && offers_num > 2) {
			   count++;
			   System.out.println(count + ": Customer name = " + customer);
		   }
	   }
	   	logger.info("Number of found by region performers: " + count);
		return count; 
	}
    
    

}

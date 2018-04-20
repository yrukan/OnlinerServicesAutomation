package by.htp.onlinerautomation.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesMainPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://s.onliner.by/";
	private final String PERFORMERS_URL = "https://s.onliner.by/profiles";

	@FindBy(xpath = "//*[@id=\'container\']/div/div[2]/div/div/div/navigation/div/div/div[1]/ul/li[2]/a/span/span")
	private WebElement linkPerformers;	

	public ServicesMainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Services page is opened");
	}

	public void goToPerformersPage()
	{
		linkPerformers.click();
		logger.info("Performers page is opened");
	}	

}

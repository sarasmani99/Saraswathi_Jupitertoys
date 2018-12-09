package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePageSuit 
{	
	protected WebDriver driver;
	
	@Before
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver", System.getenv("webdriver.chrome.driver"));
		driver = new ChromeDriver();
		driver.navigate().to("http://jupiter.cloud.planittesting.com/#/");
		driver.manage().window().maximize();
	}
	
	@After
	public void dispose() {
		driver.quit();
	}


}


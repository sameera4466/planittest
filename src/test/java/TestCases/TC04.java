package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.PageElement;

public class TC04 {
	WebDriver driver;
	private PageElement pageElement;

	@BeforeClass
	public void setup() {

		
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		pageElement = new PageElement(driver);

		driver.get("https://jupiter.cloud.planittesting.com/#/");
		driver.manage().window().maximize();

}
	
	@Test
	public void TC_4() throws Exception {

		
		pageElement.verifyCart();
		
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}

}

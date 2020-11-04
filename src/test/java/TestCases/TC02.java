package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.PageElement;

public class TC02 {
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
	public void TC_2() throws Exception {

		Thread.sleep(3000);
		pageElement.clickContact();
		pageElement.fillContactForm("Sam", "sam@gmail.com", "some msgs");
		pageElement.clickSubmitBtn();
		Thread.sleep(8000);
		pageElement.verifySuccesmsg();

	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
	
}

		

/* No validation error messages set for forename 
		 *  and message fields in the web app. So validating only email error*/

package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.PageElement;

public class TC03 {
	
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
	public void TC_3() throws Exception {

		Thread.sleep(3000);
		pageElement.clickContact();
		pageElement.fillContactForm("123", "123", "random mesg"); 
		
		Thread.sleep(2000);
		pageElement.verifyEmailErr();
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	
}
}
	

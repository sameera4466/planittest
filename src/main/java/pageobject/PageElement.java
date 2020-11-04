package pageobject;


import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageElement {

	/**
	 * @param driver
	 */
	public PageElement(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	By contactLnk = By.linkText("Contact");
	By submitBtn = By.xpath("//a[contains(text(),'Submit')]");
	By forenameTxt = By.xpath("//input[@id='forename']");
	By surname = By.xpath("//input[@id='surname']");
	By emailtxt = By.xpath("//input[@id='email']");
	By telephone = By.xpath("//div[@id='telephone-group']");
	By messagearea = By.xpath("//textarea[@id='message']");

	By forenameerror = By.xpath("//span[@id='forename-err']");
	By messageareaerror = By.xpath("//span[@id='message-err']");
	By emailerror = By.cssSelector("#email-err");
	By successmsg = By.xpath("//strong[contains(text(),'Thanks')]");
	
	By shoplnk = By.linkText("Shop");
	By cowBuylnk = By.xpath("//li[@id='product-6']//p/a");
	By bynnyBuyLnk = By.xpath("//li[@id='product-4']//p/a");
	By cartLnk = By.partialLinkText("Cart");
	By cartItem = By.xpath("//tbody/tr");
	By funnycow = By.xpath("//td[text()= ' Funny Cow']");
	By fluffybunny = By.xpath("//td[text()= ' Fluffy Bunny']");
	By validinputmessage = By.xpath("//strong[text()='We welcome your feedback' ]");

	public void clickContact() throws Exception {
		Thread.sleep(2000);
		driver.findElement(contactLnk).click();
	}

	public void clickSubmitBtn() throws Exception {
		Thread.sleep(2000);
		driver.findElement(submitBtn).click();
	}

	public void fillContactForm(String forename, String email, String msg) throws Exception {
		Thread.sleep(2000);
		driver.findElement(forenameTxt).sendKeys(forename);
		driver.findElement(emailtxt).sendKeys(email);
		driver.findElement(messagearea).sendKeys(msg);


	}

	public void validateErrorOnSubmit() throws Exception {

		clickSubmitBtn();
		Thread.sleep(5000);
		assertTrue("No error dispalyed on empty form submission", driver.findElement(forenameerror).isEnabled());
		
		assertTrue("No error dispalyed on empty form submission", driver.findElement(emailerror).isEnabled());
		
		assertTrue("No error dispalyed on empty form submission", driver.findElement(messageareaerror).isEnabled());
	}

	
	public void verifySuccesmsg() throws Exception {

		Thread.sleep(8000);
		assertTrue("Success msg is not displayed", driver.findElement(successmsg).isDisplayed());
		String successmessage = driver.findElement(successmsg).getText();
		System.out.print(successmessage);
				
	}
	
	public void verifyEmailErr() throws Exception {

		Thread.sleep(2000);
		assertTrue("Email Error is not displayed", driver.findElement(emailerror).isDisplayed());
		String emailvalidationmessage = driver.findElement(emailerror).getText();
		 System.out.println("Email validation error message is.." +emailvalidationmessage);
		
	}
	
	public void verifyCart() throws Exception{
		
		Thread.sleep(2000);
		driver.findElement(shoplnk).click();
		Thread.sleep(2000);
		driver.findElement(cowBuylnk).click();
		driver.findElement(cowBuylnk).click();
		
		Thread.sleep(2000);
		driver.findElement(bynnyBuyLnk).click();
		
		Thread.sleep(2000);
		driver.findElement(cartLnk).click();
		
		Thread.sleep(2000);
		driver.findElement(cartLnk).isDisplayed();
		
		String cartitem = driver.findElement(cartLnk).getText();
		System.out.println("total number of items in" +cartitem);
		
		assertTrue("added item not in cart", driver.findElement(funnycow).isDisplayed());
		assertTrue("added item not in cart", driver.findElement(fluffybunny).isDisplayed());
		
		
		String Item1 = driver.findElement(fluffybunny).getText();
		System.out.println("Item 2 is " +Item1);
		String Item2 = driver.findElement(funnycow).getText();
		System.out.println("Item 1 is " +Item2);
		
		
	}
	
	public void validateNoErrorOnSubmit() throws Exception {

		assertTrue("Valid message is not displayed", driver.findElement(validinputmessage).isDisplayed());
		
		String validmessage = driver.findElement(validinputmessage).getText();
		System.out.println("valid message is..." +validmessage);
		
		 
}	
	

}

package ObjectsRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.CommonFucntions;

public class AmazonCheckOut {

	WebDriver driver;
	CommonFucntions cf = new CommonFucntions();
	ExtentTest test;

	public AmazonCheckOut(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	By cartButton = By.xpath("//a[@id='nav-cart']");
	By checkoutButton = By.xpath("//input[@name='proceedToRetailCheckout']");
	By addressBy = By.xpath("//input[@data-testid='Address_selectShipToThisAddress']");
//    By 
	//h1[normalize-space()='Shopping Cart']

	public void checkOut() throws Exception {

//		String screenShot = CommonFucntions.captureScreenShot();

		driver.findElement(cartButton).click();
		test.log(LogStatus.INFO, "Click cart button", "Amazon");
		test.log(LogStatus.PASS, test.addScreenCapture(CommonFucntions.captureScreenShot()));
		

		driver.findElement(checkoutButton).click();
		test.log(LogStatus.INFO, "Click checkout button", "Amazon");

		driver.findElement(addressBy).click();
		test.log(LogStatus.INFO, "Address Selected", "Amazon");

		test.log(LogStatus.INFO, "Checkout", "Amazon");
		
		Thread.sleep(3000);
		test.log(LogStatus.PASS, test.addScreenCapture(CommonFucntions.captureScreenShot()));
	}

}

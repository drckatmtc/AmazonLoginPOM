package Test_Scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectsRepo.AmazonCheckOut;
import ObjectsRepo.AmazonLogin;
import Utils.CommonFucntions;
import Utils.ConfigFileReader;

public class Test_Scenarios_Amazon {
	WebDriver driver;

	ConfigFileReader config = new ConfigFileReader();
	ExtentTest test;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("******BEFORE SUITE********");
		driver = CommonFucntions.launchBrowser();
		test = CommonFucntions.generateExtentReport();
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("******BEFORE TEST********");
		String url = config.getSpecificUrlProperty("amazonurl");
		driver.get(url);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Launch Url", url);
	}

	@Test(priority = 0)
	public void logInAmazon() throws Exception {
		System.out.println("****** Login to Amazon ********");
		AmazonLogin al = new AmazonLogin(driver, test);
		test.log(LogStatus.INFO, "Login to Amazon", "Amazon");
		al.loginToAmazon();
	}

	@Test(priority = 1)
	public void checkoutInAmazon() throws Exception {
		System.out.println("****** Checkout ********");
		AmazonCheckOut aco = new AmazonCheckOut(driver, test);
		aco.checkOut();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("******AFTER TEST********");
		test.log(LogStatus.INFO, "Close the browser", "Chrome");
		driver.quit();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("******AFTER SUITE********");
		CommonFucntions.closeExtentReport();
	}
}

package ObjectsRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.CommonFucntions;
import Utils.ExcelReader;

public class AmazonLogin {

	WebDriver driver;
	CommonFucntions cf = new CommonFucntions();
	ExtentTest test;

	public AmazonLogin(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	By signInButton = By.xpath("//a[@id='nav-link-accountList']");
	By email = By.xpath("//input[@id='ap_email']");
	By password = By.xpath("//input[@id='ap_password']");
	By account = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");

	public void loginToAmazon() throws Exception {

		String emailStr = ExcelReader.readByColumnName("Credential", "UserName", 1);
		String passwordStr = ExcelReader.readByColumnName("Credential", "Password", 1);

		String title = driver.getTitle();

		if (title.contains("Amazon")) {
			test.log(LogStatus.PASS, "Title contains", "Amazon");
			test.log(LogStatus.PASS, test.addScreenCapture(CommonFucntions.captureScreenShot()));
		} else {
			test.log(LogStatus.FAIL, "Title does not contains", "Amazon");
		}

		driver.findElement(signInButton).click();
		test.log(LogStatus.INFO, "Click sign in button");

		driver.findElement(email).sendKeys(emailStr + Keys.ENTER);
		driver.findElement(password).sendKeys(passwordStr + Keys.ENTER);

		Thread.sleep(3000);

		String accountName = driver.findElement(account).getText();
		System.out.println(accountName);
		if (accountName.equalsIgnoreCase("Hello, sign in")) {
			test.log(LogStatus.FAIL, "Login failed", "Amazon");
			test.log(LogStatus.FAIL, test.addScreenCapture(CommonFucntions.captureScreenShot()));
		} else {
			test.log(LogStatus.PASS, "Login Successfull", "Amazon");
			test.log(LogStatus.PASS, test.addScreenCapture(CommonFucntions.captureScreenShot()));
		}
	}
}

package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import basetest.TestBase;
import pages.AddReview;

import pages.Login;
import report.ScreenshotFailed;
public class Reviews extends TestBase{
	com.relevantcodes.extentreports.ExtentTest logger;
	Logger log=Logger.getLogger(Reviews.class);
	
	
	AddReview review;
	Login init;

	@BeforeTest
	public void homepagesetup() {
	review = PageFactory.initElements(driver, AddReview.class);
		init=PageFactory.initElements(driver, Login.class);
	}

	@BeforeClass
	public void initLogger() {
		logger = extent.startTest(" Reviews Results ");
	}
	
@AfterMethod
public void fail(ITestResult result) throws IOException
{
	if (ITestResult.SUCCESS == result.getStatus()) {
        logger.log(LogStatus.PASS, result.getName() + " test case Passed");
 }

 else if (ITestResult.FAILURE == result.getStatus()) {
        String path = ScreenshotFailed.getScreenshot(driver, result.getName());
        logger.log(LogStatus.FAIL, result.getName() + " test Case Failed ", logger.addScreenCapture(path));
 }

 else if (ITestResult.SKIP == result.getStatus()) {
        logger.log(LogStatus.SKIP, result.getName() + " test case skipped");
 }

}
	
	@Test
	public void Login() throws IOException {
		init.loginClick();
		init.putUsername();
		init.putPassword();
	}
	
	@Test(dependsOnMethods = "Login")
	
	public void Menu() throws IOException, InterruptedException {
		review.getItems();
		Thread.sleep(2000);
	}
	
}

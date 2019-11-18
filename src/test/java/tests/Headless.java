package tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import basetest.HeadLessBase;
import basetest.TestBase;
import pages.AddReview;
import pages.Login;
import pages.Mobiles;
import report.ScreenshotFailed;

public class Headless extends HeadLessBase {
	ExtentTest logger;
	Logger log=Logger.getLogger(Headless.class);
	
	
	AddReview review;
	Login init;
	Mobiles smartwatch;

	@BeforeTest
	public void homepagesetup() {

		review = PageFactory.initElements(driver, AddReview.class);
		init=PageFactory.initElements(driver, Login.class);
		smartwatch = PageFactory.initElements(driver, Mobiles.class);
	}

	@BeforeClass
	public void initLogger() {
		//logger = extent.startTest(" HeadLess Results ");
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
	public void getProfileTest() throws IOException {
		init.loginClick();
		init.putUsername();
		init.putPassword();
	}
	

	@Test(dependsOnMethods = "getProfileTest")

	public void selectMobile() throws InterruptedException
	{
		smartwatch.getMobile();
	
	}
	@Test(dependsOnMethods = "selectMobile")
	
	public void cart() throws InterruptedException {
		Thread.sleep(2000);
		smartwatch.addtoCart();
	
		
	}
	
	

}

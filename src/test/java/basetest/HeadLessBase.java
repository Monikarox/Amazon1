package basetest;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertyFile;

public class HeadLessBase extends ExtentReportsBaseTest {
	protected WebDriver driver;

	@BeforeTest
	@Parameters({ "browser" })
	public void setUpF(@Optional String browser) throws Exception {

		String driverChrome = PropertyFile.getProperty("driverC"), pathChrome = PropertyFile.getProperty("pathC");

		if (browser != null)
			if (browser.equalsIgnoreCase("firefox")) {

				System.setProperty(PropertyFile.getProperty("driverF"), PropertyFile.getProperty("pathF"));
				FirefoxOptions options = new FirefoxOptions();
			//	options.setHeadless(true);
				driver = new FirefoxDriver(options);
				System.out.println(" \n FireFox HeadLess Browser invoked");

			} else if (browser.equalsIgnoreCase("chrome")) {

				System.setProperty(driverChrome, pathChrome);
				ChromeOptions chromeOptions = new ChromeOptions();
			//	chromeOptions.setHeadless(true);
				driver = new ChromeDriver(chromeOptions);
				System.out.println(" \n Chrome HeadLess Browser invoked");

			}
//	else if(browser.equalsIgnoreCase("htmlunit")) {
//		
//		 System.setProperty(PropertyFile.getProperty("driverC"), PropertyFile.getProperty("pathC"));
//		 driver=new HtmlUnitDriver();
//
//	}

			else {
				throw new Exception("Browser not correct");
			}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(PropertyFile.getProperty("url"));
		System.out.println("Title of page is: " + driver.getTitle());

	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws Exception {
		// Sdriver.quit();
	}
}

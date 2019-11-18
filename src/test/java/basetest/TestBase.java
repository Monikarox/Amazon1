package basetest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import com.browserstack.local.Local;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertyFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.ref.PhantomReference;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase extends  ExtentReportsBaseTest {

	public WebDriver driver;


	@BeforeTest
	@Parameters({"browser"}) 
	public void setUp(@ Optional String browser) throws Exception {
		String driverFirefox = PropertyFile.getProperty("driverF"),driverPhantom=PropertyFile.getProperty("driverP") ,driverSafari=PropertyFile.getProperty("driverS"), driverIE=PropertyFile.getProperty("driverI"), driverOpera=PropertyFile.getProperty("driverO"), driverChrome = PropertyFile.getProperty("driverC"), driverEdge=PropertyFile.getProperty("driverE");

		String pathFireFox = PropertyFile.getProperty("pathF"),pathPhantom= PropertyFile.getProperty("pathP"), pathSafari=PropertyFile.getProperty("pathS"),pathIE=PropertyFile.getProperty("pathI"), pathOpera=PropertyFile.getProperty("pathO"),pathChrome = PropertyFile.getProperty("pathC"), pathEdge=PropertyFile.getProperty("pathE");
		
//		System.setProperty(driverChrome, pathChrome);
//		driver = new ChromeDriver();
	
		if(browser!=null)
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		//	System.setProperty(driverFirefox, pathFireFox);
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
		
			System.setProperty(driverChrome, pathChrome);
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
	
			//  System.setProperty(driverEdge, pathEdge); driver = new EdgeDriver();
			 
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
	
		else if(browser.equalsIgnoreCase("opera"))
		{
			  
	        OperaOptions options = new OperaOptions();
	        options.setBinary(PropertyFile.getProperty("OperaBinaryPath"));
	        System.setProperty(driverOpera,pathOpera);
	        driver = new OperaDriver(options);	
		
		}
		
		
		/*
		 * 
		 * else if(browser.equalsIgnoreCase("phantom")){
		 * 
		 * 
		 * DesiredCapabilities caps=new DesiredCapabilities();
		 * caps.setJavascriptEnabled(true); caps.setCapability(driverPhantom,
		 * pathPhantom);
		 * 
		 * driver=new PhantomJSDriver();
		 * 
		 * 
		 * }
		 */
		else if(browser.equalsIgnoreCase("ie")) {
			//	System.setProperty(driverIE, pathIE);
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
		
		else if(browser.equalsIgnoreCase("safari")) {
		//	System.setProperty(driverSafari, pathSafari);
			
			driver = new SafariDriver();
		
		}
		

		
         else 
         {
         
        	 throw new Exception("Browser not correct");
         }
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(PropertyFile.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws Exception {
		// driver.quit();
	}

}

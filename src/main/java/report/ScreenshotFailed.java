package report;

import java.io.File;


import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotFailed {

	private static final Logger logger=Logger.getLogger(ScreenshotFailed.class);
	
	private ScreenshotFailed() throws IllegalAccessException {
		throw new IllegalAccessException("Can't Instantiate this class");
	}

	public static String getScreenshot(WebDriver driver, String testmethodname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "\\reports\\" + testmethodname + System.currentTimeMillis()
				+ ".jpg";

		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			logger.error("Capture Failed " + e.getMessage());
		}

		return path;
	}

}

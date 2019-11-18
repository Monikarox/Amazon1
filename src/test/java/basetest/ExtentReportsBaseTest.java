package basetest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import report.ExtentReportsClass;

public class ExtentReportsBaseTest {

	protected ExtentReportsClass reportobject = ExtentReportsClass.getExtentReportClassInstance();
	protected final ExtentReports extent = reportobject.getExtentReports();


	@Test(enabled = false)
	public void nothingtodo() {

	}

	@AfterSuite
	public void release() {
		extent.flush();
	}

}

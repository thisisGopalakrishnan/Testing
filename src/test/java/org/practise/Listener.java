package org.practise;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.utility_package.Extent_Report;
import org.utility_package.Helper;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Listener extends Helper implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("Test has Started");
		Extent_Report.report();
		Extent_Report.test = Extent_Report.extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Failure On test executing");
		
		Extent_Report.test.fail(result.getThrowable());
		try {
	        WebDriver driver = Helper.driver;

	        // Screenshot folder
	        String path = "C:\\Users\\gopal\\eclipse-workspace\\Testing\\target\\shot\\";
	        new File(path).mkdirs();

	        // Screenshot file name
	        String filePath = path + result.getName() + ".png";

	        // Capture screenshot
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File dest = new File(filePath);
	        org.openqa.selenium.io.FileHandler.copy(src, dest);

	        // Attach to extent report
	        Extent_Report.test.addScreenCaptureFromPath(filePath);
	        
//	        Extent_Report.test.fail(result.getThrowable()); 

	    } catch (Exception e) {
	        System.out.println("Screenshot not captured: " + e.getMessage());
	    }
	}

	
	
	@Override
	public void onFinish(ITestContext context) {
		Extent_Report.extent.flush();
		
	}
}

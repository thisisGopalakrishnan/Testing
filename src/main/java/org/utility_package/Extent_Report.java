package org.utility_package;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Report {
	public static ExtentReports extent;
	public static ExtentTest test ;
	 public static void report() {

	        if (extent == null) {
	            String timestamp = new SimpleDateFormat("yyyy_MM_dd___HHmmssSSS").format(new Date());
	            ExtentSparkReporter report1 = new ExtentSparkReporter("Extent_report_" + timestamp + ".html");

	            report1.config().setReportName("GOPALAKRISHNAN");
	            report1.config().setDocumentTitle("TESTING");

	            extent = new ExtentReports();
	            extent.attachReporter(report1);
	        }
	        }
	 public static void flush() {
	        extent.flush();     // FIX 2
	    }
}

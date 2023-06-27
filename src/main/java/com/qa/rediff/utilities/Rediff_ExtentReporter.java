package com.qa.rediff.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Rediff_ExtentReporter {
	public static ExtentReports generateExtentReport() throws Exception {
    ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Rediff Hybrid Practice Framewrok Results");
		sparkReporter.config().setDocumentTitle("Rediff Hybrid Practice Automation Test");
		sparkReporter.config().setTimeStampFormat("mm/dd/yyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter); 
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\rediff\\propertiesfiles\\configuration.properties");
		prop.load(ip);
		
		extentReport.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReport.setSystemInfo("Project Browser", prop.getProperty("browser1"));
		extentReport.setSystemInfo("Valid Email", prop.getProperty("validUsername"));
		extentReport.setSystemInfo("Valid Password", prop.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReport.setSystemInfo("Operating System Version", System.getProperty("os.version"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReport.setSystemInfo("QA Tester Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("QA Tester Country", System.getProperty("user.country"));
		
		return extentReport;
			
				
		
		
		
	}

}

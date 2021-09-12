package com.computech.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.computech.factory.BrowserFactory;
import com.computech.factory.ConfigProvider;
import com.computech.factory.DataProviderFactory;
import com.computech.utilities.Utility;

@SuppressWarnings("unused")
public class BaseClass {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	String path;
	@BeforeSuite
	public void setUpTestSuite() {
		path = System.getProperty("user.dir")+"\\Reports\\OrangeHRM.html";
		ExtentHtmlReporter htmlReporeter = new ExtentHtmlReporter(path);
		report = new ExtentReports();
		report.attachReporter(htmlReporeter);
		System.out.println("Log:INFO - Report Value : " + report);
		System.out.println("Log:INFO - Report Setup Ready");
	}
	@BeforeClass
	public void setUp() {
//		ConfigProvider config = new ConfigProvider();
//		driver =BrowserFactory.startApplication(config.getStagingURL(), config.getBrowser());
		driver = BrowserFactory.startApplication(DataProviderFactory.getConfig().getStagingURL(), DataProviderFactory.getConfig().getBrowser());
	}
	@AfterMethod
	public void tearDownTest(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("Log:INFO - Test Executed - Test status is passed ");
		}else if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Log:INFO - Test Executed - Test status is failed ");
		}else if(result.getStatus() == ITestResult.SKIP) {
			System.out.println("Log:INFO - Test Executed - Test status is skipped ");
		}
		if(result.getStatus() == ITestResult.SUCCESS) {
			try {
				logger.pass("Test Passed:", MediaEntityBuilder.createScreenCaptureFromPath(Utility.getScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Unable to attach screenshot in report : " + e.getMessage());
			}
		}else if(result.getStatus() == ITestResult.FAILURE) {
			try {
				logger.fail("Test Failed:", MediaEntityBuilder.createScreenCaptureFromPath(Utility.getScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Unable to attach screenshot in report : " + e.getMessage());
			}
		}else if(result.getStatus() == ITestResult.SKIP) {
			logger.skip("Test skipped..");
		}
		report.flush();
	}
	@AfterClass
	public void tearDown() {
		BrowserFactory.closeApplication(driver);
	}
}

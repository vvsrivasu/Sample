package com.computech.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.computech.factory.BrowserFactory;
import com.computech.factory.ConfigProvider;
import com.computech.pages.LoginPage;

public class FirstHRMLoginTest {
	WebDriver driver;
	LoginPage lp;
	
	@BeforeClass
	public void setUp() {
		ConfigProvider config = new ConfigProvider();
		BrowserFactory.startApplication(config.getStagingURL(), config.getBrowser());
	}
	@Test
	public void loginToHRM() {
		lp = PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApplication();
		
	}
	@AfterClass
	public void tearDown() {
		BrowserFactory.closeApplication(driver);
	}

}

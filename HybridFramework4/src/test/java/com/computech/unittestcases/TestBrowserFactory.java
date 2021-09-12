package com.computech.unittestcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.computech.factory.BrowserFactory;
import com.computech.factory.ConfigProvider;

public class TestBrowserFactory {
	WebDriver driver;
	@Test
	public void browserUtility() {
		//BrowserFactory browser = new BrowserFactory();
		ConfigProvider config = new ConfigProvider();
		driver = BrowserFactory.startApplication(config.getStagingURL(), config.getBrowser());
	}

}

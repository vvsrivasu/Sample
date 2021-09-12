package com.computech.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(String appURL, String browserName) {
		WebDriver driver = null;
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("We only support Chrome, IE, FF browser for testing..");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public static void closeApplication(WebDriver driver) {
		driver.quit();
	}
}

package com.computech.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility {
	public static void waitTo(long secs) {
		try {
			Thread.sleep(1000* secs);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	public static String getScreenshot(WebDriver driver) {
		String path = System.getProperty("user.dir")+"/Screenshots/OrangeHRM"+getCurrentTime()+".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			System.out.println("Failed to capture the screenshot..");
		}
		return path;
	}

	public static String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date d = new Date();
		return dateFormat.format(d);
		/*String value = dateFormat.format(d);
		return value;*/
	}
	/*public static void waitForWebElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}*/
	public static WebElement waitForWebElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(element));
		highLightElement(driver, element);
		return ele;
	}
	public static WebElement waitForWebElement(WebDriver driver, WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(element));
		return ele;
	}
	public static WebElement waitForWebElement(WebDriver driver, By byLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(byLocator));
		highLightElement(driver, element);
		return element;
	}
	public static WebElement waitForWebElement(WebDriver driver, By byLocator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(byLocator));
		highLightElement(driver, element);
		return element;
	}
	public static WebElement waitForWebElement(WebDriver driver, By byLocator, int time, WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(webElement));
		highLightElement(driver, element);
		return element;
	}
	public static void highLightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		waitTo(2);
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
	}
	public static void acceptAlert(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}
	public static void dismissAlert(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
	}
	public static void verifyAlertText(WebDriver driver, int time, String expAlertText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		String actAlertText=wait.until(ExpectedConditions.alertIsPresent()).getText();
		Assert.assertEquals(actAlertText, expAlertText);
	}
	public static void verifyTitle(WebDriver driver, int time, String expTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		Assert.assertTrue(wait.until(ExpectedConditions.titleIs(expTitle)));
	}

	public static void verifyContainsTitle(WebDriver driver, String exp_title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertTrue(wait.until(ExpectedConditions.titleContains(exp_title)));
	}

	public static void verifyURL(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertTrue(wait.until(ExpectedConditions.urlToBe(url)));
	}
	public static void handleFrameUsingID() {

	}
	public static void handleFrameUsingName() {

	}
	public static void handleFrameUsingFrameElement() {

	}
}

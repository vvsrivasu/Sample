package com.computech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.computech.utilities.Utility;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By userId = By.id("txtUsername");
	By password = By.name("txtPassword");
	By loginBtn = By.xpath("//input[@value='LOGIN']");
	
	public void typeUserName() {
		driver.findElement(userId).sendKeys("Admin");
	}

	public void typePassword() {
		driver.findElement(password).sendKeys("admin123");
	}

	public void clickOnSignInButton() {
		driver.findElement(loginBtn).click();
	}
	
	public void loginToApplication() {
		driver.findElement(userId).sendKeys("Admin");
		driver.findElement(password).sendKeys("admin123");
		driver.findElement(loginBtn).click();
		//Utility.highLightElement(driver, driver.findElement(userId));
	}
	public void loginToApplication(String uName, String passwd) {
		Utility.highLightElement(driver, driver.findElement(userId));
		driver.findElement(userId).sendKeys(uName);
		Utility.highLightElement(driver, driver.findElement(password));
		driver.findElement(password).sendKeys(passwd);
		Utility.highLightElement(driver, driver.findElement(loginBtn));
		driver.findElement(loginBtn).click();
	}
	
}

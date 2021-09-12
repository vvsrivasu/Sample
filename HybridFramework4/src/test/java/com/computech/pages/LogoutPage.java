package com.computech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By panelLink = By.xpath("//a[@id='welcome']");
	By loutLink = By.xpath("//a[text()='Logout']");
	
	public void logoutFromTheApplication() {
		driver.findElement(panelLink).click();
		driver.findElement(loutLink).click();
	}

}

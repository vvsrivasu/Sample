package com.computech.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.computech.factory.DataProviderFactory;
import com.computech.factory.ExcelReader;
import com.computech.pages.LoginPage;
import com.computech.pages.LogoutPage;
import com.computech.utilities.Utility;

public class LogoutTest extends BaseClass{
	
	ExcelReader excel;
	LoginPage lp;
	LogoutPage loutPage;
	
	@Test
	public void loginToHRM() {
		logger = report.createTest("Orange HRM Login Test");
		logger.info("Browser and Application is up and running..");
		lp = PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApplication(DataProviderFactory.getExcel().getStringData("LoginTest", 0, 0),DataProviderFactory.getExcel().getStringData("LoginTest", 0, 1));
		logger.pass("Login done successfully..");
		Utility.waitTo(3);
		loutPage = PageFactory.initElements(driver, LogoutPage.class);
		loutPage.logoutFromTheApplication();
		logger.pass("Logout done successfully..");
		
	}
}

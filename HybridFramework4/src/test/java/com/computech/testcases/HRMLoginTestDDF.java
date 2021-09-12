package com.computech.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.computech.factory.DataProviderFactory;
import com.computech.factory.ExcelReader;
import com.computech.pages.LoginPage;
import com.computech.pages.LogoutPage;

@SuppressWarnings("unused")
public class HRMLoginTestDDF extends BaseClass{

	ExcelReader excel;
	LoginPage lp;
	LogoutPage loutPage;
	@Test(dataProvider="getData")
	public void login(String uName, String pwd) {
		lp = PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApplication(uName, pwd);
		loutPage = PageFactory.initElements(driver, LogoutPage.class);
		loutPage.logoutFromTheApplication();
	}
	
	@DataProvider
	public static Object[][] getData(){
		String sheetName = "LoginTest";
		int rows = DataProviderFactory.getExcel().rowsCount(sheetName);
		Object[][] data = new Object[rows][2];
		for(int rowNo=0; rowNo < rows; rowNo++)
		{
			data [rowNo][0]= DataProviderFactory.getExcel().getStringData(sheetName, rowNo, 0);
			data [rowNo][1]= DataProviderFactory.getExcel().getStringData(sheetName, rowNo, 1);
			
		}
		return data;
	}
	/*
	@Test
	public void loginToHRM() {
		lp = PageFactory.initElements(driver, LoginPage.class);
//		excel = new ExcelReader();
//		lp.loginToApplication(excel.getStringData("LoginTest", 0, 0), excel.getStringData("LoginTest", 0, 1));
		lp.loginToApplication(DataProviderFactory.getExcel().getStringData("LoginTest", 0, 0),DataProviderFactory.getExcel().getStringData("LoginTest", 0, 1));
		
	}
	*/
}

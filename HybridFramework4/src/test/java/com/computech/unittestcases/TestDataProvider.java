package com.computech.unittestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.computech.factory.ConfigProvider;
import com.computech.factory.ExcelReader;

public class TestDataProvider {
	
	@Test
	public void testExcelLib() {
		ExcelReader excel = new ExcelReader();
		String data = excel.getStringData("TestSheet", 0, 0);
		Assert.assertEquals(data, "TestingExcel");
	}

	@Test
	public void testConfigLib() {
		ConfigProvider config = new ConfigProvider();
		String actData=config.getValue("testConfig");
		String expData = "TestingConfigFile";
		Assert.assertEquals(actData, expData);
	}
}

package com.computech.factory;

public class DataProviderFactory {
	
	public static ExcelReader getExcel() {
		ExcelReader excel = new ExcelReader();
		return excel;
	}
	
	public static ConfigProvider getConfig() {
		ConfigProvider config = new ConfigProvider();
		return config;
	}

}

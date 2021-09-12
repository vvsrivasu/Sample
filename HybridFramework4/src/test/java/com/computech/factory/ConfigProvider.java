package com.computech.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {
	Properties pro;
	FileInputStream fis;
	public ConfigProvider() {
		try {
			fis = new FileInputStream(new File("F:\\Workspace_Weekend\\HybridFramework\\src\\test\\resources\\config\\projectConfig.properties"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	    pro = new Properties();
	    try {
			pro.load(fis);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getValue(String key) {
		/*String val = pro.getProperty(key);
		return val;*/
		return pro.getProperty(key);
	}
	public String getStagingURL() {
		return pro.getProperty("stagingURL");
	}
	public String getBrowser() {
		return pro.getProperty("browser");
	}
	public void loadConfigurationFile() {
		
	}
}

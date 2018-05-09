package com.core;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverWrapper {
	
	WebDriver driver;
	DesiredCapabilities capabilities=null;
	
	public WebDriver initializeDriver(String BrowserType,String DriverPath)
	{
		if(BrowserType.equalsIgnoreCase("Chrome"))
			{
					
					System.setProperty("webdriver.chrome.driver",DriverPath+"\\chromedriver.exe");
					capabilities=DesiredCapabilities.chrome();
					ChromeOptions options=new ChromeOptions();
					options.setBinary(new File("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe"));
					driver=new ChromeDriver(options);
			}
		
		return driver;
	}

}

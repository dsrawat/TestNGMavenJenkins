package com.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.core.Framework;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWrapper {
	
	//static WebDriver driver;
	static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	static DesiredCapabilities capabilities=null;
	
	public static synchronized void initializeDriver(String BrowserType,String DriverPath) throws MalformedURLException
	{
		
		System.out.println("Browser type="+BrowserType);
		if(BrowserType.equalsIgnoreCase("chrome"))
			{
					System.out.println("Browser Chrome inside");
			
					capabilities=DesiredCapabilities.chrome();
					capabilities.setBrowserName("chrome");
					capabilities.setPlatform(Platform.WINDOWS);
					
					ChromeOptions options=new ChromeOptions();
					if(Framework.env.get("Chrome_HeadlessBrowser").equalsIgnoreCase("Yes"))
						options.addArguments("--headless");
					options.setBinary(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"));
					options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
					options.setCapability(CapabilityType.PLATFORM_NAME, "WINDOWS");
					driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options));
					//driver.set(new ChromeDriver(options));
			}
		else if(BrowserType.equalsIgnoreCase("firefox"))
		{
			System.out.println("Browser firefox inside");
			System.setProperty("webdriver.gecko.driver",Framework.env.get("DriverPath")+"\\geckodriver.exe");
			capabilities=DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.WINDOWS);
			FirefoxOptions options=new FirefoxOptions();
			options.setCapability(CapabilityType.BROWSER_NAME, "firefox");
			options.setCapability(CapabilityType.PLATFORM_NAME, "WINDOWS");
			//ChromeOptions options=new ChromeOptions();
			if(Framework.env.get("Firefox_HeadlessBrowser").equalsIgnoreCase("Yes"))
				options.addArguments("--headless");
			options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			//driver=new ChromeDriver(options);
			//driver= new RemoteWebDriver(new URL("http://192.168.1.9:5556/wd/hub"),capabilities);
			driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options));
			System.out.println("after driver set");
			//driver.set(new FirefoxDriver(options));
	}
		
		//return driver;
	}
	
	public static synchronized WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }

}

package com.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import TestNGFramework.TestNGMavenGitJenkins.Test1;

public class BaseClass {
	
	static String var=null;
	static String var1=null;
	
	@BeforeSuite
	public void beforSuite() throws IOException 
	{
		FileInputStream file=null;
		try {
			file = new FileInputStream(new File(System.getProperty("user.dir")+"\\Logs\\Log4j.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PropertyConfigurator.configure(file);
		//Log=Logger.getLogger(Test1.class);
		try {
			Framework.collectEnvironmentData();
			//Log.debug("************************Collecting Envirnonment Data*************************************************");
			var=System.getProperty("user.dir")+"\\"+"Report";
			System.out.println(var);
			File file1 = new File(var);
	        if (!file1.exists()) {
	            if (file1.mkdir()) {
	                System.out.println("Directory is created!");
	            } else {
	                System.out.println("Failed to create directory!");
	            }
			
	        }	
	        
	        
	        var1=var+"\\"+"Report"+java.time.LocalDate.now()+"_"+java.time.LocalTime.now().toString().replace(".","").replace(":","");
			System.out.println(var1);
			Framework.ReportPath=var1;
			File file2 = new File(var1);
	        if (!file2.exists()) {
	            if (file2.mkdir()) {
	                System.out.println("Directory is created!");
	            } else {
	                System.out.println("Failed to create directory!");
	            }
			
	        }	
	        
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reporter.reportStart();
		
		
	}
	
	@AfterSuite
	public void afterSuite()
	{
		
		//Framework.driver.quit();
		//Log.debug("************************Browser Closed*************************************************");
		
		Reporter.ReportEnd();
	}
	
	@BeforeMethod
	public void beforeTest() throws IOException
	{
		Framework.startDriver();
		//framework.driver.quit();
		//Log.debug("************************Browser Closed*************************************************");
	}
	
	@AfterMethod
	public void afterTest() throws IOException
	{
		//framework.startDriver();
		Framework.driver.quit();
		//Log.debug("************************Browser Closed*************************************************");
	}
	
	@BeforeClass
	public void beforeclass()
	{
		
		System.out.println("Name of the class"+this.getClass().getSimpleName());
		//String folderpath=;
		
		System.out.println(System.getProperty("user.dir")+this.getClass().getSimpleName());
		File file = new File(var1+"\\"+this.getClass().getSimpleName());
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }

		
	}
	
	@BeforeMethod
	public void setTestData(Method result) throws IOException
	{
		System.out.println("curent execute Test Method="+result.getName());
		Framework.Data=Framework.readTestData(result.getName());
		Framework.Report.addScenario(result.getName());
		
	}
	
	@AfterMethod
	public void setReportData(Method result) throws IOException
	{
		System.out.println("curent execute Test Method="+result.getName());
		Framework.Data=Framework.readTestData(result.getName());
		Framework.Report.endScenario();
		
	}
	
	

}

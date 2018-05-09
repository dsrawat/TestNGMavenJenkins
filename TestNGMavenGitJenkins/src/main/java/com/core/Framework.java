package com.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;

public class Framework {

	public WebDriverWrapper driverWrapper;
	public static WebDriver driver;
	public static HashMap<String,String> env=new HashMap<String,String>();
	Workbook wb;
	Sheet sh;
	public void startDriver()
	{
		
		driverWrapper=new WebDriverWrapper();
		driver=driverWrapper.initializeDriver(env.get("BrowserType"),env.get("DriverPath"));
	}
	
	public void collectEnvironmentData() throws IOException{
		
		//Load Properties File
				String PathToConfigFile=System.getProperty("user.dir");
				System.out.println(PathToConfigFile);
				Properties prop=new Properties();
				FileInputStream fp=new FileInputStream(new File(PathToConfigFile+"\\Config\\Environment.properties"));
				prop.load(fp);
				
				Enumeration em = prop.keys();
				  while(em.hasMoreElements()){
				  String key = (String)em.nextElement();
				  //String Value=prop.get(key).toString();
				  String Value=prop.getProperty(key);
				  env.put(key, Value);
				  }
				  System.out.println("env="+env);
	}
	
	public  void initializeRepository(String ObjectName) throws IOException
	{
		
		FileInputStream File=new FileInputStream(new File(System.getProperty("user.dir")+"\\ObjectRepository\\ObjectRepository.xls"));
		//Workbook wb=new XSSFWorkbook();
		wb = new  HSSFWorkbook(File);
		sh=wb.getSheetAt(0);
		
	}
	
	public String readObjectRepository(String ObjectName)
	{
		int rowcount=sh.getLastRowNum()+1;
		int colcount=sh.getRow(1).getLastCellNum();
		System.out.println("Row Count="+rowcount);
		System.out.println("Column Count="+colcount);
		String objectname1;
		String ObjectValue="";
		for(int i=1;i<rowcount;i++)
		{
			objectname1=sh.getRow(i).getCell(0).toString();
			if(objectname1.equalsIgnoreCase(ObjectName))
			{
				for(int j=1;j<colcount;j++)
				{
					System.out.println("Column value"+sh.getRow(i).getCell(j));
					ObjectValue=sh.getRow(i).getCell(j).toString();
					if(ObjectValue.isEmpty())
						continue;
					else
					{
						break;
					}
				}
			}
			if(!ObjectValue.isEmpty())
				break;
		}
		
		return ObjectValue;
	}
	
}

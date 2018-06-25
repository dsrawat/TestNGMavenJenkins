package com.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Framework {

	public WebDriverWrapper driverWrapper;
	public static WebDriver driver;
	public static HashMap<String,String> env=new HashMap<String,String>();
	HSSFWorkbook wb;
	HSSFSheet sh;
	public void startDriver() throws IOException
	{
		
		driverWrapper=new WebDriverWrapper();
		driver=driverWrapper.initializeDriver(env.get("BrowserType"),env.get("DriverPath"));
		initializeRepository();
	}
	
	public void collectEnvironmentData() throws IOException{
		
		//Load Properties File
				String PathToConfigFile=System.getProperty("user.dir");
				System.out.println(PathToConfigFile);
				Properties prop=new Properties();
				FileInputStream fp=new FileInputStream(new File(PathToConfigFile+"\\Config\\Environment.prop"));
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
	
	public  void initializeRepository() throws IOException
	{
		
		
		//System.out.println("checking="+sh.getLastRowNum());
		
		
	}
	
	public String readObjectRepository(String ObjectName) throws IOException
	{
		HashMap<String,String> hs=null;
		FileInputStream File=new FileInputStream(new File("C:\\ObjectRepository\\ObjectRepository.xls"));
		//Workbook wb=new XSSFWorkbook();
		System.out.println("repo="+Framework.env.get("RepositoryPath"));
		wb = new  HSSFWorkbook(File);
		sh=wb.getSheetAt(0);
		int rowcount=sh.getLastRowNum();
		int colcount=sh.getRow(1).getLastCellNum();
		System.out.println("Row Count="+rowcount);
		System.out.println("Column Count="+colcount);
		String objectname1;
		String ObjectValue="";
		String PropertyName="";
		String PropertyValue="";
		hs=new HashMap<String,String>();
		for(int i=1;i<=rowcount;i++)
		{
			objectname1=sh.getRow(i).getCell(0).toString();
			if(objectname1.equalsIgnoreCase(ObjectName))
			{
				
				
				
				
				
				for(int j=1;j<colcount;j++)
				{
					
					if(!sh.getRow(i).getCell(j).toString().equals(""))
					{
						PropertyName=sh.getRow(0).getCell(j).toString();
						PropertyValue=sh.getRow(i).getCell(j).toString();
					}
					//hs.put(sh.getRow(0).getCell(j).toString(), );
					
					/*System.out.println("Column value"+sh.getRow(i).getCell(j));
					ObjectValue=sh.getRow(i).getCell(j).toString();
					if(ObjectValue.isEmpty())
						continue;
					else
					{
						break;
					}*/
				}
				
				System.out.println("hashmap value="+hs);
			}
			if(!ObjectValue.isEmpty())
				break;
		}
		
		switch(PropertyName)
        {
            case "ID":
                System.out.println("ID Matched");
                break;
            case "Name":
                System.out.println("two");
                break;
            case "ClassName":
                System.out.println("three");
                break;
            case "PartialLinkText":
                System.out.println("three");
                break;
            case "LinkText":
                System.out.println("three");
                break;
            case "Xpath":
                System.out.println("three");
                break;
            case "CSS":
                System.out.println("three");
                break;
            default:
                System.out.println("no match");
        }
		
		return ObjectValue;
	}
	
}

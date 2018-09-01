package TestNGFramework.TestNGMavenGitJenkins;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.core.BaseClass;
import com.core.Framework;
import com.core.UIOperator;

public class Test1 extends BaseClass{
	//Framework framework=new Framework();
	//Logger Log=null;
	
	
	HashMap<String,String> Data=new HashMap<String,String>();
	
	
	
	@Test
	public void test1() throws IOException
	{
		HashMap<String,String> Data=readTestData(this.getClass().getSimpleName());
		//Log.debug("************************test1 execution Start*********************************************");
		UIOperator.OpenURL();
		UIOperator.enterText("GoogleSearch_TextBox",Data.get("SearchValue"));
		Assert.assertEquals(true, true);
		//Log.debug("************************test1 execution Complete*************************************************");
		
	}
	
	@Test
	public void test2()
	{
		//Log.debug("************************test2 execution Start*********************************************");
		Assert.assertEquals(true, true);
		//Log.debug("************************test2 execution Complete*************************************************");
	}
	
	@BeforeMethod
	public void setTestData(Method result) throws IOException
	{
		System.out.println("curent execute Test Method="+result.getName());
		Data=readTestData(result.getName());
	}
	
	
	
	
	public HashMap<String,String> readTestData(String Heading) throws IOException
	{
		
		HashMap<String,String> hs=null;
		HSSFWorkbook wb;
		HSSFSheet sh;
		FileInputStream File=new FileInputStream(new File(Framework.env.get("TestData")));
		//Workbook wb=new XSSFWorkbook();
		//System.out.println("repo="+Framework.env.get("RepositoryPath"));
		wb = new  HSSFWorkbook(File);
		sh=wb.getSheetAt(0);
		int rowcount=sh.getLastRowNum();
		int colcount=sh.getRow(1).getLastCellNum();
		//System.out.println("Row Count data="+rowcount);
		//System.out.println("Column Count data="+colcount);
		int matchedrow=0;
		for(int k=0;k<rowcount;k++)
		{
			
			 Row row = sh.getRow(k);
			 if(row!=null)
			 {
			 
			 //System.out.println("Cell value="+sh.getRow(k).getCell(0).toString());
				 	if(sh.getRow(k).getCell(0).toString().equalsIgnoreCase(Heading))
				 		{	
				 			matchedrow=k;
				 			break;
				 		}
			 }
			 	
		}
		
		//System.out.println("MatchedRow="+matchedrow);
		colcount=sh.getRow(matchedrow+1).getLastCellNum();
		//System.out.println("cell count="+colcount);
		for(int i=matchedrow+2;i<=(matchedrow+2);i++)
		{
			for(int j=0;j<colcount;j++)
			{
				String Headin=sh.getRow(i-1).getCell(j).toString();
				String Value=sh.getRow(i).getCell(j).toString();
				
				//System.out.println("Heading ="+sh.getRow(i-1).getCell(j).toString());
				//System.out.print(" Value ="+sh.getRow(i).getCell(j).toString());
				
				Data.put(Headin,Value);
			}
		}
		
		System.out.println("Data="+Data);
		
		return Data;
		
		
		
		
	}

}

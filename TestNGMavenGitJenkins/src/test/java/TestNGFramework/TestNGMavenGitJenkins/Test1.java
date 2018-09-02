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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.core.BaseClass;
import com.core.Framework;
import com.core.Reporter;
import com.core.UIOperator;

public class Test1 extends BaseClass{
	//Framework framework=new Framework();
	//Logger Log=null;
	
	
	
	
	
	
	@Test
	public void test1() throws IOException
	{
		//HashMap<String,String> Data=readTestData(this.getClass().getSimpleName());
		//Log.debug("************************test1 execution Start*********************************************");
		UIOperator.OpenURL();
		UIOperator.enterText("GoogleSearch_TextBox",Framework.Data.get("SearchValue"));
		Assert.assertEquals(true, true);
		Framework.Report.addReportStep("Step 1","Description 1","","");
		//Log.debug("************************test1 execution Complete*************************************************");
		Framework.Report.addReportStep("Step 2","Description 2","","");
		Framework.Report.addReportStep("Step 3","Description 3","","");
	}
	
	@Test
	public void test2() throws IOException
	{
		Framework.Report.addReportStep("Step 1","Description 1","","");
		//Log.debug("************************test2 execution Start*********************************************");
		Assert.assertEquals(true, true);
		//Log.debug("************************test2 execution Complete*************************************************");
		Framework.Report.addReportStep("Step 2","Description 2","","");
		Framework.Report.addReportStep("Step 3","Description 3","","");
	}
	
	
	
	
	

}

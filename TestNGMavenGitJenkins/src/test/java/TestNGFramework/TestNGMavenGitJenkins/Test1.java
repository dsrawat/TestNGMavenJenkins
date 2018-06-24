package TestNGFramework.TestNGMavenGitJenkins;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.core.Framework;

public class Test1 {
	Framework framework=new Framework();
	Logger Log=null;
	
	@BeforeTest
	public void beforTest() 
	{
		FileInputStream file=null;
		try {
			file = new FileInputStream(new File(System.getProperty("user.dir")+"\\Logs\\Log4j.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PropertyConfigurator.configure(file);
		Log=Logger.getLogger(Test1.class);
		try {
			framework.collectEnvironmentData();
			Log.debug("************************Collecting Envirnonment Data*************************************************");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		framework.startDriver();
		
	}
	
	@AfterTest
	public void afterTest()
	{
		
		framework.driver.quit();
		Log.debug("************************Browser Closed*************************************************");
	}
	@Test
	public void test1()
	{
		Log.debug("************************test1 execution Start*********************************************");
		Assert.assertEquals(true, true);
		Log.debug("************************test1 execution Complete*************************************************");
		
	}
	
	@Test
	public void test2()
	{
		Log.debug("************************test2 execution Start*********************************************");
		Assert.assertEquals(true, true);
		Log.debug("************************test2 execution Complete*************************************************");
	}

}

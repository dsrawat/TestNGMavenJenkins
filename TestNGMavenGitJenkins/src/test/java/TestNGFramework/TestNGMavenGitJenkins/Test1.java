package TestNGFramework.TestNGMavenGitJenkins;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.core.BaseClass;
import com.core.Framework;
import com.core.UIOperator;

public class Test1 extends BaseClass{
	//Framework framework=new Framework();
	//Logger Log=null;
	
	
	
	
	
	
	@Test
	public void test1() throws IOException
	{
		//Log.debug("************************test1 execution Start*********************************************");
		UIOperator.OpenURL();
		UIOperator.enterText("GoogleSearch_TextBox","Selenium");
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

}

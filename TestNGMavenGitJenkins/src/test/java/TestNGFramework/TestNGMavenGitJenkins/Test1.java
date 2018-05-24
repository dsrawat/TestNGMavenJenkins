package TestNGFramework.TestNGMavenGitJenkins;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.core.Framework;

public class Test1 {
	Framework framework=new Framework();
	@BeforeTest
	public void beforTest() 
	{
		
		
		try {
			framework.collectEnvironmentData();
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
	}
	@Test
	public void test1()
	{
		Assert.assertEquals(true, true);
		
	}
	
	@Test
	public void test2()
	{
		Assert.assertEquals(true, true);
		
	}

}

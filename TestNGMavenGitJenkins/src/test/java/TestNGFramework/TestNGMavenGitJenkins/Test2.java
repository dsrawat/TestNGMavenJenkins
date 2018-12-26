package TestNGFramework.TestNGMavenGitJenkins;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.core.BaseClass;
import com.core.Framework;
import com.core.UIOperator;

public class Test2 extends BaseClass {
	
	Logger Log=Logger.getLogger(Test2.class);
	
	
	
	@Test
	public void test3() throws Exception
	{
		System.out.println("test3 Thread ID= " + Thread.currentThread().getId());
		Log.debug("************************test3 execution Start*********************************************");
		UIOperator.OpenURL();
		//UIOperator.takeSnapShot();
		System.out.println("test3 Thread ID= " + Thread.currentThread().getId());
		Framework.Report.addReportStep("Step 1","Description 1","","");
		UIOperator.enterText("GoogleSearch_TextBox","Selenium");
		System.out.println("test3 Thread ID= " + Thread.currentThread().getId());
		Thread.sleep(5000);
		//UIOperator.takeSnapShot();
		Assert.assertEquals(true, true);
		Framework.Report.addReportStep("Step 2","Description 2","","");
		System.out.println("test3 Thread ID= " + Thread.currentThread().getId());
		//UIOperator.takeSnapShot();
		Log.debug("************************test3 execution Complete*************************************************");
		
	}
	
	@Test
	public void test4() throws Exception
	{
		Log.debug("************************test4 execution Start*********************************************");
		System.out.println("test4 Thread ID= " + Thread.currentThread().getId());
		UIOperator.OpenURL();
		//UIOperator.takeSnapShot();
		System.out.println("test4 Thread ID= " + Thread.currentThread().getId());
	
		Framework.Report.addReportStep("Step 1","Description 1","","");
		System.out.println("test4 Thread ID= " + Thread.currentThread().getId());
		
		Assert.assertEquals(true, true);
		
		Framework.Report.addReportStep("Step 2","Description 2","","");
		System.out.println("test4 Thread ID= " + Thread.currentThread().getId());
		Log.debug("************************test4 execution Complete*************************************************");
	}

}

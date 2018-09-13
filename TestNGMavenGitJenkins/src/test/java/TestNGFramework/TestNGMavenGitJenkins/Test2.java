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
	
	Logger Log=Logger.getLogger(Test1.class);
	
	
	
	@Test
	public void test3() throws Exception
	{
		Log.debug("************************test1 execution Start*********************************************");
		UIOperator.OpenURL();
		UIOperator.takeSnapShot();
		Framework.Report.addReportStep("Step 1","Description 1","","");
		UIOperator.enterText("GoogleSearch_TextBox","Selenium");
		UIOperator.takeSnapShot();
		Assert.assertEquals(true, true);
		Framework.Report.addReportStep("Step 2","Description 2","","");
		UIOperator.takeSnapShot();
		Log.debug("************************test1 execution Complete*************************************************");
		
	}
	
	@Test
	public void test4() throws Exception
	{
		UIOperator.OpenURL();
		UIOperator.takeSnapShot();
		Log.debug("************************test2 execution Start*********************************************");
		Framework.Report.addReportStep("Step 1","Description 1","","");
		
		Assert.assertEquals(true, true);
		Log.debug("************************test2 execution Complete*************************************************");
		Framework.Report.addReportStep("Step 2","Description 2","","");
	}

}

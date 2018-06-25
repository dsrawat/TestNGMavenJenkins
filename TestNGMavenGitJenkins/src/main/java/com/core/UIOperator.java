package com.core;

import java.io.IOException;

public class UIOperator {
	
	
	
	
	public static void OpenURL()
	{
		String URL=Framework.env.get(Framework.env.get("Run_URL"));
		Framework.driver.get(URL);
		Framework.driver.manage().window().maximize();
		
	}
	
	public static void enterText(String OjbectName,String Value) throws IOException
	{
		String Object=new Framework().readObjectRepository(OjbectName);
		
	}

}

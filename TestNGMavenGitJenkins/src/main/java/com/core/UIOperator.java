package com.core;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UIOperator {
	
	
	
	
	public static void OpenURL()
	{
		String URL=Framework.env.get(Framework.env.get("Run_URL"));
		Framework.driver.get(URL);
		Framework.driver.manage().window().maximize();
		
	}
	
	public static void enterText(String OjbectName,String Value) throws IOException
	{
		String values[]=new Framework().readObjectRepository(OjbectName).split("_");
		WebElement ele=add(values);
		ele.sendKeys(Value);
	}
	
	
	public static WebElement add(String values[]) {
		
		WebElement ele=null;
		switch(values[0])
        {
            case "ID":
                System.out.println("ID Matched");
                ele=Framework.driver.findElement(By.id(values[1]));
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
		
		return ele;
	}

}

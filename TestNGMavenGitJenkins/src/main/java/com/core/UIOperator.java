package com.core;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
                ele=Framework.driver.findElement(By.id(values[1]));
                break;
            case "Name":
            	ele=Framework.driver.findElement(By.name(values[1]));
                break;
            case "ClassName":
            	ele=Framework.driver.findElement(By.className(values[1]));
                break;
            case "PartialLinkText":
            	ele=Framework.driver.findElement(By.partialLinkText(values[1]));
                break;
            case "LinkText":
            	ele=Framework.driver.findElement(By.linkText(values[1]));
                break;
            case "Xpath":
            	ele=Framework.driver.findElement(By.xpath(values[1]));
                break;
            case "CSS":
            	ele=Framework.driver.findElement(By.cssSelector(values[1]));
                break;
            default:
                System.out.println("no match");
        }
		
		return ele;
	}
	
	/*public static void takeSnapShot() throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)Framework.driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }*/

}

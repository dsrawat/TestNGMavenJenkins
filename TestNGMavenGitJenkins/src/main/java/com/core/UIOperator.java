package com.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



public class UIOperator {
	
	
	
	
	public static void OpenURL()
	{
		String URL=Framework.env.get(Framework.env.get("Run_URL"));
		Framework.driver.get(URL);
		Framework.driver.manage().window().maximize();
		
	}
	
	public static void enterText(String ObjectName,String Value) throws IOException
	{
		try {
		String values[]=new Framework().readObjectRepository(ObjectName).split("_");
		WebElement ele=add(values);
		ele.sendKeys(Value);
		}
		catch(Exception e)
		{
			
			Framework.Report.addReportStep("Step 5","Description 5","Fail","");
			Framework.Report.addReportStepError("Unable to Enter Text of "+ObjectName);
		}
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
	
	public static void takeSnapShot() throws Exception{
		
		String Screenshotname=Framework.currentMethodName+"-"+java.time.LocalDate.now()+"_"+java.time.LocalTime.now().toString().replace(".","").replace(":","");
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(Framework.driver);
		String FileName=BaseClass.var1+"\\"+Framework.currentClassName+"\\"+Framework.currentMethodName+"\\"+Screenshotname+".JPEG";
	    ImageIO.write(fpScreenshot.getImage(),"JPEG",new File(FileName));
	    
	  
	          
	       
	      
	      
	      
	      InputStream in = new FileInputStream(new File(FileName));
	      BufferedImage bimg = ImageIO.read(in);
	      float width = bimg.getWidth();
	      float height = bimg.getHeight();
	      PDPage page1 = new PDPage(new PDRectangle(width, height));
	      Framework.document.addPage(page1); 
	      PDImageXObject pdImage1 = PDImageXObject.createFromFile(FileName,Framework.document);
	      PDPageContentStream contentStream = new PDPageContentStream(Framework.document, page1);
	      contentStream.drawImage(pdImage1, 0, 0);
	      contentStream.close();
	      in.close();

	      Framework.document.save(BaseClass.var1+"\\"+Framework.currentClassName+"\\"+Framework.currentMethodName+"\\Screens.pdf");
	      //Framework.document.close();
	      
	      
	      
    }

}

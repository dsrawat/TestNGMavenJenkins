package com.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Reporter {
	
	public static void createReport()
	{
	
	
		File file = new File("D:\\MobilePhoneLists.html");
		/*if(file.exists())
		{
			System.out.println("File already exist");
		}
		else
		{*/
				FileWriter fileWriter = null;
				BufferedWriter bufferedWriter = null;
				try 
				{
					fileWriter = new FileWriter(file);
					bufferedWriter = new BufferedWriter(fileWriter);
			
					String htmlPage = "<html><head><style><style>\r\n" + 
							"table {\r\n" + 
							"    font-family: arial, sans-serif;\r\n" + 
							"    border-collapse: collapse;\r\n" + 
							"    width: 100%;\r\n" + 
							"}\r\n" + 
							"\r\n" + 
							"td, th {\r\n" + 
							"    border: 1px solid #dddddd;\r\n" + 
							"    text-align: left;\r\n" + 
							"    padding: 8px;\r\n" + 
							"}\r\n" + 
							"\r\n" + 
							"tr:nth-child(even) {\r\n" + 
							"    background-color: #dddddd;\r\n" + 
							"}</style></head><body><b><table><tbody><tr><th>Scenario Name</th><th>Description</th><th>Screenshot Link</th></tr><tr><td>This is first asdlfkjsldfkjasldfkj asldfkjasdl</td><td>Hello aslkdfl alfdkasdjlfdask asdfoiwero wel;ndsvnlak  lkjlkh</td></tr></tbody></table>" ;
			
					bufferedWriter.write(htmlPage);
			
					bufferedWriter.append("</body></html>");
			
					System.out.println("Html page created");
					bufferedWriter.flush();
					fileWriter.flush();
					bufferedWriter.close();
					fileWriter.close();
		
				} 
				catch (IOException e) 
				{
			// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		//}
		
		
		
	}

}

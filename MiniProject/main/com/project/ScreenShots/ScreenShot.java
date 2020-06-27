package com.project.ScreenShots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	
	static int number = 1;
	public static void capture_ScreenShot(WebDriver driver,String screenName)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		System.out.println("Screenshot "+number+" taken");
		number++;
		try {
			FileHandler.copy(source,new File("./ScreenShots/"+screenName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception occured while taking the screenshot"+e.getMessage());
		}
	}
}

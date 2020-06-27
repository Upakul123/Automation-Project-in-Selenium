
/*********************************CREATING OBJECT REPOSITORY FOR THE FLIGHT DETAILS PAGE*************************************/

package com.project.PageClasses;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.BaseClasses.PageBaseClass;
import com.project.ScreenShots.ScreenShot;



public class FlightDetails extends PageBaseClass{
	public WebDriver driver;
	
	//CONSTRUCTOR FOR ACCESSING THE DRIVER 
	public FlightDetails(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//FINDING ALL THE WEBELEMENTS OF THIS PAGE USING THE LOCATORS 
	@FindBy(xpath = "//span[@class='fb ico11  hpyBlueLt ']")
	public WebElement price;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[position()<=5]")
	public List<WebElement> fiveFlights;
	
	
	
	//METHOD FOR CLICKING THE PRICE FLOW AS WELL AS TAKING SCREENSHOTS WHEREVER NECESSARY
	public void priceClick()
	{
		//IMPLEMENTING EXPLICIT WAIT BEFORE CLICKING ON THE PRICE BUTTON 
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(price));
		price.click();
		ScreenShot.capture_ScreenShot(driver,"DisplayingFlights");
	}
	
	//METHOD FOR DISPLAYING THE LIST OF FLIGHTS AVAILABLE
    public void firstFiveFlightDetails()
	{
    	int flightNumber = 1;
    	for(WebElement fl : fiveFlights)
		{
			String listofFlight = fl.getText();
			if(!listofFlight.isEmpty())
			{
				System.out.println("******************************* flight Number : "+flightNumber+" ***************************************");
				flightNumber++;
				System.out.println(listofFlight);
				System.out.println("\n");
			}
			
		}
		
		
	}

}

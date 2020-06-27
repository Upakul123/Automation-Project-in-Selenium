
/*********************************CREATING OBJECT REPOSITORY FOR THE LANDING PAGE*************************************/
package com.project.PageClasses;


import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.support.PageFactory;










import com.project.BaseClasses.PageBaseClass;
import com.project.ScreenShots.ScreenShot;

public class LandingPage extends PageBaseClass{
	public WebDriver driver;
	public Properties prop;
    
	//CONSTRUCTOR FOR ACCESSING THE DRIVER 
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//FINDING ALL THE WEBELEMENTS OF THIS PAGE USING THE LOCATORS 
	@FindBy(id = "oneway")
	public WebElement oneWay ;
	@FindBy(id = "gosuggest_inputSrc")
	public WebElement From ;
	@FindBy(xpath = "(//li[@id='react-autosuggest-1-suggestion--0'])[1]")
	public WebElement autosuggest1;
	@FindBy(id = "gosuggest_inputDest")
	public WebElement To;
	@FindBy(xpath = "(//li[@id='react-autosuggest-1-suggestion--0'])[1]")
	public WebElement autosuggest2;
	@FindBy(id = "departureCalendar")
	public WebElement Dateicon;
	@FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	public WebElement arrow;
	@FindBy(id = "fare_20200619")
	public WebElement dateofTravel;
	@FindBy(id="gi_search_btn")
	public WebElement search;
	
	
	//METHOD FOR ADDING THE DEPARTURE AND ARRIVAL AS WELL AS TAKING SCREENSHOTS WHEREVER NECESSARY
    public void setDepartureArrival(String Departure,String Arrival)
	{
    	//ACCESSING THE DATAS STORED IN THE CONFIG.PROPERTIES FILE
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "\\test\\PropFile\\config.properties");
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		oneWay.click();
		From.sendKeys(prop.getProperty(Departure));
		autosuggest1.click();
		ScreenShot.capture_ScreenShot(driver,"Adding_From");
		To.sendKeys(prop.getProperty(Arrival));
		autosuggest2.click();
		ScreenShot.capture_ScreenShot(driver,"Adding_To");
		Dateicon.click();
	}
    
  //METHOD FOR ADDING THE DATE OF JOURNEY
    public void setDateofJourney(String date)
    {
    	//ACCESSING THE DATAS STORED IN THE CONFIG.PROPERTIES FILE
    	try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "\\test\\PropFile\\config.properties");
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date expectedDate = dateFormat.parse(prop.getProperty(date));

			String day = new SimpleDateFormat("dd").format(expectedDate);
			String month = new SimpleDateFormat("MMMM").format(expectedDate);
			String year = new SimpleDateFormat("yyyy").format(expectedDate);
            String expectedMonthYear = month + " " + year;
            
            while (true) 
            {
				String displayDate = driver.findElement(By.className("DayPicker-Caption")).getText();

				if (expectedMonthYear.equals(displayDate))
				{
					driver.findElement(By.xpath("//div[contains(text(),"+day+")]")).click();
					break;
				} 
				else if (expectedDate.compareTo(currentDate) > 0) {
					driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				} else {
					driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--prev']")).click();
				}

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
    
  //METHOD FOR CLICKING THE SEARCH BUTTON AS WELL AS TAKING SCREENSHOTS WHEREVER NECESSARY
    public FlightDetails searchFlights()
    {
    	ScreenShot.capture_ScreenShot(driver,"Adding_Date");
		search.click();
		return PageFactory.initElements(driver,FlightDetails.class);
		
	}
	

}

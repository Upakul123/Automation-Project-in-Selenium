
/*********************************CREATING TEST CLASS FOR THE FLIGHT TEST*************************************/
package com.project.TestClasses;





import org.testng.annotations.Test;

import com.project.BaseClasses.PageBaseClass;
import com.project.PageClasses.FlightDetails;
import com.project.PageClasses.LandingPage;

public class FlightTest extends PageBaseClass{

	LandingPage landingPage;
    FlightDetails flightDetails;
	
	//METHOD FOR RUNNING THE FLIGHT SEARCH TEST
	@Test
	public void FlightSearch1()
	{
		PageBaseClass pg = new PageBaseClass();
		pg.invokeBrowser("browserName");
		landingPage = pg.openApplication("websiteURLKey");
		landingPage.setDepartureArrival("Departure","Arrival");
		landingPage.setDateofJourney("date");
		flightDetails = landingPage.searchFlights();
	    flightDetails.priceClick();
		flightDetails.firstFiveFlightDetails();
		pg.quitBrowser();
		
	}
	
	
	

}

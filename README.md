# Automation-Project-in-Selenium
PROJECT DONE BY : UPAKUL BORA

PROJECT TOPIC :

To get the details of 5 Flights in descending order of their price from Delhi to your Hometown for next Friday.

ASSUMPTIONS :

1) According to the project title it should display the flight details for the coming Friday but due to the current pandemic
   there are no flights available in this date so i have displayed the flight details for 4th October,2020.However the date 
   is dynamic so user can get the flight details for any date.
2) The From City was specified in the question as 'Delhi' and To City was told to be taken as 'your hometown' so it was given
   input as'Dibrugarh'.Also from and to are also dynamic and user can put this details as per his/her wish.
3) Drivers and Resources are added in project for reference.

PROCEDURE :

1) This project is created using POM Framework concept.
2) It consists of a PageBaseClass where all the basic functions such as invoke browser method,opening application method
   and quitting browser method are attached.
3) The LandingPage Class and FlightDetails Class are two classes for two different pages in the website which consists of 
   the related actions that is required to be done that page.
4) In LandingPage Class there are three methods : one for setting the From and To cities, another for Date and last one for
   clicking the search button. 
5) In FlightDetails Class there are two methods : one for setting the Price from high to low and another for displaying the 
   list of five flights in the console.
6) A ScreenShot class is used to take the screen shots wherever it is required.
7) In the FlightTest Class using TestNg annotation @Test the test for searching flights is run and the user will be able .
8) The XML file is also used to run the tests.
9) The config.properties file is used to send the data to the tests such as browserName,websiteURL,Departure,Arrival,date.

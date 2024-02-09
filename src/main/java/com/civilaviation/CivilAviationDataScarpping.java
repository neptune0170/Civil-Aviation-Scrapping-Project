package com.civilaviation;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CivilAviationDataScarpping {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PS42\\Desktop\\Scraping Project\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the website
            driver.get("https://www.civilaviation.gov.in/");

            // Get the HTML content of the page
            String htmlContent = driver.getPageSource();

            // Save HTML content to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Temporary.html"))) {
                writer.write(htmlContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("HTML content saved to Temporary.html");

            // Extract data from the HTML content
            WebElement dateElement = driver.findElement(By.cssSelector(".date-widget"));
            String Date = dateElement.getText().replace("On ", "");

            WebElement departingFlightsElement = driver.findElement(By.xpath("//div[contains(text(),'Departing flights')]/following-sibling::div"));
            String Dom_Departing_Flights = departingFlightsElement.getText().replaceAll(",", "");

            WebElement departingPaxElement = driver.findElement(By.xpath("//div[contains(text(),'Departing Pax')]/following-sibling::div"));
            String Dom_Departing_Pax = departingPaxElement.getText().replaceAll(",", "");

            WebElement arrivingFlightsElement = driver.findElement(By.xpath("//div[contains(text(),'Arriving flights')]/following-sibling::div"));
            String Dom_Arriving_Flights = arrivingFlightsElement.getText().replaceAll(",", "");

            WebElement arrivingPaxElement = driver.findElement(By.xpath("//div[contains(text(),'Arriving Pax')]/following-sibling::div"));
            String Dom_Arriving_Pax = arrivingPaxElement.getText().replaceAll(",", "");

            WebElement aircraftMovementsElement = driver.findElement(By.xpath("//div[contains(text(),'Aircraft movements')]/following-sibling::div"));
            String Dom_Aircraft_Movements = aircraftMovementsElement.getText().replaceAll(",", "");

            WebElement airportFootfallsElement = driver.findElement(By.xpath("//div[contains(text(),'Airport footfalls')]/following-sibling::div"));
            String Dom_Airport_Footfalls = airportFootfallsElement.getText().replaceAll(",", "");

            // Use the extracted data as needed
            System.out.println("Date: " + Date);
            System.out.println("Departing Flights: " + Dom_Departing_Flights);
            System.out.println("Departing Pax: " + Dom_Departing_Pax);
            System.out.println("Arriving Flights: " + Dom_Arriving_Flights);
            System.out.println("Arriving Pax: " + Dom_Arriving_Pax);
            System.out.println("Aircraft Movements: " + Dom_Aircraft_Movements);
            System.out.println("Airport Footfalls: " + Dom_Airport_Footfalls);

               // Extract data from the HTML content (International Traffic)
               WebElement intDepartingFlightsElement = driver.findElement(By.xpath("//h2[contains(@class,'international-traffic')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(text(),'Departing flights')]/following-sibling::div"));
               String Int_Departing_Flights = intDepartingFlightsElement.getText().replaceAll(",", "");
   
               WebElement intDepartingPaxElement = driver.findElement(By.xpath("//h2[contains(@class,'international-traffic')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(text(),'Departing Pax')]/following-sibling::div"));
               String Int_Departing_Pax = intDepartingPaxElement.getText().replaceAll(",", "");
   
               WebElement intArrivingFlightsElement = driver.findElement(By.xpath("//h2[contains(@class,'international-traffic')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(text(),'Arriving flights')]/following-sibling::div"));
               String Int_Arriving_Flights = intArrivingFlightsElement.getText().replaceAll(",", "");
   
               WebElement intArrivingPaxElement = driver.findElement(By.xpath("//h2[contains(@class,'international-traffic')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(text(),'Arriving Pax')]/following-sibling::div"));
               String Int_Arriving_Pax = intArrivingPaxElement.getText().replaceAll(",", "");
   
               WebElement intAircraftMovementsElement = driver.findElement(By.xpath("//h2[contains(@class,'international-traffic')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(text(),'Aircraft movements')]/following-sibling::div"));
               String Int_Aircraft_Movements = intAircraftMovementsElement.getText().replaceAll(",", "");
   
               WebElement intAirportFootfallsElement = driver.findElement(By.xpath("//h2[contains(@class,'international-traffic')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(text(),'Airport footfalls')]/following-sibling::div"));
               String Int_Airport_Footfalls = intAirportFootfallsElement.getText().replaceAll(",", "");
   
               // Use the extracted data as needed
               System.out.println("International Departing Flights: " + Int_Departing_Flights);
               System.out.println("International Departing Pax: " + Int_Departing_Pax);
               System.out.println("International Arriving Flights: " + Int_Arriving_Flights);
               System.out.println("International Arriving Pax: " + Int_Arriving_Pax);
               System.out.println("International Aircraft Movements: " + Int_Aircraft_Movements);
               System.out.println("International Airport Footfalls: " + Int_Airport_Footfalls);
               

               //OTP 
               WebElement onTimePerformanceElement = driver.findElement(By.xpath("//h2[contains(@class,'on-time-performance')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'IndiGo')]/following-sibling::div"));
               String OTP_IndiGo = onTimePerformanceElement.getText();
   
               WebElement airIndiaElement = driver.findElement(By.xpath("//h2[contains(@class,'on-time-performance')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Air India')]/following-sibling::div"));
               String OTP_AirIndia = airIndiaElement.getText();
   
               WebElement spiceJetElement = driver.findElement(By.xpath("//h2[contains(@class,'on-time-performance')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'SpiceJet')]/following-sibling::div"));
               String OTP_SpiceJet = spiceJetElement.getText();
   
               WebElement vistaraElement = driver.findElement(By.xpath("//h2[contains(@class,'on-time-performance')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Vistara')]/following-sibling::div"));
               String OTP_Vistara = vistaraElement.getText();
   
               WebElement goFirstElement = driver.findElement(By.xpath("//h2[contains(@class,'on-time-performance')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Go First')]/following-sibling::div"));
               String OTP_GoFirst = goFirstElement.getText();
   
               WebElement akasaAirElement = driver.findElement(By.xpath("//h2[contains(@class,'on-time-performance')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'AIX Connect')]/following-sibling::div"));
               String OTP_AIXConnect = akasaAirElement.getText();
   
               WebElement aixConnectElement = driver.findElement(By.xpath("//h2[contains(@class,'on-time-performance')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'AKASA AIR')]/following-sibling::div"));
               String OTP_AkasaAir = aixConnectElement.getText();
   
               // Use the extracted data as needed
               System.out.println("IndiGo OTP: " + OTP_IndiGo);
               System.out.println("Air India OTP: " + OTP_AirIndia);
               System.out.println("SpiceJet OTP: " + OTP_SpiceJet);
               System.out.println("Vistara OTP: " + OTP_Vistara);
               System.out.println("Go First OTP: " + OTP_GoFirst);
               System.out.println("AIX Connect OTP: " + OTP_AIXConnect);
               System.out.println("Akasa Air OTP: " + OTP_AkasaAir);



               //Upcomming Data;

                 // Extract data from the HTML content (Passenger Load Factor)
            WebElement passengerLoadFactorElement = driver.findElement(By.xpath("//h2[contains(@class,'passenger-load')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'IndiGo')]/following-sibling::div"));
            String PLF_IndiGo = passengerLoadFactorElement.getText();

            WebElement plfairIndiaElement = driver.findElement(By.xpath("//h2[contains(@class,'passenger-load')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Air India')]/following-sibling::div"));
            String PLF_AirIndia = plfairIndiaElement.getText();

            WebElement plfspiceJetElement = driver.findElement(By.xpath("//h2[contains(@class,'passenger-load')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'SpiceJet')]/following-sibling::div"));
            String PLF_SpiceJet = plfspiceJetElement.getText();

            WebElement plfvistaraElement = driver.findElement(By.xpath("//h2[contains(@class,'passenger-load')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Vistara')]/following-sibling::div"));
            String PLF_Vistara = plfvistaraElement.getText();

            WebElement plfgoFirstElement = driver.findElement(By.xpath("//h2[contains(@class,'passenger-load')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Go First')]/following-sibling::div"));
            String PLF_GoFirst = plfgoFirstElement.getText();

            WebElement plfakasaAirElement = driver.findElement(By.xpath("//h2[contains(@class,'passenger-load')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'AIX Connect')]/following-sibling::div"));
            String PLF_AIXConnect = plfakasaAirElement.getText();

            WebElement plfaixConnectElement = driver.findElement(By.xpath("//h2[contains(@class,'passenger-load')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'AKASA AIR')]/following-sibling::div"));
            String PLF_AkasaAir = plfaixConnectElement.getText();

            // Use the extracted data as needed
            System.out.println("IndiGo PLF: " + PLF_IndiGo);
            System.out.println("Air India PLF: " + PLF_AirIndia);
            System.out.println("SpiceJet PLF: " + PLF_SpiceJet);
            System.out.println("Vistara PLF: " + PLF_Vistara);
            System.out.println("Go First PLF: " + PLF_GoFirst);
            System.out.println("AIX Connect PLF: " + PLF_AIXConnect);
            System.out.println("Akasa Air PLF: " + PLF_AkasaAir);

             // Extract data from the HTML content (UDAN RCS)
             WebElement airportsElement = driver.findElement(By.xpath("//h2[contains(@class,'udan-rcs')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Airports*')]/following-sibling::div"));
             String UDAN_Airports = airportsElement.getText();
 
             WebElement routesElement = driver.findElement(By.xpath("//h2[contains(@class,'udan-rcs')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Routes')]/following-sibling::div"));
             String UDAN_Routes = routesElement.getText();
 
             WebElement operatorsElement = driver.findElement(By.xpath("//h2[contains(@class,'udan-rcs')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Operators')]/following-sibling::div"));
             String UDAN_Operators = operatorsElement.getText();
 
             WebElement flightsElement = driver.findElement(By.xpath("//h2[contains(@class,'udan-rcs')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Flights')]/following-sibling::div"));
             String UDAN_Flights = flightsElement.getText();
 
             WebElement passengersElement = driver.findElement(By.xpath("//h2[contains(@class,'udan-rcs')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Passengers')]/following-sibling::div"));
             String UDAN_Passengers = passengersElement.getText();
 
             WebElement viabilityGapFundingElement = driver.findElement(By.xpath("//h2[contains(@class,'udan-rcs')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Viability Gap Funding')]/following-sibling::div"));
             String UDAN_ViabilityGapFunding = viabilityGapFundingElement.getText();
 
             // Use the extracted data as needed
             System.out.println("UDAN Airports: " + UDAN_Airports);
             System.out.println("UDAN Routes: " + UDAN_Routes);
             System.out.println("UDAN Operators: " + UDAN_Operators);
             System.out.println("UDAN Flights: " + UDAN_Flights);
             System.out.println("UDAN Passengers: " + UDAN_Passengers);
             System.out.println("UDAN Viability Gap Funding: " + UDAN_ViabilityGapFunding);


             
             //
             // Extract data from the HTML content (Air Sewa Grievances - by volume)
            WebElement asgvreceivedElement = driver.findElement(By.xpath("//h2[contains(@class,'Sewa-Grievances')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Received')]/following-sibling::div"));
            String ASG_V_Received = asgvreceivedElement.getText();

            WebElement asgvreceivedTillDateElement = driver.findElement(By.xpath("//h2[contains(@class,'Sewa-Grievances')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Received (Till date)')]/following-sibling::div"));
            String ASG_V_ReceivedTillDate = asgvreceivedTillDateElement.getText();

            WebElement asgvresolvedElement = driver.findElement(By.xpath("//h2[contains(@class,'Sewa-Grievances')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Resolved')]/following-sibling::div"));
            String ASG_V_Resolved = asgvresolvedElement.getText();

            WebElement asgvresolvedTillDateElement = driver.findElement(By.xpath("//h2[contains(@class,'Sewa-Grievances')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Resolved (Till date)')]/following-sibling::div"));
            String ASG_V_ResolvedTillDate = asgvresolvedTillDateElement.getText();

            WebElement asgvpendingElement = driver.findElement(By.xpath("//h2[contains(@class,'Sewa-Grievances')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Pending')]/following-sibling::div"));
            String ASG_V_Pending = asgvpendingElement.getText();

            WebElement asgvpendingTillDateElement = driver.findElement(By.xpath("//h2[contains(@class,'Sewa-Grievances')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Pending (Till date)')]/following-sibling::div"));
            String ASG_V_PendingTillDate = asgvpendingTillDateElement.getText();

            // Use the extracted data as needed
            System.out.println("ASGV Received: " + ASG_V_Received);
            System.out.println("ASGV Received Till Date: " + ASG_V_ReceivedTillDate);
            System.out.println("ASGV Resolved: " + ASG_V_Resolved);
            System.out.println("ASGV Resolved Till Date: " + ASG_V_ResolvedTillDate);
            System.out.println("ASGV Pending: " + ASG_V_Pending);
            System.out.println("ASGV Pending Till Date: " + ASG_V_PendingTillDate);

             // Extract data from the HTML content (Air Sewa Grievances - by type)
             WebElement asgtrefundsElement = driver.findElement(By.xpath("//h2[contains(@class,'type-menu')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Refunds')]/following-sibling::div"));
             String ASG_T_Refunds = asgtrefundsElement.getText();
 
             WebElement asgtbaggageElement = driver.findElement(By.xpath("//h2[contains(@class,'type-menu')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Baggage')]/following-sibling::div"));
             String ASG_T_Baggage = asgtbaggageElement.getText();
 
             WebElement asgtcheckinElement = driver.findElement(By.xpath("//h2[contains(@class,'type-menu')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Check-in')]/following-sibling::div"));
             String ASG_T_Checkin = asgtcheckinElement.getText();
 
             WebElement asgtsecurityCheckElement = driver.findElement(By.xpath("//h2[contains(@class,'type-menu')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Security Check')]/following-sibling::div"));
             String ASG_T_SecurityCheck = asgtsecurityCheckElement.getText();
 
             WebElement asgtmealsElement = driver.findElement(By.xpath("//h2[contains(@class,'type-menu')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Meals')]/following-sibling::div"));
             String ASG_T_Meals = asgtmealsElement.getText();
 
             WebElement asgtothersElement = driver.findElement(By.xpath("//h2[contains(@class,'type-menu')]/following-sibling::span[contains(@class,'date-widget')]/parent::div/following-sibling::div//div[contains(@class,'field--name-field-label') and contains(text(),'Others')]/following-sibling::div"));
             String ASG_T_Others = asgtothersElement.getText();
 
             // Use the extracted data as needed
             System.out.println("ASGT Refunds: " + ASG_T_Refunds);
             System.out.println("ASGT Baggage: " + ASG_T_Baggage);
             System.out.println("ASGT Check-in: " + ASG_T_Checkin);
             System.out.println("ASGT Security Check: " + ASG_T_SecurityCheck);
             System.out.println("ASGT Meals: " + ASG_T_Meals);
             System.out.println("ASGT Others: " + ASG_T_Others);


//===========================================================================================
//Issue #1
  // The value of airlines are changing on the day
  
  //Approach to fix : Instead of Making the variable by the name of the airline 
  //make the variable by Entit1 = 1st value of the list "Airline + Value" from the list 
  //Same for other value.

            // String Entity1;
            // String Entity2;
            // String Entity3;
            // String Entity4;
            // String Entity5;
            // String Entity6;
// Fixed

//============================================================================================      

   // Locate the Air Sewa Grievances (by entity) section
   WebElement grievancesSection = driver.findElement(By.id("block-views-block-air-sewa-grievances-block-3"));

   // Extract data for each entity

       String entityLabel1Xpath = "/html/body/div[1]/div[1]/div/div[1]/div[9]/div/div/div/div/div[2]/ul/li[1]/div/div[1]";
       String entityCount1Xpath = "/html/body/div[1]/div[1]/div/div[1]/div[9]/div/div/div/div/div[2]/ul/li[1]/div/div[2]";

       WebElement entityLabel1Element = grievancesSection.findElement(By.xpath(entityLabel1Xpath));
       WebElement entityCount1Element = grievancesSection.findElement(By.xpath(entityCount1Xpath));

       String entityLabel1 = entityLabel1Element.getText().trim();
       String entityCount1 = entityCount1Element.getText().trim();

       // Extract data for each entity

       String entityLabel2Xpath = "/html/body/div[1]/div[1]/div/div[1]/div[9]/div/div/div/div/div[2]/ul/li[2]/div/div[1]";
       String entityCount2Xpath = "/html/body/div[1]/div[1]/div/div[1]/div[9]/div/div/div/div/div[2]/ul/li[2]/div/div[2]";

       WebElement entityLabel2Element = grievancesSection.findElement(By.xpath(entityLabel2Xpath));
       WebElement entityCount2Element = grievancesSection.findElement(By.xpath(entityCount2Xpath));

       String entityLabel2 = entityLabel2Element.getText().trim();
       String entityCount2 = entityCount2Element.getText().trim();
        
          // Extract data for each entity

       String entityLabel3Xpath = "/html/body/div[1]/div[1]/div/div[1]/div[9]/div/div/div/div/div[2]/ul/li[3]/div/div[1]";
       String entityCount3Xpath = "/html/body/div[1]/div[1]/div/div[1]/div[9]/div/div/div/div/div[2]/ul/li[3]/div/div[2]";

       WebElement entityLabel3Element = grievancesSection.findElement(By.xpath(entityLabel3Xpath));
       WebElement entityCount3Element = grievancesSection.findElement(By.xpath(entityCount3Xpath));

       String entityLabel3 = entityLabel3Element.getText().trim();
       String entityCount3 = entityCount3Element.getText().trim();
        

         // Extract data for each entity

         String entityLabel4Xpath = "/html/body/div[1]/div[1]/div/div[1]/div[9]/div/div/div/div/div[2]/ul/li[4]/div/div[1]";
         String entityCount4Xpath = "/html/body/div[1]/div[1]/div/div[1]/div[9]/div/div/div/div/div[2]/ul/li[4]/div/div[2]";
  
         WebElement entityLabel4Element = grievancesSection.findElement(By.xpath(entityLabel4Xpath));
         WebElement entityCount4Element = grievancesSection.findElement(By.xpath(entityCount4Xpath));
  
         String entityLabel4 = entityLabel4Element.getText().trim();
         String entityCount4 = entityCount4Element.getText().trim();
          

           // Extract data for each entity

       String entityLabel5Xpath = "/html/body/div[1]/div[1]/div/div[1]/div[9]/div/div/div/div/div[2]/ul/li[5]/div/div[1]";
       String entityCount5Xpath = "/html/body/div[1]/div[1]/div/div[1]/div[9]/div/div/div/div/div[2]/ul/li[5]/div/div[2]";

       WebElement entityLabel5Element = grievancesSection.findElement(By.xpath(entityLabel5Xpath));
       WebElement entityCount5Element = grievancesSection.findElement(By.xpath(entityCount5Xpath));

       String entityLabel5 = entityLabel5Element.getText().trim();
       String entityCount5 = entityCount5Element.getText().trim();

         // Extract data for each entity

         String entityLabel6Xpath = "/html/body/div[1]/div[1]/div/div[1]/div[9]/div/div/div/div/div[2]/ul/li[6]/div/div[1]";
         String entityCount6Xpath = "/html/body/div[1]/div[1]/div/div[1]/div[9]/div/div/div/div/div[2]/ul/li[6]/div/div[2]";
  
         WebElement entityLabel6Element = grievancesSection.findElement(By.xpath(entityLabel6Xpath));
         WebElement entityCount6Element = grievancesSection.findElement(By.xpath(entityCount6Xpath));
  
         String entityLabel6 = entityLabel6Element.getText().trim();
         String entityCount6 = entityCount6Element.getText().trim();
          
  

       // Concatenate and save the result
       String Entity1 = entityLabel1 + " - " + entityCount1;
       String Entity2 = entityLabel2 + " - " + entityCount2;
       String Entity3 = entityLabel3 + " - " + entityCount3;
       String Entity4 = entityLabel4 + " - " + entityCount4;
       String Entity5 = entityLabel5 + " - " + entityCount5;
       String Entity6 = entityLabel6 + " - " + entityCount6;

       System.out.println("Entity1" + ": " + Entity1);
       System.out.println("Entity2" + ": " + Entity2);
       System.out.println("Entity3" + ": " + Entity3);
       System.out.println("Entity4" + ": " + Entity4);
       System.out.println("Entity5" + ": " + Entity5);
       System.out.println("Entity6" + ": " + Entity6);
  
    //Issue #2
 
   //Approach to fix - Skip the value which whose xpath is not able to find 
   //and check why the value is not found; 
 
           //  Extract data from the HTML content (Airports section)
             WebElement operationalElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[10]/div/div/div/div/div[2]/ul/li[1]/div/div[2]"));
             String A_Operational = operationalElement.getText();
 
             WebElement internationalElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[10]/div/div/div/div/div[2]/ul/li[2]/div/div[2]"));
             String A_International = internationalElement.getText();
 
             WebElement customElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[10]/div/div/div/div/div[2]/ul/li[3]/div/div[2]"));
             String A_Custom = customElement.getText();
 
             WebElement domesticElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[10]/div/div/div/div/div[2]/ul/li[4]/div/div[2]"));
             String A_Domestic = domesticElement.getText();
 
             WebElement jointVentureInternationalElement = driver.findElement(By.xpath("//html/body/div[1]/div[1]/div/div[1]/div[10]/div/div/div/div/div[2]/ul/li[5]/div/div[2]"));
             String A_JointVentureInternational = jointVentureInternationalElement.getText();
 
             WebElement stateGovPrivateElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[10]/div/div/div/div/div[2]/ul/li[6]/div/div[2]"));
             String A_StateGov_Private = stateGovPrivateElement.getText();
 
             // Use the extracted data as needed
             System.out.println("Operational Airports: " + A_Operational);
             System.out.println("International Airports: " + A_International);
             System.out.println("Custom Airports: " + A_Custom);
             System.out.println("Domestic Airports: " + A_Domestic);
             System.out.println("Joint Venture International Airports: " + A_JointVentureInternational);
             System.out.println("State Govt./Private Airports: " + A_StateGov_Private);
 

// String D_TypeCertificates;
// String D_UINissued;
// String D_DroneSchools;
// String D_CertifiedPilots;
// String D_DANissued;
// String D_ExemptedProjects;

// String C_Inbound_INT;
// String C_Inbound_DOM;
// String C_Outbound_INT;
// String C_Outbound_DOM;
// String C_Total_INT;
// String C_Total_DOM;

// String KU_Airport;
// String KU_Permishable;
// String KU_Others;
// String KU_Total;

// String SBA_CandidatesCertified;
// String SBA_TrainersCertified;
// String SBA_AssessorsCertified;
// String SBA_JobRolesDeveloped;
// String SBA_TrainingCentersAccredited;
// String SBA_TrainingPartnersAffiliated;

// String SBR_NumberOfCourses;
// String SBR_NumberOfCandidates;
// String SBR_CandidatesWhoPassedOut;
// String SBR_CandidatesWhoObtainedJob;

// String SBI_CourseAndActivities;
// String SBI_RegisteredStudents;
// String SBI_StudentsPassout;
// String SBI_FlyingHours;

// String FTO_TotalFTO;
// String FTO_OperationalBases;
   
        } finally {
            // Close the WebDriver
            driver.quit();
        }
    }
}









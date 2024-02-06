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

               //Upcomming Data;
 // String OTP_IndiGo;
// String OTP_AirIndia;
// String OTP_SpiceJet;
// String OTP_Vistara;
// String OTP_GoFirst;
// String OTP_Akasa_Air; 
// String OTP_AIXConnect;


// String PLF_IndiGo;
// String PLF_AirIndia;
// String PLF_SpiceJet;
// String PLF_Vistara;
// String PLF_GoFirst;
// String PLF_Akasa_Air; 
// String PLF_AIXConnect;

// String UDAN_Airports;
// String UDAN_Routes;
// String UDAN_Operators;
// String UDAN_Flights;
// String UDAN_Passengers;
// String UDAN_ViabilityGapFunding;

// String ASG_V_Received;
// String ASG_V_ReceivedTillDate;
// String ASG_V_Resolved;
// String ASG_V_ResolvedTillDate;
// String ASG_V_Pending;
// String ASG_V_PendingTillDate;

// String ASG_T_Refunds;
// String ASG_T_Baggage;
// String ASG_T_Checkin;
// String ASG_T_SecurityCheck;
// String ASG_T_Meals;
// String ASG_Others;

// String ASG_E_AirIndia;
// String ASG_E_Security;
// String ASG_E_GoFirst;
// String ASG_E_Indigo;
// String ASG_E_VietJetAir;
// String ASG_E_QatarAirways;

// String A_Operational;
// String A_International;
// String A_Custom;
// String A_Domestic;
// String A_JointVentureInternational;
// String A_StateGov_Private;

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









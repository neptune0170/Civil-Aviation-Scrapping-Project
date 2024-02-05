package com.civilaviation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleScraper {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PS42\\Desktop\\Scraping Project\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Google
        driver.get("https://www.google.com");

        // Find the search box element by its name attribute value
        WebElement searchBox = driver.findElement(By.name("q"));

        // Type a query into the search box
        searchBox.sendKeys("your search query");

        // Press Enter to submit the search
        searchBox.sendKeys(Keys.RETURN);

        // Wait for the results page to load (you might need to add more explicit waits)
        // For simplicity, let's just sleep for a few seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the search results
        System.out.println("Search Results:");
        driver.findElements(By.cssSelector("h3")).forEach(result -> System.out.println(result.getText()));

        // Close the browser
        driver.quit();
    }
}
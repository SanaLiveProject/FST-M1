package LiveProjectJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class LiveActivity1 {

        public static void main(String[] args) {

            // Set up Firefox driver
            WebDriverManager.firefoxdriver().setup();

            // Create a new instance of the Firefox driver
            WebDriver driver = new FirefoxDriver();

            // Open the page
            driver.get("http://alchemy.hguy.co/orangehrm");

            // Print the title of the page
            System.out.println("Home page title: " + driver.getTitle());

            // Assertion for matching the title
            String heading = "OrangeHRM";
            Assert.assertEquals(heading, "OrangeHRM");
            System.out.println("Assertion is passed");

            // Close the browser
            driver.close();
        }
    }

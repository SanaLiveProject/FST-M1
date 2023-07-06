package LiveProjectJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class LiveActivity3 {
    public static void main(String[] args) throws InterruptedException {

        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("http://alchemy.hguy.co/orangehrm");

        // Find the username field and enter the username
        driver.findElement(By.id("txtUsername")).sendKeys("orange");

        // Find the password field and enter the password
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");

        // Find the login button and click it
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(1000);

        //Find the login name
        driver.findElement(By.id("welcome"));
        System.out.println("You are on the dashboard screen");

        //Assertion
        String loginName = "Welcome Shubham";
        Assert.assertEquals(loginName, "Welcome Shubham");

        // Close the browser
        driver.close();

    }
}

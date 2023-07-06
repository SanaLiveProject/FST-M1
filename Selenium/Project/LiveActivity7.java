package LiveProjectJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LiveActivity7 {

    public static void main(String[] args) throws InterruptedException {

        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //Wait element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("http://alchemy.hguy.co/orangehrm");

        // Find the username field and enter the username
        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtUsername")).sendKeys("orange");

        // Find the password field and enter the password
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");


        // Find the login button and click it
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(1000);

        //Find the My info menu item
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();

        //Find Qualifications option and click it
        driver.findElement(By.linkText("Qualifications")).click();

        //Click Add button
        driver.findElement(By.xpath("//*[@id=\"addWorkExperience\"]")).click();

        //Add work details
        driver.findElement(By.id("experience_employer")).sendKeys("ABC India");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Business Analyst");
        Thread.sleep(1000);

        //Save the details
        driver.findElement(By.xpath("//*[@id=\"btnWorkExpSave\"]")).click();
        System.out.println("Work experience is added");

        //Close the browser
        driver.close();
    }
}

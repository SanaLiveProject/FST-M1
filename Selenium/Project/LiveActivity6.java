package LiveProjectJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LiveActivity6 {
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

        //Find the directory menu item
        driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]/b")).isDisplayed();
        System.out.println("Directory menu is visible");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]/b"))).click();
        System.out.println("Directory menu is clickable");

        //Match the heading
        String heading = "Search Directory";
        Assert.assertEquals(heading, "Search Directory");
        System.out.println("Heading of the page matches Search Directory");

        //Close the browser
        driver.close();


    }
}

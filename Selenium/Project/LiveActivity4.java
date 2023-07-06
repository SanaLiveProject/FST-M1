package LiveProjectJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class LiveActivity4 {
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

        //Find the PIM option in the menu and click it.
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();
        Thread.sleep(1000);

        //Click the Add button
        driver.findElement(By.name("btnAdd")).click();
        Thread.sleep(1000);

        //Enter first name and last name
        driver.findElement(By.id("firstName")).sendKeys("Sana");
        driver.findElement(By.id("lastName")).sendKeys("Afreen");

        //Click save
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();

        //Verify that employee is added
        driver.findElement(By.xpath("//*[@id=\"profile-pic\"]/h1"));
        System.out.println("Employee is added");


        //Click on Employee list
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();

        //Type the employee name in search bar
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Sana Afreen");

        //Click on search button
        driver.findElement(By.id("searchBtn")).click();

        //Verify the addition of employee
        driver.findElement(By.linkText("Sana")).click();

        //Employee is added
        driver.findElement(By.xpath("//*[@id=\"profile-pic\"]/h1"));
        System.out.println("Search is successful and Employee is available");

        // Close the browser
        driver.close();

    }
}

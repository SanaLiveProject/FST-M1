package LiveProjectJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LiveActivity8 {
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

        //Click on Dashboard menu item
        driver.findElement(By.xpath("//*[@id=\"menu_dashboard_index\"]/b")).click();

        //Click on Apply leave
        driver.findElement(By.xpath("//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[4]/div/a/span")).click();

        //Select option for leave type
        WebElement leave = driver.findElement(By.id("applyleave_txtLeaveType"));
        Select singleselect = new Select(leave);
        singleselect.selectByVisibleText("DayOff");
        System.out.println("Day off selected");
        Thread.sleep(1000);

        //Enter date
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2023-11-07");
        Thread.sleep(1000);

        //Enter comments
        driver.findElement(By.id("applyleave_txtComment")).sendKeys("Test Live Activity8");

        //Click on Apply
        driver.findElement(By.id("applyBtn")).click();

        //My leave menu option
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();

        //verify the status of leave
        driver.findElement(By.linkText("Pending Approval(1.00)"));
        System.out.println("Leave is pending for approval");
        Thread.sleep(1000);

        //Close the browser
        driver.close();
    }
}
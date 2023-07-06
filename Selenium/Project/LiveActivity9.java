package LiveProjectJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.util.List;

import java.time.Duration;

public class LiveActivity9 {
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

        //Find Emergency contacts option and click it
        driver.findElement(By.linkText("Emergency Contacts")).click();
        Thread.sleep(1000);

        // Print the cells values of the first row
        List<WebElement> firstRow = driver.findElements(By.xpath("//*[@id=\"emgcontact_list\"]/tbody/tr[1]"));
        System.out.println("Emergency contacts: ");
        for (WebElement cell : firstRow) {
            System.out.println(cell.getText());
        }
        List<WebElement> secondRow = driver.findElements(By.xpath("//*[@id=\"emgcontact_list\"]/tbody/tr[2]"));
        for (WebElement cell : secondRow) {
            System.out.println(cell.getText());
        }

        //Close the browser
        driver.close();
        }
}

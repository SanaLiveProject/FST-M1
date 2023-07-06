package LiveProjectJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LiveActivity5 {
    public static void main(String[] args) throws InterruptedException {

        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

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

        //Find the MyInfo option in the menu and click it.
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();
        Thread.sleep(1000);

        //On the new page, click the Edit button.
        driver.findElement(By.id("btnSave")).click();

        //Edit First name
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Edited");

        //Edit Last name
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Name");
        Thread.sleep(1000);
        System.out.println("Name is edited");

        //Select Gender
        driver.findElement(By.id("personal_optGender_2")).click();
        Thread.sleep(1000);
        System.out.println("Gender is edited");

        //Select Nationality
        WebElement dropdown = driver.findElement(By.id("personal_cmbNation"));
        Select singleselect = new Select(dropdown);
        singleselect.selectByVisibleText("Indian");
        System.out.println("Nationality selected");
        Thread.sleep(1000);

        //Select DOB
        driver.findElement(By.id("personal_DOB")).clear();
        driver.findElement(By.id("personal_DOB")).sendKeys("1993-11-06");
        System.out.println("DOB entered");
        Thread.sleep(1000);

        //Click SAVE
        driver.findElement(By.id("btnSave")).click();
        System.out.println("Everything is saved");
        Thread.sleep(1000);

        //Close the browser
        driver.close();
    }
}

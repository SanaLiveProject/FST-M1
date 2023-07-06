package LiveProjectJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LiveActivity2 {
    public static void main(String[] args) {

        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("http://alchemy.hguy.co/orangehrm");

        //Find the image
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
        String url = logo.getAttribute("src");
        System.out.println("URL of the image is : " + url);

        // Close the browser
        driver.close();
    }
}


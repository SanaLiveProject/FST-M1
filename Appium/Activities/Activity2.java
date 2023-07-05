package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;


    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);

        // Open the page in Chrome
        driver.get("https://www.training-support.net");
        Thread.sleep(2000);
    }

    // Test method
    @Test
    public void chromeTest() throws InterruptedException {

        String pageHeading = driver.findElement(AppiumBy.xpath(
                "//android.view.View[@text='Training Support']")).getText();

        // Print to console
        System.out.println("Heading: " + pageHeading);

        // Find and click the About Us link
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='about-link']")).click();
        Thread.sleep(8000);

        // Find heading of new page and print to console
        Thread.sleep(9000);
        String aboutPageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).getText();
        System.out.println(aboutPageHeading);
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}

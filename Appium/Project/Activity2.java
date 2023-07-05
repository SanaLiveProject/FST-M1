package LiveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.testng.Assert.*;

public class Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException
    {
        //Desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        //Appium server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialise Android Driver
        driver = new AndroidDriver(serverURL,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @Test

    public void keepTest() throws InterruptedException {
        WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("New text note")));
        plusButton.click();
        WebElement title = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/editable_title")));
        title.sendKeys("Testing automation");
        WebElement desc = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/edit_note_text")));
        desc.sendKeys("Short description is entered");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        Thread.sleep(1000);
        //Assertions
        String noteAdded = driver.findElement(AppiumBy.xpath("//androidx.cardview.widget.CardView[@content-desc=\"Testing automation. Short description is entered. \"]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
        Assert.assertEquals(noteAdded, "Testing automation");
        System.out.println("Note is added");

    }
}

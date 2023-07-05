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

public class BonusActivity1 {
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

    public void reminderTest() throws InterruptedException {
        WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("New text note")));
        plusButton.click();
        WebElement title = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/editable_title")));
        title.sendKeys("Bonus Activity Note");
        WebElement desc = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/edit_note_text")));
        desc.sendKeys("Adding description to the note");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        Thread.sleep(1000);
        //Click on toolbar icon
        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
        Thread.sleep(1000);
        //Click on Reminders
        driver.findElement(AppiumBy.id("com.google.android.keep:id/drawer_navigation_reminders")).click();
        Thread.sleep(1000);
        //Click on plus icon to add reminder
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        //Enter title of the reminder
        WebElement remTitle = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/editable_title")));
        remTitle.sendKeys("Bonus Activity reminder");
        //Enter note to the reminder
        WebElement remDesc = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/edit_note_text")));
        remDesc.sendKeys("Adding description to the reminder");

        //Click on reminder icon
        driver.findElement(AppiumBy.accessibilityId("Reminder")).click();

        //Pick date and time
        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]")).click();
        Thread.sleep(1000);

        //Click the date time picker
        driver.findElement(AppiumBy.accessibilityId("Time - Currently selected - 8:00 AM")).click();
        Thread.sleep(1000);

        //Select Afternoon
        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView[1]")).click();

        //Click day picker
        driver.findElement(AppiumBy.accessibilityId("Date - Currently selected - July 6")).click();
        Thread.sleep(1000);

        //Select Today
        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView")).click();
        Thread.sleep(1000);

        //Click save
        driver.findElement(AppiumBy.id("com.google.android.keep:id/save")).click();

        //Click back arrow
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        Thread.sleep(1000);

        //Assertions
        String added = driver.findElement(AppiumBy.xpath("(//androidx.cardview.widget.CardView[@content-desc=\"Bonus Activity reminder. Adding description to the reminder. \"])[1]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
        Assert.assertEquals(added, "Bonus Activity reminder");
        String afternoon = driver.findElement(AppiumBy.xpath("(//androidx.cardview.widget.CardView[@content-desc=\"Bonus Activity reminder. Adding description to the reminder. \"])[1]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView")).getText();
        Assert.assertEquals(afternoon, "Today, 6:00 PM");
        System.out.println("Reminder is added for today 6:00 PM");


    }
}

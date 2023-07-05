package LiveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static Examples.ActionsBase.doSwipe;

public class Activity3 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        //Appium server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialise Android Driver
        driver = new AndroidDriver(serverURL,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Open Selenium page
        driver.get("https://www.training-support.net/selenium");

    }
    @Test
    public void webAppTest() throws InterruptedException {
        Dimension dims = driver.manage().window().getSize();

        //wait until page loads
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']"))).click();
        Thread.sleep(1000);

        //Scroll to end of the page
        Point start = new Point((int)(dims.width*0.5),(int)(dims.height*0.8));
        Point end = new Point((int)(dims.width*0.5),(int)(dims.height*0.2));
        doSwipe(driver,start,end,200);

        //Find and click To-Do List
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@text='To-Do List \uF0AE Elements get added at run time ']"))).click();


        //Wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));

        //To-Do list app actions
        WebElement addTaskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));
        WebElement addTaskButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));

        //Enter Tasks
        addTaskInput.sendKeys("Add Tasks to list");
        addTaskButton.click();
        Thread.sleep(1000);
        addTaskInput.sendKeys("Get number of tasks");
        addTaskButton.click();
        Thread.sleep(1000);
        addTaskInput.sendKeys("Clear the list");
        addTaskButton.click();
        Thread.sleep(1000);
        //Click the added tasks to strike them out
        driver.findElement(AppiumBy.xpath("//android.view.View[@text='Add Tasks to list']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@text='Get number of tasks']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@text='Clear the list']")).click();
        Thread.sleep(1000);

        //Clear the list
        WebElement clear = driver.findElement(AppiumBy.xpath("//android.view.View[@text=' Clear List']"));
        clear.click();
        Thread.sleep(500);
    }
}

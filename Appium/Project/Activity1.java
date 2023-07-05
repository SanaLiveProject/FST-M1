package LiveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        //Appium server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialise Android Driver
        driver = new AndroidDriver(serverURL,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void activityTest() throws InterruptedException {

        //In the tasks home page click on plus button
        WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Create new task")));
        plusButton.click();
        //Add a new task
        WebElement addTaskInput = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        addTaskInput.sendKeys("Complete Activity with Google Tasks");
        //Save the task
        WebElement saveBtn = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"));
        saveBtn.click();

        //Click plus button again
        Thread.sleep(1000);
        plusButton.click();
        Thread.sleep(1000);
        //Add one more task
        addTaskInput = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        addTaskInput.sendKeys("Complete Activity with Google Keep");
        Thread.sleep(1000);
        //Click save
        saveBtn = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"));
        saveBtn.click();
        Thread.sleep(1000);

        //Click plus button again
        Thread.sleep(1000);
        plusButton.click();
        Thread.sleep(1000);
        //Add one more task
        addTaskInput = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        addTaskInput.sendKeys("Complete the second Activity Google Keep");
        Thread.sleep(1000);
        //Click save
        saveBtn = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"));
        saveBtn.click();
        Thread.sleep(1000);

        //Assertions
        String firstTask = "Complete Activity with Google Keep";
        Assert.assertEquals(firstTask, "Complete Activity with Google Keep");
        System.out.println("Google keep task is available - Assertion passed");
        String secondTask = "Complete Activity with Google Tasks";
        Assert.assertEquals(secondTask, "Complete Activity with Google Tasks");
        System.out.println("Google Tasks task is available - - Assertion passed");
        String thirdTask = "Complete the second Activity Google Keep";
        Assert.assertEquals(thirdTask, "Complete the second Activity Google Keep");
        System.out.println("Google keep second task is available- Assertion passed");
    }
}


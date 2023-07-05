package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;

import static org.testng.Assert.assertEquals;

public class Activity1 {

    WebDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.android.calculator2");
        caps.setAppActivity(".Calculator");
        caps.noReset();

        //Appium server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialise Android Driver
        driver = new AndroidDriver(serverURL, caps);
    }
    @Test
    public void multiplicationTest() throws IOException {
        //Find digit 6 and tap it
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_6")).click();
        //Find multiplication symbol and tap it
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        //Find digit 9 and tap it
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
        //Find equal to symbol and tap it
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        //Assertion
        String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        assertEquals(result,"54");
        try {
            takeScreenshot(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void takeScreenshot(WebDriver driver) throws IOException {
        //Take the screenshot
        File tempImg = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Create SAVE location
        File screenshot = new File("src/test/resources/screenshot.jpg");
        //Copy temp data to save file
        FileUtils.copyFile(tempImg, screenshot);
        //Set file path for screenshot
        String imgPath = "../" +screenshot;
        //Add it to HTML report
        String imgHTML = "<img src=" + imgPath + "/>";
        Reporter.log(imgHTML);

    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}

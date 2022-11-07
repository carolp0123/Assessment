package baseTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    public WebDriver driver;

    protected HomePage homePage; /* access modifier */

    @BeforeMethod
    public void setup(){

        // to run in headless
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");

        // set up chrome driver
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver(options); /* added options */
        driver.manage().window().maximize();
        driver.get("http://www.way2automation.com/angularjs-protractor/webtables/ ");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void captureScrShot(ITestResult testResult){

        // if test status is a fail
        if(ITestResult.FAILURE  == testResult.getStatus()){

            TakesScreenshot screenshot = (TakesScreenshot) driver; /* take a screenshot */
            File source = screenshot.getScreenshotAs(OutputType.FILE); /*get the screenshot as a file */

            // store unique screen short according to the test name plus time
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/failed/" + testResult.getName()+ "_" + testResult.getStartMillis() + ".png");

            try {
                FileHandler.copy(source,destination);/*hover and more actions then select try catch */
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else

        if(ITestResult.SUCCESS  == testResult.getStatus()){

            TakesScreenshot screenshot = (TakesScreenshot) driver; /* take a screenshot*/
            File source = screenshot.getScreenshotAs(OutputType.FILE); /*get the screenshot as a file */

            // store unique screen short according to the test name plus time
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/passed/" + testResult.getName()+ "_" + testResult.getStartMillis() + ".png");

            try {
                FileHandler.copy(source,destination);/*hover and more actions then select try catch */
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

}

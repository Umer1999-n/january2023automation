package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class ReusableActions_Logger {
    //return method to initiate chromedriver for you test
    public static WebDriver chromeDriverSetup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("full-screen"); //start-maximized for windows
        //options.addArguments("headless");
        options.addArguments("incognito");
        //define my driver and call the chrome options conditions there
        WebDriver driver = new ChromeDriver(options);

        //at the end return the driver variable so it can be used on your test class
        return driver;
    }//end of chrome setup method

    //click action reusable method
    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
//            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully clicked on :" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of click action

    //click by index is a void method which will just perform the action
    public static void clickByIndexMethod(WebDriver driver, String xpath, int indexNumber, String elementName){
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber).click();
        }catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of click by index method

    //sendkeys is a void method which will just perform the type action
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName){
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully enterd valued on " + elementName);
        }catch (Exception e) {
            System.out.println("Unable to type on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to type on element " + elementName + " " + e);
        }
    }//end of sendkeys method

    //getText is a return method which will just perform the type action
    public static String captureText(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        String result = null;
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            //it's local to that try catch block
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
            logger.log(LogStatus.PASS,"Successfully captured text on " + elementName);

        }catch (Exception e) {
            System.out.println("Unable to type on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to type on element " + elementName + " " + e);
        }

        return result;
    }//end of getText method

    //click is a void method which will just perform the action
    public static void submitMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            logger.log(LogStatus.PASS,"Successfully submitted on " + elementName);

        }catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit method

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method
}//end of class

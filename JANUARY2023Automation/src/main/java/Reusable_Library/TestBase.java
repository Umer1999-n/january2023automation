package Reusable_Library;

import Reusable_Library.ReusableActions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    //set all global variables here with public static
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    //Set Before suite for report path and set driver
    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions.chromeDriverSetup();
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report.html", true);
    }//end of before suite annotation

    //set before method to capture test name for each @test method, so that it is visible on the report
    @BeforeMethod
    public void setTestName(Method methodName) {
        //set the name of the test case to the report by using logger concept
        logger = reports.startTest(methodName.getName());
    }//end of before method

    //set after method to end the logger for each @test in the test class
    @AfterMethod
    public void endTest() {
        reports.endTest(logger);
    }//end of after method

    //after suite to quit the driver
    @AfterSuite
    public static void quitSession() {
        driver.quit();
        //needed to create the html report after test execution
        reports.flush();
    }//end of after suite
}//end of class

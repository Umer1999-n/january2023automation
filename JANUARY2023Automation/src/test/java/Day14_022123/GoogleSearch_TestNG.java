package Day14_022123;

import Reusable_Library.ReusableActions;
import Reusable_Library.ReusableActions_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static Reusable_Library.TestBase.logger;

public class GoogleSearch_TestNG {
    //define wedbdriver
    WebDriver driver;

    @BeforeSuite
    public void setChromeDriver() {
        driver = ReusableActions.chromeDriverSetup();
    }//end of setDriver method

    @Test(priority = 1)
    public void SearchForBMW(){
        //navigate to google home page
        driver.navigate().to("https://www.google.com");
        //enter the keyword bmw on your search field
        ReusableActions_Logger.sendKeysMethod(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //submit on search button
        ReusableActions_Logger.submitAction(driver,"//*[@name='btnK']",logger,"Google Search");
    }//end of test 1

    @Test(priority = 2)
    public void CaptureSearchResultsForBMW(){
        //capture the search results using getText() and only print out the search number
        String results = ReusableActions_Logger.captureText(driver,"//*[@id='result-stats']",logger,"Search Results");
        String[] arrayMessage = results.split(" ");
        System.out.println("Search Number is " + arrayMessage[1]);
        logger.log(LogStatus.INFO,"Search Number is " + arrayMessage[1]);

    }//end of test 2
    @AfterSuite
    public void quitDriverSession() {
        driver.quit();
    }
}//end of class

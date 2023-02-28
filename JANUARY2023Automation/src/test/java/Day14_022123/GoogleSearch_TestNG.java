package Day14_022123;

import Reusable_Library.ReusableActions_Logger;
import org.testng.annotations.Test;

/*public class GoogleSearch_TestNG {
    @Test(priority = 1)
    public void SearchForBMW(){
        //navigate to google home page
        driver.navigate().to("https://www.google.com");
        //enter the keyword bmw on your search field
        ReusableActions_Logger.sendKeysMethod(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //submit on search button
        ReusableActions_Logger.submitMethod(driver,"//*[@name='btnK']",logger,"Google Search");
    }//end of test 1

    @Test(priority = 2)
    public void CaptureSearchResultsForBMW(){
        //capture the search results using getText() and only print out the search number
        String results = ReusableActions_Logger.captureText(driver,"//*[@id='result-stats']",logger,"Search Results");
        String[] arrayMessage = results.split(" ");
        System.out.println("Search Number is " + arrayMessage[1]);
        logger.log(LogStatus.INFO,"Search Number is " + arrayMessage[1]);

        //quit the driver
        driver.quit();

    }//end of test 2
}//end of class*/

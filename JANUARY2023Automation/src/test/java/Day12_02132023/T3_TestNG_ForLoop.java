package Day12_02132023;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;



public class T3_TestNG_ForLoop {
    //define wedbdriver
    WebDriver driver;

    @BeforeSuite
    public void setChromeDriver() {
        driver = ReusableActions.chromeDriverSetup();
    }//end of setDriver method

    @Test
    public void searchForMultipleCars(){
        ArrayList<String> carBrands = new ArrayList<>() ;
        carBrands.add("BMW");//index 0
        carBrands.add("Benz");//index 1
        carBrands.add("Bentley");//index 2
        carBrands.add("Toyota");//index 3
        for (int i = 0; i < carBrands.size(); i++){
            //go to google.com
            driver.navigate().to("https://www.google.com");
            //enter a car in the search field
            ReusableActions.sendKeysMethod(driver,"//*[@name='q']", carBrands.get(i),"Search Field");
            //hit submit on the google search button
            ReusableActions.submitAction(driver,"//*[@name= 'btnK']", "Google Search Button");
            String result = ReusableActions.captureText(driver,"//*[@id= 'result-stats']","Search Results");
            String[] arrayResult = result.split(" ");
            System.out.println("Result is " + arrayResult[1]);
        }//end of for loop
    }//end of search for multiple car test
    @AfterSuite
    public void quitDriverSession() {
        driver.quit();
    }
}//end of class

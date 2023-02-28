package Day9_01312023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_Hotels_InClassAI_Fahad {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome option
        ChromeOptions options = new ChromeOptions();
        // add the options for maximizing the chrome meeting
        options.addArguments("start-maximized");
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);
        //create array list for destinations
        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("Ohio");
        destinations.add("Florida");
        destinations.add("Nevada");

        for (int i = 0; i < destinations.size(); i++) {
            //navigate to hotels.com
            driver.navigate().to("https://www.hotels.com");
            //wait 2 seconds
            Thread.sleep(2000);

            //click on search bar "Going to"
            try {
                driver.findElement(By.xpath("//*[@class= 'uitk-fake-input uitk-form-field-trigger']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on Going to.. " + e);
            }

            //type in destination
            try {
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(destinations.get(i));
                //wait 1 second
                Thread.sleep(1000);
                //click on the first suggestions from the search box
                driver.findElements(By.xpath("//*[@class = 'truncate']")).get(0).click();
                //alternative way to enter your search criteria
                //driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(Keys.ENTER);
            } catch (Exception e) {
                System.out.println("Unable to type in destinations.. " + e);
            }

            //click on the search button
            try {
                driver.findElement(By.xpath("//*[@id='search_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on the search button.. " + e);
            }
            // wait a couple seconds
            Thread.sleep(3000);

            //create an arraylist for hotels suggestions
            ArrayList<WebElement> hotelList = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid= 'open-hotel-information']")));

            if (i == 0) {
                hotelList.get(0).click();
            } else if (i == 1) {
                hotelList.get(2).click();
            }else if (i == 2){
                hotelList.get(1).click();
            }

            // capture all tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            // switch to new tabs
            driver.switchTo().window(tabs.get(1));
            //wait 3 seconds
            Thread.sleep(3000);

            // capture name of the hotel
            try {
                String hotelName = driver.findElements(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).get(0).getText();
                //print out hotel name
                System.out.println(hotelName);
            } catch (Exception e) {
                System.out.println("Unable to print out hotel name...." + e);
            }

            //click on reserve a room
//            try {
////                driver.findElement(By.xpath("//*[@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-primary']")).click();
//                driver.findElement(By.xpath("//*[text()='Reserve a room']")).click();
//            } catch (Exception e) {
//                System.out.println("Unable to click reserve now.." + e);
//            }
            // wait two seconds
            Thread.sleep(2000);
            //scroll down
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll (0,1200)");
            //capture price of hotel
            try {
                String prices = driver.findElements(By.xpath("//*[contains(text(),'price')]")).get(2).getText();
                // print out price of hotel
                System.out.println(prices);
            } catch (Exception e) {
                System.out.println("Unable to capture the price of the hotel.." + e);
            }

            //click on reserve now
            try {
                driver.findElements(By.xpath("//*[@data-stid= 'submit-hotel-reserve']")).get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click reserve now.." + e);
            }
            // wait a sec
            Thread.sleep(5000);

            //handle pop up window with pay now button
            try {
                WebElement reserveNowPopUp = driver.findElement(By.xpath("//*[@class='uitk-toolbar-title-content']"));
                if (reserveNowPopUp.isDisplayed()) {
                    //if the pop up is displayed then click on pay now
                    driver.findElement(By.xpath("//span[text() = 'Pay now']")).click();
                }
            } catch (Exception e) {
                System.out.println("Unable to find pop up window " + e);
            }

            //capture amenities
            try {
                String amenities = driver.findElement(By.xpath("//*[@class = 'c-hds-success-1']")).getText();
                //print out dates
                System.out.println(amenities);
            } catch (Exception e) {
                System.out.println("Unable to capture and print out amenities.." + e);
            }//end of capture amenities
            //close tab
            driver.close();
            //switch back to orignal tab
            driver.switchTo().window(tabs.get(0));
        }//end of for loop
        driver.quit();
    }//end of main
}//end od class

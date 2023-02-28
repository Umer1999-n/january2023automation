package Day9_01312023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_Hotels_InClassAI {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("NEW YORK");//index 0
        destinations.add("OHIO");//index 1
        destinations.add("CALIFORNIA");//index 2

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start maximized option
        options.addArguments("start-maximized");
        //define the webDriver and pass the chrome options into the driver method
        WebDriver driver = new ChromeDriver(options);

        //start of for loop
        for (String destination : destinations) {
            //go to hotels page
            driver.navigate().to("https://www.hotels.com");
            //wait 1 second
            Thread.sleep(1000);

            //start of destination try-catch block
            try {
                //click on going to search box
                driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).click();
                //type in destination
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(destination);
                //wait a few seconds
                Thread.sleep(1000);
                //select and click
                driver.findElements(By.xpath("//*[@class='truncate']")).get(0).click();
                //click on search button
                driver.findElement(By.xpath("//*[@id='search_button']")).submit();
            } catch (Exception err) {
                System.out.println("Unable to enter home value for reason: " + err);
            }//end of destination search try-catch block

            //start of multiple conditions
            if (destination == ("Washington")) {
                driver.findElements(By.xpath("//*[@class='uitk-card-link']")).get(1).click();
                Thread.sleep(1000);
            } else if (destination == ("Ohio")) {
                driver.findElements(By.xpath("//*[@class='uitk-card-link']")).get(3).click();
                Thread.sleep(1000);
            } else {
                driver.findElements(By.xpath("//*[@class='uitk-card-link']")).get(2).click();
                Thread.sleep(1000);
            }//end of multiple conditions

            //new tab opens after clicking on resort
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to the new tab
            driver.switchTo().window(tabs.get(1));
            //wait 2 secs
            Thread.sleep(1000);
            String hotelName = driver.findElement(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).getText();
            System.out.println(hotelName);
            //define javascript executor (allows us to scroll)
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Thread.sleep(3000);
            //scroll down to choose your room
            //we need to store the xpath into a webElement variable
            WebElement chooseYourRoom = driver.findElement(By.xpath("//*[text()='Choose your room']"));
            //window will scroll to choose your room
            jse.executeScript("arguments[0].scrollIntoView(true);", chooseYourRoom);
            Thread.sleep(2000);
            //Print the first price of the hotel
            String Price = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
            System.out.println("The price is " + Price);
            //click on reserve button
            driver.findElements(By.xpath("//*[text()='Reserve']")).get(0).click();
            Thread.sleep(2000);

            //start of pay at property try-catch block
            try {
                //scroll down to pay at property
                //we need to store the xpath into a webElement variable
                WebElement payAtProperty = driver.findElement(By.xpath("//*[text()='Pay at property']"));
                //window will scroll to pay at property
                jse.executeScript("arguments[0].scrollIntoView(true);", payAtProperty);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[text()='Pay at property']")).click();
                Thread.sleep(2000);
            } catch (Exception err) {
                System.out.println("Unable to pay at property as no link present: " + err);
            }//end of pay at property try-catch block

            //scroll down to Room Details
            //we need to store the xpath into a webElement variable
            WebElement roomDetails = driver.findElement(By.xpath("//*[text()='Step 2: Room details']"));
            //window will scroll to choose your room
            jse.executeScript("arguments[0].scrollIntoView(true);", roomDetails);
            Thread.sleep(2000);
            //print room details out
            String room = driver.findElement(By.xpath("//*[@class=' with-small-icon icon-thin-tick']")).getText();
            System.out.println(room);
            //close driver
            driver.close();
            //switch to first tab
            driver.switchTo().window(tabs.get(0));
        }//end of for loop


        Thread.sleep(1000);
        driver.quit();

    }//end of main
}//end of class

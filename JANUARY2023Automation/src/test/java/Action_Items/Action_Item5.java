package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Action_Item5 {
    public static void main(String[] args) throws InterruptedException {
        //define the webDriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome option
        ChromeOptions options = new ChromeOptions();
        //start in incognito option
        options.addArguments("incognito");
        //define the chrome driver to use for your test
        WebDriver driver = new ChromeDriver(options);
        //create array list for zipcodes
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("11230");//index 0
        zipCodes.add("43240");//index 1
        zipCodes.add("13790");//index2

        for (int i = 0; i < zipCodes.size(); i++) {
            //navigate to weightwatchers.com
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            // add the options full-screen(mac)
            options.addArguments("start-fullscreen");
            //wait 2 seconds
            Thread.sleep(2000);

            //click on search field
            try {
                driver.findElement(By.xpath("//*[@class='input input-3TfT5']")).click();
            }catch (Exception e){
                System.out.println("Unable to click on : " + e);
            }//end of click on search try-catch block

            //type in zipcodes
            try {
                driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys(zipCodes.get(i));
                //wait 2 seconds
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println("Unable to type in zipCodes : " + e);
            }//end of type in zipcodes try-catch block

            //click on search arrow
            try {
                driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).click();

            }catch (Exception e){
                System.out.println("Unable to click on search arrow : " + e);
            }//end of click search arrow try-catch block
            //wait 2 seconds
            Thread.sleep(2000);

            //click on specific studio link
            try {
                //create an arraylist for links suggestions
                ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")));

                if (i == 0) {
                    links.get(1).click();
                } else if (i == 1) {
                    links.get(2).click();
                }else if (i == 2){
                    links.get(0).click();
                }//wait 2 seconds
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println("Unable to click on link : " + e);
            }//end of clicking on specific studio link try-catch block
            //wait 2 seconds
            Thread.sleep(2000);

            //capture the entire address on link
            try {
                String hotelAddress = driver.findElements(By.xpath("//*[@class='address-2PZwW']")).get(0).getText();
                //print out address
                System.out.println(hotelAddress);
            }catch (Exception e){
                System.out.println("Unable to capture address : " + e);
            }// end of capturing address try-catch block
            // wait two seconds
            Thread.sleep(2000);

            //scroll down
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll (0,600)");

            //capture upcoming in person workshop schedule
            try {
                String schedules = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                System.out.println(schedules);
            }catch (Exception e){
                System.out.println("Unable to capture schedule : " + e);
            }//end of capturing schedule try-catch block

        }//end of for loop
        //quit the driver
        driver.quit();
    }//end of main
}//end of class

package Day7_012423;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_FindElements {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        //note that chrome options need to be defined before the webDriver
        ChromeOptions options = new ChromeOptions();
        //start maximized option
        options.addArguments("start-maximized");
        //define the webDriver and pass the chrome options into the driver method
        WebDriver driver = new ChromeDriver(options);
        //go to yahoo page
        driver.navigate().to("https://www.yahoo.com");
        //wait 1 second
        Thread.sleep(1000);
        //click on the entertainment button
        driver.findElements(By.xpath("//*[contains(text(), 'tainment')]")).get(2).click();
        //wait 3 seconds
        Thread.sleep(3000);
        //quit driver
        driver.quit();
    }//end of main
}//end of class

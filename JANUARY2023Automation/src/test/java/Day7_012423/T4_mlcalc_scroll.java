package Day7_012423;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_mlcalc_scroll {
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
        //go to Mlcalc page
        driver.navigate().to("https://www.mlcalc.com/");
        //wait a bit
        Thread.sleep(2000);
        //define javascript executor (allows us to scroll)
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll down 800 pixels
        jse.executeScript("scroll(0,800)");
        //wait 3 seconds
        Thread.sleep(3000);
        //scroll up 400 pixels
        jse.executeScript("scroll(0,-400)");
        //wait 3 seconds
        Thread.sleep(3000);
        //scroll to calculate button
        //we need to store the xpath into a webelement variable
        WebElement calculateButton = driver.findElement(By.xpath("//*[@value = 'Calculate']"));
        //windows will scroll to calculate button
        jse.executeScript("arguments[0].scrollIntoView(true);", calculateButton);
        //wait a bit
        Thread.sleep(5000);
        //quit driver
        driver.quit();
    }//end of main
}//end of class

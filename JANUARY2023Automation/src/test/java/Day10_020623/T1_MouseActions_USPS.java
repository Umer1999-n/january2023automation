package Day10_020623;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class T1_MouseActions_USPS {
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
        //navigate to usps.com
        driver.navigate().to("https://www.usps.com");
        //wait a bit
        Thread.sleep(2000);
        //hover over send tab
        //store the send tab element in a WebElement variable
        WebElement sendTab = driver.findElement(By.xpath("//*[@id = 'mail-ship-width']"));
        //declare mouse actions
        Actions mouseActions = new Actions(driver);
        //move to the desired element (send tab), .perform() is needed for mouse actions
        mouseActions.moveToElement(sendTab).perform();
        //wait 3 seconds
        Thread.sleep(3000);
        //click on calculate a price using mouse click
        WebElement calcPrice = driver.findElement(By.xpath("//*[@class = 'tool-calc']"));
        //move to the calculate a price element then click on it
        mouseActions.moveToElement(calcPrice).click().perform();


    }//emd of main
}//end of class

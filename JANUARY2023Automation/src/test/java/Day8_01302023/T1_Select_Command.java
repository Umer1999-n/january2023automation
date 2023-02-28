package Day8_01302023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Select_Command {
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
        //click on the show advanced options menu
        driver.findElement(By.xpath("//*[text() = 'Show advanced options']")).click();
        //wait a bit
        Thread.sleep(1000);
        //store the month dropdown into a webElement variable first
        WebElement startMonthElement = driver.findElement(By.xpath("//*[@id = 'fpdd']"));
        //define the select statement for the month dropdown
        Select startMonthDropdown = new Select(startMonthElement);
        //use select by index to select May(index 4 because indexes start with 0)
        startMonthDropdown.selectByIndex(4);
        //wait a bit
        Thread.sleep(2000);
        //use select command to select a year
        WebElement startYearElement = driver.findElement(By.xpath("//*[@name = 'sy']"));
        //wait a bit
        Thread.sleep(2000);
        //define the select statement for the year dropdown
        Select startYearDropdown = new Select(startYearElement);
        //select year 2025 by visible text
        startYearDropdown.selectByVisibleText("2025");
        //wait a bit
        Thread.sleep(2000);
        //alternative approach to select using xpath without the select statement
        driver.findElement(By.xpath("//*[@name = 'sy']")).click();
        driver.findElement(By.xpath("//*[text() = '2026']")).click();
        //wait a bit
        Thread.sleep(2000);
        //quit the driver
        driver.quit();

    }//end of main
}//end of class

package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Action_Item4 {
    public static void main(String[] args) throws InterruptedException {
        //declare an array list of sports
        ArrayList<String> sports = new ArrayList<>();
        sports.add("Football");//index 0
        sports.add("Soccer");//index 1
        sports.add("Basketball");//index 2
        sports.add("Cricket");//index 3
        sports.add("Boxing");//index 4
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start full-screen option(mac)
        options.addArguments("--kiosk");
        //start in incognito option
        options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        //start of for loop
        for (int i = 0; i < sports.size(); i++) {
            //go to yahoo page
            driver.navigate().to("https://www.yahoo.com");
            //wait 2 seconds
            Thread.sleep(2000);
            //locate element for search field and type values
            driver.findElement(By.xpath("//*[@name='p']")).sendKeys(sports.get(i));
            //wait 2 seconds
            Thread.sleep(2000);
            //submit on yahoo search button
            driver.findElement(By.xpath("//*[@id='ybar-sbq']")).submit();
            //wait 2 seconds
            Thread.sleep(2000);
            //capture the search result and print it
            String results = driver.findElement(By.xpath("//*[@class =' fz-14 lh-22']")).getText();
            //split the original text
            String[] arrayMessage = results.split(" ");
            //print out just the number from the search results
            System.out.println("Search result number for : " + sports.get(i) + " is " + arrayMessage[1]);
        }//end of for loop

        //define javascript executor (allows us to scroll)
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll down 3000 pixels
        jse.executeScript("scroll(0,3000)");
        //click on About This Page
        driver.findElement(By.xpath("//*[text() = 'About this page']")).click();
        //print text yahoo questions etc.
        String getHelp = driver.findElement(By.xpath("//*[@id='announcementdiv']")).getText();
        System.out.println("The message is : " + getHelp);

        //quit driver
        driver.quit();
    }//end of main
}//end of class

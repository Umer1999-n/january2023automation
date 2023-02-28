package Day6_012323;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_ChromeOptions {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        //note that chrome options need to be defined before the webDriver
        ChromeOptions options = new ChromeOptions();
        //start maximized option
        options.addArguments("start-maximized");
        //for mac use start fullscreen if fullscreen does not work then use --kiosk
        //options.addArguments("start-fullscreen");
        //if you're using mac and start-fullscreen does not work then use --kiosk
//        options.addArguments("--kiosk");
        //start in incognito option
//        options.addArguments("incognito");
        //headless option (you dont see the browser but it will run your tests on the browser in the background)
//        options.addArguments("headless");
        //define the webDriver and pass the chrome options into the driver method
        WebDriver driver = new ChromeDriver(options);
        //go to google page
        driver.navigate(). to("https://www.google.com" );
        //wait 2 seconds
        Thread.sleep(2000);
        //locate element for search field and type cars
        //this is example of relative xpath
        driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("cars");
        //this is an example of absolute xpath
//        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("cars");
        //submit on google search button
        driver. findElement(By.xpath("//*[@name='btnK']")).submit();
        //capture the search result and print it
        String searchResult = driver.findElement (By.xpath ( "//*[@id = 'result-stats']")). getText();
        System.out.println("Result search text is " + searchResult);
        //split the original text
        String[] searchResultArray = searchResult. split(" ");
        //print out just the number from the search results
        System.out.println("Result Search Number Is " + searchResultArray[1]);
        //quit driver
        driver.quit();

    }//end of main
}//end of class

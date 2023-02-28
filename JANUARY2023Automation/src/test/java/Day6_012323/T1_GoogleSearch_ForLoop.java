package Day6_012323;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T1_GoogleSearch_ForLoop {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> carBrands = new ArrayList<>();
        carBrands.add("BMW");//index 0
        carBrands.add("Benz");//index 1
        carBrands.add("Audi");//index 2
        carBrands.add("Toyota");//index 3
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //define the webdriver
        WebDriver driver = new ChromeDriver();
        //maximize the driver
        driver.manage().window().maximize();
        //start of the for loop
        //we don't want to keep relaunching a new browser
        //hence why we are excluding the above lines from the for loop
        for (int i = 0; i < carBrands.size(); i++){
            //go to google page
            driver.navigate(). to("https://www.google.com" );
            //wait 2 seconds
            Thread.sleep(2000);
            //locate element for search field and type cars
            //this is an example of relative xpath
            driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys(carBrands.get(i));
            //this is an example of absolute xpath
//            driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("cars");
            //submit on google search button
            driver. findElement (By.xpath ("//*[@name ='btnK']")).submit();
            //capture the search result and print it
            //there are other locators in selenium such as id, name, class, cssselectors and xpath
            //we chose to use xpath mainly to handle dynamic elements
            String searchResult = driver. findElement(By.xpath("//*[@id = 'result-stats']")).getText();
            System.out.println("Result search text is " + searchResult);
            //split the original text
            String[] searchResultArray = searchResult.split(" ");
            //print out just the number from the search results
            System.out.println("Search result number for car brand : " + carBrands.get(i) + " is " + searchResultArray[1]);
        }//end of for loop
        //quit driver
        driver.quit();
    }//end of main
}//end of class

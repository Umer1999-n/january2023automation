package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Action_Item3 {
    public static void main(String[] args) throws InterruptedException {
        //set up our chrome driver manager
        WebDriverManager.chromedriver().setup();

        //define your WebDriver for chrome driver
        WebDriver driver = new ChromeDriver();

        //navigate to bing home page
        driver.navigate().to("https://www.bing.com");

        //enter the keyword sports on your search field
        driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys("sports");

        //hit submit on bing search button
        driver.findElement(By.xpath("//*[@id='search_icon']")).submit();

        //wait 2 seconds
        Thread.sleep(2000);

        //capture the search results and only print out the search number
        String results = driver.findElement(By.xpath("//*[@id='b_tween']")).getText();
        String[] arrayMessage = results.split(" ");
        System.out.println("Search Number is " + arrayMessage[1]);


        //quit the driver
        driver.quit();

    }//end of main
}//end of class

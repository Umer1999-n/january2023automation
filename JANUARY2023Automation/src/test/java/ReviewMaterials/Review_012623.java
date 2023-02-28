package ReviewMaterials;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Review_012623 {
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
        //go to Anthem.com
        driver.navigate().to("https://www.anthem.com");
        //wait 1 second
        Thread.sleep(2000);
        //Req 1: I would like to validate the description for Individual & Family Plans
        String individualFamilyPlan = driver.findElement(By.xpath("//*[@class = 'richTextEditor secondary']")).getText();
        System.out.println("Family plan text is : " + individualFamilyPlan);

        String medicarePlanDesc = driver.findElements(By.xpath("//*[@class = 'richTextEditor secondary']")).get(1).getText();
        System.out.println("Medicare text is: " + medicarePlanDesc);

        //Req 2: I would like to validate all the descriptions of all the plans
        //Hint: For Loop, webElement, getText
        List<WebElement> planDescriptionElements = driver.findElements(By.xpath("//*[@class = 'richTextEditor secondary']"));
        for (int i = 0; i < planDescriptionElements.size(); i++) {
            System.out.println("Plan description for plan " + i + " is: " + planDescriptionElements.get(i).getText());
        }//end of for loop
        driver.quit();
    }//end of main
}//end of class

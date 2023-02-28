package Day13_02142023;

import Reusable_Library.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class T2_WebElementList extends TestBase {
    List<WebElement> menuHeaderCount;

    @Test
    public void tc001_verifyTotalCountOfMenuHeaders() {
        //navigate to usps
        driver.navigate().to("https://www.usps.com/");
        List<WebElement> menuHeaderCount = driver.findElements(By.xpath("//*[@class = 'nav-list']/li"));
        System.out.println("The total number of menu headers is " + menuHeaderCount.size());
    }//end of test 1
}//end of class

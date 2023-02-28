package Day13_02142023;

import Reusable_Library.ReusableActions;
import Reusable_Library.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T3_Yahoo_Boolean extends TestBase {
    @Test
    public void tc001_verifyStaySignInOptionIsChecked() {
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //click on the sign in button
        ReusableActions.clickMethod(driver, "//*[@class='_yb_8k0cv']",  "Sign In");
        //verify the stay signed in option is checked
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The Checkbox Is Checked" + isStaySignedInChecked);


    }  //end of test 1

    @Test
    public void tc002_verifyStaySignInOptionIsUnchecked(){
        //click on the checkbox to uncheck it
        ReusableActions.clickMethod(driver, "//*[@class = 'stay-signed-in checkbox-container']", "CheckBox");
        //check the state of the box it should be unchecked now
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        //print true or false if checkbox is checked
        System.out.println("The Checkbox Is Checked" + isStaySignedInChecked);
    }//end of test 2

}//end of class



package day10_actions;

import Utilitıes.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C04_KeyboardsActions extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        //aramakutusuna click yapıp sonra harf harf nutella yazısını yazdıralım sonrada enter tuşuna basalım

        Actions actions=new Actions(driver);
        actions.click(aramakutusu).perform();
       actions .keyDown(Keys.SHIFT)
        .sendKeys("n")
        .keyUp(Keys.SHIFT).sendKeys("u").sendKeys("t").sendKeys("e").sendKeys("l").sendKeys("l").sendKeys("a").sendKeys(Keys.ENTER).perform();
    }
}

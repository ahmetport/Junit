package day10_actions;

import Utilitıes.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class homework1 extends TestBase {
   // 1- Bir Class olusturalim C02_KeyboardActions2
    //2- https://html.com/tags/iframe/ sayfasina gidelim
   // 3- video’yu gorecek kadar asagi inin
   //4- videoyu izlemek icin Play tusuna basin
   //5- videoyu calistirdiginizi test edin
    @Test
    public void test01() throws InterruptedException {
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");


        // 3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);

        //4- videoyu izlemek icin Play tusuna basin
        WebElement iframeElementi=driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframeElementi);
        WebElement playTuşu=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        actions.click(playTuşu).perform();
        Thread.sleep(3000);





        //5- videoyu calistirdiginizi test edin
       // Assert.assertTrue(playTuşu.isDisplayed());



    }





}













/*


    WebElement iframe=driver.findElement(By.xpath("(//iframe[@width='560'])[1]"));
        driver.switchTo().frame(iframe);
                WebElement playTuşu=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
                actions.click(playTuşu).perform();
                Thread.sleep(3000);

 */
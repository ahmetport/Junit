package day10_actions;

import Utilitıes.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class homework extends TestBase {


    @Test
            public void test01() throws InterruptedException {
       // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin

        Actions actions=new Actions(driver);
        WebElement hoverYanaş=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverYanaş).perform();

       // 3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();
        //4- Popup mesajini yazdirin
       String mesaj= driver.switchTo().alert().getText();
        System.out.println(mesaj);
       // 5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        // 6- “Click and hold" kutusuna basili tutun
        Actions actions1=new Actions(driver);
        WebElement basılıTut=driver.findElement(By.xpath("//div[@id='click-box']"));
        actions1.clickAndHold(basılıTut).perform();
        /*

       // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement mesaj1=driver.findElement(By.xpath("//div[@id='click-box']"));
        Thread.sleep(2000);
        System.out.println(mesaj1.getText());
        // 8- “Double click me" butonunu cift tiklayin
        Actions actions2=new Actions(driver);
        WebElement çiftTıkla=driver.findElement(By.tagName("h2"));
        actions2.doubleClick(çiftTıkla).perform();

         */



    }
}

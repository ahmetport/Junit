package day10_actions;

import Utilitıes.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_keyBoardActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //facebookanasayfaya gidip yeni kayıt oluştur butonuna basalım
        //isim kutusunu locate edip geriye kalanları tab ile dolaşarak formu doldurun


        //facebookanasayfaya gidip yeni kayıt oluştur butonuna basalım
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //isim kutusunu locate edelim
        WebElement isimkutusu=driver.findElement(By.xpath("//input[@name='firstname']"));

        //geriye kalanları tab ile dolaşarak formu doldurun
        Actions actions=new Actions(driver);
       actions.click(isimkutusu)
                .sendKeys("Ahmet"+ Keys.TAB)
                .sendKeys("enes"+Keys.TAB)
                .sendKeys("3235353535"+Keys.TAB)
                .sendKeys("sfdsdf@dfdfg.com"+Keys.TAB+Keys.TAB)

                .sendKeys("13"+Keys.TAB)
                .sendKeys("May"+Keys.TAB)
                .sendKeys("1984"+Keys.TAB+Keys.TAB)
                .sendKeys(Keys.RIGHT).moveToElement(driver.findElement(By.xpath("(//button[@type='submit'])[2]")))
                .click()


                .perform();







        Thread.sleep(5000);
    }
}

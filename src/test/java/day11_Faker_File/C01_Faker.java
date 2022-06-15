package day11_Faker_File;

import Utilitıes.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_Faker extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //facebook görevini fake isimlelrle yapalım
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //isim kutusunu locate edelim
        WebElement isimkutusu=driver.findElement(By.xpath("//input[@name='firstname']"));

        //geriye kalanları tab ile dolaşarak formu doldurun
        Actions actions=new Actions(driver);
         Faker faker=new Faker();
         String fakeemail=faker.internet().emailAddress();//email iki kere yazacagımız için burda oluşturdum aşagıda kullandım
        actions.click(isimkutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeemail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeemail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("ENES")
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(5000);
        System.out.println("hele hele antepli");
    }

}

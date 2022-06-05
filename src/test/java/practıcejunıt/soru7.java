package practıcejunıt;

import Utilitıes.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class soru7 extends TestBase {

   // 1."http://webdriveruniversity.com/" adresine gidin
   //2."Login Portal" a kadar asagi inin
    //3."Login Portal" a tiklayin
    //4.Diger window'a gecin
    //5."username" ve "password" kutularina deger yazdirin
    //6."login" butonuna basin
    //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    //    8.Ok diyerek Popup'i kapatin
    //  9.Ilk sayfaya geri donun
    //10.Ilk sayfaya donuldugunu test edin


    @Test
    public void test01() throws InterruptedException {
        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String ilkSayfaUrl=driver.getCurrentUrl();
        /*

        //2."Login Portal" a kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        //3."Login Portal" a tiklayin
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();

        //4.Diger window'a gecin
        Set<String>tümOpsiyonlar=driver.getWindowHandles();
        System.out.println(ilkSayfaHandleDegeri);
        String ikinciPencereSayfaHandle="";
        for (String each:tümOpsiyonlar
             ) {
            if(!each.equals(ilkSayfaHandleDegeri)){
                ikinciPencereSayfaHandle=each;
            }
        }
        driver.switchTo().window(ikinciPencereSayfaHandle);
       System.out.println(ikinciPencereSayfaHandle);


        //5."username" ve "password" kutularina deger yazdirin
        //6."login" butonuna basin

        Faker faker=new Faker();
        WebElement userNameelement=driver.findElement(By.xpath("//input[@id='text']"));
        actions.click(userNameelement).sendKeys(faker.name().username()).sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
/*
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expected="validation failed";
        String actual=driver.switchTo().alert().getText();
        Assert.assertEquals(expected, actual);

        //    8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //  9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaHandleDegeri);
        //10.Ilk sayfaya donuldugunu test edin

        String ikinciSayfaUrl=driver.getCurrentUrl();
        Assert.assertEquals(ilkSayfaUrl,ikinciSayfaUrl);

 */







    }
}






































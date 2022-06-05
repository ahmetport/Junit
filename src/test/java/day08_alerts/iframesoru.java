package day08_alerts;

import Utilitıes.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iframesoru extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //2. “Our Products” butonuna basin
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//a[@href='products.html']")).click();

        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("(//p[@class='sub-heading'])[2]")).click();
        Thread.sleep(1000);
        //4. Popup mesajini yazdirin
        WebElement popupMesaj = driver.findElement(By.xpath("//div[@class='modal-content']"));
        System.out.println(popupMesaj.getText());


        //5. “close” butonuna basin
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]")).click();
        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("http://webdriveruniversity.com/index.html"));





    }
}
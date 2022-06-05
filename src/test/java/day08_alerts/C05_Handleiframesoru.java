package day08_alerts;

import Utilitıes.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C05_Handleiframesoru extends TestBase {

    // 1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    // 2. “Our Products” butonuna basin
    //3. “Cameras product”i tiklayin
    //4. Popup mesajini yazdirin
    //5. “close” butonuna basin
    //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
    //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
    @Test
    public void test01() throws InterruptedException {

        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        String ilksayfahandle=driver.getWindowHandle();
        System.out.println(ilksayfahandle);
        // 2. “Our Products” butonuna basin

        WebElement iframeelement = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframeelement);
        WebElement product = driver.findElement(By.linkText("Our Products"));
        product.click();


        //3. “Cameras product”i tiklayin
        WebElement cameraElement = driver.findElement(By.xpath("//*[text()='Cameras']"));
        cameraElement.click();
       //Thread.sleep(3000);

        //4. Popup mesajini yazdirin
        WebElement popupMesaj = driver.findElement(By.className("modal-content"));
        System.out.println(popupMesaj.getText());


        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]")).click();
        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("http://webdriveruniversity.com/index.html"));

    }
}












package day11_Faker_File;

import Utilitıes.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C05_Fıle_Upload extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //3. chooseFile butonuna basalim
        //BİRİNCİ ADIM
        WebElement dosyaSecButonu=driver.findElement(By.id("file-upload"));
        //4. Yuklemek istediginiz dosyayi secelim.
        //2 İNCİ ADIM DOSYA YOLUNU OLUŞTURALIM
        String farklıKısım=System.getProperty("user.home");
        String ortakkısım="\\Desktop\\text.txt";
        String yüklenecekDosya=farklıKısım+ortakkısım;
        //3.ADIM SENDKEYS İLE DOSYAYOLUNU SEÇME BUTONUNA YOLLAYALIM
        dosyaSecButonu.sendKeys(yüklenecekDosya);
        Thread.sleep(5000);

        /*
        bu işlemi selenıum ile yapamayız çünkü web tabanlı bir uygulama degil bu durumda imdadımıza sendkeys yetişiyor
  */
        //5. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //6. “File Uploaded!” textinin goruntulendigini test edelim
        WebElement yazıelementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yazıelementi.isDisplayed());
        Thread.sleep(5000);






    }

}

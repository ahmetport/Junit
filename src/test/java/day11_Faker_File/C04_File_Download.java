package day11_Faker_File;

import Utilitıes.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_File_Download extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //BURDA EXTENDS KULLANACAGIZ ÇÜNKÜ DRIVER BİR YERLERE GİDECEK

        //1. Tests packagenin altina bir class oluşturalim

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. dummy.txt dosyasını indirelim
        WebElement dummindir=driver.findElement(By.xpath("//a[text()='dummy.txt']"));
        dummindir.click();
        Thread.sleep(5000);
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        //Dosya downloads indirilecektir,bize download sın path lazım
        String farklıKısım=System.getProperty("user.home");//mutlaka yapıyoruz
        String ortakKısım="\\Downloads\\dummy.txt";//bu sabit degişmez
        String arananDosyaYolu=farklıKısım+ortakKısım;
        //geriye o dosya yolundaki dosyanın var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));
    }
}
package day11_Faker_File;

import Utilitıes.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class mp3İndir extends TestBase {

    @Test
    public void barışManço() throws InterruptedException {
     driver.get("https://www.mp3indirdur.mobi/1263-1-sanatci-albumleri-baris-manco-indir.html");
     Thread.sleep(3000);
     driver.findElement(By.xpath("(//div[@class='ortaSolAlbumListesi'])[6]")).click();
        Thread.sleep(3000);
     driver.findElement(By.linkText("Barış Manço - Ben Bilirim")).click();
        Thread.sleep(3000);
     WebElement frameElementi=driver.findElement(By.name("playerFrame"));
     driver.switchTo().frame(frameElementi);
        Thread.sleep(3000);
     //driver.findElement(By.xpath("//img[@src='images/indir-buton.png']")).click();
     driver.findElement(By.linkText("play")).click();
     driver.close();






    }
}

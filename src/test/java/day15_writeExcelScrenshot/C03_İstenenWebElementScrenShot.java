package day15_writeExcelScrenshot;

import Utilitıes.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class C03_İstenenWebElementScrenShot extends TestBase {

    @Test
    public void test01() throws IOException {
        //amazona gidip nutella aratalım ve sonuç sayısının oldugu web elementin fotosunu çekelim
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
       // WebElement sonuçYazıElementi=driver.findElement(By.xpath(""))
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        File sonucYaziElementSS= new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");
        File temp=sonucYaziElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,sonucYaziElementSS);
    }
    }


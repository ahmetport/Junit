package day06_radıobuttoncheckbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Radiobutton {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
       // driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //“Create an Account” button’una basin
       // WebElement account=driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']"));
       // account.click();
        //“radio buttons” elementlerini locate edin
/*
        WebElement kadın=driver.findElement(""));
        WebElement erkek=driver.findElement(By.xpath("//input[@value='2']"));
        Thread.sleep(3000);
        WebElement özel=driver.findElement(By.xpath("//input[@value='-1']"));
        //Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(5000);
        if(!erkek.isSelected()){
            erkek.click();
        }
        Thread.sleep(3000);
        kadın.click();
        Thread.sleep(4000);
        özel.click();

 */


    }
}

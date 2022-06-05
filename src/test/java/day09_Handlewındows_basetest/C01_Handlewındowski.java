package day09_Handlewındows_basetest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Handlewındowski {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
       // driver.close();
    }
    @Test
    public void test01(){
        //amazon ana sayfaya gidin nutella için arama yaptırın
        //ilk ürünün resmini tıklayarak farklı bir tab olarak açın
        //yeni tabda açılan ürünün başlıgını yazdırın
        driver.get("https://www.amazon.com");
       String ilksayfadegeri=driver.getWindowHandle();
        System.out.println(ilksayfadegeri);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);
       // CDwindow-417A320A6EAE9B403390D4BA41BF24B2 açilan sayfanın  unıgue hash kodudur
        // .selenıum sayfalar arası geçiş yaparken bu kodu kullanır
       // ???????????????????????????????????????????????????????????????????????
        //driver.switchTo().window("CDwindow-417A320A6EAE9B403390D4BA41BF24B2");
        //sayfalar arası drıverımızı gezdiriyorsak ve herhangi bir sayfadan bu sayfaya geçmek istiyorsak böyle yazdırırız
                 // ***************************

        //ilk ürünün resmini tıklayarak farklı bir tab olarak açın
       // WebElement ilkUrunResmiTıkla=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        // driver.switchTo().newWindow(WindowType.TAB);//YENİ TAB GEÇMEK İÇİN

        //ADIMLARI BAŞTAN ALDIK

        driver.switchTo().newWindow(WindowType.TAB);


        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);



        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();
        //BU KOMUTU KULLANDIGIMIZDA DRIVER OTOMATIK OLARAK OLUSTURULAN NEW TABA GEÇER YENİ TABDA GÖREVİ GERÇEKLEŞTIRMEK İÇİN
        //ADIMLARI BAŞTAN ALMAMIZ GEREKİR


        //yeni tabda açılan ürünün başlıgını yazdırın
        System.out.println(driver.findElement(By.xpath("//h1[@id='title']")).getText());
        System.out.println(driver.getCurrentUrl());


        //ilksayfaya geçip url yazdıralım
       // String ilksayfadegeri=driver.getWindowHandle();
        driver.switchTo().window(ilksayfadegeri);
        System.out.println(driver.getCurrentUrl());




















    }

}

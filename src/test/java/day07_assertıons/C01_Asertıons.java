package day07_assertıons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Asertıons {

    //amazon ana sayfaya gidin 3 farklı test methodu oluşturarak aşagıdaki görevleri yapın
    //Url ın amazon içerdigini test edin
    //tıtle ın facebook içermedigini test edin
    //sol üst köşedeki amazon logosunun göründügünü test edin
   static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://www.amazon.com");//URL BURDA OLURSA BUTUN TESTLER BAGIMSIZ ÇALIŞIR
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
       // driver.get("https://www.amazon.com");*******************
        //amazon ana sayfaya gidin
       // driver.get("https://www.amazon.com");//METHOD BURDA OLURSA SADECE TEST01 ÇALIŞIR
        String aranankelime="amazon";
        String actualurl= driver.getCurrentUrl();
        Assert.assertTrue(actualurl.contains(aranankelime));
        Thread.sleep(3000);
    }
    @Test
    public void test02() throws InterruptedException {
        //tıtleın FACEBOOK içermedigini test edin
        String istenmeyenkelime="facebook";
        String actualTİtle= driver.getTitle();
        Assert.assertFalse(actualTİtle.contains(istenmeyenkelime));
        Thread.sleep(3000);
    }
    @Test
    public void test03(){
        //amazonlogosunun göründügünü test edin
      WebElement amazongörünür= driver.findElement(By.id("nav-logo-sprites"));
      Assert.assertTrue(amazongörünür.isDisplayed());


    }
}

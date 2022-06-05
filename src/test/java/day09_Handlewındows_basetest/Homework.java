package day09_Handlewındows_basetest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework {
    //amazon sayfasına gidelim
    //sayfanın wındow handle degerini string bir degişkene atayın
    //sayfa tıtle nın amazon içerdigini test edin
    //yeni bir tab oluşturun ve bestbuy adresine gidin
    //sayfa tıtlenın Best Buy içerdigini test edin
    //yeni bir wındow oluşturup walmart.com adresine gidin
    //sayfa URL nin walmart içerdigini test edin
    //ilk açılan sayfaya dönün ve amazon asayfasına döndügünüzü test edin

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
       // driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        //amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        //sayfanın wındow handle degerini string bir degişkene atayın
        String amazonHandleDegeri=driver.getWindowHandle();
        //sayfa tıtle nın "Amazon" içerdigini test edin
        String actualamazontıtle=driver.getTitle();
        String expectedamazontıtle="Amazon";
        Assert.assertTrue(actualamazontıtle.contains(expectedamazontıtle));

        //yeni bir TAB oluşturun ve bestbuy adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);//BURDAN SONRA BÜTÜN İŞLEME TEKRAR EDİYORUZ YOKSA YENİ TABA GEÇMEZ
        driver.get("https://www.amazon.com");
        driver.get("https:///www.bestbuy.com");

        //sayfa tıtlenın Best Buy içerdigini test edin
        String bestTıtle=driver.getTitle();
        String expectedbesttıtle="Best Buy";
        Assert.assertTrue(bestTıtle.contains(expectedbesttıtle));
        Thread.sleep(3000);

        //yeni bir PENCERE oluşturup walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
       // driver.get("https://www.amazon.com");
       // driver.get("https:///www.bestbuy.com");
        driver.get("https://walmart.com");
        Thread.sleep(2000);

        //sayfa URL nin walmart içerdigini test edin
        String walmartUrl=driver.getCurrentUrl();
        String expectedUrl="walmart";
        Assert.assertTrue(walmartUrl.contains(expectedUrl));

        //ilk açılan sayfaya dönün ve amazon asayfasına döndügünüzü test edin
        driver.switchTo().window(amazonHandleDegeri);
        System.out.println(driver.getCurrentUrl());









    }
}

package day07_assertıons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuyAsertıons {
    // 1) Bir class oluşturun: BestBuyAssertions
    //   https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    //  Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //   titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //  logoTest => BestBuy logosunun görüntülendigini test edin
    //  FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");

    }

    @AfterClass
    public static void tearDown() {
        // driver.close();
    }

    @Test
    public void test01() {
        //  Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expected= "https://www.bestbuy.com/";
        String actual=driver.getCurrentUrl();
        Assert.assertEquals("EŞİTSE PSSAED",expected,actual);

    }

    @Test
    public void test02() {
        //   titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String title="Rest";
        String actualTıtle=driver.getTitle();
        Assert.assertFalse(actualTıtle.contains(title));


    }

    @Test
    public void test03() {
        //  logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoelementi=driver.findElement(By.xpath("//img[@class='logo']"));
       Assert.assertTrue( logoelementi.isDisplayed());



    }

    @Test
    public void test04() {
        //  FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement fransızcatest=driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(fransızcatest.isDisplayed());








    }
}
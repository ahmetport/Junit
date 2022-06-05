package practıcejunıt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class soru5 {


    /*
       ...Exercise5...
      @BeforeClass ın icerisinde driver i kuralim
      maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
      Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
      Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
      @AfterClass ta driver ı kapatalim
       */
   static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @AfterClass
    public static void tearDown() {
       driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.google.com");
        String başlık=driver.getTitle();
        String aranankelime="Google";
        Assert.assertTrue(başlık.contains(aranankelime));
        Thread.sleep(3000);

    }
    @Test
    public void test02(){
        driver.get("https://www.amazon.com");
        String arananmetin="www.amazon.com ";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertFalse(actualUrl.contains(arananmetin));
    }

}

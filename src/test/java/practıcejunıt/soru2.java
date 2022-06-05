package practıcejunıt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class soru2 {

     /*
   ...Exercise2...
   http://www.bestbuy.com 'a gidin,
   Sayfa basliginin "Best" icerdigini(contains) dogrulayin
   Ayrica Relative Locator kullanarak;
       logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
       mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
*/

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();


    }
    @Before
    public static void testenönce(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" http://www.bestbuy.com ");
    }
    @Test
    public void testensonra() {

        Assert.assertTrue("TITLE BEST KELİMESİ İÇERMİYOR", driver.getTitle().contains("Best"));

    }
    @After
    public void kapat(){
        driver.close();
    }
    @Test
    public  void logotest(){

    }









    }


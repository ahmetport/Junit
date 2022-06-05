package practıcejunıt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class soru1 {


    /*
            ...Exercise1...
    BeforeClass ile driver ı olusturun ve class icinde static yapin
    Maximize edin, 15 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatın

*/

   static WebDriver driver;


    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Before
    public  void testenönce() {
        driver.get(" http://www.google.com");
    }


    @Test
    public void test1() {
        WebElement aramakutusu = driver.findElement(By.name("q"));
        aramakutusu.sendKeys("green mile");
        aramakutusu.submit();
    }
    @Test
    public void test2() {
        // arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
        WebElement aramakutusu = driver.findElement(By.name("q"));
        aramakutusu.sendKeys("premonition" + Keys.ENTER);

    }
    @Test
    public void test3() {
        // arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
        WebElement aramakutusu = driver.findElement(By.name("q"));
        aramakutusu.sendKeys("The Curious Case of Benjamin Button"+ Keys.ENTER);


    }
        @After
        public void testtensonra(){
        WebElement sonuçyazısı=driver.findElement(By.id("result-stats"));
            System.out.println("sonuçyazısı elementi.gettext:" +sonuçyazısı.getText());


        }
         @AfterClass
    public static void tearDown(){
        driver.close();




    }
}
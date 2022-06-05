package day06_radıobuttoncheckbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Aserrtıons {
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
        driver.close();
    }
    @Test
    public void test1(){
        //eger test methodumuzda hiçbir test yoksa şu varmı dogrulayın gibi test yoksa test çalıştıktan sonra hiç bir problemle
        //karşılaştıgımızı raporlamak için "test pass" yazısı çıkar
        driver.get("https://www.amazon.com");

        //eger testleri ıf ile yaparsak test faıl olsa bile kodlar problemsiz çalıştıgı için ekranın sol alt kısmında
        // test pass yazacaktır
        String expected="https://www.facebook.com";
        String actualurl=driver.getCurrentUrl();
        Assert.assertEquals("if güle güle",expected,actualurl);//hatanın ne oldugunu bize otomatik döner junit bize raporlar

    }
}

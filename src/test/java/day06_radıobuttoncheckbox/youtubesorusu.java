package day06_radıobuttoncheckbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class youtubesorusu {
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
      //  driver.close();
    }
    @Test
    public void test1() {
        // 1) Bir class oluşturun: YoutubeAssertions
        //2) https://www.youtube.com adresine gidin
       driver.get("https://www.youtube.com");

        // 3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        // titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String beklenensonuç="YouTube";
        String gerçekleşensonuç=driver.getTitle();
       Assert.assertEquals("tıtle testi FAILED",gerçekleşensonuç.contains(beklenensonuç));

        // imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement image=driver.findElement(By.xpath("//div[@class='style-scope ytd-rich-grid-renderer'][3]"));
        Assert.assertTrue("Youtube resmı FAILED",image.isDisplayed());

        // imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        // wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    }
}

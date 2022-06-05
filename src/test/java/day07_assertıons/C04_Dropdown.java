package day07_assertıons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_Dropdown {
    //amazona gidip dropdown dan books seçenegini seçip java aratalım ve arama sonuçlarının java içerdigini test edelim
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
      //  driver.close();

    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        //dropdawn dan bir optıon seçmek için 3 adım vardır
        //ilk adım drapdown locate edecegiz
        WebElement dropdawn=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

         //ikinci adım bir select objesi oluşturup bir önceki adımda locate ettigimiz dropdown girelim
        Select select=new Select(dropdawn);
        //üçüncü adım dropdawn da var olan optıonlardan bir tanesini yapıyoruz

        //select.selectByValue("search-alias=stripbooks-intl-ship");VALUE İLE SEÇERSEM
        select.selectByVisibleText("Books");
        //select.selectByIndex(5);İNDEX İLE SEÇERSEM

        //4 adım java aratacagız

        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("java" + Keys.ENTER);
        Thread.sleep(5000);

        //5 adım arama sonuçlarının java içerdigini test edelim test edelim

        WebElement sonuçyazısıelementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonuçyazısı=sonuçyazısıelementi.getText();
        String aranankelime="java";
        Assert.assertTrue(sonuçyazısı.contains(aranankelime));
        Thread.sleep(5000);















    }

}

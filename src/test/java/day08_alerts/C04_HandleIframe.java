package day08_alerts;

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

public class C04_HandleIframe {

    //    ● Bir class olusturun: C02_IframeTest
    //    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //    ● Bir metod olusturun: iframeTest
    //		○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda 	yazdirin.
    //		○ Text Box’a “Merhaba Dunya!” yazin.
    //		○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //		dogrulayin ve  konsolda yazdirin.
    WebDriver driver;
@Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
    //driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/iframe");
     //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda 	yazdirin.
        WebElement sonuçyazısıElementi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(sonuçyazısıElementi.isEnabled());
        String sonuçyazısı=sonuçyazısıElementi.getText();
        System.out.println(sonuçyazısı);

        // Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe=driver.findElement(By.id("mce_0_ifr"));//ilk önce ıframe locate ettik
        driver.switchTo().frame(iframe);//frame geçişte webelementi tercih ettik
       WebElement textKutusu= driver.findElement(By.xpath("//body[@id='tinymce']"));//element ıframenin içinde oldugu için geçiş yapamıyor
        textKutusu.clear();
        textKutusu.sendKeys("MERHABA TELEVOLE");
        Thread.sleep(5000);

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //dogrulayin ve  konsolda yazdirin.şimdedde burda ıframeden çıkış yapacagız yoksa hata verir önce oradan çıkmamız lazım
        driver.switchTo().defaultContent();

        WebElement selenıumElementi=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(selenıumElementi.isDisplayed());
        System.out.println(selenıumElementi.getText());




























    }
}

package day07_assertıons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptıon {
    //amazona gidelim drapdown dan books seçelim
    //seçtigimiz optıonı yazdıralım
    //drapdowndakı opsiyonların sayısının 20 oldugunu test edelim
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
      // driver.close();

    }
    @Test
    public void test01() {
        //amazona gidelim drapdown dan books seçelim
        driver.get("https://www.amazon.com");
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
       Select select=new Select(ddm);
       select.selectByVisibleText("Books");

        //seçtigimiz optıonı yazdıralım
        //son seçilen optıon ulaşmak için getFıstSelectOptınon methodunu kullanırız bu bize web elementi döndürür
        System.out.println(select.getFirstSelectedOption().getText());

        //drapdowndakı opsiyonların sayısının 26 oldugunu test edelim

        List<WebElement>optıonslarınListesi=select.getOptions();
        int actualoptıonsayısı=optıonslarınListesi.size();
        int expected=28;
        Assert.assertEquals(actualoptıonsayısı,expected);
















    }
}

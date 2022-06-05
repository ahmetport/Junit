package day06_radıobuttoncheckbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Checkbox {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown() {
        //  driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //a. Verilen web sayfasına gidin.
        //https://the-internet.herokuapp.com/checkboxes
        //checkbox elementinin tıklanıp tıklanmadıgını kontrol ediniz
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //b. Checkbox1 ve checkbox2 elementlerini locate edin.

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));

        Thread.sleep(5000);
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        //c. Checkbox1 seçili değilse onay kutusunu tıklayın


        if (!checkbox1.isSelected()) {
            checkbox1.click();
            Thread.sleep(2000);
        }
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkbox2.isSelected()) {
            checkbox2.click();
            Thread.sleep(2000);


        }

        //checkbox elementinin tıklanıp tıklanmadıgını kontrol ediniz


    }

}
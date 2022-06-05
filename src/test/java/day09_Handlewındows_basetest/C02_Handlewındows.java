package day09_Handlewındows_basetest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Handlewındows {

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
        //driver.quit();
    }
    @Test
    public void test01(){

        //amazon ana sayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilksayfawındowhandledegeri=driver.getWindowHandle();
        //url in amazon içedigini test edelim
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        //yeni bir pencere açıp bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https:///www.bestbuy.com");
        String ikincisayfawındowhandledegeri=driver.getWindowHandle();
        /*


        //tıtle ın Best Buy içerdigini test edelim
        String istenenkelime="Best Buy";
        String actualtıtle=driver.getTitle();
        Assert.assertTrue(actualtıtle.contains(istenenkelime));
        //ilk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(ilksayfawındowhandledegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);

        //arama sonuçlarının java içerdigini test edelim
        WebElement aramasonuçyazısı=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actual=aramasonuçyazısı.getText();
        String istenenword="java";
        Assert.assertTrue(actual.contains(istenenword));

        //yeniden bestbuy açık oldugu sayfaya gidelim
        driver.switchTo().window(ikincisayfawındowhandledegeri);
        //logonun göründügünü test edelim
        WebElement logoelementi=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logoelementi.isDisplayed());

         */





    }
}

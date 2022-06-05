package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Basicauthetıcatıon {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        //driver.quit();
    }
    @Test
    public void test01() {
       driver.get("https://the-internet.herokuapp.com/basic_auth");
       // driver.get("https://the-internet.herokuapp.com/basic_auth");//karşı sitenin bize sundugu hizmet
        //admin:admin şifresini bizyazıp karşı bana bu hizmeti sunan şirket biza bana bu şekilde gel yani nasıl tarif edildiyse öyle gidiyoruz


    }
}

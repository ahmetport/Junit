package practıcejunıt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class soru6 {

       /*
      ...Exercise6...
   // 1. Amazon.com'a gidelim.
   // 2. DropDown üzerinde Books secelim.(All yazan yerde)
   //    kategorilerin hepsini konsola yazdiralim
   // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
   // 4. Sonuc sayisini ekrana yazdiralim.
   // 5. Sonucların Les Miserables i icerdigini assert edelim
   */
   static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() {
      //  driver.close();


        }
    @Test
    public void testo1(){
        // 1. Amazon.com'a gidelim.
        driver.get("https://www.amazon.com");
        // 2. DropDown üzerinde Books secelim.(All yazan yerde)
        //    kategorilerin hepsini konsola yazdiralim
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Books");
        List<WebElement>optıonslarLıstesı=select.getOptions();
        for (WebElement each:optıonslarLıstesı
             ) {
            System.out.println(each.getText());
        }
       // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Les Miserables" + Keys.ENTER);
      //// 4. Sonuc sayisini ekrana yazdiralim.
        WebElement aramaSayısı=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(aramaSayısı.getText());

       //// 5. Sonucların Les Miserables i icerdigini assert edelim
        String expected="Les Miserables";
        String actual=aramaSayısı.getText();
        Assert.assertTrue(expected.contains(actual));













    }
}

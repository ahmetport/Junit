package day07_assertıons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_Dropdown {
   // ● Bir class oluşturun: DropDown
   // https://the-internet.herokuapp.com/dropdown adresine gidin.//  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
   //  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
   // 4.Tüm dropdown değerleri(value) yazdırın
   // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

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
        driver.get("https://the-internet.herokuapp.com/dropdown");
       // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement drapdownmenü=driver.findElement(By.id("dropdown"));
        Select select=new Select(drapdownmenü);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());//Option 1
        //  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());//Option 2
        //  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());//Option 1

        // 4.Tüm dropdown optıons ı yazdırın
        List<WebElement>tümopsiyonlar=select.getOptions();
        for (WebElement each:tümopsiyonlar
             ) {
            System.out.println(each.getText());//Please select an option OPTION1 VE OPTION 2
        }

        // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int dropdownboyut=tümopsiyonlar.size();
        if(dropdownboyut==4){
            System.out.println("true");
        }else{
            System.out.println("false");//FALSE
        }
    }
}

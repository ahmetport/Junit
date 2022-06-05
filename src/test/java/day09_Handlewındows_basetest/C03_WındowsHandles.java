package day09_Handlewındows_basetest;

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
import java.util.Set;

public class C03_WındowsHandles {

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
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
       // ● Tests package’inda yeni bir class olusturun: WindowHandle2
     //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

      // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement textopen=driver.findElement(By.xpath("//h3"));
        String aranankelıme="Opening a new window";
        String actualtext=textopen.getText();
        Assert.assertEquals(actualtext,aranankelıme);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String sayfaBaşlık=driver.getTitle();
        String istenenBaşlık="The Internet";
        Assert.assertEquals(sayfaBaşlık,istenenBaşlık);
        Thread.sleep(5000);
        /*
        eger kontrolsuz acilan bir tab veya window varsa
        o zaman sayfalarin window handle degerlerini elde etmem gerekir.
        oncelikle 2.sayfa acilmadan once
        ilk sayfanin window handle degerini bir String'e atayalim
         */
        String ilksayfawındowhandledegeri=driver.getWindowHandle();
        System.out.println(ilksayfawındowhandledegeri);

       // Click Here butonuna basın.****burdan sonra ikinci sayfa açılıyor ama driver yeni sayfaya geçmiyor ve işlem yapamayız
         /*
          switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
          biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
          ve yeni sayfa ile ilgili hicbir islem yapamaz
          yeni sayfada driver'i calistirmak isterseniz
          once driver'i yeni sayfaya yollamalisiniz
            */
        driver.findElement(By.linkText("Click Here")).click();
        //yeni sayfaya geçebilmek için öncelikle ikincisayfanınhandledegerini bulmamız gerekir
        //bunun için drıver.getwındowshandles() methodunu kullanarak açık olan tum sayfaların wındowhandle degerini alıp
        //bir sete atıyoruz. ilkdegeri bildigimizden dolayı ilkdegere eşit olmayana ikincihandle degeri deriz
        Set<String> windowhandleseti=driver.getWindowHandles();
        System.out.println(windowhandleseti);

        String ikincisayfawındowhandledegeri="";
        for (String each:windowhandleseti
             ) {
            if(!each.equals(ilksayfawındowhandledegeri)){
                 ikincisayfawındowhandledegeri=each;
            }
        }
        //artık ikincisayfanınwındowhandle degerini biliyoruz rahatlıkla sayfalar arası geçiş yapabiliriz
        driver.switchTo().window(ikincisayfawındowhandledegeri);

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        WebElement yenipencerebaşlık=driver.findElement(By.xpath("//h3"));
        String yeniPenceretıtle=driver.getTitle();
        String arananbaşlık="New Window";
        Assert.assertEquals(yeniPenceretıtle,arananbaşlık);

       //Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement yenipencerebaşlık1=driver.findElement(By.xpath("//h3"));
      String istenenİkınciActual=yenipencerebaşlık1.getText();
      String istenenExpected="New Window";
      Assert.assertEquals(istenenExpected,istenenİkınciActual);
      Thread.sleep(3000);

      //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilksayfawındowhandledegeri);
        String ilkpencerebaşlık=driver.getTitle();
        String ilkpencereistenenbaşlık="The Internet";
        Assert.assertEquals(ilkpencerebaşlık,ilkpencereistenenbaşlık);

    }
}
             //**********************************//
        //switchto.WİNDOW demeden lınk tıklayarak yenı tab veya wındow oluştugunda biz drıvere yeni sayfaya geç demedikçe drıver
        //eski sayfada kalır ve yeni sayfa ile ilgili hiç bir işlem yapamaz yeni sayfada driverı çalıştırmak
        // istersek drıver yeni sayfaya yoolamalıyız
        //eger konrolsuz açılan bir tab veya wındow varsa o zamn sayfaların wındow handle degerlerini elde etmem gerekir
        //öncelikle ikinci sayfa açılmadan önce ilksayfanın wındow handle degerini bir stringe atayalım
                 //**********************************//



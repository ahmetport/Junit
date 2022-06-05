package day13_cookıes_webtables;

import Utilitıes.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class C02_WebTable extends TestBase {
          // ● Bir class oluşturun : C02_WebTables

          //● login( ) metodun oluşturun ve oturum açın.
          //  ● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
           // ○ Username : manager
           // ○ Password : Manager1!
           // ● table( ) metodu oluşturun
           // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
           // ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
           // ● printRows( ) metodu oluşturun //tr
           // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
           // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
           // ○ 4.satirdaki(row) elementleri konsolda yazdırın.

    @Test
    public void test01() {
        girişyap();
        // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBaşlıklarıListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("sutun sayısı:" + sutunBaşlıklarıListesi.size());

        // ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın
        //tüm body string olarak yazdırmak istersek body elementini locate edip gettext methodu ile yazdırabiliriz
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satırListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satır sayısı:" + satırListesi.size());

        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each : satırListesi
        ) {
            System.out.println(each.getText());
        }

        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> hücreListesi = driver.findElements(By.xpath("//tbody//td"));//tr[4]//td 4 satırdaki elementler
        for (WebElement each : hücreListesi
        ) {
            System.out.println(each.getText());
        }

        //ilk önce email başlıgının kaçıncı sutunda oldugunu bulalım
        List<WebElement> başlıklarListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));


        int sutunsayısı = 0;
        for (int i = 0; i < başlıklarListesi.size(); i++) {
            if (başlıklarListesi.get(i).getText().equals("Email")) {
                sutunsayısı = i;

            }
        }


        //email başlıgındaki tüm elementelri (sutun)konsolda yazdırın
        List<WebElement> EmailSutunLıstesi = driver.findElements(By.xpath("//body//td[" + (sutunsayısı+1) + "]"));//thead kullanırsak sadece email yazar
        for (WebElement each : EmailSutunLıstesi
        ) {
            System.out.println(each.getText());


        }

    }

















    //● login( ) metodun oluşturun ve oturum açın.
    public void girişyap(){
        driver.get("https://www.hotelmycamp.com");

        driver.findElement(By.linkText("Log in")).click();
        Actions actions=new Actions(driver);
        WebElement userName=driver.findElement(By.id("UserName"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("MANAGER1!").sendKeys(Keys.ENTER).perform();















    }

}

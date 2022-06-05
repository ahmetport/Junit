package day13_cookıes_webtables;

import Utilitıes.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class C06_Web_Tablesodev extends TestBase {
    @Test
    public void test01() {
       // ● Bir class oluşturun : C03_WebTables
        // ● login() metodun oluşturun ve oturum açın.
        // ● https://www.concorthotel.com//admin/HotelRoomAdminadresine gidin
        driver.get("https://www.concorthotel.com//admin/HotelRoomAdmin");
        Actions actions=new Actions(driver);
        WebElement username=driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(username).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


        // ○ Username : manager ○ Password : Manager2!
        // ● table() metodu oluşturun
        // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement>ilkSatırElemanları=driver.findElements(By.xpath("//tbody/tr[1]/td"));
        System.out.println(ilkSatırElemanları.size());


        // ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

       WebElement  tümBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tümBody.getText());

        WebElement tümHead=driver.findElement(By.xpath("//thead/tr[1]"));
        System.out.println(tümHead.getText());


        // ● printRows() metodu oluşturun //tr
        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement>satırSayısı=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(satırSayısı.size());



        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.

        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        WebElement row=driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println(row.getText());
        // ● printCells() metodu oluşturun //td
        // ○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement>toplamHücreSayısı=driver.findElements(By.xpath("//tbody//td"));
        System.out.println(toplamHücreSayısı.size());

        // ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        for (WebElement each:toplamHücreSayısı
             ) {
            System.out.println(each.getText());
        }
        // ● printColumns() metodu oluşturun
        // ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.

        // ○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        // ○ 5.column daki elementleri konsolda yazdırın.
        List<WebElement>beşinciElement=driver.findElements(By.xpath("//tbody//td[5]"));
        for (WebElement each:beşinciElement
             ) {
            System.out.println(each.getText());
        }


    }
}

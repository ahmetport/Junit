package day10_actions;

import Utilitıes.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class C01_Actıons extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //amazon ana sayfaya git
        //account menüsünden create a list linkine tıkla
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement accountlınkı=driver.findElement(By.id("nav-link-accountList"));
       // accountlınkı.click();fark burda mouse yanaşıyor click ile sadece o sayfanın içine girirsin menüyü göremeyiz
       actions.moveToElement(accountlınkı).perform();//bunu yapınca menü açılıyor
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
        Thread.sleep(5000);
    }


}

package day13_cookıes_webtables;

import Utilitıes.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class
C03_Webtable extends TestBase {
    @Test
    public void test01() {
        //önceki classdaki adrese gidip
        //girişyap methodunu kullanarak sayfaya giriş yapın
        //input olarak verilen satır sayısı ve sutun sayısınasahip
        //cell deki textı yazdırın
        int satır = 6;
        int sutun = 3;

        girişyap();
        WebElement arananCell = driver.findElement(By.xpath("//tbody//tr[" + satır + "]//td[" + sutun + "]"));
        System.out.println(arananCell.getText());


    }








    public void girişyap() {
        driver.get("https://www.hotelmycamp.com");

        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.id("UserName"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("MANAGER1!").sendKeys(Keys.ENTER).perform();

    }
}
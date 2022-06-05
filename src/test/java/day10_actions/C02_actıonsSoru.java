package day10_actions;

import Utilitıes.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class C02_actıonsSoru extends TestBase {
   // 1- Yeni bir class olusturalim: MouseActions1
   //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim //3- Cizili alan uzerinde sag click yapalim
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    //test edelim.
    // 5- Tamam diyerek alert’i kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void test01() {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");


        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement çizilialanElementi=driver.findElement(By.id("hot-spot"));//locate etmek için mousu herhengi biryerde saga tıklayıp
        //çizgilialanı öyle seçiyoruz çünkü js alert var
        actions.contextClick(çizilialanElementi).perform();//sagclickiçin contextclick kullanıyoruz

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim
        String expectedyazı="You selected a context menu";
        String actualyazı=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedyazı, actualyazı);

        // 5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilksayfawındowhandledegeri=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Set<String> HandleSeti=driver.getWindowHandles();
       String ikincisayfawındowhandledegeri="";
        System.out.println(HandleSeti);
        for (String each:HandleSeti
             ) {
            if(!each.equals(ilksayfawındowhandledegeri)){
                ikincisayfawındowhandledegeri=each;

            }
        }
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        driver.switchTo().window(ikincisayfawındowhandledegeri);
         WebElement yazıElementi=driver.findElement(By.tagName("h1"));
        String actualyazıikincisayafa=yazıElementi.getText();
        String expectedyazıikincisayaf="Elemental Selenium";
        Assert.assertEquals(actualyazıikincisayafa,expectedyazıikincisayaf);

        //ilksayfaya tekrar dönelim
        driver.switchTo().window(ilksayfawındowhandledegeri);





























        // 5- Tamam diyerek alert’i kapatalim


        //6- Elemental Selenium linkine tiklayalim

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    }



}

package day12_selenıumwaitler;

import Utilitıes.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


// 1. Bir class olusturun : WaitTest
     //2. Iki tane metod olusturun : implicitWait() , explicitWait()
     // Iki metod icin de asagidaki adimlari test edin.
    //  3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
   //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
   //6. Add buttonuna basin
   //7. It’s back mesajinin gorundugunu test edin
     public class C01_ExplicitlyWait extends TestBase {
         @Test
         public void implicitlyWaitTest() {
// 1. Bir class olusturun : Wait


             //  3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin
             driver.get("https://the-internet.herokuapp.com/dynamic_controls");

            // 4. Remove butonuna basin.
                     driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

            // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

             WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));
             Assert.assertTrue(sonucYazisi.isDisplayed());




         }
     }
package day10_actions;

import Utilitıes.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_actıonsSoru extends TestBase {
      // 1- https://demoqa.com/droppable adresine gidelim
      // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
      //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test01() {
        driver.get("https://demoqa.com/droppable");

        // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement dragMe=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragMe,dropHere).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droopped=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String actualdropped=droopped.getText();
        String expecteddropppde="Dropped!";
        Assert.assertEquals(actualdropped,expecteddropppde);
    }

}

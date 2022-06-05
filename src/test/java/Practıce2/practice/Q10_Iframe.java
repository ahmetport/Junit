package Practıce2.practice;

import Utilitıes.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q10_Iframe extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);

        WebElement ikinciEmojı=driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        ikinciEmojı.click();


        //driver.findElement()
        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement>emojıOgelerinListesı=driver.findElements(By.xpath("//div[@id='nature']//div//img"));
        for (WebElement each:emojıOgelerinListesı
             ) {
            each.click();
        }
        Thread.sleep(5000);

        // parent iframe e geri donun
        driver.switchTo().parentFrame();
        // formu doldurun,(Formu istediğiniz metinlerle doldurun)

        Actions actions=new Actions(driver);
        Faker faker = new Faker();
        WebElement personelText=driver.findElement(By.xpath("//input[@id='text']"));
        actions.click(personelText).perform();
        for (int i = 0; i <11 ; i++) {
            actions.sendKeys(faker.name().username()).sendKeys(Keys.TAB).perform();


/*
        List<WebElement> personelText=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String>text=new ArrayList<>(Arrays.asList("ilk","son","idi","enes","ümit","ozan","bayram","ret","adem","",""));
        for (int i = 0; i <personelText.size() ; i++) {
            personelText.get(i).sendKeys(text.get(i));

 */

        }






























        //  apply button a basin
    }
}

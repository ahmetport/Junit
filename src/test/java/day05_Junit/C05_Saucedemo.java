package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_Saucedemo {
    /*
    1. “https://www.saucedemo.com” Adresine gidin
    2. Username kutusuna “standard_user” yazdirin
    3. Password kutusuna “secret_sauce” yazdirin
    4. Login tusuna basin
    5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    6. Add to Cart butonuna basin
    7. Alisveris sepetine tiklayin
    8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    9. Sayfayi kapatin
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");



        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");


        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");


        //4. Login tusuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        Thread.sleep(3000);



        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
      List<WebElement>urunelementılist=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
      urunelementılist.get(0).click();
       // String ilkurunismi=ilkurunelementı.getText();
       // System.out.println(ilkurunismi);
       // ilkurunelementı.click();




        // 6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();




        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();



        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        System.out.println(driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).isDisplayed());




    }
}
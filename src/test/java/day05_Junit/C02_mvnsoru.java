package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_mvnsoru {
    public static void main(String[] args) {
       // . http://zero.webappsecurity.com sayfasina gidin
      //  2. Signin buttonuna tiklayin
      //  3. Login alanine  “username” yazdirin
      //  4. Password alanine “password” yazdirin
       // 5. Sign in buttonuna tiklayin
       // 6. Pay Bills sayfasina gidin
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
      //  8. tarih kismina “2020-09-10” yazdirin
       // 9. Pay buttonuna tiklayin
       // 10. “The payment was successfully submitted.” mesajinin ciktigini control edin

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // . http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com ");

        //  2. Signin buttonuna tiklayin
        WebElement signbuton=driver.findElement(By.xpath("//button[@id='signin_button']"));
        signbuton.click();
        //  3. Login alanine  “username” yazdirin
        WebElement username=driver.findElement(By.id("user_login"));
        username.sendKeys("username");
//  4. Password alanine “password” yazdirin
        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("password");
        // 5. Sign in buttonuna tiklayin
        WebElement signnbutton=driver.findElement(By.xpath("//input[@type='submit']"));
        signnbutton.click();
        driver.navigate().back();
        // 6. online bankıng sayfasından Pay Bills sayfasina gidin
        WebElement onlınebankıng=driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]"));
        onlınebankıng.click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("500");
        //  8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
        // 9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        // 10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement sonuçyazısı=driver.findElement(By.xpath("//div[@id='alert_content']"));
        if(sonuçyazısı.isDisplayed()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        driver.close();











    }
}

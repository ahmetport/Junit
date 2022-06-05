package Practıce2.practice;

import Utilitıes.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q09_Alert extends TestBase {

    //    go to url :http://demo.automationtesting.in/Alerts.html
    //    click  "Alert with OK" and click 'click the button to display an alert box:'
    //    accept Alert(I am an alert box!) and print alert on console
    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //    cancel Alert  (Press a Button !)
    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //    and then sendKeys 'TechProEducation' (Please enter your name)
    //    finally print on console this message "Hello TechproEducation How are you today"
@Test
    public void test01() throws InterruptedException {
    driver.get("http://demo.automationtesting.in/Alerts.html");
    //    click  "Alert with OK" and click 'click the button to display an alert box:'
       driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
       driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
    //    accept Alert(I am an alert box!) and print alert on console
       System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


    driver.findElement(By.xpath("//*[text()='Alert with OK & Cancel ']")).click();
    driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    System.out.println(driver.switchTo().alert().getText());
    driver.switchTo().alert().dismiss();
    driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
    driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
    Thread.sleep(2000);
    driver.switchTo().alert().sendKeys("TechProEducation");
    driver.switchTo().alert().accept();
    String expectedMsj = "Hello TechProEducation How are you today";
    String actualMsj = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
    Assert.assertEquals(expectedMsj, actualMsj);
    }

}

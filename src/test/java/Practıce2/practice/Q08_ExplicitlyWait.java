package Practıce2.practice;


import Utilitıes.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Q08_ExplicitlyWait extends TestBase {


/*
    //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
    //maximize the window
    //click on action dialog button
    //if need use explicitly wait
    //click on the ok button
    //accept the alert message
 */

    @Test
    public void test01(){
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");

        //click on action dialog button
        driver.findElement(By.xpath("//button[@id='action']")).click();

        //if need use explicitly wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));
        WebElement textmesaj=driver.findElement(By.xpath("//div[@class='modal-body']"));
        Assert.assertTrue(textmesaj.isDisplayed());

        //click on the ok button
        //accept the alert message
        driver.findElement(By.id("dialog-mycodemyway-action")).click();
        driver.switchTo().alert().accept();


    }

}



package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.methods.Methods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){

        //Login
        Methods methods = new Methods();
        methods.click(By.xpath("//div[@class='menu-top-button login']"));
        methods.waitBySeconds(3);
        methods.sendKeys(By.id("login-email"),"cembayirr@gmail.com");
        methods.waitBySeconds(5);
        methods.sendKeys(By.id("login-password"),"cem12345");
        methods.waitBySeconds(5);
        methods.click(By.id("js-popup-accept-button"));
        methods.click(By.xpath("//button[@class='ky-btn ky-btn-orange w-100 ky-login-btn']"));
        methods.waitBySeconds(5);

        //Login Control
        WebElement result = methods.findElement(By.xpath("//h1[@class='section']"));
        assert result.getText().equals("Hesabım");
        methods.waitBySeconds(3);
    }
}

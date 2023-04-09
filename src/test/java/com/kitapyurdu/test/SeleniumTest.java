package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.methods.Methods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SeleniumTest extends BaseTest {

    @Test
    public void productTest(){

        //Login olunması.
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

        //Oyuncak yazıp arama yaptırma.
        methods.sendKeys(By.id("search-input"),"Oyuncak");
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.id("product-440988"));
        methods.waitBySeconds(2);

        //Favorilere ekleme ve kontrolünü gerçekleştirme.
        methods.click(By.xpath("/html/body/div[5]/div/div/div[3]/div[4]/div[2]/div[4]/div[2]/div[3]/a[4]/i"));
        methods.waitBySeconds(2);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/h2")).getText().contains("Ürün başarılı bir şekilde favorilerinize eklendi!"));

        methods.click(By.xpath("/html/body/div[5]/div/div/div[3]/div[4]/div[2]/div[5]/div[2]/div[3]/a[4]/i"));
        methods.waitBySeconds(2);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/h2")).getText().contains("Ürün başarılı bir şekilde favorilerinize eklendi!"));

        methods.click(By.xpath("/html/body/div[5]/div/div/div[3]/div[4]/div[2]/div[6]/div[2]/div[3]/a[5]/i"));
        methods.waitBySeconds(2);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/h2")).getText().contains("Ürün başarılı bir şekilde favorilerinize eklendi!"));

        methods.click(By.xpath("/html/body/div[5]/div/div/div[3]/div[4]/div[2]/div[7]/div[2]/div[3]/a[4]/i"));
        methods.waitBySeconds(2);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/h2")).getText().contains("Ürün başarılı bir şekilde favorilerinize eklendi!"));

        //Ana sayfaya dönüş.
        methods.click(By.xpath("//div[@class='logo-icon']"));
        methods.waitBySeconds(2);

        //Puan Katoloğuna gidiş.
        methods.click(By.xpath("//div[@class='lvl1catalog']"));
        methods.waitBySeconds(3);

        //Türk Klasiklerini seçtirme.
        methods.click(By.xpath("/html/body/div[5]/div/div/div[2]/div/div[4]/a[2]/img"));
        methods.waitBySeconds(3);

        //Yüksek oylama seçimi yaptırma.
        methods.selectByText(By.xpath("/html/body/div[5]/div/div[3]/div/div/div[1]/div/div[1]/select"),"Yüksek Oylama");
        methods.waitBySeconds(3);

        //Tüm kitaplardan > Hobi'ye geçme
        methods.click(By.xpath("/html/body/div[1]/div[4]/div[1]/ul/li[1]/div[2]/ul/li[3]/span"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("/html/body/div[1]/div[4]/div[1]/ul/li[1]/div[2]/ul/li[3]/div/div[1]/div/ul[2]/li[14]/a"));

        //Sayfadan random ürün seçip sepete ekleme.

        //Ürün listesini alma.
        List<WebElement> productList = driver.findElements(By.xpath("//ul[@class='product-grid jcarousel-skin-opencart']//li"));

        //Ürün listesi boyutunu alma.
        int listSize = productList.size();

        //Rastgele sayı oluşturma.
        Random random = new Random();
        int randomNumber = random.nextInt(listSize);

        //Rastgele bir ürün seç.
        WebElement randomProduct = productList.get(randomNumber);
        methods.waitBySeconds(2);

        //Seçilen ürüne tıkla.
        randomProduct.click();
        methods.waitBySeconds(2);

        //Sepete ekleme.
        methods.click(By.xpath("//a[@id='button-cart']"));
        methods.waitBySeconds(3);

        //Listelerim > Favorilerim gitme.
        methods.click(By.xpath("/html/body/div[1]/div[2]/div/div[2]/ul/li[1]/div/ul/li/a"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("/html/body/div[1]/div[2]/div/div[2]/ul/li[1]/div/ul/li/div/ul/li[1]/a"));
        methods.waitBySeconds(4);

        //Favorilerimdeki 3.Kitabı Silme
        methods.click(By.xpath("/html/body/div[5]/div/div[2]/div[1]/div[4]/div[2]/div/div[3]/div[2]/div[3]/a[3]/i"));
        methods.waitBySeconds(3);

        //Sepete gitme.
        methods.click(By.xpath("/html/body/div[1]/div[3]/div/div[4]"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[2]/div[2]/div[2]/div/a"));
        methods.waitBySeconds(2);

        //Sepette ürün adedi artırımı.
        WebElement input = methods.findElement(By.xpath("//input[@name='quantity']"));
        input.clear();
        input.sendKeys("3");
        input.submit();
        methods.waitBySeconds(2);

        //Satın al'a tıklama.
        methods.click(By.xpath("//div[@class='right']"));
        methods.waitBySeconds(3);

        //Yeni adres ekleme.
        methods.click(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/div/a[2]"));

        //Kargo adresinin doldurulması.
        WebElement inputAd = methods.findElement(By.xpath("//input[@id='address-firstname-companyname']"));
        inputAd.sendKeys("Test");
        methods.waitBySeconds(2);

        WebElement inputSoyad = methods.findElement(By.xpath("//input[@id='address-lastname-title']"));
        inputSoyad.sendKeys("Otomasyon");
        methods.waitBySeconds(2);

        methods.selectByText(By.xpath("//select[@id='address-country-id']"),"Türkiye");
        methods.waitBySeconds(2);

        methods.selectByText(By.xpath("//select[@id='address-zone-id']"),"İstanbul");
        methods.waitBySeconds(2);

        methods.selectByText(By.xpath("//select[@id='address-county-id']"),"KARTAL");
        methods.waitBySeconds(2);

        WebElement inputMahalle = methods.findElement(By.xpath("//input[@id='district']"));
        inputMahalle.sendKeys("SOĞANLIK YENİ MAH");
        methods.waitBySeconds(3);

        WebElement inputAdres = methods.findElement(By.xpath("//textarea[@id='address-address-text']"));
        inputAdres.sendKeys("Soğanlık Yeni Mah, Pamukkale Sk. No:11 Kartal/İstanbul");
        methods.waitBySeconds(2);

        WebElement inputPostcod = methods.findElement(By.xpath("//input[@id='address-postcode']"));
        inputPostcod.sendKeys("34880");
        methods.waitBySeconds(2);

        WebElement inputTel = methods.findElement(By.xpath("//input[@id='address-mobile-telephone']"));
        inputTel.sendKeys("5554443322");
        methods.waitBySeconds(2);

        methods.click(By.xpath("//button[@id='button-checkout-continue']"));
        methods.waitBySeconds(3);

        methods.click(By.xpath("//button[@id='button-checkout-continue']"));
        methods.waitBySeconds(3);

        //Yanlış kart bilgilerinin girilmesi.
        WebElement inputKartAd = methods.findElement(By.xpath("//input[@id='credit-card-owner']"));
        inputKartAd.sendKeys("TEST OTOMASYON");
        methods.waitBySeconds(2);

        WebElement inputKartNo = methods.findElement(By.xpath("//input[@id='credit_card_number_1']"));
        inputKartNo.sendKeys("0000111122223333");
        methods.waitBySeconds(2);

        methods.selectByText(By.xpath("//select[@id='credit-card-expire-date-month']"),"05");
        methods.waitBySeconds(2);

        methods.selectByText(By.xpath("//select[@id='credit-card-expire-date-year']"),"2025");
        methods.waitBySeconds(2);

        WebElement inputGuvenlikcod = methods.findElement(By.xpath("//input[@id='credit-card-security-code']"));
        inputGuvenlikcod.sendKeys("123");
        methods.waitBySeconds(2);

        //Devam butonuna tıklanması
        methods.click(By.xpath("//button[@id='button-checkout-continue']"));
        methods.waitBySeconds(3);

        //Hata mesajı onay.
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error']")).getText().contains("Kart numarası geçersiz. Kontrol ediniz!"));
        methods.waitBySeconds(2);

        //Ana sayfaya dönüş.
        methods.click(By.xpath("//a[@class='checkout-logo']"));
        methods.waitBySeconds(2);

        //Logout olunması.
        methods.scrollWithAction(By.xpath("//*[@class='menu top login']//ul//li//a"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//*[@class='menu top login']//ul//li//div//ul//li[4]//a"));

    }
}

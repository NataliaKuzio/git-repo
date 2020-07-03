package com.mycompany;

import com.mycompany.pageobject.LoginPage;
import com.mycompany.pageobject.ProductPage;
import com.mycompany.pageobject.ShoppingCart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShoppingTestCase {

    @Test
    public void shoppingTestCase() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?id_product=4&controller=product");

        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);

        productPage.addProduct();
        boolean condition1 = driver.findElement(By.tagName("body")).getText().contains("There is 1 item in your cart");
        Assert.assertFalse(condition1, "Text 'There is 1 item in your cart.' is not found");

        productPage.buyProduct();
        boolean condition2 = driver.findElement(By.tagName("body")).getText().contains("SHOPPING-CART");
        Assert.assertTrue(condition2, "SHOPPING-CART is not open");

        ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
        shoppingCart.summaryProduct();
        boolean  condition3 = driver.findElement(By.tagName("body")).getText().contains("Your shopping cart contains");
        Assert.assertFalse(condition3, "Shopping cart is empty");

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login("gryniuktest@mailinator.com", "654321");
        boolean condition = driver.findElement(By.tagName("body")).getText().contains("Choose a delivery address:");
        Assert.assertTrue(condition, "No sing-in");

        shoppingCart.deliveryAddress();
        boolean condition4 = driver.findElement(By.tagName("body")).getText().contains("Choose a shipping option");
        Assert.assertTrue(condition4, "Not found shipping option");

        shoppingCart.shippingOption();
        boolean condition5 = driver.findElement(By.tagName("body")).getText().contains("Please choose your payment method");
        Assert.assertFalse(condition5, "Not found payment method");





        //driver.quit();




    }
}

//написати test case
//перейменувати елементи пошуку
// перенести driver.findElement в PageObject
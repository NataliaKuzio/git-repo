package com.mycompany;

import com.mycompany.pageobject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestCase
{
    @Test
    public void loginTestCase()  {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?controller=authentication");

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.login("gryniuktest@mailinator.com", "654321");

        boolean condition = driver.findElement(By.tagName("body")).getText().contains("MY ACCOUNT");

        Assert.assertFalse(condition, "No username displayed on page");

        driver.quit();
    }
}



